// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.lds;

import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.lds:
//            LdsRequest, LdsRequestParams, LdsResponse

public final class GetListingDraftsRequest extends LdsRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    public static final String BODY_TAG = "getListingDraftsResponse";

    public GetListingDraftsRequest(LdsRequestParams ldsrequestparams)
    {
        super("getListingDrafts", ldsrequestparams);
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/listing/v1/services");
        xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "getListingDraftsRequest");
        xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "draftInfo");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "listingMode", params.listingMode);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "draftId", params.id);
        xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "draftInfo");
        retrieveMetaData(xmlserializer);
        xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "directive");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "name", "PRICE_GUIDANCE");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "action", "COMPLETE");
        xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "directive");
        xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "directive");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "name", "FORMAT_GUIDANCE");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "action", "COMPLETE");
        xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "directive");
        xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "directive");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "name", "SECURITY_POLICY");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "action", "NONE");
        xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "directive");
        xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "directive");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "name", "LOOK_UP_FEES");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "action", "COMPLETE");
        xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "directive");
        xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "directive");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "name", "LISTING_DETAIL");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "action", "NONE");
        xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "directive");
        xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "getListingDraftsRequest");
    }

    public volatile URL getRequestUrl()
    {
        return super.getRequestUrl();
    }

    public LdsResponse getResponse()
    {
        return new LdsResponse("getListingDraftsResponse", params.site, params.listingMode);
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
