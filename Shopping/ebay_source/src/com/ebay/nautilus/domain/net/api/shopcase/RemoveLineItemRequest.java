// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopcase;

import android.net.Uri;
import android.util.Log;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.CosVersionType;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopcase:
//            ShopcaseCartResponse

public final class RemoveLineItemRequest extends EbayCosRequest
{

    private static final String LOG_TAG = "RemoveLineItemRequest";
    private static final String OPERATION_NAME = "RemoveLineItem";
    private static final String RESOURCE_PATH = "shopcart/lineitem";
    private static final String SERVICE_NAME = "Shopcase";
    private final long itemReferenceId;
    private final boolean userInitiated = true;

    public RemoveLineItemRequest(String s, EbaySite ebaysite, long l)
    {
        super("Shopcase", "RemoveLineItem", CosVersionType.V2);
        iafToken = s;
        marketPlaceId = ebaysite.idString;
        itemReferenceId = l;
        useServiceVersion = false;
        requestBodyContentType = "application/json";
        responseBodyContentType = "application/json";
    }

    public String getHttpMethod()
    {
        return "DELETE";
    }

    public URL getRequestUrl()
    {
        Object obj;
        try
        {
            obj = Uri.parse(ApiSettings.getUrl(ApiSettings.shopcaseApiUrl).toString()).buildUpon();
            ((android.net.Uri.Builder) (obj)).appendEncodedPath("shopcart/lineitem").appendEncodedPath(Long.toString(itemReferenceId)).appendQueryParameter("userInitiated", Boolean.toString(userInitiated));
            obj = new URL(((android.net.Uri.Builder) (obj)).build().toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            Log.e("RemoveLineItemRequest", "Unable to parse URL", malformedurlexception);
            return null;
        }
        return ((URL) (obj));
    }

    public ShopcaseCartResponse getResponse()
    {
        return new ShopcaseCartResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public boolean isIdempotent()
    {
        return true;
    }
}
