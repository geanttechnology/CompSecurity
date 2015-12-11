// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;


public final class ft extends Enum
{

    public static final ft a;
    public static final ft b;
    public static final ft c;
    private static final ft d[];

    private ft(String s, int i)
    {
        super(s, i);
    }

    public static ft valueOf(String s)
    {
        return (ft)Enum.valueOf(a/a/ft, s);
    }

    public static ft[] values()
    {
        return (ft[])d.clone();
    }

    static 
    {
        a = new ft("HTTP_ONLY", 0);
        b = new ft("HTTPS_ONLY", 1);
        c = new ft("ALL", 2);
        d = (new ft[] {
            a, b, c
        });
    }
}
