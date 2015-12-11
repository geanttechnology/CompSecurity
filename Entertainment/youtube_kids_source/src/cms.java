// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cms extends Enum
{

    public static final cms a;
    public static final cms b;
    public static final cms c;
    public static final cms d;
    private static final cms e[];

    private cms(String s, int i)
    {
        super(s, i);
    }

    public static cms valueOf(String s)
    {
        return (cms)Enum.valueOf(cms, s);
    }

    public static cms[] values()
    {
        return (cms[])e.clone();
    }

    static 
    {
        a = new cms("NO_SHADER", 0);
        b = new cms("SPHERICAL", 1);
        c = new cms("STEREO3D", 2);
        d = new cms("NOOP", 3);
        e = (new cms[] {
            a, b, c, d
        });
    }
}
