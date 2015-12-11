// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package android.support.v7:
//            oc, lk

public static abstract class a.a extends Binder
    implements oc
{
    private static class a
        implements oc
    {

        private IBinder a;

        public IBinder a(lk lk1, lk lk2, lk lk3, int i)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            Parcel parcel1;
            obj = null;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
            if (lk1 == null) goto _L2; else goto _L1
_L1:
            lk1 = lk1.asBinder();
_L5:
            parcel.writeStrongBinder(lk1);
            if (lk2 == null) goto _L4; else goto _L3
_L3:
            lk1 = lk2.asBinder();
_L6:
            parcel.writeStrongBinder(lk1);
            lk1 = obj;
            if (lk3 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            lk1 = lk3.asBinder();
            parcel.writeStrongBinder(lk1);
            parcel.writeInt(i);
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            lk1 = parcel1.readStrongBinder();
            parcel1.recycle();
            parcel.recycle();
            return lk1;
_L2:
            lk1 = null;
              goto _L5
_L4:
            lk1 = null;
              goto _L6
            lk1;
            parcel1.recycle();
            parcel.recycle();
            throw lk1;
              goto _L5
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


    public static oc a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
        if (iinterface != null && (iinterface instanceof oc))
        {
            return (oc)iinterface;
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
            parcel1.writeString("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
            parcel = a(a(parcel.readStrongBinder()), a(parcel.readStrongBinder()), a(parcel.readStrongBinder()), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeStrongBinder(parcel);
            return true;
        }
    }
}
