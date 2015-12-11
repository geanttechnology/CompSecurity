// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.sso;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

// Referenced classes of package com.amazon.dcp.sso:
//            IRequestAuthenticationMethod, ReturnValueOrError

private static class mRemote
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
        s = (ReturnValueOrError)ReturnValueOrError.CREATOR.mRemote(parcel1);
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
        s = (ReturnValueOrError)ReturnValueOrError.CREATOR.mRemote(parcel1);
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
        s = (ReturnValueOrError)ReturnValueOrError.CREATOR.mRemote(parcel1);
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
        s = (ReturnValueOrError)ReturnValueOrError.CREATOR.mRemote(parcel1);
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

    (IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
