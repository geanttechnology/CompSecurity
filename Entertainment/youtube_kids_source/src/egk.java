// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.Map;

final class egk extends ejv
{

    private egj a;

    egk(egj egj1)
    {
        a = egj1;
        super();
    }

    final Map a()
    {
        return a;
    }

    public final boolean contains(Object obj)
    {
        return ehc.a(a.a.entrySet(), obj);
    }

    public final Iterator iterator()
    {
        return new egl(a);
    }

    public final boolean remove(Object obj)
    {
        if (!contains(obj))
        {
            return false;
        } else
        {
            obj = (java.util.Map.Entry)obj;
            egi.a(a.b, ((java.util.Map.Entry) (obj)).getKey());
            return true;
        }
    }
}
