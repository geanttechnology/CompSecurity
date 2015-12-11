// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk;

import android.app.Activity;
import android.content.Context;
import com.supersonic.mediationsdk.config.AbstractAdapterConfig;
import com.supersonic.mediationsdk.config.ConfigValidationResult;
import com.supersonic.mediationsdk.logger.LogListener;
import com.supersonic.mediationsdk.logger.PublisherLogger;
import com.supersonic.mediationsdk.logger.SupersonicError;
import com.supersonic.mediationsdk.logger.SupersonicLoggerManager;
import com.supersonic.mediationsdk.sdk.InterstitialListener;
import com.supersonic.mediationsdk.sdk.ListenersWrapper;
import com.supersonic.mediationsdk.sdk.OfferwallListener;
import com.supersonic.mediationsdk.sdk.RewardedVideoListener;
import com.supersonic.mediationsdk.sdk.Supersonic;
import com.supersonic.mediationsdk.server.HttpFunctions;
import com.supersonic.mediationsdk.server.Server;
import com.supersonic.mediationsdk.server.ServerURL;
import com.supersonic.mediationsdk.utils.ErrorBuilder;
import com.supersonic.mediationsdk.utils.GeneralPropertiesWorker;
import com.supersonic.mediationsdk.utils.ServerResponseWrapper;
import com.supersonic.mediationsdk.utils.SupersonicUtils;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.supersonic.mediationsdk:
//            EventsHandler, RewardedVideoManager, InterstitialManager, OfferwallManager, 
//            AbstractAdapter

public class SupersonicObject
    implements Supersonic
{

    private final String TAG = getClass().getName();
    private ServerResponseWrapper currentServerResponse;
    private ArrayList mAdaptersList;
    private AtomicBoolean mAtomicBaseInit;
    private InterstitialManager mInterstitialManager;
    private ListenersWrapper mListenersWrapper;
    private SupersonicLoggerManager mLoggerManager;
    private OfferwallManager mOfferwallManager;
    private PublisherLogger mPublisherLogger;
    private RewardedVideoManager mRewardedVideoManager;
    private Integer mUserAge;
    private String mUserGender;
    private final Object serverResponseLocker = new Object();

    public SupersonicObject()
    {
        currentServerResponse = null;
        mUserAge = null;
        mUserGender = null;
        initializeManagers();
        mAtomicBaseInit = new AtomicBoolean();
        mAdaptersList = new ArrayList();
    }

    private void baseInit(Activity activity, String s)
    {
        if (mAtomicBaseInit != null && mAtomicBaseInit.compareAndSet(false, true))
        {
            prepareForInit(activity, s);
        }
    }

    private ServerResponseWrapper getServerResponseWrapper(Context context, String s)
    {
        Object obj = null;
        String s1;
        boolean flag;
        try
        {
            context = SupersonicUtils.getSupersonicApplicationKey(context);
            s1 = HttpFunctions.getStringFromURL(ServerURL.getCPVProvidersURL(context, s));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context = obj;
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context = obj;
            continue; /* Loop/switch isn't completed */
        }
        if (s1 == null)
        {
            return null;
        }
        context = new ServerResponseWrapper(context, s, s1);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        flag = context.isValidResponse();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        return null;
_L2:
        return context;
        s;
        continue; /* Loop/switch isn't completed */
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void initializeEventsSettings(ServerResponseWrapper serverresponsewrapper)
    {
        boolean flag = serverresponsewrapper.isEventsEnabled();
        if (flag)
        {
            EventsHandler.getHandler().setEventsUrl(serverresponsewrapper.getEventsUrl());
            EventsHandler.getHandler().setMaxNumberOfEvents(serverresponsewrapper.getMaxNumberOfEvents());
            EventsHandler.getHandler().setBackupThreshold(serverresponsewrapper.getEventsBackupThreshold());
            return;
        } else
        {
            EventsHandler.getHandler().setIsEventsEnabled(flag);
            return;
        }
    }

    private void initializeLoggerManager(ServerResponseWrapper serverresponsewrapper)
    {
        mPublisherLogger.setDebugLevel(serverresponsewrapper.getPublisherLoggerLevel());
        mLoggerManager.setLoggerDebugLevel("console", serverresponsewrapper.getConsoleLoggerLevel());
        mLoggerManager.setLoggerDebugLevel("server", serverresponsewrapper.getServerLoggerLevel());
    }

    private void initializeManagers()
    {
        mLoggerManager = SupersonicLoggerManager.getLogger(0);
        mPublisherLogger = new PublisherLogger(null, 1);
        mLoggerManager.addLogger(mPublisherLogger);
        mListenersWrapper = new ListenersWrapper();
        mRewardedVideoManager = new RewardedVideoManager();
        mRewardedVideoManager.setRewardedVideoListener(mListenersWrapper);
        mInterstitialManager = new InterstitialManager();
        mInterstitialManager.setInterstitialListener(mListenersWrapper);
        mOfferwallManager = new OfferwallManager();
        mOfferwallManager.setOfferwallListener(mListenersWrapper);
    }

    private void initializeSettingsFromServerResponse(ServerResponseWrapper serverresponsewrapper)
    {
        initializeLoggerManager(serverresponsewrapper);
        initializeEventsSettings(serverresponsewrapper);
    }

    private void prepareForInit(Activity activity, String s)
    {
        SupersonicUtils.createAndStartWorker(new GeneralPropertiesWorker(activity), "GeneralPropertiesThread");
        Server.notifyUniqueUser(SupersonicUtils.getSupersonicApplicationKey(activity), s);
    }

    private void validateAge(int i, ConfigValidationResult configvalidationresult)
    {
        if (i >= 5 && i <= 120)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("age", "SupersonicAds", "age value should be between 5-120"));
        return;
        NumberFormatException numberformatexception;
        numberformatexception;
        configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("age", "SupersonicAds", "age value should be between 5-120"));
        return;
    }

    private void validateGender(String s, ConfigValidationResult configvalidationresult)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        s = s.toLowerCase().trim();
        if (!"male".equals(s) && !"female".equals(s) && !"unknown".equals(s))
        {
            configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("gender", "SupersonicAds", "gender value should be one of male/female/unknown."));
        }
        return;
        s;
        configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("gender", "SupersonicAds", "gender value should be one of male/female/unknown."));
        return;
    }

    public void addAll(ArrayList arraylist)
    {
        if (arraylist != null)
        {
            int i = 0;
            while (i < arraylist.size()) 
            {
                addToAdaptersList((AbstractAdapter)arraylist.get(i));
                i++;
            }
        }
    }

    public void addToAdaptersList(AbstractAdapter abstractadapter)
    {
        if (mAdaptersList != null && abstractadapter != null && !mAdaptersList.contains(abstractadapter))
        {
            mAdaptersList.add(abstractadapter);
        }
    }

    public Integer getAge()
    {
        this;
        JVM INSTR monitorenter ;
        Integer integer = mUserAge;
        this;
        JVM INSTR monitorexit ;
        return integer;
        Exception exception;
        exception;
        throw exception;
    }

    public String getGender()
    {
        this;
        JVM INSTR monitorenter ;
        String s = mUserGender;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public void getOfferwallCredits()
    {
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "getOfferwallCredits()", 1);
        try
        {
            mOfferwallManager.getOfferwallCredits();
            return;
        }
        catch (Throwable throwable)
        {
            mLoggerManager.logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "getOfferwallCredits()", throwable);
        }
    }

    public ServerResponseWrapper getServerResponse(Context context, String s)
    {
label0:
        {
            synchronized (serverResponseLocker)
            {
                if (currentServerResponse == null)
                {
                    break label0;
                }
                context = new ServerResponseWrapper(currentServerResponse);
            }
            return context;
        }
        Object obj = getServerResponseWrapper(context, s);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_282;
        }
        obj = SupersonicUtils.getLastResponse(context);
        obj = new JSONObject(((String) (obj)));
_L1:
        String s1;
        String s2;
        s1 = ((JSONObject) (obj)).optString("appKey");
        s2 = ((JSONObject) (obj)).optString("userId");
        obj = ((JSONObject) (obj)).optString("settings");
        if (SupersonicUtils.isEmpty(s1) || SupersonicUtils.isEmpty(s2) || SupersonicUtils.isEmpty(((String) (obj))))
        {
            break MISSING_BLOCK_LABEL_249;
        }
        context = SupersonicUtils.getSupersonicApplicationKey(context);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_244;
        }
        if (!s1.equals(context) || !s2.equals(s))
        {
            break MISSING_BLOCK_LABEL_244;
        }
        context = new ServerResponseWrapper(s1, s2, ((String) (obj)));
        initializeSettingsFromServerResponse(context);
        s = ErrorBuilder.buildUsingCachedConfigurationError(s1, s2);
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.INTERNAL, s.toString(), 1);
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.INTERNAL, (new StringBuilder()).append(s.toString()).append(": ").append(context.toString()).toString(), 0);
        currentServerResponse = context;
        return context;
        context;
        obj1;
        JVM INSTR monitorexit ;
        throw context;
        obj;
        obj = new JSONObject();
          goto _L1
        obj1;
        JVM INSTR monitorexit ;
        return null;
        context = ErrorBuilder.buildNoConfigurationAvailableError();
        mLoggerManager.logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NETWORK, "SDKInitWorker", new Exception(context.toString()));
        obj1;
        JVM INSTR monitorexit ;
        return null;
        if (!((ServerResponseWrapper) (obj)).isValidResponse())
        {
            break MISSING_BLOCK_LABEL_312;
        }
        SupersonicUtils.saveLastResponse(context, ((ServerResponseWrapper) (obj)).toString());
        initializeSettingsFromServerResponse(((ServerResponseWrapper) (obj)));
        currentServerResponse = ((ServerResponseWrapper) (obj));
        return ((ServerResponseWrapper) (obj));
        obj1;
        JVM INSTR monitorexit ;
        return null;
    }

    public void initInterstitial(Activity activity, String s)
    {
        String s1 = (new StringBuilder()).append("initRewardedVideo(userId:").append(s).append(")").toString();
        try
        {
            baseInit(activity, s);
            mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, s1, 1);
            mInterstitialManager.initInterstitial(activity, s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            mLoggerManager.logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, s1, activity);
        }
    }

    public void initOfferwall(Activity activity, String s)
    {
        String s1 = (new StringBuilder()).append("initOfferwall(userId:").append(s).append(")").toString();
        try
        {
            baseInit(activity, s);
            mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, s1, 1);
            mOfferwallManager.initOfferwall(activity, s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            mLoggerManager.logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, s1, activity);
        }
    }

    public void initRewardedVideo(Activity activity, String s)
    {
        String s1 = (new StringBuilder()).append("initRewardedVideo(userId:").append(s).append(")").toString();
        try
        {
            baseInit(activity, s);
            mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, s1, 1);
            EventsHandler.getHandler().notifyInitRewardedVideo("Mediation");
            mRewardedVideoManager.initRewardedVideo(activity, s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            mLoggerManager.logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, s1, activity);
        }
    }

    public boolean isInterstitialAdAvailable()
    {
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "isInterstitialAdAvailable()", 1);
        boolean flag;
        try
        {
            flag = mInterstitialManager.isInterstitialAdAvailable();
        }
        catch (Throwable throwable)
        {
            mLoggerManager.logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "isInterstitialAdAvailable()", throwable);
            return false;
        }
        return flag;
    }

    public boolean isOfferwallAvailable()
    {
        boolean flag = false;
        try
        {
            if (mOfferwallManager != null)
            {
                flag = mOfferwallManager.isOfferwallAvailable();
            }
        }
        catch (Exception exception)
        {
            return false;
        }
        return flag;
    }

    public boolean isRewardedVideoAvailable()
    {
        boolean flag1 = false;
        boolean flag = mRewardedVideoManager.isRewardedVideoAvailable();
        flag1 = flag;
        try
        {
            mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, (new StringBuilder()).append("isRewardedVideoAvailable():").append(flag).toString(), 1);
        }
        catch (Throwable throwable)
        {
            mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, (new StringBuilder()).append("isRewardedVideoAvailable():").append(flag1).toString(), 1);
            mLoggerManager.logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "isRewardedVideoAvailable()", throwable);
            flag = false;
        }
        EventsHandler.getHandler().notifyIsRewardedVideoAvailable("Mediation", flag);
        return flag;
    }

    public void onPause(Activity activity)
    {
        try
        {
            mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "onPause()", 1);
            EventsHandler.getHandler().notifyPause(activity, "Mediation");
            for (Iterator iterator = mAdaptersList.iterator(); iterator.hasNext(); ((AbstractAdapter)iterator.next()).onPause(activity)) { }
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            mLoggerManager.logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "onPause()", activity);
        }
    }

    public void onResume(Activity activity)
    {
        try
        {
            mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "onResume()", 1);
            EventsHandler.getHandler().notifyResume(activity, "Mediation");
            if (mRewardedVideoManager != null)
            {
                mRewardedVideoManager.onResume(activity);
            }
            for (Iterator iterator = mAdaptersList.iterator(); iterator.hasNext(); ((AbstractAdapter)iterator.next()).onResume(activity)) { }
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            mLoggerManager.logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "onResume()", activity);
        }
    }

    public void release(Activity activity)
    {
    }

    public void removeInterstitialListener()
    {
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "removeInterstitialListener()", 1);
        mListenersWrapper.setInterstitialListener(null);
    }

    public void removeOfferwallListener()
    {
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "removeOfferwallListener()", 1);
        mListenersWrapper.setOfferwallListener(null);
    }

    public void removeRewardedVideoListener()
    {
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "removeRewardedVideoListener()", 1);
        mListenersWrapper.setRewardedVideoListener(null);
    }

    public ConfigValidationResult runSupersonicConfigValidation(Context context)
    {
        ConfigValidationResult configvalidationresult = new ConfigValidationResult();
        try
        {
            Object obj = Class.forName("com.supersonic.adapters.supersonicads.SupersonicConfig");
            context = (AbstractAdapterConfig)((Class) (obj)).getMethod("getConfigObj", new Class[] {
                android/content/Context
            }).invoke(obj, new Object[] {
                context
            });
            obj = context.getClass().getSuperclass().getDeclaredMethod("isConfigValid", new Class[0]);
            ((Method) (obj)).setAccessible(true);
            context = (ConfigValidationResult)((Method) (obj)).invoke(context, new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            configvalidationresult.setInvalid(ErrorBuilder.buildAdapterInitFailedError("Failed to run isConfigValid() on SupersonicConfig"));
            return configvalidationresult;
        }
        return context;
    }

    public void setAge(int i)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = (new StringBuilder()).append(TAG).append(":setAge(age:").append(i).append(")").toString();
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, ((String) (obj)), 1);
        obj = new ConfigValidationResult();
        validateAge(i, ((ConfigValidationResult) (obj)));
        if (!((ConfigValidationResult) (obj)).isValid()) goto _L2; else goto _L1
_L1:
        mUserAge = Integer.valueOf(i);
        for (obj = mAdaptersList.iterator(); ((Iterator) (obj)).hasNext(); ((AbstractAdapter)((Iterator) (obj)).next()).setAge(i)) { }
          goto _L3
        obj;
        mLoggerManager.logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, (new StringBuilder()).append(TAG).append(":setAge(age:").append(i).append(")").toString(), ((Throwable) (obj)));
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, ((ConfigValidationResult) (obj)).getSupersonicError().toString(), 2);
        if (true) goto _L3; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    public void setGender(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = (new StringBuilder()).append(TAG).append(":setGender(gender:").append(s).append(")").toString();
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, ((String) (obj)), 1);
        obj = new ConfigValidationResult();
        validateGender(s, ((ConfigValidationResult) (obj)));
        if (!((ConfigValidationResult) (obj)).isValid()) goto _L2; else goto _L1
_L1:
        mUserGender = s;
        for (obj = mAdaptersList.iterator(); ((Iterator) (obj)).hasNext(); ((AbstractAdapter)((Iterator) (obj)).next()).setGender(s)) { }
          goto _L3
        obj;
        mLoggerManager.logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, (new StringBuilder()).append(TAG).append(":setGender(gender:").append(s).append(")").toString(), ((Throwable) (obj)));
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, ((ConfigValidationResult) (obj)).getSupersonicError().toString(), 2);
        if (true) goto _L3; else goto _L4
_L4:
        s;
        throw s;
    }

    public void setInterstitialListener(InterstitialListener interstitiallistener)
    {
        if (interstitiallistener == null)
        {
            mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "setInterstitialListener(ISListener:null)", 1);
        } else
        {
            mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "setInterstitialListener(ISListener)", 1);
        }
        mListenersWrapper.setInterstitialListener(interstitiallistener);
    }

    public void setLogListener(LogListener loglistener)
    {
        if (loglistener == null)
        {
            mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "setLogListener(LogListener:null)", 1);
            return;
        } else
        {
            mPublisherLogger.setLogListener(loglistener);
            mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, (new StringBuilder()).append("setLogListener(LogListener:").append(loglistener.getClass().getSimpleName()).append(")").toString(), 1);
            return;
        }
    }

    public void setOfferwallListener(OfferwallListener offerwalllistener)
    {
        if (offerwalllistener == null)
        {
            mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "setOfferwallListener(OWListener:null)", 1);
        } else
        {
            mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "setOfferwallListener(OWListener)", 1);
        }
        mListenersWrapper.setOfferwallListener(offerwalllistener);
    }

    public void setRewardedVideoListener(RewardedVideoListener rewardedvideolistener)
    {
        if (rewardedvideolistener == null)
        {
            mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "setRewardedVideoListener(RVListener:null)", 1);
        } else
        {
            mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "setRewardedVideoListener(RVListener)", 1);
        }
        mListenersWrapper.setRewardedVideoListener(rewardedvideolistener);
    }

    public void showInterstitial()
    {
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "showInterstitial()", 1);
        try
        {
            mInterstitialManager.showInterstitial();
            return;
        }
        catch (Throwable throwable)
        {
            mLoggerManager.logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "showInterstitial()", throwable);
        }
    }

    public void showOfferwall()
    {
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "showOfferwall()", 1);
        try
        {
            mOfferwallManager.showOfferwall();
            return;
        }
        catch (Throwable throwable)
        {
            mLoggerManager.logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "showOfferwall()", throwable);
        }
    }

    public void showRewardedVideo()
    {
        try
        {
            mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "showRewardedVideo()", 1);
            EventsHandler.getHandler().notifyShowRewardedVideo("Mediation");
            mRewardedVideoManager.showRewardedVideo();
            return;
        }
        catch (Exception exception)
        {
            mLoggerManager.logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "showRewardedVideo()", exception);
        }
    }
}
