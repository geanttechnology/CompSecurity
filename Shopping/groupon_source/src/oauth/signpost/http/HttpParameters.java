// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package oauth.signpost.http;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import oauth.signpost.OAuth;

public class HttpParameters
    implements Serializable, Map
{

    private TreeMap wrappedMap;

    public HttpParameters()
    {
        wrappedMap = new TreeMap();
    }

    public void clear()
    {
        wrappedMap.clear();
    }

    public boolean containsKey(Object obj)
    {
        return wrappedMap.containsKey(obj);
    }

    public boolean containsValue(Object obj)
    {
        for (Iterator iterator = wrappedMap.values().iterator(); iterator.hasNext();)
        {
            if (((SortedSet)iterator.next()).contains(obj))
            {
                return true;
            }
        }

        return false;
    }

    public Set entrySet()
    {
        return wrappedMap.entrySet();
    }

    public volatile Object get(Object obj)
    {
        return get(obj);
    }

    public SortedSet get(Object obj)
    {
        return (SortedSet)wrappedMap.get(obj);
    }

    public String getFirst(Object obj)
    {
        return getFirst(obj, false);
    }

    public String getFirst(Object obj, boolean flag)
    {
        obj = (SortedSet)wrappedMap.get(obj);
        if (obj == null || ((SortedSet) (obj)).isEmpty())
        {
            obj = null;
        } else
        {
            String s = (String)((SortedSet) (obj)).first();
            obj = s;
            if (flag)
            {
                return OAuth.percentDecode(s);
            }
        }
        return ((String) (obj));
    }

    public boolean isEmpty()
    {
        return wrappedMap.isEmpty();
    }

    public Set keySet()
    {
        return wrappedMap.keySet();
    }

    public volatile Object put(Object obj, Object obj1)
    {
        return put((String)obj, (SortedSet)obj1);
    }

    public String put(String s, String s1)
    {
        return put(s, s1, false);
    }

    public String put(String s, String s1, boolean flag)
    {
        SortedSet sortedset = (SortedSet)wrappedMap.get(s);
        Object obj = sortedset;
        if (sortedset == null)
        {
            TreeSet treeset = new TreeSet();
            TreeMap treemap = wrappedMap;
            obj = s;
            if (flag)
            {
                obj = OAuth.percentEncode(s);
            }
            treemap.put(obj, treeset);
            obj = treeset;
        }
        s = s1;
        if (s1 != null)
        {
            s = s1;
            if (flag)
            {
                s = OAuth.percentEncode(s1);
            }
            ((SortedSet) (obj)).add(s);
        }
        return s;
    }

    public SortedSet put(String s, SortedSet sortedset)
    {
        return (SortedSet)wrappedMap.put(s, sortedset);
    }

    public void putAll(Map map)
    {
        wrappedMap.putAll(map);
    }

    public volatile Object remove(Object obj)
    {
        return remove(obj);
    }

    public SortedSet remove(Object obj)
    {
        return (SortedSet)wrappedMap.remove(obj);
    }

    public int size()
    {
        int i = 0;
        for (Iterator iterator = wrappedMap.keySet().iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            i += ((SortedSet)wrappedMap.get(s)).size();
        }

        return i;
    }

    public Collection values()
    {
        return wrappedMap.values();
    }
}
