// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            zzph, zzpg

private static class zznI
    implements zzph
{

    private IBinder zznI;

    public IBinder asBinder()
    {
        return zznI;
    }

    public void zza(zzpg zzpg1, Uri uri, Bundle bundle, boolean flag)
        throws RemoteException
    {
        IBinder ibinder;
        Parcel parcel;
        int i;
        ibinder = null;
        i = 1;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.panorama.internal.IPanoramaService");
        if (zzpg1 == null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        ibinder = zzpg1.asBinder();
        parcel.writeStrongBinder(ibinder);
        if (uri == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        uri.writeToParcel(parcel, 0);
_L5:
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
        break MISSING_BLOCK_LABEL_128;
_L6:
        parcel.writeInt(i);
        zznI.transact(1, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L5
        zzpg1;
        parcel.recycle();
        throw zzpg1;
_L4:
        parcel.writeInt(0);
        while (!flag) 
        {
            i = 0;
            break;
        }
          goto _L6
    }

    (IBinder ibinder)
    {
        zznI = ibinder;
    }
}
