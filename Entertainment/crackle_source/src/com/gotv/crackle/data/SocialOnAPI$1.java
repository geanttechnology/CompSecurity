// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import com.gotv.crackle.Application;
import com.gotv.crackle.ApplicationConstants;
import com.gotv.crackle.FacebookHelperActivity;
import com.gotv.crackle.util.CrackleHMAC;
import com.gotv.crackle.util.NetworkUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.data:
//            SocialOnAPI, Localization, DataRequest, CrackleAccountManager

class taRequestListener extends Thread
{

    final SocialOnAPI this$0;
    final taRequestListener val$listener;
    final String val$token;
    final String val$url;
    final String val$userID;

    public void run()
    {
        Object obj;
        Object obj1;
        JSONException jsonexception2;
        JSONObject jsonobject;
        try
        {
            if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == questState.FAILED)
            {
                return;
            }
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            val$listener.onDataFailed("ACCOUNT_SSO", DataRequest.getParseErrorString(1600));
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            val$listener.onDataFailed("ACCOUNT_SSO", DataRequest.getNetworkErrorString(1600));
            return;
        }
        catch (URISyntaxException urisyntaxexception)
        {
            urisyntaxexception.printStackTrace();
            val$listener.onDataFailed("ACCOUNT_SSO", DataRequest.getURIExceptionString(1600));
            return;
        }
        obj1 = CrackleHMAC.encodeURL(val$url);
        obj = new HashMap();
        ((Map) (obj)).put("Authorization", obj1);
        ((Map) (obj)).put("User-Agent", ApplicationConstants.CUSTOM_USER_AGENT_STRING);
        ((Map) (obj)).put("Accept", "text/html,application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
        ((Map) (obj)).put("Content-Type", "application/json");
        obj1 = new JSONObject();
        ((JSONObject) (obj1)).put("GeoCode", Application.getInstance().getLocalization().getCurrentCountryCode());
        ((JSONObject) (obj1)).put("FacebookAuthToken", val$token);
        if (val$userID != null)
        {
            ((JSONObject) (obj1)).put("CrackleUserId", val$userID);
        }
        jsonobject = new JSONObject(NetworkUtil.convertStreamToString(NetworkUtil.doPost(val$url, ((Map) (obj)), ((JSONObject) (obj1)).toString())));
        obj1 = jsonobject.getJSONObject("StatusModel");
        obj = ((JSONObject) (obj1)).getString("messageCode");
        obj1 = ((JSONObject) (obj1)).getString("message");
        if (((String) (obj)).compareTo("0") != 0)
        {
            val$listener.onDataFailed("ACCOUNT_SSO", ((String) (obj1)));
            return;
        }
        jsonexception = null;
        obj1 = jsonobject.getString("CrackleUserId");
        jsonexception = ((JSONException) (obj1));
_L2:
        if (jsonexception == null)
        {
            break MISSING_BLOCK_LABEL_324;
        }
        if (jsonexception.length() > 1)
        {
            CrackleAccountManager.setUserLoggedIn(jsonexception, "Facebook");
            FacebookHelperActivity.setFacebookUserInfo(null, null, null, null, Boolean.valueOf(true));
            val$listener.onDataSuccess("ACCOUNT_SSO");
            return;
        }
        break MISSING_BLOCK_LABEL_324;
        jsonexception2;
        jsonexception2.printStackTrace();
        continue; /* Loop/switch isn't completed */
        urisyntaxexception = jsonobject.getJSONObject("UserInformation");
        if (urisyntaxexception == null)
        {
            break MISSING_BLOCK_LABEL_372;
        }
        FacebookHelperActivity.setFacebookUserInfo(urisyntaxexception.getString("First_Name"), urisyntaxexception.getString("Last_Name"), urisyntaxexception.getString("Email"), urisyntaxexception.getString("Gender"), Boolean.valueOf(true));
        return;
        JSONException jsonexception1;
        jsonexception1;
        jsonexception1.printStackTrace();
        return;
        if (true) goto _L2; else goto _L1
_L1:
    }

    taRequestListener()
    {
        this$0 = final_socialonapi;
        val$url = s;
        val$token = s1;
        val$userID = s2;
        val$listener = taRequestListener.this;
        super();
    }
}
