// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.sso;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ISubAuthenticatorResponse
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements ISubAuthenticatorResponse
    {

        public static ISubAuthenticatorResponse asInterface(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.amazon.dcp.sso.ISubAuthenticatorResponse");
            if (iinterface != null && (iinterface instanceof ISubAuthenticatorResponse))
            {
                return (ISubAuthenticatorResponse)iinterface;
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
                parcel1.writeString("com.amazon.dcp.sso.ISubAuthenticatorResponse");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.amazon.dcp.sso.ISubAuthenticatorResponse");
                onError(parcel.readInt(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.amazon.dcp.sso.ISubAuthenticatorResponse");
                break;
            }
            if (parcel.readInt() != 0)
            {
                parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            onResult(parcel);
            parcel1.writeNoException();
            return true;
        }

        public Stub()
        {
            attachInterface(this, "com.amazon.dcp.sso.ISubAuthenticatorResponse");
        }
    }

    private static class Stub.Proxy
        implements ISubAuthenticatorResponse
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
            parcel.writeInterfaceToken("com.amazon.dcp.sso.ISubAuthenticatorResponse");
            parcel.writeInt(i);
            parcel.writeString(s);
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

        public void onResult(Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.ISubAuthenticatorResponse");
            if (bundle == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L1:
            mRemote.transact(2, parcel, parcel1, 0);
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

        Stub.Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    public abstract void onError(int i, String s)
        throws RemoteException;

    public abstract void onResult(Bundle bundle)
        throws RemoteException;
}
