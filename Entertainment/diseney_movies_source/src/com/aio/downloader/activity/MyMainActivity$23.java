// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.aio.downloader.utils.Myutils;
import java.util.HashMap;
import org.json.JSONArray;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity

class this._cls0
    implements Runnable
{

    final MyMainActivity this$0;

    public void run()
    {
        String s = Uri.encode(Build.MODEL);
        Object obj = new HashMap();
        try
        {
            ((HashMap) (obj)).put("content", MyMainActivity.access$85(MyMainActivity.this).toString());
            ((HashMap) (obj)).put("ucode", MyMainActivity.access$86(MyMainActivity.this));
            ((HashMap) (obj)).put("os_version", android.os.ASE);
            ((HashMap) (obj)).put("source", "aio");
            ((HashMap) (obj)).put("device", s);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        MyMainActivity.access$87(MyMainActivity.this, Myutils.doHttpPost("http://android.downloadatoz.com/_201409/market/app_version_check.php", ((HashMap) (obj))));
        Log.e("jsonStr", (new StringBuilder(String.valueOf(MyMainActivity.access$38(MyMainActivity.this)))).toString());
        obj = new Message();
        obj.obj = MyMainActivity.access$38(MyMainActivity.this);
        obj.what = 1001;
        MyMainActivity.access$88(MyMainActivity.this).sendMessage(((Message) (obj)));
    }

    ()
    {
        this$0 = MyMainActivity.this;
        super();
    }
}
