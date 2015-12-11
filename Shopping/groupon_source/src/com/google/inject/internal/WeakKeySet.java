// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Key;
import com.google.inject.internal.util.SourceProvider;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.roboguice.shaded.goole.common.base.Objects;
import org.roboguice.shaded.goole.common.base.Preconditions;
import org.roboguice.shaded.goole.common.cache.Cache;
import org.roboguice.shaded.goole.common.cache.CacheBuilder;
import org.roboguice.shaded.goole.common.cache.RemovalCause;
import org.roboguice.shaded.goole.common.cache.RemovalListener;
import org.roboguice.shaded.goole.common.cache.RemovalNotification;
import org.roboguice.shaded.goole.common.collect.LinkedHashMultiset;
import org.roboguice.shaded.goole.common.collect.Maps;
import org.roboguice.shaded.goole.common.collect.Multiset;
import org.roboguice.shaded.goole.common.collect.Sets;

// Referenced classes of package com.google.inject.internal:
//            Errors, State

final class WeakKeySet
{
    private static final class KeyAndSource
    {

        final Key key;
        final Object source;

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (!(obj instanceof KeyAndSource))
                {
                    return false;
                }
                obj = (KeyAndSource)obj;
                if (!Objects.equal(key, ((KeyAndSource) (obj)).key) || !Objects.equal(source, ((KeyAndSource) (obj)).source))
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            return Objects.hashCode(new Object[] {
                key, source
            });
        }

        KeyAndSource(Key key1, Object obj)
        {
            key = key1;
            source = obj;
        }
    }


    private Map backingMap;
    private final Cache evictionCache = CacheBuilder.newBuilder().weakKeys().removalListener(new RemovalListener() {

        final WeakKeySet this$0;

        public void onRemoval(RemovalNotification removalnotification)
        {
            Preconditions.checkState(RemovalCause.COLLECTED.equals(removalnotification.getCause()));
            cleanUpForCollectedState((Set)removalnotification.getValue());
        }

            
            {
                this$0 = WeakKeySet.this;
                super();
            }
    }).build();
    private final Object lock;

    WeakKeySet(Object obj)
    {
        lock = obj;
    }

    private void cleanUpForCollectedState(Set set)
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        set = set.iterator();
_L2:
        KeyAndSource keyandsource;
        Multiset multiset;
        do
        {
            if (!set.hasNext())
            {
                break MISSING_BLOCK_LABEL_100;
            }
            keyandsource = (KeyAndSource)set.next();
            multiset = (Multiset)backingMap.get(keyandsource.key);
        } while (multiset == null);
        multiset.remove(keyandsource.source);
        if (multiset.isEmpty())
        {
            backingMap.remove(keyandsource.key);
        }
        if (true) goto _L2; else goto _L1
_L1:
        set;
        obj;
        JVM INSTR monitorexit ;
        throw set;
        obj;
        JVM INSTR monitorexit ;
    }

    public void add(Key key, State state, Object obj)
    {
        Object obj1;
label0:
        {
            if (backingMap == null)
            {
                backingMap = Maps.newHashMap();
            }
            if (!(obj instanceof Class))
            {
                obj1 = obj;
                if (obj != SourceProvider.UNKNOWN_SOURCE)
                {
                    break label0;
                }
            }
            obj1 = null;
        }
        Object obj2 = (Multiset)backingMap.get(key);
        obj = obj2;
        if (obj2 == null)
        {
            obj = LinkedHashMultiset.create();
            backingMap.put(key, obj);
        }
        obj2 = Errors.convert(obj1);
        ((Multiset) (obj)).add(obj2);
        if (state.parent() != State.NONE)
        {
            Set set = (Set)evictionCache.getIfPresent(state);
            obj = set;
            if (set == null)
            {
                Cache cache = evictionCache;
                obj = Sets.newHashSet();
                cache.put(state, obj);
            }
            ((Set) (obj)).add(new KeyAndSource(key, obj2));
        }
    }

    public boolean contains(Key key)
    {
        evictionCache.cleanUp();
        return backingMap != null && backingMap.containsKey(key);
    }

    public Set getSources(Key key)
    {
        evictionCache.cleanUp();
        if (backingMap == null)
        {
            key = null;
        } else
        {
            key = (Multiset)backingMap.get(key);
        }
        if (key == null)
        {
            return null;
        } else
        {
            return key.elementSet();
        }
    }

}
