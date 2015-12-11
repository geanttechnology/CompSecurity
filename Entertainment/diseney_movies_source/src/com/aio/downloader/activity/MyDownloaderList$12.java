// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import com.aio.downloader.utils.Myutils;

// Referenced classes of package com.aio.downloader.activity:
//            MyDownloaderList

class this._cls0 extends AsyncTask
{

    final MyDownloaderList this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        Myutils.copyfile(MyDownloaderList.access$23(MyDownloaderList.this), MyDownloaderList.access$24(MyDownloaderList.this), Boolean.valueOf(false));
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        void1 = new Intent("android.intent.action.VIEW");
        void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(MyDownloaderList.access$24(MyDownloaderList.this)).toString()), "application/vnd.android.package-archive");
        startActivity(void1);
    }

    ()
    {
        this$0 = MyDownloaderList.this;
        super();
    }
}
