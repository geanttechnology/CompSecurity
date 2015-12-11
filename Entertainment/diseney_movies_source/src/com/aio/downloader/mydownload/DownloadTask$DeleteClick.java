// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.mydownload;

import android.content.Context;
import android.content.Intent;
import android.view.View;

// Referenced classes of package com.aio.downloader.mydownload:
//            DownloadTask

class this._cls0
    implements android.view.Task.DeleteClick
{

    final DownloadTask this$0;

    public void onClick(View view)
    {
        if (DownloadTask.access$4(DownloadTask.this) != null)
        {
            DownloadTask.access$4(DownloadTask.this).onDelete(DownloadTask.access$1(DownloadTask.this), DownloadTask.access$2(DownloadTask.this), Boolean.valueOf(false));
        }
        view = new Intent("pdt_del");
        DownloadTask.access$3(DownloadTask.this).sendBroadcast(view);
    }

    Listener()
    {
        this$0 = DownloadTask.this;
        super();
    }
}
