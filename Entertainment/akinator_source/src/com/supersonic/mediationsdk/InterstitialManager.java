// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk;

import android.app.Activity;
import android.text.TextUtils;
import com.supersonic.mediationsdk.config.ConfigFile;
import com.supersonic.mediationsdk.config.ConfigValidationResult;
import com.supersonic.mediationsdk.logger.SupersonicError;
import com.supersonic.mediationsdk.logger.SupersonicLoggerManager;
import com.supersonic.mediationsdk.sdk.GeneralProperties;
import com.supersonic.mediationsdk.sdk.InterstitialApi;
import com.supersonic.mediationsdk.sdk.InterstitialListener;
import com.supersonic.mediationsdk.sdk.SupersonicFactory;
import com.supersonic.mediationsdk.utils.ErrorBuilder;
import com.supersonic.mediationsdk.utils.ServerResponseWrapper;
import com.supersonic.mediationsdk.utils.SupersonicUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.supersonic.mediationsdk:
//            AbstractAdapter, SupersonicObject

class InterstitialManager
    implements InterstitialApi, InterstitialListener
{

    private final String GENERAL_PROPERTIES_USER_ID = "userId";
    private final String TAG = getClass().getName();
    private InterstitialApi mAdapter;
    private AtomicBoolean mAtomicShouldPerformInit;
    private InterstitialListener mListenersWrapper;
    private SupersonicLoggerManager mLoggerManager;

    public InterstitialManager()
    {
        mAtomicShouldPerformInit = new AtomicBoolean(true);
        mLoggerManager = SupersonicLoggerManager.getLogger();
    }

    private void reportInitFail(SupersonicError supersonicerror)
    {
        this;
        JVM INSTR monitorenter ;
        mAtomicShouldPerformInit.set(true);
        mListenersWrapper.onInterstitialInitFail(supersonicerror);
        this;
        JVM INSTR monitorexit ;
        return;
        supersonicerror;
        throw supersonicerror;
    }

    private ArrayList startAdapters(Activity activity, String s, ServerResponseWrapper serverresponsewrapper)
    {
        ArrayList arraylist;
        JSONArray jsonarray;
        int i;
        arraylist = new ArrayList();
        jsonarray = serverresponsewrapper.getISProvidersArray();
        i = 0;
_L2:
        String s1;
        Object obj;
        if (i >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_342;
        }
        s1 = jsonarray.optJSONObject(i).optString("provider");
        obj = jsonarray.optJSONObject(i).optString("requestUrl");
        if (!s1.isEmpty())
        {
            break; /* Loop/switch isn't completed */
        }
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        Object obj1;
        obj1 = Class.forName((new StringBuilder()).append("com.supersonic.adapters.").append(s1.toLowerCase()).append(".").append(s1).append("Adapter").toString());
        obj = (AbstractAdapter)((Class) (obj1)).getMethod("getInstance", new Class[] {
            java/lang/String, java/lang/String
        }).invoke(obj1, new Object[] {
            s1, obj
        });
        ((AbstractAdapter) (obj)).setLogListener(mLoggerManager);
        obj1 = ((AbstractAdapter) (obj)).isVersionSupported(ConfigFile.getConfigFile(activity).getProviderCoreSdkVersion(s1), serverresponsewrapper.getAdapterSupportedVersion(s1));
label0:
        {
            if (obj1 != null)
            {
                break label0;
            }
            try
            {
                ((InterstitialApi)obj).setInterstitialListener(this);
                addInterstitialAdapter((InterstitialApi)obj);
                ((InterstitialApi)obj).initInterstitial(activity, s);
                arraylist.add(obj);
            }
            catch (Throwable throwable)
            {
                mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, (new StringBuilder()).append(s1).append(" initialization failed - please verify that required dependencies are in you build path.").toString(), 2);
                mLoggerManager.logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, (new StringBuilder()).append(TAG).append(":startAdapter(providerList:").append(jsonarray.toString()).append(")").toString(), throwable);
            }
        }
          goto _L3
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, ((SupersonicError) (obj1)).toString(), 2);
          goto _L3
        return arraylist;
    }

    public void addInterstitialAdapter(InterstitialApi interstitialapi)
    {
        mAdapter = interstitialapi;
    }

    public boolean hasProviders()
    {
        return mAdapter != null;
    }

    public void initInterstitial(final Activity activity, final String userId)
    {
        this;
        JVM INSTR monitorenter ;
        if (mAtomicShouldPerformInit == null || !mAtomicShouldPerformInit.compareAndSet(true, false)) goto _L2; else goto _L1
_L1:
        if (!TextUtils.isEmpty(userId))
        {
            GeneralProperties.getProperties().putKey("userId", userId);
        }
        SupersonicUtils.createAndStartWorker(new Runnable() {

            final InterstitialManager this$0;
            final Activity val$activity;
            final String val$userId;

            public void run()
            {
                Object obj = (SupersonicObject)SupersonicFactory.getInstance();
                SupersonicUtils.setSupersonicUserId(activity, userId);
                Object obj1 = ((SupersonicObject) (obj)).runSupersonicConfigValidation(activity);
                if (!((ConfigValidationResult) (obj1)).isValid())
                {
                    reportInitFail(((ConfigValidationResult) (obj1)).getSupersonicError());
                    return;
                }
                if (!SupersonicUtils.isNetworkConnected(activity))
                {
                    reportInitFail(ErrorBuilder.buildGenericError("No Internet Connection"));
                    return;
                }
                obj1 = ((SupersonicObject) (obj)).getServerResponse(activity, userId);
                if (obj1 != null)
                {
                    if (((ServerResponseWrapper) (obj1)).isValidResponse())
                    {
                        obj1 = startAdapters(activity, userId, ((ServerResponseWrapper) (obj1)));
                        if (obj1 == null || ((ArrayList) (obj1)).isEmpty())
                        {
                            obj = ErrorBuilder.buildAdapterInitFailedError("Please check configurations for Interstitial adapters");
                            reportInitFail(((SupersonicError) (obj)));
                            return;
                        } else
                        {
                            ((SupersonicObject) (obj)).addAll(((ArrayList) (obj1)));
                            return;
                        }
                    }
                    obj1 = ((ServerResponseWrapper) (obj1)).getReponseError();
                    obj = obj1;
                    if (obj1 == null)
                    {
                        obj = ErrorBuilder.buildNoConfigurationAvailableError();
                    }
                    reportInitFail(((SupersonicError) (obj)));
                    return;
                } else
                {
                    SupersonicError supersonicerror = ErrorBuilder.buildNoConfigurationAvailableError();
                    reportInitFail(supersonicerror);
                    return;
                }
            }

            
            {
                this$0 = InterstitialManager.this;
                activity = activity1;
                userId = s;
                super();
            }
        }, "InterstitialInitiator");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, (new StringBuilder()).append(TAG).append(": Multiple calls to init are not allowed").toString(), 2);
        if (true) goto _L4; else goto _L3
_L3:
        activity;
        throw activity;
    }

    public boolean isInterstitialAdAvailable()
    {
        if (mAdapter != null)
        {
            return mAdapter.isInterstitialAdAvailable();
        } else
        {
            return false;
        }
    }

    public void onInterstitialAdClicked()
    {
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_CALLBACK, "onInterstitialAdClicked()", 1);
        mListenersWrapper.onInterstitialAdClicked();
    }

    public void onInterstitialAdClosed()
    {
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_CALLBACK, "onInterstitialAdClosed()", 1);
        mListenersWrapper.onInterstitialAdClosed();
    }

    public void onInterstitialAvailability(boolean flag)
    {
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_CALLBACK, (new StringBuilder()).append("onInterstitialAvailability(available:").append(flag).append(")").toString(), 1);
        mListenersWrapper.onInterstitialAvailability(flag);
    }

    public void onInterstitialInitFail(SupersonicError supersonicerror)
    {
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_CALLBACK, (new StringBuilder()).append("onInterstitialInitFail(").append(supersonicerror).append(")").toString(), 1);
        reportInitFail(supersonicerror);
    }

    public void onInterstitialInitSuccess()
    {
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_CALLBACK, "onInterstitialInitSuccess()", 1);
        mListenersWrapper.onInterstitialInitSuccess();
    }

    public void onInterstitialShowFail(SupersonicError supersonicerror)
    {
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_CALLBACK, (new StringBuilder()).append("onInterstitialShowFail(").append(supersonicerror).append(")").toString(), 1);
        mListenersWrapper.onInterstitialShowFail(supersonicerror);
    }

    public void onInterstitialShowSuccess()
    {
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_CALLBACK, "onInterstitialShowSuccess()", 1);
        mListenersWrapper.onInterstitialShowSuccess();
    }

    public void onPause(Activity activity)
    {
    }

    public void onResume(Activity activity)
    {
    }

    public void release(Activity activity)
    {
    }

    public void setAge(int i)
    {
    }

    public void setGender(String s)
    {
    }

    public void setInterstitialListener(InterstitialListener interstitiallistener)
    {
        mListenersWrapper = interstitiallistener;
    }

    public void showInterstitial()
    {
        if (mAdapter != null)
        {
            mAdapter.showInterstitial();
        }
    }


}
