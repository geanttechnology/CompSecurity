// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.util.List;

class b
{

    String a;
    int b;

    final boolean a(Context context)
    {
        Intent intent;
        if (a.contains("://"))
        {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(a));
        } else
        {
            intent = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append(a).append("://").toString()));
        }
        return context.getPackageManager().queryIntentActivities(intent, 0x10000).size() > 0;
    }

    ()
    {
    }

    (String s, int i)
    {
        a = s;
        b = i;
    }
}
