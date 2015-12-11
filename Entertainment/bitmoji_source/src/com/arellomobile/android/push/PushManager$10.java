// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.content.Context;
import com.arellomobile.android.push.utils.WorkerTask;
import com.arellomobile.android.push.utils.executor.ExecutorHelper;

// Referenced classes of package com.arellomobile.android.push:
//            PushManager, DeviceFeature2_5

static final class val.purchaseTime
    implements Runnable
{

    final Context val$context;
    final String val$orderId;
    final long val$purchaseTime;
    final String val$sku;

    public void run()
    {
        ExecutorHelper.executeAsyncTask(new WorkerTask(val$context) {

            final PushManager._cls10 this$0;

            protected void doWork(Context context1)
            {
                try
                {
                    DeviceFeature2_5.trackInAppRequest(context1, orderId, sku, purchaseTime);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context1)
                {
                    return;
                }
            }

            
            {
                this$0 = PushManager._cls10.this;
                super(context1);
            }
        });
    }

    k(Context context1, String s, String s1, long l)
    {
        val$context = context1;
        val$orderId = s;
        val$sku = s1;
        val$purchaseTime = l;
        super();
    }
}
