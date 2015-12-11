// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class brg extends bqg
    implements bnj, bvz
{

    public final dii a;
    public CharSequence b;
    public CharSequence c;
    public btu d;
    private final bvz e;

    public brg(dii dii1, bvz bvz1)
    {
        a = (dii)b.a(dii1);
        e = bvz1;
        dii1 = dii1.f;
        int j = dii1.length;
        int i = 0;
        do
        {
label0:
            {
                if (i < j)
                {
                    bvz1 = dii1[i];
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
        return a.e;
    }

    public final bvz b()
    {
        return e;
    }

    public final dre c()
    {
        return a.d;
    }
}
