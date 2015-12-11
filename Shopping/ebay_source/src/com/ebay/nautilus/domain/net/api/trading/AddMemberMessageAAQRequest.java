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
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            EbayTradingRequest, AddMemberMessageAAQResponse, EbayTradingApi

public final class AddMemberMessageAAQRequest extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{
    public static final class QuestionType extends Enum
    {

        private static final QuestionType $VALUES[];
        public static final QuestionType CustomizedSubject;
        public static final QuestionType General;
        public static final QuestionType MultipleItemShipping;
        public static final QuestionType Payment;
        public static final QuestionType Shipping;

        public static QuestionType valueOf(String s)
        {
            return (QuestionType)Enum.valueOf(com/ebay/nautilus/domain/net/api/trading/AddMemberMessageAAQRequest$QuestionType, s);
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
            CustomizedSubject = new QuestionType("CustomizedSubject", 4);
            $VALUES = (new QuestionType[] {
                General, MultipleItemShipping, Payment, Shipping, CustomizedSubject
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
    private final QuestionType questionType;
    private final String recipient;
    private final String subject;

    public AddMemberMessageAAQRequest(EbayTradingApi ebaytradingapi, QuestionType questiontype, boolean flag, Long long1, String s, String s1, String s2, 
            String s3)
    {
        this(ebaytradingapi, questiontype, flag, long1, s, s1, s2, null, s3);
    }

    public AddMemberMessageAAQRequest(EbayTradingApi ebaytradingapi, QuestionType questiontype, boolean flag, Long long1, String s, String s1, String s2, 
            ArrayList arraylist, String s3)
    {
        String s4;
        if (flag)
        {
            s4 = "AddMemberMessageAAQToPartner";
        } else
        {
            s4 = "AddMemberMessageAAQToSeller";
        }
        super(ebaytradingapi, s4);
        questionType = questiontype;
        itemId = long1;
        recipient = s;
        body = s2;
        subject = s1;
        pictureUrls = arraylist;
        parentMessageId = s3;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        String s;
label0:
        {
label1:
            {
                s = getOperationName();
                xmlserializer.setPrefix("", "urn:ebay:apis:eBLBaseComponents");
                xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", s);
                XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "Version", apiVersion);
                XmlSerializerHelper.writeErrorLocale(xmlserializer, "urn:ebay:apis:eBLBaseComponents");
                XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "ItemID", String.valueOf(itemId));
                xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "MemberMessage");
                XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "Body", body);
                if (questionType == QuestionType.CustomizedSubject)
                {
                    if (TextUtils.isEmpty(subject))
                    {
                        break label1;
                    }
                    XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "Subject", subject);
                }
                XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "QuestionType", questionType.toString());
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
                break label0;
            }
            throw new com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException("CustomizedSubject messages should have a subject text");
        }
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "MemberMessage");
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", s);
    }

    public AddMemberMessageAAQResponse getResponse()
    {
        return new AddMemberMessageAAQResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
