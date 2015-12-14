// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.net.Uri;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.ThreadUtils;
import java.io.File;

// Referenced classes of package com.millennialmedia.internal.video:
//            VASTVideoView, MMVideoView

class val.downloadedFile
    implements Runnable
{

    final is._cls0 this$1;
    final File val$downloadedFile;

    public void run()
    {
        VASTVideoView.access$1402(_fld0, val$downloadedFile);
        VASTVideoView.access$300(_fld0).setVideoURI(Uri.parse(val$downloadedFile.getAbsolutePath()));
        VASTVideoView.access$1500(_fld0);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$downloadedFile = File.this;
        super();
    }

    // Unreferenced inner class com/millennialmedia/internal/video/VASTVideoView$6

/* anonymous class */
    class VASTVideoView._cls6
        implements com.millennialmedia.internal.utils.IOUtils.DownloadListener
    {

        final VASTVideoView this$0;

        public void onDownloadFailed(Throwable throwable)
        {
            MMLog.e(VASTVideoView.access$1600(), "Error occurred downloading the video file.", throwable);
            VASTVideoView.access$1700(VASTVideoView.this).onFailed();
        }

        public void onDownloadSucceeded(File file)
        {
            ThreadUtils.runOnUiThread(file. new VASTVideoView._cls6._cls1());
        }

            
            {
                this$0 = VASTVideoView.this;
                super();
            }
    }

}
