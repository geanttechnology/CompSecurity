// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.merch;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.common.content.EbayCguidGetter;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextObservingDataManager;
import com.ebay.nautilus.domain.data.Merchandise;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.dcs.DcsNautilusInteger;
import com.ebay.nautilus.domain.dcs.DcsNautilusLong;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.api.recommendation.GetPlacementRequest;
import com.ebay.nautilus.domain.net.api.recommendation.GetPlacementResponse;
import com.ebay.nautilus.domain.net.api.recommendation.Placements;
import com.ebay.nautilus.domain.net.api.recommendation.RecommendationApiContext;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.cachemanager.JsonPersistenceMapper;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.LocationUtil;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class MerchandiseDataManager extends UserContextObservingDataManager
{
    private final class GetPlacementsTask extends AsyncTask
    {

        private final RecommendationApiContext apiContext;
        private final Authentication auth;
        private final Observer caller;
        private final boolean isTransacted;
        private final List itemIds;
        private final List placementIds;
        private final EbaySite site;
        final MerchandiseDataManager this$0;

        protected transient Content doInBackground(Void avoid[])
        {
            avoid = MerchandiseDataManager.cacheKeyFor(apiContext, placementIds, itemIds, isTransacted);
            Merchandise merchandise;
            synchronized (MerchandiseDataManager.cacheLock)
            {
                merchandise = (Merchandise)MerchandiseDataManager.cacheManager.get(avoid);
            }
            if (merchandise != null)
            {
                return new Content(merchandise);
            }
            break MISSING_BLOCK_LABEL_57;
            avoid;
            obj;
            JVM INSTR monitorexit ;
            throw avoid;
            Object obj1 = new StringBuilder();
            ((StringBuilder) (obj1)).append("guid=").append(EbayIdentity.getDeviceIdString(getContext()));
            if (auth != null)
            {
                String s = EbayCguidGetter.get(getEbayContext(), MyApp.getPrefs(), site, auth.iafToken);
                if (!TextUtils.isEmpty(s))
                {
                    ((StringBuilder) (obj1)).append(",cguid=").append(s);
                }
            }
            ((StringBuilder) (obj1)).append(",pageid=2047935");
            Object obj2 = new ResultStatusOwner();
            obj1 = new GetPlacementRequest(apiContext, placementIds, itemIds, isTransacted, ((StringBuilder) (obj1)).toString());
            obj1 = (GetPlacementResponse)safeSendRequest(((Request) (obj1)), ((ResultStatusOwner) (obj2)));
            if (obj1 != null && !((GetPlacementResponse) (obj1)).getResultStatus().hasError() && ((GetPlacementResponse) (obj1)).getResultStatus() != ResultStatus.CANCELED)
            {
                obj2 = new Merchandise(((GetPlacementResponse) (obj1)).placementToListingMap);
                synchronized (MerchandiseDataManager.cacheLock)
                {
                    MerchandiseDataManager.cacheManager.put(avoid, obj2);
                }
                if (((GetPlacementResponse) (obj1)).placements != null)
                {
                    avoid = new TrackingData("MerchFeed", TrackingType.EVENT);
                    avoid.addKeyValuePair("svcdata", ((GetPlacementResponse) (obj1)).placements.impression);
                    avoid.send(getEbayContext());
                }
                return new Content(obj2, ((GetPlacementResponse) (obj1)).getResultStatus());
            } else
            {
                return new Content(((ResultStatusOwner) (obj2)).getResultStatus());
            }
            avoid;
            obj3;
            JVM INSTR monitorexit ;
            throw avoid;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onCancelled()
        {
            if (caller != null)
            {
                caller.onMerchandiseLoaded(MerchandiseDataManager.this, new Content(ResultStatus.CANCELED));
                return;
            } else
            {
                ((Observer)
// JavaClassFileOutputException: get_constant: invalid tag

        protected void onPostExecute(Content content)
        {
            if (caller != null)
            {
                caller.onMerchandiseLoaded(MerchandiseDataManager.this, content);
                return;
            } else
            {
                ((Observer)
// JavaClassFileOutputException: get_constant: invalid tag

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        protected void onPreExecute()
        {
            if (caller != null)
            {
                caller.onMerchandiseLoading(MerchandiseDataManager.this);
                return;
            } else
            {
                ((Observer)
// JavaClassFileOutputException: get_constant: invalid tag

        public GetPlacementsTask(RecommendationApiContext recommendationapicontext, List list, List list1, boolean flag, Observer observer)
        {
            this$0 = MerchandiseDataManager.this;
            super();
            apiContext = recommendationapicontext;
            placementIds = list;
            itemIds = list1;
            isTransacted = flag;
            caller = observer;
            auth = getCurrentUser();
            site = getCurrentCountry().site;
        }
    }

    public static final class KeyParams extends com.ebay.nautilus.domain.content.dm.UserContextObservingDataManager.KeyBase
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return MerchandiseDataManager.KEY;
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public KeyParams[] newArray(int i)
            {
                return new KeyParams[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };

        public MerchandiseDataManager create(EbayContext ebaycontext)
        {
            return new MerchandiseDataManager(ebaycontext, this);
        }

        public volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }


        protected KeyParams()
        {
        }
    }

    public static interface Observer
    {

        public abstract void onMerchandiseLoaded(MerchandiseDataManager merchandisedatamanager, Content content);

        public abstract void onMerchandiseLoading(MerchandiseDataManager merchandisedatamanager);
    }


    public static final KeyParams KEY = new KeyParams();
    private static final Object cacheLock = new Object();
    private static volatile CacheManager cacheManager;
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new LogInfo("MerchDM", 3, "Log Merchandise Data Manager");

    protected MerchandiseDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        UserContextObservingDataManager(ebaycontext, com/ebay/mobile/merch/MerchandiseDataManager$Observer, keyparams);
        if (cacheManager == null)
        {
            initializeCacheManager((Context)ebaycontext.getExtension(android/content/Context));
        }
    }

    private static String cacheKeyFor(RecommendationApiContext recommendationapicontext, List list, List list1, boolean flag)
    {
        Collections.sort(list);
        Collections.sort(list1);
        list = TextUtils.join("-", list);
        list1 = TextUtils.join("-", list1);
        String s = recommendationapicontext.userLocale.toString();
        String s1 = recommendationapicontext.country.site.idString;
        if (flag)
        {
            recommendationapicontext = "1";
        } else
        {
            recommendationapicontext = "0";
        }
        return String.format("rs%4$s_l%3$s_p%1$s_i%2$s_t%5$s", new Object[] {
            list, list1, s, s1, recommendationapicontext
        });
    }

    private RecommendationApiContext getApiContext()
    {
        Object obj = getCurrentUser();
        EbayCountry ebaycountry;
        android.location.Location location;
        if (obj != null)
        {
            obj = ((Authentication) (obj)).iafToken;
        } else
        {
            obj = null;
        }
        ebaycountry = getCurrentCountry();
        location = LocationUtil.getLastKnownLocation(getContext());
        return new RecommendationApiContext(((String) (obj)), ebaycountry, Locale.getDefault(), location);
    }

    private static void initializeCacheManager(Context context)
    {
        synchronized (cacheLock)
        {
            DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
            cacheManager = new CacheManager(context, JsonPersistenceMapper.create(DataMapperFactory.getDefaultMapper()), com/ebay/nautilus/domain/data/Merchandise, "merchCache", deviceconfiguration.get(DcsNautilusInteger.MerchandiseDataManagerCacheSizeInflated), deviceconfiguration.get(DcsNautilusInteger.MerchandiseDataManagerCacheSizeDeflated), deviceconfiguration.get(DcsNautilusLong.MerchandiseDataManagerCacheSizeOnDisk), deviceconfiguration.get(DcsNautilusLong.MerchandiseDataManagerCacheAge), true);
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public void TEST_clearCache()
    {
        if (cacheManager != null)
        {
            cacheManager.clear();
        }
    }

    public void getMerchandise(List list, List list1, boolean flag, Observer observer)
    {
        NautilusKernel.verifyMain();
        RecommendationApiContext recommendationapicontext = getApiContext();
        if (!recommendationapicontext.isValid)
        {
            return;
        }
        if (observer == null)
        {
            observer = null;
        } else
        {
            observer = (Observer)getSafeCallback(observer);
        }
        executeOnThreadPool(new GetPlacementsTask(recommendationapicontext, list, list1, flag, observer), new Void[0]);
    }

    public void loadData(Observer observer)
    {
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public void onCurrentCountryChanged(UserContextDataManager usercontextdatamanager, EbayCountry ebaycountry)
    {
        initializeCacheManager(getContext());
    }










}
