// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.ExecutionException;

public class boc
{

    private final bxo a;
    private final mh b;
    private Class c;

    public boc(bxo bxo1, mh mh1, Class class1)
    {
        a = (bxo)b.a(bxo1);
        b = (mh)b.a(mh1);
        c = (Class)b.a(class1);
    }

    public final eun a(bxi bxi1)
    {
        b.b();
        crf crf1 = crf.a();
        a(bxi1, ((mj) (crf1)));
        try
        {
            bxi1 = (eun)crf1.get();
        }
        // Misplaced declaration of an exception variable
        catch (bxi bxi1)
        {
            throw new bou(bxi1);
        }
        // Misplaced declaration of an exception variable
        catch (bxi bxi1)
        {
            throw new bou(bxi1);
        }
        return bxi1;
    }

    public final void a(bxi bxi1, mj mj)
    {
        boolean flag;
        if (bxi1.h == bxj.b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            b.d().a(bxi1.c(), true);
        }
        b.a(a.a(bxi1, c, mj));
    }
}
