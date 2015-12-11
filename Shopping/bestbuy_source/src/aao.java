// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.fj;

public abstract class aao extends Binder
    implements aan
{

    public aao()
    {
        attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    public static aan a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
        if (iinterface != null && (iinterface instanceof aan))
        {
            return (aan)iinterface;
        } else
        {
            return new aap(ibinder);
        }
    }

    public IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            break;
        }
        if (parcel.readInt() != 0)
        {
            parcel = fh.CREATOR.a(parcel);
        } else
        {
            parcel = null;
        }
        parcel = a(parcel);
        parcel1.writeNoException();
        if (parcel != null)
        {
            parcel1.writeInt(1);
            parcel.writeToParcel(parcel1, 1);
        } else
        {
            parcel1.writeInt(0);
        }
        return true;
    }
}
