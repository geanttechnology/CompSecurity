// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.guidesandreviews;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.CosVersionType;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net.api.guidesandreviews:
//            GetReviewsResponse

public class GetReviewsRequest extends EbayCosRequest
{

    public int maxResultsPerPage;
    public int pageNumber;
    private GetReviewsResponse response;
    public String subjectReferenceId;

    public GetReviewsRequest(EbayCountry ebaycountry, Authentication authentication, String s, int i, int j)
    {
        super("GuidesAndReviewsService", "review", CosVersionType.V2);
        maxResultsPerPage = 20;
        responseBodyContentType = "application/json";
        marketPlaceId = ebaycountry.getSite().idString;
        endUserContext = buildEndUserContext(ebaycountry, null, null, false);
        subjectReferenceId = s;
        pageNumber = i;
        if (j <= 0)
        {
            maxResultsPerPage = j;
        }
        if (authentication != null && !TextUtils.isEmpty(authentication.iafToken))
        {
            iafToken = authentication.iafToken;
        }
    }

    public URL getRequestUrl()
    {
        Object obj = Uri.parse(ApiSettings.get(ApiSettings.guidesAndReviewsServiceUrl)).buildUpon().appendPath(getOperationName());
        ((android.net.Uri.Builder) (obj)).appendPath("product");
        ((android.net.Uri.Builder) (obj)).appendPath(subjectReferenceId);
        ((android.net.Uri.Builder) (obj)).appendPath("published");
        ((android.net.Uri.Builder) (obj)).appendQueryParameter("sort", "-relevant");
        ((android.net.Uri.Builder) (obj)).appendQueryParameter("offset", String.valueOf((pageNumber - 1) * maxResultsPerPage));
        ((android.net.Uri.Builder) (obj)).appendQueryParameter("limit", String.valueOf(maxResultsPerPage));
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

    public GetReviewsResponse getResponse()
    {
        if (response == null)
        {
            response = new GetReviewsResponse();
        }
        return response;
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
