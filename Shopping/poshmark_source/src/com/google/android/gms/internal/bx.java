// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;

public interface bx
    extends IInterface
{
    public static abstract class a extends Binder
        implements bx
    {

        public static bx n(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
            if (iinterface != null && (iinterface instanceof bx))
            {
                return (bx)iinterface;
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
                parcel1.writeString("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
                parcel = a(com.google.android.gms.dynamic.b.a.G(parcel.readStrongBinder()));
                parcel1.writeNoException();
                parcel1.writeStrongBinder(parcel);
                return true;
            }
        }
    }

    private static class a.a
        implements bx
    {

        private IBinder ky;

        public IBinder a(b b1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
            if (b1 == null)
            {
                break MISSING_BLOCK_LABEL_63;
            }
            b1 = b1.asBinder();
_L1:
            parcel.writeStrongBinder(b1);
            ky.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            b1 = parcel1.readStrongBinder();
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

        public IBinder asBinder()
        {
            return ky;
        }

        a.a(IBinder ibinder)
        {
            ky = ibinder;
        }
    }


    public abstract IBinder a(b b)
        throws RemoteException;
}
