// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.internal:
//            zzcx, zzcs

class zznJ
    implements zzcx
{

    private IBinder zznJ;

    public IBinder asBinder()
    {
        return zznJ;
    }

    public void zza(zzcs zzcs1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
        if (zzcs1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        zzcs1 = zzcs1.asBinder();
_L1:
        parcel.writeStrongBinder(zzcs1);
        zznJ.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzcs1 = null;
          goto _L1
        zzcs1;
        parcel1.recycle();
        parcel.recycle();
        throw zzcs1;
    }

    (IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
