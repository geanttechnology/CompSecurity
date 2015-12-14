// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.facebook.ads.internal.util.g;
import com.facebook.ads.internal.util.r;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

public class f
{

    public static final String a = com/facebook/ads/internal/f.getSimpleName();
    private final String b;
    private final boolean c;
    private final c d;

    private f(String s, boolean flag, c c1)
    {
        b = s;
        c = flag;
        d = c1;
    }

    private static f a(Context context)
    {
        context = AdvertisingIdClient.getAdvertisingIdInfo(context);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        context = new f(context.getId(), context.isLimitAdTrackingEnabled(), c.c);
        return context;
        context;
        return null;
    }

    public static f a(Context context, com.facebook.ads.internal.util.g.a a1)
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            throw new IllegalStateException("Cannot get advertising info on main thread.");
        }
        if (a1 == null || r.a(a1.b)) goto _L2; else goto _L1
_L1:
        Object obj = new f(a1.b, a1.c, c.b);
_L4:
        return ((f) (obj));
_L2:
label0:
        {
            obj = a(context);
            if (obj != null)
            {
                a1 = ((com.facebook.ads.internal.util.g.a) (obj));
                if (!r.a(((f) (obj)).a()))
                {
                    break label0;
                }
            }
            a1 = b(context);
        }
        if (a1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = a1;
        if (!r.a(a1.a())) goto _L4; else goto _L3
_L3:
        return c(context);
    }

    private static f b(Context context)
    {
        Object obj = g.a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", new Class[] {
            android/content/Context
        });
        if (obj == null)
        {
            return null;
        }
        obj = g.a(null, ((java.lang.reflect.Method) (obj)), new Object[] {
            context
        });
        if (obj == null || ((Integer)obj).intValue() != 0)
        {
            return null;
        }
        obj = g.a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[] {
            android/content/Context
        });
        if (obj == null)
        {
            return null;
        }
        context = ((Context) (g.a(null, ((java.lang.reflect.Method) (obj)), new Object[] {
            context
        })));
        if (context == null)
        {
            return null;
        }
        obj = g.a(context.getClass(), "getId", new Class[0]);
        java.lang.reflect.Method method = g.a(context.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
        if (obj == null || method == null)
        {
            return null;
        } else
        {
            return new f((String)g.a(context, ((java.lang.reflect.Method) (obj)), new Object[0]), ((Boolean)g.a(context, method, new Object[0])).booleanValue(), c.d);
        }
    }

    private static f c(Context context)
    {
        b b1;
        b1 = new b(null);
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (!context.bindService(intent, b1, 1))
        {
            break MISSING_BLOCK_LABEL_80;
        }
        Object obj;
        obj = new a(b1.a());
        obj = new f(((a) (obj)).a(), ((a) (obj)).b(), c.e);
        context.unbindService(b1);
        return ((f) (obj));
        Object obj1;
        obj1;
        context.unbindService(b1);
        return null;
        obj1;
        context.unbindService(b1);
        throw obj1;
    }

    public String a()
    {
        return b;
    }

    public boolean b()
    {
        return c;
    }

    public c c()
    {
        return d;
    }


    private class c extends Enum
    {

        public static final c a;
        public static final c b;
        public static final c c;
        public static final c d;
        public static final c e;
        private static final c f[];

        public static c valueOf(String s)
        {
            return (c)Enum.valueOf(com/facebook/ads/internal/f$c, s);
        }

        public static c[] values()
        {
            return (c[])f.clone();
        }

        static 
        {
            a = new c("SHARED_PREFS", 0);
            b = new c("FB4A", 1);
            c = new c("DIRECT", 2);
            d = new c("REFLECTION", 3);
            e = new c("SERVICE", 4);
            f = (new c[] {
                a, b, c, d, e
            });
        }

        private c(String s, int i)
        {
            super(s, i);
        }
    }


    private class b
        implements ServiceConnection
    {

        private AtomicBoolean a;
        private final BlockingQueue b;

        public IBinder a()
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

        b(_cls1 _pcls1)
        {
            this();
        }
    }


    private class a
        implements IInterface
    {

        private IBinder a;

        public String a()
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

}
