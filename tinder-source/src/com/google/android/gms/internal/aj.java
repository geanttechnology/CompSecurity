// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.a;

public interface aj
    extends IInterface
{
    public static abstract class a extends Binder
        implements aj
    {

        public static aj a(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
            if (iinterface != null && (iinterface instanceof aj))
            {
                return (aj)iinterface;
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
                parcel = a(com.google.android.gms.dynamic.a.a.a(parcel.readStrongBinder()), com.google.android.gms.dynamic.a.a.a(parcel.readStrongBinder()), com.google.android.gms.dynamic.a.a.a(parcel.readStrongBinder()), parcel.readInt());
                parcel1.writeNoException();
                parcel1.writeStrongBinder(parcel);
                return true;
            }
        }
    }

    private static final class a.a
        implements aj
    {

        private IBinder a;

        public final IBinder a(com.google.android.gms.dynamic.a a1, com.google.android.gms.dynamic.a a2, com.google.android.gms.dynamic.a a3, int i)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            Parcel parcel1;
            obj = null;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
            if (a1 == null) goto _L2; else goto _L1
_L1:
            a1 = a1.asBinder();
_L5:
            parcel.writeStrongBinder(a1);
            if (a2 == null) goto _L4; else goto _L3
_L3:
            a1 = a2.asBinder();
_L6:
            parcel.writeStrongBinder(a1);
            a1 = obj;
            if (a3 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            a1 = a3.asBinder();
            parcel.writeStrongBinder(a1);
            parcel.writeInt(i);
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            a1 = parcel1.readStrongBinder();
            parcel1.recycle();
            parcel.recycle();
            return a1;
_L2:
            a1 = null;
              goto _L5
_L4:
            a1 = null;
              goto _L6
            a1;
            parcel1.recycle();
            parcel.recycle();
            throw a1;
              goto _L5
        }

        public final IBinder asBinder()
        {
            return a;
        }

        a.a(IBinder ibinder)
        {
            a = ibinder;
        }
    }


    public abstract IBinder a(com.google.android.gms.dynamic.a a1, com.google.android.gms.dynamic.a a2, com.google.android.gms.dynamic.a a3, int i)
        throws RemoteException;
}
