// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.sso;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

// Referenced classes of package com.amazon.dcp.sso:
//            ReturnValueOrError

public interface IRequestAuthenticationMethod
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements IRequestAuthenticationMethod
    {

        public static IRequestAuthenticationMethod asInterface(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.amazon.dcp.sso.IRequestAuthenticationMethod");
            if (iinterface != null && (iinterface instanceof IRequestAuthenticationMethod))
            {
                return (IRequestAuthenticationMethod)iinterface;
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
                parcel1.writeString("com.amazon.dcp.sso.IRequestAuthenticationMethod");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.amazon.dcp.sso.IRequestAuthenticationMethod");
                String s = parcel.readString();
                String s2 = parcel.readString();
                String s4 = parcel.readString();
                Uri uri;
                if (parcel.readInt() != 0)
                {
                    uri = (Uri)Uri.CREATOR.createFromParcel(parcel);
                } else
                {
                    uri = null;
                }
                parcel = getAuthenticationParametersForRequest(s, s2, s4, uri, parcel.readString(), parcel.readHashMap(getClass().getClassLoader()), parcel.createByteArray());
                parcel1.writeNoException();
                if (parcel != null)
                {
                    parcel1.writeInt(1);
                    parcel.writeToParcel(parcel1, 1);
                } else
                {
                    parcel1.writeInt(0);
                }
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.amazon.dcp.sso.IRequestAuthenticationMethod");
                parcel = signCorpus(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray());
                parcel1.writeNoException();
                if (parcel != null)
                {
                    parcel1.writeInt(1);
                    parcel.writeToParcel(parcel1, 1);
                } else
                {
                    parcel1.writeInt(0);
                }
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.amazon.dcp.sso.IRequestAuthenticationMethod");
                parcel = getAdpToken(parcel.readString(), parcel.readString());
                parcel1.writeNoException();
                parcel1.writeString(parcel);
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.amazon.dcp.sso.IRequestAuthenticationMethod");
                String s1 = parcel.readString();
                String s3 = parcel.readString();
                Uri uri1;
                if (parcel.readInt() != 0)
                {
                    uri1 = (Uri)Uri.CREATOR.createFromParcel(parcel);
                } else
                {
                    uri1 = null;
                }
                parcel = getAuthenticationParametersForRequestByDirectedId(s1, s3, uri1, parcel.readString(), parcel.readHashMap(getClass().getClassLoader()), parcel.createByteArray());
                parcel1.writeNoException();
                if (parcel != null)
                {
                    parcel1.writeInt(1);
                    parcel.writeToParcel(parcel1, 1);
                } else
                {
                    parcel1.writeInt(0);
                }
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.amazon.dcp.sso.IRequestAuthenticationMethod");
                parcel = signCorpusByDirectedId(parcel.readString(), parcel.readString(), parcel.createByteArray());
                parcel1.writeNoException();
                if (parcel != null)
                {
                    parcel1.writeInt(1);
                    parcel.writeToParcel(parcel1, 1);
                } else
                {
                    parcel1.writeInt(0);
                }
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.amazon.dcp.sso.IRequestAuthenticationMethod");
                parcel = getAdpTokenByDirectedId(parcel.readString());
                parcel1.writeNoException();
                parcel1.writeString(parcel);
                return true;
            }
        }

        public Stub()
        {
            attachInterface(this, "com.amazon.dcp.sso.IRequestAuthenticationMethod");
        }
    }

    private static class Stub.Proxy
        implements IRequestAuthenticationMethod
    {

        private IBinder mRemote;

        public IBinder asBinder()
        {
            return mRemote;
        }

        public String getAdpToken(String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.IRequestAuthenticationMethod");
            parcel.writeString(s);
            parcel.writeString(s1);
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

        public String getAdpTokenByDirectedId(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.IRequestAuthenticationMethod");
            parcel.writeString(s);
            mRemote.transact(6, parcel, parcel1, 0);
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

        public ReturnValueOrError getAuthenticationParametersForRequest(String s, String s1, String s2, Uri uri, String s3, Map map, byte abyte0[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.IRequestAuthenticationMethod");
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeString(s2);
            if (uri == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            uri.writeToParcel(parcel, 0);
_L3:
            parcel.writeString(s3);
            parcel.writeMap(map);
            parcel.writeByteArray(abyte0);
            mRemote.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0)
            {
                break MISSING_BLOCK_LABEL_152;
            }
            s = (ReturnValueOrError)ReturnValueOrError.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return s;
_L2:
            parcel.writeInt(0);
              goto _L3
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
            s = null;
              goto _L4
        }

        public ReturnValueOrError getAuthenticationParametersForRequestByDirectedId(String s, String s1, Uri uri, String s2, Map map, byte abyte0[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.IRequestAuthenticationMethod");
            parcel.writeString(s);
            parcel.writeString(s1);
            if (uri == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            uri.writeToParcel(parcel, 0);
_L3:
            parcel.writeString(s2);
            parcel.writeMap(map);
            parcel.writeByteArray(abyte0);
            mRemote.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0)
            {
                break MISSING_BLOCK_LABEL_144;
            }
            s = (ReturnValueOrError)ReturnValueOrError.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return s;
_L2:
            parcel.writeInt(0);
              goto _L3
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
            s = null;
              goto _L4
        }

        public ReturnValueOrError signCorpus(String s, String s1, String s2, byte abyte0[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.IRequestAuthenticationMethod");
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeString(s2);
            parcel.writeByteArray(abyte0);
            mRemote.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            s = (ReturnValueOrError)ReturnValueOrError.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return s;
_L2:
            s = null;
            if (true) goto _L4; else goto _L3
_L3:
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public ReturnValueOrError signCorpusByDirectedId(String s, String s1, byte abyte0[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.IRequestAuthenticationMethod");
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeByteArray(abyte0);
            mRemote.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            s = (ReturnValueOrError)ReturnValueOrError.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return s;
_L2:
            s = null;
            if (true) goto _L4; else goto _L3
_L3:
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        Stub.Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    public abstract String getAdpToken(String s, String s1)
        throws RemoteException;

    public abstract String getAdpTokenByDirectedId(String s)
        throws RemoteException;

    public abstract ReturnValueOrError getAuthenticationParametersForRequest(String s, String s1, String s2, Uri uri, String s3, Map map, byte abyte0[])
        throws RemoteException;

    public abstract ReturnValueOrError getAuthenticationParametersForRequestByDirectedId(String s, String s1, Uri uri, String s2, Map map, byte abyte0[])
        throws RemoteException;

    public abstract ReturnValueOrError signCorpus(String s, String s1, String s2, byte abyte0[])
        throws RemoteException;

    public abstract ReturnValueOrError signCorpusByDirectedId(String s, String s1, byte abyte0[])
        throws RemoteException;
}
