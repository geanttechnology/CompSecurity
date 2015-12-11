// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.supersonicads.sdk.data.SSABCParameters;
import com.supersonicads.sdk.data.SSAObj;
import com.supersonicads.sdk.data.SSASession;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SupersonicSharedPrefHelper
{

    private static final String APPLICATION_KEY_BC = "application_key_bc";
    private static final String APPLICATION_KEY_IS = "application_key_is";
    private static final String APPLICATION_KEY_OW = "application_key_ow";
    private static final String BACK_BUTTON_STATE = "back_button_state";
    private static final String IS_REPORTED = "is_reported";
    private static final String REGISTER_SESSIONS = "register_sessions";
    private static final String SEARCH_KEYS = "search_keys";
    private static final String SESSIONS = "sessions";
    private static final String SSA_BC_PARAMETER_CONNECTION_RETRIES = "ssa_bc_parameter_connection_retries";
    private static final String SSA_SDK_DOWNLOAD_URL = "ssa_sdk_download_url";
    private static final String SSA_SDK_LOAD_URL = "ssa_sdk_load_url";
    private static final String SUPERSONIC_SHARED_PREF = "supersonic_shared_preferen";
    private static final String UNIQUE_ID_BC = "unique_id_bc";
    private static final String UNIQUE_ID_IS = "unique_id_is";
    private static final String UNIQUE_ID_OW = "unique_id_ow";
    private static final String USER_ID_BC = "user_id_bc";
    private static final String USER_ID_IS = "user_id_is";
    private static final String USER_ID_OW = "user_id_ow";
    private static final String VERSION = "version";
    private static SupersonicSharedPrefHelper mInstance;
    private SharedPreferences mSharedPreferences;

    private SupersonicSharedPrefHelper(Context context)
    {
        mSharedPreferences = context.getSharedPreferences("supersonic_shared_preferen", 0);
    }

    private boolean getShouldRegisterSessions()
    {
        return mSharedPreferences.getBoolean("register_sessions", true);
    }

    public static SupersonicSharedPrefHelper getSupersonicPrefHelper()
    {
        com/supersonicads/sdk/utils/SupersonicSharedPrefHelper;
        JVM INSTR monitorenter ;
        SupersonicSharedPrefHelper supersonicsharedprefhelper = mInstance;
        com/supersonicads/sdk/utils/SupersonicSharedPrefHelper;
        JVM INSTR monitorexit ;
        return supersonicsharedprefhelper;
        Exception exception;
        exception;
        throw exception;
    }

    public static SupersonicSharedPrefHelper getSupersonicPrefHelper(Context context)
    {
        com/supersonicads/sdk/utils/SupersonicSharedPrefHelper;
        JVM INSTR monitorenter ;
        if (mInstance == null)
        {
            mInstance = new SupersonicSharedPrefHelper(context);
        }
        context = mInstance;
        com/supersonicads/sdk/utils/SupersonicSharedPrefHelper;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public void addSession(SSASession ssasession)
    {
        if (getShouldRegisterSessions())
        {
            JSONObject jsonobject = new JSONObject();
            Object obj;
            try
            {
                jsonobject.put("sessionStartTime", ssasession.getSessionStartTime());
                jsonobject.put("sessionEndTime", ssasession.getSessionEndTime());
                jsonobject.put("sessionType", ssasession.getSessionType());
                jsonobject.put("connectivity", ssasession.getConnectivity());
            }
            // Misplaced declaration of an exception variable
            catch (SSASession ssasession) { }
            obj = getSessions();
            ssasession = ((SSASession) (obj));
            if (obj == null)
            {
                ssasession = new JSONArray();
            }
            ssasession.put(jsonobject);
            obj = mSharedPreferences.edit();
            ((android.content.SharedPreferences.Editor) (obj)).putString("sessions", ssasession.toString());
            ((android.content.SharedPreferences.Editor) (obj)).commit();
        }
    }

    public void deleteSessions()
    {
        android.content.SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("sessions", null);
        editor.commit();
    }

    public String getApplicationKey(com.supersonicads.sdk.data.SSAEnums.ProductType producttype)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$supersonicads$sdk$data$SSAEnums$ProductType[];

            static 
            {
                $SwitchMap$com$supersonicads$sdk$data$SSAEnums$ProductType = new int[com.supersonicads.sdk.data.SSAEnums.ProductType.values().length];
                try
                {
                    $SwitchMap$com$supersonicads$sdk$data$SSAEnums$ProductType[com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$supersonicads$sdk$data$SSAEnums$ProductType[com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$supersonicads$sdk$data$SSAEnums$ProductType[com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.supersonicads.sdk.data.SSAEnums.ProductType[producttype.ordinal()])
        {
        default:
            return "EMPTY_APPLICATION_KEY";

        case 1: // '\001'
            return mSharedPreferences.getString("application_key_bc", null);

        case 2: // '\002'
            return mSharedPreferences.getString("application_key_ow", null);

        case 3: // '\003'
            return mSharedPreferences.getString("application_key_is", null);
        }
    }

    public com.supersonicads.sdk.data.SSAEnums.BackButtonState getBackButtonState()
    {
        int i = Integer.parseInt(mSharedPreferences.getString("back_button_state", "2"));
        if (i == 0)
        {
            return com.supersonicads.sdk.data.SSAEnums.BackButtonState.None;
        }
        if (i == 1)
        {
            return com.supersonicads.sdk.data.SSAEnums.BackButtonState.Device;
        }
        if (i == 2)
        {
            return com.supersonicads.sdk.data.SSAEnums.BackButtonState.Controller;
        } else
        {
            return com.supersonicads.sdk.data.SSAEnums.BackButtonState.Controller;
        }
    }

    public String getCampaignLastUpdate(String s)
    {
        return mSharedPreferences.getString(s, null);
    }

    public String getConnectionRetries()
    {
        return mSharedPreferences.getString("ssa_bc_parameter_connection_retries", "3");
    }

    public String getCurrentSDKVersion()
    {
        return mSharedPreferences.getString("version", "UN_VERSIONED");
    }

    public boolean getReportAppStarted()
    {
        return mSharedPreferences.getBoolean("is_reported", false);
    }

    public String getSDKDownloadUrl()
    {
        return mSharedPreferences.getString("ssa_sdk_download_url", null);
    }

    public String getSDKLoadUrl()
    {
        return mSharedPreferences.getString("ssa_sdk_load_url", "http://s.ssacdn.com/");
    }

    public List getSearchKeys()
    {
        Object obj = mSharedPreferences.getString("search_keys", null);
        ArrayList arraylist = new ArrayList();
        if (obj != null)
        {
            obj = new SSAObj(((String) (obj)));
            if (((SSAObj) (obj)).containsKey("searchKeys"))
            {
                JSONArray jsonarray = (JSONArray)((SSAObj) (obj)).get("searchKeys");
                try
                {
                    arraylist.addAll(((SSAObj) (obj)).toList(jsonarray));
                }
                catch (JSONException jsonexception)
                {
                    jsonexception.printStackTrace();
                    return arraylist;
                }
            }
        }
        return arraylist;
    }

    public JSONArray getSessions()
    {
        Object obj = mSharedPreferences.getString("sessions", null);
        if (obj == null)
        {
            return new JSONArray();
        }
        try
        {
            obj = new JSONArray(((String) (obj)));
        }
        catch (JSONException jsonexception)
        {
            jsonexception = new JSONArray();
        }
        return ((JSONArray) (obj));
    }

    public String getUniqueId(com.supersonicads.sdk.data.SSAEnums.ProductType producttype)
    {
        switch (_cls1..SwitchMap.com.supersonicads.sdk.data.SSAEnums.ProductType[producttype.ordinal()])
        {
        default:
            return "EMPTY_UNIQUE_ID";

        case 1: // '\001'
            return mSharedPreferences.getString("unique_id_bc", null);

        case 2: // '\002'
            return mSharedPreferences.getString("unique_id_ow", null);

        case 3: // '\003'
            return mSharedPreferences.getString("unique_id_is", null);
        }
    }

    public String getUniqueId(String s)
    {
        String s1 = "EMPTY_UNIQUE_ID";
        if (s.equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect.toString()))
        {
            s1 = mSharedPreferences.getString("unique_id_bc", null);
        } else
        {
            if (s.equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall.toString()))
            {
                return mSharedPreferences.getString("unique_id_ow", null);
            }
            if (s.equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial.toString()))
            {
                return mSharedPreferences.getString("unique_id_is", null);
            }
        }
        return s1;
    }

    public String getUserData(String s)
    {
        s = mSharedPreferences.getString(s, null);
        if (s != null)
        {
            return s;
        } else
        {
            return "{}";
        }
    }

    public void setApplicationKey(String s, com.supersonicads.sdk.data.SSAEnums.ProductType producttype)
    {
        android.content.SharedPreferences.Editor editor = mSharedPreferences.edit();
        _cls1..SwitchMap.com.supersonicads.sdk.data.SSAEnums.ProductType[producttype.ordinal()];
        JVM INSTR tableswitch 1 3: default 44
    //                   1 52
    //                   2 65
    //                   3 78;
           goto _L1 _L2 _L3 _L4
_L1:
        editor.commit();
        return;
_L2:
        editor.putString("application_key_bc", s);
        continue; /* Loop/switch isn't completed */
_L3:
        editor.putString("application_key_ow", s);
        continue; /* Loop/switch isn't completed */
_L4:
        editor.putString("application_key_is", s);
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void setBackButtonState(String s)
    {
        android.content.SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("back_button_state", s);
        editor.commit();
    }

    public void setCampaignLastUpdate(String s, String s1)
    {
        android.content.SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(s, s1);
        editor.commit();
    }

    public void setCurrentSDKVersion(String s)
    {
        android.content.SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("version", s);
        editor.commit();
    }

    public boolean setLatestCompeltionsTime(String s, String s1, String s2)
    {
        Object obj;
        obj = mSharedPreferences.getString("ssaUserData", null);
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            break MISSING_BLOCK_LABEL_108;
        }
        boolean flag;
        obj = new JSONObject(((String) (obj)));
        if (((JSONObject) (obj)).isNull(s1))
        {
            break MISSING_BLOCK_LABEL_108;
        }
        s1 = ((JSONObject) (obj)).getJSONObject(s1);
        if (s1.isNull(s2))
        {
            break MISSING_BLOCK_LABEL_108;
        }
        s1.getJSONObject(s2).put("timestamp", s);
        s = mSharedPreferences.edit();
        s.putString("ssaUserData", ((JSONObject) (obj)).toString());
        flag = s.commit();
        return flag;
        s;
        return false;
    }

    public void setReportAppStarted(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean("is_reported", flag);
        editor.apply();
    }

    public void setSSABCParameters(SSABCParameters ssabcparameters)
    {
        android.content.SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("ssa_bc_parameter_connection_retries", ssabcparameters.getConnectionRetries());
        editor.commit();
    }

    public void setSearchKeys(String s)
    {
        android.content.SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("search_keys", s);
        editor.commit();
    }

    public void setShouldRegisterSessions(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean("register_sessions", flag);
        editor.commit();
    }

    public boolean setUniqueId(String s, String s1)
    {
        android.content.SharedPreferences.Editor editor = mSharedPreferences.edit();
        if (!s1.equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.BrandConnect.toString())) goto _L2; else goto _L1
_L1:
        editor.putString("unique_id_bc", s);
_L4:
        return editor.commit();
_L2:
        if (s1.equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.OfferWall.toString()))
        {
            editor.putString("unique_id_ow", s);
        } else
        if (s1.equalsIgnoreCase(com.supersonicads.sdk.data.SSAEnums.ProductType.Interstitial.toString()))
        {
            editor.putString("unique_id_is", s);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean setUserData(String s, String s1)
    {
        android.content.SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(s, s1);
        return editor.commit();
    }

    public void setUserID(String s, com.supersonicads.sdk.data.SSAEnums.ProductType producttype)
    {
        android.content.SharedPreferences.Editor editor = mSharedPreferences.edit();
        _cls1..SwitchMap.com.supersonicads.sdk.data.SSAEnums.ProductType[producttype.ordinal()];
        JVM INSTR tableswitch 1 3: default 44
    //                   1 52
    //                   2 65
    //                   3 78;
           goto _L1 _L2 _L3 _L4
_L1:
        editor.commit();
        return;
_L2:
        editor.putString("user_id_bc", s);
        continue; /* Loop/switch isn't completed */
_L3:
        editor.putString("user_id_ow", s);
        continue; /* Loop/switch isn't completed */
_L4:
        editor.putString("user_id_is", s);
        if (true) goto _L1; else goto _L5
_L5:
    }
}
