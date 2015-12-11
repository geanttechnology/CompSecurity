// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.identity.EndpointIdentity;
import amazon.communication.identity.EndpointIdentityFactory;
import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableEndpointIdentity extends EndpointIdentity
    implements Parcelable
{
    static class Creator
        implements android.os.Parcelable.Creator
    {

        public ParcelableEndpointIdentity createFromParcel(Parcel parcel)
        {
            return new ParcelableEndpointIdentity(EndpointIdentityFactory.createFromUrn(parcel.readString()));
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ParcelableEndpointIdentity[] newArray(int i)
        {
            return new ParcelableEndpointIdentity[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        Creator()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    private EndpointIdentity mIdentity;

    public ParcelableEndpointIdentity(EndpointIdentity endpointidentity)
    {
        mIdentity = endpointidentity;
    }

    public int describeContents()
    {
        return 0;
    }

    public String toLogSafeString()
    {
        return mIdentity.toLogSafeString();
    }

    public String toString()
    {
        return mIdentity.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mIdentity.toString());
    }

}
