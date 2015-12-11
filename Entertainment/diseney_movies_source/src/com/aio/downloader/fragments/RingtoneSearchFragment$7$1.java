// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
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
//            RingtoneSearchFragment

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
        avoid = publicTools.getUrl((new StringBuilder("http://t.zedge.net/ringtone/")).append(((DownloadMovieItem)RingtoneSearchFragment.access$5(_fld0).get(val$arg2)).getId()).append("/?page=1").toString());
        HashMap hashmap = new HashMap();
        hashmap.put("content", avoid);
        avoid = publicTools.doHttpPost((new StringBuilder("http://android.downloadatoz.com/_201409/market/ringtone_pdt_parser.php?content=")).append(((DownloadMovieItem)RingtoneSearchFragment.access$5(_fld0).get(val$arg2)).getId()).toString(), hashmap);
        try
        {
            avoid = new JSONObject(avoid);
            if (avoid.getInt("status") == 1)
            {
                RingtoneSearchFragment.access$12(_fld0, new Model());
                RingtoneSearchFragment.access$13(_fld0).setRingtoneurl(avoid.getString("url"));
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.printStackTrace();
        }
        try
        {
            RingtoneSearchFragment.access$2(_fld0).playUrl(RingtoneSearchFragment.access$13(_fld0).getRingtoneurl());
            RingtoneSearchFragment.access$14(_fld0, new Timer());
            RingtoneSearchFragment.access$15(_fld0, new TimerTask() {

                final RingtoneSearchFragment._cls7._cls1 this$2;

                public void run()
                {
                    Message message = new Message();
                    message.what = 600;
                    handler.sendMessage(message);
                }

            
            {
                this$2 = RingtoneSearchFragment._cls7._cls1.this;
                super();
            }
            });
            RingtoneSearchFragment.access$16(_fld0).schedule(RingtoneSearchFragment.access$17(_fld0), 0L, 1000L);
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
        RingtoneSearchFragment.access$0(_fld0).setVisibility(8);
        if (void1 != null);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        RingtoneSearchFragment.access$0(_fld0).setVisibility(0);
    }


    is._cls0()
    {
        this$1 = final__pcls0;
        val$arg2 = I.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/fragments/RingtoneSearchFragment$7

/* anonymous class */
    class RingtoneSearchFragment._cls7
        implements android.widget.AdapterView.OnItemClickListener
    {

        final RingtoneSearchFragment this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            adapterview = getActivity().getSharedPreferences("ringtone_search_data", 0).edit();
            adapterview.putInt("ringtone_search_selector", i);
            adapterview.commit();
            RingtoneSearchFragment.access$3(RingtoneSearchFragment.this).setVisibility(0);
            RingtoneSearchFragment.access$10(RingtoneSearchFragment.this).setText(((DownloadMovieItem)RingtoneSearchFragment.access$5(RingtoneSearchFragment.this).get(i)).getTitle());
            RingtoneSearchFragment.access$11(RingtoneSearchFragment.this).setBackgroundResource(0x7f02015e);
            (i. new RingtoneSearchFragment._cls7._cls1()).execute(new Void[0]);
            RingtoneSearchFragment.access$18(RingtoneSearchFragment.this).notifyDataSetChanged();
        }


            
            {
                this$0 = RingtoneSearchFragment.this;
                super();
            }
    }

}
