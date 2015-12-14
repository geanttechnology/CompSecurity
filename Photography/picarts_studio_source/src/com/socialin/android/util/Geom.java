// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;

public abstract class Geom
{

    private static final Matrix a = new Matrix();
    private static final float b[] = new float[8];

    public static float a(float f)
    {
        return f >= 0.0F ? 1.0F : -1F;
    }

    public static float a(float f, float f1, float f2)
    {
        if (f >= f1)
        {
            f1 = f;
        }
        if (f1 > f2)
        {
            return f2;
        } else
        {
            return f1;
        }
    }

    public static float a(float f, float f1, float f2, float f3)
    {
        f -= f2;
        f1 -= f3;
        return f * f + f1 * f1;
    }

    public static float a(float f, float f1, float f2, float f3, float f4)
    {
        return ((f4 - f1) * (f2 - f)) / (f3 - f1) + f;
    }

    public static float a(float f, float f1, float f2, float f3, float f4, float f5)
    {
        float f6 = (f2 - f4) * (f2 - f4) + (f3 - f5) * (f3 - f5);
        if (f6 == 0.0F)
        {
            return b(f, f1, f2, f3);
        }
        f6 = ((f - f2) * (f4 - f2) + (f1 - f3) * (f5 - f3)) / f6;
        if (f6 < 0.0F)
        {
            return b(f, f1, f2, f3);
        }
        if (f6 > 1.0F)
        {
            return b(f, f1, f4, f5);
        } else
        {
            return b(f, f1, (f4 - f2) * f6 + f2, f6 * (f5 - f3) + f3);
        }
    }

    public static float a(PointF pointf, PointF pointf1)
    {
        return b(pointf.x, pointf.y, pointf1.x, pointf1.y);
    }

    public static float a(RectF rectf, HorizontalSide horizontalside)
    {
        switch (_cls1.c[horizontalside.ordinal()])
        {
        default:
            throw new IllegalArgumentException();

        case 1: // '\001'
            return rectf.top;

        case 2: // '\002'
            return rectf.bottom;
        }
    }

    public static float a(RectF rectf, VerticalSide verticalside)
    {
        switch (_cls1.b[verticalside.ordinal()])
        {
        default:
            throw new IllegalArgumentException();

        case 1: // '\001'
            return rectf.left;

        case 2: // '\002'
            return rectf.right;
        }
    }

    private static float a(float af[], int i, int j)
    {
        float f1;
        float f3;
        float f4;
        int k;
        f3 = af[i * 2];
        f4 = af[i * 2 + 1];
        f1 = 0.0F;
        k = 0;
_L6:
        if (k >= 2) goto _L2; else goto _L1
_L1:
        float f;
        float f5;
        float f6;
        float f7;
        f = af[((i + 1 + k) * 2) % 8];
        f5 = af[((i + 1 + k) * 2 + 1) % 8];
        f6 = af[((i + 2 + k) * 2) % 8];
        f7 = af[((i + 2 + k) * 2 + 1) % 8];
        j;
        JVM INSTR tableswitch 0 1: default 116
    //                   0 133
    //                   1 262;
           goto _L3 _L4 _L5
_L3:
        float f2 = f1;
_L10:
        k++;
        f1 = f2;
          goto _L6
_L4:
        if (f5 >= f4 && f7 <= f4) goto _L8; else goto _L7
_L7:
        f2 = f1;
        if (f5 > f4) goto _L10; else goto _L9
_L9:
        f2 = f1;
        if (f7 < f4) goto _L10; else goto _L8
_L8:
        if (f == f6)
        {
            f -= f3;
        } else
        if (f4 == f5)
        {
            f -= f3;
        } else
        if (f4 == f7)
        {
            f = f6 - f3;
        } else
        {
            f = (f + ((f6 - f) * (f4 - f5)) / (f7 - f5)) - f3;
        }
        if (Math.abs(f1) >= Math.abs(f))
        {
            f = f1;
        }
        f2 = f;
          goto _L10
_L5:
        if (f >= f3 && f6 <= f3) goto _L12; else goto _L11
_L11:
        f2 = f1;
        if (f > f3) goto _L10; else goto _L13
_L13:
        f2 = f1;
        if (f6 < f3) goto _L10; else goto _L12
_L12:
        if (f5 == f7)
        {
            f = f5 - f4;
        } else
        if (f3 == f)
        {
            f = f5 - f4;
        } else
        if (f3 == f6)
        {
            f = f7 - f4;
        } else
        {
            f = (((f7 - f5) * (f3 - f)) / (f6 - f) + f5) - f4;
        }
        f2 = f1;
        if (Math.abs(f1) < Math.abs(f))
        {
            f2 = f;
        }
          goto _L10
_L2:
        return f1;
          goto _L10
    }

    public static VerticalSide a(RectF rectf, float f, float f1, float f2)
    {
        if (rectf.top - f2 < f1 && f1 < rectf.bottom + f2)
        {
            if (Math.abs(f - rectf.left) < f2)
            {
                return VerticalSide.LEFT;
            }
            if (Math.abs(f - rectf.right) < f2)
            {
                return VerticalSide.RIGHT;
            }
        }
        return null;
    }

    public static void a(RectF rectf, float f)
    {
        float f1 = rectf.centerX();
        float f2 = rectf.centerY();
        float f3 = (rectf.width() * f) / 2.0F;
        f = (rectf.height() * f) / 2.0F;
        rectf.set(f1 - f3, f2 - f, f1 + f3, f2 + f);
    }

    public static void a(RectF rectf, float f, float f1)
    {
        rectf.offset(f - rectf.centerX(), f1 - rectf.centerY());
    }

    public static void a(RectF rectf, RectF rectf1)
    {
        float f2 = 0.0F;
        if (rectf.width() < rectf1.width() || rectf.height() < rectf1.height())
        {
            float f3 = Math.max(rectf1.width() / rectf.width(), rectf1.height() / rectf.height());
            float f = (rectf.width() * f3) / 2.0F;
            f3 = (f3 * rectf.height()) / 2.0F;
            float f4 = rectf.centerX();
            float f5 = rectf.centerY();
            rectf.set(f4 - f, f5 - f3, f + f4, f3 + f5);
        }
        float f1;
        if (rectf.left > rectf1.left)
        {
            f1 = rectf1.left - rectf.left;
        } else
        if (rectf.right < rectf1.right)
        {
            f1 = rectf1.right - rectf.right;
        } else
        {
            f1 = 0.0F;
        }
        if (rectf.top <= rectf1.top) goto _L2; else goto _L1
_L1:
        f2 = rectf1.top - rectf.top;
_L4:
        rectf.offset(f1, f2);
        return;
_L2:
        if (rectf.bottom < rectf1.bottom)
        {
            f2 = rectf1.bottom - rectf.bottom;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void a(RectF rectf, RectF rectf1, float f)
    {
        Matrix matrix = new Matrix();
        matrix.setRotate(f, rectf.centerX(), rectf.centerY());
        matrix.mapRect(rectf1, rectf);
        rectf1.sort();
    }

    public static void a(RectF rectf, RectF rectf1, RectF rectf2, float f)
    {
        rectf.left = rectf1.left + (rectf2.left - rectf1.left) * f;
        rectf.top = rectf1.top + (rectf2.top - rectf1.top) * f;
        rectf.right = rectf1.right + (rectf2.right - rectf1.right) * f;
        rectf.bottom = rectf1.bottom + (rectf2.bottom - rectf1.bottom) * f;
    }

    public static void a(RectF rectf, RectF rectf1, Fit fit)
    {
        float f;
        f = 1.0F;
        rectf.sort();
        rectf1.sort();
        _cls1.a[fit.ordinal()];
        JVM INSTR tableswitch 1 5: default 52
    //                   1 84
    //                   2 106
    //                   3 127
    //                   4 127
    //                   5 127;
           goto _L1 _L2 _L3 _L4 _L4 _L4
_L1:
        float f1 = 1.0F;
_L6:
        rectf.set(0.0F, 0.0F, f1, f);
        if (fit == Fit.START)
        {
            rectf.offsetTo(rectf1.left, rectf1.top);
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        f1 = rectf1.width();
        f = (rectf.height() * f1) / rectf.width();
        continue; /* Loop/switch isn't completed */
_L3:
        f = rectf1.height();
        f1 = (rectf.width() * f) / rectf.height();
        continue; /* Loop/switch isn't completed */
_L4:
        if (rectf.height() / rectf.width() < rectf1.height() / rectf1.width())
        {
            f1 = rectf1.width();
            f = (rectf.height() * f1) / rectf.width();
        } else
        {
            f = rectf1.height();
            f1 = (rectf.width() * f) / rectf.height();
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (fit == Fit.END)
        {
            rectf.offsetTo(rectf1.right, rectf1.bottom);
            return;
        } else
        {
            a(rectf, rectf1.centerX(), rectf1.centerY());
            return;
        }
    }

    public static void a(RectF rectf, HorizontalSide horizontalside, float f)
    {
        switch (_cls1.c[horizontalside.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            rectf.top = f;
            return;

        case 2: // '\002'
            rectf.bottom = f;
            break;
        }
    }

    public static void a(RectF rectf, VerticalSide verticalside, float f)
    {
        switch (_cls1.b[verticalside.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            rectf.left = f;
            return;

        case 2: // '\002'
            rectf.right = f;
            break;
        }
    }

    public static void a(RectF rectf, float af[], float f)
    {
        int i = 0;
        do
        {
label0:
            {
label1:
                {
                    if (i >= 4)
                    {
                        break label1;
                    }
                    float f4 = af[i * 2];
                    float f5 = af[i * 2 + 1];
                    float f1 = a(af, i, 0);
                    float f2 = a(af, i, 1);
                    if (f1 == 0.0F || f2 == 0.0F)
                    {
                        break label0;
                    }
                    float f6;
                    float af1[];
                    float af2[];
                    boolean flag;
                    int j;
                    if (f1 < 0.0F)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (f2 < 0.0F)
                    {
                        j = 1;
                    } else
                    {
                        j = 0;
                    }
                    f1 = Math.abs(f1);
                    f2 = Math.abs(f2);
                    if (f2 * f <= f1)
                    {
                        f = f2 * f;
                        f1 = f2;
                    } else
                    {
                        f3 = f1 / f;
                        f = f1;
                        f1 = f3;
                    }
                    if (flag)
                    {
                        rectf.left = f4 - f;
                        rectf.right = f4;
                    } else
                    {
                        rectf.left = f4;
                        rectf.right = f + f4;
                    }
                    if (j != 0)
                    {
                        rectf.top = f5 - f1;
                        rectf.bottom = f5;
                    } else
                    {
                        rectf.top = f5;
                        rectf.bottom = f5 + f1;
                    }
                    b[0] = rectf.left;
                    b[1] = rectf.top;
                    b[2] = rectf.right;
                    b[3] = rectf.top;
                    b[4] = rectf.right;
                    b[5] = rectf.bottom;
                    b[6] = rectf.left;
                    b[7] = rectf.bottom;
                    af1 = b;
                    f4 = b[i * 2];
                    f6 = b[i * 2 + 1];
                    f = 1.0F;
                    af2 = new float[2];
                    j = 0;
                    do
                    {
                        if (j >= 4)
                        {
                            break;
                        }
                        int k = 0;
                        float f3 = f;
                        while (k < 4) 
                        {
label2:
                            {
                                float f7 = af1[j * 2];
                                float f8 = af1[j * 2 + 1];
                                float f9 = af[(k * 2) % 8];
                                float f10 = af[(k * 2 + 1) % 8];
                                f5 = af[(k * 2 + 2) % 8];
                                float f11 = af[(k * 2 + 3) % 8];
                                if (f4 == f7)
                                {
                                    f = f3;
                                    if (f6 == f8)
                                    {
                                        break label2;
                                    }
                                }
                                if (f4 == f9)
                                {
                                    f = f3;
                                    if (f6 == f10)
                                    {
                                        break label2;
                                    }
                                }
                                if (f4 == f5)
                                {
                                    f = f3;
                                    if (f6 == f11)
                                    {
                                        break label2;
                                    }
                                }
                                flag = false;
                                f1 = 0.0F;
                                f = 0.0F;
                                float f16 = f7 - f4;
                                float f17 = f5 - f9;
                                float f12 = (f8 - f6) / f16;
                                float f13 = f6 - f12 * f4;
                                float f14 = (f11 - f10) / f17;
                                float f15 = f10 - f14 * f9;
                                if (f16 == 0.0F || f17 == 0.0F)
                                {
                                    if (f16 == 0.0F && f17 == 0.0F)
                                    {
                                        flag = false;
                                    } else
                                    if (f16 == 0.0F)
                                    {
                                        f = f14 * f4 + f15;
                                        flag = true;
                                        f1 = f4;
                                    } else
                                    {
                                        f = f12 * f5 + f13;
                                        flag = true;
                                        f1 = f5;
                                    }
                                } else
                                if (f12 != f14)
                                {
                                    f1 = (f15 - f13) / (f12 - f14);
                                    f = f12 * f1 + f13;
                                    flag = true;
                                }
                                if (flag && (f4 - f1) * (f1 - f7) >= -0.01F && (f1 - f5) * (f9 - f1) >= -0.01F && (f6 - f) * (f - f8) >= -0.01F && (f10 - f) * (f - f11) >= -0.01F)
                                {
                                    af2[0] = f1;
                                    af2[1] = f;
                                    flag = true;
                                } else
                                {
                                    flag = false;
                                }
                                f = f3;
                                if (flag)
                                {
                                    f1 = (f4 - af1[j * 2]) / (f4 - af2[0]);
                                    f = f3;
                                    if (f1 > f3)
                                    {
                                        f = f1;
                                    }
                                }
                            }
                            k++;
                            f3 = f;
                        }
                        j++;
                        f = f3;
                    } while (true);
                    if (f != 1.0F)
                    {
                        c(rectf, b[i * 2], b[i * 2 + 1], 1.0F / f);
                    }
                }
                return;
            }
            i++;
        } while (true);
    }

    public static void a(float af[], float f, float f1, float f2)
    {
        a.setRotate(f, f1, f2);
        a.mapPoints(af);
    }

    public static boolean a(RectF rectf, float f, VerticalSide verticalside, HorizontalSide horizontalside)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        if (verticalside == VerticalSide.LEFT || verticalside == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (horizontalside == HorizontalSide.TOP || horizontalside == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (verticalside == VerticalSide.RIGHT || verticalside == null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (horizontalside == HorizontalSide.BOTTOM || horizontalside == null)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        return a(rectf, f, flag, flag1, flag2, flag3);
    }

    public static boolean a(RectF rectf, float f, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        boolean flag4 = false;
        if (rectf.height() / rectf.width() >= f) goto _L2; else goto _L1
_L1:
        f = rectf.width() * f;
        if (!flag1) goto _L4; else goto _L3
_L3:
        if (flag3)
        {
            float f1 = rectf.centerY();
            rectf.top = f1 - f / 2.0F;
            rectf.bottom = f1 + f / 2.0F;
        } else
        {
            rectf.top = rectf.bottom - f;
        }
_L9:
        flag = true;
_L6:
        return flag;
_L4:
        flag = flag4;
        if (!flag3) goto _L6; else goto _L5
_L5:
        rectf.bottom = rectf.top + f;
        continue; /* Loop/switch isn't completed */
_L2:
        f = rectf.height() / f;
        if (flag)
        {
            if (flag2)
            {
                float f2 = rectf.centerX();
                rectf.left = f2 - f / 2.0F;
                rectf.right = f2 + f / 2.0F;
            } else
            {
                rectf.left = rectf.right - f;
            }
            continue; /* Loop/switch isn't completed */
        }
        flag = flag4;
        if (!flag2) goto _L6; else goto _L7
_L7:
        rectf.right = rectf.left + f;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static float b(float f, float f1, float f2)
    {
        return (f1 - f) * f2 + f;
    }

    public static float b(float f, float f1, float f2, float f3)
    {
        return (float)Math.sqrt(a(f, f1, f2, f3));
    }

    public static float b(float f, float f1, float f2, float f3, float f4)
    {
        return ((f4 - f) * (f3 - f1)) / (f2 - f) + f1;
    }

    public static float b(PointF pointf, PointF pointf1)
    {
        return c(pointf.x, pointf.y, pointf1.x, pointf1.y);
    }

    public static float b(RectF rectf, RectF rectf1)
    {
        return Math.max(Math.max(Math.max(Math.max(0.0F, Math.abs(rectf.left - rectf1.left)), Math.abs(rectf.top - rectf1.top)), Math.abs(rectf.right - rectf1.right)), Math.abs(rectf.bottom - rectf1.bottom));
    }

    public static HorizontalSide b(RectF rectf, float f, float f1, float f2)
    {
        if (rectf.left - f2 < f && f < rectf.right + f2)
        {
            if (Math.abs(f1 - rectf.top) < f2)
            {
                return HorizontalSide.TOP;
            }
            if (Math.abs(f1 - rectf.bottom) < f2)
            {
                return HorizontalSide.BOTTOM;
            }
        }
        return null;
    }

    public static void b(RectF rectf, float f, float f1)
    {
        float f2 = rectf.centerX();
        float f3 = rectf.centerY();
        rectf.set(f2 - f / 2.0F, f3 - f1 / 2.0F, f2 + f / 2.0F, f3 + f1 / 2.0F);
    }

    public static boolean b(RectF rectf, float f, VerticalSide verticalside, HorizontalSide horizontalside)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        if (verticalside == VerticalSide.LEFT || verticalside == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (horizontalside == HorizontalSide.TOP || horizontalside == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (verticalside == VerticalSide.RIGHT || verticalside == null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (horizontalside == HorizontalSide.BOTTOM || horizontalside == null)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        return b(rectf, f, flag, flag1, flag2, flag3);
    }

    public static boolean b(RectF rectf, float f, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        boolean flag4 = false;
        if (rectf.height() / rectf.width() >= f) goto _L2; else goto _L1
_L1:
        f = rectf.height() / f;
        if (!flag) goto _L4; else goto _L3
_L3:
        if (flag2)
        {
            float f1 = rectf.centerX();
            rectf.left = f1 - f / 2.0F;
            rectf.right = f1 + f / 2.0F;
        } else
        {
            rectf.left = rectf.right - f;
        }
_L9:
        flag = true;
_L6:
        return flag;
_L4:
        flag = flag4;
        if (!flag2) goto _L6; else goto _L5
_L5:
        rectf.right = rectf.left + f;
        continue; /* Loop/switch isn't completed */
_L2:
        f = rectf.width() * f;
        if (flag1)
        {
            if (flag3)
            {
                float f2 = rectf.centerY();
                rectf.top = f2 - f / 2.0F;
                rectf.bottom = f2 + f / 2.0F;
            } else
            {
                rectf.top = rectf.bottom - f;
            }
            continue; /* Loop/switch isn't completed */
        }
        flag = flag4;
        if (!flag3) goto _L6; else goto _L7
_L7:
        rectf.bottom = rectf.top + f;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static float c(float f, float f1, float f2, float f3)
    {
        return (float)Math.atan2(f3 - f1, f2 - f);
    }

    public static void c(RectF rectf, float f, float f1, float f2)
    {
        rectf.right = rectf.left + rectf.width() * f2;
        rectf.bottom = rectf.top + rectf.height() * f2;
        rectf.offsetTo((1.0F - f2) * f + rectf.left * f2, (1.0F - f2) * f1 + rectf.top * f2);
    }

    public static boolean c(RectF rectf, RectF rectf1)
    {
        return rectf.left == rectf1.left && rectf.right == rectf1.right && rectf.top == rectf1.top && rectf.bottom == rectf1.bottom;
    }

    static 
    {
        new PointF();
        new PointF();
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class HorizontalSide {}


    /* member class not found */
    class VerticalSide {}


    /* member class not found */
    class Fit {}

}
