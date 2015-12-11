// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.downloads;

import com.penthera.virtuososdk.client.IDownloadedObserver;
import com.penthera.virtuososdk.client.Virtuoso;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

// Referenced classes of package com.comcast.cim.downloads:
//            DownloadServiceManager

class this._cls0
    implements IDownloadedObserver
{

    final DownloadServiceManager this$0;

    public void engineDownloadedListChanged()
    {
        backgroundExecutor.execute(new DownloadServiceManager.UpdateDownloadableFileMapTask(DownloadServiceManager.access$500(DownloadServiceManager.this).downloadedRootList(), DownloadServiceManager.access$600(DownloadServiceManager.this)) {

            final DownloadServiceManager._cls3 this$1;

            protected void onFileMapRetrieved()
            {
                DownloadServiceManager.access$702(this$0, true);
            }

            
            {
                this$1 = DownloadServiceManager._cls3.this;
                super(this$0, list, map);
            }
        });
    }

    this._cls0()
    {
        this$0 = DownloadServiceManager.this;
        super();
    }
}
