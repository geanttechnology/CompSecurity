// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.givingworks;

import com.ebay.common.model.givingworks.NonprofitData;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class FindNonProfitResponse extends EbayResponse
{
    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final NonprofitData data;
        final FindNonProfitResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if (responseNamespace.equals(s))
            {
                if ("ack".equals(s1))
                {
                    return new AckElement(FindNonProfitResponse.this);
                }
                if ("timestamp".equals(s1))
                {
                    return new TimestampElement(FindNonProfitResponse.this);
                }
                if ("version".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            setVersion(s);
                        }

            
            {
                this$1 = RootElement.this;
                super();
            }
                    };
                }
                if ("errorMessage".equals(s1))
                {
                    return new ErrorMessageElement(FindNonProfitResponse.this, responseNamespace);
                }
                if ("nonprofit".equals(s1))
                {
                    s = new com.ebay.common.model.givingworks.NonprofitData.Nonprofit();
                    data.nonprofits.add(s);
                    return new NonprofitElement(s);
                }
                if ("paginationOutput".equals(s1))
                {
                    return new PaginationOutputElement(data.paginationOutput);
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public RootElement(NonprofitData nonprofitdata)
        {
            this$0 = FindNonProfitResponse.this;
            super();
            data = nonprofitdata;
        }
    }

    private final class RootElement.AddressElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.givingworks.NonprofitData.Nonprofit.Address data;
        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if (responseNamespace.equals(s))
            {
                if ("city".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.AddressElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            data.city = s;
                        }

            
            {
                this$2 = RootElement.AddressElement.this;
                super();
            }
                    };
                }
                if ("state".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.AddressElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            data.state = s;
                        }

            
            {
                this$2 = RootElement.AddressElement.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public RootElement.AddressElement(com.ebay.common.model.givingworks.NonprofitData.Nonprofit.Address address)
        {
            this$1 = RootElement.this;
            super();
            data = address;
        }
    }

    private final class RootElement.NonprofitElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.givingworks.NonprofitData.Nonprofit data;
        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if (responseNamespace.equals(s))
            {
                if ("externalId".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.NonprofitElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            data.externalId = s;
                        }

            
            {
                this$2 = RootElement.NonprofitElement.this;
                super();
            }
                    };
                }
                if ("nonprofitId".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.NonprofitElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            data.nonprofitId = s;
                        }

            
            {
                this$2 = RootElement.NonprofitElement.this;
                super();
            }
                    };
                }
                if ("name".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.NonprofitElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            data.name = s;
                        }

            
            {
                this$2 = RootElement.NonprofitElement.this;
                super();
            }
                    };
                }
                if ("mission".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.NonprofitElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            data.mission = s;
                        }

            
            {
                this$2 = RootElement.NonprofitElement.this;
                super();
            }
                    };
                }
                if ("logoURL".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.NonprofitElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            data.logoUrl = s;
                        }

            
            {
                this$2 = RootElement.NonprofitElement.this;
                super();
            }
                    };
                }
                if ("largeLogoURL".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.NonprofitElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            data.largeLogoUrl = s;
                        }

            
            {
                this$2 = RootElement.NonprofitElement.this;
                super();
            }
                    };
                }
                if ("address".equals(s1))
                {
                    return new RootElement.AddressElement(data.address);
                }
                if ("favoriteCount".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final RootElement.NonprofitElement this$2;

                        protected void setValue(int i)
                            throws SAXException
                        {
                            data.favoriteCount = i;
                        }

            
            {
                this$2 = RootElement.NonprofitElement.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public RootElement.NonprofitElement(com.ebay.common.model.givingworks.NonprofitData.Nonprofit nonprofit)
        {
            this$1 = RootElement.this;
            super();
            data = nonprofit;
        }
    }

    private final class RootElement.PaginationOutputElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.givingworks.NonprofitData.PaginationOutput data;
        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if (responseNamespace.equals(s) && "totalEntries".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final RootElement.PaginationOutputElement this$2;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        data.totalEntries = i;
                    }

            
            {
                this$2 = RootElement.PaginationOutputElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public RootElement.PaginationOutputElement(com.ebay.common.model.givingworks.NonprofitData.PaginationOutput paginationoutput)
        {
            this$1 = RootElement.this;
            super();
            data = paginationoutput;
        }
    }


    public NonprofitData nonProfitData;
    private final String responseNamespace;

    public FindNonProfitResponse(String s)
    {
        responseNamespace = s;
    }

    public List getNonprofits()
    {
        if (nonProfitData != null)
        {
            return nonProfitData.nonprofits;
        } else
        {
            return null;
        }
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        NonprofitData nonprofitdata = new NonprofitData();
        nonProfitData = nonprofitdata;
        SaxHandler.parseXml(inputstream, new RootElement(nonprofitdata));
    }

}
