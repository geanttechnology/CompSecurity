// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.sso;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.amazon.dcp.sso:
//            ISessionUserChanger, ParcelableAccount

public static abstract class attachInterface extends Binder
    implements ISessionUserChanger
{
    private static class Proxy
        implements ISessionUserChanger
    {

        private IBinder mRemote;

        public String[] addSessionUserDirectedIds(String as[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.ISessionUserChanger");
            parcel.writeStringArray(as);
            mRemote.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            as = parcel1.createStringArray();
            parcel1.recycle();
            parcel.recycle();
            return as;
            as;
            parcel1.recycle();
            parcel.recycle();
            throw as;
        }

        public ParcelableAccount[] addSessionUsers(ParcelableAccount aparcelableaccount[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.ISessionUserChanger");
            parcel.writeTypedArray(aparcelableaccount, 0);
            mRemote.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            aparcelableaccount = (ParcelableAccount[])parcel1.createTypedArray(ParcelableAccount.CREATOR);
            parcel1.recycle();
            parcel.recycle();
            return aparcelableaccount;
            aparcelableaccount;
            parcel1.recycle();
            parcel.recycle();
            throw aparcelableaccount;
        }

        public IBinder asBinder()
        {
            return mRemote;
        }

        public String[] changeSessionUserDirectedIds(String as[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.ISessionUserChanger");
            parcel.writeStringArray(as);
            mRemote.transact(6, parcel, parcel1, 0);
            parcel1.readException();
            as = parcel1.createStringArray();
            parcel1.recycle();
            parcel.recycle();
            return as;
            as;
            parcel1.recycle();
            parcel.recycle();
            throw as;
        }

        public ParcelableAccount[] changeSessionUsers(ParcelableAccount aparcelableaccount[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.ISessionUserChanger");
            parcel.writeTypedArray(aparcelableaccount, 0);
            mRemote.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            aparcelableaccount = (ParcelableAccount[])parcel1.createTypedArray(ParcelableAccount.CREATOR);
            parcel1.recycle();
            parcel.recycle();
            return aparcelableaccount;
            aparcelableaccount;
            parcel1.recycle();
            parcel.recycle();
            throw aparcelableaccount;
        }

        public String getInterfaceDescriptor()
        {
            return "com.amazon.dcp.sso.ISessionUserChanger";
        }

        public String[] removeSessionUserDirectedIds(String as[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.ISessionUserChanger");
            parcel.writeStringArray(as);
            mRemote.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            as = parcel1.createStringArray();
            parcel1.recycle();
            parcel.recycle();
            return as;
            as;
            parcel1.recycle();
            parcel.recycle();
            throw as;
        }

        public ParcelableAccount[] removeSessionUsers(ParcelableAccount aparcelableaccount[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.ISessionUserChanger");
            parcel.writeTypedArray(aparcelableaccount, 0);
            mRemote.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            aparcelableaccount = (ParcelableAccount[])parcel1.createTypedArray(ParcelableAccount.CREATOR);
            parcel1.recycle();
            parcel.recycle();
            return aparcelableaccount;
            aparcelableaccount;
            parcel1.recycle();
            parcel.recycle();
            throw aparcelableaccount;
        }

        Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    static final int TRANSACTION_addSessionUserDirectedIds = 4;
    static final int TRANSACTION_addSessionUsers = 1;
    static final int TRANSACTION_changeSessionUserDirectedIds = 6;
    static final int TRANSACTION_changeSessionUsers = 3;
    static final int TRANSACTION_removeSessionUserDirectedIds = 5;
    static final int TRANSACTION_removeSessionUsers = 2;

    public static ISessionUserChanger asInterface(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.amazon.dcp.sso.ISessionUserChanger");
        if (iinterface != null && (iinterface instanceof ISessionUserChanger))
        {
            return (ISessionUserChanger)iinterface;
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
            parcel1.writeString("com.amazon.dcp.sso.ISessionUserChanger");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.amazon.dcp.sso.ISessionUserChanger");
            parcel = addSessionUsers((ParcelableAccount[])parcel.createTypedArray(ParcelableAccount.CREATOR));
            parcel1.writeNoException();
            parcel1.writeTypedArray(parcel, 1);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.amazon.dcp.sso.ISessionUserChanger");
            parcel = removeSessionUsers((ParcelableAccount[])parcel.createTypedArray(ParcelableAccount.CREATOR));
            parcel1.writeNoException();
            parcel1.writeTypedArray(parcel, 1);
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.amazon.dcp.sso.ISessionUserChanger");
            parcel = changeSessionUsers((ParcelableAccount[])parcel.createTypedArray(ParcelableAccount.CREATOR));
            parcel1.writeNoException();
            parcel1.writeTypedArray(parcel, 1);
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.amazon.dcp.sso.ISessionUserChanger");
            parcel = addSessionUserDirectedIds(parcel.createStringArray());
            parcel1.writeNoException();
            parcel1.writeStringArray(parcel);
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.amazon.dcp.sso.ISessionUserChanger");
            parcel = removeSessionUserDirectedIds(parcel.createStringArray());
            parcel1.writeNoException();
            parcel1.writeStringArray(parcel);
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.amazon.dcp.sso.ISessionUserChanger");
            parcel = changeSessionUserDirectedIds(parcel.createStringArray());
            parcel1.writeNoException();
            parcel1.writeStringArray(parcel);
            return true;
        }
    }

    public Proxy.mRemote()
    {
        attachInterface(this, "com.amazon.dcp.sso.ISessionUserChanger");
    }
}
