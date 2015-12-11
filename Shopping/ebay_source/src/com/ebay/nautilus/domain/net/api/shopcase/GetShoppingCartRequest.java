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
import java.util.Locale;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopcase:
//            ShopcaseCartResponse

public final class GetShoppingCartRequest extends EbayCosRequest
{

    private static final String LOG_TAG = "GetShoppingCartRequest";
    private static final String OPERATION_NAME = "GetShoppingCart";
    private static final String RESOURCE_PATH = "shopcart";
    private static final String SERVICE_NAME = "Shopcase";
    private final boolean validate;

    public GetShoppingCartRequest(String s, EbaySite ebaysite, boolean flag)
    {
        super("Shopcase", "GetShoppingCart", CosVersionType.V2);
        validate = flag;
        iafToken = s;
        marketPlaceId = ebaysite.idString;
        serviceVersion = "2.0.1";
        requestBodyContentType = "application/json";
        responseBodyContentType = "application/json";
    }

    public URL getRequestUrl()
    {
        Object obj;
        try
        {
            obj = Uri.parse(ApiSettings.getUrl(ApiSettings.shopcaseApiUrl).toString()).buildUpon();
            ((android.net.Uri.Builder) (obj)).appendEncodedPath("shopcart").appendQueryParameter("validate", Boolean.toString(validate).toLowerCase(Locale.US)).appendQueryParameter("forceRecovery", Boolean.toString(false).toLowerCase(Locale.US)).appendQueryParameter("enableVerboseLog", Boolean.toString(false).toLowerCase(Locale.US));
            obj = new URL(((android.net.Uri.Builder) (obj)).build().toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            Log.e("GetShoppingCartRequest", "Unable to parse URL", malformedurlexception);
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
