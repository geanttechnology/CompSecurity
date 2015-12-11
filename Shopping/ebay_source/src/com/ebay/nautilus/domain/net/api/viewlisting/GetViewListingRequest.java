// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;

import android.location.Location;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.CosVersionType;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            GetViewListingResponse

public class GetViewListingRequest extends EbayCosRequest
{

    private static final String VLS_PROD_PRETEST = "x-ebay-prod-pretest";
    private final boolean includeEbayPlus;
    private final boolean includeProxPui;
    private final long listingId;
    private Integer quantity;
    private final boolean sendEEKParameter;
    private ItemCurrency unitPrice;

    public GetViewListingRequest(EbayCountry ebaycountry, Authentication authentication, long l, Location location, Address address, String s, 
            String s1, String s2, ItemCurrency itemcurrency, Integer integer, boolean flag, boolean flag1, boolean flag2)
    {
        super("ViewListingService", "GetViewListing", CosVersionType.V2);
        marketPlaceId = ebaycountry.getSite().idString;
        listingId = l;
        responseBodyContentType = "application/json";
        endUserContext = buildEndUserContext(ebaycountry, address, location, false);
        trackingHeader = s1;
        trackingCorrelationSession = s;
        trackingCorrelationId = s2;
        if (authentication != null && !TextUtils.isEmpty(authentication.iafToken))
        {
            iafToken = authentication.iafToken;
        }
        unitPrice = itemcurrency;
        quantity = integer;
        includeProxPui = flag1;
        sendEEKParameter = flag;
        includeEbayPlus = flag2;
    }

    public URL getRequestUrl()
    {
        Object obj = DeviceConfiguration.getAsync();
        Object obj1 = Uri.parse(ApiSettings.get(ApiSettings.viewListingServiceUrl)).buildUpon();
        ((android.net.Uri.Builder) (obj1)).appendPath(Long.toString(listingId));
        if (unitPrice != null)
        {
            ((android.net.Uri.Builder) (obj1)).appendQueryParameter("unitPrice", unitPrice.value);
            ((android.net.Uri.Builder) (obj1)).appendQueryParameter("fieldgroups", "logistics");
            if (quantity == null)
            {
                obj = "1";
            } else
            {
                obj = String.valueOf(quantity.intValue());
            }
            ((android.net.Uri.Builder) (obj1)).appendQueryParameter("quantity", ((String) (obj)));
        } else
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("image.seller.avatar.200X200-jpg-l");
            stringbuilder.append(",reviewstats");
            if (sendEEKParameter)
            {
                stringbuilder.append(",EEK1");
            }
            if (((DeviceConfiguration) (obj)).get(DcsNautilusBoolean.PUDO))
            {
                stringbuilder.append(",includepudo");
            }
            if (includeProxPui)
            {
                stringbuilder.append(",IsPUIEnabled");
            }
            stringbuilder.append(",description");
            if (includeEbayPlus)
            {
                stringbuilder.append(",ebayplus");
            }
            ((android.net.Uri.Builder) (obj1)).appendQueryParameter("inputoption", stringbuilder.toString());
            ((android.net.Uri.Builder) (obj1)).appendQueryParameter("fieldgroups", "compact");
            ((android.net.Uri.Builder) (obj1)).appendQueryParameter("fieldgroups", "compatibility");
        }
        obj = ((android.net.Uri.Builder) (obj1)).build().toString();
        try
        {
            obj1 = new URL(((String) (obj)));
        }
        catch (MalformedURLException malformedurlexception)
        {
            Log.e(getClass().getSimpleName(), (new StringBuilder()).append("failed encoding URL ").append(((String) (obj))).toString());
            throw new RuntimeException(malformedurlexception);
        }
        return ((URL) (obj1));
    }

    public GetViewListingResponse getResponse()
    {
        return new GetViewListingResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public boolean hasRecoverableError(Response response, IOException ioexception)
    {
        com.ebay.nautilus.kernel.content.ResultStatus.Message message;
        if (response != null && response.getResultStatus() != null)
        {
            message = response.getResultStatus().getFirstError();
        } else
        {
            message = null;
        }
        if (message != null && message.getId() == 0x14e6d38 && cosVersionType.minimumOf(CosVersionType.V2) && iafToken == null)
        {
            response = authHeaderValue.substring("Bearer ".length());
            EbayAppCredentials.get(getEbayContext()).invalidateBearerToken(response);
            return true;
        } else
        {
            return super.hasRecoverableError(response, ioexception);
        }
    }

    protected boolean isIdempotent()
    {
        return true;
    }
}
