// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            zzpu

public interface zzpv
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zzpv
    {

        public static zzpv zzdB(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
            if (iinterface != null && (iinterface instanceof zzpv))
            {
                return (zzpv)iinterface;
            } else
            {
                return new zza(ibinder);
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
                parcel1.writeString("com.google.android.gms.safetynet.internal.ISafetyNetService");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
                zza(zzpu.zza.zzdA(parcel.readStrongBinder()), parcel.createByteArray());
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
                zza(zzpu.zza.zzdA(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
                zza(zzpu.zza.zzdA(parcel.readStrongBinder()), parcel.readString(), parcel.createIntArray(), parcel.readInt(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
                zza(zzpu.zza.zzdA(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;
            }
        }
    }

    private static class zza.zza
        implements zzpv
    {

        private IBinder zznI;

        public IBinder asBinder()
        {
            return zznI;
        }

        public void zza(zzpu zzpu1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
            if (zzpu1 == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            zzpu1 = zzpu1.asBinder();
_L1:
            parcel.writeStrongBinder(zzpu1);
            zznI.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzpu1 = null;
              goto _L1
            zzpu1;
            parcel1.recycle();
            parcel.recycle();
            throw zzpu1;
        }

        public void zza(zzpu zzpu1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
            if (zzpu1 == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            zzpu1 = zzpu1.asBinder();
_L1:
            parcel.writeStrongBinder(zzpu1);
            parcel.writeString(s);
            zznI.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzpu1 = null;
              goto _L1
            zzpu1;
            parcel1.recycle();
            parcel.recycle();
            throw zzpu1;
        }

        public void zza(zzpu zzpu1, String s, int ai[], int i, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
            if (zzpu1 == null)
            {
                break MISSING_BLOCK_LABEL_92;
            }
            zzpu1 = zzpu1.asBinder();
_L1:
            parcel.writeStrongBinder(zzpu1);
            parcel.writeString(s);
            parcel.writeIntArray(ai);
            parcel.writeInt(i);
            parcel.writeString(s1);
            zznI.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzpu1 = null;
              goto _L1
            zzpu1;
            parcel1.recycle();
            parcel.recycle();
            throw zzpu1;
        }

        public void zza(zzpu zzpu1, byte abyte0[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
            if (zzpu1 == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            zzpu1 = zzpu1.asBinder();
_L1:
            parcel.writeStrongBinder(zzpu1);
            parcel.writeByteArray(abyte0);
            zznI.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzpu1 = null;
              goto _L1
            zzpu1;
            parcel1.recycle();
            parcel.recycle();
            throw zzpu1;
        }

        zza.zza(IBinder ibinder)
        {
            zznI = ibinder;
        }
    }


    public abstract void zza(zzpu zzpu)
        throws RemoteException;

    public abstract void zza(zzpu zzpu, String s)
        throws RemoteException;

    public abstract void zza(zzpu zzpu, String s, int ai[], int i, String s1)
        throws RemoteException;

    public abstract void zza(zzpu zzpu, byte abyte0[])
        throws RemoteException;
}
