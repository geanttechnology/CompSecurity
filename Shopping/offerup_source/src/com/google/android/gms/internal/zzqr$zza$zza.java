// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.internal:
//            zzqr, zzqq

class zznJ
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

    (IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
