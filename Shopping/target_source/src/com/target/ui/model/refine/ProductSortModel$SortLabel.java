// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.refine;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.common.product.p;

// Referenced classes of package com.target.ui.model.refine:
//            ProductSortModel

public static class <init>
    implements Parcelable
{

    public static final android.os..ordinal CREATOR = new android.os.Parcelable.Creator() {

        public ProductSortModel.SortLabel a(Parcel parcel)
        {
            return new ProductSortModel.SortLabel(parcel, null);
        }

        public ProductSortModel.SortLabel[] a(int i)
        {
            return new ProductSortModel.SortLabel[i];
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
    private final int mSortTitle;
    private final p mSortType;

    public p a()
    {
        return mSortType;
    }

    public int b()
    {
        return mSortTitle;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (mSortTitle)obj;
            if (mSortTitle != ((mSortTitle) (obj)).mSortTitle)
            {
                return false;
            }
            if (mSortType != ((mSortType) (obj)).mSortType)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j = mSortTitle;
        int i;
        if (mSortType != null)
        {
            i = mSortType.hashCode();
        } else
        {
            i = 0;
        }
        return i + j * 31;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(mSortTitle);
        if (mSortType == null)
        {
            i = -1;
        } else
        {
            i = mSortType.ordinal();
        }
        parcel.writeInt(i);
    }


    _cls1(int i, p p1)
    {
        mSortType = p1;
        mSortTitle = i;
    }

    private mSortTitle(Parcel parcel)
    {
        mSortTitle = parcel.readInt();
        int i = parcel.readInt();
        if (i == -1)
        {
            parcel = null;
        } else
        {
            parcel = p.values()[i];
        }
        mSortType = parcel;
    }

    mSortType(Parcel parcel, mSortType msorttype)
    {
        this(parcel);
    }
}
