// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.data.cos.base.Text;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.util.List;

public final class Department extends BaseApiResponse
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Department createFromParcel(Parcel parcel)
        {
            return (Department)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/UnifiedStream/Department);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Department[] newArray(int i)
        {
            return new Department[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public List categories;
    public String dealCategoryId;
    public Text displayName;
    public String name;
    public String topBannerLarge;
    public String topBannerSmall;
    public List topCategories;

    public Department()
    {
    }

    public String toString()
    {
        return (new StringBuilder()).append("Department(").append(name).append(",").append(displayName.content).append(",").append(categories).append(",").append(topCategories).append(",").append(dealCategoryId).append(")").toString();
    }

}
