// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class cgp
    implements Iterator
{

    private Iterator a;
    private cgo b;

    cgp(cgo cgo1)
    {
        b = cgo1;
        super();
        a = cgo.a(b).entrySet().iterator();
    }

    public final boolean hasNext()
    {
        return a.hasNext();
    }

    public final Object next()
    {
        java.util.Map.Entry entry = (java.util.Map.Entry)a.next();
        return new cgq((String)entry.getKey(), (String)entry.getValue());
    }

    public final void remove()
    {
        a.remove();
    }
}
