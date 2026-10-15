# Donut Chest Seller — Fabric 1.21.4

This is a small **client-side helper mod** for Minecraft Java Edition 1.21.4 using Fabric.

## What it does
- Adds a keybind (default: **K**).
- Press K to show a reminder message while a chest/container or inventory screen is open.
- It does **not** move items, inspect live DonutSMP orders, or sell anything automatically. The server's selling menus and rules remain in control.

## Install the built mod
1. Build the project (instructions below).
2. Find `donut-chest-seller-0.1.0.jar` in `build/libs/`.
3. Install Fabric Loader for **Minecraft Java 1.21.4** and install Fabric API for 1.21.4.
4. Put the mod jar in your Minecraft `.minecraft/mods` folder.
5. Launch the Fabric 1.21.4 profile.

## Build on Windows
- Install **JDK 21** and **Gradle 8.10+**.
- Extract this folder, open it in a terminal, and run `gradle build` (or double-click `build-windows.bat`).
- The jar will be in `build/libs/`.

## Build without installing Gradle locally
The included GitHub Actions workflow builds the jar for you:
1. Create a GitHub repository and upload the **contents** of this folder (including `.github/workflows/build.yml`).
2. Open the repository's **Actions** tab and choose **Build Fabric mod**.
3. Click **Run workflow** if prompted.
4. When the run finishes, open it and download the `DonutChestSeller-Minecraft-1.21.4` artifact. Extract it to get the jar.

## Important
This starter is intentionally a simple helper, not an automatic seller. DonutSMP server interfaces can change, and automated trading or GUI actions may violate server rules. The code does not attempt to bypass server-side controls.
