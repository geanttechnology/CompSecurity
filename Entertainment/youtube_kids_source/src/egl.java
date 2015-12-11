// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class egl
    implements Iterator
{

    private Iterator a;
    private Collection b;
    private egj c;

    egl(egj egj1)
    {
        c = egj1;
        super();
        a = c.a.entrySet().iterator();
    }

    public final boolean hasNext()
    {
        return a.hasNext();
    }

    public final Object next()
    {
        java.util.Map.Entry entry = (java.util.Map.Entry)a.next();
        b = (Collection)entry.getValue();
        egj egj1 = c;
        Object obj = entry.getKey();
        return ejr.a(obj, egj1.b.a(obj, (Collection)entry.getValue()));
    }

    public final void remove()
    {
        a.remove();
        egi.b(c.b, b.size());
        b.clear();
    }
}
