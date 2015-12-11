// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

public final class io.presage.utils.a
{
    public static final class a
    {

        private final String a;
        private final boolean b;

        public final String a()
        {
            return a;
        }

        public final boolean b()
        {
            return b;
        }

        a(String s, boolean flag)
        {
            a = s;
            b = flag;
        }
    }

    private static final class b
        implements ServiceConnection
    {

        boolean a;
        private final LinkedBlockingQueue b;

        public final IBinder a()
        {
            if (a)
            {
                throw new IllegalStateException();
            } else
            {
                a = true;
                return (IBinder)b.take();
            }
        }

        public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            try
            {
                b.put(ibinder);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ComponentName componentname)
            {
                return;
            }
        }

        public final void onServiceDisconnected(ComponentName componentname)
        {
        }

        private b()
        {
            a = false;
            b = new LinkedBlockingQueue(1);
        }

        b(byte byte0)
        {
            this();
        }
    }

    private static final class c
        implements IInterface
    {

        private IBinder a;

        public final String a()
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s;
            parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            s = parcel1.readString();
            parcel1.recycle();
            parcel.recycle();
            return s;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public final IBinder asBinder()
        {
            return a;
        }

        public final boolean b()
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            parcel.writeInt(1);
            a.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            i = parcel1.readInt();
            if (i == 0)
            {
                flag = false;
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

        public c(IBinder ibinder)
        {
            a = ibinder;
        }
    }


    public static a a(Context context)
    {
        b b1;
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        Object obj;
        try
        {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw context;
        }
        b1 = new b((byte)0);
        obj = new Intent("com.google.android.gms.ads.identifier.service.START");
        ((Intent) (obj)).setPackage("com.google.android.gms");
        if (!context.bindService(((Intent) (obj)), b1, 1))
        {
            break MISSING_BLOCK_LABEL_115;
        }
        obj = new c(b1.a());
        obj = new a(((c) (obj)).a(), ((c) (obj)).b());
        context.unbindService(b1);
        return ((a) (obj));
        Object obj1;
        obj1;
        throw obj1;
        obj1;
        context.unbindService(b1);
        throw obj1;
        throw new IOException("Google Play connection failed");
    }
}
