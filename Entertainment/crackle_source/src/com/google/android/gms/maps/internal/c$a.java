// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.GoogleMapOptionsCreator;
import com.google.android.gms.maps.model.internal.a;

// Referenced classes of package com.google.android.gms.maps.internal:
//            c, IMapFragmentDelegate, IMapViewDelegate, ICameraUpdateFactoryDelegate

public static abstract class a.dU extends Binder
    implements c
{
    private static class a
        implements c
    {

        private IBinder dU;

        public IMapViewDelegate a(b b1, GoogleMapOptions googlemapoptions)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            if (b1 == null) goto _L2; else goto _L1
_L1:
            b1 = b1.asBinder();
_L5:
            parcel.writeStrongBinder(b1);
            if (googlemapoptions == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            googlemapoptions.writeToParcel(parcel, 0);
_L6:
            dU.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            b1 = IMapViewDelegate.a.V(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return b1;
_L2:
            b1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            b1;
            parcel1.recycle();
            parcel.recycle();
            throw b1;
              goto _L5
        }

        public void a(b b1, int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            if (b1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            b1 = b1.asBinder();
_L1:
            parcel.writeStrongBinder(b1);
            parcel.writeInt(i);
            dU.transact(6, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            b1 = null;
              goto _L1
            b1;
            parcel1.recycle();
            parcel.recycle();
            throw b1;
        }

        public IBinder asBinder()
        {
            return dU;
        }

        public void e(b b1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            if (b1 == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            b1 = b1.asBinder();
_L1:
            parcel.writeStrongBinder(b1);
            dU.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            b1 = null;
              goto _L1
            b1;
            parcel1.recycle();
            parcel.recycle();
            throw b1;
        }

        public com.google.android.gms.maps.model.internal.a eA()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            com.google.android.gms.maps.model.internal.a a1;
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            dU.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            a1 = com.google.android.gms.maps.model.internal.a.a.aj(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return a1;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public ICameraUpdateFactoryDelegate ez()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            ICameraUpdateFactoryDelegate icameraupdatefactorydelegate;
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            dU.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            icameraupdatefactorydelegate = ICameraUpdateFactoryDelegate.a.O(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return icameraupdatefactorydelegate;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public IMapFragmentDelegate f(b b1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            if (b1 == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            b1 = b1.asBinder();
_L1:
            parcel.writeStrongBinder(b1);
            dU.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            b1 = IMapFragmentDelegate.a.U(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return b1;
            b1 = null;
              goto _L1
            b1;
            parcel1.recycle();
            parcel.recycle();
            throw b1;
        }

        a(IBinder ibinder)
        {
            dU = ibinder;
        }
    }


    public static c Q(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
        if (iinterface != null && (iinterface instanceof c))
        {
            return (c)iinterface;
        } else
        {
            return new a(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        throws RemoteException
    {
        IMapFragmentDelegate imapfragmentdelegate = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.maps.internal.ICreator");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            e(com.google.android.gms.dynamic.E(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            imapfragmentdelegate = f(com.google.android.gms.dynamic.E(parcel.readStrongBinder()));
            parcel1.writeNoException();
            parcel = obj;
            if (imapfragmentdelegate != null)
            {
                parcel = imapfragmentdelegate.asBinder();
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            Object obj1 = com.google.android.gms.dynamic.E(parcel.readStrongBinder());
            if (parcel.readInt() != 0)
            {
                parcel = GoogleMapOptions.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            obj1 = a(((b) (obj1)), parcel);
            parcel1.writeNoException();
            parcel = imapfragmentdelegate;
            if (obj1 != null)
            {
                parcel = ((IMapViewDelegate) (obj1)).asBinder();
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            ICameraUpdateFactoryDelegate icameraupdatefactorydelegate = ez();
            parcel1.writeNoException();
            parcel = obj2;
            if (icameraupdatefactorydelegate != null)
            {
                parcel = icameraupdatefactorydelegate.asBinder();
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            com.google.android.gms.maps.model.internal.a a1 = eA();
            parcel1.writeNoException();
            parcel = obj3;
            if (a1 != null)
            {
                parcel = a1.asBinder();
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            a(com.google.android.gms.dynamic.E(parcel.readStrongBinder()), parcel.readInt());
            parcel1.writeNoException();
            return true;
        }
    }
}
