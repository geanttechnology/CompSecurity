// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.cropwindow.edge;

import android.graphics.Rect;
import com.edmodo.cropper.a.a;

public final class Edge extends Enum
{

    public static final Edge a;
    public static final Edge b;
    public static final Edge c;
    public static final Edge d;
    private static final Edge e[];
    private float mCoordinate;

    private Edge(String s, int i)
    {
        super(s, i);
    }

    private static float a(float f, Rect rect, float f1, float f2)
    {
        float f3 = (1.0F / 0.0F);
        if (f - (float)rect.left < f1)
        {
            return (float)rect.left;
        }
        if (f >= c.a() - 40F)
        {
            f1 = c.a() - 40F;
        } else
        {
            f1 = (1.0F / 0.0F);
        }
        if ((c.a() - f) / f2 <= 40F)
        {
            f3 = c.a() - 40F * f2;
        }
        return Math.min(f, Math.min(f1, f3));
    }

    private boolean a(float f, float f1, float f2, float f3, Rect rect)
    {
        return f < (float)rect.top || f1 < (float)rect.left || f2 > (float)rect.bottom || f3 > (float)rect.right;
    }

    public static float b()
    {
        return c.a() - a.a();
    }

    private static float b(float f, Rect rect, float f1, float f2)
    {
        float f3 = (-1.0F / 0.0F);
        if ((float)rect.right - f < f1)
        {
            return (float)rect.right;
        }
        if (f <= a.a() + 40F)
        {
            f1 = a.a() + 40F;
        } else
        {
            f1 = (-1.0F / 0.0F);
        }
        if ((f - a.a()) / f2 <= 40F)
        {
            f3 = a.a() + 40F * f2;
        }
        return Math.max(f, Math.max(f1, f3));
    }

    public static float c()
    {
        return d.a() - b.a();
    }

    private static float c(float f, Rect rect, float f1, float f2)
    {
        float f3 = (1.0F / 0.0F);
        if (f - (float)rect.top < f1)
        {
            return (float)rect.top;
        }
        if (f >= d.a() - 40F)
        {
            f1 = d.a() - 40F;
        } else
        {
            f1 = (1.0F / 0.0F);
        }
        if ((d.a() - f) * f2 <= 40F)
        {
            f3 = d.a() - 40F / f2;
        }
        return Math.min(f, Math.min(f1, f3));
    }

    private static float d(float f, Rect rect, float f1, float f2)
    {
        float f3 = (-1.0F / 0.0F);
        if ((float)rect.bottom - f < f1)
        {
            return (float)rect.bottom;
        }
        if (f <= b.a() + 40F)
        {
            f1 = b.a() + 40F;
        } else
        {
            f1 = (-1.0F / 0.0F);
        }
        if ((f - b.a()) * f2 <= 40F)
        {
            f3 = b.a() + 40F / f2;
        }
        return Math.max(f, Math.max(f3, f1));
    }

    public static Edge valueOf(String s)
    {
        return (Edge)Enum.valueOf(com/edmodo/cropper/cropwindow/edge/Edge, s);
    }

    public static Edge[] values()
    {
        return (Edge[])e.clone();
    }

    public float a()
    {
        return mCoordinate;
    }

    public float a(Rect rect)
    {
        float f = mCoordinate;
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[Edge.values().length];
                try
                {
                    a[com.edmodo.cropper.cropwindow.edge.Edge.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[Edge.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[Edge.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[Edge.d.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.edmodo.cropper.cropwindow.edge._cls1.a[ordinal()];
        JVM INSTR tableswitch 1 4: default 44
    //                   1 51
    //                   2 63
    //                   3 75
    //                   4 87;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return mCoordinate - f;
_L2:
        mCoordinate = rect.left;
        continue; /* Loop/switch isn't completed */
_L3:
        mCoordinate = rect.top;
        continue; /* Loop/switch isn't completed */
_L4:
        mCoordinate = rect.right;
        continue; /* Loop/switch isn't completed */
_L5:
        mCoordinate = rect.bottom;
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void a(float f)
    {
        mCoordinate = f;
    }

    public void a(float f, float f1, Rect rect, float f2, float f3)
    {
        switch (com.edmodo.cropper.cropwindow.edge._cls1.a[ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            mCoordinate = a(f, rect, f2, f3);
            return;

        case 2: // '\002'
            mCoordinate = c(f1, rect, f2, f3);
            return;

        case 3: // '\003'
            mCoordinate = b(f, rect, f2, f3);
            return;

        case 4: // '\004'
            mCoordinate = d(f1, rect, f2, f3);
            break;
        }
    }

    public boolean a(Rect rect, float f)
    {
        boolean flag = true;
        com.edmodo.cropper.cropwindow.edge._cls1.a[ordinal()];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 44
    //                   2 61
    //                   3 78
    //                   4 95;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        flag = false;
_L7:
        return flag;
_L2:
        if (mCoordinate - (float)rect.left >= f)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (mCoordinate - (float)rect.top >= f)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if ((float)rect.right - mCoordinate >= f)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if ((float)rect.bottom - mCoordinate >= f)
        {
            return false;
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public boolean a(Edge edge, Rect rect, float f)
    {
        float f1 = edge.b(rect);
        com.edmodo.cropper.cropwindow.edge._cls1.a[ordinal()];
        JVM INSTR tableswitch 1 4: default 44
    //                   1 46
    //                   2 162
    //                   3 278
    //                   4 394;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return true;
_L2:
        if (edge.equals(b))
        {
            float f2 = rect.top;
            f1 = d.a() - f1;
            float f10 = c.a();
            return a(f2, com.edmodo.cropper.a.a.b(f2, f10, f1, f), f1, f10, rect);
        }
        if (edge.equals(d))
        {
            float f3 = rect.bottom;
            f1 = b.a() - f1;
            float f11 = c.a();
            return a(f1, com.edmodo.cropper.a.a.b(f1, f11, f3, f), f3, f11, rect);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (edge.equals(a))
        {
            float f4 = rect.left;
            f1 = c.a() - f1;
            float f12 = d.a();
            return a(com.edmodo.cropper.a.a.c(f4, f1, f12, f), f4, f12, f1, rect);
        }
        if (edge.equals(c))
        {
            float f5 = rect.right;
            f1 = a.a() - f1;
            float f13 = d.a();
            return a(com.edmodo.cropper.a.a.c(f1, f5, f13, f), f1, f13, f5, rect);
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (edge.equals(b))
        {
            float f6 = rect.top;
            f1 = d.a() - f1;
            float f14 = a.a();
            return a(f6, f14, f1, com.edmodo.cropper.a.a.d(f14, f6, f1, f), rect);
        }
        if (edge.equals(d))
        {
            float f7 = rect.bottom;
            f1 = b.a() - f1;
            float f15 = a.a();
            return a(f1, f15, f7, com.edmodo.cropper.a.a.d(f15, f1, f7, f), rect);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        if (edge.equals(a))
        {
            float f8 = rect.left;
            f1 = c.a() - f1;
            float f16 = b.a();
            return a(f16, f8, com.edmodo.cropper.a.a.e(f8, f16, f1, f), f1, rect);
        }
        if (edge.equals(c))
        {
            float f9 = rect.right;
            f1 = a.a() - f1;
            float f17 = b.a();
            return a(f17, f1, com.edmodo.cropper.a.a.e(f1, f17, f9, f), f9, rect);
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public float b(Rect rect)
    {
        float f1 = mCoordinate;
        com.edmodo.cropper.cropwindow.edge._cls1.a[ordinal()];
        JVM INSTR tableswitch 1 4: default 44
    //                   1 50
    //                   2 59
    //                   3 68
    //                   4 77;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        float f = f1;
_L7:
        return f - f1;
_L2:
        f = rect.left;
        continue; /* Loop/switch isn't completed */
_L3:
        f = rect.top;
        continue; /* Loop/switch isn't completed */
_L4:
        f = rect.right;
        continue; /* Loop/switch isn't completed */
_L5:
        f = rect.bottom;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void b(float f)
    {
        mCoordinate = mCoordinate + f;
    }

    public void c(float f)
    {
        float f1 = a.a();
        float f2 = b.a();
        float f3 = c.a();
        float f4 = d.a();
        switch (com.edmodo.cropper.cropwindow.edge._cls1.a[ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            mCoordinate = com.edmodo.cropper.a.a.b(f2, f3, f4, f);
            return;

        case 2: // '\002'
            mCoordinate = com.edmodo.cropper.a.a.c(f1, f3, f4, f);
            return;

        case 3: // '\003'
            mCoordinate = com.edmodo.cropper.a.a.d(f1, f2, f4, f);
            return;

        case 4: // '\004'
            mCoordinate = com.edmodo.cropper.a.a.e(f1, f2, f3, f);
            break;
        }
    }

    static 
    {
        a = new Edge("LEFT", 0);
        b = new Edge("TOP", 1);
        c = new Edge("RIGHT", 2);
        d = new Edge("BOTTOM", 3);
        e = (new Edge[] {
            a, b, c, d
        });
    }
}
