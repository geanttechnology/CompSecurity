// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.identity.intents.UserAddressRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zzpa, zzoz

class zznJ
    implements zzpa
{

    private IBinder zznJ;

    public IBinder asBinder()
    {
        return zznJ;
    }

    public void zza(zzoz zzoz1, UserAddressRequest useraddressrequest, Bundle bundle)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.identity.intents.internal.IAddressService");
        if (zzoz1 == null) goto _L2; else goto _L1
_L1:
        zzoz1 = zzoz1.asBinder();
_L5:
        parcel.writeStrongBinder(zzoz1);
        if (useraddressrequest == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        useraddressrequest.writeToParcel(parcel, 0);
_L6:
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L7:
        zznJ.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        zzoz1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        zzoz1;
        parcel1.recycle();
        parcel.recycle();
        throw zzoz1;
        parcel.writeInt(0);
          goto _L7
    }

    ddressRequest(IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
