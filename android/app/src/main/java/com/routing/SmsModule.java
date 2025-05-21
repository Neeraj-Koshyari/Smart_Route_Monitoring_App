package com.routing;

import android.telephony.SmsManager;
import android.util.Log;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class SmsModule extends ReactContextBaseJavaModule {
    private static final String TAG = "SmsModule";

    public SmsModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "SmsModule"; // JavaScript will refer to it by this name
    }

    @ReactMethod
    public void sendSMS(String phoneNumber, String message, Callback callback) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            callback.invoke(null, "SMS sent successfully!");
        } catch (Exception e) {
            Log.e(TAG, "Error sending SMS", e);
            callback.invoke(e.getMessage(), null);
        }
    }
}
