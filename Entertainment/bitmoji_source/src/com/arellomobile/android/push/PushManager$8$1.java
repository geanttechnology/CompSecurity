// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.content.Context;
import com.arellomobile.android.push.utils.WorkerTask;
import com.arellomobile.android.push.utils.executor.ExecutorHelper;

// Referenced classes of package com.arellomobile.android.push:
//            DeviceFeature2_5, PushManager

class  extends WorkerTask
{

    final .sendAppOpen this$1;

    protected void doWork(Context context)
    {
        try
        {
            DeviceFeature2_5.sendAppOpen(context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    l.context(Context context1)
    {
        this$1 = this._cls1.this;
        super(context1);
    }

    // Unreferenced inner class com/arellomobile/android/push/PushManager$8

/* anonymous class */
    class PushManager._cls8
        implements Runnable
    {

        final PushManager this$0;
        final Context val$context;

        public void run()
        {
            ExecutorHelper.executeAsyncTask(new PushManager._cls8._cls1(context));
        }

            
            {
                this$0 = final_pushmanager;
                context = Context.this;
                super();
            }
    }

}
