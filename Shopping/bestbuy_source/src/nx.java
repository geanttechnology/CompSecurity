// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class nx
{

    public static final nx a = new nx(-1, -2, "mb");
    public static final nx b = new nx(320, 50, "mb");
    public static final nx c = new nx(300, 250, "as");
    public static final nx d = new nx(468, 60, "as");
    public static final nx e = new nx(728, 90, "as");
    public static final nx f = new nx(160, 600, "as");
    private final oo g;

    private nx(int i, int j, String s)
    {
        this(new oo(i, j));
    }

    public nx(oo oo1)
    {
        g = oo1;
    }

    public int a()
    {
        return g.b();
    }

    public int b()
    {
        return g.a();
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof nx))
        {
            return false;
        } else
        {
            obj = (nx)obj;
            return g.equals(((nx) (obj)).g);
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
