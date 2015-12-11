// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.content;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.ebay.nautilus.shell.content:
//            FwAsyncTask

class rkerRunnable extends rkerRunnable
{

    final FwAsyncTask this$0;

    public Object call()
        throws Exception
    {
        FwAsyncTask.access$200(FwAsyncTask.this).set(true);
        Process.setThreadPriority(10);
        return FwAsyncTask.access$300(FwAsyncTask.this, doInBackground(mParams));
    }

    rkerRunnable()
    {
        this$0 = FwAsyncTask.this;
        super(null);
    }
}
