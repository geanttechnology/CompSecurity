// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.service;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.ebay.mobile.service:
//            IAppWidgetRemoteService

private static class mRemote
    implements IAppWidgetRemoteService
{

    private IBinder mRemote;

    public IBinder asBinder()
    {
        return mRemote;
    }

    public int getCurrentEbaySiteId()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.ebay.mobile.service.IAppWidgetRemoteService");
        mRemote.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public Bitmap getCurrentEbaySiteLogo(int i)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.ebay.mobile.service.IAppWidgetRemoteService");
        parcel.writeInt(i);
        mRemote.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        Bitmap bitmap = (Bitmap)Bitmap.CREATOR.(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return bitmap;
_L2:
        bitmap = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public boolean getCurrentEbaySiteSupportsDeals(int i)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = false;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.ebay.mobile.service.IAppWidgetRemoteService");
        parcel.writeInt(i);
        mRemote.transact(5, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i != 0)
        {
            flag = true;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public boolean getCurrentEbaySiteSupportsSelling(int i)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = false;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.ebay.mobile.service.IAppWidgetRemoteService");
        parcel.writeInt(i);
        mRemote.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i != 0)
        {
            flag = true;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public String getInterfaceDescriptor()
    {
        return "com.ebay.mobile.service.IAppWidgetRemoteService";
    }

    public int[] getUserCounts()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int ai[];
        parcel.writeInterfaceToken("com.ebay.mobile.service.IAppWidgetRemoteService");
        mRemote.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        ai = parcel1.createIntArray();
        parcel1.recycle();
        parcel.recycle();
        return ai;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    (IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
