// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.mydownload;

import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.mydownload:
//            DownloadTask, DownloadMovieItem

class this._cls1
    implements Runnable
{

    final tProgress this$1;

    public void run()
    {
        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&action=retry_fail&id=")).append(cess._mth1(this._cls1.this).getFile_id()).append("&size=").append(cess._mth1(this._cls1.this).getCurrentProgress()).toString());
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
