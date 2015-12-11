// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collection;
import java.util.Iterator;

final class egn
    implements Iterator
{

    private java.util.Map.Entry a;
    private Iterator b;
    private egm c;

    egn(egm egm1, Iterator iterator)
    {
        c = egm1;
        b = iterator;
        super();
    }

    public final boolean hasNext()
    {
        return b.hasNext();
    }

    public final Object next()
    {
        a = (java.util.Map.Entry)b.next();
        return a.getKey();
    }

    public final void remove()
    {
        Collection collection;
        boolean flag;
        if (a != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ejj.a(flag);
        collection = (Collection)a.getValue();
        b.remove();
        egi.b(c.b, collection.size());
        collection.clear();
    }
}
