// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.credentials.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.auth.api.credentials.internal:
//            zzg

class zznJ
    implements zzg
{

    private IBinder zznJ;

    public IBinder asBinder()
    {
        return zznJ;
    }

    public void zza(Status status, Credential credential)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
        if (status == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        status.writeToParcel(parcel, 0);
_L3:
        if (credential == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        parcel.writeInt(1);
        credential.writeToParcel(parcel, 0);
_L4:
        zznJ.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        status;
        parcel1.recycle();
        parcel.recycle();
        throw status;
        parcel.writeInt(0);
          goto _L4
    }

    public void zzg(Status status)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
        if (status == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        parcel.writeInt(1);
        status.writeToParcel(parcel, 0);
_L1:
        zznJ.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        status;
        parcel1.recycle();
        parcel.recycle();
        throw status;
    }

    (IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
