// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.registries.handler;

import android.os.Parcel;
import com.target.mothership.common.registries.e;
import com.target.mothership.common.registries.f;
import com.target.mothership.model.registries.interfaces.RegistrySearchWrapper;
import com.target.mothership.util.k;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.registries.handler:
//            TGTRegistrySearchSummary

public class TGTRegistrySearchWrapper
    implements RegistrySearchWrapper
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTRegistrySearchWrapper a(Parcel parcel)
        {
            return new TGTRegistrySearchWrapper(parcel);
        }

        public TGTRegistrySearchWrapper[] a(int i)
        {
            return new TGTRegistrySearchWrapper[i];
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
    private Integer mCurrentPage;
    private Integer mPageSize;
    private List mRegistrySearchSummary;
    private e mRegistrySort;
    private f mRegistrySortOrder;
    private Integer mTotalRecord;

    public TGTRegistrySearchWrapper()
    {
    }

    protected TGTRegistrySearchWrapper(Parcel parcel)
    {
        Object obj1 = null;
        super();
        mPageSize = (Integer)parcel.readValue(java/lang/Integer.getClassLoader());
        mTotalRecord = (Integer)parcel.readValue(java/lang/Integer.getClassLoader());
        mCurrentPage = (Integer)parcel.readValue(java/lang/Integer.getClassLoader());
        int i = parcel.readInt();
        Object obj;
        if (i == -1)
        {
            obj = null;
        } else
        {
            obj = e.values()[i];
        }
        mRegistrySort = ((e) (obj));
        i = parcel.readInt();
        if (i == -1)
        {
            obj = obj1;
        } else
        {
            obj = f.values()[i];
        }
        mRegistrySortOrder = ((f) (obj));
        mRegistrySearchSummary = new ArrayList();
        parcel.readList(mRegistrySearchSummary, com/target/mothership/model/registries/handler/TGTRegistrySearchSummary.getClassLoader());
    }

    public Integer a()
    {
        return mPageSize;
    }

    public void a(int i)
    {
        mTotalRecord = Integer.valueOf(i);
    }

    public void a(e e1)
    {
        mRegistrySort = e1;
    }

    public void a(f f1)
    {
        mRegistrySortOrder = f1;
    }

    public void a(Integer integer)
    {
        mPageSize = integer;
    }

    public void a(List list)
    {
        mRegistrySearchSummary = list;
    }

    public Integer b()
    {
        return mTotalRecord;
    }

    public void b(int i)
    {
        mCurrentPage = Integer.valueOf(i);
    }

    public Integer c()
    {
        return mCurrentPage;
    }

    public List d()
    {
        return k.a(mRegistrySearchSummary);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        byte byte0 = -1;
        parcel.writeValue(mPageSize);
        parcel.writeValue(mTotalRecord);
        parcel.writeValue(mCurrentPage);
        if (mRegistrySort == null)
        {
            i = -1;
        } else
        {
            i = mRegistrySort.ordinal();
        }
        parcel.writeInt(i);
        if (mRegistrySortOrder == null)
        {
            i = byte0;
        } else
        {
            i = mRegistrySortOrder.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeList(mRegistrySearchSummary);
    }

}
