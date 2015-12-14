// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.util;

import java.util.Random;

public final class MathUtils
{

    private static final float DEG_TO_RAD = 0.01745329F;
    private static final float RAD_TO_DEG = 57.29578F;
    private static final Random sRandom = new Random();

    private MathUtils()
    {
    }

    public static float abs(float f)
    {
        if (f > 0.0F)
        {
            return f;
        } else
        {
            return -f;
        }
    }

    public static float acos(float f)
    {
        return (float)Math.acos(f);
    }

    public static float asin(float f)
    {
        return (float)Math.asin(f);
    }

    public static float atan(float f)
    {
        return (float)Math.atan(f);
    }

    public static float atan2(float f, float f1)
    {
        return (float)Math.atan2(f, f1);
    }

    public static float constrain(float f, float f1, float f2)
    {
        if (f < f1)
        {
            return f1;
        }
        if (f > f2)
        {
            return f2;
        } else
        {
            return f;
        }
    }

    public static int constrain(int i, int j, int k)
    {
        if (i < j)
        {
            return j;
        }
        if (i > k)
        {
            return k;
        } else
        {
            return i;
        }
    }

    public static long constrain(long l, long l1, long l2)
    {
        if (l < l1)
        {
            return l1;
        }
        if (l > l2)
        {
            return l2;
        } else
        {
            return l;
        }
    }

    public static float degrees(float f)
    {
        return 57.29578F * f;
    }

    public static float dist(float f, float f1, float f2, float f3)
    {
        f = f2 - f;
        f1 = f3 - f1;
        return (float)Math.sqrt(f * f + f1 * f1);
    }

    public static float dist(float f, float f1, float f2, float f3, float f4, float f5)
    {
        f = f3 - f;
        f1 = f4 - f1;
        f2 = f5 - f2;
        return (float)Math.sqrt(f * f + f1 * f1 + f2 * f2);
    }

    public static float exp(float f)
    {
        return (float)Math.exp(f);
    }

    public static float lerp(float f, float f1, float f2)
    {
        return (f1 - f) * f2 + f;
    }

    public static float log(float f)
    {
        return (float)Math.log(f);
    }

    public static float mag(float f, float f1)
    {
        return (float)Math.sqrt(f * f + f1 * f1);
    }

    public static float mag(float f, float f1, float f2)
    {
        return (float)Math.sqrt(f * f + f1 * f1 + f2 * f2);
    }

    public static float map(float f, float f1, float f2, float f3, float f4)
    {
        return (f2 - f3) * ((f4 - f) / (f1 - f)) + f2;
    }

    public static float max(float f, float f1)
    {
        if (f > f1)
        {
            return f;
        } else
        {
            return f1;
        }
    }

    public static float max(float f, float f1, float f2)
    {
        float f3;
        if (f > f1)
        {
            f3 = f2;
            if (f > f2)
            {
                f3 = f;
            }
        } else
        {
            f3 = f2;
            if (f1 > f2)
            {
                return f1;
            }
        }
        return f3;
    }

    public static float max(int i, int j)
    {
        if (i > j)
        {
            return (float)i;
        } else
        {
            return (float)j;
        }
    }

    public static float max(int i, int j, int k)
    {
        if (i > j)
        {
            if (i <= k)
            {
                i = k;
            }
            return (float)i;
        }
        if (j <= k)
        {
            j = k;
        }
        return (float)j;
    }

    public static float min(float f, float f1)
    {
        if (f < f1)
        {
            return f;
        } else
        {
            return f1;
        }
    }

    public static float min(float f, float f1, float f2)
    {
        float f3;
        if (f < f1)
        {
            f3 = f2;
            if (f < f2)
            {
                f3 = f;
            }
        } else
        {
            f3 = f2;
            if (f1 < f2)
            {
                return f1;
            }
        }
        return f3;
    }

    public static float min(int i, int j)
    {
        if (i < j)
        {
            return (float)i;
        } else
        {
            return (float)j;
        }
    }

    public static float min(int i, int j, int k)
    {
        if (i < j)
        {
            if (i >= k)
            {
                i = k;
            }
            return (float)i;
        }
        if (j >= k)
        {
            j = k;
        }
        return (float)j;
    }

    public static float norm(float f, float f1, float f2)
    {
        return (f2 - f) / (f1 - f);
    }

    public static float pow(float f, float f1)
    {
        return (float)Math.pow(f, f1);
    }

    public static float radians(float f)
    {
        return 0.01745329F * f;
    }

    public static float random(float f)
    {
        return sRandom.nextFloat() * f;
    }

    public static float random(float f, float f1)
    {
        if (f >= f1)
        {
            return f;
        } else
        {
            return f + sRandom.nextFloat() * (f1 - f);
        }
    }

    public static int random(int i)
    {
        return (int)(sRandom.nextFloat() * (float)i);
    }

    public static int random(int i, int j)
    {
        if (i >= j)
        {
            return i;
        } else
        {
            return (int)(sRandom.nextFloat() * (float)(j - i) + (float)i);
        }
    }

    public static void randomSeed(long l)
    {
        sRandom.setSeed(l);
    }

    public static float sq(float f)
    {
        return f * f;
    }

    public static float tan(float f)
    {
        return (float)Math.tan(f);
    }

}
