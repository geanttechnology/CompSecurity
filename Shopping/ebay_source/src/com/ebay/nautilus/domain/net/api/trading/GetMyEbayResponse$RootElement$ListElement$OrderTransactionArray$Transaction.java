// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.net.CurrencyElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayResponse

static final class item extends com.ebay.nautilus.kernel.util.ransaction
{

    protected final MyEbayListItem item;

    public com.ebay.nautilus.kernel.util.ransaction get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("CreatedDate".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetMyEbayResponse.RootElement.ListElement.OrderTransactionArray.Transaction this$0;

                public void text(String s3)
                    throws SAXException
                {
                    item.transaction.createdDate = EbayDateUtils.parseXml(s3);
                }

            
            {
                this$0 = GetMyEbayResponse.RootElement.ListElement.OrderTransactionArray.Transaction.this;
                super();
            }
            };
        }
        if ("TotalTransactionPrice".equals(s1))
        {
            s = item.transaction;
            s1 = new ItemCurrency();
            s.item = s1;
            return new CurrencyElement(s1, "currencyID", attributes);
        }
        if ("BuyerPaidStatus".equals(s1) || "SellerPaidStatus".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetMyEbayResponse.RootElement.ListElement.OrderTransactionArray.Transaction this$0;

                public void text(String s3)
                    throws SAXException
                {
                    item.transaction.paidStatus = s3;
                }

            
            {
                this$0 = GetMyEbayResponse.RootElement.ListElement.OrderTransactionArray.Transaction.this;
                super();
            }
            };
        }
        if (!"FeedbackLeft".equals(s1)) goto _L2; else goto _L1
_L1:
        item.transaction.item = true;
_L4:
        return super.item(s, s1, s2, attributes);
_L2:
        if ("FeedbackReceived".equals(s1))
        {
            item.transaction.item = true;
            continue; /* Loop/switch isn't completed */
        }
        if ("QuantityPurchased".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetMyEbayResponse.RootElement.ListElement.OrderTransactionArray.Transaction this$0;

                public void setValue(int i)
                    throws SAXException
                {
                    item.transaction.quantityPurchased = i;
                }

            
            {
                this$0 = GetMyEbayResponse.RootElement.ListElement.OrderTransactionArray.Transaction.this;
                super();
            }
            };
        }
        if ("TransactionID".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetMyEbayResponse.RootElement.ListElement.OrderTransactionArray.Transaction this$0;

                public void text(String s3)
                    throws SAXException
                {
                    item.transaction.transactionId = s3;
                }

            
            {
                this$0 = GetMyEbayResponse.RootElement.ListElement.OrderTransactionArray.Transaction.this;
                super();
            }
            };
        }
        if (!"ShippedTime".equals(s1))
        {
            break; /* Loop/switch isn't completed */
        }
        item.transaction.item = true;
        if (true) goto _L4; else goto _L3
_L3:
        if ("Item".equals(s1))
        {
            return new item(item, null);
        }
        if ("Buyer".equals(s1))
        {
            return new item(item);
        }
        if ("OrderLineItemID".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetMyEbayResponse.RootElement.ListElement.OrderTransactionArray.Transaction this$0;

                public void text(String s3)
                    throws SAXException
                {
                    item.transaction.orderId = s3;
                }

            
            {
                this$0 = GetMyEbayResponse.RootElement.ListElement.OrderTransactionArray.Transaction.this;
                super();
            }
            };
        }
        if ("PaidTime".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetMyEbayResponse.RootElement.ListElement.OrderTransactionArray.Transaction this$0;

                public void text(String s3)
                    throws SAXException
                {
                    item.transaction.paidTime = s3;
                }

            
            {
                this$0 = GetMyEbayResponse.RootElement.ListElement.OrderTransactionArray.Transaction.this;
                super();
            }
            };
        }
        if ("PickupMethodSelected".equals(s1))
        {
            return new item(item.transaction);
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public _cls6.this._cls0(MyEbayListItem myebaylistitem, String s)
    {
        item = myebaylistitem;
        myebaylistitem.transaction = new com.ebay.nautilus.domain.data.ransaction.item();
        myebaylistitem.transaction.item = s;
    }
}
