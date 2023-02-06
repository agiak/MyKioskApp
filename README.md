# Demo Kiosk application
This application represents a demo application that is going to run on a Kiosk device. The application implements functionalities to lock the app so the user can not close or send the app to the background. Furthermore, the application contains functionality to enable Immersive mode.

# Kiosk mode
In specs, the application enables the Android Lock task mode. While the applications run in this mode, these things happen:
1. 'Home' and "Recent apps" buttons are disabled.
2. Status bar is not visible and accessible.
3. Notifications are not visible
4. The user cannot kill the application or exit it. 
5. Any external application, like Google Maps or a browser, is not accessible via the application.

In addition, while the Lock task is enabled, Android provides a way to disable it by tapping the 'Back' and 'Recent apps' buttons at the same time.

# Immersive mode
Because the Lock task mode hides the status bar, what we actually need to do to give the user a more immersive experience is hide the navigation bar.

# Install and Run the Project
Run the project to install the apk to your device. Enable Kiosk and Immersive mode and check basic capabilities such as showing a dialog, opening another activity, or a link to a browser.
