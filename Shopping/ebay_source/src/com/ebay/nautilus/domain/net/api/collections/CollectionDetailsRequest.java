// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.collections;

import android.net.Uri;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.CosVersionType;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net.api.collections:
//            CollectionDetailsResponse

public class CollectionDetailsRequest extends EbayCosRequest
{
    public static final class FIELD_GROUP_VALUES extends Enum
    {

        private static final FIELD_GROUP_VALUES $VALUES[];
        public static final FIELD_GROUP_VALUES Full;
        public static final FIELD_GROUP_VALUES Medium;

        public static FIELD_GROUP_VALUES valueOf(String s)
        {
            return (FIELD_GROUP_VALUES)Enum.valueOf(com/ebay/nautilus/domain/net/api/collections/CollectionDetailsRequest$FIELD_GROUP_VALUES, s);
        }

        public static FIELD_GROUP_VALUES[] values()
        {
            return (FIELD_GROUP_VALUES[])$VALUES.clone();
        }

        static 
        {
            Full = new FIELD_GROUP_VALUES("Full", 0);
            Medium = new FIELD_GROUP_VALUES("Medium", 1);
            $VALUES = (new FIELD_GROUP_VALUES[] {
                Full, Medium
            });
        }

        private FIELD_GROUP_VALUES(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String FIELD_GROUP_QUERY_PARAM = "fieldgroups";
    public static final String LIMIT_QUERY_PARAM = "limit";
    public static final String OFFSET_QUERY_PARAM = "offset";
    public static final String OPERATION_NAME = "detail";
    public static final String SERVICE_NAME = "collections";
    public String collectionId;
    private final String limit;
    private final String offset;

    public CollectionDetailsRequest(String s, EbayCountry ebaycountry, String s1, String s2, String s3)
    {
        super("collections", "detail", CosVersionType.V2);
        collectionId = s1;
        requestBodyContentType = "application/json";
        responseBodyContentType = "application/json";
        iafToken = s;
        limit = s2;
        offset = s3;
        if (ebaycountry != null)
        {
            territory = ebaycountry.getCountryCode();
            marketPlaceId = ebaycountry.getSiteGlobalId();
        }
    }

    public URL getRequestUrl()
    {
        URL url = ApiSettings.getUrl(ApiSettings.collectionDetailUrl);
        Object obj = Uri.parse(url.toString()).buildUpon().appendPath(collectionId).appendQueryParameter("limit", limit).appendQueryParameter("offset", offset).appendQueryParameter("fieldgroups", FIELD_GROUP_VALUES.Full.toString()).build();
        try
        {
            obj = new URL(((Uri) (obj)).toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            return url;
        }
        return ((URL) (obj));
    }

    public CollectionDetailsResponse getResponse()
    {
        return new CollectionDetailsResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
