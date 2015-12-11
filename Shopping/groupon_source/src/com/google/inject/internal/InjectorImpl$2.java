// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Provider;
import com.google.inject.ProvisionException;
import com.google.inject.spi.Dependency;

// Referenced classes of package com.google.inject.internal:
//            InjectorImpl, ErrorsException, Errors, BindingImpl, 
//            ContextualCallable, InternalContext, InternalFactory

class val.binding
    implements Provider
{

    final InjectorImpl this$0;
    final BindingImpl val$binding;
    final Dependency val$dependency;

    public Object get()
    {
        final Errors errors = new Errors(val$dependency);
        Object obj;
        try
        {
            obj = callInContext(new ContextualCallable() {

                final InjectorImpl._cls2 this$1;
                final Errors val$errors;

                public Object call(InternalContext internalcontext)
                    throws ErrorsException
                {
                    Dependency dependency1 = internalcontext.pushDependency(dependency, binding.getSource());
                    Object obj1 = binding.getInternalFactory().get(errors, internalcontext, dependency, false);
                    internalcontext.popStateAndSetDependency(dependency1);
                    return obj1;
                    Exception exception;
                    exception;
                    internalcontext.popStateAndSetDependency(dependency1);
                    throw exception;
                }

            
            {
                this$1 = InjectorImpl._cls2.this;
                errors = errors1;
                super();
            }
            });
            errors.throwIfNewErrors(0);
        }
        catch (ErrorsException errorsexception)
        {
            throw new ProvisionException(errors.merge(errorsexception.getErrors()).getMessages());
        }
        return obj;
    }

    public String toString()
    {
        return val$binding.getInternalFactory().toString();
    }

    _cls1.val.errors()
    {
        this$0 = final_injectorimpl;
        val$dependency = dependency1;
        val$binding = BindingImpl.this;
        super();
    }
}
