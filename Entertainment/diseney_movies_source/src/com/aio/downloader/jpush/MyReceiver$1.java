// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.jpush;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import com.aio.downloader.utils.Myutils;
import java.io.File;

// Referenced classes of package com.aio.downloader.jpush:
//            MyReceiver

class this._cls0 extends AsyncTask
{

    final MyReceiver this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        Myutils.copyfile(MyReceiver.access$0(MyReceiver.this), MyReceiver.access$1(MyReceiver.this), Boolean.valueOf(false));
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
        void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(MyReceiver.access$2(MyReceiver.this)).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
        void1.addFlags(0x10000000);
        MyReceiver.access$3(MyReceiver.this).startActivity(void1);
    }

    ()
    {
        this$0 = MyReceiver.this;
        super();
    }
}
