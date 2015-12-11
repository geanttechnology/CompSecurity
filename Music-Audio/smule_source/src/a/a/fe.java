// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;


public final class fe extends Enum
{

    public static final fe a;
    public static final fe b;
    public static final fe c;
    private static final fe d[];

    private fe(String s, int i)
    {
        super(s, i);
    }

    public static fe valueOf(String s)
    {
        return (fe)Enum.valueOf(a/a/fe, s);
    }

    public static fe[] values()
    {
        return (fe[])d.clone();
    }

    static 
    {
        a = new fe("SOCKET_MONITOR", 0);
        b = new fe("STREAM_MONITOR", 1);
        c = new fe("NONE", 2);
        d = (new fe[] {
            a, b, c
        });
    }
}
