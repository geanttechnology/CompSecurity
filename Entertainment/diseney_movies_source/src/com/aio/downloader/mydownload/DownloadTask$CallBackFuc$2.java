// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.mydownload;


// Referenced classes of package com.aio.downloader.mydownload:
//            DownloadTask, DownloadMovieItem

class this._cls1
    implements Runnable
{

    final this._cls1 this$1;

    public void run()
    {
        String s = (new StringBuilder(String.valueOf("pm install -r "))).append(cess._mth1(this._cls1.this).getFilePath()).toString();
        cess._mth2(this._cls1.this).excuteSuCMD(s);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
