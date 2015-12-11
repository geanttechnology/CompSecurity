// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.spi.Dependency;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package com.google.inject.internal:
//            ProviderInternalFactory, DelayedInitialize, ErrorsException, BindingImpl, 
//            InternalContext, Errors, InternalFactory, InjectorImpl, 
//            ProvisionListenerStackCallback, ConstructionContext

class ProvidedByInternalFactory extends ProviderInternalFactory
    implements DelayedInitialize
{

    private BindingImpl providerBinding;
    private final Key providerKey;
    private final Class providerType;
    private ProvisionListenerStackCallback provisionCallback;
    private final Class rawType;

    ProvidedByInternalFactory(Class class1, Class class2, Key key, boolean flag)
    {
        super(key, flag);
        rawType = class1;
        providerType = class2;
        providerKey = key;
    }

    public Object get(Errors errors, InternalContext internalcontext, Dependency dependency, boolean flag)
        throws ErrorsException
    {
        boolean flag1 = true;
        if (providerBinding == null)
        {
            flag1 = false;
        }
        Preconditions.checkState(flag1, "not initialized");
        internalcontext.pushState(providerKey, providerBinding.getSource());
        errors = errors.withSource(providerKey);
        errors = ((Errors) (circularGet((Provider)providerBinding.getInternalFactory().get(errors, internalcontext, dependency, true), errors, internalcontext, dependency, flag, provisionCallback)));
        internalcontext.popState();
        return errors;
        errors;
        internalcontext.popState();
        throw errors;
    }

    public void initialize(InjectorImpl injectorimpl, Errors errors)
        throws ErrorsException
    {
        providerBinding = injectorimpl.getBindingOrThrow(providerKey, errors, InjectorImpl.JitLimitation.NEW_OR_EXISTING_JIT);
    }

    protected Object provision(javax.inject.Provider provider, Errors errors, Dependency dependency, ConstructionContext constructioncontext)
        throws ErrorsException
    {
        try
        {
            provider = ((javax.inject.Provider) (super.provision(provider, errors, dependency, constructioncontext)));
        }
        // Misplaced declaration of an exception variable
        catch (javax.inject.Provider provider)
        {
            throw errors.errorInProvider(provider).toException();
        }
        if (provider == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        if (!rawType.isInstance(provider))
        {
            throw errors.subtypeNotProvided(providerType, rawType).toException();
        }
        return provider;
    }

    void setProvisionListenerCallback(ProvisionListenerStackCallback provisionlistenerstackcallback)
    {
        provisionCallback = provisionlistenerstackcallback;
    }
}
