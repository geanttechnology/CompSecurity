// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.b:
//            dr, dq

public static abstract class a.a extends Binder
    implements dr
{
    private static class a
        implements dr
    {

        private IBinder a;

        public void a(dq dq1, String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.search.internal.ISearchAuthService");
            if (dq1 == null)
            {
                break MISSING_BLOCK_LABEL_78;
            }
            dq1 = dq1.asBinder();
_L1:
            parcel.writeStrongBinder(dq1);
            parcel.writeString(s);
            parcel.writeString(s1);
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            dq1 = null;
              goto _L1
            dq1;
            parcel1.recycle();
            parcel.recycle();
            throw dq1;
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


    public static dr a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.search.internal.ISearchAuthService");
        if (iinterface != null && (iinterface instanceof dr))
        {
            return (dr)iinterface;
        } else
        {
            return new a(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        throws RemoteException
    {
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.search.internal.ISearchAuthService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.search.internal.ISearchAuthService");
            a(a(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            return true;
        }
    }
}
