// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            zzjl, zzjk

public static abstract class zza.zznI extends Binder
    implements zzjl
{
    private static class zza
        implements zzjl
    {

        private IBinder zznI;

        public IBinder asBinder()
        {
            return zznI;
        }

        public void zza(zzjk zzjk1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appinvite.internal.IAppInviteService");
            if (zzjk1 == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            zzjk1 = zzjk1.asBinder();
_L1:
            parcel.writeStrongBinder(zzjk1);
            parcel.writeString(s);
            zznI.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzjk1 = null;
              goto _L1
            zzjk1;
            parcel1.recycle();
            parcel.recycle();
            throw zzjk1;
        }

        public void zzb(zzjk zzjk1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appinvite.internal.IAppInviteService");
            if (zzjk1 == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            zzjk1 = zzjk1.asBinder();
_L1:
            parcel.writeStrongBinder(zzjk1);
            parcel.writeString(s);
            zznI.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzjk1 = null;
              goto _L1
            zzjk1;
            parcel1.recycle();
            parcel.recycle();
            throw zzjk1;
        }

        zza(IBinder ibinder)
        {
            zznI = ibinder;
        }
    }


    public static zzjl zzak(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.appinvite.internal.IAppInviteService");
        if (iinterface != null && (iinterface instanceof zzjl))
        {
            return (zzjl)iinterface;
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
            parcel1.writeString("com.google.android.gms.appinvite.internal.IAppInviteService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.appinvite.internal.IAppInviteService");
            zzb(zzaj(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.appinvite.internal.IAppInviteService");
            zza(zzaj(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;
        }
    }
}
