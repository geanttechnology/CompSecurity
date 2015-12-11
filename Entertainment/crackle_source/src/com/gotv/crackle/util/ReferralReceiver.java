// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.gotv.crackle.helpers.SharedPrefsManager;
import java.net.URLDecoder;

// Referenced classes of package com.gotv.crackle.util:
//            Log

public class ReferralReceiver extends BroadcastReceiver
{

    public ReferralReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        int i;
        try
        {
            context = URLDecoder.decode(intent.getStringExtra("referrer"), "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("Crackle", "Referral exception:");
            context.printStackTrace();
            return;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        intent = context.substring(context.indexOf("=", context.indexOf("utm_campaign")) + 1);
        i = intent.indexOf("&");
        context = intent;
        if (i <= -1)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        context = intent.substring(0, i);
        SharedPrefsManager.setReferralID(context);
        SharedPrefsManager.setShouldReportReferrer(true);
    }
}
