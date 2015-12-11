// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Binder;
import com.google.inject.Key;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.spi.BindingTargetVisitor;
import com.google.inject.spi.Dependency;
import com.google.inject.spi.HasDependencies;
import com.google.inject.spi.ProviderKeyBinding;
import java.util.Set;
import org.roboguice.shaded.goole.common.base.Objects;
import org.roboguice.shaded.goole.common.collect.ImmutableSet;

// Referenced classes of package com.google.inject.internal:
//            BindingImpl, DelayedInitialize, Scoping, ErrorsException, 
//            InjectorImpl, InternalFactory, Errors

final class LinkedProviderBindingImpl extends BindingImpl
    implements DelayedInitialize, HasDependencies, ProviderKeyBinding
{

    final DelayedInitialize delayedInitializer;
    final Key providerKey;

    public LinkedProviderBindingImpl(InjectorImpl injectorimpl, Key key, Object obj, InternalFactory internalfactory, Scoping scoping, Key key1)
    {
        this(injectorimpl, key, obj, internalfactory, scoping, key1, null);
    }

    private LinkedProviderBindingImpl(InjectorImpl injectorimpl, Key key, Object obj, InternalFactory internalfactory, Scoping scoping, Key key1, DelayedInitialize delayedinitialize)
    {
        super(injectorimpl, key, obj, internalfactory, scoping);
        providerKey = key1;
        delayedInitializer = delayedinitialize;
    }

    LinkedProviderBindingImpl(Object obj, Key key, Scoping scoping, Key key1)
    {
        super(obj, key, scoping);
        providerKey = key1;
        delayedInitializer = null;
    }

    static LinkedProviderBindingImpl createWithInitializer(InjectorImpl injectorimpl, Key key, Object obj, InternalFactory internalfactory, Scoping scoping, Key key1, DelayedInitialize delayedinitialize)
    {
        return new LinkedProviderBindingImpl(injectorimpl, key, obj, internalfactory, scoping, key1, delayedinitialize);
    }

    public Object acceptTargetVisitor(BindingTargetVisitor bindingtargetvisitor)
    {
        return bindingtargetvisitor.visit(this);
    }

    public void applyTo(Binder binder)
    {
        getScoping().applyTo(binder.withSource(getSource()).bind(getKey()).toProvider(getProviderKey()));
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof LinkedProviderBindingImpl)
        {
            obj = (LinkedProviderBindingImpl)obj;
            flag = flag1;
            if (getKey().equals(((LinkedProviderBindingImpl) (obj)).getKey()))
            {
                flag = flag1;
                if (getScoping().equals(((LinkedProviderBindingImpl) (obj)).getScoping()))
                {
                    flag = flag1;
                    if (Objects.equal(providerKey, ((LinkedProviderBindingImpl) (obj)).providerKey))
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
        return ImmutableSet.of(Dependency.get(providerKey));
    }

    public Key getProviderKey()
    {
        return providerKey;
    }

    public int hashCode()
    {
        return Objects.hashCode(new Object[] {
            getKey(), getScoping(), providerKey
        });
    }

    public void initialize(InjectorImpl injectorimpl, Errors errors)
        throws ErrorsException
    {
        if (delayedInitializer != null)
        {
            delayedInitializer.initialize(injectorimpl, errors);
        }
    }

    public String toString()
    {
        return Objects.toStringHelper(com/google/inject/spi/ProviderKeyBinding).add("key", getKey()).add("source", getSource()).add("scope", getScoping()).add("provider", providerKey).toString();
    }

    public BindingImpl withKey(Key key)
    {
        return new LinkedProviderBindingImpl(getSource(), key, getScoping(), providerKey);
    }

    public BindingImpl withScoping(Scoping scoping)
    {
        return new LinkedProviderBindingImpl(getSource(), getKey(), scoping, providerKey);
    }
}
