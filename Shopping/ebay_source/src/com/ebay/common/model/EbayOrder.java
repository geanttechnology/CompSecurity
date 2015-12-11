// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.OrderPickupStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.common.model:
//            ParcelableHelper, OrderItemTransaction, Refund, ItemTransaction

public class EbayOrder extends ParcelableHelper
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public EbayOrder createFromParcel(Parcel parcel)
        {
            return new EbayOrder(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public EbayOrder[] newArray(int i)
        {
            return new EbayOrder[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public ItemCurrency adjustmentAmount;
    public ItemCurrency amountPaid;
    public ItemCurrency amountSaved;
    public Date creationDate;
    public String eBayPaymentStatus;
    public String id;
    public Date lastModifiedTime;
    public String merchantPickupCode;
    public Date paidTime;
    public String paymentHoldStatus;
    public String paymentMethod;
    public String paymentMethods;
    public String pickupMethod;
    public String pickupPriority;
    public OrderPickupStatus pickupStatus;
    public List refunds;
    public String selectedMethod;
    public String sellerEmail;
    public ItemCurrency shippingCost;
    public String shippingService;
    public String status;
    public String statusXO;
    public String storeId;
    public ItemCurrency subtotal;
    public ItemCurrency total;
    public List transactions;

    public EbayOrder()
    {
        id = null;
        status = null;
        adjustmentAmount = null;
        amountPaid = null;
        amountSaved = null;
        creationDate = null;
        paymentMethods = null;
        sellerEmail = null;
        subtotal = null;
        total = null;
        transactions = null;
        pickupPriority = null;
        pickupMethod = null;
        selectedMethod = null;
        storeId = null;
        pickupStatus = null;
        merchantPickupCode = null;
        paymentHoldStatus = null;
        shippingService = null;
        shippingCost = null;
        eBayPaymentStatus = null;
        lastModifiedTime = null;
        paymentMethod = null;
        statusXO = null;
        refunds = null;
        paidTime = null;
    }

    EbayOrder(Parcel parcel)
    {
        Object obj = null;
        super();
        id = parcel.readString();
        status = parcel.readString();
        if (parcel.readInt() == 1)
        {
            adjustmentAmount = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() == 1)
        {
            amountPaid = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() == 1)
        {
            amountSaved = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
        }
        long l1 = parcel.readLong();
        Date date;
        int l;
        if (l1 != -1L)
        {
            date = new Date(l1);
        } else
        {
            date = null;
        }
        creationDate = date;
        paymentMethods = parcel.readString();
        sellerEmail = parcel.readString();
        subtotal = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
        total = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
        l = parcel.readInt();
        if (l > 0)
        {
            transactions = new ArrayList();
            for (int i = 0; i < l; i++)
            {
                transactions.add(OrderItemTransaction.CREATOR.createFromParcel(parcel));
            }

        }
        pickupMethod = parcel.readString();
        pickupPriority = parcel.readString();
        selectedMethod = parcel.readString();
        storeId = parcel.readString();
        int j = parcel.readInt();
        if (j != -1)
        {
            pickupStatus = OrderPickupStatus.values()[j];
        }
        merchantPickupCode = parcel.readString();
        paymentHoldStatus = parcel.readString();
        shippingService = parcel.readString();
        if (parcel.readInt() == 1)
        {
            shippingCost = (ItemCurrency)ItemCurrency.CREATOR.createFromParcel(parcel);
        }
        eBayPaymentStatus = parcel.readString();
        l1 = parcel.readLong();
        date = obj;
        if (l1 != -1L)
        {
            date = new Date(l1);
        }
        lastModifiedTime = date;
        paymentMethod = parcel.readString();
        statusXO = parcel.readString();
        l = parcel.readInt();
        if (l > 0)
        {
            refunds = new ArrayList();
            for (int k = 0; k < l; k++)
            {
                refunds.add(Refund.CREATOR.createFromParcel(parcel));
            }

        }
        paidTime = readOptDate(parcel);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        long l1 = -1L;
        boolean flag1 = true;
        boolean flag = false;
        parcel.writeString(id);
        parcel.writeString(status);
        int j;
        long l;
        if (adjustmentAmount != null)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (adjustmentAmount != null)
        {
            adjustmentAmount.writeToParcel(parcel, i);
        }
        if (amountPaid != null)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (amountPaid != null)
        {
            amountPaid.writeToParcel(parcel, i);
        }
        if (amountSaved != null)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (amountSaved != null)
        {
            amountSaved.writeToParcel(parcel, i);
        }
        if (creationDate == null)
        {
            l = -1L;
        } else
        {
            l = creationDate.getTime();
        }
        parcel.writeLong(l);
        parcel.writeString(paymentMethods);
        parcel.writeString(sellerEmail);
        subtotal.writeToParcel(parcel, i);
        total.writeToParcel(parcel, i);
        if (transactions == null)
        {
            j = 0;
        } else
        {
            j = transactions.size();
        }
        parcel.writeInt(j);
        if (transactions != null)
        {
            for (Iterator iterator = transactions.iterator(); iterator.hasNext(); ((ItemTransaction)iterator.next()).writeToParcel(parcel, i)) { }
        }
        parcel.writeString(pickupMethod);
        parcel.writeString(pickupPriority);
        parcel.writeString(selectedMethod);
        parcel.writeString(storeId);
        if (pickupStatus != null)
        {
            j = pickupStatus.ordinal();
        } else
        {
            j = -1;
        }
        parcel.writeInt(j);
        parcel.writeString(merchantPickupCode);
        parcel.writeString(paymentHoldStatus);
        parcel.writeString(shippingService);
        if (shippingCost != null)
        {
            j = ((flag1) ? 1 : 0);
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (shippingCost != null)
        {
            shippingCost.writeToParcel(parcel, i);
        }
        parcel.writeString(eBayPaymentStatus);
        if (lastModifiedTime == null)
        {
            l = l1;
        } else
        {
            l = lastModifiedTime.getTime();
        }
        parcel.writeLong(l);
        parcel.writeString(paymentMethod);
        parcel.writeString(statusXO);
        if (refunds == null)
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = refunds.size();
        }
        parcel.writeInt(j);
        if (refunds != null)
        {
            for (Iterator iterator1 = refunds.iterator(); iterator1.hasNext(); ((Refund)iterator1.next()).writeToParcel(parcel, i)) { }
        }
        writeOptDate(parcel, paidTime);
    }

}
