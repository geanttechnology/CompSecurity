// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.interfaces;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.penthera.virtuososdk.client.IVirtuosoIdentifier;

public interface IVirtuosoDownloadedCallback
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements IVirtuosoDownloadedCallback
    {

        public static IVirtuosoDownloadedCallback asInterface(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadedCallback");
            if (iinterface != null && (iinterface instanceof IVirtuosoDownloadedCallback))
            {
                return (IVirtuosoDownloadedCallback)iinterface;
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
                parcel1.writeString("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadedCallback");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadedCallback");
                IVirtuosoIdentifier ivirtuosoidentifier;
                if (parcel.readInt() != 0)
                {
                    ivirtuosoidentifier = (IVirtuosoIdentifier)IVirtuosoIdentifier.CREATOR.createFromParcel(parcel);
                } else
                {
                    ivirtuosoidentifier = null;
                }
                engineContentInDownloadedList(ivirtuosoidentifier, parcel.readInt(), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadedCallback");
                engineDownloadedListChanged();
                parcel1.writeNoException();
                return true;
            }
        }

        public Stub()
        {
            attachInterface(this, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadedCallback");
        }
    }

    private static class Stub.Proxy
        implements IVirtuosoDownloadedCallback
    {

        private IBinder mRemote;

        public IBinder asBinder()
        {
            return mRemote;
        }

        public void engineContentInDownloadedList(IVirtuosoIdentifier ivirtuosoidentifier, int i, int j)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadedCallback");
            if (ivirtuosoidentifier == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            parcel.writeInt(1);
            ivirtuosoidentifier.writeToParcel(parcel, 0);
_L1:
            parcel.writeInt(i);
            parcel.writeInt(j);
            mRemote.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            ivirtuosoidentifier;
            parcel1.recycle();
            parcel.recycle();
            throw ivirtuosoidentifier;
        }

        public void engineDownloadedListChanged()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadedCallback");
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


    public abstract void engineContentInDownloadedList(IVirtuosoIdentifier ivirtuosoidentifier, int i, int j)
        throws RemoteException;

    public abstract void engineDownloadedListChanged()
        throws RemoteException;
}
