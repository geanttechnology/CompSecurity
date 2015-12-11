// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

// Referenced classes of package net.singular.sdk:
//            Singular, SingularLog

public class InstallReceiver extends BroadcastReceiver
{

    public InstallReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Singular.initialize(context);
        context = Singular.getSingularLog();
        context.i("singular_sdk", "ReferrerReceiver.onReceive");
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        if (!intent.getAction().equals("com.android.vending.INSTALL_REFERRER"))
        {
            break MISSING_BLOCK_LABEL_88;
        }
        intent = intent.getStringExtra("referrer");
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        int i = intent.length();
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        intent = URLDecoder.decode(intent, "UTF-8");
        Singular.trackReferralId(intent);
        context.i("singular_sdk", (new StringBuilder()).append("ReferrerReceiver.onReceive(Context, Intent)PLAY_REFERRER_URL_GET_PARAM: ").append(intent).toString());
        return;
        intent;
        try
        {
            context.trackInternalDebugEvent("singular_sdk", "InstallReceiver: invalid referrer", intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent) { }
        try
        {
            context.e("singular_sdk", "InstallReceiver:onReceive exception", intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("singular_sdk", "InstallReceiver:onReceive exception", context);
        }
        return;
    }
}
