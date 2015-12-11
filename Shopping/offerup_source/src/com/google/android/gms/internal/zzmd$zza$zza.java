// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.internal:
//            zzmd, zzmc

class zznJ
    implements zzmd
{

    private IBinder zznJ;

    public IBinder asBinder()
    {
        return zznJ;
    }

    public void zza(zzmc zzmc1)
    {
        IBinder ibinder;
        Parcel parcel;
        ibinder = null;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonService");
        if (zzmc1 == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        ibinder = zzmc1.asBinder();
        parcel.writeStrongBinder(ibinder);
        zznJ.transact(1, parcel, null, 1);
        parcel.recycle();
        return;
        zzmc1;
        parcel.recycle();
        throw zzmc1;
    }

    (IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
