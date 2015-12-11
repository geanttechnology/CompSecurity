// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Key;

// Referenced classes of package com.google.inject.internal:
//            ContextualCallable, MembersInjectorImpl, ErrorsException, InternalContext, 
//            ProvisionListenerStackCallback, Errors

class val.toolableOnly
    implements ContextualCallable
{

    final MembersInjectorImpl this$0;
    final Errors val$errors;
    final Object val$instance;
    final Key val$key;
    final ProvisionListenerStackCallback val$provisionCallback;
    final Object val$source;
    final boolean val$toolableOnly;

    public volatile Object call(InternalContext internalcontext)
        throws ErrorsException
    {
        return call(internalcontext);
    }

    public Void call(final InternalContext context)
        throws ErrorsException
    {
        context.pushState(val$key, val$source);
        if (val$provisionCallback == null || !val$provisionCallback.hasListeners()) goto _L2; else goto _L1
_L1:
        val$provisionCallback.provision(val$errors, context, new ProvisionListenerStackCallback.ProvisionCallback() {

            final MembersInjectorImpl._cls1 this$1;
            final InternalContext val$context;

            public Object call()
            {
                injectMembers(instance, errors, context, toolableOnly);
                return instance;
            }

            
            {
                this$1 = MembersInjectorImpl._cls1.this;
                context = internalcontext;
                super();
            }
        });
_L4:
        context.popState();
        return null;
_L2:
        injectMembers(val$instance, val$errors, context, val$toolableOnly);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        context.popState();
        throw exception;
    }

    Callback()
    {
        this$0 = final_membersinjectorimpl;
        val$key = key1;
        val$source = obj;
        val$provisionCallback = provisionlistenerstackcallback;
        val$errors = errors1;
        val$instance = obj1;
        val$toolableOnly = Z.this;
        super();
    }
}
