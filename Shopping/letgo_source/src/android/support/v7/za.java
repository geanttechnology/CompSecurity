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
//            aab, lk

public interface za
    extends IInterface
{
    public static abstract class a extends Binder
        implements za
    {

        public static za a(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            if (iinterface != null && (iinterface instanceof za))
            {
                return (za)iinterface;
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
            lk lk2 = null;
            lk lk1 = null;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                lk2 = a(aab.a.a(parcel.readStrongBinder()));
                parcel1.writeNoException();
                parcel = lk1;
                if (lk2 != null)
                {
                    parcel = lk2.asBinder();
                }
                parcel1.writeStrongBinder(parcel);
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                lk1 = b(aab.a.a(parcel.readStrongBinder()));
                parcel1.writeNoException();
                parcel = lk2;
                break;
            }
            if (lk1 != null)
            {
                parcel = lk1.asBinder();
            }
            parcel1.writeStrongBinder(parcel);
            return true;
        }

        public a()
        {
            attachInterface(this, "com.google.android.gms.maps.internal.IInfoWindowAdapter");
        }
    }

    private static class a.a
        implements za
    {

        private IBinder a;

        public lk a(aab aab1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            if (aab1 == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            aab1 = aab1.asBinder();
_L1:
            parcel.writeStrongBinder(aab1);
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            aab1 = lk.a.a(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return aab1;
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

        public lk b(aab aab1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            if (aab1 == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            aab1 = aab1.asBinder();
_L1:
            parcel.writeStrongBinder(aab1);
            a.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            aab1 = lk.a.a(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return aab1;
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


    public abstract lk a(aab aab)
        throws RemoteException;

    public abstract lk b(aab aab)
        throws RemoteException;
}
