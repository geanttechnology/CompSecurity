// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.content.Context;
import com.arellomobile.android.push.utils.WorkerTask;
import com.arellomobile.android.push.utils.executor.ExecutorHelper;

// Referenced classes of package com.arellomobile.android.push:
//            DeviceFeature2_5, PushManager

class <init> extends WorkerTask
{

    final l.purchaseTime this$0;

    protected void doWork(Context context)
    {
        try
        {
            DeviceFeature2_5.trackInAppRequest(context, orderId, sku, purchaseTime);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    l.purchaseTime(Context context)
    {
        this$0 = this._cls0.this;
        super(context);
    }

    // Unreferenced inner class com/arellomobile/android/push/PushManager$10

/* anonymous class */
    static final class PushManager._cls10
        implements Runnable
    {

        final Context val$context;
        final String val$orderId;
        final long val$purchaseTime;
        final String val$sku;

        public void run()
        {
            ExecutorHelper.executeAsyncTask(new PushManager._cls10._cls1(context));
        }

            
            {
                context = context1;
                orderId = s;
                sku = s1;
                purchaseTime = l;
                super();
            }
    }

}
