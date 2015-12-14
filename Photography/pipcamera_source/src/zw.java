// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
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

public class zw
{

    static volatile zw a;
    static final aag b = new zv();
    final aag c;
    final boolean d;
    private final Context e;
    private final Map f;
    private final ExecutorService g;
    private final Handler h;
    private final aaa i;
    private final aaa j;
    private final IdManager k;
    private zs l;
    private WeakReference m;
    private AtomicBoolean n;

    zw(Context context, Map map, abw abw, Handler handler, aag aag1, boolean flag, aaa aaa1, 
            IdManager idmanager)
    {
        e = context;
        f = map;
        g = abw;
        h = handler;
        c = aag1;
        d = flag;
        i = aaa1;
        n = new AtomicBoolean(false);
        j = a(map.size());
        k = idmanager;
    }

    public static aad a(Class class1)
    {
        return (aad)a().f.get(class1);
    }

    static Map a(Collection collection)
    {
        return b(collection);
    }

    static AtomicBoolean a(zw zw1)
    {
        return zw1.n;
    }

    static zw a()
    {
        if (a == null)
        {
            throw new IllegalStateException("Must Initialize Fabric before using singleton()");
        } else
        {
            return a;
        }
    }

    public static transient zw a(Context context, aad aaad[])
    {
        if (a != null) goto _L2; else goto _L1
_L1:
        zw;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            c((new zx(context)).a(aaad).a());
        }
        zw;
        JVM INSTR monitorexit ;
_L2:
        return a;
        context;
        zw;
        JVM INSTR monitorexit ;
        throw context;
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
            aad aad1 = (aad)collection.next();
            map.put(aad1.getClass(), aad1);
            if (aad1 instanceof aae)
            {
                a(map, ((aae)aad1).getKits());
            }
        } while (true);
    }

    static aaa b(zw zw1)
    {
        return zw1.i;
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

    private static void c(zw zw1)
    {
        a = zw1;
        zw1.k();
    }

    public static aag h()
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

    public static boolean j()
    {
        return a != null && a.n.get();
    }

    private void k()
    {
        a(c(e));
        l = new zs(e);
        l.a(new zu() {

            final zw a;

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
                a = zw.this;
                super();
            }
        });
        a(e);
    }

    aaa a(int i1)
    {
        return new aaa(i1) {

            final CountDownLatch a;
            final int b;
            final zw c;

            public void a(Exception exception)
            {
                zw.b(c).a(exception);
            }

            public void a(Object obj)
            {
                a.countDown();
                if (a.getCount() == 0L)
                {
                    zw.a(c).set(true);
                    zw.b(c).a(c);
                }
            }

            
            {
                c = zw.this;
                b = i1;
                super();
                a = new CountDownLatch(b);
            }
        };
    }

    public zw a(Activity activity)
    {
        m = new WeakReference(activity);
        return this;
    }

    void a(Context context)
    {
        Object obj = b(context);
        Object obj1 = g();
        obj = new aah(((Future) (obj)), ((Collection) (obj1)));
        obj1 = new ArrayList(((Collection) (obj1)));
        Collections.sort(((List) (obj1)));
        ((aah) (obj)).injectParameters(context, this, aaa.d, k);
        for (Iterator iterator = ((List) (obj1)).iterator(); iterator.hasNext(); ((aad)iterator.next()).injectParameters(context, this, j, k)) { }
        ((aah) (obj)).initialize();
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
            aad aad1 = (aad)((Iterator) (obj1)).next();
            aad1.initializationTask.a(((aah) (obj)).initializationTask);
            a(f, aad1);
            aad1.initialize();
            if (context != null)
            {
                context.append(aad1.getIdentifier()).append(" [Version: ").append(aad1.getVersion()).append("]\n");
            }
        } while (true);
        if (context != null)
        {
            h().a("Fabric", context.toString());
        }
    }

    void a(Map map, aad aad1)
    {
        abp abp1 = (abp)aad1.getClass().getAnnotation(abp);
        if (abp1 != null)
        {
            Class aclass[] = abp1.a();
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
                        aad aad2;
                        do
                        {
                            if (!iterator.hasNext())
                            {
                                continue label0;
                            }
                            aad2 = (aad)iterator.next();
                        } while (!class1.isAssignableFrom(aad2.getClass()));
                        aad1.initializationTask.a(aad2.initializationTask);
                    } while (true);
                }
                if ((aad)map.get(class1) == null)
                {
                    throw new UnmetDependencyException("Referenced Kit was null, does the kit exist?");
                }
                aad1.initializationTask.a(((aad)map.get(class1)).initializationTask);
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
        context = new zz(context.getPackageCodePath());
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

    public zs e()
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
