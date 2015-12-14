// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.cyberlink.youcammakeup.Globals;

public class bf
{

    private static boolean a;

    public static boolean a()
    {
        return a;
    }

    static 
    {
        DisplayMetrics displaymetrics = Globals.d().getResources().getDisplayMetrics();
        double d = (double)displaymetrics.heightPixels / (double)displaymetrics.widthPixels;
        if (Math.abs(1080 - displaymetrics.widthPixels) < Math.abs(720 - displaymetrics.widthPixels))
        {
            if (Math.abs(d - 1.7777777777777777D) < Math.abs(d - 1.3333333333333333D))
            {
                a = true;
            } else
            {
                a = false;
            }
        } else
        if (Math.abs(d - 1.7777777777777777D) < Math.abs(d - 1.3333333333333333D))
        {
            a = true;
        } else
        {
            a = false;
        }
    }
}
