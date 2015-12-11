// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Key;
import com.google.inject.spi.Dependency;
import org.roboguice.shaded.goole.common.base.Objects;

// Referenced classes of package com.google.inject.internal:
//            CreationListener, InternalFactory, ErrorsException, InternalContext, 
//            Errors, InjectorImpl

final class FactoryProxy
    implements CreationListener, InternalFactory
{

    private final InjectorImpl injector;
    private final Key key;
    private final Object source;
    private InternalFactory targetFactory;
    private final Key targetKey;

    FactoryProxy(InjectorImpl injectorimpl, Key key1, Key key2, Object obj)
    {
        injector = injectorimpl;
        key = key1;
        targetKey = key2;
        source = obj;
    }

    public Object get(Errors errors, InternalContext internalcontext, Dependency dependency, boolean flag)
        throws ErrorsException
    {
        internalcontext.pushState(targetKey, source);
        errors = ((Errors) (targetFactory.get(errors.withSource(targetKey), internalcontext, dependency, true)));
        internalcontext.popState();
        return errors;
        errors;
        internalcontext.popState();
        throw errors;
    }

    public void notify(Errors errors)
    {
        try
        {
            targetFactory = injector.getInternalFactory(targetKey, errors.withSource(source), InjectorImpl.JitLimitation.NEW_OR_EXISTING_JIT);
            return;
        }
        catch (ErrorsException errorsexception)
        {
            errors.merge(errorsexception.getErrors());
        }
    }

    public String toString()
    {
        return Objects.toStringHelper(com/google/inject/internal/FactoryProxy).add("key", key).add("provider", targetFactory).toString();
    }
}
