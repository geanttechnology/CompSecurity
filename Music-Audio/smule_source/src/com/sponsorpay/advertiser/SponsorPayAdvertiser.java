// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.advertiser;

import android.content.Context;
import android.util.Log;
import com.sponsorpay.SponsorPay;
import com.sponsorpay.credentials.SPCredentials;
import com.sponsorpay.utils.HostInfo;
import com.sponsorpay.utils.SPIdException;
import com.sponsorpay.utils.SPIdValidator;
import com.sponsorpay.utils.SponsorPayLogger;
import java.util.Map;

// Referenced classes of package com.sponsorpay.advertiser:
//            SponsorPayAdvertiserState, ActionCallbackSender, InstallCallbackSender

public class SponsorPayAdvertiser
{

    private static final String TAG = "SponsorPayAdvertiser";
    private static SponsorPayAdvertiser mInstance;
    private SponsorPayAdvertiserState mPersistedState;

    private SponsorPayAdvertiser(Context context)
    {
        if (context == null)
        {
            throw new RuntimeException("The SDK was not initialized yet. You should call SponsorPay.start method");
        } else
        {
            mPersistedState = new SponsorPayAdvertiserState(context);
            return;
        }
    }

    private static SponsorPayAdvertiser getInstance(Context context)
    {
        if (mInstance == null)
        {
            mInstance = new SponsorPayAdvertiser(context);
        }
        return mInstance;
    }

    private void notitfyActionCompletion(String s, String s1, Map map)
    {
        s = new ActionCallbackSender(s1, SponsorPay.getCredentials(s), mPersistedState);
        s.setCustomParams(map);
        s.trigger();
    }

    private static void outputLogMessage()
    {
        if (SponsorPayLogger.isLogging())
        {
            SponsorPayLogger.i("SponsorPayAdvertiser", "Only devices running Android API level 10 and above are supported");
            return;
        } else
        {
            Log.i("SponsorPayAdvertiser", "Only devices running Android API level 10 and above are supported");
            return;
        }
    }

    public static void register(Context context)
    {
        register(context, null);
    }

    public static void register(Context context, Map map)
    {
        register(SponsorPay.getCurrentCredentials().getCredentialsToken(), context, map);
    }

    public static void register(String s, Context context, Map map)
    {
        if (HostInfo.isDeviceSupported())
        {
            getInstance(context);
            mInstance.register(s, map);
            return;
        } else
        {
            outputLogMessage();
            return;
        }
    }

    private void register(String s, Map map)
    {
        s = new InstallCallbackSender(SponsorPay.getCredentials(s), mPersistedState);
        s.setCustomParams(map);
        s.trigger();
    }

    public static void reportActionCompletion(String s)
    {
        reportActionCompletion(SponsorPay.getCurrentCredentials().getCredentialsToken(), s);
    }

    public static void reportActionCompletion(String s, String s1)
    {
        reportActionCompletion(s, s1, null);
    }

    public static void reportActionCompletion(String s, String s1, Map map)
    {
        try
        {
            SPIdValidator.validate(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException((new StringBuilder("The provided Action ID is not valid. ")).append(s.getLocalizedMessage()).toString());
        }
        if (HostInfo.isDeviceSupported())
        {
            if (mInstance == null)
            {
                throw new RuntimeException("No valid credentials object was created yet.\nYou have to execute SponsorPay.start method first.");
            } else
            {
                mInstance.notitfyActionCompletion(s, s1, map);
                return;
            }
        } else
        {
            outputLogMessage();
            return;
        }
    }
}
