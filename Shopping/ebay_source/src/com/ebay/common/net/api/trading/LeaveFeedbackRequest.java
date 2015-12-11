// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.trading:
//            LeaveFeedbackParameters, LeaveFeedbackResponse

public class LeaveFeedbackRequest extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    private final LeaveFeedbackParameters parameters;

    public LeaveFeedbackRequest(EbayTradingApi ebaytradingapi, LeaveFeedbackParameters leavefeedbackparameters)
    {
        super(ebaytradingapi, "LeaveFeedback");
        parameters = leavefeedbackparameters;
    }

    private void buildRatingBlock(XmlSerializer xmlserializer, String s, String s1, int i)
        throws IOException
    {
        if (i > 0)
        {
            xmlserializer.startTag(s, "ItemRatingDetails");
            XmlSerializerHelper.writeSimple(xmlserializer, s, "Rating", (new StringBuilder()).append("").append(i).toString());
            XmlSerializerHelper.writeSimple(xmlserializer, s, "RatingDetail", s1);
            xmlserializer.endTag(s, "ItemRatingDetails");
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
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "LeaveFeedback");
        XmlSerializerHelper.writeErrorLocale(xmlserializer, "urn:ebay:apis:eBLBaseComponents");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "UserID", parameters.originator);
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "CommentType", parameters.feedbackType);
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "ItemID", (new StringBuilder()).append("").append(parameters.itemId).toString());
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "CommentText", parameters.comment);
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "ItemArrivedWithinEDDType", parameters.eddType);
        if (parameters.communicationRating > 0 || parameters.descriptionRating > 0 || parameters.shipCostRating > 0 || parameters.shipSpeedRating > 0)
        {
            xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "SellerItemRatingDetailArray");
            buildRatingBlock(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "Communication", parameters.communicationRating);
            buildRatingBlock(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "ItemAsDescribed", parameters.descriptionRating);
            buildRatingBlock(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "ShippingAndHandlingCharges", parameters.shipCostRating);
            buildRatingBlock(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "ShippingTime", parameters.shipSpeedRating);
            xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "SellerItemRatingDetailArray");
        }
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "TargetUser", parameters.targetUser);
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "TransactionID", parameters.transactionId);
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "LeaveFeedback");
    }

    public LeaveFeedbackResponse getResponse()
    {
        return new LeaveFeedbackResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
