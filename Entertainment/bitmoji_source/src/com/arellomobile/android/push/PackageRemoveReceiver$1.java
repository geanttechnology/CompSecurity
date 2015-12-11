// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.content.Context;
import com.arellomobile.android.push.utils.WorkerTask;
import com.arellomobile.android.push.utils.executor.ExecutorHelper;

// Referenced classes of package com.arellomobile.android.push:
//            PackageRemoveReceiver, DeviceFeature2_5

class val.packageName
    implements Runnable
{

    final PackageRemoveReceiver this$0;
    final Context val$context;
    final String val$packageName;

    public void run()
    {
        ExecutorHelper.executeAsyncTask(new WorkerTask(val$context) {

            final PackageRemoveReceiver._cls1 this$1;

            protected void doWork(Context context1)
            {
                try
                {
                    DeviceFeature2_5.sendAppRemovedData(context1, packageName);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context1)
                {
                    return;
                }
            }

            
            {
                this$1 = PackageRemoveReceiver._cls1.this;
                super(context1);
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = final_packageremovereceiver;
        val$context = context1;
        val$packageName = String.this;
        super();
    }
}
