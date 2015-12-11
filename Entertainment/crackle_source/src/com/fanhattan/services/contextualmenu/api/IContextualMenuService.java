// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.contextualmenu.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.fanhattan.services.contextualmenu.api:
//            ContextualMenu, IContextualMenuCallback

public interface IContextualMenuService
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements IContextualMenuService
    {

        private static final String DESCRIPTOR = "com.fanhattan.services.contextualmenu.api.IContextualMenuService";
        static final int TRANSACTION_hideContextualMenu = 4;
        static final int TRANSACTION_invalidateContextualMenu = 3;
        static final int TRANSACTION_registerContextualMenu = 1;
        static final int TRANSACTION_unregisterContextualMenu = 2;

        public static IContextualMenuService asInterface(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.fanhattan.services.contextualmenu.api.IContextualMenuService");
            if (iinterface != null && (iinterface instanceof IContextualMenuService))
            {
                return (IContextualMenuService)iinterface;
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
                parcel1.writeString("com.fanhattan.services.contextualmenu.api.IContextualMenuService");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.fanhattan.services.contextualmenu.api.IContextualMenuService");
                registerContextualMenu(IContextualMenuCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.fanhattan.services.contextualmenu.api.IContextualMenuService");
                unregisterContextualMenu(parcel.readString());
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.fanhattan.services.contextualmenu.api.IContextualMenuService");
                if (parcel.readInt() != 0)
                {
                    parcel = (ContextualMenu)ContextualMenu.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                invalidateContextualMenu(parcel);
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.fanhattan.services.contextualmenu.api.IContextualMenuService");
                hideContextualMenu(parcel.readString());
                parcel1.writeNoException();
                return true;
            }
        }

        public Stub()
        {
            attachInterface(this, "com.fanhattan.services.contextualmenu.api.IContextualMenuService");
        }
    }

    private static class Stub.Proxy
        implements IContextualMenuService
    {

        private IBinder mRemote;

        public IBinder asBinder()
        {
            return mRemote;
        }

        public String getInterfaceDescriptor()
        {
            return "com.fanhattan.services.contextualmenu.api.IContextualMenuService";
        }

        public void hideContextualMenu(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.contextualmenu.api.IContextualMenuService");
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

        public void invalidateContextualMenu(ContextualMenu contextualmenu)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.contextualmenu.api.IContextualMenuService");
            if (contextualmenu == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            contextualmenu.writeToParcel(parcel, 0);
_L1:
            mRemote.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            contextualmenu;
            parcel1.recycle();
            parcel.recycle();
            throw contextualmenu;
        }

        public void registerContextualMenu(IContextualMenuCallback icontextualmenucallback, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.contextualmenu.api.IContextualMenuService");
            if (icontextualmenucallback == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            icontextualmenucallback = icontextualmenucallback.asBinder();
_L1:
            parcel.writeStrongBinder(icontextualmenucallback);
            parcel.writeString(s);
            mRemote.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            icontextualmenucallback = null;
              goto _L1
            icontextualmenucallback;
            parcel1.recycle();
            parcel.recycle();
            throw icontextualmenucallback;
        }

        public void unregisterContextualMenu(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.contextualmenu.api.IContextualMenuService");
            parcel.writeString(s);
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

        Stub.Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    public abstract void hideContextualMenu(String s)
        throws RemoteException;

    public abstract void invalidateContextualMenu(ContextualMenu contextualmenu)
        throws RemoteException;

    public abstract void registerContextualMenu(IContextualMenuCallback icontextualmenucallback, String s)
        throws RemoteException;

    public abstract void unregisterContextualMenu(String s)
        throws RemoteException;
}
