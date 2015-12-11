// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.aio.downloader.model.GameInfosVersionModel;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.NetWorkUtil;
import com.thin.downloadmanager.ThinDownloadManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity

class this._cls0
    implements Runnable
{

    private String min_version;
    final MyMainActivity this$0;

    public void run()
    {
        Log.v("version", "11111111getversion");
        Object obj1;
        String s = (new StringBuilder("http://app.loveitsomuch.com/gonglue_xilie/ping.php?id=")).append(Myutils.packagename2).append("&version=").append("3.3.9").toString();
        Log.e("path", s);
        obj1 = (HttpURLConnection)(new URL(s)).openConnection();
        ((HttpURLConnection) (obj1)).setConnectTimeout(60000);
        ((HttpURLConnection) (obj1)).setRequestMethod("GET");
        if (((HttpURLConnection) (obj1)).getResponseCode() != 200) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = new StringBuffer();
        obj1 = new BufferedReader(new InputStreamReader(((HttpURLConnection) (obj1)).getInputStream()));
_L12:
        Object obj2 = ((BufferedReader) (obj1)).readLine();
        if (obj2 != null) goto _L4; else goto _L3
_L3:
        JSONObject jsonobject;
        jsonobject = new JSONObject(((StringBuffer) (obj)).toString());
        status = jsonobject.getInt("status");
        in_control = jsonobject.getInt("in_control");
        MyMainActivity.access$94(MyMainActivity.this, jsonobject.getString("ad_banner"));
        min_version = jsonobject.getString("min_version_in_maintenance");
        if (min_version.equals("3.3.9"))
        {
            Log.e("eee", "min_version=null");
        }
        if (MyMainActivity.access$95(MyMainActivity.this).equals("admob"))
        {
            obj = new Message();
            obj.what = 10;
            handlertimer.sendMessage(((Message) (obj)));
        }
        MyMainActivity.access$96(MyMainActivity.this).edit().putString("banner_type", MyMainActivity.access$95(MyMainActivity.this)).commit();
        Log.e("aaaa", (new StringBuilder("22222222status:")).append(status).toString());
        Log.e("aaaa", (new StringBuilder("3333333in_control")).append(in_control).toString());
        if (status != 1 || in_control != 0) goto _L2; else goto _L5
_L5:
        GameInfosVersionModel gameinfosversionmodel;
        gameinfosversionmodel = new GameInfosVersionModel();
        gameinfosversionmodel.setUpdatePath(jsonobject.getString("update_url"));
        if (gameinfosversionmodel.getUpdatePath().equals("")) goto _L7; else goto _L6
_L6:
        if (!MyMainActivity.access$55(MyMainActivity.this).exists()) goto _L9; else goto _L8
_L8:
        Log.e("www", "eeeeee");
        (new File((new StringBuilder()).append(MyMainActivity.access$55(MyMainActivity.this)).append(File.separator).append("aioupdate.apk").toString())).delete();
_L10:
        if (MyMainActivity.access$97(MyMainActivity.this).query(MyMainActivity.access$58(MyMainActivity.this)) == 32 && NetWorkUtil.getAPNType(getApplicationContext()) == 1)
        {
            MyMainActivity.access$99(MyMainActivity.this, MyMainActivity.access$97(MyMainActivity.this).add(MyMainActivity.access$98(MyMainActivity.this)));
            Log.e("www", "download");
        }
_L7:
        Myutils.big_ad_interval = Integer.parseInt(jsonobject.getString("big_ad_interval")) * 1000;
        Log.v("fdfd", (new StringBuilder("dd")).append(Myutils.big_ad_interval).toString());
        if (!jsonobject.getString("big_ad_interval").equals("0"))
        {
            (new Timer()).schedule(new TimerTask() {

                final MyMainActivity._cls42 this$1;

                public void run()
                {
                    Message message = new Message();
                    message.what = 20;
                    handlertimer.sendMessage(message);
                }

            
            {
                this$1 = MyMainActivity._cls42.this;
                super();
            }
            }, 0L, Myutils.big_ad_interval);
        }
        obj2 = Boolean.valueOf(false);
        Boolean boolean1;
        boolean1 = Boolean.valueOf(false);
        obj = obj2;
        JSONArray jsonarray = jsonobject.getJSONArray("neitui_list");
        obj1 = obj2;
        obj = obj2;
        if (jsonarray.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_735;
        }
        obj = obj2;
        obj1 = Boolean.valueOf(true);
        obj = obj1;
        obj2 = jsonarray.getJSONObject(0);
        obj = obj1;
        gameinfosversionmodel.setNtTitle(((JSONObject) (obj2)).getString("headline"));
        obj = obj1;
        gameinfosversionmodel.setNtMsg(((JSONObject) (obj2)).getString("description"));
        obj = obj1;
        gameinfosversionmodel.setPicPath(((JSONObject) (obj2)).getString("thumb_url"));
        obj = obj1;
        gameinfosversionmodel.setNtPath(((JSONObject) (obj2)).getString("url"));
        obj = obj1;
        gameinfosversionmodel.setNtId(((JSONObject) (obj2)).getString("url_scheme"));
        obj = obj1;
        try
        {
            Log.v("version", "44444");
        }
        catch (Exception exception)
        {
            exception = ((Exception) (obj));
        }
        obj = boolean1;
        if (((Boolean) (obj1)).booleanValue())
        {
            break MISSING_BLOCK_LABEL_789;
        }
        obj = boolean1;
        if (!jsonobject.getString("update_url").equals(""))
        {
            obj = Boolean.valueOf(true);
            gameinfosversionmodel.setNtPath(jsonobject.getString("update_url"));
            Log.v("version", "55555");
        }
        if (((Boolean) (obj1)).booleanValue() || ((Boolean) (obj)).booleanValue())
        {
            handlerversoin.sendMessage(handlerversoin.obtainMessage(564, gameinfosversionmodel));
            Log.v("version", "66666");
            return;
        }
          goto _L2
_L4:
        try
        {
            ((StringBuffer) (obj)).append(((String) (obj2)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        Log.e("www", "nnnnn");
          goto _L10
_L2:
        return;
        if (true) goto _L12; else goto _L11
_L11:
    }


    _cls1.this._cls1()
    {
        this$0 = MyMainActivity.this;
        super();
    }
}
