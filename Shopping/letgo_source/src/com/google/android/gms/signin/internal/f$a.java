// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.u;

// Referenced classes of package com.google.android.gms.signin.internal:
//            f, CheckServerAuthResult, RecordConsentRequest, e

public static abstract class a.a extends Binder
    implements f
{
    private static class a
        implements f
    {

        private IBinder a;

        public void a(int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            parcel.writeInt(i);
            a.transact(7, parcel, parcel1, 0);
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

        public void a(int i, Account account, e e1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            parcel.writeInt(i);
            if (account == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            account.writeToParcel(parcel, 0);
_L3:
            if (e1 == null)
            {
                break MISSING_BLOCK_LABEL_112;
            }
            account = e1.asBinder();
_L4:
            parcel.writeStrongBinder(account);
            a.transact(8, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            account;
            parcel1.recycle();
            parcel.recycle();
            throw account;
            account = null;
              goto _L4
        }

        public void a(AuthAccountRequest authaccountrequest, e e1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (authaccountrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            authaccountrequest.writeToParcel(parcel, 0);
_L3:
            if (e1 == null)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            authaccountrequest = e1.asBinder();
_L4:
            parcel.writeStrongBinder(authaccountrequest);
            a.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            authaccountrequest;
            parcel1.recycle();
            parcel.recycle();
            throw authaccountrequest;
            authaccountrequest = null;
              goto _L4
        }

        public void a(ResolveAccountRequest resolveaccountrequest, u u1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (resolveaccountrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            resolveaccountrequest.writeToParcel(parcel, 0);
_L3:
            if (u1 == null)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            resolveaccountrequest = u1.asBinder();
_L4:
            parcel.writeStrongBinder(resolveaccountrequest);
            a.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            resolveaccountrequest;
            parcel1.recycle();
            parcel.recycle();
            throw resolveaccountrequest;
            resolveaccountrequest = null;
              goto _L4
        }

        public void a(q q1, int i, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (q1 == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            q1 = q1.asBinder();
_L1:
            parcel.writeStrongBinder(q1);
            parcel.writeInt(i);
            i = ((flag1) ? 1 : 0);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            a.transact(9, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            q1 = null;
              goto _L1
            q1;
            parcel1.recycle();
            parcel.recycle();
            throw q1;
        }

        public void a(CheckServerAuthResult checkserverauthresult)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (checkserverauthresult == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            checkserverauthresult.writeToParcel(parcel, 0);
_L1:
            a.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            checkserverauthresult;
            parcel1.recycle();
            parcel.recycle();
            throw checkserverauthresult;
        }

        public void a(RecordConsentRequest recordconsentrequest, e e1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (recordconsentrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            recordconsentrequest.writeToParcel(parcel, 0);
_L3:
            if (e1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            recordconsentrequest = e1.asBinder();
_L4:
            parcel.writeStrongBinder(recordconsentrequest);
            a.transact(10, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            recordconsentrequest;
            parcel1.recycle();
            parcel.recycle();
            throw recordconsentrequest;
            recordconsentrequest = null;
              goto _L4
        }

        public void a(e e1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (e1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            e1 = e1.asBinder();
_L1:
            parcel.writeStrongBinder(e1);
            a.transact(11, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            e1 = null;
              goto _L1
            e1;
            parcel1.recycle();
            parcel.recycle();
            throw e1;
        }

        public void a(boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            a.transact(4, parcel, parcel1, 0);
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
            return a;
        }

        a(IBinder ibinder)
        {
            a = ibinder;
        }
    }


    public static f a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (iinterface != null && (iinterface instanceof f))
        {
            return (f)iinterface;
        } else
        {
            return new a(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        throws RemoteException
    {
        boolean flag = false;
        Object obj = null;
        Object obj1 = null;
        Object obj2 = null;
        Object obj3 = null;
        AuthAccountRequest authaccountrequest = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.signin.internal.ISignInService");
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            if (parcel.readInt() != 0)
            {
                authaccountrequest = (AuthAccountRequest)AuthAccountRequest.CREATOR.createFromParcel(parcel);
            }
            a(authaccountrequest, a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            CheckServerAuthResult checkserverauthresult = obj;
            if (parcel.readInt() != 0)
            {
                checkserverauthresult = (CheckServerAuthResult)CheckServerAuthResult.CREATOR.createFromParcel(parcel);
            }
            a(checkserverauthresult);
            parcel1.writeNoException();
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            if (parcel.readInt() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            a(flag);
            parcel1.writeNoException();
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            ResolveAccountRequest resolveaccountrequest = obj1;
            if (parcel.readInt() != 0)
            {
                resolveaccountrequest = (ResolveAccountRequest)ResolveAccountRequest.CREATOR.createFromParcel(parcel);
            }
            a(resolveaccountrequest, com.google.android.gms.common.internal.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 7: // '\007'
            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            a(parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 8: // '\b'
            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            i = parcel.readInt();
            Account account = obj2;
            if (parcel.readInt() != 0)
            {
                account = (Account)Account.CREATOR.createFromParcel(parcel);
            }
            a(i, account, a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 9: // '\t'
            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            q q = com.google.android.gms.common.internal.a(parcel.readStrongBinder());
            i = parcel.readInt();
            if (parcel.readInt() != 0)
            {
                flag = true;
            }
            a(q, i, flag);
            parcel1.writeNoException();
            return true;

        case 10: // '\n'
            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            RecordConsentRequest recordconsentrequest = obj3;
            if (parcel.readInt() != 0)
            {
                recordconsentrequest = (RecordConsentRequest)RecordConsentRequest.CREATOR.createFromParcel(parcel);
            }
            a(recordconsentrequest, a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 11: // '\013'
            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
            a(a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;
        }
    }
}
