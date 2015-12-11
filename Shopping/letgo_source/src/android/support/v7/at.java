// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            ba, ay

public class at extends ba
    implements Map
{

    ay a;

    public at()
    {
    }

    public at(int i)
    {
        super(i);
    }

    private ay b()
    {
        if (a == null)
        {
            a = new ay() {

                final at a;

                protected int a()
                {
                    return a.h;
                }

                protected int a(Object obj)
                {
                    return a.a(obj);
                }

                protected Object a(int i, int j)
                {
                    return a.g[(i << 1) + j];
                }

                protected Object a(int i, Object obj)
                {
                    return a.a(i, obj);
                }

                protected void a(int i)
                {
                    a.d(i);
                }

                protected void a(Object obj, Object obj1)
                {
                    a.put(obj, obj1);
                }

                protected int b(Object obj)
                {
                    return a.b(obj);
                }

                protected Map b()
                {
                    return a;
                }

                protected void c()
                {
                    a.clear();
                }

            
            {
                a = at.this;
                super();
            }
            };
        }
        return a;
    }

    public boolean a(Collection collection)
    {
        return ay.c(this, collection);
    }

    public Set entrySet()
    {
        return b().d();
    }

    public Set keySet()
    {
        return b().e();
    }

    public void putAll(Map map)
    {
        a(h + map.size());
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); put(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

    }

    public Collection values()
    {
        return b().f();
    }
}
