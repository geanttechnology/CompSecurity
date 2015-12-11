// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Parcel;
import android.os.Parcelable;

public class PendingRequest
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PendingRequest createFromParcel(Parcel parcel)
        {
            return new PendingRequest(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public PendingRequest[] newArray(int i)
        {
            return new PendingRequest[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final int fetchType;
    public final String id;

    public PendingRequest(Parcel parcel)
    {
        id = parcel.readString();
        fetchType = parcel.readInt();
    }

    public PendingRequest(String s)
    {
        id = s;
        fetchType = 0;
    }

    public PendingRequest(String s, int i)
    {
        id = s;
        fetchType = i;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (PendingRequest)obj;
        if (id == null) goto _L4; else goto _L3
_L3:
        if (id.equals(((PendingRequest) (obj)).id)) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (((PendingRequest) (obj)).id == null)
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public int hashCode()
    {
        if (id != null)
        {
            return id.hashCode();
        } else
        {
            return 0;
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(id);
        parcel.writeInt(fetchType);
    }

}
