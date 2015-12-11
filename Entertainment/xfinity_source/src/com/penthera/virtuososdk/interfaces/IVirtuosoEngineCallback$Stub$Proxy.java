// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.interfaces;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.penthera.virtuososdk.client.IVirtuosoDownloadEngineStatus;
import com.penthera.virtuososdk.client.IVirtuosoIdentifier;

// Referenced classes of package com.penthera.virtuososdk.interfaces:
//            IVirtuosoEngineCallback

private static class mRemote
    implements IVirtuosoEngineCallback
{

    private IBinder mRemote;

    public IBinder asBinder()
    {
        return mRemote;
    }

    public void collectionsChanged(IVirtuosoIdentifier aivirtuosoidentifier[])
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoEngineCallback");
        parcel.writeTypedArray(aivirtuosoidentifier, 0);
        mRemote.transact(5, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        aivirtuosoidentifier;
        parcel1.recycle();
        parcel.recycle();
        throw aivirtuosoidentifier;
    }

    public void collectionsDeleted(String as[])
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoEngineCallback");
        parcel.writeStringArray(as);
        mRemote.transact(6, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        as;
        parcel1.recycle();
        parcel.recycle();
        throw as;
    }

    public void downloadEngineStatusDidChange(IVirtuosoDownloadEngineStatus ivirtuosodownloadenginestatus)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoEngineCallback");
        if (ivirtuosodownloadenginestatus == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        parcel.writeInt(1);
        ivirtuosodownloadenginestatus.writeToParcel(parcel, 0);
_L1:
        mRemote.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        ivirtuosodownloadenginestatus;
        parcel1.recycle();
        parcel.recycle();
        throw ivirtuosodownloadenginestatus;
    }

    public void engineContentInList(IVirtuosoIdentifier ivirtuosoidentifier, int i, int j)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoEngineCallback");
        if (ivirtuosoidentifier == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        parcel.writeInt(1);
        ivirtuosoidentifier.writeToParcel(parcel, 0);
_L1:
        parcel.writeInt(i);
        parcel.writeInt(j);
        mRemote.transact(2, parcel, parcel1, 0);
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

    public void engineListChanged()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoEngineCallback");
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

    public void itemUpdated(IVirtuosoIdentifier ivirtuosoidentifier)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoEngineCallback");
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

    public void settingChanged(int i)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoEngineCallback");
        parcel.writeInt(i);
        mRemote.transact(4, parcel, parcel1, 0);
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

    (IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
