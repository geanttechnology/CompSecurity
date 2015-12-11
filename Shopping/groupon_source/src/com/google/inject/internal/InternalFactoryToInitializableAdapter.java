// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.spi.Dependency;
import javax.inject.Provider;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package com.google.inject.internal:
//            ProviderInternalFactory, ProvisionListenerStackCallback, Initializable, ErrorsException, 
//            Errors, InternalContext, ConstructionContext

final class InternalFactoryToInitializableAdapter extends ProviderInternalFactory
{

    private final Initializable initializable;
    private final ProvisionListenerStackCallback provisionCallback;

    public InternalFactoryToInitializableAdapter(Initializable initializable1, Object obj, boolean flag, ProvisionListenerStackCallback provisionlistenerstackcallback)
    {
        super(obj, flag);
        provisionCallback = (ProvisionListenerStackCallback)Preconditions.checkNotNull(provisionlistenerstackcallback, "provisionCallback");
        initializable = (Initializable)Preconditions.checkNotNull(initializable1, "provider");
    }

    public Object get(Errors errors, InternalContext internalcontext, Dependency dependency, boolean flag)
        throws ErrorsException
    {
        return circularGet((Provider)initializable.get(errors), errors, internalcontext, dependency, flag, provisionCallback);
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
            throw errors.withSource(source).errorInProvider(provider).toException();
        }
        return provider;
    }

    public String toString()
    {
        return initializable.toString();
    }
}
