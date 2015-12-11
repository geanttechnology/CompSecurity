// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.internal:
//            zzck, zzcj

class zznJ
    implements zzck
{

    private IBinder zznJ;

    public IBinder asBinder()
    {
        return zznJ;
    }

    public void zza(zzcj zzcj1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
        if (zzcj1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        zzcj1 = zzcj1.asBinder();
_L1:
        parcel.writeStrongBinder(zzcj1);
        zznJ.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzcj1 = null;
          goto _L1
        zzcj1;
        parcel1.recycle();
        parcel.recycle();
        throw zzcj1;
    }

    (IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
