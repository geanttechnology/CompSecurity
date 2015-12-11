// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.f;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import com.smule.android.network.core.b;

public class a
{

    public static int a(Display display)
    {
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            Point point = new Point();
            display.getSize(point);
            return point.x;
        } else
        {
            return display.getWidth();
        }
    }

    public static String a()
    {
        int i = com.smule.android.network.core.b.d().e().getResources().getConfiguration().screenLayout & 0xf;
        if (i == 1)
        {
            return "small";
        }
        if (i == 2)
        {
            return "normal";
        }
        if (i == 3)
        {
            return "large";
        }
        if (i == 4)
        {
            return "xlarge";
        } else
        {
            return "unknown";
        }
    }

    public static int b(Display display)
    {
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            Point point = new Point();
            display.getSize(point);
            return point.y;
        } else
        {
            return display.getHeight();
        }
    }
}
