// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Provider;
import com.google.inject.ProvisionException;
import com.google.inject.spi.Dependency;

// Referenced classes of package com.google.inject.internal:
//            ContextualCallable, ErrorsException, BindingImpl, InternalContext, 
//            InternalFactory, Errors, InjectorImpl

class val.errors
    implements ContextualCallable
{

    final opStateAndSetDependency this$1;
    final Errors val$errors;

    public Object call(InternalContext internalcontext)
        throws ErrorsException
    {
        Dependency dependency = internalcontext.pushDependency(this._cls1.this.dependency, binding.getSource());
        Object obj = binding.getInternalFactory().get(val$errors, internalcontext, this._cls1.this.dependency, false);
        internalcontext.popStateAndSetDependency(dependency);
        return obj;
        Exception exception;
        exception;
        internalcontext.popStateAndSetDependency(dependency);
        throw exception;
    }

    l.binding()
    {
        this$1 = final_binding;
        val$errors = Errors.this;
        super();
    }

    // Unreferenced inner class com/google/inject/internal/InjectorImpl$2

/* anonymous class */
    class InjectorImpl._cls2
        implements Provider
    {

        final InjectorImpl this$0;
        final BindingImpl val$binding;
        final Dependency val$dependency;

        public Object get()
        {
            Errors errors1 = new Errors(dependency);
            Object obj;
            try
            {
                obj = callInContext(errors1. new InjectorImpl._cls2._cls1());
                errors1.throwIfNewErrors(0);
            }
            catch (ErrorsException errorsexception)
            {
                throw new ProvisionException(errors1.merge(errorsexception.getErrors()).getMessages());
            }
            return obj;
        }

        public String toString()
        {
            return binding.getInternalFactory().toString();
        }

            
            {
                this$0 = final_injectorimpl;
                dependency = dependency1;
                binding = BindingImpl.this;
                super();
            }
    }

}
