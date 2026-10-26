# FitTrack – Android Fitness Application

## Project Overview
FitTrack is an Android fitness companion application developed using Java and XML in Android Studio. It demonstrates common application screens, user input validation, Activity navigation, and alternative Android resources.

## Implemented Features
- Splash Screen with automatic navigation
- Login and Registration screens with input validation
- Forgot Password and Reset Password screens
- Dashboard with fitness modules displayed using GridLayout
- Interactive Workout Tracker with exercise selection and progress bar
- User Profile with editing and Logout options
- Light and Dark Mode support
- Landscape-specific string resources

## Technologies Used
- Java
- XML
- Android Studio
- SharedPreferences
- Android Intents

## Android Concepts
- **LinearLayout:** Registration, Profile, and Workout screens
- **ConstraintLayout:** Login screen
- **RelativeLayout:** Splash screen
- **GridLayout:** Dashboard
- **Default Resources:** `values/`
- **Alternative Resources:** `values-night/` and `values-land/`
- **Input Validation:** Email format, required fields, and password confirmation
- **Navigation:** Explicit Intents between Activities

## Navigation Flow
Splash → Login → Dashboard → Workout Tracker / Profile

Login → Register → Login

Login → Forgot Password → Reset Password → Login

Profile → Logout → Login

## Note
Authentication and password recovery are simulated locally for academic demonstration purposes. No backend is required.

## How to Run
1. Open the project in Android Studio.
2. Allow Gradle synchronization to complete.
3. Connect an Android device or start an emulator.
4. Build and run the application.