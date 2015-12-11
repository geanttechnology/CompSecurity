// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.g;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v4.g:
//            l, b, f, h, 
//            i, k

public class a extends l
    implements Map
{

    private f c;

    public a()
    {
    }

    private f a()
    {
        if (c == null)
        {
            c = new b(this);
        }
        return c;
    }

    public final boolean a(Collection collection)
    {
        return f.a(this, collection);
    }

    public Set entrySet()
    {
        f f1 = a();
        if (f1.a == null)
        {
            f1.a = new h(f1);
        }
        return f1.a;
    }

    public Set keySet()
    {
        f f1 = a();
        if (f1.b == null)
        {
            f1.b = new i(f1);
        }
        return f1.b;
    }

    public void putAll(Map map)
    {
        a(b + map.size());
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); put(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

    }

    public Collection values()
    {
        f f1 = a();
        if (f1.c == null)
        {
            f1.c = new k(f1);
        }
        return f1.c;
    }
}
