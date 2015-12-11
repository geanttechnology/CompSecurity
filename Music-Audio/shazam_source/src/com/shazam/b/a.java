// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.b;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class a
{

    private static final Map a;

    public static Object a(Class class1)
    {
        return a.get(class1);
    }

    private static void a(Map map, Class class1, Object obj)
    {
        map.put(class1, obj);
    }

    static 
    {
        HashMap hashmap = new HashMap();
        a(hashmap, Boolean.TYPE, Boolean.valueOf(false));
        a(hashmap, Character.TYPE, Character.valueOf('\0'));
        a(hashmap, Byte.TYPE, Byte.valueOf((byte)0));
        a(hashmap, Short.TYPE, Short.valueOf((short)0));
        a(hashmap, Integer.TYPE, Integer.valueOf(0));
        a(hashmap, Long.TYPE, Long.valueOf(0L));
        a(hashmap, Float.TYPE, Float.valueOf(0.0F));
        a(hashmap, Double.TYPE, Double.valueOf(0.0D));
        a = Collections.unmodifiableMap(hashmap);
    }
}
