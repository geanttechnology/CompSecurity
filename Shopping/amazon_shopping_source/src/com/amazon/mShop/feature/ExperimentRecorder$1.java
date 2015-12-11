// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.feature;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.mShop.feature:
//            ExperimentRecorder

class this._cls0
    implements Runnable
{

    final ExperimentRecorder this$0;

    public void run()
    {
        try
        {
            ExperimentRecorder.access$400(ExperimentRecorder.this).getAndSet(false);
            ExperimentRecorder.access$500(ExperimentRecorder.this);
            return;
        }
        catch (Exception exception)
        {
            Log.e(ExperimentRecorder.access$600(), "Failed to send events", exception);
        }
    }

    ()
    {
        this$0 = ExperimentRecorder.this;
        super();
    }
}
