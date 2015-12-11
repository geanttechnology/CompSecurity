// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.amazon.mShop.aiv.AIVAvailabilityUtils;
import com.amazon.mShop.aiv.LastAsinPlayHolder;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.util.Util;
import com.amazon.mobile.mash.error.MASHError;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.amazon.mShop.mash.api:
//            MASHAivPlugin

private static abstract class <init> extends Enum
{

    private static final WHISPER_CACHE $VALUES[];
    private static final LastAsinPlayHolder ASIN_HOLDER = LastAsinPlayHolder.getInstance();
    public static final e IS_PLAYBACK_SUSTAINABLE;
    public static final e START_PLAYBACK;
    public static final e START_TRAILER;
    public static final e WHISPER_CACHE;
    private final String mApiName;

    public static <init> actionFromAPIName(String s)
    {
        <init> a_3C_init>[] = values();
        int j = a_3C_init>.length;
        for (int i = 0; i < j; i++)
        {
            <init> <init>1 = a_3C_init>[i];
            if (<init>1.getApiName().equals(s))
            {
                return <init>1;
            }
        }

        return null;
    }

    private static boolean redirectToInstallCompanionApp(Activity activity, String s)
    {
        if (AIVAvailabilityUtils.isAIVCompanionAppInstalled(activity))
        {
            ASIN_HOLDER.reset();
            return false;
        } else
        {
            ASIN_HOLDER.setAsin(s);
            AndroidPlatform.getInstance().runOnUiThread(new ppMessageRunnable(activity));
            return true;
        }
    }

    public static ppMessageRunnable valueOf(String s)
    {
        return (ppMessageRunnable)Enum.valueOf(com/amazon/mShop/mash/api/MASHAivPlugin$AIVAction, s);
    }

    public static ppMessageRunnable[] values()
    {
        return (ppMessageRunnable[])$VALUES.clone();
    }

    public abstract boolean execute(JSONArray jsonarray, CallbackContext callbackcontext, CordovaPlugin cordovaplugin);

    protected String getApiName()
    {
        return mApiName;
    }

    public void onActivityResult(CallbackContext callbackcontext, int i, int j, Intent intent)
    {
    }

    static 
    {
        IS_PLAYBACK_SUSTAINABLE = new MASHAivPlugin.AIVAction("IS_PLAYBACK_SUSTAINABLE", 0, "aiv.IsPlaybackSustainable") {

            public boolean execute(JSONArray jsonarray, CallbackContext callbackcontext, CordovaPlugin cordovaplugin)
            {
                cordovaplugin.cordova.getThreadPool().execute(new MASHAivPlugin.IsPlaybackSustainableTask(callbackcontext, null));
                return true;
            }

        };
        START_PLAYBACK = new MASHAivPlugin.AIVAction("START_PLAYBACK", 1, "aiv.StartPlayback") {

            public boolean execute(JSONArray jsonarray, CallbackContext callbackcontext, CordovaPlugin cordovaplugin)
            {
                Activity activity = cordovaplugin.cordova.getActivity();
                String s;
                int i;
                try
                {
                    s = jsonarray.getString(0);
                    i = jsonarray.getInt(1);
                }
                // Misplaced declaration of an exception variable
                catch (JSONArray jsonarray)
                {
                    if (!Util.isEmpty(jsonarray.getMessage()))
                    {
                        Log.e(getApiName(), jsonarray.getMessage());
                    }
                    callbackcontext.error((new StringBuilder()).append(getApiName()).append(" JSONException: ").append(jsonarray.getMessage()).toString());
                    return false;
                }
                if (MASHAivPlugin.AIVAction.redirectToInstallCompanionApp(activity, s))
                {
                    return false;
                } else
                {
                    jsonarray = new MASHAivPlugin.StartPlaybackTask(s, i, cordovaplugin, null);
                    cordovaplugin.cordova.getThreadPool().execute(jsonarray);
                    return true;
                }
            }

            public void onActivityResult(CallbackContext callbackcontext, int i, int j, Intent intent)
            {
                callbackcontext.success();
            }

        };
        START_TRAILER = new MASHAivPlugin.AIVAction("START_TRAILER", 2, "aiv.StartTrailer") {

            public boolean execute(JSONArray jsonarray, CallbackContext callbackcontext, CordovaPlugin cordovaplugin)
            {
                Activity activity = cordovaplugin.cordova.getActivity();
                try
                {
                    jsonarray = jsonarray.getString(0);
                }
                // Misplaced declaration of an exception variable
                catch (JSONArray jsonarray)
                {
                    if (!Util.isEmpty(jsonarray.getMessage()))
                    {
                        Log.e(getApiName(), jsonarray.getMessage());
                    }
                    callbackcontext.error((new StringBuilder()).append(getApiName()).append(" JSONException: ").append(jsonarray.getMessage()).toString());
                    return false;
                }
                if (MASHAivPlugin.AIVAction.redirectToInstallCompanionApp(activity, jsonarray))
                {
                    return false;
                } else
                {
                    cordovaplugin.cordova.getThreadPool().execute(new MASHAivPlugin.StartTrailerTask(callbackcontext, activity, jsonarray, null));
                    return true;
                }
            }

        };
        WHISPER_CACHE = new MASHAivPlugin.AIVAction("WHISPER_CACHE", 3, "aiv.WhisperCache") {

            public boolean execute(JSONArray jsonarray, CallbackContext callbackcontext, CordovaPlugin cordovaplugin)
            {
                if (!AIVAvailabilityUtils.isAIVCompanionAppInstalled(cordovaplugin.cordova.getActivity()))
                {
                    return false;
                }
                ArrayList arraylist;
                int i;
                try
                {
                    jsonarray = jsonarray.getJSONArray(0);
                    arraylist = new ArrayList();
                }
                // Misplaced declaration of an exception variable
                catch (JSONArray jsonarray)
                {
                    if (!Util.isEmpty(jsonarray.getMessage()))
                    {
                        Log.e(getApiName(), jsonarray.getMessage());
                    }
                    callbackcontext.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
                    return false;
                }
                i = 0;
                if (i >= jsonarray.length())
                {
                    break; /* Loop/switch isn't completed */
                }
                arraylist.add(jsonarray.getString(i));
                i++;
                if (true) goto _L2; else goto _L1
_L2:
                break MISSING_BLOCK_LABEL_35;
_L1:
                cordovaplugin.cordova.getThreadPool().execute(new MASHAivPlugin.WhisperCacheTask(callbackcontext, arraylist, null));
                return true;
            }

        };
        $VALUES = (new .VALUES[] {
            IS_PLAYBACK_SUSTAINABLE, START_PLAYBACK, START_TRAILER, WHISPER_CACHE
        });
    }


    private _cls4(String s, int i, String s1)
    {
        super(s, i);
        mApiName = s1;
    }

    mApiName(String s, int i, String s1, mApiName mapiname)
    {
        this(s, i, s1);
    }
}
