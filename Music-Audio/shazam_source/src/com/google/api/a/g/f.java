// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.g;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.WeakHashMap;

// Referenced classes of package com.google.api.a.g:
//            w, k

public final class f
{

    private static final Map e = new WeakHashMap();
    private static final Map f = new WeakHashMap();
    final Class a;
    final boolean b;
    public final IdentityHashMap c = new IdentityHashMap();
    final List d;

    private f(Class class1, boolean flag)
    {
        a = class1;
        b = flag;
        String s;
        TreeSet treeset;
        java.lang.reflect.Field afield[];
        int i;
        int j;
        boolean flag1;
        if (!flag || !class1.isEnum())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        s = String.valueOf(String.valueOf(class1));
        w.a(flag1, (new StringBuilder(s.length() + 31)).append("cannot ignore case on an enum: ").append(s).toString());
        treeset = new TreeSet(new Comparator() {

            final f a;

            public final int compare(Object obj1, Object obj2)
            {
                obj1 = (String)obj1;
                obj2 = (String)obj2;
                if (obj1 == obj2)
                {
                    return 0;
                }
                if (obj1 == null)
                {
                    return -1;
                }
                if (obj2 == null)
                {
                    return 1;
                } else
                {
                    return ((String) (obj1)).compareTo(((String) (obj2)));
                }
            }

            
            {
                a = f.this;
                super();
            }
        });
        afield = class1.getDeclaredFields();
        j = afield.length;
        i = 0;
        while (i < j) 
        {
            java.lang.reflect.Field field = afield[i];
            k k1 = k.a(field);
            if (k1 != null)
            {
                String s1 = k1.c;
                if (flag)
                {
                    s1 = s1.toLowerCase().intern();
                }
                Object obj = (k)c.get(s1);
                String s2;
                if (obj == null)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag)
                {
                    s2 = "case-insensitive ";
                } else
                {
                    s2 = "";
                }
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = ((k) (obj)).b;
                }
                w.a(flag1, "two fields have the same %sname <%s>: %s and %s", new Object[] {
                    s2, s1, field, obj
                });
                c.put(s1, k1);
                treeset.add(s1);
            }
            i++;
        }
        class1 = class1.getSuperclass();
        if (class1 != null)
        {
            class1 = a(class1, flag);
            treeset.addAll(((f) (class1)).d);
            class1 = ((f) (class1)).c.entrySet().iterator();
            do
            {
                if (!class1.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)class1.next();
                String s3 = (String)entry.getKey();
                if (!c.containsKey(s3))
                {
                    c.put(s3, entry.getValue());
                }
            } while (true);
        }
        if (treeset.isEmpty())
        {
            class1 = Collections.emptyList();
        } else
        {
            class1 = Collections.unmodifiableList(new ArrayList(treeset));
        }
        d = class1;
    }

    public static f a(Class class1)
    {
        return a(class1, false);
    }

    public static f a(Class class1, boolean flag)
    {
        if (class1 == null)
        {
            return null;
        }
        Map map;
        f f1;
        f f2;
        if (flag)
        {
            map = f;
        } else
        {
            map = e;
        }
        map;
        JVM INSTR monitorenter ;
        f2 = (f)map.get(class1);
        f1 = f2;
        if (f2 != null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        f1 = new f(class1, flag);
        map.put(class1, f1);
        map;
        JVM INSTR monitorexit ;
        return f1;
        class1;
        map;
        JVM INSTR monitorexit ;
        throw class1;
    }

    public final k a(String s)
    {
        String s1 = s;
        if (s != null)
        {
            s1 = s;
            if (b)
            {
                s1 = s.toLowerCase();
            }
            s1 = s1.intern();
        }
        return (k)c.get(s1);
    }

}
