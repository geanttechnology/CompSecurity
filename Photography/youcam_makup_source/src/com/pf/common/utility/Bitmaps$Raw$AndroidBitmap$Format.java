// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.utility;


final class config extends Enum
{

    public static final e a;
    public static final e b;
    public static final e c;
    public static final e d;
    public static final e e;
    private static final e f[];
    final android.graphics.rmat config;
    final int nativeValue;

    public static config a(int i)
    {
        config aconfig[] = values();
        int k = aconfig.length;
        for (int j = 0; j < k; j++)
        {
            config config1 = aconfig[j];
            if (config1.nativeValue == i)
            {
                return config1;
            }
        }

        throw new IllegalArgumentException();
    }

    public static nativeValue a(android.graphics.rmat.nativeValue nativevalue)
    {
        nativeValue anativevalue[] = values();
        int j = anativevalue.length;
        for (int i = 0; i < j; i++)
        {
            nativeValue nativevalue1 = anativevalue[i];
            if (nativevalue1.config == nativevalue)
            {
                return nativevalue1;
            }
        }

        throw new IllegalArgumentException();
    }

    public static config valueOf(String s)
    {
        return (config)Enum.valueOf(com/pf/common/utility/Bitmaps$Raw$AndroidBitmap$Format, s);
    }

    public static config[] values()
    {
        return (config[])f.clone();
    }

    static 
    {
        a = new <init>("NONE", 0, 0, null);
        b = new <init>("RGBA_8888", 1, 1, android.graphics.rmat);
        c = new <init>("RGB_565", 2, 4, android.graphics.rmat);
        d = new <init>("RGBA_4444", 3, 7, android.graphics.rmat);
        e = new <init>("A_8", 4, 8, android.graphics.rmat);
        f = (new f[] {
            a, b, c, d, e
        });
    }

    private (String s, int i, int j, android.graphics.rmat rmat)
    {
        super(s, i);
        nativeValue = j;
        config = rmat;
    }
}
