// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.nearby.messages.internal:
//            MessageWrapper, zzf

public interface zzb
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zzb
    {

        public static zzb zzdh(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            if (iinterface != null && (iinterface instanceof zzb))
            {
                return (zzb)iinterface;
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
            Object obj = null;
            MessageWrapper messagewrapper = null;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.nearby.messages.internal.IMessageListener");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
                if (parcel.readInt() != 0)
                {
                    messagewrapper = MessageWrapper.CREATOR.zzfC(parcel);
                }
                zza(messagewrapper);
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
                messagewrapper = obj;
                break;
            }
            if (parcel.readInt() != 0)
            {
                messagewrapper = MessageWrapper.CREATOR.zzfC(parcel);
            }
            zzb(messagewrapper);
            parcel1.writeNoException();
            return true;
        }

        public zza()
        {
            attachInterface(this, "com.google.android.gms.nearby.messages.internal.IMessageListener");
        }
    }

    private static class zza.zza
        implements zzb
    {

        private IBinder zznI;

        public IBinder asBinder()
        {
            return zznI;
        }

        public void zza(MessageWrapper messagewrapper)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.IMessageListener");
            if (messagewrapper == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            messagewrapper.writeToParcel(parcel, 0);
_L1:
            zznI.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            messagewrapper;
            parcel1.recycle();
            parcel.recycle();
            throw messagewrapper;
        }

        public void zzb(MessageWrapper messagewrapper)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.IMessageListener");
            if (messagewrapper == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            messagewrapper.writeToParcel(parcel, 0);
_L1:
            zznI.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            messagewrapper;
            parcel1.recycle();
            parcel.recycle();
            throw messagewrapper;
        }

        zza.zza(IBinder ibinder)
        {
            zznI = ibinder;
        }
    }


    public abstract void zza(MessageWrapper messagewrapper)
        throws RemoteException;

    public abstract void zzb(MessageWrapper messagewrapper)
        throws RemoteException;
}
