// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class adp
{

    public static final adp a;
    public static final adp b;
    public static final adp c;
    public static final adp d;
    public static final adp e;
    public static final adp f;
    public static final adp g;
    public static final adp h;
    public static final adp i;
    public static final adp j;
    public static final adp k;
    private static adp l[];
    private static int m = 0;
    private final int n;
    private final String o;

    private adp(String s)
    {
        o = s;
        int i1 = m;
        m = i1 + 1;
        n = i1;
    }

    public final int a()
    {
        return n;
    }

    public String toString()
    {
        return o;
    }

    static 
    {
        a = new adp("OneKeyBeauty");
        b = new adp("Quban");
        c = new adp("Soften");
        d = new adp("ClearEye");
        e = new adp("BigEye");
        f = new adp("SlimFace");
        g = new adp("SlimNose");
        h = new adp("RemoveEyebag");
        i = new adp("EnhanceNose");
        j = new adp("Makeup");
        k = new adp("MakeupManual");
        l = (new adp[] {
            a, b, c, d, e, f, g, h, i, j, 
            k
        });
    }
}
