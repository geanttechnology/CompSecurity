// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.currency;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ebay.common.model.currency.CurrencyConversionRate;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.datamapping.ImmutableDataMapped;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.CacheLock;
import com.ebay.nautilus.kernel.util.DelayedAsyncTask;
import com.ebay.nautilus.kernel.util.SimpleMaker;
import com.ebay.nautilus.kernel.util.TimedCacheWallClock;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.ebay.common.net.api.currency:
//            CurrencyConversionRequest, CurrencyConversionResponse

public final class CurrencyConversionDataManager extends DataManager
{
    public static final class ConversionCacheKey extends ImmutableDataMapped
    {

        public final boolean bypassCache;
        public final String fromCurr;
        public final String toCurr;

        public ConversionCacheKey(String s, String s1, boolean flag)
        {
            if (s == null || s1 == null)
            {
                throw new IllegalArgumentException("Currencies must not be null");
            } else
            {
                fromCurr = s;
                toCurr = s1;
                bypassCache = flag;
                return;
            }
        }
    }

    protected static final class CurrencyCacheLock extends CacheLock
    {

        private volatile long _lastLoadTime;
        public volatile LoadState loadState;
        public volatile LoadTask loadTask;

        protected void setLoadTime()
        {
            _lastLoadTime = SystemClock.uptimeMillis();
        }

        protected long throttleTime()
        {
            long l = Math.min(CurrencyConversionDataManager.MIN_TIME_BEFORE_RETRY_TTL, (_lastLoadTime + CurrencyConversionDataManager.MIN_TIME_BEFORE_RETRY_TTL) - SystemClock.uptimeMillis());
            if (l > 0L && CurrencyConversionDataManager.logger.isLoggable)
            {
                CurrencyConversionDataManager.logger.log((new StringBuilder()).append("Throttle start of worker thread: ").append(l).toString());
            }
            return l;
        }

        protected CurrencyCacheLock()
        {
            loadState = LoadState.NEVER;
        }
    }

    protected static final class CurrencyCacheLock.LoadState extends Enum
    {

        private static final CurrencyCacheLock.LoadState $VALUES[];
        public static final CurrencyCacheLock.LoadState DONE;
        public static final CurrencyCacheLock.LoadState NEVER;
        public static final CurrencyCacheLock.LoadState PENDING;

        public static CurrencyCacheLock.LoadState valueOf(String s)
        {
            return (CurrencyCacheLock.LoadState)Enum.valueOf(com/ebay/common/net/api/currency/CurrencyConversionDataManager$CurrencyCacheLock$LoadState, s);
        }

        public static CurrencyCacheLock.LoadState[] values()
        {
            return (CurrencyCacheLock.LoadState[])$VALUES.clone();
        }

        static 
        {
            NEVER = new CurrencyCacheLock.LoadState("NEVER", 0);
            PENDING = new CurrencyCacheLock.LoadState("PENDING", 1);
            DONE = new CurrencyCacheLock.LoadState("DONE", 2);
            $VALUES = (new CurrencyCacheLock.LoadState[] {
                NEVER, PENDING, DONE
            });
        }

        private CurrencyCacheLock.LoadState(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class KeyParams extends com.ebay.nautilus.domain.content.DataManager.DataManagerKeyParams
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return CurrencyConversionDataManager.KEY;
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

        public CurrencyConversionDataManager createManager(EbayContext ebaycontext)
        {
            return new CurrencyConversionDataManager(ebaycontext, this);
        }

        public volatile DataManager createManager(EbayContext ebaycontext)
        {
            return createManager(ebaycontext);
        }


        protected KeyParams()
        {
        }
    }

    private final class LoadTask extends DelayedAsyncTask
    {

        public final ConversionCacheKey cacheKey;
        public final CurrencyCacheLock cacheLock;
        public final CurrencyConversionRequest.ConversionRequestParams conversionParams;
        public final Observer observer;
        final CurrencyConversionDataManager this$0;

        protected transient Content doInBackground(Void avoid[])
        {
            ResultStatus resultstatus;
            if (CurrencyConversionDataManager.logger.isLoggable)
            {
                CurrencyConversionDataManager.logger.log((new StringBuilder()).append("Calling currency conversion API for: ").append(conversionParams).toString());
            }
            ResultStatusOwner resultstatusowner = new ResultStatusOwner();
            avoid = (CurrencyConversionResponse)safeSendRequest(new CurrencyConversionRequest(conversionParams), resultstatusowner);
            resultstatus = resultstatusowner.getResultStatus();
            if (!CurrencyConversionDataManager.treatableAsError(resultstatus)) goto _L2; else goto _L1
_L1:
            if (CurrencyConversionDataManager.logger.isLoggable)
            {
                CurrencyConversionDataManager.logger.log((new StringBuilder()).append("Error from API, not caching result: ").append(resultstatus).toString());
            }
            avoid = new Content(null, resultstatus);
_L8:
            Object obj = cacheLock;
            obj;
            JVM INSTR monitorenter ;
            if (resultstatus != ResultStatus.CANCELED || cacheKey.bypassCache) goto _L4; else goto _L3
_L3:
            getCache().remove(cacheKey);
_L6:
            return avoid;
_L2:
            CurrencyConversionRate currencyconversionrate = ((CurrencyConversionResponse) (avoid)).currencyConversionRate;
            if (CurrencyConversionDataManager.logger.isLoggable)
            {
                CurrencyConversionDataManager.logger.log((new StringBuilder()).append("Successful rate conversion: ").append(currencyconversionrate).toString());
            }
            obj = new Content(currencyconversionrate, resultstatus);
            long l = updateCacheTimeout(cacheKey, currencyconversionrate);
            cacheLock.setData(obj);
            avoid = ((Void []) (obj));
            if (!cacheKey.bypassCache)
            {
                currencyconversionrate = currencyconversionrate.createReciprocalRate();
                avoid = ((Void []) (obj));
                if (currencyconversionrate != null)
                {
                    if (CurrencyConversionDataManager.logger.isLoggable)
                    {
                        CurrencyConversionDataManager.logger.log((new StringBuilder()).append("Reciprocal rate created: ").append(currencyconversionrate).toString());
                    }
                    avoid = new ConversionCacheKey(cacheKey.toCurr, cacheKey.fromCurr, false);
                    CurrencyCacheLock currencycachelock = new CurrencyCacheLock();
                    currencycachelock.loadState = CurrencyCacheLock.LoadState.DONE;
                    currencycachelock.setData(new Content(currencyconversionrate, resultstatus));
                    getCache().put(avoid, currencycachelock, l);
                    avoid = ((Void []) (obj));
                }
            }
            continue; /* Loop/switch isn't completed */
_L4:
            cacheLock.loadState = CurrencyCacheLock.LoadState.DONE;
            cacheLock.loadTask = null;
            cacheLock.setLoadTime();
            if (true) goto _L6; else goto _L5
_L5:
            avoid;
            obj;
            JVM INSTR monitorexit ;
            throw avoid;
            if (true) goto _L8; else goto _L7
_L7:
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            dispatchLoadComplete(observer, CurrencyConversionDataManager.CONTENT_CANCELED, conversionParams);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            dispatchLoadComplete(observer, content, conversionParams);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public LoadTask(Observer observer1, ConversionCacheKey conversioncachekey, CurrencyCacheLock currencycachelock, CurrencyConversionRequest.ConversionRequestParams conversionrequestparams)
        {
            this$0 = CurrencyConversionDataManager.this;
            super();
            observer = observer1;
            cacheKey = conversioncachekey;
            cacheLock = currencycachelock;
            conversionParams = conversionrequestparams;
        }
    }

    public static interface Observer
    {

        public abstract void onRateChanged(CurrencyConversionDataManager currencyconversiondatamanager, CurrencyConversionRate currencyconversionrate);

        public abstract void onRateLoadComplete(CurrencyConversionDataManager currencyconversiondatamanager, ResultStatus resultstatus, CurrencyConversionRate currencyconversionrate, CurrencyConversionRequest.ConversionRequestParams conversionrequestparams);
    }


    private static final long CACHE_ENTRY_LIFETIME;
    private static final Content CONTENT_CANCELED;
    private static final String CURRENCY_CONVERSION_SUB_DOMAIN = "BillingCurrencyRateService";
    public static final KeyParams KEY = new KeyParams();
    private static final int MAX_CACHE_ENTRIES = 300;
    private static final long MIN_TIME_BEFORE_RETRY_TTL;
    private static final long STALENESS_THRESHOLD;
    private static final TimedCacheWallClock _cache;
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("CurrencyConversion", 3, "Log currency conversion usage");

    private CurrencyConversionDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        super(ebaycontext, com/ebay/common/net/api/currency/CurrencyConversionDataManager$Observer);
    }


    private void attemptLoad(Observer observer, ConversionCacheKey conversioncachekey, CurrencyCacheLock currencycachelock, CurrencyConversionRequest.ConversionRequestParams conversionrequestparams)
    {
        currencycachelock;
        JVM INSTR monitorenter ;
        if (currencycachelock.loadState == CurrencyCacheLock.LoadState.DONE && isStale(getRate(currencycachelock)))
        {
            currencycachelock.loadState = CurrencyCacheLock.LoadState.NEVER;
        }
        if (currencycachelock.loadState == CurrencyCacheLock.LoadState.NEVER)
        {
            if (!conversionrequestparams.fromCurr.equals(conversionrequestparams.toCurr))
            {
                break MISSING_BLOCK_LABEL_150;
            }
            if (logger.isLoggable)
            {
                logger.log((new StringBuilder()).append("Converting to/from same currency: ").append(conversionrequestparams.fromCurr).toString());
            }
            CurrencyConversionRate currencyconversionrate = createReflexiveConversionRate(conversionrequestparams.fromCurr);
            Content content = new Content(currencyconversionrate);
            updateCacheTimeout(conversioncachekey, currencyconversionrate);
            currencycachelock.setData(content);
            currencycachelock.loadState = CurrencyCacheLock.LoadState.DONE;
            dispatchLoadComplete(observer, content, conversionrequestparams);
        }
_L2:
        currencycachelock;
        JVM INSTR monitorexit ;
        return;
        observer = new LoadTask(observer, conversioncachekey, currencycachelock, conversionrequestparams);
        currencycachelock.loadState = CurrencyCacheLock.LoadState.PENDING;
        currencycachelock.loadTask = observer;
        observer.executeDelayedTask(currencycachelock.throttleTime(), new Void[0]);
        if (true) goto _L2; else goto _L1
_L1:
        observer;
        currencycachelock;
        JVM INSTR monitorexit ;
        throw observer;
    }

    private CurrencyConversionRate createReflexiveConversionRate(String s)
    {
        try
        {
            s = new CurrencyConversionRate(System.currentTimeMillis(), "1.0", s, s, true);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    private void dispatchLoadComplete(Observer observer, Content content, CurrencyConversionRequest.ConversionRequestParams conversionrequestparams)
    {
        if (!treatableAsError(content.getStatus()))
        {
            if (logger.isLoggable)
            {
                logger.log((new StringBuilder()).append("onRateChanged: ").append(content.getData()).toString());
            }
            ((Observer)dispatcher).onRateChanged(this, (CurrencyConversionRate)content.getData());
        }
        if (observer != null)
        {
            if (logger.isLoggable)
            {
                logger.log((new StringBuilder()).append("onRateLoaded - status: ").append(content.getStatus()).append(", data: ").append(content.getData()).toString());
            }
            observer.onRateLoadComplete(this, content.getStatus(), (CurrencyConversionRate)content.getData(), conversionrequestparams);
        }
    }

    private long expiresAt(CurrencyConversionRate currencyconversionrate)
    {
        return currencyconversionrate.timeStamp + CACHE_ENTRY_LIFETIME;
    }

    private TimedCacheWallClock getCache()
    {
        return _cache;
    }

    private CurrencyConversionRate getRate(ConversionCacheKey conversioncachekey)
    {
        return getRate((CurrencyCacheLock)getCache().get(conversioncachekey));
    }

    private CurrencyConversionRate getRate(CurrencyCacheLock currencycachelock)
    {
        if (currencycachelock != null)
        {
            currencycachelock = (Content)currencycachelock.getData();
            if (currencycachelock != null)
            {
                return (CurrencyConversionRate)currencycachelock.getData();
            }
        }
        return null;
    }

    private boolean isStale(CurrencyConversionRate currencyconversionrate)
    {
        return currencyconversionrate == null || staleAt(currencyconversionrate) < System.currentTimeMillis();
    }

    private long staleAt(CurrencyConversionRate currencyconversionrate)
    {
        return currencyconversionrate.timeStamp + STALENESS_THRESHOLD;
    }

    static boolean treatableAsError(ResultStatus resultstatus)
    {
        boolean flag;
label0:
        {
            boolean flag1 = resultstatus.hasError();
            flag = flag1;
            if (!flag1)
            {
                break label0;
            }
            resultstatus = resultstatus.getMessages().iterator();
            Object obj;
            do
            {
                do
                {
                    flag = flag1;
                    if (!resultstatus.hasNext())
                    {
                        break label0;
                    }
                    obj = (com.ebay.nautilus.kernel.content.ResultStatus.Message)resultstatus.next();
                } while (!(obj instanceof com.ebay.nautilus.domain.net.EbayResponseError.LongDetails));
                obj = (com.ebay.nautilus.domain.net.EbayResponseError.LongDetails)obj;
            } while (!TextUtils.equals(((com.ebay.nautilus.domain.net.EbayResponseError.LongDetails) (obj)).subdomain, "BillingCurrencyRateService"));
            if (logger.isLoggable)
            {
                logger.log((new StringBuilder()).append("Error from currency conversion service not being treated as error: ").append(obj).toString());
            }
            flag = false;
        }
        return flag;
    }

    private long updateCacheTimeout(ConversionCacheKey conversioncachekey, CurrencyConversionRate currencyconversionrate)
    {
        long l = getCache().computeFutureTtl(expiresAt(currencyconversionrate), -1L);
        getCache().resetTimeout(conversioncachekey, l);
        return l;
    }

    public CurrencyConversionRate getConversionRate(CurrencyConversionRequest.ConversionRequestParams conversionrequestparams)
    {
        if (conversionrequestparams == null)
        {
            throw new IllegalArgumentException("conversionParams must not be null");
        }
        if (conversionrequestparams.historicalDate != null)
        {
            throw new IllegalArgumentException("HistoricalDate should be null for this call. Use loadConversionRate to bypass cache and fetch a specific historical rate conversion");
        } else
        {
            ConversionCacheKey conversioncachekey = new ConversionCacheKey(conversionrequestparams.fromCurr, conversionrequestparams.toCurr, false);
            CurrencyCacheLock currencycachelock = (CurrencyCacheLock)getCache().ensureValue(conversioncachekey);
            attemptLoad(null, conversioncachekey, currencycachelock, conversionrequestparams);
            return getRate(currencycachelock);
        }
    }

    public KeyParams getParams()
    {
        return KEY;
    }

    public volatile Object getParams()
    {
        return getParams();
    }

    public void loadConversionRate(Observer observer, CurrencyConversionRequest.ConversionRequestParams conversionrequestparams)
    {
        observer = (Observer)getSafeCallback(observer);
        boolean flag = conversionrequestparams.isHistorical();
        ConversionCacheKey conversioncachekey = new ConversionCacheKey(conversionrequestparams.fromCurr, conversionrequestparams.toCurr, flag);
        CurrencyCacheLock currencycachelock = new CurrencyCacheLock();
        if (!flag)
        {
            CurrencyCacheLock currencycachelock1 = (CurrencyCacheLock)getCache().get(conversioncachekey);
            if (currencycachelock1 != null)
            {
                currencycachelock.setData(currencycachelock1.getData());
            }
            getCache().put(conversioncachekey, currencycachelock);
        }
        attemptLoad(observer, conversioncachekey, currencycachelock, conversionrequestparams);
    }

    public void loadData(Observer observer)
    {
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public void reset()
    {
        getCache().clear();
    }

    public boolean willFetch(String s, String s1)
    {
        return isStale(getRate(new ConversionCacheKey(s, s1, false)));
    }

    static 
    {
        CONTENT_CANCELED = new Content(ResultStatus.CANCELED);
        MIN_TIME_BEFORE_RETRY_TTL = TimeUnit.SECONDS.toMillis(5L);
        STALENESS_THRESHOLD = TimeUnit.SECONDS.toMillis(0x15180L);
        CACHE_ENTRY_LIFETIME = STALENESS_THRESHOLD + STALENESS_THRESHOLD / 2L;
        _cache = new TimedCacheWallClock(300, CACHE_ENTRY_LIFETIME, new SimpleMaker() {

            public CurrencyCacheLock create()
            {
                return new CurrencyCacheLock();
            }

            public volatile Object create()
            {
                return create();
            }

        });
    }






}
