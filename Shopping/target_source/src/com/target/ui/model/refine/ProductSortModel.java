// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.refine;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;
import com.target.mothership.common.product.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ProductSortModel
    implements Parcelable
{
    public static class SortLabel
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SortLabel a(Parcel parcel)
            {
                return new SortLabel(parcel);
            }

            public SortLabel[] a(int i)
            {
                return new SortLabel[i];
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
                obj = (SortLabel)obj;
                if (mSortTitle != ((SortLabel) (obj)).mSortTitle)
                {
                    return false;
                }
                if (mSortType != ((SortLabel) (obj)).mSortType)
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


        SortLabel(int i, p p1)
        {
            mSortType = p1;
            mSortTitle = i;
        }

        private SortLabel(Parcel parcel)
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

    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ProductSortModel a(Parcel parcel)
        {
            return new ProductSortModel(parcel);
        }

        public ProductSortModel[] a(int i)
        {
            return new ProductSortModel[i];
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
    private static final int INVALID_RESOURCE_ID = -1;
    private SortLabel mSelectedSort;
    private List mSortLabel;

    ProductSortModel()
    {
        d();
    }

    private ProductSortModel(Parcel parcel)
    {
        mSelectedSort = (SortLabel)parcel.readParcelable(com/target/ui/model/refine/ProductSortModel$SortLabel.getClassLoader());
        mSortLabel = new ArrayList();
        parcel.readList(mSortLabel, com/target/ui/model/refine/ProductSortModel$SortLabel.getClassLoader());
    }


    private static int a(p p1)
    {
        static class _cls2
        {

            static final int $SwitchMap$com$target$mothership$common$product$ProductSortType[];

            static 
            {
                $SwitchMap$com$target$mothership$common$product$ProductSortType = new int[p.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$product$ProductSortType[p.RELEVANCE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$ProductSortType[p.BEST_SELLING.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$ProductSortType[p.NEWEST.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$ProductSortType[p.PRICE_HIGH.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$ProductSortType[p.PRICE_LOW.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$ProductSortType[p.RATING_HIGH.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.target.mothership.common.product.ProductSortType[p1.ordinal()])
        {
        default:
            return -1;

        case 1: // '\001'
            return 0x7f09047b;

        case 2: // '\002'
            return 0x7f090476;

        case 3: // '\003'
            return 0x7f090477;

        case 4: // '\004'
            return 0x7f090479;

        case 5: // '\005'
            return 0x7f090478;

        case 6: // '\006'
            return 0x7f09047a;
        }
    }

    private void d()
    {
        mSortLabel = new ArrayList();
        p p1;
        for (Iterator iterator = e().iterator(); iterator.hasNext(); mSortLabel.add(new SortLabel(a(p1), p1)))
        {
            p1 = (p)iterator.next();
        }

    }

    private List e()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(p.RELEVANCE);
        arraylist.add(p.NEWEST);
        arraylist.add(p.RATING_HIGH);
        arraylist.add(p.BEST_SELLING);
        arraylist.add(p.PRICE_LOW);
        arraylist.add(p.PRICE_HIGH);
        return arraylist;
    }

    public List a()
    {
        if (mSortLabel == null)
        {
            return Collections.emptyList();
        } else
        {
            return mSortLabel;
        }
    }

    public void a(SortLabel sortlabel)
    {
        mSelectedSort = sortlabel;
    }

    public void b()
    {
        mSelectedSort = null;
    }

    public e c()
    {
        return com.google.a.a.e.c(mSelectedSort);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mSelectedSort, i);
        parcel.writeList(mSortLabel);
    }

}
