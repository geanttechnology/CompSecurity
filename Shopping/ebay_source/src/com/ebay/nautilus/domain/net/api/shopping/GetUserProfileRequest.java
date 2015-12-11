// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import android.text.TextUtils;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            EbayShoppingRequest, GetUserProfileResponse, EbayShoppingApi

public final class GetUserProfileRequest extends EbayShoppingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    public static final String OPERATION_NAME = "GetUserProfile";
    private final String includeSelector;
    private final String userId;

    public GetUserProfileRequest(EbayShoppingApi ebayshoppingapi, String s)
    {
        this(ebayshoppingapi, s, "Details,FeedbackHistory");
    }

    public GetUserProfileRequest(EbayShoppingApi ebayshoppingapi, String s, String s1)
    {
        super(ebayshoppingapi, "GetUserProfile");
        userId = s;
        includeSelector = s1;
        if (s == null)
        {
            throw new NullPointerException("No user ID.");
        } else
        {
            return;
        }
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix("", "urn:ebay:apis:eBLBaseComponents");
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "GetUserProfileRequest");
        if (!TextUtils.isEmpty(includeSelector))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "IncludeSelector", includeSelector);
        }
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "UserID", userId);
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "GetUserProfileRequest");
    }

    public GetUserProfileResponse getResponse()
    {
        return new GetUserProfileResponse(userId);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
