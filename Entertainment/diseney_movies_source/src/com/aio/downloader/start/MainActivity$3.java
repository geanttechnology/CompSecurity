// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.start;

import android.os.AsyncTask;
import android.util.Log;
import java.io.File;

// Referenced classes of package com.aio.downloader.start:
//            MainActivity

class this._cls0 extends AsyncTask
{

    final MainActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        MainActivity.access$5(MainActivity.this).delete();
        Log.e("jone", "delete battery");
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
    }

    ()
    {
        this$0 = MainActivity.this;
        super();
    }
}
