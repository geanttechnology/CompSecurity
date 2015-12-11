// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;

import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package org.chromium.net:
//            IRemoteAndroidKeyStore, IRemoteAndroidKeyStoreCallbacks

class 
    implements IRemoteAndroidKeyStore
{

    public final String a()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("org.chromium.net.IRemoteAndroidKeyStore");
        throw new NullPointerException();
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public final void a(IRemoteAndroidKeyStoreCallbacks iremoteandroidkeystorecallbacks)
    {
        IBinder ibinder;
        Parcel parcel;
        Parcel parcel1;
        ibinder = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("org.chromium.net.IRemoteAndroidKeyStore");
        if (iremoteandroidkeystorecallbacks == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        ibinder = iremoteandroidkeystorecallbacks.asBinder();
        parcel.writeStrongBinder(ibinder);
        throw new NullPointerException();
        iremoteandroidkeystorecallbacks;
        parcel1.recycle();
        parcel.recycle();
        throw iremoteandroidkeystorecallbacks;
    }

    public final byte[] a(int i)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("org.chromium.net.IRemoteAndroidKeyStore");
        parcel.writeInt(i);
        throw new NullPointerException();
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public final byte[] a(int i, byte abyte0[])
    {
        Parcel parcel;
        Parcel parcel1;
        parcel1 = Parcel.obtain();
        parcel = Parcel.obtain();
        parcel1.writeInterfaceToken("org.chromium.net.IRemoteAndroidKeyStore");
        parcel1.writeInt(i);
        parcel1.writeByteArray(abyte0);
        throw new NullPointerException();
        abyte0;
        parcel.recycle();
        parcel1.recycle();
        throw abyte0;
    }

    public final byte[] a(String s)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("org.chromium.net.IRemoteAndroidKeyStore");
        parcel.writeString(s);
        throw new NullPointerException();
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public IBinder asBinder()
    {
        return null;
    }

    public final int b(String s)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel1 = Parcel.obtain();
        parcel = Parcel.obtain();
        parcel1.writeInterfaceToken("org.chromium.net.IRemoteAndroidKeyStore");
        parcel1.writeString(s);
        throw new NullPointerException();
        s;
        parcel.recycle();
        parcel1.recycle();
        throw s;
    }

    public final byte[] b(int i)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel1 = Parcel.obtain();
        parcel = Parcel.obtain();
        parcel1.writeInterfaceToken("org.chromium.net.IRemoteAndroidKeyStore");
        parcel1.writeInt(i);
        throw new NullPointerException();
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
    }

    public final byte[] c(int i)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("org.chromium.net.IRemoteAndroidKeyStore");
        parcel.writeInt(i);
        throw new NullPointerException();
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public final byte[] d(int i)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("org.chromium.net.IRemoteAndroidKeyStore");
        parcel.writeInt(i);
        throw new NullPointerException();
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public final int e(int i)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("org.chromium.net.IRemoteAndroidKeyStore");
        parcel.writeInt(i);
        throw new NullPointerException();
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public final void f(int i)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel1 = Parcel.obtain();
        parcel = Parcel.obtain();
        parcel1.writeInterfaceToken("org.chromium.net.IRemoteAndroidKeyStore");
        parcel1.writeInt(i);
        throw new NullPointerException();
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
    }
}
