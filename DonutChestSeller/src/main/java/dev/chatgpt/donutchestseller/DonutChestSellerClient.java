package dev.chatgpt.donutchestseller;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

/**
 * A deliberately safe helper: it never moves or sells items automatically.
 * Press the key while a chest screen is open to show reminders about the
 * server's normal selling menu. Server-side selling protocols vary.
 */
public final class DonutChestSellerClient implements ClientModInitializer {
    private static KeyBinding helperKey;

    @Override
    public void onInitializeClient() {
        helperKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.donut_chest_seller.open_helper",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_K,
                KeyBinding.Category.MISC
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (helperKey.wasPressed()) {
                showHelper(client);
            }
        });
    }

    private static void showHelper(MinecraftClient client) {
        if (client.player == null) return;

        if (!(client.currentScreen instanceof HandledScreen<?>)) {
            client.player.sendMessage(Text.literal(
                    "[Donut Chest Seller] Open a chest or inventory first, then press K."
            ), false);
            return;
        }

        client.player.sendMessage(Text.literal(
                "[Donut Chest Seller] Helper only: this screen cannot safely sell chest contents by itself."
        ), false);
        client.player.sendMessage(Text.literal(
                "Use DonutSMP's official /sell menu and move items manually. Do not use this helper to bypass server rules."
        ), false);
    }
}
