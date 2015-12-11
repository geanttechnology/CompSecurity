// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.List;

public final class bqj
{

    public final dcj a;
    public String b;
    public String c;
    public dre d;
    private final btu e;
    private btt f;

    public bqj(dcj dcj1)
    {
        a = (dcj)b.a(dcj1);
        e = new btu(dcj1.c);
    }

    public final btt a()
    {
        if (f == null && e.a())
        {
            Object obj = e;
            if (!((btu) (obj)).a())
            {
                obj = null;
            } else
            {
                obj = (btt)((btu) (obj)).a.get(((btu) (obj)).a.size() - 1);
            }
            f = ((btt) (obj));
        }
        return f;
    }
}
