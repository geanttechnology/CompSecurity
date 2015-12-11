// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import com.gotv.crackle.Application;
import com.gotv.crackle.ApplicationConstants;
import com.gotv.crackle.util.CrackleHMAC;
import com.gotv.crackle.util.NetworkUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.data:
//            CrackleAccountManager, Localization, DataRequest

static final class val.listener extends Thread
{

    final istener val$listener;
    final String val$url;

    public void run()
    {
        if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == .FAILED)
        {
            return;
        }
        Object obj;
        obj = CrackleHMAC.encodeURL(val$url);
        Object obj1 = new HashMap();
        ((Map) (obj1)).put("Authorization", obj);
        ((Map) (obj1)).put("User-Agent", ApplicationConstants.CUSTOM_USER_AGENT_STRING);
        ((Map) (obj1)).put("Accept", "text/html,application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
        ((Map) (obj1)).put("Content-Type", "application/json");
        obj = new JSONObject(NetworkUtil.getStringFromUrl(val$url, ((Map) (obj1))));
        Object obj2 = ((JSONObject) (obj)).getJSONObject("status");
        obj1 = ((JSONObject) (obj2)).getString("messageCode");
        obj2 = ((JSONObject) (obj2)).getString("message");
        if (((String) (obj1)).compareTo("0") != 0)
        {
            if (val$listener != null)
            {
                val$listener.onDataFailed("CrackleAccountManager User Profile", ((String) (obj2)));
                return;
            }
            break MISSING_BLOCK_LABEL_253;
        }
        try
        {
            CrackleAccountManager.access$100(((JSONObject) (obj)).getInt("age"), ((JSONObject) (obj)).getInt("gender"));
            if (val$listener != null)
            {
                val$listener.onDataSuccess("CrackleAccountManager User Profile");
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (val$listener != null)
            {
                val$listener.onDataFailed("CrackleAccountManager User Profile", DataRequest.getParseErrorString(700));
                return;
            }
        }
        catch (IOException ioexception)
        {
            if (val$listener != null)
            {
                val$listener.onDataFailed("CrackleAccountManager User Profile", DataRequest.getNetworkErrorString(700));
                return;
            }
        }
        catch (URISyntaxException urisyntaxexception)
        {
            if (val$listener != null)
            {
                val$listener.onDataFailed("CrackleAccountManager User Profile", DataRequest.getURIExceptionString(700));
            }
        }
    }

    istener(String s, istener istener)
    {
        val$url = s;
        val$listener = istener;
        super();
    }
}
