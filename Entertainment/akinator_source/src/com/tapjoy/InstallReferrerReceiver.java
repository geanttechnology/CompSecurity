// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import com.tapjoy.internal.gd;
import com.tapjoy.internal.m;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class InstallReferrerReceiver extends m
{

    public InstallReferrerReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        String s;
        s = gd.a(context, intent);
        int i = a(context, intent);
        if (!intent.getBooleanExtra("fiverocks:verify", false) || !isOrderedBroadcast())
        {
            break MISSING_BLOCK_LABEL_80;
        }
        setResultCode(i + 1);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        setResultData((new StringBuilder("http://play.google.com/store/apps/details?id=")).append(context.getPackageName()).append("&referrer=").append(URLEncoder.encode(s, "UTF-8")).toString());
        return;
        context;
    }
}
