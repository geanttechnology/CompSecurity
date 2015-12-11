// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import com.google.a.a.g;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.a.c:
//            ae, aj, ap, bk, 
//            ag, aq

final class ab extends ae
{

    private final transient EnumMap a;

    ab(EnumMap enummap)
    {
        a = enummap;
        boolean flag;
        if (!enummap.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        g.a(flag);
    }

    static EnumMap a(ab ab1)
    {
        return ab1.a;
    }

    final aj a()
    {
        return new aj() {

            final ab a;

            public final bk a()
            {
                return ap.a(ab.a(a).keySet().iterator());
            }

            public final boolean contains(Object obj)
            {
                return ab.a(a).containsKey(obj);
            }

            final boolean e()
            {
                return true;
            }

            public final Iterator iterator()
            {
                return a();
            }

            public final int size()
            {
                return a.size();
            }

            
            {
                a = ab.this;
                super();
            }
        };
    }

    final aj c()
    {
        return new ag() {

            final ab a;

            public final bk a()
            {
                return new bk(this) {

                    final _cls2 a;
                    private final Iterator b;

                    public final boolean hasNext()
                    {
                        return b.hasNext();
                    }

                    public final Object next()
                    {
                        java.util.Map.Entry entry = (java.util.Map.Entry)b.next();
                        return aq.a(entry.getKey(), entry.getValue());
                    }

            
            {
                a = _pcls2;
                super();
                b = ab.a(a.a).entrySet().iterator();
            }
                };
            }

            final ae d()
            {
                return a;
            }

            public final Iterator iterator()
            {
                return a();
            }

            
            {
                a = ab.this;
                super();
            }
        };
    }

    public final boolean containsKey(Object obj)
    {
        return a.containsKey(obj);
    }

    final boolean e()
    {
        return false;
    }

    public final Object get(Object obj)
    {
        return a.get(obj);
    }

    public final int size()
    {
        return a.size();
    }
}
