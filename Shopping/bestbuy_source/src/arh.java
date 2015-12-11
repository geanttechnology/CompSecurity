// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class arh extends Enum
{

    public static final arh a;
    public static final arh b;
    public static final arh c;
    private static final arh d[];

    private arh(String s, int i)
    {
        super(s, i);
    }

    public static arh[] a()
    {
        return (arh[])d.clone();
    }

    static 
    {
        a = new arh("NONE", 0);
        b = new arh("CONTAINER", 1);
        c = new arh("CONTAINER_DEBUG", 2);
        d = (new arh[] {
            a, b, c
        });
    }
}
