// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.pointinside.products:
//            ImageInfo, ProductPrice

public class Deal
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Deal createFromParcel(Parcel parcel)
        {
            return new Deal(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Deal[] newArray(int i)
        {
            return new Deal[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final Boolean automaticallyApplied;
    public final List brands;
    public final List categories;
    public final String dealId;
    public final List dealProductIds;
    public final List dealType;
    public final String description;
    public final Date endDate;
    public final String eventLocation;
    public final List images = new ArrayList();
    public final String link;
    public final ProductPrice price;
    public final Date startDate;
    public final String title;
    public final String type;
    public final String value;

    protected Deal(Parcel parcel)
    {
        automaticallyApplied = Boolean.valueOf(parcel.readString());
        parcel.readTypedList(images, ImageInfo.CREATOR);
        dealId = parcel.readString();
        title = parcel.readString();
        link = parcel.readString();
        type = parcel.readString();
        value = parcel.readString();
        if (parcel.readByte() == 0)
        {
            price = (ProductPrice)parcel.readParcelable(com/pointinside/products/ProductPrice.getClassLoader());
        } else
        {
            price = null;
        }
        if (parcel.readByte() == 0)
        {
            eventLocation = parcel.readString();
        } else
        {
            eventLocation = null;
        }
        if (parcel.readByte() == 0)
        {
            dealProductIds = parcel.createStringArrayList();
        } else
        {
            dealProductIds = null;
        }
        startDate = (Date)parcel.readSerializable();
        if (parcel.readByte() == 0)
        {
            dealType = parcel.createStringArrayList();
        } else
        {
            dealType = new ArrayList();
        }
        if (parcel.readByte() == 0)
        {
            categories = parcel.createStringArrayList();
        } else
        {
            categories = new ArrayList();
        }
        if (parcel.readByte() == 0)
        {
            brands = parcel.createStringArrayList();
        } else
        {
            brands = new ArrayList();
        }
        description = parcel.readString();
        endDate = (Date)parcel.readSerializable();
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder((new StringBuilder()).append("id: ").append(dealId).toString());
        stringbuilder.append((new StringBuilder()).append(" Product IDs: ").append(dealProductIds).toString());
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeString(String.valueOf(automaticallyApplied));
        parcel.writeTypedList(images);
        parcel.writeString(dealId);
        parcel.writeString(title);
        parcel.writeString(link);
        parcel.writeString(type);
        parcel.writeString(value);
        if (price == null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (price != null)
        {
            parcel.writeParcelable(price, 0);
        }
        if (eventLocation == null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (eventLocation != null)
        {
            parcel.writeString(eventLocation);
        }
        if (dealProductIds == null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (dealProductIds != null)
        {
            parcel.writeStringList(dealProductIds);
        }
        parcel.writeSerializable(startDate);
        if (dealType == null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (dealType != null)
        {
            parcel.writeStringList(dealType);
        }
        if (categories == null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (categories != null)
        {
            parcel.writeStringList(categories);
        }
        if (brands == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (brands != null)
        {
            parcel.writeStringList(brands);
        }
        parcel.writeString(description);
        parcel.writeSerializable(endDate);
    }

}
