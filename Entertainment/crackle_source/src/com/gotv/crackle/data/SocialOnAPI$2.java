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
//            SocialOnAPI, Localization, DataRequest

class taRequestListener extends Thread
{

    final SocialOnAPI this$0;
    final boolean val$dialogShown;
    final boolean val$isSocialOn;
    final taRequestListener val$listener;
    final String val$url;
    final String val$userID;

    public void run()
    {
        if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == questState.FAILED)
        {
            return;
        }
        try
        {
            Object obj = CrackleHMAC.encodeURL(val$url);
            HashMap hashmap = new HashMap();
            hashmap.put("Authorization", obj);
            hashmap.put("User-Agent", ApplicationConstants.CUSTOM_USER_AGENT_STRING);
            hashmap.put("Accept", "text/html,application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
            hashmap.put("Content-Type", "application/json");
            obj = new JSONObject();
            ((JSONObject) (obj)).put("UserID", val$userID);
            ((JSONObject) (obj)).put("IsSocialON", val$isSocialOn);
            ((JSONObject) (obj)).put("IsSocialMessageDisplayed", val$dialogShown);
            NetworkUtil.convertStreamToString(NetworkUtil.doPost(val$url, hashmap, ((JSONObject) (obj)).toString()));
            val$listener.onDataSuccess("SOCIAL SETTINGS");
            return;
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            val$listener.onDataFailed("SOCIAL SETTINGS", DataRequest.getParseErrorString(1700));
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            val$listener.onDataFailed("SOCIAL SETTINGS", DataRequest.getNetworkErrorString(1700));
            return;
        }
        catch (URISyntaxException urisyntaxexception)
        {
            urisyntaxexception.printStackTrace();
        }
        val$listener.onDataFailed("SOCIAL SETTINGS", DataRequest.getURIExceptionString(1700));
        return;
    }

    taRequestListener()
    {
        this$0 = final_socialonapi;
        val$url = s;
        val$userID = s1;
        val$isSocialOn = flag;
        val$dialogShown = flag1;
        val$listener = taRequestListener.this;
        super();
    }
}
