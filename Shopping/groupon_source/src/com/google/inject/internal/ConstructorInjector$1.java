// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;


// Referenced classes of package com.google.inject.internal:
//            ConstructorInjector, ErrorsException, ConstructionContext, InternalContext, 
//            Errors

class val.constructionContext
    implements Callback.ProvisionCallback
{

    final ConstructorInjector this$0;
    final ConstructionContext val$constructionContext;
    final InternalContext val$context;
    final Errors val$errors;

    public Object call()
        throws ErrorsException
    {
        return ConstructorInjector.access$000(ConstructorInjector.this, val$errors, val$context, val$constructionContext);
    }

    Callback.ProvisionCallback()
    {
        this$0 = final_constructorinjector;
        val$errors = errors1;
        val$context = internalcontext;
        val$constructionContext = ConstructionContext.this;
        super();
    }
}
