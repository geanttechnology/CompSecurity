// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cec extends Enum
{

    public static final cec a;
    public static final cec b;
    public static final cec c;
    private static final cec d[];

    private cec(String s, int i)
    {
        super(s, i);
    }

    public static cec valueOf(String s)
    {
        return (cec)Enum.valueOf(cec, s);
    }

    public static cec[] values()
    {
        return (cec[])d.clone();
    }

    static 
    {
        a = new cec("MALE", 0);
        b = new cec("FEMALE", 1);
        c = new cec("UNKNOWN", 2);
        d = (new cec[] {
            a, b, c
        });
    }
}
