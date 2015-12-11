// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.ads.AdSize;

public final class kh
{

    public static final kh a = new kh(-1, -2, "mb");
    public static final kh b = new kh(320, 50, "mb");
    public static final kh c = new kh(300, 250, "as");
    public static final kh d = new kh(468, 60, "as");
    public static final kh e = new kh(728, 90, "as");
    public static final kh f = new kh(160, 600, "as");
    private final AdSize g;

    private kh(int i, int j, String s)
    {
        this(new AdSize(i, j));
    }

    public kh(AdSize adsize)
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
        if (!(obj instanceof kh))
        {
            return false;
        } else
        {
            obj = (kh)obj;
            return g.equals(((kh) (obj)).g);
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
