// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import android.text.TextUtils;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.model.ItemTransactionVariation;
import com.ebay.common.model.Payment;
import com.ebay.common.model.Refund;
import com.ebay.common.util.LogisticsUtil;
import com.ebay.nautilus.domain.data.EbnOrderCancelReason;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.data.OrderPickupStatus;
import com.ebay.nautilus.domain.data.ShippingCostsShippingOption;
import com.ebay.nautilus.domain.data.ShippingPackageInfo;
import com.ebay.nautilus.domain.data.ShippingTrackingEvent;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.CurrencyElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class GetItemTransactionsResponse extends EbayResponse
{
    private final class Buyer extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("BuyerInfo".equals(s1))
                {
                    return new BuyerInfo();
                }
                if ("UserID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Buyer this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            itemTransaction.buyerUserId = s;
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
                            itemTransaction.buyerFeedbackRatingStar = s;
                        }

            
            {
                this$1 = Buyer.this;
                super();
            }
                    };
                }
                if ("FeedbackPrivate".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Buyer this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            itemTransaction.buyerFeedbackPrivate = "true".equals(s);
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
                            itemTransaction.buyerFeedbackScore = Integer.valueOf(i);
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
                            itemTransaction.buyerPositiveFeedbackPercent = Float.valueOf(f);
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

        private Buyer()
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
        }

    }

    private final class BuyerInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "ShippingAddress".equals(s1))
            {
                return new ShippingAddress();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private BuyerInfo()
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
        }

    }

    private final class ContainingOrder extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;

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
                            itemTransaction.orderId = s;
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
                            itemTransaction.orderStatus = s;
                        }

            
            {
                this$1 = ContainingOrder.this;
                super();
            }
                    };
                }
                if ("PaymentHoldDetails".equals(s1))
                {
                    return new PaymentHoldDetails();
                }
                if ("CancelReason".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ContainingOrder this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            itemTransaction.cancelReason = EbnOrderCancelReason.getByName(s);
                        }

            
            {
                this$1 = ContainingOrder.this;
                super();
            }
                    };
                }
                if ("CancelStatus".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ContainingOrder this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            itemTransaction.cancelStatus = s;
                        }

            
            {
                this$1 = ContainingOrder.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private ContainingOrder()
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
        }

    }

    private final class Item extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Seller".equals(s1))
                {
                    return new Seller();
                }
                if ("PaymentMethods".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            paymentMethods.add(s);
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

        private Item()
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
        }

    }

    private final class MonetaryDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;
        private final ItemTransaction tx;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Refunds".equals(s1))
            {
                tx.refunds = new ArrayList();
                return new Refunds(tx);
            }
            if ("Payments".equals(s1))
            {
                tx.payments = new ArrayList();
                return new Payments(tx);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public MonetaryDetails(ItemTransaction itemtransaction)
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
            tx = itemtransaction;
        }
    }

    private final class MultiLegShippingDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;
        private final ItemTransaction tx;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "SellerShipmentToLogisticsProvider".equals(s1))
            {
                return new SellerShipmentToLogisticsProvider(tx);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public MultiLegShippingDetails(ItemTransaction itemtransaction)
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
            tx = itemtransaction;
        }
    }

    private final class NameValueList extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                NameValue namevalue = (NameValue)itemTransaction.variation.nameValueList.get(itemTransaction.variation.nameValueList.size() - 1);
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

        public NameValueList()
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
            itemTransaction.variation.nameValueList.add(new NameValue());
        }
    }

    private final class PaymentElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final Payment payment;
        final GetItemTransactionsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("PaymentStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final PaymentElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        payment.status = s;
                    }

            
            {
                this$1 = PaymentElement.this;
                super();
            }
                };
            }
            if ("PaymentTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final PaymentElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        payment.time = EbayDateUtils.parseXml(s);
                    }

            
            {
                this$1 = PaymentElement.this;
                super();
            }
                };
            }
            if ("PaymentAmount".equals(s1))
            {
                s = payment;
                s1 = new ItemCurrency();
                s.amount = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("FeeOrCreditAmount".equals(s1))
            {
                s = payment;
                s1 = new ItemCurrency();
                s.feeOrCreditAmount = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public PaymentElement(Payment payment1)
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
            payment = payment1;
        }
    }

    private final class PaymentHoldDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;

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
                            itemTransaction.expectedReleaseDate = EbayDateUtils.parseXml(s);
                        }

            
            {
                this$1 = PaymentHoldDetails.this;
                super();
            }
                    };
                }
                if ("RequiredSellerActionArray".equals(s1))
                {
                    return new RequiredSellerActionArray();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private PaymentHoldDetails()
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
        }

    }

    private final class Payments extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;
        private final ItemTransaction tx;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Payment".equals(s1))
            {
                s = new Payment();
                tx.payments.add(s);
                return new PaymentElement(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public Payments(ItemTransaction itemtransaction)
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
            tx = itemtransaction;
        }
    }

    private final class PickupDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;
        private final ItemTransaction tx;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("PickupOptions".equals(s1))
            {
                return new PickupOptions(tx);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public PickupDetails(ItemTransaction itemtransaction)
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
            tx = itemtransaction;
        }
    }

    private final class PickupMethodSelected extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;
        private final ItemTransaction tx;

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
                        tx.selectedMethod = s;
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
                        tx.storeId = s;
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
                        tx.pickupStatus = OrderPickupStatus.getByName(s);
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
                        tx.merchantPickupCode = s;
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


        public PickupMethodSelected(ItemTransaction itemtransaction)
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
            tx = itemtransaction;
        }
    }

    private final class PickupOptions extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;
        private final ItemTransaction tx;

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
                        tx.pickupMethod = s;
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
                        tx.pickupPriority = s;
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


        public PickupOptions(ItemTransaction itemtransaction)
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
            tx = itemtransaction;
        }
    }

    private final class RefundElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final Refund refund;
        final GetItemTransactionsResponse this$0;

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
            this$0 = GetItemTransactionsResponse.this;
            super();
            refund = refund1;
        }
    }

    private final class Refunds extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;
        private final ItemTransaction tx;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Refund".equals(s1))
            {
                s = new Refund();
                tx.refunds.add(s);
                return new RefundElement(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public Refunds(ItemTransaction itemtransaction)
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
            tx = itemtransaction;
        }
    }

    private final class RequiredSellerActionArray extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;

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
                        itemTransaction.requiredSellerActions.add(s);
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

        private RequiredSellerActionArray()
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
        }

    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(GetItemTransactionsResponse.this);
                }
                if ("Timestamp".equals(s1))
                {
                    return new TimestampElement(GetItemTransactionsResponse.this);
                }
                if ("Errors".equals(s1))
                {
                    return new ErrorElement(GetItemTransactionsResponse.this, "urn:ebay:apis:eBLBaseComponents");
                }
                if ("Item".equals(s1))
                {
                    return new Item();
                }
                if ("TransactionArray".equals(s1))
                {
                    return new TransactionArray();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement()
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
        }

    }

    private final class SalesTax extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("SalesTaxAmount".equals(s1))
                {
                    s = itemTransaction;
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
                            itemTransaction.salesTaxPercent = f;
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
                            itemTransaction.salesTaxState = s;
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
                            itemTransaction.salesTaxShippingIncludedInTax = flag;
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

        private SalesTax()
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
        }

    }

    private final class Seller extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "UserID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Seller this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        sellerUserId = s;
                    }

            
            {
                this$1 = Seller.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private Seller()
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
        }

    }

    private final class SellerShipmentToLogisticsProvider extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;
        private final ItemTransaction tx;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("ShipToAddress".equals(s1))
                {
                    return new ShipToAddress();
                }
                if ("ShippingServiceDetails".equals(s1))
                {
                    return new ShippingServiceDetails(tx);
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public SellerShipmentToLogisticsProvider(ItemTransaction itemtransaction)
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
            tx = itemtransaction;
        }
    }

    private final class ShipToAddress extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;

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
                            itemTransaction.multiLegAddressId = s;
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
                            itemTransaction.multiLegAddressOwner = s;
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
                            itemTransaction.multiLegAddressUsage = s;
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
                            itemTransaction.multiLegCityName = s;
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
                            itemTransaction.multiLegCountry = s;
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
                            itemTransaction.multiLegCountryName = s;
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
                            itemTransaction.multiLegExternalAddressId = s;
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
                            itemTransaction.multiLegName = s;
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
                            itemTransaction.multiLegPhone = s;
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
                            itemTransaction.multiLegPostalCode = s;
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
                            itemTransaction.multiLegReferenceId = s;
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
                            itemTransaction.multiLegStateOrProvince = s;
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
                            itemTransaction.multiLegStreet1 = s;
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
                            itemTransaction.multiLegStreet2 = s;
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

        private ShipToAddress()
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
        }

    }

    private final class ShipmentTrackingDetailsXml extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails shipmenttrackingdetails = (com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails)itemTransaction.shipmentTrackingDetails.get(itemTransaction.shipmentTrackingDetails.size() - 1);
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
                            ItemTransaction itemtransaction = itemTransaction;
                            boolean flag;
                            if ("eBay Now".equalsIgnoreCase(s) || "Scheduled Delivery".equalsIgnoreCase(s))
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            itemtransaction.isEbayNow = flag;
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

        public ShipmentTrackingDetailsXml()
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
            Object obj = itemTransaction;
            obj.getClass();
            obj = new com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails(((ItemTransaction) (obj)));
            itemTransaction.shipmentTrackingDetails.add(obj);
        }
    }

    private final class ShippingAddress extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;

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

        private ShippingAddress()
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
        }

    }

    private final class ShippingDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;

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
                            itemTransaction.shippingType = s;
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
                            itemTransaction.thirdPartyCheckout = flag;
                        }

            
            {
                this$1 = ShippingDetails.this;
                super();
            }
                    };
                }
                if ("ShipmentTrackingDetails".equals(s1))
                {
                    return new ShipmentTrackingDetailsXml();
                }
                if ("ShippingServiceOptions".equals(s1))
                {
                    return new ShippingServiceOption();
                }
                if ("InternationalShippingServiceOption".equals(s1))
                {
                    return new ShippingServiceOption();
                }
                if ("SalesTax".equals(s1))
                {
                    return new SalesTax();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private ShippingDetails()
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
        }

    }

    private final class ShippingPackageInfoElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("StoreID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShippingPackageInfoElement this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            itemTransaction.selectedShippingOption.shippingPackageInfo.storeId = s;
                        }

            
            {
                this$1 = ShippingPackageInfoElement.this;
                super();
            }
                    };
                }
                if ("ShippingTrackingEvent".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShippingPackageInfoElement this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            itemTransaction.selectedShippingOption.shippingPackageInfo.shippingTrackingEvent = ShippingTrackingEvent.valueOf(s);
                        }

            
            {
                this$1 = ShippingPackageInfoElement.this;
                super();
            }
                    };
                }
                if ("ScheduledDeliveryTimeMin".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShippingPackageInfoElement this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            try
                            {
                                itemTransaction.selectedShippingOption.shippingPackageInfo.scheduledDeliveryTimeMin = EbayDateUtils.parseIso8601DateTime(s);
                                return;
                            }
                            // Misplaced declaration of an exception variable
                            catch (String s)
                            {
                                throw new SAXException(s);
                            }
                        }

            
            {
                this$1 = ShippingPackageInfoElement.this;
                super();
            }
                    };
                }
                if ("ScheduledDeliveryTimeMax".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShippingPackageInfoElement this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            try
                            {
                                itemTransaction.selectedShippingOption.shippingPackageInfo.scheduledDeliveryTimeMax = EbayDateUtils.parseIso8601DateTime(s);
                                return;
                            }
                            // Misplaced declaration of an exception variable
                            catch (String s)
                            {
                                throw new SAXException(s);
                            }
                        }

            
            {
                this$1 = ShippingPackageInfoElement.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public ShippingPackageInfoElement()
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
            itemTransaction.selectedShippingOption.shippingPackageInfo = new ShippingPackageInfo();
        }
    }

    private final class ShippingServiceDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;
        private final ItemTransaction tx;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "ShippingService".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ShippingServiceDetails this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        tx.multiLegServiceName = s;
                    }

            
            {
                this$1 = ShippingServiceDetails.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public ShippingServiceDetails(ItemTransaction itemtransaction)
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
            tx = itemtransaction;
        }
    }

    private final class ShippingServiceOption extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            ShippingCostsShippingOption shippingcostsshippingoption = (ShippingCostsShippingOption)itemTransaction.shippingOptions.get(itemTransaction.shippingOptions.size() - 1);
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

        public ShippingServiceOption()
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
            itemTransaction.shippingOptions.add(new ShippingCostsShippingOption());
        }
    }

    private final class ShippingServiceSelected extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;

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
                            itemTransaction.selectedShippingOption.shippingServiceName = s;
                            if (!TextUtils.isEmpty(s) && LogisticsUtil.sPlanOptionTokenMap.containsKey(s))
                            {
                                itemTransaction.isEbayNow = true;
                            }
                        }

            
            {
                this$1 = ShippingServiceSelected.this;
                super();
            }
                    };
                }
                if ("ShippingServiceCost".equals(s1))
                {
                    s = itemTransaction.selectedShippingOption;
                    s1 = new ItemCurrency();
                    s.shippingServiceCost = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("ShippingServiceAdditionalCost".equals(s1))
                {
                    s = itemTransaction.selectedShippingOption;
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
                            itemTransaction.selectedShippingOption.shippingTimeMin = i;
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
                            itemTransaction.selectedShippingOption.shippingTimeMax = i;
                        }

            
            {
                this$1 = ShippingServiceSelected.this;
                super();
            }
                    };
                }
                if ("ImportCharge".equals(s1))
                {
                    s = itemTransaction.selectedShippingOption;
                    s1 = new ItemCurrency();
                    s.importCharge = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("ShippingPackageInfo".equals(s1))
                {
                    return new ShippingPackageInfoElement();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private ShippingServiceSelected()
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
        }

    }

    private final class Status extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;

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
                            itemTransaction.completeStatus = s;
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
                            itemTransaction.ebayPaymentStatus = s;
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
                            itemTransaction.paymentHoldStatus = s;
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
                            itemTransaction.paymentMethodUsed = s;
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
                            itemTransaction.checkoutStatus = s;
                        }

            
            {
                this$1 = Status.this;
                super();
            }
                    };
                }
                if ("InquiryStatus".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Status this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            itemTransaction.inquiryStatus = s;
                        }

            
            {
                this$1 = Status.this;
                super();
            }
                    };
                }
                if ("ReturnStatus".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Status this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            itemTransaction.returnStatus = s;
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

        private Status()
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
        }

    }

    private final class Transaction extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Buyer".equals(s1))
                {
                    return new Buyer();
                }
                if ("Status".equals(s1))
                {
                    return new Status();
                }
                if ("ShippingServiceSelected".equals(s1))
                {
                    return new ShippingServiceSelected();
                }
                if ("ShippingDetails".equals(s1))
                {
                    return new ShippingDetails();
                }
                if ("ContainingOrder".equals(s1))
                {
                    return new ContainingOrder();
                }
                if ("Variation".equals(s1))
                {
                    return new Variation();
                }
                if ("TransactionID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Transaction this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            itemTransaction.transactionId = s;
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
                            itemTransaction.quantityPurchased = i;
                        }

            
            {
                this$1 = Transaction.this;
                super();
            }
                    };
                }
                if ("TransactionPrice".equals(s1))
                {
                    s = itemTransaction;
                    s1 = new ItemCurrency();
                    s.transactionPrice = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("ConvertedTransactionPrice".equals(s1))
                {
                    s = itemTransaction;
                    s1 = new ItemCurrency();
                    s.convertedTransactionPrice = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("AmountPaid".equals(s1))
                {
                    s = itemTransaction;
                    s1 = new ItemCurrency();
                    s.amountPaid = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("ConvertedAmountPaid".equals(s1))
                {
                    s = itemTransaction;
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
                            itemTransaction.createdDate = EbayDateUtils.parseXml(s);
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
                            itemTransaction.orderLineItemId = s;
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
                            itemTransaction.multiLeg = flag;
                        }

            
            {
                this$1 = Transaction.this;
                super();
            }
                    };
                }
                if ("MultiLegShippingDetails".equals(s1))
                {
                    return new MultiLegShippingDetails(itemTransaction);
                }
                if ("ShippedTime".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Transaction this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            itemTransaction.shippedTime = EbayDateUtils.parseXml(s);
                        }

            
            {
                this$1 = Transaction.this;
                super();
            }
                    };
                }
                if ("PickupDetails".equals(s1))
                {
                    return new PickupDetails(itemTransaction);
                }
                if ("PickupMethodSelected".equals(s1))
                {
                    return new PickupMethodSelected(itemTransaction);
                }
                if ("PaymentHoldDetails".equals(s1))
                {
                    return new PaymentHoldDetails();
                }
                if ("MonetaryDetails".equals(s1))
                {
                    return new MonetaryDetails(itemTransaction);
                }
                if ("UnpaidItem".equals(s1))
                {
                    itemTransaction.unpaidItem = new com.ebay.common.model.ItemTransaction.UnpaidItem();
                    return new UnpaidItem();
                }
                if ("PaidTime".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Transaction this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            try
                            {
                                itemTransaction.paidTime = EbayDateUtils.parseIso8601DateTime(s);
                                return;
                            }
                            // Misplaced declaration of an exception variable
                            catch (String s)
                            {
                                throw new SAXException(s);
                            }
                        }

            
            {
                this$1 = Transaction.this;
                super();
            }
                    };
                }
                if ("BuyerCheckoutMessage".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Transaction this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            itemTransaction.buyerCheckoutMessage = s;
                        }

            
            {
                this$1 = Transaction.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public Transaction()
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
            itemTransaction = new ItemTransaction();
            itemTransactions.add(itemTransaction);
        }
    }

    private final class TransactionArray extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "Transaction".equals(s1))
            {
                return new Transaction();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private TransactionArray()
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
        }

    }

    private final class UnpaidItem extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Status".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final UnpaidItem this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        itemTransaction.unpaidItem.status = s;
                    }

            
            {
                this$1 = UnpaidItem.this;
                super();
            }
                };
            }
            if ("Type".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final UnpaidItem this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        itemTransaction.unpaidItem.type = s;
                    }

            
            {
                this$1 = UnpaidItem.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private UnpaidItem()
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
        }

    }

    private final class Variation extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;

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
                            itemTransaction.variation.sku = s;
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
                            itemTransaction.variation.variationTitle = s;
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
                            itemTransaction.variation.variationViewItemURL = s;
                        }

            
            {
                this$1 = Variation.this;
                super();
            }
                    };
                }
                if ("VariationSpecifics".equals(s1))
                {
                    return new VariationSpecifics();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private Variation()
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
        }

    }

    private final class VariationSpecifics extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetItemTransactionsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "NameValueList".equals(s1))
            {
                return new NameValueList();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private VariationSpecifics()
        {
            this$0 = GetItemTransactionsResponse.this;
            super();
        }

    }


    private ItemTransaction itemTransaction;
    private final ArrayList itemTransactions = new ArrayList();
    private final ArrayList paymentMethods = new ArrayList();
    private String sellerUserId;

    public GetItemTransactionsResponse()
    {
    }

    public ItemTransaction getItemTransaction()
    {
        return itemTransaction;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
        for (inputstream = itemTransactions.iterator(); inputstream.hasNext();)
        {
            ItemTransaction itemtransaction = (ItemTransaction)inputstream.next();
            itemtransaction.sellerUserId = sellerUserId;
            itemtransaction.paymentMethods = paymentMethods;
        }

    }



/*
    static String access$502(GetItemTransactionsResponse getitemtransactionsresponse, String s)
    {
        getitemtransactionsresponse.sellerUserId = s;
        return s;
    }

*/



/*
    static ItemTransaction access$602(GetItemTransactionsResponse getitemtransactionsresponse, ItemTransaction itemtransaction)
    {
        getitemtransactionsresponse.itemTransaction = itemtransaction;
        return itemtransaction;
    }

*/

}
