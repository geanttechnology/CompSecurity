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
//            DataRequest, Localization, CrackleAccountManager

public class SocialOnAPI extends DataRequest
{

    private static final int DELETE_ACTION_ERROR_CODE_BASE = 1900;
    private static final int PUBLISH_ACTION_ERROR_CODE_BASE = 1800;
    private static final int SSO_ERROR_CODE_BASE_ERROR_CODE_BASE = 1600;
    public static final String TAG_DELETE = "SOCIAL_DELETE";
    public static final String TAG_PUBLISH = "SOCIAL_PUBLISH";
    public static final String TAG_SOCIAL_SETTINGS = "SOCIAL SETTINGS";
    public static final String TAG_SSO = "ACCOUNT_SSO";
    private static final int UPDATE_SOCIAL_SETTINGS_ERROR_CODE_BASE = 1700;
    private String mLastPostID;

    public SocialOnAPI()
    {
        mLastPostID = null;
    }

    private void publishFBAction(DataRequest.DataRequestListener datarequestlistener, String s, String s1, String s2, String s3)
    {
        (new Thread() {

            final SocialOnAPI this$0;
            final String val$actionName;
            final String val$itemID;
            final String val$itemType;
            final DataRequest.DataRequestListener val$listener;
            final String val$url;
            final String val$userID;

            public void run()
            {
                if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == DataRequest.RequestState.FAILED)
                {
                    return;
                }
                Object obj;
                Object obj1 = CrackleHMAC.encodeURL(url);
                obj = new HashMap();
                ((Map) (obj)).put("Authorization", obj1);
                ((Map) (obj)).put("User-Agent", ApplicationConstants.CUSTOM_USER_AGENT_STRING);
                ((Map) (obj)).put("Accept", "text/html,application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
                ((Map) (obj)).put("Content-Type", "application/json");
                obj1 = new JSONObject();
                ((JSONObject) (obj1)).put("UserID", userID);
                ((JSONObject) (obj1)).put("ActionName", actionName);
                ((JSONObject) (obj1)).put("ItemType", itemType);
                ((JSONObject) (obj1)).put("ItemID", itemID);
                ((JSONObject) (obj1)).put("GeoCode", Application.getInstance().getLocalization().getCurrentCountryCode());
                obj = new JSONObject(NetworkUtil.convertStreamToString(NetworkUtil.doPost(url, ((Map) (obj)), ((JSONObject) (obj1)).toString())));
                Object obj2 = ((JSONObject) (obj)).getJSONObject("status");
                obj1 = ((JSONObject) (obj2)).getString("messageCode");
                obj2 = ((JSONObject) (obj2)).getString("message");
                if (((String) (obj1)).compareTo("0") != 0)
                {
                    if (listener != null)
                    {
                        listener.onDataFailed("SOCIAL_PUBLISH", ((String) (obj2)));
                        return;
                    }
                    break MISSING_BLOCK_LABEL_339;
                }
                try
                {
                    mLastPostID = ((JSONObject) (obj)).getString("ActionID");
                    if (listener != null)
                    {
                        listener.onDataSuccess("SOCIAL_PUBLISH");
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ((JSONException) (obj)).printStackTrace();
                    if (listener != null)
                    {
                        listener.onDataFailed("SOCIAL_PUBLISH", DataRequest.getParseErrorString(1800));
                        return;
                    }
                }
                catch (IOException ioexception)
                {
                    ioexception.printStackTrace();
                    if (listener != null)
                    {
                        listener.onDataFailed("SOCIAL_PUBLISH", DataRequest.getNetworkErrorString(1800));
                        return;
                    }
                }
                catch (URISyntaxException urisyntaxexception)
                {
                    urisyntaxexception.printStackTrace();
                    if (listener != null)
                    {
                        listener.onDataFailed("SOCIAL_PUBLISH", DataRequest.getURIExceptionString(1800));
                    }
                }
            }

            
            {
                this$0 = SocialOnAPI.this;
                url = s;
                userID = s1;
                actionName = s2;
                itemType = s3;
                itemID = s4;
                listener = datarequestlistener;
                super();
            }
        }).start();
    }

    public void callSSOService(DataRequest.DataRequestListener datarequestlistener, String s, String s1)
    {
        (new Thread() {

            final SocialOnAPI this$0;
            final DataRequest.DataRequestListener val$listener;
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
                    if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == DataRequest.RequestState.FAILED)
                    {
                        return;
                    }
                }
                catch (JSONException jsonexception)
                {
                    jsonexception.printStackTrace();
                    listener.onDataFailed("ACCOUNT_SSO", DataRequest.getParseErrorString(1600));
                    return;
                }
                catch (IOException ioexception)
                {
                    ioexception.printStackTrace();
                    listener.onDataFailed("ACCOUNT_SSO", DataRequest.getNetworkErrorString(1600));
                    return;
                }
                catch (URISyntaxException urisyntaxexception)
                {
                    urisyntaxexception.printStackTrace();
                    listener.onDataFailed("ACCOUNT_SSO", DataRequest.getURIExceptionString(1600));
                    return;
                }
                obj1 = CrackleHMAC.encodeURL(url);
                obj = new HashMap();
                ((Map) (obj)).put("Authorization", obj1);
                ((Map) (obj)).put("User-Agent", ApplicationConstants.CUSTOM_USER_AGENT_STRING);
                ((Map) (obj)).put("Accept", "text/html,application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
                ((Map) (obj)).put("Content-Type", "application/json");
                obj1 = new JSONObject();
                ((JSONObject) (obj1)).put("GeoCode", Application.getInstance().getLocalization().getCurrentCountryCode());
                ((JSONObject) (obj1)).put("FacebookAuthToken", token);
                if (userID != null)
                {
                    ((JSONObject) (obj1)).put("CrackleUserId", userID);
                }
                jsonobject = new JSONObject(NetworkUtil.convertStreamToString(NetworkUtil.doPost(url, ((Map) (obj)), ((JSONObject) (obj1)).toString())));
                obj1 = jsonobject.getJSONObject("StatusModel");
                obj = ((JSONObject) (obj1)).getString("messageCode");
                obj1 = ((JSONObject) (obj1)).getString("message");
                if (((String) (obj)).compareTo("0") != 0)
                {
                    listener.onDataFailed("ACCOUNT_SSO", ((String) (obj1)));
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
                    listener.onDataSuccess("ACCOUNT_SSO");
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

            
            {
                this$0 = SocialOnAPI.this;
                url = s;
                token = s1;
                userID = s2;
                listener = datarequestlistener;
                super();
            }
        }).start();
    }

    public String getLastPostID()
    {
        return mLastPostID;
    }

    public void publishWantToWatchChannelItem(String s, String s1)
    {
        publishFBAction(null, s, "wanttowatch", "channel", s1);
    }

    public void publishWantToWatchMediaItem(String s, String s1)
    {
        publishFBAction(null, s, "wanttowatch", "media", s1);
    }

    public void publishWatchedhMediaItem(DataRequest.DataRequestListener datarequestlistener, String s, String s1)
    {
        publishFBAction(datarequestlistener, s, "watch", "media", s1);
    }

    public void unpublishLastPost(DataRequest.DataRequestListener datarequestlistener)
    {
        (new Thread() {

            final SocialOnAPI this$0;
            final DataRequest.DataRequestListener val$listener;
            final String val$url;

            public void run()
            {
                if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == DataRequest.RequestState.FAILED)
                {
                    return;
                }
                JSONException jsonexception;
                String s = CrackleHMAC.encodeURL(url);
                Object obj = new HashMap();
                ((Map) (obj)).put("Authorization", s);
                obj = NetworkUtil.getJSONFromUrl(url, ((Map) (obj))).getJSONObject("status");
                s = ((JSONObject) (obj)).getString("messageCode");
                obj = ((JSONObject) (obj)).getString("message");
                if (s.compareTo("0") != 0)
                {
                    if (listener != null)
                    {
                        listener.onDataFailed("SOCIAL_DELETE", ((String) (obj)));
                        return;
                    }
                    break MISSING_BLOCK_LABEL_207;
                }
                try
                {
                    if (listener != null)
                    {
                        listener.onDataSuccess("SOCIAL_DELETE");
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (JSONException jsonexception)
                {
                    jsonexception.printStackTrace();
                    if (listener != null)
                    {
                        listener.onDataFailed("SOCIAL_DELETE", DataRequest.getParseErrorString(1900));
                        return;
                    }
                }
                catch (IOException ioexception)
                {
                    ioexception.printStackTrace();
                    if (listener != null)
                    {
                        listener.onDataFailed("SOCIAL_DELETE", DataRequest.getNetworkErrorString(1900));
                        return;
                    }
                }
                catch (URISyntaxException urisyntaxexception)
                {
                    urisyntaxexception.printStackTrace();
                    if (listener != null)
                    {
                        listener.onDataFailed("SOCIAL_DELETE", DataRequest.getURIExceptionString(1900));
                    }
                }
            }

            
            {
                this$0 = SocialOnAPI.this;
                url = s;
                listener = datarequestlistener;
                super();
            }
        }).start();
    }

    public void updateSocialSettings(DataRequest.DataRequestListener datarequestlistener, String s, boolean flag, boolean flag1)
    {
        (new Thread() {

            final SocialOnAPI this$0;
            final boolean val$dialogShown;
            final boolean val$isSocialOn;
            final DataRequest.DataRequestListener val$listener;
            final String val$url;
            final String val$userID;

            public void run()
            {
                if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == DataRequest.RequestState.FAILED)
                {
                    return;
                }
                try
                {
                    Object obj = CrackleHMAC.encodeURL(url);
                    HashMap hashmap = new HashMap();
                    hashmap.put("Authorization", obj);
                    hashmap.put("User-Agent", ApplicationConstants.CUSTOM_USER_AGENT_STRING);
                    hashmap.put("Accept", "text/html,application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
                    hashmap.put("Content-Type", "application/json");
                    obj = new JSONObject();
                    ((JSONObject) (obj)).put("UserID", userID);
                    ((JSONObject) (obj)).put("IsSocialON", isSocialOn);
                    ((JSONObject) (obj)).put("IsSocialMessageDisplayed", dialogShown);
                    NetworkUtil.convertStreamToString(NetworkUtil.doPost(url, hashmap, ((JSONObject) (obj)).toString()));
                    listener.onDataSuccess("SOCIAL SETTINGS");
                    return;
                }
                catch (JSONException jsonexception)
                {
                    jsonexception.printStackTrace();
                    listener.onDataFailed("SOCIAL SETTINGS", DataRequest.getParseErrorString(1700));
                    return;
                }
                catch (IOException ioexception)
                {
                    ioexception.printStackTrace();
                    listener.onDataFailed("SOCIAL SETTINGS", DataRequest.getNetworkErrorString(1700));
                    return;
                }
                catch (URISyntaxException urisyntaxexception)
                {
                    urisyntaxexception.printStackTrace();
                }
                listener.onDataFailed("SOCIAL SETTINGS", DataRequest.getURIExceptionString(1700));
                return;
            }

            
            {
                this$0 = SocialOnAPI.this;
                url = s;
                userID = s1;
                isSocialOn = flag;
                dialogShown = flag1;
                listener = datarequestlistener;
                super();
            }
        }).start();
    }


/*
    static String access$002(SocialOnAPI socialonapi, String s)
    {
        socialonapi.mLastPostID = s;
        return s;
    }

*/
}
