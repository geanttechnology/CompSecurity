// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache.list;

import android.os.Parcel;
import com.target.mothership.common.c.b;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.mothership.util.k;
import com.target.mothership.util.m;
import java.util.Date;

public class CacheListSummary
    implements ListSummary
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CacheListSummary createFromParcel(Parcel parcel)
        {
            return new CacheListSummary(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public CacheListSummary[] newArray(int i)
        {
            return new CacheListSummary[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final String DELETING_FIELD = "mIsDeleting";
    public static final String GUEST_ID_FIELD = "mGuestId";
    public static final String IS_DEFAULT_LIST_FIELD = "mIsDefaultList";
    public static final String LIST_POSITION_FIELD = "mListPosition";
    public static final String LIST_SUMMARY_TABLE = "list_summary";
    public static final String REMOTE_ID_FIELD = "mId";
    private b mChannel;
    private String mDescription;
    private String mGuestId;
    private String mId;
    private boolean mIsDefaultList;
    private boolean mIsDeleting;
    private boolean mIsDirty;
    private int mItemCount;
    private int mKey;
    private Date mLastModifiedDate;
    private String mLastModifiedUserId;
    private long mListPosition;
    private String mListToken;
    private String mLocation;
    private String mOrganization;
    private Date mServerLastModifiedDate;
    private String mTitle;
    private String mTitleResourceId;

    public CacheListSummary()
    {
    }

    protected CacheListSummary(Parcel parcel)
    {
        Object obj1 = null;
        boolean flag1 = true;
        super();
        mKey = parcel.readInt();
        mId = parcel.readString();
        int i = parcel.readInt();
        Object obj;
        long l;
        boolean flag;
        if (i == -1)
        {
            obj = null;
        } else
        {
            obj = b.values()[i];
        }
        mChannel = ((b) (obj));
        mOrganization = parcel.readString();
        mLocation = parcel.readString();
        mTitle = parcel.readString();
        mItemCount = parcel.readInt();
        mDescription = parcel.readString();
        mTitleResourceId = parcel.readString();
        mGuestId = parcel.readString();
        mLastModifiedUserId = parcel.readString();
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsDefaultList = flag;
        l = parcel.readLong();
        if (l == -1L)
        {
            obj = null;
        } else
        {
            obj = new Date(l);
        }
        mLastModifiedDate = ((Date) (obj));
        l = parcel.readLong();
        if (l == -1L)
        {
            obj = obj1;
        } else
        {
            obj = new Date(l);
        }
        mServerLastModifiedDate = ((Date) (obj));
        mListPosition = parcel.readLong();
        mListToken = parcel.readString();
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
            flag = flag1;
        } else
        {
            flag = false;
        }
        mIsDeleting = flag;
    }

    public CacheListSummary(ListSummary listsummary)
    {
        mKey = listsummary.getKey();
        mId = listsummary.getId();
        mChannel = listsummary.getChannel();
        mOrganization = listsummary.getOrganization();
        mLocation = listsummary.getLocation();
        mTitle = listsummary.getTitle();
        mItemCount = listsummary.getItemCount();
        mDescription = listsummary.getDescription();
        mTitleResourceId = listsummary.getTitleResourceId();
        mLastModifiedDate = listsummary.getLastModifiedDate();
        mServerLastModifiedDate = listsummary.getServerLastModifiedDate();
        mLastModifiedUserId = listsummary.getLastModifiedUserId();
        mGuestId = listsummary.getGuestId();
        mIsDefaultList = listsummary.isDefaultList();
        mListToken = listsummary.getListToken();
        mListPosition = listsummary.getListPosition();
        mIsDirty = listsummary.isDirty();
        mIsDeleting = listsummary.isDeleting();
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
        obj = (CacheListSummary)obj;
        flag = flag2;
        if (mKey != ((CacheListSummary) (obj)).mKey) goto _L4; else goto _L6
_L6:
        flag = flag2;
        if (mItemCount != ((CacheListSummary) (obj)).mItemCount) goto _L4; else goto _L7
_L7:
        flag = flag2;
        if (mIsDefaultList != ((CacheListSummary) (obj)).mIsDefaultList) goto _L4; else goto _L8
_L8:
        flag = flag2;
        if (mListPosition != ((CacheListSummary) (obj)).mListPosition) goto _L4; else goto _L9
_L9:
        flag = flag2;
        if (mIsDirty != ((CacheListSummary) (obj)).mIsDirty) goto _L4; else goto _L10
_L10:
        flag = flag2;
        if (mIsDeleting != ((CacheListSummary) (obj)).mIsDeleting) goto _L4; else goto _L11
_L11:
        if (mId == null) goto _L13; else goto _L12
_L12:
        flag = flag2;
        if (!mId.equals(((CacheListSummary) (obj)).mId)) goto _L4; else goto _L14
_L14:
        flag = flag2;
        if (mChannel != ((CacheListSummary) (obj)).mChannel) goto _L4; else goto _L15
_L15:
        if (mOrganization == null) goto _L17; else goto _L16
_L16:
        flag = flag2;
        if (!mOrganization.equals(((CacheListSummary) (obj)).mOrganization)) goto _L4; else goto _L18
_L18:
        if (mLocation == null) goto _L20; else goto _L19
_L19:
        flag = flag2;
        if (!mLocation.equals(((CacheListSummary) (obj)).mLocation)) goto _L4; else goto _L21
_L21:
        if (mTitle == null) goto _L23; else goto _L22
_L22:
        flag = flag2;
        if (!mTitle.equals(((CacheListSummary) (obj)).mTitle)) goto _L4; else goto _L24
_L24:
        if (mDescription == null) goto _L26; else goto _L25
_L25:
        flag = flag2;
        if (!mDescription.equals(((CacheListSummary) (obj)).mDescription)) goto _L4; else goto _L27
_L27:
        if (mTitleResourceId == null) goto _L29; else goto _L28
_L28:
        flag = flag2;
        if (!mTitleResourceId.equals(((CacheListSummary) (obj)).mTitleResourceId)) goto _L4; else goto _L30
_L30:
        if (mLastModifiedDate == null) goto _L32; else goto _L31
_L31:
        flag = flag2;
        if (!mLastModifiedDate.equals(((CacheListSummary) (obj)).mLastModifiedDate)) goto _L4; else goto _L33
_L33:
        if (mServerLastModifiedDate == null) goto _L35; else goto _L34
_L34:
        flag = flag2;
        if (!mServerLastModifiedDate.equals(((CacheListSummary) (obj)).mServerLastModifiedDate)) goto _L4; else goto _L36
_L36:
        if (mLastModifiedUserId == null) goto _L38; else goto _L37
_L37:
        flag = flag2;
        if (!mLastModifiedUserId.equals(((CacheListSummary) (obj)).mLastModifiedUserId)) goto _L4; else goto _L39
_L39:
        if (mGuestId == null) goto _L41; else goto _L40
_L40:
        flag = flag2;
        if (!mGuestId.equals(((CacheListSummary) (obj)).mGuestId)) goto _L4; else goto _L42
_L42:
        if (mListToken == null) goto _L44; else goto _L43
_L43:
        flag = flag1;
        if (mListToken.equals(((CacheListSummary) (obj)).mListToken)) goto _L46; else goto _L45
_L45:
        flag = false;
_L46:
        return flag;
_L13:
        if (((CacheListSummary) (obj)).mId == null) goto _L14; else goto _L47
_L47:
        return false;
_L17:
        if (((CacheListSummary) (obj)).mOrganization == null) goto _L18; else goto _L48
_L48:
        return false;
_L20:
        if (((CacheListSummary) (obj)).mLocation == null) goto _L21; else goto _L49
_L49:
        return false;
_L23:
        if (((CacheListSummary) (obj)).mTitle == null) goto _L24; else goto _L50
_L50:
        return false;
_L26:
        if (((CacheListSummary) (obj)).mDescription == null) goto _L27; else goto _L51
_L51:
        return false;
_L29:
        if (((CacheListSummary) (obj)).mTitleResourceId == null) goto _L30; else goto _L52
_L52:
        return false;
_L32:
        if (((CacheListSummary) (obj)).mLastModifiedDate == null) goto _L33; else goto _L53
_L53:
        return false;
_L35:
        if (((CacheListSummary) (obj)).mServerLastModifiedDate == null) goto _L36; else goto _L54
_L54:
        return false;
_L38:
        if (((CacheListSummary) (obj)).mLastModifiedUserId == null) goto _L39; else goto _L55
_L55:
        return false;
_L41:
        if (((CacheListSummary) (obj)).mGuestId == null) goto _L42; else goto _L56
_L56:
        return false;
_L44:
        if (((CacheListSummary) (obj)).mListToken != null) goto _L45; else goto _L57
_L57:
        flag = flag1;
          goto _L46
    }

    public b getChannel()
    {
        return mChannel;
    }

    public String getDescription()
    {
        return mDescription;
    }

    public String getGuestId()
    {
        return mGuestId;
    }

    public String getId()
    {
        return mId;
    }

    public int getItemCount()
    {
        return mItemCount;
    }

    public int getKey()
    {
        return mKey;
    }

    public Date getLastModifiedDate()
    {
        return mLastModifiedDate;
    }

    public String getLastModifiedUserId()
    {
        return mLastModifiedUserId;
    }

    public long getListPosition()
    {
        return mListPosition;
    }

    public String getListToken()
    {
        return mListToken;
    }

    public String getLocation()
    {
        return mLocation;
    }

    public String getOrganization()
    {
        return mOrganization;
    }

    public Date getServerLastModifiedDate()
    {
        return mServerLastModifiedDate;
    }

    public String getTitle()
    {
        if (mTitleResourceId != null)
        {
            String s = m.a(mTitleResourceId);
            if (s != null)
            {
                return s;
            }
        }
        return mTitle;
    }

    public String getTitleResourceId()
    {
        return mTitleResourceId;
    }

    public int hashCode()
    {
        int l3 = 1;
        int i4 = mKey;
        int i;
        int j;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int j4;
        int k4;
        if (mId != null)
        {
            i = mId.hashCode();
        } else
        {
            i = 0;
        }
        if (mChannel != null)
        {
            j = mChannel.hashCode();
        } else
        {
            j = 0;
        }
        if (mOrganization != null)
        {
            l = mOrganization.hashCode();
        } else
        {
            l = 0;
        }
        if (mLocation != null)
        {
            i1 = mLocation.hashCode();
        } else
        {
            i1 = 0;
        }
        if (mTitle != null)
        {
            j1 = mTitle.hashCode();
        } else
        {
            j1 = 0;
        }
        j4 = mItemCount;
        if (mDescription != null)
        {
            k1 = mDescription.hashCode();
        } else
        {
            k1 = 0;
        }
        if (mTitleResourceId != null)
        {
            l1 = mTitleResourceId.hashCode();
        } else
        {
            l1 = 0;
        }
        if (mLastModifiedDate != null)
        {
            i2 = mLastModifiedDate.hashCode();
        } else
        {
            i2 = 0;
        }
        if (mServerLastModifiedDate != null)
        {
            j2 = mServerLastModifiedDate.hashCode();
        } else
        {
            j2 = 0;
        }
        if (mLastModifiedUserId != null)
        {
            k2 = mLastModifiedUserId.hashCode();
        } else
        {
            k2 = 0;
        }
        if (mGuestId != null)
        {
            l2 = mGuestId.hashCode();
        } else
        {
            l2 = 0;
        }
        if (mIsDefaultList)
        {
            i3 = 1;
        } else
        {
            i3 = 0;
        }
        if (mListToken != null)
        {
            j3 = mListToken.hashCode();
        } else
        {
            j3 = 0;
        }
        k4 = (int)(mListPosition ^ mListPosition >>> 32);
        if (mIsDirty)
        {
            k3 = 1;
        } else
        {
            k3 = 0;
        }
        if (!mIsDeleting)
        {
            l3 = 0;
        }
        return (k3 + ((j3 + (i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + ((j1 + (i1 + (l + (j + (i + i4 * 31) * 31) * 31) * 31) * 31) * 31 + j4) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + k4) * 31) * 31 + l3;
    }

    public boolean isDefaultList()
    {
        return mIsDefaultList;
    }

    public boolean isDeleting()
    {
        return mIsDeleting;
    }

    public boolean isDirty()
    {
        return mIsDirty;
    }

    public void setChannel(b b1)
    {
        mChannel = b1;
    }

    public void setDefaultList(boolean flag)
    {
        boolean flag1;
        if (mIsDirty || !k.a(mIsDefaultList, flag))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        mIsDirty = flag1;
        mIsDefaultList = flag;
    }

    public void setDeleting(boolean flag)
    {
        mIsDeleting = flag;
    }

    public void setDescription(String s)
    {
        boolean flag;
        if (mIsDirty || !k.a(mDescription, s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsDirty = flag;
        mDescription = s;
    }

    public void setDirty(boolean flag)
    {
        mIsDirty = flag;
    }

    public void setGuestId(String s)
    {
        mGuestId = s;
    }

    public void setId(String s)
    {
        mId = s;
    }

    public void setItemCount(int i)
    {
        mItemCount = i;
    }

    public void setKey(int i)
    {
        mKey = i;
    }

    public void setLastModifiedDate(Date date)
    {
        mLastModifiedDate = date;
    }

    public void setLastModifiedUserId(String s)
    {
        mLastModifiedUserId = s;
    }

    public void setListPosition(long l)
    {
        mListPosition = l;
    }

    public void setListToken(String s)
    {
        mListToken = s;
    }

    public void setLocation(String s)
    {
        mLocation = s;
    }

    public void setOrganization(String s)
    {
        mOrganization = s;
    }

    public void setResourceId(String s)
    {
        mTitleResourceId = s;
    }

    public void setServerLastModifiedDate(Date date)
    {
        mServerLastModifiedDate = date;
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

    public void setTitleResourceId(String s)
    {
        mTitleResourceId = s;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        long l1 = -1L;
        boolean flag = true;
        parcel.writeInt(mKey);
        parcel.writeString(mId);
        byte byte0;
        long l;
        if (mChannel == null)
        {
            i = -1;
        } else
        {
            i = mChannel.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeString(mOrganization);
        parcel.writeString(mLocation);
        parcel.writeString(mTitle);
        parcel.writeInt(mItemCount);
        parcel.writeString(mDescription);
        parcel.writeString(mTitleResourceId);
        parcel.writeString(mGuestId);
        parcel.writeString(mLastModifiedUserId);
        if (mIsDefaultList)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
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
        parcel.writeLong(mListPosition);
        parcel.writeString(mListToken);
        if (mIsDirty)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsDeleting)
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
    }

}
