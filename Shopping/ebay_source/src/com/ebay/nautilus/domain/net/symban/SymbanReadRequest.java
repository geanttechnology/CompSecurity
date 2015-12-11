// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.symban;

import android.net.Uri;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.CosVersionType;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net.symban:
//            SymbanReadResponse

public class SymbanReadRequest extends EbayCosRequest
{
    public static class Params
    {

        boolean badgeCountOnly;
        int limit;
        int offset;

        public boolean isBadgeCountOnly()
        {
            return badgeCountOnly;
        }

        public Params setBadgeCountOnly(boolean flag)
        {
            badgeCountOnly = flag;
            return this;
        }

        public Params setLimit(int i)
        {
            limit = i;
            return this;
        }

        public Params setOffset(int i)
        {
            offset = i;
            return this;
        }

        public Params()
        {
            badgeCountOnly = false;
            limit = 40;
            offset = 0;
        }
    }


    private final Params params;

    public SymbanReadRequest(String s, EbayCountry ebaycountry, Params params1)
    {
        super("notificationinbox", "notification", CosVersionType.V2);
        requestBodyContentType = "application/json";
        responseBodyContentType = "application/json";
        territory = ebaycountry.getCountryCode();
        marketPlaceId = ebaycountry.getSiteGlobalId();
        iafToken = s;
        params = params1;
    }

    public URL getRequestUrl()
    {
        Object obj = Uri.parse(ApiSettings.get(ApiSettings.symbanApiUrl)).buildUpon().appendQueryParameter("badgeCountOnly", Boolean.toString(params.badgeCountOnly)).appendQueryParameter("limit", Integer.toString(params.limit)).appendQueryParameter("offset", Integer.toString(params.offset));
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

    public SymbanReadResponse getResponse()
    {
        return new SymbanReadResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    protected boolean isIdempotent()
    {
        return true;
    }
}
