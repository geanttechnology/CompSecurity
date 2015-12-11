// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.text.TextUtils;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.search:
//            EbayFindingApi, SearchParameters

public static final class iafToken extends ase
{

    private final boolean includeAspectHistogram;
    private final boolean includeCategoryHistogram;
    private final int pageIndex;
    public final SearchParameters params;

    private void addCategoryIfNameNeeded( , EbayCategorySummary ebaycategorysummary)
    {
        if (ebaycategorysummary != null && TextUtils.isEmpty(ebaycategorysummary.name))
        {
            if (.fillCategories == null)
            {
                .fillCategories = new HashMap();
            }
            .fillCategories.put(String.valueOf(ebaycategorysummary.id), ebaycategorysummary);
        }
    }

    private static final String getOperationName(SearchParameters searchparameters)
    {
        String s1 = "findItemsAdvanced";
        String s;
        if (searchparameters.completedListings)
        {
            s = "findCompletedItems";
        } else
        {
            s = s1;
            if (searchparameters.productId != null)
            {
                s = s1;
                if (searchparameters.productIdType != null)
                {
                    return "findItemsByProduct";
                }
            }
        }
        return s;
    }

    public void buildSearchParameterDetails(XmlSerializer xmlserializer)
        throws IOException
    {
        buildXmlRequest(xmlserializer);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        SearchParameters searchparameters = params;
        int i = pageIndex;
        String s = (new StringBuilder()).append(getOperationName()).append("Request").toString();
        Object obj;
        boolean flag;
        if (searchparameters.productId != null && searchparameters.productIdType != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        xmlserializer.setPrefix("", "http://www.ebay.com/marketplace/search/v1/services");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", s);
        if (!TextUtils.isEmpty(searchparameters.buyerPostalCode))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "buyerPostalCode", searchparameters.buyerPostalCode);
        }
        XmlSerializerHelper.writePaginationInput(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", i, searchparameters.maxCountPerPage);
        if (TextUtils.isEmpty(searchparameters.sortOrder))
        {
            obj = "BestMatch";
        } else
        {
            obj = searchparameters.sortOrder;
        }
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "sortOrder", ((String) (obj)));
        if (!flag)
        {
            if (searchparameters.aspectHistogram != null)
            {
                obj = searchparameters.aspectHistogram.iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    Object obj1 = (com.ebay.common.model.search.m)((Iterator) (obj)).next();
                    boolean flag1 = false;
                    int k = ((com.ebay.common.model.search.m) (obj1)).m();
                    for (int j = 0; j < k && !flag1; j++)
                    {
                        flag1 = ((com.ebay.common.model.search.m)((com.ebay.common.model.search.m) (obj1)).m(j)).hecked;
                    }

                    if (flag1)
                    {
                        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "aspectFilter");
                        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "aspectName", ((com.ebay.common.model.search.hecked) (obj1)).hecked);
                        obj1 = ((com.ebay.common.model.search.hecked) (obj1)).or();
                        do
                        {
                            if (!((Iterator) (obj1)).hasNext())
                            {
                                break;
                            }
                            com.ebay.common.model.search.t t = (com.ebay.common.model.search.or)((Iterator) (obj1)).next();
                            if (t.hecked)
                            {
                                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "aspectValueName", t.alue);
                            }
                        } while (true);
                        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "aspectFilter");
                    }
                } while (true);
            }
            if (searchparameters.category != null && !searchparameters.category.isDefault())
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "categoryId", String.valueOf(searchparameters.category.id));
            }
            if (searchparameters.category1 != null && !searchparameters.category1.isDefault())
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "categoryId", String.valueOf(searchparameters.category1.id));
            }
            if (searchparameters.category2 != null && !searchparameters.category2.isDefault())
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "categoryId", String.valueOf(searchparameters.category2.id));
            }
            if (!searchparameters.completedListings && searchparameters.descriptionSearch)
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "descriptionSearch", "true");
            }
        }
        if (!TextUtils.isEmpty(searchparameters.condition))
        {
            XmlSerializerHelper.writeItemFilter(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "Condition", null, null, searchparameters.condition);
        }
        if (searchparameters.soldItemsOnly)
        {
            XmlSerializerHelper.writeItemFilter(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "SoldItemsOnly", null, null, "true");
        }
        XmlSerializerHelper.writeItemFilter(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "HideDuplicateItems", null, null, "true");
        if (searchparameters.freeShipping)
        {
            XmlSerializerHelper.writeItemFilter(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "FreeShippingOnly", null, null, "true");
        }
        if (searchparameters.expeditedShipping)
        {
            XmlSerializerHelper.writeItemFilter(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "ExpeditedShippingType", null, null, "Expedited");
        }
        if (searchparameters.localPickupOnly)
        {
            XmlSerializerHelper.writeItemFilter(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "LocalPickupOnly", null, null, "true");
        }
        if (searchparameters.searchLocalCountryOnly)
        {
            XmlSerializerHelper.writeItemFilter(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "LocatedIn", null, null, searchparameters.countryId);
        }
        if (searchparameters.searchOtherCountries || searchparameters.searchOtherCountriesGbh)
        {
            XmlSerializerHelper.writeItemFilter(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "AvailableTo", null, null, searchparameters.countryId);
        }
        if (searchparameters.paypalAccepted)
        {
            XmlSerializerHelper.writeItemFilter(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "PaymentMethod", null, null, "PayPal");
        }
        if (searchparameters.buyingFormat != 7 && searchparameters.buyingFormat != 0)
        {
            ArrayList arraylist = new ArrayList();
            if ((searchparameters.buyingFormat & 1) != 0)
            {
                arraylist.add("Auction");
            }
            if ((searchparameters.buyingFormat & 2) != 0)
            {
                arraylist.add("FixedPrice");
            }
            if ((searchparameters.buyingFormat & 4) != 0)
            {
                arraylist.add("AuctionWithBIN");
            }
            XmlSerializerHelper.writeItemFilter(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "ListingType", null, null, (String[])arraylist.toArray(new String[arraylist.size()]));
        }
        if (searchparameters.bestOfferOnly)
        {
            XmlSerializerHelper.writeItemFilter(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "BestOfferOnly", null, null, "true");
        }
        if (searchparameters.maxDistance > 0 && !TextUtils.isEmpty(searchparameters.buyerPostalCode))
        {
            XmlSerializerHelper.writeItemFilter(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "MaxDistance", null, null, String.valueOf(searchparameters.maxDistance));
        }
        if (searchparameters.minPrice != null)
        {
            XmlSerializerHelper.writeItemFilter(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "MinPrice", "Currency", searchparameters.minPrice.code, searchparameters.minPrice.value);
        }
        if (searchparameters.maxPrice != null)
        {
            XmlSerializerHelper.writeItemFilter(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "MaxPrice", "Currency", searchparameters.maxPrice.code, searchparameters.maxPrice.value);
        }
        if (!TextUtils.isEmpty(searchparameters.sellerId))
        {
            XmlSerializerHelper.writeItemFilter(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "Seller", null, null, searchparameters.sellerId);
        }
        if (searchparameters.ebayGivingWorks)
        {
            XmlSerializerHelper.writeItemFilter(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "CharityOnly", null, null, "true");
        }
        if (searchparameters.returnsAccepted)
        {
            XmlSerializerHelper.writeItemFilter(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "ReturnsAcceptedOnly", null, null, "true");
        }
        if (flag)
        {
            XmlSerializerHelper.writeTagWithAttribute(xmlserializer, null, "productId", searchparameters.productId, "type", searchparameters.productIdType);
        } else
        {
            if (!TextUtils.isEmpty(searchparameters.keywords))
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "keywords", searchparameters.keywords);
            }
            if (includeCategoryHistogram)
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "outputSelector", "CategoryHistogram");
            }
            if (includeAspectHistogram)
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "outputSelector", "AspectHistogram");
            }
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "outputSelector", "UnitPriceInfo");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "outputSelector", "SellerInfo");
        }
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "outputSelector", "PictureURLLarge");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "outputSelector", "PictureURLSuperSize");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", s);
    }

    protected String getLocaleList()
    {
        Object obj1;
label0:
        {
            Object obj = null;
            String s = obj;
            if (useSoaLocaleList)
            {
                obj1 = params.country;
                s = obj;
                if (obj1 != null)
                {
                    if (!"RU".equals(((EbayCountry) (obj1)).getCountryCode()) || "en".equals(Locale.getDefault().getLanguage()))
                    {
                        break label0;
                    }
                    s = "ru-RU_RU";
                }
            }
            return s;
        }
        String s1 = ((EbayCountry) (obj1)).site.localeLanguage;
        String s2 = ((EbayCountry) (obj1)).site.localeCountry;
        obj1 = ((EbayCountry) (obj1)).getCountryCode();
        return (new StringBuilder()).append(s1).append('-').append(s2).append('_').append(((String) (obj1))).toString();
    }

    public  getResponse()
    {
          = super.getResponse();
        addCategoryIfNameNeeded(, params.category);
        addCategoryIfNameNeeded(, params.category1);
        addCategoryIfNameNeeded(, params.category2);
        return ;
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public (SearchParameters searchparameters, int i)
    {
        boolean flag1 = true;
        super(getOperationName(searchparameters));
        params = searchparameters;
        pageIndex = i;
        boolean flag;
        if (i == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        includeCategoryHistogram = flag;
        if (i == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        includeAspectHistogram = flag;
        useSoaLocaleList = searchparameters.useSoaLocaleList;
        if (!TextUtils.isEmpty(searchparameters.country.site.idString))
        {
            soaGlobalId = searchparameters.country.site.idString;
        }
        soaAppIdHeaderName = "x-ebay-soa-security-appname";
        if (searchparameters.completedListings && !TextUtils.isEmpty(searchparameters.iafToken))
        {
            iafToken = searchparameters.iafToken;
        }
    }
}
