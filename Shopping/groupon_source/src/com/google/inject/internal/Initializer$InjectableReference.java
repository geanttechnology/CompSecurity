// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Key;
import com.google.inject.Stage;
import com.google.inject.TypeLiteral;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package com.google.inject.internal:
//            Initializable, Initializer, ErrorsException, MembersInjectorImpl, 
//            Errors, InjectorImpl, MembersInjectorStore, ProvisionListenerStackCallback

private class otNull
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
        if (Initializer.access$100(Initializer.this).getCount() == 0L)
        {
            return instance;
        }
        if (Thread.currentThread() != Initializer.access$200(Initializer.this))
        {
            try
            {
                Initializer.access$100(Initializer.this).await();
                errors = ((Errors) (instance));
            }
            // Misplaced declaration of an exception variable
            catch (Errors errors)
            {
                throw new RuntimeException(errors);
            }
            return errors;
        }
        if (Initializer.access$300(Initializer.this).remove(instance) != null)
        {
            MembersInjectorImpl membersinjectorimpl = (MembersInjectorImpl)Initializer.access$400(Initializer.this).remove(instance);
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
            if (injector.options.ge == Stage.TOOL)
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


    public (InjectorImpl injectorimpl, Object obj, Key key1, ProvisionListenerStackCallback provisionlistenerstackcallback, Object obj1)
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
