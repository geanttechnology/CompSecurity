// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzh

class zznJ
    implements zzh
{

    private IBinder zznJ;

    public IBinder asBinder()
    {
        return zznJ;
    }

    public void zza(int i, PendingIntent pendingintent)
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
        parcel.writeInt(i);
        if (pendingintent == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        parcel.writeInt(1);
        pendingintent.writeToParcel(parcel, 0);
_L1:
        zznJ.transact(3, parcel, null, 1);
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        pendingintent;
        parcel.recycle();
        throw pendingintent;
    }

    public void zza(int i, String as[])
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
        parcel.writeInt(i);
        parcel.writeStringArray(as);
        zznJ.transact(1, parcel, null, 1);
        parcel.recycle();
        return;
        as;
        parcel.recycle();
        throw as;
    }

    public void zzb(int i, String as[])
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
        parcel.writeInt(i);
        parcel.writeStringArray(as);
        zznJ.transact(2, parcel, null, 1);
        parcel.recycle();
        return;
        as;
        parcel.recycle();
        throw as;
    }

    (IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
