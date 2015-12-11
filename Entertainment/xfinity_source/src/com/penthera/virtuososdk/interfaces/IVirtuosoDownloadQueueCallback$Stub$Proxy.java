// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.interfaces;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.penthera.virtuososdk.client.IVirtuosoIdentifier;

// Referenced classes of package com.penthera.virtuososdk.interfaces:
//            IVirtuosoDownloadQueueCallback

private static class mRemote
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

    (IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
