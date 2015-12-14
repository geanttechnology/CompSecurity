// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.services.download;

import my.googlemusic.play.utils.notification.Notification;
import my.googlemusic.play.utils.notification.NotificationCreator;

// Referenced classes of package my.googlemusic.play.services.download:
//            DownloadService

class this._cls0
    implements my.googlemusic.play.internet.rogressListener
{

    final DownloadService this$0;

    public void onProgress(int i)
    {
        Notification.with(DownloadService.this).load(100).info((new StringBuilder()).append(i).append("%").toString()).show();
    }

    or()
    {
        this$0 = DownloadService.this;
        super();
    }
}
