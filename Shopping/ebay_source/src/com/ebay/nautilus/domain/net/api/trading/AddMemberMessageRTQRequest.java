// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import android.text.TextUtils;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            EbayTradingRequest, AddMemberMessageRTQResponse, EbayTradingApi

public final class AddMemberMessageRTQRequest extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{
    public static final class QuestionType extends Enum
    {

        private static final QuestionType $VALUES[];
        public static final QuestionType General;
        public static final QuestionType MultipleItemShipping;
        public static final QuestionType Payment;
        public static final QuestionType Shipping;

        public static QuestionType valueOf(String s)
        {
            return (QuestionType)Enum.valueOf(com/ebay/nautilus/domain/net/api/trading/AddMemberMessageRTQRequest$QuestionType, s);
        }

        public static QuestionType[] values()
        {
            return (QuestionType[])$VALUES.clone();
        }

        static 
        {
            General = new QuestionType("General", 0);
            MultipleItemShipping = new QuestionType("MultipleItemShipping", 1);
            Payment = new QuestionType("Payment", 2);
            Shipping = new QuestionType("Shipping", 3);
            $VALUES = (new QuestionType[] {
                General, MultipleItemShipping, Payment, Shipping
            });
        }

        private QuestionType(String s, int i)
        {
            super(s, i);
        }
    }


    private final String body;
    private final Long itemId;
    private final String parentMessageId;
    private final ArrayList pictureUrls;
    private final String recipient;

    public AddMemberMessageRTQRequest(EbayTradingApi ebaytradingapi, String s, Long long1, String s1, String s2)
    {
        this(ebaytradingapi, s, long1, s1, s2, null);
    }

    public AddMemberMessageRTQRequest(EbayTradingApi ebaytradingapi, String s, Long long1, String s1, String s2, ArrayList arraylist)
    {
        super(ebaytradingapi, "AddMemberMessageRTQ");
        parentMessageId = s;
        itemId = long1;
        recipient = s1;
        body = s2;
        pictureUrls = arraylist;
        boolean flag;
        if (!TextUtils.isEmpty(s2) && !TextUtils.isEmpty(s1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        String s = getOperationName();
        xmlserializer.setPrefix("", "urn:ebay:apis:eBLBaseComponents");
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", s);
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "Version", apiVersion);
        XmlSerializerHelper.writeErrorLocale(xmlserializer, "urn:ebay:apis:eBLBaseComponents");
        if (itemId != null)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "ItemID", String.valueOf(itemId));
        }
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "MemberMessage");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "Body", body);
        if (!TextUtils.isEmpty(parentMessageId))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "ParentMessageID", parentMessageId);
        }
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "RecipientID", recipient);
        if (pictureUrls != null && pictureUrls.size() > 0)
        {
            int i = 0;
            for (Iterator iterator = pictureUrls.iterator(); iterator.hasNext(); xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "MessageMedia"))
            {
                String s1 = (String)iterator.next();
                xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "MessageMedia");
                StringBuilder stringbuilder = (new StringBuilder()).append("image ");
                i++;
                XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "MediaName", stringbuilder.append(i).toString());
                XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "MediaURL", s1);
            }

        }
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "MemberMessage");
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", s);
    }

    public AddMemberMessageRTQResponse getResponse()
    {
        return new AddMemberMessageRTQResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
