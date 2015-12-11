// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            EbayCategory

public final class EbayCategoryNode
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public EbayCategoryNode createFromParcel(Parcel parcel)
        {
            return new EbayCategoryNode(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public EbayCategoryNode[] newArray(int i)
        {
            return new EbayCategoryNode[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final EbayCategory category;
    public final EbayCategoryNode children[];

    protected EbayCategoryNode(Parcel parcel)
    {
        category = (EbayCategory)parcel.readParcelable(com/ebay/nautilus/domain/data/EbayCategory.getClassLoader());
        children = (EbayCategoryNode[])parcel.createTypedArray(CREATOR);
    }

    public transient EbayCategoryNode(EbayCategory ebaycategory, EbayCategoryNode aebaycategorynode[])
    {
        category = ebaycategory;
        children = aebaycategorynode;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(category, i);
        parcel.writeTypedArray(children, i);
    }

}
