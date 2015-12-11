// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.aps;

import com.ebay.common.util.EbayDateFormat;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.net.CurrencyElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.common.net.api.aps:
//            ApsGetReminders

private final class item extends com.ebay.nautilus.kernel.util.em
{
    final class ListingType extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        private final MyEbayListItem item;
        final ApsGetReminders.GetRemindersResponse.ItemElement this$1;

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

        public ListingType(MyEbayListItem myebaylistitem)
        {
            this$1 = ApsGetReminders.GetRemindersResponse.ItemElement.this;
            super();
            item = myebaylistitem;
        }
    }

    private final class NameValueList extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ApsGetReminders.GetRemindersResponse.ItemElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            NameValue namevalue = (NameValue)item.nameValueList.get(item.nameValueList.size() - 1);
            if ("Name".equals(s1))
            {
                return namevalue. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final NameValueList this$2;
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

                    final NameValueList this$2;
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

        public NameValueList()
        {
            this$1 = ApsGetReminders.GetRemindersResponse.ItemElement.this;
            super();
            if (item.nameValueList == null)
            {
                item.nameValueList = new ArrayList();
            }
            item.nameValueList.add(new NameValue());
        }
    }

    private final class Variation extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ApsGetReminders.GetRemindersResponse.ItemElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("VariationSpecifics".equals(s1))
            {
                return new VariationSpecifics(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private Variation()
        {
            this$1 = ApsGetReminders.GetRemindersResponse.ItemElement.this;
            super();
        }

        Variation(ApsGetReminders._cls1 _pcls1)
        {
            this();
        }
    }

    private final class VariationSpecifics extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ApsGetReminders.GetRemindersResponse.ItemElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("NameValueList".equals(s1))
            {
                return new NameValueList();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private VariationSpecifics()
        {
            this$1 = ApsGetReminders.GetRemindersResponse.ItemElement.this;
            super();
        }

        VariationSpecifics(ApsGetReminders._cls1 _pcls1)
        {
            this();
        }
    }

    private final class Variations extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ApsGetReminders.GetRemindersResponse.ItemElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Variation".equals(s1))
            {
                return new Variation(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private Variations()
        {
            this$1 = ApsGetReminders.GetRemindersResponse.ItemElement.this;
            super();
        }

        Variations(ApsGetReminders._cls1 _pcls1)
        {
            this();
        }
    }


    private final MyEbayListItem item;
    final Variations this$0;

    public com.ebay.nautilus.kernel.util.riation get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("itemID".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                final ApsGetReminders.GetRemindersResponse.ItemElement this$1;

                protected void setValue(long l)
                    throws SAXException
                {
                    item.id = l;
                }

            
            {
                this$1 = ApsGetReminders.GetRemindersResponse.ItemElement.this;
                super();
            }
            };
        }
        if ("title".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final ApsGetReminders.GetRemindersResponse.ItemElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    item.title = s3;
                }

            
            {
                this$1 = ApsGetReminders.GetRemindersResponse.ItemElement.this;
                super();
            }
            };
        }
        if ("galleryURL".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final ApsGetReminders.GetRemindersResponse.ItemElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    item.imageUrl = s3;
                }

            
            {
                this$1 = ApsGetReminders.GetRemindersResponse.ItemElement.this;
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

                final ApsGetReminders.GetRemindersResponse.ItemElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    if (item.endDate != null)
                    {
                        return;
                    } else
                    {
                        item.endDate = new Date(EbayResponse.currentHostTime() + EbayDateFormat.millisFromISO8601Duration(s3));
                        return;
                    }
                }

            
            {
                this$1 = ApsGetReminders.GetRemindersResponse.ItemElement.this;
                super();
            }
            };
        }
        if ("endTime".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final ApsGetReminders.GetRemindersResponse.ItemElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    try
                    {
                        item.endDate = EbayDateFormat.parse(s3);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s3)
                    {
                        throw new SAXNotRecognizedException(s3.getLocalizedMessage());
                    }
                }

            
            {
                this$1 = ApsGetReminders.GetRemindersResponse.ItemElement.this;
                super();
            }
            };
        }
        if ("transactionCreatedDate".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final ApsGetReminders.GetRemindersResponse.ItemElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    try
                    {
                        item.transaction.createdDate = EbayDateFormat.parse(s3);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s3)
                    {
                        throw new SAXNotRecognizedException(s3.getLocalizedMessage());
                    }
                }

            
            {
                this$1 = ApsGetReminders.GetRemindersResponse.ItemElement.this;
                super();
            }
            };
        }
        if ("transactionID".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final ApsGetReminders.GetRemindersResponse.ItemElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    item.transaction.transactionId = s3;
                }

            
            {
                this$1 = ApsGetReminders.GetRemindersResponse.ItemElement.this;
                super();
            }
            };
        }
        if ("paidStatus".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final ApsGetReminders.GetRemindersResponse.ItemElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    item.transaction.paidStatus = s3;
                }

            
            {
                this$1 = ApsGetReminders.GetRemindersResponse.ItemElement.this;
                super();
            }
            };
        }
        if ("feedbackLeft".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                final ApsGetReminders.GetRemindersResponse.ItemElement this$1;

                public void setValue(boolean flag)
                    throws SAXException
                {
                    item.transaction.feedbackLeft = flag;
                }

            
            {
                this$1 = ApsGetReminders.GetRemindersResponse.ItemElement.this;
                super();
            }
            };
        }
        if ("quantityPurchased".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final ApsGetReminders.GetRemindersResponse.ItemElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    item.transaction.quantityPurchased = i;
                }

            
            {
                this$1 = ApsGetReminders.GetRemindersResponse.ItemElement.this;
                super();
            }
            };
        }
        if ("totalTransactionPrice".equals(s1))
        {
            s = item.transaction;
            s1 = new ItemCurrency();
            s.em = s1;
            return new CurrencyElement(s1, "currencyID", attributes);
        }
        if ("shippedTime".equals(s1))
        {
            item.transaction.em = true;
            return super.em(s, s1, s2, attributes);
        }
        if ("bidCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final ApsGetReminders.GetRemindersResponse.ItemElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    item.bidCount = i;
                }

            
            {
                this$1 = ApsGetReminders.GetRemindersResponse.ItemElement.this;
                super();
            }
            };
        }
        if ("watchCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final ApsGetReminders.GetRemindersResponse.ItemElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    item.watchCount = i;
                }

            
            {
                this$1 = ApsGetReminders.GetRemindersResponse.ItemElement.this;
                super();
            }
            };
        }
        if ("reserveMet".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                final ApsGetReminders.GetRemindersResponse.ItemElement this$1;

                public void setValue(boolean flag)
                    throws SAXException
                {
                    item.reserveMet = flag;
                }

            
            {
                this$1 = ApsGetReminders.GetRemindersResponse.ItemElement.this;
                super();
            }
            };
        }
        if ("buyerUserID".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final ApsGetReminders.GetRemindersResponse.ItemElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    item.highBidderId = s3;
                }

            
            {
                this$1 = ApsGetReminders.GetRemindersResponse.ItemElement.this;
                super();
            }
            };
        }
        if ("Variations".equals(s1))
        {
            return new Variations(null);
        } else
        {
            return super.riations(s, s1, s2, attributes);
        }
    }


    public _cls9.this._cls1(MyEbayListItem myebaylistitem)
    {
        this$0 = this._cls0.this;
        super();
        item = myebaylistitem;
    }
}
