// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Serializable;
import java.util.Iterator;

class eil
    implements Serializable
{

    private static final long serialVersionUID = 0L;
    private final Object a[];
    private final Object b[];

    eil(eij eij1)
    {
        a = new Object[eij1.size()];
        b = new Object[eij1.size()];
        eij1 = eij1.b().iterator();
        for (int i = 0; eij1.hasNext(); i++)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)eij1.next();
            a[i] = entry.getKey();
            b[i] = entry.getValue();
        }

    }

    final Object a(eik eik1)
    {
        for (int i = 0; i < a.length; i++)
        {
            eik1.a(a[i], b[i]);
        }

        return eik1.a();
    }

    Object readResolve()
    {
        return a(new eik());
    }
}
