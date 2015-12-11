// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import java.util.Date;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            MyEbayListItem, ItemCurrency, OrderPickupStatus

public static final class pickupStatus
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

    public ()
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

    feedbackReceived(Parcel parcel)
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
            obj = (ItemCurrency)ItemCurrency.CREATOR.omParcel(parcel);
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
