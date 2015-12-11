// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.registries.handler;

import android.os.Parcel;
import com.target.mothership.common.registries.RegistryRecipientId;
import com.target.mothership.common.registries.a;
import com.target.mothership.common.registries.d;
import com.target.mothership.model.registries.interfaces.RegistryRecipient;

public class TGTRegistryRecipient
    implements RegistryRecipient
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTRegistryRecipient a(Parcel parcel)
        {
            return new TGTRegistryRecipient(parcel);
        }

        public TGTRegistryRecipient[] a(int i)
        {
            return new TGTRegistryRecipient[i];
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
    private String mFirstName;
    private String mLastName;
    private a mRecipientType;
    private RegistryRecipientId mRegistryRecipientId;
    private d mRegistryRole;

    public TGTRegistryRecipient()
    {
    }

    protected TGTRegistryRecipient(Parcel parcel)
    {
        Object obj1 = null;
        super();
        int i = parcel.readInt();
        Object obj;
        if (i == -1)
        {
            obj = null;
        } else
        {
            obj = d.values()[i];
        }
        mRegistryRole = ((d) (obj));
        i = parcel.readInt();
        if (i == -1)
        {
            obj = obj1;
        } else
        {
            obj = com.target.mothership.common.registries.a.values()[i];
        }
        mRecipientType = ((a) (obj));
        mRegistryRecipientId = (RegistryRecipientId)parcel.readParcelable(com/target/mothership/common/registries/RegistryRecipientId.getClassLoader());
        mFirstName = parcel.readString();
        mLastName = parcel.readString();
    }

    public a a()
    {
        return mRecipientType;
    }

    public void a(RegistryRecipientId registryrecipientid)
    {
        mRegistryRecipientId = registryrecipientid;
    }

    public void a(a a1)
    {
        mRecipientType = a1;
    }

    public void a(d d1)
    {
        mRegistryRole = d1;
    }

    public void a(String s)
    {
        mFirstName = s;
    }

    public String b()
    {
        return mFirstName;
    }

    public void b(String s)
    {
        mLastName = s;
    }

    public String c()
    {
        return mLastName;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        byte byte0 = -1;
        if (mRegistryRole == null)
        {
            i = -1;
        } else
        {
            i = mRegistryRole.ordinal();
        }
        parcel.writeInt(i);
        if (mRecipientType == null)
        {
            i = byte0;
        } else
        {
            i = mRecipientType.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeParcelable(mRegistryRecipientId, 0);
        parcel.writeString(mFirstName);
        parcel.writeString(mLastName);
    }

}
