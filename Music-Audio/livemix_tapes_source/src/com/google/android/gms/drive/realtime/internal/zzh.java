// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzh
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zzh
    {

        public static zzh zzbb(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
            if (iinterface != null && (iinterface instanceof zzh))
            {
                return (zzh)iinterface;
            } else
            {
                return new zza(ibinder);
            }
        }

        public IBinder asBinder()
        {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            boolean flag1 = false;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
                break;
            }
            boolean flag;
            if (parcel.readInt() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (parcel.readInt() != 0)
            {
                flag1 = true;
            }
            zzc(flag, flag1);
            parcel1.writeNoException();
            return true;
        }
    }

    private static class zza.zza
        implements zzh
    {

        private IBinder zznI;

        public IBinder asBinder()
        {
            return zznI;
        }

        public void zzc(boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
            int i;
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel.writeInt(i);
            if (flag1)
            {
                i = ((flag2) ? 1 : 0);
            } else
            {
                i = 0;
            }
            parcel.writeInt(i);
            zznI.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        zza.zza(IBinder ibinder)
        {
            zznI = ibinder;
        }
    }


    public abstract void zzc(boolean flag, boolean flag1)
        throws RemoteException;
}
