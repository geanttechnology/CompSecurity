// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.d:
//            id, ic

public class ia extends id
    implements Map
{

    ic a;

    public ia()
    {
    }

    private ic b()
    {
        if (a == null)
        {
            a = new ic() {

                final ia a;

                protected final int a()
                {
                    return a.h;
                }

                protected final int a(Object obj)
                {
                    if (obj == null)
                    {
                        return a.a();
                    } else
                    {
                        return a.a(obj, obj.hashCode());
                    }
                }

                protected final Object a(int i, int j)
                {
                    return a.g[(i << 1) + j];
                }

                protected final Object a(int i, Object obj)
                {
                    ia ia1 = a;
                    i = (i << 1) + 1;
                    Object obj1 = ((id) (ia1)).g[i];
                    ((id) (ia1)).g[i] = obj;
                    return obj1;
                }

                protected final void a(int i)
                {
                    a.d(i);
                }

                protected final void a(Object obj, Object obj1)
                {
                    a.put(obj, obj1);
                }

                protected final int b(Object obj)
                {
                    return a.a(obj);
                }

                protected final Map b()
                {
                    return a;
                }

                protected final void c()
                {
                    a.clear();
                }

            
            {
                a = ia.this;
                super();
            }
            };
        }
        return a;
    }

    public Set entrySet()
    {
        ic ic1 = b();
        if (ic1.b == null)
        {
            ic1.b = new ic.b(ic1);
        }
        return ic1.b;
    }

    public Set keySet()
    {
        ic ic1 = b();
        if (ic1.c == null)
        {
            ic1.c = new ic.c(ic1);
        }
        return ic1.c;
    }

    public void putAll(Map map)
    {
        int i = h + map.size();
        if (super.f.length < i)
        {
            int ai[] = super.f;
            Object aobj[] = super.g;
            super.a(i);
            if (super.h > 0)
            {
                System.arraycopy(ai, 0, super.f, 0, super.h);
                System.arraycopy(((Object) (aobj)), 0, ((Object) (super.g)), 0, super.h << 1);
            }
            id.a(ai, aobj, super.h);
        }
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); put(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

    }

    public Collection values()
    {
        ic ic1 = b();
        if (ic1.d == null)
        {
            ic1.d = new ic.e(ic1);
        }
        return ic1.d;
    }
}
