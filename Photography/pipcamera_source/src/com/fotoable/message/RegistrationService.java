// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.message;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.content.LocalBroadcastManager;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.iid.InstanceID;
import zw;

public class RegistrationService extends IntentService
{

    public RegistrationService()
    {
        super("RegistrationService.class.getSimpleName()");
    }

    protected void onHandleIntent(Intent intent)
    {
        if (intent == null)
        {
            intent = new Exception("RegistrationService.onHandleIntent intent is null");
            if (zw.j())
            {
                Crashlytics.logException(intent);
            }
            return;
        }
        String s;
        s = (String)intent.getExtras().get("sender_id");
        intent = PreferenceManager.getDefaultSharedPreferences(this);
        s = InstanceID.getInstance(this).getToken(s, "GCM", null);
        intent.edit().putBoolean("has_token", true).apply();
        intent.edit().putString("token", s).apply();
_L1:
        Exception exception;
        try
        {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("registration_completed"));
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            intent = new Exception("RegistrationService.onHandleIntent catch Exception");
            if (zw.j())
            {
                Crashlytics.logException(intent);
            }
        }
        stopSelf();
        return;
        exception;
        intent.edit().putBoolean("has_token", false).apply();
          goto _L1
    }
}
