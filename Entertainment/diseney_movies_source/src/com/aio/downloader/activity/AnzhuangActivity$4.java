// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.os.AsyncTask;
import com.aio.downloader.utils.Myutils;

// Referenced classes of package com.aio.downloader.activity:
//            AnzhuangActivity

class this._cls0 extends AsyncTask
{

    final AnzhuangActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        Myutils.copyfile(AnzhuangActivity.access$1(AnzhuangActivity.this), AnzhuangActivity.access$2(AnzhuangActivity.this), Boolean.valueOf(false));
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        AnzhuangActivity.access$3(AnzhuangActivity.this);
    }

    ()
    {
        this$0 = AnzhuangActivity.this;
        super();
    }
}
