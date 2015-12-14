// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            zzqa, zzpz

public static abstract class zza.zznI extends Binder
    implements zzqa
{
    private static class zza
        implements zzqa
    {

        private IBinder zznI;

        public IBinder asBinder()
        {
            return zznI;
        }

        public void zza(zzpz zzpz1, String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.search.internal.ISearchAuthService");
            if (zzpz1 == null)
            {
                break MISSING_BLOCK_LABEL_78;
            }
            zzpz1 = zzpz1.asBinder();
_L1:
            parcel.writeStrongBinder(zzpz1);
            parcel.writeString(s);
            parcel.writeString(s1);
            zznI.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzpz1 = null;
              goto _L1
            zzpz1;
            parcel1.recycle();
            parcel.recycle();
            throw zzpz1;
        }

        public void zzb(zzpz zzpz1, String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.search.internal.ISearchAuthService");
            if (zzpz1 == null)
            {
                break MISSING_BLOCK_LABEL_78;
            }
            zzpz1 = zzpz1.asBinder();
_L1:
            parcel.writeStrongBinder(zzpz1);
            parcel.writeString(s);
            parcel.writeString(s1);
            zznI.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzpz1 = null;
              goto _L1
            zzpz1;
            parcel1.recycle();
            parcel.recycle();
            throw zzpz1;
        }

        zza(IBinder ibinder)
        {
            zznI = ibinder;
        }
    }


    public static zzqa zzdE(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.search.internal.ISearchAuthService");
        if (iinterface != null && (iinterface instanceof zzqa))
        {
            return (zzqa)iinterface;
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
            parcel1.writeString("com.google.android.gms.search.internal.ISearchAuthService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.search.internal.ISearchAuthService");
            zza(zzdD(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.search.internal.ISearchAuthService");
            zzb(zzdD(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            return true;
        }
    }
}
