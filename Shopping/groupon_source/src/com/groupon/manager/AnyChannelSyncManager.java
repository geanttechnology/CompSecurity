// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import com.groupon.db.dao.DaoDealSubsetAttribute;
import com.groupon.db.dao.DaoDealSummary;
import com.groupon.db.dao.DaoPagination;
import com.groupon.db.events.ChannelUpdateEvent;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.Pagination;
import com.groupon.db.models.Relevance;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.manager.deserializer.StreamingJsonDeserializer;
import com.groupon.models.DealsResponse;
import com.groupon.models.country.Country;
import com.groupon.models.division.Division;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.util.ApiGenerateShowParamBuilder;
import com.groupon.util.BuyUtils;
import com.groupon.util.CarouselExecutorManager;
import com.groupon.util.CountryNotSupportedException;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.DivisionUtil;
import com.groupon.util.ExecutorManager;
import com.groupon.util.IOUtils;
import com.groupon.util.IncentivesUtil;
import com.groupon.util.LoggingUtils;
import com.groupon.util.MutableInteger;
import com.groupon.util.ObjectMapperWrapper;
import com.groupon.util.PausableThreadPoolExecutor;
import com.groupon.util.SmuggleDealManager;
import com.groupon.util.SmuggleUtil;
import com.j256.ormlite.dao.Dao;
import com.squareup.otto.Bus;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.manager:
//            GrouponPaginatedSyncManager, WidgetsSyncHelper, SyncManagerUtils, AsyncHttp

public class AnyChannelSyncManager extends GrouponPaginatedSyncManager
{
    public class DealDeserializer extends StreamingJsonDeserializer
    {

        final AnyChannelSyncManager this$0;

        public Deal deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException
        {
            try
            {
                jsonparser = (Deal)internalMapper.readValue(jsonparser, com/groupon/db/models/Deal);
                jsonparser.afterJsonDeserializationPostProcessor(buyUtil);
                smuggledDealPermalinksReadLock.lock();
            }
            // Misplaced declaration of an exception variable
            catch (JsonParser jsonparser)
            {
                throw new RuntimeException(jsonparser);
            }
            jsonparser = (new DealSummary(jsonparser, channel)).checkIfDerivedDealIsSmuggled(smuggledDealPermalinks);
            smuggledDealPermalinksReadLock.unlock();
            dealSummaryDao.save(jsonparser);
            return null;
            jsonparser;
            smuggledDealPermalinksReadLock.unlock();
            throw jsonparser;
        }

        public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
        {
            return deserialize(jsonparser, deserializationcontext);
        }

        public DealDeserializer()
        {
            this$0 = AnyChannelSyncManager.this;
            super();
        }
    }


    protected AbTestService abTestService;
    protected BuyUtils buyUtil;
    protected String channel;
    private String channelId;
    private String channelOptions[];
    protected CurrentCountryManager currentCountryManager;
    protected Lazy currentDivisionManager;
    protected Lazy dealSubsetAttributeDao;
    protected DaoDealSummary dealSummaryDao;
    protected Lazy deviceInfoUtil;
    protected Lazy divisionUtil;
    protected String fragmentName;
    protected Bus globalBus;
    protected Lazy incentivesUtil;
    private ObjectMapperWrapper internalMapper;
    protected Lazy loggingUtils;
    protected ObjectMapper mapper;
    private String nstChannel;
    protected Lazy paginationDao;
    protected String referrer;
    protected String searchCategory;
    protected Lazy smuggleDealManager;
    protected Lazy smuggleUtil;
    private Set smuggledDealPermalinks;
    private final Lock smuggledDealPermalinksReadLock;
    private final Lock smuggledDealPermalinksWriteLock;
    private final ReadWriteLock smuggledDealPermalinksreadWriteLock;
    protected boolean widgetsSupported;
    protected boolean widgetsSupportedINTL;
    protected boolean widgetsSupportedUSA;
    private WidgetsSyncHelper widgetsSyncHelper;

    public AnyChannelSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor, ExecutorManager executormanager, String s)
    {
        super(context, pausablethreadpoolexecutor, executormanager);
        smuggledDealPermalinksreadWriteLock = new ReentrantReadWriteLock();
        smuggledDealPermalinksReadLock = smuggledDealPermalinksreadWriteLock.readLock();
        smuggledDealPermalinksWriteLock = smuggledDealPermalinksreadWriteLock.writeLock();
        searchCategory = "";
        widgetsSupported = false;
        widgetsSupportedUSA = false;
        widgetsSupportedINTL = false;
        channel = s;
    }

    public AnyChannelSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor, String s, CarouselExecutorManager carouselexecutormanager)
    {
        super(context, pausablethreadpoolexecutor, carouselexecutormanager);
        smuggledDealPermalinksreadWriteLock = new ReentrantReadWriteLock();
        smuggledDealPermalinksReadLock = smuggledDealPermalinksreadWriteLock.readLock();
        smuggledDealPermalinksWriteLock = smuggledDealPermalinksreadWriteLock.writeLock();
        searchCategory = "";
        widgetsSupported = false;
        widgetsSupportedUSA = false;
        widgetsSupportedINTL = false;
        channel = s;
    }

    public AnyChannelSyncManager(Context context, String s)
    {
        super(context);
        smuggledDealPermalinksreadWriteLock = new ReentrantReadWriteLock();
        smuggledDealPermalinksReadLock = smuggledDealPermalinksreadWriteLock.readLock();
        smuggledDealPermalinksWriteLock = smuggledDealPermalinksreadWriteLock.writeLock();
        searchCategory = "";
        widgetsSupported = false;
        widgetsSupportedUSA = false;
        widgetsSupportedINTL = false;
        channel = s;
    }

    private void doInitSmuggledDealIdSet()
    {
        smuggledDealPermalinksWriteLock.lock();
        smuggledDealPermalinks = ((SmuggleDealManager)smuggleDealManager.get()).getDealIdsToBeSmuggled(channel);
        smuggledDealPermalinksWriteLock.unlock();
        return;
        Object obj;
        obj;
        ((Exception) (obj)).printStackTrace();
        smuggledDealPermalinksWriteLock.unlock();
        return;
        obj;
        smuggledDealPermalinksWriteLock.unlock();
        throw obj;
    }

    private void init()
    {
        paginationDao = new Lazy(context) {

            final AnyChannelSyncManager this$0;

            
            {
                this$0 = AnyChannelSyncManager.this;
                super(context);
            }
        };
        dealSubsetAttributeDao = new Lazy(context) {

            final AnyChannelSyncManager this$0;

            
            {
                this$0 = AnyChannelSyncManager.this;
                super(context);
            }
        };
        currentDivisionManager = new Lazy(context) {

            final AnyChannelSyncManager this$0;

            
            {
                this$0 = AnyChannelSyncManager.this;
                super(context);
            }
        };
        divisionUtil = new Lazy(context) {

            final AnyChannelSyncManager this$0;

            
            {
                this$0 = AnyChannelSyncManager.this;
                super(context);
            }
        };
        loggingUtils = new Lazy(context) {

            final AnyChannelSyncManager this$0;

            
            {
                this$0 = AnyChannelSyncManager.this;
                super(context);
            }
        };
        deviceInfoUtil = new Lazy(context) {

            final AnyChannelSyncManager this$0;

            
            {
                this$0 = AnyChannelSyncManager.this;
                super(context);
            }
        };
        incentivesUtil = new Lazy(context) {

            final AnyChannelSyncManager this$0;

            
            {
                this$0 = AnyChannelSyncManager.this;
                super(context);
            }
        };
        smuggleDealManager = new Lazy(context) {

            final AnyChannelSyncManager this$0;

            
            {
                this$0 = AnyChannelSyncManager.this;
                super(context);
            }
        };
        smuggleUtil = new Lazy(context) {

            final AnyChannelSyncManager this$0;

            
            {
                this$0 = AnyChannelSyncManager.this;
                super(context);
            }
        };
    }

    protected ObjectMapper createObjectMapper()
    {
        ObjectMapper objectmapper = new ObjectMapper();
        SimpleModule simplemodule = new SimpleModule("DealDeserializerModule", new Version(1, 0, 0, null));
        simplemodule.addDeserializer(com/groupon/db/models/Deal, new DealDeserializer());
        objectmapper.registerModule(simplemodule);
        return objectmapper;
    }

    protected void doInitDoSyncObjectMapper()
    {
        if (mapper != null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        this;
        JVM INSTR monitorenter ;
        if (mapper == null)
        {
            mapper = createObjectMapper();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected volatile void doSync(Object obj, int i, int j)
        throws Exception
    {
        doSync((Void)obj, i, j);
    }

    protected void doSync(final Void widgetsAsyncHttp, final int offset, int i)
        throws Exception
    {
        final InputStream m;
        Ln.d((new StringBuilder()).append("Start doSync for channel ").append(channel).toString(), new Object[0]);
        SyncHttp synchttp;
        final Object nameValueParams[];
        final MutableInteger dealCount;
        long l;
        if (widgetsSyncHelper != null && widgetsSyncHelper.isEnabled(widgetsAsyncHttp, offset, i))
        {
            widgetsAsyncHttp = widgetsSyncHelper.startAsyncRequest();
        } else
        {
            widgetsAsyncHttp = null;
        }
        l = System.currentTimeMillis();
        synchttp = getSyncHttp(offset, i);
        m = (InputStream)synchttp.call();
        nameValueParams = synchttp.nvps();
        dealCount = new MutableInteger(0);
        doInitSmuggledDealIdSet();
        doInitDoSyncObjectMapper();
        dealSummaryDao.callBatchTasks(new Callable() {

            final AnyChannelSyncManager this$0;
            final MutableInteger val$dealCount;
            final InputStream val$m;
            final Object val$nameValueParams[];
            final int val$offset;
            final AsyncHttp val$widgetsAsyncHttp;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                InputStream inputstream;
                Object obj1;
                DealsResponse dealsresponse;
                SyncManagerUtils.deleteRecordsForChannel((Dao)paginationDao.get(), channel);
                SyncManagerUtils.deleteRecordsForChannel((Dao)dealSubsetAttributeDao.get(), channel);
                if (offset == 0)
                {
                    SyncManagerUtils.deleteRecordsForChannel(dealSummaryDao, channel);
                }
                dealsresponse = (DealsResponse)mapper.readValue(m, com/groupon/models/DealsResponse);
                dealCount.set(dealsresponse.deals.size());
                if (dealsresponse.pagination != null)
                {
                    dealsresponse.pagination.setChannel(channel);
                    dealsresponse.pagination.setCurrentOffset(offset);
                    dealsresponse.pagination.setNextOffset(offset + dealCount.get());
                    Object obj = dealsresponse.pagination;
                    DealSubsetAttribute dealsubsetattribute;
                    boolean flag;
                    if (dealCount.get() > 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    ((Pagination) (obj)).setHasMorePages(flag);
                    ((DaoPagination)paginationDao.get()).create(dealsresponse.pagination);
                }
                if (dealsresponse.dealSubsetAttributes != null)
                {
                    for (obj = dealsresponse.dealSubsetAttributes.iterator(); ((Iterator) (obj)).hasNext(); ((DaoDealSubsetAttribute)dealSubsetAttributeDao.get()).create(dealsubsetattribute))
                    {
                        dealsubsetattribute = (DealSubsetAttribute)((Iterator) (obj)).next();
                        dealsubsetattribute.channel = channel;
                    }

                }
                if (widgetsAsyncHttp == null)
                {
                    break MISSING_BLOCK_LABEL_338;
                }
                obj1 = null;
                inputstream = null;
                InputStream inputstream1 = (InputStream)widgetsAsyncHttp.get();
                inputstream = inputstream1;
                obj1 = inputstream1;
                widgetsSyncHelper.process(inputstream1, widgetsAsyncHttp.getParams());
                if (inputstream1 != null)
                {
                    IOUtils.close(inputstream1);
                }
_L2:
                if (offset == 0 && dealCount.get() > 0)
                {
                    logDealSearch(getFragmentName(), getNstChannel(), nameValueParams, "full_list", searchCategory, dealsresponse.relevanceService, dealCount.get());
                }
                return null;
                obj1;
                if (inputstream != null)
                {
                    IOUtils.close(inputstream);
                }
                if (true) goto _L2; else goto _L1
_L1:
                Exception exception;
                exception;
                if (obj1 != null)
                {
                    IOUtils.close(((java.io.Closeable) (obj1)));
                }
                throw exception;
            }

            
            {
                this$0 = AnyChannelSyncManager.this;
                offset = i;
                m = inputstream;
                dealCount = mutableinteger;
                widgetsAsyncHttp = asynchttp;
                nameValueParams = aobj;
                super();
            }
        });
        globalBus.post(new ChannelUpdateEvent(channel, dealCount.get()));
        ((LoggingUtils)loggingUtils.get()).logListLoadingPerformance(String.format("%sV2", new Object[] {
            channel
        }), l, dealCount.get());
        Ln.d((new StringBuilder()).append("End doSync for channel ").append(channel).toString(), new Object[0]);
        IOUtils.close(m);
        return;
        widgetsAsyncHttp;
        IOUtils.close(m);
        throw widgetsAsyncHttp;
    }

    protected String generateShowParameterValue()
    {
        return (new ApiGenerateShowParamBuilder()).dealSpecificAttributes(includesDealsWithSpecificAttributes()).dealOptionGiftWrappingCharge(includesGiftWrappableDeals()).bookingUpdatesSchedulerOptions(true).dealCard(true).incentives(((IncentivesUtil)incentivesUtil.get()).isExperimentEnabled()).images(true).build();
    }

    public String getChannelId()
    {
        return channelId;
    }

    public String[] getChannelOptions()
    {
        return channelOptions;
    }

    public String getFragmentName()
    {
        return fragmentName;
    }

    protected List getNameValueParams(int i, int j)
    {
        ArrayList arraylist = new ArrayList();
        if (channelOptions != null && channelOptions.length > 0)
        {
            arraylist.addAll(Arrays.asList(channelOptions));
        }
        if (!currentCountryManager.getCurrentCountry().isUSACompatible() && !currentCountryManager.getCurrentCountry().isJapan())
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "lang", ((DeviceInfoUtil)deviceInfoUtil.get()).getLanguageFromLocale()
            }));
            String s;
            if (currentCountryManager.getCurrentCountry().isLATAMCompatible())
            {
                arraylist.addAll(((DivisionUtil)divisionUtil.get()).getDivisionNameValuePairsUnchecked(null));
            } else
            {
                arraylist.addAll(Arrays.asList(new String[] {
                    "division_id", ((CurrentDivisionManager)currentDivisionManager.get()).getCurrentDivision().getIdOrParentId()
                }));
            }
        } else
        {
            if (shouldAddChannelParam())
            {
                arraylist.addAll(Arrays.asList(new String[] {
                    "channel_id", channelId.toLowerCase(Locale.US)
                }));
            }
            if (shouldAddPersistedDivisionParams())
            {
                arraylist.addAll(((DivisionUtil)divisionUtil.get()).getDivisionNameValuePairsUnchecked(null));
            }
            arraylist.addAll(Arrays.asList(new String[] {
                "lang", ((DeviceInfoUtil)deviceInfoUtil.get()).getLanguageFromLocale()
            }));
        }
        s = generateShowParameterValue();
        if (s != null)
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "show", s
            }));
        }
        if (Strings.notEmpty(referrer))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "referrer", referrer
            }));
        }
        if (showSmuggledDeals())
        {
            ((SmuggleUtil)smuggleUtil.get()).addDealIdsToBeSmuggledToNameValuesList(arraylist, ((SmuggleDealManager)smuggleDealManager.get()).getDealIdsToBeSmuggled(channelId));
        }
        return arraylist;
    }

    protected int getNextOffset()
        throws Exception
    {
        Pagination pagination = (Pagination)((DaoPagination)paginationDao.get()).queryForFirstEq("channel", channel);
        if (pagination != null)
        {
            return pagination.getNextOffset();
        } else
        {
            return 0;
        }
    }

    public String getNstChannel()
    {
        return nstChannel;
    }

    protected SyncHttp getSyncHttp(int i, int j)
        throws Exception
    {
        return new SyncHttp(context, java/io/InputStream, getUrl(i, j), getNameValueParams(i, j).toArray());
    }

    protected String getUrl(int i, int j)
        throws CountryNotSupportedException
    {
        String s;
        if (currentCountryManager.getCurrentCountry().isUSACompatible() || currentCountryManager.getCurrentCountry().isJapan())
        {
            s = "https:/deals";
        } else
        {
            s = String.format("https:/channels/%s/deals", new Object[] {
                channelId.toLowerCase(Locale.US)
            });
        }
        return String.format("%s?offset=%s&limit=%s", new Object[] {
            s, Integer.valueOf(i), Integer.valueOf(j)
        });
    }

    public WidgetsSyncHelper getWidgetsSyncHelper()
    {
        return widgetsSyncHelper;
    }

    protected boolean includesDealsWithSpecificAttributes()
    {
        return false;
    }

    protected boolean includesGiftWrappableDeals()
    {
        return true;
    }

    protected long lastUpdated()
        throws Exception
    {
        return SyncManagerUtils.getLastUpdatedForChannel(dealSummaryDao, channel);
    }

    protected void logDealSearch(String s, String s1, Object aobj[], String s2, String s3, Relevance relevance, int i)
    {
        LoggingUtils loggingutils = (LoggingUtils)loggingUtils.get();
        boolean flag;
        if (s != null && requiresRedirectLogging())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        loggingutils.logDealSearch(s, s1, aobj, s2, s3, relevance, i, flag);
    }

    protected boolean requiresRedirectLogging()
    {
        return true;
    }

    public void setChannel(String s)
    {
        channel = s;
    }

    public void setChannelId(String s)
    {
        channelId = s;
    }

    public void setChannelOptions(String as[])
    {
        channelOptions = as;
    }

    public void setFragmentName(String s)
    {
        fragmentName = s;
        if (widgetsSupported)
        {
            widgetsSyncHelper.fragmentName = s;
        }
    }

    public void setNstChannel(String s)
    {
        nstChannel = s;
    }

    public void setWidgetsSyncHelper(WidgetsSyncHelper widgetssynchelper)
    {
        widgetsSyncHelper = widgetssynchelper;
    }

    protected boolean shouldAddChannelParam()
    {
        return true;
    }

    protected boolean shouldAddPersistedDivisionParams()
    {
        return true;
    }

    protected boolean showSmuggledDeals()
    {
        return true;
    }

    public String toString()
    {
        return (new StringBuilder()).append(super.toString()).append("[").append(channel).append("]").toString();
    }




}
