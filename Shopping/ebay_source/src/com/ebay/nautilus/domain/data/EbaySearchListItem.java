// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ItemCurrency, Distance

public class EbaySearchListItem
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public EbaySearchListItem createFromParcel(Parcel parcel)
        {
            return new EbaySearchListItem(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public EbaySearchListItem[] newArray(int i)
        {
            return new EbaySearchListItem[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final int IS_bestOfferEnabled = 2;
    private static final int IS_buyItNowAvailable = 4;
    private static final int IS_ebn = 32768;
    private static final int IS_fromSaaS = 16384;
    private static final int IS_gift = 512;
    private static final int IS_inStorePickup = 2048;
    private static final int IS_msku = 0x200000;
    private static final int IS_pickupAndDropOff = 0x10000;
    private static final int IS_plusEligible = 0x1000000;
    public static final int LISTING_TYPE_AD_FORMAT = 1;
    public static final int LISTING_TYPE_AUCTION = 2;
    public static final int LISTING_TYPE_AUCTION_WITH_BIN = 3;
    public static final int LISTING_TYPE_CLASSIFIED = 4;
    public static final int LISTING_TYPE_FIXED_PRICE = 5;
    public static final int LISTING_TYPE_STORE_INVENTORY = 6;
    public static final int LISTING_TYPE_UNKNOWN = 0;
    public static final int SELLING_STATE_ACTIVE = 1;
    public static final int SELLING_STATE_CANCELED = 2;
    public static final int SELLING_STATE_ENDED = 3;
    public static final int SELLING_STATE_ENDED_WITHOUT_SALES = 5;
    public static final int SELLING_STATE_ENDED_WITH_SALES = 4;
    public static final int SELLING_STATE_UNKNOWN = 0;
    private static final int SET_bestOfferAmount = 1;
    private static final int SET_buyItNowPrice = 32;
    private static final int SET_convertedBuyItNowPrice = 64;
    private static final int SET_convertedCurrentPrice = 16;
    private static final int SET_convertedMaxPrice = 0x100000;
    private static final int SET_convertedMinPrice = 0x40000;
    private static final int SET_currentPrice = 8;
    private static final int SET_distance = 0x400000;
    private static final int SET_endDate = 128;
    private static final int SET_maxPrice = 0x80000;
    private static final int SET_minPrice = 0x20000;
    private static final int SET_originalRetailPrice = 1024;
    private static final int SET_reservePrice = 0x800000;
    private static final int SET_saasLargeImageUrl = 8192;
    private static final int SET_saasThumbnailUrl = 4096;
    private static final int SET_shippingCost = 256;
    public ItemCurrency bestOfferAmount;
    public boolean bestOfferEnabled;
    public String bestOfferStatus;
    public int bidCount;
    public boolean buyItNowAvailable;
    public ItemCurrency buyItNowPrice;
    public ItemCurrency convertedBuyItNowPrice;
    public ItemCurrency convertedCurrentPrice;
    public ItemCurrency convertedMaxPrice;
    public ItemCurrency convertedMinPrice;
    public ItemCurrency currentPrice;
    public Distance distance;
    public String eekRating;
    public Date endDate;
    public boolean gift;
    public long id;
    public String imageMd5Hash;
    public String imageUrl;
    public String imageZoomGuid;
    public boolean isEbn;
    public boolean isFromSaaS;
    public boolean isInStorePickup;
    public boolean isMsku;
    public boolean isPickupAndDropOff;
    public boolean isPlusEligible;
    public int listingType;
    public String masterImageUrl;
    public ItemCurrency maxPrice;
    public ItemCurrency minPrice;
    public ItemCurrency originalRetailPrice;
    public String pricingTreatment;
    public ItemCurrency reservePrice;
    public int sellingState;
    public String shipToLocation;
    public ItemCurrency shippingCost;
    public String shippingType;
    public String superSizeImageUrl;
    public String title;
    public String unitPriceQuantity;
    public String unitPriceType;

    public EbaySearchListItem()
    {
    }

    protected EbaySearchListItem(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        int i = parcel.readInt();
        id = parcel.readLong();
        sellingState = parcel.readInt();
        listingType = parcel.readInt();
        Object obj;
        boolean flag;
        if ((i & 1) != 0)
        {
            obj = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
        } else
        {
            obj = null;
        }
        bestOfferAmount = ((ItemCurrency) (obj));
        bestOfferStatus = parcel.readString();
        if ((i & 2) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bestOfferEnabled = flag;
        if ((i & 4) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        buyItNowAvailable = flag;
        imageUrl = parcel.readString();
        masterImageUrl = parcel.readString();
        superSizeImageUrl = parcel.readString();
        title = parcel.readString();
        if ((i & 8) != 0)
        {
            obj = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
        } else
        {
            obj = null;
        }
        currentPrice = ((ItemCurrency) (obj));
        if ((i & 0x10) != 0)
        {
            obj = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
        } else
        {
            obj = null;
        }
        convertedCurrentPrice = ((ItemCurrency) (obj));
        if ((0x800000 & i) != 0)
        {
            obj = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
        } else
        {
            obj = null;
        }
        reservePrice = ((ItemCurrency) (obj));
        if ((i & 0x20) != 0)
        {
            obj = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
        } else
        {
            obj = null;
        }
        buyItNowPrice = ((ItemCurrency) (obj));
        if ((i & 0x40) != 0)
        {
            obj = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
        } else
        {
            obj = null;
        }
        convertedBuyItNowPrice = ((ItemCurrency) (obj));
        if ((0x20000 & i) != 0)
        {
            obj = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
        } else
        {
            obj = null;
        }
        minPrice = ((ItemCurrency) (obj));
        if ((0x40000 & i) != 0)
        {
            obj = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
        } else
        {
            obj = null;
        }
        convertedMinPrice = ((ItemCurrency) (obj));
        if ((0x80000 & i) != 0)
        {
            obj = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
        } else
        {
            obj = null;
        }
        maxPrice = ((ItemCurrency) (obj));
        if ((0x100000 & i) != 0)
        {
            obj = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
        } else
        {
            obj = null;
        }
        convertedMaxPrice = ((ItemCurrency) (obj));
        bidCount = parcel.readInt();
        if ((i & 0x80) != 0)
        {
            obj = new Date(parcel.readLong());
        } else
        {
            obj = null;
        }
        endDate = ((Date) (obj));
        if ((i & 0x100) != 0)
        {
            obj = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
        } else
        {
            obj = null;
        }
        shippingCost = ((ItemCurrency) (obj));
        if ((i & 0x200) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        gift = flag;
        if ((i & 0x400) != 0)
        {
            obj = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
        } else
        {
            obj = null;
        }
        originalRetailPrice = ((ItemCurrency) (obj));
        pricingTreatment = parcel.readString();
        shippingType = parcel.readString();
        shipToLocation = parcel.readString();
        unitPriceType = parcel.readString();
        unitPriceQuantity = parcel.readString();
        if ((i & 0x800) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isInStorePickup = flag;
        if ((i & 0x4000) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isFromSaaS = flag;
        if ((0x8000 & i) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isEbn = flag;
        if ((0x10000 & i) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isPickupAndDropOff = flag;
        if ((0x200000 & i) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isMsku = flag;
        eekRating = parcel.readString();
        if ((0x400000 & i) != 0)
        {
            parcel = (Distance)Distance.CREATOR.createFromParcel(parcel);
        } else
        {
            parcel = null;
        }
        distance = parcel;
        if ((0x1000000 & i) != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        isPlusEligible = flag;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        int k2 = 0;
        boolean flag;
        byte byte0;
        byte byte1;
        byte byte2;
        byte byte3;
        int j;
        byte byte4;
        byte byte5;
        int k;
        int l;
        int i1;
        int j1;
        char c;
        char c1;
        char c2;
        char c3;
        char c4;
        char c5;
        int k1;
        int l1;
        int i2;
        int j2;
        if (bestOfferAmount != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (bestOfferEnabled)
        {
            byte0 = 2;
        } else
        {
            byte0 = 0;
        }
        if (buyItNowAvailable)
        {
            byte1 = 4;
        } else
        {
            byte1 = 0;
        }
        if (currentPrice != null)
        {
            byte2 = 8;
        } else
        {
            byte2 = 0;
        }
        if (convertedCurrentPrice != null)
        {
            byte3 = 16;
        } else
        {
            byte3 = 0;
        }
        if (reservePrice != null)
        {
            j = 0x800000;
        } else
        {
            j = 0;
        }
        if (buyItNowPrice != null)
        {
            byte4 = 32;
        } else
        {
            byte4 = 0;
        }
        if (convertedBuyItNowPrice != null)
        {
            byte5 = 64;
        } else
        {
            byte5 = 0;
        }
        if (minPrice != null)
        {
            k = 0x20000;
        } else
        {
            k = 0;
        }
        if (convertedMinPrice != null)
        {
            l = 0x40000;
        } else
        {
            l = 0;
        }
        if (maxPrice != null)
        {
            i1 = 0x80000;
        } else
        {
            i1 = 0;
        }
        if (convertedMaxPrice != null)
        {
            j1 = 0x100000;
        } else
        {
            j1 = 0;
        }
        if (endDate != null)
        {
            c = '\200';
        } else
        {
            c = '\0';
        }
        if (shippingCost != null)
        {
            c1 = '\u0100';
        } else
        {
            c1 = '\0';
        }
        if (gift)
        {
            c2 = '\u0200';
        } else
        {
            c2 = '\0';
        }
        if (originalRetailPrice != null)
        {
            c3 = '\u0400';
        } else
        {
            c3 = '\0';
        }
        if (isInStorePickup)
        {
            c4 = '\u0800';
        } else
        {
            c4 = '\0';
        }
        if (isFromSaaS)
        {
            c5 = '\u4000';
        } else
        {
            c5 = '\0';
        }
        if (isEbn)
        {
            k1 = 32768;
        } else
        {
            k1 = 0;
        }
        if (isPickupAndDropOff)
        {
            l1 = 0x10000;
        } else
        {
            l1 = 0;
        }
        if (isMsku)
        {
            i2 = 0x200000;
        } else
        {
            i2 = 0;
        }
        if (distance != null)
        {
            j2 = 0x400000;
        } else
        {
            j2 = 0;
        }
        if (isPlusEligible)
        {
            k2 = 0x1000000;
        }
        parcel.writeInt(j2 | (byte0 | flag | byte1 | byte2 | byte3 | j | byte4 | byte5 | k | l | i1 | j1 | c | c1 | c2 | c3 | c4 | c5 | k1 | l1 | i2) | k2);
        parcel.writeLong(id);
        parcel.writeInt(sellingState);
        parcel.writeInt(listingType);
        if (bestOfferAmount != null)
        {
            bestOfferAmount.writeToParcel(parcel, i);
        }
        parcel.writeString(bestOfferStatus);
        parcel.writeString(imageUrl);
        parcel.writeString(masterImageUrl);
        parcel.writeString(superSizeImageUrl);
        parcel.writeString(title);
        if (currentPrice != null)
        {
            currentPrice.writeToParcel(parcel, i);
        }
        if (convertedCurrentPrice != null)
        {
            convertedCurrentPrice.writeToParcel(parcel, i);
        }
        if (reservePrice != null)
        {
            reservePrice.writeToParcel(parcel, i);
        }
        if (buyItNowPrice != null)
        {
            buyItNowPrice.writeToParcel(parcel, i);
        }
        if (convertedBuyItNowPrice != null)
        {
            convertedBuyItNowPrice.writeToParcel(parcel, i);
        }
        if (minPrice != null)
        {
            minPrice.writeToParcel(parcel, i);
        }
        if (convertedMinPrice != null)
        {
            convertedMinPrice.writeToParcel(parcel, i);
        }
        if (maxPrice != null)
        {
            maxPrice.writeToParcel(parcel, i);
        }
        if (convertedMaxPrice != null)
        {
            convertedMaxPrice.writeToParcel(parcel, i);
        }
        parcel.writeInt(bidCount);
        if (endDate != null)
        {
            parcel.writeLong(endDate.getTime());
        }
        if (shippingCost != null)
        {
            shippingCost.writeToParcel(parcel, i);
        }
        if (originalRetailPrice != null)
        {
            originalRetailPrice.writeToParcel(parcel, i);
        }
        parcel.writeString(pricingTreatment);
        parcel.writeString(shippingType);
        parcel.writeString(shipToLocation);
        parcel.writeString(unitPriceType);
        parcel.writeString(unitPriceQuantity);
        parcel.writeString(eekRating);
        if (distance != null)
        {
            distance.writeToParcel(parcel, i);
        }
    }

}
