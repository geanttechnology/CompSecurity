// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.common.content.EbayCguidGetter;
import com.ebay.common.content.EbayCguidPersister;
import com.ebay.common.rtm.RtmHelper;
import com.ebay.common.util.TrackableDictionary;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.net.DataRequest;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.LogTrackError;
import com.ebay.nautilus.kernel.net.LogTrackManager;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class AdRtmDataManager extends DataManager
{
    private static abstract class AdQuery
    {

        public AdRequestType adType;
        public EbayCguidPersister cguidPersister;
        public boolean generateRequestContextOnly;
        public String iafToken;
        public EbaySite site;

        public abstract com.ebay.common.net.api.rtm.GetRtm.GetRtmRequest getRequest(Context context, String s, String s1);

        public abstract boolean validateResult(com.ebay.common.net.api.rtm.GetRtm.GetRtmRequest getrtmrequest, List list);

        private AdQuery()
        {
            adType = AdRequestType.NONE;
        }

    }

    public static final class AdRequestType extends Enum
    {

        private static final AdRequestType $VALUES[];
        public static final AdRequestType DISPLAY;
        public static final AdRequestType NONE;
        public static final AdRequestType PLA;

        public static AdRequestType valueOf(String s)
        {
            return (AdRequestType)Enum.valueOf(com/ebay/common/content/dm/AdRtmDataManager$AdRequestType, s);
        }

        public static AdRequestType[] values()
        {
            return (AdRequestType[])$VALUES.clone();
        }

        static 
        {
            NONE = new AdRequestType("NONE", 0);
            DISPLAY = new AdRequestType("DISPLAY", 1);
            PLA = new AdRequestType("PLA", 2);
            $VALUES = (new AdRequestType[] {
                NONE, DISPLAY, PLA
            });
        }

        private AdRequestType(String s, int i)
        {
            super(s, i);
        }
    }

    private final class GetAdsLoadTask extends AsyncTask
    {

        private AdRequestType adType;
        private AdQuery param;
        final AdRtmDataManager this$0;

        protected transient ResultContent doInBackground(AdQuery aadquery[])
        {
            if (isCancelled())
            {
                return null;
            }
            param = aadquery[0];
            Context context = getContext();
            Object obj2;
            obj2 = null;
            aadquery = null;
            Object obj = AdvertisingIdClient.getAdvertisingIdInfo(context);
            aadquery = ((AdQuery []) (obj));
_L8:
            if (aadquery == null) goto _L2; else goto _L1
_L1:
            if (!aadquery.isLimitAdTrackingEnabled()) goto _L3; else goto _L2
_L2:
            if (!(param instanceof HomePromoRequestContextQuery)) goto _L4; else goto _L3
_L3:
            String s;
            obj2 = param.iafToken;
            s = EbayCguidGetter.get(getEbayContext(), param.cguidPersister, param.site, ((String) (obj2)));
            boolean flag;
            boolean flag1;
            flag1 = false;
            aadquery = s;
            obj = obj2;
            flag = flag1;
            if (!(param instanceof HomeAdRequestContextQuery))
            {
                break MISSING_BLOCK_LABEL_158;
            }
            aadquery = s;
            obj = obj2;
            flag = flag1;
            if (((HomeAdRequestContextQuery)param).promoPlacementID == null)
            {
                break MISSING_BLOCK_LABEL_158;
            }
            ((HomeAdRequestContextQuery)param).promoCguid = s;
            flag = flag1;
            obj = obj2;
            aadquery = s;
            break MISSING_BLOCK_LABEL_158;
_L4:
            if (AdRtmDataManager.anonCguid == null)
            {
                AdRtmDataManager.anonCguid = EbayCguidGetter.get(getEbayContext(), param.cguidPersister, param.site, null);
            }
            s1 = AdRtmDataManager.anonCguid;
            flag2 = true;
            aadquery = s1;
            obj = obj2;
            flag = flag2;
            if (!(param instanceof HomeAdRequestContextQuery))
            {
                continue; /* Loop/switch isn't completed */
            }
            aadquery = s1;
            obj = obj2;
            flag = flag2;
            if (((HomeAdRequestContextQuery)param).promoPlacementID == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            ((HomeAdRequestContextQuery)param).promoCguid = EbayCguidGetter.get(getEbayContext(), param.cguidPersister, param.site, param.iafToken);
            aadquery = s1;
            obj = obj2;
            flag = flag2;
            if (true) goto _L6; else goto _L5
_L5:
            aadquery = param.getRequest(context, ((String) (obj)), aadquery);
            if (param.generateRequestContextOnly)
            {
                if (param instanceof HomeAdRequestContextQuery)
                {
                    return new ResultContent(aadquery.getRtmContext(flag, context));
                } else
                {
                    return new ResultContent(aadquery.getPromoRtmContext(context));
                }
            }
            obj = (com.ebay.common.net.api.rtm.GetRtm.GetRtmResponse)sendRequest(aadquery);
            if (((com.ebay.common.net.api.rtm.GetRtm.GetRtmResponse) (obj)).getResultStatus().hasError())
            {
                return null;
            }
            obj = new RtmHelper(((com.ebay.common.net.api.rtm.GetRtm.GetRtmResponse) (obj)).rcr, null);
            obj2 = ((RtmHelper) (obj)).getAds();
            if (obj2 == null)
            {
                break MISSING_BLOCK_LABEL_484;
            }
            if (!param.validateResult(aadquery, ((List) (obj2))))
            {
                break MISSING_BLOCK_LABEL_484;
            }
            aadquery = new ResultContent(((RtmHelper) (obj)));
            return aadquery;
            obj1;
            continue; /* Loop/switch isn't completed */
            obj1;
            if (true) goto _L8; else goto _L7
_L7:
            return null;
_L6:
            Object obj1;
            String s1;
            boolean flag2;
            try
            {
                if (TextUtils.isEmpty(((CharSequence) (obj))) || !TextUtils.isEmpty(aadquery))
                {
                    break; /* Loop/switch isn't completed */
                }
                if (AdRtmDataManager.logger.isLoggable)
                {
                    AdRtmDataManager.logger.log("IAF token supplied w/o matching cguid.  Ad retrieval skipped");
                }
                break MISSING_BLOCK_LABEL_471;
            }
            // Misplaced declaration of an exception variable
            catch (AdQuery aadquery[]) { }
            // Misplaced declaration of an exception variable
            catch (AdQuery aadquery[]) { }
            // Misplaced declaration of an exception variable
            catch (AdQuery aadquery[]) { }
            return null;
            return null;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((AdQuery[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleAdsLoaded(this, null, adType);
        }

        protected void onPostExecute(ResultContent resultcontent)
        {
            super.onPostExecute(resultcontent);
            handleAdsLoaded(this, resultcontent, adType);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ResultContent)obj);
        }

        public GetAdsLoadTask(AdRequestType adrequesttype)
        {
            this$0 = AdRtmDataManager.this;
            super();
            param = null;
            adType = adrequesttype;
        }
    }

    private static final class HomeAdRequestContextQuery extends AdQuery
    {

        public String placementID;
        public String promoCguid;
        public String promoPlacementID;

        public com.ebay.common.net.api.rtm.GetRtm.GetRtmRequest getRequest(Context context, String s, String s1)
        {
            return new com.ebay.common.net.api.rtm.GetRtm.GetHomeRtmRequestContext(context, placementID, promoPlacementID, promoCguid, s, site, NautilusKernel.getAppVersionName(context), s1);
        }

        public boolean validateResult(com.ebay.common.net.api.rtm.GetRtm.GetRtmRequest getrtmrequest, List list)
        {
            if (list.size() < 1)
            {
                if (AdRtmDataManager.logger.isLoggable)
                {
                    AdRtmDataManager.logger.log("Empty RTM Home Screen Ad content");
                }
            } else
            {
                if (list.size() > 1)
                {
                    if (AdRtmDataManager.logger.isLoggable)
                    {
                        AdRtmDataManager.logger.log("RTM exceeded absolute max Home Screen Ad instance limit (1)");
                    }
                    list.subList(1, list.size()).clear();
                }
                if (TextUtils.isEmpty(((com.ebay.common.rtm.RtmContent.Ad)list.get(0)).adUnitId))
                {
                    if (AdRtmDataManager.logger.isLoggable)
                    {
                        AdRtmDataManager.logger.log("RTM Home Screen Ad content is missing adUnitId");
                        return false;
                    }
                } else
                {
                    return true;
                }
            }
            return false;
        }

        private HomeAdRequestContextQuery()
        {
        }

    }

    private static final class HomePromoRequestContextQuery extends AdQuery
    {

        public String promoPlacementID;

        public com.ebay.common.net.api.rtm.GetRtm.GetRtmRequest getRequest(Context context, String s, String s1)
        {
            return new com.ebay.common.net.api.rtm.GetRtm.GetHomePromoRtmRequestContext(context, promoPlacementID, s, site, NautilusKernel.getAppVersionName(context), s1);
        }

        public boolean validateResult(com.ebay.common.net.api.rtm.GetRtm.GetRtmRequest getrtmrequest, List list)
        {
            return true;
        }

        private HomePromoRequestContextQuery()
        {
        }

    }

    public static final class KeyParams extends com.ebay.nautilus.domain.content.DataManager.DataManagerKeyParams
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return new KeyParams(parcel.readString());
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
        public final String uniquifier;

        public AdRtmDataManager createManager(EbayContext ebaycontext)
        {
            return new AdRtmDataManager(ebaycontext, com/ebay/common/content/dm/AdRtmDataManager$Observer, this);
        }

        public volatile DataManager createManager(EbayContext ebaycontext)
        {
            return createManager(ebaycontext);
        }

        public boolean equals(Object obj)
        {
            while (obj == this || (obj instanceof KeyParams) && uniquifier.equals(((KeyParams)obj).uniquifier)) 
            {
                return true;
            }
            return false;
        }

        public int hashCode()
        {
            return super.hashCode() * 31 + uniquifier.hashCode();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(uniquifier);
        }


        public KeyParams()
        {
            this(UUID.randomUUID().toString());
        }

        protected KeyParams(String s)
        {
            uniquifier = s;
        }
    }

    public static interface Observer
    {

        public abstract void onAdsContextReady(List list, AdRequestType adrequesttype);

        public abstract void onAdsReady(RtmHelper rtmhelper, AdRequestType adrequesttype);
    }

    public static final class ResultContent
    {

        public RtmHelper rtmHelper;
        public List rtmRequestContext;

        public ResultContent(RtmHelper rtmhelper)
        {
            rtmHelper = rtmhelper;
        }

        public ResultContent(List list)
        {
            rtmRequestContext = list;
        }
    }

    private static final class SearchAdQuery extends AdQuery
    {

        private static final String APLS_RTM_AD_ERR_DOMAIN = "rtmAdRequest";
        private static final int MAX_ADS_IN_RESPONSE = 10;
        public String categoryId;
        public String keywords;
        public int searchResultCount;

        public com.ebay.common.net.api.rtm.GetRtm.GetRtmRequest getRequest(Context context, String s, String s1)
        {
            return new com.ebay.common.net.api.rtm.GetRtm.GetSearchRtmRequest(context, keywords, searchResultCount, categoryId, s, site, NautilusKernel.getAppVersionName(context), s1);
        }

        public boolean validateResult(com.ebay.common.net.api.rtm.GetRtm.GetRtmRequest getrtmrequest, List list)
        {
            if (list.size() > 10)
            {
                LogTrackManager.addLogErrorData(new LogTrackError(getrtmrequest.getOperationName(), getrtmrequest.getOperationName(), getrtmrequest.getRequestUrl().toString(), getrtmrequest.getClass().toString(), "rtmAdRequest", "rtmAdErrTooManyAds", (Throwable)null));
                if (AdRtmDataManager.logger.isLoggable)
                {
                    AdRtmDataManager.logger.log(String.format("RTM exceeded absolute max ad instance limit (%d)", new Object[] {
                        Integer.valueOf(10)
                    }));
                }
                list.subList(10, list.size()).clear();
            }
            boolean flag1 = ((com.ebay.common.rtm.RtmContent.Ad)list.get(0)).isPla;
            for (list = list.iterator(); list.hasNext();)
            {
                com.ebay.common.rtm.RtmContent.Ad ad = (com.ebay.common.rtm.RtmContent.Ad)list.next();
                boolean flag;
                if (ad.isPla == flag1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    LogTrackManager.addLogErrorData(new LogTrackError(getrtmrequest.getOperationName(), getrtmrequest.getOperationName(), getrtmrequest.getRequestUrl().toString(), getrtmrequest.getClass().toString(), "rtmAdRequest", "rtmAdErrMixedModels", (Throwable)null));
                    if (AdRtmDataManager.logger.isLoggable)
                    {
                        AdRtmDataManager.logger.log("RTM Ad content contained mixed ad results");
                    }
                    return false;
                }
                if (flag1)
                {
                    if (!TextUtils.isEmpty(ad.title) && ad.thumbnailURL != null && ad.externalLink != null && !TextUtils.isEmpty(ad.formattedPriceString) && !TextUtils.isEmpty(ad.retailerName))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                } else
                if (!TextUtils.isEmpty(ad.title) && !TextUtils.isEmpty(ad.subTitle) && ad.externalLink != null && !TextUtils.isEmpty(ad.externalLinkName))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    LogTrackManager.addLogErrorData(new LogTrackError(getrtmrequest.getOperationName(), getrtmrequest.getOperationName(), getrtmrequest.getRequestUrl().toString(), getrtmrequest.getClass().toString(), "rtmAdRequest", "rtmAdErrMissingFields", (Throwable)null));
                    if (AdRtmDataManager.logger.isLoggable)
                    {
                        AdRtmDataManager.logger.log("RTM Ad content is missing one or more required fields");
                    }
                    return false;
                }
            }

            return true;
        }

        private SearchAdQuery()
        {
        }

    }

    private final class TrackAdsLoadTask extends AsyncTask
    {

        final AdRtmDataManager this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((TrackAdsLoadTaskParams[])aobj);
        }

        protected transient Void doInBackground(TrackAdsLoadTaskParams atrackadsloadtaskparams[])
        {
            atrackadsloadtaskparams = atrackadsloadtaskparams[0];
            com.ebay.common.rtm.RtmContent.Ad ad = ((TrackAdsLoadTaskParams) (atrackadsloadtaskparams)).ad;
            EbayContext ebaycontext = getEbayContext();
            try
            {
                DataRequest datarequest = new DataRequest(ad.trackingURL);
                sendRequest(datarequest);
                ((TrackAdsLoadTaskParams) (atrackadsloadtaskparams)).trackableDictionary.addKeyValuePair("trkp", ad.trackingClickID);
                ((TrackAdsLoadTaskParams) (atrackadsloadtaskparams)).trackableDictionary.send(ebaycontext);
            }
            // Misplaced declaration of an exception variable
            catch (TrackAdsLoadTaskParams atrackadsloadtaskparams[])
            {
                atrackadsloadtaskparams.printStackTrace();
            }
            return null;
        }

        private TrackAdsLoadTask()
        {
            this$0 = AdRtmDataManager.this;
            super();
        }

    }

    private static class TrackAdsLoadTaskParams
    {

        public com.ebay.common.rtm.RtmContent.Ad ad;
        public TrackableDictionary trackableDictionary;

        private TrackAdsLoadTaskParams()
        {
        }

    }

    private static final class ViewItemDisplayAdQuery extends AdQuery
    {

        private static final String APLS_RTM_AD_ERR_DOMAIN = "rtmAdRequest";
        private static final int MAX_ADS_IN_RESPONSE = 10;
        public String categoryId;
        public long itemId;
        public String title;

        public com.ebay.common.net.api.rtm.GetRtm.GetRtmRequest getRequest(Context context, String s, String s1)
        {
            return new com.ebay.common.net.api.rtm.GetRtm.GetViewItemDisplayRtmRequest(context, title, itemId, categoryId, s, site, NautilusKernel.getAppVersionName(context), s1);
        }

        public boolean validateResult(com.ebay.common.net.api.rtm.GetRtm.GetRtmRequest getrtmrequest, List list)
        {
            if (list.size() < 1)
            {
                if (AdRtmDataManager.logger.isLoggable)
                {
                    AdRtmDataManager.logger.log("Empty VIP Display Ad content");
                }
            } else
            {
                if (list.size() > 1)
                {
                    if (AdRtmDataManager.logger.isLoggable)
                    {
                        AdRtmDataManager.logger.log("RTM exceeded absolute max VIP Ad instance limit (1)");
                    }
                    list.subList(1, list.size()).clear();
                }
                if (TextUtils.isEmpty(((com.ebay.common.rtm.RtmContent.Ad)list.get(0)).adUnitId))
                {
                    if (AdRtmDataManager.logger.isLoggable)
                    {
                        AdRtmDataManager.logger.log("RTM VIP Ad content is missing adUnitId");
                        return false;
                    }
                } else
                {
                    return true;
                }
            }
            return false;
        }

        private ViewItemDisplayAdQuery()
        {
        }

    }

    private static final class ViewItemPlaAdQuery extends AdQuery
    {

        private static final String APLS_RTM_AD_ERR_DOMAIN = "rtmAdRequest";
        private static final int MAX_ADS_IN_RESPONSE = 10;
        public String categoryId;
        public long itemId;
        public String title;

        public com.ebay.common.net.api.rtm.GetRtm.GetRtmRequest getRequest(Context context, String s, String s1)
        {
            return new com.ebay.common.net.api.rtm.GetRtm.GetViewItemPlaRtmRequest(context, title, itemId, categoryId, s, site, NautilusKernel.getAppVersionName(context), s1);
        }

        public boolean validateResult(com.ebay.common.net.api.rtm.GetRtm.GetRtmRequest getrtmrequest, List list)
        {
            if (list.size() > 10)
            {
                LogTrackManager.addLogErrorData(new LogTrackError(getrtmrequest.getOperationName(), getrtmrequest.getOperationName(), getrtmrequest.getRequestUrl().toString(), getrtmrequest.getClass().toString(), "rtmAdRequest", "rtmAdErrTooManyAds", (Throwable)null));
                if (AdRtmDataManager.logger.isLoggable)
                {
                    AdRtmDataManager.logger.log(String.format("RTM exceeded absolute max ad instance limit (%d)", new Object[] {
                        Integer.valueOf(10)
                    }));
                }
                list.subList(10, list.size()).clear();
            }
            boolean flag1 = ((com.ebay.common.rtm.RtmContent.Ad)list.get(0)).isPla;
            for (list = list.iterator(); list.hasNext();)
            {
                com.ebay.common.rtm.RtmContent.Ad ad = (com.ebay.common.rtm.RtmContent.Ad)list.next();
                boolean flag;
                if (ad.isPla == flag1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    LogTrackManager.addLogErrorData(new LogTrackError(getrtmrequest.getOperationName(), getrtmrequest.getOperationName(), getrtmrequest.getRequestUrl().toString(), getrtmrequest.getClass().toString(), "rtmAdRequest", "rtmAdErrMixedModels", (Throwable)null));
                    if (AdRtmDataManager.logger.isLoggable)
                    {
                        AdRtmDataManager.logger.log("RTM Ad content contained mixed ad results");
                    }
                    return false;
                }
                if (flag1)
                {
                    if (!TextUtils.isEmpty(ad.title) && ad.thumbnailURL != null && ad.externalLink != null && !TextUtils.isEmpty(ad.formattedPriceString) && !TextUtils.isEmpty(ad.retailerName))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                } else
                if (!TextUtils.isEmpty(ad.title) && !TextUtils.isEmpty(ad.subTitle) && ad.externalLink != null && !TextUtils.isEmpty(ad.externalLinkName))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    LogTrackManager.addLogErrorData(new LogTrackError(getrtmrequest.getOperationName(), getrtmrequest.getOperationName(), getrtmrequest.getRequestUrl().toString(), getrtmrequest.getClass().toString(), "rtmAdRequest", "rtmAdErrMissingFields", (Throwable)null));
                    if (AdRtmDataManager.logger.isLoggable)
                    {
                        AdRtmDataManager.logger.log("RTM Ad content is missing one or more required fields");
                    }
                    return false;
                }
            }

            return true;
        }

        private ViewItemPlaAdQuery()
        {
        }

    }


    private static String anonCguid = null;
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("ebayAdDataManager", 2, "Log RTM-driven search ad data manager usage");
    private ResultContent lastResult;
    private AdRequestType lastResultAdType;
    private final KeyParams params;
    private AdQuery query;

    protected AdRtmDataManager(EbayContext ebaycontext, Class class1, KeyParams keyparams)
    {
        super(ebaycontext, class1);
        query = null;
        params = keyparams;
    }

    private void dispatchResult(ResultContent resultcontent, AdRequestType adrequesttype)
    {
        if (resultcontent == null)
        {
            ((Observer)dispatcher).onAdsReady(null, adrequesttype);
            return;
        }
        if (resultcontent.rtmHelper != null)
        {
            ((Observer)dispatcher).onAdsReady(resultcontent.rtmHelper, adrequesttype);
            return;
        } else
        {
            ((Observer)dispatcher).onAdsContextReady(resultcontent.rtmRequestContext, adrequesttype);
            return;
        }
    }

    private void handleAdsLoaded(GetAdsLoadTask getadsloadtask, ResultContent resultcontent, AdRequestType adrequesttype)
    {
        query = null;
        if (getadsloadtask.isCancelled())
        {
            return;
        } else
        {
            lastResult = resultcontent;
            lastResultAdType = adrequesttype;
            dispatchResult(resultcontent, adrequesttype);
            return;
        }
    }

    public void getAds(String s, String s1, int i, EbayCguidPersister ebaycguidpersister, EbaySite ebaysite, String s2, Observer observer)
    {
        SearchAdQuery searchadquery = new SearchAdQuery();
        query = searchadquery;
        searchadquery.keywords = s;
        searchadquery.searchResultCount = i;
        searchadquery.site = ebaysite;
        searchadquery.iafToken = s2;
        searchadquery.cguidPersister = ebaycguidpersister;
        searchadquery.categoryId = s1;
        loadData(observer);
    }

    public void getAdsRtmContext(EbayCguidPersister ebaycguidpersister, EbaySite ebaysite, String s, String s1, String s2, Observer observer)
    {
        HomeAdRequestContextQuery homeadrequestcontextquery = new HomeAdRequestContextQuery();
        query = homeadrequestcontextquery;
        homeadrequestcontextquery.site = ebaysite;
        homeadrequestcontextquery.iafToken = s;
        homeadrequestcontextquery.cguidPersister = ebaycguidpersister;
        homeadrequestcontextquery.generateRequestContextOnly = true;
        homeadrequestcontextquery.placementID = s1;
        homeadrequestcontextquery.promoPlacementID = s2;
        loadData(observer);
    }

    public Object getParams()
    {
        return params;
    }

    public void getPromoRtmContext(EbayCguidPersister ebaycguidpersister, EbaySite ebaysite, String s, String s1, Observer observer)
    {
        HomePromoRequestContextQuery homepromorequestcontextquery = new HomePromoRequestContextQuery();
        query = homepromorequestcontextquery;
        homepromorequestcontextquery.site = ebaysite;
        homepromorequestcontextquery.iafToken = s;
        homepromorequestcontextquery.cguidPersister = ebaycguidpersister;
        homepromorequestcontextquery.generateRequestContextOnly = true;
        homepromorequestcontextquery.promoPlacementID = s1;
        loadData(observer);
    }

    public void getViewItemDisplayAds(String s, long l, String s1, EbayCguidPersister ebaycguidpersister, EbaySite ebaysite, String s2, 
            Observer observer)
    {
        ViewItemDisplayAdQuery viewitemdisplayadquery = new ViewItemDisplayAdQuery();
        query = viewitemdisplayadquery;
        viewitemdisplayadquery.title = s;
        viewitemdisplayadquery.itemId = l;
        viewitemdisplayadquery.categoryId = s1;
        viewitemdisplayadquery.site = ebaysite;
        viewitemdisplayadquery.iafToken = s2;
        viewitemdisplayadquery.cguidPersister = ebaycguidpersister;
        viewitemdisplayadquery.adType = AdRequestType.DISPLAY;
        loadData(observer);
    }

    public void getViewItemPlaAds(String s, long l, String s1, EbayCguidPersister ebaycguidpersister, EbaySite ebaysite, String s2, 
            Observer observer)
    {
        ViewItemPlaAdQuery viewitemplaadquery = new ViewItemPlaAdQuery();
        query = viewitemplaadquery;
        viewitemplaadquery.title = s;
        viewitemplaadquery.itemId = l;
        viewitemplaadquery.site = ebaysite;
        viewitemplaadquery.iafToken = s2;
        viewitemplaadquery.cguidPersister = ebaycguidpersister;
        viewitemplaadquery.categoryId = s1;
        viewitemplaadquery.adType = AdRequestType.PLA;
        loadData(observer);
    }

    public void loadData(Observer observer)
    {
        if (query == null)
        {
            if (observer != null && lastResult != null && lastResultAdType == AdRequestType.NONE)
            {
                dispatchResult(lastResult, lastResultAdType);
            }
            return;
        } else
        {
            lastResult = null;
            lastResultAdType = null;
            executeOnThreadPool(new GetAdsLoadTask(query.adType), new AdQuery[] {
                query
            });
            return;
        }
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public void track(com.ebay.common.rtm.RtmContent.Ad ad, TrackableDictionary trackabledictionary)
    {
        if (ad == null || trackabledictionary == null || TextUtils.isEmpty(ad.trackingClickID) && ad.trackingURL == null)
        {
            return;
        } else
        {
            TrackAdsLoadTaskParams trackadsloadtaskparams = new TrackAdsLoadTaskParams();
            trackadsloadtaskparams.ad = ad;
            trackadsloadtaskparams.trackableDictionary = trackabledictionary;
            executeOnThreadPool(new TrackAdsLoadTask(), new TrackAdsLoadTaskParams[] {
                trackadsloadtaskparams
            });
            return;
        }
    }







/*
    static String access$902(String s)
    {
        anonCguid = s;
        return s;
    }

*/
}
