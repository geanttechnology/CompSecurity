// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import com.gotv.crackle.Application;
import com.gotv.crackle.ApplicationConstants;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.model.PlayProgressItem;
import com.gotv.crackle.util.CrackleHMAC;
import com.gotv.crackle.util.NetworkUtil;
import com.gotv.crackle.util.OmnitureWrapper;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.data:
//            Localization, DataRequest

public class CrackleAccountManager
{

    private static final String ACCOUNT_TYPE = "account_type";
    private static final String AGE_PREF = "age";
    private static final String CLIENT_APPLICATION_PLATFORM = "clientApplicationPlatform";
    private static final int CREATE_ACCOUNT = 600;
    private static final String DOB = "dob";
    private static final String EMAIL_ADDRESS = "emailAddress";
    private static final String FIRST_LOGIN = "first_login";
    private static final int FORGOT_PASSWORD_BASE_CODE = 2000;
    private static final String GENDER = "gender";
    public static final int GENDER_FEMALE = 1;
    public static final int GENDER_MALE = 0;
    private static final String GENDER_PREF = "gender";
    private static final String GEO_CODE = "geoCode";
    private static final String IS_TERMS_OF_SERVICE_ACCEPTED = "isTermsOfServiceAccepted";
    private static final String LAST_LOGIN = "last_login";
    private static final String LOGGED_IN = "logged_in";
    private static final String MOBILE_PHONE_NUMBER = "mobilePhoneNumber";
    private static final String PASSWORD = "password";
    private static final String PHONE_UUID = "phoneUUID";
    private static final String PROGRESS_LIST = "Progress";
    private static final String SEND_NEWSLETTER = "sendNewsletter";
    public static final String TAG_FORGOT_PASSWORD = "ForgotPassword";
    public static final String TAG_GET_BULK_PROGRESS = "CrackleAccountManager Bulk Progress";
    public static final String TAG_REGISTER = "CrackleAccountManager Register";
    public static final String TAG_SET_ITEM_PROGRESS = "CrackleAccountManager Item Progress";
    public static final String TAG_SIGN_IN = "CrackleAccountManager Sign In";
    public static final String TAG_USER_PROFILE = "CrackleAccountManager User Profile";
    private static final String USER_ID = "userID";
    private static final int USER_LOGIN = 700;
    private static final String USER_NAME = "userName";
    private String mReturnString;

    public CrackleAccountManager()
    {
    }

    public static long getTimeOfFirstLogIn(String s)
    {
        return PreferenceManager.getDefaultSharedPreferences(Application.getInstance()).getLong("userIDfirst_login", 0L);
    }

    public static long getTimeOfLastLogIn(String s)
    {
        return PreferenceManager.getDefaultSharedPreferences(Application.getInstance()).getLong("userIDlast_login", 0L);
    }

    public static int getUserAge()
    {
        return PreferenceManager.getDefaultSharedPreferences(Application.getInstance()).getInt("age", -1);
    }

    public static int getUserGender()
    {
        return PreferenceManager.getDefaultSharedPreferences(Application.getInstance()).getInt("gender", -1);
    }

    public static String getUserID()
    {
        return PreferenceManager.getDefaultSharedPreferences(Application.getInstance()).getString("userID", null);
    }

    public static void getUserProfile(DataRequest.DataRequestListener datarequestlistener, String s)
    {
        if (s == null)
        {
            return;
        } else
        {
            (new Thread(String.format("https://%s/profile/%s?format=%s", new Object[] {
                Application.getInstance().getLocalization().getLoacalizedBaseURL(), s, "json"
            }), datarequestlistener) {

                final DataRequest.DataRequestListener val$listener;
                final String val$url;

                public void run()
                {
                    if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == DataRequest.RequestState.FAILED)
                    {
                        return;
                    }
                    Object obj;
                    obj = CrackleHMAC.encodeURL(url);
                    Object obj1 = new HashMap();
                    ((Map) (obj1)).put("Authorization", obj);
                    ((Map) (obj1)).put("User-Agent", ApplicationConstants.CUSTOM_USER_AGENT_STRING);
                    ((Map) (obj1)).put("Accept", "text/html,application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
                    ((Map) (obj1)).put("Content-Type", "application/json");
                    obj = new JSONObject(NetworkUtil.getStringFromUrl(url, ((Map) (obj1))));
                    Object obj2 = ((JSONObject) (obj)).getJSONObject("status");
                    obj1 = ((JSONObject) (obj2)).getString("messageCode");
                    obj2 = ((JSONObject) (obj2)).getString("message");
                    if (((String) (obj1)).compareTo("0") != 0)
                    {
                        if (listener != null)
                        {
                            listener.onDataFailed("CrackleAccountManager User Profile", ((String) (obj2)));
                            return;
                        }
                        break MISSING_BLOCK_LABEL_253;
                    }
                    try
                    {
                        CrackleAccountManager.setUserProfileData(((JSONObject) (obj)).getInt("age"), ((JSONObject) (obj)).getInt("gender"));
                        if (listener != null)
                        {
                            listener.onDataSuccess("CrackleAccountManager User Profile");
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        if (listener != null)
                        {
                            listener.onDataFailed("CrackleAccountManager User Profile", DataRequest.getParseErrorString(700));
                            return;
                        }
                    }
                    catch (IOException ioexception)
                    {
                        if (listener != null)
                        {
                            listener.onDataFailed("CrackleAccountManager User Profile", DataRequest.getNetworkErrorString(700));
                            return;
                        }
                    }
                    catch (URISyntaxException urisyntaxexception)
                    {
                        if (listener != null)
                        {
                            listener.onDataFailed("CrackleAccountManager User Profile", DataRequest.getURIExceptionString(700));
                        }
                    }
                }

            
            {
                url = s;
                listener = datarequestlistener;
                super();
            }
            }).start();
            return;
        }
    }

    public static boolean isLoggedIn()
    {
        return PreferenceManager.getDefaultSharedPreferences(Application.getInstance()).getBoolean("logged_in", false);
    }

    public static void logOut()
    {
        SharedPrefsManager.setSocialOnEnabled(false);
        Object obj = PreferenceManager.getDefaultSharedPreferences(Application.getInstance());
        String s = ((SharedPreferences) (obj)).getString("userID", null);
        String s1 = ((SharedPreferences) (obj)).getString("account_type", null);
        obj = ((SharedPreferences) (obj)).edit();
        ((android.content.SharedPreferences.Editor) (obj)).remove("userID");
        ((android.content.SharedPreferences.Editor) (obj)).remove("account_type");
        ((android.content.SharedPreferences.Editor) (obj)).remove("logged_in");
        ((android.content.SharedPreferences.Editor) (obj)).remove("gender");
        ((android.content.SharedPreferences.Editor) (obj)).remove("age");
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        Application.getInstance().getOmnitureTracker().logOut(s, s1);
    }

    public static void setUserLoggedIn(String s, String s1)
    {
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(Application.getInstance());
        android.content.SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("userID", s);
        editor.putString("account_type", s1);
        editor.putBoolean("logged_in", true);
        if (sharedpreferences.getLong((new StringBuilder()).append(s).append("first_login").toString(), 0L) == 0L)
        {
            editor.putLong((new StringBuilder()).append(s).append("first_login").toString(), (new Date()).getTime());
        }
        editor.putLong((new StringBuilder()).append(s).append("last_login").toString(), (new Date()).getTime());
        editor.commit();
        Application.getInstance().getOmnitureTracker().logIn(s, s1);
        getUserProfile(null, s);
    }

    private static void setUserProfileData(int i, int j)
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(Application.getInstance()).edit();
        editor.putInt("age", i);
        editor.putInt("gender", j);
        editor.commit();
    }

    public void createAccount(DataRequest.DataRequestListener datarequestlistener, String s, String s1, String s2, String s3, Integer integer, String s4, 
            Boolean boolean1, Boolean boolean2, String s5, String s6)
    {
        (new Thread() {

            final CrackleAccountManager this$0;
            final String val$dob;
            final String val$emailAddress;
            final Integer val$gender;
            final DataRequest.DataRequestListener val$listener;
            final String val$mobilePhoneNumber;
            final String val$password;
            final Boolean val$sendNewsletter;
            final Boolean val$termsOfServiceAccepted;
            final String val$url;
            final String val$userName;

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
                ((JSONObject) (obj1)).put("phoneUUID", Build.ID);
                if (emailAddress != null)
                {
                    ((JSONObject) (obj1)).put("emailAddress", emailAddress);
                }
                if (userName != null)
                {
                    ((JSONObject) (obj1)).put("userName", userName);
                }
                if (password != null)
                {
                    ((JSONObject) (obj1)).put("password", password);
                }
                if (gender != null)
                {
                    ((JSONObject) (obj1)).put("gender", gender);
                }
                if (dob != null)
                {
                    ((JSONObject) (obj1)).put("dob", dob);
                }
                if (sendNewsletter != null)
                {
                    ((JSONObject) (obj1)).put("sendNewsletter", sendNewsletter);
                }
                if (termsOfServiceAccepted != null)
                {
                    ((JSONObject) (obj1)).put("isTermsOfServiceAccepted", termsOfServiceAccepted);
                }
                if (mobilePhoneNumber != null)
                {
                    ((JSONObject) (obj1)).put("mobilePhoneNumber", mobilePhoneNumber);
                }
                ((JSONObject) (obj1)).put("clientApplicationPlatform", "Android");
                mReturnString = NetworkUtil.convertStreamToString(NetworkUtil.doPost(url, ((Map) (obj)), ((JSONObject) (obj1)).toString()));
                obj = new JSONObject(mReturnString);
                Object obj2 = ((JSONObject) (obj)).getJSONObject("status");
                obj1 = ((JSONObject) (obj2)).getString("messageCode");
                obj2 = ((JSONObject) (obj2)).getString("message");
                if (((String) (obj1)).compareTo("0") != 0)
                {
                    listener.onDataFailed("CrackleAccountManager Register", ((String) (obj2)));
                    return;
                }
                try
                {
                    Application.getInstance().getOmnitureTracker().registration(((JSONObject) (obj)).getString("userID"));
                    CrackleAccountManager.setUserLoggedIn(((JSONObject) (obj)).getString("userID"), "Crackle");
                    listener.onDataSuccess("CrackleAccountManager Register");
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ((JSONException) (obj)).printStackTrace();
                    listener.onDataFailed("CrackleAccountManager Register", DataRequest.getParseErrorString(600));
                    return;
                }
                catch (IOException ioexception)
                {
                    ioexception.printStackTrace();
                    listener.onDataFailed("CrackleAccountManager Register", DataRequest.getNetworkErrorString(600));
                    return;
                }
                catch (URISyntaxException urisyntaxexception)
                {
                    urisyntaxexception.printStackTrace();
                }
                listener.onDataFailed("CrackleAccountManager Register", DataRequest.getURIExceptionString(600));
                return;
            }

            
            {
                this$0 = CrackleAccountManager.this;
                url = s;
                emailAddress = s1;
                userName = s2;
                password = s3;
                gender = integer;
                dob = s4;
                sendNewsletter = boolean1;
                termsOfServiceAccepted = boolean2;
                mobilePhoneNumber = s5;
                listener = datarequestlistener;
                super();
            }
        }).start();
    }

    public void forgotPassword(DataRequest.DataRequestListener datarequestlistener, String s)
    {
        (new Thread() {

            final CrackleAccountManager this$0;
            final DataRequest.DataRequestListener val$listener;
            final String val$url;

            public void run()
            {
                try
                {
                    String s1 = CrackleHMAC.encodeURL(url);
                    HashMap hashmap = new HashMap();
                    hashmap.put("Authorization", s1);
                    s1 = NetworkUtil.getJSONFromUrl(url, hashmap).getString("message");
                    listener.onDataFailed("ForgotPassword", s1);
                    return;
                }
                catch (JSONException jsonexception)
                {
                    jsonexception.printStackTrace();
                    listener.onDataFailed("ForgotPassword", DataRequest.getParseErrorString(2000));
                    return;
                }
                catch (IOException ioexception)
                {
                    ioexception.printStackTrace();
                    listener.onDataFailed("ForgotPassword", DataRequest.getNetworkErrorString(2000));
                    return;
                }
                catch (URISyntaxException urisyntaxexception)
                {
                    urisyntaxexception.printStackTrace();
                }
                listener.onDataFailed("ForgotPassword", DataRequest.getURIExceptionString(2000));
            }

            
            {
                this$0 = CrackleAccountManager.this;
                url = s;
                listener = datarequestlistener;
                super();
            }
        }).start();
    }

    public String getReturnString()
    {
        return mReturnString;
    }

    public void setItemProgress(final String mediaID, int i, String s)
    {
        String s1 = getUserID();
        SharedPrefsManager.setPlayProgressForItem(mediaID, s, Integer.valueOf(i));
        if (s1 != null)
        {
            (new Thread() {

                final CrackleAccountManager this$0;
                final String val$mediaID;
                final int val$timeInSeconds;
                final String val$userID;

                public void run()
                {
                    try
                    {
                        String s2 = String.format("http://%s/pauseresume/media/%s/set/%s/member/%s/%s?format=json", new Object[] {
                            Application.getInstance().getLocalization().getLoacalizedBaseURL(), mediaID, (new StringBuilder()).append(timeInSeconds).append("").toString(), userID, Application.getInstance().getLocalization().getCurrentCountryCode()
                        });
                        String s3 = CrackleHMAC.encodeURL(s2);
                        HashMap hashmap = new HashMap();
                        hashmap.put("Authorization", s3);
                        NetworkUtil.getJSONFromUrl(s2, hashmap);
                        return;
                    }
                    catch (JSONException jsonexception)
                    {
                        jsonexception.printStackTrace();
                        return;
                    }
                    catch (IOException ioexception)
                    {
                        ioexception.printStackTrace();
                        return;
                    }
                    catch (URISyntaxException urisyntaxexception)
                    {
                        urisyntaxexception.printStackTrace();
                    }
                }

            
            {
                this$0 = CrackleAccountManager.this;
                mediaID = s;
                timeInSeconds = i;
                userID = s1;
                super();
            }
            }).start();
        }
    }

    public void updateBulkMediaProgress()
    {
        final String userID = getUserID();
        if (userID != null)
        {
            (new Thread() {

                final CrackleAccountManager this$0;
                final String val$userID;

                public void run()
                {
                    Object obj;
                    obj = String.format("http://%s/pauseresume/list/member/%s/%s?format=json", new Object[] {
                        Application.getInstance().getLocalization().getLoacalizedBaseURL(), userID, Application.getInstance().getLocalization().getCurrentCountryCode()
                    });
                    String s = CrackleHMAC.encodeURL(((String) (obj)));
                    HashMap hashmap = new HashMap();
                    hashmap.put("Authorization", s);
                    obj = NetworkUtil.getJSONFromUrl(((String) (obj)), hashmap).getJSONArray("Progress");
                    int i = 0;
_L2:
                    if (i >= ((JSONArray) (obj)).length())
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    PlayProgressItem playprogressitem = new PlayProgressItem(((JSONArray) (obj)).getJSONObject(i));
                    int j = Integer.parseInt(playprogressitem.getPosition());
                    SharedPrefsManager.updatePlayProgressForItem(playprogressitem.getID(), Integer.valueOf(j * 1000), Long.valueOf(playprogressitem.getTimeStamp()));
                    i++;
                    if (true) goto _L2; else goto _L1
                    Object obj1;
                    obj1;
                    ((JSONException) (obj1)).printStackTrace();
_L1:
                    return;
                    obj1;
                    ((IOException) (obj1)).printStackTrace();
                    return;
                    obj1;
                    ((URISyntaxException) (obj1)).printStackTrace();
                    return;
                }

            
            {
                this$0 = CrackleAccountManager.this;
                userID = s;
                super();
            }
            }).start();
        }
    }

    public void verifyUserLogin(DataRequest.DataRequestListener datarequestlistener, String s, String s1)
    {
        (new Thread() {

            final CrackleAccountManager this$0;
            final String val$emailAddress;
            final DataRequest.DataRequestListener val$listener;
            final String val$password;
            final String val$url;

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
                ((JSONObject) (obj1)).put("emailAddress", emailAddress);
                ((JSONObject) (obj1)).put("password", password);
                ((JSONObject) (obj1)).put("geoCode", Application.getInstance().getLocalization().getCurrentCountryCode());
                mReturnString = NetworkUtil.convertStreamToString(NetworkUtil.doPost(url, ((Map) (obj)), ((JSONObject) (obj1)).toString()));
                obj = new JSONObject(mReturnString);
                Object obj2 = ((JSONObject) (obj)).getJSONObject("status");
                obj1 = ((JSONObject) (obj2)).getString("messageCode");
                obj2 = ((JSONObject) (obj2)).getString("message");
                if (((String) (obj1)).compareTo("0") != 0)
                {
                    listener.onDataFailed("CrackleAccountManager Sign In", ((String) (obj2)));
                    return;
                }
                try
                {
                    Application.getInstance().getOmnitureTracker().loginTracking(((JSONObject) (obj)).getString("userID"));
                    CrackleAccountManager.setUserLoggedIn(((JSONObject) (obj)).getString("userID"), "Crackle");
                    listener.onDataSuccess("CrackleAccountManager Sign In");
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ((JSONException) (obj)).printStackTrace();
                    listener.onDataFailed("CrackleAccountManager Sign In", DataRequest.getParseErrorString(700));
                    return;
                }
                catch (IOException ioexception)
                {
                    ioexception.printStackTrace();
                    listener.onDataFailed("CrackleAccountManager Sign In", DataRequest.getNetworkErrorString(700));
                    return;
                }
                catch (URISyntaxException urisyntaxexception)
                {
                    urisyntaxexception.printStackTrace();
                }
                listener.onDataFailed("CrackleAccountManager Sign In", DataRequest.getURIExceptionString(700));
                return;
            }

            
            {
                this$0 = CrackleAccountManager.this;
                url = s;
                emailAddress = s1;
                password = s2;
                listener = datarequestlistener;
                super();
            }
        }).start();
    }



/*
    static String access$002(CrackleAccountManager crackleaccountmanager, String s)
    {
        crackleaccountmanager.mReturnString = s;
        return s;
    }

*/

}
