// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.EbayCurrency;

// Referenced classes of package com.ebay.mobile.widget:
//            PriceView

protected static class <init> extends android.view.riceState
{

    public static final android.os..PriceState.amount CREATOR = new android.os.Parcelable.Creator() {

        public PriceView.PriceState createFromParcel(Parcel parcel)
        {
            return new PriceView.PriceState(parcel, null);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public PriceView.PriceState[] newArray(int i)
        {
            return new PriceView.PriceState[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public Double amount;
    public EbayCurrency currency;
    public int currencySymbolPadding;
    public boolean isPrefill;
    public boolean showCurrencySymbolAlways;
    public boolean showHintTextForZero;

    public void writeToParcel(Parcel parcel, int i)
    {
        super.riteToParcel(parcel, i);
        parcel.writeParcelable(currency, i);
        if (showHintTextForZero)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (showCurrencySymbolAlways)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (isPrefill)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeInt(currencySymbolPadding);
        if (amount == null)
        {
            parcel.writeInt(0);
            return;
        } else
        {
            parcel.writeInt(1);
            parcel.writeDouble(amount.doubleValue());
            return;
        }
    }


    private _cls1(Parcel parcel)
    {
        boolean flag1 = true;
        super(parcel);
        currency = (EbayCurrency)parcel.readParcelable(com/ebay/nautilus/domain/EbayCurrency.getClassLoader());
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        showHintTextForZero = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        showCurrencySymbolAlways = flag;
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        isPrefill = flag;
        currencySymbolPadding = parcel.readInt();
        if (parcel.readInt() == 0)
        {
            parcel = null;
        } else
        {
            parcel = Double.valueOf(parcel.readDouble());
        }
        amount = parcel;
    }

    amount(Parcel parcel, amount amount1)
    {
        this(parcel);
    }

    <init>(Parcelable parcelable)
    {
        super(parcelable);
    }
}
