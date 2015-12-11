// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.amazon.communication:
//            IInputStream

private static class mRemote
    implements IInputStream
{

    private IBinder mRemote;

    public IBinder asBinder()
    {
        return mRemote;
    }

    public int available()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.amazon.communication.IInputStream");
        mRemote.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public boolean close()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = false;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.amazon.communication.IInputStream");
        mRemote.transact(5, parcel, parcel1, 0);
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

    public String getInterfaceDescriptor()
    {
        return "com.amazon.communication.IInputStream";
    }

    public int readByte()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.amazon.communication.IInputStream");
        mRemote.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public int readBytes(byte abyte0[])
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.amazon.communication.IInputStream");
        parcel.writeByteArray(abyte0);
        mRemote.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        parcel1.readByteArray(abyte0);
        parcel1.recycle();
        parcel.recycle();
        return i;
        abyte0;
        parcel1.recycle();
        parcel.recycle();
        throw abyte0;
    }

    public int readBytesIntoOffset(byte abyte0[], int i, int j)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.amazon.communication.IInputStream");
        parcel.writeByteArray(abyte0);
        parcel.writeInt(i);
        parcel.writeInt(j);
        mRemote.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        parcel1.readByteArray(abyte0);
        parcel1.recycle();
        parcel.recycle();
        return i;
        abyte0;
        parcel1.recycle();
        parcel.recycle();
        throw abyte0;
    }

    (IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
