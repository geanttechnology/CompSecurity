// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.consent.GetConsentIntentRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zzkg

class zznJ
    implements zzkg
{

    private IBinder zznJ;

    public IBinder asBinder()
    {
        return zznJ;
    }

    public Intent zza(GetConsentIntentRequest getconsentintentrequest)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.auth.api.consent.internal.IConsentService");
        if (getconsentintentrequest == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        getconsentintentrequest.writeToParcel(parcel, 0);
_L3:
        zznJ.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        getconsentintentrequest = (Intent)Intent.CREATOR.createFromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return getconsentintentrequest;
_L2:
        parcel.writeInt(0);
          goto _L3
        getconsentintentrequest;
        parcel1.recycle();
        parcel.recycle();
        throw getconsentintentrequest;
        getconsentintentrequest = null;
          goto _L4
    }

    nsentIntentRequest(IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
