// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.common.product.CategoryId;
import com.target.mothership.common.product.EndecaId;
import com.target.mothership.model.product.interfaces.ProductEntry;
import com.target.mothership.model.product.interfaces.ProductExtendedData;
import com.target.mothership.model.product.interfaces.ProductRgbValue;
import com.target.mothership.util.k;
import java.util.ArrayList;
import java.util.List;

public class TGTProductEntry
    implements ProductEntry
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductEntry a(Parcel parcel)
        {
            return new TGTProductEntry(parcel);
        }

        public TGTProductEntry[] a(int i)
        {
            return new TGTProductEntry[i];
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
    private CategoryId mCategoryId;
    private int mCount;
    private EndecaId mEndecaId;
    private String mEntryValue;
    private List mExtendedData;
    private String mGetLabel;
    private List mRgbValue;

    TGTProductEntry()
    {
    }

    private TGTProductEntry(Parcel parcel)
    {
        mExtendedData = new ArrayList();
        parcel.readList(mExtendedData, com/target/mothership/model/product/interfaces/ProductExtendedData.getClassLoader());
        mCategoryId = (CategoryId)parcel.readParcelable(com/target/mothership/common/product/CategoryId.getClassLoader());
        mCount = parcel.readInt();
        mEndecaId = (EndecaId)parcel.readParcelable(com/target/mothership/common/product/EndecaId.getClassLoader());
        mEntryValue = parcel.readString();
        mGetLabel = parcel.readString();
        mRgbValue = new ArrayList();
        parcel.readList(mRgbValue, com/target/mothership/model/product/interfaces/ProductRgbValue.getClassLoader());
    }


    private boolean a(List list, List list1)
    {
        boolean flag1 = false;
        if (list != null || list1 != null) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        if (list != null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (list1 != null) goto _L4; else goto _L3
_L3:
        if (list == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (list1 == null) goto _L4; else goto _L5
_L5:
        flag = flag1;
        if (list.size() == list1.size())
        {
            int i = 0;
label0:
            do
            {
label1:
                {
                    if (i >= list1.size())
                    {
                        break label1;
                    }
                    flag = flag1;
                    if (!k.a((ProductExtendedData)list.get(i), (ProductExtendedData)list1.get(i)))
                    {
                        break label0;
                    }
                    i++;
                }
            } while (true);
        }
        if (true) goto _L4; else goto _L6
_L6:
        return true;
    }

    private boolean b(List list, List list1)
    {
        boolean flag1 = false;
        if (list != null || list1 != null) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        if (list != null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (list1 != null) goto _L4; else goto _L3
_L3:
        if (list == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (list1 == null) goto _L4; else goto _L5
_L5:
        flag = flag1;
        if (list.size() == list1.size())
        {
            int i = 0;
label0:
            do
            {
label1:
                {
                    if (i >= list1.size())
                    {
                        break label1;
                    }
                    flag = flag1;
                    if (!k.a((ProductRgbValue)list.get(i), (ProductRgbValue)list1.get(i)))
                    {
                        break label0;
                    }
                    i++;
                }
            } while (true);
        }
        if (true) goto _L4; else goto _L6
_L6:
        return true;
    }

    public int a()
    {
        return mCount;
    }

    public void a(int i)
    {
        mCount = i;
    }

    public void a(CategoryId categoryid)
    {
        mCategoryId = categoryid;
    }

    public void a(EndecaId endecaid)
    {
        mEndecaId = endecaid;
    }

    public void a(String s)
    {
        mEntryValue = s;
    }

    public void a(List list)
    {
        mExtendedData = list;
    }

    public e b()
    {
        return com.google.a.a.e.c(mEndecaId);
    }

    public void b(String s)
    {
        mGetLabel = s;
    }

    public void b(List list)
    {
        mRgbValue = list;
    }

    public e c()
    {
        return k.a(mEntryValue);
    }

    public String d()
    {
        return mGetLabel;
    }

    public int describeContents()
    {
        return 0;
    }

    public List e()
    {
        return k.a(mRgbValue);
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof TGTProductEntry))
            {
                return false;
            }
            obj = (TGTProductEntry)obj;
            if (!a(mExtendedData, ((TGTProductEntry) (obj)).mExtendedData) || !k.a(mCategoryId, ((TGTProductEntry) (obj)).mCategoryId) || !k.a(mEndecaId, ((TGTProductEntry) (obj)).mEndecaId) || !k.a(mEntryValue, ((TGTProductEntry) (obj)).mEntryValue) || !k.a(mGetLabel, ((TGTProductEntry) (obj)).mGetLabel) || !b(mRgbValue, ((TGTProductEntry) (obj)).mRgbValue))
            {
                return false;
            }
        }
        return true;
    }

    public boolean f()
    {
        return mCategoryId != null;
    }

    public int hashCode()
    {
        int k1 = 0;
        int i;
        int j;
        int l;
        int i1;
        int j1;
        if (mExtendedData != null)
        {
            i = mExtendedData.hashCode();
        } else
        {
            i = 0;
        }
        if (mCategoryId != null)
        {
            j = mCategoryId.hashCode();
        } else
        {
            j = 0;
        }
        if (mEndecaId != null)
        {
            l = mEndecaId.hashCode();
        } else
        {
            l = 0;
        }
        if (mEntryValue != null)
        {
            i1 = mEntryValue.hashCode();
        } else
        {
            i1 = 0;
        }
        if (mGetLabel != null)
        {
            j1 = mGetLabel.hashCode();
        } else
        {
            j1 = 0;
        }
        if (mRgbValue != null)
        {
            k1 = mRgbValue.hashCode();
        }
        return (j1 + (i1 + (l + (j + i * 31) * 31) * 31) * 31) * 31 + k1;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeList(mExtendedData);
        parcel.writeParcelable(mCategoryId, i);
        parcel.writeInt(mCount);
        parcel.writeParcelable(mEndecaId, i);
        parcel.writeString(mEntryValue);
        parcel.writeString(mGetLabel);
        parcel.writeList(mRgbValue);
    }

}
