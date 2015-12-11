// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.spi.ProvisionListenerBinding;
import com.google.inject.spi.ScopeBinding;
import com.google.inject.spi.TypeConverterBinding;
import com.google.inject.spi.TypeListenerBinding;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.roboguice.shaded.goole.common.collect.ImmutableList;
import org.roboguice.shaded.goole.common.collect.ImmutableMap;
import org.roboguice.shaded.goole.common.collect.ImmutableSet;

// Referenced classes of package com.google.inject.internal:
//            Errors, BindingImpl

interface State
{

    public static final State NONE = new State() {

        public void addConverter(TypeConverterBinding typeconverterbinding)
        {
            throw new UnsupportedOperationException();
        }

        public void addProvisionListener(ProvisionListenerBinding provisionlistenerbinding)
        {
            throw new UnsupportedOperationException();
        }

        public void addTypeListener(TypeListenerBinding typelistenerbinding)
        {
            throw new UnsupportedOperationException();
        }

        public void blacklist(Key key, State state, Object obj)
        {
        }

        public TypeConverterBinding getConverter(String s, TypeLiteral typeliteral, Errors errors, Object obj)
        {
            throw new UnsupportedOperationException();
        }

        public Iterable getConvertersThisLevel()
        {
            return ImmutableSet.of();
        }

        public BindingImpl getExplicitBinding(Key key)
        {
            return null;
        }

        public Map getExplicitBindingsThisLevel()
        {
            throw new UnsupportedOperationException();
        }

        public List getProvisionListenerBindings()
        {
            return ImmutableList.of();
        }

        public ScopeBinding getScopeBinding(Class class1)
        {
            return null;
        }

        public Map getScopes()
        {
            return ImmutableMap.of();
        }

        public Set getSourcesForBlacklistedKey(Key key)
        {
            throw new UnsupportedOperationException();
        }

        public List getTypeListenerBindings()
        {
            return ImmutableList.of();
        }

        public boolean isBlacklisted(Key key)
        {
            return true;
        }

        public Object lock()
        {
            throw new UnsupportedOperationException();
        }

        public State parent()
        {
            throw new UnsupportedOperationException();
        }

        public void putBinding(Key key, BindingImpl bindingimpl)
        {
            throw new UnsupportedOperationException();
        }

        public void putScopeBinding(Class class1, ScopeBinding scopebinding)
        {
            throw new UnsupportedOperationException();
        }

    };

    public abstract void addConverter(TypeConverterBinding typeconverterbinding);

    public abstract void addProvisionListener(ProvisionListenerBinding provisionlistenerbinding);

    public abstract void addTypeListener(TypeListenerBinding typelistenerbinding);

    public abstract void blacklist(Key key, State state, Object obj);

    public abstract TypeConverterBinding getConverter(String s, TypeLiteral typeliteral, Errors errors, Object obj);

    public abstract Iterable getConvertersThisLevel();

    public abstract BindingImpl getExplicitBinding(Key key);

    public abstract Map getExplicitBindingsThisLevel();

    public abstract List getProvisionListenerBindings();

    public abstract ScopeBinding getScopeBinding(Class class1);

    public abstract Map getScopes();

    public abstract Set getSourcesForBlacklistedKey(Key key);

    public abstract List getTypeListenerBindings();

    public abstract boolean isBlacklisted(Key key);

    public abstract Object lock();

    public abstract State parent();

    public abstract void putBinding(Key key, BindingImpl bindingimpl);

    public abstract void putScopeBinding(Class class1, ScopeBinding scopebinding);

}
