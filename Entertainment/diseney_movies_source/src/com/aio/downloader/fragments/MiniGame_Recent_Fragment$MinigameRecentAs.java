// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.os.AsyncTask;
import com.aio.downloader.utils.ASCIIutil;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.fragments:
//            MiniGame_Recent_Fragment

class myjson extends AsyncTask
{

    private String myjson;
    final MiniGame_Recent_Fragment this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        avoid = publicTools.getUrl((new StringBuilder("http://app.loveitsomuch.com/game/h5/game_list.php?ucode=abc&version=1.0&order_type=hot&page=")).append(MiniGame_Recent_Fragment.access$1(MiniGame_Recent_Fragment.this)).toString());
        if (avoid == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        try
        {
            myjson = ASCIIutil.toparse(avoid);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[]) { }
        return myjson;
        myjson = null;
        break MISSING_BLOCK_LABEL_38;
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
        }
        try
        {
            MiniGame_Recent_Fragment.access$2(MiniGame_Recent_Fragment.this, s);
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        MiniGame_Recent_Fragment.access$0(MiniGame_Recent_Fragment.this).setVisibility(8);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        MiniGame_Recent_Fragment.access$0(MiniGame_Recent_Fragment.this).setVisibility(0);
    }

    ()
    {
        this$0 = MiniGame_Recent_Fragment.this;
        super();
        myjson = null;
    }
}
