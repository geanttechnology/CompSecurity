// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import com.groupon.Channel;
import com.groupon.abtest.BadgesAbTestHelper;
import com.groupon.abtest.MerchantSpecialsAbTestHelper;
import com.groupon.activity.GlobalSearchResult;
import com.groupon.cookies.CookieFactory;
import com.groupon.db.dao.DaoDealSubsetAttribute;
import com.groupon.db.dao.DaoDealSummary;
import com.groupon.db.dao.DaoPagination;
import com.groupon.db.events.ChannelUpdateEvent;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.Pagination;
import com.groupon.deeplink.DeepLinkData;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.deeplink.Endpoint;
import com.groupon.deeplink.InvalidDeepLinkException;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.manager.deserializer.StreamingJsonDeserializer;
import com.groupon.models.DealsResponse;
import com.groupon.models.Place;
import com.groupon.models.category.Category;
import com.groupon.models.country.Country;
import com.groupon.models.dealsearch.OtherDeals;
import com.groupon.models.dealsearch.SearchResponse;
import com.groupon.service.DeepLinkManager;
import com.groupon.service.LoginService;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ApiRequestUtil;
import com.groupon.util.BuyUtils;
import com.groupon.util.CountryNotSupportedException;
import com.groupon.util.CountryUtil;
import com.groupon.util.ExecutorManager;
import com.groupon.util.GlobalSearchUtil;
import com.groupon.util.HttpUtil;
import com.groupon.util.IOUtils;
import com.groupon.util.IncentivesUtil;
import com.groupon.util.LoggingUtils;
import com.groupon.util.MutableInteger;
import com.groupon.util.ObjectMapperWrapper;
import com.groupon.util.PausableThreadPoolExecutor;
import com.groupon.view.UrlImageView;
import com.j256.ormlite.dao.Dao;
import com.squareup.otto.Bus;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.manager:
//            AnyChannelSyncManager, BusinessesSyncHelper, AsyncHttp, SyncManagerUtils

public class SearchSyncManager extends AnyChannelSyncManager
{
    public class DealDeserializer extends StreamingJsonDeserializer
    {

        private String channel;
        private ObjectMapperWrapper standardObjectMapperDelegate;
        final SearchSyncManager this$0;

        public Deal deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException
        {
            try
            {
                jsonparser = (Deal)standardObjectMapperDelegate.readValue(jsonparser, com/groupon/db/models/Deal);
                jsonparser.afterJsonDeserializationPostProcessor(buyUtil);
                daoDealSummary.save(new DealSummary(jsonparser, channel));
                UrlImageView.prefetch((Application)context.getApplicationContext(), jsonparser.getImageUrl());
            }
            // Misplaced declaration of an exception variable
            catch (JsonParser jsonparser)
            {
                throw new RuntimeException(jsonparser);
            }
            return null;
        }

        public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
        {
            return deserialize(jsonparser, deserializationcontext);
        }

        public DealDeserializer(String s, Context context1)
        {
            this$0 = SearchSyncManager.this;
            super();
            channel = s;
            RoboGuice.getInjector(context1).injectMembers(this);
        }
    }

    public class OtherDealsDeserializer extends StreamingJsonDeserializer
    {

        final SearchSyncManager this$0;

        public OtherDeals deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException
        {
            return (OtherDeals)otherDealsInternalObjectMapper.readValue(jsonparser, com/groupon/models/dealsearch/OtherDeals);
        }

        public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
        {
            return deserialize(jsonparser, deserializationcontext);
        }

        public OtherDealsDeserializer()
        {
            this$0 = SearchSyncManager.this;
            super();
        }
    }


    private static final String PULL = "pull";
    private AbTestService abTestService;
    protected Activity activity;
    private BadgesAbTestHelper badgesAbTestHelper;
    private BusinessesSyncHelper businessesSyncHelper;
    private BuyUtils buyUtil;
    private Context context;
    private CookieFactory cookieFactory;
    private CountryUtil countryUtil;
    DaoDealSummary daoDealSummary;
    private DeepLinkManager deepLinkManager;
    private List deepLinkParametersForNstLogging;
    private DeepLinkUtil deepLinkUtil;
    private String deepLinkWithApiParameters;
    private GlobalSearchUtil globalSearchUtil;
    private boolean isGoodsConnectedMarketPlace1504;
    private boolean isShowBadgeOnSearch1509USCA;
    private boolean isShowExactMatchMerchant1410USCAmatchAbove;
    private boolean isShowExactMatchMerchant1410USCAmatchBelow;
    private boolean isShowExactMatchMerchant1410USCAmatchNoDeals;
    private Logger logger;
    private LoginService loginService;
    private MerchantSpecialsAbTestHelper merchantSpecialsAbTestHelper;
    private boolean merchantSpecialsEnabledDivisions;
    private String otherDealChannel;
    private ObjectMapper otherDealsInternalObjectMapper;
    private GlobalSearchResult resultActivity;
    public String searchTerm;
    private boolean shouldForceUpdateOnAutoSync;

    public SearchSyncManager(Context context1, String s, PausableThreadPoolExecutor pausablethreadpoolexecutor, ExecutorManager executormanager)
    {
        super(context1, pausablethreadpoolexecutor, executormanager, s);
        context = context1;
    }

    public void configure(String s, String s1, String s2)
    {
        boolean flag1 = true;
        channel = s;
        otherDealChannel = s1;
        resultActivity = (GlobalSearchResult)activity;
        deepLinkWithApiParameters = s2;
        boolean flag2 = Strings.isEmpty(s2);
        boolean flag;
        if (flag2 && abTestService.isVariantEnabled("showExactMatchMerchant1410USCA", "matchNoDeals"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isShowExactMatchMerchant1410USCAmatchNoDeals = flag;
        if (flag2 && abTestService.isVariantEnabled("showExactMatchMerchant1410USCA", "matchAbove"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isShowExactMatchMerchant1410USCAmatchAbove = flag;
        if (flag2 && abTestService.isVariantEnabled("showExactMatchMerchant1410USCA", "matchBelow"))
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        isShowExactMatchMerchant1410USCAmatchBelow = flag;
        isGoodsConnectedMarketPlace1504 = abTestService.isVariantEnabledAndUSCA("goodsConnectedMarketplaceUSCA1504", "on");
        isShowBadgeOnSearch1509USCA = badgesAbTestHelper.isShowBadgeOnSearch();
    }

    protected ObjectMapper createObjectMapper()
    {
        ObjectMapper objectmapper = new ObjectMapper();
        objectmapper.enable(new org.codehaus.jackson.map.DeserializationConfig.Feature[] {
            org.codehaus.jackson.map.DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY
        });
        SimpleModule simplemodule = new SimpleModule("SearchDeserializerModule", new Version(1, 0, 0, null));
        simplemodule.addDeserializer(com/groupon/db/models/Deal, new DealDeserializer(channel, context));
        simplemodule.addDeserializer(com/groupon/models/dealsearch/OtherDeals, new OtherDealsDeserializer());
        objectmapper.registerModule(simplemodule);
        otherDealsInternalObjectMapper = new ObjectMapper();
        simplemodule = new SimpleModule("OtherDealDeserializerModule", new Version(1, 0, 0, null));
        simplemodule.addDeserializer(com/groupon/db/models/Deal, new DealDeserializer(otherDealChannel, context));
        otherDealsInternalObjectMapper.registerModule(simplemodule);
        return objectmapper;
    }

    protected volatile void doSync(Object obj, int i, int j)
        throws Exception
    {
        doSync((Void)obj, i, j);
    }

    protected void doSync(Void void1, final int offset, int i)
        throws Exception
    {
        final InputStream inputStream;
        void1 = resultActivity.getPlace();
        merchantSpecialsEnabledDivisions = merchantSpecialsAbTestHelper.isMerchantSpecialsEnabled(void1);
        Ln.d((new StringBuilder()).append("Start doSync for channel ").append(channel).toString(), new Object[0]);
        boolean flag = context.getResources().getBoolean(0x7f090007);
        final MutableInteger dealCount;
        long l;
        if (offset == 0 && currentCountryManager.getCurrentCountry().isUSACompatible() && businessesSyncHelper != null && flag && merchantSpecialsEnabledDivisions && (isShowExactMatchMerchant1410USCAmatchNoDeals || isShowExactMatchMerchant1410USCAmatchAbove || isShowExactMatchMerchant1410USCAmatchBelow))
        {
            void1 = businessesSyncHelper.startAsyncRequest(searchTerm, resultActivity.getPlace());
        } else
        {
            void1 = null;
        }
        l = System.currentTimeMillis();
        dealCount = new MutableInteger(0);
        dealCount.set(0);
        inputStream = getSyncHttp(offset, i);
        inputStream.setObjectMapper(mapper);
        inputStream = (InputStream)inputStream.call();
        doInitDoSyncObjectMapper();
        dealSummaryDao.callBatchTasks(new Callable() {

            final SearchSyncManager this$0;
            final MutableInteger val$dealCount;
            final InputStream val$inputStream;
            final int val$offset;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                Object obj;
                SyncManagerUtils.deleteRecordsForChannel((Dao)paginationDao.get(), channel);
                SyncManagerUtils.deleteRecordsForChannel((Dao)dealSubsetAttributeDao.get(), channel);
                if (offset == 0)
                {
                    SyncManagerUtils.deleteRecordsForChannel(dealSummaryDao, channel);
                }
                SyncManagerUtils.deleteRecordsForChannel(dealSummaryDao, otherDealChannel);
                obj = (SearchResponse)mapper.readValue(inputStream, com/groupon/models/dealsearch/SearchResponse);
                if (((SearchResponse) (obj)).otherDeals != null && ((SearchResponse) (obj)).otherDeals.backfill != null && ((SearchResponse) (obj)).otherDeals.backfill.dealSubsetAttributes != null)
                {
                    DealSubsetAttribute dealsubsetattribute;
                    for (Iterator iterator = ((SearchResponse) (obj)).otherDeals.backfill.dealSubsetAttributes.iterator(); iterator.hasNext(); ((DaoDealSubsetAttribute)dealSubsetAttributeDao.get()).create(dealsubsetattribute))
                    {
                        dealsubsetattribute = (DealSubsetAttribute)iterator.next();
                        dealsubsetattribute.channel = channel;
                    }

                }
                  goto _L1
                obj;
                IOUtils.close(inputStream);
_L5:
                return null;
_L1:
                if (((SearchResponse) (obj)).deals != null)
                {
                    dealCount.set(((SearchResponse) (obj)).deals.size());
                }
                if (((SearchResponse) (obj)).pagination == null) goto _L3; else goto _L2
_L2:
                Object obj1;
                ((SearchResponse) (obj)).pagination.setChannel(channel);
                ((SearchResponse) (obj)).pagination.setCurrentOffset(offset);
                ((SearchResponse) (obj)).pagination.setNextOffset(offset + dealCount.get());
                obj1 = ((SearchResponse) (obj)).pagination;
                int j;
                boolean flag1;
                if (dealCount.get() > 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                ((Pagination) (obj1)).setHasMorePages(flag1);
                ((DaoPagination)paginationDao.get()).create(((SearchResponse) (obj)).pagination);
_L3:
                if (offset != 0) goto _L5; else goto _L4
_L4:
                obj1 = SearchSyncManager.this;
                if (((SearchResponse) (obj)).pagination == null)
                {
                    break MISSING_BLOCK_LABEL_370;
                }
                j = ((SearchResponse) (obj)).pagination.getCount();
_L6:
                ((SearchSyncManager) (obj1)).logGlobalSearchDealSearch(j);
                  goto _L5
                j = dealCount.get();
                  goto _L6
            }

            
            {
                this$0 = SearchSyncManager.this;
                offset = i;
                inputStream = inputstream;
                dealCount = mutableinteger;
                super();
            }
        });
        ((LoggingUtils)loggingUtils.get()).logListLoadingPerformance(String.format("%sV2", new Object[] {
            channel
        }), l, dealCount.get());
        Ln.d((new StringBuilder()).append("End doSync for channel ").append(channel).toString(), new Object[0]);
        if (void1 == null)
        {
            break MISSING_BLOCK_LABEL_340;
        }
        inputStream = null;
        void1 = (InputStream)void1.get();
        inputStream = void1;
        if (!isShowExactMatchMerchant1410USCAmatchNoDeals)
        {
            break MISSING_BLOCK_LABEL_317;
        }
        inputStream = void1;
        if (dealCount.get() > 0)
        {
            break MISSING_BLOCK_LABEL_332;
        }
        inputStream = void1;
        businessesSyncHelper.process(void1, channel);
        if (void1 != null)
        {
            IOUtils.close(void1);
        }
        globalBus.post(new ChannelUpdateEvent(channel, dealCount.get()));
        return;
        void1;
        if (inputStream != null)
        {
            IOUtils.close(inputStream);
        }
        throw void1;
    }

    public void forceUpdateOnAutoSync()
    {
        shouldForceUpdateOnAutoSync = true;
    }

    protected List getNameValueParams(int i, int j)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "locale", countryUtil.getLocale(currentCountryManager.getCurrentCountry())
        }));
        if (loginService.isLoggedIn())
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "email_address", loginService.getEmail()
            }));
        } else
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "visitor_id", cookieFactory.getBrowserCookie()
            }));
        }
        arraylist.addAll(ApiRequestUtil.generateSearchShowParameter(((IncentivesUtil)incentivesUtil.get()).isExperimentEnabled(), false, isGoodsConnectedMarketPlace1504, isShowBadgeOnSearch1509USCA));
        if (deepLinkWithApiParameters != null)
        {
            Object obj1;
            String s;
            ArrayList arraylist1;
            String s1;
            java.util.Map.Entry entry;
            Place place;
            String s2;
            String s3;
            boolean flag;
            if (deepLinkUtil.isDeepLink(deepLinkWithApiParameters))
            {
                try
                {
                    Object obj = deepLinkUtil.getDeepLink(deepLinkWithApiParameters);
                    if (deepLinkManager.isDirectlyFollowable(((DeepLinkData) (obj))) && ((DeepLinkData) (obj)).getEndpoint().equals(Endpoint.SEARCH_RESULTS_WITH_UI))
                    {
                        deepLinkWithApiParameters = "/deals/search";
                        obj = Uri.parse(((DeepLinkData) (obj)).toString()).getEncodedQuery();
                        if (Strings.notEmpty(obj))
                        {
                            deepLinkWithApiParameters = (new StringBuilder()).append(deepLinkWithApiParameters).append("?").append(((String) (obj))).toString();
                        }
                    }
                }
                catch (InvalidDeepLinkException invaliddeeplinkexception) { }
            }
            deepLinkParametersForNstLogging = globalSearchUtil.mergeDeepLinkParams(deepLinkWithApiParameters, arraylist);
            return deepLinkParametersForNstLogging;
        }
        arraylist1 = new ArrayList();
        s3 = resultActivity.getSearchTerm();
        s1 = resultActivity.getCurrentCategoryId();
        entry = resultActivity.getSelectedCategory();
        s2 = resultActivity.getAvailableFacetGroupFiltersFromDeepLink();
        flag = resultActivity.isDeepLinked();
        place = resultActivity.getPlace();
        s = null;
        obj1 = s;
        if (Strings.notEmpty(s3))
        {
            if (Strings.notEmpty(s1))
            {
                if (currentCountryManager.getCurrentCountry().isUSACompatible())
                {
                    obj1 = "mobile_all";
                } else
                {
                    obj1 = "mobile_search_intl";
                }
                arraylist1.addAll(Arrays.asList(new String[] {
                    "filters", (new StringBuilder()).append("category:").append(s1).toString()
                }));
            } else
            if (entry != null)
            {
                s = ((Category)entry.getKey()).relevanceContext;
                obj1 = s;
                if (!((Category)entry.getKey()).isAllDeals)
                {
                    obj1 = new StringBuilder("category");
                    if (((Integer)entry.getValue()).intValue() > 1)
                    {
                        ((StringBuilder) (obj1)).append(entry.getValue());
                    }
                    ((StringBuilder) (obj1)).append(":");
                    ((StringBuilder) (obj1)).append(((Category)entry.getKey()).id);
                    arraylist1.addAll(Arrays.asList(new String[] {
                        "filters", ((StringBuilder) (obj1)).toString()
                    }));
                    obj1 = s;
                }
            } else
            {
                obj1 = s;
                if (Strings.isEmpty(s2))
                {
                    arraylist1.addAll(Arrays.asList(new String[] {
                        "query", s3
                    }));
                    obj1 = s;
                }
            }
        }
        if (Strings.notEmpty(s2))
        {
            arraylist1.addAll(Arrays.asList(new String[] {
                "facet_group_filters", s2
            }));
        }
        s = ((String) (obj1));
        if (Strings.isEmpty(obj1))
        {
            if (currentCountryManager.getCurrentCountry().isUSACompatible())
            {
                if (flag)
                {
                    s = "mobile_all";
                } else
                {
                    s = "mobile_search";
                }
            } else
            {
                s = "mobile_search_intl";
            }
        }
        arraylist1.addAll(Arrays.asList(new String[] {
            "relevance_context", s
        }));
        arraylist1.addAll(Arrays.asList(new Serializable[] {
            "lat", Double.valueOf(place.lat)
        }));
        arraylist1.addAll(Arrays.asList(new Serializable[] {
            "lng", Double.valueOf(place.lng)
        }));
        if (entry == null && Strings.isEmpty(s1))
        {
            obj1 = resultActivity.getSearchChannelFilter();
            if (obj1 != null)
            {
                arraylist1.addAll(Arrays.asList(new String[] {
                    "filters", String.format("topcategory:%1$s", new Object[] {
                        obj1
                    })
                }));
            }
        }
        arraylist.addAll(arraylist1);
        arraylist.add("other_deals");
        arraylist.add(Boolean.valueOf(true));
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "offset", Integer.valueOf(i), "limit", Integer.valueOf(j)
        }));
        return arraylist;
    }

    protected int getNextOffset()
        throws Exception
    {
        if (shouldForceUpdateOnAutoSync)
        {
            shouldForceUpdateOnAutoSync = false;
            return 0;
        }
        Pagination pagination = (Pagination)((DaoPagination)paginationDao.get()).queryForFirstEq("channel", channel);
        int i;
        if (pagination != null)
        {
            i = pagination.getNextOffset();
        } else
        {
            i = 0;
        }
        return i;
    }

    protected String getUrl(int i, int j)
        throws CountryNotSupportedException
    {
        return "https:/deals/search";
    }

    protected long lastUpdated()
        throws Exception
    {
        long l = SyncManagerUtils.getLastUpdatedForChannel(dealSummaryDao, channel);
        if (shouldForceUpdateOnAutoSync)
        {
            l = 0L;
        }
        return l;
    }

    protected void logGlobalSearchDealSearch(int i)
    {
        if (deepLinkParametersForNstLogging != null)
        {
            HashMap hashmap = HttpUtil.arrayToHash(deepLinkParametersForNstLogging);
            String s = (String)hashmap.get("query");
            String s1 = (String)hashmap.get("filters");
            Logger logger1 = logger;
            String s4 = Channel.GLOBAL_SEARCH.toString();
            String s5;
            if (!Strings.notEmpty(s))
            {
                s = "";
            }
            s5 = resultActivity.getOriginatingNstChannel().toString();
            if (!Strings.notEmpty(s1))
            {
                s1 = "";
            }
            logger1.logDealSearch("", s4, s, s5, s1, safeFloat((String)hashmap.get("lat")), safeFloat((String)hashmap.get("lng")), "pull", i, Logger.NULL_NST_FIELD);
            return;
        }
        String s3 = resultActivity.getSearchSourceChannel().toString();
        Object obj = resultActivity.getSelectedCategory();
        String s2;
        Place place;
        Logger logger2;
        String s6;
        if (obj != null)
        {
            obj = ((Category)((java.util.Map.Entry) (obj)).getKey()).id;
        } else
        {
            obj = "";
        }
        s2 = resultActivity.getSearchTerm();
        place = resultActivity.getPlace();
        logger2 = logger;
        s6 = Channel.GLOBAL_SEARCH.toString();
        if (Strings.notEmpty(obj))
        {
            s2 = "";
        }
        if (!Strings.notEmpty(obj))
        {
            obj = "";
        }
        logger2.logDealSearch("", s6, s2, s3, ((String) (obj)), (float)place.lng, (float)place.lat, "pull", i, Logger.NULL_NST_FIELD);
    }

    protected float safeFloat(String s)
    {
        float f;
        try
        {
            f = Float.parseFloat(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 0.0F;
        }
        return f;
    }

    public void setSearchTerm(String s)
    {
        searchTerm = s;
    }




}
