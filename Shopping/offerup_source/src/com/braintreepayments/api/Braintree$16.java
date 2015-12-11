// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api;

import android.os.Handler;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.braintreepayments.api:
//            Braintree

class val.throwable
    implements tenerCallback
{

    final Braintree this$0;
    final Throwable val$throwable;

    public void execute()
    {
        class _cls1
            implements Runnable
        {

            final Braintree._cls16 this$1;
            final Braintree.ErrorListener val$listener;

            public void run()
            {
                listener.onUnrecoverableError(throwable);
            }

            _cls1()
            {
                this$1 = Braintree._cls16.this;
                listener = errorlistener;
                super();
            }
        }

        final orListener listener;
        for (Iterator iterator = Braintree.access$1300(Braintree.this).iterator(); iterator.hasNext(); Braintree.access$1000(Braintree.this).post(new _cls1()))
        {
            listener = (orListener)iterator.next();
        }

    }

    public boolean hasListeners()
    {
        return !Braintree.access$1300(Braintree.this).isEmpty();
    }

    _cls1()
    {
        this$0 = final_braintree;
        val$throwable = Throwable.this;
        super();
    }
}
