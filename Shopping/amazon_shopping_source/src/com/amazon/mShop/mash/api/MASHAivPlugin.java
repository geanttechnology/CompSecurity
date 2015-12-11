// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import com.amazon.client.metrics.AndroidMetricsFactoryImpl;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.MetricsFactory;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.aiv.AIVAvailabilityUtils;
import com.amazon.mShop.aiv.AmazonInstantVideoProxy;
import com.amazon.mShop.aiv.LastAsinPlayHolder;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.Util;
import com.amazon.mobile.mash.api.MASHCordovaPlugin;
import com.amazon.mobile.mash.error.MASHError;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class MASHAivPlugin extends MASHCordovaPlugin
{
    private static abstract class AIVAction extends Enum
    {

        private static final AIVAction $VALUES[];
        private static final LastAsinPlayHolder ASIN_HOLDER = LastAsinPlayHolder.getInstance();
        public static final AIVAction IS_PLAYBACK_SUSTAINABLE;
        public static final AIVAction START_PLAYBACK;
        public static final AIVAction START_TRAILER;
        public static final AIVAction WHISPER_CACHE;
        private final String mApiName;

        public static AIVAction actionFromAPIName(String s)
        {
            AIVAction aaivaction[] = values();
            int j = aaivaction.length;
            for (int i = 0; i < j; i++)
            {
                AIVAction aivaction = aaivaction[i];
                if (aivaction.getApiName().equals(s))
                {
                    return aivaction;
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
                AndroidPlatform.getInstance().runOnUiThread(new CompanionAppMessageRunnable(activity));
                return true;
            }
        }

        public static AIVAction valueOf(String s)
        {
            return (AIVAction)Enum.valueOf(com/amazon/mShop/mash/api/MASHAivPlugin$AIVAction, s);
        }

        public static AIVAction[] values()
        {
            return (AIVAction[])$VALUES.clone();
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
            IS_PLAYBACK_SUSTAINABLE = new AIVAction("IS_PLAYBACK_SUSTAINABLE", 0, "aiv.IsPlaybackSustainable") {

                public boolean execute(JSONArray jsonarray, CallbackContext callbackcontext, CordovaPlugin cordovaplugin)
                {
                    cordovaplugin.cordova.getThreadPool().execute(new IsPlaybackSustainableTask(callbackcontext));
                    return true;
                }

            };
            START_PLAYBACK = new AIVAction("START_PLAYBACK", 1, "aiv.StartPlayback") {

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
                    if (AIVAction.redirectToInstallCompanionApp(activity, s))
                    {
                        return false;
                    } else
                    {
                        jsonarray = new StartPlaybackTask(s, i, cordovaplugin);
                        cordovaplugin.cordova.getThreadPool().execute(jsonarray);
                        return true;
                    }
                }

                public void onActivityResult(CallbackContext callbackcontext, int i, int j, Intent intent)
                {
                    callbackcontext.success();
                }

            };
            START_TRAILER = new AIVAction("START_TRAILER", 2, "aiv.StartTrailer") {

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
                    if (AIVAction.redirectToInstallCompanionApp(activity, jsonarray))
                    {
                        return false;
                    } else
                    {
                        cordovaplugin.cordova.getThreadPool().execute(new StartTrailerTask(callbackcontext, activity, jsonarray));
                        return true;
                    }
                }

            };
            WHISPER_CACHE = new AIVAction("WHISPER_CACHE", 3, "aiv.WhisperCache") {

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
                    cordovaplugin.cordova.getThreadPool().execute(new WhisperCacheTask(callbackcontext, arraylist));
                    return true;
                }

            };
            $VALUES = (new AIVAction[] {
                IS_PLAYBACK_SUSTAINABLE, START_PLAYBACK, START_TRAILER, WHISPER_CACHE
            });
        }


        private AIVAction(String s, int i, String s1)
        {
            super(s, i);
            mApiName = s1;
        }

    }

    private static class CompanionAppMessageRunnable
        implements Runnable
    {

        final Activity mActivity;
        private final MetricsFactory mMetricsFactory;

        public void run()
        {
            final com.amazon.client.metrics.ClickStreamMetricsEvent clickMetrics = mMetricsFactory.createClickStreamMetricEvent("ATVAndroid", "CompanionAppInstallationNotifier:ContinueClick");
            MetricEvent metricevent = mMetricsFactory.createMetricEvent("ATVAndroid", "CompanionAppInstallationNotifier:DialogDisplay");
            View view = mActivity.getLayoutInflater().inflate(com.amazon.mShop.android.lib.R.layout.aiv_companion_app_installation_dialog, null);
            Button button = (Button)view.findViewById(com.amazon.mShop.android.lib.R.id.continue_button);
            AmazonAlertDialog amazonalertdialog = (new com.amazon.mShop.AmazonAlertDialog.Builder(mActivity)).create();
            amazonalertdialog.setView(view, 0, 0, 0, 0);
            button.setOnClickListener(amazonalertdialog. new android.view.View.OnClickListener() {

                final CompanionAppMessageRunnable this$0;
                final MetricEvent val$clickMetrics;
                final AmazonAlertDialog val$dialog;

                public void onClick(View view)
                {
                    clickMetrics.addCounter("Counter", 1.0D);
                    mMetricsFactory.record(clickMetrics);
                    dialog.dismiss();
                    if (AmazonInstantVideoProxy.getInstance().isAIVBeta())
                    {
                        view = "B00N2886IU";
                    } else
                    {
                        view = "B00N28818A";
                    }
                    ActivityUtils.startAppstoreActivityWithAsin(mActivity, view, null, null, null);
                }

            
            {
                this$0 = final_companionappmessagerunnable;
                clickMetrics = metricevent;
                dialog = AmazonAlertDialog.this;
                super();
            }
            });
            metricevent.addCounter("Counter", 1.0D);
            mMetricsFactory.record(metricevent);
            amazonalertdialog.show();
        }


        public CompanionAppMessageRunnable(Activity activity)
        {
            mActivity = (Activity)Preconditions.checkNotNull(activity);
            mMetricsFactory = AndroidMetricsFactoryImpl.getInstance(mActivity);
        }
    }

    static class IsPlaybackSustainableTask
        implements Runnable
    {

        private final CallbackContext mCallbackContext;

        public void run()
        {
            boolean flag = AmazonInstantVideoProxy.getInstance().isPlaybackSustainable();
            mCallbackContext.success(String.valueOf(flag));
        }

        private IsPlaybackSustainableTask(CallbackContext callbackcontext)
        {
            mCallbackContext = callbackcontext;
        }

    }

    static class StartPlaybackTask
        implements Runnable
    {

        private final Activity mActivity;
        private final String mAsin;
        private final CordovaPlugin mCordovaPlugin;
        private final int mTimecode;

        public void run()
        {
            boolean flag = mActivity instanceof CordovaInterface;
            if (flag)
            {
                ((CordovaInterface)mActivity).setActivityResultCallback(mCordovaPlugin);
            } else
            {
                Log.e("aiv.StartPlayback", "The activity in StartPlayback is not a CordovaInterface. Cannot delay callback.");
            }
            AmazonInstantVideoProxy.getInstance().startPlayback(mActivity, mAsin, mTimecode);
            if (!flag)
            {
                mCordovaPlugin.onActivityResult(1, -1, null);
            }
        }

        private StartPlaybackTask(String s, int i, CordovaPlugin cordovaplugin)
        {
            mActivity = cordovaplugin.cordova.getActivity();
            mAsin = s;
            mTimecode = i;
            mCordovaPlugin = cordovaplugin;
        }

    }

    static class StartTrailerTask
        implements Runnable
    {

        private final Activity mActivity;
        private final String mAsin;
        private final CallbackContext mCallbackContext;

        public void run()
        {
            AmazonInstantVideoProxy.getInstance().startTrailer(mActivity, mAsin);
            mCallbackContext.success();
        }

        private StartTrailerTask(CallbackContext callbackcontext, Activity activity, String s)
        {
            mCallbackContext = callbackcontext;
            mActivity = activity;
            mAsin = s;
        }

    }

    static class WhisperCacheTask
        implements Runnable
    {

        private final List mAsins;
        private final CallbackContext mCallbackContext;

        public void run()
        {
            AmazonInstantVideoProxy.getInstance().whisperCache(mAsins);
            mCallbackContext.success();
        }

        private WhisperCacheTask(CallbackContext callbackcontext, List list)
        {
            mCallbackContext = callbackcontext;
            mAsins = list;
        }

    }


    private AIVAction mAivAction;
    private CallbackContext mCallbackContext;

    public MASHAivPlugin()
    {
    }

    public boolean execute(String s, JSONArray jsonarray, CallbackContext callbackcontext)
        throws JSONException
    {
        mAivAction = AIVAction.actionFromAPIName(s);
        if (mAivAction == null)
        {
            callbackcontext.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
            mCallbackContext = null;
            return false;
        } else
        {
            mCallbackContext = callbackcontext;
            return mAivAction.execute(jsonarray, callbackcontext, this);
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        mAivAction.onActivityResult(mCallbackContext, i, j, intent);
    }
}
