// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import org.roboguice.shaded.goole.common.collect.ImmutableSet;

// Referenced classes of package com.google.inject.internal:
//            ErrorsException, SingleParameterInjector, ConstructionProxy, ConstructionContext, 
//            MembersInjectorImpl, Errors, InternalContext, ProvisionListenerStackCallback

final class ConstructorInjector
{

    private final ConstructionProxy constructionProxy;
    private final ImmutableSet injectableMembers;
    private final MembersInjectorImpl membersInjector;
    private final SingleParameterInjector parameterInjectors[];

    ConstructorInjector(Set set, ConstructionProxy constructionproxy, SingleParameterInjector asingleparameterinjector[], MembersInjectorImpl membersinjectorimpl)
    {
        injectableMembers = ImmutableSet.copyOf(set);
        constructionProxy = constructionproxy;
        parameterInjectors = asingleparameterinjector;
        membersInjector = membersinjectorimpl;
    }

    private Object provision(Errors errors, InternalContext internalcontext, ConstructionContext constructioncontext)
        throws ErrorsException
    {
        Object obj;
        Object aobj[] = SingleParameterInjector.getAll(errors, internalcontext, parameterInjectors);
        obj = constructionProxy.newInstance(aobj);
        constructioncontext.setProxyDelegates(obj);
        constructioncontext.finishConstruction();
        constructioncontext.setCurrentReference(obj);
        membersInjector.injectMembers(obj, errors, internalcontext, false);
        membersInjector.notifyListeners(obj, errors);
        constructioncontext.removeCurrentReference();
        return obj;
        internalcontext;
        try
        {
            constructioncontext.finishConstruction();
            throw internalcontext;
        }
        // Misplaced declaration of an exception variable
        catch (InternalContext internalcontext) { }
        finally
        {
            constructioncontext.removeCurrentReference();
        }
        if (internalcontext.getCause() != null)
        {
            internalcontext = internalcontext.getCause();
        }
        throw errors.withSource(constructionProxy.getInjectionPoint()).errorInjectingConstructor(internalcontext).toException();
        throw errors;
    }

    Object construct(final Errors errors, final InternalContext context, Class class1, boolean flag, ProvisionListenerStackCallback provisionlistenerstackcallback)
        throws ErrorsException
    {
        final ConstructionContext constructionContext = context.getConstructionContext(this);
        if (!constructionContext.isConstructing()) goto _L2; else goto _L1
_L1:
        if (!flag)
        {
            throw errors.circularProxiesDisabled(class1).toException();
        }
        class1 = ((Class) (constructionContext.createProxy(errors, class1)));
_L4:
        return class1;
_L2:
        Object obj;
        obj = constructionContext.getCurrentReference();
        class1 = ((Class) (obj));
        if (obj != null) goto _L4; else goto _L3
_L3:
        constructionContext.startConstruction();
        if (provisionlistenerstackcallback.hasListeners())
        {
            break MISSING_BLOCK_LABEL_83;
        }
        errors = ((Errors) (provision(errors, context, constructionContext)));
        constructionContext.finishConstruction();
        return errors;
        errors = ((Errors) (provisionlistenerstackcallback.provision(errors, context, new ProvisionListenerStackCallback.ProvisionCallback() {

            final ConstructorInjector this$0;
            final ConstructionContext val$constructionContext;
            final InternalContext val$context;
            final Errors val$errors;

            public Object call()
                throws ErrorsException
            {
                return provision(errors, context, constructionContext);
            }

            
            {
                this$0 = ConstructorInjector.this;
                errors = errors1;
                context = internalcontext;
                constructionContext = constructioncontext;
                super();
            }
        })));
        constructionContext.finishConstruction();
        return errors;
        errors;
        constructionContext.finishConstruction();
        throw errors;
    }

    ConstructionProxy getConstructionProxy()
    {
        return constructionProxy;
    }

    public ImmutableSet getInjectableMembers()
    {
        return injectableMembers;
    }

}
