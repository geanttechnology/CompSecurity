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

class is._cls0 extends teDownloadableFileMapTask
{

    final is._cls0 this$1;

    protected void onFileMapRetrieved()
    {
        DownloadServiceManager.access$702(_fld0, true);
    }

    is._cls0(List list, Map map)
    {
        this$1 = this._cls1.this;
        super(_fld0, list, map);
    }

    // Unreferenced inner class com/comcast/cim/downloads/DownloadServiceManager$3

/* anonymous class */
    class DownloadServiceManager._cls3
        implements IDownloadedObserver
    {

        final DownloadServiceManager this$0;

        public void engineDownloadedListChanged()
        {
            backgroundExecutor.execute(new DownloadServiceManager._cls3._cls1(DownloadServiceManager.access$500(DownloadServiceManager.this).downloadedRootList(), DownloadServiceManager.access$600(DownloadServiceManager.this)));
        }

            
            {
                this$0 = DownloadServiceManager.this;
                super();
            }
    }

}
