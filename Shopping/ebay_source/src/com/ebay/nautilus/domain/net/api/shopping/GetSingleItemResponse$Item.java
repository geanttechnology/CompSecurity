// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import android.text.TextUtils;
import com.ebay.nautilus.domain.Duration;
import com.ebay.nautilus.domain.data.EbayItem;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.data.Variation;
import com.ebay.nautilus.domain.data.VariationPictureSet;
import com.ebay.nautilus.domain.net.CurrencyElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetSingleItemResponse

protected final class this._cls0 extends com.ebay.nautilus.kernel.util.sponse.Item
{
    private final class BusinessSellerAddress extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSingleItemResponse.Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("CompanyName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BusinessSellerAddress this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.bsCompanyName = s;
                    }

            
            {
                this$2 = BusinessSellerAddress.this;
                super();
            }
                };
            }
            if ("FirstName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BusinessSellerAddress this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.bsFirstName = s;
                    }

            
            {
                this$2 = BusinessSellerAddress.this;
                super();
            }
                };
            }
            if ("LastName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BusinessSellerAddress this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.bsLastName = s;
                    }

            
            {
                this$2 = BusinessSellerAddress.this;
                super();
            }
                };
            }
            if ("CityName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BusinessSellerAddress this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.bsCityName = s;
                    }

            
            {
                this$2 = BusinessSellerAddress.this;
                super();
            }
                };
            }
            if ("Name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BusinessSellerAddress this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.bsName = s;
                    }

            
            {
                this$2 = BusinessSellerAddress.this;
                super();
            }
                };
            }
            if ("Phone".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BusinessSellerAddress this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.bsPhone = s;
                    }

            
            {
                this$2 = BusinessSellerAddress.this;
                super();
            }
                };
            }
            if ("PostalCode".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BusinessSellerAddress this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.bsPostalCode = s;
                    }

            
            {
                this$2 = BusinessSellerAddress.this;
                super();
            }
                };
            }
            if ("StateOrProvince".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BusinessSellerAddress this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.bsStateOrProvince = s;
                    }

            
            {
                this$2 = BusinessSellerAddress.this;
                super();
            }
                };
            }
            if ("CountryName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BusinessSellerAddress this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.bsCountryName = s;
                    }

            
            {
                this$2 = BusinessSellerAddress.this;
                super();
            }
                };
            }
            if ("Street1".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BusinessSellerAddress this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.bsStreet1 = s;
                    }

            
            {
                this$2 = BusinessSellerAddress.this;
                super();
            }
                };
            }
            if ("Street2".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BusinessSellerAddress this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.bsStreet2 = s;
                    }

            
            {
                this$2 = BusinessSellerAddress.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public BusinessSellerAddress()
        {
            this$1 = GetSingleItemResponse.Item.this;
            super();
        }
    }

    private final class BusinessSellerDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSingleItemResponse.Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("AdditionalContactInformation".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final BusinessSellerDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.bsAdditionalContactInformation = s;
                        }

            
            {
                this$2 = BusinessSellerDetails.this;
                super();
            }
                    };
                }
                if ("Address".equals(s1))
                {
                    return new BusinessSellerAddress();
                }
                if ("Email".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final BusinessSellerDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.bsEmail = s;
                        }

            
            {
                this$2 = BusinessSellerDetails.this;
                super();
            }
                    };
                }
                if ("LegalInvoice".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final BusinessSellerDetails this$2;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            item.bsLegalInvoice = flag;
                        }

            
            {
                this$2 = BusinessSellerDetails.this;
                super();
            }
                    };
                }
                if ("TermsAndConditions".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final BusinessSellerDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.bsTermsAndConditions = s;
                        }

            
            {
                this$2 = BusinessSellerDetails.this;
                super();
            }
                    };
                }
                if ("TradeRegistrationNumber".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final BusinessSellerDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.bsTradeRegistrationNumber = s;
                        }

            
            {
                this$2 = BusinessSellerDetails.this;
                super();
            }
                    };
                }
                if ("Fax".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final BusinessSellerDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.bsFax = s;
                        }

            
            {
                this$2 = BusinessSellerDetails.this;
                super();
            }
                    };
                }
                if ("VATDetails".equals(s1))
                {
                    return new VatDetails(null);
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public BusinessSellerDetails()
        {
            this$1 = GetSingleItemResponse.Item.this;
            super();
            this$0.item.bsDetailsExists = true;
        }
    }

    private final class Charity extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSingleItemResponse.Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("CharityID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final Charity this$2;

                        public void setValue(int i)
                            throws SAXException
                        {
                            item.charityId = i;
                        }

            
            {
                this$2 = Charity.this;
                super();
            }
                    };
                }
                if ("CharityName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Charity this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.charityName = s;
                        }

            
            {
                this$2 = Charity.this;
                super();
            }
                    };
                }
                if ("CharityNumber".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final Charity this$2;

                        public void setValue(int i)
                            throws SAXException
                        {
                            item.charityNumber = i;
                        }

            
            {
                this$2 = Charity.this;
                super();
            }
                    };
                }
                if ("DonationPercent".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.FloatElement() {

                        final Charity this$2;

                        public void setValue(float f)
                            throws SAXException
                        {
                            item.charityDonationPercent = f;
                        }

            
            {
                this$2 = Charity.this;
                super();
            }
                    };
                }
                if ("LogoURL".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Charity this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.charityLogoUrl = s;
                        }

            
            {
                this$2 = Charity.this;
                super();
            }
                    };
                }
                if ("Mission".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Charity this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.charityMission = s;
                        }

            
            {
                this$2 = Charity.this;
                super();
            }
                    };
                }
                if ("Status".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Charity this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.charityStatus = s;
                        }

            
            {
                this$2 = Charity.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private Charity()
        {
            this$1 = GetSingleItemResponse.Item.this;
            super();
        }

        Charity(GetSingleItemResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class DiscountPriceInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSingleItemResponse.Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("MinimumAdvertisedPrice".equals(s1))
                {
                    s = item;
                    s1 = new ItemCurrency();
                    s.dpiMinimumAdvertisedPrice = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("MinimumAdvertisedPriceExposure".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final DiscountPriceInfo this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.dpiMinimumAdvertisedPriceExposure = s;
                        }

            
            {
                this$2 = DiscountPriceInfo.this;
                super();
            }
                    };
                }
                if ("OriginalRetailPrice".equals(s1))
                {
                    s = item;
                    s1 = new ItemCurrency();
                    s.originalRetailPrice = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("PricingTreatment".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final DiscountPriceInfo this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.pricingTreatment = s;
                        }

            
            {
                this$2 = DiscountPriceInfo.this;
                super();
            }
                    };
                }
                if ("SoldOffeBay".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final DiscountPriceInfo this$2;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            item.dpiSoldOffEbay = flag;
                        }

            
            {
                this$2 = DiscountPriceInfo.this;
                super();
            }
                    };
                }
                if ("SoldOneBay".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final DiscountPriceInfo this$2;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            item.dpiSoldOnEbay = flag;
                        }

            
            {
                this$2 = DiscountPriceInfo.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private DiscountPriceInfo()
        {
            this$1 = GetSingleItemResponse.Item.this;
            super();
        }

        DiscountPriceInfo(GetSingleItemResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class HighBidder extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSingleItemResponse.Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "UserID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final HighBidder this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.highBidderUserId = s;
                    }

            
            {
                this$2 = HighBidder.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private HighBidder()
        {
            this$1 = GetSingleItemResponse.Item.this;
            super();
        }

        HighBidder(GetSingleItemResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ItemSpecifics extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSingleItemResponse.Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "NameValueList".equals(s1))
            {
                return new NameValueList(item.itemSpecifics);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ItemSpecifics()
        {
            this$1 = GetSingleItemResponse.Item.this;
            super();
        }

        ItemSpecifics(GetSingleItemResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class NameValueList extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        ArrayList list;
        final GetSingleItemResponse.Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                NameValue namevalue = (NameValue)list.get(list.size() - 1);
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
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public NameValueList(ArrayList arraylist)
        {
            this$1 = GetSingleItemResponse.Item.this;
            super();
            list = arraylist;
            arraylist.add(new NameValue());
        }
    }

    private final class PickupInStoreDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSingleItemResponse.Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("EligibleForPickupInStore".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final PickupInStoreDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.eligibleForPickupInStore = "true".equals(s);
                        }

            
            {
                this$2 = PickupInStoreDetails.this;
                super();
            }
                    };
                }
                if ("AvailableForPickupInStore".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final PickupInStoreDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.availableForPickupInStore = "true".equals(s);
                        }

            
            {
                this$2 = PickupInStoreDetails.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private PickupInStoreDetails()
        {
            this$1 = GetSingleItemResponse.Item.this;
            super();
        }

        PickupInStoreDetails(GetSingleItemResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class Pictures extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSingleItemResponse.Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("VariationSpecificName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Pictures this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.variationPicturesSpecificName = s;
                        }

            
            {
                this$2 = Pictures.this;
                super();
            }
                    };
                }
                if ("VariationSpecificPictureSet".equals(s1))
                {
                    return new VariationSpecificPictureSet();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private Pictures()
        {
            this$1 = GetSingleItemResponse.Item.this;
            super();
        }

        Pictures(GetSingleItemResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class PromotionalSaleDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSingleItemResponse.Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("OriginalPrice".equals(s1))
                {
                    s = item;
                    s1 = new ItemCurrency();
                    s.promotionalSaleOriginalPrice = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("StartTime".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final PromotionalSaleDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.promotionalSaleStartTime = EbayDateUtils.parseXml(s);
                        }

            
            {
                this$2 = PromotionalSaleDetails.this;
                super();
            }
                    };
                }
                if ("EndTime".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final PromotionalSaleDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.promotionalSaleEndTime = EbayDateUtils.parseXml(s);
                        }

            
            {
                this$2 = PromotionalSaleDetails.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private PromotionalSaleDetails()
        {
            this$1 = GetSingleItemResponse.Item.this;
            super();
        }

        PromotionalSaleDetails(GetSingleItemResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ReturnPolicy extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSingleItemResponse.Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Description".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ReturnPolicy this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.rpDescription = s;
                        }

            
            {
                this$2 = ReturnPolicy.this;
                super();
            }
                    };
                }
                if ("EAN".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ReturnPolicy this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.rpEAN = s;
                        }

            
            {
                this$2 = ReturnPolicy.this;
                super();
            }
                    };
                }
                if ("RestockingFeeValue".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ReturnPolicy this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.rpRestockingFee = s;
                        }

            
            {
                this$2 = ReturnPolicy.this;
                super();
            }
                    };
                }
                if ("Refund".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ReturnPolicy this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.rpRefund = s;
                        }

            
            {
                this$2 = ReturnPolicy.this;
                super();
            }
                    };
                }
                if ("ReturnsAccepted".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ReturnPolicy this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.rpReturnsAccepted = s;
                        }

            
            {
                this$2 = ReturnPolicy.this;
                super();
            }
                    };
                }
                if ("ReturnsWithin".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ReturnPolicy this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.rpReturnsWithin = s;
                        }

            
            {
                this$2 = ReturnPolicy.this;
                super();
            }
                    };
                }
                if ("ShippingCostPaidBy".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ReturnPolicy this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.rpShippingCostPaidBy = s;
                        }

            
            {
                this$2 = ReturnPolicy.this;
                super();
            }
                    };
                }
                if ("WarrantyDuration".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ReturnPolicy this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.rpWarrantyDuration = s;
                        }

            
            {
                this$2 = ReturnPolicy.this;
                super();
            }
                    };
                }
                if ("WarrantyOffered".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ReturnPolicy this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.rpWarrantyOffered = s;
                        }

            
            {
                this$2 = ReturnPolicy.this;
                super();
            }
                    };
                }
                if ("WarrantyType".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ReturnPolicy this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.rpWarrantyType = s;
                        }

            
            {
                this$2 = ReturnPolicy.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private ReturnPolicy()
        {
            this$1 = GetSingleItemResponse.Item.this;
            super();
        }

        ReturnPolicy(GetSingleItemResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class Seller extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSingleItemResponse.Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("UserID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Seller this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.sellerUserId = s;
                        }

            
            {
                this$2 = Seller.this;
                super();
            }
                    };
                }
                if ("FeedbackRatingStar".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Seller this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.sellerFeedbackRatingStar = s;
                        }

            
            {
                this$2 = Seller.this;
                super();
            }
                    };
                }
                if ("FeedbackScore".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final Seller this$2;

                        public void setValue(int i)
                            throws SAXException
                        {
                            item.sellerFeedbackScore = i;
                        }

            
            {
                this$2 = Seller.this;
                super();
            }
                    };
                }
                if ("PositiveFeedbackPercent".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.FloatElement() {

                        final Seller this$2;

                        public void setValue(float f)
                            throws SAXException
                        {
                            item.sellerPositiveFeedbackPercent = f;
                        }

            
            {
                this$2 = Seller.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private Seller()
        {
            this$1 = GetSingleItemResponse.Item.this;
            super();
        }

        Seller(GetSingleItemResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class SellingStatus extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSingleItemResponse.Item this$1;
        final Variation variation;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "QuantitySold".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final SellingStatus this$2;

                    public void setValue(int i)
                        throws SAXException
                    {
                        variation.setQuantitySold(i);
                    }

            
            {
                this$2 = SellingStatus.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public SellingStatus(Variation variation1)
        {
            this$1 = GetSingleItemResponse.Item.this;
            super();
            variation = variation1;
        }
    }

    private final class UnitInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSingleItemResponse.Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("UnitType".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final UnitInfo this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.unitPriceType = s;
                        }

            
            {
                this$2 = UnitInfo.this;
                super();
            }
                    };
                }
                if ("UnitQuantity".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final UnitInfo this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.unitPriceQuantity = s;
                        }

            
            {
                this$2 = UnitInfo.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private UnitInfo()
        {
            this$1 = GetSingleItemResponse.Item.this;
            super();
        }

        UnitInfo(GetSingleItemResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class VariationSpecificPictureSet extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSingleItemResponse.Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                VariationPictureSet variationpictureset = (VariationPictureSet)item.variationPictureSets.get(item.variationPictureSets.size() - 1);
                if ("VariationSpecificValue".equals(s1))
                {
                    return variationpictureset. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final VariationSpecificPictureSet this$2;
                        final VariationPictureSet val$vps;

                        public void text(String s)
                            throws SAXException
                        {
                            vps.specificName = s;
                        }

            
            {
                this$2 = final_variationspecificpictureset;
                vps = VariationPictureSet.this;
                super();
            }
                    };
                }
                if ("PictureURL".equals(s1))
                {
                    return variationpictureset. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final VariationSpecificPictureSet this$2;
                        final VariationPictureSet val$vps;

                        public void text(String s)
                            throws SAXException
                        {
                            vps.pictureUrls.add(s);
                        }

            
            {
                this$2 = final_variationspecificpictureset;
                vps = VariationPictureSet.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public VariationSpecificPictureSet()
        {
            this$1 = GetSingleItemResponse.Item.this;
            super();
            this$0.item.variationPictureSets.add(new VariationPictureSet());
        }
    }

    private final class VariationSpecifics extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSingleItemResponse.Item this$1;
        final Variation variation;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "NameValueList".equals(s1))
            {
                return new NameValueList(variation.getNameValueList());
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public VariationSpecifics(Variation variation1)
        {
            this$1 = GetSingleItemResponse.Item.this;
            super();
            variation = variation1;
        }
    }

    private final class VariationSpecificsSet extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSingleItemResponse.Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "NameValueList".equals(s1))
            {
                return new NameValueList(item.variationSpecifics);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private VariationSpecificsSet()
        {
            this$1 = GetSingleItemResponse.Item.this;
            super();
        }

        VariationSpecificsSet(GetSingleItemResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class VariationXml extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSingleItemResponse.Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                Variation variation = (Variation)item.variations.get(item.variations.size() - 1);
                if ("Quantity".equals(s1))
                {
                    return variation. new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final VariationXml this$2;
                        final Variation val$variation;

                        public void setValue(int i)
                            throws SAXException
                        {
                            variation.setQuantity(i);
                        }

            
            {
                this$2 = final_variationxml;
                variation = Variation.this;
                super();
            }
                    };
                }
                if ("SellingStatus".equals(s1))
                {
                    return new SellingStatus(variation);
                }
                if ("VariationSpecifics".equals(s1))
                {
                    return new VariationSpecifics(variation);
                }
                if ("SKU".equals(s1))
                {
                    return variation. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final VariationXml this$2;
                        final Variation val$variation;

                        public void text(String s)
                            throws SAXException
                        {
                            variation.setSKU(s);
                        }

            
            {
                this$2 = final_variationxml;
                variation = Variation.this;
                super();
            }
                    };
                }
                if ("".equals(s1))
                {
                    return variation. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final VariationXml this$2;
                        final Variation val$variation;

                        public void text(String s)
                            throws SAXException
                        {
                            variation.setSKU(s);
                        }

            
            {
                this$2 = final_variationxml;
                variation = Variation.this;
                super();
            }
                    };
                }
                if ("StartPrice".equals(s1))
                {
                    return new CurrencyElement(variation.getStartPrice(), "currencyID", attributes);
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public VariationXml()
        {
            this$1 = GetSingleItemResponse.Item.this;
            super();
            this$0.item.variations.add(new Variation());
        }
    }

    private final class Variations extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSingleItemResponse.Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Pictures".equals(s1))
                {
                    return new Pictures(null);
                }
                if ("Variation".equals(s1))
                {
                    return new VariationXml();
                }
                if ("VariationSpecificsSet".equals(s1))
                {
                    return new VariationSpecificsSet(null);
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private Variations()
        {
            this$1 = GetSingleItemResponse.Item.this;
            super();
        }

        Variations(GetSingleItemResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class VatDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSingleItemResponse.Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("VATID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final VatDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.bsVatId = s;
                        }

            
            {
                this$2 = VatDetails.this;
                super();
            }
                    };
                }
                if ("VATSite".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final VatDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.bsVatSite = s;
                        }

            
            {
                this$2 = VatDetails.this;
                super();
            }
                    };
                }
                if ("VATPercent".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                        final VatDetails this$2;

                        public void setValue(double d)
                            throws SAXException
                        {
                            item.bsVatPercent = d;
                        }

            
            {
                this$2 = VatDetails.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private VatDetails()
        {
            this$1 = GetSingleItemResponse.Item.this;
            super();
        }

        VatDetails(GetSingleItemResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class shippingCostSummary extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSingleItemResponse.Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("ShippingServiceCost".equals(s1))
                {
                    s = item;
                    s1 = new ItemCurrency();
                    s.shippingCost = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("LocalPickup".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final shippingCostSummary this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.isLocalPickup = "true".equals(s);
                        }

            
            {
                this$2 = shippingCostSummary.this;
                super();
            }
                    };
                }
                if ("ShippingType".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final shippingCostSummary this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.shippingType = s;
                        }

            
            {
                this$2 = shippingCostSummary.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private shippingCostSummary()
        {
            this$1 = GetSingleItemResponse.Item.this;
            super();
        }

        shippingCostSummary(GetSingleItemResponse._cls1 _pcls1)
        {
            this();
        }
    }


    final GetSingleItemResponse this$0;

    public com.ebay.nautilus.kernel.util.sponse.Item get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("ItemID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void setValue(long l)
                        throws SAXException
                    {
                        item.id = l;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("Site".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.site = s3;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("Title".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.title = s3;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("TopRatedListing".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        item.topRatedListing = flag;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("Description".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.description = s3;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("PrimaryCategoryID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void setValue(long l)
                        throws SAXException
                    {
                        item.primaryCategoryId = l;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("PrimaryCategoryIDPath".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.primaryCategoryIdPath = s3;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("PrimaryCategoryName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.primaryCategoryName = s3;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("SecondaryCategoryID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void setValue(long l)
                        throws SAXException
                    {
                        item.secondaryCategoryId = l;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("SecondaryCategoryIDPath".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.secondaryCategoryIdPath = s3;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("SecondaryCategoryName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.secondaryCategoryName = s3;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("ConvertedBuyItNowPrice".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.convertedBuyItNowPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("ConvertedCurrentPrice".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.convertedCurrentPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("ListingType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.listingType = s3;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("ProductID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;
                    final String val$productIdtype;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.productId = s3;
                        item.productIdType = productIdtype;
                        if (TextUtils.isEmpty(item.productIdType))
                        {
                            item.productIdType = "Reference";
                        }
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                productIdtype = s;
                super();
            }
                };
            }
            if ("ListingStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.listingStatus = s3;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("PromotionalSaleDetails".equals(s1))
            {
                return new PromotionalSaleDetails(null);
            }
            if ("PictureURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.pictureUrls.add(s3);
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("Seller".equals(s1))
            {
                return new Seller(null);
            }
            if ("ItemSpecifics".equals(s1))
            {
                return new ItemSpecifics(null);
            }
            if ("Variations".equals(s1))
            {
                return new Variations(null);
            }
            if ("Title".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.title = s3;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("Subtitle".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.subTitle = s3;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("TimeLeft".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.timeLeft = Duration.parseXml(s3);
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("ListingType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.listingType = s3;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("EndTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.endDate = EbayDateUtils.parseXml(s3);
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("StartTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.startDate = EbayDateUtils.parseXml(s3);
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("Location".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        if (s3 != null)
                        {
                            item.location = s3.trim();
                        }
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("Site".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.site = s3;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("PaymentMethods".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.paymentMethods.add(s3);
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("GalleryURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.galleryUrl = s3;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("HandlingTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        item.handlingTime = Integer.valueOf(i);
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("Quantity".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        item.quantity = i;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("QuantitySold".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        item.quantitySold = i;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("HighBidder".equals(s1))
            {
                return new HighBidder(null);
            }
            if ("BidCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        item.bidCount = i;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("CurrentPrice".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.currentPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("BuyItNowPrice".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.buyItNowPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("BuyItNowAvailable".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        item.buyItNowAvailable = flag;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("Charity".equals(s1))
            {
                return new Charity(null);
            }
            if ("ReserveMet".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        item.reserveMet = flag;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("ShipToLocations".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.shipToLocations.add(s3);
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("ExcludeShipToLocation".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.excludeShipToLocations.add(s3);
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("ShippingCostSummary".equals(s1))
            {
                return new shippingCostSummary(null);
            }
            if ("HitCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        item.hitCount = i;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("AutoPay".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        item.autoPay = flag;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("ViewItemURLForNaturalSearch".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.viewItemUrlForNaturalSearch = s3;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("MinimumToBid".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.minimumToBid = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("EmbeddedMobileCheckoutEnabled".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        item.embeddedMobileCheckoutEnabled = flag;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("PrimaryCategoryIDPath".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.primaryCategoryIdPath = s3;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("BusinessSellerDetails".equals(s1))
            {
                return new BusinessSellerDetails();
            }
            if ("DiscountPriceInfo".equals(s1))
            {
                return new DiscountPriceInfo(null);
            }
            if ("Country".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.country = s3;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("BestOfferEnabled".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        item.bestOfferEnabled = flag;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("ReturnPolicy".equals(s1))
            {
                return new ReturnPolicy(null);
            }
            if ("GlobalShipping".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        item.globalShipping = flag;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("ConditionID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        item.conditionId = i;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("ConditionDisplayName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.conditionDisplayName = s3;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("ConditionDescription".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.conditionDescription = s3;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("UnitInfo".equalsIgnoreCase(s1))
            {
                return new UnitInfo(null);
            }
            if ("PickupInStoreDetails".equals(s1))
            {
                return new PickupInStoreDetails(null);
            }
            if ("SKU".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.sku = s3;
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("AvailableForPickupInStore".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.availableForPickupInStore = "true".equals(s3);
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("eBayNowEligible".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.availableForEbayNow = "true".equals(s3);
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("IgnoreQuantity".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.ignoreQuantity = "true".equals(s3);
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
            if ("LotSize".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetSingleItemResponse.Item this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        item.lotSize = Integer.valueOf(i);
                    }

            
            {
                this$1 = GetSingleItemResponse.Item.this;
                super();
            }
                };
            }
        }
        return super.Item(s, s1, s2, attributes);
    }

    protected _cls9.this._cls1()
    {
        this$0 = GetSingleItemResponse.this;
        super();
    }
}
