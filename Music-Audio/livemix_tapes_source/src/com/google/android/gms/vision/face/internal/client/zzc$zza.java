// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.face.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import com.google.android.gms.vision.internal.client.zza;

// Referenced classes of package com.google.android.gms.vision.face.internal.client:
//            zzc, FaceParcel

public static abstract class zza.zznI extends Binder
    implements zzc
{
    private static class zza
        implements zzc
    {

        private IBinder zznI;

        public IBinder asBinder()
        {
            return zznI;
        }

        public void zzCf()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
            zznI.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public FaceParcel[] zzc(zzd zzd1, FrameMetadataParcel framemetadataparcel)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
            if (zzd1 == null) goto _L2; else goto _L1
_L1:
            zzd1 = zzd1.asBinder();
_L5:
            parcel.writeStrongBinder(zzd1);
            if (framemetadataparcel == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            framemetadataparcel.writeToParcel(parcel, 0);
_L6:
            zznI.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            zzd1 = (FaceParcel[])parcel1.createTypedArray(FaceParcel.CREATOR);
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

        public boolean zzjG(int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
            parcel.writeInt(i);
            zznI.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            i = parcel1.readInt();
            if (i != 0)
            {
                flag = true;
            }
            parcel1.recycle();
            parcel.recycle();
            return flag;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        zza(IBinder ibinder)
        {
            zznI = ibinder;
        }
    }


    public static zzc zzdM(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
        if (iinterface != null && (iinterface instanceof zzc))
        {
            return (zzc)iinterface;
        } else
        {
            return new zza(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        throws RemoteException
    {
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
            zzd zzd = com.google.android.gms.dynamic.zzbk(parcel.readStrongBinder());
            if (parcel.readInt() != 0)
            {
                parcel = FrameMetadataParcel.CREATOR.zzgD(parcel);
            } else
            {
                parcel = null;
            }
            parcel = zzc(zzd, parcel);
            parcel1.writeNoException();
            parcel1.writeTypedArray(parcel, 1);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
            boolean flag = zzjG(parcel.readInt());
            parcel1.writeNoException();
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel1.writeInt(i);
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
            zzCf();
            parcel1.writeNoException();
            return true;
        }
    }
}
