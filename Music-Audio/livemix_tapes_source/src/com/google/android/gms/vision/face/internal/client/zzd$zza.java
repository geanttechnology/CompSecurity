// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.face.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

// Referenced classes of package com.google.android.gms.vision.face.internal.client:
//            zzd, FaceSettingsParcel, zzb, zzc

public static abstract class zza.zznI extends Binder
    implements com.google.android.gms.vision.face.internal.client.zzd
{
    private static class zza
        implements com.google.android.gms.vision.face.internal.client.zzd
    {

        private IBinder zznI;

        public IBinder asBinder()
        {
            return zznI;
        }

        public zzc zza(zzd zzd1, FaceSettingsParcel facesettingsparcel)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
            if (zzd1 == null) goto _L2; else goto _L1
_L1:
            zzd1 = zzd1.asBinder();
_L5:
            parcel.writeStrongBinder(zzd1);
            if (facesettingsparcel == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            facesettingsparcel.writeToParcel(parcel, 0);
_L6:
            zznI.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            zzd1 = zzc.zza.zzdM(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return zzd1;
_L2:
            zzd1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            zzd1;
            parcel1.recycle();
            parcel.recycle();
            throw zzd1;
              goto _L5
        }

        zza(IBinder ibinder)
        {
            zznI = ibinder;
        }
    }


    public static com.google.android.gms.vision.face.internal.client.zzd zzdN(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
        if (iinterface != null && (iinterface instanceof com.google.android.gms.vision.face.internal.client.zzd))
        {
            return (com.google.android.gms.vision.face.internal.client.zzd)iinterface;
        } else
        {
            return new zza(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        throws RemoteException
    {
        Object obj = null;
        Object obj1;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
            obj1 = com.google.android.gms.dynamic.zzbk(parcel.readStrongBinder());
            break;
        }
        if (parcel.readInt() != 0)
        {
            parcel = FaceSettingsParcel.CREATOR.zzgB(parcel);
        } else
        {
            parcel = null;
        }
        obj1 = zza(((zzd) (obj1)), parcel);
        parcel1.writeNoException();
        parcel = obj;
        if (obj1 != null)
        {
            parcel = ((zzc) (obj1)).asBinder();
        }
        parcel1.writeStrongBinder(parcel);
        return true;
    }
}
