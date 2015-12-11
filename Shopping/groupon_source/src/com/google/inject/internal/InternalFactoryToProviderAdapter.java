// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Provider;
import com.google.inject.spi.Dependency;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package com.google.inject.internal:
//            InternalFactory, ErrorsException, Errors, InternalContext

final class InternalFactoryToProviderAdapter
    implements InternalFactory
{

    private final Provider provider;
    private final Object source;

    public InternalFactoryToProviderAdapter(Provider provider1, Object obj)
    {
        provider = (Provider)Preconditions.checkNotNull(provider1, "provider");
        source = Preconditions.checkNotNull(obj, "source");
    }

    public Object get(Errors errors, InternalContext internalcontext, Dependency dependency, boolean flag)
        throws ErrorsException
    {
        try
        {
            internalcontext = ((InternalContext) (errors.checkForNull(provider.get(), source, dependency)));
        }
        // Misplaced declaration of an exception variable
        catch (InternalContext internalcontext)
        {
            throw errors.withSource(source).errorInProvider(internalcontext).toException();
        }
        return internalcontext;
    }

    public String toString()
    {
        return provider.toString();
    }
}
