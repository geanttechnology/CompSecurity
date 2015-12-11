// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;


public final class ct extends Enum
{

    public static final ct a;
    public static final ct b;
    private static final ct c[];

    private ct(String s, int i)
    {
        super(s, i);
    }

    public static ct valueOf(String s)
    {
        return (ct)Enum.valueOf(a/a/ct, s);
    }

    public static ct[] values()
    {
        return (ct[])c.clone();
    }

    static 
    {
        a = new ct("NORMAL", 0);
        b = new ct("URGENT", 1);
        c = (new ct[] {
            a, b
        });
    }
}
