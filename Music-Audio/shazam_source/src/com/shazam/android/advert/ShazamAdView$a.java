// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert;


// Referenced classes of package com.shazam.android.advert:
//            ShazamAdView

private static final class c extends Enum
{

    public static final b a;
    public static final b b;
    private static final b d[];
    final int c;

    public static c a(int i)
    {
        c ac[] = values();
        int k = ac.length;
        for (int j = 0; j < k; j++)
        {
            c c1 = ac[j];
            if (c1.c == i)
            {
                return c1;
            }
        }

        return a;
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/shazam/android/advert/ShazamAdView$a, s);
    }

    public static a[] values()
    {
        return (a[])d.clone();
    }

    static 
    {
        a = new <init>("APP_NEXUS", 0, 0);
        b = new <init>("FACEBOOK", 1, 1);
        d = (new d[] {
            a, b
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        c = j;
    }
}
