// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.playhaven.android.util;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

public class DisplayUtil
{

    public DisplayUtil()
    {
    }

    public static Display getDisplay(Context context)
    {
        return ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
    }

    public static Point getScreenSize(Context context)
    {
        context = getDisplay(context);
        Point point = new Point();
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            context.getSize(point);
            return point;
        } else
        {
            point.x = context.getWidth();
            point.y = context.getHeight();
            return point;
        }
    }

    public static boolean isPortrait(Context context)
    {
        getDisplay(context);
        context = getScreenSize(context);
        return ((Point) (context)).x <= ((Point) (context)).y;
    }
}
