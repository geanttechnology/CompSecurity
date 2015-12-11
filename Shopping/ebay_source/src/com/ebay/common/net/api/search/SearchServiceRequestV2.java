// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.text.TextUtils;
import android.util.Pair;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.PostalCodeSpecification;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceRequest, SearchConfiguration, SearchParameters, SellerOfferParameters, 
//            SearchServiceResponseV2, ISearchEventTracker

public class SearchServiceRequestV2 extends SearchServiceRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    private static final int PAGEID_SEARCHRESULTS = 0x1f3fc0;
    private final SearchConfiguration config;
    private final boolean includeAspectHistogram;
    private final boolean includeCategoryHistogram;
    private final int pageIndex;
    private final SearchParameters params;
    private final String searchTerritoryHeader;
    private final ISearchEventTracker searchTracker;
    private final int skipCount;

    public SearchServiceRequestV2(SearchParameters searchparameters, int i, ISearchEventTracker isearcheventtracker, SearchConfiguration searchconfiguration, int j)
    {
        boolean flag1 = true;
        super("search", "search", searchconfiguration.cosVersionType);
        searchTerritoryHeader = searchparameters.country.getCountryCode();
        String s = searchparameters.country.getCountryCode();
        String s3 = searchparameters.buyerPostalCode;
        String s1 = s;
        String s2 = s3;
        if (searchparameters.primaryPostalCodeSpec != null)
        {
            if (!TextUtils.isEmpty(searchparameters.primaryPostalCodeSpec.countryCode))
            {
                s = searchparameters.primaryPostalCodeSpec.countryCode;
            }
            s1 = s;
            s2 = s3;
            if (!TextUtils.isEmpty(searchparameters.primaryPostalCodeSpec.postalCode))
            {
                s2 = searchparameters.primaryPostalCodeSpec.postalCode;
                s1 = s;
            }
        }
        endUserContext = buildEndUserContext(s1, null, s2, null, true);
        trackingCorrelationId = EbayIdentity.generateRequestCorrelationId();
        if (searchparameters.country.site != null)
        {
            marketPlaceId = searchparameters.country.site.idString;
        }
        pageIndex = i;
        skipCount = j;
        boolean flag;
        if (i == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        includeAspectHistogram = flag;
        if (i == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        includeCategoryHistogram = flag;
        iafToken = searchparameters.iafToken;
        params = searchparameters;
        searchTracker = isearcheventtracker;
        config = searchconfiguration;
    }

    private void addAspectScope(XmlSerializer xmlserializer, String s, String s1, String s2)
        throws IllegalArgumentException, IllegalStateException, IOException
    {
        xmlserializer.startTag(s, "scope");
        XmlSerializerHelper.writeSimple(xmlserializer, s, "type", s1);
        XmlSerializerHelper.writeSimple(xmlserializer, s, "value", s2);
        xmlserializer.endTag(s, "scope");
    }

    private void addConstraint(XmlSerializer xmlserializer, String s, String s1, String s2)
        throws IOException
    {
        xmlserializer.startTag(s, "globalAspect");
        XmlSerializerHelper.writeSimple(xmlserializer, s, "value", s2);
        XmlSerializerHelper.writeSimple(xmlserializer, s, "constraintType", s1);
        xmlserializer.endTag(s, "globalAspect");
    }

    private void addConstraintWithMultipleParamValues(XmlSerializer xmlserializer, String s, String s1, String s2, List list)
        throws IOException
    {
        xmlserializer.startTag(s, "globalAspect");
        for (list = list.iterator(); list.hasNext(); xmlserializer.endTag(s, "paramNameValue"))
        {
            Pair pair = (Pair)list.next();
            xmlserializer.startTag(s, "paramNameValue");
            XmlSerializerHelper.writeSimple(xmlserializer, s, "name", (String)pair.first);
            XmlSerializerHelper.writeSimple(xmlserializer, s, "value", (String)pair.second);
        }

        XmlSerializerHelper.writeSimple(xmlserializer, s, "value", s2);
        XmlSerializerHelper.writeSimple(xmlserializer, s, "constraintType", s1);
        xmlserializer.endTag(s, "globalAspect");
    }

    private void addConstraintWithParamValue(XmlSerializer xmlserializer, String s, String s1, String s2, String s3, String s4)
        throws IOException
    {
        xmlserializer.startTag(s, "globalAspect");
        xmlserializer.startTag(s, "paramNameValue");
        XmlSerializerHelper.writeSimple(xmlserializer, s, "name", s1);
        XmlSerializerHelper.writeSimple(xmlserializer, s, "value", s2);
        xmlserializer.endTag(s, "paramNameValue");
        XmlSerializerHelper.writeSimple(xmlserializer, s, "value", s4);
        XmlSerializerHelper.writeSimple(xmlserializer, s, "constraintType", s3);
        xmlserializer.endTag(s, "globalAspect");
    }

    private void addConstraintWithParamValue(XmlSerializer xmlserializer, String s, String s1, String s2, String s3, ArrayList arraylist)
        throws IOException
    {
        if (arraylist.size() == 0)
        {
            return;
        }
        xmlserializer.startTag(s, "globalAspect");
        xmlserializer.startTag(s, "paramNameValue");
        XmlSerializerHelper.writeSimple(xmlserializer, s, "name", s1);
        XmlSerializerHelper.writeSimple(xmlserializer, s, "value", s2);
        xmlserializer.endTag(s, "paramNameValue");
        for (s1 = arraylist.iterator(); s1.hasNext(); XmlSerializerHelper.writeSimple(xmlserializer, s, "value", (String)s1.next())) { }
        XmlSerializerHelper.writeSimple(xmlserializer, s, "constraintType", s3);
        xmlserializer.endTag(s, "globalAspect");
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        Object obj;
        String s;
        boolean flag;
        boolean flag1;
        int i;
        if (!params.country.isSite())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (params.queryIntent == SearchParameters.QueryIntent.CountOnly)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        xmlserializer.startTag("", "universalSearchRequest");
        xmlserializer.startTag("", "searchRequest");
        if (params.allowExpansions && pageIndex == 1 && params.sellerOffer == null && params.sellerId == null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            xmlserializer.startTag("", "requestConfig");
            XmlSerializerHelper.writeSimple(xmlserializer, "", "name", "CASSINI_NULL_LOW_ENABLED");
            XmlSerializerHelper.writeSimple(xmlserializer, "", "value", "1");
            xmlserializer.endTag("", "requestConfig");
            if (config.isUseUvccEnabled)
            {
                xmlserializer.startTag("", "requestConfig");
                XmlSerializerHelper.writeSimple(xmlserializer, "", "name", "UserVisibleConstraints.Enabled");
                XmlSerializerHelper.writeSimple(xmlserializer, "", "value", "1");
                xmlserializer.endTag("", "requestConfig");
                xmlserializer.startTag("", "requestConfig");
                XmlSerializerHelper.writeSimple(xmlserializer, "", "name", "SearchServiceDictionary.WHOLE_PATH_LN_ENABLED");
                XmlSerializerHelper.writeSimple(xmlserializer, "", "value", "1");
                xmlserializer.endTag("", "requestConfig");
            }
            if (config.isSpellAutoCorrectEnabled)
            {
                xmlserializer.startTag("", "requestConfig");
                XmlSerializerHelper.writeSimple(xmlserializer, "", "name", "cassini.item.is_spell_auto_correct_enabled");
                XmlSerializerHelper.writeSimple(xmlserializer, "", "value", "1");
                xmlserializer.endTag("", "requestConfig");
            }
        }
        if (config.isPickupAndDropOffHackRequired)
        {
            xmlserializer.startTag("", "requestConfig");
            XmlSerializerHelper.writeSimple(xmlserializer, "", "name", "SearchServiceDictionary.PUDO_ENABLED");
            XmlSerializerHelper.writeSimple(xmlserializer, "", "value", "true");
            xmlserializer.endTag("", "requestConfig");
        }
        if (config.isEbayPlusEnabled)
        {
            xmlserializer.startTag("", "requestConfig");
            XmlSerializerHelper.writeSimple(xmlserializer, "", "name", "SearchServiceDictionary.EBAY_PLUS");
            XmlSerializerHelper.writeSimple(xmlserializer, "", "value", "true");
            xmlserializer.endTag("", "requestConfig");
        }
        i = skipCount;
        xmlserializer.startTag("", "paginationInput");
        XmlSerializerHelper.writeSimple(xmlserializer, "", "skipCount", String.valueOf(i));
        if (flag1)
        {
            obj = "0";
        } else
        {
            obj = String.valueOf(params.maxCountPerPage);
        }
        XmlSerializerHelper.writeSimple(xmlserializer, "", "entriesPerPage", ((String) (obj)));
        XmlSerializerHelper.writeSimple(xmlserializer, "", "pageNumber", String.valueOf(pageIndex));
        xmlserializer.endTag("", "paginationInput");
        xmlserializer.startTag("", "shipToLocation");
        XmlSerializerHelper.writeSimple(xmlserializer, "", "country", params.countryId);
        if (params.buyerPostalCode != null)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "", "postalCode", params.buyerPostalCode);
        }
        xmlserializer.endTag("", "shipToLocation");
        if (TextUtils.isEmpty(params.sortOrder))
        {
            obj = "BestMatch";
        } else
        {
            obj = params.sortOrder;
        }
        XmlSerializerHelper.writeSimple(xmlserializer, "", "sortOrder", ((String) (obj)));
        if (params.category != null && !params.category.isDefault())
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "", "categoryId", String.valueOf(params.category.id));
        }
        if (params.category1 != null && !params.category1.isDefault())
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "", "categoryId", String.valueOf(params.category1.id));
        }
        if (params.category2 != null && !params.category2.isDefault())
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "", "categoryId", String.valueOf(params.category2.id));
        }
        s = "ItemTitleSearch";
        obj = s;
        if (!params.completedListings)
        {
            obj = s;
            if (params.descriptionSearch)
            {
                obj = "ItemTitleAndDescriptionSearch";
            }
        }
        XmlSerializerHelper.writeSimple(xmlserializer, "", "scope", ((String) (obj)));
        xmlserializer.startTag("", "constraints");
        if (params.aspectHistogram != null && params.aspectHistogram.hasCheck())
        {
            xmlserializer.startTag("", "scopedAspect");
            obj = params.aspectHistogram.iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect = (com.ebay.common.model.search.EbayAspectHistogram.Aspect)((Iterator) (obj)).next();
                if (aspect.hasCheck())
                {
                    xmlserializer.startTag("", "aspect");
                    ListIterator listiterator = aspect.listIterator();
                    XmlSerializerHelper.writeSimple(xmlserializer, "", "name", aspect.serviceName);
                    do
                    {
                        if (!listiterator.hasNext())
                        {
                            break;
                        }
                        com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectvalue = (com.ebay.common.model.search.EbayAspectHistogram.AspectValue)listiterator.next();
                        if (aspectvalue.checked)
                        {
                            XmlSerializerHelper.writeSimple(xmlserializer, "", "value", aspectvalue.serviceValue);
                        }
                    } while (true);
                    xmlserializer.endTag("", "aspect");
                }
            } while (true);
            addAspectScope(xmlserializer, "", params.aspectHistogram.scopeType, params.aspectHistogram.scopeValue);
            xmlserializer.endTag("", "scopedAspect");
        }
        if (!TextUtils.isEmpty(params.condition))
        {
            String s1 = params.condition;
            obj = s1;
            if (s1.equals("Unspecified"))
            {
                obj = "non_specified";
            }
            addConstraint(xmlserializer, "", "ItemCondition", ((String) (obj)));
        }
        if (params.sinceTime != 0L)
        {
            addConstraint(xmlserializer, "", "StartTimeFrom", EbayDateUtils.formatIso8601DateTime(new Date(params.sinceTime)));
        }
        if (params.freeShipping)
        {
            addConstraint(xmlserializer, "", "FreeShippingOnly", "true");
        }
        if (params.expeditedShipping)
        {
            addConstraint(xmlserializer, "", "ExpeditedShippingType", "true");
        }
        if (params.searchLocalCountryOnly)
        {
            if (!flag)
            {
                addConstraint(xmlserializer, "", "PreferredLocation", "CurrentCountry");
            }
            addConstraint(xmlserializer, "", "LocatedIn", params.countryId);
        }
        if (params.searchOtherCountries || params.searchOtherCountriesGbh || params.sellerId != null)
        {
            addConstraint(xmlserializer, "", "PreferredLocation", "Worldwide");
            addConstraint(xmlserializer, "", "AvailableTo", params.countryId);
        }
        if (!flag && !params.searchLocalCountryOnly && !params.searchOtherCountries && !params.searchOtherCountriesGbh && params.sellerId == null)
        {
            addConstraint(xmlserializer, "", "PreferredLocation", "CurrentSite");
        }
        if (params.buyingFormat != 7 && params.buyingFormat != 0)
        {
            obj = new ArrayList();
            ArrayList arraylist;
            if (params.buyingFormat == 5)
            {
                ((ArrayList) (obj)).add("Auction");
            } else
            if (params.buyingFormat == 6)
            {
                ((ArrayList) (obj)).add("FixedPrice");
            }
            addConstraintWithParamValue(xmlserializer, "", "operator", "exclusive", "ListingType", ((ArrayList) (obj)));
        }
        if (!flag && config.isIncludeLocalItemsOnlyEnabled)
        {
            addConstraint(xmlserializer, "", "IncludeLocalOnlyItems", "true");
        }
        if (params.bestOfferOnly)
        {
            addConstraint(xmlserializer, "", "BestOfferOnly", "true");
        }
        if (params.localPickupOnly)
        {
            addConstraint(xmlserializer, "", "LocalPickupOnly", "true");
        }
        if (params.maxDistance > 0 && !TextUtils.isEmpty(params.buyerPostalCode))
        {
            addConstraintWithParamValue(xmlserializer, "", "postalCode", params.buyerPostalCode, "MaxDistance", String.valueOf(params.maxDistance));
        }
        if (params.minPrice != null)
        {
            addConstraintWithParamValue(xmlserializer, "", "currency", params.minPrice.code, "MinPrice", params.minPrice.value);
        }
        if (params.maxPrice != null)
        {
            addConstraintWithParamValue(xmlserializer, "", "currency", params.maxPrice.code, "MaxPrice", params.maxPrice.value);
        }
        if (params.completedListings)
        {
            addConstraint(xmlserializer, "", "CompletedListingsOnly", "true");
        }
        if (params.soldItemsOnly)
        {
            addConstraint(xmlserializer, "", "SoldItemsOnly", "true");
        }
        if (params.inStorePickupOnly)
        {
            addConstraint(xmlserializer, "", "LocalMerchantStorePickupOnly", "true");
        }
        if (params.ebnOnly)
        {
            addConstraint(xmlserializer, "", "EbayNowDelivery", "true");
        }
        if (params.ebayGivingWorks)
        {
            addConstraint(xmlserializer, "", "CharityOnly", "true");
        }
        if (params.returnsAccepted)
        {
            addConstraint(xmlserializer, "", "ReturnsAcceptedOnly", "true");
        }
        if (params.ebayPlusOnly)
        {
            addConstraint(xmlserializer, "", "EbayPlus", "true");
        }
        obj = params.sellerOffer;
        if (obj != null)
        {
            arraylist = new ArrayList();
            arraylist.add(new Pair("offerId", ((SellerOfferParameters) (obj)).offerId));
            arraylist.add(new Pair("offerType", ((SellerOfferParameters) (obj)).offerType));
            if (!TextUtils.isEmpty(((SellerOfferParameters) (obj)).seedCategoryId))
            {
                arraylist.add(new Pair("seedCategoryId", ((SellerOfferParameters) (obj)).seedCategoryId));
            }
            addConstraintWithMultipleParamValues(xmlserializer, "", "SellerOffer", "", arraylist);
        }
        xmlserializer.endTag("", "constraints");
        if (!TextUtils.isEmpty(params.keywords))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "", "keyword", params.keywords);
        }
        if (!TextUtils.isEmpty(params.sellerId))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "", "sellerName", params.sellerId);
        } else
        if (obj != null)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "", "sellerName", ((SellerOfferParameters) (obj)).sellerName);
        }
        xmlserializer.startTag("", "outputSelector");
        if (!flag1)
        {
            xmlserializer.startTag("", "item");
            XmlSerializerHelper.writeSimple(xmlserializer, "", "shipping", "");
            XmlSerializerHelper.writeSimple(xmlserializer, "", "distance", "");
            xmlserializer.endTag("", "item");
            xmlserializer.startTag("", "refinement");
            if (includeAspectHistogram)
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "", "aspectHistogram", "");
            }
            if (includeCategoryHistogram)
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "", "categoryHistogram", "");
            }
            xmlserializer.endTag("", "refinement");
            if (obj != null)
            {
                xmlserializer.startTag("", "sellerOffer");
                XmlSerializerHelper.writeSimple(xmlserializer, "", "sellerOffer", "");
                xmlserializer.endTag("", "sellerOffer");
            }
        }
        xmlserializer.startTag("", "rewrite");
        xmlserializer.endTag("", "rewrite");
        xmlserializer.endTag("", "outputSelector");
        xmlserializer.endTag("", "searchRequest");
        if (DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Search.B.saasV2PromotedListingsEnabled))
        {
            xmlserializer.startTag("", "answerRequest");
            xmlserializer.startTag("", "outputSelector");
            xmlserializer.startTag("", "labeledAnswerTemplate");
            XmlSerializerHelper.writeSimple(xmlserializer, "", "promotedListing", "");
            xmlserializer.endTag("", "labeledAnswerTemplate");
            xmlserializer.endTag("", "outputSelector");
            xmlserializer.endTag("", "answerRequest");
        }
        xmlserializer.endTag("", "universalSearchRequest");
    }

    public int getPageNumber()
    {
        return pageIndex;
    }

    public URL getRequestUrl()
    {
        if (config.isOAuthEndpointEnabled)
        {
            return ApiSettings.getUrl(ApiSettings.searchServiceOAuthApiV2);
        } else
        {
            return ApiSettings.getUrl(ApiSettings.searchServiceApiV2);
        }
    }

    public SearchServiceResponseV2 getResponse()
    {
        long l = 0L;
        if (params.category != null)
        {
            l = params.category.id;
        }
        return new SearchServiceResponseV2(config, l);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    protected boolean isIdempotent()
    {
        return true;
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        super.onAddHeaders(iheaders);
        if (searchTracker != null)
        {
            String s = searchTracker.generateSaaSTrackingHeader(getEbayContext(), 0x1f3fc0, iafToken);
            if (!TextUtils.isEmpty(s))
            {
                iheaders.setHeader("x-ebay-c-tracking", s);
            }
        }
    }
}
