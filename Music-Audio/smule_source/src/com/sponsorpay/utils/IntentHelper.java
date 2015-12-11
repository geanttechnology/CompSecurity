// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.util.List;

public class IntentHelper
{

    public IntentHelper()
    {
    }

    public static boolean isIntentAvailable(Context context, String s, Uri uri)
    {
        context = context.getPackageManager();
        s = new Intent(s);
        if (uri != null)
        {
            s.setData(uri);
        }
        return context.queryIntentActivities(s, 0x10000).size() > 0;
    }
}
