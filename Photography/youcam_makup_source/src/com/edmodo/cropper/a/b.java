// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;
import android.util.TypedValue;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.edmodo.cropper.cropwindow.handle.Handle;

public class b
{

    public static float a(Context context)
    {
        return TypedValue.applyDimension(1, 24F, context.getResources().getDisplayMetrics());
    }

    public static Pair a(Handle handle, float f, float f1, float f2, float f3, float f4, float f5)
    {
        float f6;
        f6 = 0.0F;
        if (handle == null)
        {
            return null;
        }
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[Handle.values().length];
                try
                {
                    a[Handle.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    a[Handle.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[Handle.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[Handle.d.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[Handle.e.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[Handle.f.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[Handle.g.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[Handle.h.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[Handle.i.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[handle.ordinal()];
        JVM INSTR tableswitch 1 9: default 68
    //                   1 89
    //                   2 101
    //                   3 114
    //                   4 126
    //                   5 139
    //                   6 149
    //                   7 159
    //                   8 170
    //                   9 180;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
        f = 0.0F;
        f1 = f6;
_L12:
        return new Pair(Float.valueOf(f), Float.valueOf(f1));
_L2:
        f = f2 - f;
        f1 = f3 - f1;
        continue; /* Loop/switch isn't completed */
_L3:
        f = f4 - f;
        f1 = f3 - f1;
        continue; /* Loop/switch isn't completed */
_L4:
        f = f2 - f;
        f1 = f5 - f1;
        continue; /* Loop/switch isn't completed */
_L5:
        f = f4 - f;
        f1 = f5 - f1;
        continue; /* Loop/switch isn't completed */
_L6:
        f = f2 - f;
        f1 = f6;
        continue; /* Loop/switch isn't completed */
_L7:
        f = 0.0F;
        f1 = f3 - f1;
        continue; /* Loop/switch isn't completed */
_L8:
        f = f4 - f;
        f1 = f6;
        continue; /* Loop/switch isn't completed */
_L9:
        f = 0.0F;
        f1 = f5 - f1;
        continue; /* Loop/switch isn't completed */
_L10:
        f2 = (f4 + f2) / 2.0F;
        f3 = (f3 + f5) / 2.0F;
        f = f2 - f;
        f1 = f3 - f1;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public static Handle a(float f, float f1, float f2, float f3, float f4, float f5, float f6)
    {
        if (a(f, f1, f2, f3, f6))
        {
            return Handle.a;
        }
        if (a(f, f1, f4, f3, f6))
        {
            return Handle.b;
        }
        if (a(f, f1, f2, f5, f6))
        {
            return Handle.c;
        }
        if (a(f, f1, f4, f5, f6))
        {
            return Handle.d;
        }
        if (c(f, f1, f2, f3, f4, f5) && a())
        {
            return Handle.i;
        }
        if (a(f, f1, f2, f4, f3, f6))
        {
            return Handle.f;
        }
        if (a(f, f1, f2, f4, f5, f6))
        {
            return Handle.h;
        }
        if (b(f, f1, f2, f3, f5, f6))
        {
            return Handle.e;
        }
        if (b(f, f1, f4, f3, f5, f6))
        {
            return Handle.g;
        }
        if (c(f, f1, f2, f3, f4, f5) && !a())
        {
            return Handle.i;
        } else
        {
            return null;
        }
    }

    private static boolean a()
    {
        return !CropOverlayView.a();
    }

    private static boolean a(float f, float f1, float f2, float f3, float f4)
    {
        return Math.abs(f - f2) <= f4 && Math.abs(f1 - f3) <= f4;
    }

    private static boolean a(float f, float f1, float f2, float f3, float f4, float f5)
    {
        return f > f2 && f < f3 && Math.abs(f1 - f4) <= f5;
    }

    private static boolean b(float f, float f1, float f2, float f3, float f4, float f5)
    {
        return Math.abs(f - f2) <= f5 && f1 > f3 && f1 < f4;
    }

    private static boolean c(float f, float f1, float f2, float f3, float f4, float f5)
    {
        return f > f2 && f < f4 && f1 > f3 && f1 < f5;
    }
}
