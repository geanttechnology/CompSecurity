// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.interactors;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.gallery.thor.interactors:
//            ThisDayInteractor

class this._cls0 extends ThreadPoolExecutor
{

    final this._cls0 this$0;

    protected void afterExecute(Runnable runnable, Throwable throwable)
    {
        super.afterExecute(runnable, throwable);
        runnable = ((this._cls0)runnable).tTaskType();
        cess._mth500(this._cls0.this, runnable);
    }

    (int i, int j, long l, TimeUnit timeunit, BlockingQueue blockingqueue, 
            ThreadFactory threadfactory)
    {
        this$0 = this._cls0.this;
        super(i, j, l, timeunit, blockingqueue, threadfactory);
    }
}
