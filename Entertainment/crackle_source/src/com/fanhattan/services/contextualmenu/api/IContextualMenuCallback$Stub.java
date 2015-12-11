// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.contextualmenu.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.fanhattan.services.contextualmenu.api:
//            IContextualMenuCallback, ContextualMenu

public static abstract class attachInterface extends Binder
    implements IContextualMenuCallback
{
    private static class Proxy
        implements IContextualMenuCallback
    {

        private IBinder mRemote;

        public IBinder asBinder()
        {
            return mRemote;
        }

        public String getInterfaceDescriptor()
        {
            return "com.fanhattan.services.contextualmenu.api.IContextualMenuCallback";
        }

        public void onCloseContextualMenu()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.contextualmenu.api.IContextualMenuCallback");
            mRemote.transact(3, parcel, parcel1, 0);
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

        public boolean onContextualMenuSelected(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.fanhattan.services.contextualmenu.api.IContextualMenuCallback");
            parcel.writeString(s);
            mRemote.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            i = parcel1.readInt();
            if (i != 0)
            {
                flag = true;
            }
            parcel1.recycle();
            parcel.recycle();
            return flag;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public ContextualMenu onCreateContextualMenu()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.contextualmenu.api.IContextualMenuCallback");
            mRemote.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            ContextualMenu contextualmenu = (ContextualMenu)ContextualMenu.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return contextualmenu;
_L2:
            contextualmenu = null;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    private static final String DESCRIPTOR = "com.fanhattan.services.contextualmenu.api.IContextualMenuCallback";
    static final int TRANSACTION_onCloseContextualMenu = 3;
    static final int TRANSACTION_onContextualMenuSelected = 2;
    static final int TRANSACTION_onCreateContextualMenu = 1;

    public static IContextualMenuCallback asInterface(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.fanhattan.services.contextualmenu.api.IContextualMenuCallback");
        if (iinterface != null && (iinterface instanceof IContextualMenuCallback))
        {
            return (IContextualMenuCallback)iinterface;
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
        boolean flag = false;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.fanhattan.services.contextualmenu.api.IContextualMenuCallback");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.fanhattan.services.contextualmenu.api.IContextualMenuCallback");
            parcel = onCreateContextualMenu();
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

        case 2: // '\002'
            parcel.enforceInterface("com.fanhattan.services.contextualmenu.api.IContextualMenuCallback");
            boolean flag1 = onContextualMenuSelected(parcel.readString());
            parcel1.writeNoException();
            i = ((flag) ? 1 : 0);
            if (flag1)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.fanhattan.services.contextualmenu.api.IContextualMenuCallback");
            onCloseContextualMenu();
            parcel1.writeNoException();
            return true;
        }
    }

    public Proxy.mRemote()
    {
        attachInterface(this, "com.fanhattan.services.contextualmenu.api.IContextualMenuCallback");
    }
}
