// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.unifiedstream;

import android.net.Uri;
import android.text.TextUtils;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.data.UnifiedStream.PaginationInput;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.CosVersionType;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net.api.unifiedstream:
//            UssListOfListingsResponse

public class UssDealDetailsRequest extends EbayCosRequest
{
    public static class Params
    {

        public final int DEFAULT_LIMIT = 200;
        public final String DEFAULT_READSET = "FEATURED";
        public String dealCategoryId;
        public String lastRefreshedTag;
        public int limit;
        public int offset;
        public PaginationInput paginationInput;
        public String readset;

        public Params()
        {
        }
    }


    private final Params params;

    public UssDealDetailsRequest(String s, EbayCountry ebaycountry, Params params1)
    {
        super("unifiedstream", "dealsdetails", CosVersionType.V3);
        requestBodyContentType = "application/json";
        responseBodyContentType = "application/json";
        territory = ebaycountry.getCountryCode();
        marketPlaceId = ebaycountry.getSiteGlobalId();
        iafToken = s;
        params = params1;
    }

    public String getHttpMethod()
    {
        return "GET";
    }

    public URL getRequestUrl()
    {
        String s = params.readset;
        Object obj = s;
        if (TextUtils.isEmpty(s))
        {
            params.getClass();
            obj = "FEATURED";
        }
        int i;
        int j;
        if (params.limit == 0)
        {
            params.getClass();
            i = 200;
        } else
        {
            i = params.limit;
        }
        j = params.offset;
        obj = Uri.parse(ApiSettings.getUrl(ApiSettings.unifiedStreamUrl).toString()).buildUpon().appendPath("deal").appendQueryParameter("dealCategoryId", params.dealCategoryId).appendQueryParameter("limit", String.valueOf(i)).appendQueryParameter("offset", String.valueOf(j)).appendQueryParameter("readset", ((String) (obj))).build().toString();
        try
        {
            obj = new URL(((String) (obj)));
        }
        catch (MalformedURLException malformedurlexception)
        {
            return null;
        }
        return ((URL) (obj));
    }

    public UssListOfListingsResponse getResponse()
    {
        return new UssListOfListingsResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    protected void initialize(ResultStatusOwner resultstatusowner)
        throws InterruptedException
    {
        super.initialize(resultstatusowner);
        endUserContext = buildEndUserContext(territory, null, null, null, true);
    }

    protected boolean isIdempotent()
    {
        return true;
    }
}
