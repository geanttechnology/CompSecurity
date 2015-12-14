// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.services.download;

import java.util.List;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.Song;
import my.googlemusic.play.utils.notification.Notification;

// Referenced classes of package my.googlemusic.play.services.download:
//            DownloadService

class this._cls0
    implements Runnable
{

    final DownloadService this$0;

    public void run()
    {
        DownloadService.access$202(DownloadService.this, true);
        do
        {
            if (DownloadService.access$000(DownloadService.this).isEmpty())
            {
                break;
            }
            Song song = (Song)DownloadService.access$000(DownloadService.this).remove(0);
            if (!DownloadService.access$100(DownloadService.this).isDownloadFinished(song))
            {
                DownloadService.access$400(DownloadService.this, song);
            }
        } while (true);
        DownloadService.access$100(DownloadService.this).sendBroadcast("DOWNLOAD COMPLETED");
        Notification.with(DownloadService.this).cancel(100);
        DownloadService.access$202(DownloadService.this, false);
        stopSelf();
    }

    ()
    {
        this$0 = DownloadService.this;
        super();
    }
}
