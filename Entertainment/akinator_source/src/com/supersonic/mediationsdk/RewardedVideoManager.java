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
import com.supersonic.mediationsdk.sdk.RewardedVideoAdapterApi;
import com.supersonic.mediationsdk.sdk.RewardedVideoApi;
import com.supersonic.mediationsdk.sdk.RewardedVideoListener;
import com.supersonic.mediationsdk.sdk.RewardedVideoManagerListener;
import com.supersonic.mediationsdk.sdk.SupersonicFactory;
import com.supersonic.mediationsdk.server.Server;
import com.supersonic.mediationsdk.utils.ErrorBuilder;
import com.supersonic.mediationsdk.utils.ServerResponseWrapper;
import com.supersonic.mediationsdk.utils.SupersonicUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.supersonic.mediationsdk:
//            SupersonicObject, AbstractAdapter, EventsHandler

class RewardedVideoManager
    implements RewardedVideoApi, RewardedVideoManagerListener
{

    private final String GENERAL_PROPERTIES_USER_ID = "userId";
    private final String TAG = getClass().getSimpleName();
    private Activity mActivity;
    private AtomicBoolean mAtomicShouldPerformInit;
    private PriorityBlockingQueue mAvailableAdapters;
    private ArrayList mInitiatedAdapters;
    private boolean mIsAdAvailable;
    private boolean mIsReportSuccess;
    private RewardedVideoListener mListenersWrapper;
    private SupersonicLoggerManager mLoggerManager;
    private ArrayList mNotAvailableAdapters;
    private ServerResponseWrapper mServerResponseWrapper;
    private String mUserId;

    public RewardedVideoManager()
    {
        mIsAdAvailable = false;
        mIsReportSuccess = false;
        mAvailableAdapters = new PriorityBlockingQueue();
        mInitiatedAdapters = new ArrayList();
        mNotAvailableAdapters = new ArrayList();
        mLoggerManager = SupersonicLoggerManager.getLogger();
        mAtomicShouldPerformInit = new AtomicBoolean(true);
    }

    private void addToAvailable(RewardedVideoAdapterApi rewardedvideoadapterapi)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mAvailableAdapters.contains(rewardedvideoadapterapi))
        {
            mAvailableAdapters.add(rewardedvideoadapterapi);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        rewardedvideoadapterapi;
        throw rewardedvideoadapterapi;
    }

    private void addToInitiated(RewardedVideoAdapterApi rewardedvideoadapterapi)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mInitiatedAdapters.contains(rewardedvideoadapterapi))
        {
            mInitiatedAdapters.add(rewardedvideoadapterapi);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        rewardedvideoadapterapi;
        throw rewardedvideoadapterapi;
    }

    private void addToUnavailable(RewardedVideoAdapterApi rewardedvideoadapterapi)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mNotAvailableAdapters.contains(rewardedvideoadapterapi))
        {
            mNotAvailableAdapters.add(rewardedvideoadapterapi);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        rewardedvideoadapterapi;
        throw rewardedvideoadapterapi;
    }

    private AbstractAdapter loadNextAdapter()
    {
        int i = mServerResponseWrapper.getAdaptersSmartLoadAmount();
        AbstractAdapter abstractadapter1 = null;
        AbstractAdapter abstractadapter = null;
        if (mAvailableAdapters.size() + mInitiatedAdapters.size() < i)
        {
            do
            {
                abstractadapter1 = abstractadapter;
                if (!mServerResponseWrapper.hasMoreProvidersToLoad())
                {
                    break;
                }
                abstractadapter1 = abstractadapter;
                if (abstractadapter != null)
                {
                    break;
                }
                abstractadapter1 = startAdapter(mServerResponseWrapper);
                abstractadapter = abstractadapter1;
                if (abstractadapter1 != null)
                {
                    ((SupersonicObject)SupersonicFactory.getInstance()).addToAdaptersList(abstractadapter1);
                    abstractadapter = abstractadapter1;
                }
            } while (true);
        }
        return abstractadapter1;
    }

    private void notifyIsAdAvailableForStatistics()
    {
        this;
        JVM INSTR monitorenter ;
        AbstractAdapter abstractadapter;
        for (Iterator iterator = mAvailableAdapters.iterator(); iterator.hasNext(); EventsHandler.getHandler().notifyIsRewardedVideoAvailable(abstractadapter.getProviderName(), true))
        {
            abstractadapter = (AbstractAdapter)(RewardedVideoAdapterApi)iterator.next();
        }

        break MISSING_BLOCK_LABEL_51;
        Exception exception;
        exception;
        throw exception;
        AbstractAdapter abstractadapter1;
        for (Iterator iterator1 = mNotAvailableAdapters.iterator(); iterator1.hasNext(); EventsHandler.getHandler().notifyIsRewardedVideoAvailable(abstractadapter1.getProviderName(), false))
        {
            abstractadapter1 = (AbstractAdapter)(RewardedVideoAdapterApi)iterator1.next();
        }

        AbstractAdapter abstractadapter2;
        for (Iterator iterator2 = mInitiatedAdapters.iterator(); iterator2.hasNext(); EventsHandler.getHandler().notifyIsRewardedVideoAvailable(abstractadapter2.getProviderName(), false))
        {
            abstractadapter2 = (AbstractAdapter)(RewardedVideoAdapterApi)iterator2.next();
        }

        this;
        JVM INSTR monitorexit ;
    }

    private boolean providerSettingExistsInconfig(String s)
    {
        return ConfigFile.getConfigFile(mActivity).getProviderJsonSettings(s).length() != 0;
    }

    private void removeFromAvailable(RewardedVideoAdapterApi rewardedvideoadapterapi)
    {
        this;
        JVM INSTR monitorenter ;
        if (mAvailableAdapters.contains(rewardedvideoadapterapi))
        {
            mAvailableAdapters.remove(rewardedvideoadapterapi);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        rewardedvideoadapterapi;
        throw rewardedvideoadapterapi;
    }

    private void removeFromInitiated(RewardedVideoAdapterApi rewardedvideoadapterapi)
    {
        this;
        JVM INSTR monitorenter ;
        if (mInitiatedAdapters.contains(rewardedvideoadapterapi))
        {
            mInitiatedAdapters.remove(rewardedvideoadapterapi);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        rewardedvideoadapterapi;
        throw rewardedvideoadapterapi;
    }

    private void removeFromUnavailable(RewardedVideoAdapterApi rewardedvideoadapterapi)
    {
        this;
        JVM INSTR monitorenter ;
        if (mNotAvailableAdapters.contains(rewardedvideoadapterapi))
        {
            mNotAvailableAdapters.remove(rewardedvideoadapterapi);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        rewardedvideoadapterapi;
        throw rewardedvideoadapterapi;
    }

    private void reportFalseImpressionsOnHigherPriority(int i)
    {
        JSONArray jsonarray = mServerResponseWrapper.getRVProvidersArray();
        for (int j = 0; j < i; j++)
        {
            Server.callAsyncRequestURL(jsonarray.optJSONObject(j).optString("requestUrl"), false);
        }

    }

    private void reportImpression(RewardedVideoAdapterApi rewardedvideoadapterapi, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        String s = "";
        String s1 = ((AbstractAdapter)rewardedvideoadapterapi).getUrl();
        s = s1;
        Server.callAsyncRequestURL(s1, flag);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Throwable throwable;
        throwable;
        mLoggerManager.logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NETWORK, (new StringBuilder()).append("reportImpression:(provider:").append(((AbstractAdapter)rewardedvideoadapterapi).getProviderName()).append(", ").append("providerURL:").append(s).append(", ").append("hit:").append(flag).append(")").toString(), throwable);
        if (true) goto _L2; else goto _L1
_L1:
        rewardedvideoadapterapi;
        throw rewardedvideoadapterapi;
    }

    private void reportInitFail(SupersonicError supersonicerror)
    {
        this;
        JVM INSTR monitorenter ;
        mAtomicShouldPerformInit.set(true);
        mListenersWrapper.onRewardedVideoInitFail(supersonicerror);
        this;
        JVM INSTR monitorexit ;
        return;
        supersonicerror;
        throw supersonicerror;
    }

    private AbstractAdapter startAdapter(ServerResponseWrapper serverresponsewrapper)
    {
        this;
        JVM INSTR monitorenter ;
        JSONObject jsonobject = serverresponsewrapper.getNextProvider();
        if (jsonobject != null) goto _L2; else goto _L1
_L1:
        serverresponsewrapper = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return serverresponsewrapper;
_L2:
        Object obj;
        String s;
        s = jsonobject.optString("provider");
        obj = jsonobject.optString("requestUrl");
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, (new StringBuilder()).append(TAG).append(":startAdapter(").append(s).append(")").toString(), 1);
        if (s.isEmpty())
        {
            serverresponsewrapper = null;
            continue; /* Loop/switch isn't completed */
        }
        if (providerSettingExistsInconfig(s))
        {
            break MISSING_BLOCK_LABEL_137;
        }
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, (new StringBuilder()).append(s).append(" Adapter loading is failed due to missing configuration.").toString(), 2);
        serverresponsewrapper = null;
        continue; /* Loop/switch isn't completed */
        Class class1 = Class.forName((new StringBuilder()).append("com.supersonic.adapters.").append(s.toLowerCase()).append(".").append(s).append("Adapter").toString());
        obj = (AbstractAdapter)class1.getMethod("getInstance", new Class[] {
            java/lang/String, java/lang/String
        }).invoke(class1, new Object[] {
            s, obj
        });
        ((AbstractAdapter) (obj)).setLogListener(mLoggerManager);
        ((AbstractAdapter) (obj)).setRewardedVideoTimeout(serverresponsewrapper.getAdaptersSmartLoadTimeout());
        ((AbstractAdapter) (obj)).setRewardedVideoPriority(serverresponsewrapper.getAdaptersLoadPosition());
        serverresponsewrapper = ((AbstractAdapter) (obj)).isVersionSupported(ConfigFile.getConfigFile(mActivity).getProviderCoreSdkVersion(s), serverresponsewrapper.getAdapterSupportedVersion(s));
        if (serverresponsewrapper != null)
        {
            break MISSING_BLOCK_LABEL_450;
        }
        ((RewardedVideoAdapterApi)obj).setRewardedVideoListener(this);
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, (new StringBuilder()).append(TAG).append(": startAdapter(").append(s).append(") moved to 'Initiated' list").toString(), 0);
        addInitiatedRewardedVideoAdapter((RewardedVideoAdapterApi)obj);
        ((RewardedVideoAdapterApi)obj).initRewardedVideo(mActivity, mUserId);
        serverresponsewrapper = ((ServerResponseWrapper) (obj));
        continue; /* Loop/switch isn't completed */
        serverresponsewrapper;
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, (new StringBuilder()).append(s).append(" initialization failed - please verify that required dependencies are in you build path.").toString(), 2);
        mLoggerManager.logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, (new StringBuilder()).append(TAG).append(":startAdapter(JSONObject:").append(jsonobject.toString()).append(")").toString(), serverresponsewrapper);
        serverresponsewrapper = null;
        continue; /* Loop/switch isn't completed */
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, serverresponsewrapper.toString(), 2);
        serverresponsewrapper = null;
        if (true) goto _L4; else goto _L3
_L3:
        serverresponsewrapper;
        throw serverresponsewrapper;
    }

    public void addAvailableRewardedVideoAdapter(RewardedVideoAdapterApi rewardedvideoadapterapi)
    {
        this;
        JVM INSTR monitorenter ;
        addToAvailable(rewardedvideoadapterapi);
        removeFromInitiated(rewardedvideoadapterapi);
        removeFromUnavailable(rewardedvideoadapterapi);
        this;
        JVM INSTR monitorexit ;
        return;
        rewardedvideoadapterapi;
        throw rewardedvideoadapterapi;
    }

    public void addInitiatedRewardedVideoAdapter(RewardedVideoAdapterApi rewardedvideoadapterapi)
    {
        this;
        JVM INSTR monitorenter ;
        addToInitiated(rewardedvideoadapterapi);
        removeFromUnavailable(rewardedvideoadapterapi);
        removeFromAvailable(rewardedvideoadapterapi);
        this;
        JVM INSTR monitorexit ;
        return;
        rewardedvideoadapterapi;
        throw rewardedvideoadapterapi;
    }

    public void addUnavailableRewardedVideoAdapter(RewardedVideoAdapterApi rewardedvideoadapterapi)
    {
        this;
        JVM INSTR monitorenter ;
        addToUnavailable(rewardedvideoadapterapi);
        removeFromAvailable(rewardedvideoadapterapi);
        removeFromInitiated(rewardedvideoadapterapi);
        this;
        JVM INSTR monitorexit ;
        return;
        rewardedvideoadapterapi;
        throw rewardedvideoadapterapi;
    }

    public void initRewardedVideo(final Activity activity, final String userId)
    {
        this;
        JVM INSTR monitorenter ;
        if (mAtomicShouldPerformInit == null || !mAtomicShouldPerformInit.compareAndSet(true, false)) goto _L2; else goto _L1
_L1:
        mIsAdAvailable = false;
        mIsReportSuccess = false;
        mActivity = activity;
        mUserId = userId;
        if (!TextUtils.isEmpty(userId))
        {
            GeneralProperties.getProperties().putKey("userId", userId);
        }
        SupersonicUtils.createAndStartWorker(new Runnable() {

            final RewardedVideoManager this$0;
            final Activity val$activity;
            final String val$userId;

            public void run()
            {
                SupersonicObject supersonicobject = (SupersonicObject)SupersonicFactory.getInstance();
                SupersonicUtils.setSupersonicUserId(activity, userId);
                ConfigValidationResult configvalidationresult = supersonicobject.runSupersonicConfigValidation(mActivity);
                if (!configvalidationresult.isValid())
                {
                    reportInitFail(configvalidationresult.getSupersonicError());
                } else
                {
                    if (!SupersonicUtils.isNetworkConnected(activity))
                    {
                        reportInitFail(ErrorBuilder.buildGenericError("No Internet Connection"));
                        return;
                    }
                    mServerResponseWrapper = supersonicobject.getServerResponse(mActivity, userId);
                    if (mServerResponseWrapper != null)
                    {
                        if (mServerResponseWrapper.isValidResponse())
                        {
                            int j = mServerResponseWrapper.getAdaptersSmartLoadAmount();
                            int i = 0;
                            while (i < j && loadNextAdapter() != null) 
                            {
                                i++;
                            }
                        } else
                        {
                            SupersonicError supersonicerror2 = mServerResponseWrapper.getReponseError();
                            SupersonicError supersonicerror = supersonicerror2;
                            if (supersonicerror2 == null)
                            {
                                supersonicerror = ErrorBuilder.buildNoConfigurationAvailableError();
                            }
                            reportInitFail(supersonicerror);
                            return;
                        }
                    } else
                    {
                        SupersonicError supersonicerror1 = ErrorBuilder.buildNoConfigurationAvailableError();
                        reportInitFail(supersonicerror1);
                        return;
                    }
                }
            }

            
            {
                this$0 = RewardedVideoManager.this;
                activity = activity1;
                userId = s;
                super();
            }
        }, "RewardedVideoInitiator");
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

    public boolean isRewardedVideoAvailable()
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = mAvailableAdapters.iterator();
_L2:
        boolean flag = flag1;
        RewardedVideoAdapterApi rewardedvideoadapterapi;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_48;
        }
        rewardedvideoadapterapi = (RewardedVideoAdapterApi)iterator.next();
        flag = rewardedvideoadapterapi.isRewardedVideoAvailable();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        flag = true;
        this;
        JVM INSTR monitorexit ;
        return flag;
        onVideoAvailabilityChanged(false, (AbstractAdapter)rewardedvideoadapterapi);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public void onPause(Activity activity)
    {
    }

    public void onResume(Activity activity)
    {
        if (activity != null)
        {
            mActivity = activity;
        }
    }

    public void onRewardedVideoAdClosed(AbstractAdapter abstractadapter)
    {
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_CALLBACK, (new StringBuilder()).append(abstractadapter.getProviderName()).append(":onRewardedVideoAdClosed()").toString(), 1);
        EventsHandler.getHandler().notifyVideoAdClosed(abstractadapter.getProviderName());
        notifyIsAdAvailableForStatistics();
        mListenersWrapper.onRewardedVideoAdClosed();
    }

    public void onRewardedVideoAdOpened(AbstractAdapter abstractadapter)
    {
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_CALLBACK, (new StringBuilder()).append(abstractadapter.getProviderName()).append(":onRewardedVideoAdOpened()").toString(), 1);
        EventsHandler.getHandler().notifyVideoAdOpened(abstractadapter.getProviderName());
        mListenersWrapper.onRewardedVideoAdOpened();
    }

    public void onRewardedVideoAdRewarded(int i, AbstractAdapter abstractadapter)
    {
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_CALLBACK, (new StringBuilder()).append(abstractadapter.getProviderName()).append(":onRewardedVideoAdRewarded(amount:").append(i).append(")").toString(), 1);
        EventsHandler.getHandler().notifyVideoAdRewarded(abstractadapter.getProviderName());
        mListenersWrapper.onRewardedVideoAdRewarded(i);
    }

    public void onRewardedVideoInitFail(SupersonicError supersonicerror, AbstractAdapter abstractadapter)
    {
        this;
        JVM INSTR monitorenter ;
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_CALLBACK, (new StringBuilder()).append(abstractadapter.getProviderName()).append(":onRewardedVideoInitFail(").append(supersonicerror).append(")").toString(), 1);
        EventsHandler.getHandler().notifyInitRewardedVideoResult(abstractadapter.getProviderName(), true);
        boolean flag1 = false;
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, (new StringBuilder()).append("Smart Loading - ").append(abstractadapter.getProviderName()).append(" moved to 'Not Available' list").toString(), 0);
        boolean flag = flag1;
        if (mNotAvailableAdapters.size() + mAvailableAdapters.size() + mNotAvailableAdapters.size() != 0)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        flag = flag1;
        if (!mServerResponseWrapper.hasMoreProvidersToLoad())
        {
            flag = true;
        }
        addUnavailableRewardedVideoAdapter((RewardedVideoAdapterApi)abstractadapter);
        loadNextAdapter();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        reportInitFail(supersonicerror);
        this;
        JVM INSTR monitorexit ;
        return;
        supersonicerror;
        throw supersonicerror;
    }

    public void onRewardedVideoInitSuccess(AbstractAdapter abstractadapter)
    {
        this;
        JVM INSTR monitorenter ;
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_CALLBACK, (new StringBuilder()).append(abstractadapter.getProviderName()).append(":onRewardedVideoInitSuccess()").toString(), 1);
        EventsHandler.getHandler().notifyInitRewardedVideoResult(abstractadapter.getProviderName(), true);
        if (!mIsReportSuccess)
        {
            mIsReportSuccess = true;
            mListenersWrapper.onRewardedVideoInitSuccess();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        abstractadapter;
        throw abstractadapter;
    }

    public void onVideoAvailabilityChanged(boolean flag, AbstractAdapter abstractadapter)
    {
        this;
        JVM INSTR monitorenter ;
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_CALLBACK, (new StringBuilder()).append(abstractadapter.getProviderName()).append(":onVideoAvailabilityChanged(available:").append(flag).append(")").toString(), 1);
        EventsHandler.getHandler().notifyVideoAvailabilityChanged(abstractadapter.getProviderName(), flag);
        if (!flag) goto _L2; else goto _L1
_L1:
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, (new StringBuilder()).append("Smart Loading - ").append(abstractadapter.getProviderName()).append(" moved to 'Available' list").toString(), 0);
        addAvailableRewardedVideoAdapter((RewardedVideoAdapterApi)abstractadapter);
_L6:
        boolean flag2 = false;
        if (mIsAdAvailable || !flag) goto _L4; else goto _L3
_L3:
        if (mAvailableAdapters.size() <= 0) goto _L4; else goto _L5
_L5:
        mIsAdAvailable = true;
        boolean flag1 = true;
_L9:
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        mListenersWrapper.onVideoAvailabilityChanged(mIsAdAvailable);
_L7:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, (new StringBuilder()).append("Smart Loading - ").append(abstractadapter.getProviderName()).append(" moved to 'Not Available' list").toString(), 0);
        addUnavailableRewardedVideoAdapter((RewardedVideoAdapterApi)abstractadapter);
        loadNextAdapter();
          goto _L6
        Throwable throwable;
        throwable;
        mLoggerManager.logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_CALLBACK, (new StringBuilder()).append("onVideoAvailabilityChanged(available:").append(flag).append(", ").append("provider:").append(abstractadapter.getProviderName()).append(")").toString(), throwable);
          goto _L7
        abstractadapter;
        throw abstractadapter;
_L4:
        flag1 = flag2;
        if (!mIsAdAvailable) goto _L9; else goto _L8
_L8:
        flag1 = flag2;
        if (flag) goto _L9; else goto _L10
_L10:
        flag1 = flag2;
        if (mAvailableAdapters.size() > 0) goto _L9; else goto _L11
_L11:
        mIsAdAvailable = false;
        flag1 = true;
          goto _L9
    }

    public void onVideoEnd(AbstractAdapter abstractadapter)
    {
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_CALLBACK, (new StringBuilder()).append(abstractadapter.getProviderName()).append(":onVideoEnd()").toString(), 1);
        EventsHandler.getHandler().notifyVideoEnd(abstractadapter.getProviderName());
        mListenersWrapper.onVideoEnd();
    }

    public void onVideoStart(AbstractAdapter abstractadapter)
    {
        mLoggerManager.log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_CALLBACK, (new StringBuilder()).append(abstractadapter.getProviderName()).append(":onVideoStart()").toString(), 1);
        EventsHandler.getHandler().notifyVideoStart(abstractadapter.getProviderName());
        mListenersWrapper.onVideoStart();
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

    public void setRewardedVideoListener(RewardedVideoListener rewardedvideolistener)
    {
        mListenersWrapper = rewardedvideolistener;
    }

    public void showRewardedVideo()
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist = new ArrayList();
        int i = 0;
        Iterator iterator = mAvailableAdapters.iterator();
_L8:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        RewardedVideoAdapterApi rewardedvideoadapterapi = (RewardedVideoAdapterApi)iterator.next();
        if (!rewardedvideoadapterapi.isRewardedVideoAvailable()) goto _L4; else goto _L3
_L3:
        reportImpression(rewardedvideoadapterapi, true);
        reportFalseImpressionsOnHigherPriority(((AbstractAdapter)rewardedvideoadapterapi).getRewardedVideoPriority());
        rewardedvideoadapterapi.showRewardedVideo();
          goto _L2
_L7:
        if (i >= arraylist.size()) goto _L6; else goto _L5
_L5:
        onVideoAvailabilityChanged(false, (AbstractAdapter)arraylist.get(i));
        i++;
          goto _L7
_L4:
        arraylist.add(rewardedvideoadapterapi);
        i = 1;
        Exception exception1 = new Exception("FailedToShowVideoException");
        mLoggerManager.logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.INTERNAL, (new StringBuilder()).append(((AbstractAdapter)rewardedvideoadapterapi).getProviderName()).append(" Failed to show video").toString(), exception1);
          goto _L8
        Exception exception;
        exception;
        throw exception;
_L6:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (i == 0) goto _L6; else goto _L9
_L9:
        i = 0;
          goto _L7
    }





/*
    static ServerResponseWrapper access$202(RewardedVideoManager rewardedvideomanager, ServerResponseWrapper serverresponsewrapper)
    {
        rewardedvideomanager.mServerResponseWrapper = serverresponsewrapper;
        return serverresponsewrapper;
    }

*/

}
