// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.spi.Dependency;
import javax.inject.Provider;

// Referenced classes of package com.google.inject.internal:
//            ProviderInternalFactory, ErrorsException, ConstructionContext, Errors

class val.constructionContext
    implements back.ProvisionCallback
{

    final ProviderInternalFactory this$0;
    final ConstructionContext val$constructionContext;
    final Dependency val$dependency;
    final Errors val$errors;
    final Provider val$provider;

    public Object call()
        throws ErrorsException
    {
        return provision(val$provider, val$errors, val$dependency, val$constructionContext);
    }

    back.ProvisionCallback()
    {
        this$0 = final_providerinternalfactory;
        val$provider = provider1;
        val$errors = errors1;
        val$dependency = dependency1;
        val$constructionContext = ConstructionContext.this;
        super();
    }
}
