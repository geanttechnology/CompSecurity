// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.google.common.util.concurrent:
//            AbstractScheduledService

class this._cls1
    implements Runnable
{

    final this._cls1 this$1;

    public void run()
    {
        cess._mth200(this._cls1.this).lock();
        this._cls1 _lcls1;
        this._cls1 _lcls1_1;
        _lcls1 = ate();
        _lcls1_1 = ate;
        if (_lcls1 != _lcls1_1)
        {
            try
            {
                cess._mth200(this._cls1.this).unlock();
                return;
            }
            catch (Throwable throwable)
            {
                tifyFailed(throwable);
            }
            break MISSING_BLOCK_LABEL_75;
        }
        shutDown();
        cess._mth200(this._cls1.this).unlock();
        tifyStopped();
        return;
        return;
        Exception exception;
        exception;
        cess._mth200(this._cls1.this).unlock();
        throw exception;
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
