// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.StrictMode;
import android.view.Display;
import android.view.WindowManager;

public class n
{

    public static Point a(Context context)
    {
        Point point;
        point = new Point();
        point.x = 480;
        point.y = 320;
        context = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        if (android.os.Build.VERSION.SDK_INT < 13)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        context.getSize(point);
        return point;
        try
        {
            point.x = context.getWidth();
            point.y = context.getHeight();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return point;
        }
        return point;
    }

    static void a()
    {
        try
        {
            if (android.os.Build.VERSION.SDK_INT >= 9)
            {
                StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder()).permitAll().build());
            }
            return;
        }
        catch (Throwable throwable)
        {
            return;
        }
    }

    public static boolean a(Class class1, Context context)
    {
        boolean flag = false;
        class1 = new Intent(context, class1);
        if (context.getPackageManager().resolveActivity(class1, 0) != null)
        {
            flag = true;
        }
        return flag;
    }

    public static boolean a(String s, Context context)
    {
        return context.checkCallingOrSelfPermission(s) == 0;
    }

    public static boolean b()
    {
        return android.os.Build.VERSION.SDK_INT >= 15;
    }

    public static boolean c()
    {
        return android.os.Build.VERSION.SDK_INT >= 19;
    }
}
