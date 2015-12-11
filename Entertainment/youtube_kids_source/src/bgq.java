// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Comparator;

final class bgq
    implements Comparator
{

    private bgp a;

    bgq(bgp bgp1)
    {
        a = bgp1;
        super();
    }

    public final int compare(Object obj, Object obj1)
    {
        obj = (bvg)obj;
        obj1 = (bvg)obj1;
        return ((bvg) (obj)).a(bgp.a(a).k) - ((bvg) (obj1)).a(bgp.a(a).k);
    }
}
