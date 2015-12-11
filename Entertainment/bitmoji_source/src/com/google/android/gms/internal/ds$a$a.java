// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            ds

private static class ky
    implements ds
{

    private IBinder ky;

    public void R(String s)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        parcel.writeString(s);
        ky.transact(5, parcel, null, 1);
        parcel.recycle();
        return;
        s;
        parcel.recycle();
        throw s;
    }

    public void S(String s)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        parcel.writeString(s);
        ky.transact(11, parcel, null, 1);
        parcel.recycle();
        return;
        s;
        parcel.recycle();
        throw s;
    }

    public void T(String s)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        parcel.writeString(s);
        ky.transact(12, parcel, null, 1);
        parcel.recycle();
        return;
        s;
        parcel.recycle();
        throw s;
    }

    public void a(double d, double d1, boolean flag)
        throws RemoteException
    {
        Parcel parcel;
        int i;
        i = 1;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        parcel.writeDouble(d);
        parcel.writeDouble(d1);
        if (!flag)
        {
            i = 0;
        }
        parcel.writeInt(i);
        ky.transact(7, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public void a(String s, String s1, long l)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        parcel.writeString(s);
        parcel.writeString(s1);
        parcel.writeLong(l);
        ky.transact(9, parcel, null, 1);
        parcel.recycle();
        return;
        s;
        parcel.recycle();
        throw s;
    }

    public void a(String s, byte abyte0[], long l)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        parcel.writeString(s);
        parcel.writeByteArray(abyte0);
        parcel.writeLong(l);
        ky.transact(10, parcel, null, 1);
        parcel.recycle();
        return;
        s;
        parcel.recycle();
        throw s;
    }

    public void a(boolean flag, double d, boolean flag1)
        throws RemoteException
    {
        Parcel parcel;
        boolean flag2;
        flag2 = true;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeDouble(d);
        if (flag1)
        {
            i = ((flag2) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        ky.transact(8, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public IBinder asBinder()
    {
        return ky;
    }

    public void cZ()
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        ky.transact(6, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public void df()
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        ky.transact(4, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public void disconnect()
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        ky.transact(1, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public void e(String s, String s1)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        parcel.writeString(s);
        parcel.writeString(s1);
        ky.transact(3, parcel, null, 1);
        parcel.recycle();
        return;
        s;
        parcel.recycle();
        throw s;
    }

    public void e(String s, boolean flag)
        throws RemoteException
    {
        Parcel parcel;
        int i;
        i = 1;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
        parcel.writeString(s);
        if (!flag)
        {
            i = 0;
        }
        parcel.writeInt(i);
        ky.transact(2, parcel, null, 1);
        parcel.recycle();
        return;
        s;
        parcel.recycle();
        throw s;
    }

    (IBinder ibinder)
    {
        ky = ibinder;
    }
}
