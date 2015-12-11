// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.givingworks;

import com.ebay.common.model.givingworks.NonprofitData;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.givingworks:
//            FindNonProfitResponse

private final class data extends com.ebay.nautilus.kernel.util.ement
{
    private final class AddressElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.givingworks.NonprofitData.Nonprofit.Address data;
        final FindNonProfitResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if (FindNonProfitResponse.access$000(this$0).equals(s))
            {
                if ("city".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final AddressElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            data.city = s;
                        }

            
            {
                this$2 = AddressElement.this;
                super();
            }
                    };
                }
                if ("state".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final AddressElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            data.state = s;
                        }

            
            {
                this$2 = AddressElement.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public AddressElement(com.ebay.common.model.givingworks.NonprofitData.Nonprofit.Address address)
        {
            this$1 = FindNonProfitResponse.RootElement.this;
            super();
            data = address;
        }
    }

    private final class NonprofitElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.givingworks.NonprofitData.Nonprofit data;
        final FindNonProfitResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if (FindNonProfitResponse.access$000(this$0).equals(s))
            {
                if ("externalId".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final NonprofitElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            data.externalId = s;
                        }

            
            {
                this$2 = NonprofitElement.this;
                super();
            }
                    };
                }
                if ("nonprofitId".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final NonprofitElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            data.nonprofitId = s;
                        }

            
            {
                this$2 = NonprofitElement.this;
                super();
            }
                    };
                }
                if ("name".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final NonprofitElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            data.name = s;
                        }

            
            {
                this$2 = NonprofitElement.this;
                super();
            }
                    };
                }
                if ("mission".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final NonprofitElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            data.mission = s;
                        }

            
            {
                this$2 = NonprofitElement.this;
                super();
            }
                    };
                }
                if ("logoURL".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final NonprofitElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            data.logoUrl = s;
                        }

            
            {
                this$2 = NonprofitElement.this;
                super();
            }
                    };
                }
                if ("largeLogoURL".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final NonprofitElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            data.largeLogoUrl = s;
                        }

            
            {
                this$2 = NonprofitElement.this;
                super();
            }
                    };
                }
                if ("address".equals(s1))
                {
                    return new AddressElement(data.address);
                }
                if ("favoriteCount".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final NonprofitElement this$2;

                        protected void setValue(int i)
                            throws SAXException
                        {
                            data.favoriteCount = i;
                        }

            
            {
                this$2 = NonprofitElement.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public NonprofitElement(com.ebay.common.model.givingworks.NonprofitData.Nonprofit nonprofit)
        {
            this$1 = FindNonProfitResponse.RootElement.this;
            super();
            data = nonprofit;
        }
    }

    private final class PaginationOutputElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.givingworks.NonprofitData.PaginationOutput data;
        final FindNonProfitResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if (FindNonProfitResponse.access$000(this$0).equals(s) && "totalEntries".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final PaginationOutputElement this$2;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        data.totalEntries = i;
                    }

            
            {
                this$2 = PaginationOutputElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public PaginationOutputElement(com.ebay.common.model.givingworks.NonprofitData.PaginationOutput paginationoutput)
        {
            this$1 = FindNonProfitResponse.RootElement.this;
            super();
            data = paginationoutput;
        }
    }


    private final NonprofitData data;
    final FindNonProfitResponse this$0;

    public com.ebay.nautilus.kernel.util.ement get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if (FindNonProfitResponse.access$000(FindNonProfitResponse.this).equals(s))
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

                    final FindNonProfitResponse.RootElement this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        setVersion(s3);
                    }

            
            {
                this$1 = FindNonProfitResponse.RootElement.this;
                super();
            }
                };
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(FindNonProfitResponse.this, FindNonProfitResponse.access$000(FindNonProfitResponse.this));
            }
            if ("nonprofit".equals(s1))
            {
                s = new com.ebay.common.model.givingworks.t.this._cls0();
                data.nonprofits.add(s);
                return new NonprofitElement(s);
            }
            if ("paginationOutput".equals(s1))
            {
                return new PaginationOutputElement(data.paginationOutput);
            }
        }
        return super.(s, s1, s2, attributes);
    }

    public _cls1.this._cls1(NonprofitData nonprofitdata)
    {
        this$0 = FindNonProfitResponse.this;
        super();
        data = nonprofitdata;
    }
}
