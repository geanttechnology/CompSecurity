// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.inventory;

import android.net.Uri;
import android.text.TextUtils;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.common.net.api.inventory:
//            GetLocationDetailsResponse

public class GetLocationDetailsRequest extends EbayRequest
{

    private final String locationId;
    private final String sellerUserId;

    public GetLocationDetailsRequest(String s, String s1)
    {
        sellerUserId = s;
        locationId = s1;
    }

    public URL getRequestUrl()
    {
        Object obj = Uri.parse(ApiSettings.getUrl(EbaySettings.localLookupUrl).toString()).buildUpon();
        ((android.net.Uri.Builder) (obj)).appendPath("locationdetails");
        if (!TextUtils.isEmpty(locationId))
        {
            ((android.net.Uri.Builder) (obj)).appendQueryParameter("LocationID", locationId);
        }
        if (!TextUtils.isEmpty(sellerUserId))
        {
            ((android.net.Uri.Builder) (obj)).appendQueryParameter("SellerID", sellerUserId);
        }
        try
        {
            obj = new URL(((android.net.Uri.Builder) (obj)).toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            malformedurlexception.printStackTrace();
            return null;
        }
        return ((URL) (obj));
    }

    public GetLocationDetailsResponse getResponse()
    {
        return new GetLocationDetailsResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        super.onAddHeaders(iheaders);
        iheaders.setHeader("Accept", "application/xml");
    }
}
