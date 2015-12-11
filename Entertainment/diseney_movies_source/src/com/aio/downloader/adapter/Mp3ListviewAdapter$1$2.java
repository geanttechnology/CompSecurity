// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.model.Model;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.NetWorkUtil;
import com.aio.downloader.utils.publicTools;
import java.util.HashMap;

// Referenced classes of package com.aio.downloader.adapter:
//            Mp3ListviewAdapter

class val.in_fo extends AsyncTask
{

    final is._cls0 this$1;
    private final DownloadMovieItem val$in_fo;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        avoid = publicTools.getUrl((new StringBuilder("http://mp3box.to/user/download/?song=")).append(val$in_fo.getId()).toString());
        HashMap hashmap = new HashMap();
        hashmap.put("content", avoid);
        avoid = publicTools.doHttpPost((new StringBuilder("http://android.downloadatoz.com/_201409/market/mp3_pdt_parser.php?id=")).append(val$in_fo.getId()).toString(), hashmap);
        getmp3json(avoid);
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        try
        {
            MydownloadMp3(val$in_fo.getId(), val$in_fo.getTitle(), Mp3ListviewAdapter.access$6(_fld0).getMp3url());
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            Toast.makeText(Mp3ListviewAdapter.access$2(_fld0), Mp3ListviewAdapter.access$2(_fld0).getString(0x7f0b0064), 1).show();
        }
        void1 = new Intent();
        if (!Mp3ListviewAdapter.access$5(_fld0).equals("mp3recent")) goto _L2; else goto _L1
_L1:
        void1.setAction("hiderecentmp3");
_L4:
        Mp3ListviewAdapter.access$2(_fld0).sendBroadcast(void1);
        return;
_L2:
        if (Mp3ListviewAdapter.access$5(_fld0).equals("mp3popular"))
        {
            void1.setAction("hidepopularmp3");
        } else
        if (Mp3ListviewAdapter.access$5(_fld0).equals("mp3search"))
        {
            void1.setAction("hidesearchmp3");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onPreExecute()
    {
        Intent intent;
        super.onPreExecute();
        intent = new Intent();
        if (!Mp3ListviewAdapter.access$5(_fld0).equals("mp3recent")) goto _L2; else goto _L1
_L1:
        intent.setAction("showrecentmp3");
_L4:
        Mp3ListviewAdapter.access$2(_fld0).sendBroadcast(intent);
        return;
_L2:
        if (Mp3ListviewAdapter.access$5(_fld0).equals("mp3popular"))
        {
            intent.setAction("showpopularmp3");
        } else
        if (Mp3ListviewAdapter.access$5(_fld0).equals("mp3search"))
        {
            intent.setAction("showsearchmp3");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    l.in_fo()
    {
        this$1 = final_in_fo1;
        val$in_fo = DownloadMovieItem.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/adapter/Mp3ListviewAdapter$1

/* anonymous class */
    class Mp3ListviewAdapter._cls1
        implements android.view.View.OnClickListener
    {

        final Mp3ListviewAdapter this$0;
        private final DownloadMovieItem val$in_fo;

        public void onClick(View view)
        {
            Mp3ListviewAdapter.access$0(Mp3ListviewAdapter.this).edit().putString("appname", in_fo.getTitle()).commit();
            (new Thread(new Mp3ListviewAdapter._cls1._cls1())).start();
            if (Mp3ListviewAdapter.access$1(Mp3ListviewAdapter.this).getBoolean("isopen", false) && NetWorkUtil.getAPNType(Mp3ListviewAdapter.access$2(Mp3ListviewAdapter.this)) != 1)
            {
                Mp3ListviewAdapter.access$3(Mp3ListviewAdapter.this);
                return;
            }
            if (Mp3ListviewAdapter.access$4(Mp3ListviewAdapter.this).queryfile(in_fo.getId()) == null)
            {
                (in_fo. new Mp3ListviewAdapter._cls1._cls2()).execute(new Void[0]);
                return;
            } else
            {
                Mp3ListviewAdapter.access$7(Mp3ListviewAdapter.this);
                return;
            }
        }


            
            {
                this$0 = final_mp3listviewadapter;
                in_fo = DownloadMovieItem.this;
                super();
            }

        // Unreferenced inner class com/aio/downloader/adapter/Mp3ListviewAdapter$1$1

/* anonymous class */
        class Mp3ListviewAdapter._cls1._cls1
            implements Runnable
        {

            final Mp3ListviewAdapter._cls1 this$1;
            private final DownloadMovieItem val$in_fo;

            public void run()
            {
                publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=mp3&id=")).append(in_fo.getId()).append("&title=").append(in_fo.getTitle()).append("&album_title=").append(in_fo.getAlbum_title()).append("&artist_title=").append(in_fo.getArtist_title()).append("&size=").append(in_fo.getSize()).toString());
            }

                    
                    {
                        this$1 = Mp3ListviewAdapter._cls1.this;
                        in_fo = downloadmovieitem;
                        super();
                    }
        }

    }

}
