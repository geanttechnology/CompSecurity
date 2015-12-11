// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Binder;
import com.google.inject.Binding;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.spi.BindingTargetVisitor;
import com.google.inject.spi.Dependency;
import com.google.inject.spi.HasDependencies;
import com.google.inject.spi.ProviderBinding;
import java.util.Set;
import org.roboguice.shaded.goole.common.base.Objects;
import org.roboguice.shaded.goole.common.collect.ImmutableSet;

// Referenced classes of package com.google.inject.internal:
//            BindingImpl, InjectorImpl, Scoping, InternalFactory, 
//            ErrorsException, Errors, InternalContext

private static class providedBinding extends BindingImpl
    implements HasDependencies, ProviderBinding
{

    final BindingImpl providedBinding;

    static InternalFactory createInternalFactory(Binding binding)
    {
        return new InternalFactory(binding.getProvider()) {

            final Provider val$provider;

            public Provider get(Errors errors, InternalContext internalcontext, Dependency dependency, boolean flag)
            {
                return provider;
            }

            public volatile Object get(Errors errors, InternalContext internalcontext, Dependency dependency, boolean flag)
                throws ErrorsException
            {
                return get(errors, internalcontext, dependency, flag);
            }

            
            {
                provider = provider1;
                super();
            }
        };
    }

    public Object acceptTargetVisitor(BindingTargetVisitor bindingtargetvisitor)
    {
        return bindingtargetvisitor.visit(this);
    }

    public void applyTo(Binder binder)
    {
        throw new UnsupportedOperationException("This element represents a synthetic binding.");
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof _cls1.get)
        {
            obj = (_cls1.get)obj;
            flag = flag1;
            if (getKey().equals(((getKey) (obj)).getKey()))
            {
                flag = flag1;
                if (getScoping().equals(((getScoping) (obj)).getScoping()))
                {
                    flag = flag1;
                    if (Objects.equal(providedBinding, ((providedBinding) (obj)).providedBinding))
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public Set getDependencies()
    {
        return ImmutableSet.of(Dependency.get(getProvidedKey()));
    }

    public Key getProvidedKey()
    {
        return providedBinding.getKey();
    }

    public int hashCode()
    {
        return Objects.hashCode(new Object[] {
            getKey(), getScoping(), providedBinding
        });
    }

    public String toString()
    {
        return Objects.toStringHelper(com/google/inject/spi/ProviderBinding).ing("key", getKey()).ing("providedKey", getProvidedKey()).ey();
    }

    _cls1.val.provider(InjectorImpl injectorimpl, Key key, Binding binding)
    {
        super(injectorimpl, key, binding.getSource(), createInternalFactory(binding), Scoping.UNSCOPED);
        providedBinding = (BindingImpl)binding;
    }
}
