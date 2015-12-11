// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.deals;

import com.ebay.common.model.EbayDeals;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.CurrencyElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

public final class EbayDealsApi
{
    public static class DealsRequest extends Request
    {

        private final URL url;

        public URL getRequestUrl()
        {
            return url;
        }

        public DealsResponse getResponse()
        {
            return new DealsResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public String getUserAgent()
        {
            return EbayAppCredentials.get(getEbayContext()).userAgent;
        }

        public DealsRequest(EbaySite ebaysite, int i, int j)
        {
            Object obj = null;
            try
            {
                ebaysite = new URL(String.format(ApiSettings.get(EbaySettings.dealsApiUrlFormat), new Object[] {
                    Integer.valueOf(ebaysite.idInt), Integer.valueOf(i), Integer.valueOf(j)
                }));
            }
            // Misplaced declaration of an exception variable
            catch (EbaySite ebaysite)
            {
                ebaysite.printStackTrace();
                ebaysite = obj;
            }
            // Misplaced declaration of an exception variable
            catch (EbaySite ebaysite)
            {
                ebaysite.printStackTrace();
                ebaysite = obj;
            }
            // Misplaced declaration of an exception variable
            catch (EbaySite ebaysite)
            {
                ebaysite.printStackTrace();
                ebaysite = obj;
            }
            url = ebaysite;
        }
    }

    public static class DealsResponse extends EbayResponse
    {

        private final EbayDeals data = new EbayDeals();
        com.ebay.nautilus.kernel.util.SaxHandler.Element root;

        public final EbayDeals getData()
        {
            if (isSuccessful())
            {
                return data;
            } else
            {
                return null;
            }
        }

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            if (inputstream == null)
            {
                throw new NullPointerException("inputStream");
            } else
            {
                SaxHandler.parseXml(inputstream, root);
                return;
            }
        }


        public DealsResponse()
        {
            root = new _cls1();
        }
    }

    static final class DealsResponse.ItemElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        com.ebay.nautilus.kernel.util.SaxHandler.Element detailsElement;
        com.ebay.common.model.EbayDeals.Item item;
        com.ebay.nautilus.kernel.util.SaxHandler.Element metadataElement;

        DealsResponse.ItemElement get(List list, Attributes attributes)
        {
            item = new com.ebay.common.model.EbayDeals.Item();
            int j = attributes.getLength();
            for (int i = 0; i < j; i++)
            {
                if ("ItemID".equals(attributes.getLocalName(i)))
                {
                    item.id = Long.parseLong(attributes.getValue(i));
                }
            }

            list.add(item);
            return this;
        }

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ItemDetails".equals(s1))
            {
                return detailsElement;
            }
            if ("ItemMetaData".equals(s1))
            {
                return metadataElement;
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        DealsResponse.ItemElement()
        {
            item = null;
            detailsElement = new _cls1();
            metadataElement = new _cls2();
        }
    }

    static final class DealsResponse.MultiSkuElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        com.ebay.nautilus.kernel.util.SaxHandler.TextElement imageUrlElement;
        com.ebay.common.model.EbayDeals.MultiSkuItem item;
        private final DealsResponse.ItemElement itemElement;
        com.ebay.nautilus.kernel.util.SaxHandler.TextElement titleElement;

        DealsResponse.MultiSkuElement get(List list)
        {
            item = new com.ebay.common.model.EbayDeals.MultiSkuItem();
            item.id = -1L;
            list.add(item);
            return this;
        }

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Title".equals(s1))
            {
                return titleElement;
            }
            if ("StaticImage140x140".equals(s1))
            {
                return imageUrlElement;
            }
            if ("Item".equals(s1))
            {
                if (item.items == null)
                {
                    item.items = new ArrayList();
                }
                return itemElement.get(item.items, attributes);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public DealsResponse.MultiSkuElement(DealsResponse.ItemElement itemelement)
        {
            item = null;
            titleElement = new _cls1();
            imageUrlElement = new _cls2();
            itemElement = itemelement;
        }
    }


    public static final int FEED_TYPE_CSA = 1;
    public static final int FEED_TYPE_DEALS = 0;
    public static final int LEVEL_ALL_DAILY_DEALS = 2;
    public static final int LEVEL_ALL_DAILY_DEALS_PLUS_HERO_ITEMS = 3;
    public static final int LEVEL_All = 0;
    public static final int LEVEL_ONE_DAILY_DEAL = 1;
    public static final int LEVEL_OPTIMIZED_FOR_MOBILE = 4;

    public EbayDealsApi()
    {
    }

    public static final EbayDeals parseDeals(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        DealsResponse dealsresponse = new DealsResponse();
        dealsresponse.parse(inputstream);
        return dealsresponse.getData();
    }

    // Unreferenced inner class com/ebay/common/net/deals/EbayDealsApi$DealsResponse$1

/* anonymous class */
    class DealsResponse._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        com.ebay.nautilus.kernel.util.SaxHandler.Element initiativeElement;
        final DealsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Ack".equals(s1))
            {
                return new AckElement(DealsResponse.this);
            }
            if ("Initiative".equals(s1))
            {
                return initiativeElement;
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

            
            {
                this$0 = DealsResponse.this;
                super();
                initiativeElement = new _cls1();
            }
    }


    // Unreferenced inner class com/ebay/common/net/deals/EbayDealsApi$DealsResponse$1$1

/* anonymous class */
    class DealsResponse._cls1._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        com.ebay.common.model.EbayDeals.Section section;
        com.ebay.nautilus.kernel.util.SaxHandler.Element sectionElement;
        final DealsResponse._cls1 this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("InitiativeSection".equals(s1))
            {
                section = new com.ebay.common.model.EbayDeals.Section();
    class DealsResponse._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        com.ebay.nautilus.kernel.util.SaxHandler.Element initiativeElement;
        final DealsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Ack".equals(s1))
            {
                return new AckElement(DealsResponse.this);
            }
            if ("Initiative".equals(s1))
            {
                return initiativeElement;
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

            
            {
                this$0 = DealsResponse.this;
                super();
                initiativeElement = new _cls1();
            }
    }

                data.add(section);
                int j = attributes.getLength();
                int i = 0;
                while (i < j) 
                {
                    if ("SectionID".equals(attributes.getLocalName(i)))
                    {
                        section.id = Integer.parseInt(attributes.getValue(i));
                    } else
                    if ("DisplayTitle".equals(attributes.getLocalName(i)))
                    {
                        section.title = attributes.getValue(i);
                    } else
                    if ("Description".equals(attributes.getLocalName(i)))
                    {
                        section.description = attributes.getValue(i);
                    }
                    i++;
                }
                return sectionElement;
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

            
            {
                this$1 = DealsResponse._cls1.this;
                super();
                section = null;
                sectionElement = new _cls1();
            }
    }


    // Unreferenced inner class com/ebay/common/net/deals/EbayDealsApi$DealsResponse$1$1$1

/* anonymous class */
    class DealsResponse._cls1._cls1._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        com.ebay.common.model.EbayDeals.SubSection subSection;
        com.ebay.nautilus.kernel.util.SaxHandler.Element subSectionElement;
        final DealsResponse._cls1._cls1 this$2;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Items".equals(s1))
            {
                subSection = new com.ebay.common.model.EbayDeals.SubSection();
    class DealsResponse._cls1._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        com.ebay.common.model.EbayDeals.Section section;
        com.ebay.nautilus.kernel.util.SaxHandler.Element sectionElement;
        final DealsResponse._cls1 this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("InitiativeSection".equals(s1))
            {
                section = new com.ebay.common.model.EbayDeals.Section();
    class DealsResponse._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        com.ebay.nautilus.kernel.util.SaxHandler.Element initiativeElement;
        final DealsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Ack".equals(s1))
            {
                return new AckElement(DealsResponse.this);
            }
            if ("Initiative".equals(s1))
            {
                return initiativeElement;
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

            
            {
                this$0 = DealsResponse.this;
                super();
                initiativeElement = new _cls1();
            }
    }

                data.add(section);
                int j = attributes.getLength();
                int i = 0;
                while (i < j) 
                {
                    if ("SectionID".equals(attributes.getLocalName(i)))
                    {
                        section.id = Integer.parseInt(attributes.getValue(i));
                    } else
                    if ("DisplayTitle".equals(attributes.getLocalName(i)))
                    {
                        section.title = attributes.getValue(i);
                    } else
                    if ("Description".equals(attributes.getLocalName(i)))
                    {
                        section.description = attributes.getValue(i);
                    }
                    i++;
                }
                return sectionElement;
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

            
            {
                this$1 = DealsResponse._cls1.this;
                super();
                section = null;
                sectionElement = new _cls1();
            }
    }

                section.add(subSection);
                int j = attributes.getLength();
                for (int i = 0; i < j; i++)
                {
                    if ("SubTitle".equals(attributes.getLocalName(i)))
                    {
                        subSection.title = attributes.getValue(i);
                    }
                }

                return subSectionElement;
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

            
            {
                this$2 = DealsResponse._cls1._cls1.this;
                super();
                subSection = null;
                subSectionElement = new _cls1();
            }
    }


    // Unreferenced inner class com/ebay/common/net/deals/EbayDealsApi$DealsResponse$1$1$1$1

/* anonymous class */
    class DealsResponse._cls1._cls1._cls1._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        DealsResponse.ItemElement itemElement;
        DealsResponse.MultiSkuElement multiSkuElement;
        final DealsResponse._cls1._cls1._cls1 this$3;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
    class DealsResponse._cls1._cls1._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        com.ebay.common.model.EbayDeals.SubSection subSection;
        com.ebay.nautilus.kernel.util.SaxHandler.Element subSectionElement;
        final DealsResponse._cls1._cls1 this$2;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Items".equals(s1))
            {
                subSection = new com.ebay.common.model.EbayDeals.SubSection();
    class DealsResponse._cls1._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        com.ebay.common.model.EbayDeals.Section section;
        com.ebay.nautilus.kernel.util.SaxHandler.Element sectionElement;
        final DealsResponse._cls1 this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("InitiativeSection".equals(s1))
            {
                section = new com.ebay.common.model.EbayDeals.Section();
    class DealsResponse._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        com.ebay.nautilus.kernel.util.SaxHandler.Element initiativeElement;
        final DealsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Ack".equals(s1))
            {
                return new AckElement(DealsResponse.this);
            }
            if ("Initiative".equals(s1))
            {
                return initiativeElement;
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

            
            {
                this$0 = DealsResponse.this;
                super();
                initiativeElement = new _cls1();
            }
    }

                data.add(section);
                int j = attributes.getLength();
                int i = 0;
                while (i < j) 
                {
                    if ("SectionID".equals(attributes.getLocalName(i)))
                    {
                        section.id = Integer.parseInt(attributes.getValue(i));
                    } else
                    if ("DisplayTitle".equals(attributes.getLocalName(i)))
                    {
                        section.title = attributes.getValue(i);
                    } else
                    if ("Description".equals(attributes.getLocalName(i)))
                    {
                        section.description = attributes.getValue(i);
                    }
                    i++;
                }
                return sectionElement;
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

            
            {
                this$1 = DealsResponse._cls1.this;
                super();
                section = null;
                sectionElement = new _cls1();
            }
    }

                section.add(subSection);
                int j = attributes.getLength();
                for (int i = 0; i < j; i++)
                {
                    if ("SubTitle".equals(attributes.getLocalName(i)))
                    {
                        subSection.title = attributes.getValue(i);
                    }
                }

                return subSectionElement;
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

            
            {
                this$2 = DealsResponse._cls1._cls1.this;
                super();
                subSection = null;
                subSectionElement = new _cls1();
            }
    }

            if ("Item".equals(s1))
            {
                return itemElement.get(subSection, attributes);
            }
            if ("MultiSKU".equals(s1))
            {
                return multiSkuElement.get(subSection);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

            
            {
                this$3 = DealsResponse._cls1._cls1._cls1.this;
                super();
                itemElement = new DealsResponse.ItemElement();
                multiSkuElement = new DealsResponse.MultiSkuElement(itemElement);
            }
    }


    // Unreferenced inner class com/ebay/common/net/deals/EbayDealsApi$DealsResponse$ItemElement$1

/* anonymous class */
    class DealsResponse.ItemElement._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        com.ebay.nautilus.kernel.util.SaxHandler.TextElement imageUrlElement;
        final DealsResponse.ItemElement this$0;
        com.ebay.nautilus.kernel.util.SaxHandler.TextElement titleElement;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Title".equals(s1))
            {
                return titleElement;
            }
            if ("GalleryURL".equals(s1))
            {
                return imageUrlElement;
            }
            if ("ConvertedCurrentPrice".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.convertedCurrentPrice = s1;
                return new CurrencyElement(s1, "CurrencyID", attributes);
            }
            if ("RRP".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.origRetailPrice = s1;
                return new CurrencyElement(s1, "CurrencyID", attributes);
            }
            if ("ShippingPrice".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.shippingCost = s1;
                return new CurrencyElement(s1, "CurrencyID", attributes);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

            
            {
                this$0 = DealsResponse.ItemElement.this;
                super();
                titleElement = new _cls1();
                imageUrlElement = new _cls2();
            }
    }


    // Unreferenced inner class com/ebay/common/net/deals/EbayDealsApi$DealsResponse$ItemElement$1$1

/* anonymous class */
    class DealsResponse.ItemElement._cls1._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final DealsResponse.ItemElement._cls1 this$1;

        public void text(String s)
            throws SAXException
        {
    class DealsResponse.ItemElement._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        com.ebay.nautilus.kernel.util.SaxHandler.TextElement imageUrlElement;
        final DealsResponse.ItemElement this$0;
        com.ebay.nautilus.kernel.util.SaxHandler.TextElement titleElement;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Title".equals(s1))
            {
                return titleElement;
            }
            if ("GalleryURL".equals(s1))
            {
                return imageUrlElement;
            }
            if ("ConvertedCurrentPrice".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.convertedCurrentPrice = s1;
                return new CurrencyElement(s1, "CurrencyID", attributes);
            }
            if ("RRP".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.origRetailPrice = s1;
                return new CurrencyElement(s1, "CurrencyID", attributes);
            }
            if ("ShippingPrice".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.shippingCost = s1;
                return new CurrencyElement(s1, "CurrencyID", attributes);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

            
            {
                this$0 = DealsResponse.ItemElement.this;
                super();
                titleElement = new _cls1();
                imageUrlElement = new _cls2();
            }
    }

            item.title = s;
        }

            
            {
                this$1 = DealsResponse.ItemElement._cls1.this;
                super();
            }
    }


    // Unreferenced inner class com/ebay/common/net/deals/EbayDealsApi$DealsResponse$ItemElement$1$2

/* anonymous class */
    class DealsResponse.ItemElement._cls1._cls2 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final DealsResponse.ItemElement._cls1 this$1;

        public void text(String s)
            throws SAXException
        {
            item.imageUrl = s;
        }

            
            {
                this$1 = DealsResponse.ItemElement._cls1.this;
                super();
            }
    }


    // Unreferenced inner class com/ebay/common/net/deals/EbayDealsApi$DealsResponse$ItemElement$2

/* anonymous class */
    class DealsResponse.ItemElement._cls2 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        com.ebay.nautilus.kernel.util.SaxHandler.TextElement endDateElement;
        com.ebay.nautilus.kernel.util.SaxHandler.TextElement energyRatingElement;
        com.ebay.nautilus.kernel.util.SaxHandler.TextElement savingsRateElement;
        final DealsResponse.ItemElement this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("SavingsRate".equals(s1))
            {
                return savingsRateElement;
            }
            if ("EndTime".equals(s1))
            {
                return endDateElement;
            }
            if ("MetaAttribute".equals(s1))
            {
                int j = attributes.getLength();
                for (int i = 0; i < j; i++)
                {
                    if ("EEKRating".equals(attributes.getValue(i)))
                    {
                        return energyRatingElement;
                    }
                }

            }
            return super.get(s, s1, s2, attributes);
        }

            
            {
                this$0 = DealsResponse.ItemElement.this;
                super();
                savingsRateElement = new _cls1();
                endDateElement = new _cls2();
                energyRatingElement = new _cls3();
            }
    }


    // Unreferenced inner class com/ebay/common/net/deals/EbayDealsApi$DealsResponse$ItemElement$2$1

/* anonymous class */
    class DealsResponse.ItemElement._cls2._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final DealsResponse.ItemElement._cls2 this$1;

        public void text(String s)
            throws SAXException
        {
            try
            {
    class DealsResponse.ItemElement._cls2 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        com.ebay.nautilus.kernel.util.SaxHandler.TextElement endDateElement;
        com.ebay.nautilus.kernel.util.SaxHandler.TextElement energyRatingElement;
        com.ebay.nautilus.kernel.util.SaxHandler.TextElement savingsRateElement;
        final DealsResponse.ItemElement this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("SavingsRate".equals(s1))
            {
                return savingsRateElement;
            }
            if ("EndTime".equals(s1))
            {
                return endDateElement;
            }
            if ("MetaAttribute".equals(s1))
            {
                int j = attributes.getLength();
                for (int i = 0; i < j; i++)
                {
                    if ("EEKRating".equals(attributes.getValue(i)))
                    {
                        return energyRatingElement;
                    }
                }

            }
            return super.get(s, s1, s2, attributes);
        }

            
            {
                this$0 = DealsResponse.ItemElement.this;
                super();
                savingsRateElement = new _cls1();
                endDateElement = new _cls2();
                energyRatingElement = new _cls3();
            }
    }

                item.savingsRate = Integer.parseInt(s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new SAXNotRecognizedException(s.getLocalizedMessage());
            }
        }

            
            {
                this$1 = DealsResponse.ItemElement._cls2.this;
                super();
            }
    }


    // Unreferenced inner class com/ebay/common/net/deals/EbayDealsApi$DealsResponse$ItemElement$2$2

/* anonymous class */
    class DealsResponse.ItemElement._cls2._cls2 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final DealsResponse.ItemElement._cls2 this$1;

        public void text(String s)
            throws SAXException
        {
            try
            {
                item.endDate = EbayDateUtils.parseIso8601DateTime(s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new SAXNotRecognizedException(s.getLocalizedMessage());
            }
        }

            
            {
                this$1 = DealsResponse.ItemElement._cls2.this;
                super();
            }
    }


    // Unreferenced inner class com/ebay/common/net/deals/EbayDealsApi$DealsResponse$ItemElement$2$3

/* anonymous class */
    class DealsResponse.ItemElement._cls2._cls3 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final DealsResponse.ItemElement._cls2 this$1;

        public void text(String s)
        {
            item.energyRating = s;
        }

            
            {
                this$1 = DealsResponse.ItemElement._cls2.this;
                super();
            }
    }


    // Unreferenced inner class com/ebay/common/net/deals/EbayDealsApi$DealsResponse$MultiSkuElement$1

/* anonymous class */
    class DealsResponse.MultiSkuElement._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final DealsResponse.MultiSkuElement this$0;

        public void text(String s)
            throws SAXException
        {
            item.title = s;
        }

            
            {
                this$0 = DealsResponse.MultiSkuElement.this;
                super();
            }
    }


    // Unreferenced inner class com/ebay/common/net/deals/EbayDealsApi$DealsResponse$MultiSkuElement$2

/* anonymous class */
    class DealsResponse.MultiSkuElement._cls2 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final DealsResponse.MultiSkuElement this$0;

        public void text(String s)
            throws SAXException
        {
            item.imageUrl = s;
        }

            
            {
                this$0 = DealsResponse.MultiSkuElement.this;
                super();
            }
    }

}
