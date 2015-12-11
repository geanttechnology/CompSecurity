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
//            PdsRequest, PdsSetAttributesResponse

public final class PdsSetAttrClearRequest extends PdsRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    private static final String CLEAR_ATTRIBUTE_ID = "10140";
    private final String attributeId;

    public PdsSetAttrClearRequest(String s, EbaySite ebaysite, String s1, String s2)
    {
        super(s, ebaysite.idString, "setAttributes", s1);
        attributeId = s2;
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
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "setAttributesRequest");
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "attributes");
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "attribute");
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "Id");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobileor/v1/commonservices", "AttributeId", "10140");
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "Id");
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "Value");
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "complexListValue");
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "value");
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "intValue");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobileor/v1/commonservices", "value", attributeId);
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "intValue");
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "value");
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "complexListValue");
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "Value");
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "attribute");
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "attributes");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobileor/v1/commonservices", "cguid", cguid);
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "setAttributesRequest");
    }

    public PdsSetAttributesResponse getResponse()
    {
        return new PdsSetAttributesResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
