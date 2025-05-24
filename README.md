# 🚨 Road Safety App – React Native with Google Maps

A smart road safety application built using **React Native** and **Google Maps** that tracks your journey through checkpoints and sends SOS alerts if you miss a checkpoint in time. The app supports two modes:

- **Automatic Mode**: Auto-calculates the optimal path to your destination and generates timed checkpoints.
- **Manual Mode**: Lets you tap on the map to place custom checkpoints along the chosen route.

---

## 🗺️ Key Features

- **Google Maps Integration**  
- **Automatic Mode**  
  - Enter destination → optimal route generated → automatic checkpoints with ETA  
  - SOS popup if you fail to reach a checkpoint in time  
- **Manual Mode**  
  - Enter destination → route displayed → tap to add custom checkpoints  
  - SOS alert for missed checkpoint timing  
- **Real-Time Location Tracking**  
- **Smooth Zoom & Centering**  
- **Google Places Autocomplete** for destination search  
- **Automatic SMS** in emergencies (Android only)  
- **AsyncStorage** for user settings (e.g., saved phone number)

---

## 🛠️ Installation & Setup

### 1. Initialize Project

```
npx react-native init MyMapApp
cd MyMapApp
```

### 2. Install Dependencies

```
# Core mapping & location
npm install react-native-maps
npm install react-native-maps-directions
npm install react-native-google-places-autocomplete
npm install react-native-get-location
npm install react-native-get-random-values
npm install uuid

# UI dropdowns
npm install react-native-element-dropdown
npm install react-native-dropdown-picker

# Navigation
npm install @react-navigation/native
npm install @react-navigation/native-stack
npm install react-native-screens
npm install react-native-safe-area-context
npm install react-native-gesture-handler
npm install react-native-reanimated

# Async Storage
npm install @react-native-async-storage/async-storage
```

### 3. Platform-Specific Configuration

#### Android

1. **Permissions & API Key**  
   Edit `android/app/src/main/AndroidManifest.xml`:

   ```
   <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
   <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
   <uses-permission android:name="android.permission.SEND_SMS" />

   <application>
     <!-- Google Maps API Key -->
     <meta-data
       android:name="com.google.android.geo.API_KEY"
       android:value="YOUR_GOOGLE_MAPS_API_KEY" />
   </application>
   ```

2. **Native Module for Automatic SMS**  
   - **SmsModule.java**: implements SMS via `SmsManager`  
   - **SmsPackage.java**: registers the module  
   - Register your package in `MainApplication.kt`  

#### iOS

```bash
cd ios
pod install
cd ..
```

Add to `Info.plist`:

```
<key>NSLocationWhenInUseUsageDescription</key>
<string>Your app requires access to your location.</string>
<key>NSLocationAlwaysAndWhenInUseUsageDescription</key>
<string>Your app requires access to your location.</string>
```

---

## 🔧 Common Issues & Fixes

1. **`crypto.getRandomValues()` Error**  
   ```js
   // At top of your entry file (e.g., App.js)
   import 'react-native-get-random-values';
   ```

2. **CMake Build Error**  
   ```bash
   cd android
   ./gradlew clean
   rm -rf app/.cxx app/build
   ./gradlew assembleDebug
   ```

3. **Infinite SOS Loop**  
   - Stop simulation when SOS popup appears to prevent repeated checks.

4. **Checkpoint Persistence**  
   - Use a state flag to initialize checkpoints only once per route.

5. **App Data Reset on Background**  
   - Persist necessary state in AsyncStorage; rehydrate on app launch.

---

## 📂 Project Structure

```
MyMapApp/
├── android/
├── ios/
├── src/
│   ├── screens/
│   │   ├── Home/
│   │   ├── Automatic/
│   │   └── Manual/
│   ├── components/
│   └── utils/
├── App.js
└── README.md
```

---

## 🔗 Useful Resources

- **Android Studio Setup**: https://youtu.be/8l691BQ-RGc?si=TRlFOUT-kgUX80dc  
- **Google Maps Tutorial Playlist**: https://www.youtube.com/playlist?list=PLeIJUF3PiXDfOoCWgD4uibjkGQMT7a78v  
- **React Native Maps**: https://github.com/react-native-maps/react-native-maps  
- **React Native Maps Directions**: https://github.com/bramus/react-native-maps-directions  
- **Google Places Autocomplete**: https://www.npmjs.com/package/react-native-google-places-autocomplete  

---

*Developed by Navraj Devali and Neeraj Koshyari*
