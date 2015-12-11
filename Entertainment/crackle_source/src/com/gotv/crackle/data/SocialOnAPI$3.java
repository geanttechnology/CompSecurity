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
    final String val$actionName;
    final String val$itemID;
    final String val$itemType;
    final taRequestListener val$listener;
    final String val$url;
    final String val$userID;

    public void run()
    {
        if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == questState.FAILED)
        {
            return;
        }
        Object obj;
        Object obj1 = CrackleHMAC.encodeURL(val$url);
        obj = new HashMap();
        ((Map) (obj)).put("Authorization", obj1);
        ((Map) (obj)).put("User-Agent", ApplicationConstants.CUSTOM_USER_AGENT_STRING);
        ((Map) (obj)).put("Accept", "text/html,application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
        ((Map) (obj)).put("Content-Type", "application/json");
        obj1 = new JSONObject();
        ((JSONObject) (obj1)).put("UserID", val$userID);
        ((JSONObject) (obj1)).put("ActionName", val$actionName);
        ((JSONObject) (obj1)).put("ItemType", val$itemType);
        ((JSONObject) (obj1)).put("ItemID", val$itemID);
        ((JSONObject) (obj1)).put("GeoCode", Application.getInstance().getLocalization().getCurrentCountryCode());
        obj = new JSONObject(NetworkUtil.convertStreamToString(NetworkUtil.doPost(val$url, ((Map) (obj)), ((JSONObject) (obj1)).toString())));
        Object obj2 = ((JSONObject) (obj)).getJSONObject("status");
        obj1 = ((JSONObject) (obj2)).getString("messageCode");
        obj2 = ((JSONObject) (obj2)).getString("message");
        if (((String) (obj1)).compareTo("0") != 0)
        {
            if (val$listener != null)
            {
                val$listener.onDataFailed("SOCIAL_PUBLISH", ((String) (obj2)));
                return;
            }
            break MISSING_BLOCK_LABEL_339;
        }
        try
        {
            SocialOnAPI.access$002(SocialOnAPI.this, ((JSONObject) (obj)).getString("ActionID"));
            if (val$listener != null)
            {
                val$listener.onDataSuccess("SOCIAL_PUBLISH");
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((JSONException) (obj)).printStackTrace();
            if (val$listener != null)
            {
                val$listener.onDataFailed("SOCIAL_PUBLISH", DataRequest.getParseErrorString(1800));
                return;
            }
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            if (val$listener != null)
            {
                val$listener.onDataFailed("SOCIAL_PUBLISH", DataRequest.getNetworkErrorString(1800));
                return;
            }
        }
        catch (URISyntaxException urisyntaxexception)
        {
            urisyntaxexception.printStackTrace();
            if (val$listener != null)
            {
                val$listener.onDataFailed("SOCIAL_PUBLISH", DataRequest.getURIExceptionString(1800));
            }
        }
    }

    taRequestListener()
    {
        this$0 = final_socialonapi;
        val$url = s;
        val$userID = s1;
        val$actionName = s2;
        val$itemType = s3;
        val$itemID = s4;
        val$listener = taRequestListener.this;
        super();
    }
}
