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
    implements Map, Serializable
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

    public String getAsHeaderElement(String s)
    {
        String s1 = getFirst(s);
        if (s1 == null)
        {
            return null;
        } else
        {
            return (new StringBuilder()).append(s).append("=\"").append(s1).append("\"").toString();
        }
    }

    public String getAsQueryString(Object obj)
    {
        return getAsQueryString(obj, true);
    }

    public String getAsQueryString(Object obj, boolean flag)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Object obj1 = obj;
        if (flag)
        {
            obj1 = OAuth.percentEncode((String)obj);
        }
        obj = (Set)wrappedMap.get(obj1);
        if (obj == null)
        {
            return (new StringBuilder()).append(obj1).append("=").toString();
        }
        obj = ((Set) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            stringbuilder.append((new StringBuilder()).append(obj1).append("=").append((String)((Iterator) (obj)).next()).toString());
            if (((Iterator) (obj)).hasNext())
            {
                stringbuilder.append("&");
            }
        } while (true);
        return stringbuilder.toString();
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

    public HttpParameters getOAuthParameters()
    {
        HttpParameters httpparameters = new HttpParameters();
        Iterator iterator = entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            String s = (String)entry.getKey();
            if (s.startsWith("oauth_") || s.startsWith("x_oauth_"))
            {
                httpparameters.put(s, (SortedSet)entry.getValue());
            }
        } while (true);
        return httpparameters;
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
        String s2 = s;
        if (flag)
        {
            s2 = OAuth.percentEncode(s);
        }
        s = (SortedSet)wrappedMap.get(s2);
        Object obj = s;
        if (s == null)
        {
            obj = new TreeSet();
            wrappedMap.put(s2, obj);
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

    public SortedSet put(String s, SortedSet sortedset, boolean flag)
    {
        if (flag)
        {
            remove(s);
            for (sortedset = sortedset.iterator(); sortedset.hasNext(); put(s, (String)sortedset.next(), true)) { }
            return get(s);
        } else
        {
            return (SortedSet)wrappedMap.put(s, sortedset);
        }
    }

    public void putAll(Map map)
    {
        wrappedMap.putAll(map);
    }

    public void putAll(Map map, boolean flag)
    {
        if (flag)
        {
            String s;
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); put(s, (SortedSet)map.get(s), true))
            {
                s = (String)iterator.next();
            }

        } else
        {
            wrappedMap.putAll(map);
        }
    }

    public void putAll(String as[], boolean flag)
    {
        for (int i = 0; i < as.length - 1; i += 2)
        {
            put(as[i], as[i + 1], flag);
        }

    }

    public void putMap(Map map)
    {
        Object obj;
        String s;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); ((SortedSet) (obj)).addAll((Collection)map.get(s)))
        {
            s = (String)iterator.next();
            SortedSet sortedset = get(s);
            obj = sortedset;
            if (sortedset == null)
            {
                obj = new TreeSet();
                put(s, ((SortedSet) (obj)));
            }
        }

    }

    public String putNull(String s, String s1)
    {
        return put(s, s1);
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
