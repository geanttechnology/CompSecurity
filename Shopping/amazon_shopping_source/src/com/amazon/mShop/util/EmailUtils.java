// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class EmailUtils
{

    public EmailUtils()
    {
    }

    public static void composeEmail(Context context, String s, String s1, String s2)
    {
        s = new Intent("android.intent.action.SENDTO", Uri.parse((new StringBuilder()).append("mailto:").append(s).toString()));
        s.putExtra("android.intent.extra.SUBJECT", s1);
        if (s2 != null)
        {
            s.putExtra("android.intent.extra.TEXT", s2);
        } else
        {
            s.putExtra("android.intent.extra.TEXT", "");
        }
        context.startActivity(Intent.createChooser(s, context.getString(com.amazon.mShop.android.lib.R.string.send_email)));
    }
}
