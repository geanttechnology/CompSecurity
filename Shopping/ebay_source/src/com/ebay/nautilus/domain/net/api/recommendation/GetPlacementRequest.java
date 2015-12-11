// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.recommendation;

import android.net.Uri;
import android.util.Log;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.CosVersionType;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.recommendation:
//            RecommendationApiContext, GetPlacementResponse

public class GetPlacementRequest extends EbayCosRequest
{

    private final boolean isTransacted;
    private final List listingIds;
    private final List placementIds;
    private GetPlacementResponse response;

    public GetPlacementRequest(RecommendationApiContext recommendationapicontext, Long long1, Long long2, boolean flag, String s)
    {
        this(recommendationapicontext, Arrays.asList(new Long[] {
            long1
        }), Arrays.asList(new Long[] {
            long2
        }), flag, s);
    }

    public GetPlacementRequest(RecommendationApiContext recommendationapicontext, List list, List list1, boolean flag, String s)
    {
        super("RecommendationService", "placement", CosVersionType.V2);
        placementIds = list;
        listingIds = list1;
        isTransacted = flag;
        responseBodyContentType = "application/json";
        marketPlaceId = recommendationapicontext.country.getSiteGlobalId();
        iafToken = recommendationapicontext.iafToken;
        endUserContext = buildEndUserContext(recommendationapicontext.country, null, recommendationapicontext.location, false);
        trackingHeader = s;
    }

    public URL getRequestUrl()
    {
        Object obj = Uri.parse(ApiSettings.get(ApiSettings.recommendationApiUrl)).buildUpon().appendPath(getOperationName());
        if (placementIds != null)
        {
            for (int i = 0; i < placementIds.size(); i++)
            {
                ((android.net.Uri.Builder) (obj)).appendQueryParameter("placementId", ((Long)placementIds.get(i)).toString());
            }

        }
        if (listingIds != null)
        {
            for (int j = 0; j < listingIds.size(); j++)
            {
                ((android.net.Uri.Builder) (obj)).appendQueryParameter("listingId", ((Long)listingIds.get(j)).toString());
            }

        }
        if (isTransacted)
        {
            ((android.net.Uri.Builder) (obj)).appendQueryParameter("usrSt", "1");
        }
        obj = ((android.net.Uri.Builder) (obj)).build().toString();
        URL url;
        try
        {
            url = new URL(((String) (obj)));
        }
        catch (MalformedURLException malformedurlexception)
        {
            Log.e(getClass().getSimpleName(), (new StringBuilder()).append("failed encoding URL ").append(((String) (obj))).toString());
            throw new RuntimeException(malformedurlexception);
        }
        return url;
    }

    public GetPlacementResponse getResponse()
    {
        if (response == null)
        {
            response = new GetPlacementResponse();
        }
        return response;
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
