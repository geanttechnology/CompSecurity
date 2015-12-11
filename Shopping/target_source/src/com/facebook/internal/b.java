// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.facebook.f;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.facebook.internal:
//            o

public class com.facebook.internal.b
{
    private static final class a
        implements IInterface
    {

        private IBinder a;

        public String a()
            throws RemoteException
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

        public IBinder asBinder()
        {
            return a;
        }

        public boolean b()
            throws RemoteException
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

        a(IBinder ibinder)
        {
            a = ibinder;
        }
    }

    private static final class b
        implements ServiceConnection
    {

        private AtomicBoolean a;
        private final BlockingQueue b;

        public IBinder a()
            throws InterruptedException
        {
            if (a.compareAndSet(true, true))
            {
                throw new IllegalStateException("Binder already consumed");
            } else
            {
                return (IBinder)b.take();
            }
        }

        public void onServiceConnected(ComponentName componentname, IBinder ibinder)
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

        public void onServiceDisconnected(ComponentName componentname)
        {
        }

        private b()
        {
            a = new AtomicBoolean(false);
            b = new LinkedBlockingDeque();
        }

    }


    private static final String a = com/facebook/internal/b.getCanonicalName();
    private static com.facebook.internal.b g;
    private String b;
    private String c;
    private String d;
    private boolean e;
    private long f;

    public com.facebook.internal.b()
    {
    }

    public static com.facebook.internal.b a(Context context)
    {
        if (g == null || System.currentTimeMillis() - g.f >= 0x36ee80L) goto _L2; else goto _L1
_L1:
        context = g;
_L8:
        return context;
_L2:
        com.facebook.internal.b b1 = b(context);
        if (context.getPackageManager().resolveContentProvider("com.facebook.katana.provider.AttributionIdProvider", 0) == null) goto _L4; else goto _L3
_L3:
        Object obj = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
_L9:
        String s = e(context);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        b1.d = s;
        if (obj != null) goto _L6; else goto _L5
_L5:
        context = a(b1);
        if (true) goto _L8; else goto _L7
_L7:
        throw new NullPointerException();
_L4:
        if (context.getPackageManager().resolveContentProvider("com.facebook.wakizashi.provider.AttributionIdProvider", 0) == null)
        {
            break MISSING_BLOCK_LABEL_361;
        }
        obj = Uri.parse("content://com.facebook.wakizashi.provider.AttributionIdProvider");
          goto _L9
_L6:
        obj = context.getContentResolver().query(((Uri) (obj)), new String[] {
            "aid", "androidid", "limit_tracking"
        }, null, null, null);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        context = ((Context) (obj));
        if (((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_177;
        }
        context = ((Context) (obj));
        b1 = a(b1);
        context = b1;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            return b1;
        }
          goto _L8
        context = ((Context) (obj));
        int i = ((Cursor) (obj)).getColumnIndex("aid");
        context = ((Context) (obj));
        int k = ((Cursor) (obj)).getColumnIndex("androidid");
        context = ((Context) (obj));
        int j = ((Cursor) (obj)).getColumnIndex("limit_tracking");
        context = ((Context) (obj));
        b1.b = ((Cursor) (obj)).getString(i);
        if (k <= 0 || j <= 0)
        {
            break MISSING_BLOCK_LABEL_277;
        }
        context = ((Context) (obj));
        if (b1.b() != null)
        {
            break MISSING_BLOCK_LABEL_277;
        }
        context = ((Context) (obj));
        b1.c = ((Cursor) (obj)).getString(k);
        context = ((Context) (obj));
        b1.e = Boolean.parseBoolean(((Cursor) (obj)).getString(j));
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return a(b1);
        Exception exception;
        exception;
        obj = null;
_L13:
        context = ((Context) (obj));
        Log.d(a, (new StringBuilder()).append("Caught unexpected exception in getAttributionId(): ").append(exception.toString()).toString());
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
        obj;
        context = null;
_L11:
        if (context != null)
        {
            context.close();
        }
        throw obj;
        obj;
        if (true) goto _L11; else goto _L10
_L10:
        exception;
        if (true) goto _L13; else goto _L12
_L12:
        obj = null;
          goto _L9
    }

    private static com.facebook.internal.b a(com.facebook.internal.b b1)
    {
        b1.f = System.currentTimeMillis();
        g = b1;
        return b1;
    }

    private static com.facebook.internal.b b(Context context)
    {
        com.facebook.internal.b b1 = c(context);
        Object obj = b1;
        if (b1 == null)
        {
            context = d(context);
            obj = context;
            if (context == null)
            {
                obj = new com.facebook.internal.b();
            }
        }
        return ((com.facebook.internal.b) (obj));
    }

    private static com.facebook.internal.b c(Context context)
    {
        try
        {
            if (Looper.myLooper() == Looper.getMainLooper())
            {
                throw new f("getAndroidId cannot be called on the main thread.");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            o.a("android_id", context);
            return null;
        }
        Object obj = o.a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", new Class[] {
            android/content/Context
        });
        if (obj == null)
        {
            return null;
        }
        obj = o.a(null, ((java.lang.reflect.Method) (obj)), new Object[] {
            context
        });
        if (!(obj instanceof Integer) || ((Integer)obj).intValue() != 0)
        {
            break MISSING_BLOCK_LABEL_212;
        }
        obj = o.a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[] {
            android/content/Context
        });
        if (obj == null)
        {
            return null;
        }
        context = ((Context) (o.a(null, ((java.lang.reflect.Method) (obj)), new Object[] {
            context
        })));
        if (context == null)
        {
            return null;
        }
        java.lang.reflect.Method method;
        obj = o.a(context.getClass(), "getId", new Class[0]);
        method = o.a(context.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
        if (obj == null || method == null)
        {
            break MISSING_BLOCK_LABEL_214;
        }
        com.facebook.internal.b b1;
        b1 = new com.facebook.internal.b();
        b1.c = (String)o.a(context, ((java.lang.reflect.Method) (obj)), new Object[0]);
        b1.e = ((Boolean)o.a(context, method, new Object[0])).booleanValue();
        return b1;
        return null;
        return null;
    }

    private static com.facebook.internal.b d(Context context)
    {
        b b1;
        b1 = new b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (!context.bindService(intent, b1, 1))
        {
            break MISSING_BLOCK_LABEL_91;
        }
        com.facebook.internal.b b2;
        a a1 = new a(b1.a());
        b2 = new com.facebook.internal.b();
        b2.c = a1.a();
        b2.e = a1.b();
        context.unbindService(b1);
        return b2;
        Object obj;
        obj;
        o.a("android_id", ((Exception) (obj)));
        context.unbindService(b1);
        return null;
        obj;
        context.unbindService(b1);
        throw obj;
    }

    private static String e(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        if (packagemanager != null)
        {
            return packagemanager.getInstallerPackageName(context.getPackageName());
        } else
        {
            return null;
        }
    }

    public String a()
    {
        return b;
    }

    public String b()
    {
        return c;
    }

    public String c()
    {
        return d;
    }

    public boolean d()
    {
        return e;
    }

}
