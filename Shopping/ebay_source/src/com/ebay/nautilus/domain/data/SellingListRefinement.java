// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class SellingListRefinement
    implements Parcelable
{

    public static final String ACTIVE_FILTER_ALL = "activeAll";
    public static final String ACTIVE_FILTER_AUCTION = "Auction";
    public static final String ACTIVE_FILTER_FIXED_PRICE = "FixedPrice";
    public static final String ACTIVE_FILTER_WILL_SELL = "WillSell";
    public static final String ACTIVE_FILTER_WITH_OFFERS = "NewOffers";
    public static final String ACTIVE_SORT_BID_COUNT = "BidCount";
    public static final String ACTIVE_SORT_DEFAULT = "activeDefault";
    public static final String ACTIVE_SORT_NEWLY_LISTED = "NewlyListed";
    public static final String ACTIVE_SORT_WATCH_COUNT = "WatchCount";
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SellingListRefinement createFromParcel(Parcel parcel)
        {
            return new SellingListRefinement(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public SellingListRefinement[] newArray(int i)
        {
            return new SellingListRefinement[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final String DEFAULT_FILTER = "All";
    public static final String SOLD_FILTER_ALL = "soldAll";
    public static final String SOLD_FILTER_AWAITING_PAYMENT = "AwaitingPayment";
    public static final String SOLD_FILTER_AWAITING_SHIPMENT = "AwaitingShipment";
    public static final String SOLD_SORT_DEFAULT = "soldDefault";
    public static String SupportedMyEbayActiveFilters[] = {
        "activeAll", "Auction", "FixedPrice", "NewOffers"
    };
    public static String SupportedMyEbaySoldFilters[] = {
        "soldAll", "AwaitingPayment", "AwaitingShipment"
    };
    public static final String UNSOLD_FILTER_ALL = "unsoldAll";
    public static final String UNSOLD_FILTER_NOT_YET_RELISTED = "NotYetRelisted";
    public String filter;
    public String listName;
    public String sortOrder;

    public SellingListRefinement(Parcel parcel)
    {
        listName = parcel.readString();
        sortOrder = parcel.readString();
        filter = parcel.readString();
    }

    public SellingListRefinement(SellingListRefinement sellinglistrefinement)
    {
        listName = sellinglistrefinement.listName;
        sortOrder = sellinglistrefinement.sortOrder;
        filter = sellinglistrefinement.filter;
    }

    private SellingListRefinement(String s)
    {
        listName = s;
    }

    public static SellingListRefinement buildDefaultActive()
    {
        SellingListRefinement sellinglistrefinement = new SellingListRefinement("ActiveList");
        sellinglistrefinement.resetDefault();
        return sellinglistrefinement;
    }

    public static SellingListRefinement buildDefaultSold()
    {
        SellingListRefinement sellinglistrefinement = new SellingListRefinement("SoldList");
        sellinglistrefinement.resetDefault();
        return sellinglistrefinement;
    }

    public static String getTrackingFilterName(String s)
    {
        String s1;
label0:
        {
            if (!"activeAll".equals(s) && !"soldAll".equals(s))
            {
                s1 = s;
                if (!"unsoldAll".equals(s))
                {
                    break label0;
                }
            }
            s1 = "All";
        }
        return s1;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof SellingListRefinement)
        {
            obj = (SellingListRefinement)obj;
            flag = flag1;
            if (TextUtils.equals(listName, ((SellingListRefinement) (obj)).listName))
            {
                flag = flag1;
                if (TextUtils.equals(filter, ((SellingListRefinement) (obj)).filter))
                {
                    flag = flag1;
                    if (TextUtils.equals(sortOrder, ((SellingListRefinement) (obj)).sortOrder))
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return ((listName.hashCode() + 31) * 31 + sortOrder.hashCode()) * 31 + filter.hashCode();
    }

    public boolean isDefault()
    {
        boolean flag1 = false;
        boolean flag;
        if ("ActiveList".equals(listName))
        {
            flag = flag1;
            if ("activeAll".equals(filter))
            {
                flag = flag1;
                if ("activeDefault".equals(sortOrder))
                {
                    flag = true;
                }
            }
        } else
        {
            flag = flag1;
            if ("SoldList".equals(listName))
            {
                return "soldAll".equals(filter);
            }
        }
        return flag;
    }

    public void resetDefault()
    {
        if ("ActiveList".equals(listName))
        {
            filter = "activeAll";
            sortOrder = "activeDefault";
        } else
        if ("SoldList".equals(listName))
        {
            filter = "soldAll";
            sortOrder = "soldDefault";
            return;
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(listName);
        parcel.writeString(sortOrder);
        parcel.writeString(filter);
    }

}
