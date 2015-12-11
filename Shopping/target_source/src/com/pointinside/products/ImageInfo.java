// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import android.os.Parcel;
import android.os.Parcelable;
import com.pointinside.internal.utils.StringUtils;

public class ImageInfo
    implements Parcelable
{
    public static final class PIProductsImageInfoType extends Enum
    {

        private static final PIProductsImageInfoType $VALUES[];
        public static final PIProductsImageInfoType full;
        public static final PIProductsImageInfoType large;
        public static final PIProductsImageInfoType thumbnail;
        public static final PIProductsImageInfoType unknown;

        public static PIProductsImageInfoType byString(String s)
        {
            PIProductsImageInfoType apiproductsimageinfotype[] = values();
            int j = apiproductsimageinfotype.length;
            for (int i = 0; i < j; i++)
            {
                PIProductsImageInfoType piproductsimageinfotype = apiproductsimageinfotype[i];
                if (piproductsimageinfotype.toString().equals(s))
                {
                    return piproductsimageinfotype;
                }
            }

            return null;
        }

        public static PIProductsImageInfoType valueOf(String s)
        {
            return (PIProductsImageInfoType)Enum.valueOf(com/pointinside/products/ImageInfo$PIProductsImageInfoType, s);
        }

        public static PIProductsImageInfoType[] values()
        {
            return (PIProductsImageInfoType[])$VALUES.clone();
        }

        static 
        {
            unknown = new PIProductsImageInfoType("unknown", 0);
            thumbnail = new PIProductsImageInfoType("thumbnail", 1);
            large = new PIProductsImageInfoType("large", 2);
            full = new PIProductsImageInfoType("full", 3);
            $VALUES = (new PIProductsImageInfoType[] {
                unknown, thumbnail, large, full
            });
        }

        private PIProductsImageInfoType(String s, int i)
        {
            super(s, i);
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ImageInfo createFromParcel(Parcel parcel)
        {
            return new ImageInfo(PIProductsImageInfoType.byString(parcel.readString()), parcel.readString());
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ImageInfo[] newArray(int i)
        {
            return new ImageInfo[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final PIProductsImageInfoType type;
    public final String url;

    public ImageInfo(PIProductsImageInfoType piproductsimageinfotype, String s)
    {
        type = piproductsimageinfotype;
        url = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        StringUtils.appendIfNotNull(stringbuilder, " Url", url);
        StringUtils.appendIfNotNull(stringbuilder, " Type", type.toString());
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(type.toString());
        parcel.writeString(url);
    }

}
