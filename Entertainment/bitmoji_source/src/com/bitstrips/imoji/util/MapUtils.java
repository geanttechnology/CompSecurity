// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.util;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Map;

public class MapUtils
{

    private static final String ENTRY_SPLITTER = ",";
    private static final String PAIR_KEY_VALUE_SPLITTER = ":";

    public MapUtils()
    {
    }

    public static Map asMap(String s)
    {
        java.util.HashMap hashmap = Maps.newHashMap();
        if (!Strings.isNullOrEmpty(s))
        {
            s = getKeyValuePairs(s);
            int j = s.length;
            int i = 0;
            while (i < j) 
            {
                String as[] = getKeyValuePair(s[i]);
                hashmap.put(as[0], as[1]);
                i++;
            }
        }
        return hashmap;
    }

    private static Function converter()
    {
        return new Function() {

            public volatile Object apply(Object obj)
            {
                return apply((java.util.Map.Entry)obj);
            }

            public String apply(java.util.Map.Entry entry)
            {
                return (new StringBuilder()).append((String)entry.getKey()).append(":").append((String)entry.getValue()).toString();
            }

        };
    }

    private static String[] getKeyValuePair(String s)
    {
        return s.split(":");
    }

    private static String[] getKeyValuePairs(String s)
    {
        return s.split(",");
    }

    private static Predicate predicate()
    {
        return new Predicate() {

            public volatile boolean apply(Object obj)
            {
                return apply((java.util.Map.Entry)obj);
            }

            public boolean apply(java.util.Map.Entry entry)
            {
                return !Strings.isNullOrEmpty((String)entry.getKey()) && !Strings.isNullOrEmpty((String)entry.getValue());
            }

        };
    }

    public static String toString(Map map)
    {
        map = Lists.newArrayList(map.entrySet());
        return Joiner.on(",").join(Collections2.transform(Collections2.filter(map, predicate()), converter()));
    }
}
