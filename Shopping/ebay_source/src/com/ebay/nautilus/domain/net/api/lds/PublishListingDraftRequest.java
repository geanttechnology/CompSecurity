// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.lds;

import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.lds:
//            LdsRequest, LdsRequestParams, LdsResponse

public final class PublishListingDraftRequest extends LdsRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    public static final String BODY_TAG = "publishListingDraftResponse";

    public PublishListingDraftRequest(LdsRequestParams ldsrequestparams)
    {
        super("publishListingDraft", ldsrequestparams);
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        HashMap hashmap = params.values;
        xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/listing/v1/services");
        xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "publishListingDraftRequest");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "listingMode", params.listingMode);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "draftId", params.id);
        xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "listing");
        if (hashmap.containsKey("Listing.AutoRelistInfo.AutoRelistEnabled"))
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "autoRelistInfo");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "autoRelistEnabled", (String)hashmap.get("Listing.AutoRelistInfo.AutoRelistEnabled"));
            xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "autoRelistInfo");
        }
        xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "listing");
        if (DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Selling.B.guarantee))
        {
            retrieveMetaData(xmlserializer);
        }
        xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "publishListingDraftRequest");
    }

    public volatile URL getRequestUrl()
    {
        return super.getRequestUrl();
    }

    public LdsResponse getResponse()
    {
        return new LdsResponse("publishListingDraftResponse", params.site, params.listingMode);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
