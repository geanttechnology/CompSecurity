// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.proxy.ProxyGrpcRequest;
import com.google.android.gms.auth.api.proxy.ProxyRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zzkk

public abstract class xyGrpcRequest extends Binder
    implements zzkk
{

    public static zzkk zzaw(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        class zza
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

            zza(IBinder ibinder)
            {
                zznJ = ibinder;
            }
        }

        if (iinterface != null && (iinterface instanceof zzkk))
        {
            return (zzkk)iinterface;
        } else
        {
            return new zza(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        zzkj zzkj = null;
        Object obj = null;
        zzkj zzkj1;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.auth.api.internal.IAuthService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.auth.api.internal.IAuthService");
            zzkj = zzav(parcel.readStrongBinder());
            if (parcel.readInt() != 0)
            {
                obj = (ProxyRequest)ProxyRequest.CREATOR.createFromParcel(parcel);
            }
            zza(zzkj, ((ProxyRequest) (obj)));
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.auth.api.internal.IAuthService");
            zzkj1 = zzav(parcel.readStrongBinder());
            obj = zzkj;
            break;
        }
        if (parcel.readInt() != 0)
        {
            obj = (ProxyGrpcRequest)ProxyGrpcRequest.CREATOR.createFromParcel(parcel);
        }
        zza(zzkj1, ((ProxyGrpcRequest) (obj)));
        parcel1.writeNoException();
        return true;
    }
}
