// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.sso;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.amazon.dcp.sso:
//            ISessionUserChanger, ParcelableAccount

private static class mRemote
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

    (IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
