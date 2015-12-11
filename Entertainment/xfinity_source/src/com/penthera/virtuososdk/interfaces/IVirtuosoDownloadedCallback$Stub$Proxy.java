// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.interfaces;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.penthera.virtuososdk.client.IVirtuosoIdentifier;

// Referenced classes of package com.penthera.virtuososdk.interfaces:
//            IVirtuosoDownloadedCallback

private static class mRemote
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

    (IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
