// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

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
import com.facebook.h;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package android.support.v7:
//            kb

public class jk
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


    private static final String a = android/support/v7/jk.getCanonicalName();
    private static jk g;
    private String b;
    private String c;
    private String d;
    private boolean e;
    private long f;

    public jk()
    {
    }

    public static jk a(Context context)
    {
        if (g == null || System.currentTimeMillis() - g.f >= 0x36ee80L) goto _L2; else goto _L1
_L1:
        context = g;
_L8:
        return context;
_L2:
        jk jk1 = b(context);
        if (context.getPackageManager().resolveContentProvider("com.facebook.katana.provider.AttributionIdProvider", 0) == null) goto _L4; else goto _L3
_L3:
        Object obj = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
_L9:
        String s = e(context);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        jk1.d = s;
        if (obj != null) goto _L6; else goto _L5
_L5:
        context = a(jk1);
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
        jk1 = a(jk1);
        context = jk1;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            return jk1;
        }
          goto _L8
        context = ((Context) (obj));
        int j = ((Cursor) (obj)).getColumnIndex("aid");
        context = ((Context) (obj));
        int i = ((Cursor) (obj)).getColumnIndex("androidid");
        context = ((Context) (obj));
        int k = ((Cursor) (obj)).getColumnIndex("limit_tracking");
        context = ((Context) (obj));
        jk1.b = ((Cursor) (obj)).getString(j);
        if (i <= 0 || k <= 0)
        {
            break MISSING_BLOCK_LABEL_277;
        }
        context = ((Context) (obj));
        if (jk1.b() != null)
        {
            break MISSING_BLOCK_LABEL_277;
        }
        context = ((Context) (obj));
        jk1.c = ((Cursor) (obj)).getString(i);
        context = ((Context) (obj));
        jk1.e = Boolean.parseBoolean(((Cursor) (obj)).getString(k));
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return a(jk1);
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

    private static jk a(jk jk1)
    {
        jk1.f = System.currentTimeMillis();
        g = jk1;
        return jk1;
    }

    private static jk b(Context context)
    {
        jk jk1 = c(context);
        Object obj = jk1;
        if (jk1 == null)
        {
            context = d(context);
            obj = context;
            if (context == null)
            {
                obj = new jk();
            }
        }
        return ((jk) (obj));
    }

    private static jk c(Context context)
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            throw new h("getAndroidId cannot be called on the main thread.");
        }
          goto _L1
        context;
        kb.a("android_id", context);
_L3:
        return null;
_L1:
        Object obj = kb.a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", new Class[] {
            android/content/Context
        });
        if (obj == null) goto _L3; else goto _L2
_L2:
        obj = kb.a(null, ((java.lang.reflect.Method) (obj)), new Object[] {
            context
        });
        if (!(obj instanceof Integer) || ((Integer)obj).intValue() != 0) goto _L3; else goto _L4
_L4:
        obj = kb.a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[] {
            android/content/Context
        });
        if (obj == null) goto _L3; else goto _L5
_L5:
        context = ((Context) (kb.a(null, ((java.lang.reflect.Method) (obj)), new Object[] {
            context
        })));
        if (context == null) goto _L3; else goto _L6
_L6:
        java.lang.reflect.Method method;
        obj = kb.a(context.getClass(), "getId", new Class[0]);
        method = kb.a(context.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
        if (obj == null || method == null) goto _L3; else goto _L7
_L7:
        jk jk1 = new jk();
        jk1.c = (String)kb.a(context, ((java.lang.reflect.Method) (obj)), new Object[0]);
        jk1.e = ((Boolean)kb.a(context, method, new Object[0])).booleanValue();
        return null;
    }

    private static jk d(Context context)
    {
        b b1;
        b1 = new b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (!context.bindService(intent, b1, 1))
        {
            break MISSING_BLOCK_LABEL_91;
        }
        jk jk1;
        a a1 = new a(b1.a());
        jk1 = new jk();
        jk1.c = a1.a();
        jk1.e = a1.b();
        context.unbindService(b1);
        return jk1;
        Object obj;
        obj;
        kb.a("android_id", ((Exception) (obj)));
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
