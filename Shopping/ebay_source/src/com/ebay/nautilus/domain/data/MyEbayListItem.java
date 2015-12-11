// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            EbaySearchListItem, ItemCurrency, NameValue, OrderPickupStatus

public class MyEbayListItem extends EbaySearchListItem
    implements Parcelable, Comparable
{
    public static final class Transaction
    {

        public static final String PICKUP_STATUS_NOT_APPLICABLE = "NotApplicable";
        public Date createdDate;
        public boolean feedbackLeft;
        public boolean feedbackReceived;
        public String orderId;
        public String paidStatus;
        public String paidTime;
        public String pickupMethod;
        public OrderPickupStatus pickupStatus;
        public String pickupStoreId;
        public int quantityPurchased;
        public boolean shipped;
        public ItemCurrency totalTransactionPrice;
        public String transactionId;

        public boolean isPaid()
        {
            return "Complete".equals(paidStatus) || "MarkedAsPaid".equals(paidStatus) || "Paid".equals(paidStatus) || "PaidCOD".equals(paidStatus) || "PaidWithEscrow".equals(paidStatus) || "PaidWithPaisaPay".equals(paidStatus) || "PaidWithPaisaPayEscrow".equals(paidStatus) || "PaidWithPayPal".equals(paidStatus);
        }

        final void write(Parcel parcel)
        {
            byte byte2 = 0;
            int i;
            byte byte0;
            byte byte1;
            if (createdDate != null)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (totalTransactionPrice != null)
            {
                byte0 = 2;
            } else
            {
                byte0 = 0;
            }
            if (feedbackLeft)
            {
                byte1 = 4;
            } else
            {
                byte1 = 0;
            }
            if (feedbackReceived)
            {
                byte2 = 8;
            }
            i = byte1 | (byte0 | i) | byte2;
            parcel.writeInt(i);
            if (createdDate != null)
            {
                parcel.writeLong(createdDate.getTime());
            }
            if (totalTransactionPrice != null)
            {
                totalTransactionPrice.writeToParcel(parcel, i);
            }
            parcel.writeInt(quantityPurchased);
            parcel.writeString(paidStatus);
            parcel.writeString(transactionId);
            parcel.writeString(orderId);
            parcel.writeString(paidTime);
            parcel.writeString(pickupMethod);
            parcel.writeString(pickupStoreId);
            if (pickupStatus != null)
            {
                parcel.writeInt(pickupStatus.ordinal());
                return;
            } else
            {
                parcel.writeInt(-1);
                return;
            }
        }

        public Transaction()
        {
            createdDate = null;
            totalTransactionPrice = null;
            feedbackLeft = false;
            quantityPurchased = 0;
            paidStatus = null;
            transactionId = null;
            orderId = null;
            shipped = false;
            paidTime = null;
            feedbackReceived = false;
        }

        Transaction(Parcel parcel)
        {
            boolean flag1 = true;
            super();
            int i = parcel.readInt();
            Object obj;
            boolean flag;
            if ((i & 1) != 0)
            {
                obj = new Date(parcel.readLong());
            } else
            {
                obj = null;
            }
            createdDate = ((Date) (obj));
            if ((i & 2) != 0)
            {
                obj = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
            } else
            {
                obj = null;
            }
            totalTransactionPrice = ((ItemCurrency) (obj));
            if ((i & 4) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            feedbackLeft = flag;
            quantityPurchased = parcel.readInt();
            paidStatus = parcel.readString();
            transactionId = parcel.readString();
            orderId = parcel.readString();
            paidTime = parcel.readString();
            if ((i & 8) != 0)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            feedbackReceived = flag;
            pickupMethod = parcel.readString();
            pickupStoreId = parcel.readString();
            i = parcel.readInt();
            if (i != -1)
            {
                pickupStatus = OrderPickupStatus.values()[i];
            }
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public MyEbayListItem createFromParcel(Parcel parcel)
        {
            return new MyEbayListItem(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public MyEbayListItem[] newArray(int i)
        {
            return new MyEbayListItem[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final Comparator END_TIME_COMPARATOR = new Comparator() {

        public int compare(MyEbayListItem myebaylistitem, MyEbayListItem myebaylistitem1)
        {
            if (myebaylistitem.endTimestamp < myebaylistitem1.endTimestamp)
            {
                return 1;
            }
            return myebaylistitem.endTimestamp <= myebaylistitem1.endTimestamp ? 0 : -1;
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((MyEbayListItem)obj, (MyEbayListItem)obj1);
        }

    };
    private static final int IS_localPickup = 128;
    private static final int IS_reserveMet = 32;
    private static final int SET_convertedMaxBidPrice = 16;
    private static final int SET_convertedStartPrice = 4;
    private static final int SET_maxBidPrice = 8;
    private static final int SET_startDate = 1;
    private static final int SET_startPrice = 2;
    private static final int SET_transaction = 64;
    public static final String SHIPPING_TYPE_CALCULATED = "Calculated";
    public static final String SHIPPING_TYPE_FREE = "Free";
    public static final String SHIPPING_TYPE_FREIGHT = "Freight";
    public static final String SHIPPING_TYPE_NOT_SPECIFIED = "NotSpecified";
    public int bestOfferPendingCount;
    public String buyerUserID;
    public ItemCurrency convertedMaxBidPrice;
    public ItemCurrency convertedStartPrice;
    public long endTimestamp;
    public String highBidderId;
    public boolean isRelisted;
    public boolean localPickup;
    public ItemCurrency maxBidPrice;
    public ArrayList nameValueList;
    public String orderId;
    public boolean reserveMet;
    public Date startDate;
    public ItemCurrency startPrice;
    public Transaction transaction;
    public int watchCount;

    public MyEbayListItem()
    {
        localPickup = false;
    }

    MyEbayListItem(Parcel parcel)
    {
        boolean flag1 = true;
        Object obj1 = null;
        super(parcel);
        localPickup = false;
        int i = parcel.readInt();
        Object obj;
        boolean flag;
        if ((i & 1) != 0)
        {
            obj = new Date(parcel.readLong());
        } else
        {
            obj = null;
        }
        startDate = ((Date) (obj));
        endTimestamp = parcel.readLong();
        if ((i & 2) != 0)
        {
            obj = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
        } else
        {
            obj = null;
        }
        startPrice = ((ItemCurrency) (obj));
        if ((i & 4) != 0)
        {
            obj = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
        } else
        {
            obj = null;
        }
        convertedStartPrice = ((ItemCurrency) (obj));
        if ((i & 8) != 0)
        {
            obj = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
        } else
        {
            obj = null;
        }
        maxBidPrice = ((ItemCurrency) (obj));
        if ((i & 0x10) != 0)
        {
            obj = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
        } else
        {
            obj = null;
        }
        convertedMaxBidPrice = ((ItemCurrency) (obj));
        highBidderId = parcel.readString();
        if ((i & 0x20) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        reserveMet = flag;
        obj = obj1;
        if ((i & 0x40) != 0)
        {
            obj = new Transaction(parcel);
        }
        transaction = ((Transaction) (obj));
        watchCount = parcel.readInt();
        nameValueList = parcel.createTypedArrayList(NameValue.CREATOR);
        buyerUserID = parcel.readString();
        if ((i & 0x80) != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        localPickup = flag;
        orderId = parcel.readString();
        bestOfferPendingCount = parcel.readInt();
    }

    public int compareTo(MyEbayListItem myebaylistitem)
    {
        return title.compareTo(myebaylistitem.title);
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((MyEbayListItem)obj);
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("{").append("id: ").append(id).append(", title: ").append(title).append(", currentPrice: ").append(currentPrice).append(", convertedCurrentPrice: ").append(convertedCurrentPrice).append(", buyItNowPrice: ").append(buyItNowPrice).append(", convertedBuyItNowPrice: ").append(convertedBuyItNowPrice).append(", startPrice: ").append(startPrice).append(", convertedStartPrice: ").append(convertedStartPrice).append(", shippingCost: ").append(shippingCost).append(", startDate: ").append(startDate).append(", endDate: ").append(endDate).append(", highBidderId: ").append(highBidderId).append(", watchCount: ").append(watchCount).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        char c = '\0';
        super.writeToParcel(parcel, i);
        boolean flag;
        byte byte0;
        byte byte1;
        byte byte2;
        byte byte3;
        byte byte4;
        byte byte5;
        if (startDate != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (startPrice != null)
        {
            byte0 = 2;
        } else
        {
            byte0 = 0;
        }
        if (convertedStartPrice != null)
        {
            byte1 = 4;
        } else
        {
            byte1 = 0;
        }
        if (maxBidPrice != null)
        {
            byte2 = 8;
        } else
        {
            byte2 = 0;
        }
        if (convertedMaxBidPrice != null)
        {
            byte3 = 16;
        } else
        {
            byte3 = 0;
        }
        if (reserveMet)
        {
            byte4 = 32;
        } else
        {
            byte4 = 0;
        }
        if (transaction != null)
        {
            byte5 = 64;
        } else
        {
            byte5 = 0;
        }
        if (localPickup)
        {
            c = '\200';
        }
        parcel.writeInt(byte5 | (byte0 | flag | byte1 | byte2 | byte3 | byte4) | c);
        if (startDate != null)
        {
            parcel.writeLong(startDate.getTime());
        }
        parcel.writeLong(endTimestamp);
        if (startPrice != null)
        {
            startPrice.writeToParcel(parcel, i);
        }
        if (convertedStartPrice != null)
        {
            convertedStartPrice.writeToParcel(parcel, i);
        }
        if (maxBidPrice != null)
        {
            maxBidPrice.writeToParcel(parcel, i);
        }
        if (convertedMaxBidPrice != null)
        {
            convertedMaxBidPrice.writeToParcel(parcel, i);
        }
        parcel.writeString(highBidderId);
        if (transaction != null)
        {
            transaction.write(parcel);
        }
        parcel.writeInt(watchCount);
        parcel.writeTypedList(nameValueList);
        parcel.writeString(buyerUserID);
        parcel.writeString(orderId);
        parcel.writeInt(bestOfferPendingCount);
    }

}
