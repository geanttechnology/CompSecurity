// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a;

import com.google.android.gms.ads.AdSize;

public final class d
{

    public static final d a = new d(-1, -2, "mb");
    public static final d b = new d(320, 50, "mb");
    public static final d c = new d(300, 250, "as");
    public static final d d = new d(468, 60, "as");
    public static final d e = new d(728, 90, "as");
    public static final d f = new d(160, 600, "as");
    private final AdSize g;

    private d(int i, int j, String s)
    {
        this(new AdSize(i, j));
    }

    public d(AdSize adsize)
    {
        g = adsize;
    }

    public int a()
    {
        return g.getWidth();
    }

    public int b()
    {
        return g.getHeight();
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof d))
        {
            return false;
        } else
        {
            obj = (d)obj;
            return g.equals(((d) (obj)).g);
        }
    }

    public int hashCode()
    {
        return g.hashCode();
    }

    public String toString()
    {
        return g.toString();
    }

}
