// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.signin.internal:
//            zze, AuthAccountResult

class zzlW
    implements zze
{

    private IBinder zzlW;

    public IBinder asBinder()
    {
        return zzlW;
    }

    public void zza(ConnectionResult connectionresult, AuthAccountResult authaccountresult)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
        if (connectionresult == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        connectionresult.writeToParcel(parcel, 0);
_L3:
        if (authaccountresult == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        parcel.writeInt(1);
        authaccountresult.writeToParcel(parcel, 0);
_L4:
        zzlW.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        connectionresult;
        parcel1.recycle();
        parcel.recycle();
        throw connectionresult;
        parcel.writeInt(0);
          goto _L4
    }

    public void zzaN(Status status)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
        if (status == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        parcel.writeInt(1);
        status.writeToParcel(parcel, 0);
_L1:
        zzlW.transact(4, parcel, parcel1, 0);
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

    esult(IBinder ibinder)
    {
        zzlW = ibinder;
    }
}
