// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public abstract class elb extends Enum
{

    public static final elb a;
    public static final elb b;
    private static elb c;
    private static final elb d[];

    elb(String s, int i)
    {
        super(s, i);
    }

    public static elb valueOf(String s)
    {
        return (elb)Enum.valueOf(elb, s);
    }

    public static elb[] values()
    {
        return (elb[])d.clone();
    }

    public abstract int a(int i);

    static 
    {
        c = new elc("NEXT_LOWER", 0);
        a = new eld("NEXT_HIGHER", 1);
        b = new ele("INVERTED_INSERTION_INDEX", 2);
        d = (new elb[] {
            c, a, b
        });
    }
}
