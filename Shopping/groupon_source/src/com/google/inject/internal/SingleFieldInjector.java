// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.spi.Dependency;
import com.google.inject.spi.InjectionPoint;
import java.lang.reflect.Field;
import java.util.List;

// Referenced classes of package com.google.inject.internal:
//            SingleMemberInjector, ErrorsException, InjectorImpl, Errors, 
//            BindingImpl, InternalContext, InternalFactory

final class SingleFieldInjector
    implements SingleMemberInjector
{

    final BindingImpl binding;
    final Dependency dependency;
    final Field field;
    final InjectionPoint injectionPoint;

    public SingleFieldInjector(InjectorImpl injectorimpl, InjectionPoint injectionpoint, Errors errors)
        throws ErrorsException
    {
        injectionPoint = injectionpoint;
        field = (Field)injectionpoint.getMember();
        dependency = (Dependency)injectionpoint.getDependencies().get(0);
        field.setAccessible(true);
        binding = injectorimpl.getBindingOrThrow(dependency.getKey(), errors, InjectorImpl.JitLimitation.NO_JIT);
    }

    public InjectionPoint getInjectionPoint()
    {
        return injectionPoint;
    }

    public void inject(Errors errors, InternalContext internalcontext, Object obj)
    {
        Errors errors1;
        errors1 = errors.withSource(dependency);
        errors = internalcontext.pushDependency(dependency, binding.getSource());
        Object obj1 = binding.getInternalFactory().get(errors1, internalcontext, dependency, false);
        field.set(obj, obj1);
        internalcontext.popStateAndSetDependency(errors);
        return;
        obj;
        errors1.withSource(injectionPoint).merge(((ErrorsException) (obj)).getErrors());
        internalcontext.popStateAndSetDependency(errors);
        return;
        obj;
        throw new AssertionError(obj);
        obj;
        internalcontext.popStateAndSetDependency(errors);
        throw obj;
    }
}
