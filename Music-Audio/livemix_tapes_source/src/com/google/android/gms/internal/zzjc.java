// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appdatasearch.zzf;

// Referenced classes of package com.google.android.gms.internal:
//            zzjd

public interface zzjc
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zzjc
    {

        public static zzjc zzaf(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            if (iinterface != null && (iinterface instanceof zzjc))
            {
                return (zzjc)iinterface;
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
                parcel1.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                zza(com.google.android.gms.internal.zzjd.zza.zzag(parcel.readStrongBinder()), parcel.readString(), (UsageInfo[])parcel.createTypedArray(UsageInfo.CREATOR));
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                zza(com.google.android.gms.internal.zzjd.zza.zzag(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                zzb(com.google.android.gms.internal.zzjd.zza.zzag(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                zzjd zzjd = com.google.android.gms.internal.zzjd.zza.zzag(parcel.readStrongBinder());
                boolean flag;
                if (parcel.readInt() != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                zza(zzjd, flag);
                parcel1.writeNoException();
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                com.google.android.gms.appdatasearch.GetRecentContextCall.Request request;
                if (parcel.readInt() != 0)
                {
                    request = com.google.android.gms.appdatasearch.GetRecentContextCall.Request.CREATOR.zzw(parcel);
                } else
                {
                    request = null;
                }
                zza(request, com.google.android.gms.internal.zzjd.zza.zzag(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                zza(com.google.android.gms.internal.zzjd.zza.zzag(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                parcel1.writeNoException();
                return true;
            }
        }
    }

    private static class zza.zza
        implements zzjc
    {

        private IBinder zznI;

        public IBinder asBinder()
        {
            return zznI;
        }

        public void zza(com.google.android.gms.appdatasearch.GetRecentContextCall.Request request, zzjd zzjd1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            if (request == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            request.writeToParcel(parcel, 0);
_L3:
            if (zzjd1 == null)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            request = zzjd1.asBinder();
_L4:
            parcel.writeStrongBinder(request);
            zznI.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            request;
            parcel1.recycle();
            parcel.recycle();
            throw request;
            request = null;
              goto _L4
        }

        public void zza(zzjd zzjd1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            if (zzjd1 == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            zzjd1 = zzjd1.asBinder();
_L1:
            parcel.writeStrongBinder(zzjd1);
            zznI.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzjd1 = null;
              goto _L1
            zzjd1;
            parcel1.recycle();
            parcel.recycle();
            throw zzjd1;
        }

        public void zza(zzjd zzjd1, String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            if (zzjd1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            zzjd1 = zzjd1.asBinder();
_L1:
            parcel.writeStrongBinder(zzjd1);
            parcel.writeString(s);
            parcel.writeString(s1);
            zznI.transact(6, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzjd1 = null;
              goto _L1
            zzjd1;
            parcel1.recycle();
            parcel.recycle();
            throw zzjd1;
        }

        public void zza(zzjd zzjd1, String s, UsageInfo ausageinfo[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            if (zzjd1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            zzjd1 = zzjd1.asBinder();
_L1:
            parcel.writeStrongBinder(zzjd1);
            parcel.writeString(s);
            parcel.writeTypedArray(ausageinfo, 0);
            zznI.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzjd1 = null;
              goto _L1
            zzjd1;
            parcel1.recycle();
            parcel.recycle();
            throw zzjd1;
        }

        public void zza(zzjd zzjd1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            if (zzjd1 == null)
            {
                break MISSING_BLOCK_LABEL_77;
            }
            zzjd1 = zzjd1.asBinder();
_L1:
            parcel.writeStrongBinder(zzjd1);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzjd1 = null;
              goto _L1
            zzjd1;
            parcel1.recycle();
            parcel.recycle();
            throw zzjd1;
        }

        public void zzb(zzjd zzjd1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            if (zzjd1 == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            zzjd1 = zzjd1.asBinder();
_L1:
            parcel.writeStrongBinder(zzjd1);
            zznI.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzjd1 = null;
              goto _L1
            zzjd1;
            parcel1.recycle();
            parcel.recycle();
            throw zzjd1;
        }

        zza.zza(IBinder ibinder)
        {
            zznI = ibinder;
        }
    }


    public abstract void zza(com.google.android.gms.appdatasearch.GetRecentContextCall.Request request, zzjd zzjd)
        throws RemoteException;

    public abstract void zza(zzjd zzjd)
        throws RemoteException;

    public abstract void zza(zzjd zzjd, String s, String s1)
        throws RemoteException;

    public abstract void zza(zzjd zzjd, String s, UsageInfo ausageinfo[])
        throws RemoteException;

    public abstract void zza(zzjd zzjd, boolean flag)
        throws RemoteException;

    public abstract void zzb(zzjd zzjd)
        throws RemoteException;
}
