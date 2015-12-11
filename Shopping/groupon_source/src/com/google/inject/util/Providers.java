// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.util;

import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.spi.InjectionPoint;
import com.google.inject.spi.ProviderWithDependencies;
import java.util.Iterator;
import java.util.Set;
import org.roboguice.shaded.goole.common.base.Objects;
import org.roboguice.shaded.goole.common.base.Preconditions;
import org.roboguice.shaded.goole.common.collect.ImmutableSet;
import org.roboguice.shaded.goole.common.collect.Sets;

public final class Providers
{
    private static final class ConstantProvider
        implements Provider
    {

        private final Object instance;

        public boolean equals(Object obj)
        {
            return (obj instanceof ConstantProvider) && Objects.equal(instance, ((ConstantProvider)obj).instance);
        }

        public Object get()
        {
            return instance;
        }

        public int hashCode()
        {
            return Objects.hashCode(new Object[] {
                instance
            });
        }

        public String toString()
        {
            return (new StringBuilder()).append("of(").append(instance).append(")").toString();
        }

        private ConstantProvider(Object obj)
        {
            instance = obj;
        }

    }

    private static class GuicifiedProvider
        implements Provider
    {

        protected final javax.inject.Provider _flddelegate;

        public boolean equals(Object obj)
        {
            return (obj instanceof GuicifiedProvider) && Objects.equal(_flddelegate, ((GuicifiedProvider)obj)._flddelegate);
        }

        public Object get()
        {
            return _flddelegate.get();
        }

        public int hashCode()
        {
            return Objects.hashCode(new Object[] {
                _flddelegate
            });
        }

        public String toString()
        {
            return (new StringBuilder()).append("guicified(").append(_flddelegate).append(")").toString();
        }

        private GuicifiedProvider(javax.inject.Provider provider)
        {
            _flddelegate = provider;
        }

    }

    private static final class GuicifiedProviderWithDependencies extends GuicifiedProvider
        implements ProviderWithDependencies
    {

        private final Set dependencies;

        public Set getDependencies()
        {
            return dependencies;
        }

        void initialize(Injector injector)
        {
            injector.injectMembers(_flddelegate);
        }

        private GuicifiedProviderWithDependencies(Set set, javax.inject.Provider provider)
        {
            super(provider);
            dependencies = set;
        }

    }


    private Providers()
    {
    }

    public static Provider guicify(javax.inject.Provider provider)
    {
        if (provider instanceof Provider)
        {
            return (Provider)provider;
        }
        javax.inject.Provider provider1 = (javax.inject.Provider)Preconditions.checkNotNull(provider, "provider");
        Object obj = InjectionPoint.forInstanceMethodsAndFields(provider.getClass());
        if (((Set) (obj)).isEmpty())
        {
            return new GuicifiedProvider(provider1);
        }
        provider = Sets.newHashSet();
        for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); provider.addAll(((InjectionPoint)((Iterator) (obj)).next()).getDependencies())) { }
        return new GuicifiedProviderWithDependencies(ImmutableSet.copyOf(provider), provider1);
    }

    public static Provider of(Object obj)
    {
        return new ConstantProvider(obj);
    }
}
