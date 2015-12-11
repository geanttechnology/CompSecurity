// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import com.gotv.crackle.util.CrackleHMAC;
import com.gotv.crackle.util.NetworkUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.data:
//            CrackleAccountManager, DataRequest

class istener extends Thread
{

    final CrackleAccountManager this$0;
    final istener val$listener;
    final String val$url;

    public void run()
    {
        try
        {
            String s = CrackleHMAC.encodeURL(val$url);
            HashMap hashmap = new HashMap();
            hashmap.put("Authorization", s);
            s = NetworkUtil.getJSONFromUrl(val$url, hashmap).getString("message");
            val$listener.onDataFailed("ForgotPassword", s);
            return;
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            val$listener.onDataFailed("ForgotPassword", DataRequest.getParseErrorString(2000));
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            val$listener.onDataFailed("ForgotPassword", DataRequest.getNetworkErrorString(2000));
            return;
        }
        catch (URISyntaxException urisyntaxexception)
        {
            urisyntaxexception.printStackTrace();
        }
        val$listener.onDataFailed("ForgotPassword", DataRequest.getURIExceptionString(2000));
    }

    istener()
    {
        this$0 = final_crackleaccountmanager;
        val$url = s;
        val$listener = istener.this;
        super();
    }
}
