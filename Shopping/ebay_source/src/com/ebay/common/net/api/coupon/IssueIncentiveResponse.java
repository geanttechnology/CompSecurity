// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.coupon;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class IssueIncentiveResponse extends EbayResponse
{
    private static final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final String domain;
        final IssueIncentiveResponse response;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if (domain.equals(s))
            {
                if ("ack".equals(s1))
                {
                    return new AckElement(response);
                }
                if ("timestamp".equals(s1))
                {
                    return new TimestampElement(response);
                }
                if ("errorMessage".equals(s1))
                {
                    return new ErrorMessageElement(response, "http://www.ebay.com/marketplace/mobileor/v2/commonservices");
                }
                if ("issuedIncentive".equals(s1))
                {
                    return new IssuedIncentiveElement();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public RootElement(boolean flag, IssueIncentiveResponse issueincentiveresponse)
        {
            String s;
            if (flag)
            {
                s = "http://www.ebay.com/marketplace/mobileor/v1/commonservices";
            } else
            {
                s = "http://www.ebay.com/marketplace/mobileor/v2/commonservices";
            }
            domain = s;
            response = issueincentiveresponse;
        }
    }

    private final class RootElement.IssuedIncentiveElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if (domain.equals(s) && "message".equals(s1))
            {
                return new MessageElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.IssuedIncentiveElement()
        {
            this$0 = RootElement.this;
            super();
        }

    }

    private final class RootElement.IssuedIncentiveElement.MessageElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement.IssuedIncentiveElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if (domain.equals(s))
            {
                if ("title".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.IssuedIncentiveElement.MessageElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            response.title = s;
                        }

            
            {
                this$2 = RootElement.IssuedIncentiveElement.MessageElement.this;
                super();
            }
                    };
                }
                if ("primaryBodyText".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.IssuedIncentiveElement.MessageElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            response.primaryBody = s;
                        }

            
            {
                this$2 = RootElement.IssuedIncentiveElement.MessageElement.this;
                super();
            }
                    };
                }
                if ("secondaryBodyText".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.IssuedIncentiveElement.MessageElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            response.secondaryBody = s;
                        }

            
            {
                this$2 = RootElement.IssuedIncentiveElement.MessageElement.this;
                super();
            }
                    };
                }
                if ("buttonText".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.IssuedIncentiveElement.MessageElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            response.buttonText = s;
                        }

            
            {
                this$2 = RootElement.IssuedIncentiveElement.MessageElement.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement.IssuedIncentiveElement.MessageElement()
        {
            this$1 = RootElement.IssuedIncentiveElement.this;
            super();
        }

    }


    static final String ServiceDomain = "http://www.ebay.com/marketplace/mobileor/v2/commonservices";
    static final String ServiceDomainV1 = "http://www.ebay.com/marketplace/mobileor/v1/commonservices";
    public String buttonText;
    final boolean isServiceV1;
    public String primaryBody;
    public String secondaryBody;
    public String title;

    IssueIncentiveResponse(boolean flag)
    {
        title = null;
        primaryBody = null;
        secondaryBody = null;
        buttonText = null;
        isServiceV1 = flag;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement(isServiceV1, this));
    }
}
