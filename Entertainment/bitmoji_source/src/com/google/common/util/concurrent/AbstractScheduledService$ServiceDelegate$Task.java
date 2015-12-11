// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.google.common.util.concurrent:
//            AbstractScheduledService

class this._cls1
    implements Runnable
{

    final this._cls1 this$1;

    public void run()
    {
        s._mth200(this._cls1.this).lock();
        boolean flag = s._mth300(this._cls1.this).isCancelled();
        if (flag)
        {
            s._mth200(this._cls1.this).unlock();
            return;
        }
        runOneIteration();
        s._mth200(this._cls1.this).unlock();
        return;
        Object obj;
        obj;
        shutDown();
_L1:
        yFailed(((Throwable) (obj)));
        s._mth300(this._cls1.this).cancel(false);
        s._mth200(this._cls1.this).unlock();
        return;
        Exception exception;
        exception;
        AbstractScheduledService.access$400().log(Level.WARNING, "Error while attempting to shut down the service after failure.", exception);
          goto _L1
        obj;
        s._mth200(this._cls1.this).unlock();
        throw obj;
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
