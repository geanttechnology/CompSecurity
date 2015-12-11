// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import android.text.format.Time;
import android.util.Log;
import android.view.Window;
import com.aio.downloader.dialog.CallerOutDialog1;
import com.aio.downloader.dialog.InstallfirstDialog;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.Myutils;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aio.downloader.service:
//            ServiceUpdate

class this._cls1 extends TimerTask
{

    final Broadcast this$1;

    public void run()
    {
        Intent intent = new Intent("meiri");
        intent.putExtra("icon_pick1", ServiceUpdate.access$10(_fld0));
        intent.putExtra("title_pick1", ServiceUpdate.access$11(_fld0));
        intent.putExtra("short_desc1", ServiceUpdate.access$12(_fld0));
        intent.putExtra("id_meiri", ServiceUpdate.access$13(_fld0));
        sendBroadcast(intent);
        intent = new Intent("meiribig");
        intent.putExtra("icon_pick", ServiceUpdate.access$14(_fld0));
        intent.putExtra("title_pick", ServiceUpdate.access$15(_fld0));
        intent.putExtra("short_desc", ServiceUpdate.access$16(_fld0));
        intent.putExtra("img_pick", ServiceUpdate.access$17(_fld0));
        intent.putExtra("id_meiribig", ServiceUpdate.access$18(_fld0));
        sendBroadcast(intent);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/service/ServiceUpdate$2

/* anonymous class */
    class ServiceUpdate._cls2 extends Handler
    {

        private String icon0;
        private String icon1;
        private String icon2;
        private String icon3;
        private String icon4;
        private String icon5;
        private String icon6;
        private String icon7;
        final ServiceUpdate this$0;

        public void handleMessage(Message message)
        {
            super.handleMessage(message);
            message.what;
            JVM INSTR lookupswitch 4: default 52
        //                       10: 262
        //                       30: 53
        //                       100: 554
        //                       250: 76;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            return;
_L3:
            MobclickAgent.onEvent(getApplicationContext(), "first_insall_cleaner");
            ServiceUpdate.access$0(ServiceUpdate.this).show();
            return;
_L5:
            message = message.obj.toString();
            try
            {
                message = new JSONObject(message);
                message.getInt("has_next_page");
                if (message.getInt("status") == 1)
                {
                    message = message.getJSONArray("list");
                    icon0 = message.getJSONObject(0).getString("icon");
                    icon1 = message.getJSONObject(1).getString("icon");
                    icon2 = message.getJSONObject(2).getString("icon");
                    icon3 = message.getJSONObject(3).getString("icon");
                    icon4 = message.getJSONObject(4).getString("icon");
                    icon5 = message.getJSONObject(5).getString("icon");
                    icon6 = message.getJSONObject(6).getString("icon");
                    icon7 = message.getJSONObject(7).getString("icon");
                    (new Timer()).schedule(new ServiceUpdate._cls2._cls1(), 10000L, 30000L);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                message.printStackTrace();
                return;
            }
            continue; /* Loop/switch isn't completed */
_L2:
            message = message.obj.toString();
            list_pick.addAll(Myutils.parsetodaypick(message));
            Log.e("lpl", (new StringBuilder("list_pick=")).append(list_pick).toString());
            Object obj;
            android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
            int i;
            int j;
            int k;
            try
            {
                ServiceUpdate.access$1(ServiceUpdate.this, ((DownloadMovieItem)list_pick.get(0)).getIcon());
                ServiceUpdate.access$2(ServiceUpdate.this, ((DownloadMovieItem)list_pick.get(0)).getTitle());
                ServiceUpdate.access$3(ServiceUpdate.this, ((DownloadMovieItem)list_pick.get(0)).getShort_desc());
                ServiceUpdate.access$4(ServiceUpdate.this, ((DownloadMovieItem)list_pick.get(0)).getMovieHeadImagePath());
                ServiceUpdate.access$5(ServiceUpdate.this, ((DownloadMovieItem)list_pick.get(0)).getId());
                ServiceUpdate.access$6(ServiceUpdate.this, ((DownloadMovieItem)list_pick.get(1)).getIcon());
                ServiceUpdate.access$7(ServiceUpdate.this, ((DownloadMovieItem)list_pick.get(1)).getTitle());
                ServiceUpdate.access$8(ServiceUpdate.this, ((DownloadMovieItem)list_pick.get(1)).getShort_desc());
                ServiceUpdate.access$9(ServiceUpdate.this, ((DownloadMovieItem)list_pick.get(1)).getId());
            }
            // Misplaced declaration of an exception variable
            catch (Message message) { }
            (new Timer()).schedule(new ServiceUpdate._cls2._cls2(), 30000L, 60000L);
            return;
_L4:
            message = null;
            obj = getApplicationContext().getPackageManager().getPackageInfo("com.allinone.callerid", 0);
            message = ((Message) (obj));
_L7:
            obj = new Time();
            ((Time) (obj)).setToNow();
            i = ((Time) (obj)).hour;
            j = ((Time) (obj)).minute;
            k = ((Time) (obj)).second;
            if (i == 10 && j == 30 && k == 0 && message == null)
            {
                MobclickAgent.onEvent(getApplicationContext(), "simulate_call");
                ServiceUpdate.access$20(ServiceUpdate.this, new CallerOutDialog1(getApplicationContext(), 0x7f0c0010, ServiceUpdate.access$19(ServiceUpdate.this), "+1 813-449-2756"));
                ServiceUpdate.access$21(ServiceUpdate.this).setCanceledOnTouchOutside(true);
                ServiceUpdate.access$21(ServiceUpdate.this).getWindow().setType(2003);
                ServiceUpdate.access$21(ServiceUpdate.this).show();
                return;
            }
            if (true) goto _L1; else goto _L6
_L6:
            namenotfoundexception;
            namenotfoundexception.printStackTrace();
              goto _L7
        }








            
            {
                this$0 = ServiceUpdate.this;
                super();
            }

        // Unreferenced inner class com/aio/downloader/service/ServiceUpdate$2$1

/* anonymous class */
        class ServiceUpdate._cls2._cls1 extends TimerTask
        {

            final ServiceUpdate._cls2 this$1;

            public void run()
            {
                Log.e("qwa", (new StringBuilder("icon0=")).append(icon0).toString());
                Intent intent = new Intent("paidppp");
                intent.putExtra("icon0", icon0);
                intent.putExtra("icon1", icon1);
                intent.putExtra("icon2", icon2);
                intent.putExtra("icon3", icon3);
                intent.putExtra("icon4", icon4);
                intent.putExtra("icon5", icon5);
                sendBroadcast(intent);
            }

                    
                    {
                        this$1 = ServiceUpdate._cls2.this;
                        super();
                    }
        }

    }

}
