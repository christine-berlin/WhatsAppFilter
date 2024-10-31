# WhatsAppFilter
WhatsApp Notification Filter
An Android application that filters incoming WhatsApp notifications based on user-defined keywords, allowing users to track messages from specific contacts or topics directly on their screen.

Features
Keyword-Based Notification Filtering: Only receive notifications containing selected keywords.
Real-Time Updates: View incoming messages from specified contacts instantly on the main screen.
Customizable Keywords: Easily update the keywords to refine notifications.
Screenshots
(Include relevant screenshots here)

Getting Started
Prerequisites
Android Studio
Android device/emulator with Android 5.0 (API Level 21) or higher
Installation
Clone the repository:
git clone https://github.com/your-username/whatsapp-notification-filter.git
Open the project in Android Studio.
Build and run the project on an Android device.
Usage
Launch the app and enter keywords for filtering WhatsApp notifications.
View filtered notifications directly on the main screen.
Code Overview
MainActivity.java
Handles the main activity, displaying notifications containing the specified keywords.

NotificationListener.java
Monitors notifications from WhatsApp, filtering them based on the keywords set by the user.

IntroActivity.java
Provides a simple UI for entering keywords, which are then used to filter notifications.



Filter for Whatsapp messages. Enter "Tim. Bob, Ellie" and hit the "show messages" button to see only Whatsapp messages from Tim, Bob and Ellie. 
Useful for Whatsapp groups. 
