// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.EbayOrder;
import com.ebay.common.model.ItemTransactionVariation;
import com.ebay.common.model.OrderItemTransaction;
import com.ebay.common.model.Refund;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.data.OrderPickupStatus;
import com.ebay.nautilus.domain.data.ShippingCostsShippingOption;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.CurrencyElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class GetOrdersResponse extends EbayResponse
{
    private final class Buyer extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final OrderItemTransaction currentTx;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("BuyerInfo".equals(s1))
                {
                    return new BuyerInfo(currentTx);
                }
                if ("UserID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Buyer this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.buyerUserId = s;
                        }

            
            {
                this$1 = Buyer.this;
                super();
            }
                    };
                }
                if ("FeedbackRatingStar".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Buyer this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.buyerFeedbackRatingStar = s;
                        }

            
            {
                this$1 = Buyer.this;
                super();
            }
                    };
                }
                if ("FeedbackScore".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final Buyer this$1;

                        public void setValue(int i)
                            throws SAXException
                        {
                            currentTx.buyerFeedbackScore = Integer.valueOf(i);
                        }

            
            {
                this$1 = Buyer.this;
                super();
            }
                    };
                }
                if ("PositiveFeedbackPercent".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.FloatElement() {

                        final Buyer this$1;

                        public void setValue(float f)
                            throws SAXException
                        {
                            currentTx.buyerPositiveFeedbackPercent = Float.valueOf(f);
                        }

            
            {
                this$1 = Buyer.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public Buyer(OrderItemTransaction orderitemtransaction)
        {
            this$0 = GetOrdersResponse.this;
            super();
            currentTx = orderitemtransaction;
        }
    }

    private final class BuyerInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final OrderItemTransaction itemTransaction;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "ShippingAddress".equals(s1))
            {
                return new ShippingAddress(itemTransaction);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public BuyerInfo(OrderItemTransaction orderitemtransaction)
        {
            this$0 = GetOrdersResponse.this;
            super();
            itemTransaction = orderitemtransaction;
        }
    }

    private final class CheckoutStatus extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbayOrder order;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("eBayPaymentStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final CheckoutStatus this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        order.eBayPaymentStatus = s;
                    }

            
            {
                this$1 = CheckoutStatus.this;
                super();
            }
                };
            }
            if ("LastModifiedTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final CheckoutStatus this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        order.lastModifiedTime = EbayDateUtils.parseXml(s);
                    }

            
            {
                this$1 = CheckoutStatus.this;
                super();
            }
                };
            }
            if ("PaymentMethod".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final CheckoutStatus this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        order.paymentMethod = s;
                    }

            
            {
                this$1 = CheckoutStatus.this;
                super();
            }
                };
            }
            if ("Status".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final CheckoutStatus this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        order.statusXO = s;
                    }

            
            {
                this$1 = CheckoutStatus.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public CheckoutStatus(EbayOrder ebayorder)
        {
            this$0 = GetOrdersResponse.this;
            super();
            order = ebayorder;
        }
    }

    private final class ContainingOrder extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final OrderItemTransaction currentTx;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("OrderID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ContainingOrder this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.orderId = s;
                        }

            
            {
                this$1 = ContainingOrder.this;
                super();
            }
                    };
                }
                if ("OrderStatus".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ContainingOrder this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.orderStatus = s;
                        }

            
            {
                this$1 = ContainingOrder.this;
                super();
            }
                    };
                }
                if ("PaymentHoldDetails".equals(s1))
                {
                    return new PaymentHoldDetails(currentTx);
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public ContainingOrder(OrderItemTransaction orderitemtransaction)
        {
            this$0 = GetOrdersResponse.this;
            super();
            currentTx = orderitemtransaction;
        }
    }

    private final class Item extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final OrderItemTransaction currentTx;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("ItemID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.itemId = s;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("Site".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.site = s;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("Title".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.title = s;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("SKU".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.sku = s;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public Item(OrderItemTransaction orderitemtransaction)
        {
            this$0 = GetOrdersResponse.this;
            super();
            currentTx = orderitemtransaction;
        }
    }

    private final class MonetaryDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbayOrder order;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Refunds".equals(s1))
            {
                order.refunds = new ArrayList();
                return new Refunds(order);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public MonetaryDetails(EbayOrder ebayorder)
        {
            this$0 = GetOrdersResponse.this;
            super();
            order = ebayorder;
        }
    }

    private final class MultiLegShippingDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final OrderItemTransaction currentTx;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "SellerShipmentToLogisticsProvider".equals(s1))
            {
                return new SellerShipmentToLogisticsProvider(currentTx);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public MultiLegShippingDetails(OrderItemTransaction orderitemtransaction)
        {
            this$0 = GetOrdersResponse.this;
            super();
            currentTx = orderitemtransaction;
        }
    }

    private final class NameValueList extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final OrderItemTransaction currentTx;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                NameValue namevalue = (NameValue)currentTx.variation.nameValueList.get(currentTx.variation.nameValueList.size() - 1);
                if ("Name".equals(s1))
                {
                    return namevalue. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final NameValueList this$1;
                        final NameValue val$nameValue;

                        public void text(String s)
                            throws SAXException
                        {
                            nameValue.setName(s);
                        }

            
            {
                this$1 = final_namevaluelist;
                nameValue = NameValue.this;
                super();
            }
                    };
                }
                if ("Value".equals(s1))
                {
                    return namevalue. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final NameValueList this$1;
                        final NameValue val$nameValue;

                        public void text(String s)
                            throws SAXException
                        {
                            nameValue.addValue(s);
                        }

            
            {
                this$1 = final_namevaluelist;
                nameValue = NameValue.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public NameValueList(OrderItemTransaction orderitemtransaction)
        {
            this$0 = GetOrdersResponse.this;
            super();
            currentTx = orderitemtransaction;
            currentTx.variation.nameValueList.add(new NameValue());
        }
    }

    private final class Order extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbayOrder order;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("OrderID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Order this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        order.id = s;
                    }

            
            {
                this$1 = Order.this;
                super();
            }
                };
            }
            if ("OrderStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Order this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        order.status = s;
                    }

            
            {
                this$1 = Order.this;
                super();
            }
                };
            }
            if ("AdjustmentAmount".equals(s1))
            {
                s = order;
                s1 = new ItemCurrency();
                s.adjustmentAmount = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("AmountPaid".equals(s1))
            {
                s = order;
                s1 = new ItemCurrency();
                s.amountPaid = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("AmountSaved".equals(s1))
            {
                s = order;
                s1 = new ItemCurrency();
                s.amountSaved = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("PaymentMethods".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Order this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        order.paymentMethods = s;
                    }

            
            {
                this$1 = Order.this;
                super();
            }
                };
            }
            if ("SellerEmail".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Order this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        order.sellerEmail = s;
                    }

            
            {
                this$1 = Order.this;
                super();
            }
                };
            }
            if ("Subtotal".equals(s1))
            {
                s = order;
                s1 = new ItemCurrency();
                s.subtotal = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("Total".equals(s1))
            {
                s = order;
                s1 = new ItemCurrency();
                s.total = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("TransactionArray".equals(s1))
            {
                return new TransactionArray(order);
            }
            if ("CreatedTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Order this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        order.creationDate = EbayDateUtils.parseXml(s);
                    }

            
            {
                this$1 = Order.this;
                super();
            }
                };
            }
            if ("PickupDetails".equals(s1))
            {
                return new PickupDetails(order);
            }
            if ("PickupMethodSelected".equals(s1))
            {
                return new PickupMethodSelected(order);
            }
            if ("PaymentHoldStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Order this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        order.paymentHoldStatus = s;
                    }

            
            {
                this$1 = Order.this;
                super();
            }
                };
            }
            if ("ShippingServiceSelectedOrder".equals(s1))
            {
                return new ShippingServiceSelectedOrder(order);
            }
            if ("CheckoutStatus".equals(s1))
            {
                return new CheckoutStatus(order);
            }
            if ("MonetaryDetails".equals(s1))
            {
                return new MonetaryDetails(order);
            }
            if ("PaidTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Order this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        order.paidTime = EbayDateUtils.parseXml(s);
                    }

            
            {
                this$1 = Order.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public Order(EbayOrder ebayorder)
        {
            this$0 = GetOrdersResponse.this;
            super();
            order = ebayorder;
        }
    }

    private final class OrderArray extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbayResponse response;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Order".equals(s1))
            {
                s = new EbayOrder();
                ((GetOrdersResponse)response).orders.add(s);
                return new Order(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public OrderArray(EbayResponse ebayresponse)
        {
            this$0 = GetOrdersResponse.this;
            super();
            response = ebayresponse;
        }
    }

    private final class PaymentHoldDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final OrderItemTransaction currentTx;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("ExpectedReleaseDate".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final PaymentHoldDetails this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.expectedReleaseDate = EbayDateUtils.parseXml(s);
                        }

            
            {
                this$1 = PaymentHoldDetails.this;
                super();
            }
                    };
                }
                if ("RequiredSellerActionArray".equals(s1))
                {
                    return new RequiredSellerActionArray(currentTx);
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public PaymentHoldDetails(OrderItemTransaction orderitemtransaction)
        {
            this$0 = GetOrdersResponse.this;
            super();
            currentTx = orderitemtransaction;
        }
    }

    private final class PickupDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbayOrder order;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("PickupOptions".equals(s1))
            {
                return new PickupOptions(order);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public PickupDetails(EbayOrder ebayorder)
        {
            this$0 = GetOrdersResponse.this;
            super();
            order = ebayorder;
        }
    }

    private final class PickupMethodSelected extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbayOrder order;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("PickupMethod".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final PickupMethodSelected this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        order.selectedMethod = s;
                    }

            
            {
                this$1 = PickupMethodSelected.this;
                super();
            }
                };
            }
            if ("PickupStoreID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final PickupMethodSelected this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        order.storeId = s;
                    }

            
            {
                this$1 = PickupMethodSelected.this;
                super();
            }
                };
            }
            if ("PickupStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final PickupMethodSelected this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        order.pickupStatus = OrderPickupStatus.getByName(s);
                    }

            
            {
                this$1 = PickupMethodSelected.this;
                super();
            }
                };
            }
            if ("MerchantPickupCode".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final PickupMethodSelected this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        order.merchantPickupCode = s;
                    }

            
            {
                this$1 = PickupMethodSelected.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public PickupMethodSelected(EbayOrder ebayorder)
        {
            this$0 = GetOrdersResponse.this;
            super();
            order = ebayorder;
        }
    }

    private final class PickupOptions extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbayOrder order;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("PickupMethod".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final PickupOptions this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        order.pickupMethod = s;
                    }

            
            {
                this$1 = PickupOptions.this;
                super();
            }
                };
            }
            if ("PickupPriority".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final PickupOptions this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        order.pickupPriority = s;
                    }

            
            {
                this$1 = PickupOptions.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public PickupOptions(EbayOrder ebayorder)
        {
            this$0 = GetOrdersResponse.this;
            super();
            order = ebayorder;
        }
    }

    private final class RefundElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final Refund refund;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("RefundStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RefundElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        refund.status = s;
                    }

            
            {
                this$1 = RefundElement.this;
                super();
            }
                };
            }
            if ("RefundType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RefundElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        refund.type = s;
                    }

            
            {
                this$1 = RefundElement.this;
                super();
            }
                };
            }
            if ("RefundTo".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RefundElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        refund.refundTo = s;
                    }

            
            {
                this$1 = RefundElement.this;
                super();
            }
                };
            }
            if ("RefundTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RefundElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        refund.refundTime = EbayDateUtils.parseXml(s);
                    }

            
            {
                this$1 = RefundElement.this;
                super();
            }
                };
            }
            if ("RefundAmount".equals(s1))
            {
                s = refund;
                s1 = new ItemCurrency();
                s.refundAmount = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public RefundElement(Refund refund1)
        {
            this$0 = GetOrdersResponse.this;
            super();
            refund = refund1;
        }
    }

    private final class Refunds extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbayOrder order;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Refund".equals(s1))
            {
                s = new Refund();
                order.refunds.add(s);
                return new RefundElement(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public Refunds(EbayOrder ebayorder)
        {
            this$0 = GetOrdersResponse.this;
            super();
            order = ebayorder;
        }
    }

    private final class RequiredSellerActionArray extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final OrderItemTransaction currentTx;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "RequiredSellerAction".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RequiredSellerActionArray this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        currentTx.requiredSellerActions.add(s);
                    }

            
            {
                this$1 = RequiredSellerActionArray.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public RequiredSellerActionArray(OrderItemTransaction orderitemtransaction)
        {
            this$0 = GetOrdersResponse.this;
            super();
            currentTx = orderitemtransaction;
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbayResponse response;
        final GetOrdersResponse this$0;
        private final TimestampElement timestamp;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Ack".equals(s1))
            {
                return new AckElement(response);
            }
            if ("Timestamp".equals(s1))
            {
                return timestamp;
            }
            if ("Errors".equals(s1))
            {
                return new ErrorElement(response, "urn:ebay:apis:eBLBaseComponents");
            }
            if ("OrderArray".equals(s1))
            {
                orders = new ArrayList();
                return new OrderArray(response);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public RootElement(EbayResponse ebayresponse)
        {
            this$0 = GetOrdersResponse.this;
            super();
            response = ebayresponse;
            timestamp = new TimestampElement(ebayresponse);
        }
    }

    private final class SalesTax extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final OrderItemTransaction currentTx;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("SalesTaxAmount".equals(s1))
                {
                    s = currentTx;
                    s1 = new ItemCurrency();
                    s.salesTaxAmount = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("SalesTaxPercent".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.FloatElement() {

                        final SalesTax this$1;

                        public void setValue(float f)
                            throws SAXException
                        {
                            currentTx.salesTaxPercent = f;
                        }

            
            {
                this$1 = SalesTax.this;
                super();
            }
                    };
                }
                if ("SalesTaxState".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final SalesTax this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.salesTaxState = s;
                        }

            
            {
                this$1 = SalesTax.this;
                super();
            }
                    };
                }
                if ("ShippingIncludedInTax".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final SalesTax this$1;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            currentTx.salesTaxShippingIncludedInTax = flag;
                        }

            
            {
                this$1 = SalesTax.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public SalesTax(OrderItemTransaction orderitemtransaction)
        {
            this$0 = GetOrdersResponse.this;
            super();
            currentTx = orderitemtransaction;
        }
    }

    private final class SellerShipmentToLogisticsProvider extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final OrderItemTransaction currentTx;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "ShipToAddress".equals(s1))
            {
                return new ShipToAddress(currentTx);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public SellerShipmentToLogisticsProvider(OrderItemTransaction orderitemtransaction)
        {
            this$0 = GetOrdersResponse.this;
            super();
            currentTx = orderitemtransaction;
        }
    }

    private final class ShipToAddress extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final OrderItemTransaction currentTx;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("AddressId".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShipToAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.multiLegAddressId = s;
                        }

            
            {
                this$1 = ShipToAddress.this;
                super();
            }
                    };
                }
                if ("AddressOwner".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShipToAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.multiLegAddressOwner = s;
                        }

            
            {
                this$1 = ShipToAddress.this;
                super();
            }
                    };
                }
                if ("AddressUsage".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShipToAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.multiLegAddressUsage = s;
                        }

            
            {
                this$1 = ShipToAddress.this;
                super();
            }
                    };
                }
                if ("CityName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShipToAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.multiLegCityName = s;
                        }

            
            {
                this$1 = ShipToAddress.this;
                super();
            }
                    };
                }
                if ("Country".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShipToAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.multiLegCountry = s;
                        }

            
            {
                this$1 = ShipToAddress.this;
                super();
            }
                    };
                }
                if ("CountryName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShipToAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.multiLegCountryName = s;
                        }

            
            {
                this$1 = ShipToAddress.this;
                super();
            }
                    };
                }
                if ("ExternalAddressId".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShipToAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.multiLegExternalAddressId = s;
                        }

            
            {
                this$1 = ShipToAddress.this;
                super();
            }
                    };
                }
                if ("Name".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShipToAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.multiLegName = s;
                        }

            
            {
                this$1 = ShipToAddress.this;
                super();
            }
                    };
                }
                if ("Phone".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShipToAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.multiLegPhone = s;
                        }

            
            {
                this$1 = ShipToAddress.this;
                super();
            }
                    };
                }
                if ("PostalCode".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShipToAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.multiLegPostalCode = s;
                        }

            
            {
                this$1 = ShipToAddress.this;
                super();
            }
                    };
                }
                if ("ReferenceID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShipToAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.multiLegReferenceId = s;
                        }

            
            {
                this$1 = ShipToAddress.this;
                super();
            }
                    };
                }
                if ("StateOrProvince".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShipToAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.multiLegStateOrProvince = s;
                        }

            
            {
                this$1 = ShipToAddress.this;
                super();
            }
                    };
                }
                if ("Street1".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShipToAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.multiLegStreet1 = s;
                        }

            
            {
                this$1 = ShipToAddress.this;
                super();
            }
                    };
                }
                if ("Street2".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShipToAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.multiLegStreet2 = s;
                        }

            
            {
                this$1 = ShipToAddress.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public ShipToAddress(OrderItemTransaction orderitemtransaction)
        {
            this$0 = GetOrdersResponse.this;
            super();
            currentTx = orderitemtransaction;
        }
    }

    private final class ShipmentTrackingDetailsXml extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final OrderItemTransaction currentTx;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails shipmenttrackingdetails = (com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails)currentTx.shipmentTrackingDetails.get(currentTx.shipmentTrackingDetails.size() - 1);
                if ("ShipmentTrackingNumber".equals(s1))
                {
                    return shipmenttrackingdetails. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShipmentTrackingDetailsXml this$1;
                        final com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails val$std;

                        public void text(String s)
                            throws SAXException
                        {
                            std.shipmentTrackingNumber = s;
                        }

            
            {
                this$1 = final_shipmenttrackingdetailsxml;
                std = com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails.this;
                super();
            }
                    };
                }
                if ("ShippingCarrierUsed".equals(s1))
                {
                    return shipmenttrackingdetails. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShipmentTrackingDetailsXml this$1;
                        final com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails val$std;

                        public void text(String s)
                            throws SAXException
                        {
                            std.shippingCarrierUsed = s;
                        }

            
            {
                this$1 = final_shipmenttrackingdetailsxml;
                std = com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public ShipmentTrackingDetailsXml(OrderItemTransaction orderitemtransaction)
        {
            this$0 = GetOrdersResponse.this;
            super();
            currentTx = orderitemtransaction;
            getordersresponse = currentTx;
            getClass();
            getordersresponse = new com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails(GetOrdersResponse.this);
            currentTx.shipmentTrackingDetails.add(GetOrdersResponse.this);
        }
    }

    private final class ShippingAddress extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final OrderItemTransaction itemTransaction;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("CityName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShippingAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            itemTransaction.buyerCityName = s;
                        }

            
            {
                this$1 = ShippingAddress.this;
                super();
            }
                    };
                }
                if ("Street".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShippingAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            itemTransaction.buyerStreet = s;
                        }

            
            {
                this$1 = ShippingAddress.this;
                super();
            }
                    };
                }
                if ("Street1".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShippingAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            itemTransaction.buyerStreet1 = s;
                        }

            
            {
                this$1 = ShippingAddress.this;
                super();
            }
                    };
                }
                if ("Street2".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShippingAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            itemTransaction.buyerStreet2 = s;
                        }

            
            {
                this$1 = ShippingAddress.this;
                super();
            }
                    };
                }
                if ("Country".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShippingAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            itemTransaction.buyerCountry = s;
                        }

            
            {
                this$1 = ShippingAddress.this;
                super();
            }
                    };
                }
                if ("CountryName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShippingAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            itemTransaction.buyerCountryName = s;
                        }

            
            {
                this$1 = ShippingAddress.this;
                super();
            }
                    };
                }
                if ("Name".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShippingAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            itemTransaction.buyerName = s;
                        }

            
            {
                this$1 = ShippingAddress.this;
                super();
            }
                    };
                }
                if ("Phone".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShippingAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            itemTransaction.buyerPhone = s;
                        }

            
            {
                this$1 = ShippingAddress.this;
                super();
            }
                    };
                }
                if ("PostalCode".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShippingAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            itemTransaction.buyerPostalCode = s;
                        }

            
            {
                this$1 = ShippingAddress.this;
                super();
            }
                    };
                }
                if ("StateOrProvince".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShippingAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            itemTransaction.buyerStateOrProvince = s;
                        }

            
            {
                this$1 = ShippingAddress.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public ShippingAddress(OrderItemTransaction orderitemtransaction)
        {
            this$0 = GetOrdersResponse.this;
            super();
            itemTransaction = orderitemtransaction;
        }
    }

    private final class ShippingDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final OrderItemTransaction currentTx;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("ShippingType".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShippingDetails this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.shippingType = s;
                        }

            
            {
                this$1 = ShippingDetails.this;
                super();
            }
                    };
                }
                if ("ThirdPartyCheckout".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final ShippingDetails this$1;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            currentTx.thirdPartyCheckout = flag;
                        }

            
            {
                this$1 = ShippingDetails.this;
                super();
            }
                    };
                }
                if ("ShipmentTrackingDetails".equals(s1))
                {
                    return new ShipmentTrackingDetailsXml(currentTx);
                }
                if ("ShippingServiceOptions".equals(s1))
                {
                    return new ShippingServiceOption(currentTx);
                }
                if ("InternationalShippingServiceOption".equals(s1))
                {
                    return new ShippingServiceOption(currentTx);
                }
                if ("SalesTax".equals(s1))
                {
                    return new SalesTax(currentTx);
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public ShippingDetails(OrderItemTransaction orderitemtransaction)
        {
            this$0 = GetOrdersResponse.this;
            super();
            currentTx = orderitemtransaction;
        }
    }

    private final class ShippingServiceOption extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final OrderItemTransaction currentTx;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            ShippingCostsShippingOption shippingcostsshippingoption = (ShippingCostsShippingOption)currentTx.shippingOptions.get(currentTx.shippingOptions.size() - 1);
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("ExpeditedService".equals(s1))
                {
                    return shippingcostsshippingoption. new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final ShippingServiceOption this$1;
                        final ShippingCostsShippingOption val$so;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            so.expeditedService = flag;
                        }

            
            {
                this$1 = final_shippingserviceoption;
                so = ShippingCostsShippingOption.this;
                super();
            }
                    };
                }
                if ("ShippingInsuranceCost".equals(s1))
                {
                    s = new ItemCurrency();
                    shippingcostsshippingoption.shippingInsuranceCost = s;
                    return new CurrencyElement(s, "currencyID", attributes);
                }
                if ("ShippingServiceAdditionalCost".equals(s1))
                {
                    s = new ItemCurrency();
                    shippingcostsshippingoption.shippingServiceAdditionalCost = s;
                    return new CurrencyElement(s, "currencyID", attributes);
                }
                if ("ShippingServiceCost".equals(s1))
                {
                    s = new ItemCurrency();
                    shippingcostsshippingoption.shippingServiceCost = s;
                    return new CurrencyElement(s, "currencyID", attributes);
                }
                if ("ShippingService".equals(s1))
                {
                    return shippingcostsshippingoption. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShippingServiceOption this$1;
                        final ShippingCostsShippingOption val$so;

                        public void text(String s)
                            throws SAXException
                        {
                            so.shippingServiceName = s;
                        }

            
            {
                this$1 = final_shippingserviceoption;
                so = ShippingCostsShippingOption.this;
                super();
            }
                    };
                }
                if ("ShippingServicePriority".equals(s1))
                {
                    return shippingcostsshippingoption. new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final ShippingServiceOption this$1;
                        final ShippingCostsShippingOption val$so;

                        public void setValue(int i)
                            throws SAXException
                        {
                            so.shippingServicePriority = i;
                        }

            
            {
                this$1 = final_shippingserviceoption;
                so = ShippingCostsShippingOption.this;
                super();
            }
                    };
                }
                if ("ShippingSurcharge".equals(s1))
                {
                    s = new ItemCurrency();
                    shippingcostsshippingoption.shippingSurcharge = s;
                    return new CurrencyElement(s, "currencyID", attributes);
                }
                if ("ShippingTimeMax".equals(s1))
                {
                    return shippingcostsshippingoption. new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final ShippingServiceOption this$1;
                        final ShippingCostsShippingOption val$so;

                        public void setValue(int i)
                            throws SAXException
                        {
                            so.shippingTimeMax = i;
                        }

            
            {
                this$1 = final_shippingserviceoption;
                so = ShippingCostsShippingOption.this;
                super();
            }
                    };
                }
                if ("ShippingTimeMin".equals(s1))
                {
                    return shippingcostsshippingoption. new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final ShippingServiceOption this$1;
                        final ShippingCostsShippingOption val$so;

                        public void setValue(int i)
                            throws SAXException
                        {
                            so.shippingTimeMin = i;
                        }

            
            {
                this$1 = final_shippingserviceoption;
                so = ShippingCostsShippingOption.this;
                super();
            }
                    };
                }
                if ("ImportCharge".equals(s1))
                {
                    s = new ItemCurrency();
                    shippingcostsshippingoption.importCharge = s;
                    return new CurrencyElement(s, "currencyID", attributes);
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public ShippingServiceOption(OrderItemTransaction orderitemtransaction)
        {
            this$0 = GetOrdersResponse.this;
            super();
            currentTx = orderitemtransaction;
            currentTx.shippingOptions.add(new ShippingCostsShippingOption());
        }
    }

    private final class ShippingServiceSelected extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final OrderItemTransaction currentTx;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("ShippingService".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShippingServiceSelected this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.selectedShippingOption.shippingServiceName = s;
                        }

            
            {
                this$1 = ShippingServiceSelected.this;
                super();
            }
                    };
                }
                if ("ShippingServiceCost".equals(s1))
                {
                    s = currentTx.selectedShippingOption;
                    s1 = new ItemCurrency();
                    s.shippingServiceCost = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("ShippingServiceAdditionalCost".equals(s1))
                {
                    s = currentTx.selectedShippingOption;
                    s1 = new ItemCurrency();
                    s.shippingServiceAdditionalCost = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("ShippingTimeMin".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final ShippingServiceSelected this$1;

                        public void setValue(int i)
                            throws SAXException
                        {
                            currentTx.selectedShippingOption.shippingTimeMin = i;
                        }

            
            {
                this$1 = ShippingServiceSelected.this;
                super();
            }
                    };
                }
                if ("ShippingTimeMax".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final ShippingServiceSelected this$1;

                        public void setValue(int i)
                            throws SAXException
                        {
                            currentTx.selectedShippingOption.shippingTimeMax = i;
                        }

            
            {
                this$1 = ShippingServiceSelected.this;
                super();
            }
                    };
                }
                if ("ImportCharge".equals(s1))
                {
                    s = currentTx.selectedShippingOption;
                    s1 = new ItemCurrency();
                    s.importCharge = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public ShippingServiceSelected(OrderItemTransaction orderitemtransaction)
        {
            this$0 = GetOrdersResponse.this;
            super();
            currentTx = orderitemtransaction;
        }
    }

    private final class ShippingServiceSelectedOrder extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbayOrder order;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ShippingService".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ShippingServiceSelectedOrder this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        order.shippingService = s;
                    }

            
            {
                this$1 = ShippingServiceSelectedOrder.this;
                super();
            }
                };
            }
            if ("ShippingServiceCost".equals(s1))
            {
                s = order;
                s1 = new ItemCurrency();
                s.shippingCost = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public ShippingServiceSelectedOrder(EbayOrder ebayorder)
        {
            this$0 = GetOrdersResponse.this;
            super();
            order = ebayorder;
        }
    }

    private final class Status extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final OrderItemTransaction currentTx;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("CompleteStatus".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Status this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.completeStatus = s;
                        }

            
            {
                this$1 = Status.this;
                super();
            }
                    };
                }
                if ("eBayPaymentStatus".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Status this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.ebayPaymentStatus = s;
                        }

            
            {
                this$1 = Status.this;
                super();
            }
                    };
                }
                if ("PaymentHoldStatus".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Status this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.paymentHoldStatus = s;
                        }

            
            {
                this$1 = Status.this;
                super();
            }
                    };
                }
                if ("PaymentMethodUsed".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Status this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.paymentMethodUsed = s;
                        }

            
            {
                this$1 = Status.this;
                super();
            }
                    };
                }
                if ("CheckoutStatus".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Status this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.checkoutStatus = s;
                        }

            
            {
                this$1 = Status.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public Status(OrderItemTransaction orderitemtransaction)
        {
            this$0 = GetOrdersResponse.this;
            super();
            currentTx = orderitemtransaction;
        }
    }

    private final class Transaction extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final OrderItemTransaction currentTx = new OrderItemTransaction();
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Buyer".equals(s1))
                {
                    return new Buyer(currentTx);
                }
                if ("Status".equals(s1))
                {
                    return new Status(currentTx);
                }
                if ("ShippingServiceSelected".equals(s1))
                {
                    return new ShippingServiceSelected(currentTx);
                }
                if ("ShippingDetails".equals(s1))
                {
                    return new ShippingDetails(currentTx);
                }
                if ("ContainingOrder".equals(s1))
                {
                    return new ContainingOrder(currentTx);
                }
                if ("Variation".equals(s1))
                {
                    return new Variation(currentTx);
                }
                if ("TransactionID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Transaction this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.transactionId = s;
                        }

            
            {
                this$1 = Transaction.this;
                super();
            }
                    };
                }
                if ("QuantityPurchased".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final Transaction this$1;

                        public void setValue(int i)
                            throws SAXException
                        {
                            currentTx.quantityPurchased = i;
                        }

            
            {
                this$1 = Transaction.this;
                super();
            }
                    };
                }
                if ("TransactionPrice".equals(s1))
                {
                    s = currentTx;
                    s1 = new ItemCurrency();
                    s.transactionPrice = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("ConvertedTransactionPrice".equals(s1))
                {
                    s = currentTx;
                    s1 = new ItemCurrency();
                    s.convertedTransactionPrice = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("AmountPaid".equals(s1))
                {
                    s = currentTx;
                    s1 = new ItemCurrency();
                    s.amountPaid = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("ConvertedAmountPaid".equals(s1))
                {
                    s = currentTx;
                    s1 = new ItemCurrency();
                    s.convertedAmountPaid = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("CreatedDate".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Transaction this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.createdDate = EbayDateUtils.parseXml(s);
                        }

            
            {
                this$1 = Transaction.this;
                super();
            }
                    };
                }
                if ("OrderLineItemID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Transaction this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.orderLineItemId = s;
                        }

            
            {
                this$1 = Transaction.this;
                super();
            }
                    };
                }
                if ("IsMultiLegShipping".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final Transaction this$1;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            currentTx.multiLeg = flag;
                        }

            
            {
                this$1 = Transaction.this;
                super();
            }
                    };
                }
                if ("MultiLegShippingDetails".equals(s1))
                {
                    return new MultiLegShippingDetails(currentTx);
                }
                if ("Item".equals(s1))
                {
                    return new Item(currentTx);
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public Transaction(EbayOrder ebayorder)
        {
            this$0 = GetOrdersResponse.this;
            super();
            ebayorder.transactions.add(currentTx);
        }
    }

    private final class TransactionArray extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbayOrder order;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "Transaction".equals(s1))
            {
                return new Transaction(order);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public TransactionArray(EbayOrder ebayorder)
        {
            this$0 = GetOrdersResponse.this;
            super();
            order = ebayorder;
            order.transactions = new ArrayList();
        }
    }

    private final class Variation extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final OrderItemTransaction currentTx;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("SKU".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Variation this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.variation.sku = s;
                        }

            
            {
                this$1 = Variation.this;
                super();
            }
                    };
                }
                if ("VariationTitle".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Variation this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.variation.variationTitle = s;
                        }

            
            {
                this$1 = Variation.this;
                super();
            }
                    };
                }
                if ("VariationViewItemURL".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Variation this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            currentTx.variation.variationViewItemURL = s;
                        }

            
            {
                this$1 = Variation.this;
                super();
            }
                    };
                }
                if ("VariationSpecifics".equals(s1))
                {
                    return new VariationSpecifics(currentTx);
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public Variation(OrderItemTransaction orderitemtransaction)
        {
            this$0 = GetOrdersResponse.this;
            super();
            currentTx = orderitemtransaction;
        }
    }

    private final class VariationSpecifics extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final OrderItemTransaction currentTx;
        final GetOrdersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "NameValueList".equals(s1))
            {
                return new NameValueList(currentTx);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public VariationSpecifics(OrderItemTransaction orderitemtransaction)
        {
            this$0 = GetOrdersResponse.this;
            super();
            currentTx = orderitemtransaction;
        }
    }


    public List orders;

    public GetOrdersResponse()
    {
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement(this));
    }
}
