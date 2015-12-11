// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bge extends Enum
{

    public static final bge a;
    public static final bge b;
    public static final bge c;
    public static final bge d;
    private static final bge e[];

    private bge(String s, int i)
    {
        super(s, i);
    }

    public static bge valueOf(String s)
    {
        return (bge)Enum.valueOf(bge, s);
    }

    public static bge[] values()
    {
        return (bge[])e.clone();
    }

    static 
    {
        a = new bge("START", 0);
        b = new bge("END", 1);
        c = new bge("ERROR", 2);
        d = new bge("UNKNOWN", 3);
        e = (new bge[] {
            a, b, c, d
        });
    }
}
