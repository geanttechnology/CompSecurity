// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk.internal.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface PlaybackSdkEventContext
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements PlaybackSdkEventContext
    {

        public static PlaybackSdkEventContext asInterface(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventContext");
            if (iinterface != null && (iinterface instanceof PlaybackSdkEventContext))
            {
                return (PlaybackSdkEventContext)iinterface;
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
                parcel1.writeString("com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventContext");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventContext");
                parcel = getAsin();
                parcel1.writeNoException();
                parcel1.writeString(parcel);
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventContext");
                long l = getCurrentPosition();
                parcel1.writeNoException();
                parcel1.writeLong(l);
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventContext");
                long l1 = getDuration();
                parcel1.writeNoException();
                parcel1.writeLong(l1);
                return true;
            }
        }

        public Stub()
        {
            attachInterface(this, "com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventContext");
        }
    }

    private static class Stub.Proxy
        implements PlaybackSdkEventContext
    {

        private IBinder mRemote;

        public IBinder asBinder()
        {
            return mRemote;
        }

        public String getAsin()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s;
            parcel.writeInterfaceToken("com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventContext");
            mRemote.transact(1, parcel, parcel1, 0);
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

        public long getCurrentPosition()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            long l;
            parcel.writeInterfaceToken("com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventContext");
            mRemote.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            l = parcel1.readLong();
            parcel1.recycle();
            parcel.recycle();
            return l;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public long getDuration()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            long l;
            parcel.writeInterfaceToken("com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventContext");
            mRemote.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            l = parcel1.readLong();
            parcel1.recycle();
            parcel.recycle();
            return l;
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


    public abstract String getAsin()
        throws RemoteException;

    public abstract long getCurrentPosition()
        throws RemoteException;

    public abstract long getDuration()
        throws RemoteException;
}
