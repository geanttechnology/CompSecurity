// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class alm extends Binder
    implements all
{

    public alm()
    {
        attachInterface(this, "com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
    }

    public static all a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
        if (iinterface != null && (iinterface instanceof all))
        {
            return (all)iinterface;
        } else
        {
            return new aln(ibinder);
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
            parcel1.writeString("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
            a(aoq.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;
        }
    }
}
