// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cnc extends Enum
{

    public static final cnc a;
    public static final cnc b;
    private static final cnc c[];

    private cnc(String s, int i)
    {
        super(s, i);
    }

    public static cnc valueOf(String s)
    {
        return (cnc)Enum.valueOf(cnc, s);
    }

    public static cnc[] values()
    {
        return (cnc[])c.clone();
    }

    static 
    {
        a = new cnc("NONE", 0);
        b = new cnc("LINEAR_TOKEN_BUCKET", 1);
        c = (new cnc[] {
            a, b
        });
    }
}
