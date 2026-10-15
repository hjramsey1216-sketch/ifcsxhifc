@echo off
setlocal
where java >nul 2>nul
if errorlevel 1 (
  echo Java is not installed. Install Java 21 first.
  pause
  exit /b 1
)
where gradle >nul 2>nul
if errorlevel 1 (
  echo Gradle is not installed or is not on PATH.
  echo Easiest option: upload this folder to a GitHub repository and run the Build Fabric mod workflow.
  pause
  exit /b 1
)
gradle build --no-daemon
if errorlevel 1 (
  echo Build failed. Read the error above.
  pause
  exit /b 1
)
echo.
echo Finished. The mod jar is in build\libs\
explorer build\libs\
pause
