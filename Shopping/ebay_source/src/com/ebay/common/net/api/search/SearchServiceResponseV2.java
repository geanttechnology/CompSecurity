// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.text.TextUtils;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.model.search.SellerOffer;
import com.ebay.common.net.api.search.idealmodel.LabeledAnswerSrpListItem;
import com.ebay.common.net.api.search.idealmodel.RegularSrpListItem;
import com.ebay.common.net.api.search.idealmodel.RewriteEndSrpListItem;
import com.ebay.common.net.api.search.idealmodel.RewriteStartSrpListItem;
import com.ebay.common.net.api.search.idealmodel.SrpListItem;
import com.ebay.common.net.api.search.wiremodel.AnswerResponse;
import com.ebay.common.net.api.search.wiremodel.Layout;
import com.ebay.common.net.api.search.wiremodel.Rewrite;
import com.ebay.common.net.api.search.wiremodel.SearchResponse;
import com.ebay.common.util.EbayDateFormat;
import com.ebay.nautilus.domain.data.Distance;
import com.ebay.nautilus.domain.data.EbaySearchListItem;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.kernel.net.IHeader;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.IResponseHeaderHandler;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponse, ISearchTracking, KnownSearchExpansion, SearchConfiguration, 
//            SearchExpansion

public class SearchServiceResponseV2 extends SearchServiceResponse
    implements ISearchTracking, IResponseHeaderHandler
{
    private class AnswersElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("labeledItem".equals(s1))
            {
                if (answers.labeledAnswers == null)
                {
                    answers.labeledAnswers = new ArrayList();
                }
                return new LabeledAnswersElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private AnswersElement()
        {
            this$0 = SearchServiceResponseV2.this;
            super();
        }

    }

    private class AspectContainerElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("aspect".equals(s1))
            {
                return new AspectElement(aspect);
            }
            if ("valueHistogram".equals(s1))
            {
                s = new com.ebay.common.model.search.EbayAspectHistogram.AspectValue();
                aspect.add(s);
                return new ValueHistogramElement(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public AspectContainerElement(com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect1)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            aspect = aspect1;
        }
    }

    private class AspectElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            byte byte0 = -1;
            s1.hashCode();
            JVM INSTR lookupswitch 3: default 40
        //                       3373707: 78
        //                       696548518: 108
        //                       1714148973: 93;
               goto _L1 _L2 _L3 _L4
_L1:
            break; /* Loop/switch isn't completed */
_L3:
            break MISSING_BLOCK_LABEL_108;
_L5:
            switch (byte0)
            {
            default:
                return super.get(s, s1, s2, attributes);

            case 0: // '\0'
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final AspectElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        aspect.serviceName = s;
                    }

            
            {
                this$1 = AspectElement.this;
                super();
            }
                };

            case 1: // '\001'
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final AspectElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        if (TextUtils.isEmpty(aspect.name))
                        {
                            aspect.name = s;
                        }
                    }

            
            {
                this$1 = AspectElement.this;
                super();
            }
                };

            case 2: // '\002'
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final AspectElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        aspect.name = s;
                    }

            
            {
                this$1 = AspectElement.this;
                super();
            }
                };
            }
_L2:
            if (s1.equals("name"))
            {
                byte0 = 0;
            }
              goto _L5
_L4:
            if (s1.equals("displayName"))
            {
                byte0 = 1;
            }
              goto _L5
            if (s1.equals("localizedName"))
            {
                byte0 = 2;
            }
              goto _L5
        }

        public AspectElement(com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect1)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            aspect = aspect1;
        }
    }

    private class AspectHistogramElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("aspect".equals(s1))
            {
                s = new com.ebay.common.model.search.EbayAspectHistogram.Aspect();
                searchResponse.aspectHistogram.add(s);
                return new AspectContainerElement(s);
            }
            if ("scope".equals(s1))
            {
                return new ScopedAspectElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public AspectHistogramElement()
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            if (searchResponse.aspectHistogram == null)
            {
                searchResponse.aspectHistogram = new EbayAspectHistogram();
                searchResponse.aspectHistogram.domainDisplayName = "";
                searchResponse.aspectHistogram.domainName = "";
            }
        }
    }

    private class AspectValueElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectValue;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            byte byte0 = -1;
            s1.hashCode();
            JVM INSTR lookupswitch 3: default 40
        //                       3373707: 78
        //                       696548518: 108
        //                       1714148973: 93;
               goto _L1 _L2 _L3 _L4
_L1:
            break; /* Loop/switch isn't completed */
_L3:
            break MISSING_BLOCK_LABEL_108;
_L5:
            switch (byte0)
            {
            default:
                return super.get(s, s1, s2, attributes);

            case 0: // '\0'
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final AspectValueElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        aspectValue.serviceValue = s;
                    }

            
            {
                this$1 = AspectValueElement.this;
                super();
            }
                };

            case 1: // '\001'
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final AspectValueElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        if (TextUtils.isEmpty(aspectValue.value))
                        {
                            aspectValue.value = s;
                        }
                    }

            
            {
                this$1 = AspectValueElement.this;
                super();
            }
                };

            case 2: // '\002'
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final AspectValueElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        aspectValue.value = s;
                    }

            
            {
                this$1 = AspectValueElement.this;
                super();
            }
                };
            }
_L2:
            if (s1.equals("name"))
            {
                byte0 = 0;
            }
              goto _L5
_L4:
            if (s1.equals("displayName"))
            {
                byte0 = 1;
            }
              goto _L5
            if (s1.equals("localizedName"))
            {
                byte0 = 2;
            }
              goto _L5
        }

        public AspectValueElement(com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectvalue)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            aspectValue = aspectvalue;
        }
    }

    private class CategoryElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory category;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            byte byte0 = -1;
            s1.hashCode();
            JVM INSTR lookupswitch 6: default 64
        //                       -1989025848: 159
        //                       -1490976132: 189
        //                       3355: 114
        //                       3373707: 129
        //                       102865796: 174
        //                       696548518: 144;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
            break; /* Loop/switch isn't completed */
_L3:
            break MISSING_BLOCK_LABEL_189;
_L8:
            switch (byte0)
            {
            default:
                return super.get(s, s1, s2, attributes);

            case 0: // '\0'
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final CategoryElement this$1;

                    protected void setValue(long l)
                        throws SAXException
                    {
                        category.id = l;
                    }

            
            {
                this$1 = CategoryElement.this;
                super();
            }
                };

            case 1: // '\001'
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final CategoryElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        if (TextUtils.isEmpty(category.name))
                        {
                            category.name = s;
                        }
                    }

            
            {
                this$1 = CategoryElement.this;
                super();
            }
                };

            case 2: // '\002'
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final CategoryElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        category.name = s;
                    }

            
            {
                this$1 = CategoryElement.this;
                super();
            }
                };

            case 3: // '\003'
                return new com.ebay.nautilus.kernel.util.SaxHandler.Element() {

                    final CategoryElement this$1;

                    public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
                        throws SAXException
                    {
                        if ("id".equals(s1))
                        {
                            return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                                final CategoryElement._cls4 this$2;

                                protected void setValue(long l)
                                    throws SAXException
                                {
                                    category.parentId = l;
                                }

            
            {
                this$2 = CategoryElement._cls4.this;
                super();
            }
                            };
                        } else
                        {
                            return super.get(s, s1, s2, attributes);
                        }
                    }

            
            {
                this$1 = CategoryElement.this;
                super();
            }
                };

            case 4: // '\004'
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final CategoryElement this$1;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        category.level = i;
                    }

            
            {
                this$1 = CategoryElement.this;
                super();
            }
                };

            case 5: // '\005'
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final CategoryElement this$1;

                    protected void setValue(boolean flag)
                        throws SAXException
                    {
                        category.isLeaf = flag;
                    }

            
            {
                this$1 = CategoryElement.this;
                super();
            }
                };
            }
_L4:
            if (s1.equals("id"))
            {
                byte0 = 0;
            }
              goto _L8
_L5:
            if (s1.equals("name"))
            {
                byte0 = 1;
            }
              goto _L8
_L7:
            if (s1.equals("localizedName"))
            {
                byte0 = 2;
            }
              goto _L8
_L2:
            if (s1.equals("parentCategory"))
            {
                byte0 = 3;
            }
              goto _L8
_L6:
            if (s1.equals("level"))
            {
                byte0 = 4;
            }
              goto _L8
            if (s1.equals("leafCategory"))
            {
                byte0 = 5;
            }
              goto _L8
        }


        public CategoryElement(com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory parentcategory)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            category = parentcategory;
        }
    }

    private class CategoryHistogramElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory category;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("category".equals(s1))
            {
                searchResponse.categoryHistogram.categories.add(category);
                return new CategoryElement(category);
            }
            if ("categoryHistogram".equals(s1))
            {
                s = new com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory();
                return new CategoryHistogramElement(s);
            }
            if ("matchCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final CategoryHistogramElement this$1;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        category.count = i;
                    }

            
            {
                this$1 = CategoryHistogramElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public CategoryHistogramElement(com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory parentcategory)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            if (searchResponse.categoryHistogram == null)
            {
                searchResponse.categoryHistogram = new EbayCategoryHistogram();
            }
            category = parentcategory;
        }
    }

    private class CurrencyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ItemCurrency currency;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("currencyId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final CurrencyElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        currency.code = s;
                    }

            
            {
                this$1 = CurrencyElement.this;
                super();
            }
                };
            }
            if ("value".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final CurrencyElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        currency.value = s;
                    }

            
            {
                this$1 = CurrencyElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public CurrencyElement(ItemCurrency itemcurrency)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            currency = itemcurrency;
        }
    }

    private class DiscountPriceInfoElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final EbaySearchListItem item;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("originalRetailPrice".equals(s1))
            {
                s = SearchServiceResponseV2.this;
                s1 = item;
                s2 = new ItemCurrency();
                s1.originalRetailPrice = s2;
                return s. new CurrencyElement(s2);
            }
            if ("pricingTreatment".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final DiscountPriceInfoElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.pricingTreatment = s;
                    }

            
            {
                this$1 = DiscountPriceInfoElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public DiscountPriceInfoElement(EbaySearchListItem ebaysearchlistitem)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            item = ebaysearchlistitem;
        }
    }

    private class DistanceElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final EbaySearchListItem item;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            byte byte0 = -1;
            s1.hashCode();
            JVM INSTR lookupswitch 2: default 32
        //                       3594628: 66
        //                       111972721: 81;
               goto _L1 _L2 _L3
_L1:
            break; /* Loop/switch isn't completed */
_L3:
            break MISSING_BLOCK_LABEL_81;
_L4:
            switch (byte0)
            {
            default:
                return super.get(s, s1, s2, attributes);

            case 0: // '\0'
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final DistanceElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.distance.unit = s;
                    }

            
            {
                this$1 = DistanceElement.this;
                super();
            }
                };

            case 1: // '\001'
                return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                    final DistanceElement this$1;

                    protected void setValue(double d)
                        throws SAXException
                    {
                        item.distance.length = d;
                    }

            
            {
                this$1 = DistanceElement.this;
                super();
            }
                };
            }
_L2:
            if (s1.equals("unit"))
            {
                byte0 = 0;
            }
              goto _L4
            if (s1.equals("value"))
            {
                byte0 = 1;
            }
              goto _L4
        }

        public DistanceElement(EbaySearchListItem ebaysearchlistitem)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            item = ebaysearchlistitem;
            item.distance = new Distance();
        }
    }

    private class EbayPlusElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final EbaySearchListItem item;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("badgeEligible".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final EbayPlusElement this$1;

                    protected void setValue(boolean flag)
                        throws SAXException
                    {
                        if (config.isEbayPlusEnabled)
                        {
                            item.isPlusEligible = flag;
                        }
                    }

            
            {
                this$1 = EbayPlusElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public EbayPlusElement(EbaySearchListItem ebaysearchlistitem)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            item = ebaysearchlistitem;
        }
    }

    private class ErrorElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final com.ebay.nautilus.domain.net.EbayResponseError.LongDetails error;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("errorId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ErrorElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        error.code = s;
                    }

            
            {
                this$1 = ErrorElement.this;
                super();
            }
                };
            }
            if ("category".equals(s1))
            {
                return new CategoryElement();
            }
            if ("severity".equals(s1))
            {
                return new SeverityElement();
            }
            if ("domain".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ErrorElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        error.domain = s;
                    }

            
            {
                this$1 = ErrorElement.this;
                super();
            }
                };
            }
            if ("subdomain".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ErrorElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        error.subdomain = s;
                    }

            
            {
                this$1 = ErrorElement.this;
                super();
            }
                };
            }
            if ("exceptionId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ErrorElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        error.exceptionId = s;
                    }

            
            {
                this$1 = ErrorElement.this;
                super();
            }
                };
            }
            if ("message".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ErrorElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        com.ebay.nautilus.domain.net.EbayResponseError.LongDetails longdetails = error;
                        error.shortMessage = s;
                        longdetails.longMessage = s;
                    }

            
            {
                this$1 = ErrorElement.this;
                super();
            }
                };
            }
            if ("parameter".equals(s1))
            {
                if (error.parameters == null)
                {
                    error.parameters = new ArrayList();
                }
                s = new com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter();
                error.parameters.add(s);
                return new ParameterElement(s, attributes);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public ErrorElement(com.ebay.nautilus.domain.net.EbayResponseError.LongDetails longdetails)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            error = longdetails;
        }
    }

    private final class ErrorElement.CategoryElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final ErrorElement this$1;

        public void text(String s)
            throws SAXException
        {
            byte byte0 = -1;
            s.hashCode();
            JVM INSTR lookupswitch 3: default 40
        //                       -1803461041: 97
        //                       -1534621073: 83
        //                       -1072845520: 69;
               goto _L1 _L2 _L3 _L4
_L1:
            break; /* Loop/switch isn't completed */
_L2:
            break MISSING_BLOCK_LABEL_97;
_L5:
            switch (byte0)
            {
            default:
                return;

            case 0: // '\0'
                error.category = 1;
                return;

            case 1: // '\001'
                error.category = 2;
                return;

            case 2: // '\002'
                error.category = 3;
                break;
            }
            break MISSING_BLOCK_LABEL_146;
_L4:
            if (s.equals("Application"))
            {
                byte0 = 0;
            }
              goto _L5
_L3:
            if (s.equals("Request"))
            {
                byte0 = 1;
            }
              goto _L5
            if (s.equals("System"))
            {
                byte0 = 2;
            }
              goto _L5
        }

        private ErrorElement.CategoryElement()
        {
            this$1 = ErrorElement.this;
            super();
        }

    }

    private final class ErrorElement.ParameterElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        private final com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter parameter;
        final ErrorElement this$1;

        public void text(String s)
            throws SAXException
        {
            parameter.value = s;
        }

        public ErrorElement.ParameterElement(com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter parameter1, Attributes attributes)
        {
            this$1 = ErrorElement.this;
            super();
            parameter = parameter1;
            int j = attributes.getLength();
            for (int i = 0; i < j; i++)
            {
                if (attributes.getLocalName(i).equals("name"))
                {
                    parameter1.name = attributes.getValue(i);
                }
            }

        }
    }

    private final class ErrorElement.SeverityElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final ErrorElement this$1;

        public void text(String s)
            throws SAXException
        {
            if ("Error".equals(s))
            {
                ackCode = -1;
                error.severity = 1;
            } else
            if ("Warning".equals(s))
            {
                error.severity = 2;
                return;
            }
        }

        private ErrorElement.SeverityElement()
        {
            this$1 = ErrorElement.this;
            super();
        }

    }

    private class ErrorMessageElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("error".equals(s1))
            {
                s = new com.ebay.nautilus.domain.net.EbayResponseError.LongDetails();
                addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                    s
                });
                return new ErrorElement(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ErrorMessageElement()
        {
            this$0 = SearchServiceResponseV2.this;
            super();
        }

    }

    private class ItemElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final EbaySearchListItem item;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            byte byte0 = -1;
            s1.hashCode();
            JVM INSTR lookupswitch 13: default 120
        //                       -1178662002: 198
        //                       -486196699: 304
        //                       -398774404: 273
        //                       -397503281: 336
        //                       110371416: 213
        //                       123954077: 384
        //                       288459765: 368
        //                       592621906: 258
        //                       725876637: 320
        //                       1355399510: 288
        //                       1369632792: 352
        //                       1423034070: 228
        //                       1561374562: 243;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L1:
            break; /* Loop/switch isn't completed */
_L7:
            break MISSING_BLOCK_LABEL_384;
_L15:
            switch (byte0)
            {
            default:
                return super.get(s, s1, s2, attributes);

            case 0: // '\0'
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final ItemElement this$1;

                    protected void setValue(long l)
                        throws SAXException
                    {
                        searchResponse.itemIds.add(Long.valueOf(l));
                        item.id = l;
                    }

            
            {
                this$1 = ItemElement.this;
                super();
            }
                };

            case 1: // '\001'
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ItemElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        if (TextUtils.isEmpty(item.title))
                        {
                            item.title = s;
                        }
                    }

            
            {
                this$1 = ItemElement.this;
                super();
            }
                };

            case 2: // '\002'
                return new ItemImageInfoElement(item);

            case 3: // '\003'
                return new SellingStatusElement(item);

            case 4: // '\004'
                return new ListingInfoElement(item);

            case 5: // '\005'
                return new ShippingInfoElement(item);

            case 6: // '\006'
                return new DiscountPriceInfoElement(item);

            case 7: // '\007'
                return new UnitPriceInfoElement(item);

            case 8: // '\b'
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ItemElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        if (config.isEEKEnabled)
                        {
                            item.eekRating = s;
                        }
                    }

            
            {
                this$1 = ItemElement.this;
                super();
            }
                };

            case 9: // '\t'
                return new EbayPlusElement(item);

            case 10: // '\n'
                return new MultiVariationListingInfo(item);

            case 11: // '\013'
                return new DistanceElement(item);

            case 12: // '\f'
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ItemElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        if (config.isItemTitleTranslationEnabled)
                        {
                            item.title = s;
                        }
                    }

            
            {
                this$1 = ItemElement.this;
                super();
            }
                };
            }
_L2:
            if (s1.equals("itemId"))
            {
                byte0 = 0;
            }
              goto _L15
_L6:
            if (s1.equals("title"))
            {
                byte0 = 1;
            }
              goto _L15
_L13:
            if (s1.equals("itemImageInfo"))
            {
                byte0 = 2;
            }
              goto _L15
_L14:
            if (s1.equals("sellingStatus"))
            {
                byte0 = 3;
            }
              goto _L15
_L9:
            if (s1.equals("listingInfo"))
            {
                byte0 = 4;
            }
              goto _L15
_L4:
            if (s1.equals("shippingInfo"))
            {
                byte0 = 5;
            }
              goto _L15
_L11:
            if (s1.equals("discountPriceInfo"))
            {
                byte0 = 6;
            }
              goto _L15
_L3:
            if (s1.equals("unitPrice"))
            {
                byte0 = 7;
            }
              goto _L15
_L10:
            if (s1.equals("eekStatus"))
            {
                byte0 = 8;
            }
              goto _L15
_L5:
            if (s1.equals("ebayPlus"))
            {
                byte0 = 9;
            }
              goto _L15
_L12:
            if (s1.equals("multiVariationListingInfo"))
            {
                byte0 = 10;
            }
              goto _L15
_L8:
            if (s1.equals("distance"))
            {
                byte0 = 11;
            }
              goto _L15
            if (s1.equals("localizedTitle"))
            {
                byte0 = 12;
            }
              goto _L15
        }

        public ItemElement(EbaySearchListItem ebaysearchlistitem)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            item = ebaysearchlistitem;
        }
    }

    private class ItemImageExtendedElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final EbaySearchListItem item;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("md5".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ItemImageExtendedElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.imageMd5Hash = s;
                    }

            
            {
                this$1 = ItemImageExtendedElement.this;
                super();
            }
                };
            }
            if ("zoomGuid".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ItemImageExtendedElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.imageZoomGuid = s;
                    }

            
            {
                this$1 = ItemImageExtendedElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public ItemImageExtendedElement(EbaySearchListItem ebaysearchlistitem)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            item = ebaysearchlistitem;
        }
    }

    private class ItemImageInfoElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final EbaySearchListItem item;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("primaryImageURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ItemImageInfoElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.imageUrl = s;
                    }

            
            {
                this$1 = ItemImageInfoElement.this;
                super();
            }
                };
            }
            if ("extended".equals(s1))
            {
                return new ItemImageExtendedElement(item);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public ItemImageInfoElement(EbaySearchListItem ebaysearchlistitem)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            item = ebaysearchlistitem;
        }
    }

    private class ItemsElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            byte byte0 = -1;
            s1.hashCode();
            JVM INSTR lookupswitch 6: default 64
        //                       -1606870765: 159
        //                       -224133017: 174
        //                       100526016: 114
        //                       1160481063: 129
        //                       1393618126: 189
        //                       1839258186: 144;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
            break; /* Loop/switch isn't completed */
_L6:
            break MISSING_BLOCK_LABEL_189;
_L8:
            switch (byte0)
            {
            default:
                return super.get(s, s1, s2, attributes);

            case 0: // '\0'
                if (searchResponse.items == null)
                {
                    searchResponse.items = new ArrayList();
                }
                return new SearchRecordElement();

            case 1: // '\001'
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final ItemsElement this$1;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        searchResponse.matchCount = i;
                    }

            
            {
                this$1 = ItemsElement.this;
                super();
            }
                };

            case 2: // '\002'
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final ItemsElement this$1;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        searchResponse.matchCountWithDupes = i;
                    }

            
            {
                this$1 = ItemsElement.this;
                super();
            }
                };

            case 3: // '\003'
                return new SearchRefinementElement();

            case 4: // '\004'
                return new RewritesElement();

            case 5: // '\005'
                return new SellerOfferDetailElement();
            }
_L4:
            if (s1.equals("items"))
            {
                byte0 = 0;
            }
              goto _L8
_L5:
            if (s1.equals("dedupedMatchCount"))
            {
                byte0 = 1;
            }
              goto _L8
_L7:
            if (s1.equals("matchCount"))
            {
                byte0 = 2;
            }
              goto _L8
_L2:
            if (s1.equals("searchRefinement"))
            {
                byte0 = 3;
            }
              goto _L8
_L3:
            if (s1.equals("rewrites"))
            {
                byte0 = 4;
            }
              goto _L8
            if (s1.equals("sellerOfferDetail"))
            {
                byte0 = 5;
            }
              goto _L8
        }

        private ItemsElement()
        {
            this$0 = SearchServiceResponseV2.this;
            super();
        }

    }

    private class LabeledAnswerElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final com.ebay.common.net.api.search.wiremodel.AnswerResponse.LabeledAnswer labeledAnswer;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("id".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final LabeledAnswerElement this$1;

                    public void setValue(long l)
                        throws SAXException
                    {
                        labeledAnswer.id = l;
                    }

            
            {
                this$1 = LabeledAnswerElement.this;
                super();
            }
                };
            }
            if ("impression".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final LabeledAnswerElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        labeledAnswer.impression = s;
                    }

            
            {
                this$1 = LabeledAnswerElement.this;
                super();
            }
                };
            }
            if ("item".equals(s1))
            {
                s = new com.ebay.common.net.api.search.wiremodel.AnswerResponse.LabeledItem();
                labeledAnswer.labeledItems.add(s);
                return new LabeledItemElement(s);
            }
            if ("label".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final LabeledAnswerElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        labeledAnswer.label = s;
                    }

            
            {
                this$1 = LabeledAnswerElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        LabeledAnswerElement(com.ebay.common.net.api.search.wiremodel.AnswerResponse.LabeledAnswer labeledanswer)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            labeledAnswer = labeledanswer;
            labeledanswer.labeledItems = new ArrayList();
        }
    }

    private class LabeledAnswersElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("answer".equals(s1))
            {
                s = new com.ebay.common.net.api.search.wiremodel.AnswerResponse.LabeledAnswer();
                answers.labeledAnswers.add(s);
                return new LabeledAnswerElement(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private LabeledAnswersElement()
        {
            this$0 = SearchServiceResponseV2.this;
            super();
        }

    }

    private class LabeledItemElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.net.api.search.wiremodel.AnswerResponse.LabeledItem labeledItem;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("id".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final LabeledItemElement this$1;

                    public void setValue(long l)
                        throws SAXException
                    {
                        labeledItem.id = l;
                    }

            
            {
                this$1 = LabeledItemElement.this;
                super();
            }
                };
            }
            if ("item".equals(s1))
            {
                s = new EbaySearchListItem();
                labeledItem.item = s;
                return new ItemElement(s);
            }
            if ("label".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final LabeledItemElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        labeledItem.label = s;
                    }

            
            {
                this$1 = LabeledItemElement.this;
                super();
            }
                };
            }
            if ("tracking".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final LabeledItemElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        labeledItem.tracking = s;
                    }

            
            {
                this$1 = LabeledItemElement.this;
                super();
            }
                };
            }
            if ("typeLabel".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final LabeledItemElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        labeledItem.typeLabel = s;
                    }

            
            {
                this$1 = LabeledItemElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        LabeledItemElement(com.ebay.common.net.api.search.wiremodel.AnswerResponse.LabeledItem labeleditem)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            labeledItem = labeleditem;
        }
    }

    private class LayoutElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("list".equals(s1))
            {
                if (layout.layoutEntries == null)
                {
                    layout.layoutEntries = new ArrayList();
                }
                s = new com.ebay.common.net.api.search.wiremodel.Layout.LayoutEntry();
                layout.layoutEntries.add(s);
                return new LayoutEntryElement(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private LayoutElement()
        {
            this$0 = SearchServiceResponseV2.this;
            super();
        }

    }

    private class LayoutEntryElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        com.ebay.common.net.api.search.wiremodel.Layout.LayoutEntry layoutEntry;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("locator".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final LayoutEntryElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        layoutEntry.locator = s;
                    }

            
            {
                this$1 = LayoutEntryElement.this;
                super();
            }
                };
            }
            if ("type".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final LayoutEntryElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        layoutEntry.type = com.ebay.common.net.api.search.wiremodel.Layout.LayoutEntryType.valueOf(s);
                    }

            
            {
                this$1 = LayoutEntryElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        LayoutEntryElement(com.ebay.common.net.api.search.wiremodel.Layout.LayoutEntry layoutentry)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            layoutEntry = layoutentry;
        }
    }

    private class ListingInfoElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final EbaySearchListItem item;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            byte byte0 = -1;
            s1.hashCode();
            JVM INSTR lookupswitch 6: default 64
        //                       -1607243192: 174
        //                       -1373294204: 129
        //                       443857148: 159
        //                       592960478: 189
        //                       606772553: 114
        //                       1887563140: 144;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
            break; /* Loop/switch isn't completed */
_L5:
            break MISSING_BLOCK_LABEL_189;
_L8:
            switch (byte0)
            {
            default:
                return super.get(s, s1, s2, attributes);

            case 0: // '\0'
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final ListingInfoElement this$1;

                    protected void setValue(boolean flag)
                        throws SAXException
                    {
                        item.bestOfferEnabled = flag;
                    }

            
            {
                this$1 = ListingInfoElement.this;
                super();
            }
                };

            case 1: // '\001'
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final ListingInfoElement this$1;

                    protected void setValue(boolean flag)
                        throws SAXException
                    {
                        item.buyItNowAvailable = flag;
                    }

            
            {
                this$1 = ListingInfoElement.this;
                super();
            }
                };

            case 2: // '\002'
                s = SearchServiceResponseV2.this;
                s1 = item;
                s2 = new ItemCurrency();
                s1.buyItNowPrice = s2;
                return s. new CurrencyElement(s2);

            case 3: // '\003'
                s = SearchServiceResponseV2.this;
                s1 = item;
                s2 = new ItemCurrency();
                s1.convertedBuyItNowPrice = s2;
                return s. new CurrencyElement(s2);

            case 4: // '\004'
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ListingInfoElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.endDate = EbayDateFormat.parseSaasDate(s);
                    }

            
            {
                this$1 = ListingInfoElement.this;
                super();
            }
                };

            case 5: // '\005'
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ListingInfoElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        byte byte0;
                        byte0 = 0;
                        item.listingType = 0;
                        s.hashCode();
                        JVM INSTR lookupswitch 6: default 76
                    //                                   -2015334886: 129
                    //                                   -1626286402: 171
                    //                                   -607502763: 157
                    //                                   1002796579: 117
                    //                                   1377925531: 185
                    //                                   1711994419: 143;
                           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
                        byte0 = -1;
                          goto _L8
_L5:
                        if (!s.equals("Auction")) goto _L1; else goto _L8
_L2:
                        if (!s.equals("AdFormat")) goto _L1; else goto _L9
_L9:
                        byte0 = 1;
                          goto _L8
_L7:
                        if (!s.equals("Classified")) goto _L1; else goto _L10
_L10:
                        byte0 = 2;
                          goto _L8
_L4:
                        if (!s.equals("FixedPrice")) goto _L1; else goto _L11
_L11:
                        byte0 = 3;
                          goto _L8
_L3:
                        if (!s.equals("AuctionWithBIN")) goto _L1; else goto _L12
_L12:
                        byte0 = 4;
                          goto _L8
_L6:
                        if (!s.equals("StoreInventory")) goto _L1; else goto _L13
_L13:
                        byte0 = 5;
_L8:
                        switch (byte0)
                        {
                        default:
                            return;

                        case 0: // '\0'
                            item.listingType = 2;
                            return;

                        case 1: // '\001'
                            item.listingType = 1;
                            return;

                        case 2: // '\002'
                            item.listingType = 4;
                            return;

                        case 3: // '\003'
                            item.listingType = 5;
                            return;

                        case 4: // '\004'
                            item.listingType = 3;
                            return;

                        case 5: // '\005'
                            item.listingType = 6;
                            break;
                        }
                        return;
                    }

            
            {
                this$1 = ListingInfoElement.this;
                super();
            }
                };
            }
_L6:
            if (s1.equals("bestOfferEnabled"))
            {
                byte0 = 0;
            }
              goto _L8
_L3:
            if (s1.equals("buyItNowAvailable"))
            {
                byte0 = 1;
            }
              goto _L8
_L7:
            if (s1.equals("buyItNowPrice"))
            {
                byte0 = 2;
            }
              goto _L8
_L4:
            if (s1.equals("buyItNowConvertedPrice"))
            {
                byte0 = 3;
            }
              goto _L8
_L2:
            if (s1.equals("endTime"))
            {
                byte0 = 4;
            }
              goto _L8
            if (s1.equals("listingType"))
            {
                byte0 = 5;
            }
              goto _L8
        }

        public ListingInfoElement(EbaySearchListItem ebaysearchlistitem)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            item = ebaysearchlistitem;
        }
    }

    private class LongArrayElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        private final List longs;
        final SearchServiceResponseV2 this$0;

        public void text(String s)
            throws SAXException
        {
            s = s.split(",");
            int j = s.length;
            for (int i = 0; i < j; i++)
            {
                String s1 = s[i];
                longs.add(Long.valueOf(Long.parseLong(s1)));
            }

        }

        LongArrayElement(List list)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            if (list == null)
            {
                throw new IllegalArgumentException("List of longs must not be null");
            } else
            {
                longs = list;
                return;
            }
        }
    }

    private class MultiVariationListingInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final EbaySearchListItem item;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            byte byte0 = -1;
            s1.hashCode();
            JVM INSTR tableswitch -1475740300 -1475740300: default 24
        //                       -1475740300 54;
               goto _L1 _L2
_L1:
            switch (byte0)
            {
            default:
                return super.get(s, s1, s2, attributes);

            case 0: // '\0'
                return new PriceRangeElement(item);
            }
_L2:
            if (s1.equals("priceRange"))
            {
                byte0 = 0;
            }
              goto _L1
        }

        public MultiVariationListingInfo(EbaySearchListItem ebaysearchlistitem)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            item = ebaysearchlistitem;
            item.isMsku = true;
        }
    }

    private class OfferMessageDetailElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("legalTextMessage".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final OfferMessageDetailElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        searchResponse.sellerOfferDetail.legalTextMessage = s;
                    }

            
            {
                this$1 = OfferMessageDetailElement.this;
                super();
            }
                };
            }
            if ("textMessage".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final OfferMessageDetailElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        searchResponse.sellerOfferDetail.textMessage = s;
                    }

            
            {
                this$1 = OfferMessageDetailElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private OfferMessageDetailElement()
        {
            this$0 = SearchServiceResponseV2.this;
            super();
        }

    }

    private class PriceRangeElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final EbaySearchListItem item;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            byte byte0 = -1;
            s1.hashCode();
            JVM INSTR lookupswitch 4: default 48
        //                       -1382007273: 90
        //                       -1273988663: 105
        //                       394189381: 120
        //                       502207991: 135;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            break; /* Loop/switch isn't completed */
_L5:
            break MISSING_BLOCK_LABEL_135;
_L6:
            switch (byte0)
            {
            default:
                return super.get(s, s1, s2, attributes);

            case 0: // '\0'
                item.minPrice = new ItemCurrency();
                return new CurrencyElement(item.minPrice);

            case 1: // '\001'
                item.convertedMinPrice = new ItemCurrency();
                return new CurrencyElement(item.convertedMinPrice);

            case 2: // '\002'
                item.maxPrice = new ItemCurrency();
                return new CurrencyElement(item.maxPrice);

            case 3: // '\003'
                item.convertedMaxPrice = new ItemCurrency();
                break;
            }
            break MISSING_BLOCK_LABEL_263;
_L2:
            if (s1.equals("minPrice"))
            {
                byte0 = 0;
            }
              goto _L6
_L3:
            if (s1.equals("convertedMinPrice"))
            {
                byte0 = 1;
            }
              goto _L6
_L4:
            if (s1.equals("maxPrice"))
            {
                byte0 = 2;
            }
              goto _L6
            if (s1.equals("convertedMaxPrice"))
            {
                byte0 = 3;
            }
              goto _L6
            return new CurrencyElement(item.convertedMaxPrice);
        }

        public PriceRangeElement(EbaySearchListItem ebaysearchlistitem)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            item = ebaysearchlistitem;
        }
    }

    private class RewriteAttributeElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        public String attributeName;
        public String attributeValue;
        private final SearchExpansion.ExpansionResult expansionResult;
        final SearchServiceResponseV2 this$0;

        private void apply()
        {
            String s;
            byte byte0;
            if (TextUtils.isEmpty(attributeName) || TextUtils.isEmpty(attributeValue))
            {
                return;
            }
            s = attributeName;
            byte0 = -1;
            s.hashCode();
            JVM INSTR lookupswitch 9: default 116
        //                       -2110750945: 298
        //                       -1483000135: 268
        //                       -1382665227: 240
        //                       -214023765: 283
        //                       -90002480: 226
        //                       704031600: 184
        //                       1566183812: 212
        //                       1972125092: 198
        //                       1972790805: 254;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
            break; /* Loop/switch isn't completed */
_L2:
            break MISSING_BLOCK_LABEL_298;
_L11:
            switch (byte0)
            {
            default:
                return;

            case 0: // '\0'
                expansionResult.isAutoRun = Boolean.parseBoolean(attributeValue);
                return;

            case 1: // '\001'
                expansionResult.recoveryType = attributeValue;
                return;

            case 2: // '\002'
            case 3: // '\003'
                expansionResult.abridgedMatchCount = Long.parseLong(attributeValue);
                return;

            case 4: // '\004'
                expansionResult.instanceName = attributeValue;
                return;

            case 5: // '\005'
                expansionResult.matchCount = Long.parseLong(attributeValue);
                return;

            case 6: // '\006'
                expansionResult.promotedToPrimary = attributeValue.equals("full");
                return;

            case 7: // '\007'
                expansionResult.metaAttributeNames = attributeValue.split(",");
                applyMetaAttributes();
                return;

            case 8: // '\b'
                expansionResult.metaAttributeValues = attributeValue.split(",");
                break;
            }
            break MISSING_BLOCK_LABEL_421;
_L7:
            if (s.equals("is_auto_run"))
            {
                byte0 = 0;
            }
              goto _L11
_L9:
            if (s.equals("recovery_type"))
            {
                byte0 = 1;
            }
              goto _L11
_L8:
            if (s.equals("abriged_match_count"))
            {
                byte0 = 2;
            }
              goto _L11
_L6:
            if (s.equals("abridged_match_count"))
            {
                byte0 = 3;
            }
              goto _L11
_L4:
            if (s.equals("instance_name"))
            {
                byte0 = 4;
            }
              goto _L11
_L10:
            if (s.equals("match_count"))
            {
                byte0 = 5;
            }
              goto _L11
_L3:
            if (s.equals("promoted_to_primary"))
            {
                byte0 = 6;
            }
              goto _L11
_L5:
            if (s.equals("meta_attribute_names"))
            {
                byte0 = 7;
            }
              goto _L11
            if (s.equals("meta_attribute_values"))
            {
                byte0 = 8;
            }
              goto _L11
            applyMetaAttributes();
            return;
        }

        private void applyMetaAttributes()
        {
_L2:
            return;
            if (expansionResult.metaAttributeNames == null || expansionResult.metaAttributeValues == null || expansionResult.metaAttributeNames.length != expansionResult.metaAttributeValues.length) goto _L2; else goto _L1
_L1:
            int i = 0;
_L4:
            if (i >= expansionResult.metaAttributeNames.length)
            {
                break; /* Loop/switch isn't completed */
            }
            String s2 = expansionResult.metaAttributeNames[i];
            String s1 = expansionResult.metaAttributeValues[i];
            String s;
            try
            {
                if (s2.equals("original_user_query"))
                {
                    break MISSING_BLOCK_LABEL_98;
                }
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                throw new IllegalStateException("Unsupported encoding: ISO-8859-1");
            }
            s = s1;
            if (!s2.equals("correction"))
            {
                break MISSING_BLOCK_LABEL_105;
            }
            s = URLDecoder.decode(s1, "UTF-8");
            expansionResult.metaAttributes.put(s2, s);
            i++;
            if (true) goto _L4; else goto _L3
_L3:
            if (true) goto _L2; else goto _L5
_L5:
        }

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RewriteAttributeElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        attributeName = s;
                        apply();
                    }

            
            {
                this$1 = RewriteAttributeElement.this;
                super();
            }
                };
            }
            if ("value".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RewriteAttributeElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        attributeValue = s;
                        apply();
                    }

            
            {
                this$1 = RewriteAttributeElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public RewriteAttributeElement(SearchExpansion.ExpansionResult expansionresult)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            expansionResult = expansionresult;
        }
    }

    private class RewriteCategoryPathElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult.Category category;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("id".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final RewriteCategoryPathElement this$1;

                    protected void setValue(long l)
                        throws SAXException
                    {
                        category.id = l;
                    }

            
            {
                this$1 = RewriteCategoryPathElement.this;
                super();
            }
                };
            }
            if ("name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RewriteCategoryPathElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        category.name = s;
                    }

            
            {
                this$1 = RewriteCategoryPathElement.this;
                super();
            }
                };
            }
            if ("localizedName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RewriteCategoryPathElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        category.localizedName = s;
                    }

            
            {
                this$1 = RewriteCategoryPathElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public RewriteCategoryPathElement(com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult.Category category1)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            category = category1;
        }
    }

    private class RewriteDescriptorElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SearchExpansion.ExpansionResult expansionResult;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            byte byte0 = -1;
            s1.hashCode();
            JVM INSTR lookupswitch 5: default 56
        //                       -1077049240: 147
        //                       3357091: 117
        //                       3575610: 162
        //                       954925063: 102
        //                       1862736958: 132;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
            break; /* Loop/switch isn't completed */
_L4:
            break MISSING_BLOCK_LABEL_162;
_L7:
            switch (byte0)
            {
            default:
                return super.get(s, s1, s2, attributes);

            case 0: // '\0'
                return new RewriteDescriptorMessageElement(expansionResult.rewriteDescriptor);

            case 1: // '\001'
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RewriteDescriptorElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        expansionResult.rewriteDescriptor.mode = SearchExpansion.ExpansionResult.RewriteMode.valueOf(s.toUpperCase(Locale.US));
                    }

            
            {
                this$1 = RewriteDescriptorElement.this;
                super();
            }
                };

            case 2: // '\002'
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RewriteDescriptorElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        if ("promoted_full".equals(s))
                        {
                            expansionResult.rewriteDescriptor.isPromoted = true;
                            return;
                        } else
                        {
                            expansionResult.rewriteDescriptor.isPromoted = false;
                            return;
                        }
                    }

            
            {
                this$1 = RewriteDescriptorElement.this;
                super();
            }
                };

            case 3: // '\003'
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final RewriteDescriptorElement this$1;

                    protected void setValue(boolean flag)
                        throws SAXException
                    {
                        expansionResult.rewriteDescriptor.isRecourseType = flag;
                    }

            
            {
                this$1 = RewriteDescriptorElement.this;
                super();
            }
                };

            case 4: // '\004'
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RewriteDescriptorElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        expansionResult.rewriteDescriptor.type = SearchExpansion.ExpansionResult.RewriteType.valueOf(s.toUpperCase(Locale.US));
                        if ("spell_check".equals(s) || "category_constraint".equals(s) || "spell_auto_correct".equals(s))
                        {
                            expansionResult.isRecoursable = true;
                        }
                    }

            
            {
                this$1 = RewriteDescriptorElement.this;
                super();
            }
                };
            }
_L5:
            if (s1.equals("message"))
            {
                byte0 = 0;
            }
              goto _L7
_L3:
            if (s1.equals("mode"))
            {
                byte0 = 1;
            }
              goto _L7
_L6:
            if (s1.equals("promotedToMainResults"))
            {
                byte0 = 2;
            }
              goto _L7
_L2:
            if (s1.equals("recourseType"))
            {
                byte0 = 3;
            }
              goto _L7
            if (s1.equals("type"))
            {
                byte0 = 4;
            }
              goto _L7
        }

        public RewriteDescriptorElement(SearchExpansion.ExpansionResult expansionresult)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            expansionResult = expansionresult;
            expansionResult.rewriteDescriptor = new SearchExpansion.ExpansionResult.RewriteDescriptor();
        }
    }

    private class RewriteDescriptorMessageElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SearchExpansion.ExpansionResult.RewriteDescriptor rewriteDescriptor;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            byte byte0 = -1;
            s1.hashCode();
            JVM INSTR lookupswitch 3: default 40
        //                       3355: 78
        //                       458736106: 108
        //                       653058492: 93;
               goto _L1 _L2 _L3 _L4
_L1:
            break; /* Loop/switch isn't completed */
_L3:
            break MISSING_BLOCK_LABEL_108;
_L5:
            switch (byte0)
            {
            default:
                return super.get(s, s1, s2, attributes);

            case 0: // '\0'
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final RewriteDescriptorMessageElement this$1;

                    public void setValue(long l)
                        throws SAXException
                    {
                        rewriteDescriptor.id = l;
                    }

            
            {
                this$1 = RewriteDescriptorMessageElement.this;
                super();
            }
                };

            case 1: // '\001'
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RewriteDescriptorMessageElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        rewriteDescriptor.userMessage = s;
                    }

            
            {
                this$1 = RewriteDescriptorMessageElement.this;
                super();
            }
                };

            case 2: // '\002'
                return new RewriteDescriptorMessageParametersElement(rewriteDescriptor);
            }
_L2:
            if (s1.equals("id"))
            {
                byte0 = 0;
            }
              goto _L5
_L4:
            if (s1.equals("userMessage"))
            {
                byte0 = 1;
            }
              goto _L5
            if (s1.equals("parameters"))
            {
                byte0 = 2;
            }
              goto _L5
        }

        public RewriteDescriptorMessageElement(SearchExpansion.ExpansionResult.RewriteDescriptor rewritedescriptor)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            rewriteDescriptor = rewritedescriptor;
        }
    }

    private class RewriteDescriptorMessageParametersElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        String parameterName;
        String parameterValue;
        private final SearchExpansion.ExpansionResult.RewriteDescriptor rewriteDescriptor;
        final SearchServiceResponseV2 this$0;

        private void apply()
        {
            if (TextUtils.isEmpty(parameterName) || TextUtils.isEmpty(parameterValue))
            {
                return;
            } else
            {
                rewriteDescriptor.parameters.put(parameterName, parameterValue);
                return;
            }
        }

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            byte byte0 = -1;
            s1.hashCode();
            JVM INSTR lookupswitch 2: default 32
        //                       3373707: 66
        //                       111972721: 81;
               goto _L1 _L2 _L3
_L1:
            break; /* Loop/switch isn't completed */
_L3:
            break MISSING_BLOCK_LABEL_81;
_L4:
            switch (byte0)
            {
            default:
                return super.get(s, s1, s2, attributes);

            case 0: // '\0'
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RewriteDescriptorMessageParametersElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        parameterName = s;
                        apply();
                    }

            
            {
                this$1 = RewriteDescriptorMessageParametersElement.this;
                super();
            }
                };

            case 1: // '\001'
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RewriteDescriptorMessageParametersElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        parameterValue = s;
                        apply();
                    }

            
            {
                this$1 = RewriteDescriptorMessageParametersElement.this;
                super();
            }
                };
            }
_L2:
            if (s1.equals("name"))
            {
                byte0 = 0;
            }
              goto _L4
            if (s1.equals("value"))
            {
                byte0 = 1;
            }
              goto _L4
        }


        public RewriteDescriptorMessageParametersElement(SearchExpansion.ExpansionResult.RewriteDescriptor rewritedescriptor)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            rewriteDescriptor = rewritedescriptor;
            if (rewriteDescriptor.parameters == null)
            {
                rewriteDescriptor.parameters = new HashMap();
            }
        }
    }

    private class RewriteDifferenceCategoryElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult.CategoryDifference categoryDifference;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("add".equals(s1))
            {
                categoryDifference.add = new ArrayList();
                return new LongArrayElement(categoryDifference.add);
            }
            if ("remove".equals(s1))
            {
                categoryDifference.remove = new ArrayList();
                return new LongArrayElement(categoryDifference.remove);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public RewriteDifferenceCategoryElement(com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult.CategoryDifference categorydifference)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            categoryDifference = categorydifference;
        }
    }

    private class RewriteDifferenceElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult.SearchRequestDifference requestDifference;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("categoryId".equals(s1))
            {
                requestDifference.categoryId = new com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult.CategoryDifference();
                return new RewriteDifferenceCategoryElement(requestDifference.categoryId);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public RewriteDifferenceElement(com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult.SearchRequestDifference searchrequestdifference)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            requestDifference = searchrequestdifference;
        }
    }

    private class RewriteElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Rewrite rewrite;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("result".equals(s1))
            {
                rewrite.rewriteResults = new ArrayList();
                s = new com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult();
                rewrite.rewriteResults.add(s);
                return new RewriteResultElement(s);
            }
            if ("type".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RewriteElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        rewrite.type = s;
                    }

            
            {
                this$1 = RewriteElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public RewriteElement(Rewrite rewrite1)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            rewrite = rewrite1;
        }
    }

    private class RewriteInfoElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult.RewriteInfo rewriteInfo;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("categoryPath".equals(s1))
            {
                if (rewriteInfo.categoryPaths == null)
                {
                    rewriteInfo.categoryPaths = new ArrayList();
                }
                s = new com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult.Category();
                rewriteInfo.categoryPaths.add(s);
                return new RewriteCategoryPathElement(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public RewriteInfoElement(com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult.RewriteInfo rewriteinfo)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            rewriteInfo = rewriteinfo;
        }
    }

    private class RewriteModifiedRequestElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult.SearchRequest modifiedRequest;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("categoryId".equals(s1))
            {
                modifiedRequest.categoryIds = new ArrayList();
                return new LongArrayElement(modifiedRequest.categoryIds);
            }
            break MISSING_BLOCK_LABEL_42;
            if (!"constraints".equals(s1) && !"excludeCategoryId".equals(s1) && !"feature".equals(s1))
            {
                if ("keyword".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RewriteModifiedRequestElement this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            modifiedRequest.keyword = s;
                        }

            
            {
                this$1 = RewriteModifiedRequestElement.this;
                super();
            }
                    };
                }
                if ("outputSelector".equals(s1) || "paginationInput".equals(s1) || "requestConfig".equals(s1) || "scope".equals(s1) || "sellerName".equals(s1) || "shipToLocation".equals(s1) || "sortOrder".equals(s1) || !"userContext".equals(s1));
            }
            return super.get(s, s1, s2, attributes);
        }

        RewriteModifiedRequestElement(com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult.SearchRequest searchrequest)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            modifiedRequest = searchrequest;
        }
    }

    private class RewriteResultElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult rewriteResult;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("attribute".equals(s1))
            {
                return new RewriteAttributeElement(rewriteResult.expansionResult);
            }
            if ("descriptor".equals(s1))
            {
                return new RewriteDescriptorElement(rewriteResult.expansionResult);
            }
            if ("info".equals(s1))
            {
                rewriteResult.rewriteInfo = new com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult.RewriteInfo();
                return new RewriteInfoElement(rewriteResult.rewriteInfo);
            }
            if ("item".equals(s1))
            {
                if (rewriteResult.items == null)
                {
                    rewriteResult.items = new ArrayList();
                }
                s = new EbaySearchListItem();
                s.isFromSaaS = true;
                rewriteResult.items.add(s);
                return new ItemElement(s);
            }
            if ("matchCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final RewriteResultElement this$1;

                    public void setValue(long l)
                        throws SAXException
                    {
                        rewriteResult.matchCount = l;
                    }

            
            {
                this$1 = RewriteResultElement.this;
                super();
            }
                };
            }
            if ("modifiedRequest".equals(s1))
            {
                rewriteResult.modifiedRequest = new com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult.SearchRequest();
                return new RewriteModifiedRequestElement(rewriteResult.modifiedRequest);
            }
            if ("requestDifference".equals(s1))
            {
                rewriteResult.requestDifference = new com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult.SearchRequestDifference();
                return new RewriteDifferenceElement(rewriteResult.requestDifference);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public RewriteResultElement(com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult rewriteresult)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            rewriteResult = rewriteresult;
            rewriteResult.expansionResult = new SearchExpansion.ExpansionResult();
        }
    }

    private class RewritesElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("rewrite".equals(s1))
            {
                if (searchResponse.rewrites == null)
                {
                    searchResponse.rewrites = new ArrayList();
                }
                s = new Rewrite();
                searchResponse.rewrites.add(s);
                return new RewriteElement(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RewritesElement()
        {
            this$0 = SearchServiceResponseV2.this;
            super();
        }

    }

    private class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("items".equals(s1))
            {
                return new ItemsElement();
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement();
            }
            if ("answers".equals(s1))
            {
                answers = new AnswerResponse();
                return new AnswersElement();
            }
            if ("layout".equals(s1))
            {
                layout = new Layout();
                return new LayoutElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement()
        {
            this$0 = SearchServiceResponseV2.this;
            super();
        }

    }

    private class ScopedAspectElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("type".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ScopedAspectElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        searchResponse.aspectHistogram.scopeType = s;
                    }

            
            {
                this$1 = ScopedAspectElement.this;
                super();
            }
                };
            }
            if ("value".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ScopedAspectElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        searchResponse.aspectHistogram.scopeValue = s;
                    }

            
            {
                this$1 = ScopedAspectElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ScopedAspectElement()
        {
            this$0 = SearchServiceResponseV2.this;
            super();
        }

    }

    private class SearchRecordElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("item".equals(s1))
            {
                s = new EbaySearchListItem();
                s.isFromSaaS = true;
                searchResponse.items.add(s);
                return new ItemElement(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private SearchRecordElement()
        {
            this$0 = SearchServiceResponseV2.this;
            super();
        }

    }

    private class SearchRefinementElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("categoryHistogram".equals(s1))
            {
                return new CategoryHistogramElement(new com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory());
            }
            if ("scopedAspectHistogram".equals(s1))
            {
                return new AspectHistogramElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private SearchRefinementElement()
        {
            this$0 = SearchServiceResponseV2.this;
            super();
        }

    }

    private class SellerOfferDetailElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("subTitle".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final SellerOfferDetailElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        searchResponse.sellerOfferDetail.subTitle = s;
                    }

            
            {
                this$1 = SellerOfferDetailElement.this;
                super();
            }
                };
            }
            if ("offerMessageDetail".equals(s1))
            {
                return new OfferMessageDetailElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public SellerOfferDetailElement()
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            searchResponse.sellerOfferDetail = new SearchServiceResponse.SellerOfferDetail();
        }
    }

    private class SellingStateElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final EbaySearchListItem item;
        final SearchServiceResponseV2 this$0;

        public void text(String s)
            throws SAXException
        {
            int i;
            boolean flag;
            flag = false;
            i = -1;
            s.hashCode();
            JVM INSTR lookupswitch 3: default 44
        //                       2582772: 111
        //                       67099290: 83
        //                       1955883814: 97;
               goto _L1 _L2 _L3 _L4
_L1:
            i;
            JVM INSTR tableswitch 0 2: default 72
        //                       0 125
        //                       1 130
        //                       2 135;
               goto _L5 _L6 _L7 _L8
_L5:
            i = ((flag) ? 1 : 0);
_L9:
            item.sellingState = i;
            return;
_L3:
            if (s.equals("Ended"))
            {
                i = 0;
            }
              goto _L1
_L4:
            if (s.equals("Active"))
            {
                i = 1;
            }
              goto _L1
_L2:
            if (s.equals("Sold"))
            {
                i = 2;
            }
              goto _L1
_L6:
            i = 5;
              goto _L9
_L7:
            i = 1;
              goto _L9
_L8:
            i = 4;
              goto _L9
        }

        public SellingStateElement(EbaySearchListItem ebaysearchlistitem)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            item = ebaysearchlistitem;
        }
    }

    private class SellingStatusElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final EbaySearchListItem item;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            byte byte0 = -1;
            s1.hashCode();
            JVM INSTR lookupswitch 4: default 48
        //                       -642369759: 135
        //                       -295659006: 105
        //                       623540754: 90
        //                       1454999376: 120;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            break; /* Loop/switch isn't completed */
_L2:
            break MISSING_BLOCK_LABEL_135;
_L6:
            switch (byte0)
            {
            default:
                return super.get(s, s1, s2, attributes);

            case 0: // '\0'
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final SellingStatusElement this$1;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        item.bidCount = i;
                    }

            
            {
                this$1 = SellingStatusElement.this;
                super();
            }
                };

            case 1: // '\001'
                item.convertedCurrentPrice = new ItemCurrency();
                return new CurrencyElement(item.convertedCurrentPrice);

            case 2: // '\002'
                item.currentPrice = new ItemCurrency();
                return new CurrencyElement(item.currentPrice);

            case 3: // '\003'
                return new SellingStateElement(item);
            }
_L4:
            if (s1.equals("bidCount"))
            {
                byte0 = 0;
            }
              goto _L6
_L3:
            if (s1.equals("convertedCurrentPrice"))
            {
                byte0 = 1;
            }
              goto _L6
_L5:
            if (s1.equals("currentPrice"))
            {
                byte0 = 2;
            }
              goto _L6
            if (s1.equals("sellingState"))
            {
                byte0 = 3;
            }
              goto _L6
        }

        public SellingStatusElement(EbaySearchListItem ebaysearchlistitem)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            item = ebaysearchlistitem;
        }
    }

    private class ShippingInfoElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final EbaySearchListItem item;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("convertedShippingCost".equals(s1))
            {
                s = SearchServiceResponseV2.this;
                s1 = item;
                s2 = new ItemCurrency();
                s1.shippingCost = s2;
                return s. new CurrencyElement(s2);
            }
            if (item.shippingCost == null && "shippingCost".equals(s1))
            {
                s = SearchServiceResponseV2.this;
                s1 = item;
                s2 = new ItemCurrency();
                s1.shippingCost = s2;
                return s. new CurrencyElement(s2);
            }
            if ("shippingType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ShippingInfoElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.shippingType = s;
                    }

            
            {
                this$1 = ShippingInfoElement.this;
                super();
            }
                };
            }
            if ("shipsToLocation".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ShippingInfoElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.shipToLocation = s;
                    }

            
            {
                this$1 = ShippingInfoElement.this;
                super();
            }
                };
            }
            if ("localMerchantOption".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ShippingInfoElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        byte byte0 = -1;
                        s.hashCode();
                        JVM INSTR lookupswitch 3: default 40
                    //                                   -287833887: 83
                    //                                   -256988515: 69
                    //                                   1000546144: 97;
                           goto _L1 _L2 _L3 _L4
_L1:
                        break; /* Loop/switch isn't completed */
_L4:
                        break MISSING_BLOCK_LABEL_97;
_L5:
                        switch (byte0)
                        {
                        default:
                            return;

                        case 0: // '\0'
                            item.isInStorePickup = true;
                            return;

                        case 1: // '\001'
                            item.isEbn = true;
                            return;

                        case 2: // '\002'
                            item.isPickupAndDropOff = true;
                            break;
                        }
                        break MISSING_BLOCK_LABEL_146;
_L3:
                        if (s.equals("StorePickup"))
                        {
                            byte0 = 0;
                        }
                          goto _L5
_L2:
                        if (s.equals("EbayNow"))
                        {
                            byte0 = 1;
                        }
                          goto _L5
                        if (s.equals("LockerPickupOptionAvailable"))
                        {
                            byte0 = 2;
                        }
                          goto _L5
                    }

            
            {
                this$1 = ShippingInfoElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public ShippingInfoElement(EbaySearchListItem ebaysearchlistitem)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            item = ebaysearchlistitem;
        }
    }

    private class UnitPriceInfoElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final EbaySearchListItem item;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("type".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final UnitPriceInfoElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.unitPriceType = s;
                    }

            
            {
                this$1 = UnitPriceInfoElement.this;
                super();
            }
                };
            }
            if ("quantity".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final UnitPriceInfoElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.unitPriceQuantity = s;
                    }

            
            {
                this$1 = UnitPriceInfoElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public UnitPriceInfoElement(EbaySearchListItem ebaysearchlistitem)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            item = ebaysearchlistitem;
        }
    }

    private class ValueHistogramElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectValue;
        final SearchServiceResponseV2 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("aspectvalue".equals(s1))
            {
                return new AspectValueElement(aspectValue);
            }
            if ("matchCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final ValueHistogramElement this$1;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        aspectValue.count = i;
                    }

            
            {
                this$1 = ValueHistogramElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public ValueHistogramElement(com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectvalue)
        {
            this$0 = SearchServiceResponseV2.this;
            super();
            aspectValue = aspectvalue;
        }
    }


    private static final Pattern MADLAN_REPLACEMENT_TEXT_PATTERN = Pattern.compile("(::\\w*::)");
    protected AnswerResponse answers;
    protected ArrayList items;
    protected Layout layout;
    public int numberOfRegularItemsSeen;
    protected SearchResponse searchResponse;

    protected SearchServiceResponseV2(SearchConfiguration searchconfiguration, long l)
    {
        super(searchconfiguration);
        searchResponse = new SearchResponse();
        searchResponse.searchedCategoryId = l;
    }

    private final String assembleMadlanDisplayString(SearchExpansion.ExpansionResult.RewriteDescriptor rewritedescriptor)
    {
        Matcher matcher = MADLAN_REPLACEMENT_TEXT_PATTERN.matcher(rewritedescriptor.userMessage);
        String s = rewritedescriptor.userMessage;
        do
        {
            String s1;
            String s2;
label0:
            {
                s1 = s;
                if (matcher.find())
                {
                    s2 = matcher.group(1);
                    s1 = null;
                    if (rewritedescriptor.parameters != null)
                    {
                        s1 = (String)rewritedescriptor.parameters.get(s2);
                    }
                    if (s1 != null)
                    {
                        break label0;
                    }
                    s1 = null;
                }
                return s1;
            }
            s = s.replace(s2, s1);
        } while (true);
    }

    private void translateWireModelToIdealModel()
    {
        if (items == null)
        {
            items = new ArrayList();
        }
        int i = 0;
        Iterator iterator = layout.layoutEntries.iterator();
label0:
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj2 = (com.ebay.common.net.api.search.wiremodel.Layout.LayoutEntry)iterator.next();
            static class _cls1
            {

                static final int $SwitchMap$com$ebay$common$net$api$search$wiremodel$Layout$LayoutEntryType[];

                static 
                {
                    $SwitchMap$com$ebay$common$net$api$search$wiremodel$Layout$LayoutEntryType = new int[com.ebay.common.net.api.search.wiremodel.Layout.LayoutEntryType.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$common$net$api$search$wiremodel$Layout$LayoutEntryType[com.ebay.common.net.api.search.wiremodel.Layout.LayoutEntryType.LISTING.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$ebay$common$net$api$search$wiremodel$Layout$LayoutEntryType[com.ebay.common.net.api.search.wiremodel.Layout.LayoutEntryType.LABELED_ITEM_ANSWER.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$ebay$common$net$api$search$wiremodel$Layout$LayoutEntryType[com.ebay.common.net.api.search.wiremodel.Layout.LayoutEntryType.REWRITE_START.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.ebay.common.net.api.search.wiremodel.Layout.LayoutEntryType[((com.ebay.common.net.api.search.wiremodel.Layout.LayoutEntry) (obj2)).type.ordinal()])
            {
            default:
                break;

            case 1: // '\001'
                Object obj = REGULAR_ITEM_PATH_PATTERN.matcher(((com.ebay.common.net.api.search.wiremodel.Layout.LayoutEntry) (obj2)).locator);
                obj2 = RERWITE_ITEM_PATH_PATTERN.matcher(((com.ebay.common.net.api.search.wiremodel.Layout.LayoutEntry) (obj2)).locator);
                int j;
                if (((Matcher) (obj)).find())
                {
                    addRewriteEndIfNeeded(items);
                    j = Integer.parseInt(((Matcher) (obj)).group(1));
                    obj = (EbaySearchListItem)searchResponse.items.get(j);
                    items.add((new RegularSrpListItem(((EbaySearchListItem) (obj)))).withTrackableRank(i));
                    j = i + 1;
                } else
                {
                    j = i;
                    if (((Matcher) (obj2)).find())
                    {
                        j = Integer.parseInt(((Matcher) (obj2)).group(1));
                        int j1 = Integer.parseInt(((Matcher) (obj2)).group(2));
                        int l1 = Integer.parseInt(((Matcher) (obj2)).group(3));
                        com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult rewriteresult = (com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult)((Rewrite)searchResponse.rewrites.get(j)).rewriteResults.get(j1);
                        items.add((new RegularSrpListItem((EbaySearchListItem)rewriteresult.items.get(l1))).withTrackableRank(i));
                        j = i + 1;
                    }
                }
                numberOfRegularItemsSeen = numberOfRegularItemsSeen + 1;
                i = j;
                continue;

            case 2: // '\002'
                Object obj1 = LABELED_ANSWER_PATH_PATTERN.matcher(((com.ebay.common.net.api.search.wiremodel.Layout.LayoutEntry) (obj2)).locator);
                if (!((Matcher) (obj1)).find())
                {
                    continue;
                }
                addRewriteEndIfNeeded(items);
                int k = Integer.parseInt(((Matcher) (obj1)).group(1));
                obj2 = (com.ebay.common.net.api.search.wiremodel.AnswerResponse.LabeledAnswer)answers.labeledAnswers.get(k);
                obj1 = ((com.ebay.common.net.api.search.wiremodel.AnswerResponse.LabeledAnswer) (obj2)).impression;
                Iterator iterator1 = ((com.ebay.common.net.api.search.wiremodel.AnswerResponse.LabeledAnswer) (obj2)).labeledItems.iterator();
                k = i;
                do
                {
                    i = k;
                    if (!iterator1.hasNext())
                    {
                        continue label0;
                    }
                    com.ebay.common.net.api.search.wiremodel.AnswerResponse.LabeledItem labeleditem = (com.ebay.common.net.api.search.wiremodel.AnswerResponse.LabeledItem)iterator1.next();
                    items.add((new LabeledAnswerSrpListItem(labeleditem.item, ((String) (obj1)), labeleditem.tracking, labeleditem.label, labeleditem.id, ((com.ebay.common.net.api.search.wiremodel.AnswerResponse.LabeledAnswer) (obj2)).id, labeleditem.typeLabel)).withTrackableRank(k));
                    obj1 = null;
                    k++;
                } while (true);

            case 3: // '\003'
                Matcher matcher = REWRITE_START_PATH_PATTERN.matcher(((com.ebay.common.net.api.search.wiremodel.Layout.LayoutEntry) (obj2)).locator);
                if (matcher.find())
                {
                    addRewriteEndIfNeeded(items);
                    int l = Integer.parseInt(matcher.group(1));
                    int k1 = Integer.parseInt(matcher.group(2));
                    Object obj3 = (Rewrite)searchResponse.rewrites.get(l);
                    if (!"query_rewrite".equals(((Rewrite) (obj3)).type))
                    {
                        com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult rewriteresult1 = (com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult)((Rewrite) (obj3)).rewriteResults.get(k1);
                        SearchExpansion.ExpansionResult expansionresult = rewriteresult1.expansionResult;
                        obj3 = KnownSearchExpansion.getTypeForNameAndPromotion(((Rewrite) (obj3)).type, expansionresult.promotedToPrimary);
                        int i1;
                        if (rewriteresult1.items == null)
                        {
                            i1 = 0;
                        } else
                        {
                            i1 = rewriteresult1.items.size();
                        }
                        if (config.isMadlanDisplayStringsEnabled && expansionresult.rewriteDescriptor != null && !TextUtils.isEmpty(expansionresult.rewriteDescriptor.userMessage))
                        {
                            expansionresult.rewriteDescriptor.displayMessage = assembleMadlanDisplayString(expansionresult.rewriteDescriptor);
                        }
                        items.add(new RewriteStartSrpListItem(((KnownSearchExpansion) (obj3)), expansionresult, i1));
                        if (KnownSearchExpansion.CROSS_BORDER.serviceExpansionName.equals(((KnownSearchExpansion) (obj3)).serviceExpansionName))
                        {
                            rewriteEndSrpListItem = new RewriteEndSrpListItem(((KnownSearchExpansion) (obj3)), expansionresult);
                        }
                    }
                }
                break;
            }
        } while (true);
    }

    public boolean areExpansionsSurfaced()
    {
        return searchResponse.searchExpansions != null && !searchResponse.searchExpansions.isEmpty();
    }

    public void fill(ArrayList arraylist)
    {
        if (items != null)
        {
            for (Iterator iterator = items.iterator(); iterator.hasNext(); arraylist.add((SrpListItem)iterator.next())) { }
        }
    }

    public AnswerResponse getAnswers()
    {
        return answers;
    }

    public EbayAspectHistogram getAspects()
    {
        return searchResponse.aspectHistogram;
    }

    public Integer getAuctionItemCount()
    {
        return Integer.valueOf(0);
    }

    public EbayCategoryHistogram getCategories()
    {
        return searchResponse.categoryHistogram;
    }

    public ArrayList getExpansions()
    {
        return searchResponse.searchExpansions;
    }

    public Integer getFixedPriceItemCount()
    {
        return Integer.valueOf(0);
    }

    public IResponseHeaderHandler getHeaderHandler()
    {
        return this;
    }

    public ArrayList getItemIds()
    {
        return searchResponse.itemIds;
    }

    public volatile List getItemIds()
    {
        return getItemIds();
    }

    public Layout getLayout()
    {
        return layout;
    }

    public ArrayList getPage()
    {
        return items;
    }

    public volatile List getPage()
    {
        return getPage();
    }

    public String getRequestCorrelationId()
    {
        return searchResponse.trackingCorrelationId;
    }

    public List getRewrites()
    {
        return searchResponse.rewrites;
    }

    public SellerOffer getSellerOffer()
    {
        if (searchResponse.sellerOfferDetail == null)
        {
            return null;
        } else
        {
            return new SellerOffer(searchResponse.sellerOfferDetail);
        }
    }

    public int getTotalCount()
    {
        return searchResponse.matchCount;
    }

    public int getTotalCountWithDupes()
    {
        return searchResponse.matchCountWithDupes;
    }

    public String getTrackingResponseHeader()
    {
        return searchResponse.trackingResponseHeader;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        ackCode = 1;
        SaxHandler.parseXml(inputstream, new RootElement(null));
        if (ackCode != -1 && layout != null && layout.layoutEntries != null)
        {
            translateWireModelToIdealModel();
        }
        if (searchResponse.categoryHistogram == null)
        {
            return;
        }
        if (!config.isUseUvccEnabled) goto _L2; else goto _L1
_L1:
        if (searchResponse.searchExpansions == null) goto _L4; else goto _L3
_L3:
        inputstream = searchResponse.searchExpansions.iterator();
_L7:
        if (!inputstream.hasNext()) goto _L2; else goto _L5
_L5:
        SearchExpansion searchexpansion = (SearchExpansion)inputstream.next();
        if (searchexpansion.expansionResult == null) goto _L7; else goto _L6
_L6:
        long l = searchexpansion.expansionResult.uvccCategoryId;
        if (l <= 0L) goto _L7; else goto _L8
_L8:
        searchResponse.searchedCategoryId = l;
_L2:
        searchResponse.categoryHistogram.reconstructWithTwoLevels(searchResponse.searchedCategoryId);
        return;
_L4:
        if (searchResponse.rewrites == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        inputstream = searchResponse.rewrites.iterator();
        Rewrite rewrite;
        do
        {
            if (!inputstream.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            rewrite = (Rewrite)inputstream.next();
        } while (!KnownSearchExpansion.QUERY_REWRITE.serviceExpansionName.equals(rewrite.type));
        inputstream = (com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult)rewrite.rewriteResults.get(0);
        if (((com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult) (inputstream)).requestDifference.categoryId != null && !((com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult) (inputstream)).requestDifference.categoryId.add.isEmpty())
        {
            long l1 = ((Long)((com.ebay.common.net.api.search.wiremodel.Rewrite.RewriteResult) (inputstream)).requestDifference.categoryId.add.get(0)).longValue();
            if (l1 > 0L)
            {
                searchResponse.searchedCategoryId = l1;
            }
        }
        if (true) goto _L2; else goto _L9
_L9:
    }

    public void readHeaders(IHeaders iheaders)
    {
        iheaders = iheaders.iterator();
label0:
        do
        {
            if (iheaders.hasNext())
            {
                Object obj = (IHeader)iheaders.next();
                String s = ((IHeader) (obj)).getName();
                if (s == null)
                {
                    continue;
                }
                if ("x-ebay-svc-tracking-data".equals(s.toLowerCase(Locale.US)))
                {
                    searchResponse.trackingResponseHeader = ((IHeader) (obj)).getValue();
                    continue;
                }
                if (!"x-ebay-c-request-id".equals(s.toLowerCase(Locale.US)))
                {
                    continue;
                }
                obj = ((IHeader) (obj)).getValue();
                if (TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    continue;
                }
                String as[] = ((String) (obj)).split(",");
                int i = 0;
                do
                {
                    if (i >= as.length)
                    {
                        continue label0;
                    }
                    if (as[i].startsWith("rci=") && as[i].length() > 4)
                    {
                        searchResponse.trackingCorrelationId = as[i].substring(4);
                        continue label0;
                    }
                    i++;
                } while (true);
            }
            return;
        } while (true);
    }

}
