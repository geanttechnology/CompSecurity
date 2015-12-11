// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.text.TextUtils;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.model.search.SellerOffer;
import com.ebay.common.net.api.search.idealmodel.RegularSrpListItem;
import com.ebay.common.net.api.search.idealmodel.RewriteStartSrpListItem;
import com.ebay.common.net.api.search.idealmodel.SrpListItem;
import com.ebay.common.util.EbayDateFormat;
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
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponse, ISearchTracking, SearchExpansion, KnownSearchExpansion, 
//            SearchConfiguration

public class SearchServiceResponseV1 extends SearchServiceResponse
    implements ISearchTracking, IResponseHeaderHandler
{
    private class AspectContainerElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect;
        final SearchServiceResponseV1 this$0;

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
            this$0 = SearchServiceResponseV1.this;
            super();
            aspect = aspect1;
        }
    }

    private class AspectElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect;
        final SearchServiceResponseV1 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("name".equals(s1))
            {
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
            }
            if ("displayName".equals(s1))
            {
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
            }
            if ("localizedName".equals(s1))
            {
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
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public AspectElement(com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect1)
        {
            this$0 = SearchServiceResponseV1.this;
            super();
            aspect = aspect1;
        }
    }

    private class AspectHistogramElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SearchServiceResponseV1 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("aspect".equals(s1))
            {
                s = new com.ebay.common.model.search.EbayAspectHistogram.Aspect();
                aspectHistogram.add(s);
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
            this$0 = SearchServiceResponseV1.this;
            super();
            if (aspectHistogram == null)
            {
                aspectHistogram = new EbayAspectHistogram();
                aspectHistogram.domainDisplayName = "";
                aspectHistogram.domainName = "";
            }
        }
    }

    private class AspectValueElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectValue;
        final SearchServiceResponseV1 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("name".equals(s1))
            {
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
            }
            if ("displayName".equals(s1))
            {
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
            }
            if ("localizedName".equals(s1))
            {
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
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public AspectValueElement(com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectvalue)
        {
            this$0 = SearchServiceResponseV1.this;
            super();
            aspectValue = aspectvalue;
        }
    }

    private class CategoryElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory category;
        final SearchServiceResponseV1 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("id".equals(s1))
            {
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
            }
            if ("name".equals(s1))
            {
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
            }
            if ("localizedName".equals(s1))
            {
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
            }
            if ("parentCategory".equals(s1))
            {
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
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public CategoryElement(com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory parentcategory)
        {
            this$0 = SearchServiceResponseV1.this;
            super();
            category = parentcategory;
        }
    }

    private class CategoryHistogramElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory category;
        final SearchServiceResponseV1 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("category".equals(s1))
            {
                categoryHistogram.categories.add(category);
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
            this$0 = SearchServiceResponseV1.this;
            super();
            if (categoryHistogram == null)
            {
                categoryHistogram = new EbayCategoryHistogram();
            }
            category = parentcategory;
        }
    }

    private class CurrencyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final ItemCurrency currency;
        final SearchServiceResponseV1 this$0;

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
            this$0 = SearchServiceResponseV1.this;
            super();
            currency = itemcurrency;
        }
    }

    private class DiscountPriceInfoElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbaySearchListItem item;
        final SearchServiceResponseV1 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("originalRetailPrice".equals(s1))
            {
                s = SearchServiceResponseV1.this;
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
            this$0 = SearchServiceResponseV1.this;
            super();
            item = ebaysearchlistitem;
        }
    }

    private class ErrorElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.nautilus.domain.net.EbayResponseError.LongDetails error;
        final SearchServiceResponseV1 this$0;

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
            this$0 = SearchServiceResponseV1.this;
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
            if ("Application".equals(s))
            {
                error.category = 1;
            } else
            {
                if ("Request".equals(s))
                {
                    error.category = 2;
                    return;
                }
                if ("System".equals(s))
                {
                    error.category = 3;
                    return;
                }
            }
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

        final SearchServiceResponseV1 this$0;

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
            this$0 = SearchServiceResponseV1.this;
            super();
        }

    }

    private class ExpansionAttributeElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        public String attributeName;
        public String attributeValue;
        private final SearchExpansion.ExpansionResult expansionResult;
        final SearchServiceResponseV1 this$0;

        private void apply()
        {
            if (!TextUtils.isEmpty(attributeName) && !TextUtils.isEmpty(attributeValue)) goto _L2; else goto _L1
_L1:
            return;
_L2:
            if (attributeName.equals("is_auto_run"))
            {
                expansionResult.isAutoRun = Boolean.parseBoolean(attributeValue);
                return;
            }
            if (!attributeName.equals("recovery_type"))
            {
                break; /* Loop/switch isn't completed */
            }
            expansionResult.recoveryType = attributeValue;
            if ("spell_check".equals(attributeValue) || "category_constraint".equals(attributeValue) || "spell_auto_correct".equals(attributeValue))
            {
                expansionResult.isRecoursable = true;
                return;
            }
            if (true) goto _L1; else goto _L3
_L3:
            if (attributeName.equals("abriged_match_count") || attributeName.equals("abridged_match_count"))
            {
                expansionResult.abridgedMatchCount = Long.parseLong(attributeValue);
                return;
            }
            if (attributeName.equals("instance_name"))
            {
                expansionResult.instanceName = attributeValue;
                return;
            }
            if (attributeName.equals("match_count"))
            {
                expansionResult.matchCount = Long.parseLong(attributeValue);
                return;
            }
            if (attributeName.equals("promoted_to_primary"))
            {
                expansionResult.promotedToPrimary = attributeValue.equals("full");
                return;
            }
            if (attributeName.equals("meta_attribute_names"))
            {
                expansionResult.metaAttributeNames = attributeValue.split(",");
                applyMetaAttributes();
                return;
            }
            if (attributeName.equals("meta_attribute_values"))
            {
                expansionResult.metaAttributeValues = attributeValue.split(",");
                applyMetaAttributes();
                return;
            }
            if (true) goto _L1; else goto _L4
_L4:
        }

        private void applyMetaAttributes()
        {
_L2:
            return;
            if (expansionResult.metaAttributeNames == null || expansionResult.metaAttributeValues == null || expansionResult.metaAttributeNames.length != expansionResult.metaAttributeValues.length) goto _L2; else goto _L1
_L1:
            int i = 0;
_L4:
            if (i >= expansionResult.metaAttributeNames.length) goto _L2; else goto _L3
_L3:
            String s;
            String s1;
            s1 = expansionResult.metaAttributeNames[i];
            s = expansionResult.metaAttributeValues[i];
            if (s1.equals("original_user_query"))
            {
                break MISSING_BLOCK_LABEL_98;
            }
            Object obj = s;
            if (!s1.equals("correction"))
            {
                break MISSING_BLOCK_LABEL_105;
            }
            obj = URLDecoder.decode(s, "UTF-8");
_L5:
            expansionResult.metaAttributes.put(s1, obj);
            i++;
              goto _L4
              goto _L2
            UnsupportedEncodingException unsupportedencodingexception;
            unsupportedencodingexception;
            unsupportedencodingexception = s;
              goto _L5
        }

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ExpansionAttributeElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        attributeName = s;
                        apply();
                    }

            
            {
                this$1 = ExpansionAttributeElement.this;
                super();
            }
                };
            }
            if ("value".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ExpansionAttributeElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        attributeValue = s;
                        apply();
                    }

            
            {
                this$1 = ExpansionAttributeElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public ExpansionAttributeElement(SearchExpansion.ExpansionResult expansionresult)
        {
            this$0 = SearchServiceResponseV1.this;
            super();
            expansionResult = expansionresult;
        }
    }

    private class ExpansionResultElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final SearchExpansion.ExpansionResult expansionResult;
        final SearchServiceResponseV1 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("attribute".equals(s1))
            {
                return new ExpansionAttributeElement(expansionResult);
            }
            if ("searchRecord".equals(s1))
            {
                return new SearchExpansionRecordElement(expansionResult);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public ExpansionResultElement(SearchExpansion.ExpansionResult expansionresult)
        {
            this$0 = SearchServiceResponseV1.this;
            super();
            expansionResult = expansionresult;
        }
    }

    private class ItemElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbaySearchListItem item;
        final SearchServiceResponseV1 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("itemId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final ItemElement this$1;

                    protected void setValue(long l)
                        throws SAXException
                    {
                        itemIds.add(Long.valueOf(l));
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
            }
            if ("itemImageInfo".equals(s1))
            {
                return new ItemImageInfoElement(item);
            }
            if ("sellingStatus".equals(s1))
            {
                return new SellingStatusElement(item);
            }
            if ("listingInfo".equals(s1))
            {
                return new ListingInfoElement(item);
            }
            if ("shippingInfo".equals(s1))
            {
                return new ShippingInfoElement(item);
            }
            if ("discountPriceInfo".equals(s1))
            {
                return new DiscountPriceInfoElement(item);
            }
            if ("unitPrice".equals(s1))
            {
                return new UnitPriceInfoElement(item);
            }
            if ("eekStatus".equals(s1))
            {
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
            }
            if ("localizedTitle".equals(s1))
            {
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
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public ItemElement(EbaySearchListItem ebaysearchlistitem)
        {
            this$0 = SearchServiceResponseV1.this;
            super();
            item = ebaysearchlistitem;
        }
    }

    private class ItemImageInfoElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbaySearchListItem item;
        final SearchServiceResponseV1 this$0;

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
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public ItemImageInfoElement(EbaySearchListItem ebaysearchlistitem)
        {
            this$0 = SearchServiceResponseV1.this;
            super();
            item = ebaysearchlistitem;
        }
    }

    private class ListingInfoElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbaySearchListItem item;
        final SearchServiceResponseV1 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("bestOfferEnabled".equals(s1))
            {
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
            }
            if ("buyItNowAvailable".equals(s1))
            {
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
            }
            if ("buyItNowPrice".equals(s1))
            {
                s = SearchServiceResponseV1.this;
                s1 = item;
                s2 = new ItemCurrency();
                s1.buyItNowPrice = s2;
                return s. new CurrencyElement(s2);
            }
            if ("buyItNowConvertedPrice".equals(s1))
            {
                s = SearchServiceResponseV1.this;
                s1 = item;
                s2 = new ItemCurrency();
                s1.convertedBuyItNowPrice = s2;
                return s. new CurrencyElement(s2);
            }
            if ("endTime".equals(s1))
            {
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
            }
            if ("listingType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ListingInfoElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.listingType = 0;
                        if ("Auction".equals(s))
                        {
                            item.listingType = 2;
                        } else
                        {
                            if ("AdFormat".equals(s))
                            {
                                item.listingType = 1;
                                return;
                            }
                            if ("Classified".equals(s))
                            {
                                item.listingType = 4;
                                return;
                            }
                            if ("FixedPrice".equals(s))
                            {
                                item.listingType = 5;
                                return;
                            }
                            if ("AuctionWithBIN".equals(s))
                            {
                                item.listingType = 3;
                                return;
                            }
                            if ("StoreInventory".equals(s))
                            {
                                item.listingType = 6;
                                return;
                            }
                        }
                    }

            
            {
                this$1 = ListingInfoElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public ListingInfoElement(EbaySearchListItem ebaysearchlistitem)
        {
            this$0 = SearchServiceResponseV1.this;
            super();
            item = ebaysearchlistitem;
        }
    }

    private class OfferMessageDetailElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SearchServiceResponseV1 this$0;

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
                        sellerOfferDetail.legalTextMessage = s;
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
                        sellerOfferDetail.textMessage = s;
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
            this$0 = SearchServiceResponseV1.this;
            super();
        }

    }

    private class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SearchServiceResponseV1 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("searchRecord".equals(s1))
            {
                if (rawItems == null)
                {
                    rawItems = new ArrayList();
                }
                return new SearchRecordElement();
            }
            if ("dedupedMatchCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final RootElement this$1;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        matchCount = i;
                    }

            
            {
                this$1 = RootElement.this;
                super();
            }
                };
            }
            if ("matchCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final RootElement this$1;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        matchCountWithDupes = i;
                    }

            
            {
                this$1 = RootElement.this;
                super();
            }
                };
            }
            if ("searchRefinement".equals(s1))
            {
                return new SearchRefinementElement();
            }
            if ("searchExpansion".equals(s1))
            {
                if (searchExpansions == null)
                {
                    searchExpansions = new ArrayList();
                }
                return new SearchExpansionElement(new SearchExpansion());
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement();
            }
            if ("sellerOfferDetail".equals(s1))
            {
                return new SellerOfferDetailElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement()
        {
            this$0 = SearchServiceResponseV1.this;
            super();
        }

    }

    private class ScopedAspectElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SearchServiceResponseV1 this$0;

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
                        aspectHistogram.scopeType = s;
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
                        aspectHistogram.scopeValue = s;
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
            this$0 = SearchServiceResponseV1.this;
            super();
        }

    }

    private class SearchExpansionElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final SearchExpansion searchExpansion;
        final SearchServiceResponseV1 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("expansionResult".equals(s1))
            {
                searchExpansion.expansionResult = new SearchExpansion.ExpansionResult();
                return new ExpansionResultElement(searchExpansion.expansionResult);
            }
            if ("expansionType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final SearchExpansionElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        searchExpansion.expansionType = s;
                    }

            
            {
                this$1 = SearchExpansionElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public SearchExpansionElement(SearchExpansion searchexpansion)
        {
            this$0 = SearchServiceResponseV1.this;
            super();
            searchExpansion = searchexpansion;
            searchExpansions.add(searchexpansion);
        }
    }

    private class SearchExpansionRecordElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final SearchExpansion.ExpansionResult expansionResult;
        final SearchServiceResponseV1 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("item".equals(s1))
            {
                s = new EbaySearchListItem();
                s.isFromSaaS = true;
                expansionResult.searchRecords.add(s);
                return new ItemElement(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public SearchExpansionRecordElement(SearchExpansion.ExpansionResult expansionresult)
        {
            this$0 = SearchServiceResponseV1.this;
            super();
            expansionResult = expansionresult;
        }
    }

    private class SearchRecordElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SearchServiceResponseV1 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("item".equals(s1))
            {
                s = new EbaySearchListItem();
                s.isFromSaaS = true;
                rawItems.add(s);
                return new ItemElement(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private SearchRecordElement()
        {
            this$0 = SearchServiceResponseV1.this;
            super();
        }

    }

    private class SearchRefinementElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SearchServiceResponseV1 this$0;

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
            this$0 = SearchServiceResponseV1.this;
            super();
        }

    }

    private class SellerOfferDetailElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SearchServiceResponseV1 this$0;

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
                        sellerOfferDetail.subTitle = s;
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
            this$0 = SearchServiceResponseV1.this;
            super();
            sellerOfferDetail = new SearchServiceResponse.SellerOfferDetail();
        }
    }

    private class SellingStateElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        private final EbaySearchListItem item;
        final SearchServiceResponseV1 this$0;

        public void text(String s)
            throws SAXException
        {
            int i = 0;
            if (!"Ended".equals(s)) goto _L2; else goto _L1
_L1:
            i = 5;
_L4:
            item.sellingState = i;
            return;
_L2:
            if ("Active".equals(s))
            {
                i = 1;
            } else
            if ("Sold".equals(s))
            {
                i = 4;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public SellingStateElement(EbaySearchListItem ebaysearchlistitem)
        {
            this$0 = SearchServiceResponseV1.this;
            super();
            item = ebaysearchlistitem;
        }
    }

    private class SellingStatusElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbaySearchListItem item;
        final SearchServiceResponseV1 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("bidCount".equals(s1))
            {
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
            }
            if ("convertedCurrentPrice".equals(s1))
            {
                item.convertedCurrentPrice = new ItemCurrency();
                return new CurrencyElement(item.convertedCurrentPrice);
            }
            if ("currentPrice".equals(s1))
            {
                item.currentPrice = new ItemCurrency();
                return new CurrencyElement(item.currentPrice);
            }
            if ("sellingState".equals(s1))
            {
                return new SellingStateElement(item);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public SellingStatusElement(EbaySearchListItem ebaysearchlistitem)
        {
            this$0 = SearchServiceResponseV1.this;
            super();
            item = ebaysearchlistitem;
        }
    }

    private class ShippingInfoElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbaySearchListItem item;
        final SearchServiceResponseV1 this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("convertedShippingCost".equals(s1))
            {
                s = SearchServiceResponseV1.this;
                s1 = item;
                s2 = new ItemCurrency();
                s1.shippingCost = s2;
                return s. new CurrencyElement(s2);
            }
            if (item.shippingCost == null && "shippingCost".equals(s1))
            {
                s = SearchServiceResponseV1.this;
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
                        if ("StorePickup".equals(s))
                        {
                            item.isInStorePickup = true;
                        } else
                        {
                            if ("EbayNow".equals(s))
                            {
                                item.isEbn = true;
                                return;
                            }
                            if ("LockerPickupOptionAvailable".equals(s))
                            {
                                item.isPickupAndDropOff = true;
                                return;
                            }
                        }
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
            this$0 = SearchServiceResponseV1.this;
            super();
            item = ebaysearchlistitem;
        }
    }

    private class UnitPriceInfoElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbaySearchListItem item;
        final SearchServiceResponseV1 this$0;

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
            this$0 = SearchServiceResponseV1.this;
            super();
            item = ebaysearchlistitem;
        }
    }

    private class ValueHistogramElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectValue;
        final SearchServiceResponseV1 this$0;

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
            this$0 = SearchServiceResponseV1.this;
            super();
            aspectValue = aspectvalue;
        }
    }


    private EbayAspectHistogram aspectHistogram;
    private EbayCategoryHistogram categoryHistogram;
    private final ArrayList itemIds = new ArrayList();
    private ArrayList items;
    private int matchCount;
    private int matchCountWithDupes;
    private ArrayList rawItems;
    private ArrayList searchExpansions;
    private SearchServiceResponse.SellerOfferDetail sellerOfferDetail;
    private String trackingResponseHeader;

    protected SearchServiceResponseV1(SearchConfiguration searchconfiguration)
    {
        super(searchconfiguration);
        rawItems = null;
        categoryHistogram = null;
        aspectHistogram = null;
        trackingResponseHeader = null;
        searchExpansions = null;
        sellerOfferDetail = null;
    }

    private void translateWireModelToIdealModel()
    {
        int i;
label0:
        {
            if (items == null)
            {
                items = new ArrayList();
            }
            boolean flag = false;
            i = ((flag) ? 1 : 0);
            if (searchExpansions == null)
            {
                break label0;
            }
            Object obj1 = searchExpansions.iterator();
            Object obj;
            SearchExpansion searchexpansion;
            do
            {
                i = ((flag) ? 1 : 0);
                if (!((Iterator) (obj1)).hasNext())
                {
                    break label0;
                }
                searchexpansion = (SearchExpansion)((Iterator) (obj1)).next();
                obj = searchexpansion.expansionResult;
            } while (!((SearchExpansion.ExpansionResult) (obj)).promotedToPrimary);
            obj1 = KnownSearchExpansion.getTypeForNameAndPromotion(searchexpansion.expansionType, ((SearchExpansion.ExpansionResult) (obj)).promotedToPrimary);
            if (((SearchExpansion.ExpansionResult) (obj)).searchRecords == null)
            {
                i = 0;
            } else
            {
                i = ((SearchExpansion.ExpansionResult) (obj)).searchRecords.size();
            }
            items.add(new RewriteStartSrpListItem(((KnownSearchExpansion) (obj1)), ((SearchExpansion.ExpansionResult) (obj)), i));
            if (i > 0)
            {
                EbaySearchListItem ebaysearchlistitem;
                for (obj = ((SearchExpansion.ExpansionResult) (obj)).searchRecords.iterator(); ((Iterator) (obj)).hasNext(); items.add(new RegularSrpListItem(ebaysearchlistitem)))
                {
                    ebaysearchlistitem = (EbaySearchListItem)((Iterator) (obj)).next();
                }

            }
            i = 1;
        }
        if (i == 0)
        {
            if (rawItems != null)
            {
                EbaySearchListItem ebaysearchlistitem1;
                for (Iterator iterator = rawItems.iterator(); iterator.hasNext(); items.add(new RegularSrpListItem(ebaysearchlistitem1)))
                {
                    ebaysearchlistitem1 = (EbaySearchListItem)iterator.next();
                }

            }
            if (searchExpansions != null)
            {
                Iterator iterator1 = searchExpansions.iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    Object obj3 = (SearchExpansion)iterator1.next();
                    Object obj2 = ((SearchExpansion) (obj3)).expansionResult;
                    obj3 = KnownSearchExpansion.getTypeForNameAndPromotion(((SearchExpansion) (obj3)).expansionType, ((SearchExpansion.ExpansionResult) (obj2)).promotedToPrimary);
                    int j;
                    if (((SearchExpansion.ExpansionResult) (obj2)).searchRecords == null)
                    {
                        j = 0;
                    } else
                    {
                        j = ((SearchExpansion.ExpansionResult) (obj2)).searchRecords.size();
                    }
                    items.add(new RewriteStartSrpListItem(((KnownSearchExpansion) (obj3)), ((SearchExpansion.ExpansionResult) (obj2)), j));
                    if (j > 0)
                    {
                        obj2 = ((SearchExpansion.ExpansionResult) (obj2)).searchRecords.iterator();
                        while (((Iterator) (obj2)).hasNext()) 
                        {
                            EbaySearchListItem ebaysearchlistitem2 = (EbaySearchListItem)((Iterator) (obj2)).next();
                            items.add(new RegularSrpListItem(ebaysearchlistitem2));
                        }
                    }
                } while (true);
            }
        }
    }

    public boolean areExpansionsSurfaced()
    {
        return searchExpansions != null && !searchExpansions.isEmpty();
    }

    public void fill(ArrayList arraylist)
    {
        if (items != null)
        {
            for (Iterator iterator = items.iterator(); iterator.hasNext(); arraylist.add((SrpListItem)iterator.next())) { }
        }
    }

    public EbayAspectHistogram getAspects()
    {
        return aspectHistogram;
    }

    public Integer getAuctionItemCount()
    {
        return Integer.valueOf(0);
    }

    public EbayCategoryHistogram getCategories()
    {
        return categoryHistogram;
    }

    public ArrayList getExpansions()
    {
        return searchExpansions;
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
        return itemIds;
    }

    public volatile List getItemIds()
    {
        return getItemIds();
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
        return null;
    }

    public List getRewrites()
    {
        return null;
    }

    public SellerOffer getSellerOffer()
    {
        if (sellerOfferDetail == null)
        {
            return null;
        } else
        {
            return new SellerOffer(sellerOfferDetail);
        }
    }

    public int getTotalCount()
    {
        return matchCount;
    }

    public int getTotalCountWithDupes()
    {
        return matchCountWithDupes;
    }

    public String getTrackingResponseHeader()
    {
        return trackingResponseHeader;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        ackCode = 1;
        SaxHandler.parseXml(inputstream, new RootElement());
        if (ackCode != -1)
        {
            translateWireModelToIdealModel();
        }
        if (categoryHistogram != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        inputstream = categoryHistogram.categories.listIterator();
label0:
        do
        {
            if (!inputstream.hasNext())
            {
                continue;
            }
            com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory parentcategory = (com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory)inputstream.next();
            Object obj = categoryHistogram.categories.listIterator();
            com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory parentcategory1;
            do
            {
                if (!((ListIterator) (obj)).hasNext())
                {
                    break label0;
                }
                parentcategory1 = (com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory)((ListIterator) (obj)).next();
            } while (parentcategory1.id != parentcategory.parentId);
            obj = new com.ebay.common.model.search.EbayCategoryHistogram.Category();
            obj.id = parentcategory.id;
            obj.name = parentcategory.name;
            obj.count = parentcategory.count;
            parentcategory1.children.add(obj);
            inputstream.remove();
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void readHeaders(IHeaders iheaders)
    {
        iheaders = iheaders.iterator();
        do
        {
            if (!iheaders.hasNext())
            {
                break;
            }
            IHeader iheader = (IHeader)iheaders.next();
            String s = iheader.getName();
            if (s == null || !"x-ebay-svc-tracking-data".equals(s.toLowerCase(Locale.US)))
            {
                continue;
            }
            trackingResponseHeader = iheader.getValue();
            break;
        } while (true);
    }



/*
    static EbayCategoryHistogram access$1102(SearchServiceResponseV1 searchserviceresponsev1, EbayCategoryHistogram ebaycategoryhistogram)
    {
        searchserviceresponsev1.categoryHistogram = ebaycategoryhistogram;
        return ebaycategoryhistogram;
    }

*/



/*
    static EbayAspectHistogram access$1602(SearchServiceResponseV1 searchserviceresponsev1, EbayAspectHistogram ebayaspecthistogram)
    {
        searchserviceresponsev1.aspectHistogram = ebayaspecthistogram;
        return ebayaspecthistogram;
    }

*/



/*
    static ArrayList access$1902(SearchServiceResponseV1 searchserviceresponsev1, ArrayList arraylist)
    {
        searchserviceresponsev1.searchExpansions = arraylist;
        return arraylist;
    }

*/



/*
    static SearchServiceResponse.SellerOfferDetail access$2402(SearchServiceResponseV1 searchserviceresponsev1, SearchServiceResponse.SellerOfferDetail sellerofferdetail)
    {
        searchserviceresponsev1.sellerOfferDetail = sellerofferdetail;
        return sellerofferdetail;
    }

*/


/*
    static int access$2702(SearchServiceResponseV1 searchserviceresponsev1, int i)
    {
        searchserviceresponsev1.matchCount = i;
        return i;
    }

*/


/*
    static int access$2802(SearchServiceResponseV1 searchserviceresponsev1, int i)
    {
        searchserviceresponsev1.matchCountWithDupes = i;
        return i;
    }

*/




/*
    static ArrayList access$902(SearchServiceResponseV1 searchserviceresponsev1, ArrayList arraylist)
    {
        searchserviceresponsev1.rawItems = arraylist;
        return arraylist;
    }

*/
}
