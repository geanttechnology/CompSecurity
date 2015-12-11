// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.registries.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.common.registries.RegistryAlternateId;
import com.target.mothership.common.registries.RegistryHashedId;
import com.target.mothership.common.registries.RegistryId;
import com.target.mothership.common.registries.c;
import com.target.mothership.common.registries.g;
import com.target.mothership.model.registries.interfaces.RegistryDetails;
import com.target.mothership.util.k;
import com.target.mothership.util.p;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.target.mothership.model.registries.handler:
//            TGTRegistryRecipient

public class TGTRegistryDetails
    implements RegistryDetails
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTRegistryDetails a(Parcel parcel)
        {
            return new TGTRegistryDetails(parcel);
        }

        public TGTRegistryDetails[] a(int i)
        {
            return new TGTRegistryDetails[i];
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
    private String mCity;
    private String mCountry;
    private Date mCreatedDate;
    private Date mEventDate;
    private RegistryAlternateId mRegistryAlternateId;
    private c mRegistryEventType;
    private RegistryHashedId mRegistryHashedId;
    private RegistryId mRegistryId;
    private List mRegistryRecipientList;
    private g mRegistryStatus;
    private String mRegistryTitle;
    private String mState;
    private int mTotalItemCount;

    TGTRegistryDetails()
    {
    }

    protected TGTRegistryDetails(Parcel parcel)
    {
        Object obj1 = null;
        super();
        mRegistryTitle = parcel.readString();
        mRegistryId = (RegistryId)parcel.readParcelable(com/target/mothership/common/registries/RegistryId.getClassLoader());
        int i = parcel.readInt();
        Object obj;
        long l;
        if (i == -1)
        {
            obj = null;
        } else
        {
            obj = com.target.mothership.common.registries.g.values()[i];
        }
        mRegistryStatus = ((g) (obj));
        mRegistryHashedId = (RegistryHashedId)parcel.readParcelable(com/target/mothership/common/registries/RegistryHashedId.getClassLoader());
        mRegistryAlternateId = (RegistryAlternateId)parcel.readParcelable(com/target/mothership/common/registries/RegistryAlternateId.getClassLoader());
        mCity = parcel.readString();
        mState = parcel.readString();
        mCountry = parcel.readString();
        l = parcel.readLong();
        if (l == -1L)
        {
            obj = null;
        } else
        {
            obj = new Date(l);
        }
        mEventDate = ((Date) (obj));
        l = parcel.readLong();
        if (l == -1L)
        {
            obj = null;
        } else
        {
            obj = new Date(l);
        }
        mCreatedDate = ((Date) (obj));
        mTotalItemCount = parcel.readInt();
        i = parcel.readInt();
        if (i == -1)
        {
            obj = obj1;
        } else
        {
            obj = com.target.mothership.common.registries.c.values()[i];
        }
        mRegistryEventType = ((c) (obj));
        mRegistryRecipientList = new ArrayList();
        parcel.readList(mRegistryRecipientList, com/target/mothership/model/registries/handler/TGTRegistryRecipient.getClassLoader());
    }

    public e a(Double double1)
    {
        if (mRegistryAlternateId == null)
        {
            return com.google.a.a.e.e();
        } else
        {
            return com.google.a.a.e.c(p.a(mRegistryAlternateId, double1));
        }
    }

    public String a()
    {
        return mRegistryTitle;
    }

    public void a(int i)
    {
        mTotalItemCount = i;
    }

    public void a(RegistryAlternateId registryalternateid)
    {
        mRegistryAlternateId = registryalternateid;
    }

    public void a(RegistryId registryid)
    {
        mRegistryId = registryid;
    }

    public void a(c c1)
    {
        mRegistryEventType = c1;
    }

    public void a(g g1)
    {
        mRegistryStatus = g1;
    }

    public void a(String s)
    {
        mRegistryTitle = s;
    }

    public void a(Date date)
    {
        mEventDate = date;
    }

    public void a(List list)
    {
        mRegistryRecipientList = list;
    }

    public RegistryId b()
    {
        return mRegistryId;
    }

    public void b(String s)
    {
        mCity = s;
    }

    public void b(Date date)
    {
        mCreatedDate = date;
    }

    public e c()
    {
        return com.google.a.a.e.c(mRegistryAlternateId);
    }

    public void c(String s)
    {
        mState = s;
    }

    public String d()
    {
        return mCity;
    }

    public void d(String s)
    {
        mCountry = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public String e()
    {
        return mState;
    }

    public Date f()
    {
        return mEventDate;
    }

    public c g()
    {
        return mRegistryEventType;
    }

    public List h()
    {
        return k.a(mRegistryRecipientList);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        long l1 = -1L;
        byte byte0 = -1;
        parcel.writeString(mRegistryTitle);
        parcel.writeParcelable(mRegistryId, 0);
        long l;
        if (mRegistryStatus == null)
        {
            i = -1;
        } else
        {
            i = mRegistryStatus.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeParcelable(mRegistryHashedId, 0);
        parcel.writeParcelable(mRegistryAlternateId, 0);
        parcel.writeString(mCity);
        parcel.writeString(mState);
        parcel.writeString(mCountry);
        if (mEventDate != null)
        {
            l = mEventDate.getTime();
        } else
        {
            l = -1L;
        }
        parcel.writeLong(l);
        l = l1;
        if (mCreatedDate != null)
        {
            l = mCreatedDate.getTime();
        }
        parcel.writeLong(l);
        parcel.writeInt(mTotalItemCount);
        if (mRegistryEventType == null)
        {
            i = byte0;
        } else
        {
            i = mRegistryEventType.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeList(mRegistryRecipientList);
    }

}
