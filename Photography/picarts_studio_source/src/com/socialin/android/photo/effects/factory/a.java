// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.effects.factory;


public final class a
{

    private static final int a[] = {
        552, 255, 252, 11, 101
    };
    private static final Integer b[] = {
        Integer.valueOf(0xa8fb4877), Integer.valueOf(0xa8d6215c), Integer.valueOf(0xa8f38a50), Integer.valueOf(0xa8ec7439), Integer.valueOf(0xa8b4be54)
    };
    private static final Integer c[] = {
        Integer.valueOf(0xa809dfe1), Integer.valueOf(0xa8e88a04), Integer.valueOf(0xa8844c4d), Integer.valueOf(0xa865059e), Integer.valueOf(0xa8b8774c)
    };
    private static final Integer d[] = {
        Integer.valueOf(0xfff700), Integer.valueOf(0xf3ff00), Integer.valueOf(0xbcff6f), Integer.valueOf(0xffa1db)
    };
    private static final Integer e[] = {
        Integer.valueOf(0xff0000), Integer.valueOf(34047), Integer.valueOf(0xad3232), Integer.valueOf(0x1b6826)
    };

    public static int a(int i1)
    {
        return a[i1];
    }

    public static int a(String s)
    {
        if (s.equals("CROSSPROCESS_MODE_RED"))
        {
            return 1;
        }
        return !s.equals("CROSSPROCESS_MODE_GREEN") ? 3 : 2;
    }

    public static int b(int i1)
    {
        return c[i1].intValue();
    }

    public static int b(String s)
    {
        return !s.equals("CROSSPROCESSING_MODE_1") ? 2 : 1;
    }

    public static int c(int i1)
    {
        return b[i1].intValue();
    }

    public static int c(String s)
    {
        if (s.equals("VINTAGE_MODE_1"))
        {
            return 1;
        }
        if (s.equals("VINTAGE_MODE_2"))
        {
            return 2;
        }
        return !s.equals("VINTAGE_MODE_3") ? 4 : 3;
    }

    public static int d(int i1)
    {
        return d[i1].intValue();
    }

    public static int d(String s)
    {
        if (s.equals("VIGNETTE_SQRT"))
        {
            return 1;
        }
        if (s.equals("VIGNETTE_LINEAR"))
        {
            return 2;
        }
        if (s.equals("VIGNETTE_CUBE"))
        {
            return 4;
        }
        return !s.equals("VIGNETTE_SQUARE") ? 5 : 3;
    }

    public static int e(int i1)
    {
        return e[i1].intValue();
    }

    public static int e(String s)
    {
        if (s.equals("DESATURATE_MODE_DEFAULT"))
        {
            return 0;
        }
        if (s.equals("DESATURATE_MODE_RED"))
        {
            return 1;
        }
        return !s.equals("DESATURATE_MODE_GREEN") ? 3 : 2;
    }

    public static int f(String s)
    {
        return !s.equals("HDR_MODE_1") ? 2 : 1;
    }

    public static int g(String s)
    {
        if (!s.equals("Normal"))
        {
            if (s.equals("Multiply"))
            {
                return 1;
            }
            if (s.equals("Screen"))
            {
                return 2;
            }
            if (s.equals("Overlay"))
            {
                return 3;
            }
            if (s.equals("Darken"))
            {
                return 4;
            }
            if (s.equals("Lighten"))
            {
                return 5;
            }
            if (s.equals("Color Dodge"))
            {
                return 6;
            }
            if (s.equals("Difference"))
            {
                return 10;
            }
            if (s.equals("Exclusion"))
            {
                return 11;
            }
        }
        return 0;
    }

    public static int h(String s)
    {
        if (s.equals("SMEAR_LINES"))
        {
            return 1;
        }
        if (s.equals("SMEAR_CIRCLES"))
        {
            return 2;
        }
        if (s.equals("SMEAR_SQUARES"))
        {
            return 3;
        }
        return !s.equals("SMEAR_RANDOM") ? 0 : 4;
    }

    public static int i(String s)
    {
        return !s.equals("SKETCHER_MODE_1") ? 2 : 1;
    }

    public static int j(String s)
    {
        return !s.equals("FATTAL_MODE_1") ? 2 : 1;
    }

    public static int k(String s)
    {
        if (s.equals("UNITEDCOLORS_MODE_STD"))
        {
            return 0;
        }
        if (s.equals("UNITEDCOLORS_MODE_RED"))
        {
            return 1;
        }
        return !s.equals("UNITEDCOLORS_MODE_GREEN") ? 3 : 2;
    }

    public static int l(String s)
    {
        if (s.equals("SUNLESSTAN_MODE_1"))
        {
            return 1;
        }
        if (s.equals("SUNLESSTAN_MODE_2"))
        {
            return 2;
        }
        if (s.equals("SUNLESSTAN_MODE_3"))
        {
            return 3;
        }
        return !s.equals("SUNLESSTAN_MODE_4") ? 5 : 4;
    }

}
