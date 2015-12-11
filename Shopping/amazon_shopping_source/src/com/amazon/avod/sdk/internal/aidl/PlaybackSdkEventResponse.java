// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk.internal.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.amazon.avod.sdk.internal.aidl:
//            PlaybackSdkEventContext

public interface PlaybackSdkEventResponse
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements PlaybackSdkEventResponse
    {

        public static PlaybackSdkEventResponse asInterface(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventResponse");
            if (iinterface != null && (iinterface instanceof PlaybackSdkEventResponse))
            {
                return (PlaybackSdkEventResponse)iinterface;
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
                parcel1.writeString("com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventResponse");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventResponse");
                onStart(PlaybackSdkEventContext.Stub.asInterface(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventResponse");
                onResume(PlaybackSdkEventContext.Stub.asInterface(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventResponse");
                onPause(PlaybackSdkEventContext.Stub.asInterface(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventResponse");
                onStop(PlaybackSdkEventContext.Stub.asInterface(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventResponse");
                onSeekStart(parcel.readLong(), PlaybackSdkEventContext.Stub.asInterface(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventResponse");
                onSeekEnd(PlaybackSdkEventContext.Stub.asInterface(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;
            }
        }

        public Stub()
        {
            attachInterface(this, "com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventResponse");
        }
    }

    private static class Stub.Proxy
        implements PlaybackSdkEventResponse
    {

        private IBinder mRemote;

        public IBinder asBinder()
        {
            return mRemote;
        }

        public void onPause(PlaybackSdkEventContext playbacksdkeventcontext)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventResponse");
            if (playbacksdkeventcontext == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            playbacksdkeventcontext = playbacksdkeventcontext.asBinder();
_L1:
            parcel.writeStrongBinder(playbacksdkeventcontext);
            mRemote.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            playbacksdkeventcontext = null;
              goto _L1
            playbacksdkeventcontext;
            parcel1.recycle();
            parcel.recycle();
            throw playbacksdkeventcontext;
        }

        public void onResume(PlaybackSdkEventContext playbacksdkeventcontext)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventResponse");
            if (playbacksdkeventcontext == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            playbacksdkeventcontext = playbacksdkeventcontext.asBinder();
_L1:
            parcel.writeStrongBinder(playbacksdkeventcontext);
            mRemote.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            playbacksdkeventcontext = null;
              goto _L1
            playbacksdkeventcontext;
            parcel1.recycle();
            parcel.recycle();
            throw playbacksdkeventcontext;
        }

        public void onSeekEnd(PlaybackSdkEventContext playbacksdkeventcontext)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventResponse");
            if (playbacksdkeventcontext == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            playbacksdkeventcontext = playbacksdkeventcontext.asBinder();
_L1:
            parcel.writeStrongBinder(playbacksdkeventcontext);
            mRemote.transact(6, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            playbacksdkeventcontext = null;
              goto _L1
            playbacksdkeventcontext;
            parcel1.recycle();
            parcel.recycle();
            throw playbacksdkeventcontext;
        }

        public void onSeekStart(long l, PlaybackSdkEventContext playbacksdkeventcontext)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventResponse");
            parcel.writeLong(l);
            if (playbacksdkeventcontext == null)
            {
                break MISSING_BLOCK_LABEL_72;
            }
            playbacksdkeventcontext = playbacksdkeventcontext.asBinder();
_L1:
            parcel.writeStrongBinder(playbacksdkeventcontext);
            mRemote.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            playbacksdkeventcontext = null;
              goto _L1
            playbacksdkeventcontext;
            parcel1.recycle();
            parcel.recycle();
            throw playbacksdkeventcontext;
        }

        public void onStart(PlaybackSdkEventContext playbacksdkeventcontext)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventResponse");
            if (playbacksdkeventcontext == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            playbacksdkeventcontext = playbacksdkeventcontext.asBinder();
_L1:
            parcel.writeStrongBinder(playbacksdkeventcontext);
            mRemote.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            playbacksdkeventcontext = null;
              goto _L1
            playbacksdkeventcontext;
            parcel1.recycle();
            parcel.recycle();
            throw playbacksdkeventcontext;
        }

        public void onStop(PlaybackSdkEventContext playbacksdkeventcontext)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventResponse");
            if (playbacksdkeventcontext == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            playbacksdkeventcontext = playbacksdkeventcontext.asBinder();
_L1:
            parcel.writeStrongBinder(playbacksdkeventcontext);
            mRemote.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            playbacksdkeventcontext = null;
              goto _L1
            playbacksdkeventcontext;
            parcel1.recycle();
            parcel.recycle();
            throw playbacksdkeventcontext;
        }

        Stub.Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    public abstract void onPause(PlaybackSdkEventContext playbacksdkeventcontext)
        throws RemoteException;

    public abstract void onResume(PlaybackSdkEventContext playbacksdkeventcontext)
        throws RemoteException;

    public abstract void onSeekEnd(PlaybackSdkEventContext playbacksdkeventcontext)
        throws RemoteException;

    public abstract void onSeekStart(long l, PlaybackSdkEventContext playbacksdkeventcontext)
        throws RemoteException;

    public abstract void onStart(PlaybackSdkEventContext playbacksdkeventcontext)
        throws RemoteException;

    public abstract void onStop(PlaybackSdkEventContext playbacksdkeventcontext)
        throws RemoteException;
}
