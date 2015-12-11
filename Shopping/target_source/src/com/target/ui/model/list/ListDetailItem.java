// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.list;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;
import com.pointinside.maps.Location;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.model.list.interfaces.ListItem;

// Referenced classes of package com.target.ui.model.list:
//            b

public class ListDetailItem
    implements Parcelable, b
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ListDetailItem a(Parcel parcel)
        {
            return new ListDetailItem(parcel);
        }

        public ListDetailItem[] a(int l)
        {
            return new ListDetailItem[l];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int l)
        {
            return a(l);
        }

    };
    private boolean mActionEnabled;
    private boolean mDisabled;
    private boolean mFulfilled;
    private boolean mHasDeals;
    private boolean mInEditMode;
    private Location mInStoreLocation;
    private boolean mIsCompleted;
    private final ListItem mListItem;
    private int mQuantity;
    private Tcin mTcin;
    private String mTitle;

    private ListDetailItem(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        mTitle = parcel.readString();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mFulfilled = flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mActionEnabled = flag;
        mInStoreLocation = (Location)parcel.readParcelable(com/pointinside/maps/Location.getClassLoader());
        mListItem = (ListItem)parcel.readParcelable(com/target/mothership/model/list/interfaces/ListItem.getClassLoader());
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mHasDeals = flag;
        mTcin = (Tcin)parcel.readParcelable(com/target/mothership/common/product/Tcin.getClassLoader());
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mIsCompleted = flag;
    }


    public ListDetailItem(ListItem listitem)
    {
        mTitle = listitem.getTitle();
        mFulfilled = listitem.isFulfilled();
        mIsCompleted = listitem.isCompleted();
        mListItem = listitem;
        mTcin = (Tcin)listitem.getTcin().d();
        mQuantity = listitem.getDesiredQuantity();
    }

    public int a()
    {
        return 2;
    }

    public void a(int l)
    {
        mQuantity = l;
    }

    public void a(Location location)
    {
        mInStoreLocation = location;
    }

    public void a(String s)
    {
        mTitle = s;
    }

    public void a(boolean flag)
    {
        mActionEnabled = flag;
    }

    public String b()
    {
        return mTitle;
    }

    public void b(boolean flag)
    {
        mInEditMode = flag;
    }

    public void c(boolean flag)
    {
        mHasDeals = flag;
    }

    public boolean c()
    {
        return mFulfilled;
    }

    public void d(boolean flag)
    {
        mDisabled = flag;
    }

    public boolean d()
    {
        return mIsCompleted;
    }

    public int describeContents()
    {
        return 0;
    }

    public ListItem e()
    {
        return mListItem;
    }

    public boolean equals(Object obj)
    {
        boolean flag1;
        boolean flag2;
        flag1 = true;
        flag2 = false;
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag2;
        if (obj == null) goto _L4; else goto _L3
_L3:
        flag = flag2;
        if (getClass() != obj.getClass()) goto _L4; else goto _L5
_L5:
        obj = (ListDetailItem)obj;
        flag = flag2;
        if (mFulfilled != ((ListDetailItem) (obj)).mFulfilled) goto _L4; else goto _L6
_L6:
        flag = flag2;
        if (mActionEnabled != ((ListDetailItem) (obj)).mActionEnabled) goto _L4; else goto _L7
_L7:
        flag = flag2;
        if (mQuantity != ((ListDetailItem) (obj)).mQuantity) goto _L4; else goto _L8
_L8:
        flag = flag2;
        if (mHasDeals != ((ListDetailItem) (obj)).mHasDeals) goto _L4; else goto _L9
_L9:
        flag = flag2;
        if (mInEditMode != ((ListDetailItem) (obj)).mInEditMode) goto _L4; else goto _L10
_L10:
        flag = flag2;
        if (mDisabled != ((ListDetailItem) (obj)).mDisabled) goto _L4; else goto _L11
_L11:
        flag = flag2;
        if (mIsCompleted != ((ListDetailItem) (obj)).mIsCompleted) goto _L4; else goto _L12
_L12:
        if (mTitle == null) goto _L14; else goto _L13
_L13:
        flag = flag2;
        if (!mTitle.equals(((ListDetailItem) (obj)).mTitle)) goto _L4; else goto _L15
_L15:
        if (mListItem == null) goto _L17; else goto _L16
_L16:
        flag = flag2;
        if (!mListItem.equals(((ListDetailItem) (obj)).mListItem)) goto _L4; else goto _L18
_L18:
        if (mInStoreLocation == null) goto _L20; else goto _L19
_L19:
        flag = flag2;
        if (!mInStoreLocation.equals(((ListDetailItem) (obj)).mInStoreLocation)) goto _L4; else goto _L21
_L21:
        if (mTcin == null) goto _L23; else goto _L22
_L22:
        flag = flag1;
        if (mTcin.equals(((ListDetailItem) (obj)).mTcin)) goto _L25; else goto _L24
_L24:
        flag = false;
_L25:
        return flag;
_L14:
        if (((ListDetailItem) (obj)).mTitle == null) goto _L15; else goto _L26
_L26:
        return false;
_L17:
        if (((ListDetailItem) (obj)).mListItem == null) goto _L18; else goto _L27
_L27:
        return false;
_L20:
        if (((ListDetailItem) (obj)).mInStoreLocation == null) goto _L21; else goto _L28
_L28:
        return false;
_L23:
        if (((ListDetailItem) (obj)).mTcin != null) goto _L24; else goto _L29
_L29:
        flag = flag1;
          goto _L25
    }

    public Location f()
    {
        return mInStoreLocation;
    }

    public e g()
    {
        return com.google.a.a.e.c(mTcin);
    }

    public int h()
    {
        return mQuantity;
    }

    public int hashCode()
    {
        int i3 = 1;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int j3;
        if (mTitle != null)
        {
            l = mTitle.hashCode();
        } else
        {
            l = 0;
        }
        if (mFulfilled)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (mActionEnabled)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (mListItem != null)
        {
            k1 = mListItem.hashCode();
        } else
        {
            k1 = 0;
        }
        if (mInStoreLocation != null)
        {
            l1 = mInStoreLocation.hashCode();
        } else
        {
            l1 = 0;
        }
        j3 = mQuantity;
        if (mTcin != null)
        {
            i2 = mTcin.hashCode();
        } else
        {
            i2 = 0;
        }
        if (mHasDeals)
        {
            j2 = 1;
        } else
        {
            j2 = 0;
        }
        if (mInEditMode)
        {
            k2 = 1;
        } else
        {
            k2 = 0;
        }
        if (mDisabled)
        {
            l2 = 1;
        } else
        {
            l2 = 0;
        }
        if (!mIsCompleted)
        {
            i3 = 0;
        }
        return (l2 + (k2 + (j2 + (i2 + ((l1 + (k1 + (j1 + (i1 + l * 31) * 31) * 31) * 31) * 31 + j3) * 31) * 31) * 31) * 31) * 31 + i3;
    }

    public boolean i()
    {
        return mInEditMode;
    }

    public boolean j()
    {
        return mHasDeals;
    }

    public boolean k()
    {
        return mDisabled;
    }

    public void writeToParcel(Parcel parcel, int l)
    {
        boolean flag = true;
        parcel.writeString(mTitle);
        int i1;
        if (mFulfilled)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeByte((byte)i1);
        if (mActionEnabled)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeByte((byte)i1);
        parcel.writeParcelable(mInStoreLocation, l);
        parcel.writeParcelable(mListItem, l);
        if (mHasDeals)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeByte((byte)i1);
        parcel.writeParcelable(mTcin, l);
        if (mIsCompleted)
        {
            l = ((flag) ? 1 : 0);
        } else
        {
            l = 0;
        }
        parcel.writeByte((byte)l);
    }

}
