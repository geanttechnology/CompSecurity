// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WeakIdentityHashMap
    implements Map
{
    class IdentityWeakReference extends WeakReference
    {

        int hash;
        final WeakIdentityHashMap this$0;

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (get() != ((IdentityWeakReference) (obj = (IdentityWeakReference)obj)).get())
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            return hash;
        }

        IdentityWeakReference(Object obj)
        {
            this$0 = WeakIdentityHashMap.this;
            super(obj, queue);
            hash = System.identityHashCode(obj);
        }
    }


    private Map backingStore;
    private final ReferenceQueue queue = new ReferenceQueue();

    public WeakIdentityHashMap()
    {
        backingStore = new HashMap();
    }

    private void reap()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = queue.poll();
_L2:
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (IdentityWeakReference)obj;
        backingStore.remove(obj);
        obj = queue.poll();
        if (true) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void clear()
    {
        backingStore.clear();
        reap();
    }

    public boolean containsKey(Object obj)
    {
        reap();
        return backingStore.containsKey(new IdentityWeakReference(obj));
    }

    public boolean containsValue(Object obj)
    {
        reap();
        return backingStore.containsValue(obj);
    }

    public Set entrySet()
    {
        reap();
        HashSet hashset = new HashSet();
        java.util.Map.Entry entry;
        for (Iterator iterator = backingStore.entrySet().iterator(); iterator.hasNext(); hashset.add(new java.util.Map.Entry() {

        final WeakIdentityHashMap this$0;
        final Object val$key;
        final Object val$value;

        public Object getKey()
        {
            return key;
        }

        public Object getValue()
        {
            return value;
        }

        public Object setValue(Object obj)
        {
            throw new UnsupportedOperationException();
        }

            
            {
                this$0 = WeakIdentityHashMap.this;
                key = obj;
                value = obj1;
                super();
            }
    }))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return Collections.unmodifiableSet(hashset);
    }

    public boolean equals(Object obj)
    {
        return backingStore.equals(((WeakIdentityHashMap)obj).backingStore);
    }

    public Object get(Object obj)
    {
        reap();
        return backingStore.get(new IdentityWeakReference(obj));
    }

    public int hashCode()
    {
        reap();
        return backingStore.hashCode();
    }

    public boolean isEmpty()
    {
        reap();
        return backingStore.isEmpty();
    }

    public Set keySet()
    {
        reap();
        HashSet hashset = new HashSet();
        for (Iterator iterator = backingStore.keySet().iterator(); iterator.hasNext(); hashset.add(((IdentityWeakReference)iterator.next()).get())) { }
        return Collections.unmodifiableSet(hashset);
    }

    public Object put(Object obj, Object obj1)
    {
        reap();
        return backingStore.put(new IdentityWeakReference(obj), obj1);
    }

    public void putAll(Map map)
    {
        throw new UnsupportedOperationException();
    }

    public Object remove(Object obj)
    {
        reap();
        return backingStore.remove(new IdentityWeakReference(obj));
    }

    public int size()
    {
        reap();
        return backingStore.size();
    }

    public Collection values()
    {
        reap();
        return backingStore.values();
    }

}
