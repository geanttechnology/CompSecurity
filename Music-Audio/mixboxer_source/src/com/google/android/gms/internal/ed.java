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

public interface ed
    extends IInterface
{
    public static abstract class a extends Binder
        implements ed
    {

        public static ed z(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            if (iinterface != null && (iinterface instanceof ed))
            {
                return (ed)iinterface;
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
                parcel1.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
                parcel = a(com.google.android.gms.dynamic.b.a.E(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                parcel1.writeNoException();
                break;
            }
            if (parcel != null)
            {
                parcel = parcel.asBinder();
            } else
            {
                parcel = null;
            }
            parcel1.writeStrongBinder(parcel);
            return true;
        }
    }

    private static class a.a
        implements ed
    {

        private IBinder dU;

        public b a(b b1, int i, int j)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
            if (b1 == null)
            {
                break MISSING_BLOCK_LABEL_88;
            }
            b1 = b1.asBinder();
_L1:
            parcel.writeStrongBinder(b1);
            parcel.writeInt(i);
            parcel.writeInt(j);
            dU.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            b1 = com.google.android.gms.dynamic.b.a.E(parcel1.readStrongBinder());
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
            return dU;
        }

        a.a(IBinder ibinder)
        {
            dU = ibinder;
        }
    }


    public abstract b a(b b, int i, int j)
        throws RemoteException;
}
