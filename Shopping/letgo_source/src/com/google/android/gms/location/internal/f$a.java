// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.location.internal:
//            f

public static abstract class attachInterface extends Binder
    implements f
{
    private static class a
        implements f
    {

        private IBinder a;

        public void a(int i, PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
            parcel.writeInt(i);
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_65;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L1:
            a.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            pendingintent;
            parcel1.recycle();
            parcel.recycle();
            throw pendingintent;
        }

        public void a(int i, String as[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
            parcel.writeInt(i);
            parcel.writeStringArray(as);
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            as;
            parcel1.recycle();
            parcel.recycle();
            throw as;
        }

        public IBinder asBinder()
        {
            return a;
        }

        public void b(int i, String as[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
            parcel.writeInt(i);
            parcel.writeStringArray(as);
            a.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            as;
            parcel1.recycle();
            parcel.recycle();
            throw as;
        }

        a(IBinder ibinder)
        {
            a = ibinder;
        }
    }


    public static f a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
        if (iinterface != null && (iinterface instanceof f))
        {
            return (f)iinterface;
        } else
        {
            return new a(ibinder);
        }
    }

    public IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        throws RemoteException
    {
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.location.internal.IGeofencerCallbacks");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
            a(parcel.readInt(), parcel.createStringArray());
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
            b(parcel.readInt(), parcel.createStringArray());
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
            i = parcel.readInt();
            break;
        }
        if (parcel.readInt() != 0)
        {
            parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
        } else
        {
            parcel = null;
        }
        a(i, parcel);
        parcel1.writeNoException();
        return true;
    }

    public a.a()
    {
        attachInterface(this, "com.google.android.gms.location.internal.IGeofencerCallbacks");
    }
}
