# PageTurner

PageTurner is an Android reading companion app designed to help readers discover books and keep their reading interests organised. The project is currently a work in progress, with development focused on building the Android application UI and navigation using Kotlin and Jetpack Compose.

> **Status:** Work in progress. Features and implementation are still evolving. The current repository contains the Android client and sample book data; backend services, persistent user data, and production integrations are not yet represented as completed functionality.

## Current Work

The app currently includes UI screens and components for:

- **Authentication flow:** splash, sign-up, login, forgot-password, reset-password, and link screens.
- **Home and discovery:** home, discover, and book details screens.
- **Library and profile:** dedicated library and profile screens.
- **Reusable UI:** shared top and bottom bars, cards, input components, and app branding.
- **Book data:** local sample book data and genre definitions used while the app is being developed.

Some screens and flows are still under development. The presence of a screen in the project does not necessarily mean that its full authentication, data, or backend behaviour is implemented.

## Tech Stack

- **Language:** Kotlin
- **UI:** Jetpack Compose
- **Design system:** Material 3
- **Navigation:** Navigation Compose
- **Image loading:** Coil 3
- **Build system:** Gradle with Kotlin DSL and a version catalog
- **IDE:** Android Studio

## Project Structure

The Android application source is organised under `app/src/main/java/com/example/pageturner/`:

```text
pageturner/
├── data/
│   ├── Book.kt
│   ├── Genre.kt
│   ├── GenreList.kt
│   └── SampleBooks.kt
├── ui/
│   ├── components/
│   │   ├── common/
│   │   └── ...
│   ├── navigation/
│   │   ├── AppNavigation.kt
│   │   └── MainNavigation.kt
│   ├── screens/
│   │   ├── auth/
│   │   └── home/
│   └── theme/
└── MainActivity.kt
```

## Getting Started

### Prerequisites

- Android Studio
- A compatible JDK configured through Android Studio
- Android SDK for the project's configured compile SDK
- An Android emulator or physical Android device

### Run locally

1. Clone the repository:

   ```bash
   git clone https://github.com/lindaopolo7896/pageTurn.git
   cd pageTurn
   ```

2. Open the project in Android Studio.
3. Allow Gradle to sync and download the required dependencies.
4. Select an emulator or connect an Android device with USB debugging enabled.
5. Run the `app` configuration.

You can also build the debug APK from the project root:

```bash
./gradlew assembleDebug
```

The generated APK is placed in `app/build/outputs/apk/debug/`.

## Development Direction

The project is being developed incrementally. Planned areas of continued work include strengthening the app architecture, connecting real book data, implementing persistent application data, and completing the user-facing reading and library flows.

These are development goals, not claims that the functionality is already complete.

## Contributing

PageTurner is currently an individual work-in-progress project. Suggestions and feedback are welcome.

## License

No license has currently been specified for this repository. All rights are reserved unless a license is added.
