// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.ads.AdSize;

public final class ayy
{

    public static final ayy a = new ayy(-1, -2, "mb");
    public static final ayy b = new ayy(320, 50, "mb");
    public static final ayy c = new ayy(300, 250, "as");
    public static final ayy d = new ayy(468, 60, "as");
    public static final ayy e = new ayy(728, 90, "as");
    public static final ayy f = new ayy(160, 600, "as");
    private final AdSize g;

    private ayy(int i, int j, String s)
    {
        this(new AdSize(i, j));
    }

    public ayy(AdSize adsize)
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
        if (!(obj instanceof ayy))
        {
            return false;
        } else
        {
            obj = (ayy)obj;
            return g.equals(((ayy) (obj)).g);
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
