// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Key;
import com.google.inject.spi.Dependency;
import javax.inject.Provider;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package com.google.inject.internal:
//            ProviderInternalFactory, CreationListener, ProvisionListenerStackCallback, ErrorsException, 
//            InternalContext, Errors, InternalFactory, InjectorImpl, 
//            ConstructionContext

final class BoundProviderFactory extends ProviderInternalFactory
    implements CreationListener
{

    private final InjectorImpl injector;
    private InternalFactory providerFactory;
    final Key providerKey;
    private final ProvisionListenerStackCallback provisionCallback;

    BoundProviderFactory(InjectorImpl injectorimpl, Key key, Object obj, boolean flag, ProvisionListenerStackCallback provisionlistenerstackcallback)
    {
        super(obj, flag);
        provisionCallback = (ProvisionListenerStackCallback)Preconditions.checkNotNull(provisionlistenerstackcallback, "provisionCallback");
        injector = injectorimpl;
        providerKey = key;
    }

    public Object get(Errors errors, InternalContext internalcontext, Dependency dependency, boolean flag)
        throws ErrorsException
    {
        internalcontext.pushState(providerKey, source);
        errors = errors.withSource(providerKey);
        errors = ((Errors) (circularGet((Provider)providerFactory.get(errors, internalcontext, dependency, true), errors, internalcontext, dependency, flag, provisionCallback)));
        internalcontext.popState();
        return errors;
        errors;
        internalcontext.popState();
        throw errors;
    }

    public void notify(Errors errors)
    {
        try
        {
            providerFactory = injector.getInternalFactory(providerKey, errors.withSource(source), InjectorImpl.JitLimitation.NEW_OR_EXISTING_JIT);
            return;
        }
        catch (ErrorsException errorsexception)
        {
            errors.merge(errorsexception.getErrors());
        }
    }

    protected Object provision(Provider provider, Errors errors, Dependency dependency, ConstructionContext constructioncontext)
        throws ErrorsException
    {
        try
        {
            provider = ((Provider) (super.provision(provider, errors, dependency, constructioncontext)));
        }
        // Misplaced declaration of an exception variable
        catch (Provider provider)
        {
            throw errors.errorInProvider(provider).toException();
        }
        return provider;
    }

    public String toString()
    {
        return providerKey.toString();
    }
}
