// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bqv
    implements bnj, bvz
{

    public final dfx a;
    public List b;
    private List c;
    private Object d;

    public bqv(dfx dfx1)
    {
        a = dfx1;
    }

    public final void a(bnk bnk1)
    {
        bnk1.a();
        Object obj = d();
        if (obj instanceof bnj)
        {
            ((bnj)obj).a(bnk1);
        }
        obj = c();
        if (obj != null)
        {
            ((btk) (obj)).a(bnk1);
        }
        if (c == null)
        {
            c = new ArrayList();
            Object obj1 = a.a;
            if (obj1 != null)
            {
                obj1 = ((dfy) (obj1)).b;
                if (obj1 != null)
                {
                    dfz adfz[] = ((dyk) (obj1)).a;
                    int j = adfz.length;
                    for (int i = 0; i < j; i++)
                    {
                        dfz dfz1 = adfz[i];
                        if (dfz1.b != null)
                        {
                            c.add(new bts(dfz1.b));
                        }
                    }

                }
            }
        }
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((bts)iterator.next()).a(bnk1)) { }
    }

    public final byte[] a()
    {
        return a.d;
    }

    public final bvz b()
    {
        return null;
    }

    public final btk c()
    {
        dfy dfy1;
        for (dfy1 = a.a; dfy1 == null || dfy1.a == null;)
        {
            return null;
        }

        return new btk(dfy1.a);
    }

    public final Object d()
    {
        if (d != null || a.c == null) goto _L2; else goto _L1
_L1:
        dfv dfv1 = a.c;
        if (dfv1.a == null) goto _L4; else goto _L3
_L3:
        d = new bqx(dfv1.a);
_L2:
        return d;
_L4:
        if (dfv1.b != null)
        {
            d = new bro(dfv1.b);
        } else
        if (dfv1.c != null)
        {
            d = new bsy(dfv1.c);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }
}
