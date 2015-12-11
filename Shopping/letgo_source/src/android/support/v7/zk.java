// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package android.support.v7:
//            aab

public interface zk
    extends IInterface
{
    public static abstract class a extends Binder
        implements zk
    {

        public static zk a(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            if (iinterface != null && (iinterface instanceof zk))
            {
                return (zk)iinterface;
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
                parcel1.writeString("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                a(aab.a.a(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                b(aab.a.a(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                c(aab.a.a(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;
            }
        }
    }

    private static class a.a
        implements zk
    {

        private IBinder a;

        public void a(aab aab1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            if (aab1 == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            aab1 = aab1.asBinder();
_L1:
            parcel.writeStrongBinder(aab1);
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            aab1 = null;
              goto _L1
            aab1;
            parcel1.recycle();
            parcel.recycle();
            throw aab1;
        }

        public IBinder asBinder()
        {
            return a;
        }

        public void b(aab aab1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            if (aab1 == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            aab1 = aab1.asBinder();
_L1:
            parcel.writeStrongBinder(aab1);
            a.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            aab1 = null;
              goto _L1
            aab1;
            parcel1.recycle();
            parcel.recycle();
            throw aab1;
        }

        public void c(aab aab1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            if (aab1 == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            aab1 = aab1.asBinder();
_L1:
            parcel.writeStrongBinder(aab1);
            a.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            aab1 = null;
              goto _L1
            aab1;
            parcel1.recycle();
            parcel.recycle();
            throw aab1;
        }

        a.a(IBinder ibinder)
        {
            a = ibinder;
        }
    }


    public abstract void a(aab aab)
        throws RemoteException;

    public abstract void b(aab aab)
        throws RemoteException;

    public abstract void c(aab aab)
        throws RemoteException;
}
