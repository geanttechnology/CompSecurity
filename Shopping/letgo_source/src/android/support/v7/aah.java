// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package android.support.v7:
//            abo

public class aah
{
    static final class a
    {

        public final String a;
        public final Object b;

        public boolean equals(Object obj)
        {
            if (obj instanceof a)
            {
                if (a.equals(((a) (obj = (a)obj)).a) && b.equals(((a) (obj)).b))
                {
                    return true;
                }
            }
            return false;
        }

        public int hashCode()
        {
            return Arrays.hashCode(new Integer[] {
                Integer.valueOf(a.hashCode()), Integer.valueOf(b.hashCode())
            });
        }

        public String toString()
        {
            return (new StringBuilder()).append("Key: ").append(a).append(" value: ").append(b.toString()).toString();
        }

        a(String s, Object obj)
        {
            a = s;
            b = obj;
        }
    }

    static interface b
    {

        public abstract void a(Map map);
    }

    static interface c
    {

        public abstract void a(a a1);

        public abstract void a(String s);

        public abstract void a(List list, long l);
    }

    public static interface c.a
    {

        public abstract void a(List list);
    }


    public static final Object a = new Object();
    static final String b[] = "gtm.lifetime".toString().split("\\.");
    private static final Pattern c = Pattern.compile("(\\d+)\\s*([smhd]?)");
    private final ConcurrentHashMap d;
    private final Map e;
    private final ReentrantLock f;
    private final LinkedList g;
    private final c h;
    private final CountDownLatch i;

    aah()
    {
        this(new c() {

            public void a(c.a a1)
            {
                a1.a(new ArrayList());
            }

            public void a(String s)
            {
            }

            public void a(List list, long l)
            {
            }

        });
    }

    aah(c c1)
    {
        h = c1;
        d = new ConcurrentHashMap();
        e = new HashMap();
        f = new ReentrantLock();
        g = new LinkedList();
        i = new CountDownLatch(1);
        a();
    }

    public static transient Map a(Object aobj[])
    {
        if (aobj.length % 2 != 0)
        {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        HashMap hashmap = new HashMap();
        for (int j = 0; j < aobj.length; j += 2)
        {
            if (!(aobj[j] instanceof String))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("key is not a string: ").append(aobj[j]).toString());
            }
            hashmap.put((String)aobj[j], aobj[j + 1]);
        }

        return hashmap;
    }

    static CountDownLatch a(aah aah1)
    {
        return aah1.i;
    }

    private void a()
    {
        h.a(new c.a() {

            final aah a;

            public void a(List list)
            {
                a a1;
                for (list = list.iterator(); list.hasNext(); aah.a(a, a.b(a1.a, a1.b)))
                {
                    a1 = (a)list.next();
                }

                aah.a(a).countDown();
            }

            
            {
                a = aah.this;
                super();
            }
        });
    }

    static void a(aah aah1, Map map)
    {
        aah1.b(map);
    }

    private void a(Map map, String s, Collection collection)
    {
        Iterator iterator = map.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            StringBuilder stringbuilder = (new StringBuilder()).append(s);
            if (s.length() == 0)
            {
                map = "";
            } else
            {
                map = ".";
            }
            map = stringbuilder.append(map).append((String)entry.getKey()).toString();
            if (entry.getValue() instanceof Map)
            {
                a((Map)entry.getValue(), ((String) (map)), collection);
            } else
            if (!map.equals("gtm.lifetime"))
            {
                collection.add(new a(map, entry.getValue()));
            }
        } while (true);
    }

    static Long b(String s)
    {
        Object obj = c.matcher(s);
        if (!((Matcher) (obj)).matches())
        {
            abo.c((new StringBuilder()).append("unknown _lifetime: ").append(s).toString());
            return null;
        }
        long l;
        try
        {
            l = Long.parseLong(((Matcher) (obj)).group(1));
        }
        catch (NumberFormatException numberformatexception)
        {
            abo.b((new StringBuilder()).append("illegal number in _lifetime value: ").append(s).toString());
            l = 0L;
        }
        if (l <= 0L)
        {
            abo.c((new StringBuilder()).append("non-positive _lifetime: ").append(s).toString());
            return null;
        }
        obj = ((Matcher) (obj)).group(2);
        if (((String) (obj)).length() == 0)
        {
            return Long.valueOf(l);
        }
        switch (((String) (obj)).charAt(0))
        {
        default:
            abo.b((new StringBuilder()).append("unknown units in _lifetime: ").append(s).toString());
            return null;

        case 115: // 's'
            return Long.valueOf(l * 1000L);

        case 109: // 'm'
            return Long.valueOf(l * 1000L * 60L);

        case 104: // 'h'
            return Long.valueOf(l * 1000L * 60L * 60L);

        case 100: // 'd'
            return Long.valueOf(l * 1000L * 60L * 60L * 24L);
        }
    }

    private void b()
    {
        int j = 0;
        do
        {
            Map map = (Map)g.poll();
            if (map != null)
            {
                g(map);
                j++;
                if (j > 500)
                {
                    g.clear();
                    throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
                }
            } else
            {
                return;
            }
        } while (true);
    }

    private void b(Map map)
    {
        f.lock();
        g.offer(map);
        if (f.getHoldCount() == 1)
        {
            b();
        }
        c(map);
        f.unlock();
        return;
        map;
        f.unlock();
        throw map;
    }

    private void c(Map map)
    {
        Long long1 = d(map);
        if (long1 == null)
        {
            return;
        } else
        {
            map = f(map);
            map.remove("gtm.lifetime");
            h.a(map, long1.longValue());
            return;
        }
    }

    private Long d(Map map)
    {
        map = ((Map) (e(map)));
        if (map == null)
        {
            return null;
        } else
        {
            return b(map.toString());
        }
    }

    private Object e(Map map)
    {
        String as[] = b;
        int k = as.length;
        int j = 0;
        do
        {
            Object obj;
label0:
            {
                obj = map;
                if (j < k)
                {
                    obj = as[j];
                    if (map instanceof Map)
                    {
                        break label0;
                    }
                    obj = null;
                }
                return obj;
            }
            map = ((Map) (((Map)map).get(obj)));
            j++;
        } while (true);
    }

    private List f(Map map)
    {
        ArrayList arraylist = new ArrayList();
        a(map, "", arraylist);
        return arraylist;
    }

    private void g(Map map)
    {
        Map map1 = e;
        map1;
        JVM INSTR monitorenter ;
        String s;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); a(b(s, map.get(s)), e))
        {
            s = (String)iterator.next();
        }

        break MISSING_BLOCK_LABEL_69;
        map;
        map1;
        JVM INSTR monitorexit ;
        throw map;
        map1;
        JVM INSTR monitorexit ;
        h(map);
        return;
    }

    private void h(Map map)
    {
        for (Iterator iterator = d.keySet().iterator(); iterator.hasNext(); ((b)iterator.next()).a(map)) { }
    }

    void a(b b1)
    {
        d.put(b1, Integer.valueOf(0));
    }

    void a(String s)
    {
        a(s, null);
        h.a(s);
    }

    public void a(String s, Object obj)
    {
        a(b(s, obj));
    }

    public void a(String s, Map map)
    {
        map = new HashMap(map);
        map.put("event", s);
        a(map);
    }

    void a(List list, List list1)
    {
        for (; list1.size() < list.size(); list1.add(null)) { }
        int j = 0;
        while (j < list.size()) 
        {
            Object obj = list.get(j);
            if (obj instanceof List)
            {
                if (!(list1.get(j) instanceof List))
                {
                    list1.set(j, new ArrayList());
                }
                a((List)obj, (List)list1.get(j));
            } else
            if (obj instanceof Map)
            {
                if (!(list1.get(j) instanceof Map))
                {
                    list1.set(j, new HashMap());
                }
                a((Map)obj, (Map)list1.get(j));
            } else
            if (obj != a)
            {
                list1.set(j, obj);
            }
            j++;
        }
    }

    public void a(Map map)
    {
        try
        {
            i.await();
        }
        catch (InterruptedException interruptedexception)
        {
            abo.b("DataLayer.push: unexpected InterruptedException");
        }
        b(map);
    }

    void a(Map map, Map map1)
    {
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            Object obj = map.get(s);
            if (obj instanceof List)
            {
                if (!(map1.get(s) instanceof List))
                {
                    map1.put(s, new ArrayList());
                }
                a((List)obj, (List)map1.get(s));
            } else
            if (obj instanceof Map)
            {
                if (!(map1.get(s) instanceof Map))
                {
                    map1.put(s, new HashMap());
                }
                a((Map)obj, (Map)map1.get(s));
            } else
            {
                map1.put(s, obj);
            }
        }

    }

    Map b(String s, Object obj)
    {
        HashMap hashmap = new HashMap();
        String as[] = s.toString().split("\\.");
        int j = 0;
        HashMap hashmap1;
        for (s = hashmap; j < as.length - 1; s = hashmap1)
        {
            hashmap1 = new HashMap();
            s.put(as[j], hashmap1);
            j++;
        }

        s.put(as[as.length - 1], obj);
        return hashmap;
    }

    public Object c(String s)
    {
        Map map = e;
        map;
        JVM INSTR monitorenter ;
        Object obj;
        String as[];
        int k;
        obj = e;
        as = s.split("\\.");
        k = as.length;
        int j;
        s = ((String) (obj));
        j = 0;
_L2:
        if (j >= k)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        obj = as[j];
        if (s instanceof Map)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        map;
        JVM INSTR monitorexit ;
        return null;
        s = ((String) (((Map)s).get(obj)));
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        map;
        JVM INSTR monitorexit ;
        return null;
        map;
        JVM INSTR monitorexit ;
        return s;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
        j++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public String toString()
    {
        Map map = e;
        map;
        JVM INSTR monitorenter ;
        Object obj;
        obj = new StringBuilder();
        java.util.Map.Entry entry;
        for (Iterator iterator = e.entrySet().iterator(); iterator.hasNext(); ((StringBuilder) (obj)).append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", new Object[] {
    entry.getKey(), entry.getValue()
})))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        break MISSING_BLOCK_LABEL_93;
        obj;
        map;
        JVM INSTR monitorexit ;
        throw obj;
        obj = ((StringBuilder) (obj)).toString();
        map;
        JVM INSTR monitorexit ;
        return ((String) (obj));
    }

}
