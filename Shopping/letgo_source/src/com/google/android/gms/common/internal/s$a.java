// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.common.internal:
//            s

public static abstract class attachInterface extends Binder
    implements s
{
    private static class a
        implements s
    {

        private IBinder a;

        public void a(int i, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsCallbacks");
            parcel.writeInt(i);
            if (bundle == null)
            {
                break MISSING_BLOCK_LABEL_65;
            }
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L1:
            a.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            bundle;
            parcel1.recycle();
            parcel.recycle();
            throw bundle;
        }

        public void a(int i, IBinder ibinder, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsCallbacks");
            parcel.writeInt(i);
            parcel.writeStrongBinder(ibinder);
            if (bundle == null)
            {
                break MISSING_BLOCK_LABEL_78;
            }
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L1:
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            ibinder;
            parcel1.recycle();
            parcel.recycle();
            throw ibinder;
        }

        public IBinder asBinder()
        {
            return a;
        }

        a(IBinder ibinder)
        {
            a = ibinder;
        }
    }


    public static s a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
        if (iinterface != null && (iinterface instanceof s))
        {
            return (s)iinterface;
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
        IBinder ibinder = null;
        Object obj = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.common.internal.IGmsCallbacks");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
            i = parcel.readInt();
            ibinder = parcel.readStrongBinder();
            if (parcel.readInt() != 0)
            {
                obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            a(i, ibinder, ((Bundle) (obj)));
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
            i = parcel.readInt();
            obj = ibinder;
            break;
        }
        if (parcel.readInt() != 0)
        {
            obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
        }
        a(i, ((Bundle) (obj)));
        parcel1.writeNoException();
        return true;
    }

    public a.a()
    {
        attachInterface(this, "com.google.android.gms.common.internal.IGmsCallbacks");
    }
}
