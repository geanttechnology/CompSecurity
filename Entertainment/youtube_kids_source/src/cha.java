// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public class cha
    implements chl
{

    private static final String a = cha.getCanonicalName();
    private final Executor b;
    private final Executor c;
    private final s d;
    private final chl e;
    private final bn f = new chd(this);
    private final Map g = new HashMap();
    private final Set h = new HashSet();

    public cha(Executor executor, Executor executor1, s s1, chl chl1)
    {
        b = (Executor)b.a(executor);
        c = (Executor)b.a(executor1);
        d = (s)b.a(s1);
        e = (chl)b.a(chl1);
    }

    static chl a(cha cha1)
    {
        return cha1.e;
    }

    static String a()
    {
        return a;
    }

    static void a(cha cha1, Set set, Set set1)
    {
        set1 = set1.iterator();
        do
        {
            if (!set1.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)set1.next();
            s s1 = cha1.d;
            entry.getKey();
            if (s1.b())
            {
                Object obj1 = a;
                obj1 = String.valueOf(entry.getKey());
                (new StringBuilder(String.valueOf(obj1).length() + 13)).append("Unsubscribe: ").append(((String) (obj1)));
                obj1 = cha1.d;
                entry.getKey();
            }
        } while (true);
        set1 = set.iterator();
        do
        {
            if (!set1.hasNext())
            {
                break;
            }
            Object obj = (java.util.Map.Entry)set1.next();
            s s2 = cha1.d;
            ((java.util.Map.Entry) (obj)).getKey();
            if (!s2.b())
            {
                Object obj2 = a;
                obj2 = String.valueOf(((java.util.Map.Entry) (obj)).getKey());
                (new StringBuilder(String.valueOf(obj2).length() + 11)).append("Subscribe: ").append(((String) (obj2)));
                obj2 = cha1.d;
                ((java.util.Map.Entry) (obj)).getKey();
                obj = cha1.f;
            }
        } while (true);
        if (!set.isEmpty())
        {
            set = cha1.g.values();
            if (!set.isEmpty())
            {
                set1 = a;
                cha1.c.execute(new chc(cha1, set));
            }
        }
    }

    static Set b(cha cha1)
    {
        return cha1.h;
    }

    public final Map a(Collection collection)
    {
        HashMap hashmap = new HashMap();
        Object obj1 = collection.iterator();
        while (((Iterator) (obj1)).hasNext()) 
        {
            cgc cgc2 = (cgc)((Iterator) (obj1)).next();
            String s1 = String.valueOf(cgc2.c.toString());
            if (s1.length() != 0)
            {
                s1 = "o2:".concat(s1);
            } else
            {
                s1 = new String("o2:");
            }
            hashmap.put(new ena(1069, s1.getBytes()), cgc2);
        }
        Object obj = new HashSet(hashmap.entrySet());
        ((Set) (obj)).removeAll(g.entrySet());
        obj1 = new HashSet(g.entrySet());
        ((Set) (obj1)).removeAll(hashmap.entrySet());
        g.clear();
        g.putAll(hashmap);
        java.util.Map.Entry entry;
        for (Iterator iterator = ((Set) (obj1)).iterator(); iterator.hasNext(); h.remove(entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        b.execute(new chb(this, ((Set) (obj)), ((Set) (obj1))));
        obj = new HashMap();
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            cgc cgc1 = (cgc)collection.next();
            if (h.contains(cgc1))
            {
                ((Map) (obj)).put(cgc1, Boolean.valueOf(true));
            }
        } while (true);
        return ((Map) (obj));
    }

}
