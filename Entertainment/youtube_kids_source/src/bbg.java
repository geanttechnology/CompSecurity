// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public abstract class bbg extends Binder
    implements bbf
{

    public static bbf a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.mdm.internal.INetworkQualityService");
        if (iinterface != null && (iinterface instanceof bbf))
        {
            return (bbf)iinterface;
        } else
        {
            return new bbh(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        String s;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.mdm.internal.INetworkQualityService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.mdm.internal.INetworkQualityService");
            s = parcel.readString();
            break;
        }
        if (parcel.readInt() != 0)
        {
            parcel1 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
        } else
        {
            parcel1 = null;
        }
        if (parcel.readInt() != 0)
        {
            parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
        } else
        {
            parcel = null;
        }
        a(s, parcel1, parcel);
        return true;
    }
}
