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

    final eaconsListener.onBeaconsError this$0;

    protected void doWork(Context context)
    {
        try
        {
            context = DeviceFeature2_5.getBeacons(context);
            listener.onBeaconsReceived(context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            listener.onBeaconsError(context);
        }
    }

    l.listener(Context context)
    {
        this$0 = this._cls0.this;
        super(context);
    }

    // Unreferenced inner class com/arellomobile/android/push/PushManager$4

/* anonymous class */
    static final class PushManager._cls4
        implements Runnable
    {

        final Context val$context;
        final PushManager.GetBeaconsListener val$listener;

        public void run()
        {
            ExecutorHelper.executeAsyncTask(new PushManager._cls4._cls1(context));
        }

            
            {
                context = context1;
                listener = getbeaconslistener;
                super();
            }
    }

}
