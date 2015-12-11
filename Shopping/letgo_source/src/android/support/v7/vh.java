// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            vk, vj

public class vh extends vk
    implements Map
{

    vj a;

    public vh()
    {
    }

    private vj b()
    {
        if (a == null)
        {
            a = new vj() {

                final vh a;

                protected int a()
                {
                    return a.h;
                }

                protected int a(Object obj)
                {
                    if (obj == null)
                    {
                        return a.a();
                    } else
                    {
                        return a.a(obj, obj.hashCode());
                    }
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
                    return a.a(obj);
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
                a = vh.this;
                super();
            }
            };
        }
        return a;
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
