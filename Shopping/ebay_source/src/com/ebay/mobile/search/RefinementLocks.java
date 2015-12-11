// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.content.Context;
import android.text.TextUtils;
import com.ebay.common.Preferences;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.eBayDictionaryProvider;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.data.ItemCurrency;

// Referenced classes of package com.ebay.mobile.search:
//            SearchUtil

public final class RefinementLocks
{
    public static abstract class RefinementLockType extends Enum
    {

        private static final RefinementLockType $VALUES[];
        public static final RefinementLockType BESTOFFER;
        public static final RefinementLockType BUYINGFORMAT;
        public static final RefinementLockType COMPLETEDITEMS;
        public static final RefinementLockType CONDITION;
        public static final RefinementLockType DESCRIPTIONSEARCH;
        public static final RefinementLockType EBAYGIVINGWORKS;
        public static final RefinementLockType EBAYPLUS;
        public static final RefinementLockType EBN;
        public static final RefinementLockType EXPEDITEDSHIPPING;
        public static final RefinementLockType FREESHIPPING;
        public static final RefinementLockType INSTOREPICKUP;
        public static final RefinementLockType LOCALPICKUP;
        public static final RefinementLockType MAXDISTANCE;
        public static final RefinementLockType MAXPRICE;
        public static final RefinementLockType MINPRICE;
        private static char PRICE_TOKEN = '?';
        public static final RefinementLockType RETURNSACCEPTED;
        public static final RefinementLockType SEARCHLOCALCOUNTRY;
        public static final RefinementLockType SEARCHOTHERCOUNTRIES;
        public static final RefinementLockType SOLDITEMS;
        public static final RefinementLockType SORTORDER;
        public static final RefinementLockType ZIPCODE;

        public static RefinementLockType valueOf(String s)
        {
            return (RefinementLockType)Enum.valueOf(com/ebay/mobile/search/RefinementLocks$RefinementLockType, s);
        }

        public static RefinementLockType[] values()
        {
            return (RefinementLockType[])$VALUES.clone();
        }

        void apply(SearchParameters searchparameters)
        {
            String s = MyApp.getPrefs().getGlobalPref(getLockPrefKey(), null);
            if (s != null)
            {
                apply(searchparameters, s);
            }
        }

        void apply(SearchParameters searchparameters, String s)
        {
        }

        protected ItemCurrency constructCurrencyFromPrefs()
        {
            String s = MyApp.getPrefs().getGlobalPref(getLockPrefKey(), null);
            int i;
            if (s != null)
            {
                if ((i = s.indexOf(PRICE_TOKEN)) != -1)
                {
                    ItemCurrency itemcurrency = new ItemCurrency();
                    itemcurrency.code = s.substring(0, i);
                    itemcurrency.value = s.substring(i + 1);
                    return itemcurrency;
                }
            }
            return null;
        }

        protected String getLockPrefKey()
        {
            String s = MyApp.getPrefs().getCurrentCountry().getCountryCode();
            return (new StringBuilder()).append("_").append(s).append("_refine_lock_").append(toString()).toString();
        }

        abstract boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1);

        boolean isLocked()
        {
            return MyApp.getPrefs().getGlobalPref(getLockPrefKey(), null) != null;
        }

        void lock(ItemCurrency itemcurrency)
        {
            MyApp.getPrefs().setGlobalPref((new StringBuilder()).append(itemcurrency.code).append(PRICE_TOKEN).append(itemcurrency.value).toString(), getLockPrefKey());
        }

        void lock(String s)
        {
            if (!TextUtils.isEmpty(s))
            {
                MyApp.getPrefs().setGlobalPref(s, getLockPrefKey());
            }
        }

        void unlock()
        {
            MyApp.getPrefs().removeGlobalPref(getLockPrefKey());
        }

        static 
        {
            BESTOFFER = new RefinementLockType("BESTOFFER", 0) {

                void apply(SearchParameters searchparameters, String s)
                {
                    searchparameters.bestOfferOnly = Boolean.parseBoolean(s);
                }

                boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1)
                {
                    return searchparameters.bestOfferOnly == searchparameters1.bestOfferOnly;
                }

            };
            BUYINGFORMAT = new RefinementLockType("BUYINGFORMAT", 1) {

                void apply(SearchParameters searchparameters, String s)
                {
                    searchparameters.buyingFormat = Integer.parseInt(s);
                }

                boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1)
                {
                    return searchparameters.buyingFormat == searchparameters1.buyingFormat;
                }

            };
            CONDITION = new RefinementLockType("CONDITION", 2) {

                void apply(SearchParameters searchparameters, String s)
                {
                    searchparameters.condition = s;
                }

                boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1)
                {
                    if (searchparameters1.condition != null)
                    {
                        return searchparameters1.condition.equals(searchparameters.condition);
                    }
                    return searchparameters.condition == null;
                }

            };
            MINPRICE = new RefinementLockType("MINPRICE", 3) {

                void apply(SearchParameters searchparameters)
                {
                    searchparameters.minPrice = constructCurrencyFromPrefs();
                }

                boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1)
                {
                    if (searchparameters1.minPrice != null)
                    {
                        return searchparameters1.minPrice.equals(searchparameters.minPrice);
                    }
                    return searchparameters.minPrice == null;
                }

            };
            MAXPRICE = new RefinementLockType("MAXPRICE", 4) {

                void apply(SearchParameters searchparameters)
                {
                    searchparameters.maxPrice = constructCurrencyFromPrefs();
                }

                boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1)
                {
                    if (searchparameters1.maxPrice != null)
                    {
                        return searchparameters1.maxPrice.equals(searchparameters.maxPrice);
                    }
                    return searchparameters.maxPrice == null;
                }

            };
            SORTORDER = new RefinementLockType("SORTORDER", 5) {

                void apply(SearchParameters searchparameters, String s)
                {
                    searchparameters.sortOrder = s;
                }

                boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1)
                {
                    if (searchparameters1.sortOrder != null)
                    {
                        return searchparameters1.sortOrder.equals(searchparameters.sortOrder);
                    }
                    return searchparameters.sortOrder == null || searchparameters.sortOrder.equals("BestMatch");
                }

            };
            FREESHIPPING = new RefinementLockType("FREESHIPPING", 6) {

                void apply(SearchParameters searchparameters, String s)
                {
                    searchparameters.freeShipping = Boolean.parseBoolean(s);
                }

                boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1)
                {
                    return searchparameters.freeShipping == searchparameters1.freeShipping;
                }

            };
            EXPEDITEDSHIPPING = new RefinementLockType("EXPEDITEDSHIPPING", 7) {

                void apply(SearchParameters searchparameters, String s)
                {
                    searchparameters.expeditedShipping = Boolean.parseBoolean(s);
                }

                boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1)
                {
                    return searchparameters.expeditedShipping == searchparameters1.expeditedShipping;
                }

            };
            INSTOREPICKUP = new RefinementLockType("INSTOREPICKUP", 8) {

                void apply(SearchParameters searchparameters, String s)
                {
                    searchparameters.inStorePickupOnly = Boolean.parseBoolean(s);
                }

                boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1)
                {
                    return searchparameters.inStorePickupOnly == searchparameters1.inStorePickupOnly;
                }

            };
            LOCALPICKUP = new RefinementLockType("LOCALPICKUP", 9) {

                void apply(SearchParameters searchparameters, String s)
                {
                    searchparameters.localPickupOnly = Boolean.parseBoolean(s);
                }

                boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1)
                {
                    return searchparameters.localPickupOnly == searchparameters1.localPickupOnly;
                }

            };
            EBN = new RefinementLockType("EBN", 10) {

                void apply(SearchParameters searchparameters, String s)
                {
                    searchparameters.ebnOnly = Boolean.parseBoolean(s);
                }

                boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1)
                {
                    return searchparameters.ebnOnly == searchparameters1.ebnOnly;
                }

            };
            ZIPCODE = new RefinementLockType("ZIPCODE", 11) {

                void apply(SearchParameters searchparameters, String s)
                {
                    searchparameters.buyerPostalCode = s;
                }

                boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1)
                {
                    return SearchUtil.isZipCodeDefault(searchparameters.buyerPostalCode);
                }

            };
            MAXDISTANCE = new RefinementLockType("MAXDISTANCE", 12) {

                void apply(SearchParameters searchparameters, String s)
                {
                    searchparameters.maxDistance = Integer.parseInt(s);
                }

                boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1)
                {
                    return searchparameters.maxDistance == searchparameters1.maxDistance;
                }

            };
            COMPLETEDITEMS = new RefinementLockType("COMPLETEDITEMS", 13) {

                void apply(SearchParameters searchparameters, String s)
                {
                    searchparameters.completedListings = Boolean.parseBoolean(s);
                }

                boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1)
                {
                    return searchparameters.completedListings == searchparameters1.completedListings;
                }

            };
            SOLDITEMS = new RefinementLockType("SOLDITEMS", 14) {

                void apply(SearchParameters searchparameters, String s)
                {
                    searchparameters.soldItemsOnly = Boolean.parseBoolean(s);
                }

                boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1)
                {
                    return searchparameters.soldItemsOnly == searchparameters1.soldItemsOnly;
                }

            };
            EBAYPLUS = new RefinementLockType("EBAYPLUS", 15) {

                void apply(SearchParameters searchparameters, String s)
                {
                    searchparameters.ebayPlusOnly = Boolean.parseBoolean(s);
                }

                boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1)
                {
                    return searchparameters.ebayPlusOnly == searchparameters1.ebayPlusOnly;
                }

            };
            DESCRIPTIONSEARCH = new RefinementLockType("DESCRIPTIONSEARCH", 16) {

                void apply(SearchParameters searchparameters, String s)
                {
                    searchparameters.descriptionSearch = Boolean.parseBoolean(s);
                }

                boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1)
                {
                    return searchparameters.descriptionSearch == searchparameters1.descriptionSearch;
                }

            };
            SEARCHOTHERCOUNTRIES = new RefinementLockType("SEARCHOTHERCOUNTRIES", 17) {

                void apply(SearchParameters searchparameters, String s)
                {
                    searchparameters.searchOtherCountries = Boolean.parseBoolean(s);
                }

                boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1)
                {
                    return searchparameters.searchOtherCountries == searchparameters1.searchOtherCountries;
                }

            };
            SEARCHLOCALCOUNTRY = new RefinementLockType("SEARCHLOCALCOUNTRY", 18) {

                void apply(SearchParameters searchparameters, String s)
                {
                    searchparameters.searchLocalCountryOnly = Boolean.parseBoolean(s);
                }

                boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1)
                {
                    return searchparameters.searchLocalCountryOnly == searchparameters1.searchLocalCountryOnly;
                }

            };
            RETURNSACCEPTED = new RefinementLockType("RETURNSACCEPTED", 19) {

                void apply(SearchParameters searchparameters, String s)
                {
                    searchparameters.returnsAccepted = Boolean.parseBoolean(s);
                }

                boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1)
                {
                    return searchparameters.returnsAccepted == searchparameters1.returnsAccepted;
                }

            };
            EBAYGIVINGWORKS = new RefinementLockType("EBAYGIVINGWORKS", 20) {

                void apply(SearchParameters searchparameters, String s)
                {
                    searchparameters.ebayGivingWorks = Boolean.parseBoolean(s);
                }

                boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1)
                {
                    return searchparameters.ebayGivingWorks == searchparameters1.ebayGivingWorks;
                }

            };
            $VALUES = (new RefinementLockType[] {
                BESTOFFER, BUYINGFORMAT, CONDITION, MINPRICE, MAXPRICE, SORTORDER, FREESHIPPING, EXPEDITEDSHIPPING, INSTOREPICKUP, LOCALPICKUP, 
                EBN, ZIPCODE, MAXDISTANCE, COMPLETEDITEMS, SOLDITEMS, EBAYPLUS, DESCRIPTIONSEARCH, SEARCHOTHERCOUNTRIES, SEARCHLOCALCOUNTRY, RETURNSACCEPTED, 
                EBAYGIVINGWORKS
            });
        }

        private RefinementLockType(String s, int i)
        {
            super(s, i);
        }

    }


    public static final int STATE_LOCKED = 1;
    public static final int STATE_UNCONFIGURED = 3;
    public static final int STATE_UNLOCKED = 2;
    private final SearchParameters defaultParameters;

    public RefinementLocks(Context context)
    {
        defaultParameters = eBayDictionaryProvider.getDefaultSearchParameters(context, null);
    }

    public static void applyLocks(SearchParameters searchparameters)
    {
        RefinementLockType arefinementlocktype[] = RefinementLockType.values();
        int j = arefinementlocktype.length;
        for (int i = 0; i < j; i++)
        {
            arefinementlocktype[i].apply(searchparameters);
        }

    }

    public static void unlockAll()
    {
        RefinementLockType arefinementlocktype[] = RefinementLockType.values();
        int j = arefinementlocktype.length;
        for (int i = 0; i < j; i++)
        {
            arefinementlocktype[i].unlock();
        }

    }

    public int getLockState(RefinementLockType refinementlocktype, SearchParameters searchparameters)
    {
        if (refinementlocktype.isLocked())
        {
            return 1;
        }
        return !refinementlocktype.isDefault(searchparameters, defaultParameters) ? 2 : 3;
    }

    public void lock(RefinementLockType refinementlocktype, int i)
    {
        refinementlocktype.lock(String.valueOf(i));
    }

    public void lock(RefinementLockType refinementlocktype, ItemCurrency itemcurrency)
    {
        if (itemcurrency != null)
        {
            refinementlocktype.lock(itemcurrency);
        }
    }

    public void lock(RefinementLockType refinementlocktype, String s)
    {
        if (s != null)
        {
            refinementlocktype.lock(s);
        }
    }

    public void lock(RefinementLockType refinementlocktype, boolean flag)
    {
        refinementlocktype.lock(String.valueOf(flag));
    }

    public void unlock(RefinementLockType refinementlocktype)
    {
        refinementlocktype.unlock();
    }
}
