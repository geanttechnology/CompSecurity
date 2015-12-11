// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.List;

public abstract class btq
    implements bnj, bsn, bvz
{

    private final dxz a;
    private final bvz b;

    public btq(dxz dxz1, bvz bvz1)
    {
        a = (dxz)b.a(dxz1);
        b = bvz1;
    }

    public final void a(bnk bnk1)
    {
        bnk1.a();
        Iterator iterator = d().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = iterator.next();
            if (obj instanceof bnj)
            {
                ((bnj)obj).a(bnk1);
            }
        } while (true);
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

    public abstract List d();
}
