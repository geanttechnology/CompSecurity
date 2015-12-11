// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list.handler;

import android.os.Parcel;
import com.target.mothership.common.c.b;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.mothership.util.m;
import java.util.Date;

class TGTListSummary
    implements ListSummary
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTListSummary a(Parcel parcel)
        {
            return new TGTListSummary(parcel);
        }

        public TGTListSummary[] a(int i)
        {
            return new TGTListSummary[i];
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
    private b mChannel;
    private String mDescription;
    private String mGuestId;
    private String mId;
    private boolean mIsDefaultList;
    private int mItemCount;
    private int mKey;
    private String mLastModifiedUserId;
    private long mListPosition;
    private String mListToken;
    private String mLocation;
    private String mOrganization;
    private Date mServerLastModifiedDate;
    private String mTitle;
    private String mTitleResourceId;

    TGTListSummary()
    {
    }

    protected TGTListSummary(Parcel parcel)
    {
        Object obj1 = null;
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
            obj = obj1;
        } else
        {
            obj = new Date(l);
        }
        mServerLastModifiedDate = ((Date) (obj));
        mListPosition = parcel.readLong();
        mListToken = parcel.readString();
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
        obj = (TGTListSummary)obj;
        flag = flag2;
        if (mKey != ((TGTListSummary) (obj)).mKey) goto _L4; else goto _L6
_L6:
        flag = flag2;
        if (mItemCount != ((TGTListSummary) (obj)).mItemCount) goto _L4; else goto _L7
_L7:
        flag = flag2;
        if (mListPosition != ((TGTListSummary) (obj)).mListPosition) goto _L4; else goto _L8
_L8:
        flag = flag2;
        if (mIsDefaultList != ((TGTListSummary) (obj)).mIsDefaultList) goto _L4; else goto _L9
_L9:
        if (mId == null) goto _L11; else goto _L10
_L10:
        flag = flag2;
        if (!mId.equals(((TGTListSummary) (obj)).mId)) goto _L4; else goto _L12
_L12:
        flag = flag2;
        if (mChannel != ((TGTListSummary) (obj)).mChannel) goto _L4; else goto _L13
_L13:
        if (mOrganization == null) goto _L15; else goto _L14
_L14:
        flag = flag2;
        if (!mOrganization.equals(((TGTListSummary) (obj)).mOrganization)) goto _L4; else goto _L16
_L16:
        if (mLocation == null) goto _L18; else goto _L17
_L17:
        flag = flag2;
        if (!mLocation.equals(((TGTListSummary) (obj)).mLocation)) goto _L4; else goto _L19
_L19:
        if (mTitle == null) goto _L21; else goto _L20
_L20:
        flag = flag2;
        if (!mTitle.equals(((TGTListSummary) (obj)).mTitle)) goto _L4; else goto _L22
_L22:
        if (mDescription == null) goto _L24; else goto _L23
_L23:
        flag = flag2;
        if (!mDescription.equals(((TGTListSummary) (obj)).mDescription)) goto _L4; else goto _L25
_L25:
        if (mTitleResourceId == null) goto _L27; else goto _L26
_L26:
        flag = flag2;
        if (!mTitleResourceId.equals(((TGTListSummary) (obj)).mTitleResourceId)) goto _L4; else goto _L28
_L28:
        if (mGuestId == null) goto _L30; else goto _L29
_L29:
        flag = flag2;
        if (!mGuestId.equals(((TGTListSummary) (obj)).mGuestId)) goto _L4; else goto _L31
_L31:
        if (mServerLastModifiedDate == null) goto _L33; else goto _L32
_L32:
        flag = flag2;
        if (!mServerLastModifiedDate.equals(((TGTListSummary) (obj)).mServerLastModifiedDate)) goto _L4; else goto _L34
_L34:
        if (mLastModifiedUserId == null) goto _L36; else goto _L35
_L35:
        flag = flag2;
        if (!mLastModifiedUserId.equals(((TGTListSummary) (obj)).mLastModifiedUserId)) goto _L4; else goto _L37
_L37:
        if (mListToken == null) goto _L39; else goto _L38
_L38:
        flag = flag1;
        if (mListToken.equals(((TGTListSummary) (obj)).mListToken)) goto _L41; else goto _L40
_L40:
        flag = false;
_L41:
        return flag;
_L11:
        if (((TGTListSummary) (obj)).mId == null) goto _L12; else goto _L42
_L42:
        return false;
_L15:
        if (((TGTListSummary) (obj)).mOrganization == null) goto _L16; else goto _L43
_L43:
        return false;
_L18:
        if (((TGTListSummary) (obj)).mLocation == null) goto _L19; else goto _L44
_L44:
        return false;
_L21:
        if (((TGTListSummary) (obj)).mTitle == null) goto _L22; else goto _L45
_L45:
        return false;
_L24:
        if (((TGTListSummary) (obj)).mDescription == null) goto _L25; else goto _L46
_L46:
        return false;
_L27:
        if (((TGTListSummary) (obj)).mTitleResourceId == null) goto _L28; else goto _L47
_L47:
        return false;
_L30:
        if (((TGTListSummary) (obj)).mGuestId == null) goto _L31; else goto _L48
_L48:
        return false;
_L33:
        if (((TGTListSummary) (obj)).mServerLastModifiedDate == null) goto _L34; else goto _L49
_L49:
        return false;
_L36:
        if (((TGTListSummary) (obj)).mLastModifiedUserId == null) goto _L37; else goto _L50
_L50:
        return false;
_L39:
        if (((TGTListSummary) (obj)).mListToken != null) goto _L40; else goto _L51
_L51:
        flag = flag1;
          goto _L41
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
        return null;
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
        int l2 = 0;
        int i3 = mKey;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int j3;
        int k3;
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
            k = mOrganization.hashCode();
        } else
        {
            k = 0;
        }
        if (mLocation != null)
        {
            l = mLocation.hashCode();
        } else
        {
            l = 0;
        }
        if (mTitle != null)
        {
            i1 = mTitle.hashCode();
        } else
        {
            i1 = 0;
        }
        j3 = mItemCount;
        if (mDescription != null)
        {
            j1 = mDescription.hashCode();
        } else
        {
            j1 = 0;
        }
        if (mTitleResourceId != null)
        {
            k1 = mTitleResourceId.hashCode();
        } else
        {
            k1 = 0;
        }
        if (mGuestId != null)
        {
            l1 = mGuestId.hashCode();
        } else
        {
            l1 = 0;
        }
        if (mServerLastModifiedDate != null)
        {
            i2 = mServerLastModifiedDate.hashCode();
        } else
        {
            i2 = 0;
        }
        if (mLastModifiedUserId != null)
        {
            j2 = mLastModifiedUserId.hashCode();
        } else
        {
            j2 = 0;
        }
        if (mListToken != null)
        {
            k2 = mListToken.hashCode();
        } else
        {
            k2 = 0;
        }
        k3 = (int)(mListPosition ^ mListPosition >>> 32);
        if (mIsDefaultList)
        {
            l2 = 1;
        }
        return ((k2 + (j2 + (i2 + (l1 + (k1 + (j1 + ((i1 + (l + (k + (j + (i + i3 * 31) * 31) * 31) * 31) * 31) * 31 + j3) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + k3) * 31 + l2;
    }

    public boolean isDefaultList()
    {
        return mIsDefaultList;
    }

    public boolean isDeleting()
    {
        return false;
    }

    public boolean isDirty()
    {
        return false;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
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
        if (mServerLastModifiedDate != null)
        {
            l = mServerLastModifiedDate.getTime();
        } else
        {
            l = -1L;
        }
        parcel.writeLong(l);
        parcel.writeLong(mListPosition);
        parcel.writeString(mListToken);
    }

}
