// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.d;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.MotionEvent;

// Referenced classes of package com.smule.pianoandroid.d:
//            c, b

public class a
{

    private static final String a = com/smule/pianoandroid/d/a.getName();
    private static c b = null;

    public a()
    {
    }

    public static c a(Context context)
    {
        if (b != null)
        {
            return b;
        }
        if (Build.MODEL.compareTo("Bowser") == 0)
        {
            b = c.b;
        } else
        if (Build.MODEL.compareTo("KFOT") == 0)
        {
            b = c.b;
        } else
        {
            context = context.getPackageManager();
            if (context.hasSystemFeature("android.hardware.touchscreen.multitouch.jazzhand"))
            {
                b = c.d;
            } else
            if (context.hasSystemFeature("android.hardware.touchscreen.multitouch.distinct"))
            {
                b = c.c;
            } else
            if (context.hasSystemFeature("android.hardware.touchscreen.multitouch"))
            {
                b = c.b;
            } else
            {
                b = c.a;
            }
        }
        return b;
    }

    private static void a(MotionEvent motionevent, int i, b b1)
    {
        b1.a(motionevent.getX(i), motionevent.getY(i), motionevent.getPointerId(i), motionevent.getAction() & 0xff);
    }

    public static boolean a(MotionEvent motionevent, b b1)
    {
        int i = motionevent.getAction();
        i & 0xff;
        JVM INSTR tableswitch 0 6: default 52
    //                   0 54
    //                   1 82
    //                   2 75
    //                   3 103
    //                   4 52
    //                   5 61
    //                   6 89;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7
_L1:
        return true;
_L2:
        b(motionevent, b1);
        return true;
_L6:
        a(motionevent, (i & 0xff00) >> 8, b1);
        return true;
_L4:
        c(motionevent, b1);
        return true;
_L3:
        b(motionevent, b1);
        return true;
_L7:
        a(motionevent, (i & 0xff00) >> 8, b1);
        return true;
_L5:
        int k = motionevent.getPointerCount();
        if (k == 1)
        {
            b(motionevent, b1);
            return true;
        }
        int j = 0;
        while (j < k) 
        {
            a(motionevent, j, b1);
            j++;
        }
        if (true) goto _L1; else goto _L8
_L8:
    }

    public static int b(Context context)
    {
        context = a(context);
        if (c.d == context)
        {
            return 5;
        }
        if (c.b == context || c.c == context)
        {
            return 2;
        }
        return c.a != context ? 0 : 1;
    }

    private static void b(MotionEvent motionevent, b b1)
    {
        b1.a(motionevent.getX(), motionevent.getY(), motionevent.getPointerId(0), motionevent.getAction() & 0xff);
    }

    private static void c(MotionEvent motionevent, b b1)
    {
        boolean flag = false;
        int k = motionevent.getPointerCount();
        int l = motionevent.getHistorySize() / k;
        int i1 = motionevent.getAction();
        int i = 0;
        while (i < l) 
        {
            if (k == 1)
            {
                b1.a(motionevent.getHistoricalX(i), motionevent.getHistoricalY(i), motionevent.getPointerId(0), i1 & 0xff);
            } else
            {
                int j = 0;
                while (j < k) 
                {
                    b1.a(motionevent.getHistoricalX(j, i), motionevent.getHistoricalY(j, i), motionevent.getPointerId(j), i1 & 0xff);
                    j++;
                }
            }
            i++;
        }
        i = ((flag) ? 1 : 0);
        if (k == 1)
        {
            b(motionevent, b1);
        } else
        {
            while (i < k) 
            {
                a(motionevent, i, b1);
                i++;
            }
        }
    }

}
