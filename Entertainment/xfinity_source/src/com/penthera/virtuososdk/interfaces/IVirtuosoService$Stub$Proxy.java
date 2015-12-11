// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.interfaces;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.penthera.virtuososdk.client.IVirtuosoDownloadEngineStatus;
import com.penthera.virtuososdk.client.IVirtuosoIdentifier;

// Referenced classes of package com.penthera.virtuososdk.interfaces:
//            IVirtuosoService, IVirtuosoDownloadedCallback, IVirtuosoEngineCallback, IVirtuosoDownloadQueueCallback

private static class mRemote
    implements IVirtuosoService
{

    private IBinder mRemote;

    public double allowableStorageRemaining(String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        double d;
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        parcel.writeString(s);
        mRemote.transact(34, parcel, parcel1, 0);
        parcel1.readException();
        d = parcel1.readDouble();
        parcel1.recycle();
        parcel.recycle();
        return d;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public IBinder asBinder()
    {
        return mRemote;
    }

    public boolean cellularDataQuotaOK(String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = false;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        parcel.writeString(s);
        mRemote.transact(28, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i != 0)
        {
            flag = true;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public void cleanup(String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        parcel.writeString(s);
        mRemote.transact(31, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public void configure(Bundle bundle, int i, int j, String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L1:
        parcel.writeInt(i);
        parcel.writeInt(j);
        parcel.writeString(s);
        mRemote.transact(8, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        bundle;
        parcel1.recycle();
        parcel.recycle();
        throw bundle;
    }

    public boolean diskStatusOK(String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = false;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        parcel.writeString(s);
        mRemote.transact(27, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i != 0)
        {
            flag = true;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public boolean enabled(String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = false;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        parcel.writeString(s);
        mRemote.transact(23, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i != 0)
        {
            flag = true;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public double getCurrentThroughput(String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        double d;
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        parcel.writeString(s);
        mRemote.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        d = parcel1.readDouble();
        parcel1.recycle();
        parcel.recycle();
        return d;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public double getOverallThroughput(String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        double d;
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        parcel.writeString(s);
        mRemote.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        d = parcel1.readDouble();
        parcel1.recycle();
        parcel.recycle();
        return d;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public void markComplete(IVirtuosoIdentifier ivirtuosoidentifier, String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        if (ivirtuosoidentifier == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        parcel.writeInt(1);
        ivirtuosoidentifier.writeToParcel(parcel, 0);
_L1:
        parcel.writeString(s);
        mRemote.transact(3, parcel, parcel1, 0);
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

    public void markErrored(IVirtuosoIdentifier ivirtuosoidentifier, int i, String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        if (ivirtuosoidentifier == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        parcel.writeInt(1);
        ivirtuosoidentifier.writeToParcel(parcel, 0);
_L1:
        parcel.writeInt(i);
        parcel.writeString(s);
        mRemote.transact(4, parcel, parcel1, 0);
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

    public boolean networkStatusOK(String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = false;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        parcel.writeString(s);
        mRemote.transact(26, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i != 0)
        {
            flag = true;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public void pauseDownloads(String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        parcel.writeString(s);
        mRemote.transact(19, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public boolean powerStatusOK(String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = false;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        parcel.writeString(s);
        mRemote.transact(25, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i != 0)
        {
            flag = true;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public int queueSize(String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        parcel.writeString(s);
        mRemote.transact(21, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public long quotaRecordingStart(String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        long l;
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        parcel.writeString(s);
        mRemote.transact(30, parcel, parcel1, 0);
        parcel1.readException();
        l = parcel1.readLong();
        parcel1.recycle();
        parcel.recycle();
        return l;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public void registerDownloadCallbackHandler(IVirtuosoDownloadedCallback ivirtuosodownloadedcallback, String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        if (ivirtuosodownloadedcallback == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        ivirtuosodownloadedcallback = ivirtuosodownloadedcallback.asBinder();
_L1:
        parcel.writeStrongBinder(ivirtuosodownloadedcallback);
        parcel.writeString(s);
        mRemote.transact(13, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        ivirtuosodownloadedcallback = null;
          goto _L1
        ivirtuosodownloadedcallback;
        parcel1.recycle();
        parcel.recycle();
        throw ivirtuosodownloadedcallback;
    }

    public void registerEngineCallbackHandler(IVirtuosoEngineCallback ivirtuosoenginecallback, String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        if (ivirtuosoenginecallback == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        ivirtuosoenginecallback = ivirtuosoenginecallback.asBinder();
_L1:
        parcel.writeStrongBinder(ivirtuosoenginecallback);
        parcel.writeString(s);
        mRemote.transact(15, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        ivirtuosoenginecallback = null;
          goto _L1
        ivirtuosoenginecallback;
        parcel1.recycle();
        parcel.recycle();
        throw ivirtuosoenginecallback;
    }

    public void registerQueueCallbackHandler(IVirtuosoDownloadQueueCallback ivirtuosodownloadqueuecallback, String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        if (ivirtuosodownloadqueuecallback == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        ivirtuosodownloadqueuecallback = ivirtuosodownloadqueuecallback.asBinder();
_L1:
        parcel.writeStrongBinder(ivirtuosodownloadqueuecallback);
        parcel.writeString(s);
        mRemote.transact(17, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        ivirtuosodownloadqueuecallback = null;
          goto _L1
        ivirtuosodownloadqueuecallback;
        parcel1.recycle();
        parcel.recycle();
        throw ivirtuosodownloadqueuecallback;
    }

    public void resetCellularDataQuota(String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        parcel.writeString(s);
        mRemote.transact(22, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public void resetErrorQueue(String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        parcel.writeString(s);
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

    public void resetTestSettings(String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        parcel.writeString(s);
        mRemote.transact(7, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public void resumeDownloads(String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        parcel.writeString(s);
        mRemote.transact(20, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public void setTestSettings(Bundle bundle, String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L1:
        parcel.writeString(s);
        mRemote.transact(6, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        bundle;
        parcel1.recycle();
        parcel.recycle();
        throw bundle;
    }

    public void signalDelete(String s, IVirtuosoIdentifier ivirtuosoidentifier)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        parcel.writeString(s);
        if (ivirtuosoidentifier == null)
        {
            break MISSING_BLOCK_LABEL_68;
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
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public void signalDownloadSettingChange(String s, int i)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        parcel.writeString(s);
        parcel.writeInt(i);
        mRemote.transact(12, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public void signalExpire(String s, IVirtuosoIdentifier ivirtuosoidentifier)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        parcel.writeString(s);
        if (ivirtuosoidentifier == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        parcel.writeInt(1);
        ivirtuosoidentifier.writeToParcel(parcel, 0);
_L1:
        mRemote.transact(11, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public void signalQueueChange(String s, boolean flag)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        int i;
        i = 0;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        parcel.writeString(s);
        if (flag)
        {
            i = 1;
        }
        parcel.writeInt(i);
        mRemote.transact(9, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public IVirtuosoDownloadEngineStatus status(String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        parcel.writeString(s);
        mRemote.transact(24, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        s = (IVirtuosoDownloadEngineStatus)IVirtuosoDownloadEngineStatus.CREATOR.mParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return s;
_L2:
        s = null;
        if (true) goto _L4; else goto _L3
_L3:
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public double storageUsed(String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        double d;
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        parcel.writeString(s);
        mRemote.transact(32, parcel, parcel1, 0);
        parcel1.readException();
        d = parcel1.readDouble();
        parcel1.recycle();
        parcel.recycle();
        return d;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public double totalFileSize(String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        double d;
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        parcel.writeString(s);
        mRemote.transact(33, parcel, parcel1, 0);
        parcel1.readException();
        d = parcel1.readDouble();
        parcel1.recycle();
        parcel.recycle();
        return d;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public void unregisterDownloadCallbackHandler(IVirtuosoDownloadedCallback ivirtuosodownloadedcallback, String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        if (ivirtuosodownloadedcallback == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        ivirtuosodownloadedcallback = ivirtuosodownloadedcallback.asBinder();
_L1:
        parcel.writeStrongBinder(ivirtuosodownloadedcallback);
        parcel.writeString(s);
        mRemote.transact(14, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        ivirtuosodownloadedcallback = null;
          goto _L1
        ivirtuosodownloadedcallback;
        parcel1.recycle();
        parcel.recycle();
        throw ivirtuosodownloadedcallback;
    }

    public void unregisterEngineCallbackHandler(IVirtuosoEngineCallback ivirtuosoenginecallback, String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        if (ivirtuosoenginecallback == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        ivirtuosoenginecallback = ivirtuosoenginecallback.asBinder();
_L1:
        parcel.writeStrongBinder(ivirtuosoenginecallback);
        parcel.writeString(s);
        mRemote.transact(16, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        ivirtuosoenginecallback = null;
          goto _L1
        ivirtuosoenginecallback;
        parcel1.recycle();
        parcel.recycle();
        throw ivirtuosoenginecallback;
    }

    public void unregisterQueueCallbackHandler(IVirtuosoDownloadQueueCallback ivirtuosodownloadqueuecallback, String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        if (ivirtuosodownloadqueuecallback == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        ivirtuosodownloadqueuecallback = ivirtuosodownloadqueuecallback.asBinder();
_L1:
        parcel.writeStrongBinder(ivirtuosodownloadqueuecallback);
        parcel.writeString(s);
        mRemote.transact(18, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        ivirtuosodownloadqueuecallback = null;
          goto _L1
        ivirtuosodownloadqueuecallback;
        parcel1.recycle();
        parcel.recycle();
        throw ivirtuosodownloadqueuecallback;
    }

    public double utilizedCellularDataQuota(String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        double d;
        parcel.writeInterfaceToken("com.penthera.virtuososdk.interfaces.IVirtuosoService");
        parcel.writeString(s);
        mRemote.transact(29, parcel, parcel1, 0);
        parcel1.readException();
        d = parcel1.readDouble();
        parcel1.recycle();
        parcel.recycle();
        return d;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    ck(IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
