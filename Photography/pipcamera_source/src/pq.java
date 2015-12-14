// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.ads.AdSize;

public final class pq
{

    public static final pq a = new pq(-1, -2, "mb");
    public static final pq b = new pq(320, 50, "mb");
    public static final pq c = new pq(300, 250, "as");
    public static final pq d = new pq(468, 60, "as");
    public static final pq e = new pq(728, 90, "as");
    public static final pq f = new pq(160, 600, "as");
    private final AdSize g;

    private pq(int i, int j, String s)
    {
        this(new AdSize(i, j));
    }

    public pq(AdSize adsize)
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
        if (!(obj instanceof pq))
        {
            return false;
        } else
        {
            obj = (pq)obj;
            return g.equals(((pq) (obj)).g);
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
