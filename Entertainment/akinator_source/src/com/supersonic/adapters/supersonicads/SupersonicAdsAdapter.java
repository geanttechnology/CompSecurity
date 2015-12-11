// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.adapters.supersonicads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.supersonic.mediationsdk.AbstractAdapter;
import com.supersonic.mediationsdk.EventsHandler;
import com.supersonic.mediationsdk.logger.SupersonicLoggerManager;
import com.supersonic.mediationsdk.sdk.InterstitialApi;
import com.supersonic.mediationsdk.sdk.InterstitialListener;
import com.supersonic.mediationsdk.sdk.OfferwallApi;
import com.supersonic.mediationsdk.sdk.OfferwallListener;
import com.supersonic.mediationsdk.sdk.RewardedVideoAdapterApi;
import com.supersonic.mediationsdk.sdk.RewardedVideoManagerListener;
import com.supersonic.mediationsdk.utils.ErrorBuilder;
import com.supersonic.mediationsdk.utils.SupersonicUtils;
import com.supersonicads.sdk.SSAFactory;
import com.supersonicads.sdk.SSAPublisher;
import com.supersonicads.sdk.data.AdUnitsReady;
import com.supersonicads.sdk.listeners.OnInterstitialListener;
import com.supersonicads.sdk.listeners.OnOfferWallListener;
import com.supersonicads.sdk.listeners.OnRewardedVideoListener;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.supersonic.adapters.supersonicads:
//            SupersonicConfig

class SupersonicAdsAdapter extends AbstractAdapter
    implements RewardedVideoAdapterApi, InterstitialApi, OfferwallApi, OnOfferWallListener
{

    private static SupersonicAdsAdapter mInstance;
    private final String ITEM_SIGNATURE = "itemSignature";
    private String TAG;
    private final String TIMESTAMP = "timestamp";
    private final String VERSION = "1.0";
    private Activity mActivtiy;
    private int mCurrentVideosPresented;
    private InterstitialListener mInterstitialListener;
    private boolean mIsAdAvailable;
    private int mMaxVideosPerSession;
    private OfferwallListener mOfferwallListener;
    private String mOfferwallUserId;
    private RewardedVideoManagerListener mRewardedVideoManager;
    private SSAPublisher mSSAPublisher;

    private SupersonicAdsAdapter(String s, String s1)
    {
        super(s, s1);
        TAG = com/supersonic/adapters/supersonicads/SupersonicAdsAdapter.getSimpleName();
        setAdAvailable(false);
        setInterstitialSupport(true);
        setOfferwallSupport(true);
    }

    private void addItemNameCountSignature(HashMap hashmap, Context context)
    {
        Object obj;
        int j;
        obj = SupersonicConfig.getConfigObj(context);
        context = ((SupersonicConfig) (obj)).getItemName();
        j = ((SupersonicConfig) (obj)).getItemCount();
        obj = ((SupersonicConfig) (obj)).getPrivateKey();
        int i = 1;
        if (!SupersonicUtils.isEmpty(context)) goto _L2; else goto _L1
_L1:
        i = 0;
_L9:
        if (SupersonicUtils.isEmpty(((String) (obj))))
        {
            i = 0;
        }
          goto _L3
_L2:
        hashmap.put("itemName", context);
        continue; /* Loop/switch isn't completed */
_L7:
        if (i != 0)
        {
            try
            {
                i = SupersonicUtils.getCurrentTimestamp();
                hashmap.put("timestamp", String.valueOf(i));
                hashmap.put("itemSignature", createItemSig(i, context, j, ((String) (obj))));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (HashMap hashmap)
            {
                SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_API, (new StringBuilder()).append(TAG).append(":addItemNameCountSignature").toString(), hashmap);
            }
        }
        return;
_L5:
        hashmap.put("itemCount", String.valueOf(j));
        continue; /* Loop/switch isn't completed */
_L3:
        if (j != -1) goto _L5; else goto _L4
_L4:
        i = 0;
        if (true) goto _L7; else goto _L6
_L6:
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private String createItemSig(int i, String s, int j, String s1)
    {
        return SupersonicUtils.getMD5((new StringBuilder()).append(i).append(s).append(j).append(s1).toString());
    }

    private String createMinimumOfferCommissionSig(double d, String s)
    {
        return SupersonicUtils.getMD5((new StringBuilder()).append(d).append(s).toString());
    }

    private String createUserCreationDateSig(String s, String s1, String s2)
    {
        return SupersonicUtils.getMD5((new StringBuilder()).append(s).append(s1).append(s2).toString());
    }

    private HashMap getGenenralExtraParams(Context context)
    {
        HashMap hashmap = new HashMap();
        context = SupersonicConfig.getConfigObj(context);
        String s = context.getUserAgeGroup();
        if (!TextUtils.isEmpty(s))
        {
            hashmap.put("applicationUserAgeGroup", s);
        }
        context = context.getUserGender();
        if (!TextUtils.isEmpty(context))
        {
            hashmap.put("applicationUserGender", context);
        }
        return hashmap;
    }

    public static SupersonicAdsAdapter getInstance(String s, String s1)
    {
        if (mInstance == null)
        {
            mInstance = new SupersonicAdsAdapter(s, s1);
        }
        return mInstance;
    }

    private HashMap getInterstitialExtraParams(Context context)
    {
        return getGenenralExtraParams(context);
    }

    private HashMap getOfferwallExtraParams(Context context)
    {
        HashMap hashmap = getGenenralExtraParams(context);
        Object obj = SupersonicConfig.getConfigObj(context);
        String s = ((SupersonicConfig) (obj)).getLanguage();
        if (!SupersonicUtils.isEmpty(s))
        {
            hashmap.put("language", s);
        }
        s = ((SupersonicConfig) (obj)).getClientSideCallbacks();
        if (!SupersonicUtils.isEmpty(s))
        {
            hashmap.put("useClientSideCallbacks", s);
        }
        obj = ((SupersonicConfig) (obj)).getOfferwallCustomParams();
        if (obj != null && !((Map) (obj)).isEmpty())
        {
            hashmap.putAll(((Map) (obj)));
        }
        addItemNameCountSignature(hashmap, context);
        return hashmap;
    }

    private HashMap getRewardedVideoExtraParams(Context context)
    {
        HashMap hashmap = getGenenralExtraParams(context);
        SupersonicConfig supersonicconfig = SupersonicConfig.getConfigObj(context);
        String s = supersonicconfig.getLanguage();
        if (!SupersonicUtils.isEmpty(s))
        {
            hashmap.put("language", s);
        }
        s = supersonicconfig.getMaxVideoLength();
        if (!SupersonicUtils.isEmpty(s))
        {
            hashmap.put("maxVideoLength", s);
        }
        s = supersonicconfig.getCampaignId();
        if (!SupersonicUtils.isEmpty(s))
        {
            hashmap.put(SupersonicConfig.CAMPAIGN_ID, s);
        }
        addItemNameCountSignature(hashmap, context);
        context = supersonicconfig.getRewardedVideoCustomParams();
        if (context != null && !context.isEmpty())
        {
            hashmap.putAll(context);
        }
        return hashmap;
    }

    public void getOfferwallCredits()
    {
        if (mSSAPublisher != null)
        {
            String s = SupersonicConfig.getConfigObj(mActivtiy).getApplicationKey();
            String s1 = SupersonicConfig.getConfigObj(mActivtiy).getUserId();
            log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_API, (new StringBuilder()).append(getProviderName()).append(":getOfferwallCredits(appKey:").append(s).append("userId:").append(s1).append(")").toString(), 1);
            mSSAPublisher.getOfferWallCredits(s, s1, this);
            return;
        } else
        {
            log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, "Please call init before calling getOfferwallCredits", 2);
            return;
        }
    }

    public String getVersion()
    {
        return "1.0";
    }

    public void initInterstitial(final Activity appKey, final String userId)
    {
        mActivtiy = appKey;
        final HashMap supersonicConfig = getInterstitialExtraParams(appKey);
        appKey = SupersonicConfig.getConfigObj(appKey).getApplicationKey();
        log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_API, (new StringBuilder()).append(getProviderName()).append(":initInterstitial(appKey:").append(appKey).append(", userId:").append(userId).append(", extraParams:").append(supersonicConfig).append(")").toString(), 1);
        mActivtiy.runOnUiThread(new Runnable() {

            final SupersonicAdsAdapter this$0;
            final String val$appKey;
            final HashMap val$supersonicConfig;
            final String val$userId;

            public void run()
            {
                mSSAPublisher = SSAFactory.getPublisherInstance(mActivtiy);
                mSSAPublisher.initInterstitial(appKey, userId, supersonicConfig, new OnInterstitialListener() {

                    final _cls3 this$1;

                    public void onInterstitialAdClicked()
                    {
                        if (mInterstitialListener != null)
                        {
                            mInterstitialListener.onInterstitialAdClicked();
                        }
                    }

                    public void onInterstitialAdClosed()
                    {
                        if (mInterstitialListener != null)
                        {
                            mInterstitialListener.onInterstitialAdClosed();
                        }
                    }

                    public void onInterstitialAvailability(boolean flag)
                    {
                        if (mInterstitialListener != null)
                        {
                            mInterstitialListener.onInterstitialAvailability(flag);
                        }
                    }

                    public void onInterstitialInitFail(String s)
                    {
                        if (mInterstitialListener != null)
                        {
                            s = ErrorBuilder.buildAdapterInitFailedError(s);
                            mInterstitialListener.onInterstitialInitFail(s);
                        }
                    }

                    public void onInterstitialInitSuccess()
                    {
                        if (mInterstitialListener != null)
                        {
                            mInterstitialListener.onInterstitialInitSuccess();
                        }
                    }

                    public void onInterstitialShowFail(String s)
                    {
                        if (mInterstitialListener != null)
                        {
                            s = ErrorBuilder.buildAdapterInitFailedError(s);
                            mInterstitialListener.onInterstitialShowFail(s);
                        }
                    }

                    public void onInterstitialShowSuccess()
                    {
                        if (mInterstitialListener != null)
                        {
                            mInterstitialListener.onInterstitialShowSuccess();
                        }
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                });
            }

            
            {
                this$0 = SupersonicAdsAdapter.this;
                appKey = s;
                userId = s1;
                supersonicConfig = hashmap;
                super();
            }
        });
    }

    public void initOfferwall(Activity activity, String s)
    {
        try
        {
            log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_API, (new StringBuilder()).append(getProviderName()).append(":initOfferwall(userId:").append(s).append(")").toString(), 1);
            mActivtiy = activity;
            mOfferwallUserId = s;
            mActivtiy.runOnUiThread(new Runnable() {

                final SupersonicAdsAdapter this$0;

                public void run()
                {
                    mSSAPublisher = SSAFactory.getPublisherInstance(mActivtiy);
                    mOfferwallListener.onOfferwallInitSuccess();
                }

            
            {
                this$0 = SupersonicAdsAdapter.this;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_API, (new StringBuilder()).append(getProviderName()).append(":initOfferwall(userId:").append(s).append(")").toString(), activity);
        }
        mOfferwallListener.onOfferwallInitFail(ErrorBuilder.buildAdapterInitFailedError("Offerwall init failed"));
    }

    public void initRewardedVideo(final Activity activity, final String userId)
    {
        EventsHandler.getHandler().notifyInitRewardedVideo(getProviderName());
        log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_API, (new StringBuilder()).append(getProviderName()).append(":initRewardedVideo(userId:").append(userId).append(")").toString(), 1);
        mActivtiy = activity;
        mMaxVideosPerSession = SupersonicConfig.getConfigObj(activity).getMaxVideos();
        mCurrentVideosPresented = 0;
        mActivtiy.runOnUiThread(new Runnable() {

            final SupersonicAdsAdapter this$0;
            final Activity val$activity;
            final String val$userId;

            public void run()
            {
                mSSAPublisher = SSAFactory.getPublisherInstance(mActivtiy);
                HashMap hashmap = getRewardedVideoExtraParams(activity);
                String s = SupersonicConfig.getConfigObj(activity).getApplicationKey();
                log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_API, (new StringBuilder()).append(getProviderName()).append(":initRewardedVideo(appKey:").append(s).append(", userId:").append(userId).append(", extraParams:").append(hashmap).append(")").toString(), 1);
                mSSAPublisher.initRewardedVideo(s, userId, hashmap, new OnRewardedVideoListener() {

                    final _cls2 this$1;

                    public void onRVAdClosed()
                    {
                        if (mRewardedVideoManager != null)
                        {
                            mRewardedVideoManager.onRewardedVideoAdClosed(_fld0);
                        }
                    }

                    public void onRVAdCredited(int i)
                    {
                        if (mRewardedVideoManager != null)
                        {
                            mRewardedVideoManager.onRewardedVideoAdRewarded(i, _fld0);
                        }
                    }

                    public void onRVGeneric(String s, String s1)
                    {
                    }

                    public void onRVInitFail(String s)
                    {
                        setRVInitStatus(false);
                        cancelTimer();
                        if (mRewardedVideoManager != null)
                        {
                            s = ErrorBuilder.buildAdapterInitFailedError(s);
                            mRewardedVideoManager.onRewardedVideoInitFail(s, _fld0);
                        }
                    }

                    public void onRVInitSuccess(AdUnitsReady adunitsready)
                    {
                        cancelTimer();
                        setRVInitStatus(true);
                        SupersonicAdsAdapter supersonicadsadapter = _fld0;
                        int i;
                        int j;
                        boolean flag;
                        if (mCurrentVideosPresented < mMaxVideosPerSession)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        supersonicadsadapter.setAdAvailable(flag);
                        if (mRewardedVideoManager == null) goto _L2; else goto _L1
_L1:
                        mRewardedVideoManager.onRewardedVideoInitSuccess(_fld0);
                        i = 0;
                        j = Integer.parseInt(adunitsready.getNumOfAdUnits());
                        i = j;
_L4:
                        if (i <= 0 || !mIsAdAvailable)
                        {
                            break; /* Loop/switch isn't completed */
                        }
                        mRewardedVideoManager.onVideoAvailabilityChanged(true, _fld0);
_L2:
                        return;
                        adunitsready;
                        SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, "onRVInitSuccess:parseInt()", adunitsready);
                        if (true) goto _L4; else goto _L3
_L3:
                        mRewardedVideoManager.onVideoAvailabilityChanged(false, _fld0);
                        return;
                    }

                    public void onRVNoMoreOffers()
                    {
                        cancelTimer();
                        setAdAvailable(false);
                        if (mRewardedVideoManager != null)
                        {
                            mRewardedVideoManager.onRewardedVideoInitSuccess(_fld0);
                            mRewardedVideoManager.onVideoAvailabilityChanged(false, _fld0);
                        }
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
            }

            
            {
                this$0 = SupersonicAdsAdapter.this;
                activity = activity1;
                userId = s;
                super();
            }
        });
    }

    public boolean isInterstitialAdAvailable()
    {
        log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_API, (new StringBuilder()).append(getProviderName()).append(":isInterstitialAdAvailable()").toString(), 1);
        if (mSSAPublisher != null)
        {
            return mSSAPublisher.isInterstitialAdAvailable();
        } else
        {
            log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, "Please call init before calling isInterstitialAdAvailable", 2);
            return false;
        }
    }

    public boolean isOfferwallAvailable()
    {
        return true;
    }

    public boolean isRewardedVideoAvailable()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_API, (new StringBuilder()).append(getProviderName()).append(":isRewardedVideoAvailable():").append(mIsAdAvailable).toString(), 1);
        EventsHandler.getHandler().notifyIsRewardedVideoAvailable(getProviderName(), mIsAdAvailable);
        flag = mIsAdAvailable;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void onGetOWCreditsFailed(String s)
    {
        if (mOfferwallListener != null)
        {
            s = ErrorBuilder.buildGenericError(s);
            mOfferwallListener.onGetOfferwallCreditsFail(s);
        }
    }

    public void onOWAdClosed()
    {
        if (mOfferwallListener != null)
        {
            mOfferwallListener.onOfferwallClosed();
        }
    }

    public boolean onOWAdCredited(int i, int j, boolean flag)
    {
        return mOfferwallListener != null && mOfferwallListener.onOfferwallAdCredited(i, j, flag);
    }

    public void onOWGeneric(String s, String s1)
    {
    }

    public void onOWShowFail(String s)
    {
        if (mOfferwallListener != null)
        {
            s = ErrorBuilder.buildGenericError(s);
            mOfferwallListener.onOfferwallShowFail(s);
        }
    }

    public void onOWShowSuccess()
    {
        if (mOfferwallListener != null)
        {
            mOfferwallListener.onOfferwallOpened();
        }
    }

    public void onPause(Activity activity)
    {
        log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_API, (new StringBuilder()).append(getProviderName()).append(":onPause()").toString(), 1);
        if (mSSAPublisher != null)
        {
            mSSAPublisher.onPause(activity);
        }
    }

    public void onResume(Activity activity)
    {
        log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_API, (new StringBuilder()).append(getProviderName()).append(":onResume()").toString(), 1);
        mActivtiy = activity;
        if (mSSAPublisher != null)
        {
            mSSAPublisher.onResume(mActivtiy);
        }
    }

    public void release(Activity activity)
    {
        log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_API, (new StringBuilder()).append(getProviderName()).append(":release()").toString(), 1);
        if (mSSAPublisher != null)
        {
            mSSAPublisher.release(mActivtiy);
        }
    }

    public void setAdAvailable(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        mIsAdAvailable = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setAge(int i)
    {
        SupersonicConfig.getConfigObj(mActivtiy).setUserAgeGroup(i);
        log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_API, (new StringBuilder()).append(getProviderName()).append(":setAge(age:").append(i).append(")").toString(), 1);
    }

    public void setGender(String s)
    {
        SupersonicConfig.getConfigObj(mActivtiy).setUserGender(s);
        log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_API, (new StringBuilder()).append(getProviderName()).append(":setGender(gender:").append(s).append(")").toString(), 1);
    }

    public void setInterstitialListener(InterstitialListener interstitiallistener)
    {
        mInterstitialListener = interstitiallistener;
    }

    public void setOfferwallListener(OfferwallListener offerwalllistener)
    {
        mOfferwallListener = offerwalllistener;
    }

    public void setRewardedVideoListener(RewardedVideoManagerListener rewardedvideomanagerlistener)
    {
        mRewardedVideoManager = rewardedvideomanagerlistener;
    }

    public void showInterstitial()
    {
        log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_API, (new StringBuilder()).append(getProviderName()).append(":showInterstitial()").toString(), 1);
        if (mSSAPublisher != null)
        {
            mSSAPublisher.showInterstitial();
            return;
        } else
        {
            log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, "Please call init before calling showInterstitial", 2);
            return;
        }
    }

    public void showOfferwall()
    {
        HashMap hashmap = getOfferwallExtraParams(mActivtiy);
        String s = SupersonicConfig.getConfigObj(mActivtiy).getApplicationKey();
        log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_API, (new StringBuilder()).append(getProviderName()).append(":showOfferwall(appKey:").append(s).append(", userId:").append(mOfferwallUserId).append(", extraParams:").append(hashmap).append(")").toString(), 1);
        if (mSSAPublisher != null)
        {
            mSSAPublisher.showOfferWall(SupersonicConfig.getConfigObj(mActivtiy).getApplicationKey(), mOfferwallUserId, hashmap, this);
            return;
        } else
        {
            log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, "Please call init before calling showOfferwall", 2);
            return;
        }
    }

    public void showRewardedVideo()
    {
        EventsHandler.getHandler().notifyShowRewardedVideo(getProviderName());
        if (mSSAPublisher != null)
        {
            log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_API, (new StringBuilder()).append(getProviderName()).append(":showRewardedVideo()").toString(), 1);
            mSSAPublisher.showRewardedVideo();
            mCurrentVideosPresented = mCurrentVideosPresented + 1;
            if (mCurrentVideosPresented >= mMaxVideosPerSession)
            {
                setAdAvailable(false);
                if (mRewardedVideoManager != null)
                {
                    mRewardedVideoManager.onVideoAvailabilityChanged(false, this);
                }
            }
            return;
        } else
        {
            log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, "Please call init before calling showRewardedVideo", 2);
            return;
        }
    }



/*
    static SSAPublisher access$002(SupersonicAdsAdapter supersonicadsadapter, SSAPublisher ssapublisher)
    {
        supersonicadsadapter.mSSAPublisher = ssapublisher;
        return ssapublisher;
    }

*/














}
