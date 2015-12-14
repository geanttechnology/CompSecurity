// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;

public class BroadcastReceiverUtility
{

    public static void toggleBroadcastReceiver(Context context, Class class1, boolean flag)
    {
        class1 = new ComponentName(context, class1);
        context = context.getPackageManager();
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        context.setComponentEnabledSetting(class1, i, 1);
    }
}
