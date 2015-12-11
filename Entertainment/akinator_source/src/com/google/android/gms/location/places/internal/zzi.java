// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zze;

public interface zzi
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zzi
    {

        public static zzi zzch(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            if (iinterface != null && (iinterface instanceof zzi))
            {
                return (zzi)iinterface;
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
            Object obj2 = null;
            Object obj3 = null;
            Object obj4 = null;
            Object obj = null;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                parcel1 = obj;
                if (parcel.readInt() != 0)
                {
                    parcel1 = DataHolder.CREATOR.zzag(parcel);
                }
                zzab(parcel1);
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                parcel1 = obj1;
                if (parcel.readInt() != 0)
                {
                    parcel1 = DataHolder.CREATOR.zzag(parcel);
                }
                zzac(parcel1);
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                parcel1 = obj2;
                if (parcel.readInt() != 0)
                {
                    parcel1 = DataHolder.CREATOR.zzag(parcel);
                }
                zzad(parcel1);
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                parcel1 = obj3;
                if (parcel.readInt() != 0)
                {
                    parcel1 = (Status)Status.CREATOR.createFromParcel(parcel);
                }
                zzaN(parcel1);
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                parcel1 = obj4;
                break;
            }
            if (parcel.readInt() != 0)
            {
                parcel1 = DataHolder.CREATOR.zzag(parcel);
            }
            zzae(parcel1);
            return true;
        }

        public zza()
        {
            attachInterface(this, "com.google.android.gms.location.places.internal.IPlacesCallbacks");
        }
    }

    private static class zza.zza
        implements zzi
    {

        private IBinder zznJ;

        public IBinder asBinder()
        {
            return zznJ;
        }

        public void zzaN(Status status)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            if (status == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            status.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(4, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            status;
            parcel.recycle();
            throw status;
        }

        public void zzab(DataHolder dataholder)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            if (dataholder == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            dataholder.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(1, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            dataholder;
            parcel.recycle();
            throw dataholder;
        }

        public void zzac(DataHolder dataholder)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            if (dataholder == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            dataholder.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(2, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            dataholder;
            parcel.recycle();
            throw dataholder;
        }

        public void zzad(DataHolder dataholder)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            if (dataholder == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            dataholder.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(3, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            dataholder;
            parcel.recycle();
            throw dataholder;
        }

        public void zzae(DataHolder dataholder)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            if (dataholder == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            dataholder.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(5, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            dataholder;
            parcel.recycle();
            throw dataholder;
        }

        zza.zza(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public abstract void zzaN(Status status)
        throws RemoteException;

    public abstract void zzab(DataHolder dataholder)
        throws RemoteException;

    public abstract void zzac(DataHolder dataholder)
        throws RemoteException;

    public abstract void zzad(DataHolder dataholder)
        throws RemoteException;

    public abstract void zzae(DataHolder dataholder)
        throws RemoteException;
}
