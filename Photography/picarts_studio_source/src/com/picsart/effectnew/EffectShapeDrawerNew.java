// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effectnew;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;

// Referenced classes of package com.picsart.effectnew:
//            h, i

public final class EffectShapeDrawerNew
{

    float a;
    float b;
    i c;
    Paint d;
    Paint e;
    boolean f;
    boolean g;
    float h;
    float i;
    Bitmap j;
    Bitmap k;
    boolean l;
    public ShapeType m;
    h n;

    public EffectShapeDrawerNew(Bitmap bitmap, Bitmap bitmap1)
    {
        a = 25F;
        b = 25F;
        c = null;
        d = null;
        e = null;
        f = false;
        g = false;
        h = 0.0F;
        i = 0.0F;
        j = null;
        k = null;
        l = true;
        m = ShapeType.Focal;
        d = new Paint();
        d.setAntiAlias(true);
        d.setStyle(android.graphics.Paint.Style.STROKE);
        e = new Paint(2);
        j = bitmap;
        k = bitmap1;
        a = Math.max((float)j.getWidth() / 2.0F, (float)j.getHeight() / 2.0F);
        b = Math.max((float)bitmap1.getWidth() / 2.0F, (float)bitmap1.getHeight() / 2.0F);
    }

    private void a(boolean flag)
    {
label0:
        {
label1:
            {
                if (n == null)
                {
                    break label1;
                }
                RectF rectf = n.a();
                if (c != null && rectf != null)
                {
                    if (flag)
                    {
                        break label0;
                    }
                    if (!rectf.contains(c.b.x, c.b.y))
                    {
                        break label1;
                    }
                }
                l = flag;
            }
            return;
        }
        l = flag;
    }

    public final boolean a(float f1, float f2)
    {
        i j1;
        if (n == null)
        {
            return false;
        }
        if (l)
        {
            i i1 = c;
            boolean flag;
            if (i1.a(i1.b.x - i1.c * i1.e, i1.b.y, f1, f2))
            {
                i1.a = 0;
                flag = true;
            } else
            if (i1.a(i1.b.x + i1.c * i1.e, i1.b.y, f1, f2))
            {
                i1.a = 1;
                flag = true;
            } else
            if (i1.a(i1.b.x, i1.b.y - i1.c * i1.f, f1, f2))
            {
                i1.a = 2;
                flag = true;
            } else
            if (i1.a(i1.b.x, i1.b.y + i1.c * i1.f, f1, f2))
            {
                i1.a = 3;
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                h = f1;
                i = f2;
                return true;
            }
        }
        j1 = c;
        if (j1.i.m != ShapeType.Focal) goto _L2; else goto _L1
_L1:
        double d1;
        double d2;
        double d3;
        double d4;
        float f3;
        float f5;
        float f7;
        d1 = Math.pow(j1.b.x - f1, 2D);
        d2 = Math.pow(j1.c * j1.f, 2D);
        d3 = Math.pow(j1.b.y - f2, 2D);
        d4 = Math.pow(j1.c * j1.e, 2D);
        f3 = j1.c;
        f5 = j1.c;
        f7 = j1.e;
        if (d1 * d2 + d3 * d4 > Math.pow(j1.f * (f3 * f5 * f7), 2D)) goto _L4; else goto _L3
_L3:
        boolean flag1 = true;
_L6:
        if (flag1)
        {
            f = true;
            h = f1;
            i = f2;
            a(true);
            return true;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (f1 >= j1.b.x - j1.c * Math.abs(j1.e) && f1 <= j1.b.x + j1.c * Math.abs(j1.e) && f2 >= j1.b.y - j1.c * Math.abs(j1.f))
        {
            float f4 = j1.b.y;
            float f6 = j1.c;
            if (f2 <= Math.abs(j1.f) * f6 + f4)
            {
                flag1 = true;
                continue; /* Loop/switch isn't completed */
            }
        }
_L4:
        flag1 = false;
        if (true) goto _L6; else goto _L5
_L5:
        if (l && f1 >= c.d.x - (float)(j.getWidth() / 2) - 5F && f1 <= c.d.x + (float)(j.getWidth() / 2) + 5F && f2 >= c.d.y - (float)(j.getHeight() / 2) - 5F && f2 <= c.d.y + (float)(j.getHeight() / 2) + 5F)
        {
            g = true;
            f = false;
            h = f1;
            i = f2;
            return true;
        } else
        {
            a(false);
            return false;
        }
    }

    private class ShapeType extends Enum
    {

        private static final ShapeType $VALUES[];
        public static final ShapeType Focal;
        public static final ShapeType Rect;

        public static ShapeType valueOf(String s)
        {
            return (ShapeType)Enum.valueOf(com/picsart/effectnew/EffectShapeDrawerNew$ShapeType, s);
        }

        public static ShapeType[] values()
        {
            return (ShapeType[])$VALUES.clone();
        }

        static 
        {
            Focal = new ShapeType("Focal", 0);
            Rect = new ShapeType("Rect", 1);
            $VALUES = (new ShapeType[] {
                Focal, Rect
            });
        }

        private ShapeType(String s, int i1)
        {
            super(s, i1);
        }
    }

}
