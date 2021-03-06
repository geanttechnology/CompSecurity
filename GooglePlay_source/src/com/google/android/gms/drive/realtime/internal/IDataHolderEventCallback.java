// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.DataHolderCreator;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;

public interface IDataHolderEventCallback
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements IDataHolderEventCallback
    {

        public static IDataHolderEventCallback asInterface(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
            if (iinterface != null && (iinterface instanceof IDataHolderEventCallback))
            {
                return (IDataHolderEventCallback)iinterface;
            } else
            {
                return new Proxy(ibinder);
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
                parcel1.writeString("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
                Object obj;
                if (parcel.readInt() != 0)
                {
                    obj = DataHolder.CREATOR;
                    obj = DataHolderCreator.createFromParcel(parcel);
                } else
                {
                    obj = null;
                }
                if (parcel.readInt() != 0)
                {
                    parcel = (ParcelableEventList)ParcelableEventList.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                onResult(((DataHolder) (obj)), parcel);
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
                break;
            }
            if (parcel.readInt() != 0)
            {
                parcel = (Status)Status.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            onError(parcel);
            parcel1.writeNoException();
            return true;
        }
    }

    private static final class Stub.Proxy
        implements IDataHolderEventCallback
    {

        private IBinder mRemote;

        public final IBinder asBinder()
        {
            return mRemote;
        }

        public final void onError(Status status)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
            if (status == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            status.writeToParcel(parcel, 0);
_L1:
            mRemote.transact(2, parcel, parcel1, 0);
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

        public final void onResult(DataHolder dataholder, ParcelableEventList parcelableeventlist)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
            if (dataholder == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            dataholder.writeToParcel(parcel, 0);
_L3:
            if (parcelableeventlist == null)
            {
                break MISSING_BLOCK_LABEL_95;
            }
            parcel.writeInt(1);
            parcelableeventlist.writeToParcel(parcel, 0);
_L4:
            mRemote.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            dataholder;
            parcel1.recycle();
            parcel.recycle();
            throw dataholder;
            parcel.writeInt(0);
              goto _L4
        }

        Stub.Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    public abstract void onError(Status status)
        throws RemoteException;

    public abstract void onResult(DataHolder dataholder, ParcelableEventList parcelableeventlist)
        throws RemoteException;
}
