// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.model.list.interfaces.ListItem;
import java.util.Date;

class TGTListItem
    implements Parcelable, ListItem
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTListItem a(Parcel parcel)
        {
            return new TGTListItem(parcel);
        }

        public TGTListItem[] a(int i)
        {
            return new TGTListItem[i];
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
    private int mDesiredQuantity;
    private boolean mIsCompleted;
    private long mItemPosition;
    private int mKey;
    private String mListItemId;
    private int mListKey;
    private String mNote;
    private int mPurchasedQuantity;
    private Date mServerLastModifiedDate;
    private Tcin mTcin;
    private String mTitle;

    TGTListItem()
    {
    }

    private TGTListItem(Parcel parcel)
    {
        mKey = parcel.readInt();
        mListKey = parcel.readInt();
        mListItemId = parcel.readString();
        mTitle = parcel.readString();
        mNote = parcel.readString();
        mDesiredQuantity = parcel.readInt();
        mPurchasedQuantity = parcel.readInt();
        mTcin = (Tcin)parcel.readParcelable(com/target/mothership/common/product/Tcin.getClassLoader());
        long l = parcel.readLong();
        Date date;
        boolean flag;
        if (l == -1L)
        {
            date = null;
        } else
        {
            date = new Date(l);
        }
        mServerLastModifiedDate = date;
        mItemPosition = parcel.readLong();
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsCompleted = flag;
    }


    public int describeContents()
    {
        return 0;
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
        obj = (TGTListItem)obj;
        flag = flag2;
        if (mKey != ((TGTListItem) (obj)).mKey) goto _L4; else goto _L6
_L6:
        flag = flag2;
        if (mListKey != ((TGTListItem) (obj)).mListKey) goto _L4; else goto _L7
_L7:
        flag = flag2;
        if (mDesiredQuantity != ((TGTListItem) (obj)).mDesiredQuantity) goto _L4; else goto _L8
_L8:
        flag = flag2;
        if (mPurchasedQuantity != ((TGTListItem) (obj)).mPurchasedQuantity) goto _L4; else goto _L9
_L9:
        flag = flag2;
        if (mItemPosition != ((TGTListItem) (obj)).mItemPosition) goto _L4; else goto _L10
_L10:
        flag = flag2;
        if (mIsCompleted != ((TGTListItem) (obj)).mIsCompleted) goto _L4; else goto _L11
_L11:
        if (mListItemId == null) goto _L13; else goto _L12
_L12:
        flag = flag2;
        if (!mListItemId.equals(((TGTListItem) (obj)).mListItemId)) goto _L4; else goto _L14
_L14:
        if (mTitle == null) goto _L16; else goto _L15
_L15:
        flag = flag2;
        if (!mTitle.equals(((TGTListItem) (obj)).mTitle)) goto _L4; else goto _L17
_L17:
        if (mNote == null) goto _L19; else goto _L18
_L18:
        flag = flag2;
        if (!mNote.equals(((TGTListItem) (obj)).mNote)) goto _L4; else goto _L20
_L20:
        if (mTcin == null) goto _L22; else goto _L21
_L21:
        flag = flag2;
        if (!mTcin.equals(((TGTListItem) (obj)).mTcin)) goto _L4; else goto _L23
_L23:
        if (mServerLastModifiedDate == null) goto _L25; else goto _L24
_L24:
        flag = flag1;
        if (mServerLastModifiedDate.equals(((TGTListItem) (obj)).mServerLastModifiedDate)) goto _L27; else goto _L26
_L26:
        flag = false;
_L27:
        return flag;
_L13:
        if (((TGTListItem) (obj)).mListItemId == null) goto _L14; else goto _L28
_L28:
        return false;
_L16:
        if (((TGTListItem) (obj)).mTitle == null) goto _L17; else goto _L29
_L29:
        return false;
_L19:
        if (((TGTListItem) (obj)).mNote == null) goto _L20; else goto _L30
_L30:
        return false;
_L22:
        if (((TGTListItem) (obj)).mTcin == null) goto _L23; else goto _L31
_L31:
        return false;
_L25:
        if (((TGTListItem) (obj)).mServerLastModifiedDate != null) goto _L26; else goto _L32
_L32:
        flag = flag1;
          goto _L27
    }

    public int getDesiredQuantity()
    {
        return mDesiredQuantity;
    }

    public long getItemPosition()
    {
        return mItemPosition;
    }

    public int getKey()
    {
        return mKey;
    }

    public Date getLastModifiedDate()
    {
        return null;
    }

    public String getListId()
    {
        return null;
    }

    public String getListItemId()
    {
        return mListItemId;
    }

    public int getListKey()
    {
        return mListKey;
    }

    public String getNote()
    {
        return mNote;
    }

    public int getPurchasedQuantity()
    {
        return mPurchasedQuantity;
    }

    public Date getServerLastModifiedDate()
    {
        return mServerLastModifiedDate;
    }

    public e getTcin()
    {
        return e.c(mTcin);
    }

    public String getTitle()
    {
        return mTitle;
    }

    public int hashCode()
    {
        int j1 = 0;
        int k1 = mKey;
        int l1 = mListKey;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int i2;
        int j2;
        int k2;
        if (mListItemId != null)
        {
            i = mListItemId.hashCode();
        } else
        {
            i = 0;
        }
        if (mTitle != null)
        {
            j = mTitle.hashCode();
        } else
        {
            j = 0;
        }
        if (mNote != null)
        {
            k = mNote.hashCode();
        } else
        {
            k = 0;
        }
        i2 = mDesiredQuantity;
        j2 = mPurchasedQuantity;
        if (mTcin != null)
        {
            l = mTcin.hashCode();
        } else
        {
            l = 0;
        }
        if (mServerLastModifiedDate != null)
        {
            i1 = mServerLastModifiedDate.hashCode();
        } else
        {
            i1 = 0;
        }
        k2 = (int)(mItemPosition ^ mItemPosition >>> 32);
        if (mIsCompleted)
        {
            j1 = 1;
        }
        return ((i1 + (l + (((k + (j + (i + (k1 * 31 + l1) * 31) * 31) * 31) * 31 + i2) * 31 + j2) * 31) * 31) * 31 + k2) * 31 + j1;
    }

    public boolean isCompleted()
    {
        return mIsCompleted;
    }

    public boolean isDeleting()
    {
        return false;
    }

    public boolean isDirty()
    {
        return false;
    }

    public boolean isFulfilled()
    {
        return mPurchasedQuantity >= mDesiredQuantity;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(mKey);
        parcel.writeInt(mListKey);
        parcel.writeString(mListItemId);
        parcel.writeString(mTitle);
        parcel.writeString(mNote);
        parcel.writeInt(mDesiredQuantity);
        parcel.writeInt(mPurchasedQuantity);
        parcel.writeParcelable(mTcin, i);
        long l;
        if (mServerLastModifiedDate != null)
        {
            l = mServerLastModifiedDate.getTime();
        } else
        {
            l = -1L;
        }
        parcel.writeLong(l);
        parcel.writeLong(mItemPosition);
        if (mIsCompleted)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
    }

}
