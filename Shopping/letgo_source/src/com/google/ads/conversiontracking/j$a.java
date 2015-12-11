// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.conversiontracking;

import android.text.TextUtils;

// Referenced classes of package com.google.ads.conversiontracking:
//            j

public static class c
{

    private final String a;
    private final String b;
    private final long c;

    public static c a(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            if ((s = s.split(" ")).length == 3)
            {
                boolean flag;
                try
                {
                    s = new <init>(s[0], s[1], Long.parseLong(s[2]));
                    flag = s.a();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    return null;
                }
                if (!flag)
                {
                    return s;
                }
            }
        }
        return null;
    }

    static String a(a a1)
    {
        return a1.b;
    }

    static String b(b b1)
    {
        return b1.a;
    }

    static long c(a a1)
    {
        return a1.c;
    }

    public boolean a()
    {
        return c + 0x1cf7c5800L < j.a();
    }

    public (String s, String s1)
    {
        this(s, s1, j.a());
    }

    private <init>(String s, String s1, long l)
    {
        a = s;
        b = s1;
        c = l;
    }
}
