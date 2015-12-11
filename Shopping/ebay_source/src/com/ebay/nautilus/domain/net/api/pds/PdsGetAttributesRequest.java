// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.pds;

import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.pds:
//            PdsRequest, PdsGetAttributesResponse

public final class PdsGetAttributesRequest extends PdsRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    public static final String LAST_ITEM_VIEWED_ATTRIBUTE_ID = "10297";
    public static final String LAST_QUERIES_USED_ATTRIBUTE_ID = "10203";
    public static final String OPERATION_NAME = "getAttributes";
    private final boolean wantRecentSearches;
    private final boolean wantRecentlyViewed;

    public PdsGetAttributesRequest(String s, EbaySite ebaysite, String s1, boolean flag, boolean flag1)
    {
        super(s, ebaysite.idString, "getAttributes", s1);
        wantRecentlyViewed = flag;
        wantRecentSearches = flag1;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix("", "http://www.ebay.com/marketplace/mobileor/v1/commonservices");
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "getAttributesRequest");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobileor/v1/commonservices", "cguid", cguid);
        String as[];
        int j;
        if (wantRecentlyViewed && wantRecentSearches)
        {
            as = new String[2];
            as[0] = "10297";
            as[1] = "10203";
        } else
        if (wantRecentlyViewed)
        {
            as = new String[1];
            as[0] = "10297";
        } else
        {
            as = new String[1];
            as[0] = "10203";
        }
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "attributeIds");
        j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            xmlserializer.startTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "attributeId");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobileor/v1/commonservices", "AttributeId", s);
            xmlserializer.endTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "attributeId");
        }

        xmlserializer.endTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "attributeIds");
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "getAttributesRequest");
    }

    public PdsGetAttributesResponse getResponse()
    {
        return new PdsGetAttributesResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
