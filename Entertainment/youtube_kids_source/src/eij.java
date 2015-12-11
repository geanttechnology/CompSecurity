// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Serializable;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class eij
    implements Serializable, Map
{

    private transient eiu a;
    private transient eiu b;
    private transient ehr c;

    eij()
    {
    }

    public static eij a(Map map)
    {
        int i = 0;
        if ((map instanceof eij) && !(map instanceof eiz))
        {
            eij eij1 = (eij)map;
            if (!eij1.e())
            {
                return eij1;
            }
        } else
        if (map instanceof EnumMap)
        {
            map = (EnumMap)map;
            java.util.Map.Entry entry;
            for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); f.b(entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
                f.b(entry.getKey());
            }

            map = new EnumMap(map);
            Object obj;
            switch (map.size())
            {
            default:
                return new ehx(map);

            case 0: // '\0'
                return ehe.a;

            case 1: // '\001'
                obj = (java.util.Map.Entry)a.b(map.entrySet());
                break;
            }
            map = ((Map) (((java.util.Map.Entry) (obj)).getKey()));
            obj = ((java.util.Map.Entry) (obj)).getValue();
            f.a(map, "null key in entry: null=%s", new Object[] {
                obj
            });
            f.a(obj, "null value in entry: %s=null", new Object[] {
                map
            });
            return new ekx(map, obj);
        }
        map = (java.util.Map.Entry[])map.entrySet().toArray(new java.util.Map.Entry[0]);
        switch (map.length)
        {
        default:
            for (; i < map.length; i++)
            {
                map[i] = a(map[i].getKey(), map[i].getValue());
            }

            break;

        case 0: // '\0'
            return ehe.a;

        case 1: // '\001'
            return new ekx(a(map[0].getKey(), map[0].getValue()));
        }
        return new ekm(map);
    }

    static java.util.Map.Entry a(Object obj, Object obj1)
    {
        f.a(obj, "null key in entry: null=%s", new Object[] {
            obj1
        });
        f.a(obj1, "null value in entry: %s=null", new Object[] {
            obj
        });
        return ejr.a(obj, obj1);
    }

    public static eij g()
    {
        return ehe.a;
    }

    eiu a()
    {
        return new eio(this);
    }

    public eiu b()
    {
        eiu eiu2 = a;
        eiu eiu1 = eiu2;
        if (eiu2 == null)
        {
            eiu1 = c();
            a = eiu1;
        }
        return eiu1;
    }

    abstract eiu c();

    public final void clear()
    {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(Object obj)
    {
        return get(obj) != null;
    }

    public boolean containsValue(Object obj)
    {
        return obj != null && ejr.e(this, obj);
    }

    public eiu d()
    {
        eiu eiu2 = b;
        eiu eiu1 = eiu2;
        if (eiu2 == null)
        {
            eiu1 = a();
            b = eiu1;
        }
        return eiu1;
    }

    abstract boolean e();

    public Set entrySet()
    {
        return b();
    }

    public boolean equals(Object obj)
    {
        return ejr.d(this, obj);
    }

    public ehr f()
    {
        ehr ehr = c;
        Object obj = ehr;
        if (ehr == null)
        {
            obj = new eir(this);
            c = ((ehr) (obj));
        }
        return ((ehr) (obj));
    }

    public abstract Object get(Object obj);

    public int hashCode()
    {
        return b().hashCode();
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public Set keySet()
    {
        return d();
    }

    public final Object put(Object obj, Object obj1)
    {
        throw new UnsupportedOperationException();
    }

    public final void putAll(Map map)
    {
        throw new UnsupportedOperationException();
    }

    public final Object remove(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public String toString()
    {
        return ejr.a(this);
    }

    public Collection values()
    {
        return f();
    }

    Object writeReplace()
    {
        return new eil(this);
    }
}
