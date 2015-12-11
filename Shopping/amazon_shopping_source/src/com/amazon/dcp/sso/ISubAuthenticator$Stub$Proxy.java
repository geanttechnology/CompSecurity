// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.sso;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.amazon.dcp.sso:
//            ISubAuthenticator, ISubAuthenticatorResponse, IAmazonAccountAuthenticator

private static class mRemote
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

    (IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
