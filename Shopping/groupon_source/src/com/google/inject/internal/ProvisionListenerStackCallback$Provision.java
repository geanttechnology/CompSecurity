// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Binding;
import com.google.inject.ProvisionException;
import com.google.inject.spi.ProvisionListener;
import java.util.List;

// Referenced classes of package com.google.inject.internal:
//            ProvisionListenerStackCallback, InternalContext, ErrorsException, Errors

private class errors extends com.google.inject.spi.sion
{

    final allback callable;
    final InternalContext context;
    ProvisionListener erredListener;
    final Errors errors;
    ErrorsException exceptionDuringProvision;
    int index;
    Object result;
    final ProvisionListenerStackCallback this$0;

    public Binding getBinding()
    {
        return ProvisionListenerStackCallback.access$100(ProvisionListenerStackCallback.this);
    }

    public List getDependencyChain()
    {
        return context.getDependencyChain();
    }

    public Object provision()
    {
        index = index + 1;
        if (index != ProvisionListenerStackCallback.access$000(ProvisionListenerStackCallback.this).length) goto _L2; else goto _L1
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
        if (index >= ProvisionListenerStackCallback.access$000(ProvisionListenerStackCallback.this).length)
        {
            break; /* Loop/switch isn't completed */
        }
        int i = index;
        try
        {
            ProvisionListenerStackCallback.access$000(ProvisionListenerStackCallback.this)[index].onProvision(this);
        }
        catch (RuntimeException runtimeexception)
        {
            erredListener = ProvisionListenerStackCallback.access$000(ProvisionListenerStackCallback.this)[i];
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

    public allback(Errors errors1, InternalContext internalcontext, allback allback)
    {
        this$0 = ProvisionListenerStackCallback.this;
        super();
        index = -1;
        callable = allback;
        context = internalcontext;
        errors = errors1;
    }
}
