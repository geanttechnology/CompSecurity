// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.net.CurrencyElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.util.ArrayList;
import java.util.Date;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayResponse

private static final class timestamp extends com.ebay.nautilus.kernel.util.istElement
{
    private static final class ItemArray extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final ArrayList items;
        private final Date timestamp;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Item".equals(s1))
            {
                s = new MyEbayListItem();
                items.add(s);
                return new GetMyEbayResponse.RootElement.Item(s, timestamp);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public ItemArray(ArrayList arraylist, Date date)
        {
            items = arraylist;
            timestamp = date;
        }
    }

    private static final class OrderTransactionArray extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        protected final ArrayList items;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("OrderTransaction".equals(s1))
            {
                return new OrderTransaction(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public OrderTransactionArray(ArrayList arraylist)
        {
            items = arraylist;
        }
    }

    final class OrderTransactionArray.Order extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        public String orderId;
        final OrderTransactionArray this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            Object obj;
            if ("OrderID".equals(s1))
            {
                obj = new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final OrderTransactionArray.Order this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        orderId = s;
                    }

            
            {
                this$1 = OrderTransactionArray.Order.this;
                super();
            }
                };
            } else
            {
                obj = this;
                if (!"TransactionArray".equals(s1))
                {
                    if ("Transaction".equals(s1))
                    {
                        s = new MyEbayListItem();
                        items.add(s);
                        s.orderId = orderId;
                        return new OrderTransactionArray.Transaction(s, orderId);
                    } else
                    {
                        return super.get(s, s1, s2, attributes);
                    }
                }
            }
            return ((com.ebay.nautilus.kernel.util.SaxHandler.Element) (obj));
        }

        OrderTransactionArray.Order()
        {
            this$0 = OrderTransactionArray.this;
            super();
            orderId = null;
        }
    }

    private final class OrderTransactionArray.OrderTransaction extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final OrderTransactionArray this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Order".equals(s1))
            {
                return new OrderTransactionArray.Order();
            }
            if ("Transaction".equals(s1))
            {
                s = new MyEbayListItem();
                items.add(s);
                return new OrderTransactionArray.Transaction(s, null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private OrderTransactionArray.OrderTransaction()
        {
            this$0 = OrderTransactionArray.this;
            super();
        }

        OrderTransactionArray.OrderTransaction(GetMyEbayResponse._cls1 _pcls1)
        {
            this();
        }
    }

    static final class OrderTransactionArray.Transaction extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        protected final MyEbayListItem item;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("CreatedDate".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final OrderTransactionArray.Transaction this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        item.transaction.createdDate = EbayDateUtils.parseXml(s);
                    }

            
            {
                this$0 = OrderTransactionArray.Transaction.this;
                super();
            }
                };
            }
            if ("TotalTransactionPrice".equals(s1))
            {
                s = item.transaction;
                s1 = new ItemCurrency();
                s.totalTransactionPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("BuyerPaidStatus".equals(s1) || "SellerPaidStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final OrderTransactionArray.Transaction this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        item.transaction.paidStatus = s;
                    }

            
            {
                this$0 = OrderTransactionArray.Transaction.this;
                super();
            }
                };
            }
            if (!"FeedbackLeft".equals(s1)) goto _L2; else goto _L1
_L1:
            item.transaction.feedbackLeft = true;
_L4:
            return super.get(s, s1, s2, attributes);
_L2:
            if ("FeedbackReceived".equals(s1))
            {
                item.transaction.feedbackReceived = true;
                continue; /* Loop/switch isn't completed */
            }
            if ("QuantityPurchased".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final OrderTransactionArray.Transaction this$0;

                    public void setValue(int i)
                        throws SAXException
                    {
                        item.transaction.quantityPurchased = i;
                    }

            
            {
                this$0 = OrderTransactionArray.Transaction.this;
                super();
            }
                };
            }
            if ("TransactionID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final OrderTransactionArray.Transaction this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        item.transaction.transactionId = s;
                    }

            
            {
                this$0 = OrderTransactionArray.Transaction.this;
                super();
            }
                };
            }
            if (!"ShippedTime".equals(s1))
            {
                break; /* Loop/switch isn't completed */
            }
            item.transaction.shipped = true;
            if (true) goto _L4; else goto _L3
_L3:
            if ("Item".equals(s1))
            {
                return new GetMyEbayResponse.RootElement.Item(item, null);
            }
            if ("Buyer".equals(s1))
            {
                return new GetMyEbayResponse.RootElement.Buyer(item);
            }
            if ("OrderLineItemID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final OrderTransactionArray.Transaction this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        item.transaction.orderId = s;
                    }

            
            {
                this$0 = OrderTransactionArray.Transaction.this;
                super();
            }
                };
            }
            if ("PaidTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final OrderTransactionArray.Transaction this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        item.transaction.paidTime = s;
                    }

            
            {
                this$0 = OrderTransactionArray.Transaction.this;
                super();
            }
                };
            }
            if ("PickupMethodSelected".equals(s1))
            {
                return new GetMyEbayResponse.RootElement.PickupMethodSelected(item.transaction);
            }
            if (true) goto _L4; else goto _L5
_L5:
        }

        public OrderTransactionArray.Transaction(MyEbayListItem myebaylistitem, String s)
        {
            item = myebaylistitem;
            myebaylistitem.transaction = new com.ebay.nautilus.domain.data.MyEbayListItem.Transaction();
            myebaylistitem.transaction.orderId = s;
        }
    }

    private final class PaginationResultElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMyEbayResponse.RootElement.ListElement this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("TotalNumberOfEntries".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final PaginationResultElement this$1;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        response.totalEntries = i;
                    }

            
            {
                this$1 = PaginationResultElement.this;
                super();
            }
                };
            }
            if ("TotalNumberOfPages".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final PaginationResultElement this$1;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        response.totalPages = i;
                    }

            
            {
                this$1 = PaginationResultElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private PaginationResultElement()
        {
            this$0 = GetMyEbayResponse.RootElement.ListElement.this;
            super();
        }

        PaginationResultElement(GetMyEbayResponse._cls1 _pcls1)
        {