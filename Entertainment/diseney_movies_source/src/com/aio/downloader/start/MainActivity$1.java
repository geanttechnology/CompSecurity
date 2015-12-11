// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.start;

import android.os.AsyncTask;
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
        if (MainActivity.access$0(MainActivity.this).exists())
        {
            MainActivity.access$0(MainActivity.this).delete();
        }
        if (MainActivity.access$1(MainActivity.this).exists())
        {
            MainActivity.access$1(MainActivity.this).delete();
        }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        (new Thread() {

            final MainActivity._cls1 this$1;

            public void run()
            {
                super.run();
                File _tmp = MainActivity.access$2(this$0);
                File _tmp1 = MainActivity.access$3(this$0);
            }

            
            {
                this$1 = MainActivity._cls1.this;
                super();
            }
        }).start();
    }


    _cls1.this._cls1()
    {
        this$0 = MainActivity.this;
        super();
    }
}
