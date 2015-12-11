// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.proxy.ProxyGrpcRequest;
import com.google.android.gms.auth.api.proxy.ProxyRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zzkk, zzkj

class zznJ
    implements zzkk
{

    private IBinder zznJ;

    public IBinder asBinder()
    {
        return zznJ;
    }

    public void zza(zzkj zzkj1, ProxyGrpcRequest proxygrpcrequest)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthService");
        if (zzkj1 == null) goto _L2; else goto _L1
_L1:
        zzkj1 = zzkj1.asBinder();
_L5:
        parcel.writeStrongBinder(zzkj1);
        if (proxygrpcrequest == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        proxygrpcrequest.writeToParcel(parcel, 0);
_L6:
        zznJ.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        zzkj1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        zzkj1;
        parcel1.recycle();
        parcel.recycle();
        throw zzkj1;
          goto _L5
    }

    public void zza(zzkj zzkj1, ProxyRequest proxyrequest)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthService");
        if (zzkj1 == null) goto _L2; else goto _L1
_L1:
        zzkj1 = zzkj1.asBinder();
_L5:
        parcel.writeStrongBinder(zzkj1);
        if (proxyrequest == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        proxyrequest.writeToParcel(parcel, 0);
_L6:
        zznJ.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        zzkj1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        zzkj1;
        parcel1.recycle();
        parcel.recycle();
        throw zzkj1;
          goto _L5
    }

    quest(IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
