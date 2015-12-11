// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import android.os.SystemClock;
import com.groupon.abtest.RapiAbTestHelper;
import com.groupon.db.dao.DaoDeal;
import com.groupon.db.events.DealUpdateEvent;
import com.groupon.db.models.Deal;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.models.country.Country;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ApiGenerateShowParamBuilder;
import com.groupon.util.BuyUtils;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.IOUtils;
import com.groupon.util.IncentivesUtil;
import com.groupon.util.ObjectMapperWrapper;
import com.groupon.util.PausableThreadPoolExecutor;
import com.groupon.util.UiTreatmentsUtil;
import com.squareup.otto.Bus;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.restlet.engine.util.InternetUsDateFormat;
import roboguice.inject.Lazy;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.manager:
//            GrouponSyncManager, SyncManagerUtils

public class DealSyncManager extends GrouponSyncManager
{
    protected static class DealResponse
    {

        private Deal deal;


        protected DealResponse()
        {
        }
    }


    private Lazy abTestService;
    private Lazy buyUtil;
    private Date checkInDate;
    private Date checkOutDate;
    private CurrentCountryManager currentCountryManager;
    private CurrentDivisionManager currentDivisionManager;
    private Lazy dealDao;
    private String dealId;
    protected Lazy deviceInfoUtil;
    private AtomicBoolean downloaded;
    private boolean forceDownload;
    private Bus globalBus;
    private Lazy incentivesUtil;
    private boolean includeMerchantPersona;
    private boolean includeMerchantRecommendationAndTips;
    private Lazy internetUsDateFormat;
    private Logger logger;
    private ObjectMapperWrapper mapper;
    private Lazy rapiAbTestHelper;
    private Lazy uiTreatmentsUtil;

    public DealSyncManager(Context context)
    {
        super(context);
        forceDownload = false;
        downloaded = new AtomicBoolean(false);
    }

    public DealSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor)
    {
        super(context, pausablethreadpoolexecutor);
        forceDownload = false;
        downloaded = new AtomicBoolean(false);
        abTestService = new Lazy(context) {

            final DealSyncManager this$0;

            
            {
                this$0 = DealSyncManager.this;
                super(context);
            }
        };
        rapiAbTestHelper = new Lazy(context) {

            final DealSyncManager this$0;

            
            {
                this$0 = DealSyncManager.this;
                super(context);
            }
        };
        dealDao = new Lazy(context) {

            final DealSyncManager this$0;

            
            {
                this$0 = DealSyncManager.this;
                super(context);
            }
        };
        buyUtil = new Lazy(context) {

            final DealSyncManager this$0;

            
            {
                this$0 = DealSyncManager.this;
                super(context);
            }
        };
        incentivesUtil = new Lazy(context) {

            final DealSyncManager this$0;

            
            {
                this$0 = DealSyncManager.this;
                super(context);
            }
        };
        internetUsDateFormat = new Lazy(context) {

            final DealSyncManager this$0;

            
            {
                this$0 = DealSyncManager.this;
                super(context);
            }
        };
        uiTreatmentsUtil = new Lazy(context) {

            final DealSyncManager this$0;

            
            {
                this$0 = DealSyncManager.this;
                super(context);
            }
        };
        deviceInfoUtil = new Lazy(context) {

            final DealSyncManager this$0;

            
            {
                this$0 = DealSyncManager.this;
                super(context);
            }
        };
    }

    protected volatile void doSync(Object obj)
        throws Exception
    {
        doSync((Void)obj);
    }

    protected void doSync(Void void1)
        throws Exception
    {
        Ln.d("Start doSync for deal details", new Object[0]);
        final DealResponse dealObject;
        long l;
        long l1;
        boolean flag;
        boolean flag1;
        boolean flag2;
        if (!currentCountryManager.getCurrentCountry().isUSACompatible() && ((AbTestService)abTestService.get()).isVariantEnabled("multioptions1508INTL", "on"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = ((AbTestService)abTestService.get()).isVariantEnabled("thirdPartyLinkout1509", "on");
        void1 = currentDivisionManager.getCurrentDivision();
        flag2 = ((RapiAbTestHelper)rapiAbTestHelper.get()).isDTFforEitherHBWOrFDEnabled(void1);
        void1 = new ArrayList(Arrays.asList(new Object[] {
            "show", (new ApiGenerateShowParamBuilder()).dealSpecificAttributes(true).includeLegalDisclosure(currentCountryManager.getCurrentCountry().isUSACompatible()).dealOptionGiftWrappingCharge(true).bookingUpdatesSchedulerOptions(true).tips(includeMerchantRecommendationAndTips).connectedMarketPlace(includeMerchantPersona).incentives(((IncentivesUtil)incentivesUtil.get()).isExperimentEnabled()).inventoryService(true).recommendations(includeMerchantRecommendationAndTips).images(true).channels(flag).includeExternalDealProvider(flag1).categorizations(flag2).includeUiTreatments(((UiTreatmentsUtil)uiTreatmentsUtil.get()).isExperimentEnabled()).build()
        }));
        void1.addAll(Arrays.asList(new String[] {
            "lang", ((DeviceInfoUtil)deviceInfoUtil.get()).getLanguageFromLocale()
        }));
        if (includeMerchantRecommendationAndTips)
        {
            void1.addAll(Arrays.asList(new Serializable[] {
                "merchantTipsLimit", Integer.valueOf(3)
            }));
        }
        if (checkInDate != null && checkOutDate != null)
        {
            void1.addAll(Arrays.asList(new String[] {
                "start_date", ((InternetUsDateFormat)internetUsDateFormat.get()).format("yyyy-MM-dd", checkInDate).toString()
            }));
            void1.addAll(Arrays.asList(new String[] {
                "end_date", ((InternetUsDateFormat)internetUsDateFormat.get()).format("yyyy-MM-dd", checkOutDate).toString()
            }));
        }
        l = SystemClock.currentThreadTimeMillis();
        void1 = (InputStream)(new SyncHttp(context, java/io/InputStream, (new StringBuilder()).append("https:/deals/").append(dealId).toString(), void1.toArray())).call();
        l1 = SystemClock.currentThreadTimeMillis();
        logger.logGeneralEvent("deal_performance", "deal_request_duration", dealId, (int)(l1 - l), Logger.NULL_NST_FIELD);
        l = SystemClock.currentThreadTimeMillis();
        dealObject = (DealResponse)mapper.readValue(void1, com/groupon/manager/DealSyncManager$DealResponse);
        l1 = SystemClock.currentThreadTimeMillis();
        logger.logGeneralEvent("deal_performance", "deal_json_parsing", dealId, (int)(l1 - l), Logger.NULL_NST_FIELD);
        l = SystemClock.currentThreadTimeMillis();
        dealObject.deal.afterJsonDeserializationPostProcessor((BuyUtils)buyUtil.get());
        l1 = SystemClock.currentThreadTimeMillis();
        logger.logGeneralEvent("deal_performance", "deal_post_process", dealId, (int)(l1 - l), Logger.NULL_NST_FIELD);
        ((DaoDeal)dealDao.get()).callBatchTasks(new Callable() {

            final DealSyncManager this$0;
            final DealResponse val$dealObject;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                long l2 = SystemClock.currentThreadTimeMillis();
                ((DaoDeal)dealDao.get()).save(dealObject.deal);
                long l3 = SystemClock.currentThreadTimeMillis();
                logger.logGeneralEvent("deal_performance", "store_deal_to_db", dealId, (int)(l3 - l2), Logger.NULL_NST_FIELD);
                downloaded.set(true);
                return null;
            }

            
            {
                this$0 = DealSyncManager.this;
                dealObject = dealresponse;
                super();
            }
        });
        globalBus.post(new DealUpdateEvent(dealObject.deal.remoteId));
        Ln.d("End doSync for deal details", new Object[0]);
        IOUtils.close(void1);
        return;
        Exception exception;
        exception;
        IOUtils.close(void1);
        throw exception;
    }

    public Date getCheckInDate()
    {
        return checkInDate;
    }

    public Date getCheckOutDate()
    {
        return checkOutDate;
    }

    public String getDealId()
    {
        return dealId;
    }

    public boolean isForceDownload()
    {
        return forceDownload;
    }

    public boolean isIncludeMerchantPersona()
    {
        return includeMerchantPersona;
    }

    public boolean isIncludeMerchantRecommendationAndTips()
    {
        return includeMerchantRecommendationAndTips;
    }

    public boolean isValid(Deal deal)
    {
        return deal != null && (downloaded.get() || !forceDownload && (deal.getOptions().size() <= 0 || deal.isOptionListComplete));
    }

    protected long lastUpdated()
        throws Exception
    {
        Deal deal = SyncManagerUtils.getDeal((DaoDeal)dealDao.get(), dealId);
        if (isValid(deal))
        {
            return deal.modificationDate.getTime();
        } else
        {
            return 0L;
        }
    }

    public void setCheckInDate(Date date)
    {
        checkInDate = date;
    }

    public void setCheckOutDate(Date date)
    {
        checkOutDate = date;
    }

    public void setDealId(String s)
    {
        dealId = s;
    }

    public void setForceDownload(boolean flag)
    {
        forceDownload = flag;
    }

    public void setIncludeMerchantPersona(boolean flag)
    {
        includeMerchantPersona = flag;
    }

    public void setIncludeMerchantRecommendationAndTips(boolean flag)
    {
        includeMerchantRecommendationAndTips = flag;
    }




}
