// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.gcm;

import android.content.Context;
import android.util.Log;
import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.d;
import com.socialin.asyncnet.Request;
import java.io.IOException;
import java.util.Random;

public final class ServerUtilities
{

    private static final int BACKOFF_MILLI_SECONDS = 2000;
    private static final int MAX_ATTEMPTS = 5;
    public static final String SENDER_ID = "1076413845392";
    private static final String TAG = "ServerUtilities";
    private static final Random random = new Random();

    public ServerUtilities()
    {
    }

    public static boolean register(Context context, String s)
    {
        int i;
        long l;
        d.a((new StringBuilder("ServerUtilities registering device (regId = ")).append(s).append(")").toString());
        l = random.nextInt(1000) + 2000;
        i = 1;
_L2:
        if (i > 5)
        {
            break; /* Loop/switch isn't completed */
        }
        (new StringBuilder("Attempt #")).append(i).append(" to register");
        SocialinApiV3.getInstance().createGcmRegisterRequest(s).d();
        return true;
        context;
        Log.e("ServerUtilities", (new StringBuilder("Failed to register on attempt ")).append(i).toString(), context);
        if (i == 5)
        {
            break; /* Loop/switch isn't completed */
        }
        try
        {
            (new StringBuilder("Sleeping for ")).append(l).append(" ms before retry");
            Thread.sleep(l);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Thread.currentThread().interrupt();
            return false;
        }
        i++;
        l = 2L * l;
        if (true) goto _L2; else goto _L1
_L1:
        return false;
    }

    public static void unregister(Context context, String s)
    {
        Log.i("ServerUtilities", (new StringBuilder("unregistering device (regId = ")).append(s).append(")").toString());
        try
        {
            throw new IOException();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

}
