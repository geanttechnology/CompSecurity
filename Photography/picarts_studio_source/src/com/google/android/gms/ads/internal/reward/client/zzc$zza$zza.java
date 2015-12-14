// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.reward.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzem;

// Referenced classes of package com.google.android.gms.ads.internal.reward.client:
//            zzc

class zznJ
    implements zzc
{

    private IBinder zznJ;

    public IBinder asBinder()
    {
        return zznJ;
    }

    public IBinder zza(zzd zzd1, zzem zzem1, int i)
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
        if (zzd1 == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        zzd1 = zzd1.asBinder();
_L1:
        parcel.writeStrongBinder(zzd1);
        zzd1 = obj;
        if (zzem1 == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        zzd1 = zzem1.asBinder();
        parcel.writeStrongBinder(zzd1);
        parcel.writeInt(i);
        zznJ.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        zzd1 = parcel1.readStrongBinder();
        parcel1.recycle();
        parcel.recycle();
        return zzd1;
        zzd1 = null;
          goto _L1
        zzd1;
        parcel1.recycle();
        parcel.recycle();
        throw zzd1;
    }

    (IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
