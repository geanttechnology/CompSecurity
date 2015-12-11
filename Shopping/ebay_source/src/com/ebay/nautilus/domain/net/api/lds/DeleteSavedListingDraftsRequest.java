// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.lds;

import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.lds:
//            LdsRequest, LdsResponse, LdsRequestParams

public class DeleteSavedListingDraftsRequest extends LdsRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    public static final String BODY_TAG = "deleteSavedListingDraftsResponse";
    private final ArrayList draftIds;

    public DeleteSavedListingDraftsRequest(LdsRequestParams ldsrequestparams, ArrayList arraylist)
    {
        super("deleteSavedListingDrafts", ldsrequestparams);
        draftIds = arraylist;
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
        xmlserializer.startTag("http://www.ebay.com/marketplace/listing/v1/services", "deleteSavedListingDraftsRequest");
        for (Iterator iterator = draftIds.iterator(); iterator.hasNext(); XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/listing/v1/services", "draftId", (String)iterator.next())) { }
        xmlserializer.endTag("http://www.ebay.com/marketplace/listing/v1/services", "deleteSavedListingDraftsRequest");
    }

    public volatile URL getRequestUrl()
    {
        return super.getRequestUrl();
    }

    public LdsResponse getResponse()
    {
        return new LdsResponse("deleteSavedListingDraftsResponse", params.site, null);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
