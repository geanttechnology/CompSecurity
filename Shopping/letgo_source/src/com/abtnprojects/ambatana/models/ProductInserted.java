// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.aeu;
import android.support.v7.aev;
import android.support.v7.aqo;

public class ProductInserted
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ProductInserted createFromParcel(Parcel parcel)
        {
            return new ProductInserted(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ProductInserted[] newArray(int i)
        {
            return new ProductInserted[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private final String description;
    private final String imageUrl;
    private final String productId;
    private final int selectedCategoryId;
    private final boolean shareProduct;
    private final String title;

    public ProductInserted(Parcel parcel)
    {
        title = parcel.readString();
        description = parcel.readString();
        selectedCategoryId = parcel.readInt();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        shareProduct = flag;
        productId = parcel.readString();
        imageUrl = parcel.readString();
    }

    public ProductInserted(String s, String s1, int i, boolean flag, String s2, String s3)
    {
        title = s;
        description = s1;
        selectedCategoryId = i;
        shareProduct = flag;
        productId = s2;
        imageUrl = s3;
    }

    public static ProductInserted fromJSON(String s)
    {
        aeu aeu1 = (new aev()).a();
        try
        {
            s = (ProductInserted)aeu1.a(s, com/abtnprojects/ambatana/models/ProductInserted);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            aqo.b(s, "fromJson", new Object[0]);
            return null;
        }
        return s;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getDescription()
    {
        return description;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public String getProductId()
    {
        return productId;
    }

    public int getSelectedCategoryId()
    {
        return selectedCategoryId;
    }

    public String getTitle()
    {
        return title;
    }

    public boolean isShareProduct()
    {
        return shareProduct;
    }

    public String toJSON()
    {
        return (new aev()).a().a(this);
    }

    public String toString()
    {
        return (new StringBuilder()).append("ProductInserted{title='").append(title).append('\'').append(", description='").append(description).append('\'').append(", selectedCategoryId=").append(selectedCategoryId).append(", shareProduct=").append(shareProduct).append(", productId='").append(productId).append('\'').append(", imageUrl='").append(imageUrl).append('\'').append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeInt(selectedCategoryId);
        if (shareProduct)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeString(productId);
        parcel.writeString(imageUrl);
    }

}
