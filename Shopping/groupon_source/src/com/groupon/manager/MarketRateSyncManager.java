// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.app.Application;
import android.content.Context;
import android.text.format.DateFormat;
import com.groupon.db.dao.DaoMarketRateResult;
import com.groupon.db.dao.DaoPagination;
import com.groupon.db.events.ChannelUpdateEvent;
import com.groupon.db.models.MarketRateResult;
import com.groupon.db.models.Pagination;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.manager.deserializer.StreamingJsonDeserializer;
import com.groupon.models.MarketRateResultResponse;
import com.groupon.models.country.Country;
import com.groupon.models.division.Division;
import com.groupon.service.LocationService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.util.CarouselExecutorManager;
import com.groupon.util.ExecutorManager;
import com.groupon.util.GeoPoint;
import com.groupon.util.IOUtils;
import com.groupon.util.ImageUrl;
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
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.manager:
//            AnyChannelSyncManager, SyncManagerUtils

public class MarketRateSyncManager extends AnyChannelSyncManager
{
    public class HotelDeserializer extends StreamingJsonDeserializer
    {

        final MarketRateSyncManager this$0;

        public MarketRateResult deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException
        {
            deserializationcontext = (MarketRateResult)internalMapper.readValue(jsonparser, com/groupon/db/models/MarketRateResult);
            deserializationcontext.afterJsonDeserializationPostProcessor();
            if (!isSearchFlow)
            {
                break MISSING_BLOCK_LABEL_84;
            }
            jsonparser = pagerChannelAndSubchannel;
_L1:
            deserializationcontext.channel = jsonparser;
            marketRateResultDao.replace(deserializationcontext);
            UrlImageView.prefetch((Application)
// JavaClassFileOutputException: get_constant: invalid tag

        public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
        {
            return deserialize(jsonparser, deserializationcontext);
        }

        public HotelDeserializer()
        {
            this$0 = MarketRateSyncManager.this;
            super();
        }
    }


    private Date checkInDate;
    private Date checkOutDate;
    private GeoPoint currentLocationOrDivisionGeoPoint;
    private String destinationId;
    private ObjectMapperWrapper internalMapper;
    private boolean isSearchFlow;
    private LocationService locationService;
    private DaoMarketRateResult marketRateResultDao;
    private String pagerChannelAndSubchannel;

    public MarketRateSyncManager(Context context)
    {
        AnyChannelSyncManager(context, "MARKET_RATE");
    }

    public MarketRateSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor, CarouselExecutorManager carouselexecutormanager)
    {
        AnyChannelSyncManager(context, pausablethreadpoolexecutor, "MARKET_RATE", carouselexecutormanager);
    }

    public MarketRateSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor, ExecutorManager executormanager)
    {
        AnyChannelSyncManager(context, pausablethreadpoolexecutor, executormanager, "MARKET_RATE");
    }

    protected ObjectMapper createObjectMapper()
    {
        ObjectMapper objectmapper = new ObjectMapper();
        SimpleModule simplemodule = new SimpleModule("HotelDeserializerModule", new Version(1, 0, 0, null));
        simplemodule.addDeserializer(com/groupon/db/models/MarketRateResult, new HotelDeserializer());
        objectmapper.registerModule(simplemodule);
        return objectmapper;
    }

    protected volatile void doSync(Object obj, int i, int j)
        throws Exception
    {
        doSync((Void)obj, i, j);
    }

    protected void doSync(final Void inputStream, final int offset, int i)
        throws Exception
    {
        long l = System.currentTimeMillis();
        inputStream = getSyncHttp(offset, i);
        doInitDoSyncObjectMapper();
        inputStream.setObjectMapper(mapper);
        inputStream = (InputStream)inputStream.call();
        final MutableInteger dealCount = new MutableInteger(0);
        marketRateResultDao.callBatchTasks(new Callable() {

            final MarketRateSyncManager this$0;
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
                Object obj1 = (Dao)paginationDao.get();
                if (!isSearchFlow) goto _L2; else goto _L1
_L1:
                Object obj = pagerChannelAndSubchannel;
_L7:
                SyncManagerUtils.deleteRecordsForChannel(((Dao) (obj1)), ((String) (obj)));
                if (offset != 0) goto _L4; else goto _L3
_L3:
                obj1 = marketRateResultDao;
                if (!isSearchFlow)
                {
                    break MISSING_BLOCK_LABEL_251;
                }
                obj = pagerChannelAndSubchannel;
_L9:
                SyncManagerUtils.deleteRecordsForChannel(((Dao) (obj1)), ((String) (obj)));
_L4:
                Pagination pagination;
                obj1 = (MarketRateResultResponse)mapper.readValue(inputStream, com/groupon/models/MarketRateResultResponse);
                dealCount.set(((MarketRateResultResponse) (obj1)).results.size());
                pagination = ((MarketRateResultResponse) (obj1)).pagination;
                if (!isSearchFlow) goto _L6; else goto _L5
_L5:
                obj = pagerChannelAndSubchannel;
_L8:
                pagination.setChannel(((String) (obj)));
                ((MarketRateResultResponse) (obj1)).pagination.setCurrentOffset(offset);
                ((MarketRateResultResponse) (obj1)).pagination.setNextOffset(offset + dealCount.get());
                obj = ((MarketRateResultResponse) (obj1)).pagination;
                boolean flag;
                if (dealCount.get() > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                ((Pagination) (obj)).setHasMorePages(flag);
                ((DaoPagination)paginationDao.get()).create(((MarketRateResultResponse) (obj1)).pagination);
                IOUtils.close(inputStream);
                return null;
_L2:
                obj = "HOTELS";
                  goto _L7
_L6:
                obj = "HOTELS";
                  goto _L8
                obj;
                IOUtils.close(inputStream);
                throw obj;
                obj = "HOTELS";
                  goto _L9
            }

            
            {
                this$0 = MarketRateSyncManager.this;
                offset = i;
                inputStream = inputstream;
                dealCount = mutableinteger;
                super();
            }
        });
        Bus bus = globalBus;
        if (isSearchFlow)
        {
            inputStream = pagerChannelAndSubchannel;
        } else
        {
            inputStream = "HOTELS";
        }
        bus.post(new ChannelUpdateEvent(inputStream, dealCount.get()));
        ((LoggingUtils)loggingUtils.get()).logListLoadingPerformance(String.format("%sV2", new Object[] {
            channel
        }), l, dealCount.get());
    }

    protected List getNameValueParams(int i, int j)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList(new String[] {
            "inventory_type", Strings.join(",", new String[] {
                Strings.join(",", new String[] {
                    "HOTEL", "DEAL"
                }), "LASTMINUTE"
            })
        }));
        android.location.Location location;
        if (locationService.isAGpsProviderEnabled())
        {
            location = locationService.getLocation();
        } else
        {
            location = null;
        }
        if (location != null)
        {
            currentLocationOrDivisionGeoPoint = new GeoPoint(location);
        } else
        {
            currentLocationOrDivisionGeoPoint = ((CurrentDivisionManager)currentDivisionManager.get()).getCurrentDivision().geoPoint;
        }
        if (Strings.isEmpty(destinationId))
        {
            arraylist.addAll(Arrays.asList(new Serializable[] {
                "latitude", Float.valueOf(currentLocationOrDivisionGeoPoint.getLatitudeDegrees()), "longitude", Float.valueOf(currentLocationOrDivisionGeoPoint.getLongitudeDegrees())
            }));
        } else
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "destination_id", destinationId
            }));
        }
        if (checkInDate != null && checkOutDate != null)
        {
            arraylist.addAll(Arrays.asList(new CharSequence[] {
                "check_in", DateFormat.format("yyyy-MM-dd", checkInDate)
            }));
            arraylist.addAll(Arrays.asList(new CharSequence[] {
                "check_out", DateFormat.format("yyyy-MM-dd", checkOutDate)
            }));
        }
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "adults", Integer.valueOf(2)
        }));
        return arraylist;
    }

    protected int getNextOffset()
        throws Exception
    {
        DaoPagination daopagination = (DaoPagination)paginationDao.get();
        Object obj;
        if (isSearchFlow)
        {
            obj = pagerChannelAndSubchannel;
        } else
        {
            obj = "HOTELS";
        }
        obj = (Pagination)daopagination.queryForFirstEq("channel", obj);
        if (obj != null)
        {
            return ((Pagination) (obj)).getNextOffset();
        } else
        {
            return 0;
        }
    }

    public String getPagerChannelAndSubchannel()
    {
        return pagerChannelAndSubchannel;
    }

    protected String getUrl(int i, int j)
    {
        String s = (new StringBuilder()).append("pagination,").append("results.id,").append("results.title,").append("results.source,").append("results.productType,").append("results.announcementTitle,").append("results.address,").append("results.images,").append("results.avgMinPrice,").append("results.avgStrikePrice,").append("results.displayValue,").append("results.discountPercentage,").append("results.bucksPercentage,").append("results.hotelRating,").append("results.isSoldOut,").append("results.uuid,").append("results.hasRaO").toString();
        return String.format("%s?offset=%s&limit=%s&show=%s", new Object[] {
            String.format("/getaways/systems/%s/search", new Object[] {
                currentCountryManager.getCurrentCountry().isoName
            }), Integer.valueOf(i), Integer.valueOf(j), s
        });
    }

    public void init()
    {
    }

    public void setCheckInDate(Date date)
    {
        checkInDate = date;
    }

    public void setCheckOutDate(Date date)
    {
        checkOutDate = date;
    }

    public void setDestinationId(String s)
    {
        destinationId = s;
    }

    public void setPagerChannelAndSubchannel(String s)
    {
        pagerChannelAndSubchannel = s;
    }

    public void setSearchFlow(boolean flag)
    {
        isSearchFlow = flag;
    }





}
