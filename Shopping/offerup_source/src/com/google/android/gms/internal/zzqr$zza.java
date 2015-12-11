// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.internal:
//            zzqr

public abstract class zza extends Binder
    implements zzqr
{

    public static zzqr zzdK(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.search.internal.ISearchAuthService");
        class zza
            implements zzqr
        {

            private IBinder zznJ;

            public IBinder asBinder()
            {
                return zznJ;
            }

            public void zza(zzqq zzqq1, String s, String s1)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.search.internal.ISearchAuthService");
                if (zzqq1 == null)
                {
                    break MISSING_BLOCK_LABEL_78;
                }
                zzqq1 = zzqq1.asBinder();
_L1:
                parcel.writeStrongBinder(zzqq1);
                parcel.writeString(s);
                parcel.writeString(s1);
                zznJ.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                zzqq1 = null;
                  goto _L1
                zzqq1;
                parcel1.recycle();
                parcel.recycle();
                throw zzqq1;
            }

            public void zzb(zzqq zzqq1, String s, String s1)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.search.internal.ISearchAuthService");
                if (zzqq1 == null)
                {
                    break MISSING_BLOCK_LABEL_78;
                }
                zzqq1 = zzqq1.asBinder();
_L1:
                parcel.writeStrongBinder(zzqq1);
                parcel.writeString(s);
                parcel.writeString(s1);
                zznJ.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                zzqq1 = null;
                  goto _L1
                zzqq1;
                parcel1.recycle();
                parcel.recycle();
                throw zzqq1;
            }

            zza(IBinder ibinder)
            {
                zznJ = ibinder;
            }
        }

        if (iinterface != null && (iinterface instanceof zzqr))
        {
            return (zzqr)iinterface;
        } else
        {
            return new zza(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
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
            zza(zzdJ(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.search.internal.ISearchAuthService");
            zzb(zzdJ(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            return true;
        }
    }
}
