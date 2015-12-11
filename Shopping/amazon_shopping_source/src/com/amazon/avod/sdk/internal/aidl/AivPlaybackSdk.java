// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk.internal.aidl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

// Referenced classes of package com.amazon.avod.sdk.internal.aidl:
//            PlaybackSdkEventResponse

public interface AivPlaybackSdk
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements AivPlaybackSdk
    {

        public static AivPlaybackSdk asInterface(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk");
            if (iinterface != null && (iinterface instanceof AivPlaybackSdk))
            {
                return (AivPlaybackSdk)iinterface;
            } else
            {
                return new Proxy(ibinder);
            }
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            boolean flag1 = false;
            boolean flag = false;
            boolean flag3;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk");
                String s = parcel.readString();
                Bundle bundle;
                if (parcel.readInt() != 0)
                {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                } else
                {
                    bundle = null;
                }
                startPlayback(s, bundle, PlaybackSdkEventResponse.Stub.asInterface(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk");
                terminatePlayback();
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk");
                prepareVideo(parcel.readString());
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk");
                teardownPreparedVideo();
                parcel1.writeNoException();
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk");
                whisperCacheContent(parcel.createStringArrayList(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk");
                boolean flag2 = isPlaybackSupported();
                parcel1.writeNoException();
                i = ((flag) ? 1 : 0);
                if (flag2)
                {
                    i = 1;
                }
                parcel1.writeInt(i);
                return true;

            case 7: // '\007'
                parcel.enforceInterface("com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk");
                flag3 = isPlaybackSustainable();
                parcel1.writeNoException();
                i = ((flag1) ? 1 : 0);
                break;
            }
            if (flag3)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;
        }

        public Stub()
        {
            attachInterface(this, "com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk");
        }
    }

    private static class Stub.Proxy
        implements AivPlaybackSdk
    {

        private IBinder mRemote;

        public IBinder asBinder()
        {
            return mRemote;
        }

        public boolean isPlaybackSupported()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk");
            mRemote.transact(6, parcel, parcel1, 0);
            parcel1.readException();
            i = parcel1.readInt();
            if (i != 0)
            {
                flag = true;
            }
            parcel1.recycle();
            parcel.recycle();
            return flag;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public boolean isPlaybackSustainable()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk");
            mRemote.transact(7, parcel, parcel1, 0);
            parcel1.readException();
            i = parcel1.readInt();
            if (i != 0)
            {
                flag = true;
            }
            parcel1.recycle();
            parcel.recycle();
            return flag;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void prepareVideo(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk");
            parcel.writeString(s);
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

        public void startPlayback(String s, Bundle bundle, PlaybackSdkEventResponse playbacksdkeventresponse)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk");
            parcel.writeString(s);
            if (bundle == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L3:
            if (playbacksdkeventresponse == null)
            {
                break MISSING_BLOCK_LABEL_111;
            }
            s = playbacksdkeventresponse.asBinder();
_L4:
            parcel.writeStrongBinder(s);
            mRemote.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
            s = null;
              goto _L4
        }

        public void teardownPreparedVideo()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk");
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

        public void terminatePlayback()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk");
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

        public void whisperCacheContent(List list, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk");
            parcel.writeStringList(list);
            parcel.writeString(s);
            mRemote.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            list;
            parcel1.recycle();
            parcel.recycle();
            throw list;
        }

        Stub.Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    public abstract boolean isPlaybackSupported()
        throws RemoteException;

    public abstract boolean isPlaybackSustainable()
        throws RemoteException;

    public abstract void prepareVideo(String s)
        throws RemoteException;

    public abstract void startPlayback(String s, Bundle bundle, PlaybackSdkEventResponse playbacksdkeventresponse)
        throws RemoteException;

    public abstract void teardownPreparedVideo()
        throws RemoteException;

    public abstract void terminatePlayback()
        throws RemoteException;

    public abstract void whisperCacheContent(List list, String s)
        throws RemoteException;
}
