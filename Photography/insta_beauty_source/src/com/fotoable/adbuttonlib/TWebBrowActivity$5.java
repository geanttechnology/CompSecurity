// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import atz;
import com.wantu.model.res.WXDLShareInfo;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.fotoable.adbuttonlib:
//            TWebBrowActivity

class val.scene
    implements Runnable
{

    final TWebBrowActivity this$0;
    final boolean val$scene;
    final WXDLShareInfo val$shareinfo;
    final String val$urlString;
    final atz val$wechatAssistant;

    public void run()
    {
        Object obj;
        obj = (HttpURLConnection)(new URL(val$urlString)).openConnection();
        ((HttpURLConnection) (obj)).setConnectTimeout(8000);
        ((HttpURLConnection) (obj)).setRequestMethod("GET");
        if (((HttpURLConnection) (obj)).getResponseCode() != 200) goto _L2; else goto _L1
_L1:
        obj = ((HttpURLConnection) (obj)).getInputStream();
          goto _L3
_L5:
        try
        {
            obj = BitmapFactory.decodeStream(((java.io.InputStream) (obj)));
            Bitmap bitmap = Bitmap.createScaledBitmap(((Bitmap) (obj)), 100, 100, true);
            if (val$shareinfo != null)
            {
                val$wechatAssistant.a(val$shareinfo, bitmap, val$scene);
                return;
            }
        }
        catch (Exception exception)
        {
            return;
        }
        val$wechatAssistant.a(((Bitmap) (obj)), val$scene);
        return;
_L2:
        obj = null;
_L3:
        if (obj != null) goto _L5; else goto _L4
_L4:
    }

    ()
    {
        this$0 = final_twebbrowactivity;
        val$urlString = s;
        val$shareinfo = wxdlshareinfo;
        val$wechatAssistant = atz1;
        val$scene = Z.this;
        super();
    }
}
