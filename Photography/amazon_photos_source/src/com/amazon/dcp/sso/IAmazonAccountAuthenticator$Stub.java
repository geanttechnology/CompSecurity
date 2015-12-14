// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.sso;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

// Referenced classes of package com.amazon.dcp.sso:
//            IAmazonAccountAuthenticator, IWebserviceCallback

public static abstract class Proxy.mRemote extends Binder
    implements IAmazonAccountAuthenticator
{
    private static class Proxy
        implements IAmazonAccountAuthenticator
    {

        private IBinder mRemote;

        public IBinder asBinder()
        {
            return mRemote;
        }

        public void callGetCredentialsWebservice(Uri uri, String s, Map map, byte abyte0[], IWebserviceCallback iwebservicecallback)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.IAmazonAccountAuthenticator");
            if (uri == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            uri.writeToParcel(parcel, 0);
_L3:
            parcel.writeString(s);
            parcel.writeMap(map);
            parcel.writeByteArray(abyte0);
            if (iwebservicecallback == null)
            {
                break MISSING_BLOCK_LABEL_126;
            }
            uri = iwebservicecallback.asBinder();
_L4:
            parcel.writeStrongBinder(uri);
            mRemote.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            uri;
            parcel1.recycle();
            parcel.recycle();
            throw uri;
            uri = null;
              goto _L4
        }

        public void invalidateAuthToken(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.IAmazonAccountAuthenticator");
            parcel.writeString(s);
            mRemote.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void invalidateAuthTokenByTokenType(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.IAmazonAccountAuthenticator");
            parcel.writeString(s);
            mRemote.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public String peekAuthToken(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.IAmazonAccountAuthenticator");
            parcel.writeString(s);
            mRemote.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            s = parcel1.readString();
            parcel1.recycle();
            parcel.recycle();
            return s;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void storeToken(String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.IAmazonAccountAuthenticator");
            parcel.writeString(s);
            parcel.writeString(s1);
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

        Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    public static IAmazonAccountAuthenticator asInterface(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.amazon.dcp.sso.IAmazonAccountAuthenticator");
        if (iinterface != null && (iinterface instanceof IAmazonAccountAuthenticator))
        {
            return (IAmazonAccountAuthenticator)iinterface;
        } else
        {
            return new Proxy(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        throws RemoteException
    {
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.amazon.dcp.sso.IAmazonAccountAuthenticator");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.amazon.dcp.sso.IAmazonAccountAuthenticator");
            Uri uri;
            if (parcel.readInt() != 0)
            {
                uri = (Uri)Uri.CREATOR.el(parcel);
            } else
            {
                uri = null;
            }
            callGetCredentialsWebservice(uri, parcel.readString(), parcel.readHashMap(getClass().getClassLoader()), parcel.createByteArray(), ace(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.amazon.dcp.sso.IAmazonAccountAuthenticator");
            storeToken(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.amazon.dcp.sso.IAmazonAccountAuthenticator");
            parcel = peekAuthToken(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeString(parcel);
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.amazon.dcp.sso.IAmazonAccountAuthenticator");
            invalidateAuthToken(parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.amazon.dcp.sso.IAmazonAccountAuthenticator");
            invalidateAuthTokenByTokenType(parcel.readString());
            parcel1.writeNoException();
            return true;
        }
    }
}
