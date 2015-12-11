// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.aps;

import com.ebay.common.model.RemindersList;
import com.ebay.common.util.EbayDateFormat;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.CurrencyElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.common.net.api.aps:
//            ApsGetReminders

private static final class <init> extends EbayResponse
{
    private final class BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ApsGetReminders.GetRemindersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("getRemindersResponse".equals(s1))
            {
                return new GetRemindersResponseElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private BodyElement()
        {
            this$0 = ApsGetReminders.GetRemindersResponse.this;
            super();
        }

        BodyElement(ApsGetReminders._cls1 _pcls1)
        {
            this();
        }
    }

    private final class GetRemindersResponseElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ApsGetReminders.GetRemindersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(ApsGetReminders.GetRemindersResponse.this);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(ApsGetReminders.GetRemindersResponse.this);
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(ApsGetReminders.GetRemindersResponse.this, "http://www.ebay.com/marketplace/mobileor/v1/services");
            }
            if ("buyingReminder".equals(s1) || "sellingReminder".equals(s1))
            {
                return new ReminderElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetRemindersResponseElement()
        {
            this$0 = ApsGetReminders.GetRemindersResponse.this;
            super();
        }

        GetRemindersResponseElement(ApsGetReminders._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ItemElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final MyEbayListItem item;
        final ApsGetReminders.GetRemindersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("itemID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final ItemElement this$1;

                    protected void setValue(long l)
                        throws SAXException
                    {
                        item.id = l;
                    }

            
            {
                this$1 = ItemElement.this;
                super();
            }
                };
            }
            if ("title".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ItemElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.title = s;
                    }

            
            {
                this$1 = ItemElement.this;
                super();
            }
                };
            }
            if ("galleryURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ItemElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.imageUrl = s;
                    }

            
            {
                this$1 = ItemElement.this;
                super();
            }
                };
            }
            if ("listingType".equals(s1))
            {
                return new ListingType(item);
            }
            if ("convertedCurrentPrice".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.convertedCurrentPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("currentPrice".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.currentPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("shippingServiceCost".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.shippingCost = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("bestOfferPrice".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.bestOfferAmount = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("timeLeft".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ItemElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        if (item.endDate != null)
                        {
                            return;
                        } else
                        {
                            item.endDate = new Date(EbayResponse.currentHostTime() + EbayDateFormat.millisFromISO8601Duration(s));
                            return;
                        }
                    }

            
            {
                this$1 = ItemElement.this;
                super();
            }
                };
            }
            if ("endTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ItemElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        try
                        {
                            item.endDate = EbayDateFormat.parse(s);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s)
                        {
                            throw new SAXNotRecognizedException(s.getLocalizedMessage());
                        }
                    }

            
            {
                this$1 = ItemElement.this;
                super();
            }
                };
            }
            if ("transactionCreatedDate".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ItemElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        try
                        {
                            item.transaction.createdDate = EbayDateFormat.parse(s);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s)
                        {
                            throw new SAXNotRecognizedException(s.getLocalizedMessage());
                        }
                    }

            
            {
                this$1 = ItemElement.this;
                super();
            }
                };
            }
            if ("transactionID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ItemElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.transaction.transactionId = s;
                    }

            
            {
                this$1 = ItemElement.this;
                super();
            }
                };
            }
            if ("paidStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ItemElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.transaction.paidStatus = s;
                    }

            
            {
                this$1 = ItemElement.this;
                super();
            }
                };
            }
            if ("feedbackLeft".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final ItemElement this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        item.transaction.feedbackLeft = flag;
                    }

            
            {
                this$1 = ItemElement.this;
                super();
            }
                };
            }
            if ("quantityPurchased".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final ItemElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        item.transaction.quantityPurchased = i;
                    }

            
            {
                this$1 = ItemElement.this;
                super();
            }
                };
            }
            if ("totalTransactionPrice".equals(s1))
            {
                s = item.transaction;
                s1 = new ItemCurrency();
                s.totalTransactionPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("shippedTime".equals(s1))
            {
                item.transaction.shipped = true;
                return super.get(s, s1, s2, attributes);
            }
            if ("bidCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final ItemElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        item.bidCount = i;
                    }

            
            {
                this$1 = ItemElement.this;
                super();
            }
                };
            }
            if ("watchCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final ItemElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        item.watchCount = i;
                    }

            
            {
                this$1 = ItemElement.this;
                super();
            }
                };
            }
            if ("reserveMet".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final ItemElement this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        item.reserveMet = flag;
                    }

            
            {
                this$1 = ItemElement.this;
                super();
            }
                };
            }
            if ("buyerUserID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ItemElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.highBidderId = s;
                    }

            
            {
                this$1 = ItemElement.this;
                super();
            }
                };
            }
            if ("Variations".equals(s1))
            {
                return new Variations(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public ItemElement(MyEbayListItem myebaylistitem)
        {
            this$0 = ApsGetReminders.GetRemindersResponse.this;
            super();
            item = myebaylistitem;
        }
    }

    final class ItemElement.ListingType extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        private final MyEbayListItem item;
        final ItemElement this$1;

        public void text(String s)
            throws SAXException
        {
            item.listingType = 0;
            s.length();
            JVM INSTR tableswitch 7 16: default 68
        //                       7 69
        //                       8 87
        //                       9 68
        //                       10 105
        //                       11 68
        //                       12 68
        //                       13 68
        //                       14 141
        //                       15 68
        //                       16 196;
               goto _L1 _L2 _L3 _L1 _L4 _L1 _L1 _L1 _L5 _L1 _L6
_L1:
            return;
_L2:
            if (s.equals("Chinese"))
            {
                item.listingType = 2;
                return;
            }
            continue; /* Loop/switch isn't completed */
_L3:
            if (s.equals("AdFormat"))
            {
                item.listingType = 1;
                return;
            }
            if (true) goto _L1; else goto _L4
_L4:
            if (s.equals("Classified"))
            {
                item.listingType = 4;
                return;
            }
            if (s.equals("FixedPrice"))
            {
                item.listingType = 5;
                return;
            }
            if (true)
            {
                continue; /* Loop/switch isn't completed */
            }
_L5:
            if (s.equals("AuctionWithBIN"))
            {
                item.listingType = 3;
                return;
            }
            if (s.equals("FixedPriceItem"))
            {
                item.listingType = 5;
                return;
            }
            if (s.equals("StoreInventory"))
            {
                item.listingType = 6;
                return;
            }
            continue; /* Loop/switch isn't completed */
_L6:
            if (s.equals("StoresFixedPrice"))
            {
                item.listingType = 5;
                return;
            }
            if (true) goto _L1; else goto _L7
_L7:
        }

        public ItemElement.ListingType(MyEbayListItem myebaylistitem)
        {
            this$1 = ItemElement.this;
            super();
            item = myebaylistitem;
        }
    }

    private final class ItemElement.NameValueList extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ItemElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            NameValue namevalue = (NameValue)item.nameValueList.get(item.nameValueList.size() - 1);
            if ("Name".equals(s1))
            {
                return namevalue. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ItemElement.NameValueList this$2;
                    final NameValue val$nameValue;

                    public void text(String s)
                        throws SAXException
                    {
                        nameValue.setName(s);
                    }

            
            {
                this$2 = final_namevaluelist;
                nameValue = NameValue.this;
                super();
            }
                };
            }
            if ("Value".equals(s1))
            {
                return namevalue. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ItemElement.NameValueList this$2;
                    final NameValue val$nameValue;

                    public void text(String s)
                        throws SAXException
                    {
                        nameValue.addValue(s);
                    }

            
            {
                this$2 = final_namevaluelist;
                nameValue = NameValue.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public ItemElement.NameValueList()
        {
            this$1 = ItemElement.this;
            super();
            if (item.nameValueList == null)
            {
                item.nameValueList = new ArrayList();
            }
            item.nameValueList.add(new NameValue());
        }
    }

    private final class ItemElement.Variation extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ItemElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("VariationSpecifics".equals(s1))
            {
                return new ItemElement.VariationSpecifics(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ItemElement.Variation()
        {
            this$1 = ItemElement.this;
            super();
        }

        ItemElement.Variation(ApsGetReminders._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ItemElement.VariationSpecifics extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ItemElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("NameValueList".equals(s1))
            {
                return new ItemElement.NameValueList();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ItemElement.VariationSpecifics()
        {
            this$1 = ItemElement.this;
            super();
        }

        ItemElement.VariationSpecifics(ApsGetReminders._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ItemElement.Variations extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ItemElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Variation".equals(s1))
            {
                return new ItemElement.Variation(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ItemElement.Variations()
        {
            this$1 = ItemElement.this;
            super();
        }

        ItemElement.Variations(ApsGetReminders._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ReminderElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ApsGetReminders.GetRemindersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("paymentToSend".equals(s1) || "watchEndingSoon".equals(s1) || "feedbackToSend".equals(s1) || "outbid".equals(s1) || "bidEndingSoon".equals(s1) || "paymentToReceive".equals(s1) || "bestOffer".equals(s1) || "shippingNeeded".equals(s1) || "sellEndingSoon".equals(s1) || "secondChanceOffer".equals(s1) || "pickupReady".equals(s1))
            {
                listResult.count = Integer.valueOf(attributes.getValue("count")).intValue();
                listResult.nextPageLocator = attributes.getValue("nextPageLocator");
                s = listResult;
                boolean flag;
                if (attributes.getValue("hasMore") != null && attributes.getValue("hasMore").equals("true"))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                s.hasMore = flag;
                return new ReminderTypeElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ReminderElement()
        {
            this$0 = ApsGetReminders.GetRemindersResponse.this;
            super();
        }

        ReminderElement(ApsGetReminders._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ReminderTypeElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ApsGetReminders.GetRemindersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("item".equals(s1))
            {
                s = new MyEbayListItem();
                s.transaction = new com.ebay.nautilus.domain.data.MyEbayListItem.Transaction();
                items.add(s);
                return new ItemElement(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ReminderTypeElement()
        {
            this$0 = ApsGetReminders.GetRemindersResponse.this;
            super();
        }

        ReminderTypeElement(ApsGetReminders._cls1 _pcls1)
        {
            this();
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ApsGetReminders.GetRemindersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://schemas.xmlsoap.org/soap/envelope/".equals(s) && "Body".equals(s1))
            {
                return new BodyElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement()
        {
            this$0 = ApsGetReminders.GetRemindersResponse.this;
            super();
        }

        RootElement(ApsGetReminders._cls1 _pcls1)
        {
            this();
        }
    }


    private final List items;
    private final RemindersList listResult;

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.odyElement
    {
        SaxHandler.parseXml(inputstream, new RootElement(null));
    }



    private RootElement()
    {
        listResult = new RemindersList();
        items = listResult.list;
    }

    listResult(listResult listresult)
    {
        this();
    }
}
