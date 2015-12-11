// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Key;
import com.google.inject.spi.Dependency;

// Referenced classes of package com.google.inject.internal:
//            InternalFactory, InjectorImpl, ErrorsException, BindingImpl, 
//            InternalContext, Errors

class val.targetBinding
    implements InternalFactory
{

    final InjectorImpl this$0;
    final BindingImpl val$targetBinding;
    final Key val$targetKey;

    public Object get(Errors errors, InternalContext internalcontext, Dependency dependency, boolean flag)
        throws ErrorsException
    {
        internalcontext.pushState(val$targetKey, val$targetBinding.getSource());
        errors = ((Errors) (val$targetBinding.getInternalFactory().get(errors.withSource(val$targetKey), internalcontext, dependency, true)));
        internalcontext.popState();
        return errors;
        errors;
        internalcontext.popState();
        throw errors;
    }

    ()
    {
        this$0 = final_injectorimpl;
        val$targetKey = key;
        val$targetBinding = BindingImpl.this;
        super();
    }
}
