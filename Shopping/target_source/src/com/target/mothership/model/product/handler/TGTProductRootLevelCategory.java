// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.common.product.CategoryId;
import com.target.mothership.model.product.interfaces.ProductRootLevelCategory;

public class TGTProductRootLevelCategory
    implements ProductRootLevelCategory
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductRootLevelCategory a(Parcel parcel)
        {
            return new TGTProductRootLevelCategory(parcel);
        }

        public TGTProductRootLevelCategory[] a(int i)
        {
            return new TGTProductRootLevelCategory[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    private CategoryId mRootCategoryId;
    private String mRootCategoryName;

    TGTProductRootLevelCategory()
    {
    }

    protected TGTProductRootLevelCategory(Parcel parcel)
    {
        mRootCategoryId = (CategoryId)parcel.readParcelable(com/target/mothership/common/product/CategoryId.getClassLoader());
        mRootCategoryName = parcel.readString();
    }

    public String a()
    {
        return mRootCategoryName;
    }

    public void a(CategoryId categoryid)
    {
        mRootCategoryId = categoryid;
    }

    public void a(String s)
    {
        mRootCategoryName = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mRootCategoryId, 0);
        parcel.writeString(mRootCategoryName);
    }

}
