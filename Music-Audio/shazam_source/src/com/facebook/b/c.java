// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.b;

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
import com.facebook.h;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.facebook.b:
//            t

public class c
{
    private static final class a
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

        a(IBinder ibinder)
        {
            a = ibinder;
        }
    }

    private static final class b
        implements ServiceConnection
    {

        AtomicBoolean a;
        final BlockingQueue b;

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
            a = new AtomicBoolean(false);
            b = new LinkedBlockingDeque();
        }

        b(byte byte0)
        {
            this();
        }
    }


    private static final String e = com/facebook/b/c.getCanonicalName();
    private static c g;
    public String a;
    public String b;
    String c;
    public boolean d;
    private long f;

    public c()
    {
    }

    public static c a(Context context)
    {
        Object obj3 = null;
        if (g == null || System.currentTimeMillis() - g.f >= 0x36ee80L) goto _L2; else goto _L1
_L1:
        Object obj = g;
_L13:
        return ((c) (obj));
_L2:
        Object obj1;
        obj1 = b(context);
        obj = obj1;
        if (obj1 != null) goto _L4; else goto _L3
_L3:
        obj1 = c(context);
        obj = obj1;
        if (obj1 != null) goto _L4; else goto _L5
_L5:
        obj1 = new c();
_L17:
        if (context.getPackageManager().resolveContentProvider("com.facebook.katana.provider.AttributionIdProvider", 0) == null) goto _L7; else goto _L6
_L6:
        obj = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
_L12:
        Object obj2 = context.getPackageManager();
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_389;
        }
        obj2 = ((PackageManager) (obj2)).getInstallerPackageName(context.getPackageName());
_L18:
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        obj1.c = ((String) (obj2));
        if (obj != null) goto _L9; else goto _L8
_L8:
        return a(((c) (obj1)));
_L7:
        if (context.getPackageManager().resolveContentProvider("com.facebook.wakizashi.provider.AttributionIdProvider", 0) == null) goto _L11; else goto _L10
_L10:
        obj = Uri.parse("content://com.facebook.wakizashi.provider.AttributionIdProvider");
          goto _L12
_L9:
        context = context.getContentResolver().query(((Uri) (obj)), new String[] {
            "aid", "androidid", "limit_tracking"
        }, null, null, null);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_185;
        }
        obj = context;
        if (context.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_206;
        }
        obj = context;
        obj1 = a(((c) (obj1)));
        obj = obj1;
        if (context != null)
        {
            context.close();
            return ((c) (obj1));
        }
          goto _L13
        obj = context;
        int i = context.getColumnIndex("aid");
        obj = context;
        int j = context.getColumnIndex("androidid");
        obj = context;
        int k = context.getColumnIndex("limit_tracking");
        obj = context;
        obj1.a = context.getString(i);
        if (j <= 0 || k <= 0)
        {
            break MISSING_BLOCK_LABEL_306;
        }
        obj = context;
        if (((c) (obj1)).b != null)
        {
            break MISSING_BLOCK_LABEL_306;
        }
        obj = context;
        obj1.b = context.getString(j);
        obj = context;
        obj1.d = Boolean.parseBoolean(context.getString(k));
        if (context != null)
        {
            context.close();
        }
        return a(((c) (obj1)));
        obj1;
        context = null;
_L16:
        obj = context;
        (new StringBuilder("Caught unexpected exception in getAttributionId(): ")).append(((Exception) (obj1)).toString());
        if (context != null)
        {
            context.close();
        }
        return null;
        context;
        obj = obj3;
_L15:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw context;
        context;
        if (true) goto _L15; else goto _L14
_L14:
        obj1;
        if (true) goto _L16; else goto _L11
_L11:
        obj = null;
          goto _L12
_L4:
        obj1 = obj;
          goto _L17
        obj2 = null;
          goto _L18
    }

    private static c a(c c1)
    {
        c1.f = System.currentTimeMillis();
        g = c1;
        return c1;
    }

    private static c b(Context context)
    {
        try
        {
            if (Looper.myLooper() == Looper.getMainLooper())
            {
                throw new h("getAndroidId cannot be called on the main thread.");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            t.a(context);
            return null;
        }
        Object obj = t.a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", new Class[] {
            android/content/Context
        });
        if (obj == null)
        {
            return null;
        }
        obj = t.a(null, ((java.lang.reflect.Method) (obj)), new Object[] {
            context
        });
        if (!(obj instanceof Integer) || ((Integer)obj).intValue() != 0)
        {
            break MISSING_BLOCK_LABEL_210;
        }
        obj = t.a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[] {
            android/content/Context
        });
        if (obj == null)
        {
            return null;
        }
        context = ((Context) (t.a(null, ((java.lang.reflect.Method) (obj)), new Object[] {
            context
        })));
        if (context == null)
        {
            return null;
        }
        java.lang.reflect.Method method;
        obj = t.a(context.getClass(), "getId", new Class[0]);
        method = t.a(context.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
        if (obj == null || method == null)
        {
            break MISSING_BLOCK_LABEL_212;
        }
        c c1;
        c1 = new c();
        c1.b = (String)t.a(context, ((java.lang.reflect.Method) (obj)), new Object[0]);
        c1.d = ((Boolean)t.a(context, method, new Object[0])).booleanValue();
        return c1;
        return null;
        return null;
    }

    private static c c(Context context)
    {
        b b1;
        b1 = new b((byte)0);
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (!context.bindService(intent, b1, 1))
        {
            break MISSING_BLOCK_LABEL_68;
        }
        if (b1.a.compareAndSet(true, true))
        {
            throw new IllegalStateException("Binder already consumed");
        }
        break MISSING_BLOCK_LABEL_70;
        Object obj;
        obj;
        t.a(((Exception) (obj)));
        context.unbindService(b1);
        return null;
        c c1;
        a a1 = new a((IBinder)b1.b.take());
        c1 = new c();
        c1.b = a1.a();
        c1.d = a1.b();
        context.unbindService(b1);
        return c1;
        a1;
        context.unbindService(b1);
        throw a1;
    }

}
