// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.mydownload.MyApplcation;
import com.aio.downloader.utils.SharedPreferencesConfig;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity, MyDownloaderList

class this._cls1 extends TimerTask
{

    final roadcast this$1;

    public void run()
    {
        Log.e("qwa", (new StringBuilder("icon0=")).append(on0).toString());
        Intent intent = new Intent("paidppp");
        intent.putExtra("icon0", on0);
        intent.putExtra("icon1", on1);
        intent.putExtra("icon2", on2);
        intent.putExtra("icon3", on3);
        intent.putExtra("icon4", on4);
        intent.putExtra("icon5", on5);
        sendBroadcast(intent);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/activity/MyMainActivity$10

/* anonymous class */
    class MyMainActivity._cls10 extends Handler
    {

        private String icon0;
        private String icon1;
        private String icon2;
        private String icon3;
        private String icon4;
        private String icon5;
        private String icon6;
        private String price0;
        private String price1;
        private String price2;
        private String price3;
        private String price4;
        private String price5;
        private String price6;
        final MyMainActivity this$0;

        public void handleMessage(Message message)
        {
            super.handleMessage(message);
            message.what;
            JVM INSTR lookupswitch 8: default 84
        //                       1: 85
        //                       2: 99
        //                       3: 107
        //                       4: 200
        //                       5: 277
        //                       250: 354
        //                       297: 871
        //                       30000: 798;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
            return;
_L2:
            Toast.makeText(MyMainActivity.this, "Failed to connect server.", 0).show();
            return;
_L3:
            MyMainActivity.access$17(MyMainActivity.this);
            return;
_L4:
            Toast.makeText(MyMainActivity.this, (new StringBuilder("'")).append(MyMainActivity.access$18(MyMainActivity.this).getTitle()).append("' is added to download queue.").toString(), 0).show();
            message = new Intent();
            message.setAction("homeapp");
            sendBroadcast(message);
            MyMainActivity.access$15(MyMainActivity.this).setVisibility(0);
            MyMainActivity.access$15(MyMainActivity.this).startAnimation(MyMainActivity.access$16(MyMainActivity.this));
            return;
_L5:
            message = new Intent();
            message.setAction("homeapp");
            sendBroadcast(message);
            MyMainActivity.access$15(MyMainActivity.this).setVisibility(0);
            MyMainActivity.access$15(MyMainActivity.this).startAnimation(MyMainActivity.access$16(MyMainActivity.this));
            message = new Intent(getApplicationContext(), com/aio/downloader/activity/MyDownloaderList);
            startActivity(message);
            return;
_L6:
            message = new Intent();
            message.setAction("homeapp");
            sendBroadcast(message);
            MyMainActivity.access$15(MyMainActivity.this).setVisibility(0);
            MyMainActivity.access$15(MyMainActivity.this).startAnimation(MyMainActivity.access$16(MyMainActivity.this));
            message = new Intent(getApplicationContext(), com/aio/downloader/activity/MyDownloaderList);
            startActivity(message);
            return;
_L7:
            message = message.obj.toString();
            try
            {
                message = new JSONObject(message);
                message.getInt("has_next_page");
                if (message.getInt("status") == 1)
                {
                    message = message.getJSONArray("list");
                    JSONObject jsonobject = message.getJSONObject(0);
                    icon0 = jsonobject.getString("icon");
                    price0 = jsonobject.getString("price");
                    MyMainActivity.access$19(MyMainActivity.this).asyncLoadImage(icon0, MyMainActivity.access$20(MyMainActivity.this));
                    jsonobject = message.getJSONObject(1);
                    icon1 = jsonobject.getString("icon");
                    price1 = jsonobject.getString("price");
                    MyMainActivity.access$19(MyMainActivity.this).asyncLoadImage(icon1, MyMainActivity.access$21(MyMainActivity.this));
                    jsonobject = message.getJSONObject(2);
                    icon2 = jsonobject.getString("icon");
                    price2 = jsonobject.getString("price");
                    MyMainActivity.access$19(MyMainActivity.this).asyncLoadImage(icon2, MyMainActivity.access$22(MyMainActivity.this));
                    jsonobject = message.getJSONObject(3);
                    icon3 = jsonobject.getString("icon");
                    price3 = jsonobject.getString("price");
                    MyMainActivity.access$19(MyMainActivity.this).asyncLoadImage(icon3, MyMainActivity.access$23(MyMainActivity.this));
                    jsonobject = message.getJSONObject(4);
                    icon4 = jsonobject.getString("icon");
                    price4 = jsonobject.getString("price");
                    MyMainActivity.access$19(MyMainActivity.this).asyncLoadImage(icon4, MyMainActivity.access$24(MyMainActivity.this));
                    jsonobject = message.getJSONObject(5);
                    icon5 = jsonobject.getString("icon");
                    price5 = jsonobject.getString("price");
                    MyMainActivity.access$19(MyMainActivity.this).asyncLoadImage(icon5, MyMainActivity.access$25(MyMainActivity.this));
                    jsonobject = message.getJSONObject(6);
                    icon6 = jsonobject.getString("icon");
                    price6 = jsonobject.getString("price");
                    MyMainActivity.access$19(MyMainActivity.this).asyncLoadImage(icon5, MyMainActivity.access$26(MyMainActivity.this));
                    message = message.getJSONObject(7);
                    message.getString("icon");
                    message.getString("price");
                    MyMainActivity.access$19(MyMainActivity.this).asyncLoadImage(icon5, MyMainActivity.access$27(MyMainActivity.this));
                    (new Timer()).schedule(new MyMainActivity._cls10._cls1(), 10000L, 30000L);
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
_L9:
            if (System.currentTimeMillis() > SharedPreferencesConfig.GetClickTime(getApplicationContext()))
            {
                SharedPreferencesConfig.SetClickTime(getApplicationContext(), System.currentTimeMillis() + 30000L);
                MyMainActivity.access$28(MyMainActivity.this).setImageResource(0x7f0200d8);
                message = AnimationUtils.loadAnimation(getApplicationContext(), 0x7f04001e);
                MyMainActivity.access$28(MyMainActivity.this).startAnimation(message);
                return;
            }
            if (true) goto _L1; else goto _L8
_L8:
            Toast.makeText(MyMainActivity.this, "'AIO Downloader' is added to download queue.", 0).show();
            message = new Intent();
            message.setAction("homeapp");
            sendBroadcast(message);
            MyMainActivity.access$15(MyMainActivity.this).setVisibility(0);
            MyMainActivity.access$15(MyMainActivity.this).startAnimation(MyMainActivity.access$16(MyMainActivity.this));
            return;
        }








            
            {
                this$0 = MyMainActivity.this;
                super();
            }
    }

}
