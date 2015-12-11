// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;

public abstract class afv extends Binder
    implements afu
{

    public static afu a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
        if (iinterface != null && (iinterface instanceof afu))
        {
            return (afu)iinterface;
        } else
        {
            return new afw(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        Object obj1 = null;
        Object obj2 = null;
        Object obj = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            parcel1 = obj;
            if (parcel.readInt() != 0)
            {
                parcel1 = DataHolder.CREATOR.a(parcel);
            }
            a(parcel1);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            parcel1 = obj1;
            if (parcel.readInt() != 0)
            {
                parcel1 = DataHolder.CREATOR.a(parcel);
            }
            b(parcel1);
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            parcel1 = obj2;
            break;
        }
        if (parcel.readInt() != 0)
        {
            parcel1 = DataHolder.CREATOR.a(parcel);
        }
        c(parcel1);
        return true;
    }
}
