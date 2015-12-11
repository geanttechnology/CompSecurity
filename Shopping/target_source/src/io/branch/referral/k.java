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

public class k extends BroadcastReceiver
{

    private static String a = "bnc_no_value";

    public k()
    {
    }

    public static String a()
    {
        return a;
    }

    public void onReceive(Context context, Intent intent)
    {
        int i;
        i = 0;
        context = intent.getStringExtra("referrer");
        if (context == null) goto _L2; else goto _L1
_L1:
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
_L7:
        if (i >= j) goto _L4; else goto _L3
_L3:
        String as[] = intent[i].split("=");
        if (as.length > 1)
        {
            context.put(URLDecoder.decode(as[0], "UTF-8"), URLDecoder.decode(as[1], "UTF-8"));
        }
          goto _L5
_L4:
        if (context.containsKey(j.a.e.a()))
        {
            a = (String)context.get(j.a.e.a());
        }
_L2:
        return;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

}
