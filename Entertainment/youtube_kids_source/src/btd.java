// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class btd extends bqg
    implements bnj, bvz
{

    private final dvc a;
    private final bvz b;

    public btd(dvc dvc1, String s, boolean flag, bvz bvz1)
    {
        a = (dvc)b.a(dvc1);
        b = bvz1;
        dvc1 = dvc1.b;
        int j = dvc1.length;
        int i = 0;
        do
        {
label0:
            {
                if (i < j)
                {
                    s = dvc1[i];
                    if (((dfq) (s)).b == null)
                    {
                        break label0;
                    }
                    dvc1 = ((dfq) (s)).b;
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
        return a.c;
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
