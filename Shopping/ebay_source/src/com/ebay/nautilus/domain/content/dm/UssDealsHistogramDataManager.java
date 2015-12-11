// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.UnifiedStream.SearchRefinement;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.gson.EbayDateAdapter;
import com.ebay.nautilus.domain.net.api.unifiedstream.UssDealsHistogramRequest;
import com.ebay.nautilus.domain.net.api.unifiedstream.UssDealsHistogramResponse;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.cachemanager.JsonPersistenceMapper;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.FwLog;
import com.google.gson.GsonBuilder;
import java.util.Date;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UserContextObservingDataManager, UserContextDataManager

public class UssDealsHistogramDataManager extends UserContextObservingDataManager
{
    private final class ConsultCacheTask extends AsyncTask
    {

        private final EbayCountry country;
        final UssDealsHistogramDataManager this$0;

        protected transient DealsHistogramCacheRecord doInBackground(Void avoid[])
        {
            avoid = null;
            String s = getCacheKey(country.getSite().id);
            if (s != null)
            {
                if (UssDealsHistogramDataManager.logger.isLoggable)
                {
                    UssDealsHistogramDataManager.logger.log((new StringBuilder()).append("cache lookup ").append(s).toString());
                }
                avoid = (DealsHistogramCacheRecord)UssDealsHistogramDataManager.cacheManager.get(s);
            } else
            if (UssDealsHistogramDataManager.logger.isLoggable)
            {
                UssDealsHistogramDataManager.logger.log("lookup aborted, invalid key");
                return null;
            }
            return avoid;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onPostExecute(DealsHistogramCacheRecord dealshistogramcacherecord)
        {
            super.onPostExecute(dealshistogramcacherecord);
            if (dealshistogramcacherecord != null && flushCacheTask == null) goto _L2; else goto _L1
_L1:
            if (UssDealsHistogramDataManager.logger.isLoggable)
            {
                UssDealsHistogramDataManager.logger.log("cache miss, forcing update");
            }
            if (loadTask == null)
            {
                getContentsAsync(country);
            } else
            if (UssDealsHistogramDataManager.logger.isLoggable)
            {
                UssDealsHistogramDataManager.logger.log("aborting update, already in progress");
            }
_L4:
            consultCacheTask = null;
            return;
_L2:
            if (!dealshistogramcacherecord.isStale())
            {
                break; /* Loop/switch isn't completed */
            }
            if (UssDealsHistogramDataManager.logger.isLoggable)
            {
                UssDealsHistogramDataManager.logger.log("cache hit but entry is stale, forcing update");
            }
            if (loadTask == null)
            {
                getContentsAsync(country);
            } else
            if (UssDealsHistogramDataManager.logger.isLoggable)
            {
                UssDealsHistogramDataManager.logger.log("aborting update, already in progress");
            }
_L6:
            handleLoadDataResult(new Content(dealshistogramcacherecord.searchRefinement));
            if (true) goto _L4; else goto _L3
_L3:
            if (!UssDealsHistogramDataManager.logger.isLoggable) goto _L6; else goto _L5
_L5:
            UssDealsHistogramDataManager.logger.log("cache hit");
              goto _L6
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((DealsHistogramCacheRecord)obj);
        }

        protected ConsultCacheTask(EbayCountry ebaycountry)
        {
            this$0 = UssDealsHistogramDataManager.this;
            super();
            country = ebaycountry;
        }
    }

    private static final class DealsHistogramCacheRecord extends BaseDataMapped
    {

        public final SearchRefinement searchRefinement;
        public long ttl;

        public boolean isStale()
        {
            return System.currentTimeMillis() > ttl;
        }

        public DealsHistogramCacheRecord(Content content)
        {
            searchRefinement = (SearchRefinement)content.getData();
            ttl = System.currentTimeMillis() + 0x5265c00L;
            if (Log.isLoggable("UssDealsHistogramDmTtl", 3))
            {
                ttl = System.currentTimeMillis() + 0x927c0L;
                UssDealsHistogramDataManager.logger.log("overriding TTL to ten minutes");
            }
        }
    }

    private final class FlushCacheTask extends AsyncTask
    {

        final UssDealsHistogramDataManager this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            UssDealsHistogramDataManager.cacheManager.clear();
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            flushCacheTask = null;
        }

        private FlushCacheTask()
        {
            this$0 = UssDealsHistogramDataManager.this;
            super();
        }

    }

    public static final class KeyParams extends UserContextObservingDataManager.KeyBase
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return UssDealsHistogramDataManager.KEY;
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

        protected volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        protected UssDealsHistogramDataManager create(EbayContext ebaycontext)
        {
            return new UssDealsHistogramDataManager(ebaycontext, this);
        }

        public boolean equals(Object obj)
        {
            return obj instanceof KeyParams;
        }

        public String toString()
        {
            return "UssDealsHistogramDataManager.KEY";
        }


        public KeyParams()
        {
        }
    }

    private final class LoadTask extends AsyncTask
    {

        private final EbayCountry country;
        UssDealsHistogramResponse response;
        final UssDealsHistogramDataManager this$0;

        protected transient Content doInBackground(Void avoid[])
        {
            try
            {
                response = (UssDealsHistogramResponse)sendRequest(new UssDealsHistogramRequest(country));
                avoid = response.getResultStatus();
                if (avoid.hasError())
                {
                    return new Content(avoid);
                }
                avoid = new Content(response.container.searchRefinement, avoid);
                UssDealsHistogramDataManager.cacheManager.put(getCacheKey(country.getSite().id), new DealsHistogramCacheRecord(avoid));
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return null;
            }
            return avoid;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleLoadDataResult(null);
            loadTask = null;
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleLoadDataResult(content);
            loadTask = null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public LoadTask(EbayCountry ebaycountry)
        {
            this$0 = UssDealsHistogramDataManager.this;
            super();
            country = ebaycountry;
        }
    }

    public static interface Observer
    {

        public abstract void onDealsHistogramChanged(UssDealsHistogramDataManager ussdealshistogramdatamanager, Content content);
    }


    private static final String CACHE_KEY_PREFIX = "uss_deals_histogram";
    public static final KeyParams KEY = new KeyParams();
    private static final int MAX_CACHE_ENTRIES = 3;
    private static final long MAX_CACHE_TTL = 0x240c8400L;
    private static final long STALE_TTL = 0x5265c00L;
    private static CacheManager cacheManager;
    static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("UssDealsHistogramDm", 3, "UnifiedStream Deals Histogram DataManager");
    private ConsultCacheTask consultCacheTask;
    private FlushCacheTask flushCacheTask;
    private boolean isCountryInitialized;
    private LoadTask loadTask;

    UssDealsHistogramDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        super(ebaycontext, com/ebay/nautilus/domain/content/dm/UssDealsHistogramDataManager$Observer, keyparams);
        isCountryInitialized = false;
        if (logger.isLoggable)
        {
            FwLog.logMethod(logger, new Object[] {
                keyparams
            });
        }
        if (cacheManager == null)
        {
            if (logger.isLoggable)
            {
                logger.log("Instantiating Cache Manager");
            }
            keyparams = (new GsonBuilder()).registerTypeAdapter(java/util/Date, new EbayDateAdapter()).create();
            cacheManager = new CacheManager((Context)ebaycontext.getExtension(android/content/Context), JsonPersistenceMapper.create(keyparams), com/ebay/nautilus/domain/content/dm/UssDealsHistogramDataManager$DealsHistogramCacheRecord, "ussDealsHistogramCache", 3, 3, 3L, 0x240c8400L, true);
        }
    }

    private void cancelTasks(boolean flag)
    {
        if (consultCacheTask != null)
        {
            consultCacheTask.cancel(true);
            consultCacheTask = null;
        }
        if (loadTask != null)
        {
            loadTask.cancel(true);
            loadTask = null;
        }
        if (!flag && flushCacheTask != null)
        {
            flushCacheTask.cancel(true);
            flushCacheTask = null;
        }
    }

    private String getCacheKey(String s)
    {
        if (s == null)
        {
            s = "unknown";
        }
        return (new StringBuilder()).append("uss_deals_histogram-").append(s).append("-").append(((KeyParams)getParams()).toString()).toString();
    }

    public void flush()
    {
        NautilusKernel.verifyMain();
        cancelTasks(true);
        if (flushCacheTask == null)
        {
            FlushCacheTask flushcachetask = new FlushCacheTask();
            flushCacheTask = flushcachetask;
            executeOnThreadPool(flushcachetask, new Void[0]);
            if (logger.isLoggable)
            {
                logger.log("flushing cache");
            }
        }
    }

    public void forceReloadData()
    {
        if (logger.isLoggable)
        {
            FwLog.logMethod(logger, new Object[0]);
        }
        if (loadTask != null)
        {
            loadTask.cancel(true);
            loadTask = null;
        }
        if (consultCacheTask != null)
        {
            consultCacheTask.cancel(true);
            consultCacheTask = null;
        }
        loadData(((Observer) (null)));
    }

    protected void getContentsAsync(EbayCountry ebaycountry)
    {
        NautilusKernel.verifyMain();
        if (loadTask == null)
        {
            ebaycountry = new LoadTask(ebaycountry);
            loadTask = ebaycountry;
            executeOnThreadPool(ebaycountry, new Void[0]);
        }
    }

    protected void handleLoadDataResult(Content content)
    {
        if (content == null)
        {
            return;
        } else
        {
            ((Observer)dispatcher).onDealsHistogramChanged(this, content);
            return;
        }
    }

    public void loadData(Observer observer)
    {
        if (logger.isLoggable)
        {
            FwLog.logMethod(logger, new Object[] {
                observer
            });
        }
        NautilusKernel.verifyMain();
        if (consultCacheTask != null)
        {
            return;
        }
        observer = getCurrentCountry();
        if (observer == null)
        {
            throw new IllegalStateException("getCurrentCountry() returned null");
        } else
        {
            consultCacheTask = new ConsultCacheTask(observer);
            executeOnThreadPool(consultCacheTask, new Void[0]);
            return;
        }
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public void onCurrentCountryChanged(UserContextDataManager usercontextdatamanager, EbayCountry ebaycountry)
    {
        if (logger.isLoggable)
        {
            FwLog.logMethod(logger, new Object[] {
                usercontextdatamanager, ebaycountry
            });
        }
        super.onCurrentCountryChanged(usercontextdatamanager, ebaycountry);
        if (!isCountryInitialized)
        {
            isCountryInitialized = true;
            return;
        } else
        {
            forceReloadData();
            return;
        }
    }

    protected void onLastObserverUnregistered()
    {
        cancelTasks(false);
    }







/*
    static LoadTask access$402(UssDealsHistogramDataManager ussdealshistogramdatamanager, LoadTask loadtask)
    {
        ussdealshistogramdatamanager.loadTask = loadtask;
        return loadtask;
    }

*/



/*
    static FlushCacheTask access$502(UssDealsHistogramDataManager ussdealshistogramdatamanager, FlushCacheTask flushcachetask)
    {
        ussdealshistogramdatamanager.flushCacheTask = flushcachetask;
        return flushcachetask;
    }

*/


/*
    static ConsultCacheTask access$602(UssDealsHistogramDataManager ussdealshistogramdatamanager, ConsultCacheTask consultcachetask)
    {
        ussdealshistogramdatamanager.consultCacheTask = consultcachetask;
        return consultcachetask;
    }

*/
}
