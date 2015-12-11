// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;


public final class dn extends Enum
{

    public static final dn a;
    public static final dn b;
    private static final dn c[];

    private dn(String s, int i)
    {
        super(s, i);
    }

    public static dn valueOf(String s)
    {
        return (dn)Enum.valueOf(netswipe/dn, s);
    }

    public static dn[] values()
    {
        return (dn[])c.clone();
    }

    static 
    {
        a = new dn("STRICT", 0);
        b = new dn("BROWSER_COMPATIBLE", 1);
        c = (new dn[] {
            a, b
        });
    }
}
