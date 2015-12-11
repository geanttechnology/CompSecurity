// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.notification.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.fanhattan.services.notification.api:
//            INotificationService

public static abstract class attachInterface extends Binder
    implements INotificationService
{
    private static class Proxy
        implements INotificationService
    {

        private IBinder mRemote;

        public IBinder asBinder()
        {
            return mRemote;
        }

        public String getInterfaceDescriptor()
        {
            return "com.fanhattan.services.notification.api.INotificationService";
        }

        public void showNotification(String s, String s1, int i, long l)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.notification.api.INotificationService");
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeInt(i);
            parcel.writeLong(l);
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

        public void showNotificationImageResource(String s, int i, String s1, int j, long l)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.notification.api.INotificationService");
            parcel.writeString(s);
            parcel.writeInt(i);
            parcel.writeString(s1);
            parcel.writeInt(j);
            parcel.writeLong(l);
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

        public void showNotificationImageUrl(String s, String s1, String s2, int i, long l)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.notification.api.INotificationService");
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeString(s2);
            parcel.writeInt(i);
            parcel.writeLong(l);
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

        Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    private static final String DESCRIPTOR = "com.fanhattan.services.notification.api.INotificationService";
    static final int TRANSACTION_showNotification = 3;
    static final int TRANSACTION_showNotificationImageResource = 2;
    static final int TRANSACTION_showNotificationImageUrl = 1;

    public static INotificationService asInterface(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.fanhattan.services.notification.api.INotificationService");
        if (iinterface != null && (iinterface instanceof INotificationService))
        {
            return (INotificationService)iinterface;
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
            parcel1.writeString("com.fanhattan.services.notification.api.INotificationService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.fanhattan.services.notification.api.INotificationService");
            showNotificationImageUrl(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readLong());
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.fanhattan.services.notification.api.INotificationService");
            showNotificationImageResource(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readLong());
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.fanhattan.services.notification.api.INotificationService");
            showNotification(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readLong());
            parcel1.writeNoException();
            return true;
        }
    }

    public Proxy.mRemote()
    {
        attachInterface(this, "com.fanhattan.services.notification.api.INotificationService");
    }
}
