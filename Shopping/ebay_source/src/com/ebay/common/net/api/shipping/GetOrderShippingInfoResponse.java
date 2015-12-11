// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shipping;

import com.ebay.common.model.OrderShippingInfo;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.text.ParseException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class GetOrderShippingInfoResponse extends EbayResponse
{
    private final class Body extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetOrderShippingInfoResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/shipping/v1/services".equals(s) && "getOrderShippingInfoResponse".equals(s1))
            {
                return new GetOrderShippingInfoResponseXml();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private Body()
        {
            this$0 = GetOrderShippingInfoResponse.this;
            super();
        }

    }

    private final class DeliveryEstimate extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetOrderShippingInfoResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/shipping/v1/services".equals(s))
            {
                if ("maxDeliveryDate".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final DeliveryEstimate this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            try
                            {
                                info.estimatedMaxDeliveryDate = EbayDateUtils.parseDateOnly(s);
                                return;
                            }
                            // Misplaced declaration of an exception variable
                            catch (String s)
                            {
                                throw new SAXException("Error parsing date");
                            }
                        }

            
            {
                this$1 = DeliveryEstimate.this;
                super();
            }
                    };
                }
                if ("minDeliveryDate".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final DeliveryEstimate this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            try
                            {
                                info.estimatedMinDeliveryDate = EbayDateUtils.parseDateOnly(s);
                                return;
                            }
                            // Misplaced declaration of an exception variable
                            catch (String s)
                            {
                                throw new SAXException("Error parsing date");
                            }
                        }

            
            {
                this$1 = DeliveryEstimate.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private DeliveryEstimate()
        {
            this$0 = GetOrderShippingInfoResponse.this;
            super();
        }

    }

    private final class GetOrderShippingInfoResponseXml extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetOrderShippingInfoResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/shipping/v1/services".equals(s) && "orderShippingInfo".equals(s1))
            {
                return new OrderShippingInfoXml();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetOrderShippingInfoResponseXml()
        {
            this$0 = GetOrderShippingInfoResponse.this;
            super();
        }

    }

    private final class OrderShippingInfoXml extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetOrderShippingInfoResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/shipping/v1/services".equals(s) && "transactionInfo".equals(s1))
            {
                return new TransactionInfo();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private OrderShippingInfoXml()
        {
            this$0 = GetOrderShippingInfoResponse.this;
            super();
        }

    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetOrderShippingInfoResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://schemas.xmlsoap.org/soap/envelope/".equals(s))
            {
                if ("Errors".equals(s1))
                {
                    return new ErrorElement(GetOrderShippingInfoResponse.this, "urn:ebay:apis:eBLBaseComponents");
                }
                if ("Body".equals(s1))
                {
                    return new Body();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement()
        {
            this$0 = GetOrderShippingInfoResponse.this;
            super();
        }

    }

    private final class SelectedShippingDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetOrderShippingInfoResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/shipping/v1/services".equals(s) && "deliveryEstimate".equals(s1))
            {
                return new DeliveryEstimate();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private SelectedShippingDetails()
        {
            this$0 = GetOrderShippingInfoResponse.this;
            super();
        }

    }

    private final class TransactionInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetOrderShippingInfoResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/shipping/v1/services".equals(s))
            {
                if ("selectedShippingDetails".equals(s1))
                {
                    return new SelectedShippingDetails();
                }
                if ("itemShippingService".equals(s1) && info.estimatedMaxDeliveryDate == null)
                {
                    return new itemShippingService();
                }
                if ("shippedDate".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final TransactionInfo this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            info.shippedDate = EbayDateUtils.parseXml(s);
                        }

            
            {
                this$1 = TransactionInfo.this;
                super();
            }
                    };
                }
                if ("actualDeliveryDate".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final TransactionInfo this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            info.actualDeliveryDate = EbayDateUtils.parseXml(s);
                        }

            
            {
                this$1 = TransactionInfo.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private TransactionInfo()
        {
            this$0 = GetOrderShippingInfoResponse.this;
            super();
        }

    }

    private final class itemShippingService extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetOrderShippingInfoResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/shipping/v1/services".equals(s) && "deliveryEstimate".equals(s1))
            {
                return new DeliveryEstimate();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private itemShippingService()
        {
            this$0 = GetOrderShippingInfoResponse.this;
            super();
        }

    }


    public OrderShippingInfo info;

    protected GetOrderShippingInfoResponse()
    {
        info = new OrderShippingInfo();
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }
}
