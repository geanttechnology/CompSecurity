// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bta extends bqg
    implements bnj, bvz
{

    public final duu a;
    public btu b;
    private final bvz c;

    public bta(duu duu1, float f, bvz bvz1)
    {
        a = (duu)b.a(duu1);
        c = bvz1;
        duu1 = duu1.j;
        int j = duu1.length;
        int i = 0;
        do
        {
label0:
            {
                if (i < j)
                {
                    bvz1 = duu1[i];
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
        return a.i;
    }

    public final bvz b()
    {
        return c;
    }

    public final dre c()
    {
        return a.f;
    }
}
