// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Binding;
import com.google.inject.Key;
import com.google.inject.Stage;
import com.google.inject.TypeLiteral;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import org.roboguice.shaded.goole.common.base.Preconditions;
import org.roboguice.shaded.goole.common.collect.Lists;
import org.roboguice.shaded.goole.common.collect.Maps;

// Referenced classes of package com.google.inject.internal:
//            ErrorsException, Errors, InjectorImpl, MembersInjectorStore, 
//            ProvisionListenerStackCallback, Initializables, ProvisionListenerCallbackStore, Initializable, 
//            MembersInjectorImpl

final class Initializer
{
    private class InjectableReference
        implements Initializable
    {

        private final InjectorImpl injector;
        private final Object instance;
        private final Key key;
        private final ProvisionListenerStackCallback provisionCallback;
        private final Object source;
        final Initializer this$0;

        public Object get(Errors errors)
            throws ErrorsException
        {
            boolean flag1 = true;
            if (ready.getCount() == 0L)
            {
                return instance;
            }
            if (Thread.currentThread() != creatingThread)
            {
                try
                {
                    ready.await();
                    errors = ((Errors) (instance));
                }
                // Misplaced declaration of an exception variable
                catch (Errors errors)
                {
                    throw new RuntimeException(errors);
                }
                return errors;
            }
            if (pendingInjection.remove(instance) != null)
            {
                MembersInjectorImpl membersinjectorimpl = (MembersInjectorImpl)pendingMembersInjectors.remove(instance);
                Object obj;
                Key key1;
                ProvisionListenerStackCallback provisionlistenerstackcallback;
                Object obj1;
                boolean flag;
                if (membersinjectorimpl != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                Preconditions.checkState(flag, "No membersInjector available for instance: %s, from key: %s", new Object[] {
                    instance, key
                });
                obj = instance;
                errors = errors.withSource(source);
                key1 = key;
                provisionlistenerstackcallback = provisionCallback;
                obj1 = source;
                if (injector.options.stage == Stage.TOOL)
                {
                    flag = flag1;
                } else
                {
                    flag = false;
                }
                membersinjectorimpl.injectAndNotify(obj, errors, key1, provisionlistenerstackcallback, obj1, flag);
            }
            return instance;
        }

        public String toString()
        {
            return instance.toString();
        }

        public MembersInjectorImpl validate(Errors errors)
            throws ErrorsException
        {
            TypeLiteral typeliteral = TypeLiteral.get(instance.getClass());
            return injector.membersInjectorStore.get(typeliteral, errors.withSource(source));
        }


        public InjectableReference(InjectorImpl injectorimpl, Object obj, Key key1, ProvisionListenerStackCallback provisionlistenerstackcallback, Object obj1)
        {
            this$0 = Initializer.this;
            super();
            injector = injectorimpl;
            key = key1;
            provisionCallback = provisionlistenerstackcallback;
            instance = Preconditions.checkNotNull(obj, "instance");
            source = Preconditions.checkNotNull(obj1, "source");
        }
    }


    private final Thread creatingThread = Thread.currentThread();
    private final Map pendingInjection = Maps.newIdentityHashMap();
    private final Map pendingMembersInjectors = Maps.newIdentityHashMap();
    private final CountDownLatch ready = new CountDownLatch(1);

    Initializer()
    {
    }

    void injectAll(Errors errors)
    {
        for (Iterator iterator = Lists.newArrayList(pendingInjection.values()).iterator(); iterator.hasNext();)
        {
            InjectableReference injectablereference = (InjectableReference)iterator.next();
            try
            {
                injectablereference.get(errors);
            }
            catch (ErrorsException errorsexception)
            {
                errors.merge(errorsexception.getErrors());
            }
        }

        if (!pendingInjection.isEmpty())
        {
            throw new AssertionError((new StringBuilder()).append("Failed to satisfy ").append(pendingInjection).toString());
        } else
        {
            ready.countDown();
            return;
        }
    }

    Initializable requestInjection(InjectorImpl injectorimpl, Object obj, Binding binding, Object obj1, Set set)
    {
        Object obj2 = null;
        Preconditions.checkNotNull(obj1);
        ProvisionListenerStackCallback provisionlistenerstackcallback;
        if (binding == null)
        {
            provisionlistenerstackcallback = null;
        } else
        {
            provisionlistenerstackcallback = injectorimpl.provisionListenerStore.get(binding);
        }
        if (obj == null || set.isEmpty() && !injectorimpl.membersInjectorStore.hasTypeListeners() && (provisionlistenerstackcallback == null || !provisionlistenerstackcallback.hasListeners()))
        {
            return Initializables.of(obj);
        }
        if (binding == null)
        {
            binding = obj2;
        } else
        {
            binding = binding.getKey();
        }
        injectorimpl = new InjectableReference(injectorimpl, obj, binding, provisionlistenerstackcallback, obj1);
        pendingInjection.put(obj, injectorimpl);
        return injectorimpl;
    }

    void validateOustandingInjections(Errors errors)
    {
        for (Iterator iterator = pendingInjection.values().iterator(); iterator.hasNext();)
        {
            InjectableReference injectablereference = (InjectableReference)iterator.next();
            try
            {
                pendingMembersInjectors.put(injectablereference.instance, injectablereference.validate(errors));
            }
            catch (ErrorsException errorsexception)
            {
                errors.merge(errorsexception.getErrors());
            }
        }

    }




}
