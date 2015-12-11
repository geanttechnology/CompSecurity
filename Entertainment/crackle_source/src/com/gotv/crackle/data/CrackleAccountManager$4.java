// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import com.gotv.crackle.Application;
import com.gotv.crackle.ApplicationConstants;
import com.gotv.crackle.util.CrackleHMAC;
import com.gotv.crackle.util.NetworkUtil;
import com.gotv.crackle.util.OmnitureWrapper;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.data:
//            CrackleAccountManager, Localization, DataRequest

class istener extends Thread
{

    final CrackleAccountManager this$0;
    final String val$emailAddress;
    final istener val$listener;
    final String val$password;
    final String val$url;

    public void run()
    {
        if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == .FAILED)
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
        ((JSONObject) (obj1)).put("emailAddress", val$emailAddress);
        ((JSONObject) (obj1)).put("password", val$password);
        ((JSONObject) (obj1)).put("geoCode", Application.getInstance().getLocalization().getCurrentCountryCode());
        CrackleAccountManager.access$002(CrackleAccountManager.this, NetworkUtil.convertStreamToString(NetworkUtil.doPost(val$url, ((Map) (obj)), ((JSONObject) (obj1)).toString())));
        obj = new JSONObject(CrackleAccountManager.access$000(CrackleAccountManager.this));
        Object obj2 = ((JSONObject) (obj)).getJSONObject("status");
        obj1 = ((JSONObject) (obj2)).getString("messageCode");
        obj2 = ((JSONObject) (obj2)).getString("message");
        if (((String) (obj1)).compareTo("0") != 0)
        {
            val$listener.onDataFailed("CrackleAccountManager Sign In", ((String) (obj2)));
            return;
        }
        try
        {
            Application.getInstance().getOmnitureTracker().loginTracking(((JSONObject) (obj)).getString("userID"));
            CrackleAccountManager.setUserLoggedIn(((JSONObject) (obj)).getString("userID"), "Crackle");
            val$listener.onDataSuccess("CrackleAccountManager Sign In");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((JSONException) (obj)).printStackTrace();
            val$listener.onDataFailed("CrackleAccountManager Sign In", DataRequest.getParseErrorString(700));
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            val$listener.onDataFailed("CrackleAccountManager Sign In", DataRequest.getNetworkErrorString(700));
            return;
        }
        catch (URISyntaxException urisyntaxexception)
        {
            urisyntaxexception.printStackTrace();
        }
        val$listener.onDataFailed("CrackleAccountManager Sign In", DataRequest.getURIExceptionString(700));
        return;
    }

    istener()
    {
        this$0 = final_crackleaccountmanager;
        val$url = s;
        val$emailAddress = s1;
        val$password = s2;
        val$listener = istener.this;
        super();
    }
}
