// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.ir;

import amazon.communication.identity.IRServiceEndpoint;
import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.amazon.communication.ir:
//            IRServiceEndpointImpl

public class ParcelableIRServiceEndpoint
    implements IRServiceEndpoint, Parcelable
{
    static class Creator
        implements android.os.Parcelable.Creator
    {

        public ParcelableIRServiceEndpoint createFromParcel(Parcel parcel)
        {
            Integer integer = null;
            String s = parcel.readString();
            String s1 = parcel.readString();
            String s2 = parcel.readString();
            amazon.communication.identity.IRServiceEndpoint.DirectConnection directconnection = amazon.communication.identity.IRServiceEndpoint.DirectConnection.parse(parcel.readString());
            amazon.communication.identity.IRServiceEndpoint.DataCompression datacompression = amazon.communication.identity.IRServiceEndpoint.DataCompression.parse(parcel.readString());
            amazon.communication.identity.IRServiceEndpoint.ClearTextConnection cleartextconnection = amazon.communication.identity.IRServiceEndpoint.ClearTextConnection.parse(parcel.readString());
            int i = parcel.readInt();
            int j = parcel.readInt();
            int k = parcel.readInt();
            String s3 = parcel.readString();
            if (j == -1)
            {
                parcel = null;
            } else
            {
                parcel = Integer.valueOf(j);
            }
            if (k != -1)
            {
                integer = Integer.valueOf(k);
            }
            return new ParcelableIRServiceEndpoint(new IRServiceEndpointImpl(s, s1, s3, s2, directconnection, datacompression, cleartextconnection, i, parcel, integer));
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ParcelableIRServiceEndpoint[] newArray(int i)
        {
            return new ParcelableIRServiceEndpoint[i];
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
    private final IRServiceEndpoint mEndpoint;

    public ParcelableIRServiceEndpoint(IRServiceEndpoint irserviceendpoint)
    {
        mEndpoint = irserviceendpoint;
    }

    public int describeContents()
    {
        return 0;
    }

    public amazon.communication.identity.IRServiceEndpoint.ClearTextConnection getClearTextConnection()
    {
        return mEndpoint.getClearTextConnection();
    }

    public amazon.communication.identity.IRServiceEndpoint.DataCompression getDataCompression()
    {
        return mEndpoint.getDataCompression();
    }

    public amazon.communication.identity.IRServiceEndpoint.DirectConnection getDirectConnection()
    {
        return mEndpoint.getDirectConnection();
    }

    public String getDirectorServiceName()
    {
        return mEndpoint.getDirectorServiceName();
    }

    public String getDomain()
    {
        return mEndpoint.getDomain();
    }

    public String getHostname()
    {
        return mEndpoint.getHostname();
    }

    public Integer getPort()
    {
        return mEndpoint.getPort();
    }

    public String getRealm()
    {
        return mEndpoint.getRealm();
    }

    public Integer getSecurePort()
    {
        return mEndpoint.getSecurePort();
    }

    public int getTimeout()
    {
        return mEndpoint.getTimeout();
    }

    public String toString()
    {
        return mEndpoint.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        byte byte0 = -1;
        parcel.writeString(mEndpoint.getHostname());
        parcel.writeString(mEndpoint.getDomain());
        parcel.writeString(mEndpoint.getDirectorServiceName());
        parcel.writeString(mEndpoint.getDirectConnection().toString());
        parcel.writeString(mEndpoint.getDataCompression().toString());
        parcel.writeString(mEndpoint.getClearTextConnection().toString());
        parcel.writeInt(mEndpoint.getTimeout());
        if (mEndpoint.getPort() == null)
        {
            i = -1;
        } else
        {
            i = mEndpoint.getPort().intValue();
        }
        parcel.writeInt(i);
        if (mEndpoint.getSecurePort() == null)
        {
            i = byte0;
        } else
        {
            i = mEndpoint.getSecurePort().intValue();
        }
        parcel.writeInt(i);
        parcel.writeString(mEndpoint.getRealm());
    }

}
