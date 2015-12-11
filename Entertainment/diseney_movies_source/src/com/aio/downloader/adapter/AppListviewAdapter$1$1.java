// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.adapter:
//            AppListviewAdapter

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(AppListviewAdapter.access$4(_fld0).getString("appid", "invalid")).append("&from=apk&add_to_list=1").toString());
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/adapter/AppListviewAdapter$1

/* anonymous class */
    class AppListviewAdapter._cls1 extends Handler
    {

        final AppListviewAdapter this$0;

        public void handleMessage(Message message)
        {
            super.handleMessage(message);
            switch (message.what)
            {
            default:
                return;

            case 1: // '\001'
                Toast.makeText(AppListviewAdapter.access$0(AppListviewAdapter.this), "Failed to connect server.", 0).show();
                return;

            case 2: // '\002'
                AppListviewAdapter.access$1(AppListviewAdapter.this);
                return;

            case 3: // '\003'
                AppListviewAdapter.access$2(AppListviewAdapter.this, Boolean.valueOf(true));
                break;
            }
            Toast.makeText(AppListviewAdapter.access$0(AppListviewAdapter.this), (new StringBuilder("'")).append(AppListviewAdapter.access$3(AppListviewAdapter.this).getString("appname", ": this app")).append("' is added to download queue.").toString(), 0).show();
            (new Thread(new AppListviewAdapter._cls1._cls1())).start();
            message = new Intent();
            if (!AppListviewAdapter.access$5(AppListviewAdapter.this).equals("app1") && !AppListviewAdapter.access$5(AppListviewAdapter.this).equals("app2") && !AppListviewAdapter.access$5(AppListviewAdapter.this).equals("app3") && !AppListviewAdapter.access$5(AppListviewAdapter.this).equals("app4") && !AppListviewAdapter.access$5(AppListviewAdapter.this).equals("app5")) goto _L2; else goto _L1
_L1:
            message.setAction("app");
_L4:
            AppListviewAdapter.access$0(AppListviewAdapter.this).sendBroadcast(message);
            return;
_L2:
            if (AppListviewAdapter.access$5(AppListviewAdapter.this).equals("game1") || AppListviewAdapter.access$5(AppListviewAdapter.this).equals("game2") || AppListviewAdapter.access$5(AppListviewAdapter.this).equals("game3") || AppListviewAdapter.access$5(AppListviewAdapter.this).equals("game4") || AppListviewAdapter.access$5(AppListviewAdapter.this).equals("game5"))
            {
                message.setAction("game");
            } else
            if (AppListviewAdapter.access$5(AppListviewAdapter.this).equals("paid1") || AppListviewAdapter.access$5(AppListviewAdapter.this).equals("paid2") || AppListviewAdapter.access$5(AppListviewAdapter.this).equals("paid3") || AppListviewAdapter.access$5(AppListviewAdapter.this).equals("paid4") || AppListviewAdapter.access$5(AppListviewAdapter.this).equals("paid5"))
            {
                message.setAction("paid_wyc");
            } else
            if (AppListviewAdapter.access$5(AppListviewAdapter.this).equals("adult1") || AppListviewAdapter.access$5(AppListviewAdapter.this).equals("adult2") || AppListviewAdapter.access$5(AppListviewAdapter.this).equals("adult3") || AppListviewAdapter.access$5(AppListviewAdapter.this).equals("adult4"))
            {
                message.setAction("adult");
            } else
            if (AppListviewAdapter.access$5(AppListviewAdapter.this).equals("homeapp"))
            {
                message.setAction("homeapp");
            } else
            if (AppListviewAdapter.access$5(AppListviewAdapter.this).equals("appsearch"))
            {
                message.setAction("hideappsearch");
            }
            if (true) goto _L4; else goto _L3
_L3:
        }


            
            {
                this$0 = AppListviewAdapter.this;
                super();
            }
    }

}
