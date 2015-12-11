// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopcase;

import android.net.Uri;
import android.text.TextUtils;
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

public final class AddToCartRequest extends EbayCosRequest
{

    private static final String LOG_TAG = "AddToCartRequest";
    private static final String OPERATION_NAME = "AddToCart";
    private static final int QUANTITY_LOWER_BOUND = 1;
    private static final String RESOURCE_PATH = "shopcart/item";
    private static final String SERVICE_NAME = "Shopcase";
    private final long ebayItemId;
    private final int requestedQuantity;
    private final String variationId;

    public AddToCartRequest(String s, EbaySite ebaysite, long l, String s1, int i)
    {
        super("Shopcase", "AddToCart", CosVersionType.V2);
        iafToken = s;
        marketPlaceId = ebaysite.idString;
        ebayItemId = l;
        variationId = s1;
        if (i <= 1)
        {
            i = 1;
        }
        requestedQuantity = i;
        serviceVersion = "2.0.1";
        requestBodyContentType = "application/json";
        responseBodyContentType = "application/json";
    }

    public String getHttpMethod()
    {
        return "POST";
    }

    public URL getRequestUrl()
    {
        Object obj;
        try
        {
            obj = Uri.parse(ApiSettings.getUrl(ApiSettings.shopcaseApiUrl).toString()).buildUpon();
            ((android.net.Uri.Builder) (obj)).appendEncodedPath("shopcart/item").appendEncodedPath(Long.toString(ebayItemId));
            if (!TextUtils.isEmpty(variationId))
            {
                ((android.net.Uri.Builder) (obj)).appendQueryParameter("variationId", variationId);
            }
            ((android.net.Uri.Builder) (obj)).appendQueryParameter("quantity", Integer.toString(requestedQuantity));
            obj = new URL(((android.net.Uri.Builder) (obj)).build().toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            Log.e("AddToCartRequest", "Unable to parse URL", malformedurlexception);
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
        return false;
    }
}
