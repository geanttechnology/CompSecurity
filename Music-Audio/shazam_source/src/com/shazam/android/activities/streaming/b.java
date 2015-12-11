// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.streaming;

import java.util.Locale;

// Referenced classes of package com.shazam.android.activities.streaming:
//            RdioAuthFlowActivity, SpotifyAuthFlowActivity

public final class b extends Enum
{

    public static final b a;
    public static final b b;
    private static final b i[];
    public final String c;
    public final int d;
    public final int e;
    public final int f;
    final int g;
    final Class h;

    private b(String s, int j, String s1, int k, int l, int i1, int j1, 
            Class class1)
    {
        super(s, j);
        c = s1;
        d = k;
        e = l;
        f = i1;
        g = j1;
        h = class1;
    }

    public static b a(String s)
    {
        b ab[] = values();
        int k = ab.length;
        for (int j = 0; j < k; j++)
        {
            b b1 = ab[j];
            if (b1.c.equals(s))
            {
                return b1;
            }
        }

        return null;
    }

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(com/shazam/android/activities/streaming/b, s);
    }

    public static b[] values()
    {
        return (b[])i.clone();
    }

    public final String toString()
    {
        return name().toLowerCase(Locale.US);
    }

    static 
    {
        a = new b("RDIO", 0, "rdio", 0x7f0900e9, 0x7f020134, 0x7f020135, 0x7f020172, com/shazam/android/activities/streaming/RdioAuthFlowActivity);
        b = new b("SPOTIFY", 1, "spotify", 0x7f09012a, 0x7f020136, 0x7f02015f, 0x7f020173, com/shazam/android/activities/streaming/SpotifyAuthFlowActivity);
        i = (new b[] {
            a, b
        });
    }
}
