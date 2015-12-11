// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.PostalCodeSpecification;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

// Referenced classes of package com.ebay.common.net.api.search:
//            SellerOfferParameters

public final class SearchParameters
    implements Parcelable, Cloneable
{
    public static final class QueryIntent extends Enum
    {

        private static final QueryIntent $VALUES[];
        public static final QueryIntent CountOnly;
        public static final QueryIntent Normal;

        public static QueryIntent valueOf(String s)
        {
            return (QueryIntent)Enum.valueOf(com/ebay/common/net/api/search/SearchParameters$QueryIntent, s);
        }

        public static QueryIntent[] values()
        {
            return (QueryIntent[])$VALUES.clone();
        }

        static 
        {
            Normal = new QueryIntent("Normal", 0);
            CountOnly = new QueryIntent("CountOnly", 1);
            $VALUES = (new QueryIntent[] {
                Normal, CountOnly
            });
        }

        private QueryIntent(String s, int i)
        {
            super(s, i);
        }
    }

    static interface Refinement
        extends Annotation
    {
    }


    public static final int BUYING_FORMAT_ALL = 7;
    public static final int BUYING_FORMAT_AUCTION = 5;
    public static final int BUYING_FORMAT_BUY_IT_NOW = 6;
    public static final String CONDITION_NEW = "New";
    public static final String CONDITION_UNSPECIFIED = "Unspecified";
    public static final String CONDITION_USED = "Used";
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SearchParameters createFromParcel(Parcel parcel)
        {
            return new SearchParameters(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public SearchParameters[] newArray(int i)
        {
            return new SearchParameters[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final int LISTING_FORMAT_AUCTION = 1;
    public static final int LISTING_FORMAT_AUCTION_WITH_BIN = 4;
    public static final int LISTING_FORMAT_FIXED_PRICE = 2;
    public static final int LISTING_FORMAT_MASK = 7;
    public static final int SEARCH_TYPE_ADVANCED = 1;
    public static final int SEARCH_TYPE_CATEGORY = 2;
    public static final int SEARCH_TYPE_INVALID = 0;
    public static final int SEARCH_TYPE_PRODUCT = 4;
    public static final int SEARCH_TYPE_SELLER_ITEMS = 3;
    public static final String SORT_BEST_MATCH = "BestMatch";
    public static final String SORT_DISTANCE_NEAREST = "DistanceNearest";
    public static final String SORT_END_TIME_SOONEST = "EndTimeSoonest";
    public static final String SORT_PRICE_HIGHEST = "CurrentPriceHighest";
    public static final String SORT_PRICE_PLUC_SHIPPING_LOWEST = "PricePlusShippingLowest";
    public static final String SORT_PRICE_PLUS_SHIPPING_HIGHEST = "PricePlusShippingHighest";
    public static final String SORT_START_TIME_NEWEST = "StartTimeNewest";
    private static int lastSearchId = 0;
    public boolean allowExpansions;
    public EbayAspectHistogram aspectHistogram;
    public boolean bestOfferOnly;
    public String buyerPostalCode;
    public int buyingFormat;
    public EbayCategorySummary category;
    public EbayCategorySummary category1;
    public EbayCategorySummary category2;
    public boolean completedListings;
    public String condition;
    public EbayCountry country;
    public String countryId;
    public boolean descriptionSearch;
    public boolean ebayGivingWorks;
    public boolean ebayPlusOnly;
    public boolean ebnOnly;
    public boolean expeditedShipping;
    public boolean freeShipping;
    public boolean hideShipping;
    public String iafToken;
    public boolean inStorePickupOnly;
    public String keywords;
    public boolean localPickupOnly;
    public final int maxCountPerPage;
    public int maxDistance;
    public ItemCurrency maxPrice;
    public ItemCurrency minPrice;
    public final int numberOfPagesToPrefetch;
    public boolean paypalAccepted;
    public PostalCodeSpecification primaryPostalCodeSpec;
    public String productId;
    public String productIdType;
    public QueryIntent queryIntent;
    public boolean returnsAccepted;
    public final int searchId;
    public boolean searchLocalCountryOnly;
    public boolean searchOtherCountries;
    public boolean searchOtherCountriesGbh;
    public String sellerId;
    public SellerOfferParameters sellerOffer;
    public long sinceTime;
    public boolean soldItemsOnly;
    public String sortOrder;
    public boolean useSoaLocaleList;

    SearchParameters(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        allowExpansions = true;
        buyerPostalCode = null;
        primaryPostalCodeSpec = null;
        keywords = null;
        sellerId = null;
        buyingFormat = 7;
        maxDistance = 0;
        sortOrder = "BestMatch";
        condition = null;
        iafToken = null;
        ebayPlusOnly = false;
        completedListings = false;
        soldItemsOnly = false;
        category = null;
        category1 = null;
        category2 = null;
        descriptionSearch = false;
        returnsAccepted = false;
        ebayGivingWorks = false;
        freeShipping = false;
        expeditedShipping = false;
        localPickupOnly = false;
        inStorePickupOnly = false;
        ebnOnly = false;
        searchLocalCountryOnly = false;
        searchOtherCountries = false;
        searchOtherCountriesGbh = false;
        hideShipping = false;
        minPrice = null;
        maxPrice = null;
        aspectHistogram = null;
        productId = null;
        productIdType = null;
        paypalAccepted = false;
        bestOfferOnly = false;
        useSoaLocaleList = false;
        sellerOffer = null;
        queryIntent = QueryIntent.Normal;
        searchId = parcel.readInt();
        country = (EbayCountry)parcel.readParcelable(com/ebay/nautilus/domain/EbayCountry.getClassLoader());
        countryId = parcel.readString();
        maxCountPerPage = parcel.readInt();
        numberOfPagesToPrefetch = parcel.readInt();
        buyingFormat = parcel.readInt();
        maxDistance = parcel.readInt();
        buyerPostalCode = parcel.readString();
        keywords = parcel.readString();
        sellerId = parcel.readString();
        sortOrder = parcel.readString();
        condition = parcel.readString();
        iafToken = parcel.readString();
        sinceTime = parcel.readLong();
        int i = parcel.readInt();
        boolean flag;
        if ((i & 1) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        soldItemsOnly = flag;
        if ((i & 2) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        descriptionSearch = flag;
        if ((i & 4) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        completedListings = flag;
        if ((i & 8) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        freeShipping = flag;
        if ((i & 0x10) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        searchLocalCountryOnly = flag;
        if ((i & 0x20) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        searchOtherCountries = flag;
        if ((i & 0x40) != 0)
        {
            minPrice = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
        }
        if ((i & 0x80) != 0)
        {
            maxPrice = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
        }
        if ((i & 0x100) != 0)
        {
            category = (EbayCategorySummary)EbayCategorySummary.CREATOR.createFromParcel(parcel);
        }
        if ((i & 0x2000) != 0)
        {
            category1 = (EbayCategorySummary)EbayCategorySummary.CREATOR.createFromParcel(parcel);
        }
        if ((i & 0x4000) != 0)
        {
            category2 = (EbayCategorySummary)EbayCategorySummary.CREATOR.createFromParcel(parcel);
        }
        if ((i & 0x200) != 0)
        {
            aspectHistogram = (EbayAspectHistogram)EbayAspectHistogram.CREATOR.createFromParcel(parcel);
        }
        if ((i & 0x400) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        paypalAccepted = flag;
        if ((i & 0x800) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hideShipping = flag;
        if ((i & 0x1000) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bestOfferOnly = flag;
        if ((0x8000 & i) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        useSoaLocaleList = flag;
        if ((0x10000 & i) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        searchOtherCountriesGbh = flag;
        if ((0x20000 & i) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        expeditedShipping = flag;
        if ((0x40000 & i) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        localPickupOnly = flag;
        if ((0x80000 & i) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        inStorePickupOnly = flag;
        if ((0x100000 & i) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ebnOnly = flag;
        if ((0x200000 & i) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        returnsAccepted = flag;
        if ((0x400000 & i) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ebayGivingWorks = flag;
        if ((0x800000 & i) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        allowExpansions = flag;
        if ((0x1000000 & i) != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        ebayPlusOnly = flag;
        productId = parcel.readString();
        productIdType = parcel.readString();
        sellerOffer = (SellerOfferParameters)parcel.readParcelable(com/ebay/common/net/api/search/SellerOfferParameters.getClassLoader());
    }

    public SearchParameters(EbayCountry ebaycountry, int i, int j)
    {
        allowExpansions = true;
        buyerPostalCode = null;
        primaryPostalCodeSpec = null;
        keywords = null;
        sellerId = null;
        buyingFormat = 7;
        maxDistance = 0;
        sortOrder = "BestMatch";
        condition = null;
        iafToken = null;
        ebayPlusOnly = false;
        completedListings = false;
        soldItemsOnly = false;
        category = null;
        category1 = null;
        category2 = null;
        descriptionSearch = false;
        returnsAccepted = false;
        ebayGivingWorks = false;
        freeShipping = false;
        expeditedShipping = false;
        localPickupOnly = false;
        inStorePickupOnly = false;
        ebnOnly = false;
        searchLocalCountryOnly = false;
        searchOtherCountries = false;
        searchOtherCountriesGbh = false;
        hideShipping = false;
        minPrice = null;
        maxPrice = null;
        aspectHistogram = null;
        productId = null;
        productIdType = null;
        paypalAccepted = false;
        bestOfferOnly = false;
        useSoaLocaleList = false;
        sellerOffer = null;
        queryIntent = QueryIntent.Normal;
        int k;
        if (lastSearchId == 0x7fffffff)
        {
            k = 0x80000000;
            lastSearchId = 0x80000000;
        } else
        {
            k = lastSearchId + 1;
            lastSearchId = k;
        }
        searchId = k;
        country = ebaycountry;
        countryId = ebaycountry.getCountryCode();
        maxCountPerPage = i;
        numberOfPagesToPrefetch = j;
    }

    private boolean isEqual(Object obj, Object obj1)
    {
        if (obj == null)
        {
            return obj1 == null;
        } else
        {
            return obj.equals(obj1);
        }
    }

    public final void clearZipCodeAndDependencies()
    {
        buyerPostalCode = null;
        ebnOnly = false;
        inStorePickupOnly = false;
        localPickupOnly = false;
    }

    public SearchParameters clone()
    {
        SearchParameters searchparameters;
        try
        {
            searchparameters = (SearchParameters)super.clone();
            if (category != null)
            {
                searchparameters.category = category.clone();
            }
            if (category1 != null)
            {
                searchparameters.category1 = category1.clone();
            }
            if (category2 != null)
            {
                searchparameters.category2 = category2.clone();
            }
            if (minPrice != null)
            {
                searchparameters.minPrice = minPrice.clone();
            }
            if (maxPrice != null)
            {
                searchparameters.maxPrice = maxPrice.clone();
            }
            if (aspectHistogram != null)
            {
                searchparameters.aspectHistogram = aspectHistogram.clone();
            }
            if (sellerOffer != null)
            {
                searchparameters.sellerOffer = new SellerOfferParameters(sellerOffer);
            }
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            return null;
        }
        return searchparameters;
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public final boolean containsLocalRefinements()
    {
        return ebnOnly || localPickupOnly || inStorePickupOnly;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof SearchParameters))
        {
            obj = (SearchParameters)obj;
            if (isEqual(country, ((SearchParameters) (obj)).country) && isEqual(countryId, ((SearchParameters) (obj)).countryId) && maxCountPerPage == ((SearchParameters) (obj)).maxCountPerPage && numberOfPagesToPrefetch == ((SearchParameters) (obj)).numberOfPagesToPrefetch && buyingFormat == ((SearchParameters) (obj)).buyingFormat && maxDistance == ((SearchParameters) (obj)).maxDistance && isEqual(buyerPostalCode, ((SearchParameters) (obj)).buyerPostalCode) && isEqual(keywords, ((SearchParameters) (obj)).keywords) && isEqual(sellerId, ((SearchParameters) (obj)).sellerId) && isEqual(sortOrder, ((SearchParameters) (obj)).sortOrder) && isEqual(condition, ((SearchParameters) (obj)).condition) && isEqual(iafToken, ((SearchParameters) (obj)).iafToken) && isEqual(Long.valueOf(sinceTime), Long.valueOf(((SearchParameters) (obj)).sinceTime)) && soldItemsOnly == ((SearchParameters) (obj)).soldItemsOnly && descriptionSearch == ((SearchParameters) (obj)).descriptionSearch && completedListings == ((SearchParameters) (obj)).completedListings && freeShipping == ((SearchParameters) (obj)).freeShipping && expeditedShipping == ((SearchParameters) (obj)).expeditedShipping && localPickupOnly == ((SearchParameters) (obj)).localPickupOnly && inStorePickupOnly == ((SearchParameters) (obj)).inStorePickupOnly && ebnOnly == ((SearchParameters) (obj)).ebnOnly && returnsAccepted == ((SearchParameters) (obj)).returnsAccepted && ebayPlusOnly == ((SearchParameters) (obj)).ebayPlusOnly && ebayGivingWorks == ((SearchParameters) (obj)).ebayGivingWorks && allowExpansions == ((SearchParameters) (obj)).allowExpansions && searchLocalCountryOnly == ((SearchParameters) (obj)).searchLocalCountryOnly && searchOtherCountries == ((SearchParameters) (obj)).searchOtherCountries && searchOtherCountriesGbh == ((SearchParameters) (obj)).searchOtherCountriesGbh && isEqual(minPrice, ((SearchParameters) (obj)).minPrice) && isEqual(maxPrice, ((SearchParameters) (obj)).maxPrice) && isEqual(category, ((SearchParameters) (obj)).category) && isEqual(aspectHistogram, ((SearchParameters) (obj)).aspectHistogram) && paypalAccepted == ((SearchParameters) (obj)).paypalAccepted && hideShipping == ((SearchParameters) (obj)).hideShipping && isEqual(productId, ((SearchParameters) (obj)).productId) && isEqual(productIdType, ((SearchParameters) (obj)).productIdType) && isEqual(Boolean.valueOf(bestOfferOnly), Boolean.valueOf(((SearchParameters) (obj)).bestOfferOnly)) && useSoaLocaleList == ((SearchParameters) (obj)).useSoaLocaleList)
            {
                return true;
            }
        }
        return false;
    }

    public final int getRefinementDelta(SearchParameters searchparameters)
    {
        Field afield[];
        int i;
        int j;
        int l;
        j = 0;
        afield = searchparameters.getClass().getFields();
        l = afield.length;
        i = 0;
_L2:
        Field field;
        int k;
        if (i >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        field = afield[i];
        k = j;
        if (!field.isAnnotationPresent(com/ebay/common/net/api/search/SearchParameters$Refinement))
        {
            break MISSING_BLOCK_LABEL_74;
        }
        boolean flag = isEqual(field.get(searchparameters), field.get(this));
        k = j;
        if (!flag)
        {
            k = j + 1;
        }
_L3:
        i++;
        j = k;
        if (true) goto _L2; else goto _L1
        IllegalAccessException illegalaccessexception;
        illegalaccessexception;
        illegalaccessexception.printStackTrace();
        k = j;
          goto _L3
_L1:
        return j;
    }

    public final int getSearchType()
    {
        if (productId == null && productIdType == null) goto _L2; else goto _L1
_L1:
        if (!TextUtils.isEmpty(productId) && !TextUtils.isEmpty(productIdType) && category == null && keywords == null && aspectHistogram == null && !descriptionSearch) goto _L4; else goto _L3
_L3:
        return 0;
_L4:
        return 4;
_L2:
        if (keywords == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (keywords.length() < 2) goto _L3; else goto _L5
_L5:
        return 1;
        if (descriptionSearch) goto _L3; else goto _L6
_L6:
        if (sellerId == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (TextUtils.isEmpty(sellerId)) goto _L3; else goto _L7
_L7:
        return 3;
        if (category == null || category.id <= 0L) goto _L3; else goto _L8
_L8:
        return 2;
    }

    public String toString()
    {
        return (new StringBuilder()).append(super.toString()).append(" {iafToken:").append(iafToken).append(" since: ").append(sinceTime).append(" country:").append(country).append(" countryId:").append(countryId).append(" maxCountPerPage:").append(maxCountPerPage).append(" numberOfPagesToPrefetch:").append(numberOfPagesToPrefetch).append(" buyerPostalCode:").append(buyerPostalCode).append(" hideShipping:").append(hideShipping).append(" keywords:").append(keywords).append(" sellerId:").append(sellerId).append(" buyingFormat:").append(buyingFormat).append(" maxDistance:").append(maxDistance).append(" sortOrder:").append(sortOrder).append(" condition:").append(condition).append(" category:").append(category).append(" soldItemsOnly:").append(soldItemsOnly).append(" descriptionSearch:").append(descriptionSearch).append(" completedListings:").append(completedListings).append(" returnsAccepted:").append(returnsAccepted).append(" ebayPlusOnly:").append(ebayPlusOnly).append(" ebayGivingWorks:").append(ebayGivingWorks).append(" freeShipping:").append(freeShipping).append(" expeditedShipping:").append(expeditedShipping).append(" localPickupOnly:").append(localPickupOnly).append(" inStorePickupOnly:").append(inStorePickupOnly).append(" ebnOnly:").append(ebnOnly).append(" searchLocalCountryOnly:").append(searchLocalCountryOnly).append(" searchOtherCountries:").append(searchOtherCountries).append(" searchOtherCountriesGbh:").append(searchOtherCountriesGbh).append(" minPrice:").append(minPrice).append(" maxPrice:").append(maxPrice).append(" productId:").append(productId).append(" productIdType:").append(productIdType).append(" paypalAccepted:").append(paypalAccepted).append(" bestOffer:").append(bestOfferOnly).append(" useSoaLocaleList:").append(useSoaLocaleList).append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        int k2 = 0;
        parcel.writeInt(searchId);
        parcel.writeParcelable(country, i);
        parcel.writeString(countryId);
        parcel.writeInt(maxCountPerPage);
        parcel.writeInt(numberOfPagesToPrefetch);
        parcel.writeInt(buyingFormat);
        parcel.writeInt(maxDistance);
        parcel.writeString(buyerPostalCode);
        parcel.writeString(keywords);
        parcel.writeString(sellerId);
        parcel.writeString(sortOrder);
        parcel.writeString(condition);
        parcel.writeString(iafToken);
        parcel.writeLong(sinceTime);
        boolean flag;
        byte byte0;
        byte byte1;
        byte byte2;
        byte byte3;
        byte byte4;
        byte byte5;
        char c;
        char c1;
        char c2;
        char c3;
        char c4;
        char c5;
        char c6;
        char c7;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        if (soldItemsOnly)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (descriptionSearch)
        {
            byte0 = 2;
        } else
        {
            byte0 = 0;
        }
        if (completedListings)
        {
            byte1 = 4;
        } else
        {
            byte1 = 0;
        }
        if (freeShipping)
        {
            byte2 = 8;
        } else
        {
            byte2 = 0;
        }
        if (searchLocalCountryOnly)
        {
            byte3 = 16;
        } else
        {
            byte3 = 0;
        }
        if (searchOtherCountries)
        {
            byte4 = 32;
        } else
        {
            byte4 = 0;
        }
        if (minPrice != null)
        {
            byte5 = 64;
        } else
        {
            byte5 = 0;
        }
        if (maxPrice != null)
        {
            c = '\200';
        } else
        {
            c = '\0';
        }
        if (category != null)
        {
            c1 = '\u0100';
        } else
        {
            c1 = '\0';
        }
        if (aspectHistogram != null)
        {
            c2 = '\u0200';
        } else
        {
            c2 = '\0';
        }
        if (paypalAccepted)
        {
            c3 = '\u0400';
        } else
        {
            c3 = '\0';
        }
        if (hideShipping)
        {
            c4 = '\u0800';
        } else
        {
            c4 = '\0';
        }
        if (bestOfferOnly)
        {
            c5 = '\u1000';
        } else
        {
            c5 = '\0';
        }
        if (category1 != null)
        {
            c6 = '\u2000';
        } else
        {
            c6 = '\0';
        }
        if (category2 != null)
        {
            c7 = '\u4000';
        } else
        {
            c7 = '\0';
        }
        if (useSoaLocaleList)
        {
            j = 32768;
        } else
        {
            j = 0;
        }
        if (searchOtherCountries)
        {
            k = 0x10000;
        } else
        {
            k = 0;
        }
        if (expeditedShipping)
        {
            l = 0x20000;
        } else
        {
            l = 0;
        }
        if (localPickupOnly)
        {
            i1 = 0x40000;
        } else
        {
            i1 = 0;
        }
        if (inStorePickupOnly)
        {
            j1 = 0x80000;
        } else
        {
            j1 = 0;
        }
        if (ebnOnly)
        {
            k1 = 0x100000;
        } else
        {
            k1 = 0;
        }
        if (returnsAccepted)
        {
            l1 = 0x200000;
        } else
        {
            l1 = 0;
        }
        if (ebayGivingWorks)
        {
            i2 = 0x400000;
        } else
        {
            i2 = 0;
        }
        if (allowExpansions)
        {
            j2 = 0x800000;
        } else
        {
            j2 = 0;
        }
        if (ebayPlusOnly)
        {
            k2 = 0x1000000;
        }
        parcel.writeInt(j2 | (byte0 | flag | byte1 | byte2 | byte3 | byte4 | byte5 | c | c1 | c2 | c3 | c4 | c5 | c6 | c7 | j | k | l | i1 | j1 | k1 | l1 | i2) | k2);
        if (minPrice != null)
        {
            minPrice.writeToParcel(parcel, i);
        }
        if (maxPrice != null)
        {
            maxPrice.writeToParcel(parcel, i);
        }
        if (category != null)
        {
            category.writeToParcel(parcel, i);
        }
        if (category1 != null)
        {
            category1.writeToParcel(parcel, i);
        }
        if (category2 != null)
        {
            category2.writeToParcel(parcel, i);
        }
        if (aspectHistogram != null)
        {
            aspectHistogram.writeToParcel(parcel, i);
        }
        parcel.writeString(productId);
        parcel.writeString(productIdType);
        parcel.writeParcelable(sellerOffer, i);
    }

}
