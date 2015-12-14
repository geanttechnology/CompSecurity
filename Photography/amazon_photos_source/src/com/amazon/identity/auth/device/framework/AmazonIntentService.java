// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.app.IntentService;
import android.content.Intent;
import com.amazon.identity.auth.device.utils.MAPLog;

public abstract class AmazonIntentService extends IntentService
{

    public static final String TAG = com/amazon/identity/auth/device/framework/AmazonIntentService.getName();

    public AmazonIntentService(String s)
    {
        super(s);
    }

    public final void onHandleIntent(Intent intent)
    {
        if (intent == null)
        {
            MAPLog.w(TAG, "Ignore: Received (null) Intent");
            return;
        }
        try
        {
            MAPLog.i(TAG, (new StringBuilder("Service Received: ")).append(intent).toString());
            protectedOnHandleIntent$14d1abce();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            stopSelf();
            throw intent;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            stopSelf();
        }
        throw intent;
    }

    protected abstract void protectedOnHandleIntent$14d1abce();

}
