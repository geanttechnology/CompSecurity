// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.downloads;

import com.penthera.virtuososdk.client.IQueueObserver;
import com.penthera.virtuososdk.client.IVirtuosoAsset;
import com.penthera.virtuososdk.client.IVirtuosoIdentifier;
import com.penthera.virtuososdk.client.Virtuoso;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.slf4j.Logger;

// Referenced classes of package com.comcast.cim.downloads:
//            DownloadServiceManager

class this._cls0
    implements IQueueObserver
{

    final DownloadServiceManager this$0;

    public void downloadEngineDidFinishDownloadingFile(final IVirtuosoIdentifier file)
    {
        DownloadServiceManager.access$000().debug("Callback downloadEngineDidFinishDownloadingFile");
        if (file.type() == 4)
        {
            file = (IVirtuosoAsset)file;
            backgroundExecutor.execute(new Runnable() {

                final DownloadServiceManager._cls4 this$1;
                final IVirtuosoAsset val$file;

                public void run()
                {
                    DownloadServiceManager.access$000().debug((new StringBuilder()).append("File Progress is : ").append(file.currentSize()).append(":").append(file.expectedSize()).append(", percent complete: ").append(file.fractionComplete()).toString());
                    DownloadFile downloadfile = DownloadServiceManager.access$800(this$0, file);
                    DownloadServiceManager.access$900(this$0).put(file.uuid(), downloadfile);
                    onFileDownloadFinished(downloadfile);
                }

            
            {
                this$1 = DownloadServiceManager._cls4.this;
                file = ivirtuosoasset;
                super();
            }
            });
        }
    }

    public void downloadEngineDidStartDownloadingFile(final IVirtuosoIdentifier file)
    {
        DownloadServiceManager.access$000().debug("Callback downloadEngineDidStartDownloadingFile");
        if (file.type() == 4)
        {
            file = (IVirtuosoAsset)file;
            backgroundExecutor.execute(new Runnable() {

                final DownloadServiceManager._cls4 this$1;
                final IVirtuosoAsset val$file;

                public void run()
                {
                    DownloadFile downloadfile = DownloadServiceManager.access$800(this$0, file);
                    DownloadServiceManager.access$900(this$0).put(file.uuid(), downloadfile);
                    onFileDownloadStarted(downloadfile);
                }

            
            {
                this$1 = DownloadServiceManager._cls4.this;
                file = ivirtuosoasset;
                super();
            }
            });
        }
    }

    public void downloadEngineFileWithError(final IVirtuosoIdentifier file)
    {
        DownloadServiceManager.access$000().debug("Callback downloadEngineFileWithError");
        if (file.type() == 4)
        {
            file = (IVirtuosoAsset)file;
            backgroundExecutor.execute(new Runnable() {

                final DownloadServiceManager._cls4 this$1;
                final IVirtuosoAsset val$file;

                public void run()
                {
                    DownloadFile downloadfile = DownloadServiceManager.access$800(this$0, file);
                    DownloadServiceManager.access$900(this$0).put(file.uuid(), downloadfile);
                    onFileDownloadError(downloadfile);
                }

            
            {
                this$1 = DownloadServiceManager._cls4.this;
                file = ivirtuosoasset;
                super();
            }
            });
        }
    }

    public void downloadEngineProgressUpdatedForFile(final IVirtuosoIdentifier file)
    {
        DownloadServiceManager.access$000().debug("Callback downloadEngineProgressUpdatedForFile");
        if (file.type() == 4)
        {
            file = (IVirtuosoAsset)file;
            backgroundExecutor.execute(new Runnable() {

                final DownloadServiceManager._cls4 this$1;
                final IVirtuosoAsset val$file;

                public void run()
                {
                    DownloadFile downloadfile = DownloadServiceManager.access$800(this$0, file);
                    DownloadServiceManager.access$900(this$0).put(file.uuid(), downloadfile);
                    onFileProgressUpdated(downloadfile);
                }

            
            {
                this$1 = DownloadServiceManager._cls4.this;
                file = ivirtuosoasset;
                super();
            }
            });
        }
    }

    public void engineDownloadQueueChanged()
    {
        backgroundExecutor.execute(new DownloadServiceManager.UpdateDownloadableFileMapTask(DownloadServiceManager.access$500(DownloadServiceManager.this).queuedRootList(), DownloadServiceManager.access$900(DownloadServiceManager.this)) {

            final DownloadServiceManager._cls4 this$1;

            protected void onFileMapRetrieved()
            {
                DownloadServiceManager.access$1002(this$0, true);
            }

            
            {
                this$1 = DownloadServiceManager._cls4.this;
                super(this$0, list, map);
            }
        });
    }

    public void fragmentComplete(final IVirtuosoIdentifier file)
    {
        DownloadServiceManager.access$000().debug("Callback downloadEngineProgressUpdatedForFile");
        if (file.type() == 4)
        {
            file = (IVirtuosoAsset)file;
            backgroundExecutor.execute(new Runnable() {

                final DownloadServiceManager._cls4 this$1;
                final IVirtuosoAsset val$file;

                public void run()
                {
                    DownloadFile downloadfile = DownloadServiceManager.access$800(this$0, file);
                    DownloadServiceManager.access$900(this$0).put(file.uuid(), downloadfile);
                    onFileProgressUpdated(downloadfile);
                }

            
            {
                this$1 = DownloadServiceManager._cls4.this;
                file = ivirtuosoasset;
                super();
            }
            });
        }
    }

    this._cls0()
    {
        this$0 = DownloadServiceManager.this;
        super();
    }
}
