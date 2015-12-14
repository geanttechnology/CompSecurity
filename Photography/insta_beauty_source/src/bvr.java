// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Comparator;

class bvr
    implements Comparator
{

    final bvq a;

    bvr(bvq bvq)
    {
        a = bvq;
        super();
    }

    public int a(bvs bvs1, bvs bvs2)
    {
        return (int)(bvs1.b - bvs2.b);
    }

    public int compare(Object obj, Object obj1)
    {
        return a((bvs)obj, (bvs)obj1);
    }
}
