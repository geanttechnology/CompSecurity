// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import android.os.Build;
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
    final String val$dob;
    final String val$emailAddress;
    final Integer val$gender;
    final istener val$listener;
    final String val$mobilePhoneNumber;
    final String val$password;
    final Boolean val$sendNewsletter;
    final Boolean val$termsOfServiceAccepted;
    final String val$url;
    final String val$userName;

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
        ((JSONObject) (obj1)).put("phoneUUID", Build.ID);
        if (val$emailAddress != null)
        {
            ((JSONObject) (obj1)).put("emailAddress", val$emailAddress);
        }
        if (val$userName != null)
        {
            ((JSONObject) (obj1)).put("userName", val$userName);
        }
        if (val$password != null)
        {
            ((JSONObject) (obj1)).put("password", val$password);
        }
        if (val$gender != null)
        {
            ((JSONObject) (obj1)).put("gender", val$gender);
        }
        if (val$dob != null)
        {
            ((JSONObject) (obj1)).put("dob", val$dob);
        }
        if (val$sendNewsletter != null)
        {
            ((JSONObject) (obj1)).put("sendNewsletter", val$sendNewsletter);
        }
        if (val$termsOfServiceAccepted != null)
        {
            ((JSONObject) (obj1)).put("isTermsOfServiceAccepted", val$termsOfServiceAccepted);
        }
        if (val$mobilePhoneNumber != null)
        {
            ((JSONObject) (obj1)).put("mobilePhoneNumber", val$mobilePhoneNumber);
        }
        ((JSONObject) (obj1)).put("clientApplicationPlatform", "Android");
        CrackleAccountManager.access$002(CrackleAccountManager.this, NetworkUtil.convertStreamToString(NetworkUtil.doPost(val$url, ((Map) (obj)), ((JSONObject) (obj1)).toString())));
        obj = new JSONObject(CrackleAccountManager.access$000(CrackleAccountManager.this));
        Object obj2 = ((JSONObject) (obj)).getJSONObject("status");
        obj1 = ((JSONObject) (obj2)).getString("messageCode");
        obj2 = ((JSONObject) (obj2)).getString("message");
        if (((String) (obj1)).compareTo("0") != 0)
        {
            val$listener.onDataFailed("CrackleAccountManager Register", ((String) (obj2)));
            return;
        }
        try
        {
            Application.getInstance().getOmnitureTracker().registration(((JSONObject) (obj)).getString("userID"));
            CrackleAccountManager.setUserLoggedIn(((JSONObject) (obj)).getString("userID"), "Crackle");
            val$listener.onDataSuccess("CrackleAccountManager Register");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((JSONException) (obj)).printStackTrace();
            val$listener.onDataFailed("CrackleAccountManager Register", DataRequest.getParseErrorString(600));
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            val$listener.onDataFailed("CrackleAccountManager Register", DataRequest.getNetworkErrorString(600));
            return;
        }
        catch (URISyntaxException urisyntaxexception)
        {
            urisyntaxexception.printStackTrace();
        }
        val$listener.onDataFailed("CrackleAccountManager Register", DataRequest.getURIExceptionString(600));
        return;
    }

    istener()
    {
        this$0 = final_crackleaccountmanager;
        val$url = s;
        val$emailAddress = s1;
        val$userName = s2;
        val$password = s3;
        val$gender = integer;
        val$dob = s4;
        val$sendNewsletter = boolean1;
        val$termsOfServiceAccepted = boolean2;
        val$mobilePhoneNumber = s5;
        val$listener = istener.this;
        super();
    }
}
