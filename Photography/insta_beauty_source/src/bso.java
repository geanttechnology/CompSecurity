// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class bso
{

    static volatile bso a;
    static final btb b = new bsn();
    final btb c;
    final boolean d;
    private final Context e;
    private final Map f;
    private final ExecutorService g;
    private final Handler h;
    private final bsu i;
    private final bsu j;
    private final IdManager k;
    private bsj l;
    private WeakReference m;
    private AtomicBoolean n;

    bso(Context context, Map map, bvf bvf, Handler handler, btb btb1, boolean flag, bsu bsu1, 
            IdManager idmanager)
    {
        e = context;
        f = map;
        g = bvf;
        h = handler;
        c = btb1;
        d = flag;
        i = bsu1;
        n = new AtomicBoolean(false);
        j = a(map.size());
        k = idmanager;
    }

    static bso a()
    {
        if (a == null)
        {
            throw new IllegalStateException("Must Initialize Fabric before using singleton()");
        } else
        {
            return a;
        }
    }

    public static transient bso a(Context context, bsy absy[])
    {
        if (a != null) goto _L2; else goto _L1
_L1:
        bso;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            c((new bsr(context)).a(absy).a());
        }
        bso;
        JVM INSTR monitorexit ;
_L2:
        return a;
        context;
        bso;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static bsy a(Class class1)
    {
        return (bsy)a().f.get(class1);
    }

    static Map a(Collection collection)
    {
        return b(collection);
    }

    static AtomicBoolean a(bso bso1)
    {
        return bso1.n;
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
            bsy bsy1 = (bsy)collection.next();
            map.put(bsy1.getClass(), bsy1);
            if (bsy1 instanceof bsz)
            {
                a(map, ((bsz)bsy1).getKits());
            }
        } while (true);
    }

    static bsu b(bso bso1)
    {
        return bso1.i;
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

    private static void c(bso bso1)
    {
        a = bso1;
        bso1.k();
    }

    public static btb h()
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
        l = new bsj(e);
        l.a(new bsp(this));
        a(e);
    }

    public bso a(Activity activity)
    {
        m = new WeakReference(activity);
        return this;
    }

    bsu a(int i1)
    {
        return new bsq(this, i1);
    }

    void a(Context context)
    {
        Object obj = b(context);
        Object obj1 = g();
        obj = new btc(((Future) (obj)), ((Collection) (obj1)));
        obj1 = new ArrayList(((Collection) (obj1)));
        Collections.sort(((List) (obj1)));
        ((btc) (obj)).injectParameters(context, this, bsu.d, k);
        for (Iterator iterator = ((List) (obj1)).iterator(); iterator.hasNext(); ((bsy)iterator.next()).injectParameters(context, this, j, k)) { }
        ((btc) (obj)).initialize();
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
            bsy bsy1 = (bsy)((Iterator) (obj1)).next();
            bsy1.initializationTask.a(((btc) (obj)).initializationTask);
            a(f, bsy1);
            bsy1.initialize();
            if (context != null)
            {
                context.append(bsy1.getIdentifier()).append(" [Version: ").append(bsy1.getVersion()).append("]\n");
            }
        } while (true);
        if (context != null)
        {
            h().a("Fabric", context.toString());
        }
    }

    void a(Map map, bsy bsy1)
    {
        bux bux1 = (bux)bsy1.getClass().getAnnotation(bux);
        if (bux1 != null)
        {
            Class aclass[] = bux1.a();
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
                        bsy bsy2;
                        do
                        {
                            if (!iterator.hasNext())
                            {
                                continue label0;
                            }
                            bsy2 = (bsy)iterator.next();
                        } while (!class1.isAssignableFrom(bsy2.getClass()));
                        bsy1.initializationTask.a(bsy2.initializationTask);
                    } while (true);
                }
                if ((bsy)map.get(class1) == null)
                {
                    throw new UnmetDependencyException("Referenced Kit was null, does the kit exist?");
                }
                bsy1.initializationTask.a(((bsy)map.get(class1)).initializationTask);
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
        context = new bst(context.getPackageCodePath());
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

    public bsj e()
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
