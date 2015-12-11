// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Stage;
import com.google.inject.spi.InjectionPoint;
import java.util.Iterator;
import org.roboguice.shaded.goole.common.collect.ImmutableList;

// Referenced classes of package com.google.inject.internal:
//            ContextualCallable, InjectionRequestProcessor, ErrorsException, SingleMemberInjector, 
//            InjectorImpl, InternalContext

class this._cls1
    implements ContextualCallable
{

    final jector this$1;

    public volatile Object call(InternalContext internalcontext)
        throws ErrorsException
    {
        return call(internalcontext);
    }

    public Void call(InternalContext internalcontext)
    {
        org.roboguice.shaded.goole.common.collect.UnmodifiableIterator unmodifiableiterator = mberInjectors.iterator();
        do
        {
            if (!unmodifiableiterator.hasNext())
            {
                break;
            }
            SingleMemberInjector singlememberinjector = (SingleMemberInjector)unmodifiableiterator.next();
            if (jector.options.jector != Stage.TOOL || singlememberinjector.getInjectionPoint().isToolable())
            {
                singlememberinjector.inject(errors, internalcontext, null);
            }
        } while (true);
        return null;
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
