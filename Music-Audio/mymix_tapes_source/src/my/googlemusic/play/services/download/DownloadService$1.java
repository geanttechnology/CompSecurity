// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.services.download;

import my.googlemusic.play.interfaces.Server;

// Referenced classes of package my.googlemusic.play.services.download:
//            DownloadService

class this._cls0
    implements Runnable
{

    final DownloadService this$0;

    public void run()
    {
        DownloadService.access$002(DownloadService.this, DownloadService.access$100(DownloadService.this).getDownloads());
        if (!DownloadService.access$200(DownloadService.this))
        {
            DownloadService.access$300(DownloadService.this);
        }
    }

    ()
    {
        this$0 = DownloadService.this;
        super();
    }
}
