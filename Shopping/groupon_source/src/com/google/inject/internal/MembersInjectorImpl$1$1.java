// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Key;

// Referenced classes of package com.google.inject.internal:
//            MembersInjectorImpl, InternalContext, ContextualCallable, ErrorsException, 
//            ProvisionListenerStackCallback, Errors

class val.context
    implements llback.ProvisionCallback
{

    final l.instance this$1;
    final InternalContext val$context;

    public Object call()
    {
        injectMembers(instance, errors, val$context, toolableOnly);
        return instance;
    }

    l.toolableOnly()
    {
        this$1 = final_toolableonly;
        val$context = InternalContext.this;
        super();
    }

    // Unreferenced inner class com/google/inject/internal/MembersInjectorImpl$1

/* anonymous class */
    class MembersInjectorImpl._cls1
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

        public Void call(InternalContext internalcontext)
            throws ErrorsException
        {
            internalcontext.pushState(key, source);
            if (provisionCallback == null || !provisionCallback.hasListeners()) goto _L2; else goto _L1
_L1:
            provisionCallback.provision(errors, internalcontext, internalcontext. new MembersInjectorImpl._cls1._cls1());
_L4:
            internalcontext.popState();
            return null;
_L2:
            injectMembers(instance, errors, internalcontext, toolableOnly);
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            internalcontext.popState();
            throw exception;
        }

            
            {
                this$0 = final_membersinjectorimpl;
                key = key1;
                source = obj;
                provisionCallback = provisionlistenerstackcallback;
                errors = errors1;
                instance = obj1;
                toolableOnly = Z.this;
                super();
            }
    }

}
