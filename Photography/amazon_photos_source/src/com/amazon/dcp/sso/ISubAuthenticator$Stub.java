// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.sso;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.amazon.dcp.sso:
//            ISubAuthenticator, ISubAuthenticatorResponse, IAmazonAccountAuthenticator

public static abstract class attachInterface extends Binder
    implements ISubAuthenticator
{
    private static class Proxy
        implements ISubAuthenticator
    {

        private IBinder mRemote;

        public IBinder asBinder()
        {
            return mRemote;
        }

        public void getAccountRemovalAllowed(ISubAuthenticatorResponse isubauthenticatorresponse, String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.ISubAuthenticator");
            if (isubauthenticatorresponse == null)
            {
                break MISSING_BLOCK_LABEL_78;
            }
            isubauthenticatorresponse = isubauthenticatorresponse.asBinder();
_L1:
            parcel.writeStrongBinder(isubauthenticatorresponse);
            parcel.writeString(s);
            parcel.writeString(s1);
            mRemote.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            isubauthenticatorresponse = null;
              goto _L1
            isubauthenticatorresponse;
            parcel1.recycle();
            parcel.recycle();
            throw isubauthenticatorresponse;
        }

        public void getAuthToken(ISubAuthenticatorResponse isubauthenticatorresponse, String s, String s1, String s2, Bundle bundle, IAmazonAccountAuthenticator iamazonaccountauthenticator)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            Parcel parcel1;
            obj = null;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.ISubAuthenticator");
            if (isubauthenticatorresponse == null) goto _L2; else goto _L1
_L1:
            isubauthenticatorresponse = isubauthenticatorresponse.asBinder();
_L5:
            parcel.writeStrongBinder(isubauthenticatorresponse);
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeString(s2);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            isubauthenticatorresponse = obj;
            if (iamazonaccountauthenticator == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            isubauthenticatorresponse = iamazonaccountauthenticator.asBinder();
            parcel.writeStrongBinder(isubauthenticatorresponse);
            mRemote.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            isubauthenticatorresponse = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            isubauthenticatorresponse;
            parcel1.recycle();
            parcel.recycle();
            throw isubauthenticatorresponse;
              goto _L5
        }

        public void updateAuthToken(ISubAuthenticatorResponse isubauthenticatorresponse, String s, String s1, String s2, Bundle bundle, IAmazonAccountAuthenticator iamazonaccountauthenticator)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            Parcel parcel1;
            obj = null;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.ISubAuthenticator");
            if (isubauthenticatorresponse == null) goto _L2; else goto _L1
_L1:
            isubauthenticatorresponse = isubauthenticatorresponse.asBinder();
_L5:
            parcel.writeStrongBinder(isubauthenticatorresponse);
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeString(s2);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            isubauthenticatorresponse = obj;
            if (iamazonaccountauthenticator == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            isubauthenticatorresponse = iamazonaccountauthenticator.asBinder();
            parcel.writeStrongBinder(isubauthenticatorresponse);
            mRemote.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            isubauthenticatorresponse = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            isubauthenticatorresponse;
            parcel1.recycle();
            parcel.recycle();
            throw isubauthenticatorresponse;
              goto _L5
        }

        Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    public static ISubAuthenticator asInterface(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.amazon.dcp.sso.ISubAuthenticator");
        if (iinterface != null && (iinterface instanceof ISubAuthenticator))
        {
            return (ISubAuthenticator)iinterface;
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
        ISubAuthenticatorResponse isubauthenticatorresponse1;
        String s1;
        String s3;
        String s5;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.amazon.dcp.sso.ISubAuthenticator");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.amazon.dcp.sso.ISubAuthenticator");
            ISubAuthenticatorResponse isubauthenticatorresponse = se.Stub.asInterface(parcel.readStrongBinder());
            String s = parcel.readString();
            String s2 = parcel.readString();
            String s4 = parcel.readString();
            Bundle bundle;
            if (parcel.readInt() != 0)
            {
                bundle = (Bundle)Bundle.CREATOR.teFromParcel(parcel);
            } else
            {
                bundle = null;
            }
            getAuthToken(isubauthenticatorresponse, s, s2, s4, bundle, ator.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.amazon.dcp.sso.ISubAuthenticator");
            getAccountRemovalAllowed(se.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.amazon.dcp.sso.ISubAuthenticator");
            isubauthenticatorresponse1 = se.Stub.asInterface(parcel.readStrongBinder());
            s1 = parcel.readString();
            s3 = parcel.readString();
            s5 = parcel.readString();
            break;
        }
        Bundle bundle1;
        if (parcel.readInt() != 0)
        {
            bundle1 = (Bundle)Bundle.CREATOR.teFromParcel(parcel);
        } else
        {
            bundle1 = null;
        }
        updateAuthToken(isubauthenticatorresponse1, s1, s3, s5, bundle1, ator.Stub.asInterface(parcel.readStrongBinder()));
        parcel1.writeNoException();
        return true;
    }

    public Proxy.mRemote()
    {
        attachInterface(this, "com.amazon.dcp.sso.ISubAuthenticator");
    }
}
