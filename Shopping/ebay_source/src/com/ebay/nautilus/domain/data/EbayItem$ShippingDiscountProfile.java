// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            EbayItem, ItemCurrency, ItemWeight

public class this._cls0
{

    public ItemCurrency eachAdditionalAmount;
    public ItemCurrency eachAdditionalAmountOff;
    public Float eachAdditionalPercentOff;
    public String id;
    public String mappedId;
    public String name;
    final EbayItem this$0;
    public ItemWeight weightOff;

    public void readFromParcel(Parcel parcel, ClassLoader classloader)
    {
        id = parcel.readString();
        name = parcel.readString();
        eachAdditionalAmount = (ItemCurrency)parcel.readParcelable(classloader);
        eachAdditionalAmountOff = (ItemCurrency)parcel.readParcelable(classloader);
        if (1 == parcel.readInt())
        {
            eachAdditionalPercentOff = Float.valueOf(parcel.readFloat());
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeParcelable(eachAdditionalAmount, i);
        parcel.writeParcelable(eachAdditionalAmountOff, i);
        if (eachAdditionalPercentOff != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (eachAdditionalPercentOff != null)
        {
            parcel.writeFloat(eachAdditionalPercentOff.floatValue());
        }
    }

    public ()
    {
        this$0 = EbayItem.this;
        super();
    }
}
