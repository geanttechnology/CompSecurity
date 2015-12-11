// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;

public class InstallListener extends BroadcastReceiver
{

    private static String installID_ = "bnc_no_value";

    public InstallListener()
    {
    }

    public static String getInstallationID()
    {
        return installID_;
    }

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getStringExtra("referrer");
        if (context == null) goto _L2; else goto _L1
_L1:
        int i;
        String as[];
        int j;
        try
        {
            intent = URLDecoder.decode(context, "UTF-8");
            context = new HashMap();
            intent = intent.split("&");
            j = intent.length;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return;
        }
        i = 0;
_L7:
        if (i >= j) goto _L4; else goto _L3
_L3:
        as = intent[i].split("=");
        if (as.length > 1)
        {
            context.put(URLDecoder.decode(as[0], "UTF-8"), URLDecoder.decode(as[1], "UTF-8"));
        }
          goto _L5
_L4:
        if (context.containsKey(Defines.Jsonkey.LinkClickID.getKey()))
        {
            installID_ = (String)context.get(Defines.Jsonkey.LinkClickID.getKey());
        }
_L2:
        return;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

}
