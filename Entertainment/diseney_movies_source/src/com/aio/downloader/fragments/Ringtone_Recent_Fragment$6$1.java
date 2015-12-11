// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aio.downloader.adapter.RingtoneListviewAdapter;
import com.aio.downloader.model.Model;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.Player;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aio.downloader.fragments:
//            Ringtone_Recent_Fragment

class val.arg2 extends AsyncTask
{

    final is._cls0 this$1;
    private final int val$arg2;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        avoid = publicTools.getUrl((new StringBuilder("http://t.zedge.net/ringtone/")).append(((DownloadMovieItem)Ringtone_Recent_Fragment.access$9(_fld0).get(val$arg2)).getId()).append("/?page=1").toString());
        HashMap hashmap = new HashMap();
        hashmap.put("content", avoid);
        avoid = publicTools.doHttpPost((new StringBuilder("http://android.downloadatoz.com/_201409/market/ringtone_pdt_parser.php?content=")).append(((DownloadMovieItem)Ringtone_Recent_Fragment.access$9(_fld0).get(val$arg2)).getId()).toString(), hashmap);
        Log.e("olol", (new StringBuilder("rrrrjsondata=")).append(avoid).toString());
        try
        {
            avoid = new JSONObject(avoid);
            if (avoid.getInt("status") == 1)
            {
                Ringtone_Recent_Fragment.access$11(_fld0, new Model());
                Ringtone_Recent_Fragment.access$12(_fld0).setRingtoneurl(avoid.getString("url"));
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.printStackTrace();
        }
        try
        {
            Ringtone_Recent_Fragment.access$2(_fld0).playUrl(Ringtone_Recent_Fragment.access$12(_fld0).getRingtoneurl());
            Ringtone_Recent_Fragment.access$13(_fld0, new Timer());
            Ringtone_Recent_Fragment.access$14(_fld0, new TimerTask() {

                final Ringtone_Recent_Fragment._cls6._cls1 this$2;

                public void run()
                {
                    Message message = new Message();
                    message.what = 400;
                    handler.sendMessage(message);
                }

            
            {
                this$2 = Ringtone_Recent_Fragment._cls6._cls1.this;
                super();
            }
            });
            Ringtone_Recent_Fragment.access$15(_fld0).schedule(Ringtone_Recent_Fragment.access$16(_fld0), 0L, 1000L);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[]) { }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        Ringtone_Recent_Fragment.access$0(_fld0).setVisibility(8);
        if (void1 != null);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        Ringtone_Recent_Fragment.access$0(_fld0).setVisibility(0);
    }


    is._cls0()
    {
        this$1 = final__pcls0;
        val$arg2 = I.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/fragments/Ringtone_Recent_Fragment$6

/* anonymous class */
    class Ringtone_Recent_Fragment._cls6
        implements android.widget.AdapterView.OnItemClickListener
    {

        final Ringtone_Recent_Fragment this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            adapterview = getActivity().getSharedPreferences("ringtone_recent_data", 0).edit();
            adapterview.putInt("ringtone_recent_selector", i);
            adapterview.commit();
            Ringtone_Recent_Fragment.access$3(Ringtone_Recent_Fragment.this).setVisibility(0);
            Ringtone_Recent_Fragment.access$8(Ringtone_Recent_Fragment.this).setText(((DownloadMovieItem)Ringtone_Recent_Fragment.access$9(Ringtone_Recent_Fragment.this).get(i)).getTitle());
            Ringtone_Recent_Fragment.access$10(Ringtone_Recent_Fragment.this).setBackgroundResource(0x7f02015e);
            (i. new Ringtone_Recent_Fragment._cls6._cls1()).execute(new Void[0]);
            Ringtone_Recent_Fragment.access$17(Ringtone_Recent_Fragment.this).notifyDataSetChanged();
        }


            
            {
                this$0 = Ringtone_Recent_Fragment.this;
                super();
            }
    }

}
