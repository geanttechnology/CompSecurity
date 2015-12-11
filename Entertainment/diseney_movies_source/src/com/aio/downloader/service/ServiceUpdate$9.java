// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.aio.downloader.utils.Myutils;
import java.util.HashMap;
import org.json.JSONArray;

// Referenced classes of package com.aio.downloader.service:
//            ServiceUpdate

class this._cls0
    implements Runnable
{

    final ServiceUpdate this$0;

    public void run()
    {
        String s = Uri.encode(Build.MODEL);
        Object obj = new HashMap();
        try
        {
            ((HashMap) (obj)).put("content", ServiceUpdate.access$57(ServiceUpdate.this).toString());
            ((HashMap) (obj)).put("ucode", ServiceUpdate.access$58(ServiceUpdate.this));
            ((HashMap) (obj)).put("os_version", android.os.LEASE);
            ((HashMap) (obj)).put("source", "aio");
            ((HashMap) (obj)).put("device", s);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        ServiceUpdate.access$59(ServiceUpdate.this, Myutils.doHttpPost("http://android.downloadatoz.com/_201409/market/app_version_check.php", ((HashMap) (obj))));
        Log.e("qaz", (new StringBuilder(String.valueOf(ServiceUpdate.access$51(ServiceUpdate.this)))).toString());
        obj = new Message();
        obj.obj = ServiceUpdate.access$51(ServiceUpdate.this);
        obj.what = 1001;
        ServiceUpdate.access$60(ServiceUpdate.this).sendMessage(((Message) (obj)));
    }

    ()
    {
        this$0 = ServiceUpdate.this;
        super();
    }
}
