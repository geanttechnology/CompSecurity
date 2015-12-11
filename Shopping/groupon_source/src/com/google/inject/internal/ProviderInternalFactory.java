// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.spi.Dependency;
import javax.inject.Provider;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package com.google.inject.internal:
//            InternalFactory, ErrorsException, InternalContext, ConstructionContext, 
//            Errors, ProvisionListenerStackCallback

abstract class ProviderInternalFactory
    implements InternalFactory
{

    private final boolean allowProxy;
    protected final Object source;

    ProviderInternalFactory(Object obj, boolean flag)
    {
        source = Preconditions.checkNotNull(obj, "source");
        allowProxy = flag;
    }

    protected Object circularGet(final Provider provider, final Errors errors, InternalContext internalcontext, final Dependency dependency, boolean flag, ProvisionListenerStackCallback provisionlistenerstackcallback)
        throws ErrorsException
    {
        final ConstructionContext constructionContext;
        Class class1 = dependency.getKey().getTypeLiteral().getRawType();
        constructionContext = internalcontext.getConstructionContext(this);
        if (constructionContext.isConstructing())
        {
            if (!allowProxy)
            {
                throw errors.circularProxiesDisabled(class1).toException();
            } else
            {
                return constructionContext.createProxy(errors, class1);
            }
        }
        constructionContext.startConstruction();
        if (provisionlistenerstackcallback.hasListeners())
        {
            break MISSING_BLOCK_LABEL_90;
        }
        provider = ((Provider) (provision(provider, errors, dependency, constructionContext)));
        constructionContext.removeCurrentReference();
        constructionContext.finishConstruction();
        return provider;
        provider = ((Provider) (provisionlistenerstackcallback.provision(errors, internalcontext, new ProvisionListenerStackCallback.ProvisionCallback() {

            final ProviderInternalFactory this$0;
            final ConstructionContext val$constructionContext;
            final Dependency val$dependency;
            final Errors val$errors;
            final Provider val$provider;

            public Object call()
                throws ErrorsException
            {
                return provision(provider, errors, dependency, constructionContext);
            }

            
            {
                this$0 = ProviderInternalFactory.this;
                provider = provider1;
                errors = errors1;
                dependency = dependency1;
                constructionContext = constructioncontext;
                super();
            }
        })));
        constructionContext.removeCurrentReference();
        constructionContext.finishConstruction();
        return provider;
        provider;
        constructionContext.removeCurrentReference();
        constructionContext.finishConstruction();
        throw provider;
    }

    protected Object provision(Provider provider, Errors errors, Dependency dependency, ConstructionContext constructioncontext)
        throws ErrorsException
    {
        provider = ((Provider) (errors.checkForNull(provider.get(), source, dependency)));
        constructioncontext.setProxyDelegates(provider);
        return provider;
    }
}
