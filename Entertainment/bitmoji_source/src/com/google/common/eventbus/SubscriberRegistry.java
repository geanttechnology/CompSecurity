// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.eventbus;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.reflect.TypeToken;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

// Referenced classes of package com.google.common.eventbus:
//            EventBus, Subscriber, Subscribe

final class SubscriberRegistry
{
    private static final class MethodIdentifier
    {

        private final String name;
        private final List parameterTypes;

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (obj instanceof MethodIdentifier)
            {
                obj = (MethodIdentifier)obj;
                flag = flag1;
                if (name.equals(((MethodIdentifier) (obj)).name))
                {
                    flag = flag1;
                    if (parameterTypes.equals(((MethodIdentifier) (obj)).parameterTypes))
                    {
                        flag = true;
                    }
                }
            }
            return flag;
        }

        public int hashCode()
        {
            return Objects.hashCode(new Object[] {
                name, parameterTypes
            });
        }

        MethodIdentifier(Method method)
        {
            name = method.getName();
            parameterTypes = Arrays.asList(method.getParameterTypes());
        }
    }


    private static final LoadingCache flattenHierarchyCache = CacheBuilder.newBuilder().weakKeys().build(new CacheLoader() {

        public ImmutableSet load(Class class1)
        {
            return ImmutableSet.copyOf(TypeToken.of(class1).getTypes().rawTypes());
        }

        public volatile Object load(Object obj)
            throws Exception
        {
            return load((Class)obj);
        }

    });
    private static final LoadingCache subscriberMethodsCache = CacheBuilder.newBuilder().weakKeys().build(new CacheLoader() {

        public ImmutableList load(Class class1)
            throws Exception
        {
            return SubscriberRegistry.getAnnotatedMethodsNotCached(class1);
        }

        public volatile Object load(Object obj)
            throws Exception
        {
            return load((Class)obj);
        }

    });
    private final EventBus bus;
    private final ConcurrentMap subscribers = Maps.newConcurrentMap();

    SubscriberRegistry(EventBus eventbus)
    {
        bus = (EventBus)Preconditions.checkNotNull(eventbus);
    }

    private Multimap findAllSubscribers(Object obj)
    {
        HashMultimap hashmultimap = HashMultimap.create();
        Method method;
        for (com.google.common.collect.UnmodifiableIterator unmodifiableiterator = getAnnotatedMethods(obj.getClass()).iterator(); unmodifiableiterator.hasNext(); hashmultimap.put(method.getParameterTypes()[0], Subscriber.create(bus, obj, method)))
        {
            method = (Method)unmodifiableiterator.next();
        }

        return hashmultimap;
    }

    static ImmutableSet flattenHierarchy(Class class1)
    {
        try
        {
            class1 = (ImmutableSet)flattenHierarchyCache.getUnchecked(class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw Throwables.propagate(class1.getCause());
        }
        return class1;
    }

    private static ImmutableList getAnnotatedMethods(Class class1)
    {
        return (ImmutableList)subscriberMethodsCache.getUnchecked(class1);
    }

    private static ImmutableList getAnnotatedMethodsNotCached(Class class1)
    {
        Object obj = TypeToken.of(class1).getTypes().rawTypes();
        class1 = Maps.newHashMap();
        for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            Method amethod[] = ((Class)((Iterator) (obj)).next()).getDeclaredMethods();
            int j = amethod.length;
            int i = 0;
            while (i < j) 
            {
                Method method = amethod[i];
                if (method.isAnnotationPresent(com/google/common/eventbus/Subscribe) && !method.isSynthetic())
                {
                    Class aclass[] = method.getParameterTypes();
                    MethodIdentifier methodidentifier;
                    boolean flag;
                    if (aclass.length == 1)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    Preconditions.checkArgument(flag, "Method %s has @Subscribe annotation but has %s parameters.Subscriber methods must have exactly 1 parameter.", new Object[] {
                        method, Integer.valueOf(aclass.length)
                    });
                    methodidentifier = new MethodIdentifier(method);
                    if (!class1.containsKey(methodidentifier))
                    {
                        class1.put(methodidentifier, method);
                    }
                }
                i++;
            }
        }

        return ImmutableList.copyOf(class1.values());
    }

    Iterator getSubscribers(Object obj)
    {
        Object obj1 = flattenHierarchy(obj.getClass());
        obj = Lists.newArrayListWithCapacity(((ImmutableSet) (obj1)).size());
        obj1 = ((ImmutableSet) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            Object obj2 = (Class)((Iterator) (obj1)).next();
            obj2 = (CopyOnWriteArraySet)subscribers.get(obj2);
            if (obj2 != null)
            {
                ((List) (obj)).add(((CopyOnWriteArraySet) (obj2)).iterator());
            }
        } while (true);
        return Iterators.concat(((List) (obj)).iterator());
    }

    Set getSubscribersForTesting(Class class1)
    {
        return (Set)MoreObjects.firstNonNull(subscribers.get(class1), ImmutableSet.of());
    }

    void register(Object obj)
    {
        Collection collection;
        for (Iterator iterator = findAllSubscribers(obj).asMap().entrySet().iterator(); iterator.hasNext(); ((CopyOnWriteArraySet) (obj)).addAll(collection))
        {
            obj = (java.util.Map.Entry)iterator.next();
            Class class1 = (Class)((java.util.Map.Entry) (obj)).getKey();
            collection = (Collection)((java.util.Map.Entry) (obj)).getValue();
            CopyOnWriteArraySet copyonwritearrayset = (CopyOnWriteArraySet)subscribers.get(class1);
            obj = copyonwritearrayset;
            if (copyonwritearrayset == null)
            {
                obj = new CopyOnWriteArraySet();
                obj = (CopyOnWriteArraySet)MoreObjects.firstNonNull(subscribers.putIfAbsent(class1, obj), obj);
            }
        }

    }

    void unregister(Object obj)
    {
        for (Iterator iterator = findAllSubscribers(obj).asMap().entrySet().iterator(); iterator.hasNext();)
        {
            Object obj2 = (java.util.Map.Entry)iterator.next();
            Object obj1 = (Class)((java.util.Map.Entry) (obj2)).getKey();
            obj2 = (Collection)((java.util.Map.Entry) (obj2)).getValue();
            obj1 = (CopyOnWriteArraySet)subscribers.get(obj1);
            if (obj1 == null || !((CopyOnWriteArraySet) (obj1)).removeAll(((Collection) (obj2))))
            {
                obj = String.valueOf(obj);
                throw new IllegalArgumentException((new StringBuilder(String.valueOf(obj).length() + 65)).append("missing event subscriber for an annotated method. Is ").append(((String) (obj))).append(" registered?").toString());
            }
        }

    }


}
