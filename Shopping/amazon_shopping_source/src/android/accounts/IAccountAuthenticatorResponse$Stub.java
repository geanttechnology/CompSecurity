// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.accounts;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package android.accounts:
//            IAccountAuthenticatorResponse

public static abstract class attachInterface extends Binder
    implements IAccountAuthenticatorResponse
{
    private static class Proxy
        implements IAccountAuthenticatorResponse
    {

        private IBinder mRemote;

        public IBinder asBinder()
        {
            return mRemote;
        }

        public void onError(int i, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("android.accounts.IAccountAuthenticatorResponse");
            parcel.writeInt(i);
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

        public void onRequestContinued()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("android.accounts.IAccountAuthenticatorResponse");
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

        public void onResult(Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("android.accounts.IAccountAuthenticatorResponse");
            if (bundle == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L1:
            mRemote.transact(1, parcel, parcel1, 0);
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

        Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    static final int TRANSACTION_onError = 3;
    static final int TRANSACTION_onRequestContinued = 2;
    static final int TRANSACTION_onResult = 1;

    public static IAccountAuthenticatorResponse asInterface(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("android.accounts.IAccountAuthenticatorResponse");
        if (iinterface != null && (iinterface instanceof IAccountAuthenticatorResponse))
        {
            return (IAccountAuthenticatorResponse)iinterface;
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
            parcel1.writeString("android.accounts.IAccountAuthenticatorResponse");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("android.accounts.IAccountAuthenticatorResponse");
            if (parcel.readInt() != 0)
            {
                parcel = (Bundle)Bundle.CREATOR.(parcel);
            } else
            {
                parcel = null;
            }
            onResult(parcel);
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("android.accounts.IAccountAuthenticatorResponse");
            onRequestContinued();
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("android.accounts.IAccountAuthenticatorResponse");
            onError(parcel.readInt(), parcel.readString());
            parcel1.writeNoException();
            return true;
        }
    }

    public Proxy.mRemote()
    {
        attachInterface(this, "android.accounts.IAccountAuthenticatorResponse");
    }
}
