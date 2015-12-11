// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.sound.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ISoundService
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements ISoundService
    {

        private static final String DESCRIPTOR = "com.fanhattan.services.sound.api.ISoundService";
        static final int TRANSACTION_getMode = 4;
        static final int TRANSACTION_play = 1;
        static final int TRANSACTION_setMode = 3;
        static final int TRANSACTION_setVolume = 2;

        public static ISoundService asInterface(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.fanhattan.services.sound.api.ISoundService");
            if (iinterface != null && (iinterface instanceof ISoundService))
            {
                return (ISoundService)iinterface;
            } else
            {
                return new Proxy(ibinder);
            }
        }

        public IBinder asBinder()
        {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.fanhattan.services.sound.api.ISoundService");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.fanhattan.services.sound.api.ISoundService");
                play(parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.fanhattan.services.sound.api.ISoundService");
                setVolume(parcel.readFloat());
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.fanhattan.services.sound.api.ISoundService");
                setMode(parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.fanhattan.services.sound.api.ISoundService");
                i = getMode();
                parcel1.writeNoException();
                parcel1.writeInt(i);
                return true;
            }
        }

        public Stub()
        {
            attachInterface(this, "com.fanhattan.services.sound.api.ISoundService");
        }
    }

    private static class Stub.Proxy
        implements ISoundService
    {

        private IBinder mRemote;

        public IBinder asBinder()
        {
            return mRemote;
        }

        public String getInterfaceDescriptor()
        {
            return "com.fanhattan.services.sound.api.ISoundService";
        }

        public int getMode()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.fanhattan.services.sound.api.ISoundService");
            mRemote.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            i = parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            return i;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void play(int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.sound.api.ISoundService");
            parcel.writeInt(i);
            mRemote.transact(1, parcel, parcel1, 0);
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

        public void setMode(int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.sound.api.ISoundService");
            parcel.writeInt(i);
            mRemote.transact(3, parcel, parcel1, 0);
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

        public void setVolume(float f)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.sound.api.ISoundService");
            parcel.writeFloat(f);
            mRemote.transact(2, parcel, parcel1, 0);
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

        Stub.Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    public abstract int getMode()
        throws RemoteException;

    public abstract void play(int i)
        throws RemoteException;

    public abstract void setMode(int i)
        throws RemoteException;

    public abstract void setVolume(float f)
        throws RemoteException;
}
