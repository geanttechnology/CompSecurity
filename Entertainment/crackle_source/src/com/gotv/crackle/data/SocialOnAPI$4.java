// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import com.gotv.crackle.Application;
import com.gotv.crackle.util.CrackleHMAC;
import com.gotv.crackle.util.NetworkUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.data:
//            SocialOnAPI, Localization, DataRequest

class taRequestListener extends Thread
{

    final SocialOnAPI this$0;
    final taRequestListener val$listener;
    final String val$url;

    public void run()
    {
        if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == questState.FAILED)
        {
            return;
        }
        JSONException jsonexception;
        String s = CrackleHMAC.encodeURL(val$url);
        Object obj = new HashMap();
        ((Map) (obj)).put("Authorization", s);
        obj = NetworkUtil.getJSONFromUrl(val$url, ((Map) (obj))).getJSONObject("status");
        s = ((JSONObject) (obj)).getString("messageCode");
        obj = ((JSONObject) (obj)).getString("message");
        if (s.compareTo("0") != 0)
        {
            if (val$listener != null)
            {
                val$listener.onDataFailed("SOCIAL_DELETE", ((String) (obj)));
                return;
            }
            break MISSING_BLOCK_LABEL_207;
        }
        try
        {
            if (val$listener != null)
            {
                val$listener.onDataSuccess("SOCIAL_DELETE");
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            if (val$listener != null)
            {
                val$listener.onDataFailed("SOCIAL_DELETE", DataRequest.getParseErrorString(1900));
                return;
            }
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            if (val$listener != null)
            {
                val$listener.onDataFailed("SOCIAL_DELETE", DataRequest.getNetworkErrorString(1900));
                return;
            }
        }
        catch (URISyntaxException urisyntaxexception)
        {
            urisyntaxexception.printStackTrace();
            if (val$listener != null)
            {
                val$listener.onDataFailed("SOCIAL_DELETE", DataRequest.getURIExceptionString(1900));
            }
        }
    }

    taRequestListener()
    {
        this$0 = final_socialonapi;
        val$url = s;
        val$listener = taRequestListener.this;
        super();
    }
}
