// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247.bridge;

import android.app.Activity;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.gps.locationfinder.GPSTracker;
import com.inc247.ChatSDK;
import com.inc247.ChatSDKUtil;
import com.inc247.ChatSDKWebView;
import com.inc247.Location_Alert;
import com.inc247.constants.ChatSDKConstants;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inc247.bridge:
//            ChatSDKJSToNativeBridge

public final class ChatSDKNativeToJSBridge
{

    public static String MessageForGoogleLocationService;
    public static String MessageForGps;
    private static final String TAG = com/inc247/bridge/ChatSDKNativeToJSBridge.getSimpleName();
    public static String address;
    private static String bridgeEventsCallback = "ApplicationStatus";
    private static String chatBackground = "Chat Background";
    private static String chatEndedString = "chatEnded";
    private static String chatForeground = "Chat Foreground";
    private static String chatMaximizedString = "Chat Window Maximized";
    private static String chatMinimizedString = "Chat Window Minimized";
    public static JSONObject data = null;
    public static String getLocationToBridge = "getValues";
    public static GPSTracker gps;
    public static String latitude;
    public static LocationManager locationManager;
    public static String longitude;

    public ChatSDKNativeToJSBridge()
    {
    }

    private static void CheckGPSandGoogleLocationIsOn()
    {
        locationManager = (LocationManager)ChatSDK.getSDKInstance().activity.getSystemService("location");
        if (!locationManager.isProviderEnabled("gps"))
        {
            Location_Alert.showGPSDisabledAlertToUser(MessageForGps);
            return;
        }
        if (!locationManager.isProviderEnabled("network"))
        {
            Location_Alert.ShowGoogleLocationAlert(MessageForGoogleLocationService);
            return;
        } else
        {
            sendCurrentLocationToJS();
            return;
        }
    }

    public static void executeJS(final String url)
    {
        if (url.startsWith("javascript:"))
        {
            try
            {
                (new Handler(Looper.getMainLooper())).post(new Runnable() {

                    private final String val$url;

                    public void run()
                    {
                        ChatSDKWebView.getInstance(ChatSDK.getSDKInstance().activity).loadUrl(url);
                    }

            
            {
                url = s;
                super();
            }
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (final String url)
            {
                url.printStackTrace();
            }
            executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(url).append("'}").toString()));
            return;
        } else
        {
            Log.e(TAG, "Error in javascript String");
            return;
        }
    }

    public static void get_current_longitude_latitude()
    {
        gps = new GPSTracker(ChatSDK.getSDKInstance().activity);
        longitude = String.valueOf(gps.longitude);
        latitude = String.valueOf(gps.latitude);
    }

    public static void sendChatBackgroundCallbackToJS()
    {
        try
        {
            executeJS(ChatSDKUtil.createExecJSString(bridgeEventsCallback, chatBackground));
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(exception).append("'}").toString()));
            return;
        }
    }

    public static void sendChatForegroundCallbackToJS()
    {
        try
        {
            executeJS(ChatSDKUtil.createExecJSString(bridgeEventsCallback, chatForeground));
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(exception).append("'}").toString()));
            return;
        }
    }

    public static void sendChatMaximizedCallbackToJS()
    {
        try
        {
            executeJS(ChatSDKUtil.createExecJSString(bridgeEventsCallback, chatMaximizedString));
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(exception).append("'}").toString()));
            return;
        }
    }

    public static void sendChatMinimizedCallbackToJS()
    {
        try
        {
            executeJS(ChatSDKUtil.createExecJSString(bridgeEventsCallback, chatMinimizedString));
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(exception).append("'}").toString()));
            return;
        }
    }

    public static void sendCurrentLocationToJS()
    {
        get_current_longitude_latitude();
        data = new JSONObject();
        try
        {
            data.put("longitude : ", longitude);
            data.put("latitude : ", latitude);
            ChatSDKJSToNativeBridge.getLocation(data);
            return;
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(jsonexception).append("'}").toString()));
            return;
        }
    }

    public static void sendEndedCallbackToJS()
    {
        executeJS(ChatSDKUtil.createExecJSString(bridgeEventsCallback, chatEndedString));
    }

    public static void sendLocation()
    {
        if (!ChatSDKConstants.isUserPermitGps)
        {
            data = null;
        }
        CheckGPSandGoogleLocationIsOn();
    }

    static 
    {
        MessageForGps = ChatSDKConstants.alertForEnableGps;
        MessageForGoogleLocationService = ChatSDKConstants.alertForEnabledGoogleLocationService;
    }
}
