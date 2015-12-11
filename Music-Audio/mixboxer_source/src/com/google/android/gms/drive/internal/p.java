// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.StatusCreator;

// Referenced classes of package com.google.android.gms.drive.internal:
//            OnContentsResponse, OnDownloadProgressResponse, OnDriveIdResponse, OnListEntriesResponse, 
//            OnMetadataResponse

public interface p
    extends IInterface
{
    public static abstract class a extends Binder
        implements p
    {

        public static p D(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            if (iinterface != null && (iinterface instanceof p))
            {
                return (p)iinterface;
            } else
            {
                return new a(ibinder);
            }
        }

        public IBinder asBinder()
        {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            Object obj = null;
            Object obj1 = null;
            Object obj2 = null;
            Object obj3 = null;
            Object obj4 = null;
            OnDownloadProgressResponse ondownloadprogressresponse = null;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                if (parcel.readInt() != 0)
                {
                    ondownloadprogressresponse = (OnDownloadProgressResponse)OnDownloadProgressResponse.CREATOR.createFromParcel(parcel);
                }
                a(ondownloadprogressresponse);
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                OnListEntriesResponse onlistentriesresponse = obj;
                if (parcel.readInt() != 0)
                {
                    onlistentriesresponse = (OnListEntriesResponse)OnListEntriesResponse.CREATOR.createFromParcel(parcel);
                }
                a(onlistentriesresponse);
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                OnDriveIdResponse ondriveidresponse = obj1;
                if (parcel.readInt() != 0)
                {
                    ondriveidresponse = (OnDriveIdResponse)OnDriveIdResponse.CREATOR.createFromParcel(parcel);
                }
                a(ondriveidresponse);
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                OnMetadataResponse onmetadataresponse = obj2;
                if (parcel.readInt() != 0)
                {
                    onmetadataresponse = (OnMetadataResponse)OnMetadataResponse.CREATOR.createFromParcel(parcel);
                }
                a(onmetadataresponse);
                parcel1.writeNoException();
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                OnContentsResponse oncontentsresponse = obj3;
                if (parcel.readInt() != 0)
                {
                    oncontentsresponse = (OnContentsResponse)OnContentsResponse.CREATOR.createFromParcel(parcel);
                }
                a(oncontentsresponse);
                parcel1.writeNoException();
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                Status status = obj4;
                if (parcel.readInt() != 0)
                {
                    status = Status.CREATOR.createFromParcel(parcel);
                }
                m(status);
                parcel1.writeNoException();
                return true;

            case 7: // '\007'
                parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                onSuccess();
                parcel1.writeNoException();
                return true;
            }
        }

        public a()
        {
            attachInterface(this, "com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        }
    }

    private static class a.a
        implements p
    {

        private IBinder dU;

        public void a(OnContentsResponse oncontentsresponse)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            if (oncontentsresponse == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            oncontentsresponse.writeToParcel(parcel, 0);
_L1:
            dU.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            oncontentsresponse;
            parcel1.recycle();
            parcel.recycle();
            throw oncontentsresponse;
        }

        public void a(OnDownloadProgressResponse ondownloadprogressresponse)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            if (ondownloadprogressresponse == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            ondownloadprogressresponse.writeToParcel(parcel, 0);
_L1:
            dU.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            ondownloadprogressresponse;
            parcel1.recycle();
            parcel.recycle();
            throw ondownloadprogressresponse;
        }

        public void a(OnDriveIdResponse ondriveidresponse)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            if (ondriveidresponse == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            ondriveidresponse.writeToParcel(parcel, 0);
_L1:
            dU.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            ondriveidresponse;
            parcel1.recycle();
            parcel.recycle();
            throw ondriveidresponse;
        }

        public void a(OnListEntriesResponse onlistentriesresponse)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            if (onlistentriesresponse == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            onlistentriesresponse.writeToParcel(parcel, 0);
_L1:
            dU.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            onlistentriesresponse;
            parcel1.recycle();
            parcel.recycle();
            throw onlistentriesresponse;
        }

        public void a(OnMetadataResponse onmetadataresponse)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            if (onmetadataresponse == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            onmetadataresponse.writeToParcel(parcel, 0);
_L1:
            dU.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            onmetadataresponse;
            parcel1.recycle();
            parcel.recycle();
            throw onmetadataresponse;
        }

        public IBinder asBinder()
        {
            return dU;
        }

        public void m(Status status)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            if (status == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            parcel.writeInt(1);
            status.writeToParcel(parcel, 0);
_L1:
            dU.transact(6, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            status;
            parcel1.recycle();
            parcel.recycle();
            throw status;
        }

        public void onSuccess()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            dU.transact(7, parcel, parcel1, 0);
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

        a.a(IBinder ibinder)
        {
            dU = ibinder;
        }
    }


    public abstract void a(OnContentsResponse oncontentsresponse)
        throws RemoteException;

    public abstract void a(OnDownloadProgressResponse ondownloadprogressresponse)
        throws RemoteException;

    public abstract void a(OnDriveIdResponse ondriveidresponse)
        throws RemoteException;

    public abstract void a(OnListEntriesResponse onlistentriesresponse)
        throws RemoteException;

    public abstract void a(OnMetadataResponse onmetadataresponse)
        throws RemoteException;

    public abstract void m(Status status)
        throws RemoteException;

    public abstract void onSuccess()
        throws RemoteException;
}
