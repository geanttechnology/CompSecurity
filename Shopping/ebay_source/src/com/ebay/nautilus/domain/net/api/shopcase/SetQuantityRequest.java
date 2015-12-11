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
import com.google.gson.Gson;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopcase:
//            ShopcaseCartResponse

public final class SetQuantityRequest extends EbayCosRequest
{
    private static final class RequestBody
    {

        public Collection updates;

        private RequestBody()
        {
            updates = new LinkedList();
        }

    }

    private static final class Update
    {

        private final String lineItemId;
        private final int quantity;

        public Update(String s, int i)
        {
            lineItemId = s;
            quantity = i;
        }
    }


    private static final String LOG_TAG = "SetQuantityRequest";
    private static final String OPERATION_NAME = "UpdateLineItem";
    private static final String RESOURCE_PATH = "shopcart/lineitem";
    private static final String SERVICE_NAME = "Shopcase";
    private final long itemReferenceId;
    private final int requestedQuantity;

    public SetQuantityRequest(String s, EbaySite ebaysite, long l, int i)
    {
        super("Shopcase", "UpdateLineItem", CosVersionType.V2);
        iafToken = s;
        marketPlaceId = ebaysite.idString;
        itemReferenceId = l;
        requestedQuantity = i;
        useServiceVersion = false;
        requestBodyContentType = "application/json";
        responseBodyContentType = "application/json";
    }

    public byte[] buildRequest()
    {
        RequestBody requestbody = new RequestBody();
        requestbody.updates.add(new Update(Long.toString(itemReferenceId), requestedQuantity));
        return defaultRequestMapper.toJson(requestbody).getBytes();
    }

    public String getHttpMethod()
    {
        return "PUT";
    }

    public URL getRequestUrl()
    {
        Object obj;
        try
        {
            obj = Uri.parse(ApiSettings.getUrl(ApiSettings.shopcaseApiUrl).toString()).buildUpon();
            ((android.net.Uri.Builder) (obj)).appendEncodedPath("shopcart/lineitem");
            obj = new URL(((android.net.Uri.Builder) (obj)).build().toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            Log.e("SetQuantityRequest", "Unable to parse URL", malformedurlexception);
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
