// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.UserDispute;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class GetUserDisputesResponse extends EbayResponse
{
    private final class Dispute extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetUserDisputesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                UserDispute userdispute = (UserDispute)userDisputes.get(userDisputes.size() - 1);
                if ("DisputeCreatedTime".equals(s1))
                {
                    return userdispute. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Dispute this$1;
                        final UserDispute val$dispute;

                        public void text(String s)
                            throws SAXException
                        {
                            dispute.createdTime = EbayDateUtils.parseXml(s);
                        }

            
            {
                this$1 = final_dispute1;
                dispute = UserDispute.this;
                super();
            }
                    };
                }
                if ("DisputeCreditEligibility".equals(s1))
                {
                    return userdispute. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Dispute this$1;
                        final UserDispute val$dispute;

                        public void text(String s)
                            throws SAXException
                        {
                            dispute.creditEligibility = s;
                        }

            
            {
                this$1 = final_dispute1;
                dispute = UserDispute.this;
                super();
            }
                    };
                }
                if ("DisputeExplanation".equals(s1))
                {
                    return userdispute. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Dispute this$1;
                        final UserDispute val$dispute;

                        public void text(String s)
                            throws SAXException
                        {
                            dispute.explanation = s;
                        }

            
            {
                this$1 = final_dispute1;
                dispute = UserDispute.this;
                super();
            }
                    };
                }
                if ("DisputeID".equals(s1))
                {
                    return userdispute. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Dispute this$1;
                        final UserDispute val$dispute;

                        public void text(String s)
                            throws SAXException
                        {
                            dispute.id = s;
                        }

            
            {
                this$1 = final_dispute1;
                dispute = UserDispute.this;
                super();
            }
                    };
                }
                if ("DisputeReason".equals(s1))
                {
                    return userdispute. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Dispute this$1;
                        final UserDispute val$dispute;

                        public void text(String s)
                            throws SAXException
                        {
                            dispute.reason = s;
                        }

            
            {
                this$1 = final_dispute1;
                dispute = UserDispute.this;
                super();
            }
                    };
                }
                if ("DisputeState".equals(s1))
                {
                    return userdispute. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Dispute this$1;
                        final UserDispute val$dispute;

                        public void text(String s)
                            throws SAXException
                        {
                            dispute.state = s;
                        }

            
            {
                this$1 = final_dispute1;
                dispute = UserDispute.this;
                super();
            }
                    };
                }
                if ("DisputeStatus".equals(s1))
                {
                    return userdispute. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Dispute this$1;
                        final UserDispute val$dispute;

                        public void text(String s)
                            throws SAXException
                        {
                            dispute.status = s;
                        }

            
            {
                this$1 = final_dispute1;
                dispute = UserDispute.this;
                super();
            }
                    };
                }
                if ("Item".equals(s1))
                {
                    return new Item(userdispute);
                }
                if ("OrderLineItemID".equals(s1))
                {
                    return userdispute. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Dispute this$1;
                        final UserDispute val$dispute;

                        public void text(String s)
                            throws SAXException
                        {
                            dispute.orderLineItemId = s;
                        }

            
            {
                this$1 = final_dispute1;
                dispute = UserDispute.this;
                super();
            }
                    };
                }
                if ("TransactionID".equals(s1))
                {
                    return userdispute. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Dispute this$1;
                        final UserDispute val$dispute;

                        public void text(String s)
                            throws SAXException
                        {
                            dispute.transactionId = s;
                        }

            
            {
                this$1 = final_dispute1;
                dispute = UserDispute.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public Dispute()
        {
            this$0 = GetUserDisputesResponse.this;
            super();
            userDisputes.add(new UserDispute());
        }
    }

    private final class DisputeArray extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetUserDisputesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "Dispute".equals(s1))
            {
                return new Dispute();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private DisputeArray()
        {
            this$0 = GetUserDisputesResponse.this;
            super();
        }

    }

    private final class Item extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final UserDispute dispute;
        final GetUserDisputesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "ItemID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Item this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        dispute.itemId = s;
                    }

            
            {
                this$1 = Item.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public Item(UserDispute userdispute)
        {
            this$0 = GetUserDisputesResponse.this;
            super();
            dispute = userdispute;
        }
    }

    private final class PaginationResult extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetUserDisputesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "TotalNumberOfPages".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final PaginationResult this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        totalNumberOfPages = i;
                    }

            
            {
                this$1 = PaginationResult.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private PaginationResult()
        {
            this$0 = GetUserDisputesResponse.this;
            super();
        }

    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetUserDisputesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(GetUserDisputesResponse.this);
                }
                if ("Timestamp".equals(s1))
                {
                    return new TimestampElement(GetUserDisputesResponse.this);
                }
                if ("Errors".equals(s1))
                {
                    return new ErrorElement(GetUserDisputesResponse.this, "urn:ebay:apis:eBLBaseComponents");
                }
                if ("DisputeArray".equals(s1))
                {
                    return new DisputeArray();
                }
                if ("PaginationResult".equals(s1))
                {
                    return new PaginationResult();
                }
                if ("PageNumber".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final RootElement this$1;

                        public void setValue(int i)
                            throws SAXException
                        {
                            pageNumber = i;
                        }

            
            {
                this$1 = RootElement.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement()
        {
            this$0 = GetUserDisputesResponse.this;
            super();
        }

    }


    public int pageNumber;
    public int totalNumberOfPages;
    public ArrayList userDisputes;

    public GetUserDisputesResponse()
    {
        userDisputes = new ArrayList();
        totalNumberOfPages = 0;
        pageNumber = 0;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }
}
