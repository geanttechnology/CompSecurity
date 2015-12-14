// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ay;

import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

public final class a
{

    private static ColorMatrix a = new ColorMatrix();
    private static int b[] = {
        0xffff0000, -65281, 0xff0000ff, 0xff00ffff, 0xff00ff00, -256, 0xffff0000
    };

    private static int a(int i, int j, float f)
    {
        return Math.round((float)(j - i) * f) + i;
    }

    public static ColorMatrixColorFilter a(int i, int j)
    {
        return new ColorMatrixColorFilter(b(i, j));
    }

    public static void a(int i, int j, ColorMatrix colormatrix)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException();

        case 0: // '\0'
            colormatrix.setSaturation((float)j / 50F);
            return;

        case 1: // '\001'
            float f = (float)j - 100F;
            colormatrix.set(new float[] {
                1.0F, 0.0F, 0.0F, 0.0F, f, 0.0F, 1.0F, 0.0F, 0.0F, f, 
                0.0F, 0.0F, 1.0F, 0.0F, f, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F
            });
            return;

        case 2: // '\002'
            float f1 = (float)j / 50F;
            colormatrix.set(new float[] {
                f1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f1, 0.0F, 0.0F, 0.0F, 
                0.0F, 0.0F, f1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F
            });
            return;

        case 3: // '\003'
            float f2 = j;
            colormatrix.set(new float[] {
                (float)j, (float)j, f2, 0.0F, -30720F, (float)j, (float)j, f2, 0.0F, -30720F, 
                (float)j, (float)j, f2, 0.0F, -30720F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F
            });
            return;

        case 4: // '\004'
            float f4 = (float)(((double)j * 3.1415899999999999D) / 180D);
            float f3 = (float)Math.cos(f4);
            f4 = (float)Math.sin(f4);
            colormatrix.set(new float[] {
                0.213F + 0.787F * f3 + -0.213F * f4, 0.715F + -0.715F * f3 + -0.715F * f4, 0.072F + -0.072F * f3 + 0.928F * f4, 0.0F, 0.0F, (float)((double)(0.213F + -0.213F * f3) + (double)f4 * 0.14299999999999999D), (float)((double)(0.715F + 0.285F * f3) + (double)f4 * 0.14000000000000001D), (float)((double)(0.072F + -0.072F * f3) + (double)f4 * -0.28299999999999997D), 0.0F, 0.0F, 
                0.213F + -0.213F * f3 + -0.787F * f4, 0.715F + -0.715F * f3 + 0.715F * f4, f4 * 0.072F + (f3 * 0.928F + 0.072F), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 
                0.0F, 0.0F, 0.0F, 0.0F, 1.0F
            });
            return;

        case 5: // '\005'
            colormatrix.set(a(j, false));
            return;

        case 6: // '\006'
            colormatrix.set(a(j, true));
            return;

        case 7: // '\007'
            colormatrix.set(new float[] {
                0.393F, 0.769F, 0.189F, 0.0F, 0.0F, 0.349F, 0.686F, 0.168F, 0.0F, 0.0F, 
                0.272F, 0.534F, 0.131F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F
            });
            break;
        }
    }

    public static void a(int i, int j, Paint paint)
    {
        a(i, j, a);
        paint.setColorFilter(new ColorMatrixColorFilter(a));
    }

    private static float[] a(int i, boolean flag)
    {
        float f1 = 1.0F;
        float f = (float)i / 255F;
        int ai[] = b;
        float f2;
        float f3;
        int j;
        if (f <= 0.0F)
        {
            i = ai[0];
        } else
        if (f >= 1.0F)
        {
            i = ai[ai.length - 1];
        } else
        {
            f *= ai.length - 1;
            int k = (int)f;
            f -= k;
            i = ai[k];
            k = ai[k + 1];
            i = Color.argb(a(Color.alpha(i), Color.alpha(k), f), a(Color.red(i), Color.red(k), f), a(Color.green(i), Color.green(k), f), a(Color.blue(i), Color.blue(k), f));
        }
        j = i >> 24 & 0xff;
        f2 = (float)j / 255F;
        if (flag)
        {
            f = -0.001F;
        } else
        {
            f = 0.333333F;
        }
        f2 *= f;
        f3 = j;
        if (flag)
        {
            f = 1.0F;
        } else
        {
            f = 0.0F;
        }
        if (flag)
        {
            f1 = -1F;
        }
        return (new float[] {
            f1, 0.0F, 0.0F, 0.0F, (float)(i >> 16 & 0xff), 0.0F, f1, 0.0F, 0.0F, (float)(i >> 8 & 0xff), 
            0.0F, 0.0F, f1, 0.0F, (float)(i & 0xff), f2, f2, f2, 0.0F, f * f3
        });
    }

    public static ColorMatrix b(int i, int j)
    {
        ColorMatrix colormatrix = new ColorMatrix();
        a(i, j, colormatrix);
        return colormatrix;
    }

}
