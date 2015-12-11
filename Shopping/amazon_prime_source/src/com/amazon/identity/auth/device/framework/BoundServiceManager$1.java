// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.platform.metric.MetricsHelper;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            BoundServiceManager

class this._cls0
    implements Runnable
{

    final BoundServiceManager this$0;

    public void run()
    {
label0:
        {
            synchronized (BoundServiceManager.this)
            {
                if (BoundServiceManager.access$000(BoundServiceManager.this) == null)
                {
                    break label0;
                }
            }
            return;
        }
        Object obj1;
        MAPLog.e(BoundServiceManager.access$100(), (new StringBuilder("Application timed out trying to bind to ")).append(BoundServiceManager.access$200(BoundServiceManager.this)).toString());
        obj1 = BoundServiceManager.access$300(BoundServiceManager.this);
        BoundServiceManager.access$302$39f4b877(BoundServiceManager.this);
        obj;
        JVM INSTR monitorexit ;
        if (obj1 != null)
        {
            MetricsHelper.incrementCounter("BindTimeout", new String[0]);
            for (obj = ((List) (obj1)).iterator(); ((Iterator) (obj)).hasNext(); BoundServiceManager.access$500(BoundServiceManager.this).execute(new ErrorRunnable(nnableBoundServiceCallback.access._mth400(((nnableBoundServiceCallback) (obj1))))))
            {
                obj1 = (nnableBoundServiceCallback)((Iterator) (obj)).next();
            }

        }
        break MISSING_BLOCK_LABEL_136;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ErrorRunnable()
    {
        this$0 = BoundServiceManager.this;
        super();
    }
}
