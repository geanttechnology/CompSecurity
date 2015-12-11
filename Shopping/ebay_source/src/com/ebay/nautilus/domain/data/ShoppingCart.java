// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            CurrencyAmount

public class ShoppingCart extends BaseDataMapped
    implements Parcelable
{
    public static final class Address extends BaseDataMapped
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Address createFromParcel(Parcel parcel)
            {
                return (Address)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ShoppingCart$Address);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public Address[] newArray(int i)
            {
                return new Address[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public static final Address UNKNOWN = new Address();
        public final String addressId;
        public final String city;
        public final String country;
        public final String county;
        public final String name;
        public final String phone;
        public final String postalCode;
        public final String stateOrProvince;
        public final String streetLine1;
        public final String streetLine2;


        public Address()
        {
            this(null, null, null, null, null, null, null, null, null, null);
        }

        public Address(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
                String s7, String s8, String s9)
        {
            if (s == null)
            {
                s = "";
            }
            addressId = s;
            if (s1 == null)
            {
                s1 = "";
            }
            name = s1;
            if (s2 == null)
            {
                s2 = "";
            }
            streetLine1 = s2;
            if (s3 == null)
            {
                s3 = "";
            }
            streetLine2 = s3;
            if (s4 == null)
            {
                s4 = "";
            }
            city = s4;
            if (s5 == null)
            {
                s5 = "";
            }
            county = s5;
            if (s6 == null)
            {
                s6 = "";
            }
            stateOrProvince = s6;
            if (s7 == null)
            {
                s7 = "";
            }
            country = s7;
            if (s8 == null)
            {
                s8 = "";
            }
            postalCode = s8;
            if (s9 == null)
            {
                s9 = "";
            }
            phone = s9;
        }
    }

    public static final class CheckoutSession extends BaseDataMapped
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public CheckoutSession createFromParcel(Parcel parcel)
            {
                return (CheckoutSession)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ShoppingCart$CheckoutSession);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public CheckoutSession[] newArray(int i)
            {
                return new CheckoutSession[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public static final CheckoutSession UNKNOWN = new CheckoutSession();
        public final boolean isEligibleForGuestCheckout;
        public final String token;
        public final String type;
        public final Uri url;


        protected CheckoutSession()
        {
            this(null, null, null, false);
        }

        public CheckoutSession(String s, String s1, Uri uri, boolean flag)
        {
            if (s == null)
            {
                s = "";
            }
            token = s;
            if (s1 == null)
            {
                s1 = "";
            }
            type = s1;
            if (uri == null)
            {
                uri = Uri.EMPTY;
            }
            url = uri;
            isEligibleForGuestCheckout = flag;
        }
    }

    public static class Item extends Transaction
        implements Parcelable, Comparable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Item createFromParcel(Parcel parcel)
            {
                return (Item)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ShoppingCart$Item);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public Item[] newArray(int i)
            {
                return new Item[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public static final Item UNKNOWN = new Item();
        private static final ItemComparator itemComparitor = new ItemComparator();
        public final Date addedToCartAt;
        public final Set availablePaymentMethods;
        public final int availableQuantity;
        public final boolean hasReservePrice;
        public final boolean hasRevisions;
        public final String imageUrl;
        public final boolean isBuyItNowAvailable;
        public final boolean isEbayPaymentProcessEnabled;
        public final boolean isEnded;
        public final boolean isReserveMet;
        public final boolean isTransacted;
        public final boolean isUnbuyable;
        public final Date itemEndTime;
        public final Map itemSpecifics;
        public final ListingType itemType;
        public final Long lineItemId;
        public final com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.LineItemTypes lineItemType;
        public final String location;
        public final String orderId;
        public final Long primaryCategoryId;
        public final boolean requiresImmediatePayment;
        public final boolean savedForLater;
        public final Long secondaryCategoryId;
        public final Long sellerFeedbackScore;
        public final String sellerUserId;
        public final ItemCurrencyWithConversion shippingCost;
        public final EbaySite site;
        public final Status status;
        public final String title;
        public final List transactions;
        public final String translatedTitle;
        public final List variationSpecifics;

        public int compareTo(Item item)
        {
            if (this == item)
            {
                return 0;
            }
            if (item == null)
            {
                return 1;
            } else
            {
                return itemComparitor.compare(this, item);
            }
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((Item)obj);
        }

        public String getTitle(boolean flag)
        {
            if (flag && !TextUtils.isEmpty(translatedTitle))
            {
                return translatedTitle;
            } else
            {
                return title;
            }
        }

        public boolean hasPaymentMethod(String s)
        {
            return availablePaymentMethods.contains(s);
        }


        protected Item()
        {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, null, null, false, false, false, false, false, false, null, null, false, false, false, null, null, false, null, null, com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.LineItemTypes.UNKNOWN_LINE_ITEM_TYPE, null);
        }

        public Item(EbaySite ebaysite, String s, Long long1, String s1, Long long2, Long long3, String s2, 
                String s3, String s4, Long long4, Status status1, Long long5, Long long6, ItemCurrencyWithConversion itemcurrencywithconversion, 
                ItemCurrencyWithConversion itemcurrencywithconversion1, int i, int j, List list, String s5, boolean flag, boolean flag1, 
                boolean flag2, boolean flag3, boolean flag4, boolean flag5, Date date, Date date1, boolean flag6, 
                boolean flag7, boolean flag8, ListingType listingtype, List list1, boolean flag9, Set set, Map map, 
                com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.LineItemTypes lineitemtypes, String s6)
        {
            super(long1, s1, long2, itemcurrencywithconversion, i);
            long l;
            if (ebaysite == null)
            {
                ebaysite = EbaySite.US;
            }
            site = ebaysite;
            if (s == null)
            {
                s = "";
            }
            location = s;
            if (long3 != null)
            {
                l = long3.longValue();
            } else
            {
                l = 0L;
            }
            lineItemId = Long.valueOf(l);
            if (s2 == null)
            {
                s2 = "";
            }
            imageUrl = s2;
            if (s3 == null)
            {
                s3 = "";
            }
            title = s3;
            if (s4 == null)
            {
                s4 = "";
            }
            sellerUserId = s4;
            if (long4 != null)
            {
                l = long4.longValue();
            } else
            {
                l = 0L;
            }
            sellerFeedbackScore = Long.valueOf(l);
            if (status1 == null)
            {
                status1 = Status.UNKNOWN;
            }
            status = status1;
            if (long5 != null)
            {
                l = long5.longValue();
            } else
            {
                l = 0L;
            }
            primaryCategoryId = Long.valueOf(l);
            if (long6 != null)
            {
                l = long6.longValue();
            } else
            {
                l = 0L;
            }
            secondaryCategoryId = Long.valueOf(l);
            if (itemcurrencywithconversion1 == null)
            {
                itemcurrencywithconversion1 = ItemCurrencyWithConversion.ZERO;
            }
            shippingCost = itemcurrencywithconversion1;
            availableQuantity = j;
            if (list != null)
            {
                ebaysite = Collections.unmodifiableList(list);
            } else
            {
                ebaysite = Collections.emptyList();
            }
            variationSpecifics = ebaysite;
            if (s5 == null)
            {
                s5 = "";
            }
            orderId = s5;
            isEnded = flag;
            isTransacted = flag1;
            isReserveMet = flag2;
            hasReservePrice = flag3;
            isBuyItNowAvailable = flag4;
            isEbayPaymentProcessEnabled = flag5;
            if (date == null)
            {
                date = new Date(0L);
            }
            itemEndTime = date;
            if (date1 == null)
            {
                date1 = new Date(0L);
            }
            addedToCartAt = date1;
            isUnbuyable = flag6;
            hasRevisions = flag7;
            requiresImmediatePayment = flag8;
            if (listingtype == null)
            {
                listingtype = ListingType.UNKNOWN;
            }
            itemType = listingtype;
            if (list1 != null)
            {
                ebaysite = Collections.unmodifiableList(list1);
            } else
            {
                ebaysite = Collections.emptyList();
            }
            transactions = ebaysite;
            savedForLater = flag9;
            if (set != null)
            {
                ebaysite = Collections.unmodifiableSet(set);
            } else
            {
                ebaysite = Collections.emptySet();
            }
            availablePaymentMethods = ebaysite;
            if (map == null)
            {
                map = Collections.emptyMap();
            }
            itemSpecifics = map;
            lineItemType = lineitemtypes;
            translatedTitle = s6;
        }
    }

    public static final class Item.ListingType extends Enum
    {

        private static final Item.ListingType $VALUES[];
        public static final Item.ListingType BID_AND_BIN;
        public static final Item.ListingType BID_ONLY;
        public static final Item.ListingType BIN_ONLY;
        public static final Item.ListingType UNKNOWN;

        public static Item.ListingType from(String s)
        {
            try
            {
                s = valueOf(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return UNKNOWN;
            }
            return s;
        }

        public static Item.ListingType valueOf(String s)
        {
            return (Item.ListingType)Enum.valueOf(com/ebay/nautilus/domain/data/ShoppingCart$Item$ListingType, s);
        }

        public static Item.ListingType[] values()
        {
            return (Item.ListingType[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new Item.ListingType("UNKNOWN", 0);
            BIN_ONLY = new Item.ListingType("BIN_ONLY", 1);
            BID_AND_BIN = new Item.ListingType("BID_AND_BIN", 2);
            BID_ONLY = new Item.ListingType("BID_ONLY", 3);
            $VALUES = (new Item.ListingType[] {
                UNKNOWN, BIN_ONLY, BID_AND_BIN, BID_ONLY
            });
        }

        private Item.ListingType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Item.Status extends Enum
    {

        private static final Item.Status $VALUES[];
        public static final Item.Status ENDED;
        public static final Item.Status ENDING_SOON;
        public static final Item.Status HAS_REVISIONS;
        public static final Item.Status LAST_ONE;
        public static final Item.Status NOT_AVAILABLE;
        public static final Item.Status PAY_NOW;
        public static final Item.Status SELLER_ON_VACATION;
        public static final Item.Status UNKNOWN;
        public static final Item.Status UP_FOR_AUCTION;
        public static final Item.Status WON;
        public final boolean isCartable;
        public final boolean isRemoveable;
        public final boolean isSaveable;

        public static Item.Status valueOf(String s)
        {
            return (Item.Status)Enum.valueOf(com/ebay/nautilus/domain/data/ShoppingCart$Item$Status, s);
        }

        public static Item.Status[] values()
        {
            return (Item.Status[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new Item.Status("UNKNOWN", 0, true, true, true);
            SELLER_ON_VACATION = new Item.Status("SELLER_ON_VACATION", 1, true, true, true);
            PAY_NOW = new Item.Status("PAY_NOW", 2, true, true, false);
            WON = new Item.Status("WON", 3, true, true, false);
            ENDED = new Item.Status("ENDED", 4, false, false, true);
            UP_FOR_AUCTION = new Item.Status("UP_FOR_AUCTION", 5, false, false, true);
            NOT_AVAILABLE = new Item.Status("NOT_AVAILABLE", 6, false, true, true);
            ENDING_SOON = new Item.Status("ENDING_SOON", 7, true, true, true);
            LAST_ONE = new Item.Status("LAST_ONE", 8, true, true, true);
            HAS_REVISIONS = new Item.Status("HAS_REVISIONS", 9, true, true, true);
            $VALUES = (new Item.Status[] {
                UNKNOWN, SELLER_ON_VACATION, PAY_NOW, WON, ENDED, UP_FOR_AUCTION, NOT_AVAILABLE, ENDING_SOON, LAST_ONE, HAS_REVISIONS
            });
        }

        private Item.Status(String s, int i, boolean flag, boolean flag1, boolean flag2)
        {
            super(s, i);
            isCartable = flag;
            isSaveable = flag1;
            isRemoveable = flag2;
        }
    }

    public static class ItemComparator
        implements Comparator
    {

        private SortPriority priorityOf(Item item)
        {
            if (item.isUnbuyable)
            {
                return SortPriority.UN_BUYABLE;
            }
            if (item.lineItemId == null && !TextUtils.isEmpty(item.orderId))
            {
                return SortPriority.SELLER_CREATED;
            }
            if (item.lineItemId != null)
            {
                return SortPriority.BUYER_CREATED;
            } else
            {
                return SortPriority.LOWEST;
            }
        }

        public int compare(Item item, Item item1)
        {
            SortPriority sortpriority;
            SortPriority sortpriority1;
            int i;
            i = -1;
            if (!TextUtils.equals(item.sellerUserId, item.sellerUserId))
            {
                break MISSING_BLOCK_LABEL_108;
            }
            sortpriority = priorityOf(item);
            sortpriority1 = priorityOf(item1);
            if (sortpriority.ordinal() != sortpriority1.ordinal()) goto _L2; else goto _L1
_L1:
            boolean flag = item.isEnded;
            if (flag != item1.isEnded) goto _L4; else goto _L3
_L3:
            item = item.addedToCartAt;
            item1 = item1.addedToCartAt;
            if (item == null || item1 == null) goto _L6; else goto _L5
_L5:
            i = item.compareTo(item1);
_L8:
            return i;
_L6:
            return 0;
_L4:
            if (flag) goto _L8; else goto _L7
_L7:
            return 1;
_L2:
            if (sortpriority.ordinal() < sortpriority1.ordinal()) goto _L8; else goto _L9
_L9:
            return 1;
            return item.sellerUserId.compareTo(item1.sellerUserId);
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((Item)obj, (Item)obj1);
        }

        public ItemComparator()
        {
        }
    }

    private static final class ItemComparator.SortPriority extends Enum
    {

        private static final ItemComparator.SortPriority $VALUES[];
        public static final ItemComparator.SortPriority BUYER_CREATED;
        public static final ItemComparator.SortPriority LOWEST;
        public static final ItemComparator.SortPriority SELLER_CREATED;
        public static final ItemComparator.SortPriority UN_BUYABLE;

        public static ItemComparator.SortPriority valueOf(String s)
        {
            return (ItemComparator.SortPriority)Enum.valueOf(com/ebay/nautilus/domain/data/ShoppingCart$ItemComparator$SortPriority, s);
        }

        public static ItemComparator.SortPriority[] values()
        {
            return (ItemComparator.SortPriority[])$VALUES.clone();
        }

        static 
        {
            LOWEST = new ItemComparator.SortPriority("LOWEST", 0);
            UN_BUYABLE = new ItemComparator.SortPriority("UN_BUYABLE", 1);
            SELLER_CREATED = new ItemComparator.SortPriority("SELLER_CREATED", 2);
            BUYER_CREATED = new ItemComparator.SortPriority("BUYER_CREATED", 3);
            $VALUES = (new ItemComparator.SortPriority[] {
                LOWEST, UN_BUYABLE, SELLER_CREATED, BUYER_CREATED
            });
        }

        private ItemComparator.SortPriority(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ItemCurrencyWithConversion
    {

        public static final ItemCurrencyWithConversion ZERO = new ItemCurrencyWithConversion();
        public final CurrencyAmount listedPrice;
        public final CurrencyAmount sitePrice;

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (!(obj instanceof ItemCurrencyWithConversion) || (((ItemCurrencyWithConversion) (obj = (ItemCurrencyWithConversion)obj)).listedPrice.isZero() || ((ItemCurrencyWithConversion) (obj)).sitePrice.isZero() || !((ItemCurrencyWithConversion) (obj)).listedPrice.equals(listedPrice) || !((ItemCurrencyWithConversion) (obj)).sitePrice.equals(sitePrice)))
                {
                    return false;
                }
            }
            return true;
        }

        public boolean isZero()
        {
            return listedPrice.isZero() && sitePrice.isZero();
        }


        protected ItemCurrencyWithConversion()
        {
            this(CurrencyAmount.ZERO, CurrencyAmount.ZERO);
        }

        public ItemCurrencyWithConversion(CurrencyAmount currencyamount, CurrencyAmount currencyamount1)
        {
            CurrencyAmount currencyamount2 = currencyamount;
            if (currencyamount == null)
            {
                currencyamount2 = CurrencyAmount.ZERO;
            }
            sitePrice = currencyamount2;
            currencyamount = currencyamount1;
            if (currencyamount1 == null)
            {
                currencyamount = CurrencyAmount.ZERO;
            }
            listedPrice = currencyamount;
        }
    }

    public static final class Orders extends BaseDataMapped
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Orders createFromParcel(Parcel parcel)
            {
                return (Orders)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ShoppingCart$Orders);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public Orders[] newArray(int i)
            {
                return new Orders[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public static final Orders UNKNOWN = new Orders();
        public final Map itemsByOffer;


        protected Orders()
        {
            this(null);
        }

        public Orders(SortedMap sortedmap)
        {
            if (sortedmap != null)
            {
                sortedmap = Collections.unmodifiableSortedMap(sortedmap);
            } else
            {
                sortedmap = Collections.emptyMap();
            }
            itemsByOffer = sortedmap;
        }
    }

    public static class Promotion extends BaseDataMapped
        implements Parcelable, Comparable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Promotion createFromParcel(Parcel parcel)
            {
                return (Promotion)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ShoppingCart$Promotion);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public Promotion[] newArray(int i)
            {
                return new Promotion[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public static final Promotion UNKNOWN = new Promotion();
        public final CurrencyAmount discount;
        public final String message;
        public final String offerCode;
        public final OfferType offerType;
        public final PromotionType promotionType;
        public final String seedCategoryId;
        public final String sellerUserId;
        public final Status status;

        public int compareTo(Promotion promotion)
        {
            boolean flag = true;
            int i;
            if (this == promotion)
            {
                i = 0;
            } else
            {
                i = ((flag) ? 1 : 0);
                if (promotion != null)
                {
                    if (status == promotion.status)
                    {
                        return offerCode.compareTo(promotion.offerCode);
                    }
                    i = ((flag) ? 1 : 0);
                    if (status != Status.APPLIED)
                    {
                        return -1;
                    }
                }
            }
            return i;
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((Promotion)obj);
        }

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (!(obj instanceof Promotion))
                {
                    return false;
                }
                if (obj.hashCode() != hashCode())
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            return offerCode.hashCode();
        }


        public Promotion()
        {
            this(null, null, null, null, null, null, null, null);
        }

        public Promotion(String s, OfferType offertype, PromotionType promotiontype, Status status1, CurrencyAmount currencyamount, String s1, String s2, 
                String s3)
        {
            if (s == null)
            {
                s = "";
            }
            offerCode = s;
            if (offertype == null)
            {
                offertype = OfferType.None;
            }
            offerType = offertype;
            if (promotiontype == null)
            {
                promotiontype = PromotionType.None;
            }
            promotionType = promotiontype;
            if (status1 == null)
            {
                status1 = Status.NOT_APPLIED;
            }
            status = status1;
            if (currencyamount == null)
            {
                currencyamount = CurrencyAmount.ZERO;
            }
            discount = currencyamount;
            if (s1 == null)
            {
                s1 = "";
            }
            message = s1;
            if (s2 == null)
            {
                s2 = "";
            }
            sellerUserId = s2;
            if (s3 == null)
            {
                s3 = "";
            }
            seedCategoryId = s3;
        }
    }

    public static final class Promotion.OfferType extends Enum
    {

        private static final Promotion.OfferType $VALUES[];
        public static final Promotion.OfferType BundleOffer;
        public static final Promotion.OfferType MarkDownSale;
        public static final Promotion.OfferType None;
        public static final Promotion.OfferType OrderSubTotalOffer;
        public static final Promotion.OfferType PromotionalShipping;
        public static final Promotion.OfferType RebateOffer;
        public static final Promotion.OfferType SaleAndClearence;
        public static final Promotion.OfferType SaleEvent;
        public static final Promotion.OfferType TargetedOffer;
        public static final Promotion.OfferType VerticalOffer;

        public static Promotion.OfferType from(String s)
        {
            try
            {
                s = valueOf(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return None;
            }
            return s;
        }

        public static Promotion.OfferType valueOf(String s)
        {
            return (Promotion.OfferType)Enum.valueOf(com/ebay/nautilus/domain/data/ShoppingCart$Promotion$OfferType, s);
        }

        public static Promotion.OfferType[] values()
        {
            return (Promotion.OfferType[])$VALUES.clone();
        }

        static 
        {
            None = new Promotion.OfferType("None", 0);
            BundleOffer = new Promotion.OfferType("BundleOffer", 1);
            OrderSubTotalOffer = new Promotion.OfferType("OrderSubTotalOffer", 2);
            SaleEvent = new Promotion.OfferType("SaleEvent", 3);
            PromotionalShipping = new Promotion.OfferType("PromotionalShipping", 4);
            SaleAndClearence = new Promotion.OfferType("SaleAndClearence", 5);
            VerticalOffer = new Promotion.OfferType("VerticalOffer", 6);
            RebateOffer = new Promotion.OfferType("RebateOffer", 7);
            MarkDownSale = new Promotion.OfferType("MarkDownSale", 8);
            TargetedOffer = new Promotion.OfferType("TargetedOffer", 9);
            $VALUES = (new Promotion.OfferType[] {
                None, BundleOffer, OrderSubTotalOffer, SaleEvent, PromotionalShipping, SaleAndClearence, VerticalOffer, RebateOffer, MarkDownSale, TargetedOffer
            });
        }

        private Promotion.OfferType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Promotion.PromotionType extends Enum
    {

        private static final Promotion.PromotionType $VALUES[];
        public static final Promotion.PromotionType BillMeLaterPromotionalOffer;
        public static final Promotion.PromotionType None;
        public static final Promotion.PromotionType SME;
        public static final Promotion.PromotionType SellerDiscountedPromotionalOffer;
        public static final Promotion.PromotionType ShippingPromotionalOffer;
        public final boolean isSellerPromotion;

        public static Promotion.PromotionType from(String s)
        {
            if (TextUtils.isEmpty(s))
            {
                return None;
            }
            try
            {
                s = valueOf(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return None;
            }
            return s;
        }

        public static Promotion.PromotionType valueOf(String s)
        {
            return (Promotion.PromotionType)Enum.valueOf(com/ebay/nautilus/domain/data/ShoppingCart$Promotion$PromotionType, s);
        }

        public static Promotion.PromotionType[] values()
        {
            return (Promotion.PromotionType[])$VALUES.clone();
        }

        static 
        {
            None = new Promotion.PromotionType("None", 0, false);
            BillMeLaterPromotionalOffer = new Promotion.PromotionType("BillMeLaterPromotionalOffer", 1, false);
            ShippingPromotionalOffer = new Promotion.PromotionType("ShippingPromotionalOffer", 2, true);
            SellerDiscountedPromotionalOffer = new Promotion.PromotionType("SellerDiscountedPromotionalOffer", 3, true);
            SME = new Promotion.PromotionType("SME", 4, false);
            $VALUES = (new Promotion.PromotionType[] {
                None, BillMeLaterPromotionalOffer, ShippingPromotionalOffer, SellerDiscountedPromotionalOffer, SME
            });
        }

        private Promotion.PromotionType(String s, int i, boolean flag)
        {
            super(s, i);
            isSellerPromotion = flag;
        }
    }

    public static final class Promotion.Status extends Enum
    {

        private static final Promotion.Status $VALUES[];
        public static final Promotion.Status APPLIED;
        public static final Promotion.Status NOT_APPLIED;

        public static Promotion.Status from(String s)
        {
            try
            {
                s = valueOf(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return NOT_APPLIED;
            }
            return s;
        }

        public static Promotion.Status valueOf(String s)
        {
            return (Promotion.Status)Enum.valueOf(com/ebay/nautilus/domain/data/ShoppingCart$Promotion$Status, s);
        }

        public static Promotion.Status[] values()
        {
            return (Promotion.Status[])$VALUES.clone();
        }

        static 
        {
            NOT_APPLIED = new Promotion.Status("NOT_APPLIED", 0);
            APPLIED = new Promotion.Status("APPLIED", 1);
            $VALUES = (new Promotion.Status[] {
                NOT_APPLIED, APPLIED
            });
        }

        private Promotion.Status(String s, int i)
        {
            super(s, i);
        }
    }

    public static class Seller extends BaseDataMapped
        implements Parcelable, Comparable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Seller createFromParcel(Parcel parcel)
            {
                return (Seller)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ShoppingCart$Seller);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public Seller[] newArray(int i)
            {
                return new Seller[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public static final Seller UNKNOWN = new Seller();
        public final int feedbackScore;
        public final boolean isOnVacation;
        public final String username;
        public final Date vacationEndsOn;

        public int compareTo(Seller seller)
        {
            if (this == seller)
            {
                return 0;
            }
            if (seller == null)
            {
                return 1;
            } else
            {
                return username.compareTo(seller.username);
            }
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((Seller)obj);
        }


        protected Seller()
        {
            this(null, 0, false, null);
        }

        public Seller(String s, int i, boolean flag, Date date)
        {
            if (s == null)
            {
                s = "";
            }
            username = s;
            feedbackScore = i;
            isOnVacation = flag;
            if (!flag || date == null)
            {
                date = new Date(0L);
            }
            vacationEndsOn = date;
        }
    }

    public static final class Summary extends BaseDataMapped
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Summary createFromParcel(Parcel parcel)
            {
                return (Summary)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ShoppingCart$Summary);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public Summary[] newArray(int i)
            {
                return new Summary[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public static final Summary UNKNOWN = new Summary();
        public final CurrencyAmount adjustmentsSubTotal;
        private final Set currencyCodes;
        public final CurrencyAmount discount;
        public final boolean hasBopisItem;
        public final CurrencyAmount importCharges;
        public final CurrencyAmount itemSubTotal;
        public final CurrencyAmount shippingSubTotal;
        public final CurrencyAmount taxSubTotal;
        public final CurrencyAmount total;
        public final int totalBuyableItems;
        public final int totalTransactedItems;
        public final int totalUnbuyableItems;

        public boolean isLocalCurrencyCart(String s)
        {
            boolean flag = true;
            if (TextUtils.isEmpty(s) || currencyCodes.isEmpty())
            {
                flag = false;
            } else
            if (currencyCodes.size() != 1 || !currencyCodes.contains(s))
            {
                return false;
            }
            return flag;
        }


        protected Summary()
        {
            this(null, null, null, null, null, null, null, 0, 0, 0, false, null);
        }

        public Summary(CurrencyAmount currencyamount, CurrencyAmount currencyamount1, CurrencyAmount currencyamount2, CurrencyAmount currencyamount3, CurrencyAmount currencyamount4, CurrencyAmount currencyamount5, CurrencyAmount currencyamount6, 
                int i, int j, int k, boolean flag)
        {
            this(currencyamount, currencyamount1, currencyamount2, currencyamount3, currencyamount4, currencyamount5, currencyamount6, i, j, k, flag, null);
        }

        public Summary(CurrencyAmount currencyamount, CurrencyAmount currencyamount1, CurrencyAmount currencyamount2, CurrencyAmount currencyamount3, CurrencyAmount currencyamount4, CurrencyAmount currencyamount5, CurrencyAmount currencyamount6, 
                int i, int j, int k, boolean flag, Set set)
        {
            if (currencyamount == null)
            {
                currencyamount = CurrencyAmount.ZERO;
            }
            itemSubTotal = currencyamount;
            if (currencyamount2 == null)
            {
                currencyamount2 = CurrencyAmount.ZERO;
            }
            importCharges = currencyamount2;
            if (currencyamount1 == null)
            {
                currencyamount1 = CurrencyAmount.ZERO;
            }
            shippingSubTotal = currencyamount1;
            if (currencyamount3 == null)
            {
                currencyamount3 = CurrencyAmount.ZERO;
            }
            discount = currencyamount3;
            if (currencyamount4 == null)
            {
                currencyamount4 = CurrencyAmount.ZERO;
            }
            adjustmentsSubTotal = currencyamount4;
            if (currencyamount5 == null)
            {
                currencyamount5 = CurrencyAmount.ZERO;
            }
            taxSubTotal = currencyamount5;
            if (currencyamount6 == null)
            {
                currencyamount6 = CurrencyAmount.ZERO;
            }
            total = currencyamount6;
            totalBuyableItems = j;
            totalUnbuyableItems = i;
            totalTransactedItems = k;
            hasBopisItem = flag;
            if (set == null)
            {
                set = Collections.emptySet();
            }
            currencyCodes = set;
        }

        public Summary(Summary summary1, Set set)
        {
            if (summary1 == null)
            {
                throw new RuntimeException("Cart Summary Is Null");
            }
            itemSubTotal = summary1.itemSubTotal;
            importCharges = summary1.importCharges;
            shippingSubTotal = summary1.shippingSubTotal;
            discount = summary1.discount;
            adjustmentsSubTotal = summary1.adjustmentsSubTotal;
            taxSubTotal = summary1.taxSubTotal;
            total = summary1.total;
            totalBuyableItems = summary1.totalBuyableItems;
            totalUnbuyableItems = summary1.totalUnbuyableItems;
            totalTransactedItems = summary1.totalTransactedItems;
            hasBopisItem = summary1.hasBopisItem;
            if (set == null)
            {
                set = Collections.emptySet();
            }
            currencyCodes = set;
        }
    }

    public static class Transaction extends BaseDataMapped
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Transaction createFromParcel(Parcel parcel)
            {
                return (Transaction)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ShoppingCart$Transaction);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public Transaction[] newArray(int i)
            {
                return new Transaction[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public static final Transaction UNKNOWN = new Transaction();
        public final Long ebayItemId;
        public final ItemCurrencyWithConversion itemPrice;
        public final int requestedQuantity;
        public final Long transactionId;
        public final String variationId;


        protected Transaction()
        {
            this(null, null, null, null, 0);
        }

        public Transaction(Long long1, String s, Long long2, ItemCurrencyWithConversion itemcurrencywithconversion, int i)
        {
            long l;
            if (long1 != null)
            {
                l = long1.longValue();
            } else
            {
                l = 0L;
            }
            ebayItemId = Long.valueOf(l);
            variationId = s;
            if (long2 != null)
            {
                l = long2.longValue();
            } else
            {
                l = -1L;
            }
            transactionId = Long.valueOf(l);
            if (itemcurrencywithconversion == null)
            {
                itemcurrencywithconversion = ItemCurrencyWithConversion.ZERO;
            }
            itemPrice = itemcurrencywithconversion;
            requestedQuantity = i;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ShoppingCart createFromParcel(Parcel parcel)
        {
            return (ShoppingCart)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ShoppingCart);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ShoppingCart[] newArray(int i)
        {
            return new ShoppingCart[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final ShoppingCart EMPTY = new ShoppingCart();
    public static final String PAYMENT_METHOD_PAYPAL = "PayPal";
    private transient List allItems;
    public final long cartId;
    private transient Map itemsByCurrency;
    private transient Map itemsById;
    public final Map itemsBySeller;
    public final List savedForLater;
    public final Address shippingAddress;
    public final Summary summary;
    private transient List unavailableItems;

    protected ShoppingCart()
    {
        this(0L, null, null, null, null);
    }

    public ShoppingCart(long l, SortedMap sortedmap, List list, Summary summary1, Address address)
    {
        cartId = l;
        if (sortedmap != null)
        {
            sortedmap = Collections.unmodifiableSortedMap(sortedmap);
        } else
        {
            sortedmap = Collections.emptyMap();
        }
        itemsBySeller = sortedmap;
        if (list != null)
        {
            sortedmap = Collections.unmodifiableList(list);
        } else
        {
            sortedmap = Collections.emptyList();
        }
        savedForLater = sortedmap;
        if (summary1 != null)
        {
            sortedmap = new Summary(summary1, getItemsByCurrency().keySet());
        } else
        {
            sortedmap = Summary.UNKNOWN;
        }
        summary = sortedmap;
        if (address == null)
        {
            address = Address.UNKNOWN;
        }
        shippingAddress = address;
    }

    public static String createItemKey(long l, String s)
    {
        return createItemKey(l, s, "");
    }

    public static String createItemKey(long l, String s, String s1)
    {
        StringBuilder stringbuilder = (new StringBuilder()).append(Long.toString(l));
        if (TextUtils.isEmpty(s))
        {
            s = "";
        } else
        {
            s = (new StringBuilder()).append(":").append(s).toString();
        }
        stringbuilder = stringbuilder.append(s);
        if (TextUtils.isEmpty(s1))
        {
            s = ":-1";
        } else
        {
            s = (new StringBuilder()).append(":").append(s1).toString();
        }
        return stringbuilder.append(s).toString();
    }

    public List getAllItems()
    {
        if (allItems == null)
        {
            LinkedList linkedlist = new LinkedList();
            for (Iterator iterator = itemsBySeller.values().iterator(); iterator.hasNext();)
            {
                Iterator iterator1 = ((Orders)iterator.next()).itemsByOffer.values().iterator();
                while (iterator1.hasNext()) 
                {
                    linkedlist.addAll((List)iterator1.next());
                }
            }

            allItems = Collections.unmodifiableList(linkedlist);
        }
        return allItems;
    }

    public Item getItemById(long l, String s)
    {
        s = createItemKey(l, s);
        Map map = getItemsById();
        if (map.containsKey(s))
        {
            return (Item)map.get(s);
        } else
        {
            return null;
        }
    }

    public List getItemsByCurrency(String s)
    {
        Map map = getItemsByCurrency();
        if (map.containsKey(s))
        {
            return (List)map.get(s);
        } else
        {
            return Collections.emptyList();
        }
    }

    public Map getItemsByCurrency()
    {
        if (itemsByCurrency == null)
        {
            HashMap hashmap = new HashMap();
            Item item;
            String s;
            for (Iterator iterator = getAllItems().iterator(); iterator.hasNext(); ((List)hashmap.get(s)).add(item))
            {
                item = (Item)iterator.next();
                s = item.itemPrice.listedPrice.getCurrencyCode();
                if (!hashmap.containsKey(s))
                {
                    hashmap.put(s, new LinkedList());
                }
            }

            itemsByCurrency = Collections.unmodifiableMap(hashmap);
        }
        return itemsByCurrency;
    }

    public Map getItemsById()
    {
        if (itemsById == null)
        {
            HashMap hashmap = new HashMap();
            Item item;
            for (Iterator iterator = getAllItems().iterator(); iterator.hasNext(); hashmap.put(createItemKey(item.ebayItemId.longValue(), item.variationId), item))
            {
                item = (Item)iterator.next();
            }

            itemsById = Collections.unmodifiableMap(hashmap);
        }
        return itemsById;
    }

    public List getUnavailableItems()
    {
        if (unavailableItems == null)
        {
            LinkedList linkedlist = new LinkedList();
            Iterator iterator = getAllItems().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Item item = (Item)iterator.next();
                if (item.isEnded)
                {
                    linkedlist.add(item);
                }
            } while (true);
            unavailableItems = Collections.unmodifiableList(linkedlist);
        }
        return unavailableItems;
    }

    public boolean isMultipleCurrencyCart()
    {
        return getItemsByCurrency().size() > 1;
    }

}
