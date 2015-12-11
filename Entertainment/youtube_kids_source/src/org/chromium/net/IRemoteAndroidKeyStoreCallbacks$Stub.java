// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package org.chromium.net:
//            IRemoteAndroidKeyStoreCallbacks

public abstract class attachInterface extends Binder
    implements IRemoteAndroidKeyStoreCallbacks
{

    public static IRemoteAndroidKeyStoreCallbacks a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("org.chromium.net.IRemoteAndroidKeyStoreCallbacks");
        class Proxy
            implements IRemoteAndroidKeyStoreCallbacks
        {

            private IBinder a;

            public final void a()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("org.chromium.net.IRemoteAndroidKeyStoreCallbacks");
                a.transact(1, parcel, parcel1, 0);
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

            public final void b()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("org.chromium.net.IRemoteAndroidKeyStoreCallbacks");
                a.transact(2, parcel, parcel1, 0);
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

            Proxy(IBinder ibinder)
            {
                a = ibinder;
            }
        }

        if (iinterface != null && (iinterface instanceof IRemoteAndroidKeyStoreCallbacks))
        {
            return (IRemoteAndroidKeyStoreCallbacks)iinterface;
        } else
        {
            return new Proxy(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("org.chromium.net.IRemoteAndroidKeyStoreCallbacks");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("org.chromium.net.IRemoteAndroidKeyStoreCallbacks");
            a();
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("org.chromium.net.IRemoteAndroidKeyStoreCallbacks");
            b();
            parcel1.writeNoException();
            return true;
        }
    }

    public Proxy()
    {
        attachInterface(this, "org.chromium.net.IRemoteAndroidKeyStoreCallbacks");
    }
}
