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
//            GetFeedbackResponse

public final class GetFeedbackRequest extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{
    public static final class CommentType extends Enum
    {

        private static final CommentType $VALUES[];
        public static final CommentType ALL;
        public static final CommentType NEGATIVE;
        public static final CommentType NEUTRAL;
        public static final CommentType POSITIVE;
        protected String name;

        public static CommentType valueOf(String s)
        {
            return (CommentType)Enum.valueOf(com/ebay/common/net/api/trading/GetFeedbackRequest$CommentType, s);
        }

        public static CommentType[] values()
        {
            return (CommentType[])$VALUES.clone();
        }

        public String getName()
        {
            return name;
        }

        static 
        {
            ALL = new CommentType("ALL", 0, "");
            POSITIVE = new CommentType("POSITIVE", 1, "Positive");
            NEUTRAL = new CommentType("NEUTRAL", 2, "Neutral");
            NEGATIVE = new CommentType("NEGATIVE", 3, "Negative");
            $VALUES = (new CommentType[] {
                ALL, POSITIVE, NEUTRAL, NEGATIVE
            });
        }

        private CommentType(String s, int i, String s1)
        {
            super(s, i);
            name = s1;
        }
    }

    public static final class FeedbackType extends Enum
    {

        private static final FeedbackType $VALUES[];
        public static final FeedbackType RECEIVED_AS_BUYER;
        public static final FeedbackType RECEIVED_AS_SELLER;
        protected String name;

        public static FeedbackType valueOf(String s)
        {
            return (FeedbackType)Enum.valueOf(com/ebay/common/net/api/trading/GetFeedbackRequest$FeedbackType, s);
        }

        public static FeedbackType[] values()
        {
            return (FeedbackType[])$VALUES.clone();
        }

        public String getName()
        {
            return name;
        }

        static 
        {
            RECEIVED_AS_BUYER = new FeedbackType("RECEIVED_AS_BUYER", 0, "FeedbackReceivedAsBuyer");
            RECEIVED_AS_SELLER = new FeedbackType("RECEIVED_AS_SELLER", 1, "FeedbackReceivedAsSeller");
            $VALUES = (new FeedbackType[] {
                RECEIVED_AS_BUYER, RECEIVED_AS_SELLER
            });
        }

        private FeedbackType(String s, int i, String s1)
        {
            super(s, i);
            name = s1;
        }
    }


    private final CommentType commentType;
    private final FeedbackType feedbackType;
    private final int page;
    private final String userId;

    public GetFeedbackRequest(EbayTradingApi ebaytradingapi, String s, int i, CommentType commenttype, FeedbackType feedbacktype)
    {
        super(ebaytradingapi, "GetFeedback");
        userId = s;
        page = i;
        commentType = commenttype;
        feedbackType = feedbacktype;
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
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "GetFeedbackRequest");
        XmlSerializerHelper.writeErrorLocale(xmlserializer, "urn:ebay:apis:eBLBaseComponents");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "DetailLevel", "ReturnAll");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "UserID", userId);
        if (commentType != null && commentType != CommentType.ALL)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "CommentType", commentType.name);
        }
        if (feedbackType != null)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "FeedbackType", feedbackType.name);
        }
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "Pagination");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "EntriesPerPage", String.valueOf(100));
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "PageNumber", String.valueOf(page));
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "Pagination");
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "GetFeedbackRequest");
    }

    public GetFeedbackResponse getResponse()
    {
        return new GetFeedbackResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
