// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.finditem;

import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class FindItemsResponse extends EbayResponse
{
    public static class ItemResult
    {

        public int bidCount;
        public String binPrice;
        public String buyerFixedShippingCost;
        public String conditionNew;
        public String currency;
        public String currentPrice;
        public Date endTime;
        public String flatShippingCost;
        public String fullCalculatedShipping;
        public long id;
        public String imageUrl;
        public boolean isFreeShipping;
        public boolean isInsuranceRequired;
        public String leafCategory;
        public String md5Image;
        public String productReferenceId;
        public Date safeStartTime;
        public String saleType;
        public String shippingFlag;
        public String site;
        public boolean soldAsBin;
        public String startPrice;
        public String title;

        public ItemResult()
        {
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final FindItemsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(FindItemsResponse.this);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(FindItemsResponse.this);
            }
            if ("resultSummaryInfo".equals(s1))
            {
                return new ResultSummary();
            }
            if ("searchResultSet".equals(s1))
            {
                return new SearchResultSet();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement()
        {
            this$0 = FindItemsResponse.this;
            super();
        }

    }

    private final class RootElement.ResultSummary extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("matchCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final RootElement.ResultSummary this$2;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        matchCount = i;
                    }

            
            {
                this$2 = RootElement.ResultSummary.this;
                super();
            }
                };
            }
            if ("abridgedMatchCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final RootElement.ResultSummary this$2;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        abridgedMatchCount = i;
                    }

            
            {
                this$2 = RootElement.ResultSummary.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.ResultSummary()
        {
            this$1 = RootElement.this;
            super();
        }

    }

    private final class RootElement.SearchResultSet extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        public ItemResult result;
        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("mapping".equals(s1))
            {
                return new Mapping();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public RootElement.SearchResultSet()
        {
            this$1 = RootElement.this;
            super();
            result = new ItemResult();
            results.add(result);
        }
    }

    private final class RootElement.SearchResultSet.Mapping extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private String name;
        final RootElement.SearchResultSet this$2;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("field".equals(s1))
            {
                return new Field();
            }
            if ("fieldValue".equals(s1))
            {
                return new FieldValue();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }



/*
        static String access$502(RootElement.SearchResultSet.Mapping mapping, String s)
        {
            mapping.name = s;
            return s;
        }

*/

        private RootElement.SearchResultSet.Mapping()
        {
            this$2 = RootElement.SearchResultSet.this;
            super();
        }

    }

    private final class RootElement.SearchResultSet.Mapping.Field extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement.SearchResultSet.Mapping this$3;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.SearchResultSet.Mapping.Field this$4;

                    public void text(String s)
                        throws SAXException
                    {
                        name = s;
                    }

            
            {
                this$4 = RootElement.SearchResultSet.Mapping.Field.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.SearchResultSet.Mapping.Field()
        {
            this$3 = RootElement.SearchResultSet.Mapping.this;
            super();
        }

    }

    private final class RootElement.SearchResultSet.Mapping.FieldValue extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement.SearchResultSet.Mapping this$3;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("value".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.SearchResultSet.Mapping.FieldValue this$4;

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
                this$4 = RootElement.SearchResultSet.Mapping.FieldValue.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.SearchResultSet.Mapping.FieldValue()
        {
            this$3 = RootElement.SearchResultSet.Mapping.this;
            super();
        }

    }


    public int abridgedMatchCount;
    public int matchCount;
    public ArrayList results;

    public FindItemsResponse()
    {
        results = new ArrayList();
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
        for (inputstream = results.iterator(); inputstream.hasNext();)
        {
            ItemResult itemresult = (ItemResult)inputstream.next();
            itemresult.imageUrl = EbaySettings.getImageUrlFromMd5(itemresult.id, itemresult.md5Image);
        }

    }
}
