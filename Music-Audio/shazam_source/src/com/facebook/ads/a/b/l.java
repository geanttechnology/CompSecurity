// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.b;

import java.util.Locale;

public final class l extends Enum
{

    public static final l a;
    public static final l b;
    private static final l c[];

    private l(String s, int i)
    {
        super(s, i);
    }

    public static l a(String s)
    {
        if (s == null)
        {
            return a;
        }
        try
        {
            s = (l)Enum.valueOf(com/facebook/ads/a/b/l, s.toUpperCase(Locale.getDefault()));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return a;
        }
        return s;
    }

    public static l valueOf(String s)
    {
        return (l)Enum.valueOf(com/facebook/ads/a/b/l, s);
    }

    public static l[] values()
    {
        return (l[])c.clone();
    }

    static 
    {
        a = new l("UNKNOWN", 0);
        b = new l("AN", 1);
        c = (new l[] {
            a, b
        });
    }
}
