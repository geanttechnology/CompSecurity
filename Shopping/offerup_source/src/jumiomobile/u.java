// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


public final class u extends Enum
{

    public static final u a;
    public static final u b;
    private static final u c[];

    private u(String s, int i)
    {
        super(s, i);
    }

    public static u valueOf(String s)
    {
        return (u)Enum.valueOf(jumiomobile/u, s);
    }

    public static u[] values()
    {
        return (u[])c.clone();
    }

    static 
    {
        a = new u("FRONT", 0);
        b = new u("BACK", 1);
        c = (new u[] {
            a, b
        });
    }
}
