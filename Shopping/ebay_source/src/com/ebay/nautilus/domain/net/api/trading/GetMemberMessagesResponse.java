// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class GetMemberMessagesResponse extends EbayResponse
{
    private final class Item extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMemberMessagesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("ItemID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                        final Item this$1;

                        public void setValue(long l)
                            throws SAXException
                        {
                            builder.itemId(l);
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("ListingDetails".equals(s1))
                {
                    return new ListingDetails();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private Item()
        {
            this$0 = GetMemberMessagesResponse.this;
            super();
        }

    }

    private final class ListingDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMemberMessagesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "ViewItemURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ListingDetails this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        builder.text(s);
                    }

            
            {
                this$1 = ListingDetails.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ListingDetails()
        {
            this$0 = GetMemberMessagesResponse.this;
            super();
        }

    }

    private final class MemberMessage extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMemberMessagesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "MemberMessageExchange".equals(s1))
            {
                return new MemberMessageExchange();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private MemberMessage()
        {
            this$0 = GetMemberMessagesResponse.this;
            super();
        }

    }

    private final class MemberMessageExchange extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMemberMessagesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Item".equals(s1))
                {
                    return new Item();
                }
                if ("Question".equals(s1))
                {
                    return new Question();
                }
                if ("CreationDate".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final MemberMessageExchange this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            builder.receiveDate(EbayDateUtils.parseXml(s));
                        }

            
            {
                this$1 = MemberMessageExchange.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private MemberMessageExchange()
        {
            this$0 = GetMemberMessagesResponse.this;
            super();
        }

    }

    private final class Question extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMemberMessagesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("SenderID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Question this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            builder.sender(s);
                        }

            
            {
                this$1 = Question.this;
                super();
            }
                    };
                }
                if ("Subject".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Question this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            builder.subject(s);
                        }

            
            {
                this$1 = Question.this;
                super();
            }
                    };
                }
                if ("MessageID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Question this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            builder.messageId(s);
                        }

            
            {
                this$1 = Question.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private Question()
        {
            this$0 = GetMemberMessagesResponse.this;
            super();
        }

    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMemberMessagesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(GetMemberMessagesResponse.this);
                }
                if ("Timestamp".equals(s1))
                {
                    return new TimestampElement(GetMemberMessagesResponse.this);
                }
                if ("Errors".equals(s1))
                {
                    return new ErrorElement(GetMemberMessagesResponse.this, "urn:ebay:apis:eBLBaseComponents");
                }
                if ("MemberMessage".equals(s1))
                {
                    return new MemberMessage();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement()
        {
            this$0 = GetMemberMessagesResponse.this;
            super();
        }

    }


    com.ebay.nautilus.domain.data.EbayMessage.Builder builder;

    public GetMemberMessagesResponse()
    {
    }

    public EbayMessage getEbayMessage()
    {
        return builder.build();
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }
}
