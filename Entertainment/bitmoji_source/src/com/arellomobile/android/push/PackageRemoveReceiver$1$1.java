// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.content.Context;
import com.arellomobile.android.push.utils.WorkerTask;
import com.arellomobile.android.push.utils.executor.ExecutorHelper;

// Referenced classes of package com.arellomobile.android.push:
//            DeviceFeature2_5, PackageRemoveReceiver

class this._cls1 extends WorkerTask
{

    final l.packageName this$1;

    protected void doWork(Context context)
    {
        try
        {
            DeviceFeature2_5.sendAppRemovedData(context, packageName);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    l.packageName(Context context)
    {
        this$1 = this._cls1.this;
        super(context);
    }

    // Unreferenced inner class com/arellomobile/android/push/PackageRemoveReceiver$1

/* anonymous class */
    class PackageRemoveReceiver._cls1
        implements Runnable
    {

        final PackageRemoveReceiver this$0;
        final Context val$context;
        final String val$packageName;

        public void run()
        {
            ExecutorHelper.executeAsyncTask(new PackageRemoveReceiver._cls1._cls1(context));
        }

            
            {
                this$0 = final_packageremovereceiver;
                context = context1;
                packageName = String.this;
                super();
            }
    }

}
