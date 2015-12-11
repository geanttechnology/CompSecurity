// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.local;

import android.net.Uri;
import android.util.Log;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.common.net.api.local:
//            BaseEbayNowRequest, EbayNowValidateTimeSlotResponse

public final class EbayNowValidateTimeSlotRequest extends BaseEbayNowRequest
{
    public static class Product
    {

        public final String sku;

        public Product(String s)
        {
            sku = s;
        }
    }


    public final String deliveryNotes;
    public final String phone;
    public final Product products[];
    public final String reservationToken;
    public final String sellerEiasToken;

    public EbayNowValidateTimeSlotRequest(String s, String s1, String s2, Product aproduct[], String s3, String s4)
    {
        super(s, true);
        reservationToken = s1;
        sellerEiasToken = s2;
        products = aproduct;
        phone = s3;
        deliveryNotes = s4;
    }

    protected URL formatUrl()
    {
        Object obj = Uri.parse(EbaySettings.get(EbaySettings.ebncdsvcUrl)).buildUpon();
        ((android.net.Uri.Builder) (obj)).appendPath("delivery-slots").appendPath("reservations").appendPath("validate");
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

    public EbayResponse getResponse()
    {
        return new EbayNowValidateTimeSlotResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
