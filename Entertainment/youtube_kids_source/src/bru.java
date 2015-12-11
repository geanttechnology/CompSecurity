// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bru extends bqg
    implements bnj, bvz
{

    private final dlo a;
    private final bvz b;

    public bru(dlo dlo1, bvz bvz1)
    {
        a = (dlo)b.a(dlo1);
        b = bvz1;
        dlo1 = dlo1.c;
        int j = dlo1.length;
        int i = 0;
        do
        {
label0:
            {
                if (i < j)
                {
                    bvz1 = dlo1[i];
                    if (((dzo) (bvz1)).b == null)
                    {
                        break label0;
                    }
                    new bsi(((dzo) (bvz1)).b, this);
                }
                return;
            }
            i++;
        } while (true);
    }

    public final void a(bnk bnk1)
    {
        bnk1.a();
    }

    public final byte[] a()
    {
        return a.b;
    }

    public final bvz b()
    {
        return b;
    }

    public final dre c()
    {
        return a.a;
    }
}
