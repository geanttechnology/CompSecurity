// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class js
{

    private static js g;
    private final Map a;
    private final Map b;
    private final Map c;
    private final String d;
    private final String e;
    private final String f;

    js(Map map, Map map1, Map map2, String s, String s1, String s2)
    {
        a = map;
        b = map1;
        c = map2;
        d = s;
        e = s1;
        f = s2;
    }

    public static js a()
    {
        android/support/v7/js;
        JVM INSTR monitorenter ;
        js js1;
        if (g == null)
        {
            g = b();
        }
        js1 = g;
        android/support/v7/js;
        JVM INSTR monitorexit ;
        return js1;
        Exception exception;
        exception;
        throw exception;
    }

    public static js a(JSONArray jsonarray)
    {
        if (jsonarray == null)
        {
            return null;
        }
        int i = 0;
        String s = null;
        String s1 = null;
        String s2 = null;
        Map map = null;
        Map map1 = null;
        Map map3 = null;
        while (i < jsonarray.length()) 
        {
            JSONObject jsonobject = jsonarray.optJSONObject(i);
            Map map2;
            Map map4;
            Map map5;
            String s3;
            String s4;
            String s5;
            if (jsonobject == null)
            {
                s5 = s;
                s4 = s1;
                s3 = s2;
                map5 = map;
                map4 = map1;
                map2 = map3;
            } else
            {
                String s6 = jsonobject.optString("name");
                map2 = map3;
                map4 = map1;
                map5 = map;
                s3 = s2;
                s4 = s1;
                s5 = s;
                if (s6 != null)
                {
                    if (s6.equalsIgnoreCase("other"))
                    {
                        s3 = jsonobject.optString("recovery_message", null);
                        map2 = a(jsonobject);
                        map4 = map1;
                        map5 = map;
                        s4 = s1;
                        s5 = s;
                    } else
                    if (s6.equalsIgnoreCase("transient"))
                    {
                        s4 = jsonobject.optString("recovery_message", null);
                        map4 = a(jsonobject);
                        map2 = map3;
                        map5 = map;
                        s3 = s2;
                        s5 = s;
                    } else
                    {
                        map2 = map3;
                        map4 = map1;
                        map5 = map;
                        s3 = s2;
                        s4 = s1;
                        s5 = s;
                        if (s6.equalsIgnoreCase("login_recoverable"))
                        {
                            s5 = jsonobject.optString("recovery_message", null);
                            map5 = a(jsonobject);
                            map2 = map3;
                            map4 = map1;
                            s3 = s2;
                            s4 = s1;
                        }
                    }
                }
            }
            i++;
            map3 = map2;
            map1 = map4;
            map = map5;
            s2 = s3;
            s1 = s4;
            s = s5;
        }
        return new js(map3, map1, map, s2, s1, s);
    }

    private static Map a(JSONObject jsonobject)
    {
        JSONArray jsonarray = jsonobject.optJSONArray("items");
        if (jsonarray.length() == 0)
        {
            return null;
        }
        HashMap hashmap = new HashMap();
        int i = 0;
        while (i < jsonarray.length()) 
        {
            jsonobject = jsonarray.optJSONObject(i);
            if (jsonobject != null)
            {
                int k = jsonobject.optInt("code");
                if (k != 0)
                {
                    JSONArray jsonarray1 = jsonobject.optJSONArray("subcodes");
                    if (jsonarray1 != null && jsonarray1.length() > 0)
                    {
                        jsonobject = new HashSet();
                        for (int j = 0; j < jsonarray1.length(); j++)
                        {
                            int l = jsonarray1.optInt(j);
                            if (l != 0)
                            {
                                jsonobject.add(Integer.valueOf(l));
                            }
                        }

                    } else
                    {
                        jsonobject = null;
                    }
                    hashmap.put(Integer.valueOf(k), jsonobject);
                }
            }
            i++;
        }
        return hashmap;
    }

    private static js b()
    {
        return new js(null, new HashMap() {

            
            {
                put(Integer.valueOf(2), null);
                put(Integer.valueOf(4), null);
                put(Integer.valueOf(9), null);
                put(Integer.valueOf(17), null);
                put(Integer.valueOf(341), null);
            }
        }, new HashMap() {

            
            {
                put(Integer.valueOf(102), null);
                put(Integer.valueOf(190), null);
            }
        }, null, null, null);
    }

    public com.facebook.j.a a(int i, int j, boolean flag)
    {
        if (flag)
        {
            return com.facebook.j.a.c;
        }
        if (a != null && a.containsKey(Integer.valueOf(i)))
        {
            Set set = (Set)a.get(Integer.valueOf(i));
            if (set == null || set.contains(Integer.valueOf(j)))
            {
                return com.facebook.j.a.b;
            }
        }
        if (c != null && c.containsKey(Integer.valueOf(i)))
        {
            Set set1 = (Set)c.get(Integer.valueOf(i));
            if (set1 == null || set1.contains(Integer.valueOf(j)))
            {
                return com.facebook.j.a.a;
            }
        }
        if (b != null && b.containsKey(Integer.valueOf(i)))
        {
            Set set2 = (Set)b.get(Integer.valueOf(i));
            if (set2 == null || set2.contains(Integer.valueOf(j)))
            {
                return com.facebook.j.a.c;
            }
        }
        return com.facebook.j.a.b;
    }

    public String a(com.facebook.j.a a1)
    {
        static class _cls3
        {

            static final int a[];

            static 
            {
                a = new int[com.facebook.j.a.values().length];
                try
                {
                    a[com.facebook.j.a.b.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.facebook.j.a.a.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.facebook.j.a.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls3.a[a1.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return d;

        case 2: // '\002'
            return f;

        case 3: // '\003'
            return e;
        }
    }
}
