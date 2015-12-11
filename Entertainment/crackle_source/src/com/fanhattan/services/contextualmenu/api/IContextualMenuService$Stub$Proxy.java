// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.contextualmenu.api;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.fanhattan.services.contextualmenu.api:
//            IContextualMenuService, ContextualMenu, IContextualMenuCallback

private static class mRemote
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

    Q(IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
