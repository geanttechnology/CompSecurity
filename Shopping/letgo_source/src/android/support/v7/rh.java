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
//            lk

public interface rh
    extends IInterface
{
    public static abstract class a extends Binder
        implements rh
    {

        public static rh a(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
            if (iinterface != null && (iinterface instanceof rh))
            {
                return (rh)iinterface;
            } else
            {
                return new a(ibinder);
            }
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
                parcel = a(lk.a.a(parcel.readStrongBinder()));
                parcel1.writeNoException();
                parcel1.writeStrongBinder(parcel);
                return true;
            }
        }
    }

    private static class a.a
        implements rh
    {

        private IBinder a;

        public IBinder a(lk lk1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
            if (lk1 == null)
            {
                break MISSING_BLOCK_LABEL_63;
            }
            lk1 = lk1.asBinder();
_L1:
            parcel.writeStrongBinder(lk1);
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            lk1 = parcel1.readStrongBinder();
            parcel1.recycle();
            parcel.recycle();
            return lk1;
            lk1 = null;
              goto _L1
            lk1;
            parcel1.recycle();
            parcel.recycle();
            throw lk1;
        }

        public IBinder asBinder()
        {
            return a;
        }

        a.a(IBinder ibinder)
        {
            a = ibinder;
        }
    }


    public abstract IBinder a(lk lk)
        throws RemoteException;
}
