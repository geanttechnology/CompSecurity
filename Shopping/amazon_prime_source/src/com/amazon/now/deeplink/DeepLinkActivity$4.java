// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.deeplink;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.now.deeplink:
//            DeepLinkActivity

class val.asin
    implements com.amazon.now.net.lback
{

    final DeepLinkActivity this$0;
    final String val$asin;

    public void response(String s)
    {
        Object obj;
        HashMap hashmap;
        boolean flag;
        boolean flag1;
        flag1 = false;
        hashmap = new HashMap();
        obj = null;
        flag = flag1;
        s = new JSONObject(s);
        flag = flag1;
        flag1 = s.optBoolean("buyable", false);
        if (!flag1) goto _L2; else goto _L1
_L1:
        flag = flag1;
        hashmap.put("merchantId", s.optString("merchantId", null));
        flag = flag1;
        s = obj;
_L3:
        if (flag)
        {
            hashmap.put("asin", val$asin);
            DeepLinkActivity.access$000(DeepLinkActivity.this, hashmap);
            return;
        } else
        {
            DeepLinkActivity.access$100(DeepLinkActivity.this, s);
            return;
        }
_L2:
        flag = flag1;
        s = s.optString("errorMessage", null);
        flag = flag1;
          goto _L3
        s;
        Log.e(DeepLinkActivity.access$200(), s.toString(), s);
        s = obj;
          goto _L3
    }

    ()
    {
        this$0 = final_deeplinkactivity;
        val$asin = String.this;
        super();
    }
}
