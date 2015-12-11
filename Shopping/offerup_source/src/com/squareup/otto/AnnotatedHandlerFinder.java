// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.otto;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// Referenced classes of package com.squareup.otto:
//            EventProducer, EventHandler, Subscribe, Produce

final class AnnotatedHandlerFinder
{

    private static final ConcurrentMap PRODUCERS_CACHE = new ConcurrentHashMap();
    private static final ConcurrentMap SUBSCRIBERS_CACHE = new ConcurrentHashMap();

    private AnnotatedHandlerFinder()
    {
    }

    static Map findAllProducers(Object obj)
    {
        Class class1 = obj.getClass();
        HashMap hashmap = new HashMap();
        Map map = (Map)PRODUCERS_CACHE.get(class1);
        Object obj1 = map;
        if (map == null)
        {
            obj1 = new HashMap();
            loadAnnotatedProducerMethods(class1, ((Map) (obj1)));
        }
        if (!((Map) (obj1)).isEmpty())
        {
            java.util.Map.Entry entry;
            EventProducer eventproducer;
            for (obj1 = ((Map) (obj1)).entrySet().iterator(); ((Iterator) (obj1)).hasNext(); hashmap.put(entry.getKey(), eventproducer))
            {
                entry = (java.util.Map.Entry)((Iterator) (obj1)).next();
                eventproducer = new EventProducer(obj, (Method)entry.getValue());
            }

        }
        return hashmap;
    }

    static Map findAllSubscribers(Object obj)
    {
        Class class1 = obj.getClass();
        HashMap hashmap = new HashMap();
        Map map = (Map)SUBSCRIBERS_CACHE.get(class1);
        Object obj1 = map;
        if (map == null)
        {
            obj1 = new HashMap();
            loadAnnotatedSubscriberMethods(class1, ((Map) (obj1)));
        }
        if (!((Map) (obj1)).isEmpty())
        {
            java.util.Map.Entry entry;
            HashSet hashset;
            for (obj1 = ((Map) (obj1)).entrySet().iterator(); ((Iterator) (obj1)).hasNext(); hashmap.put(entry.getKey(), hashset))
            {
                entry = (java.util.Map.Entry)((Iterator) (obj1)).next();
                hashset = new HashSet();
                for (Iterator iterator = ((Set)entry.getValue()).iterator(); iterator.hasNext(); hashset.add(new EventHandler(obj, (Method)iterator.next()))) { }
            }

        }
        return hashmap;
    }

    private static void loadAnnotatedMethods(Class class1, Map map, Map map1)
    {
        Method amethod[] = class1.getDeclaredMethods();
        int j = amethod.length;
        int i = 0;
        while (i < j) 
        {
            Method method = amethod[i];
            if (!method.isBridge())
            {
                if (method.isAnnotationPresent(com/squareup/otto/Subscribe))
                {
                    Class aclass[] = method.getParameterTypes();
                    if (aclass.length != 1)
                    {
                        throw new IllegalArgumentException((new StringBuilder("Method ")).append(method).append(" has @Subscribe annotation but requires ").append(aclass.length).append(" arguments.  Methods must require a single argument.").toString());
                    }
                    Class class3 = aclass[0];
                    if (class3.isInterface())
                    {
                        throw new IllegalArgumentException((new StringBuilder("Method ")).append(method).append(" has @Subscribe annotation on ").append(class3).append(" which is an interface.  Subscription must be on a concrete class type.").toString());
                    }
                    if ((method.getModifiers() & 1) == 0)
                    {
                        throw new IllegalArgumentException((new StringBuilder("Method ")).append(method).append(" has @Subscribe annotation on ").append(class3).append(" but is not 'public'.").toString());
                    }
                    Set set = (Set)map1.get(class3);
                    Object obj = set;
                    if (set == null)
                    {
                        obj = new HashSet();
                        map1.put(class3, obj);
                    }
                    ((Set) (obj)).add(method);
                } else
                if (method.isAnnotationPresent(com/squareup/otto/Produce))
                {
                    Class aclass1[] = method.getParameterTypes();
                    if (aclass1.length != 0)
                    {
                        throw new IllegalArgumentException((new StringBuilder("Method ")).append(method).append("has @Produce annotation but requires ").append(aclass1.length).append(" arguments.  Methods must require zero arguments.").toString());
                    }
                    if (method.getReturnType() == java/lang/Void)
                    {
                        throw new IllegalArgumentException((new StringBuilder("Method ")).append(method).append(" has a return type of void.  Must declare a non-void type.").toString());
                    }
                    Class class2 = method.getReturnType();
                    if (class2.isInterface())
                    {
                        throw new IllegalArgumentException((new StringBuilder("Method ")).append(method).append(" has @Produce annotation on ").append(class2).append(" which is an interface.  Producers must return a concrete class type.").toString());
                    }
                    if (class2.equals(Void.TYPE))
                    {
                        throw new IllegalArgumentException((new StringBuilder("Method ")).append(method).append(" has @Produce annotation but has no return type.").toString());
                    }
                    if ((method.getModifiers() & 1) == 0)
                    {
                        throw new IllegalArgumentException((new StringBuilder("Method ")).append(method).append(" has @Produce annotation on ").append(class2).append(" but is not 'public'.").toString());
                    }
                    if (map.containsKey(class2))
                    {
                        throw new IllegalArgumentException((new StringBuilder("Producer for type ")).append(class2).append(" has already been registered.").toString());
                    }
                    map.put(class2, method);
                }
            }
            i++;
        }
        PRODUCERS_CACHE.put(class1, map);
        SUBSCRIBERS_CACHE.put(class1, map1);
    }

    private static void loadAnnotatedProducerMethods(Class class1, Map map)
    {
        loadAnnotatedMethods(class1, map, new HashMap());
    }

    private static void loadAnnotatedSubscriberMethods(Class class1, Map map)
    {
        loadAnnotatedMethods(class1, new HashMap(), map);
    }

}
