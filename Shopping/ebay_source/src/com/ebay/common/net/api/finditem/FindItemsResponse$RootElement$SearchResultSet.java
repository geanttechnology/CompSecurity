// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.finditem;

import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.finditem:
//            FindItemsResponse

private final class result extends com.ebay.nautilus.kernel.util.et
{
    private final class Mapping extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private String name;
        final FindItemsResponse.RootElement.SearchResultSet this$2;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("field".equals(s1))
            {
                return new Field(null);
            }
            if ("fieldValue".equals(s1))
            {
                return new FieldValue(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }



/*
        static String access$502(Mapping mapping, String s)
        {
            mapping.name = s;
            return s;
        }

*/

        private Mapping()
        {
            this$2 = FindItemsResponse.RootElement.SearchResultSet.this;
            super();
        }

        Mapping(FindItemsResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class Mapping.Field extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Mapping this$3;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Mapping.Field this$4;

                    public void text(String s)
                        throws SAXException
                    {
                        name = s;
                    }

            
            {
                this$4 = Mapping.Field.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private Mapping.Field()
        {
            this$3 = Mapping.this;
            super();
        }

        Mapping.Field(FindItemsResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class Mapping.FieldValue extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Mapping this$3;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("value".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Mapping.FieldValue this$4;

                    public void text(String s)
                        throws SAXException
                    {
                        if ("ITEM_ID".equals(name))
                        {
                            result.id = Long.parseLong(s);
                        } else
                        {
                            if ("TITLE".equals(name))
                            {
                                result.title = s;
                                return;
                            }
                            if ("LEAF_CATS".equals(name))
                            {
                                result.leafCategory = s;
                                return;
                            }
                            if ("SITE".equals(name))
                            {
                                result.site = s;
                                return;
                            }
                            if ("PRODUCT_REFID".equals(name))
                            {
                                result.productReferenceId = s;
                                return;
                            }
                            if ("ITEM_CONDITION_NEW".equals(name))
                            {
                                result.conditionNew = s;
                                return;
                            }
                            if ("BIN_PRICE".equals(name))
                            {
                                result.binPrice = s;
                                return;
                            }
                            if ("CURRENT_PRICE".equals(name))
                            {
                                result.currentPrice = s;
                                return;
                            }
                            if ("CURRENCY".equals(name))
                            {
                                result.currency = s;
                                return;
                            }
                            if ("BID_COUNT".equals(name))
                            {
                                result.bidCount = Integer.valueOf(s).intValue();
                                return;
                            }
                            if ("SALE_TYPE".equals(name))
                            {
                                result.saleType = s;
                                return;
                            }
                            if ("SAFE_START_TIME".equals(name))
                            {
                                result.safeStartTime = EbayDateUtils.parseXml(s);
                                return;
                            }
                            if ("END_TIME".equals(name))
                            {
                                result.endTime = EbayDateUtils.parseXml(s);
                                return;
                            }
                            if ("BUYER_FIXED_SHIPPING_COST".equals(name))
                            {
                                result.buyerFixedShippingCost = s;
                                return;
                            }
                            if ("FLAT_SHIP_COST".equals(name))
                            {
                                result.flatShippingCost = s;
                                return;
                            }
                            if ("FULL_CALCULATED_SHIPPING".equals(name))
                            {
                                result.fullCalculatedShipping = s;
                                return;
                            }
                            if ("MD5_IMAGE".equals(name))
                            {
                                result.md5Image = s;
                                return;
                            }
                            if ("IS_FREE_SHIPPING".equals(name))
                            {
                                result.isFreeShipping = Boolean.valueOf(s).booleanValue();
                                return;
                            }
                            if ("SHIPPING_FLAG".equals(name))
                            {
                                result.shippingFlag = s;
                                return;
                            }
                            if ("IS_INSURANCE_REQUIRED".equals(name))
                            {
                                result.isInsuranceRequired = Boolean.valueOf(s).booleanValue();
                                return;
                            }
                            if ("SOLD_AS_BIN".equals(name))
                            {
                                result.soldAsBin = Boolean.valueOf(s).booleanValue();
                                return;
                            }
                            if ("START_PRICE".equals(name))
                            {
                                result.startPrice = s;
                                return;
                            }
                        }
                    }

            
            {
                this$4 = Mapping.FieldValue.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private Mapping.FieldValue()
        {
            this$3 = Mapping.this;
            super();
        }

        Mapping.FieldValue(FindItemsResponse._cls1 _pcls1)
        {
            this();
        }
    }


    public Mapping result;
    final Mapping this$1;

    public com.ebay.nautilus.kernel.util.et get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("mapping".equals(s1))
        {
            return new Mapping(null);
        } else
        {
            return super.et(s, s1, s2, attributes);
        }
    }

    public Mapping()
    {
        this$1 = this._cls1.this;
        super();
        result = new result();
        results.add(result);
    }
}
