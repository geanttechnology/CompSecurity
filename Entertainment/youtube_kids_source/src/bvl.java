// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;

public class bvl
{

    public bvr a;
    private int b;
    private ArrayList c;
    private ArrayList d;

    public bvl(int i)
    {
        b = i;
        c = new ArrayList();
        d = new ArrayList();
    }

    public final bvj a()
    {
        return new bvj(b, c, d, a, (byte)0);
    }

    public final bvl a(bvn bvn)
    {
        c.add(bvn);
        return this;
    }

    public final bvl a(bvv bvv)
    {
        d.add(bvv);
        return this;
    }
}
