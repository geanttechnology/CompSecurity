// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.amazon.communication:
//            IInputStream

public static abstract class attachInterface extends Binder
    implements IInputStream
{
    private static class Proxy
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

        Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    static final int TRANSACTION_available = 4;
    static final int TRANSACTION_close = 5;
    static final int TRANSACTION_readByte = 3;
    static final int TRANSACTION_readBytes = 1;
    static final int TRANSACTION_readBytesIntoOffset = 2;

    public static IInputStream asInterface(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.amazon.communication.IInputStream");
        if (iinterface != null && (iinterface instanceof IInputStream))
        {
            return (IInputStream)iinterface;
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
        boolean flag;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.amazon.communication.IInputStream");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.amazon.communication.IInputStream");
            parcel = parcel.createByteArray();
            i = readBytes(parcel);
            parcel1.writeNoException();
            parcel1.writeInt(i);
            parcel1.writeByteArray(parcel);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.amazon.communication.IInputStream");
            byte abyte0[] = parcel.createByteArray();
            i = readBytesIntoOffset(abyte0, parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(i);
            parcel1.writeByteArray(abyte0);
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.amazon.communication.IInputStream");
            i = readByte();
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.amazon.communication.IInputStream");
            i = available();
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.amazon.communication.IInputStream");
            flag = close();
            parcel1.writeNoException();
            break;
        }
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel1.writeInt(i);
        return true;
    }

    public Proxy.mRemote()
    {
        attachInterface(this, "com.amazon.communication.IInputStream");
    }
}
