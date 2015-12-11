// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache.list;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.model.list.interfaces.ListItem;
import com.target.mothership.util.k;
import com.target.mothership.util.o;
import java.util.Date;

public class CacheListItem
    implements Parcelable, ListItem
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CacheListItem createFromParcel(Parcel parcel)
        {
            return new CacheListItem(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public CacheListItem[] newArray(int i)
        {
            return new CacheListItem[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final String ITEM_COMPLETED_FIELD = "mIsCompleted";
    public static final String ITEM_DELETING_FIELD = "mIsDeleting";
    public static final String ITEM_POSITION_FIELD = "mItemPosition";
    public static final String LIST_ITEM_TABLE = "list_item";
    public static final String LIST_KEY_FIELD = "mListKey";
    public static final String REMOTE_ID_FIELD = "mListItemId";
    private int mDesiredQuantity;
    private boolean mIsCompleted;
    private boolean mIsDeleting;
    private boolean mIsDirty;
    private long mItemPosition;
    private int mKey;
    private Date mLastModifiedDate;
    private String mListId;
    private String mListItemId;
    private int mListKey;
    private String mNote;
    private int mPurchasedQuantity;
    private Date mServerLastModifiedDate;
    private String mTcinString;
    private String mTitle;

    public CacheListItem()
    {
    }

    private CacheListItem(Parcel parcel)
    {
        Object obj = null;
        boolean flag1 = true;
        super();
        mKey = parcel.readInt();
        mListKey = parcel.readInt();
        mListItemId = parcel.readString();
        mTitle = parcel.readString();
        mNote = parcel.readString();
        mDesiredQuantity = parcel.readInt();
        mPurchasedQuantity = parcel.readInt();
        mTcinString = parcel.readString();
        mListId = parcel.readString();
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
        mLastModifiedDate = date;
        l = parcel.readLong();
        if (l == -1L)
        {
            date = obj;
        } else
        {
            date = new Date(l);
        }
        mServerLastModifiedDate = date;
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsDirty = flag;
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsDeleting = flag;
        mItemPosition = parcel.readLong();
        if (parcel.readByte() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mIsCompleted = flag;
    }


    public CacheListItem(ListItem listitem)
    {
        mKey = listitem.getKey();
        mListKey = listitem.getListKey();
        mListItemId = listitem.getListItemId();
        mTitle = listitem.getTitle();
        mNote = listitem.getNote();
        mDesiredQuantity = listitem.getDesiredQuantity();
        mPurchasedQuantity = listitem.getPurchasedQuantity();
        String s;
        if (listitem.getTcin().b())
        {
            s = ((Tcin)listitem.getTcin().c()).b();
        } else
        {
            s = null;
        }
        mTcinString = s;
        mListId = listitem.getListId();
        mLastModifiedDate = listitem.getLastModifiedDate();
        mServerLastModifiedDate = listitem.getServerLastModifiedDate();
        mIsDirty = listitem.isDirty();
        mIsDeleting = listitem.isDeleting();
        mItemPosition = listitem.getItemPosition();
        mIsCompleted = listitem.isCompleted();
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
        obj = (CacheListItem)obj;
        flag = flag2;
        if (mKey != ((CacheListItem) (obj)).mKey) goto _L4; else goto _L6
_L6:
        flag = flag2;
        if (mListKey != ((CacheListItem) (obj)).mListKey) goto _L4; else goto _L7
_L7:
        flag = flag2;
        if (mDesiredQuantity != ((CacheListItem) (obj)).mDesiredQuantity) goto _L4; else goto _L8
_L8:
        flag = flag2;
        if (mPurchasedQuantity != ((CacheListItem) (obj)).mPurchasedQuantity) goto _L4; else goto _L9
_L9:
        flag = flag2;
        if (mIsDirty != ((CacheListItem) (obj)).mIsDirty) goto _L4; else goto _L10
_L10:
        flag = flag2;
        if (mIsDeleting != ((CacheListItem) (obj)).mIsDeleting) goto _L4; else goto _L11
_L11:
        flag = flag2;
        if (mItemPosition != ((CacheListItem) (obj)).mItemPosition) goto _L4; else goto _L12
_L12:
        flag = flag2;
        if (mIsCompleted != ((CacheListItem) (obj)).mIsCompleted) goto _L4; else goto _L13
_L13:
        if (mListItemId == null) goto _L15; else goto _L14
_L14:
        flag = flag2;
        if (!mListItemId.equals(((CacheListItem) (obj)).mListItemId)) goto _L4; else goto _L16
_L16:
        if (mTitle == null) goto _L18; else goto _L17
_L17:
        flag = flag2;
        if (!mTitle.equals(((CacheListItem) (obj)).mTitle)) goto _L4; else goto _L19
_L19:
        if (mNote == null) goto _L21; else goto _L20
_L20:
        flag = flag2;
        if (!mNote.equals(((CacheListItem) (obj)).mNote)) goto _L4; else goto _L22
_L22:
        if (mTcinString == null) goto _L24; else goto _L23
_L23:
        flag = flag2;
        if (!mTcinString.equals(((CacheListItem) (obj)).mTcinString)) goto _L4; else goto _L25
_L25:
        if (mListId == null) goto _L27; else goto _L26
_L26:
        flag = flag2;
        if (!mListId.equals(((CacheListItem) (obj)).mListId)) goto _L4; else goto _L28
_L28:
        if (mLastModifiedDate == null) goto _L30; else goto _L29
_L29:
        flag = flag2;
        if (!mLastModifiedDate.equals(((CacheListItem) (obj)).mLastModifiedDate)) goto _L4; else goto _L31
_L31:
        if (mServerLastModifiedDate == null) goto _L33; else goto _L32
_L32:
        flag = flag1;
        if (mServerLastModifiedDate.equals(((CacheListItem) (obj)).mServerLastModifiedDate)) goto _L35; else goto _L34
_L34:
        flag = false;
_L35:
        return flag;
_L15:
        if (((CacheListItem) (obj)).mListItemId == null) goto _L16; else goto _L36
_L36:
        return false;
_L18:
        if (((CacheListItem) (obj)).mTitle == null) goto _L19; else goto _L37
_L37:
        return false;
_L21:
        if (((CacheListItem) (obj)).mNote == null) goto _L22; else goto _L38
_L38:
        return false;
_L24:
        if (((CacheListItem) (obj)).mTcinString == null) goto _L25; else goto _L39
_L39:
        return false;
_L27:
        if (((CacheListItem) (obj)).mListId == null) goto _L28; else goto _L40
_L40:
        return false;
_L30:
        if (((CacheListItem) (obj)).mLastModifiedDate == null) goto _L31; else goto _L41
_L41:
        return false;
_L33:
        if (((CacheListItem) (obj)).mServerLastModifiedDate != null) goto _L34; else goto _L42
_L42:
        flag = flag1;
          goto _L35
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
        return mLastModifiedDate;
    }

    public String getListId()
    {
        return mListId;
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
        if (o.g(mTcinString))
        {
            return e.b(new Tcin(mTcinString));
        } else
        {
            return e.e();
        }
    }

    public String getTitle()
    {
        return mTitle;
    }

    public int hashCode()
    {
        int k2 = 1;
        int l2 = mKey;
        int i3 = mListKey;
        int i;
        int j;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int j3;
        int k3;
        int l3;
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
            l = mNote.hashCode();
        } else
        {
            l = 0;
        }
        j3 = mDesiredQuantity;
        k3 = mPurchasedQuantity;
        if (mTcinString != null)
        {
            i1 = mTcinString.hashCode();
        } else
        {
            i1 = 0;
        }
        if (mListId != null)
        {
            j1 = mListId.hashCode();
        } else
        {
            j1 = 0;
        }
        if (mLastModifiedDate != null)
        {
            k1 = mLastModifiedDate.hashCode();
        } else
        {
            k1 = 0;
        }
        if (mServerLastModifiedDate != null)
        {
            l1 = mServerLastModifiedDate.hashCode();
        } else
        {
            l1 = 0;
        }
        if (mIsDirty)
        {
            i2 = 1;
        } else
        {
            i2 = 0;
        }
        if (mIsDeleting)
        {
            j2 = 1;
        } else
        {
            j2 = 0;
        }
        l3 = (int)(mItemPosition ^ mItemPosition >>> 32);
        if (!mIsCompleted)
        {
            k2 = 0;
        }
        return ((j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (((l + (j + (i + (l2 * 31 + i3) * 31) * 31) * 31) * 31 + j3) * 31 + k3) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + l3) * 31 + k2;
    }

    public boolean isCompleted()
    {
        return mIsCompleted;
    }

    public boolean isDeleting()
    {
        return mIsDeleting;
    }

    public boolean isDirty()
    {
        return mIsDirty;
    }

    public boolean isFulfilled()
    {
        return mPurchasedQuantity >= mDesiredQuantity;
    }

    public void setCompleted(boolean flag)
    {
        mIsCompleted = flag;
    }

    public void setDeleting(boolean flag)
    {
        mIsDeleting = flag;
    }

    public void setDesiredQuantity(int i)
    {
        boolean flag;
        if (mIsDeleting || mDesiredQuantity != i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsDirty = flag;
        mDesiredQuantity = i;
    }

    public void setDirty(boolean flag)
    {
        mIsDirty = flag;
    }

    public void setItemPosition(long l)
    {
        mItemPosition = l;
    }

    public void setKey(int i)
    {
        mKey = i;
    }

    public void setLastModifiedDate(Date date)
    {
        mLastModifiedDate = date;
    }

    public void setListId(String s)
    {
        mListId = s;
    }

    public void setListItemId(String s)
    {
        mListItemId = s;
    }

    public void setListKey(int i)
    {
        mListKey = i;
    }

    public void setNote(String s)
    {
        boolean flag;
        if (mIsDirty || !k.a(mNote, s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsDirty = flag;
        mNote = s;
    }

    public void setPurchasedQuantity(int i)
    {
        boolean flag;
        if (mIsDirty || mPurchasedQuantity != i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsDirty = flag;
        mPurchasedQuantity = i;
    }

    public void setServerLastModifiedDate(Date date)
    {
        mServerLastModifiedDate = date;
    }

    public void setTcin(Tcin tcin)
    {
        boolean flag;
        if (tcin != null)
        {
            tcin = tcin.b();
        } else
        {
            tcin = null;
        }
        if (mIsDirty || !k.a(mTcinString, tcin))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsDirty = flag;
        mTcinString = tcin;
    }

    public void setTitle(String s)
    {
        boolean flag;
        if (mIsDirty || !k.a(mTitle, s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsDirty = flag;
        mTitle = s;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        long l1 = -1L;
        boolean flag = true;
        parcel.writeInt(mKey);
        parcel.writeInt(mListKey);
        parcel.writeString(mListItemId);
        parcel.writeString(mTitle);
        parcel.writeString(mNote);
        parcel.writeInt(mDesiredQuantity);
        parcel.writeInt(mPurchasedQuantity);
        parcel.writeString(mTcinString);
        parcel.writeString(mListId);
        long l;
        if (mLastModifiedDate != null)
        {
            l = mLastModifiedDate.getTime();
        } else
        {
            l = -1L;
        }
        parcel.writeLong(l);
        l = l1;
        if (mServerLastModifiedDate != null)
        {
            l = mServerLastModifiedDate.getTime();
        }
        parcel.writeLong(l);
        if (mIsDirty)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (mIsDeleting)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeLong(mItemPosition);
        if (mIsCompleted)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
    }

}
