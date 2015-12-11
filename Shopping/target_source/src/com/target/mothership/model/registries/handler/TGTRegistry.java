// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.registries.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.common.registries.RegistryAlternateId;
import com.target.mothership.common.registries.RegistryHashedId;
import com.target.mothership.common.registries.RegistryId;
import com.target.mothership.common.registries.g;
import com.target.mothership.model.registries.interfaces.Registry;

public class TGTRegistry
    implements Registry
{

    private RegistryAlternateId mRegistryAlternateId;
    private RegistryHashedId mRegistryHashedId;
    private RegistryId mRegistryId;
    private g mRegistryStatus;
    private String mRegistryTitle;

    public TGTRegistry()
    {
    }

    public TGTRegistry(Parcel parcel)
    {
        mRegistryTitle = parcel.readString();
        mRegistryId = (RegistryId)parcel.readParcelable(com/target/mothership/common/registries/RegistryId.getClassLoader());
        int i = parcel.readInt();
        g g1;
        if (i == -1)
        {
            g1 = null;
        } else
        {
            g1 = g.values()[i];
        }
        mRegistryStatus = g1;
        mRegistryHashedId = (RegistryHashedId)parcel.readParcelable(com/target/mothership/common/registries/RegistryHashedId.getClassLoader());
        mRegistryAlternateId = (RegistryAlternateId)parcel.readParcelable(com/target/mothership/common/registries/RegistryAlternateId.getClassLoader());
    }

    public String a()
    {
        return mRegistryTitle;
    }

    public void a(RegistryAlternateId registryalternateid)
    {
        mRegistryAlternateId = registryalternateid;
    }

    public void a(RegistryHashedId registryhashedid)
    {
        mRegistryHashedId = registryhashedid;
    }

    public void a(RegistryId registryid)
    {
        mRegistryId = registryid;
    }

    public void a(g g1)
    {
        mRegistryStatus = g1;
    }

    public void a(String s)
    {
        mRegistryTitle = s;
    }

    public RegistryId b()
    {
        return mRegistryId;
    }

    public e c()
    {
        return e.c(mRegistryAlternateId);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mRegistryTitle);
        parcel.writeParcelable(mRegistryId, 0);
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
    }
}
