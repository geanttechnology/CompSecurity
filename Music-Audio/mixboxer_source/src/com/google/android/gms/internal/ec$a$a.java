// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            ec, eb

private static class dU
    implements ec
{

    private IBinder dU;

    public void a(eb eb1, int i1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (eb1 == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        eb1 = eb1.asBinder();
_L1:
        parcel.writeStrongBinder(eb1);
        parcel.writeInt(i1);
        dU.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        eb1 = null;
          goto _L1
        eb1;
        parcel1.recycle();
        parcel.recycle();
        throw eb1;
    }

    public void a(eb eb1, int i1, String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (eb1 == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        eb1 = eb1.asBinder();
_L1:
        parcel.writeStrongBinder(eb1);
        parcel.writeInt(i1);
        parcel.writeString(s);
        dU.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        eb1 = null;
          goto _L1
        eb1;
        parcel1.recycle();
        parcel.recycle();
        throw eb1;
    }

    public void a(eb eb1, int i1, String s, Bundle bundle)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (eb1 == null) goto _L2; else goto _L1
_L1:
        eb1 = eb1.asBinder();
_L5:
        parcel.writeStrongBinder(eb1);
        parcel.writeInt(i1);
        parcel.writeString(s);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        dU.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        eb1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        eb1;
        parcel1.recycle();
        parcel.recycle();
        throw eb1;
          goto _L5
    }

    public void a(eb eb1, int i1, String s, IBinder ibinder, Bundle bundle)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (eb1 == null) goto _L2; else goto _L1
_L1:
        eb1 = eb1.asBinder();
_L5:
        parcel.writeStrongBinder(eb1);
        parcel.writeInt(i1);
        parcel.writeString(s);
        parcel.writeStrongBinder(ibinder);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        dU.transact(19, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        eb1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        eb1;
        parcel1.recycle();
        parcel.recycle();
        throw eb1;
          goto _L5
    }

    public void a(eb eb1, int i1, String s, String s1, String as[])
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (eb1 == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        eb1 = eb1.asBinder();
_L1:
        parcel.writeStrongBinder(eb1);
        parcel.writeInt(i1);
        parcel.writeString(s);
        parcel.writeString(s1);
        parcel.writeStringArray(as);
        dU.transact(10, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        eb1 = null;
          goto _L1
        eb1;
        parcel1.recycle();
        parcel.recycle();
        throw eb1;
    }

    public void a(eb eb1, int i1, String s, String s1, String as[], String s2, Bundle bundle)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (eb1 == null) goto _L2; else goto _L1
_L1:
        eb1 = eb1.asBinder();
_L5:
        parcel.writeStrongBinder(eb1);
        parcel.writeInt(i1);
        parcel.writeString(s);
        parcel.writeString(s1);
        parcel.writeStringArray(as);
        parcel.writeString(s2);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        dU.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        eb1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        eb1;
        parcel1.recycle();
        parcel.recycle();
        throw eb1;
          goto _L5
    }

    public void a(eb eb1, int i1, String s, String s1, String as[], String s2, IBinder ibinder, 
            String s3, Bundle bundle)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (eb1 == null) goto _L2; else goto _L1
_L1:
        eb1 = eb1.asBinder();
_L5:
        parcel.writeStrongBinder(eb1);
        parcel.writeInt(i1);
        parcel.writeString(s);
        parcel.writeString(s1);
        parcel.writeStringArray(as);
        parcel.writeString(s2);
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s3);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        dU.transact(9, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        eb1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        eb1;
        parcel1.recycle();
        parcel.recycle();
        throw eb1;
          goto _L5
    }

    public void a(eb eb1, int i1, String s, String as[], String s1, Bundle bundle)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (eb1 == null) goto _L2; else goto _L1
_L1:
        eb1 = eb1.asBinder();
_L5:
        parcel.writeStrongBinder(eb1);
        parcel.writeInt(i1);
        parcel.writeString(s);
        parcel.writeStringArray(as);
        parcel.writeString(s1);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        dU.transact(20, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        eb1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        eb1;
        parcel1.recycle();
        parcel.recycle();
        throw eb1;
          goto _L5
    }

    public IBinder asBinder()
    {
        return dU;
    }

    public void b(eb eb1, int i1, String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (eb1 == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        eb1 = eb1.asBinder();
_L1:
        parcel.writeStrongBinder(eb1);
        parcel.writeInt(i1);
        parcel.writeString(s);
        dU.transact(21, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        eb1 = null;
          goto _L1
        eb1;
        parcel1.recycle();
        parcel.recycle();
        throw eb1;
    }

    public void b(eb eb1, int i1, String s, Bundle bundle)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (eb1 == null) goto _L2; else goto _L1
_L1:
        eb1 = eb1.asBinder();
_L5:
        parcel.writeStrongBinder(eb1);
        parcel.writeInt(i1);
        parcel.writeString(s);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        dU.transact(5, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        eb1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        eb1;
        parcel1.recycle();
        parcel.recycle();
        throw eb1;
          goto _L5
    }

    public void c(eb eb1, int i1, String s, Bundle bundle)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (eb1 == null) goto _L2; else goto _L1
_L1:
        eb1 = eb1.asBinder();
_L5:
        parcel.writeStrongBinder(eb1);
        parcel.writeInt(i1);
        parcel.writeString(s);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        dU.transact(6, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        eb1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        eb1;
        parcel1.recycle();
        parcel.recycle();
        throw eb1;
          goto _L5
    }

    public void d(eb eb1, int i1, String s, Bundle bundle)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (eb1 == null) goto _L2; else goto _L1
_L1:
        eb1 = eb1.asBinder();
_L5:
        parcel.writeStrongBinder(eb1);
        parcel.writeInt(i1);
        parcel.writeString(s);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        dU.transact(7, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        eb1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        eb1;
        parcel1.recycle();
        parcel.recycle();
        throw eb1;
          goto _L5
    }

    public void e(eb eb1, int i1, String s, Bundle bundle)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (eb1 == null) goto _L2; else goto _L1
_L1:
        eb1 = eb1.asBinder();
_L5:
        parcel.writeStrongBinder(eb1);
        parcel.writeInt(i1);
        parcel.writeString(s);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        dU.transact(8, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        eb1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        eb1;
        parcel1.recycle();
        parcel.recycle();
        throw eb1;
          goto _L5
    }

    public void f(eb eb1, int i1, String s, Bundle bundle)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (eb1 == null) goto _L2; else goto _L1
_L1:
        eb1 = eb1.asBinder();
_L5:
        parcel.writeStrongBinder(eb1);
        parcel.writeInt(i1);
        parcel.writeString(s);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        dU.transact(11, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        eb1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        eb1;
        parcel1.recycle();
        parcel.recycle();
        throw eb1;
          goto _L5
    }

    public void g(eb eb1, int i1, String s, Bundle bundle)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (eb1 == null) goto _L2; else goto _L1
_L1:
        eb1 = eb1.asBinder();
_L5:
        parcel.writeStrongBinder(eb1);
        parcel.writeInt(i1);
        parcel.writeString(s);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        dU.transact(12, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        eb1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        eb1;
        parcel1.recycle();
        parcel.recycle();
        throw eb1;
          goto _L5
    }

    public void h(eb eb1, int i1, String s, Bundle bundle)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (eb1 == null) goto _L2; else goto _L1
_L1:
        eb1 = eb1.asBinder();
_L5:
        parcel.writeStrongBinder(eb1);
        parcel.writeInt(i1);
        parcel.writeString(s);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        dU.transact(13, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        eb1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        eb1;
        parcel1.recycle();
        parcel.recycle();
        throw eb1;
          goto _L5
    }

    public void i(eb eb1, int i1, String s, Bundle bundle)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (eb1 == null) goto _L2; else goto _L1
_L1:
        eb1 = eb1.asBinder();
_L5:
        parcel.writeStrongBinder(eb1);
        parcel.writeInt(i1);
        parcel.writeString(s);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        dU.transact(14, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        eb1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        eb1;
        parcel1.recycle();
        parcel.recycle();
        throw eb1;
          goto _L5
    }

    public void j(eb eb1, int i1, String s, Bundle bundle)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (eb1 == null) goto _L2; else goto _L1
_L1:
        eb1 = eb1.asBinder();
_L5:
        parcel.writeStrongBinder(eb1);
        parcel.writeInt(i1);
        parcel.writeString(s);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        dU.transact(15, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        eb1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        eb1;
        parcel1.recycle();
        parcel.recycle();
        throw eb1;
          goto _L5
    }

    public void k(eb eb1, int i1, String s, Bundle bundle)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (eb1 == null) goto _L2; else goto _L1
_L1:
        eb1 = eb1.asBinder();
_L5:
        parcel.writeStrongBinder(eb1);
        parcel.writeInt(i1);
        parcel.writeString(s);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        dU.transact(16, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        eb1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        eb1;
        parcel1.recycle();
        parcel.recycle();
        throw eb1;
          goto _L5
    }

    public void l(eb eb1, int i1, String s, Bundle bundle)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (eb1 == null) goto _L2; else goto _L1
_L1:
        eb1 = eb1.asBinder();
_L5:
        parcel.writeStrongBinder(eb1);
        parcel.writeInt(i1);
        parcel.writeString(s);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        dU.transact(17, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        eb1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        eb1;
        parcel1.recycle();
        parcel.recycle();
        throw eb1;
          goto _L5
    }

    public void m(eb eb1, int i1, String s, Bundle bundle)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (eb1 == null) goto _L2; else goto _L1
_L1:
        eb1 = eb1.asBinder();
_L5:
        parcel.writeStrongBinder(eb1);
        parcel.writeInt(i1);
        parcel.writeString(s);
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        dU.transact(18, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        eb1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        eb1;
        parcel1.recycle();
        parcel.recycle();
        throw eb1;
          goto _L5
    }

    (IBinder ibinder)
    {
        dU = ibinder;
    }
}
