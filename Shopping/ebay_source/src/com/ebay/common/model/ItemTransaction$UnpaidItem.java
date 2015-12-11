// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;

// Referenced classes of package com.ebay.common.model:
//            ItemTransaction

public static class _cls1 extends BaseDataMapped
    implements Parcelable
{

    public static final android.os.aseDataMapped CREATOR = new android.os.Parcelable.Creator() {

        public ItemTransaction.UnpaidItem createFromParcel(Parcel parcel)
        {
            return (ItemTransaction.UnpaidItem)DataMapperFactory.readParcelJson(parcel, com/ebay/common/model/ItemTransaction$UnpaidItem);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ItemTransaction.UnpaidItem[] newArray(int i)
        {
            return new ItemTransaction.UnpaidItem[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String status;
    public String type;


    public _cls1()
    {
    }
}
