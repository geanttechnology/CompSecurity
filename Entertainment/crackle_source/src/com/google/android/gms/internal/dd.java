// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.DataHolderCreator;

public interface dd
    extends IInterface
{
    public static abstract class a extends Binder
        implements dd
    {

        public static dd s(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
            if (iinterface != null && (iinterface instanceof dd))
            {
                return (dd)iinterface;
            } else
            {
                return new a(ibinder);
            }
        }

        public IBinder asBinder()
        {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            Object obj = null;
            DataHolder dataholder = null;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                return true;

            case 5001: 
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                i = parcel.readInt();
                if (parcel.readInt() != 0)
                {
                    dataholder = DataHolder.CREATOR.createFromParcel(parcel);
                }
                a(i, dataholder);
                parcel1.writeNoException();
                return true;

            case 5002: 
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                DataHolder dataholder1 = obj;
                if (parcel.readInt() != 0)
                {
                    dataholder1 = DataHolder.CREATOR.createFromParcel(parcel);
                }
                a(dataholder1);
                parcel1.writeNoException();
                return true;

            case 5003: 
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                onStateDeleted(parcel.readInt(), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 5004: 
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                onSignOutComplete();
                parcel1.writeNoException();
                return true;

            case 5005: 
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                p(parcel.readInt());
                parcel1.writeNoException();
                return true;
            }
        }

        public a()
        {
            attachInterface(this, "com.google.android.gms.appstate.internal.IAppStateCallbacks");
        }
    }

    private static class a.a
        implements dd
    {

        private IBinder dU;

        public void a(int i, DataHolder dataholder)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
            parcel.writeInt(i);
            if (dataholder == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            parcel.writeInt(1);
            dataholder.writeToParcel(parcel, 0);
_L1:
            dU.transact(5001, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            dataholder;
            parcel1.recycle();
            parcel.recycle();
            throw dataholder;
        }

        public void a(DataHolder dataholder)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
            if (dataholder == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            parcel.writeInt(1);
            dataholder.writeToParcel(parcel, 0);
_L1:
            dU.transact(5002, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            dataholder;
            parcel1.recycle();
            parcel.recycle();
            throw dataholder;
        }

        public IBinder asBinder()
        {
            return dU;
        }

        public void onSignOutComplete()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
            dU.transact(5004, parcel, parcel1, 0);
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

        public void onStateDeleted(int i, int j)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
            parcel.writeInt(i);
            parcel.writeInt(j);
            dU.transact(5003, parcel, parcel1, 0);
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

        public void p(int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
            parcel.writeInt(i);
            dU.transact(5005, parcel, parcel1, 0);
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

        a.a(IBinder ibinder)
        {
            dU = ibinder;
        }
    }


    public abstract void a(int i, DataHolder dataholder)
        throws RemoteException;

    public abstract void a(DataHolder dataholder)
        throws RemoteException;

    public abstract void onSignOutComplete()
        throws RemoteException;

    public abstract void onStateDeleted(int i, int j)
        throws RemoteException;

    public abstract void p(int i)
        throws RemoteException;
}
