// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.arellomobile.android.push.utils.WorkerTask;
import com.arellomobile.android.push.utils.executor.ExecutorHelper;

// Referenced classes of package com.arellomobile.android.push:
//            DeviceFeature2_5

public class PackageRemoveReceiver extends BroadcastReceiver
{

    public PackageRemoveReceiver()
    {
    }

    private void sendPackageRemoved(final Context context, final String packageName)
    {
        (new Handler(context.getMainLooper())).post(new Runnable() {

            final PackageRemoveReceiver this$0;
            final Context val$context;
            final String val$packageName;

            public void run()
            {
                ExecutorHelper.executeAsyncTask(new WorkerTask(context) {

                    final _cls1 this$1;

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

            
            {
                this$1 = _cls1.this;
                super(context);
            }
                });
            }

            
            {
                this$0 = PackageRemoveReceiver.this;
                context = context1;
                packageName = s;
                super();
            }
        });
    }

    public void onReceive(Context context, Intent intent)
    {
        if ("android.intent.action.PACKAGE_REMOVED".equals(intent.getAction()))
        {
            intent = intent.getData();
            if (intent != null)
            {
                intent = intent.getSchemeSpecificPart();
            } else
            {
                intent = null;
            }
            if (intent != null)
            {
                sendPackageRemoved(context, intent);
                return;
            }
        }
    }
}
