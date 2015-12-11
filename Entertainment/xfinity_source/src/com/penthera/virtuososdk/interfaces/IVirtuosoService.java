// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.interfaces;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.penthera.virtuososdk.client.IVirtuosoDownloadEngineStatus;
import com.penthera.virtuososdk.client.IVirtuosoIdentifier;

// Referenced classes of package com.penthera.virtuososdk.interfaces:
//            IVirtuosoDownloadedCallback, IVirtuosoEngineCallback, IVirtuosoDownloadQueueCallback

public interface IVirtuosoService
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements IVirtuosoService
    {

        public static IVirtuosoService asInterface(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
            if (iinterface != null && (iinterface instanceof IVirtuosoService))
            {
                return (IVirtuosoService)iinterface;
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
            boolean flag = false;
            boolean flag1 = false;
            boolean flag2 = false;
            boolean flag3 = false;
            boolean flag4 = false;
            boolean flag5 = false;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                double d = getCurrentThroughput(parcel.readString());
                parcel1.writeNoException();
                parcel1.writeDouble(d);
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                double d1 = getOverallThroughput(parcel.readString());
                parcel1.writeNoException();
                parcel1.writeDouble(d1);
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                IVirtuosoIdentifier ivirtuosoidentifier;
                if (parcel.readInt() != 0)
                {
                    ivirtuosoidentifier = (IVirtuosoIdentifier)IVirtuosoIdentifier.CREATOR.createFromParcel(parcel);
                } else
                {
                    ivirtuosoidentifier = null;
                }
                markComplete(ivirtuosoidentifier, parcel.readString());
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                IVirtuosoIdentifier ivirtuosoidentifier1;
                if (parcel.readInt() != 0)
                {
                    ivirtuosoidentifier1 = (IVirtuosoIdentifier)IVirtuosoIdentifier.CREATOR.createFromParcel(parcel);
                } else
                {
                    ivirtuosoidentifier1 = null;
                }
                markErrored(ivirtuosoidentifier1, parcel.readInt(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                resetErrorQueue(parcel.readString());
                parcel1.writeNoException();
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                Bundle bundle;
                if (parcel.readInt() != 0)
                {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                } else
                {
                    bundle = null;
                }
                setTestSettings(bundle, parcel.readString());
                parcel1.writeNoException();
                return true;

            case 7: // '\007'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                resetTestSettings(parcel.readString());
                parcel1.writeNoException();
                return true;

            case 8: // '\b'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                Bundle bundle1;
                if (parcel.readInt() != 0)
                {
                    bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                } else
                {
                    bundle1 = null;
                }
                configure(bundle1, parcel.readInt(), parcel.readInt(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 9: // '\t'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                String s = parcel.readString();
                if (parcel.readInt() != 0)
                {
                    flag5 = true;
                }
                signalQueueChange(s, flag5);
                parcel1.writeNoException();
                return true;

            case 10: // '\n'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                String s1 = parcel.readString();
                if (parcel.readInt() != 0)
                {
                    parcel = (IVirtuosoIdentifier)IVirtuosoIdentifier.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                signalDelete(s1, parcel);
                parcel1.writeNoException();
                return true;

            case 11: // '\013'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                String s2 = parcel.readString();
                if (parcel.readInt() != 0)
                {
                    parcel = (IVirtuosoIdentifier)IVirtuosoIdentifier.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                signalExpire(s2, parcel);
                parcel1.writeNoException();
                return true;

            case 12: // '\f'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                signalDownloadSettingChange(parcel.readString(), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 13: // '\r'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                registerDownloadCallbackHandler(IVirtuosoDownloadedCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 14: // '\016'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                unregisterDownloadCallbackHandler(IVirtuosoDownloadedCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 15: // '\017'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                registerEngineCallbackHandler(IVirtuosoEngineCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 16: // '\020'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                unregisterEngineCallbackHandler(IVirtuosoEngineCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 17: // '\021'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                registerQueueCallbackHandler(IVirtuosoDownloadQueueCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 18: // '\022'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                unregisterQueueCallbackHandler(IVirtuosoDownloadQueueCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 19: // '\023'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                pauseDownloads(parcel.readString());
                parcel1.writeNoException();
                return true;

            case 20: // '\024'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                resumeDownloads(parcel.readString());
                parcel1.writeNoException();
                return true;

            case 21: // '\025'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                i = queueSize(parcel.readString());
                parcel1.writeNoException();
                parcel1.writeInt(i);
                return true;

            case 22: // '\026'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                resetCellularDataQuota(parcel.readString());
                parcel1.writeNoException();
                return true;

            case 23: // '\027'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                boolean flag6 = enabled(parcel.readString());
                parcel1.writeNoException();
                i = ((flag) ? 1 : 0);
                if (flag6)
                {
                    i = 1;
                }
                parcel1.writeInt(i);
                return true;

            case 24: // '\030'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                parcel = status(parcel.readString());
                parcel1.writeNoException();
                if (parcel != null)
                {
                    parcel1.writeInt(1);
                    parcel.writeToParcel(parcel1, 1);
                    return true;
                } else
                {
                    parcel1.writeInt(0);
                    return true;
                }

            case 25: // '\031'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                boolean flag7 = powerStatusOK(parcel.readString());
                parcel1.writeNoException();
                i = ((flag1) ? 1 : 0);
                if (flag7)
                {
                    i = 1;
                }
                parcel1.writeInt(i);
                return true;

            case 26: // '\032'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                boolean flag8 = networkStatusOK(parcel.readString());
                parcel1.writeNoException();
                i = ((flag2) ? 1 : 0);
                if (flag8)
                {
                    i = 1;
                }
                parcel1.writeInt(i);
                return true;

            case 27: // '\033'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                boolean flag9 = diskStatusOK(parcel.readString());
                parcel1.writeNoException();
                i = ((flag3) ? 1 : 0);
                if (flag9)
                {
                    i = 1;
                }
                parcel1.writeInt(i);
                return true;

            case 28: // '\034'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                boolean flag10 = cellularDataQuotaOK(parcel.readString());
                parcel1.writeNoException();
                i = ((flag4) ? 1 : 0);
                if (flag10)
                {
                    i = 1;
                }
                parcel1.writeInt(i);
                return true;

            case 29: // '\035'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                double d2 = utilizedCellularDataQuota(parcel.readString());
                parcel1.writeNoException();
                parcel1.writeDouble(d2);
                return true;

            case 30: // '\036'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                long l = quotaRecordingStart(parcel.readString());
                parcel1.writeNoException();
                parcel1.writeLong(l);
                return true;

            case 31: // '\037'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                cleanup(parcel.readString());
                parcel1.writeNoException();
                return true;

            case 32: // ' '
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                double d3 = storageUsed(parcel.readString());
                parcel1.writeNoException();
                parcel1.writeDouble(d3);
                return true;

            case 33: // '!'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                double d4 = totalFileSize(parcel.readString());
                parcel1.writeNoException();
                parcel1.writeDouble(d4);
                return true;

            case 34: // '"'
                parcel.enforceInterface("com.penthera.virtuososdk.interfaces.IVirtuosoService");
                double d5 = allowableStorageRemaining(parcel.readString());
                parcel1.writeNoException();
                parcel1.writeDouble(d5);
                return true;
            }
        }

        public Stub()
        {
            attachInterface(this, "com.penthera.virtuososdk.interfaces.IVirtuosoService");
        }
    }

    private static class Stub.Proxy
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
            s = (IVirtuosoDownloadEngineStatus)IVirtuosoDownloadEngineStatus.CREATOR.createFromParcel(parcel1);
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

        Stub.Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    public abstract double allowableStorageRemaining(String s)
        throws RemoteException;

    public abstract boolean cellularDataQuotaOK(String s)
        throws RemoteException;

    public abstract void cleanup(String s)
        throws RemoteException;

    public abstract void configure(Bundle bundle, int i, int j, String s)
        throws RemoteException;

    public abstract boolean diskStatusOK(String s)
        throws RemoteException;

    public abstract boolean enabled(String s)
        throws RemoteException;

    public abstract double getCurrentThroughput(String s)
        throws RemoteException;

    public abstract double getOverallThroughput(String s)
        throws RemoteException;

    public abstract void markComplete(IVirtuosoIdentifier ivirtuosoidentifier, String s)
        throws RemoteException;

    public abstract void markErrored(IVirtuosoIdentifier ivirtuosoidentifier, int i, String s)
        throws RemoteException;

    public abstract boolean networkStatusOK(String s)
        throws RemoteException;

    public abstract void pauseDownloads(String s)
        throws RemoteException;

    public abstract boolean powerStatusOK(String s)
        throws RemoteException;

    public abstract int queueSize(String s)
        throws RemoteException;

    public abstract long quotaRecordingStart(String s)
        throws RemoteException;

    public abstract void registerDownloadCallbackHandler(IVirtuosoDownloadedCallback ivirtuosodownloadedcallback, String s)
        throws RemoteException;

    public abstract void registerEngineCallbackHandler(IVirtuosoEngineCallback ivirtuosoenginecallback, String s)
        throws RemoteException;

    public abstract void registerQueueCallbackHandler(IVirtuosoDownloadQueueCallback ivirtuosodownloadqueuecallback, String s)
        throws RemoteException;

    public abstract void resetCellularDataQuota(String s)
        throws RemoteException;

    public abstract void resetErrorQueue(String s)
        throws RemoteException;

    public abstract void resetTestSettings(String s)
        throws RemoteException;

    public abstract void resumeDownloads(String s)
        throws RemoteException;

    public abstract void setTestSettings(Bundle bundle, String s)
        throws RemoteException;

    public abstract void signalDelete(String s, IVirtuosoIdentifier ivirtuosoidentifier)
        throws RemoteException;

    public abstract void signalDownloadSettingChange(String s, int i)
        throws RemoteException;

    public abstract void signalExpire(String s, IVirtuosoIdentifier ivirtuosoidentifier)
        throws RemoteException;

    public abstract void signalQueueChange(String s, boolean flag)
        throws RemoteException;

    public abstract IVirtuosoDownloadEngineStatus status(String s)
        throws RemoteException;

    public abstract double storageUsed(String s)
        throws RemoteException;

    public abstract double totalFileSize(String s)
        throws RemoteException;

    public abstract void unregisterDownloadCallbackHandler(IVirtuosoDownloadedCallback ivirtuosodownloadedcallback, String s)
        throws RemoteException;

    public abstract void unregisterEngineCallbackHandler(IVirtuosoEngineCallback ivirtuosoenginecallback, String s)
        throws RemoteException;

    public abstract void unregisterQueueCallbackHandler(IVirtuosoDownloadQueueCallback ivirtuosodownloadqueuecallback, String s)
        throws RemoteException;

    public abstract double utilizedCellularDataQuota(String s)
        throws RemoteException;
}
