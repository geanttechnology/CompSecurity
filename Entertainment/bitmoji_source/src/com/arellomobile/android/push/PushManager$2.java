// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.content.Context;
import com.arellomobile.android.push.utils.WorkerTask;
import com.arellomobile.android.push.utils.executor.ExecutorHelper;

// Referenced classes of package com.arellomobile.android.push:
//            PushManager, DeviceFeature2_5

static final class val.listener
    implements Runnable
{

    final Context val$context;
    final tTagsListener val$listener;

    public void run()
    {
        ExecutorHelper.executeAsyncTask(new WorkerTask(val$context) {

            final PushManager._cls2 this$0;

            protected void doWork(Context context1)
            {
                try
                {
                    context1 = DeviceFeature2_5.getTags(context1);
                    listener.onTagsReceived(context1);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context1)
                {
                    listener.onError(context1);
                }
            }

            
            {
                this$0 = PushManager._cls2.this;
                super(context1);
            }
        });
    }

    tTagsListener(Context context1, tTagsListener ttagslistener)
    {
        val$context = context1;
        val$listener = ttagslistener;
        super();
    }
}
