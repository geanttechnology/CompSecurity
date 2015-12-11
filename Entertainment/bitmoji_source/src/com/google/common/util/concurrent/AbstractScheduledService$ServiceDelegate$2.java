// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import java.util.concurrent.Future;
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
        startUp();
        cess._mth302(this._cls1.this, scheduler().(AbstractScheduledService.access$500(_fld0), cess._mth600(this._cls1.this), cess._mth700(this._cls1.this)));
        tifyStarted();
        cess._mth200(this._cls1.this).unlock();
        return;
        Object obj;
        obj;
        tifyFailed(((Throwable) (obj)));
        if (cess._mth300(this._cls1.this) != null)
        {
            cess._mth300(this._cls1.this).cancel(false);
        }
        cess._mth200(this._cls1.this).unlock();
        return;
        obj;
        cess._mth200(this._cls1.this).unlock();
        throw obj;
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
