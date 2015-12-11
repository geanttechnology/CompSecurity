// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class ala extends Binder
    implements akz
{

    public ala()
    {
        attachInterface(this, "com.google.android.gms.maps.internal.IInfoWindowAdapter");
    }

    public static akz a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
        if (iinterface != null && (iinterface instanceof akz))
        {
            return (akz)iinterface;
        } else
        {
            return new alb(ibinder);
        }
    }

    public IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        ry ry2 = null;
        ry ry1 = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            ry2 = a(aoq.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            parcel = ry1;
            if (ry2 != null)
            {
                parcel = ry2.asBinder();
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            ry1 = b(aoq.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            parcel = ry2;
            break;
        }
        if (ry1 != null)
        {
            parcel = ry1.asBinder();
        }
        parcel1.writeStrongBinder(parcel);
        return true;
    }
}
