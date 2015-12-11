// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.PointF;

// Referenced classes of package jumiomobile:
//            af

public class ac
{

    public static double a(double d)
    {
        return 57.295779513082323D * d;
    }

    public static transient float a(float af1[])
    {
        int i = 0;
        float f = af1[0];
        for (int j = af1.length; i < j; i++)
        {
            f = Math.min(f, af1[i]);
        }

        return f;
    }

    public static PointF[] a(PointF pointf, PointF pointf1, PointF pointf2, PointF pointf3, int i)
    {
        return a(new PointF[] {
            pointf, pointf1, pointf2, pointf3
        }, i);
    }

    public static PointF[] a(PointF apointf[], int i)
    {
        if (i == 0)
        {
            return apointf;
        }
        if (apointf.length != 4)
        {
            throw new IllegalArgumentException("Only quadrangular polygons are supported at the moment!");
        } else
        {
            float f2 = apointf[0].x;
            float f3 = apointf[0].y;
            float f8 = apointf[1].x;
            float f9 = apointf[1].y;
            float f6 = apointf[2].x;
            float f7 = apointf[2].y;
            float f4 = apointf[3].x;
            float f5 = apointf[3].y;
            apointf = new af(f2, f3, f8, f9);
            Object obj = apointf.g().b().a(i).a(f8, f9);
            float f = apointf.f();
            float f1 = (float)(((af) (obj)).e() - (double)f * ((af) (obj)).d());
            apointf = new af(f8, f9, f6, f7);
            obj = apointf.g().b().a(i).a(f6, f7);
            f8 = apointf.f();
            f9 = (float)(((af) (obj)).e() - (double)f8 * ((af) (obj)).d());
            float f10 = (f9 - f1) / (f - f8);
            apointf = new PointF(f10, f8 * f10 + f9);
            obj = new af(f6, f7, f4, f5);
            Object obj1 = ((af) (obj)).g().b().a(i).a(f4, f5);
            f6 = ((af) (obj)).f();
            f7 = (float)(((af) (obj1)).e() - (double)f6 * ((af) (obj1)).d());
            f8 = (f7 - f9) / (f8 - f6);
            obj = new PointF(f8, f6 * f8 + f7);
            obj1 = new af(f4, f5, f2, f3);
            af af1 = ((af) (obj1)).g().b().a(i).a(f2, f3);
            f2 = ((af) (obj1)).f();
            f3 = (float)(af1.e() - (double)f2 * af1.d());
            f4 = (f3 - f7) / (f6 - f2);
            obj1 = new PointF(f4, f2 * f4 + f3);
            f2 = (f1 - f3) / (f2 - f);
            return (new PointF[] {
                new PointF(f2, f * f2 + f1), apointf, obj, obj1
            });
        }
    }

    public static transient float b(float af1[])
    {
        int i = 0;
        float f = af1[0];
        for (int j = af1.length; i < j; i++)
        {
            f = Math.max(f, af1[i]);
        }

        return f;
    }
}
