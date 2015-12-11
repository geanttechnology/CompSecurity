// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import android.os.SystemClock;
import com.groupon.db.dao.DaoHotel;
import com.groupon.db.events.HotelUpdateEvent;
import com.groupon.db.models.Hotel;
import com.groupon.http.synchronous.MarketRateSyncHttp;
import com.groupon.models.hotel.HotelDealResponse;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ApiRequestUtil;
import com.groupon.util.IOUtils;
import com.groupon.util.ObjectMapperWrapper;
import com.groupon.util.PausableThreadPoolExecutor;
import com.squareup.otto.Bus;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.groupon.manager:
//            GrouponSyncManager

public class HotelSyncManager extends GrouponSyncManager
{

    private static final String ACTION_ON_HOTEL_DETAILS_LOADED = "on_hotel_details_loaded";
    private AtomicBoolean downloaded;
    private boolean forceDownload;
    private Bus globalBus;
    private DaoHotel hotelDao;
    private String hotelId;
    private Logger logger;
    private ObjectMapperWrapper mapper;
    private boolean requestTripAdvisorReviews;

    public HotelSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor)
    {
        super(context, pausablethreadpoolexecutor);
        forceDownload = false;
        requestTripAdvisorReviews = false;
        downloaded = new AtomicBoolean(false);
    }

    private Object[] getNameValueParams()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(ApiRequestUtil.generateHotelShowParameters(requestTripAdvisorReviews));
        return arraylist.toArray();
    }

    protected volatile void doSync(Object obj)
        throws Exception
    {
        doSync((Void)obj);
    }

    protected void doSync(Void void1)
        throws Exception
    {
        long l;
        l = SystemClock.elapsedRealtime();
        void1 = (InputStream)(new MarketRateSyncHttp(context, java/io/InputStream, String.format("/getaways/hotels/%s", new Object[] {
            hotelId
        }), getNameValueParams())).call();
        final HotelDealResponse hotelObject = (HotelDealResponse)mapper.readValue(void1, com/groupon/models/hotel/HotelDealResponse);
        hotelObject.hotel.afterJsonDeserializationPostProcessor();
        hotelDao.callBatchTasks(new Callable() {

            final HotelSyncManager this$0;
            final HotelDealResponse val$hotelObject;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                hotelDao.replace(hotelObject.hotel);
                downloaded.set(true);
                return null;
            }

            
            {
                this$0 = HotelSyncManager.this;
                hotelObject = hoteldealresponse;
                super();
            }
        });
        globalBus.post(new HotelUpdateEvent(hotelObject.hotel.remoteId));
        long l1 = SystemClock.elapsedRealtime();
        logger.logGeneralEvent("hotel_performance", "on_hotel_details_loaded", hotelId, (int)(l1 - l), Logger.NULL_NST_FIELD);
        IOUtils.close(void1);
        return;
        Exception exception;
        exception;
        IOUtils.close(void1);
        throw exception;
    }

    public String getHotelId()
    {
        return hotelId;
    }

    public boolean isValid(Hotel hotel)
    {
        return hotel != null && (downloaded.get() || !forceDownload);
    }

    protected long lastUpdated()
        throws Exception
    {
        Hotel hotel = hotelDao.getByHotelId(hotelId);
        if (isValid(hotel))
        {
            return hotel.modificationDate.getTime();
        } else
        {
            return 0L;
        }
    }

    public void setHotelId(String s)
    {
        hotelId = s;
    }

    public void setRequestTripAdvisorReviews(boolean flag)
    {
        requestTripAdvisorReviews = flag;
    }


}
