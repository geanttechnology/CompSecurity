// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;

// Referenced classes of package com.google.android.gms.internal:
//            zzcp

class zznJ
    implements zzcp
{

    private IBinder zznJ;

    public IBinder asBinder()
    {
        return zznJ;
    }

    public IBinder zza(zzd zzd1, zzd zzd2, zzd zzd3, int i)
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
        if (zzd1 == null) goto _L2; else goto _L1
_L1:
        zzd1 = zzd1.asBinder();
_L5:
        parcel.writeStrongBinder(zzd1);
        if (zzd2 == null) goto _L4; else goto _L3
_L3:
        zzd1 = zzd2.asBinder();
_L6:
        parcel.writeStrongBinder(zzd1);
        zzd1 = obj;
        if (zzd3 == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        zzd1 = zzd3.asBinder();
        parcel.writeStrongBinder(zzd1);
        parcel.writeInt(i);
        zznJ.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        zzd1 = parcel1.readStrongBinder();
        parcel1.recycle();
        parcel.recycle();
        return zzd1;
_L2:
        zzd1 = null;
          goto _L5
_L4:
        zzd1 = null;
          goto _L6
        zzd1;
        parcel1.recycle();
        parcel.recycle();
        throw zzd1;
          goto _L5
    }

    (IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
