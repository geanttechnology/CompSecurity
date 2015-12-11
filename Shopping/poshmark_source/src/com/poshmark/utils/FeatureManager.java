// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.application.PMApplication;
import com.poshmark.data_model.models.Features;
import com.poshmark.data_model.models.inner_models.AddToBundleButtonFeature;
import com.poshmark.data_model.models.inner_models.FeedAutoRefreshFeature;
import com.poshmark.data_model.models.inner_models.FeedLazyLoadFeature;
import com.poshmark.data_model.models.inner_models.ListingFeature;
import com.poshmark.data_model.models.inner_models.ShopTabLuxuryFeature;
import com.poshmark.data_model.models.inner_models.SimilarListings;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.triggers.TriggerThresholds;
import java.util.Date;

public class FeatureManager
    implements PMNotificationListener
{

    static FeatureManager globalFeatureManager = null;
    Features currentFeatures;
    Date lastFetchTime;
    Object mutex;
    SharedPreferences savedFeatureSettings;

    private FeatureManager()
    {
        mutex = new Object();
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.NEW_FEATURES_ON_SERVER", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.LOGOUT_COMPLETE", this);
        Context context = PMApplication.getContext();
        PMApplication.getContext();
        savedFeatureSettings = context.getSharedPreferences("savedFeatureSettings", 0);
        if (cachedFeaturesAvailable())
        {
            currentFeatures = getCachedFeatures();
            return;
        } else
        {
            currentFeatures = new Features();
            return;
        }
    }

    private boolean cachedFeaturesAvailable()
    {
        return savedFeatureSettings.getString("FEATURES_JSON", null) != null;
    }

    private void clearAllSavedSettings()
    {
        synchronized (mutex)
        {
            savedFeatureSettings.edit().clear().commit();
            currentFeatures = new Features();
            lastFetchTime = null;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private Features getCachedFeatures()
    {
        Object obj = null;
        String s = savedFeatureSettings.getString("FEATURES_JSON", null);
        if (s != null)
        {
            obj = (new GsonBuilder()).create();
            if (!(obj instanceof Gson))
            {
                obj = ((Gson) (obj)).fromJson(s, com/poshmark/data_model/models/Features);
            } else
            {
                obj = GsonInstrumentation.fromJson((Gson)obj, s, com/poshmark/data_model/models/Features);
            }
            obj = (Features)obj;
        }
        return ((Features) (obj));
    }

    private void getFeatures()
    {
        PMApi.getFeatures(new PMApiResponseHandler() {

            final FeatureManager this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                synchronized (mutex)
                {
                    if (!pmapiresponse.hasError())
                    {
                        lastFetchTime = new Date();
                        currentFeatures = (Features)pmapiresponse.data;
                        saveFeaturesToCache();
                    }
                }
                return;
                pmapiresponse;
                obj;
                JVM INSTR monitorexit ;
                throw pmapiresponse;
            }

            
            {
                this$0 = FeatureManager.this;
                super();
            }
        });
    }

    public static FeatureManager getGlobalFeatureManager()
    {
        com/poshmark/utils/FeatureManager;
        JVM INSTR monitorenter ;
        FeatureManager featuremanager;
        if (globalFeatureManager == null)
        {
            globalFeatureManager = new FeatureManager();
        }
        featuremanager = globalFeatureManager;
        com/poshmark/utils/FeatureManager;
        JVM INSTR monitorexit ;
        return featuremanager;
        Exception exception;
        exception;
        throw exception;
    }

    private void saveFeaturesToCache()
    {
        Object obj = (new GsonBuilder()).create();
        Features features = currentFeatures;
        if (!(obj instanceof Gson))
        {
            obj = ((Gson) (obj)).toJson(features, com/poshmark/data_model/models/Features);
        } else
        {
            obj = GsonInstrumentation.toJson((Gson)obj, features, com/poshmark/data_model/models/Features);
        }
        if (obj != null)
        {
            savedFeatureSettings.edit().putString("FEATURES_JSON", ((String) (obj))).commit();
        }
    }

    public AddToBundleButtonFeature getAddToBundleButtonFeature()
    {
        AddToBundleButtonFeature addtobundlebuttonfeature;
        synchronized (mutex)
        {
            addtobundlebuttonfeature = currentFeatures.getAddToBundleButtonFeature();
        }
        return addtobundlebuttonfeature;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public TriggerThresholds getBrandShareTriggerFeature()
    {
        TriggerThresholds triggerthresholds;
        synchronized (mutex)
        {
            triggerthresholds = currentFeatures.getBrandShareTriggerFeature();
        }
        return triggerthresholds;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public com.poshmark.data_model.models.inner_models.FbDialogShareFeature.TipInfo getFbShareProTipInfo(ShareManager.SHARE_MODE share_mode)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (currentFeatures == null && currentFeatures.isShareProTipEnabled(share_mode))
        {
            break MISSING_BLOCK_LABEL_38;
        }
        share_mode = currentFeatures.getFbShareProTipInfo(share_mode);
        return share_mode;
        obj;
        JVM INSTR monitorexit ;
        return null;
        share_mode;
        obj;
        JVM INSTR monitorexit ;
        throw share_mode;
    }

    public FeedAutoRefreshFeature getFeedAutoRefreshFeature()
    {
        FeedAutoRefreshFeature feedautorefreshfeature;
        synchronized (mutex)
        {
            feedautorefreshfeature = currentFeatures.getFeedAutoRefreshFeature();
        }
        return feedautorefreshfeature;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public FeedLazyLoadFeature getFeedLazyLoadFeature()
    {
        FeedLazyLoadFeature feedlazyloadfeature;
        synchronized (mutex)
        {
            feedlazyloadfeature = currentFeatures.getLazyFeedLoadFeature();
        }
        return feedlazyloadfeature;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public ListingFeature getListingFeature()
    {
        ListingFeature listingfeature;
        synchronized (mutex)
        {
            listingfeature = currentFeatures.getListingFeature();
        }
        return listingfeature;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public ShopTabLuxuryFeature getLuxuryFeature()
    {
        ShopTabLuxuryFeature shoptabluxuryfeature;
        synchronized (mutex)
        {
            shoptabluxuryfeature = currentFeatures.getLuxuryFeature();
        }
        return shoptabluxuryfeature;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public TriggerThresholds getRateAppTriggerFeature()
    {
        TriggerThresholds triggerthresholds;
        synchronized (mutex)
        {
            triggerthresholds = currentFeatures.getRateAppTriggerFeature();
        }
        return triggerthresholds;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public SimilarListings getSimilarListingsFeature()
    {
        SimilarListings similarlistings;
        synchronized (mutex)
        {
            similarlistings = currentFeatures.getSimilarListingsFeature();
        }
        return similarlistings;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void handleNotification(Intent intent)
    {
        if (intent.getAction().equals("com.poshmark.intents.NEW_FEATURES_ON_SERVER"))
        {
            getFeatures();
        } else
        if (intent.getAction().equals("com.poshmark.intents.LOGOUT_COMPLETE"))
        {
            clearAllSavedSettings();
            return;
        }
    }

    public boolean isAddToBundleButtonFeatureEnabled()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (currentFeatures == null || !currentFeatures.isAddToBundleButtonFeatureEnabled())
        {
            return false;
        }
        obj;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isAutoCompleteSearchEnabled()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (currentFeatures == null || !currentFeatures.isAutoCompleteEnabled())
        {
            return false;
        }
        obj;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isBrandPriceDropEnabled()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (currentFeatures == null || !currentFeatures.isBrandPriceDropEnabled())
        {
            return false;
        }
        obj;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isBrandsFollowOnSignupEnabled()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (currentFeatures == null || !currentFeatures.isBrandsFollowOnSignupEnabled())
        {
            return false;
        }
        obj;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isEditListingWithNFSEnable()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (currentFeatures == null || !currentFeatures.isEditListingWithNFSEnabled())
        {
            return false;
        }
        obj;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isFbExplicitShareEnabled()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (currentFeatures == null || !currentFeatures.isFbExplicitShareEnabled())
        {
            return false;
        }
        obj;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isFbMessengerSharingEnabled()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (currentFeatures == null || !currentFeatures.isFBMessengerSharingEnabled())
        {
            return false;
        }
        obj;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isFbShareProTipEnabled(ShareManager.SHARE_MODE share_mode)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (currentFeatures == null || !currentFeatures.isShareProTipEnabled(share_mode))
        {
            return false;
        }
        obj;
        JVM INSTR monitorexit ;
        return true;
        share_mode;
        obj;
        JVM INSTR monitorexit ;
        throw share_mode;
    }

    public boolean isFilterBarv2FeatureEnabled()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (currentFeatures == null || !currentFeatures.isFilterBarv2FeatureEnabled())
        {
            return false;
        }
        obj;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isListingDetailsPriceDropEnabled()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (currentFeatures == null || !currentFeatures.isListingDetailsPriceDropEnabled())
        {
            return false;
        }
        obj;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isMakeAnOfferEnabled()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (currentFeatures == null || !currentFeatures.isMakeAnOfferEnabled())
        {
            return false;
        }
        obj;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isMyLikesFiltersEnabled()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (currentFeatures == null || !currentFeatures.isMyLikesFiltersEnabled())
        {
            return false;
        }
        obj;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isMyLikesPriceDropEnabled()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (currentFeatures == null || !currentFeatures.isMyLikesPriceDropEnabled())
        {
            return false;
        }
        obj;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isNewListingDetailsLayoutEnabled()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (currentFeatures == null || !currentFeatures.isNewListingDetailsFeatureEnabled())
        {
            return false;
        }
        obj;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isPinterestButtonEnabled()
    {
        return currentFeatures.isPinterestButtonEnabled();
    }

    public boolean isPinterestConnectionDialogShowable()
    {
        return currentFeatures.isPinterestConnectionDialogShowable();
    }

    public boolean isShowroomPriceDropEnabled()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (currentFeatures == null || !currentFeatures.isShowroomPriceDropEnabled())
        {
            return false;
        }
        obj;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isShowroomsEnabled()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (currentFeatures == null || !currentFeatures.isShowRoomsEnabled())
        {
            return false;
        }
        obj;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isSimilarListingsFeatureEnabled()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (currentFeatures == null || !currentFeatures.isSimilarListingsFeatureEnabled())
        {
            return false;
        }
        obj;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean lastUpdatedBefore(Date date)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (lastFetchTime == null || lastFetchTime.before(date))
        {
            return true;
        }
        obj;
        JVM INSTR monitorexit ;
        return false;
        date;
        obj;
        JVM INSTR monitorexit ;
        throw date;
    }


}
