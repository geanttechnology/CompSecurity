// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Binding;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matcher;
import com.google.inject.spi.ProvisionListenerBinding;
import com.google.inject.spi.ScopeBinding;
import com.google.inject.spi.TypeConverterBinding;
import com.google.inject.spi.TypeListenerBinding;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.roboguice.shaded.goole.common.base.Preconditions;
import org.roboguice.shaded.goole.common.collect.ImmutableMap;
import org.roboguice.shaded.goole.common.collect.Lists;
import org.roboguice.shaded.goole.common.collect.Maps;

// Referenced classes of package com.google.inject.internal:
//            State, WeakKeySet, Errors, BindingImpl

final class InheritingState
    implements State
{

    private final WeakKeySet blacklistedKeys;
    private final List converters = Lists.newArrayList();
    private final Map explicitBindings;
    private final Map explicitBindingsMutable = Maps.newLinkedHashMap();
    private final Object lock;
    private final State parent;
    private final List provisionListenerBindings = Lists.newArrayList();
    private final Map scopes = Maps.newHashMap();
    private final List typeListenerBindings = Lists.newArrayList();

    InheritingState(State state)
    {
        explicitBindings = Collections.unmodifiableMap(explicitBindingsMutable);
        parent = (State)Preconditions.checkNotNull(state, "parent");
        if (state == State.NONE)
        {
            state = this;
        } else
        {
            state = ((State) (state.lock()));
        }
        lock = state;
        blacklistedKeys = new WeakKeySet(lock);
    }

    public void addConverter(TypeConverterBinding typeconverterbinding)
    {
        converters.add(typeconverterbinding);
    }

    public void addProvisionListener(ProvisionListenerBinding provisionlistenerbinding)
    {
        provisionListenerBindings.add(provisionlistenerbinding);
    }

    public void addTypeListener(TypeListenerBinding typelistenerbinding)
    {
        typeListenerBindings.add(typelistenerbinding);
    }

    public void blacklist(Key key, State state, Object obj)
    {
        parent.blacklist(key, state, obj);
        blacklistedKeys.add(key, state, obj);
    }

    public TypeConverterBinding getConverter(String s, TypeLiteral typeliteral, Errors errors, Object obj)
    {
        TypeConverterBinding typeconverterbinding = null;
label0:
        for (Object obj1 = this; obj1 != State.NONE; obj1 = ((State) (obj1)).parent())
        {
            Iterator iterator = ((State) (obj1)).getConvertersThisLevel().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    continue label0;
                }
                TypeConverterBinding typeconverterbinding1 = (TypeConverterBinding)iterator.next();
                if (typeconverterbinding1.getTypeMatcher().matches(typeliteral))
                {
                    if (typeconverterbinding != null)
                    {
                        errors.ambiguousTypeConversion(s, obj, typeliteral, typeconverterbinding, typeconverterbinding1);
                    }
                    typeconverterbinding = typeconverterbinding1;
                }
            } while (true);
        }

        return typeconverterbinding;
    }

    public Iterable getConvertersThisLevel()
    {
        return converters;
    }

    public BindingImpl getExplicitBinding(Key key)
    {
        Binding binding = (Binding)explicitBindings.get(key);
        if (binding != null)
        {
            return (BindingImpl)binding;
        } else
        {
            return parent.getExplicitBinding(key);
        }
    }

    public Map getExplicitBindingsThisLevel()
    {
        return explicitBindings;
    }

    public List getProvisionListenerBindings()
    {
        List list = parent.getProvisionListenerBindings();
        ArrayList arraylist = new ArrayList(list.size() + 1);
        arraylist.addAll(list);
        arraylist.addAll(provisionListenerBindings);
        return arraylist;
    }

    public ScopeBinding getScopeBinding(Class class1)
    {
        ScopeBinding scopebinding = (ScopeBinding)scopes.get(class1);
        if (scopebinding != null)
        {
            return scopebinding;
        } else
        {
            return parent.getScopeBinding(class1);
        }
    }

    public Map getScopes()
    {
        org.roboguice.shaded.goole.common.collect.ImmutableMap.Builder builder = ImmutableMap.builder();
        java.util.Map.Entry entry;
        for (Iterator iterator = scopes.entrySet().iterator(); iterator.hasNext(); builder.put(entry.getKey(), ((ScopeBinding)entry.getValue()).getScope()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return builder.build();
    }

    public Set getSourcesForBlacklistedKey(Key key)
    {
        return blacklistedKeys.getSources(key);
    }

    public List getTypeListenerBindings()
    {
        List list = parent.getTypeListenerBindings();
        ArrayList arraylist = new ArrayList(list.size() + 1);
        arraylist.addAll(list);
        arraylist.addAll(typeListenerBindings);
        return arraylist;
    }

    public boolean isBlacklisted(Key key)
    {
        return blacklistedKeys.contains(key);
    }

    public Object lock()
    {
        return lock;
    }

    public State parent()
    {
        return parent;
    }

    public void putBinding(Key key, BindingImpl bindingimpl)
    {
        explicitBindingsMutable.put(key, bindingimpl);
    }

    public void putScopeBinding(Class class1, ScopeBinding scopebinding)
    {
        scopes.put(class1, scopebinding);
    }
}
