// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.Collections;
import java.util.Set;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShoppingCart, CurrencyAmount

public static final class currencyCodes extends BaseDataMapped
    implements Parcelable
{

    public static final android.os.oppingCart.Summary.currencyCodes CREATOR = new android.os.Parcelable.Creator() {

        public ShoppingCart.Summary createFromParcel(Parcel parcel)
        {
            return (ShoppingCart.Summary)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ShoppingCart$Summary);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ShoppingCart.Summary[] newArray(int i)
        {
            return new ShoppingCart.Summary[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final _cls1.newArray UNKNOWN = new <init>();
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


    protected _cls1()
    {
        this(null, null, null, null, null, null, null, 0, 0, 0, false, null);
    }

    public <init>(CurrencyAmount currencyamount, CurrencyAmount currencyamount1, CurrencyAmount currencyamount2, CurrencyAmount currencyamount3, CurrencyAmount currencyamount4, CurrencyAmount currencyamount5, CurrencyAmount currencyamount6, 
            int i, int j, int k, boolean flag)
    {
        this(currencyamount, currencyamount1, currencyamount2, currencyamount3, currencyamount4, currencyamount5, currencyamount6, i, j, k, flag, null);
    }

    public <init>(CurrencyAmount currencyamount, CurrencyAmount currencyamount1, CurrencyAmount currencyamount2, CurrencyAmount currencyamount3, CurrencyAmount currencyamount4, CurrencyAmount currencyamount5, CurrencyAmount currencyamount6, 
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

    public currencyCodes(currencyCodes currencycodes, Set set)
    {
        if (currencycodes == null)
        {
            throw new RuntimeException("Cart Summary Is Null");
        }
        itemSubTotal = currencycodes.itemSubTotal;
        importCharges = currencycodes.importCharges;
        shippingSubTotal = currencycodes.shippingSubTotal;
        discount = currencycodes.discount;
        adjustmentsSubTotal = currencycodes.adjustmentsSubTotal;
        taxSubTotal = currencycodes.taxSubTotal;
        total = currencycodes.total;
        totalBuyableItems = currencycodes.totalBuyableItems;
        totalUnbuyableItems = currencycodes.totalUnbuyableItems;
        totalTransactedItems = currencycodes.totalTransactedItems;
        hasBopisItem = currencycodes.hasBopisItem;
        if (set == null)
        {
            set = Collections.emptySet();
        }
        currencyCodes = set;
    }
}
