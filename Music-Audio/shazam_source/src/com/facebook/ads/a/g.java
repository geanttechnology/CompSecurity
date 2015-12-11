// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import com.facebook.ads.a.f.s;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class g
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
            String s1;
            parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            s1 = parcel1.readString();
            parcel1.recycle();
            parcel.recycle();
            return s1;
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


    public static final String a = com/facebook/ads/a/g.getSimpleName();
    public final String b;
    public final boolean c;

    private g(String s1, boolean flag)
    {
        b = s1;
        c = flag;
    }

    private static g a(Context context)
    {
label0:
        {
            b b1 = new b((byte)0);
            Object obj = new Intent("com.google.android.gms.ads.identifier.service.START");
            ((Intent) (obj)).setPackage("com.google.android.gms");
            if (context.bindService(((Intent) (obj)), b1, 1))
            {
                try
                {
                    if (b1.a.compareAndSet(true, true))
                    {
                        throw new IllegalStateException("Binder already consumed");
                    }
                    break label0;
                }
                catch (Exception exception)
                {
                    context.unbindService(b1);
                }
                finally
                {
                    context.unbindService(b1);
                    throw exception1;
                }
            }
            return null;
        }
        exception = new a((IBinder)b1.b.take());
        exception = new g(exception.a(), exception.b());
        context.unbindService(b1);
        return exception;
    }

    public static g a(Context context, com.facebook.ads.a.f.a a1)
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            throw new IllegalStateException("Cannot get advertising info on main thread.");
        }
        Object obj;
        if (a1 != null && !s.a(a1.b))
        {
            obj = new g(a1.b, a1.c);
        } else
        {
            a1 = com.facebook.ads.a.f.g.a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", new Class[] {
                android/content/Context
            });
            if (a1 == null)
            {
                a1 = null;
            } else
            {
                a1 = ((com.facebook.ads.a.f.a) (com.facebook.ads.a.f.g.a(null, a1, new Object[] {
                    context
                })));
                if (a1 == null || ((Integer)a1).intValue() != 0)
                {
                    a1 = null;
                } else
                {
                    a1 = com.facebook.ads.a.f.g.a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[] {
                        android/content/Context
                    });
                    if (a1 == null)
                    {
                        a1 = null;
                    } else
                    {
                        a1 = ((com.facebook.ads.a.f.a) (com.facebook.ads.a.f.g.a(null, a1, new Object[] {
                            context
                        })));
                        if (a1 == null)
                        {
                            a1 = null;
                        } else
                        {
                            java.lang.reflect.Method method = com.facebook.ads.a.f.g.a(a1.getClass(), "getId", new Class[0]);
                            java.lang.reflect.Method method1 = com.facebook.ads.a.f.g.a(a1.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
                            if (method == null || method1 == null)
                            {
                                a1 = null;
                            } else
                            {
                                a1 = new g((String)com.facebook.ads.a.f.g.a(a1, method, new Object[0]), ((Boolean)com.facebook.ads.a.f.g.a(a1, method1, new Object[0])).booleanValue());
                            }
                        }
                    }
                }
            }
            obj = a1;
            if (a1 == null)
            {
                return a(context);
            }
        }
        return ((g) (obj));
    }

}
