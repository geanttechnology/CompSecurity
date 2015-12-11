// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.notification.api;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.fanhattan.services.notification.api:
//            INotificationService

private static class mRemote
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

    (IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
