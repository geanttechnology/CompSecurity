// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.util;

import android.app.Activity;
import android.os.CountDownTimer;
import android.widget.Toast;

public class ToastUtils
{

    public ToastUtils()
    {
    }

    public static void showLonger(Activity activity, String s)
    {
        activity = Toast.makeText(activity, s, 0);
        activity.setGravity(48, 0, 80);
        activity.show();
        (new CountDownTimer(3000L, 1000L, activity) {

            final Toast val$toast;

            public void onFinish()
            {
                toast.show();
            }

            public void onTick(long l)
            {
                toast.show();
            }

            
            {
                toast = toast1;
                super(l, l1);
            }
        }).start();
    }
}
