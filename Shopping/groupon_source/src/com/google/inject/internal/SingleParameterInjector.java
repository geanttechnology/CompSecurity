// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.spi.Dependency;

// Referenced classes of package com.google.inject.internal:
//            ErrorsException, Errors, BindingImpl, InternalContext, 
//            InternalFactory

final class SingleParameterInjector
{

    private static final Object NO_ARGUMENTS[] = new Object[0];
    private final BindingImpl binding;
    private final Dependency dependency;

    SingleParameterInjector(Dependency dependency1, BindingImpl bindingimpl)
    {
        dependency = dependency1;
        binding = bindingimpl;
    }

    static Object[] getAll(Errors errors, InternalContext internalcontext, SingleParameterInjector asingleparameterinjector[])
        throws ErrorsException
    {
        if (asingleparameterinjector == null)
        {
            return NO_ARGUMENTS;
        }
        int j = errors.size();
        int k = asingleparameterinjector.length;
        Object aobj[] = new Object[k];
        int i = 0;
        while (i < k) 
        {
            SingleParameterInjector singleparameterinjector = asingleparameterinjector[i];
            try
            {
                aobj[i] = singleparameterinjector.inject(errors, internalcontext);
            }
            catch (ErrorsException errorsexception)
            {
                errors.merge(errorsexception.getErrors());
            }
            i++;
        }
        errors.throwIfNewErrors(j);
        return aobj;
    }

    private Object inject(Errors errors, InternalContext internalcontext)
        throws ErrorsException
    {
        Dependency dependency1 = internalcontext.pushDependency(dependency, binding.getSource());
        errors = ((Errors) (binding.getInternalFactory().get(errors.withSource(dependency), internalcontext, dependency, false)));
        internalcontext.popStateAndSetDependency(dependency1);
        return errors;
        errors;
        internalcontext.popStateAndSetDependency(dependency1);
        throw errors;
    }

}
