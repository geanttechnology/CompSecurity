// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.bootstrap.request.ConnectRequest;
import com.google.android.gms.nearby.bootstrap.request.ContinueConnectRequest;
import com.google.android.gms.nearby.bootstrap.request.DisableTargetRequest;
import com.google.android.gms.nearby.bootstrap.request.DisconnectRequest;
import com.google.android.gms.nearby.bootstrap.request.EnableTargetRequest;
import com.google.android.gms.nearby.bootstrap.request.SendDataRequest;
import com.google.android.gms.nearby.bootstrap.request.StartScanRequest;
import com.google.android.gms.nearby.bootstrap.request.StopScanRequest;
import com.google.android.gms.nearby.bootstrap.request.zza;
import com.google.android.gms.nearby.bootstrap.request.zzb;
import com.google.android.gms.nearby.bootstrap.request.zzc;
import com.google.android.gms.nearby.bootstrap.request.zzd;
import com.google.android.gms.nearby.bootstrap.request.zze;
import com.google.android.gms.nearby.bootstrap.request.zzf;
import com.google.android.gms.nearby.bootstrap.request.zzg;
import com.google.android.gms.nearby.bootstrap.request.zzh;

// Referenced classes of package com.google.android.gms.internal:
//            zzoz, zzoy

public static abstract class zza.zznI extends Binder
    implements zzoz
{
    private static class zza
        implements zzoz
    {

        private IBinder zznI;

        public IBinder asBinder()
        {
            return zznI;
        }

        public String getToken()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s;
            parcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            zznI.transact(9, parcel, parcel1, 0);
            parcel1.readException();
            s = parcel1.readString();
            parcel1.recycle();
            parcel.recycle();
            return s;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void zza(zzoy zzoy1)
            throws RemoteException
        {
            IBinder ibinder;
            Parcel parcel;
            ibinder = null;
            parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            if (zzoy1 == null)
            {
                break MISSING_BLOCK_LABEL_23;
            }
            ibinder = zzoy1.asBinder();
            parcel.writeStrongBinder(ibinder);
            zznI.transact(10, parcel, null, 1);
            parcel.recycle();
            return;
            zzoy1;
            parcel.recycle();
            throw zzoy1;
        }

        public void zza(ConnectRequest connectrequest)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            if (connectrequest == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            connectrequest.writeToParcel(parcel, 0);
_L1:
            zznI.transact(5, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            connectrequest;
            parcel.recycle();
            throw connectrequest;
        }

        public void zza(ContinueConnectRequest continueconnectrequest)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            if (continueconnectrequest == null)
            {
                break MISSING_BLOCK_LABEL_45;
            }
            parcel.writeInt(1);
            continueconnectrequest.writeToParcel(parcel, 0);
_L1:
            zznI.transact(8, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            continueconnectrequest;
            parcel.recycle();
            throw continueconnectrequest;
        }

        public void zza(DisableTargetRequest disabletargetrequest)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            if (disabletargetrequest == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            disabletargetrequest.writeToParcel(parcel, 0);
_L1:
            zznI.transact(4, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            disabletargetrequest;
            parcel.recycle();
            throw disabletargetrequest;
        }

        public void zza(DisconnectRequest disconnectrequest)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            if (disconnectrequest == null)
            {
                break MISSING_BLOCK_LABEL_45;
            }
            parcel.writeInt(1);
            disconnectrequest.writeToParcel(parcel, 0);
_L1:
            zznI.transact(6, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            disconnectrequest;
            parcel.recycle();
            throw disconnectrequest;
        }

        public void zza(EnableTargetRequest enabletargetrequest)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            if (enabletargetrequest == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            enabletargetrequest.writeToParcel(parcel, 0);
_L1:
            zznI.transact(3, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            enabletargetrequest;
            parcel.recycle();
            throw enabletargetrequest;
        }

        public void zza(SendDataRequest senddatarequest)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            if (senddatarequest == null)
            {
                break MISSING_BLOCK_LABEL_45;
            }
            parcel.writeInt(1);
            senddatarequest.writeToParcel(parcel, 0);
_L1:
            zznI.transact(7, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            senddatarequest;
            parcel.recycle();
            throw senddatarequest;
        }

        public void zza(StartScanRequest startscanrequest)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            if (startscanrequest == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            startscanrequest.writeToParcel(parcel, 0);
_L1:
            zznI.transact(1, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            startscanrequest;
            parcel.recycle();
            throw startscanrequest;
        }

        public void zza(StopScanRequest stopscanrequest)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            if (stopscanrequest == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            stopscanrequest.writeToParcel(parcel, 0);
_L1:
            zznI.transact(2, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            stopscanrequest;
            parcel.recycle();
            throw stopscanrequest;
        }

        zza(IBinder ibinder)
        {
            zznI = ibinder;
        }
    }


    public static zzoz zzdc(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
        if (iinterface != null && (iinterface instanceof zzoz))
        {
            return (zzoz)iinterface;
        } else
        {
            return new zza(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        throws RemoteException
    {
        Object obj1 = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        Object obj6 = null;
        Object obj7 = null;
        Object obj = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            parcel1 = obj;
            if (parcel.readInt() != 0)
            {
                parcel1 = StartScanRequest.CREATOR.zzft(parcel);
            }
            zza(parcel1);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            parcel1 = obj1;
            if (parcel.readInt() != 0)
            {
                parcel1 = StopScanRequest.CREATOR.zzfu(parcel);
            }
            zza(parcel1);
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            parcel1 = obj2;
            if (parcel.readInt() != 0)
            {
                parcel1 = EnableTargetRequest.CREATOR.zzfr(parcel);
            }
            zza(parcel1);
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            parcel1 = obj3;
            if (parcel.readInt() != 0)
            {
                parcel1 = DisableTargetRequest.CREATOR.zzfp(parcel);
            }
            zza(parcel1);
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            parcel1 = obj4;
            if (parcel.readInt() != 0)
            {
                parcel1 = ConnectRequest.CREATOR.zzfn(parcel);
            }
            zza(parcel1);
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            parcel1 = obj5;
            if (parcel.readInt() != 0)
            {
                parcel1 = DisconnectRequest.CREATOR.zzfq(parcel);
            }
            zza(parcel1);
            return true;

        case 7: // '\007'
            parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            parcel1 = obj6;
            if (parcel.readInt() != 0)
            {
                parcel1 = SendDataRequest.CREATOR.zzfs(parcel);
            }
            zza(parcel1);
            return true;

        case 8: // '\b'
            parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            parcel1 = obj7;
            if (parcel.readInt() != 0)
            {
                parcel1 = ContinueConnectRequest.CREATOR.zzfo(parcel);
            }
            zza(parcel1);
            return true;

        case 9: // '\t'
            parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            parcel = getToken();
            parcel1.writeNoException();
            parcel1.writeString(parcel);
            return true;

        case 10: // '\n'
            parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            zza(zzdb(parcel.readStrongBinder()));
            return true;
        }
    }
}
