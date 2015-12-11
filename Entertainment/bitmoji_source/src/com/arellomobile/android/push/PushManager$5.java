// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.content.Context;
import com.arellomobile.android.push.utils.WorkerTask;
import com.arellomobile.android.push.utils.executor.ExecutorHelper;

// Referenced classes of package com.arellomobile.android.push:
//            PushManager, DeviceFeature2_5

static final class val.action
    implements Runnable
{

    final String val$action;
    final Context val$context;
    final String val$major;
    final String val$minor;
    final String val$proximityUuid;

    public void run()
    {
        ExecutorHelper.executeAsyncTask(new WorkerTask(val$context) {

            final PushManager._cls5 this$0;

            protected void doWork(Context context1)
            {
                try
                {
                    DeviceFeature2_5.processBeacon(context1, proximityUuid, major, minor, action);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context1)
                {
                    context1.printStackTrace();
                }
            }

            
            {
                this$0 = PushManager._cls5.this;
                super(context1);
            }
        });
    }

    sk(Context context1, String s, String s1, String s2, String s3)
    {
        val$context = context1;
        val$proximityUuid = s;
        val$major = s1;
        val$minor = s2;
        val$action = s3;
        super();
    }
}
