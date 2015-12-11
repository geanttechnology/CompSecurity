// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import com.groupon.db.dao.DaoDeliveryEstimation;
import com.groupon.db.events.DeliveryEstimationUpdateEvent;
import com.groupon.db.models.DeliveryEstimation;
import com.groupon.http.synchronous.DeliveryEstimationSyncHttp;
import com.groupon.util.IOUtils;
import com.groupon.util.ObjectMapperWrapper;
import com.groupon.util.PausableThreadPoolExecutor;
import com.squareup.otto.Bus;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.manager:
//            GrouponSyncManager, SyncManagerUtils

public class DeliveryEstimationSyncManager extends GrouponSyncManager
{

    private String dealUuid;
    private DaoDeliveryEstimation deliveryAndEstimationDao;
    private AtomicBoolean downloaded;
    private Bus globalBus;
    private AtomicBoolean hasAutomaticEstimationSyncBeenStarted;
    private ObjectMapperWrapper mapper;
    private String optionUuid;

    public DeliveryEstimationSyncManager(Context context)
    {
        super(context);
        downloaded = new AtomicBoolean(false);
        hasAutomaticEstimationSyncBeenStarted = new AtomicBoolean(false);
    }

    public DeliveryEstimationSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor)
    {
        super(context, pausablethreadpoolexecutor);
        downloaded = new AtomicBoolean(false);
        hasAutomaticEstimationSyncBeenStarted = new AtomicBoolean(false);
    }

    protected volatile void doSync(Object obj)
        throws Exception
    {
        doSync((Void)obj);
    }

    protected void doSync(Void void1)
        throws Exception
    {
        Ln.d("Start doSync for delivery and estimation", new Object[0]);
        void1 = (InputStream)(new DeliveryEstimationSyncHttp(context, java/io/InputStream, String.format("/delivery/v1/estimates?dealUuid=%1s&optionUuid=%2s", new Object[] {
            dealUuid, optionUuid
        }))).call();
        DeliveryEstimation deliveryestimation;
        deliveryestimation = (DeliveryEstimation)mapper.readValue(void1, com/groupon/db/models/DeliveryEstimation);
        deliveryestimation.setDealsList();
        int i = 0;
_L2:
        if (i >= deliveryestimation.dealsList.size())
        {
            break; /* Loop/switch isn't completed */
        }
        deliveryestimation.afterJsonDeserializationPostProcessor((com.groupon.db.models.DeliveryEstimation.EstimatedDeals)deliveryestimation.dealsList.get(i));
        deliveryAndEstimationDao.save(deliveryestimation);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        Ln.d("End doSync for delivery and estimation", new Object[0]);
        IOUtils.close(void1);
        downloaded.set(true);
        globalBus.post(new DeliveryEstimationUpdateEvent(dealUuid));
        return;
        Exception exception;
        exception;
        IOUtils.close(void1);
        throw exception;
    }

    public boolean hasAutomaticSyncBeenStarted()
    {
        return hasAutomaticEstimationSyncBeenStarted.get();
    }

    public boolean isEstimationDownloaded()
    {
        return downloaded.get();
    }

    public boolean isEstimationValid(DeliveryEstimation deliveryestimation)
    {
        return Calendar.getInstance().getTime().getTime() - deliveryestimation.modificationDate.getTime() < TimeUnit.MINUTES.toMillis(5L);
    }

    protected long lastUpdated()
        throws Exception
    {
        DeliveryEstimation deliveryestimation = SyncManagerUtils.getEstimation(deliveryAndEstimationDao, dealUuid);
        if (deliveryestimation != null)
        {
            return deliveryestimation.modificationDate.getTime();
        } else
        {
            return 0L;
        }
    }

    public void setAutomaticSyncStatus(boolean flag)
    {
        hasAutomaticEstimationSyncBeenStarted.set(flag);
    }

    public void setDealUUID(String s)
    {
        dealUuid = s;
    }

    public void setOptionUUID(String s)
    {
        optionUuid = s;
    }
}
