// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class bvm
{

    private final int a;
    private final bvi b;
    private final bvl c;

    public bvm(int i, bvi bvi1, bvl bvl)
    {
        a = i;
        b = bvi1;
        c = bvl;
    }

    public bvm(bvi bvi1, bvl bvl)
    {
        this(0, bvi1, bvl);
    }

    public long a()
    {
        return b.getDelayMillis(a);
    }

    public bvm b()
    {
        return new bvm(a + 1, b, c);
    }

    public bvm c()
    {
        return new bvm(b, c);
    }
}
