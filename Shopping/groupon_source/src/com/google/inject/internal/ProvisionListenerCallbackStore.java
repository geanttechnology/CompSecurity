// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Binding;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Stage;
import com.google.inject.matcher.Matcher;
import com.google.inject.spi.ProvisionListenerBinding;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;
import org.roboguice.shaded.goole.common.cache.CacheBuilder;
import org.roboguice.shaded.goole.common.cache.CacheLoader;
import org.roboguice.shaded.goole.common.cache.LoadingCache;
import org.roboguice.shaded.goole.common.collect.ImmutableList;
import org.roboguice.shaded.goole.common.collect.ImmutableSet;
import org.roboguice.shaded.goole.common.collect.Lists;

// Referenced classes of package com.google.inject.internal:
//            ProvisionListenerStackCallback

final class ProvisionListenerCallbackStore
{
    private static class KeyBinding
    {

        final Binding binding;
        final Key key;

        public boolean equals(Object obj)
        {
            return (obj instanceof KeyBinding) && key.equals(((KeyBinding)obj).key);
        }

        public int hashCode()
        {
            return key.hashCode();
        }

        KeyBinding(Key key1, Binding binding1)
        {
            key = key1;
            binding = binding1;
        }
    }


    private static final Set INTERNAL_BINDINGS = ImmutableSet.of(Key.get(com/google/inject/Injector), Key.get(com/google/inject/Stage), Key.get(java/util/logging/Logger));
    private final LoadingCache cache = CacheBuilder.newBuilder().build(new CacheLoader() {

        final ProvisionListenerCallbackStore this$0;

        public ProvisionListenerStackCallback load(KeyBinding keybinding)
        {
            return create(keybinding.binding);
        }

        public volatile Object load(Object obj)
            throws Exception
        {
            return load((KeyBinding)obj);
        }

            
            {
                this$0 = ProvisionListenerCallbackStore.this;
                super();
            }
    });
    private final ImmutableList listenerBindings;

    ProvisionListenerCallbackStore(List list)
    {
        listenerBindings = ImmutableList.copyOf(list);
    }

    private ProvisionListenerStackCallback create(Binding binding)
    {
        java.util.ArrayList arraylist = null;
        org.roboguice.shaded.goole.common.collect.UnmodifiableIterator unmodifiableiterator = listenerBindings.iterator();
        do
        {
            if (!unmodifiableiterator.hasNext())
            {
                break;
            }
            ProvisionListenerBinding provisionlistenerbinding = (ProvisionListenerBinding)unmodifiableiterator.next();
            if (provisionlistenerbinding.getBindingMatcher().matches(binding))
            {
                java.util.ArrayList arraylist1 = arraylist;
                if (arraylist == null)
                {
                    arraylist1 = Lists.newArrayList();
                }
                arraylist1.addAll(provisionlistenerbinding.getListeners());
                arraylist = arraylist1;
            }
        } while (true);
        if (arraylist == null || arraylist.isEmpty())
        {
            return ProvisionListenerStackCallback.emptyListener();
        } else
        {
            return new ProvisionListenerStackCallback(binding, arraylist);
        }
    }

    public ProvisionListenerStackCallback get(Binding binding)
    {
        if (!INTERNAL_BINDINGS.contains(binding.getKey()))
        {
            return (ProvisionListenerStackCallback)cache.getUnchecked(new KeyBinding(binding.getKey(), binding));
        } else
        {
            return ProvisionListenerStackCallback.emptyListener();
        }
    }

    boolean remove(Binding binding)
    {
        return cache.asMap().remove(binding) != null;
    }


}
