// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.downloads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.Executor;

// Referenced classes of package com.comcast.cim.downloads:
//            DownloadServiceManager

class this._cls0 extends BroadcastReceiver
{

    final DownloadServiceManager this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (isExternalStorageConnected())
        {
            if (!DownloadServiceManager.access$1300(DownloadServiceManager.this))
            {
                DownloadServiceManager.access$1302(DownloadServiceManager.this, true);
                backgroundExecutor.execute(new Runnable() {

                    final DownloadServiceManager._cls15 this$1;

                    public void run()
                    {
                        try
                        {
                            Thread.sleep(5000L);
                            if (DownloadServiceManager.access$1300(this$0))
                            {
                                DownloadServiceManager.access$1400(this$0);
                                DownloadServiceManager.access$1500(this$0);
                            }
                            return;
                        }
                        catch (InterruptedException interruptedexception)
                        {
                            return;
                        }
                    }

            
            {
                this$1 = DownloadServiceManager._cls15.this;
                super();
            }
                });
            }
            return;
        } else
        {
            DownloadServiceManager.access$1302(DownloadServiceManager.this, false);
            return;
        }
    }

    _cls1.this._cls1()
    {
        this$0 = DownloadServiceManager.this;
        super();
    }
}
