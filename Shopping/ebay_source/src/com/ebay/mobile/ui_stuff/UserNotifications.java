// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.ui_stuff;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

public class UserNotifications
{

    public UserNotifications()
    {
    }

    public static void ShowToast(Activity activity, String s)
    {
        Toast.makeText(activity, s, 0).show();
    }

    public static void ShowToast(Activity activity, String s, boolean flag)
    {
        if (flag)
        {
            Toast.makeText(activity, s, 1).show();
            return;
        } else
        {
            Toast.makeText(activity, s, 0).show();
            return;
        }
    }

    public static void showToast(Context context, String s, boolean flag, boolean flag1)
    {
        int i;
        if (flag1)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        context = Toast.makeText(context, s, i);
        if (flag)
        {
            context.setGravity(17, 0, 0);
        }
        context.show();
    }
}
