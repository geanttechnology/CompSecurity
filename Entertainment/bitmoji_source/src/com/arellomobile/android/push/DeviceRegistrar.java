// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.arellomobile.android.push.request.RegisterDeviceRequest;
import com.arellomobile.android.push.request.RequestManager;
import com.arellomobile.android.push.request.UnregisterDeviceRequest;
import com.arellomobile.android.push.utils.PreferenceUtils;
import com.google.android.gcm.GCMRegistrar;
import java.util.Date;

// Referenced classes of package com.arellomobile.android.push:
//            PushEventsTransmitter

public class DeviceRegistrar
{

    private static final String TAG = "DeviceRegistrar";

    public DeviceRegistrar()
    {
    }

    static void registerWithServer(Context context, String s)
    {
        Log.w("DeviceRegistrar", "Registering for pushes");
        RegisterDeviceRequest registerdevicerequest = new RegisterDeviceRequest(s);
        try
        {
            RequestManager.sendRequest(context, registerdevicerequest);
            GCMRegistrar.setRegisteredOnServer(context, true);
            PushEventsTransmitter.onRegistered(context, s);
            PreferenceUtils.setLastRegistration(context, (new Date()).getTime());
            Log.w("DeviceRegistrar", (new StringBuilder()).append("Registered for pushes: ").append(s).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        if (s.getMessage() != null)
        {
            PushEventsTransmitter.onRegisterError(context, s.getMessage());
            Log.e("DeviceRegistrar", (new StringBuilder()).append("Registration error ").append(s.getMessage()).toString(), s);
            return;
        } else
        {
            s = registerdevicerequest.getRawResponse();
            Log.e("DeviceRegistrar", (new StringBuilder()).append("Registration error ").append(s).toString());
            PushEventsTransmitter.onRegisterError(context, s);
            return;
        }
    }

    static void unregisterWithServer(Context context, String s)
    {
        Log.w("DeviceRegistrar", "Try To Unregistered for pushes");
        GCMRegistrar.setRegisteredOnServer(context, false);
        UnregisterDeviceRequest unregisterdevicerequest = new UnregisterDeviceRequest();
        try
        {
            RequestManager.sendRequest(context, unregisterdevicerequest);
            PushEventsTransmitter.onUnregistered(context, s);
            Log.w("DeviceRegistrar", (new StringBuilder()).append("Unregistered for pushes: ").append(s).toString());
            PreferenceUtils.resetLastRegistration(context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        if (!TextUtils.isEmpty(s.getMessage()))
        {
            PushEventsTransmitter.onUnregisteredError(context, s.getMessage());
            Log.e("DeviceRegistrar", (new StringBuilder()).append("Unregistration error ").append(s.getMessage()).toString(), s);
            return;
        } else
        {
            s = unregisterdevicerequest.getRawResponse();
            PushEventsTransmitter.onUnregisteredError(context, s);
            Log.e("DeviceRegistrar", (new StringBuilder()).append("Unregistration error ").append(s).toString());
            return;
        }
    }
}
