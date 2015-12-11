// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.util.Log;
import android.widget.ProgressBar;
import com.aio.downloader.utils.Myutils;
import com.thin.downloadmanager.DownloadStatusListener;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity

class this._cls0
    implements DownloadStatusListener
{

    final MyMainActivity this$0;

    public void onDownloadComplete(int i)
    {
        Log.e("jone", "download crush completed");
        Myutils.copyfile(MyMainActivity.access$75(MyMainActivity.this), MyMainActivity.access$76(MyMainActivity.this), Boolean.valueOf(false));
        try
        {
            Log.e("crush", (new StringBuilder("crush=")).append(getFileSizes(MyMainActivity.access$75(MyMainActivity.this))).toString());
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void onDownloadFailed(int i, int j, String s)
    {
        Log.e("jone", "DownloadFailed");
        if (i == MyMainActivity.access$77(MyMainActivity.this))
        {
            MyMainActivity.access$59(MyMainActivity.this).setProgress(0);
        }
    }

    public void onProgress(int i, long l, long l1, int j)
    {
        Log.e("jone", (new StringBuilder(String.valueOf(j))).toString());
        if (i == MyMainActivity.access$77(MyMainActivity.this))
        {
            MyMainActivity.access$59(MyMainActivity.this).setProgress(j);
        }
    }

    ()
    {
        this$0 = MyMainActivity.this;
        super();
    }
}
