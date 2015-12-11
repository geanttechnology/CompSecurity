// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentTypeEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.Contents;
import com.ebay.nautilus.domain.data.UnifiedStream.KeyValue;
import com.ebay.nautilus.domain.data.UnifiedStream.OutputSelector;
import com.ebay.nautilus.domain.data.UnifiedStream.Pagination;
import com.ebay.nautilus.domain.data.UnifiedStream.PaginationInput;
import com.ebay.nautilus.domain.data.UnifiedStream.RequestContext;
import com.ebay.nautilus.domain.data.UnifiedStream.RtmInfo;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.gson.EbayDateAdapter;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.api.unifiedstream.UnifiedStreamRequest;
import com.ebay.nautilus.domain.net.api.unifiedstream.UnifiedStreamResponse;
import com.ebay.nautilus.domain.net.api.unifiedstream.UssDealDetailsRequest;
import com.ebay.nautilus.domain.net.api.unifiedstream.UssListOfListingsResponse;
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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UserContextObservingDataManager, UssUtil, UserContextDataManager

public final class UssContentsDataManager extends UserContextObservingDataManager
{
    private final class ConsultCacheTask extends AsyncTask
    {

        private final Authentication auth;
        private ArrayList contentSources;
        private final EbayCountry country;
        private final ArrayList observers = new ArrayList();
        final UssContentsDataManager this$0;

        public transient void attach(Observer observer, ContentSourceEnum acontentsourceenum[])
        {
label0:
            {
                if (observer != null)
                {
                    observers.add(observer);
                }
                if (contentSources != null)
                {
                    if (acontentsourceenum != null && acontentsourceenum.length != 0)
                    {
                        break label0;
                    }
                    contentSources = null;
                }
                return;
            }
            contentSources.addAll(Arrays.asList(acontentsourceenum));
        }

        protected transient ContentsCacheRecord doInBackground(Void avoid[])
        {
            avoid = null;
            String s = getCacheKey(auth, country.getSite().id);
            if (s != null)
            {
                if (UssContentsDataManager.logger.isLoggable)
                {
                    UssContentsDataManager.logger.log((new StringBuilder()).append("cache lookup ").append(s).toString());
                }
                avoid = (ContentsCacheRecord)UssContentsDataManager.cacheManager.get(s);
            } else
            if (UssContentsDataManager.logger.isLoggable)
            {
                UssContentsDataManager.logger.log("lookup aborted, invalid key");
                return null;
            }
            return avoid;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onPostExecute(ContentsCacheRecord contentscacherecord)
        {
            boolean flag1;
            super.onPostExecute(contentscacherecord);
            flag1 = false;
            if (contentscacherecord != null && flushCacheTask == null) goto _L2; else goto _L1
_L1:
            if (UssContentsDataManager.logger.isLoggable)
            {
                UssContentsDataManager.logger.log("cache miss, forcing update");
            }
            if (loadTask == null)
            {
                getContentsAsync(auth, country);
            } else
            if (UssContentsDataManager.logger.isLoggable)
            {
                UssContentsDataManager.logger.log("aborting update, already in progress");
            }
_L4:
            consultCacheTask = null;
            return;
_L2:
            boolean flag;
            if (!contentscacherecord.isStale() && !contentscacherecord.isStaleContentSources(contentSources))
            {
                break; /* Loop/switch isn't completed */
            }
            if (UssContentsDataManager.logger.isLoggable)
            {
                UssContentsDataManager.logger.log("cache hit but entry is stale, forcing update");
            }
            flag1 = true;
            if (loadTask == null)
            {
                getContentsAsync(auth, country);
                flag = flag1;
            } else
            {
                flag = flag1;
                if (UssContentsDataManager.logger.isLoggable)
                {
                    UssContentsDataManager.logger.log("aborting update, already in progress");
                    flag = flag1;
                }
            }
_L5:
            handleLoadDataResult(new Content(contentscacherecord.content), true, flag, observers);
            if (true) goto _L4; else goto _L3
_L3:
            flag = flag1;
            if (UssContentsDataManager.logger.isLoggable)
            {
                UssContentsDataManager.logger.log("cache hit");
                flag = flag1;
            }
              goto _L5
            if (true) goto _L4; else goto _L6
_L6:
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ContentsCacheRecord)obj);
        }

        protected transient ConsultCacheTask(Authentication authentication, EbayCountry ebaycountry, Observer observer, ContentSourceEnum acontentsourceenum[])
        {
            this$0 = UssContentsDataManager.this;
            super();
            auth = authentication;
            country = ebaycountry;
            if (observer != null)
            {
                observers.add(observer);
            }
            contentSources = new ArrayList();
            if (acontentsourceenum != null)
            {
                contentSources.addAll(Arrays.asList(acontentsourceenum));
            }
        }
    }

    private static final class ContentsCacheRecord extends BaseDataMapped
    {

        public final Contents content;
        public ContentSourceEnum staleContentSources[];
        public long ttl;

        public transient void addStaleContentSources(ContentSourceEnum acontentsourceenum[])
        {
            if (acontentsourceenum != null)
            {
                HashSet hashset;
                int j;
                if (staleContentSources == null)
                {
                    hashset = new HashSet();
                } else
                {
                    hashset = new HashSet(Arrays.asList(staleContentSources));
                }
                j = acontentsourceenum.length;
                for (int i = 0; i < j; i++)
                {
                    hashset.add(acontentsourceenum[i]);
                }

                staleContentSources = new ContentSourceEnum[hashset.size()];
                hashset.toArray(staleContentSources);
            }
        }

        public boolean isStale()
        {
            return System.currentTimeMillis() > ttl;
        }

        public boolean isStaleContentSources(List list)
        {
label0:
            {
                HashSet hashset;
                if (staleContentSources == null)
                {
                    hashset = new HashSet();
                } else
                {
                    hashset = new HashSet(Arrays.asList(staleContentSources));
                }
                if ((list == null || list.isEmpty()) && !hashset.isEmpty())
                {
                    return true;
                }
                if (list == null)
                {
                    break label0;
                }
                list = list.iterator();
                do
                {
                    if (!list.hasNext())
                    {
                        break label0;
                    }
                } while (!hashset.contains((ContentSourceEnum)list.next()));
                return true;
            }
            return false;
        }

        public ContentsCacheRecord(Content content1)
        {
            content = (Contents)content1.getData();
            ttl = System.currentTimeMillis() + 0xdbba0L;
            if (Log.isLoggable("UssDataManagerTtl", 3))
            {
                ttl = System.currentTimeMillis() + 0x927c0L;
                UssContentsDataManager.logger.log("overriding TTL to ten minutes");
            } else
            if (UssContentsDataManager.TEST_instantStale)
            {
                ttl = System.currentTimeMillis();
                UssContentsDataManager.logger.log("Overriding TTL to instant stale");
                return;
            }
        }
    }

    private final class FlushCacheTask extends AsyncTask
    {

        private final Authentication auth;
        private final EbayCountry country;
        final UssContentsDataManager this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            UssContentsDataManager.cacheManager.remove(getCacheKey(auth, country.getSite().id));
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
            this$0 = UssContentsDataManager.this;
            super();
            auth = authentication;
            country = ebaycountry;
        }
    }

    private final class InvalidateCacheContentSourcesTask extends AsyncTask
    {

        private final Authentication auth;
        private ContentSourceEnum contentSources[];
        private final EbayCountry country;
        final UssContentsDataManager this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            avoid = getCacheKey(auth, country.getSite().id);
            ContentsCacheRecord contentscacherecord = (ContentsCacheRecord)UssContentsDataManager.cacheManager.get(avoid);
            if (contentscacherecord != null)
            {
                contentscacherecord.addStaleContentSources(contentSources);
                UssContentsDataManager.cacheManager.put(avoid, contentscacherecord);
            }
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
        }

        public transient InvalidateCacheContentSourcesTask(Authentication authentication, EbayCountry ebaycountry, ContentSourceEnum acontentsourceenum[])
        {
            this$0 = UssContentsDataManager.this;
            super();
            auth = authentication;
            country = ebaycountry;
            contentSources = acontentsourceenum;
        }
    }

    public static final class KeyParams extends UserContextObservingDataManager.KeyBase
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return new KeyParams(parcel);
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
        public final boolean blended;
        public final List categoryIds;
        public final String channel;
        public final String department;
        public final List outputSelectors;
        public final List requestContextValues;
        public final RtmInfo rtmInfo;

        public volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        public UssContentsDataManager create(EbayContext ebaycontext)
        {
            return new UssContentsDataManager(ebaycontext, this);
        }

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null)
                {
                    return false;
                }
                if (obj instanceof KeyParams)
                {
                    obj = (KeyParams)obj;
                    if (blended != ((KeyParams) (obj)).blended || channel != ((KeyParams) (obj)).channel && (channel == null || !channel.equals(((KeyParams) (obj)).channel)) || department != ((KeyParams) (obj)).department && (department == null || !department.equals(((KeyParams) (obj)).department)) || categoryIds != ((KeyParams) (obj)).categoryIds && (categoryIds == null || !categoryIds.equals(((KeyParams) (obj)).categoryIds)) || outputSelectors != ((KeyParams) (obj)).outputSelectors && (outputSelectors == null || !outputSelectors.equals(((KeyParams) (obj)).outputSelectors)) || requestContextValues != ((KeyParams) (obj)).requestContextValues && (requestContextValues == null || !requestContextValues.equals(((KeyParams) (obj)).requestContextValues)) || rtmInfo != ((KeyParams) (obj)).rtmInfo && (rtmInfo == null || !rtmInfo.equals(((KeyParams) (obj)).rtmInfo)))
                    {
                        return false;
                    }
                } else
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            int k1 = 0;
            int l1 = super.hashCode();
            int i;
            int j;
            int k;
            int l;
            int i1;
            int j1;
            if (channel == null)
            {
                i = 0;
            } else
            {
                i = channel.hashCode();
            }
            if (department == null)
            {
                j = 0;
            } else
            {
                j = department.hashCode();
            }
            if (categoryIds == null)
            {
                k = 0;
            } else
            {
                k = categoryIds.hashCode();
            }
            if (outputSelectors == null)
            {
                l = 0;
            } else
            {
                l = outputSelectors.hashCode();
            }
            if (requestContextValues == null)
            {
                i1 = 0;
            } else
            {
                i1 = requestContextValues.hashCode();
            }
            if (rtmInfo == null)
            {
                j1 = 0;
            } else
            {
                j1 = rtmInfo.hashCode();
            }
            if (blended)
            {
                k1 = 1;
            }
            return ((((((l1 * 31 + i) * 31 + j) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1) * 31 + k1;
        }

        public String toString()
        {
            return (new StringBuilder()).append("KeyParams(").append(channel).append(",").append(department).append(",").append(categoryIds).append(",").append(outputSelectors).append(",").append(requestContextValues).append(",").append(rtmInfo).append(",").append(blended).append(")").toString().replaceAll(" ", "");
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            boolean flag = true;
            parcel.writeString(channel);
            parcel.writeString(department);
            if (categoryIds != null)
            {
                parcel.writeInt(1);
                parcel.writeStringList(categoryIds);
            } else
            {
                parcel.writeInt(0);
            }
            if (outputSelectors != null)
            {
                parcel.writeInt(1);
                parcel.writeTypedList(outputSelectors);
            } else
            {
                parcel.writeInt(0);
            }
            if (requestContextValues != null)
            {
                parcel.writeInt(1);
                parcel.writeTypedList(requestContextValues);
            } else
            {
                parcel.writeInt(0);
            }
            parcel.writeParcelable(rtmInfo, i);
            if (blended)
            {
                i = ((flag) ? 1 : 0);
            } else
            {
                i = 0;
            }
            parcel.writeInt(i);
        }


        KeyParams(Parcel parcel)
        {
            channel = parcel.readString();
            department = parcel.readString();
            boolean flag;
            if (parcel.readInt() == 1)
            {
                categoryIds = new ArrayList();
                parcel.readStringList(categoryIds);
            } else
            {
                categoryIds = null;
            }
            if (parcel.readInt() == 1)
            {
                outputSelectors = new ArrayList();
                parcel.readTypedList(outputSelectors, OutputSelector.CREATOR);
            } else
            {
                outputSelectors = null;
            }
            if (parcel.readInt() == 1)
            {
                requestContextValues = new ArrayList();
                parcel.readTypedList(requestContextValues, KeyValue.CREATOR);
            } else
            {
                requestContextValues = null;
            }
            rtmInfo = (RtmInfo)parcel.readParcelable(com/ebay/nautilus/domain/data/UnifiedStream/RtmInfo.getClassLoader());
            if (parcel.readInt() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            blended = flag;
        }

        public KeyParams(String s, String s1, List list, List list1, List list2, RtmInfo rtminfo, boolean flag)
        {
            channel = s;
            department = s1;
            categoryIds = list;
            outputSelectors = list1;
            requestContextValues = list2;
            rtmInfo = rtminfo;
            blended = flag;
            if (s == null && list1 == null)
            {
                throw new IllegalStateException("Either channel or outputSelectors must be non-null. channel = null  outputSelectors = null");
            }
            if (ChannelEnum.DEPARTMENT.toString().equals(s) && TextUtils.isEmpty(s1) && (list == null || list.isEmpty()))
            {
                throw new IllegalStateException((new StringBuilder()).append("When channel = DEPARTMENT, either department or categoryIds must not be empty. department = ").append(s1).append("  categoryIds = ").append(list).toString());
            } else
            {
                return;
            }
        }
    }

    private final class LoadContentsTask extends LoadTaskBase
    {

        UnifiedStreamResponse response;
        final UssContentsDataManager this$0;

        protected transient Content doInBackground(Void avoid[])
        {
            Object obj;
            UssContentsDataManager usscontentsdatamanager;
            obj = getRequestParams(keyParams, lastRequestTime, null);
            usscontentsdatamanager = UssContentsDataManager.this;
            if (auth == null)
            {
                break MISSING_BLOCK_LABEL_165;
            }
            avoid = auth.iafToken;
_L1:
            response = (UnifiedStreamResponse)usscontentsdatamanager.sendRequest(new UnifiedStreamRequest(avoid, country, ((com.ebay.nautilus.domain.net.api.unifiedstream.UnifiedStreamRequest.Params) (obj))));
            avoid = response.getResultStatus();
            lastRequestTime = response.requestTime;
            if (avoid.hasError())
            {
                return new Content(avoid);
            }
            obj = response.streamContents;
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_163;
            }
            avoid = new Content(obj, avoid);
            UssContentsDataManager.cacheManager.put(getCacheKey(auth, country.getSite().id), new ContentsCacheRecord(avoid));
            return avoid;
            avoid;
            return null;
            avoid = null;
              goto _L1
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        public LoadContentsTask(Authentication authentication, EbayCountry ebaycountry, KeyParams keyparams)
        {
            this$0 = UssContentsDataManager.this;
            super(authentication, ebaycountry, keyparams);
        }
    }

    private final class LoadDealDetailsTask extends LoadTaskBase
    {

        UssListOfListingsResponse response;
        final UssContentsDataManager this$0;

        protected transient Content doInBackground(Void avoid[])
        {
            com.ebay.nautilus.domain.net.api.unifiedstream.UssDealDetailsRequest.Params params = new com.ebay.nautilus.domain.net.api.unifiedstream.UssDealDetailsRequest.Params();
            if (keyParams.requestContextValues != null && keyParams.requestContextValues.size() != 0) goto _L2; else goto _L1
_L2:
            UssContentsDataManager usscontentsdatamanager;
            params.dealCategoryId = ((KeyValue)keyParams.requestContextValues.get(0)).value;
            if (lastRequestTime > 0L)
            {
                params.lastRefreshedTag = EbayDateUtils.formatIso8601DateTime(new Date(lastRequestTime));
            }
            usscontentsdatamanager = UssContentsDataManager.this;
            if (auth == null)
            {
                break MISSING_BLOCK_LABEL_353;
            }
            avoid = auth.iafToken;
_L4:
            response = (UssListOfListingsResponse)usscontentsdatamanager.sendRequest(new UssDealDetailsRequest(avoid, country, params));
            avoid = response.getResultStatus();
            lastRequestTime = response.requestTime;
            if (avoid.hasError())
            {
                return new Content(avoid);
            }
            if (response.streamContents == null || response.streamContents.listings.size() <= 0) goto _L1; else goto _L3
_L3:
            Object obj1 = response.streamContents.listings;
            Object obj = new com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord();
            obj.type = ContentTypeEnum.DEALS_CATEGORY;
            obj.listings = ((List) (obj1));
            obj1 = new com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup();
            obj1.contentSource = ContentSourceEnum.DEALS;
            obj1.contents = new ArrayList();
            ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj1)).contents.add(obj);
            obj = new Contents();
            obj.contentGroups = new ArrayList();
            ((Contents) (obj)).contentGroups.add(obj1);
            avoid = new Content(obj, avoid);
            UssContentsDataManager.cacheManager.put(getCacheKey(auth, country.getSite().id), new ContentsCacheRecord(avoid));
            return avoid;
_L1:
            return null;
            avoid;
            return null;
            avoid = null;
              goto _L4
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        public LoadDealDetailsTask(Authentication authentication, EbayCountry ebaycountry, KeyParams keyparams)
        {
            this$0 = UssContentsDataManager.this;
            super(authentication, ebaycountry, keyparams);
        }
    }

    private abstract class LoadTaskBase extends AsyncTask
    {

        protected final Authentication auth;
        protected final EbayCountry country;
        protected final KeyParams keyParams;
        final UssContentsDataManager this$0;

        protected void onCancelled()
        {
            super.onCancelled();
            handleLoadDataResult(null, false, false, null);
            loadTask = null;
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleLoadDataResult(content, false, false, null);
            loadTask = null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public LoadTaskBase(Authentication authentication, EbayCountry ebaycountry, KeyParams keyparams)
        {
            this$0 = UssContentsDataManager.this;
            super();
            country = ebaycountry;
            auth = authentication;
            keyParams = keyparams;
        }
    }

    public static interface Observer
    {

        public abstract void onStreamChanged(UssContentsDataManager usscontentsdatamanager, Content content, boolean flag, boolean flag1);
    }


    private static final String CACHE_KEY_PREFIX = "uss_contents";
    private static final String DEALS_CATEGORY_ID = "DealCategoryId";
    private static final String DEALS_CHANNEL_STRING = "DEALS";
    public static final String DEALS_DETAILS_MODE = "DETAILS";
    private static final List DEAL_SELECTOR;
    private static final List FEED_SELECTOR;
    private static final long MAX_CACHE_TTL = 0x3ffffffffffffffeL;
    public static final int MAX_ENTRIES_PER_PAGE = 50;
    protected static final long STALE_TTL = 0xdbba0L;
    public static boolean TEST_instantStale = false;
    private static final KeyParams _followingChannelKeyParams;
    protected static CacheManager cacheManager;
    static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("UssContentsDm", 3, "UnifiedStream Contents DataManager");
    protected ConsultCacheTask consultCacheTask;
    protected FlushCacheTask flushCacheTask;
    private boolean isCountryInitialized;
    private boolean isUserInitialized;
    protected long lastRequestTime;
    protected LoadTaskBase loadTask;

    UssContentsDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        super(ebaycontext, com/ebay/nautilus/domain/content/dm/UssContentsDataManager$Observer, keyparams);
        lastRequestTime = 0L;
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
            cacheManager = new CacheManager((Context)ebaycontext.getExtension(android/content/Context), JsonPersistenceMapper.create(keyparams), com/ebay/nautilus/domain/content/dm/UssContentsDataManager$ContentsCacheRecord, "unifiedStreamCache", 1, 1, 1L, 0x3ffffffffffffffeL, true);
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

    public static KeyParams getChannelKeyParams(String s)
    {
        return getChannelKeyParams(s, null, null);
    }

    public static KeyParams getChannelKeyParams(String s, List list, List list1)
    {
        return new KeyParams(s, null, null, list, list1, null, false);
    }

    public static KeyParams getContentSourceKeyParams(ContentSourceEnum contentsourceenum)
    {
        return new KeyParams(null, null, null, Collections.singletonList(new OutputSelector(contentsourceenum)), null, null, false);
    }

    public static KeyParams getDealChannelKeyParams(String s)
    {
        ArrayList arraylist1;
        if (s != null)
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(new KeyValue("DEALS", "DealCategoryId", s));
            s = arraylist;
        } else
        {
            s = null;
        }
        arraylist1 = new ArrayList();
        arraylist1.add(new OutputSelector(ContentSourceEnum.DEALS));
        return new KeyParams(ChannelEnum.DEALS.toString(), null, null, arraylist1, s, null, true);
    }

    public static KeyParams getDealContentKeyParams(boolean flag)
    {
        return new KeyParams(ChannelEnum.DEALS.toString(), null, null, DEAL_SELECTOR, null, null, flag);
    }

    public static KeyParams getDealDepartmentKeyParams(String s)
    {
        List list = Collections.singletonList(new OutputSelector(ContentSourceEnum.DEALS));
        return new KeyParams(ChannelEnum.DEALS.toString(), s, null, list, null, null, true);
    }

    public static KeyParams getDealDetailsKeyParams(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            s = Collections.singletonList(new KeyValue("DEALS", "DealCategoryId", s));
            List list = Collections.singletonList(new OutputSelector(ContentSourceEnum.DEALS));
            return new KeyParams(ChannelEnum.DEALS.toString(), "DETAILS", null, list, s, null, true);
        }
    }

    public static KeyParams getDepartmentChannelKeyParams(String s)
    {
        return getDepartmentChannelKeyParams(s, null, null);
    }

    public static KeyParams getDepartmentChannelKeyParams(String s, List list, List list1)
    {
        return new KeyParams(ChannelEnum.DEPARTMENT.toString(), s, null, list, list1, null, false);
    }

    public static KeyParams getFollowingChannelKeyParams()
    {
        return _followingChannelKeyParams;
    }

    public static transient void invalidateActivityChannelData(EbayContext ebaycontext, ContentSourceEnum acontentsourceenum[])
    {
        invalidateChannelData(ebaycontext, ChannelEnum.ACTIVITY.toString(), acontentsourceenum);
    }

    private static transient void invalidateChannelData(EbayContext ebaycontext, String s, ContentSourceEnum acontentsourceenum[])
    {
        if (s != null)
        {
            ebaycontext = getExisting(ebaycontext, com/ebay/nautilus/domain/content/dm/UssContentsDataManager).iterator();
            do
            {
                if (!ebaycontext.hasNext())
                {
                    break;
                }
                UssContentsDataManager usscontentsdatamanager = (UssContentsDataManager)ebaycontext.next();
                if (s.equals(((KeyParams)usscontentsdatamanager.getParams()).channel))
                {
                    usscontentsdatamanager.invalidateContentSources(acontentsourceenum);
                }
            } while (true);
        }
    }

    public static transient void invalidateSellChannelData(EbayContext ebaycontext, ContentSourceEnum acontentsourceenum[])
    {
        invalidateChannelData(ebaycontext, ChannelEnum.SELL.toString(), acontentsourceenum);
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
                logger.log((new StringBuilder()).append("flushing cache ").append(getParams()).toString());
            }
        }
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
        s1 = UnifiedStreamRequest.getLocaleList();
        return (new StringBuilder()).append("uss_contents-").append(authentication).append("-").append(s).append("-").append(s1).append("-").append(((KeyParams)getParams()).toString()).toString();
    }

    protected void getContentsAsync(Authentication authentication, EbayCountry ebaycountry)
    {
        KeyParams keyparams;
label0:
        {
            NautilusKernel.verifyMain();
            keyparams = (KeyParams)getParams();
            if (loadTask == null)
            {
                if (!ChannelEnum.DEALS.toString().equals(keyparams.channel) || !"DETAILS".equals(keyparams.department))
                {
                    break label0;
                }
                authentication = new LoadDealDetailsTask(authentication, ebaycountry, keyparams);
                loadTask = authentication;
                executeOnThreadPool(authentication, new Void[0]);
            }
            return;
        }
        authentication = new LoadContentsTask(authentication, ebaycountry, keyparams);
        loadTask = authentication;
        executeOnThreadPool(authentication, new Void[0]);
    }

    protected com.ebay.nautilus.domain.net.api.unifiedstream.UnifiedStreamRequest.Params getRequestParams(KeyParams keyparams, long l, List list)
    {
        com.ebay.nautilus.domain.net.api.unifiedstream.UnifiedStreamRequest.Params params;
        params = new com.ebay.nautilus.domain.net.api.unifiedstream.UnifiedStreamRequest.Params();
        params.channel = keyparams.channel;
        params.department = keyparams.department;
        params.categoryId = keyparams.categoryIds;
        params.outputSelector = keyparams.outputSelectors;
        if (l > 0L)
        {
            params.lastRefreshedTag = EbayDateUtils.formatIso8601DateTime(new Date(l));
        }
        if (list == null || list.isEmpty()) goto _L2; else goto _L1
_L1:
        params.paginationInput = new PaginationInput();
        params.paginationInput.entriesPerPage = Integer.valueOf(50);
        params.paginationInput.pagination = list;
_L4:
        if (keyparams.requestContextValues != null)
        {
            if (params.requestContext == null)
            {
                params.requestContext = new RequestContext();
            }
            params.requestContext.keyValues.addAll(keyparams.requestContextValues);
        }
        if (keyparams.rtmInfo != null)
        {
            list = UssUtil.getRtmRequestContextValues(getContext(), Integer.toString(keyparams.rtmInfo.siteId), keyparams.rtmInfo.cguid, keyparams.rtmInfo.placementId);
            if (params.requestContext == null)
            {
                params.requestContext = new RequestContext();
            }
            params.requestContext.keyValues.addAll(list);
        }
        params.blended = keyparams.blended;
        return params;
_L2:
        if (keyparams.outputSelectors != null && !keyparams.outputSelectors.isEmpty())
        {
            Object obj = (OutputSelector)keyparams.outputSelectors.get(0);
            params.paginationInput = new PaginationInput();
            params.paginationInput.entriesPerPage = Integer.valueOf(50);
            list = new Pagination();
            list.contentSource = ((OutputSelector) (obj)).contentSource;
            list.cursor = "0";
            list.entriesPerPage = Integer.valueOf(50);
            obj = new ArrayList();
            ((List) (obj)).add(list);
            params.paginationInput.pagination = ((List) (obj));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void handleLoadDataResult(Content content, boolean flag, boolean flag1, List list)
    {
        if (content != null)
        {
            if (list != null && list.size() > 0)
            {
                list = list.iterator();
                while (list.hasNext()) 
                {
                    ((Observer)list.next()).onStreamChanged(this, content, flag, flag1);
                }
            } else
            {
                ((Observer)dispatcher).onStreamChanged(this, content, flag, flag1);
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
        lastRequestTime = 0L;
        flush();
        loadData(((Observer) (null)));
    }

    public transient void invalidateContentSources(ContentSourceEnum acontentsourceenum[])
    {
        if (acontentsourceenum == null || acontentsourceenum.length == 0)
        {
            flush();
        } else
        {
            NautilusKernel.verifyMain();
            executeOnThreadPool(new InvalidateCacheContentSourcesTask(getCurrentUser(), getCurrentCountry(), acontentsourceenum), new Void[0]);
            if (logger.isLoggable)
            {
                logger.log((new StringBuilder()).append("invalidating content sources ").append(acontentsourceenum.toString()).append(" ").append(getParams()).toString());
                return;
            }
        }
    }

    public void loadData(Observer observer)
    {
        loadDataForContentSource(observer, new ContentSourceEnum[0]);
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public transient void loadDataForContentSource(Observer observer, ContentSourceEnum acontentsourceenum[])
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
            consultCacheTask.attach(observer, acontentsourceenum);
            return;
        }
        EbayCountry ebaycountry = getCurrentCountry();
        if (ebaycountry == null)
        {
            throw new IllegalStateException("getCurrentCountry() returned null");
        } else
        {
            consultCacheTask = new ConsultCacheTask(getCurrentUser(), ebaycountry, observer, acontentsourceenum);
            executeOnThreadPool(consultCacheTask, new Void[0]);
            return;
        }
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

    static 
    {
        FEED_SELECTOR = Collections.unmodifiableList(Collections.singletonList(new OutputSelector(ContentSourceEnum.FEED)));
        _followingChannelKeyParams = new KeyParams(null, null, null, FEED_SELECTOR, null, null, false);
        DEAL_SELECTOR = Collections.unmodifiableList(Collections.singletonList(new OutputSelector(ContentSourceEnum.DEALS)));
    }


}
