// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.requestor;

import com.pointinside.json.ResponseFeedsPlaces;
import com.pointinside.json.ResponseFeedsVenues;
import com.pointinside.json.ResponseFeedsVenuesByLocation;
import com.pointinside.json.ResponseFeedsZoneImages;
import com.pointinside.json.ResponseFeedsZones;
import com.pointinside.net.url.FeedsPlacesURLBuilder;
import com.pointinside.net.url.FeedsServicesURLBuilder;
import com.pointinside.net.url.FeedsURLBuilder;
import com.pointinside.net.url.FeedsVenueLocationURLBuilder;
import com.pointinside.net.url.FeedsZoneImagesURLBuilder;
import com.pointinside.net.url.FeedsZoneURLBuilder;
import com.pointinside.products.ItemRecommendationsResponse;
import com.pointinside.products.ItemRecommendationsURLBuilder;
import com.pointinside.products.ProductLookupResponse;
import com.pointinside.products.ProductLookupURLBuilder;
import com.pointinside.products.ProductSearchResponse;
import com.pointinside.products.ProductSearchURLBuilder;

// Referenced classes of package com.pointinside.net.requestor:
//            AllVenueFeedRequestor, GeneralAnalyticsRequestor, ItemRecommendationsRequestor, ProductLookupRequestor, 
//            ProductSearchRequestor, SingleVenueFeedRequestor, VenueByLocationFeedRequestor, VenueCacheFeedRequestor

public final class RequestorFactory
{

    public RequestorFactory()
    {
    }

    public static final AllVenueFeedRequestor newAllVenueRequestor()
    {
        return new AllVenueFeedRequestor(new FeedsURLBuilder(), new ResponseFeedsVenues());
    }

    public static GeneralAnalyticsRequestor newGeneralAnalyticsRequestor()
    {
        return new GeneralAnalyticsRequestor();
    }

    public static ItemRecommendationsRequestor newItemRecommendationRequestor(ItemRecommendationsURLBuilder itemrecommendationsurlbuilder)
    {
        return new ItemRecommendationsRequestor(itemrecommendationsurlbuilder, new ItemRecommendationsResponse());
    }

    public static ProductLookupRequestor newProductLookupRequestor(ProductLookupURLBuilder productlookupurlbuilder)
    {
        return new ProductLookupRequestor(productlookupurlbuilder, new ProductLookupResponse());
    }

    public static ProductSearchRequestor newProductSearchRequestor(ProductSearchURLBuilder productsearchurlbuilder)
    {
        return new ProductSearchRequestor(productsearchurlbuilder, new ProductSearchResponse());
    }

    public static final SingleVenueFeedRequestor newRequestor(FeedsPlacesURLBuilder feedsplacesurlbuilder)
    {
        return new SingleVenueFeedRequestor(feedsplacesurlbuilder, new ResponseFeedsPlaces());
    }

    public static final SingleVenueFeedRequestor newRequestor(FeedsServicesURLBuilder feedsservicesurlbuilder)
    {
        return new SingleVenueFeedRequestor(feedsservicesurlbuilder, new ResponseFeedsPlaces());
    }

    public static final SingleVenueFeedRequestor newRequestor(FeedsZoneImagesURLBuilder feedszoneimagesurlbuilder)
    {
        return new SingleVenueFeedRequestor(feedszoneimagesurlbuilder, new ResponseFeedsZoneImages());
    }

    public static final SingleVenueFeedRequestor newRequestor(FeedsZoneURLBuilder feedszoneurlbuilder)
    {
        return new SingleVenueFeedRequestor(feedszoneurlbuilder, new ResponseFeedsZones());
    }

    public static final SingleVenueFeedRequestor newServicesRequestor(FeedsServicesURLBuilder feedsservicesurlbuilder)
    {
        return new SingleVenueFeedRequestor(feedsservicesurlbuilder, new ResponseFeedsPlaces());
    }

    public static final SingleVenueFeedRequestor newSingleVenueRequestor(FeedsURLBuilder feedsurlbuilder)
    {
        return new SingleVenueFeedRequestor(feedsurlbuilder, new ResponseFeedsVenues());
    }

    public static final VenueByLocationFeedRequestor newVenueByLocationFeedRequestor()
    {
        return new VenueByLocationFeedRequestor(new FeedsVenueLocationURLBuilder(), new ResponseFeedsVenuesByLocation());
    }

    public static final VenueCacheFeedRequestor newVenueCacheRequestor(FeedsURLBuilder feedsurlbuilder)
    {
        return new VenueCacheFeedRequestor(feedsurlbuilder, new ResponseFeedsVenues());
    }
}
