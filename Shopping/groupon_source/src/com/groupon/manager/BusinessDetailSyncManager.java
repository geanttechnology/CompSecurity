// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import com.groupon.db.dao.DaoBusiness;
import com.groupon.db.dao.DaoSpecial;
import com.groupon.db.dao.DaoTip;
import com.groupon.db.events.BusinessUpdateEvent;
import com.groupon.db.models.Business;
import com.groupon.db.models.Special;
import com.groupon.db.models.Tip;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.util.BuyUtils;
import com.groupon.util.IOUtils;
import com.groupon.util.ObjectMapperWrapper;
import com.groupon.util.PausableThreadPoolExecutor;
import com.squareup.otto.Bus;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.manager:
//            GrouponSyncManager

public class BusinessDetailSyncManager extends GrouponSyncManager
{
    protected static class BusinessResponse
    {

        public Business business;

        protected BusinessResponse()
        {
        }
    }


    private BuyUtils buyUtil;
    private DaoBusiness daoBusiness;
    private DaoSpecial daoSpecial;
    private DaoTip daoTip;
    private Bus globalBus;
    private ObjectMapperWrapper mapper;
    private String merchantId;

    public BusinessDetailSyncManager(Context context)
    {
        super(context);
    }

    public BusinessDetailSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor)
    {
        super(context, pausablethreadpoolexecutor);
    }

    protected volatile void doSync(Object obj)
        throws Exception
    {
        doSync((Void)obj);
    }

    protected void doSync(final Void m)
        throws Exception
    {
        Ln.d("Start doSync for merchant details", new Object[0]);
        m = (InputStream)(new SyncHttp(context, java/io/InputStream, (new StringBuilder()).append("https:/businesses/").append(merchantId).toString())).call();
        daoBusiness.callBatchTasks(new Callable() {

            final BusinessDetailSyncManager this$0;
            final InputStream val$m;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                BusinessResponse businessresponse = (BusinessResponse)mapper.readValue(m, com/groupon/manager/BusinessDetailSyncManager$BusinessResponse);
                if (businessresponse.business == null)
                {
                    return null;
                }
                businessresponse.business.afterJsonDeserializationPostProcessor(buyUtil);
                Special special;
                for (Iterator iterator = businessresponse.business.getSpecials().iterator(); iterator.hasNext(); daoSpecial.clear(special.remoteId))
                {
                    special = (Special)iterator.next();
                }

                Tip tip;
                for (Iterator iterator1 = businessresponse.business.getTips().iterator(); iterator1.hasNext(); daoTip.clearByTipIdAndBusinessTipId(tip.remoteId, businessresponse.business.remoteId))
                {
                    tip = (Tip)iterator1.next();
                }

                daoBusiness.clearByChannelId(businessresponse.business.remoteId);
                businessresponse.business.channel = businessresponse.business.remoteId;
                daoBusiness.save(businessresponse.business);
                return null;
            }

            
            {
                this$0 = BusinessDetailSyncManager.this;
                m = inputstream;
                super();
            }
        });
        globalBus.post(new BusinessUpdateEvent(merchantId));
        Ln.d("End doSync for merchant details", new Object[0]);
        IOUtils.close(m);
        return;
        Exception exception;
        exception;
        IOUtils.close(m);
        throw exception;
    }

    protected long lastUpdated()
        throws Exception
    {
        return 0L;
    }

    public void setMerchantId(String s)
    {
        merchantId = s;
    }





}
