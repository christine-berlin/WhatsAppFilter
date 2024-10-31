# WhatsApp Notification Filter

An Android application designed to filter incoming WhatsApp notifications based on user-defined keywords, allowing users to focus on messages from specific contacts or topics directly on their screen.

## Features

- **Keyword-Based Notification Filtering**: Only receive notifications containing selected keywords.
- **Real-Time Updates**: View incoming messages from specified contacts instantly on the main screen.
- **Customizable Keywords**: Easily update the keywords to refine notifications.

## Screenshots
...will follow

## Getting Started

### Prerequisites
- **Android Studio**: Download and install [Android Studio](https://developer.android.com/studio).
- **Android Device/Emulator**: Device running Android 5.0 (API Level 21) or higher.

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/whatsapp-notification-filter.git
2. Open the project in Android Studio.
3. Build and run the project on an Android device or emulator.

### Usage
1. Launch the app and enter keywords for filtering WhatsApp notifications.
2. View filtered notifications directly on the main screen.

## Code Overview
### MainActivity.java
Handles the main activity, displaying notifications that contain specified keywords. Manages the UI and displays filtered notifications in real-time.

### NotificationListener.java
Monitors incoming notifications from WhatsApp and filters them based on user-defined keywords. Uses NotificationListenerService to process notification data.

### IntroActivity.java
Provides a UI for entering keywords, which are then used to filter notifications in real-time.

