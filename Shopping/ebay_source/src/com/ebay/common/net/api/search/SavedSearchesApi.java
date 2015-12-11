// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.net.Uri;
import android.text.TextUtils;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.model.search.SavedSearch;
import com.ebay.common.net.AsyncList;
import com.ebay.common.net.EbayRequestHelper;
import com.ebay.common.net.PaginationElement;
import com.ebay.common.net.api.finding.PagedList;
import com.ebay.common.util.EbayDateFormat;
import com.ebay.common.util.EbaySettings;
import com.ebay.common.util.IncrementingInt;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.EbaySearchListItem;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.CurrencyElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchParameters

public final class SavedSearchesApi
{
    private static final class AutoFillCache
    {

        public final String autofillVersion;
        public final String baseUrl;
        public final HashMap cache = new HashMap();
        public final String siteId;

        public final String[] get(String s)
        {
            this;
            JVM INSTR monitorenter ;
            s = (String[])cache.get(s);
            this;
            JVM INSTR monitorexit ;
            return s;
            s;
            throw s;
        }

        public final URL getAutoFillUrl(String s)
        {
            Object obj;
            obj = null;
            if (TextUtils.isEmpty(s))
            {
                break MISSING_BLOCK_LABEL_471;
            }
            char c;
            int i;
            int j;
            if (baseUrl.endsWith("/"))
            {
                obj = baseUrl.substring(0, baseUrl.length() - 1);
            } else
            {
                obj = baseUrl;
            }
            j = s.length();
            i = j;
            if (j > 4)
            {
                i = 4;
            }
            j = 0;
            if (j >= i)
            {
                break MISSING_BLOCK_LABEL_442;
            }
            c = s.charAt(j);
            obj = (new StringBuilder()).append(((String) (obj))).append('/').toString();
            c;
            JVM INSTR lookupswitch 9: default 180
        //                       33: 281
        //                       39: 350
        //                       40: 373
        //                       41: 396
        //                       42: 419
        //                       45: 258
        //                       46: 304
        //                       95: 235
        //                       126: 327;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L6:
            break MISSING_BLOCK_LABEL_419;
_L9:
            break; /* Loop/switch isn't completed */
_L1:
            obj = (new StringBuilder()).append(((String) (obj))).append(Uri.encode(String.valueOf(c)).toLowerCase(Locale.getDefault()).replace('%', '_')).toString();
_L14:
            j++;
            if (true) goto _L12; else goto _L11
_L12:
            break MISSING_BLOCK_LABEL_61;
_L11:
            obj = (new StringBuilder()).append(((String) (obj))).append("_5f").toString();
            continue; /* Loop/switch isn't completed */
_L7:
            obj = (new StringBuilder()).append(((String) (obj))).append("_2d").toString();
            continue; /* Loop/switch isn't completed */
_L2:
            obj = (new StringBuilder()).append(((String) (obj))).append("_21").toString();
            continue; /* Loop/switch isn't completed */
_L8:
            obj = (new StringBuilder()).append(((String) (obj))).append("_2e").toString();
            continue; /* Loop/switch isn't completed */
_L10:
            obj = (new StringBuilder()).append(((String) (obj))).append("_7e").toString();
            continue; /* Loop/switch isn't completed */
_L3:
            obj = (new StringBuilder()).append(((String) (obj))).append("_27").toString();
            continue; /* Loop/switch isn't completed */
_L4:
            obj = (new StringBuilder()).append(((String) (obj))).append("_28").toString();
            continue; /* Loop/switch isn't completed */
_L5:
            obj = (new StringBuilder()).append(((String) (obj))).append("_29").toString();
            continue; /* Loop/switch isn't completed */
            obj = (new StringBuilder()).append(((String) (obj))).append("_2a").toString();
            if (true) goto _L14; else goto _L13
_L13:
            s = (new StringBuilder()).append(((String) (obj))).append(".js").toString();
            try
            {
                obj = new URL(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return null;
            }
            return ((URL) (obj));
        }

        public final String[] put(String s, String as[])
        {
            this;
            JVM INSTR monitorenter ;
            s = (String[])cache.put(s, as);
            this;
            JVM INSTR monitorexit ;
            return s;
            s;
            throw s;
        }

        public AutoFillCache(String s, String s1)
        {
            siteId = s;
            autofillVersion = s1;
            baseUrl = EbaySettings.getAutoFillRequest(s, s1);
        }
    }

    private static final class EbaySavedSearch extends EbaySavedSearchBase
    {

        private final SavedSearch savedSearch;

        protected int getMaxCountPerPage()
        {
            return savedSearch.searchParameters.maxCountPerPage;
        }

        protected EbaySearchRequestBase getRequest(int i)
        {
            return new EbaySavedSearchRequest(savedSearch, i);
        }

        protected void trackResponse(EbaySavedSearchResponse ebaysavedsearchresponse, int i)
        {
        }

        public EbaySavedSearch(EbayContext ebaycontext, SavedSearch savedsearch)
        {
            super(ebaycontext);
            savedSearch = savedsearch;
        }
    }

    private static abstract class EbaySavedSearchBase
        implements com.ebay.common.net.api.finding.PagedList.Query
    {

        private EbayAspectHistogram aspects;
        private EbayCategoryHistogram categories;
        private final EbayContext context;
        private ArrayList firstPage;
        private ArrayList itemIds;
        private int listCount;
        private String savedSearchQuery;
        private int totalCount;

        private EbaySavedSearchResponse sendRequestAndTrackResponse(EbaySearchRequestBase ebaysearchrequestbase, int i)
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
        {
            ebaysearchrequestbase = (EbaySavedSearchResponse)EbayRequestHelper.sendRequest(context, ebaysearchrequestbase);
            trackResponse(ebaysearchrequestbase, i);
            return ebaysearchrequestbase;
        }

        public void fill(ArrayList arraylist, int i, int j)
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
        {
            if (i < listCount) goto _L2; else goto _L1
_L1:
            return;
_L2:
            int k;
            k = j;
            if (i + j > listCount)
            {
                k = listCount - i;
            }
            if (i != 0 || firstPage == null || firstPage.size() != k)
            {
                break; /* Loop/switch isn't completed */
            }
            ArrayList arraylist1 = firstPage;
            firstPage = null;
            i = 0;
            while (i < k) 
            {
                arraylist.add(arraylist1.get(i));
                i++;
            }
            if (true) goto _L1; else goto _L3
_L3:
            EbaySearchRequestBase ebaysearchrequestbase = getRequest(i);
            i = 0;
            if (ebaysearchrequestbase instanceof EbaySearchRequest)
            {
                i = ((EbaySearchRequest)ebaysearchrequestbase).pageIndex;
            }
            sendRequestAndTrackResponse(ebaysearchrequestbase, i).fill(arraylist);
            if (arraylist.size() < k)
            {
                i = 0;
                while (i < k && arraylist.size() < k) 
                {
                    arraylist.add(arraylist.get(i));
                    i++;
                }
            }
            if (true) goto _L1; else goto _L4
_L4:
        }

        public EbayAspectHistogram getAspects()
        {
            return aspects;
        }

        public EbayCategoryHistogram getCategories()
        {
            return categories;
        }

        public ArrayList getItemIds()
        {
            return itemIds;
        }

        protected abstract int getMaxCountPerPage();

        protected abstract EbaySearchRequestBase getRequest(int i);

        public final String getSavedSearchQuery()
        {
            return savedSearchQuery;
        }

        public final int getTotalCount()
        {
            return totalCount;
        }

        public int query()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
        {
            int j = getMaxCountPerPage();
            Object obj = getRequest(0);
            int i = 0;
            if (obj instanceof EbaySearchRequest)
            {
                i = ((EbaySearchRequest)obj).pageIndex;
            }
            obj = sendRequestAndTrackResponse(((EbaySearchRequestBase) (obj)), i);
            itemIds = ((EbaySavedSearchResponse) (obj)).getItemIds();
            totalCount = ((EbaySavedSearchResponse) (obj)).getTotalCount();
            if (totalCount > j * 100)
            {
                i = j * 100;
            } else
            {
                i = totalCount;
            }
            listCount = i;
            firstPage = ((EbaySavedSearchResponse) (obj)).getPage();
            categories = ((EbaySavedSearchResponse) (obj)).getCategories();
            aspects = ((EbaySavedSearchResponse) (obj)).getAspects();
            savedSearchQuery = ((EbaySavedSearchResponse) (obj)).getSavedSearchQuery();
            return listCount;
        }

        protected abstract void trackResponse(EbaySavedSearchResponse ebaysavedsearchresponse, int i);

        protected EbaySavedSearchBase(EbayContext ebaycontext)
        {
            categories = null;
            aspects = null;
            savedSearchQuery = null;
            itemIds = new ArrayList();
            totalCount = 0;
            listCount = 0;
            firstPage = null;
            context = ebaycontext;
        }
    }

    public static final class EbaySavedSearchRequest extends EbaySearchRequestBase
    {

        private final int pageIndex;
        public final SavedSearch savedSearch;

        public void buildXmlRequest(XmlSerializer xmlserializer)
            throws IOException
        {
            SavedSearch savedsearch = savedSearch;
            int i = pageIndex;
            String s = (new StringBuilder()).append(getOperationName()).append("Request").toString();
            xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/search/v1/services");
            xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", s);
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "searchId", savedsearch.id);
            if (savedsearch.newItemsOnly && savedsearch.since > 0L)
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "startTimeFrom", EbayDateUtils.formatIso8601DateTime(new Date(savedsearch.since)));
            }
            XmlSerializerHelper.writePaginationInput(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", i, savedsearch.searchParameters.maxCountPerPage);
            xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", s);
        }

        public EbaySavedSearchRequest(SavedSearch savedsearch, int i)
        {
            super("findItemsForFavoriteSearch");
            savedSearch = savedsearch;
            pageIndex = i / savedsearch.searchParameters.maxCountPerPage + 1;
            soaAppIdHeaderName = "x-ebay-soa-security-appname";
            iafToken = savedsearch.searchParameters.iafToken;
        }
    }

    private static final class EbaySavedSearchResponse extends EbayResponse
    {

        private EbayAspectHistogram aspects;
        private EbayCategoryHistogram categories;
        Map fillCategories;
        private ArrayList itemIds;
        private ArrayList items;
        private String savedSearchQuery;
        private int totalCount;

        private final FindItemsResponse parseResponse(InputStream inputstream)
            throws SAXException, IOException
        {
            FindItemsResponse finditemsresponse = new FindItemsResponse(this);
            SaxHandler.parseXml(inputstream, finditemsresponse);
            return finditemsresponse;
        }

        public final void fill(ArrayList arraylist)
        {
            if (items != null)
            {
                for (Iterator iterator = items.iterator(); iterator.hasNext(); arraylist.add((EbaySearchListItem)iterator.next())) { }
            } else
            {
                arraylist.add(new EbaySearchListItem());
            }
        }

        public final EbayAspectHistogram getAspects()
        {
            return aspects;
        }

        public final EbayCategoryHistogram getCategories()
        {
            return categories;
        }

        public ArrayList getItemIds()
        {
            return itemIds;
        }

        public final ArrayList getPage()
        {
            return items;
        }

        public final String getSavedSearchQuery()
        {
            return savedSearchQuery;
        }

        public final int getTotalCount()
        {
            return totalCount;
        }

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            try
            {
                inputstream = parseResponse(inputstream);
                if (((FindItemsResponse) (inputstream)).paginationOutput != null)
                {
                    totalCount = ((FindItemsResponse) (inputstream)).paginationOutput.totalEntries;
                }
                if (((FindItemsResponse) (inputstream)).searchResult != null && !((FindItemsResponse) (inputstream)).searchResult.items.isEmpty())
                {
                    items = ((FindItemsResponse) (inputstream)).searchResult.items;
                    if (totalCount == 0)
                    {
                        totalCount = items.size();
                    }
                    itemIds = ((FindItemsResponse) (inputstream)).searchResult.itemIds;
                }
                if (((FindItemsResponse) (inputstream)).categories != null && !((FindItemsResponse) (inputstream)).categories.categories.isEmpty())
                {
                    categories = ((FindItemsResponse) (inputstream)).categories;
                }
                if (((FindItemsResponse) (inputstream)).aspects != null && !((FindItemsResponse) (inputstream)).aspects.isEmpty())
                {
                    aspects = ((FindItemsResponse) (inputstream)).aspects;
                }
                savedSearchQuery = ((FindItemsResponse) (inputstream)).savedSearchQuery;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(inputstream);
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(inputstream);
            }
        }

        private EbaySavedSearchResponse()
        {
            items = null;
            itemIds = new ArrayList();
            totalCount = 0;
            categories = null;
            aspects = null;
            savedSearchQuery = null;
            fillCategories = null;
        }

    }

    public static final class EbaySearchRequest extends EbaySearchRequestBase
    {

        private final boolean includeAspectHistogram;
        private final boolean includeCategoryHistogram;
        private final int pageIndex;
        public final SearchParameters params;

        private void addCategoryIfNameNeeded(EbaySavedSearchResponse ebaysavedsearchresponse, EbayCategorySummary ebaycategorysummary)
        {
            if (ebaycategorysummary != null && TextUtils.isEmpty(ebaycategorysummary.name))
            {
                if (ebaysavedsearchresponse.fillCategories == null)
                {
                    ebaysavedsearchresponse.fillCategories = new HashMap();
                }
                ebaysavedsearchresponse.fillCategories.put(String.valueOf(ebaycategorysummary.id), ebaycategorysummary);
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
                        Object obj1 = (com.ebay.common.model.search.EbayAspectHistogram.Aspect)((Iterator) (obj)).next();
                        boolean flag1 = false;
                        int k = ((com.ebay.common.model.search.EbayAspectHistogram.Aspect) (obj1)).size();
                        for (int j = 0; j < k && !flag1; j++)
                        {
                            flag1 = ((com.ebay.common.model.search.EbayAspectHistogram.AspectValue)((com.ebay.common.model.search.EbayAspectHistogram.Aspect) (obj1)).get(j)).checked;
                        }

                        if (flag1)
                        {
                            xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "aspectFilter");
                            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "aspectName", ((com.ebay.common.model.search.EbayAspectHistogram.Aspect) (obj1)).name);
                            obj1 = ((com.ebay.common.model.search.EbayAspectHistogram.Aspect) (obj1)).iterator();
                            do
                            {
                                if (!((Iterator) (obj1)).hasNext())
                                {
                                    break;
                                }
                                com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectvalue = (com.ebay.common.model.search.EbayAspectHistogram.AspectValue)((Iterator) (obj1)).next();
                                if (aspectvalue.checked)
                                {
                                    XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "aspectValueName", aspectvalue.value);
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
            if (searchparameters.ebayPlusOnly)
            {
                XmlSerializerHelper.writeItemFilter(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "EbayPlus", null, null, "true");
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

        public EbaySavedSearchResponse getResponse()
        {
            EbaySavedSearchResponse ebaysavedsearchresponse = super.getResponse();
            addCategoryIfNameNeeded(ebaysavedsearchresponse, params.category);
            addCategoryIfNameNeeded(ebaysavedsearchresponse, params.category1);
            addCategoryIfNameNeeded(ebaysavedsearchresponse, params.category2);
            return ebaysavedsearchresponse;
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }


        public EbaySearchRequest(SearchParameters searchparameters, int i, boolean flag, boolean flag1)
        {
            super(getOperationName(searchparameters));
            params = searchparameters;
            pageIndex = i / searchparameters.maxCountPerPage + 1;
            includeCategoryHistogram = flag;
            includeAspectHistogram = flag1;
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

    public static abstract class EbaySearchRequestBase extends EbaySoaRequest
        implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
    {

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            return XmlSerializerHelper.buildXmlRequest(this);
        }

        public abstract void buildXmlRequest(XmlSerializer xmlserializer)
            throws IOException;

        public URL getRequestUrl()
        {
            ApiSettings apisettings;
            if (iafToken == null)
            {
                apisettings = ApiSettings.finding20Api;
            } else
            {
                apisettings = ApiSettings.finding20ApiSecure;
            }
            return ApiSettings.getUrl(apisettings);
        }

        public EbaySavedSearchResponse getResponse()
        {
            return new EbaySavedSearchResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        protected EbaySearchRequestBase(String s)
        {
            super("FindingService", false, s);
            isConvertedToAlternateHttpFaultStatus = true;
        }
    }

    private static final class ErrorElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.nautilus.domain.net.EbayResponseError.LongDetails error = new com.ebay.nautilus.domain.net.EbayResponseError.LongDetails();

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("errorId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ErrorElement this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        error.code = s;
                    }

            
            {
                this$0 = ErrorElement.this;
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

                    final ErrorElement this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        error.domain = s;
                    }

            
            {
                this$0 = ErrorElement.this;
                super();
            }
                };
            }
            if ("subdomain".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ErrorElement this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        error.subdomain = s;
                    }

            
            {
                this$0 = ErrorElement.this;
                super();
            }
                };
            }
            if ("exceptionId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ErrorElement this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        error.exceptionId = s;
                    }

            
            {
                this$0 = ErrorElement.this;
                super();
            }
                };
            }
            if ("message".equals(s1))
            {
                return new MessageElement();
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


        public ErrorElement(EbayResponse ebayresponse, String s)
        {
            ebayresponse.addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                error
            });
        }
    }

    private final class ErrorElement.CategoryElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final ErrorElement this$0;

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
            this$0 = ErrorElement.this;
            super();
        }

    }

    private final class ErrorElement.MessageElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final ErrorElement this$0;

        public void text(String s)
            throws SAXException
        {
            com.ebay.nautilus.domain.net.EbayResponseError.LongDetails longdetails = error;
            error.shortMessage = s;
            longdetails.longMessage = s;
        }

        private ErrorElement.MessageElement()
        {
            this$0 = ErrorElement.this;
            super();
        }

    }

    private static final class ErrorElement.ParameterElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        private final com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter parameter;

        public void text(String s)
            throws SAXException
        {
            parameter.value = s;
        }

        public ErrorElement.ParameterElement(com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter parameter1, Attributes attributes)
        {
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

        final ErrorElement this$0;

        public void text(String s)
            throws SAXException
        {
            if ("Error".equals(s))
            {
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
            this$0 = ErrorElement.this;
            super();
        }

    }

    private static final class FindItemsResponse extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        public EbayAspectHistogram aspects;
        public final IncrementingInt auctionItemCount = new IncrementingInt();
        public EbayCategoryHistogram categories;
        public final IncrementingInt fixedPriceItemCount = new IncrementingInt();
        public final ArrayList itemIds = new ArrayList();
        public PaginationElement paginationOutput;
        public final EbaySavedSearchResponse response;
        public String savedSearchQuery;
        public SearchResult searchResult;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/search/v1/services".equals(s))
            {
                if ("ack".equals(s1))
                {
                    return new AckElement(response);
                }
                if ("timestamp".equals(s1))
                {
                    return new TimestampElement(response);
                }
                if ("error".equals(s1))
                {
                    return new ErrorElement(response, "http://www.ebay.com/marketplace/search/v1/services");
                }
                if ("errorMessage".equals(s1))
                {
                    return new ErrorMessageElement(response, "http://www.ebay.com/marketplace/search/v1/services");
                }
                if ("searchResult".equals(s1))
                {
                    s = new SearchResult(attributes, itemIds, auctionItemCount, fixedPriceItemCount, response);
                    searchResult = s;
                    return s;
                }
                if ("paginationOutput".equals(s1))
                {
                    s = new PaginationElement();
                    paginationOutput = s;
                    return s;
                }
                if ("categoryHistogramContainer".equals(s1))
                {
                    s = new EbayCategoryHistogram();
                    categories = s;
                    return new CategoryHistogram(s);
                }
                if ("aspectHistogramContainer".equals(s1))
                {
                    s = new EbayAspectHistogram();
                    aspects = s;
                    return new AspectHistogram(s);
                }
                if ("itemSearchURL".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final FindItemsResponse this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            savedSearchQuery = s;
                        }

            
            {
                this$0 = FindItemsResponse.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public FindItemsResponse(EbaySavedSearchResponse ebaysavedsearchresponse)
        {
            searchResult = null;
            paginationOutput = null;
            categories = null;
            aspects = null;
            savedSearchQuery = null;
            response = ebaysavedsearchresponse;
        }
    }

    static final class FindItemsResponse.AspectHistogram extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final Aspect aspect = new Aspect();
        private final EbayAspectHistogram data;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("aspect".equals(s1))
            {
                return aspect.add(data, attributes);
            }
            if ("domainName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final FindItemsResponse.AspectHistogram this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        data.domainName = s;
                    }

            
            {
                this$0 = FindItemsResponse.AspectHistogram.this;
                super();
            }
                };
            }
            if ("domainDisplayName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final FindItemsResponse.AspectHistogram this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        data.domainDisplayName = s;
                    }

            
            {
                this$0 = FindItemsResponse.AspectHistogram.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public FindItemsResponse.AspectHistogram(EbayAspectHistogram ebayaspecthistogram)
        {
            data = ebayaspecthistogram;
        }
    }

    static final class FindItemsResponse.AspectHistogram.Aspect extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private com.ebay.common.model.search.EbayAspectHistogram.Aspect a;
        private final Value value = new Value();

        FindItemsResponse.AspectHistogram.Aspect add(ArrayList arraylist, Attributes attributes)
        {
            com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect = new com.ebay.common.model.search.EbayAspectHistogram.Aspect();
            a = aspect;
            arraylist.add(aspect);
            a.name = attributes.getValue("name");
            return this;
        }

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("valueHistogram".equals(s1))
            {
                return value.add(a, attributes);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        FindItemsResponse.AspectHistogram.Aspect()
        {
            a = null;
        }
    }

    static final class FindItemsResponse.AspectHistogram.Aspect.Value extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private com.ebay.common.model.search.EbayAspectHistogram.AspectValue v;

        FindItemsResponse.AspectHistogram.Aspect.Value add(ArrayList arraylist, Attributes attributes)
        {
            com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectvalue = new com.ebay.common.model.search.EbayAspectHistogram.AspectValue();
            v = aspectvalue;
            arraylist.add(aspectvalue);
            v.value = attributes.getValue("valueName");
            return this;
        }

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("count".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final FindItemsResponse.AspectHistogram.Aspect.Value this$0;

                    public void setValue(int i)
                        throws SAXException
                    {
                        v.count = i;
                    }

            
            {
                this$0 = FindItemsResponse.AspectHistogram.Aspect.Value.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        FindItemsResponse.AspectHistogram.Aspect.Value()
        {
            v = null;
        }
    }

    static final class FindItemsResponse.CategoryHistogram extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final ParentCategoryElement child = new ParentCategoryElement();
        private final EbayCategoryHistogram data;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/search/v1/services".equals(s) && "categoryHistogram".equals(s1))
            {
                return child.add(data.categories);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public FindItemsResponse.CategoryHistogram(EbayCategoryHistogram ebaycategoryhistogram)
        {
            data = ebaycategoryhistogram;
        }
    }

    private static class FindItemsResponse.CategoryHistogram.CategoryElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        protected com.ebay.common.model.search.EbayCategoryHistogram.Category category;
        private final FieldElement field;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/search/v1/services".equals(s))
            {
                if ("categoryId".equals(s1))
                {
                    return field.getId();
                }
                if ("categoryName".equals(s1))
                {
                    return field.getName();
                }
                if ("count".equals(s1))
                {
                    return field.getCount();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private FindItemsResponse.CategoryHistogram.CategoryElement()
        {
            category = null;
            field = new FieldElement();
        }

    }

    private final class FindItemsResponse.CategoryHistogram.CategoryElement.FieldElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        private int field;
        final FindItemsResponse.CategoryHistogram.CategoryElement this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element getCount()
        {
            field = 2;
            return this;
        }

        public com.ebay.nautilus.kernel.util.SaxHandler.Element getId()
        {
            field = 0;
            return this;
        }

        public com.ebay.nautilus.kernel.util.SaxHandler.Element getName()
        {
            field = 1;
            return this;
        }

        public void text(String s)
            throws SAXException
        {
            switch (field)
            {
            default:
                return;

            case 0: // '\0'
                category.id = Long.parseLong(s);
                return;

            case 1: // '\001'
                category.name = s;
                return;

            case 2: // '\002'
                category.count = Integer.parseInt(s);
                break;
            }
        }

        private FindItemsResponse.CategoryHistogram.CategoryElement.FieldElement()
        {
            this$0 = FindItemsResponse.CategoryHistogram.CategoryElement.this;
            super();
            field = 0;
        }

    }

    private static final class FindItemsResponse.CategoryHistogram.ChildCategoryElement extends FindItemsResponse.CategoryHistogram.CategoryElement
    {

        public final com.ebay.nautilus.kernel.util.SaxHandler.Element add(ArrayList arraylist)
        {
            com.ebay.common.model.search.EbayCategoryHistogram.Category category = new com.ebay.common.model.search.EbayCategoryHistogram.Category();
            this.category = category;
            arraylist.add(category);
            return this;
        }

        private FindItemsResponse.CategoryHistogram.ChildCategoryElement()
        {
        }

    }

    private static final class FindItemsResponse.CategoryHistogram.ParentCategoryElement extends FindItemsResponse.CategoryHistogram.CategoryElement
    {

        private final FindItemsResponse.CategoryHistogram.ChildCategoryElement child;

        public final com.ebay.nautilus.kernel.util.SaxHandler.Element add(ArrayList arraylist)
        {
            com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory parentcategory = new com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory();
            category = parentcategory;
            arraylist.add(parentcategory);
            return this;
        }

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/search/v1/services".equals(s) && "childCategoryHistogram".equals(s1))
            {
                return child.add(((com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory)category).children);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private FindItemsResponse.CategoryHistogram.ParentCategoryElement()
        {
            child = new FindItemsResponse.CategoryHistogram.ChildCategoryElement();
        }

    }

    static final class FindItemsResponse.SearchResult extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        public final IncrementingInt auctionItemCount;
        public int count;
        public final IncrementingInt fixedPriceItemCount;
        public final ArrayList itemIds;
        public final ArrayList items;
        public final EbaySavedSearchResponse response;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if (!"http://www.ebay.com/marketplace/search/v1/services".equals(s) || !"item".equals(s1))
            {
                throw new SAXNotRecognizedException(s1);
            } else
            {
                s = new EbaySearchListItem();
                items.add(s);
                return new Item(s, itemIds, auctionItemCount, fixedPriceItemCount, response);
            }
        }

        public FindItemsResponse.SearchResult(Attributes attributes, ArrayList arraylist, IncrementingInt incrementingint, IncrementingInt incrementingint1, EbaySavedSearchResponse ebaysavedsearchresponse)
        {
            count = -1;
            int j = attributes.getLength();
            for (int i = 0; i < j; i++)
            {
                if ("count".equals(attributes.getLocalName(i)))
                {
                    count = Integer.parseInt(attributes.getValue(i));
                }
            }

            if (count > 0)
            {
                attributes = new ArrayList(count);
            } else
            {
                attributes = new ArrayList();
            }
            items = attributes;
            itemIds = arraylist;
            auctionItemCount = incrementingint;
            fixedPriceItemCount = incrementingint1;
            response = ebaysavedsearchresponse;
        }
    }

    static final class FindItemsResponse.SearchResult.Item extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final IncrementingInt auctionItemCount;
        private final IncrementingInt fixedPriceItemCount;
        private final EbaySearchListItem item;
        private final ArrayList itemIds;
        public final EbaySavedSearchResponse response;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/search/v1/services".equals(s))
            {
                if ("itemId".equals(s1))
                {
                    return new ItemId(item, itemIds);
                }
                if ("title".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final FindItemsResponse.SearchResult.Item this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            item.title = s;
                        }

            
            {
                this$0 = FindItemsResponse.SearchResult.Item.this;
                super();
            }
                    };
                }
                if ("pictureURLLarge".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final FindItemsResponse.SearchResult.Item this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            item.masterImageUrl = s;
                        }

            
            {
                this$0 = FindItemsResponse.SearchResult.Item.this;
                super();
            }
                    };
                }
                if ("pictureURLSuperSize".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final FindItemsResponse.SearchResult.Item this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            item.superSizeImageUrl = s;
                        }

            
            {
                this$0 = FindItemsResponse.SearchResult.Item.this;
                super();
            }
                    };
                }
                if ("galleryURL".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final FindItemsResponse.SearchResult.Item this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            item.imageUrl = s;
                        }

            
            {
                this$0 = FindItemsResponse.SearchResult.Item.this;
                super();
            }
                    };
                }
                if ("sellingStatus".equals(s1))
                {
                    return new SellingStatus(item);
                }
                if ("listingInfo".equals(s1))
                {
                    return new ListingInfo(item, auctionItemCount, fixedPriceItemCount);
                }
                if ("shippingInfo".equals(s1))
                {
                    return new ShippingInfo(item);
                }
                if ("discountPriceInfo".equals(s1))
                {
                    return new DiscountPriceInfo(item);
                }
                if ("unitPrice".equals(s1))
                {
                    return new UnitPrice(item);
                }
                if ("primaryCategory".equals(s1) && response.fillCategories != null)
                {
                    return new PrimaryCategory();
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        protected FindItemsResponse.SearchResult.Item(EbaySearchListItem ebaysearchlistitem, ArrayList arraylist, IncrementingInt incrementingint, IncrementingInt incrementingint1, EbaySavedSearchResponse ebaysavedsearchresponse)
        {
            item = ebaysearchlistitem;
            itemIds = arraylist;
            auctionItemCount = incrementingint;
            fixedPriceItemCount = incrementingint1;
            response = ebaysavedsearchresponse;
        }
    }

    static final class FindItemsResponse.SearchResult.Item.DiscountPriceInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbaySearchListItem item;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("originalRetailPrice".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.originalRetailPrice = s1;
                return new CurrencyElement(s1, "currencyId", attributes);
            }
            if ("pricingTreatment".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final FindItemsResponse.SearchResult.Item.DiscountPriceInfo this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        item.pricingTreatment = s;
                    }

            
            {
                this$0 = FindItemsResponse.SearchResult.Item.DiscountPriceInfo.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        protected FindItemsResponse.SearchResult.Item.DiscountPriceInfo(EbaySearchListItem ebaysearchlistitem)
        {
            item = ebaysearchlistitem;
        }
    }

    static final class FindItemsResponse.SearchResult.Item.ItemId extends com.ebay.nautilus.kernel.util.SaxHandler.LongElement
    {

        private final EbaySearchListItem item;
        private final ArrayList itemIds;

        protected void setValue(long l)
            throws SAXException
        {
            item.id = l;
            itemIds.add(Long.valueOf(l));
        }

        public FindItemsResponse.SearchResult.Item.ItemId(EbaySearchListItem ebaysearchlistitem, ArrayList arraylist)
        {
            item = ebaysearchlistitem;
            itemIds = arraylist;
        }
    }

    static final class FindItemsResponse.SearchResult.Item.ListingInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final IncrementingInt auctionItemCount;
        private final IncrementingInt fixedPriceItemCount;
        private final EbaySearchListItem item;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/search/v1/services".equals(s))
            {
                if ("bestOfferEnabled".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final FindItemsResponse.SearchResult.Item.ListingInfo this$0;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            item.bestOfferEnabled = flag;
                        }

            
            {
                this$0 = FindItemsResponse.SearchResult.Item.ListingInfo.this;
                super();
            }
                    };
                }
                if ("buyItNowAvailable".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final FindItemsResponse.SearchResult.Item.ListingInfo this$0;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            item.buyItNowAvailable = flag;
                        }

            
            {
                this$0 = FindItemsResponse.SearchResult.Item.ListingInfo.this;
                super();
            }
                    };
                }
                if ("buyItNowPrice".equals(s1))
                {
                    s = item;
                    s1 = new ItemCurrency();
                    s.buyItNowPrice = s1;
                    return new CurrencyElement(s1, "currencyId", attributes);
                }
                if ("convertedBuyItNowPrice".equals(s1))
                {
                    s = item;
                    s1 = new ItemCurrency();
                    s.convertedBuyItNowPrice = s1;
                    return new CurrencyElement(s1, "currencyId", attributes);
                }
                if ("endTime".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final FindItemsResponse.SearchResult.Item.ListingInfo this$0;

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
                this$0 = FindItemsResponse.SearchResult.Item.ListingInfo.this;
                super();
            }
                    };
                }
                if ("gift".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final FindItemsResponse.SearchResult.Item.ListingInfo this$0;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            item.gift = flag;
                        }

            
            {
                this$0 = FindItemsResponse.SearchResult.Item.ListingInfo.this;
                super();
            }
                    };
                }
                if ("listingType".equals(s1))
                {
                    return new ListingType(item, auctionItemCount, fixedPriceItemCount);
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        protected FindItemsResponse.SearchResult.Item.ListingInfo(EbaySearchListItem ebaysearchlistitem, IncrementingInt incrementingint, IncrementingInt incrementingint1)
        {
            item = ebaysearchlistitem;
            auctionItemCount = incrementingint;
            fixedPriceItemCount = incrementingint1;
        }
    }

    static final class FindItemsResponse.SearchResult.Item.ListingInfo.ListingType extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        private final IncrementingInt auctionItemCount;
        private final IncrementingInt fixedPriceItemCount;
        private final EbaySearchListItem item;

        public void text(String s)
            throws SAXException
        {
            item.listingType = 0;
            s.length();
            JVM INSTR tableswitch 7 14: default 60
        //                       7 61
        //                       8 86
        //                       9 60
        //                       10 104
        //                       11 60
        //                       12 60
        //                       13 60
        //                       14 147;
               goto _L1 _L2 _L3 _L1 _L4 _L1 _L1 _L1 _L5
_L1:
            return;
_L2:
            if (s.equals("Auction"))
            {
                item.listingType = 2;
                auctionItemCount.increment();
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
                fixedPriceItemCount.increment();
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
                auctionItemCount.increment();
                fixedPriceItemCount.increment();
                return;
            }
            if (s.equals("StoreInventory"))
            {
                item.listingType = 6;
                fixedPriceItemCount.increment();
                return;
            }
            if (true) goto _L1; else goto _L6
_L6:
        }

        public FindItemsResponse.SearchResult.Item.ListingInfo.ListingType(EbaySearchListItem ebaysearchlistitem, IncrementingInt incrementingint, IncrementingInt incrementingint1)
        {
            item = ebaysearchlistitem;
            auctionItemCount = incrementingint;
            fixedPriceItemCount = incrementingint1;
        }
    }

    final class FindItemsResponse.SearchResult.Item.PrimaryCategory extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private EbayCategorySummary category;
        private String categoryName;
        final FindItemsResponse.SearchResult.Item this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("categoryId".equals(s1))
            {
                return new CategoryId();
            }
            if ("categoryName".equals(s1))
            {
                return new CategoryName();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        void test()
        {
            if (category != null && categoryName != null)
            {
                category.name = categoryName;
            }
        }


/*
        static EbayCategorySummary access$302(FindItemsResponse.SearchResult.Item.PrimaryCategory primarycategory, EbayCategorySummary ebaycategorysummary)
        {
            primarycategory.category = ebaycategorysummary;
            return ebaycategorysummary;
        }

*/


/*
        static String access$402(FindItemsResponse.SearchResult.Item.PrimaryCategory primarycategory, String s)
        {
            primarycategory.categoryName = s;
            return s;
        }

*/

        FindItemsResponse.SearchResult.Item.PrimaryCategory()
        {
            this$0 = FindItemsResponse.SearchResult.Item.this;
            super();
            category = null;
            categoryName = null;
        }
    }

    final class FindItemsResponse.SearchResult.Item.PrimaryCategory.CategoryId extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final FindItemsResponse.SearchResult.Item.PrimaryCategory this$1;

        public void text(String s)
            throws SAXException
        {
            if (response.fillCategories != null)
            {
                category = (EbayCategorySummary)response.fillCategories.remove(s);
                if (response.fillCategories.isEmpty())
                {
                    response.fillCategories = null;
                }
                test();
            }
        }

        FindItemsResponse.SearchResult.Item.PrimaryCategory.CategoryId()
        {
            this$1 = FindItemsResponse.SearchResult.Item.PrimaryCategory.this;
            super();
        }
    }

    final class FindItemsResponse.SearchResult.Item.PrimaryCategory.CategoryName extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final FindItemsResponse.SearchResult.Item.PrimaryCategory this$1;

        public void text(String s)
            throws SAXException
        {
            categoryName = s;
            test();
        }

        FindItemsResponse.SearchResult.Item.PrimaryCategory.CategoryName()
        {
            this$1 = FindItemsResponse.SearchResult.Item.PrimaryCategory.this;
            super();
        }
    }

    static final class FindItemsResponse.SearchResult.Item.SellingStatus extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbaySearchListItem item;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/search/v1/services".equals(s))
            {
                if ("bidCount".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final FindItemsResponse.SearchResult.Item.SellingStatus this$0;

                        public void setValue(int i)
                            throws SAXException
                        {
                            item.bidCount = i;
                        }

            
            {
                this$0 = FindItemsResponse.SearchResult.Item.SellingStatus.this;
                super();
            }
                    };
                }
                if ("convertedCurrentPrice".equals(s1))
                {
                    s = item;
                    s1 = new ItemCurrency();
                    s.convertedCurrentPrice = s1;
                    return new CurrencyElement(s1, "currencyId", attributes);
                }
                if ("currentPrice".equals(s1))
                {
                    s = item;
                    s1 = new ItemCurrency();
                    s.currentPrice = s1;
                    return new CurrencyElement(s1, "currencyId", attributes);
                }
                if ("sellingState".equals(s1))
                {
                    return new State(item);
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        protected FindItemsResponse.SearchResult.Item.SellingStatus(EbaySearchListItem ebaysearchlistitem)
        {
            item = ebaysearchlistitem;
        }
    }

    static final class FindItemsResponse.SearchResult.Item.SellingStatus.State extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        private final EbaySearchListItem item;

        public void text(String s)
            throws SAXException
        {
            item.sellingState = 0;
            s.length();
            JVM INSTR lookupswitch 5: default 64
        //                       5: 65
        //                       6: 83
        //                       8: 101
        //                       14: 119
        //                       17: 137;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
            return;
_L2:
            if (s.equals("Ended"))
            {
                item.sellingState = 3;
                return;
            }
            continue; /* Loop/switch isn't completed */
_L3:
            if (s.equals("Active"))
            {
                item.sellingState = 1;
                return;
            }
            continue; /* Loop/switch isn't completed */
_L4:
            if (s.equals("Canceled"))
            {
                item.sellingState = 2;
                return;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            if (s.equals("EndedWithSales"))
            {
                item.sellingState = 4;
                return;
            }
            continue; /* Loop/switch isn't completed */
_L6:
            if (s.equals("EndedWithoutSales"))
            {
                item.sellingState = 5;
                return;
            }
            if (true) goto _L1; else goto _L7
_L7:
        }

        public FindItemsResponse.SearchResult.Item.SellingStatus.State(EbaySearchListItem ebaysearchlistitem)
        {
            item = ebaysearchlistitem;
        }
    }

    static final class FindItemsResponse.SearchResult.Item.ShippingInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbaySearchListItem item;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/search/v1/services".equals(s))
            {
                if (item.shippingCost == null && "shippingServiceCost".equals(s1))
                {
                    s = item;
                    s1 = new ItemCurrency();
                    s.shippingCost = s1;
                    return new CurrencyElement(s1, "currencyId", attributes);
                }
                if ("shippingType".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final FindItemsResponse.SearchResult.Item.ShippingInfo this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            item.shippingType = s;
                        }

            
            {
                this$0 = FindItemsResponse.SearchResult.Item.ShippingInfo.this;
                super();
            }
                    };
                }
                if ("shipToLocations".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final FindItemsResponse.SearchResult.Item.ShippingInfo this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            item.shipToLocation = s;
                        }

            
            {
                this$0 = FindItemsResponse.SearchResult.Item.ShippingInfo.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        protected FindItemsResponse.SearchResult.Item.ShippingInfo(EbaySearchListItem ebaysearchlistitem)
        {
            item = ebaysearchlistitem;
        }
    }

    static final class FindItemsResponse.SearchResult.Item.UnitPrice extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbaySearchListItem item;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("type".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final FindItemsResponse.SearchResult.Item.UnitPrice this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        item.unitPriceType = s;
                    }

            
            {
                this$0 = FindItemsResponse.SearchResult.Item.UnitPrice.this;
                super();
            }
                };
            }
            if ("quantity".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final FindItemsResponse.SearchResult.Item.UnitPrice this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        item.unitPriceQuantity = s;
                    }

            
            {
                this$0 = FindItemsResponse.SearchResult.Item.UnitPrice.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        protected FindItemsResponse.SearchResult.Item.UnitPrice(EbaySearchListItem ebaysearchlistitem)
        {
            item = ebaysearchlistitem;
        }
    }

    private static class ListResult
    {

        public final AsyncList list;
        public final int totalItemsCount;

        public ListResult(int i, AsyncList asynclist)
        {
            totalItemsCount = i;
            list = asynclist;
        }
    }

    public static class SearchListResult extends ListResult
    {

        public final EbayAspectHistogram aspects;
        public final EbayCategoryHistogram categories;
        public final ArrayList itemIds;
        public String keywordsRecommendation;
        public final String searchUrl;
        public final int totalCountWithDupes;
        public final List warnings;

        public boolean hasWarning(String s)
        {
            if (warnings != null)
            {
                Iterator iterator = warnings.iterator();
                while (iterator.hasNext()) 
                {
                    if (s.equals(((EbayResponseError)iterator.next()).code))
                    {
                        return true;
                    }
                }
            }
            return false;
        }

        public SearchListResult(int i, int j, AsyncList asynclist, EbayCategoryHistogram ebaycategoryhistogram, EbayAspectHistogram ebayaspecthistogram, String s, ArrayList arraylist)
        {
            this(i, j, asynclist, ebaycategoryhistogram, ebayaspecthistogram, s, arraylist, null);
        }

        public SearchListResult(int i, int j, AsyncList asynclist, EbayCategoryHistogram ebaycategoryhistogram, EbayAspectHistogram ebayaspecthistogram, String s, ArrayList arraylist, 
                List list)
        {
            super(i, asynclist);
            categories = ebaycategoryhistogram;
            aspects = ebayaspecthistogram;
            searchUrl = s;
            itemIds = arraylist;
            warnings = list;
            totalCountWithDupes = j;
        }

        public SearchListResult(int i, AsyncList asynclist, EbayCategoryHistogram ebaycategoryhistogram, EbayAspectHistogram ebayaspecthistogram, String s, ArrayList arraylist)
        {
            this(i, i, asynclist, ebaycategoryhistogram, ebayaspecthistogram, s, arraylist, null);
        }
    }


    public static final String SERVICE_NAME = "FindingService";
    public static final String ServiceDomain = "http://www.ebay.com/marketplace/search/v1/services";
    static final int maxApiPageLimit = 100;
    public static final boolean rewriteImageUrl = true;

    private SavedSearchesApi()
    {
    }

    public static final SearchListResult findItem(EbayContext ebaycontext, SavedSearch savedsearch, boolean flag)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        savedsearch.searchParameters.useSoaLocaleList = flag;
        Object obj;
        boolean flag1;
        if (flag && !savedsearch.searchParameters.country.isSite())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            savedsearch.searchParameters.countryId = savedsearch.searchParameters.country.getCountryCode();
        }
        ebaycontext = new EbaySavedSearch(ebaycontext, savedsearch);
        obj = new PagedList(ebaycontext, savedsearch.searchParameters.maxCountPerPage, 100, savedsearch.searchParameters.numberOfPagesToPrefetch);
        ((PagedList) (obj)).startQuery();
        obj = new SearchListResult(ebaycontext.getTotalCount(), ((AsyncList) (obj)), ebaycontext.getCategories(), ebaycontext.getAspects(), ebaycontext.getSavedSearchQuery(), ebaycontext.getItemIds());
        if (TextUtils.isEmpty(savedsearch.query))
        {
            savedsearch.query = ebaycontext.getSavedSearchQuery();
        }
        return ((SearchListResult) (obj));
    }

    public static final void retryFindItem(SearchListResult searchlistresult)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        if (searchlistresult != null && searchlistresult.list != null)
        {
            ((PagedList)searchlistresult.list).retry();
        }
    }
}
