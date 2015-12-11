// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.content.Context;
import com.arellomobile.android.push.utils.WorkerTask;
import com.arellomobile.android.push.utils.executor.ExecutorHelper;

// Referenced classes of package com.arellomobile.android.push:
//            PushManager, DeviceFeature2_5

class val.context
    implements Runnable
{

    final PushManager this$0;
    final Context val$context;

    public void run()
    {
        ExecutorHelper.executeAsyncTask(new WorkerTask(val$context) {

            final PushManager._cls8 this$1;

            protected void doWork(Context context1)
            {
                try
                {
                    DeviceFeature2_5.sendAppOpen(context1);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context1)
                {
                    return;
                }
            }

            
            {
                this$1 = PushManager._cls8.this;
                super(context1);
            }
        });
    }

    sk()
    {
        this$0 = final_pushmanager;
        val$context = Context.this;
        super();
    }
}
