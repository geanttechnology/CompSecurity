// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.android.internal.telephony;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.android.internal.telephony:
//            ITelephony

public static abstract class attachInterface extends Binder
    implements ITelephony
{
    private static class Proxy
        implements ITelephony
    {

        private IBinder mRemote;

        public void answerRingingCall()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
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

        public IBinder asBinder()
        {
            return mRemote;
        }

        public boolean endCall()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.android.internal.telephony.ITelephony");
            mRemote.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            i = parcel1.readInt();
            if (i == 0)
            {
                flag = false;
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
            return "com.android.internal.telephony.ITelephony";
        }

        Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    private static final String DESCRIPTOR = "com.android.internal.telephony.ITelephony";
    static final int TRANSACTION_answerRingingCall = 2;
    static final int TRANSACTION_endCall = 1;

    public static ITelephony asInterface(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.telephony.ITelephony");
        if (iinterface != null && (iinterface instanceof ITelephony))
        {
            return (ITelephony)iinterface;
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
            parcel1.writeString("com.android.internal.telephony.ITelephony");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            boolean flag = endCall();
            parcel1.writeNoException();
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel1.writeInt(i);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.android.internal.telephony.ITelephony");
            answerRingingCall();
            parcel1.writeNoException();
            return true;
        }
    }

    public Proxy.mRemote()
    {
        attachInterface(this, "com.android.internal.telephony.ITelephony");
    }
}
