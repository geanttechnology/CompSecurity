// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.params;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;
import com.target.mothership.common.product.CategoryId;
import com.target.mothership.common.product.EndecaId;
import com.target.mothership.common.product.p;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.store.handler.TGTStore;
import com.target.mothership.model.store.interfaces.Store;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ProductSummaryParam
    implements Parcelable
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a MOBILE;
        public static final a ONLINE;
        private String mValue;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/common/params/ProductSummaryParam$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        public String toString()
        {
            return mValue;
        }

        static 
        {
            MOBILE = new a("MOBILE", 0, "mobile");
            ONLINE = new a("ONLINE", 1, "online");
            $VALUES = (new a[] {
                MOBILE, ONLINE
            });
        }

        private a(String s, int i1, String s1)
        {
            super(s, i1);
            mValue = s1;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ProductSummaryParam a(Parcel parcel)
        {
            return new ProductSummaryParam(parcel);
        }

        public ProductSummaryParam[] a(int i1)
        {
            return new ProductSummaryParam[i1];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i1)
        {
            return a(i1);
        }

    };
    private final CategoryId mCategoryId;
    private a mChannel;
    private final EndecaId mEndecaId;
    private List mFacetParams;
    private boolean mIsRequiredStoreInfo;
    private Integer mLimit;
    private Integer mMaxPrice;
    private Integer mMinPrice;
    private Integer mOffset;
    private Integer mPageNumber;
    private final String mSearchTerm;
    private p mSortType;
    private final Store mStore;

    private ProductSummaryParam(Parcel parcel)
    {
        Object obj1 = null;
        super();
        mFacetParams = new ArrayList();
        mStore = (Store)parcel.readParcelable(com/target/mothership/model/store/handler/TGTStore.getClassLoader());
        mCategoryId = (CategoryId)parcel.readParcelable(com/target/mothership/common/product/CategoryId.getClassLoader());
        mEndecaId = (EndecaId)parcel.readParcelable(com/target/mothership/common/product/EndecaId.getClassLoader());
        mSearchTerm = parcel.readString();
        int i1 = parcel.readInt();
        Object obj;
        boolean flag;
        if (i1 == -1)
        {
            obj = null;
        } else
        {
            obj = p.values()[i1];
        }
        mSortType = ((p) (obj));
        mMaxPrice = (Integer)parcel.readValue(java/lang/Integer.getClassLoader());
        mMinPrice = (Integer)parcel.readValue(java/lang/Integer.getClassLoader());
        if (parcel.readInt() == 1)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            parcel.readTypedList(mFacetParams, EndecaId.CREATOR);
        }
        i1 = parcel.readInt();
        if (i1 == -1)
        {
            obj = obj1;
        } else
        {
            obj = a.values()[i1];
        }
        mChannel = ((a) (obj));
        mPageNumber = (Integer)parcel.readValue(java/lang/Integer.getClassLoader());
        mOffset = (Integer)parcel.readValue(java/lang/Integer.getClassLoader());
        mLimit = (Integer)parcel.readValue(java/lang/Integer.getClassLoader());
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsRequiredStoreInfo = flag;
    }


    public ProductSummaryParam(Store store, CategoryId categoryid, EndecaId endecaid, String s)
    {
        mFacetParams = new ArrayList();
        mSearchTerm = s;
        mCategoryId = categoryid;
        mEndecaId = endecaid;
        mStore = store;
    }

    public String a()
    {
        if (mStore == null)
        {
            return null;
        } else
        {
            return mStore.getStoreId().a();
        }
    }

    public void a(p p1)
    {
        mSortType = p1;
    }

    public void a(Integer integer)
    {
        mMaxPrice = integer;
    }

    public void a(List list)
    {
        mFacetParams = list;
    }

    public Store b()
    {
        return mStore;
    }

    public void b(Integer integer)
    {
        mMinPrice = integer;
    }

    public e c()
    {
        return com.google.a.a.e.c(mCategoryId);
    }

    public void c(Integer integer)
    {
        mPageNumber = integer;
    }

    public e d()
    {
        return com.google.a.a.e.c(mEndecaId);
    }

    public void d(Integer integer)
    {
        mLimit = integer;
    }

    public int describeContents()
    {
        return 0;
    }

    public e e()
    {
        if (mSearchTerm == null)
        {
            return com.google.a.a.e.e();
        } else
        {
            return com.google.a.a.e.b(mSearchTerm.trim());
        }
    }

    public boolean f()
    {
        return mIsRequiredStoreInfo;
    }

    public e g()
    {
        if (mSortType == null)
        {
            return com.google.a.a.e.e();
        } else
        {
            return com.google.a.a.e.b(mSortType);
        }
    }

    public e h()
    {
        if (mMaxPrice == null)
        {
            return com.google.a.a.e.e();
        } else
        {
            return com.google.a.a.e.b(mMaxPrice.toString());
        }
    }

    public e i()
    {
        if (mMinPrice == null)
        {
            return com.google.a.a.e.e();
        } else
        {
            return com.google.a.a.e.b(mMinPrice.toString());
        }
    }

    public List j()
    {
        if (mFacetParams == null)
        {
            return Collections.emptyList();
        }
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = mFacetParams.iterator(); iterator.hasNext(); arraylist.add(((EndecaId)iterator.next()).a())) { }
        return arraylist;
    }

    public e k()
    {
        if (mPageNumber == null)
        {
            return com.google.a.a.e.e();
        } else
        {
            return com.google.a.a.e.b(mPageNumber);
        }
    }

    public e l()
    {
        if (mChannel == null)
        {
            return com.google.a.a.e.e();
        } else
        {
            return com.google.a.a.e.b(mChannel.toString());
        }
    }

    public e m()
    {
        if (mOffset == null)
        {
            return com.google.a.a.e.e();
        } else
        {
            return com.google.a.a.e.b(mOffset);
        }
    }

    public e n()
    {
        if (mLimit == null)
        {
            return com.google.a.a.e.e();
        } else
        {
            return com.google.a.a.e.b(mLimit);
        }
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        byte byte1 = -1;
        byte byte0 = 1;
        parcel.writeParcelable(mStore, 0);
        parcel.writeParcelable(mCategoryId, 0);
        parcel.writeParcelable(mEndecaId, 0);
        parcel.writeString(mSearchTerm);
        int j1;
        if (mSortType == null)
        {
            i1 = -1;
        } else
        {
            i1 = mSortType.ordinal();
        }
        parcel.writeInt(i1);
        parcel.writeValue(mMaxPrice);
        parcel.writeValue(mMinPrice);
        if (mFacetParams != null && !mFacetParams.isEmpty())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        parcel.writeInt(j1);
        if (i1 != 0)
        {
            parcel.writeTypedList(mFacetParams);
        }
        if (mChannel == null)
        {
            i1 = byte1;
        } else
        {
            i1 = mChannel.ordinal();
        }
        parcel.writeInt(i1);
        parcel.writeValue(mPageNumber);
        parcel.writeValue(mOffset);
        parcel.writeValue(mLimit);
        if (!mIsRequiredStoreInfo)
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
    }

}
