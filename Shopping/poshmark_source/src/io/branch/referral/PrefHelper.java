// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            BranchRemoteInterface, NetworkCallback, ServerResponse

public class PrefHelper
{
    public static class DebugNetworkCallback
        implements NetworkCallback
    {

        private int connectionStatus;

        public void finished(ServerResponse serverresponse)
        {
            if (serverresponse == null)
            {
                break MISSING_BLOCK_LABEL_216;
            }
            String s;
            connectionStatus = serverresponse.getStatusCode();
            s = serverresponse.getTag();
            if (connectionStatus != 465) goto _L2; else goto _L1
_L1:
            PrefHelper.BNC_Remote_Debug = false;
            Log.i("Branch Debug", "======= Server is not listening =======");
_L3:
            PrefHelper.BNC_Debug_Connecting = false;
            return;
_L2:
label0:
            {
                if (connectionStatus < 400 || connectionStatus >= 500)
                {
                    break label0;
                }
                if (serverresponse.getObject() != null && serverresponse.getObject().has("error") && serverresponse.getObject().getJSONObject("error").has("message"))
                {
                    Log.i("BranchSDK", (new StringBuilder()).append("Branch API Error: ").append(serverresponse.getObject().getJSONObject("error").getString("message")).toString());
                }
            }
              goto _L3
            if (connectionStatus == 200) goto _L5; else goto _L4
_L4:
            if (connectionStatus != -1009)
            {
                break MISSING_BLOCK_LABEL_180;
            }
            Log.i("BranchSDK", "Branch API Error: poor network connectivity. Please try again later.");
              goto _L3
            try
            {
                Log.i("BranchSDK", "Trouble reaching server. Please try again in a few minutes.");
            }
            // Misplaced declaration of an exception variable
            catch (ServerResponse serverresponse)
            {
                serverresponse.printStackTrace();
                return;
            }
              goto _L3
_L5:
            if (!s.equals("t_debug_connect")) goto _L3; else goto _L6
_L6:
            PrefHelper.BNC_Remote_Debug = true;
            Log.i("Branch Debug", "======= Connected to Branch Remote Debugger =======");
              goto _L3
        }

        public int getConnectionStatus()
        {
            return connectionStatus;
        }

        public DebugNetworkCallback()
        {
        }
    }


    private static boolean BNC_App_Listing = false;
    private static boolean BNC_Debug = false;
    private static boolean BNC_Debug_Connecting = false;
    private static boolean BNC_Dev_Debug = false;
    private static boolean BNC_Remote_Debug = false;
    private static boolean BNC_Smart_Session = false;
    private static boolean BNC_Touch_Debugging = false;
    private static String Branch_Key = null;
    public static final int DEBUG_TRIGGER_NUM_FINGERS = 4;
    public static final int DEBUG_TRIGGER_PRESS_TIME = 3000;
    private static final int INTERVAL_RETRY = 0;
    private static final String KEY_ACTIONS = "bnc_actions";
    private static final String KEY_APP_KEY = "bnc_app_key";
    private static final String KEY_APP_LINK = "bnc_app_link";
    private static final String KEY_APP_VERSION = "bnc_app_version";
    private static final String KEY_BRANCH_KEY = "bnc_branch_key";
    private static final String KEY_BUCKETS = "bnc_buckets";
    private static final String KEY_CREDIT_BASE = "bnc_credit_base_";
    private static final String KEY_DEVICE_FINGERPRINT_ID = "bnc_device_fingerprint_id";
    private static final String KEY_EXTERNAL_INTENT_EXTRA = "bnc_external_intent_extra";
    private static final String KEY_EXTERNAL_INTENT_URI = "bnc_external_intent_uri";
    private static final String KEY_IDENTITY = "bnc_identity";
    private static final String KEY_IDENTITY_ID = "bnc_identity_id";
    private static final String KEY_INSTALL_PARAMS = "bnc_install_params";
    private static final String KEY_IS_REFERRABLE = "bnc_is_referrable";
    private static final String KEY_LAST_READ_SYSTEM = "bnc_system_read_date";
    private static final String KEY_LINK_CLICK_ID = "bnc_link_click_id";
    private static final String KEY_LINK_CLICK_IDENTIFIER = "bnc_link_click_identifier";
    private static final String KEY_RETRY_COUNT = "bnc_retry_count";
    private static final String KEY_RETRY_INTERVAL = "bnc_retry_interval";
    private static final String KEY_SESSION_ID = "bnc_session_id";
    private static final String KEY_SESSION_PARAMS = "bnc_session_params";
    private static final String KEY_TIMEOUT = "bnc_timeout";
    private static final String KEY_TOTAL_BASE = "bnc_total_base_";
    private static final String KEY_UNIQUE_BASE = "bnc_balance_base_";
    private static final String KEY_USER_URL = "bnc_user_url";
    private static final int MAX_RETRIES = 1;
    public static final String NO_STRING_VALUE = "bnc_no_value";
    public static final String REQ_TAG_DEBUG_CONNECT = "t_debug_connect";
    public static final String REQ_TAG_DEBUG_DISCONNECT = "t_debug_disconnect";
    public static final String REQ_TAG_DEBUG_LOG = "t_debug_log";
    public static final String REQ_TAG_DEBUG_SCREEN = "t_debug_screen";
    private static final String SHARED_PREF_FILE = "branch_referral_shared_pref";
    private static final int TIMEOUT = 5000;
    private static PrefHelper prefHelper_;
    private SharedPreferences appSharedPrefs_;
    private Context context_;
    private android.content.SharedPreferences.Editor prefsEditor_;
    private BranchRemoteInterface remoteInterface_;

    public PrefHelper()
    {
    }

    private PrefHelper(Context context)
    {
        appSharedPrefs_ = context.getSharedPreferences("branch_referral_shared_pref", 0);
        prefsEditor_ = appSharedPrefs_.edit();
        context_ = context;
    }

    public static void Debug(String s, String s1)
    {
        if (prefHelper_ != null)
        {
            prefHelper_.log(s, s1);
        } else
        if (BNC_Debug || BNC_Dev_Debug)
        {
            Log.i(s, s1);
            return;
        }
    }

    private void clearPrefOnBranchKeyChange()
    {
        String s = getLinkClickID();
        String s1 = getLinkClickIdentifier();
        String s2 = getAppLink();
        prefsEditor_.clear();
        setLinkClickID(s);
        setLinkClickIdentifier(s1);
        setAppLink(s2);
        prefHelper_.prefsEditor_.commit();
    }

    private ArrayList deserializeString(String s)
    {
        ArrayList arraylist = new ArrayList();
        Collections.addAll(arraylist, s.split(","));
        return arraylist;
    }

    private ArrayList getActions()
    {
        String s = getString("bnc_actions");
        if (s.equals("bnc_no_value"))
        {
            return new ArrayList();
        } else
        {
            return deserializeString(s);
        }
    }

    private ArrayList getBuckets()
    {
        String s = getString("bnc_buckets");
        if (s.equals("bnc_no_value"))
        {
            return new ArrayList();
        } else
        {
            return deserializeString(s);
        }
    }

    public static PrefHelper getInstance(Context context)
    {
        if (prefHelper_ == null)
        {
            prefHelper_ = new PrefHelper(context);
        }
        return prefHelper_;
    }

    private String serializeArrayList(ArrayList arraylist)
    {
        String s = "";
        Iterator iterator = arraylist.iterator();
        for (arraylist = s; iterator.hasNext(); arraylist = (new StringBuilder()).append(arraylist).append(s).append(",").toString())
        {
            s = (String)iterator.next();
        }

        return arraylist.substring(0, arraylist.length() - 1);
    }

    private void setActions(ArrayList arraylist)
    {
        if (arraylist.size() == 0)
        {
            setString("bnc_actions", "bnc_no_value");
            return;
        } else
        {
            setString("bnc_actions", serializeArrayList(arraylist));
            return;
        }
    }

    private void setBuckets(ArrayList arraylist)
    {
        if (arraylist.size() == 0)
        {
            setString("bnc_buckets", "bnc_no_value");
            return;
        } else
        {
            setString("bnc_buckets", serializeArrayList(arraylist));
            return;
        }
    }

    public void clearDebug()
    {
        BNC_Debug = false;
        BNC_Debug_Connecting = false;
        if (BNC_Remote_Debug)
        {
            BNC_Remote_Debug = false;
            if (remoteInterface_ != null)
            {
                (new Thread(new Runnable() {

                    final PrefHelper this$0;

                    public void run()
                    {
                        remoteInterface_.disconnectFromDebug();
                    }

            
            {
                this$0 = PrefHelper.this;
                super();
            }
                })).start();
            }
        }
    }

    public void clearIsReferrable()
    {
        setInteger("bnc_is_referrable", 0);
    }

    public void clearSystemReadStatus()
    {
        setLong("bnc_system_read_date", Calendar.getInstance().getTimeInMillis() / 1000L);
    }

    public void clearUserValues()
    {
        for (Iterator iterator = getBuckets().iterator(); iterator.hasNext(); setCreditCount((String)iterator.next(), 0)) { }
        setBuckets(new ArrayList());
        String s;
        for (Iterator iterator1 = getActions().iterator(); iterator1.hasNext(); setActionUniqueCount(s, 0))
        {
            s = (String)iterator1.next();
            setActionTotalCount(s, 0);
        }

        setActions(new ArrayList());
    }

    public void disableExternAppListing()
    {
        BNC_App_Listing = false;
    }

    public void disableSmartSession()
    {
        BNC_Smart_Session = false;
    }

    public void disableTouchDebugging()
    {
        BNC_Touch_Debugging = false;
    }

    public String getAPIBaseUrl()
    {
        return "https://api.branch.io/";
    }

    public int getActionTotalCount(String s)
    {
        return getInteger((new StringBuilder()).append("bnc_total_base_").append(s).toString());
    }

    public int getActionUniqueCount(String s)
    {
        return getInteger((new StringBuilder()).append("bnc_balance_base_").append(s).toString());
    }

    public String getAppKey()
    {
        String s = null;
        ApplicationInfo applicationinfo = context_.getPackageManager().getApplicationInfo(context_.getPackageName(), 128);
        Object obj = s;
        try
        {
            if (applicationinfo.metaData != null)
            {
                obj = applicationinfo.metaData.getString("io.branch.sdk.ApplicationId");
            }
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception = s;
        }
        s = ((String) (obj));
        if (obj == null)
        {
            s = getString("bnc_app_key");
        }
        return s;
    }

    public String getAppLink()
    {
        return getString("bnc_app_link");
    }

    public String getAppVersion()
    {
        return getString("bnc_app_version");
    }

    public boolean getBool(String s)
    {
        return prefHelper_.appSharedPrefs_.getBoolean(s, false);
    }

    public String getBranchKey()
    {
        if (Branch_Key == null)
        {
            Branch_Key = getString("bnc_branch_key");
        }
        return Branch_Key;
    }

    public int getCreditCount()
    {
        return getCreditCount(Defines.Jsonkey.DefaultBucket.getKey());
    }

    public int getCreditCount(String s)
    {
        return getInteger((new StringBuilder()).append("bnc_credit_base_").append(s).toString());
    }

    public String getDeviceFingerPrintID()
    {
        return getString("bnc_device_fingerprint_id");
    }

    public boolean getExternAppListing()
    {
        return BNC_App_Listing;
    }

    public boolean getExternDebug()
    {
        return BNC_Dev_Debug;
    }

    public String getExternalIntentExtra()
    {
        return getString("bnc_external_intent_extra");
    }

    public String getExternalIntentUri()
    {
        return getString("bnc_external_intent_uri");
    }

    public float getFloat(String s)
    {
        return prefHelper_.appSharedPrefs_.getFloat(s, 0.0F);
    }

    public String getIdentity()
    {
        return getString("bnc_identity");
    }

    public String getIdentityID()
    {
        return getString("bnc_identity_id");
    }

    public String getInstallParams()
    {
        return getString("bnc_install_params");
    }

    public int getInteger(String s)
    {
        return getInteger(s, 0);
    }

    public int getInteger(String s, int i)
    {
        return prefHelper_.appSharedPrefs_.getInt(s, i);
    }

    public int getIsReferrable()
    {
        return getInteger("bnc_is_referrable");
    }

    public String getLinkClickID()
    {
        return getString("bnc_link_click_id");
    }

    public String getLinkClickIdentifier()
    {
        return getString("bnc_link_click_identifier");
    }

    public long getLong(String s)
    {
        return prefHelper_.appSharedPrefs_.getLong(s, 0L);
    }

    public int getRetryCount()
    {
        return getInteger("bnc_retry_count", 1);
    }

    public int getRetryInterval()
    {
        return getInteger("bnc_retry_interval", 0);
    }

    public String getSessionID()
    {
        return getString("bnc_session_id");
    }

    public String getSessionParams()
    {
        return getString("bnc_session_params");
    }

    public boolean getSmartSession()
    {
        return BNC_Smart_Session;
    }

    public String getString(String s)
    {
        return prefHelper_.appSharedPrefs_.getString(s, "bnc_no_value");
    }

    public int getTimeout()
    {
        return getInteger("bnc_timeout", 5000);
    }

    public boolean getTouchDebugging()
    {
        return BNC_Touch_Debugging;
    }

    public String getUserURL()
    {
        return getString("bnc_user_url");
    }

    public boolean isDebug()
    {
        return BNC_Debug;
    }

    public boolean keepDebugConnection()
    {
        if (BNC_Remote_Debug && remoteInterface_ != null)
        {
            (new Thread(new Runnable() {

                final PrefHelper this$0;

                public void run()
                {
                    remoteInterface_.sendLog("");
                }

            
            {
                this$0 = PrefHelper.this;
                super();
            }
            })).start();
            return true;
        } else
        {
            return BNC_Debug_Connecting;
        }
    }

    public void log(final String tag, final String message)
    {
        if (BNC_Debug || BNC_Dev_Debug)
        {
            Log.i(tag, message);
            if (BNC_Remote_Debug && remoteInterface_ != null)
            {
                (new Thread(new Runnable() {

                    final PrefHelper this$0;
                    final String val$message;
                    final String val$tag;

                    public void run()
                    {
                        remoteInterface_.sendLog((new StringBuilder()).append(tag).append("\t").append(message).toString());
                    }

            
            {
                this$0 = PrefHelper.this;
                tag = s;
                message = s1;
                super();
            }
                })).start();
            }
        }
    }

    public String readBranchKey(boolean flag)
    {
        Object obj;
        String s;
        Object obj1 = null;
        obj = null;
        String s1;
        ApplicationInfo applicationinfo;
        if (flag)
        {
            s1 = "io.branch.sdk.BranchKey";
        } else
        {
            s1 = "io.branch.sdk.BranchKey.test";
        }
        if (!flag)
        {
            setExternDebug();
        }
        s = obj1;
        applicationinfo = context_.getPackageManager().getApplicationInfo(context_.getPackageName(), 128);
        s = obj1;
        if (applicationinfo.metaData == null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        s = obj1;
        s1 = applicationinfo.metaData.getString(s1);
        obj = s1;
        if (s1 == null)
        {
            obj = s1;
            if (!flag)
            {
                s = s1;
                try
                {
                    obj = applicationinfo.metaData.getString("io.branch.sdk.BranchKey");
                }
                catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
                {
                    namenotfoundexception = s;
                }
            }
        }
        s = ((String) (obj));
        if (obj == null)
        {
            s = "bnc_no_value";
        }
        return s;
    }

    public void setActionTotalCount(String s, int i)
    {
        ArrayList arraylist = getActions();
        if (!arraylist.contains(s))
        {
            arraylist.add(s);
            setActions(arraylist);
        }
        setInteger((new StringBuilder()).append("bnc_total_base_").append(s).toString(), i);
    }

    public void setActionUniqueCount(String s, int i)
    {
        setInteger((new StringBuilder()).append("bnc_balance_base_").append(s).toString(), i);
    }

    public void setAppKey(String s)
    {
        setString("bnc_app_key", s);
    }

    public void setAppLink(String s)
    {
        setString("bnc_app_link", s);
    }

    public void setAppVersion(String s)
    {
        setString("bnc_app_version", s);
    }

    public void setBool(String s, Boolean boolean1)
    {
        prefHelper_.prefsEditor_.putBoolean(s, boolean1.booleanValue());
        prefHelper_.prefsEditor_.commit();
    }

    public boolean setBranchKey(String s)
    {
        Branch_Key = s;
        String s1 = getString("bnc_branch_key");
        if (s == null || s1 == null || !s1.equals(s))
        {
            clearPrefOnBranchKeyChange();
            setString("bnc_branch_key", s);
            return true;
        } else
        {
            return false;
        }
    }

    public void setCreditCount(int i)
    {
        setCreditCount(Defines.Jsonkey.DefaultBucket.getKey(), i);
    }

    public void setCreditCount(String s, int i)
    {
        ArrayList arraylist = getBuckets();
        if (!arraylist.contains(s))
        {
            arraylist.add(s);
            setBuckets(arraylist);
        }
        setInteger((new StringBuilder()).append("bnc_credit_base_").append(s).toString(), i);
    }

    public void setDebug()
    {
        BNC_Debug = true;
        BNC_Debug_Connecting = true;
        if (!BNC_Remote_Debug)
        {
            (new Thread(new Runnable() {

                final PrefHelper this$0;

                public void run()
                {
                    if (remoteInterface_ == null)
                    {
                        remoteInterface_ = new BranchRemoteInterface(context_);
                        remoteInterface_.setNetworkCallbackListener(new DebugNetworkCallback());
                    }
                    remoteInterface_.connectToDebug();
                }

            
            {
                this$0 = PrefHelper.this;
                super();
            }
            })).start();
        }
    }

    public void setDeviceFingerPrintID(String s)
    {
        setString("bnc_device_fingerprint_id", s);
    }

    public void setExternDebug()
    {
        BNC_Dev_Debug = true;
    }

    public void setExternalIntentExtra(String s)
    {
        setString("bnc_external_intent_extra", s);
    }

    public void setExternalIntentUri(String s)
    {
        setString("bnc_external_intent_uri", s);
    }

    public void setFloat(String s, float f)
    {
        prefHelper_.prefsEditor_.putFloat(s, f);
        prefHelper_.prefsEditor_.commit();
    }

    public void setIdentity(String s)
    {
        setString("bnc_identity", s);
    }

    public void setIdentityID(String s)
    {
        setString("bnc_identity_id", s);
    }

    public void setInstallParams(String s)
    {
        setString("bnc_install_params", s);
    }

    public void setInteger(String s, int i)
    {
        prefHelper_.prefsEditor_.putInt(s, i);
        prefHelper_.prefsEditor_.commit();
    }

    public void setIsReferrable()
    {
        setInteger("bnc_is_referrable", 1);
    }

    public void setLinkClickID(String s)
    {
        setString("bnc_link_click_id", s);
    }

    public void setLinkClickIdentifier(String s)
    {
        setString("bnc_link_click_identifier", s);
    }

    public void setLong(String s, long l)
    {
        prefHelper_.prefsEditor_.putLong(s, l);
        prefHelper_.prefsEditor_.commit();
    }

    public void setRetryCount(int i)
    {
        setInteger("bnc_retry_count", i);
    }

    public void setRetryInterval(int i)
    {
        setInteger("bnc_retry_interval", i);
    }

    public void setSessionID(String s)
    {
        setString("bnc_session_id", s);
    }

    public void setSessionParams(String s)
    {
        setString("bnc_session_params", s);
    }

    public void setString(String s, String s1)
    {
        prefHelper_.prefsEditor_.putString(s, s1);
        prefHelper_.prefsEditor_.commit();
    }

    public void setTimeout(int i)
    {
        setInteger("bnc_timeout", i);
    }

    public void setUserURL(String s)
    {
        setString("bnc_user_url", s);
    }

    static 
    {
        BNC_Dev_Debug = false;
        BNC_Debug = false;
        BNC_Debug_Connecting = false;
        BNC_Remote_Debug = false;
        BNC_App_Listing = true;
        BNC_Touch_Debugging = true;
        BNC_Smart_Session = true;
    }



/*
    static BranchRemoteInterface access$002(PrefHelper prefhelper, BranchRemoteInterface branchremoteinterface)
    {
        prefhelper.remoteInterface_ = branchremoteinterface;
        return branchremoteinterface;
    }

*/



/*
    static boolean access$202(boolean flag)
    {
        BNC_Remote_Debug = flag;
        return flag;
    }

*/


/*
    static boolean access$302(boolean flag)
    {
        BNC_Debug_Connecting = flag;
        return flag;
    }

*/
}
