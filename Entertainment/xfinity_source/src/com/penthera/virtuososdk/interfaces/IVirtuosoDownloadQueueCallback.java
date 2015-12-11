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

public interface IVirtuosoDownloadQueueCallback
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements IVirtuosoDownloadQueueCallback
    {

        public static IVirtuosoDownloadQueueCallback asInterface(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
            if (iinterface != null && (iinterface instanceof IVirtuosoDownloadQueueCallback))
            {
                return (IVirtuosoDownloadQueueCallback)iinterface;
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
                parcel1.writeString("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
                downloadEngineDidStartDownloadingFileMin(parcel.readString(), parcel.readInt(), parcel.readDouble(), parcel.readDouble(), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
                downloadEngineProgressUpdatedForFileMin(parcel.readString(), parcel.readInt(), parcel.readDouble(), parcel.readDouble(), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
                downloadEngineDidFinishDownloadingFileMin(parcel.readString(), parcel.readInt(), parcel.readDouble(), parcel.readDouble(), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
                downloadEngineFileWithErrorMin(parcel.readString(), parcel.readInt(), parcel.readDouble(), parcel.readDouble(), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
                fragmentCompleteMin(parcel.readString(), parcel.readInt(), parcel.readDouble(), parcel.readDouble(), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
                if (parcel.readInt() != 0)
                {
                    parcel = (IVirtuosoIdentifier)IVirtuosoIdentifier.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                downloadEngineDidStartDownloadingFile(parcel);
                parcel1.writeNoException();
                return true;

            case 7: // '\007'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
                if (parcel.readInt() != 0)
                {
                    parcel = (IVirtuosoIdentifier)IVirtuosoIdentifier.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                downloadEngineProgressUpdatedForFile(parcel);
                parcel1.writeNoException();
                return true;

            case 8: // '\b'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
                if (parcel.readInt() != 0)
                {
                    parcel = (IVirtuosoIdentifier)IVirtuosoIdentifier.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                downloadEngineDidFinishDownloadingFile(parcel);
                parcel1.writeNoException();
                return true;

            case 9: // '\t'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
                if (parcel.readInt() != 0)
                {
                    parcel = (IVirtuosoIdentifier)IVirtuosoIdentifier.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                downloadEngineFileWithError(parcel);
                parcel1.writeNoException();
                return true;

            case 10: // '\n'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
                if (parcel.readInt() != 0)
                {
                    parcel = (IVirtuosoIdentifier)IVirtuosoIdentifier.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                fragmentComplete(parcel);
                parcel1.writeNoException();
                return true;

            case 11: // '\013'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
                IVirtuosoIdentifier ivirtuosoidentifier;
                if (parcel.readInt() != 0)
                {
                    ivirtuosoidentifier = (IVirtuosoIdentifier)IVirtuosoIdentifier.CREATOR.createFromParcel(parcel);
                } else
                {
                    ivirtuosoidentifier = null;
                }
                engineContentInQueuedList(ivirtuosoidentifier, parcel.readInt(), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 12: // '\f'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
                engineDownloadQueueChanged();
                parcel1.writeNoException();
                return true;

            case 13: // '\r'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
                collectionsProgressUpdated((IVirtuosoIdentifier[])parcel.createTypedArray(IVirtuosoIdentifier.CREATOR));
                parcel1.writeNoException();
                return true;

            case 14: // '\016'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
                collectionsComplete((IVirtuosoIdentifier[])parcel.createTypedArray(IVirtuosoIdentifier.CREATOR));
                parcel1.writeNoException();
                return true;
            }
        }

        public Stub()
        {
            attachInterface(this, "com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
        }
    }

    private static class Stub.Proxy
        implements IVirtuosoDownloadQueueCallback
    {

        private IBinder mRemote;

        public IBinder asBinder()
        {
            return mRemote;
        }

        public void collectionsComplete(IVirtuosoIdentifier aivirtuosoidentifier[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
            parcel.writeTypedArray(aivirtuosoidentifier, 0);
            mRemote.transact(14, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            aivirtuosoidentifier;
            parcel1.recycle();
            parcel.recycle();
            throw aivirtuosoidentifier;
        }

        public void collectionsProgressUpdated(IVirtuosoIdentifier aivirtuosoidentifier[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
            parcel.writeTypedArray(aivirtuosoidentifier, 0);
            mRemote.transact(13, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            aivirtuosoidentifier;
            parcel1.recycle();
            parcel.recycle();
            throw aivirtuosoidentifier;
        }

        public void downloadEngineDidFinishDownloadingFile(IVirtuosoIdentifier ivirtuosoidentifier)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
            if (ivirtuosoidentifier == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            parcel.writeInt(1);
            ivirtuosoidentifier.writeToParcel(parcel, 0);
_L1:
            mRemote.transact(8, parcel, parcel1, 0);
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

        public void downloadEngineDidFinishDownloadingFileMin(String s, int i, double d, double d1, int j)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
            parcel.writeString(s);
            parcel.writeInt(i);
            parcel.writeDouble(d);
            parcel.writeDouble(d1);
            parcel.writeInt(j);
            mRemote.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void downloadEngineDidStartDownloadingFile(IVirtuosoIdentifier ivirtuosoidentifier)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
            if (ivirtuosoidentifier == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            parcel.writeInt(1);
            ivirtuosoidentifier.writeToParcel(parcel, 0);
_L1:
            mRemote.transact(6, parcel, parcel1, 0);
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

        public void downloadEngineDidStartDownloadingFileMin(String s, int i, double d, double d1, int j)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
            parcel.writeString(s);
            parcel.writeInt(i);
            parcel.writeDouble(d);
            parcel.writeDouble(d1);
            parcel.writeInt(j);
            mRemote.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void downloadEngineFileWithError(IVirtuosoIdentifier ivirtuosoidentifier)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
            if (ivirtuosoidentifier == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            parcel.writeInt(1);
            ivirtuosoidentifier.writeToParcel(parcel, 0);
_L1:
            mRemote.transact(9, parcel, parcel1, 0);
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

        public void downloadEngineFileWithErrorMin(String s, int i, double d, double d1, int j)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
            parcel.writeString(s);
            parcel.writeInt(i);
            parcel.writeDouble(d);
            parcel.writeDouble(d1);
            parcel.writeInt(j);
            mRemote.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void downloadEngineProgressUpdatedForFile(IVirtuosoIdentifier ivirtuosoidentifier)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
            if (ivirtuosoidentifier == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            parcel.writeInt(1);
            ivirtuosoidentifier.writeToParcel(parcel, 0);
_L1:
            mRemote.transact(7, parcel, parcel1, 0);
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

        public void downloadEngineProgressUpdatedForFileMin(String s, int i, double d, double d1, int j)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
            parcel.writeString(s);
            parcel.writeInt(i);
            parcel.writeDouble(d);
            parcel.writeDouble(d1);
            parcel.writeInt(j);
            mRemote.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void engineContentInQueuedList(IVirtuosoIdentifier ivirtuosoidentifier, int i, int j)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
            if (ivirtuosoidentifier == null)
            {
                break MISSING_BLOCK_LABEL_81;
            }
            parcel.writeInt(1);
            ivirtuosoidentifier.writeToParcel(parcel, 0);
_L1:
            parcel.writeInt(i);
            parcel.writeInt(j);
            mRemote.transact(11, parcel, parcel1, 0);
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

        public void engineDownloadQueueChanged()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
            mRemote.transact(12, parcel, parcel1, 0);
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

        public void fragmentComplete(IVirtuosoIdentifier ivirtuosoidentifier)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
            if (ivirtuosoidentifier == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            parcel.writeInt(1);
            ivirtuosoidentifier.writeToParcel(parcel, 0);
_L1:
            mRemote.transact(10, parcel, parcel1, 0);
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

        public void fragmentCompleteMin(String s, int i, double d, double d1, int j)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoDownloadQueueCallback");
            parcel.writeString(s);
            parcel.writeInt(i);
            parcel.writeDouble(d);
            parcel.writeDouble(d1);
            parcel.writeInt(j);
            mRemote.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        Stub.Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    public abstract void collectionsComplete(IVirtuosoIdentifier aivirtuosoidentifier[])
        throws RemoteException;

    public abstract void collectionsProgressUpdated(IVirtuosoIdentifier aivirtuosoidentifier[])
        throws RemoteException;

    public abstract void downloadEngineDidFinishDownloadingFile(IVirtuosoIdentifier ivirtuosoidentifier)
        throws RemoteException;

    public abstract void downloadEngineDidFinishDownloadingFileMin(String s, int i, double d, double d1, int j)
        throws RemoteException;

    public abstract void downloadEngineDidStartDownloadingFile(IVirtuosoIdentifier ivirtuosoidentifier)
        throws RemoteException;

    public abstract void downloadEngineDidStartDownloadingFileMin(String s, int i, double d, double d1, int j)
        throws RemoteException;

    public abstract void downloadEngineFileWithError(IVirtuosoIdentifier ivirtuosoidentifier)
        throws RemoteException;

    public abstract void downloadEngineFileWithErrorMin(String s, int i, double d, double d1, int j)
        throws RemoteException;

    public abstract void downloadEngineProgressUpdatedForFile(IVirtuosoIdentifier ivirtuosoidentifier)
        throws RemoteException;

    public abstract void downloadEngineProgressUpdatedForFileMin(String s, int i, double d, double d1, int j)
        throws RemoteException;

    public abstract void engineContentInQueuedList(IVirtuosoIdentifier ivirtuosoidentifier, int i, int j)
        throws RemoteException;

    public abstract void engineDownloadQueueChanged()
        throws RemoteException;

    public abstract void fragmentComplete(IVirtuosoIdentifier ivirtuosoidentifier)
        throws RemoteException;

    public abstract void fragmentCompleteMin(String s, int i, double d, double d1, int j)
        throws RemoteException;
}
