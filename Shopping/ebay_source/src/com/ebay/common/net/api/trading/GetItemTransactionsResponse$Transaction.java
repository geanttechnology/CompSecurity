// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.ItemTransaction;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.CurrencyElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.text.ParseException;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetItemTransactionsResponse

private final class this._cls0 extends com.ebay.nautilus.kernel.util.n
{

    final GetItemTransactionsResponse this$0;

    public com.ebay.nautilus.kernel.util.n get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Buyer".equals(s1))
            {
                return new (GetItemTransactionsResponse.this, null);
            }
            if ("Status".equals(s1))
            {
                return new >(GetItemTransactionsResponse.this, null);
            }
            if ("ShippingServiceSelected".equals(s1))
            {
                return new iceSelected(GetItemTransactionsResponse.this, null);
            }
            if ("ShippingDetails".equals(s1))
            {
                return new ils(GetItemTransactionsResponse.this, null);
            }
            if ("ContainingOrder".equals(s1))
            {
                return new der(GetItemTransactionsResponse.this, null);
            }
            if ("Variation".equals(s1))
            {
                return new nit>(GetItemTransactionsResponse.this, null);
            }
            if ("TransactionID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.Transaction this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).transactionId = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.Transaction.this;
                super();
            }
                };
            }
            if ("QuantityPurchased".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetItemTransactionsResponse.Transaction this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).quantityPurchased = i;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.Transaction.this;
                super();
            }
                };
            }
            if ("TransactionPrice".equals(s1))
            {
                s = GetItemTransactionsResponse.access$600(GetItemTransactionsResponse.this);
                s1 = new ItemCurrency();
                s.transactionPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("ConvertedTransactionPrice".equals(s1))
            {
                s = GetItemTransactionsResponse.access$600(GetItemTransactionsResponse.this);
                s1 = new ItemCurrency();
                s.convertedTransactionPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("AmountPaid".equals(s1))
            {
                s = GetItemTransactionsResponse.access$600(GetItemTransactionsResponse.this);
                s1 = new ItemCurrency();
                s.amountPaid = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("ConvertedAmountPaid".equals(s1))
            {
                s = GetItemTransactionsResponse.access$600(GetItemTransactionsResponse.this);
                s1 = new ItemCurrency();
                s.convertedAmountPaid = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("CreatedDate".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.Transaction this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).createdDate = EbayDateUtils.parseXml(s3);
                    }

            
            {
                this$1 = GetItemTransactionsResponse.Transaction.this;
                super();
            }
                };
            }
            if ("OrderLineItemID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.Transaction this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).orderLineItemId = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.Transaction.this;
                super();
            }
                };
            }
            if ("IsMultiLegShipping".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetItemTransactionsResponse.Transaction this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).multiLeg = flag;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.Transaction.this;
                super();
            }
                };
            }
            if ("MultiLegShippingDetails".equals(s1))
            {
                return new pingDetails(GetItemTransactionsResponse.this, GetItemTransactionsResponse.access$600(GetItemTransactionsResponse.this));
            }
            if ("ShippedTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.Transaction this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).shippedTime = EbayDateUtils.parseXml(s3);
                    }

            
            {
                this$1 = GetItemTransactionsResponse.Transaction.this;
                super();
            }
                };
            }
            if ("PickupDetails".equals(s1))
            {
                return new s(GetItemTransactionsResponse.this, GetItemTransactionsResponse.access$600(GetItemTransactionsResponse.this));
            }
            if ("PickupMethodSelected".equals(s1))
            {
                return new Selected(GetItemTransactionsResponse.this, GetItemTransactionsResponse.access$600(GetItemTransactionsResponse.this));
            }
            if ("PaymentHoldDetails".equals(s1))
            {
                return new etails(GetItemTransactionsResponse.this, null);
            }
            if ("MonetaryDetails".equals(s1))
            {
                return new ils(GetItemTransactionsResponse.this, GetItemTransactionsResponse.access$600(GetItemTransactionsResponse.this));
            }
            if ("UnpaidItem".equals(s1))
            {
                GetItemTransactionsResponse.access$600(GetItemTransactionsResponse.this).unpaidItem = new com.ebay.common.model.ansaction.this._cls0();
                return new init>(GetItemTransactionsResponse.this, null);
            }
            if ("PaidTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.Transaction this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        try
                        {
                            GetItemTransactionsResponse.access$600(this$0).paidTime = EbayDateUtils.parseIso8601DateTime(s3);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s3)
                        {
                            throw new SAXException(s3);
                        }
                    }

            
            {
                this$1 = GetItemTransactionsResponse.Transaction.this;
                super();
            }
                };
            }
            if ("BuyerCheckoutMessage".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.Transaction this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).buyerCheckoutMessage = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.Transaction.this;
                super();
            }
                };
            }
        }
        return super.n(s, s1, s2, attributes);
    }

    public _cls8.this._cls1()
    {
        this$0 = GetItemTransactionsResponse.this;
        super();
        GetItemTransactionsResponse.access$602(GetItemTransactionsResponse.this, new ItemTransaction());
        GetItemTransactionsResponse.access$700(GetItemTransactionsResponse.this).add(GetItemTransactionsResponse.access$600(GetItemTransactionsResponse.this));
    }
}
