// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Binding;
import com.google.inject.ProvisionException;
import com.google.inject.spi.ProvisionListener;
import java.util.List;
import java.util.Set;
import org.roboguice.shaded.goole.common.collect.ImmutableList;
import org.roboguice.shaded.goole.common.collect.Sets;

// Referenced classes of package com.google.inject.internal:
//            ErrorsException, Errors, InternalContext

final class ProvisionListenerStackCallback
{
    private class Provision extends com.google.inject.spi.ProvisionListener.ProvisionInvocation
    {

        final ProvisionCallback callable;
        final InternalContext context;
        ProvisionListener erredListener;
        final Errors errors;
        ErrorsException exceptionDuringProvision;
        int index;
        Object result;
        final ProvisionListenerStackCallback this$0;

        public Binding getBinding()
        {
            return binding;
        }

        public List getDependencyChain()
        {
            return context.getDependencyChain();
        }

        public Object provision()
        {
            index = index + 1;
            if (index != listeners.length) goto _L2; else goto _L1
_L1:
            try
            {
                result = callable.call();
            }
            catch (ErrorsException errorsexception)
            {
                exceptionDuringProvision = errorsexception;
                throw new ProvisionException(errors.merge(errorsexception.getErrors()).getMessages());
            }
_L4:
            return result;
_L2:
            if (index >= listeners.length)
            {
                break; /* Loop/switch isn't completed */
            }
            int i = index;
            try
            {
                listeners[index].onProvision(this);
            }
            catch (RuntimeException runtimeexception)
            {
                erredListener = listeners[i];
                throw runtimeexception;
            }
            if (i == index)
            {
                provision();
            }
            if (true) goto _L4; else goto _L3
_L3:
            throw new IllegalStateException("Already provisioned in this listener.");
        }

        public Provision(Errors errors1, InternalContext internalcontext, ProvisionCallback provisioncallback)
        {
            this$0 = ProvisionListenerStackCallback.this;
            super();
            index = -1;
            callable = provisioncallback;
            context = internalcontext;
            errors = errors1;
        }
    }

    public static interface ProvisionCallback
    {

        public abstract Object call()
            throws ErrorsException;
    }


    private static final ProvisionListenerStackCallback EMPTY_CALLBACK = new ProvisionListenerStackCallback(null, ImmutableList.of());
    private static final ProvisionListener EMPTY_LISTENER[] = new ProvisionListener[0];
    private final Binding binding;
    private final ProvisionListener listeners[];

    public ProvisionListenerStackCallback(Binding binding1, List list)
    {
        binding = binding1;
        if (list.isEmpty())
        {
            listeners = EMPTY_LISTENER;
            return;
        } else
        {
            binding1 = Sets.newLinkedHashSet(list);
            listeners = (ProvisionListener[])binding1.toArray(new ProvisionListener[binding1.size()]);
            return;
        }
    }

    public static ProvisionListenerStackCallback emptyListener()
    {
        return EMPTY_CALLBACK;
    }

    public boolean hasListeners()
    {
        return listeners.length > 0;
    }

    public Object provision(Errors errors, InternalContext internalcontext, ProvisionCallback provisioncallback)
        throws ErrorsException
    {
        provisioncallback = new Provision(errors, internalcontext, provisioncallback);
        internalcontext = null;
        try
        {
            provisioncallback.provision();
        }
        // Misplaced declaration of an exception variable
        catch (InternalContext internalcontext) { }
        if (((Provision) (provisioncallback)).exceptionDuringProvision != null)
        {
            throw ((Provision) (provisioncallback)).exceptionDuringProvision;
        }
        if (internalcontext != null)
        {
            if (((Provision) (provisioncallback)).erredListener != null)
            {
                provisioncallback = ((Provision) (provisioncallback)).erredListener.getClass();
            } else
            {
                provisioncallback = "(unknown)";
            }
            throw errors.errorInUserCode(internalcontext, "Error notifying ProvisionListener %s of %s.%n Reason: %s", new Object[] {
                provisioncallback, binding.getKey(), internalcontext
            }).toException();
        } else
        {
            return ((Provision) (provisioncallback)).result;
        }
    }



}
