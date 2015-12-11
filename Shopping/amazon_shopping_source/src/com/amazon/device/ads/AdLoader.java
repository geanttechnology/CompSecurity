// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            AdSlot, AdvertisingIdentifier, AdError, AdRequest, 
//            AdData, StartUpWaiter, IAdLoaderCallback, Log, 
//            MetricsCollector, InternalAdRegistration, IInternalAdRegistration, Utils, 
//            AdTargetingOptions, AdWrapper, JSONUtils, AdSize, 
//            AdProperties, Assets, WebRequest, DebugProperties, 
//            ThreadUtils, Ad

class AdLoader
{
    protected class AdFetchException extends Exception
    {

        private static final long serialVersionUID = 1L;
        private final AdError adError;
        final AdLoader this$0;

        public AdError getAdError()
        {
            return adError;
        }

        public AdFetchException(AdError aderror)
        {
            this$0 = AdLoader.this;
            super();
            adError = aderror;
        }

        public AdFetchException(AdError aderror, Throwable throwable)
        {
            this$0 = AdLoader.this;
            super(throwable);
            adError = aderror;
        }
    }

    protected static class AdLoaderFactory
    {

        public AdLoader createAdLoader(AdRequest adrequest, Map map)
        {
            return new AdLoader(adrequest, map);
        }

        protected AdLoaderFactory()
        {
        }
    }

    protected static class AdReadyToLoadListener
    {

        private final AdSlot adSlots[];
        private final AdTargetingOptions requestOptions;
        private final int timeout;
        private final AtomicInteger waitCount;

        public void onAdReady(Ad ad)
        {
            AdLoader.decrementCount(timeout, waitCount, requestOptions, adSlots);
        }

        public transient AdReadyToLoadListener(int i, AtomicInteger atomicinteger, AdTargetingOptions adtargetingoptions, AdSlot aadslot[])
        {
            waitCount = atomicinteger;
            requestOptions = adtargetingoptions;
            adSlots = aadslot;
            timeout = i;
        }
    }


    public static final int AD_FAILED = -1;
    public static final int AD_NOT_READY = 1;
    public static final int AD_QUEUED = 0;
    protected static final String LOG_TAG = com/amazon/device/ads/AdLoader.getSimpleName();
    private static AdLoaderFactory adLoaderFactory = new AdLoaderFactory();
    protected final AdRequest adRequest;
    protected MetricsCollector.CompositeMetricsCollector compositeMetricsCollector;
    protected AdError error;
    protected final Map slots;
    protected int timeout;

    public AdLoader(AdRequest adrequest, Map map)
    {
        timeout = 20000;
        error = null;
        compositeMetricsCollector = null;
        adRequest = adrequest;
        slots = map;
    }

    protected static void adFailedToBeReady(int i, AtomicInteger atomicinteger, AdTargetingOptions adtargetingoptions, AdSlot aadslot[], int j)
    {
        aadslot[j].setSlotNumber(-1);
        decrementCount(i, atomicinteger, adtargetingoptions, aadslot);
    }

    private static void beginFetchAds(int i, AdTargetingOptions adtargetingoptions, AdSlot aadslot[])
    {
        Object obj = (new AdvertisingIdentifier()).getAdvertisingIdentifierInfo();
        if (!((AdvertisingIdentifier.Info) (obj)).canDo())
        {
            failAds(new AdError(AdError.ErrorCode.INTERNAL_ERROR, "An internal request was not made on a background thread."), aadslot);
        } else
        {
            adtargetingoptions = (new AdRequest(adtargetingoptions)).setAdvertisingIdentifierInfo(((AdvertisingIdentifier.Info) (obj)));
            obj = new HashMap();
            int k = aadslot.length;
            for (int j = 0; j < k; j++)
            {
                AdSlot adslot = aadslot[j];
                if (adslot.getSlotNumber() != -1)
                {
                    ((HashMap) (obj)).put(Integer.valueOf(adslot.getSlotNumber()), adslot);
                    adslot.getAdData().setSlotId(adslot.getSlotNumber());
                    adtargetingoptions.putSlot(adslot.getAdData(), adslot.getAdTargetingOptions());
                }
            }

            if (((HashMap) (obj)).size() > 0)
            {
                adtargetingoptions = adLoaderFactory.createAdLoader(adtargetingoptions, ((Map) (obj)));
                adtargetingoptions.setTimeout(i);
                adtargetingoptions.beginFetchAd();
                return;
            }
        }
    }

    private void beginFinalizeFetchAd()
    {
        (new Handler(Looper.getMainLooper())).post(new Runnable() {

            final AdLoader this$0;

            public void run()
            {
                finalizeFetchAd();
            }

            
            {
                this$0 = AdLoader.this;
                super();
            }
        });
    }

    protected static void decrementCount(int i, AtomicInteger atomicinteger, AdTargetingOptions adtargetingoptions, AdSlot aadslot[])
    {
        if (atomicinteger.decrementAndGet() == 0)
        {
            (new StartUpWaiter(i, adtargetingoptions, aadslot) {

                final AdSlot val$adSlots[];
                final AdTargetingOptions val$requestOptions;
                final int val$timeout;

                protected void startUpFailed()
                {
                    (new Handler(Looper.getMainLooper())).post(new Runnable() {

                        final _cls3 this$0;

                        public void run()
                        {
                            AdLoader.failAds(new AdError(AdError.ErrorCode.NETWORK_ERROR, "The configuration was unable to be loaded"), adSlots);
                        }

            
            {
                this$0 = _cls3.this;
                super();
            }
                    });
                }

                protected void startUpReady()
                {
                    InternalAdRegistration.getInstance().register();
                    AdLoader.beginFetchAds(timeout, requestOptions, adSlots);
                }

            
            {
                timeout = i;
                requestOptions = adtargetingoptions;
                adSlots = aadslot;
                super();
            }
            }).start();
        }
    }

    private static void failAds(AdError aderror, AdSlot aadslot[])
    {
        int j = 0;
        int l = aadslot.length;
        for (int i = 0; i < l;)
        {
            AdSlot adslot = aadslot[i];
            int k = j;
            if (adslot.getSlotNumber() != -1)
            {
                adslot.getAdLoaderCallback().adFailed(aderror);
                k = j + 1;
            }
            i++;
            j = k;
        }

        if (j > 0)
        {
            Log.w(LOG_TAG, "%s; code: %s", new Object[] {
                aderror.getMessage(), aderror.getCode()
            });
        }
    }

    private WebRequest getAdRequest()
        throws AdFetchException
    {
        getCompositeMetricsCollector().startMetric(Metrics.MetricType.AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL);
        WebRequest webrequest = adRequest.getWebRequest();
        getCompositeMetricsCollector().stopMetric(Metrics.MetricType.AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL);
        return webrequest;
    }

    private MetricsCollector getCompositeMetricsCollector()
    {
        if (compositeMetricsCollector == null)
        {
            ArrayList arraylist = new ArrayList();
            for (Iterator iterator = slots.entrySet().iterator(); iterator.hasNext(); arraylist.add(((AdSlot)((java.util.Map.Entry)iterator.next()).getValue()).getAdData().getMetricsCollector())) { }
            compositeMetricsCollector = new MetricsCollector.CompositeMetricsCollector(arraylist);
        }
        return compositeMetricsCollector;
    }

    private static boolean isNoRetry(AdSlot aadslot[])
    {
        int i = InternalAdRegistration.getInstance().getNoRetryTtlRemainingMillis();
        if (i > 0)
        {
            i /= 1000;
            Object obj;
            Object obj1;
            int j;
            if (InternalAdRegistration.getInstance().getIsAppDisabled())
            {
                obj1 = (new StringBuilder()).append("SDK Message: ").append(Utils.getDisabledAppServerMessage()).toString();
                obj = AdError.ErrorCode.INTERNAL_ERROR;
            } else
            {
                obj1 = (new StringBuilder()).append("SDK Message: ").append("no results. Try again in ").append(i).append(" seconds.").toString();
                obj = AdError.ErrorCode.NO_FILL;
            }
            Log.e(LOG_TAG, ((String) (obj1)));
            obj = new AdError(((AdError.ErrorCode) (obj)), ((String) (obj1)));
            j = aadslot.length;
            for (i = 0; i < j; i++)
            {
                obj1 = aadslot[i];
                if (((AdSlot) (obj1)).getAdData() != null && ((AdSlot) (obj1)).getAdData().getMetricsCollector() != null)
                {
                    ((AdSlot) (obj1)).getAdData().getMetricsCollector().incrementMetric(Metrics.MetricType.AD_COUNTER_FAILED_DUE_TO_NO_RETRY);
                }
                if (((AdSlot) (obj1)).getAdLoaderCallback() != null)
                {
                    ((AdSlot) (obj1)).getAdLoaderCallback().adFailed(((AdError) (obj)));
                }
            }

            return true;
        } else
        {
            return false;
        }
    }

    protected static transient boolean[] loadAds(int i, AdTargetingOptions adtargetingoptions, Ad aad[])
    {
        AdSlot aadslot[] = new AdSlot[aad.length];
        for (int j = 0; j < aad.length; j++)
        {
            aadslot[j] = new AdSlot(aad[j], new AdTargetingOptions());
        }

        return loadAds(i, adtargetingoptions, aadslot);
    }

    protected static transient boolean[] loadAds(int i, AdTargetingOptions adtargetingoptions, AdSlot aadslot[])
    {
        AdTargetingOptions adtargetingoptions1 = adtargetingoptions;
        if (adtargetingoptions == null)
        {
            adtargetingoptions1 = new AdTargetingOptions();
        }
        adtargetingoptions = new boolean[aadslot.length];
        if (isNoRetry(aadslot))
        {
            Arrays.fill(adtargetingoptions, true);
        } else
        {
            AtomicInteger atomicinteger = new AtomicInteger(aadslot.length);
            AdReadyToLoadListener adreadytoloadlistener = new AdReadyToLoadListener(i, atomicinteger, adtargetingoptions1, aadslot);
            int k = 0;
            int l = aadslot.length;
            int j = 0;
            while (j < l) 
            {
                AdSlot adslot = aadslot[j];
                adslot.setSlotNumber(k + 1);
                int i1 = adslot.getAdWrapper().prepareAd(adreadytoloadlistener);
                if (i1 != 0)
                {
                    adFailedToBeReady(i, atomicinteger, adtargetingoptions1, aadslot, k);
                    if (i1 == -1)
                    {
                        adtargetingoptions[k] = 0;
                    } else
                    {
                        adtargetingoptions[k] = 1;
                    }
                } else
                {
                    adtargetingoptions[k] = 1;
                }
                k++;
                j++;
            }
        }
        return adtargetingoptions;
    }

    private void parseResponse(JSONObject jsonobject)
    {
        AdError aderror;
        String s;
        HashSet hashset;
        Object obj;
        int j1;
        long l1;
        l1 = System.currentTimeMillis();
        obj = JSONUtils.getStringFromJSON(jsonobject, "status", null);
        hashset = new HashSet(slots.keySet());
        aderror = getAdError(jsonobject);
        s = JSONUtils.getStringFromJSON(jsonobject, "errorCode", "No Ad Received");
        adRequest.setInstrumentationPixelURL(JSONUtils.getStringFromJSON(jsonobject, "instrPixelURL", null));
        if (obj == null || !((String) (obj)).equals("ok"))
        {
            break MISSING_BLOCK_LABEL_634;
        }
        obj = JSONUtils.getJSONArrayFromJSON(jsonobject, "ads");
        j1 = 0;
_L2:
        JSONObject jsonobject1;
        if (j1 >= ((JSONArray) (obj)).length())
        {
            break MISSING_BLOCK_LABEL_634;
        }
        jsonobject1 = JSONUtils.getJSONObjectFromJSONArray(((JSONArray) (obj)), j1);
        if (jsonobject1 != null)
        {
            break; /* Loop/switch isn't completed */
        }
_L3:
        j1++;
        if (true) goto _L2; else goto _L1
_L1:
        AdSlot adslot;
        String s1;
        HashSet hashset1;
        JSONArray jsonarray;
        int i = JSONUtils.getIntegerFromJSON(jsonobject1, "slotId", -1);
        adslot = (AdSlot)slots.get(Integer.valueOf(i));
        if (adslot != null)
        {
label0:
            {
                hashset.remove(Integer.valueOf(i));
                jsonobject = JSONUtils.getStringFromJSON(jsonobject1, "instrPixelURL", adRequest.getInstrumentationPixelURL());
                adslot.getAdData().setInstrumentationPixelUrl(jsonobject);
                jsonobject = JSONUtils.getStringFromJSON(jsonobject1, "impPixelURL", null);
                adslot.getAdData().setImpressionPixelUrl(jsonobject);
                if (adslot.getAdData().getRequestedAdSize().isAuto())
                {
                    adslot.getAdData().getMetricsCollector().incrementMetric(Metrics.MetricType.AD_COUNTER_AUTO_AD_SIZE);
                }
                s1 = JSONUtils.getStringFromJSON(jsonobject1, "html", "");
                jsonarray = JSONUtils.getJSONArrayFromJSON(jsonobject1, "creativeTypes");
                hashset1 = new HashSet();
                if (jsonarray != null)
                {
                    for (int j = 0; j < jsonarray.length(); j++)
                    {
                        jsonobject = AdData.AAXCreative.getCreative(JSONUtils.getIntegerFromJSONArray(jsonarray, j, 0));
                        if (jsonobject != null)
                        {
                            hashset1.add(jsonobject);
                        }
                    }

                }
                if (!hashset1.isEmpty())
                {
                    break label0;
                }
                adslot.setAdError(new AdError(AdError.ErrorCode.INTERNAL_ERROR, "No valid creative types found"));
                Log.e(LOG_TAG, "No valid creative types found");
            }
        }
          goto _L3
        int k;
        int l;
        int i1;
        boolean flag;
        boolean flag2;
        jsonobject = JSONUtils.getStringFromJSON(jsonobject1, "size", "");
        i1 = 0;
        k = 0;
        boolean flag1 = false;
        l = 0;
        flag = false;
        if (hashset1.contains(AdData.AAXCreative.INTERSTITIAL))
        {
            break MISSING_BLOCK_LABEL_524;
        }
        flag2 = false;
        if (jsonobject != null)
        {
            jsonobject = jsonobject.split("x");
        } else
        {
            jsonobject = null;
        }
        if (jsonobject != null && jsonobject.length == 2) goto _L5; else goto _L4
_L4:
        i1 = 1;
        k = ((flag1) ? 1 : 0);
        l = ((flag) ? 1 : 0);
_L6:
        if (i1 == 0)
        {
            break MISSING_BLOCK_LABEL_524;
        }
        adslot.setAdError(new AdError(AdError.ErrorCode.INTERNAL_ERROR, "Server returned an invalid ad size"));
        Log.e(LOG_TAG, "Server returned an invalid ad size");
          goto _L3
_L5:
        k = i1;
        i1 = Integer.parseInt(jsonobject[0]);
        k = i1;
        l = Integer.parseInt(jsonobject[1]);
        k = i1;
        i1 = ((flag2) ? 1 : 0);
          goto _L6
        jsonobject;
        i1 = 1;
        l = ((flag) ? 1 : 0);
          goto _L6
        long l2 = JSONUtils.getLongFromJSON(jsonobject1, "cacheTTL", -1L);
        if (l2 > -1L)
        {
            adslot.getAdData().setExpirationTimeMillis(l1 + 1000L * l2);
        }
        jsonobject = new AdProperties(jsonarray);
        adslot.getAdData().setHeight(l);
        adslot.getAdData().setWidth(k);
        adslot.getAdData().setCreative(s1);
        adslot.getAdData().setCreativeTypes(hashset1);
        adslot.getAdData().setProperties(jsonobject);
        adslot.getAdData().setFetched(true);
          goto _L3
        for (jsonobject = hashset.iterator(); jsonobject.hasNext(); Log.w(LOG_TAG, "%s; code: %s", new Object[] {
    aderror.getMessage(), s
}))
        {
            Integer integer = (Integer)jsonobject.next();
            ((AdSlot)slots.get(integer)).setAdError(aderror);
            ((AdSlot)slots.get(integer)).getAdData().setInstrumentationPixelUrl(adRequest.getInstrumentationPixelURL());
        }

        return;
    }

    protected static void setAdLoaderFactory(AdLoaderFactory adloaderfactory)
    {
        adLoaderFactory = adloaderfactory;
    }

    private void setErrorForAllSlots(AdError aderror)
    {
        for (Iterator iterator = slots.values().iterator(); iterator.hasNext(); ((AdSlot)iterator.next()).setAdError(aderror)) { }
    }

    public void beginFetchAd()
    {
        getCompositeMetricsCollector().stopMetric(Metrics.MetricType.AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START);
        getCompositeMetricsCollector().startMetric(Metrics.MetricType.AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP);
        startFetchAdThread();
    }

    protected void fetchAd()
    {
        getCompositeMetricsCollector().stopMetric(Metrics.MetricType.AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP);
        getCompositeMetricsCollector().startMetric(Metrics.MetricType.AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START);
        if (!Assets.getInstance().ensureAssetsCreated())
        {
            error = new AdError(AdError.ErrorCode.REQUEST_ERROR, "Unable to create the assets needed to display ads");
            Log.e(LOG_TAG, "Unable to create the assets needed to display ads");
            setErrorForAllSlots(error);
            return;
        }
        Object obj;
        try
        {
            obj = fetchResponseFromNetwork();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            error = ((AdFetchException) (obj)).getAdError();
            Log.e(LOG_TAG, ((AdFetchException) (obj)).getAdError().getMessage());
            setErrorForAllSlots(error);
            return;
        }
        if (!((WebRequest.WebResponse) (obj)).isHttpStatusCodeOK())
        {
            obj = (new StringBuilder()).append(((WebRequest.WebResponse) (obj)).getHttpStatusCode()).append(" - ").append(((WebRequest.WebResponse) (obj)).getHttpStatus()).toString();
            error = new AdError(AdError.ErrorCode.NETWORK_ERROR, ((String) (obj)));
            Log.e(LOG_TAG, ((String) (obj)));
            setErrorForAllSlots(error);
            return;
        }
        obj = ((WebRequest.WebResponse) (obj)).getJSONObjectBody();
        if (obj == null)
        {
            error = new AdError(AdError.ErrorCode.INTERNAL_ERROR, "Unable to parse response");
            Log.e(LOG_TAG, "Unable to parse response");
            setErrorForAllSlots(error);
            return;
        } else
        {
            parseResponse(((JSONObject) (obj)));
            getCompositeMetricsCollector().stopMetric(Metrics.MetricType.AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END);
            getCompositeMetricsCollector().startMetric(Metrics.MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP);
            return;
        }
    }

    protected WebRequest.WebResponse fetchResponseFromNetwork()
        throws AdFetchException
    {
        Object obj = getAdRequest();
        ((WebRequest) (obj)).setMetricsCollector(getCompositeMetricsCollector());
        ((WebRequest) (obj)).setServiceCallLatencyMetric(Metrics.MetricType.AAX_LATENCY_GET_AD);
        ((WebRequest) (obj)).setTimeout(timeout);
        getCompositeMetricsCollector().stopMetric(Metrics.MetricType.AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START);
        getCompositeMetricsCollector().incrementMetric(Metrics.MetricType.TLS_ENABLED);
        try
        {
            obj = ((WebRequest) (obj)).makeCall();
        }
        catch (Object obj1)
        {
            if (((WebRequest.WebRequestException) (obj1)).getStatus() == WebRequest.WebRequestStatus.NETWORK_FAILURE)
            {
                obj1 = new AdError(AdError.ErrorCode.NETWORK_ERROR, "Could not contact Ad Server");
            } else
            if (((WebRequest.WebRequestException) (obj1)).getStatus() == WebRequest.WebRequestStatus.NETWORK_TIMEOUT)
            {
                obj1 = new AdError(AdError.ErrorCode.NETWORK_TIMEOUT, "Connection to Ad Server timed out");
            } else
            {
                obj1 = new AdError(AdError.ErrorCode.INTERNAL_ERROR, ((WebRequest.WebRequestException) (obj1)).getMessage());
            }
            throw new AdFetchException(((AdError) (obj1)));
        }
        getCompositeMetricsCollector().startMetric(Metrics.MetricType.AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END);
        return ((WebRequest.WebResponse) (obj));
    }

    protected void finalizeFetchAd()
    {
        for (Iterator iterator = slots.entrySet().iterator(); iterator.hasNext();)
        {
            AdSlot adslot = (AdSlot)((java.util.Map.Entry)iterator.next()).getValue();
            IAdLoaderCallback iadloadercallback = adslot.getAdLoaderCallback();
            AdData addata = adslot.getAdData();
            addata.getMetricsCollector().stopMetric(Metrics.MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP);
            if (!addata.getIsFetched())
            {
                addata.getMetricsCollector().startMetric(Metrics.MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE);
                if (adslot.getAdError() != null)
                {
                    iadloadercallback.adFailed(adslot.getAdError());
                } else
                {
                    iadloadercallback.adFailed(new AdError(AdError.ErrorCode.INTERNAL_ERROR, "Unknown error occurred."));
                }
            } else
            {
                addata.getMetricsCollector().startMetric(Metrics.MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START);
                iadloadercallback.handleResponse();
            }
        }

    }

    protected AdError getAdError(JSONObject jsonobject)
    {
        int i = retrieveNoRetryTtlSeconds(jsonobject);
        InternalAdRegistration.getInstance().setNoRetryTtl(i);
        jsonobject = JSONUtils.getStringFromJSON(jsonobject, "errorMessage", "No Ad Received");
        InternalAdRegistration.getInstance().setIsAppDisabled(jsonobject.equalsIgnoreCase(Utils.getDisabledAppServerMessage()));
        String s = (new StringBuilder()).append("Server Message: ").append(jsonobject).toString();
        if (i > 0)
        {
            getCompositeMetricsCollector().publishMetricInMilliseconds(Metrics.MetricType.AD_NO_RETRY_TTL_RECEIVED, i * 1000);
        }
        if (i > 0 && !InternalAdRegistration.getInstance().getIsAppDisabled())
        {
            jsonobject = (new StringBuilder()).append(s).append(". Try again in ").append(i).append(" seconds").toString();
            return new AdError(AdError.ErrorCode.NO_FILL, jsonobject);
        }
        if (jsonobject.equals("no results"))
        {
            return new AdError(AdError.ErrorCode.NO_FILL, s);
        } else
        {
            return new AdError(AdError.ErrorCode.INTERNAL_ERROR, s);
        }
    }

    protected int retrieveNoRetryTtlSeconds(JSONObject jsonobject)
    {
        return DebugProperties.getDebugPropertyAsInteger("debug.noRetryTTL", JSONUtils.getIntegerFromJSON(jsonobject, "noretryTTL", 0));
    }

    public void setTimeout(int i)
    {
        timeout = i;
    }

    protected void startFetchAdThread()
    {
        ThreadUtils.executeRunnable(new Runnable() {

            final AdLoader this$0;

            public void run()
            {
                fetchAd();
                beginFinalizeFetchAd();
            }

            
            {
                this$0 = AdLoader.this;
                super();
            }
        });
    }




}
