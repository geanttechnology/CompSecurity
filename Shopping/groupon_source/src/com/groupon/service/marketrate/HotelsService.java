// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.marketrate;

import android.view.View;
import com.groupon.callbacks.HotelReviewsRequestCallback;
import com.groupon.callbacks.RaORequestCallback;
import com.groupon.db.models.HotelReviews;
import com.groupon.models.RoomDetails;
import com.groupon.models.country.Country;
import com.groupon.models.hotel.Destination;
import com.groupon.models.hotel.DestinationListWrapper;
import com.groupon.models.hotel.Hotel;
import com.groupon.models.hotel.HotelRoom;
import com.groupon.models.hotel.HotelSearchResponse;
import com.groupon.models.hotel.ImageFormat;
import com.groupon.models.hotel.Original;
import com.groupon.models.hotel.RaoResponseWrapper;
import com.groupon.models.hotel.Sizes;
import com.groupon.network.HttpResponseException;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.ApiRequestUtil;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.Function2;
import com.groupon.util.ImageUrl;
import com.groupon.util.ObjectMapperWrapper;
import com.groupon.util.ReturningFunction1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service.marketrate:
//            MarketRateServiceBase

public class HotelsService extends MarketRateServiceBase
{
    protected static class CreateReservationExceptionFunction
        implements ReturningFunction1
    {

        protected final Function1 onException;

        public Boolean execute(Exception exception)
        {
            if (onException != null)
            {
                onException.execute(exception);
            }
            return Boolean.valueOf(false);
        }

        public volatile Object execute(Object obj)
            throws Exception
        {
            return execute((Exception)obj);
        }

        public CreateReservationExceptionFunction(Function1 function1)
        {
            onException = function1;
        }
    }

    protected static class CreateReservationSuccessFunction
        implements Function1
    {

        protected final Function1 onSuccess;

        public void execute(HotelSearchResponse hotelsearchresponse)
        {
            if (onSuccess != null)
            {
                List list = hotelsearchresponse.reservations;
                hotelsearchresponse = list;
                if (list == null)
                {
                    hotelsearchresponse = new ArrayList();
                }
                onSuccess.execute(hotelsearchresponse);
            }
        }

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((HotelSearchResponse)obj);
        }

        public CreateReservationSuccessFunction(Function1 function1)
        {
            onSuccess = function1;
        }
    }

    protected static class DeleteRaOSuccessFunction
        implements Function1
    {

        protected final RaORequestCallback callback;

        public void execute(HotelSearchResponse hotelsearchresponse)
        {
            if (callback != null)
            {
                callback.onDeleteRaOSuccess();
            }
        }

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((HotelSearchResponse)obj);
        }

        public DeleteRaOSuccessFunction(RaORequestCallback raorequestcallback)
        {
            callback = raorequestcallback;
        }
    }

    protected static class GetDestinationExceptionFunction
        implements ReturningFunction1
    {

        protected final Function1 onException;

        public Boolean execute(Exception exception)
        {
            if (onException != null)
            {
                onException.execute(exception);
            }
            return Boolean.valueOf(false);
        }

        public volatile Object execute(Object obj)
            throws Exception
        {
            return execute((Exception)obj);
        }

        public GetDestinationExceptionFunction(Function1 function1)
        {
            onException = function1;
        }
    }

    protected class GetDestinationSuccessFunction
        implements Function1
    {

        protected final Function1 onSuccess;
        final HotelsService this$0;

        public void execute(HotelSearchResponse hotelsearchresponse)
        {
            if (onSuccess != null)
            {
                ArrayList arraylist = new ArrayList();
                hotelsearchresponse = hotelsearchresponse.destinationList;
                if (hotelsearchresponse != null)
                {
                    for (hotelsearchresponse = hotelsearchresponse.iterator(); hotelsearchresponse.hasNext();)
                    {
                        Iterator iterator = ((DestinationListWrapper)hotelsearchresponse.next()).destinations.iterator();
                        while (iterator.hasNext()) 
                        {
                            arraylist.add((Destination)iterator.next());
                        }
                    }

                }
                onSuccess.execute(arraylist);
            }
        }

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((HotelSearchResponse)obj);
        }

        public GetDestinationSuccessFunction(Function1 function1)
        {
            this$0 = HotelsService.this;
            super();
            onSuccess = function1;
        }
    }

    protected static class GetHotelImageUrlsExceptionFunction
        implements ReturningFunction1
    {

        protected final Function1 onException;

        public Boolean execute(Exception exception)
        {
            if (onException != null)
            {
                onException.execute(exception);
            }
            return Boolean.valueOf(false);
        }

        public volatile Object execute(Object obj)
            throws Exception
        {
            return execute((Exception)obj);
        }

        public GetHotelImageUrlsExceptionFunction(Function1 function1)
        {
            onException = function1;
        }
    }

    protected class GetHotelImageUrlsSuccessFunction
        implements Function1
    {

        protected final Function1 onSuccess;
        final HotelsService this$0;

        public void execute(HotelSearchResponse hotelsearchresponse)
        {
            if (onSuccess != null)
            {
                ArrayList arraylist = new ArrayList();
                hotelsearchresponse = hotelsearchresponse.images;
                if (hotelsearchresponse != null)
                {
                    Iterator iterator = hotelsearchresponse.iterator();
                    while (iterator.hasNext()) 
                    {
                        hotelsearchresponse = ((ImageFormat)iterator.next()).sizes.original.url;
                        if (!hotelsearchresponse.startsWith("http"))
                        {
                            hotelsearchresponse = (new StringBuilder()).append("http://").append(hotelsearchresponse).toString();
                        }
                        arraylist.add(new ImageUrl(hotelsearchresponse));
                    }
                }
                onSuccess.execute(arraylist);
            }
        }

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((HotelSearchResponse)obj);
        }

        public GetHotelImageUrlsSuccessFunction(Function1 function1)
        {
            this$0 = HotelsService.this;
            super();
            onSuccess = function1;
        }
    }

    protected static class GetHotelInventoryExceptionFunction
        implements ReturningFunction1
    {

        protected final Function1 onException;

        public Boolean execute(Exception exception)
        {
            boolean flag = false;
            int i;
            if (exception instanceof HttpResponseException)
            {
                i = ((HttpResponseException)exception).getStatusCode();
            } else
            {
                i = 0;
            }
            if (i == 404)
            {
                flag = true;
            }
            if (onException != null)
            {
                onException.execute(exception);
            }
            return Boolean.valueOf(flag);
        }

        public volatile Object execute(Object obj)
            throws Exception
        {
            return execute((Exception)obj);
        }

        public GetHotelInventoryExceptionFunction(Function1 function1)
        {
            onException = function1;
        }
    }

    protected static class GetHotelInventorySuccessFunction
        implements Function1
    {

        protected final Function2 onSuccess;

        public void execute(HotelSearchResponse hotelsearchresponse)
        {
            if (onSuccess != null)
            {
                List list = hotelsearchresponse.hotel.options;
                Object obj = list;
                if (list == null)
                {
                    obj = new ArrayList();
                }
                onSuccess.execute(obj, hotelsearchresponse.hotel.productType);
            }
        }

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((HotelSearchResponse)obj);
        }

        public GetHotelInventorySuccessFunction(Function2 function2)
        {
            onSuccess = function2;
        }
    }

    protected static class GetHotelReservationExceptionFunction
        implements ReturningFunction1
    {

        protected final Function1 onException;

        public Boolean execute(Exception exception)
        {
            boolean flag = false;
            int i;
            if (exception instanceof HttpResponseException)
            {
                i = ((HttpResponseException)exception).getStatusCode();
            } else
            {
                i = 0;
            }
            if (i == 404)
            {
                flag = true;
            }
            if (onException != null)
            {
                onException.execute(exception);
            }
            return Boolean.valueOf(flag);
        }

        public volatile Object execute(Object obj)
            throws Exception
        {
            return execute((Exception)obj);
        }

        public GetHotelReservationExceptionFunction(Function1 function1)
        {
            onException = function1;
        }
    }

    protected static class GetHotelReservationOnFinallyFunction
        implements Function0
    {

        protected final Function0 onFinally;

        public void execute()
        {
            if (onFinally != null)
            {
                onFinally.execute();
            }
        }

        public GetHotelReservationOnFinallyFunction(Function0 function0)
        {
            onFinally = function0;
        }
    }

    protected static class GetHotelReservationSuccessFunction
        implements Function1
    {

        protected final Function1 onSuccess;

        public void execute(HotelSearchResponse hotelsearchresponse)
        {
            if (onSuccess != null)
            {
                List list = hotelsearchresponse.reservations;
                hotelsearchresponse = list;
                if (list == null)
                {
                    hotelsearchresponse = new ArrayList();
                }
                onSuccess.execute(hotelsearchresponse);
            }
        }

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((HotelSearchResponse)obj);
        }

        public GetHotelReservationSuccessFunction(Function1 function1)
        {
            onSuccess = function1;
        }
    }

    protected static class GetHotelReviewsExceptionFunction
        implements ReturningFunction1
    {

        protected final HotelReviewsRequestCallback callback;

        public Boolean execute(Exception exception)
        {
            boolean flag = false;
            int i;
            if (exception instanceof HttpResponseException)
            {
                i = ((HttpResponseException)exception).getStatusCode();
            } else
            {
                i = 0;
            }
            if (i == 404)
            {
                flag = true;
            }
            if (callback != null)
            {
                callback.onException(exception);
            }
            return Boolean.valueOf(flag);
        }

        public volatile Object execute(Object obj)
            throws Exception
        {
            return execute((Exception)obj);
        }

        public GetHotelReviewsExceptionFunction(HotelReviewsRequestCallback hotelreviewsrequestcallback)
        {
            callback = hotelreviewsrequestcallback;
        }
    }

    protected class GetHotelReviewsSuccessFunction
        implements Function1
    {

        protected final HotelReviewsRequestCallback callback;
        private final String reviewSource;
        final HotelsService this$0;

        public void execute(HotelSearchResponse hotelsearchresponse)
            throws RuntimeException
        {
label0:
            {
                if (callback != null)
                {
                    hotelsearchresponse = hotelsearchresponse.hotel.hotelReviews.iterator();
                    HotelReviews hotelreviews;
                    do
                    {
                        if (!hotelsearchresponse.hasNext())
                        {
                            break label0;
                        }
                        hotelreviews = (HotelReviews)hotelsearchresponse.next();
                    } while (!Strings.equalsIgnoreCase(hotelreviews.sourceType, reviewSource));
                    callback.onHotelReviewsSuccess(hotelreviews);
                }
                return;
            }
            callback.onHotelReviewsSuccess(null);
        }

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((HotelSearchResponse)obj);
        }

        public GetHotelReviewsSuccessFunction(String s, HotelReviewsRequestCallback hotelreviewsrequestcallback)
        {
            this$0 = HotelsService.this;
            super();
            reviewSource = s;
            callback = hotelreviewsrequestcallback;
        }
    }

    protected static class RaOExceptionFunction
        implements ReturningFunction1
    {

        protected final RaORequestCallback callback;

        public Boolean execute(Exception exception)
        {
            boolean flag = false;
            int i;
            if (exception instanceof HttpResponseException)
            {
                i = ((HttpResponseException)exception).getStatusCode();
            } else
            {
                i = 0;
            }
            if (i == 404)
            {
                flag = true;
            }
            if (callback != null)
            {
                callback.onException(exception);
            }
            return Boolean.valueOf(flag);
        }

        public volatile Object execute(Object obj)
            throws Exception
        {
            return execute((Exception)obj);
        }

        public RaOExceptionFunction(RaORequestCallback raorequestcallback)
        {
            callback = raorequestcallback;
        }
    }

    protected static class RequestRaOSuccessFunction
        implements Function1
    {

        protected final RaORequestCallback callback;

        public void execute(HotelSearchResponse hotelsearchresponse)
        {
            if (callback != null)
            {
                RaoResponseWrapper raoresponsewrapper = new RaoResponseWrapper();
                raoresponsewrapper.waitTimeSecond = hotelsearchresponse.waitTimeMsec / 1000;
                raoresponsewrapper.attemptsLeft = hotelsearchresponse.attemptsLeft;
                callback.onRequestRaOSuccess(raoresponsewrapper);
            }
        }

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((HotelSearchResponse)obj);
        }

        public RequestRaOSuccessFunction(RaORequestCallback raorequestcallback)
        {
            callback = raorequestcallback;
        }
    }

    protected static class UpdateReservationExceptionFunction
        implements ReturningFunction1
    {

        protected final Function1 onException;

        public Boolean execute(Exception exception)
        {
            if (onException != null)
            {
                onException.execute(exception);
            }
            return Boolean.valueOf(false);
        }

        public volatile Object execute(Object obj)
            throws Exception
        {
            return execute((Exception)obj);
        }

        public UpdateReservationExceptionFunction(Function1 function1)
        {
            onException = function1;
        }
    }

    protected static class UpdateReservationSuccessFunction
        implements Function1
    {

        protected final Function1 onSuccess;

        public void execute(HotelSearchResponse hotelsearchresponse)
        {
            if (onSuccess != null)
            {
                List list = hotelsearchresponse.reservations;
                hotelsearchresponse = list;
                if (list == null)
                {
                    hotelsearchresponse = new ArrayList();
                }
                onSuccess.execute(hotelsearchresponse);
            }
        }

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((HotelSearchResponse)obj);
        }

        public UpdateReservationSuccessFunction(Function1 function1)
        {
            onSuccess = function1;
        }
    }


    public static final String REQUEST_AN_OFFER_ENDPOINT = "/getaways/discount/rao/%s";
    private String endpoint;
    private String method;
    protected ObjectMapperWrapper objectMapper;
    private List params;

    public HotelsService()
    {
    }

    public void createReservation(List list, View view, Function1 function1, Function1 function1_1, Function0 function0, Function0 function0_1)
    {
        endpoint = String.format("/getaways/systems/%s/hotel_reservations", new Object[] {
            currentCountryManager.getCurrentCountry().isoName
        });
        params = list;
        method = "POST";
        super.execute(view, new CreateReservationSuccessFunction(function1), new CreateReservationExceptionFunction(function1_1), function0, function0_1, null);
    }

    public void getDestinationSuggestions(List list, View view, Function1 function1, Function1 function1_1)
    {
        endpoint = "/getaways/geo/destinations";
        params = list;
        method = "GET";
        super.execute(view, new GetDestinationSuccessFunction(function1), new GetDestinationExceptionFunction(function1_1), null, null, null);
    }

    protected String getEndpoint()
    {
        return endpoint;
    }

    public void getHotelImageUrls(String s, View view, Function1 function1, Function1 function1_1)
    {
        endpoint = String.format("/getaways/hotels/%s/images", new Object[] {
            s
        });
        params = Collections.emptyList();
        method = "GET";
        super.execute(view, new GetHotelImageUrlsSuccessFunction(function1), new GetHotelImageUrlsExceptionFunction(function1_1), null, null, null);
    }

    public void getHotelInventory(String s, List list, View view, Function2 function2, Function1 function1)
    {
        endpoint = String.format("/getaways/hotels/%s/inventory", new Object[] {
            s
        });
        params = list;
        method = "GET";
        super.execute(view, new GetHotelInventorySuccessFunction(function2), new GetHotelInventoryExceptionFunction(function1), null, null, null);
    }

    public void getHotelReservation(String s, String s1, List list, View view, Function1 function1, Function1 function1_1, Function0 function0)
    {
        endpoint = String.format("/getaways/systems/%s/users/%s/hotel_reservations/%s", new Object[] {
            "us", s, s1
        });
        params = list;
        method = "GET";
        super.execute(view, new GetHotelReservationSuccessFunction(function1), new GetHotelReservationExceptionFunction(function1_1), null, null, new GetHotelReservationOnFinallyFunction(function0));
    }

    public void getHotelReviews(String s, String s1, HotelReviewsRequestCallback hotelreviewsrequestcallback)
    {
        endpoint = String.format("/getaways/hotels/%s", new Object[] {
            s
        });
        params = ApiRequestUtil.generateHotelShowParameters(true);
        method = "GET";
        super.execute(null, new GetHotelReviewsSuccessFunction(s1, hotelreviewsrequestcallback), new GetHotelReviewsExceptionFunction(hotelreviewsrequestcallback), null, null, null);
    }

    protected String getMethod()
    {
        if (method != null)
        {
            return method;
        } else
        {
            return super.getMethod();
        }
    }

    protected Object[] getParams()
    {
        if (params != null)
        {
            return params.toArray();
        } else
        {
            return null;
        }
    }

    public List mapHotelInventory(List list)
    {
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            HotelRoom hotelroom = (HotelRoom)list.next();
            List list1 = hotelroom.details;
            boolean flag2 = Strings.notEmpty(hotelroom.title);
            boolean flag;
            boolean flag1;
            if (list1.size() > 0 && list1.get(0) != null && Strings.notEmpty(((RoomDetails)list1.get(0)).description))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (hotelroom.prices != null && hotelroom.prices.get(0) != null)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1 && (flag2 || flag))
            {
                arraylist.add(hotelroom);
            }
        } while (true);
        return arraylist;
    }

    public void requestRaOOffer(String s, List list, View view, RaORequestCallback raorequestcallback)
    {
        endpoint = String.format("/getaways/discount/rao/%s", new Object[] {
            s
        });
        params = list;
        method = "POST";
        super.execute(view, new RequestRaOSuccessFunction(raorequestcallback), new RaOExceptionFunction(raorequestcallback), null, null, null);
    }

    public void skipRaOOffer(String s, List list, View view, RaORequestCallback raorequestcallback)
    {
        endpoint = String.format("/getaways/discount/rao/%s", new Object[] {
            s
        });
        params = list;
        method = "DELETE";
        super.execute(view, new DeleteRaOSuccessFunction(raorequestcallback), new RaOExceptionFunction(raorequestcallback), null, null, null);
    }

    public void updateReservation(String s, List list, View view, Function1 function1, Function1 function1_1, Function0 function0, Function0 function0_1)
    {
        endpoint = String.format("/getaways/systems/%s/hotel_reservations/%s", new Object[] {
            currentCountryManager.getCurrentCountry().isoName, s
        });
        params = list;
        method = "PUT";
        super.execute(view, new UpdateReservationSuccessFunction(function1), new UpdateReservationExceptionFunction(function1_1), function0, function0_1, null);
    }
}
