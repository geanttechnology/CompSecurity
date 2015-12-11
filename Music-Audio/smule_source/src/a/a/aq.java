// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;


public final class aq extends Enum
{

    public static final aq a;
    public static final aq b;
    private static final aq d[];
    private String c;

    private aq(String s, int i, String s1)
    {
        super(s, i);
        c = s1;
    }

    public static aq valueOf(String s)
    {
        return (aq)Enum.valueOf(a/a/aq, s);
    }

    public static aq[] values()
    {
        return (aq[])d.clone();
    }

    public final String a()
    {
        return c;
    }

    static 
    {
        a = new aq("FOREGROUND", 0, "foregrounded");
        b = new aq("BACKGROUND", 1, "backgrounded");
        d = (new aq[] {
            a, b
        });
    }
}
