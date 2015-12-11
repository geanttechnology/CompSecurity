// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            AppMetadata, EventParcel, UserAttributeParcel, zzj, 
//            zzb, zzaf

public interface zzm
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zzm
    {

        public static zzm zzcZ(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
            if (iinterface != null && (iinterface instanceof zzm))
            {
                return (zzm)iinterface;
            } else
            {
                return new zza(ibinder);
            }
        }

        public IBinder asBinder()
        {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            Object obj1 = null;
            Object obj = null;
            AppMetadata appmetadata = null;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.measurement.internal.IMeasurementService");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                if (parcel.readInt() != 0)
                {
                    obj = EventParcel.CREATOR.zzfz(parcel);
                } else
                {
                    obj = null;
                }
                if (parcel.readInt() != 0)
                {
                    appmetadata = AppMetadata.CREATOR.zzfx(parcel);
                }
                zza(((EventParcel) (obj)), appmetadata);
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                AppMetadata appmetadata1;
                if (parcel.readInt() != 0)
                {
                    obj = UserAttributeParcel.CREATOR.zzfA(parcel);
                } else
                {
                    obj = null;
                }
                appmetadata1 = obj1;
                if (parcel.readInt() != 0)
                {
                    appmetadata1 = AppMetadata.CREATOR.zzfx(parcel);
                }
                zza(((UserAttributeParcel) (obj)), appmetadata1);
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                break;
            }
            if (parcel.readInt() != 0)
            {
                obj = AppMetadata.CREATOR.zzfx(parcel);
            }
            zza(((AppMetadata) (obj)));
            parcel1.writeNoException();
            return true;
        }

        public zza()
        {
            attachInterface(this, "com.google.android.gms.measurement.internal.IMeasurementService");
        }
    }

    private static class zza.zza
        implements zzm
    {

        private IBinder zznJ;

        public IBinder asBinder()
        {
            return zznJ;
        }

        public void zza(AppMetadata appmetadata)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (appmetadata == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            appmetadata.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            appmetadata;
            parcel1.recycle();
            parcel.recycle();
            throw appmetadata;
        }

        public void zza(EventParcel eventparcel, AppMetadata appmetadata)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (eventparcel == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            eventparcel.writeToParcel(parcel, 0);
_L3:
            if (appmetadata == null)
            {
                break MISSING_BLOCK_LABEL_95;
            }
            parcel.writeInt(1);
            appmetadata.writeToParcel(parcel, 0);
_L4:
            zznJ.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            eventparcel;
            parcel1.recycle();
            parcel.recycle();
            throw eventparcel;
            parcel.writeInt(0);
              goto _L4
        }

        public void zza(UserAttributeParcel userattributeparcel, AppMetadata appmetadata)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (userattributeparcel == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            userattributeparcel.writeToParcel(parcel, 0);
_L3:
            if (appmetadata == null)
            {
                break MISSING_BLOCK_LABEL_95;
            }
            parcel.writeInt(1);
            appmetadata.writeToParcel(parcel, 0);
_L4:
            zznJ.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            userattributeparcel;
            parcel1.recycle();
            parcel.recycle();
            throw userattributeparcel;
            parcel.writeInt(0);
              goto _L4
        }

        zza.zza(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public abstract void zza(AppMetadata appmetadata)
        throws RemoteException;

    public abstract void zza(EventParcel eventparcel, AppMetadata appmetadata)
        throws RemoteException;

    public abstract void zza(UserAttributeParcel userattributeparcel, AppMetadata appmetadata)
        throws RemoteException;
}
