// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.b;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class k
{

    private static k g;
    public final Map a;
    public final Map b;
    public final Map c;
    public final String d;
    public final String e;
    public final String f;

    k(Map map, Map map1, Map map2, String s, String s1, String s2)
    {
        a = map;
        b = map1;
        c = map2;
        d = s;
        e = s1;
        f = s2;
    }

    public static k a()
    {
        com/facebook/b/k;
        JVM INSTR monitorenter ;
        k k1;
        if (g == null)
        {
            g = new k(null, new HashMap() {

            
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
        k1 = g;
        com/facebook/b/k;
        JVM INSTR monitorexit ;
        return k1;
        Exception exception;
        exception;
        throw exception;
    }

    static Map a(JSONObject jsonobject)
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
            if (jsonobject == null)
            {
                continue;
            }
            int l = jsonobject.optInt("code");
            if (l == 0)
            {
                continue;
            }
            JSONArray jsonarray1 = jsonobject.optJSONArray("subcodes");
            if (jsonarray1 != null && jsonarray1.length() > 0)
            {
                jsonobject = new HashSet();
                for (int j = 0; j < jsonarray1.length(); j++)
                {
                    int i1 = jsonarray1.optInt(j);
                    if (i1 != 0)
                    {
                        jsonobject.add(Integer.valueOf(i1));
                    }
                }

            } else
            {
                jsonobject = null;
            }
            hashmap.put(Integer.valueOf(l), jsonobject);
            i++;
        }
        return hashmap;
    }

    // Unreferenced inner class com/facebook/b/k$3

/* anonymous class */
    public static final class _cls3
    {

        public static final int a[];

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

}
