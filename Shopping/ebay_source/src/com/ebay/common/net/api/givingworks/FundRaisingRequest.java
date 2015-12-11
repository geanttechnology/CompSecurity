// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.givingworks;

import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;

public abstract class FundRaisingRequest extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    public static final String NAMESPACE_V1 = "http://www.ebay.com/marketplace/fundraising/v1/services";
    public static final String NAMESPACE_V3 = "http://www.ebay.com/marketplace/fundraising/v3/services";

    public FundRaisingRequest(EbaySite ebaysite, boolean flag, String s)
    {
        super("FundRaisingService", flag, s);
        super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
        super.dataFormat = "XML";
        super.soaGlobalId = ebaysite.idString;
        super.soaContentType = "application/xml";
    }

    public final byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }
}
