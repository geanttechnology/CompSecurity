// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.service;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IAppWidgetRemoteService
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements IAppWidgetRemoteService
    {

        private static final String DESCRIPTOR = "com.ebay.mobile.service.IAppWidgetRemoteService";
        static final int TRANSACTION_getCurrentEbaySiteId = 2;
        static final int TRANSACTION_getCurrentEbaySiteLogo = 4;
        static final int TRANSACTION_getCurrentEbaySiteSupportsDeals = 5;
        static final int TRANSACTION_getCurrentEbaySiteSupportsSelling = 3;
        static final int TRANSACTION_getUserCounts = 1;

        public static IAppWidgetRemoteService asInterface(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.ebay.mobile.service.IAppWidgetRemoteService");
            if (iinterface != null && (iinterface instanceof IAppWidgetRemoteService))
            {
                return (IAppWidgetRemoteService)iinterface;
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
            boolean flag1 = false;
            boolean flag = false;
            boolean flag3;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.ebay.mobile.service.IAppWidgetRemoteService");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.ebay.mobile.service.IAppWidgetRemoteService");
                parcel = getUserCounts();
                parcel1.writeNoException();
                parcel1.writeIntArray(parcel);
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.ebay.mobile.service.IAppWidgetRemoteService");
                i = getCurrentEbaySiteId();
                parcel1.writeNoException();
                parcel1.writeInt(i);
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.ebay.mobile.service.IAppWidgetRemoteService");
                boolean flag2 = getCurrentEbaySiteSupportsSelling(parcel.readInt());
                parcel1.writeNoException();
                i = ((flag) ? 1 : 0);
                if (flag2)
                {
                    i = 1;
                }
                parcel1.writeInt(i);
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.ebay.mobile.service.IAppWidgetRemoteService");
                parcel = getCurrentEbaySiteLogo(parcel.readInt());
                parcel1.writeNoException();
                if (parcel != null)
                {
                    parcel1.writeInt(1);
                    parcel.writeToParcel(parcel1, 1);
                    return true;
                } else
                {
                    parcel1.writeInt(0);
                    return true;
                }

            case 5: // '\005'
                parcel.enforceInterface("com.ebay.mobile.service.IAppWidgetRemoteService");
                flag3 = getCurrentEbaySiteSupportsDeals(parcel.readInt());
                parcel1.writeNoException();
                i = ((flag1) ? 1 : 0);
                break;
            }
            if (flag3)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;
        }

        public Stub()
        {
            attachInterface(this, "com.ebay.mobile.service.IAppWidgetRemoteService");
        }
    }

    private static class Stub.Proxy
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
            Bitmap bitmap = (Bitmap)Bitmap.CREATOR.createFromParcel(parcel1);
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

        Stub.Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    public abstract int getCurrentEbaySiteId()
        throws RemoteException;

    public abstract Bitmap getCurrentEbaySiteLogo(int i)
        throws RemoteException;

    public abstract boolean getCurrentEbaySiteSupportsDeals(int i)
        throws RemoteException;

    public abstract boolean getCurrentEbaySiteSupportsSelling(int i)
        throws RemoteException;

    public abstract int[] getUserCounts()
        throws RemoteException;
}
