// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.os.AsyncTask;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.fragments:
//            Mp3_Popular_Fragment

class this._cls0 extends AsyncTask
{

    final Mp3_Popular_Fragment this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        return publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/mp3_list_more.php?tab=popular&page=")).append(Mp3_Popular_Fragment.access$5(Mp3_Popular_Fragment.this)).toString());
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        if (s == null)
        {
            return;
        } else
        {
            Mp3_Popular_Fragment.access$6(Mp3_Popular_Fragment.this, s);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        Mp3_Popular_Fragment.access$0(Mp3_Popular_Fragment.this).setVisibility(0);
    }

    ()
    {
        this$0 = Mp3_Popular_Fragment.this;
        super();
    }
}
