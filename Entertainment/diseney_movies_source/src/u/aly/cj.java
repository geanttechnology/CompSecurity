// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package u.aly:
//            bz, di, dj, ca, 
//            cf, cy, dh, dg, 
//            ct, cg, dd, cz

public abstract class cj
    implements bz
{
    private static class a extends di
    {

        public volatile void a(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (cj)bz1);
        }

        public void a(cy cy1, cj cj1)
            throws cf
        {
            cj1.c = null;
            cj1.b = null;
            cy1.j();
            ct ct1 = cy1.l();
            cj1.b = cj1.a(cy1, ct1);
            if (cj1.b != null)
            {
                cj1.c = cj1.b(ct1.c);
            }
            cy1.m();
            cy1.l();
            cy1.k();
        }

        public volatile void b(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (cj)bz1);
        }

        public void b(cy cy1, cj cj1)
            throws cf
        {
            if (cj1.j() == null || cj1.k() == null)
            {
                throw new cz("Cannot write a TUnion with no set value!");
            } else
            {
                cy1.a(cj1.c());
                cy1.a(cj1.a(cj1.c));
                cj1.c(cy1);
                cy1.c();
                cy1.d();
                cy1.b();
                return;
            }
        }

        private a()
        {
        }

        a(a a1)
        {
            this();
        }
    }

    private static class b
        implements dh
    {

        public a a()
        {
            return new a(null);
        }

        public dg b()
        {
            return a();
        }

        private b()
        {
        }

        b(b b1)
        {
            this();
        }
    }

    private static class c extends dj
    {

        public volatile void a(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (cj)bz1);
        }

        public void a(cy cy1, cj cj1)
            throws cf
        {
            cj1.c = null;
            cj1.b = null;
            short word0 = cy1.v();
            cj1.b = cj1.a(cy1, word0);
            if (cj1.b != null)
            {
                cj1.c = cj1.b(word0);
            }
        }

        public volatile void b(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (cj)bz1);
        }

        public void b(cy cy1, cj cj1)
            throws cf
        {
            if (cj1.j() == null || cj1.k() == null)
            {
                throw new cz("Cannot write a TUnion with no set value!");
            } else
            {
                cy1.a(cj1.c.a());
                cj1.d(cy1);
                return;
            }
        }

        private c()
        {
        }

        c(c c1)
        {
            this();
        }
    }

    private static class d
        implements dh
    {

        public c a()
        {
            return new c(null);
        }

        public dg b()
        {
            return a();
        }

        private d()
        {
        }

        d(d d1)
        {
            this();
        }
    }


    private static final Map a;
    protected Object b;
    protected cg c;

    protected cj()
    {
        c = null;
        b = null;
    }

    protected cj(cg cg, Object obj)
    {
        b(cg, obj);
    }

    protected cj(cj cj1)
    {
        if (!cj1.getClass().equals(getClass()))
        {
            throw new ClassCastException();
        } else
        {
            c = cj1.c;
            b = a(cj1.b);
            return;
        }
    }

    private static Object a(Object obj)
    {
        Object obj1;
        if (obj instanceof bz)
        {
            obj1 = ((bz)obj).g();
        } else
        {
            if (obj instanceof ByteBuffer)
            {
                return ca.d((ByteBuffer)obj);
            }
            if (obj instanceof List)
            {
                return a((List)obj);
            }
            if (obj instanceof Set)
            {
                return a((Set)obj);
            }
            obj1 = obj;
            if (obj instanceof Map)
            {
                return a((Map)obj);
            }
        }
        return obj1;
    }

    private static List a(List list)
    {
        ArrayList arraylist = new ArrayList(list.size());
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                return arraylist;
            }
            arraylist.add(a(list.next()));
        } while (true);
    }

    private static Map a(Map map)
    {
        HashMap hashmap = new HashMap();
        map = map.entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                return hashmap;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            hashmap.put(a(entry.getKey()), a(entry.getValue()));
        } while (true);
    }

    private static Set a(Set set)
    {
        HashSet hashset = new HashSet();
        set = set.iterator();
        do
        {
            if (!set.hasNext())
            {
                return hashset;
            }
            hashset.add(a(set.next()));
        } while (true);
    }

    protected abstract Object a(cy cy1, ct ct1)
        throws cf;

    protected abstract Object a(cy cy1, short word0)
        throws cf;

    protected abstract ct a(cg cg);

    public void a(int i, Object obj)
    {
        b(b((short)i), obj);
    }

    protected abstract void a(cg cg, Object obj)
        throws ClassCastException;

    public void a(cy cy1)
        throws cf
    {
        ((dh)a.get(cy1.D())).b().a(cy1, this);
    }

    public Object b(cg cg)
    {
        if (cg != c)
        {
            throw new IllegalArgumentException((new StringBuilder("Cannot get the value of field ")).append(cg).append(" because union's set field is ").append(c).toString());
        } else
        {
            return k();
        }
    }

    protected abstract cg b(short word0);

    public final void b()
    {
        c = null;
        b = null;
    }

    public void b(cg cg, Object obj)
    {
        a(cg, obj);
        c = cg;
        b = obj;
    }

    public void b(cy cy1)
        throws cf
    {
        ((dh)a.get(cy1.D())).b().b(cy1, this);
    }

    public Object c(int i)
    {
        return b(b((short)i));
    }

    protected abstract dd c();

    protected abstract void c(cy cy1)
        throws cf;

    public boolean c(cg cg)
    {
        return c == cg;
    }

    protected abstract void d(cy cy1)
        throws cf;

    public boolean d(int i)
    {
        return c(b((short)i));
    }

    public cg j()
    {
        return c;
    }

    public Object k()
    {
        return b;
    }

    public boolean l()
    {
        return c != null;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("<");
        stringbuilder.append(getClass().getSimpleName());
        stringbuilder.append(" ");
        if (j() != null)
        {
            Object obj = k();
            stringbuilder.append(a(j()).a);
            stringbuilder.append(":");
            if (obj instanceof ByteBuffer)
            {
                ca.a((ByteBuffer)obj, stringbuilder);
            } else
            {
                stringbuilder.append(obj.toString());
            }
        }
        stringbuilder.append(">");
        return stringbuilder.toString();
    }

    static 
    {
        a = new HashMap();
        a.put(u/aly/di, new b(null));
        a.put(u/aly/dj, new d(null));
    }
}
