// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.registries.handler;

import android.os.Parcel;
import com.target.mothership.common.registries.c;
import com.target.mothership.model.registries.interfaces.RegistrySearchSummary;
import com.target.mothership.util.k;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.target.mothership.model.registries.handler:
//            TGTRegistry, TGTRegistryRecipient

public class TGTRegistrySearchSummary extends TGTRegistry
    implements RegistrySearchSummary
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTRegistrySearchSummary a(Parcel parcel)
        {
            return new TGTRegistrySearchSummary(parcel);
        }

        public TGTRegistrySearchSummary[] a(int i)
        {
            return new TGTRegistrySearchSummary[i];
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
    private String mCreatedBy;
    private String mCreatedFor;
    private Integer mItemQuantity;
    private String mLocationCity;
    private String mLocationCountry;
    private String mLocationState;
    private Date mRegistryCreatedDate;
    private Date mRegistryEventDate;
    private c mRegistryEventType;
    private List mRegistryRecipientList;
    private Date mRegistryUpdatedDate;
    private Date mUpdateTime;

    public TGTRegistrySearchSummary()
    {
    }

    protected TGTRegistrySearchSummary(Parcel parcel)
    {
        Object obj1 = null;
        super(parcel);
        mItemQuantity = (Integer)parcel.readValue(java/lang/Integer.getClassLoader());
        long l = parcel.readLong();
        Object obj;
        int i;
        if (l == -1L)
        {
            obj = null;
        } else
        {
            obj = new Date(l);
        }
        mUpdateTime = ((Date) (obj));
        l = parcel.readLong();
        if (l == -1L)
        {
            obj = null;
        } else
        {
            obj = new Date(l);
        }
        mRegistryCreatedDate = ((Date) (obj));
        l = parcel.readLong();
        if (l == -1L)
        {
            obj = null;
        } else
        {
            obj = new Date(l);
        }
        mRegistryUpdatedDate = ((Date) (obj));
        l = parcel.readLong();
        if (l == -1L)
        {
            obj = null;
        } else
        {
            obj = new Date(l);
        }
        mRegistryEventDate = ((Date) (obj));
        mLocationCity = parcel.readString();
        mLocationState = parcel.readString();
        mLocationCountry = parcel.readString();
        mCreatedBy = parcel.readString();
        mCreatedFor = parcel.readString();
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

    public void a(c c1)
    {
        mRegistryEventType = c1;
    }

    public void a(Integer integer)
    {
        mItemQuantity = integer;
    }

    public void a(Date date)
    {
        mUpdateTime = date;
    }

    public void a(List list)
    {
        mRegistryRecipientList = list;
    }

    public void b(String s)
    {
        mLocationCity = s;
    }

    public void b(Date date)
    {
        mRegistryCreatedDate = date;
    }

    public void c(String s)
    {
        mLocationState = s;
    }

    public void c(Date date)
    {
        mRegistryUpdatedDate = date;
    }

    public Date d()
    {
        return mRegistryEventDate;
    }

    public void d(String s)
    {
        mLocationCountry = s;
    }

    public void d(Date date)
    {
        mRegistryEventDate = date;
    }

    public int describeContents()
    {
        return 0;
    }

    public String e()
    {
        return mLocationCity;
    }

    public void e(String s)
    {
        mCreatedBy = s;
    }

    public String f()
    {
        return mLocationState;
    }

    public void f(String s)
    {
        mCreatedFor = s;
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
        super.writeToParcel(parcel, i);
        parcel.writeValue(mItemQuantity);
        long l;
        if (mUpdateTime != null)
        {
            l = mUpdateTime.getTime();
        } else
        {
            l = -1L;
        }
        parcel.writeLong(l);
        if (mRegistryCreatedDate != null)
        {
            l = mRegistryCreatedDate.getTime();
        } else
        {
            l = -1L;
        }
        parcel.writeLong(l);
        if (mRegistryUpdatedDate != null)
        {
            l = mRegistryUpdatedDate.getTime();
        } else
        {
            l = -1L;
        }
        parcel.writeLong(l);
        l = l1;
        if (mRegistryEventDate != null)
        {
            l = mRegistryEventDate.getTime();
        }
        parcel.writeLong(l);
        parcel.writeString(mLocationCity);
        parcel.writeString(mLocationState);
        parcel.writeString(mLocationCountry);
        parcel.writeString(mCreatedBy);
        parcel.writeString(mCreatedFor);
        if (mRegistryEventType == null)
        {
            i = -1;
        } else
        {
            i = mRegistryEventType.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeList(mRegistryRecipientList);
    }

}
