// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


public final class aiv extends Enum
{

    public static final aiv a;
    public static final aiv b;
    public static final aiv c;
    private static final aiv d[];

    private aiv(String s, int i)
    {
        super(s, i);
    }

    public static aiv valueOf(String s)
    {
        return (aiv)Enum.valueOf(android/support/v7/aiv, s);
    }

    public static aiv[] values()
    {
        return (aiv[])d.clone();
    }

    static 
    {
        a = new aiv("NETWORK", 0);
        b = new aiv("DISC_CACHE", 1);
        c = new aiv("MEMORY_CACHE", 2);
        d = (new aiv[] {
            a, b, c
        });
    }
}
