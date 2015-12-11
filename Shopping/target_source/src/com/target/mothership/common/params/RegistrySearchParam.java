// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.params;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.common.registries.b;
import com.target.mothership.common.registries.c;
import com.target.mothership.common.registries.d;
import com.target.mothership.common.registries.e;
import com.target.mothership.common.registries.f;
import com.target.mothership.common.registries.h;
import com.target.mothership.util.k;
import java.util.Date;

// Referenced classes of package com.target.mothership.common.params:
//            a

public class RegistrySearchParam extends a
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public RegistrySearchParam a(Parcel parcel)
        {
            return new RegistrySearchParam(parcel);
        }

        public RegistrySearchParam[] a(int i1)
        {
            return new RegistrySearchParam[i1];
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
    private String mAltListId;
    private final b mChannel;
    private String mEmailId;
    private Date mEndDate;
    private String mEventCity;
    private String mEventState;
    private c mEventType;
    private final String mFirstName;
    private final String mLastName;
    private Integer mLimit;
    private Integer mOffset;
    private String mOrganization;
    private String mPhoneNumber;
    private String mProfileId;
    private d mRole;
    private e mSortBy;
    private f mSortOrder;
    private Date mStartDate;
    private final h mSubChannel;

    protected RegistrySearchParam(Parcel parcel)
    {
        Object obj1 = null;
        super();
        mFirstName = parcel.readString();
        mLastName = parcel.readString();
        int i1 = parcel.readInt();
        Object obj;
        long l1;
        if (i1 == -1)
        {
            obj = null;
        } else
        {
            obj = com.target.mothership.common.registries.b.values()[i1];
        }
        mChannel = ((b) (obj));
        i1 = parcel.readInt();
        if (i1 == -1)
        {
            obj = null;
        } else
        {
            obj = com.target.mothership.common.registries.h.values()[i1];
        }
        mSubChannel = ((h) (obj));
        i1 = parcel.readInt();
        if (i1 == -1)
        {
            obj = null;
        } else
        {
            obj = com.target.mothership.common.registries.d.values()[i1];
        }
        mRole = ((d) (obj));
        i1 = parcel.readInt();
        if (i1 == -1)
        {
            obj = null;
        } else
        {
            obj = com.target.mothership.common.registries.c.values()[i1];
        }
        mEventType = ((c) (obj));
        i1 = parcel.readInt();
        if (i1 == -1)
        {
            obj = null;
        } else
        {
            obj = com.target.mothership.common.registries.e.values()[i1];
        }
        mSortBy = ((e) (obj));
        i1 = parcel.readInt();
        if (i1 == -1)
        {
            obj = null;
        } else
        {
            obj = com.target.mothership.common.registries.f.values()[i1];
        }
        mSortOrder = ((f) (obj));
        mEmailId = parcel.readString();
        mEventState = parcel.readString();
        mEventCity = parcel.readString();
        mOrganization = parcel.readString();
        mPhoneNumber = parcel.readString();
        mLimit = (Integer)parcel.readValue(java/lang/Integer.getClassLoader());
        mOffset = (Integer)parcel.readValue(java/lang/Integer.getClassLoader());
        l1 = parcel.readLong();
        if (l1 == -1L)
        {
            obj = null;
        } else
        {
            obj = new Date(l1);
        }
        mStartDate = ((Date) (obj));
        l1 = parcel.readLong();
        if (l1 == -1L)
        {
            obj = obj1;
        } else
        {
            obj = new Date(l1);
        }
        mEndDate = ((Date) (obj));
        mProfileId = parcel.readString();
        mAltListId = parcel.readString();
    }

    public RegistrySearchParam(String s1, String s2)
    {
        mFirstName = s1;
        mLastName = s2;
        mChannel = b.MOBILE;
        mSubChannel = h.ANDROID;
        mEventType = c.TARGET_LIST;
    }

    public final String a()
    {
        return mFirstName;
    }

    public void a(c c1)
    {
        mEventType = c1;
    }

    public void a(e e1)
    {
        mSortBy = e1;
    }

    public void a(f f1)
    {
        mSortOrder = f1;
    }

    public void a(Integer integer)
    {
        mLimit = integer;
    }

    public void a(String s1)
    {
        mEmailId = s1;
    }

    public void a(Date date)
    {
        mStartDate = date;
    }

    public final String b()
    {
        return mLastName;
    }

    public void b(Integer integer)
    {
        mOffset = integer;
    }

    public void b(String s1)
    {
        mEventState = s1;
    }

    public void b(Date date)
    {
        mEndDate = date;
    }

    public final String c()
    {
        return "3991";
    }

    public void c(String s1)
    {
        mEventCity = s1;
    }

    public final b d()
    {
        return mChannel;
    }

    public int describeContents()
    {
        return 0;
    }

    public final h e()
    {
        return mSubChannel;
    }

    public d f()
    {
        if (mRole == null)
        {
            return d.UNKNOWN;
        } else
        {
            return mRole;
        }
    }

    public c g()
    {
        if (mEventType == null)
        {
            return c.UNKNOWN;
        } else
        {
            return mEventType;
        }
    }

    public e h()
    {
        if (mSortBy == null)
        {
            return e.EVENT_DATE;
        } else
        {
            return mSortBy;
        }
    }

    public f i()
    {
        if (mSortOrder == null)
        {
            return f.ASCENDING_ORDER;
        } else
        {
            return mSortOrder;
        }
    }

    public com.google.a.a.e j()
    {
        return com.target.mothership.util.k.a(mEmailId);
    }

    public com.google.a.a.e k()
    {
        return com.target.mothership.util.k.a(mEventState);
    }

    public com.google.a.a.e l()
    {
        return com.target.mothership.util.k.a(mEventCity);
    }

    public com.google.a.a.e m()
    {
        return com.target.mothership.util.k.a(mOrganization);
    }

    public com.google.a.a.e n()
    {
        return com.target.mothership.util.k.a(mPhoneNumber);
    }

    public com.google.a.a.e o()
    {
        return com.target.mothership.util.k.a(mLimit);
    }

    public com.google.a.a.e p()
    {
        return com.target.mothership.util.k.a(mOffset);
    }

    public com.google.a.a.e q()
    {
        return com.target.mothership.util.k.a(mStartDate);
    }

    public com.google.a.a.e r()
    {
        return com.target.mothership.util.k.a(mEndDate);
    }

    public com.google.a.a.e s()
    {
        return com.target.mothership.util.k.a(mProfileId);
    }

    public com.google.a.a.e t()
    {
        return com.target.mothership.util.k.a(mAltListId);
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        long l2 = -1L;
        byte byte0 = -1;
        parcel.writeString(mFirstName);
        parcel.writeString(mLastName);
        long l1;
        if (mChannel == null)
        {
            i1 = -1;
        } else
        {
            i1 = mChannel.ordinal();
        }
        parcel.writeInt(i1);
        if (mSubChannel == null)
        {
            i1 = -1;
        } else
        {
            i1 = mSubChannel.ordinal();
        }
        parcel.writeInt(i1);
        if (mRole == null)
        {
            i1 = -1;
        } else
        {
            i1 = mRole.ordinal();
        }
        parcel.writeInt(i1);
        if (mEventType == null)
        {
            i1 = -1;
        } else
        {
            i1 = mEventType.ordinal();
        }
        parcel.writeInt(i1);
        if (mSortBy == null)
        {
            i1 = -1;
        } else
        {
            i1 = mSortBy.ordinal();
        }
        parcel.writeInt(i1);
        if (mSortOrder == null)
        {
            i1 = byte0;
        } else
        {
            i1 = mSortOrder.ordinal();
        }
        parcel.writeInt(i1);
        parcel.writeString(mEmailId);
        parcel.writeString(mEventState);
        parcel.writeString(mEventCity);
        parcel.writeString(mOrganization);
        parcel.writeString(mPhoneNumber);
        parcel.writeValue(mLimit);
        parcel.writeValue(mOffset);
        if (mStartDate != null)
        {
            l1 = mStartDate.getTime();
        } else
        {
            l1 = -1L;
        }
        parcel.writeLong(l1);
        l1 = l2;
        if (mEndDate != null)
        {
            l1 = mEndDate.getTime();
        }
        parcel.writeLong(l1);
        parcel.writeString(mProfileId);
        parcel.writeString(mAltListId);
    }

}
