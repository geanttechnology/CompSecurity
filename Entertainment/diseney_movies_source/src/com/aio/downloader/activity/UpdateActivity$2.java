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
//            UpdateActivity

class this._cls0
    implements Runnable
{

    final UpdateActivity this$0;

    public void run()
    {
        String s = Uri.encode(Build.MODEL);
        Object obj = new HashMap();
        try
        {
            ((HashMap) (obj)).put("content", UpdateActivity.access$7(UpdateActivity.this).toString());
            ((HashMap) (obj)).put("ucode", UpdateActivity.access$8(UpdateActivity.this));
            ((HashMap) (obj)).put("os_version", android.os.EASE);
            ((HashMap) (obj)).put("source", "aio");
            ((HashMap) (obj)).put("device", s);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        UpdateActivity.access$9(UpdateActivity.this, Myutils.doHttpPost("http://android.downloadatoz.com/_201409/market/app_version_check.php", ((HashMap) (obj))));
        Log.e("update", (new StringBuilder(String.valueOf(UpdateActivity.access$1(UpdateActivity.this)))).toString());
        obj = new Message();
        obj.obj = UpdateActivity.access$1(UpdateActivity.this);
        obj.what = 1001;
        UpdateActivity.access$10(UpdateActivity.this).sendMessage(((Message) (obj)));
    }

    ()
    {
        this$0 = UpdateActivity.this;
        super();
    }
}
