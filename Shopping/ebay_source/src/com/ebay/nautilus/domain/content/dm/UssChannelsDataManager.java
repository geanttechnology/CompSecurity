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
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelsContainer;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.gson.EbayDateAdapter;
import com.ebay.nautilus.domain.net.api.unifiedstream.UssChannelsRequest;
import com.ebay.nautilus.domain.net.api.unifiedstream.UssChannelsResponse;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.cachemanager.JsonPersistenceMapper;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.FwLog;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UserContextObservingDataManager, UserContextDataManager

public class UssChannelsDataManager extends UserContextObservingDataManager
{
    private static final class ChannelsCacheRecord extends BaseDataMapped
    {

        public final ChannelsContainer channelsContainer;
        public long ttl;

        public boolean isStale()
        {
            return System.currentTimeMillis() > ttl;
        }

        public ChannelsCacheRecord(Content content)
        {
            channelsContainer = (ChannelsContainer)content.getData();
            ttl = System.currentTimeMillis() + 0xdbba0L;
            if (Log.isLoggable("UssChannelsDmTtl", 3))
            {
                ttl = System.currentTimeMillis() + 0x927c0L;
                UssChannelsDataManager.logger.log("overriding TTL to ten minutes");
            }
        }
    }

    private final class ConsultCacheTask extends AsyncTask
    {

        private final Authentication auth;
        private final EbayCountry country;
        private final ArrayList observers = new ArrayList();
        final UssChannelsDataManager this$0;

        public void attach(Observer observer)
        {
            if (observer != null)
            {
                observers.add(observer);
            }
        }

        protected transient ChannelsCacheRecord doInBackground(Void avoid[])
        {
            avoid = null;
            String s = getCacheKey(auth, country.getSite().id);
            if (s != null)
            {
                if (UssChannelsDataManager.logger.isLoggable)
                {
                    UssChannelsDataManager.logger.log((new StringBuilder()).append("cache lookup ").append(s).toString());
                }
                avoid = (ChannelsCacheRecord)UssChannelsDataManager.cacheManager.get(s);
            } else
            if (UssChannelsDataManager.logger.isLoggable)
            {
                UssChannelsDataManager.logger.log("lookup aborted, invalid key");
                return null;
            }
            return avoid;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onPostExecute(ChannelsCacheRecord channelscacherecord)
        {
            super.onPostExecute(channelscacherecord);
            if (channelscacherecord != null && flushCacheTask == null) goto _L2; else goto _L1
_L1:
            if (UssChannelsDataManager.logger.isLoggable)
            {
                UssChannelsDataManager.logger.log("cache miss, forcing update");
            }
            if (loadTask == null)
            {
                getContentsAsync(auth, country);
            } else
            if (UssChannelsDataManager.logger.isLoggable)
            {
                UssChannelsDataManager.logger.log("aborting update, already in progress");
            }
_L4:
            consultCacheTask = null;
            return;
_L2:
            if (!channelscacherecord.isStale())
            {
                break; /* Loop/switch isn't completed */
            }
            if (UssChannelsDataManager.logger.isLoggable)
            {
                UssChannelsDataManager.logger.log("cache hit but entry is stale, forcing update");
            }
            if (loadTask == null)
            {
                getContentsAsync(auth, country);
            } else
            if (UssChannelsDataManager.logger.isLoggable)
            {
                UssChannelsDataManager.logger.log("aborting update, already in progress");
            }
_L6:
            handleLoadDataResult(new Content(channelscacherecord.channelsContainer), observers);
            if (true) goto _L4; else goto _L3
_L3:
            if (!UssChannelsDataManager.logger.isLoggable) goto _L6; else goto _L5
_L5:
            UssChannelsDataManager.logger.log("cache hit");
              goto _L6
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ChannelsCacheRecord)obj);
        }

        protected ConsultCacheTask(Authentication authentication, EbayCountry ebaycountry, Observer observer)
        {
            this$0 = UssChannelsDataManager.this;
            super();
            auth = authentication;
            country = ebaycountry;
            if (observer != null)
            {
                observers.add(observer);
            }
        }
    }

    private final class FlushCacheTask extends AsyncTask
    {

        private final Authentication auth;
        private final EbayCountry country;
        final UssChannelsDataManager this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            UssChannelsDataManager.cacheManager.remove(getCacheKey(auth, country.getSite().id));
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

        public FlushCacheTask(Authentication authentication, EbayCountry ebaycountry)
        {
            this$0 = UssChannelsDataManager.this;
            super();
            auth = authentication;
            country = ebaycountry;
        }
    }

    public static final class KeyParams extends UserContextObservingDataManager.KeyBase
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return UssChannelsDataManager.KEY;
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

        protected UssChannelsDataManager create(EbayContext ebaycontext)
        {
            return new UssChannelsDataManager(ebaycontext, this);
        }

        public boolean equals(Object obj)
        {
            return obj instanceof KeyParams;
        }

        public String toString()
        {
            return "UssChannelsDataManager.KEY";
        }


        public KeyParams()
        {
        }
    }

    private final class LoadTask extends AsyncTask
    {

        private final Authentication auth;
        private final EbayCountry country;
        UssChannelsResponse response;
        final UssChannelsDataManager this$0;

        protected transient Content doInBackground(Void avoid[])
        {
            Object obj;
            obj = UssChannelsDataManager.this;
            if (auth == null)
            {
                break MISSING_BLOCK_LABEL_138;
            }
            avoid = auth.iafToken;
_L1:
            response = (UssChannelsResponse)((UssChannelsDataManager) (obj)).sendRequest(new UssChannelsRequest(avoid, country));
            avoid = response.getResultStatus();
            if (avoid.hasError())
            {
                return new Content(avoid);
            }
            obj = new Content(response.container, avoid);
            avoid = ((Void []) (obj));
            if (response.container == null)
            {
                break MISSING_BLOCK_LABEL_136;
            }
            UssChannelsDataManager.cacheManager.put(getCacheKey(auth, country.getSite().id), new ChannelsCacheRecord(((Content) (obj))));
            return ((Content) (obj));
            avoid;
            avoid = null;
            return avoid;
            avoid = null;
              goto _L1
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleLoadDataResult(null, null);
            loadTask = null;
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleLoadDataResult(content, null);
            loadTask = null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public LoadTask(Authentication authentication, EbayCountry ebaycountry)
        {
            this$0 = UssChannelsDataManager.this;
            super();
            country = ebaycountry;
            auth = authentication;
        }
    }

    public static interface Observer
    {

        public abstract void onChannelsChanged(UssChannelsDataManager usschannelsdatamanager, Content content, EbayCountry ebaycountry);
    }


    private static final String CACHE_KEY_PREFIX = "uss_channels";
    public static final KeyParams KEY = new KeyParams();
    private static final int MAX_CACHE_ENTRIES = 3;
    private static final long MAX_CACHE_TTL = 0x240c8400L;
    protected static final long STALE_TTL = 0xdbba0L;
    protected static CacheManager cacheManager;
    static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("UssChannelsDm", 3, "UnifiedStream Channels DataManager");
    protected ConsultCacheTask consultCacheTask;
    protected FlushCacheTask flushCacheTask;
    private boolean isCountryInitialized;
    private boolean isUserInitialized;
    protected LoadTask loadTask;

    UssChannelsDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        super(ebaycontext, com/ebay/nautilus/domain/content/dm/UssChannelsDataManager$Observer, keyparams);
        isUserInitialized = false;
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
            cacheManager = new CacheManager((Context)ebaycontext.getExtension(android/content/Context), JsonPersistenceMapper.create(keyparams), com/ebay/nautilus/domain/content/dm/UssChannelsDataManager$ChannelsCacheRecord, "ussChannelsCache", 3, 3, 3L, 0x240c8400L, true);
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

    public void flush()
    {
        NautilusKernel.verifyMain();
        cancelTasks(true);
        if (flushCacheTask == null)
        {
            FlushCacheTask flushcachetask = new FlushCacheTask(getCurrentUser(), getCurrentCountry());
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

    protected String getCacheKey(Authentication authentication, String s)
    {
        String s1;
        if (authentication != null)
        {
            authentication = authentication.user;
        } else
        {
            authentication = "anon";
        }
        if (s == null)
        {
            s = "unknown";
        }
        s1 = UssChannelsRequest.getLocaleList();
        return (new StringBuilder()).append("uss_channels-").append(authentication).append("-").append(s).append("-").append(s1).append("-").append(((KeyParams)getParams()).toString()).toString();
    }

    protected void getContentsAsync(Authentication authentication, EbayCountry ebaycountry)
    {
        NautilusKernel.verifyMain();
        if (loadTask == null)
        {
            authentication = new LoadTask(authentication, ebaycountry);
            loadTask = authentication;
            executeOnThreadPool(authentication, new Void[0]);
        }
    }

    protected void handleLoadDataResult(Content content, List list)
    {
        if (content != null)
        {
            if (list != null && list.size() > 0)
            {
                int i = 0;
                while (i < list.size()) 
                {
                    ((Observer)list.get(i)).onChannelsChanged(this, content, getCurrentCountry());
                    i++;
                }
            } else
            {
                ((Observer)dispatcher).onChannelsChanged(this, content, getCurrentCountry());
                return;
            }
        }
    }

    public void invalidateAndForceReloadData()
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
        flush();
        loadData(((Observer) (null)));
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
            consultCacheTask.attach(observer);
            return;
        }
        EbayCountry ebaycountry = getCurrentCountry();
        if (ebaycountry == null)
        {
            throw new IllegalStateException("getCurrentCountry() returned null");
        } else
        {
            consultCacheTask = new ConsultCacheTask(getCurrentUser(), ebaycountry, observer);
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
            invalidateAndForceReloadData();
            return;
        }
    }

    public void onCurrentUserChanged(UserContextDataManager usercontextdatamanager, String s, String s1, boolean flag)
    {
        if (logger.isLoggable)
        {
            FwLog.logMethod(logger, new Object[] {
                usercontextdatamanager, s, s1, Boolean.valueOf(flag)
            });
        }
        super.onCurrentUserChanged(usercontextdatamanager, s, s1, flag);
        if (!isUserInitialized)
        {
            isUserInitialized = true;
        } else
        if (!flag)
        {
            invalidateAndForceReloadData();
            return;
        }
    }

    protected void onLastObserverUnregistered()
    {
        cancelTasks(false);
    }


}
