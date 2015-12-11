// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package android.support.v7:
//            als, alz, ama, alr, 
//            amd, alw, amc, aly, 
//            anf, ano, alv, amw, 
//            anm

public class alt
{
    public static class a
    {

        private final Context a;
        private alz b[];
        private anm c;
        private Handler d;
        private amc e;
        private boolean f;
        private String g;
        private String h;
        private alw i;

        public transient a a(alz aalz[])
        {
            if (b != null)
            {
                throw new IllegalStateException("Kits already set.");
            } else
            {
                b = aalz;
                return this;
            }
        }

        public alt a()
        {
            if (c == null)
            {
                c = anm.a();
            }
            if (d == null)
            {
                d = new Handler(Looper.getMainLooper());
            }
            Object obj;
            amw amw1;
            if (e == null)
            {
                if (f)
                {
                    e = new als(3);
                } else
                {
                    e = new als();
                }
            }
            if (h == null)
            {
                h = a.getPackageName();
            }
            if (i == null)
            {
                i = alw.d;
            }
            if (b == null)
            {
                obj = new HashMap();
            } else
            {
                obj = alt.a(Arrays.asList(b));
            }
            amw1 = new amw(a, h, g, ((Map) (obj)).values());
            return new alt(a, ((Map) (obj)), c, d, e, f, i, amw1);
        }

        public a(Context context)
        {
            if (context == null)
            {
                throw new IllegalArgumentException("Context must not be null.");
            } else
            {
                a = context.getApplicationContext();
                return;
            }
        }
    }


    static volatile alt a;
    static final amc b = new als();
    final amc c;
    final boolean d;
    private final Context e;
    private final Map f;
    private final ExecutorService g;
    private final Handler h;
    private final alw i;
    private final alw j;
    private final amw k;
    private alr l;
    private WeakReference m;
    private AtomicBoolean n;

    alt(Context context, Map map, anm anm, Handler handler, amc amc1, boolean flag, alw alw1, 
            amw amw)
    {
        e = context;
        f = map;
        g = anm;
        h = handler;
        c = amc1;
        d = flag;
        i = alw1;
        n = new AtomicBoolean(false);
        j = a(map.size());
        k = amw;
    }

    static alt a()
    {
        if (a == null)
        {
            throw new IllegalStateException("Must Initialize Fabric before using singleton()");
        } else
        {
            return a;
        }
    }

    public static transient alt a(Context context, alz aalz[])
    {
        if (a != null) goto _L2; else goto _L1
_L1:
        android/support/v7/alt;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            c((new a(context)).a(aalz).a());
        }
        android/support/v7/alt;
        JVM INSTR monitorexit ;
_L2:
        return a;
        context;
        android/support/v7/alt;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static alz a(Class class1)
    {
        return (alz)a().f.get(class1);
    }

    static Map a(Collection collection)
    {
        return b(collection);
    }

    static AtomicBoolean a(alt alt1)
    {
        return alt1.n;
    }

    private static void a(Map map, Collection collection)
    {
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            alz alz1 = (alz)collection.next();
            map.put(alz1.getClass(), alz1);
            if (alz1 instanceof ama)
            {
                a(map, ((ama)alz1).getKits());
            }
        } while (true);
    }

    static alw b(alt alt1)
    {
        return alt1.i;
    }

    private static Map b(Collection collection)
    {
        HashMap hashmap = new HashMap(collection.size());
        a(hashmap, collection);
        return hashmap;
    }

    private Activity c(Context context)
    {
        if (context instanceof Activity)
        {
            return (Activity)context;
        } else
        {
            return null;
        }
    }

    private static void c(alt alt1)
    {
        a = alt1;
        alt1.j();
    }

    public static amc h()
    {
        if (a == null)
        {
            return b;
        } else
        {
            return a.c;
        }
    }

    public static boolean i()
    {
        if (a == null)
        {
            return false;
        } else
        {
            return a.d;
        }
    }

    private void j()
    {
        a(c(e));
        l = new alr(e);
        l.a(new alr.b() {

            final alt a;

            public void onActivityCreated(Activity activity, Bundle bundle)
            {
                a.a(activity);
            }

            public void onActivityResumed(Activity activity)
            {
                a.a(activity);
            }

            public void onActivityStarted(Activity activity)
            {
                a.a(activity);
            }

            
            {
                a = alt.this;
                super();
            }
        });
        a(e);
    }

    public alt a(Activity activity)
    {
        m = new WeakReference(activity);
        return this;
    }

    alw a(int i1)
    {
        return new alw(i1) {

            final CountDownLatch a;
            final int b;
            final alt c;

            public void a(Exception exception)
            {
                alt.b(c).a(exception);
            }

            public void a(Object obj)
            {
                a.countDown();
                if (a.getCount() == 0L)
                {
                    alt.a(c).set(true);
                    alt.b(c).a(c);
                }
            }

            
            {
                c = alt.this;
                b = i1;
                super();
                a = new CountDownLatch(b);
            }
        };
    }

    void a(Context context)
    {
        Object obj = b(context);
        Object obj1 = g();
        obj = new amd(((Future) (obj)), ((Collection) (obj1)));
        obj1 = new ArrayList(((Collection) (obj1)));
        Collections.sort(((List) (obj1)));
        ((amd) (obj)).injectParameters(context, this, alw.d, k);
        for (Iterator iterator = ((List) (obj1)).iterator(); iterator.hasNext(); ((alz)iterator.next()).injectParameters(context, this, j, k)) { }
        ((amd) (obj)).initialize();
        if (h().a("Fabric", 3))
        {
            context = (new StringBuilder("Initializing ")).append(d()).append(" [Version: ").append(c()).append("], with the following kits:\n");
        } else
        {
            context = null;
        }
        obj1 = ((List) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            alz alz1 = (alz)((Iterator) (obj1)).next();
            alz1.initializationTask.a(((amd) (obj)).initializationTask);
            a(f, alz1);
            alz1.initialize();
            if (context != null)
            {
                context.append(alz1.getIdentifier()).append(" [Version: ").append(alz1.getVersion()).append("]\n");
            }
        } while (true);
        if (context != null)
        {
            h().a("Fabric", context.toString());
        }
    }

    void a(Map map, alz alz1)
    {
        anf anf1 = (anf)alz1.getClass().getAnnotation(android/support/v7/anf);
        if (anf1 != null)
        {
            Class aclass[] = anf1.a();
            int j1 = aclass.length;
label0:
            for (int i1 = 0; i1 < j1; i1++)
            {
                Class class1 = aclass[i1];
                if (class1.isInterface())
                {
                    Iterator iterator = map.values().iterator();
                    do
                    {
                        alz alz2;
                        do
                        {
                            if (!iterator.hasNext())
                            {
                                continue label0;
                            }
                            alz2 = (alz)iterator.next();
                        } while (!class1.isAssignableFrom(alz2.getClass()));
                        alz1.initializationTask.a(alz2.initializationTask);
                    } while (true);
                }
                if ((alz)map.get(class1) == null)
                {
                    throw new ano("Referenced Kit was null, does the kit exist?");
                }
                alz1.initializationTask.a(((alz)map.get(class1)).initializationTask);
            }

        }
    }

    public Activity b()
    {
        if (m != null)
        {
            return (Activity)m.get();
        } else
        {
            return null;
        }
    }

    Future b(Context context)
    {
        context = new alv(context.getPackageCodePath());
        return f().submit(context);
    }

    public String c()
    {
        return "1.3.6.79";
    }

    public String d()
    {
        return "io.fabric.sdk.android:fabric";
    }

    public alr e()
    {
        return l;
    }

    public ExecutorService f()
    {
        return g;
    }

    public Collection g()
    {
        return f.values();
    }

}
