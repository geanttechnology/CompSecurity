// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.internal:
//            zzcz, zzcu

class zznJ
    implements zzcz
{

    private IBinder zznJ;

    public IBinder asBinder()
    {
        return zznJ;
    }

    public void zza(zzcu zzcu1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
        if (zzcu1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        zzcu1 = zzcu1.asBinder();
_L1:
        parcel.writeStrongBinder(zzcu1);
        zznJ.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzcu1 = null;
          goto _L1
        zzcu1;
        parcel1.recycle();
        parcel.recycle();
        throw zzcu1;
    }

    (IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
