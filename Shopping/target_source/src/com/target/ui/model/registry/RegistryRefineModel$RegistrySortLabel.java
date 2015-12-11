// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.registry;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.common.registries.e;
import com.target.mothership.common.registries.f;

// Referenced classes of package com.target.ui.model.registry:
//            RegistryRefineModel

public static class mSortOrder
    implements Parcelable
{

    public static final android.os. CREATOR = new android.os.Parcelable.Creator() {

        public RegistryRefineModel.RegistrySortLabel a(Parcel parcel)
        {
            return new RegistryRefineModel.RegistrySortLabel(parcel);
        }

        public RegistryRefineModel.RegistrySortLabel[] a(int i)
        {
            return new RegistryRefineModel.RegistrySortLabel[i];
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
    private final f mSortOrder;
    private int mSortTitleResId;
    private final e mSortType;

    public int a()
    {
        return mSortTitleResId;
    }

    public e b()
    {
        return mSortType;
    }

    public f c()
    {
        return mSortOrder;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        boolean flag2 = true;
        boolean flag3 = false;
        boolean flag;
        if (this == obj)
        {
            flag = true;
        } else
        {
            flag = flag3;
            if (obj != null)
            {
                flag = flag3;
                if (getClass() == obj.getClass())
                {
                    obj = (mSortOrder)obj;
                    flag = flag3;
                    if (mSortTitleResId == ((mSortTitleResId) (obj)).mSortTitleResId)
                    {
                        flag = flag3;
                        if (mSortType == ((mSortType) (obj)).mSortType)
                        {
                            boolean flag1;
                            if (mSortOrder == ((mSortOrder) (obj)).mSortOrder)
                            {
                                flag1 = flag2;
                            } else
                            {
                                flag1 = false;
                            }
                            return flag1;
                        }
                    }
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        int j = 0;
        int k = mSortTitleResId;
        int i;
        if (mSortType != null)
        {
            i = mSortType.hashCode();
        } else
        {
            i = 0;
        }
        if (mSortOrder != null)
        {
            j = mSortOrder.hashCode();
        }
        return (i + k * 31) * 31 + j;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        byte byte0 = -1;
        parcel.writeInt(mSortTitleResId);
        if (mSortType == null)
        {
            i = -1;
        } else
        {
            i = mSortType.ordinal();
        }
        parcel.writeInt(i);
        if (mSortOrder == null)
        {
            i = byte0;
        } else
        {
            i = mSortOrder.ordinal();
        }
        parcel.writeInt(i);
    }


    _cls1(int i, e e1, f f1)
    {
        mSortTitleResId = i;
        mSortType = e1;
        mSortOrder = f1;
    }

    protected mSortOrder(Parcel parcel)
    {
        Object obj = null;
        super();
        mSortTitleResId = parcel.readInt();
        int i = parcel.readInt();
        e e1;
        if (i == -1)
        {
            e1 = null;
        } else
        {
            e1 = e.values()[i];
        }
        mSortType = e1;
        i = parcel.readInt();
        if (i == -1)
        {
            parcel = obj;
        } else
        {
            parcel = f.values()[i];
        }
        mSortOrder = parcel;
    }
}
