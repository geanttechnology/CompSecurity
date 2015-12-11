// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import c.a.a.a.a.b.x;
import c.a.a.a.a.c.n;
import c.a.a.a.a.c.w;
import c.a.a.a.a.c.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package c.a.a.a:
//            q, g, h, a, 
//            f, j, r, k, 
//            n, m, o

public class e
{

    private static volatile e a;
    private static q b = new q();
    private final Context c;
    private final Map d;
    private final ExecutorService e;
    private final k f;
    private final k g;
    private final x h;
    private a i;
    private WeakReference j;
    private AtomicBoolean k;
    private q l;
    private boolean m;

    e(Context context, Map map, w w, Handler handler, q q1, boolean flag, k k1, 
            x x)
    {
        c = context;
        d = map;
        e = w;
        l = q1;
        m = flag;
        f = k1;
        k = new AtomicBoolean(false);
        g = new g(this, map.size());
        h = x;
    }

    public static transient e a(Context context, c.a.a.a.n an[])
    {
        Iterator iterator = null;
        if (a != null) goto _L2; else goto _L1
_L1:
        c/a/a/a/e;
        JVM INSTR monitorenter ;
        if (a != null)
        {
            break MISSING_BLOCK_LABEL_367;
        }
        an = (new h(context)).a(an).a();
        a = an;
        context = ((e) (an)).c;
        if (!(context instanceof Activity)) goto _L4; else goto _L3
_L3:
        context = (Activity)context;
_L6:
        Object obj;
        Object obj1;
        an.a(((Activity) (context)));
        an.i = new a(((e) (an)).c);
        ((e) (an)).i.a(new f(an));
        context = ((e) (an)).c;
        obj = new j(context.getPackageCodePath());
        obj = ((e) (an)).e.submit(((java.util.concurrent.Callable) (obj)));
        obj1 = ((e) (an)).d.values();
        obj = new r(((java.util.concurrent.Future) (obj)), ((Collection) (obj1)));
        obj1 = new ArrayList(((Collection) (obj1)));
        Collections.sort(((List) (obj1)));
        ((r) (obj)).injectParameters(context, an, k.a, ((e) (an)).h);
        for (Iterator iterator1 = ((List) (obj1)).iterator(); iterator1.hasNext(); ((c.a.a.a.n)iterator1.next()).injectParameters(context, an, ((e) (an)).g, ((e) (an)).h)) { }
        break MISSING_BLOCK_LABEL_226;
        context;
        c/a/a/a/e;
        JVM INSTR monitorexit ;
        throw context;
_L4:
        context = null;
        if (true) goto _L6; else goto _L5
_L5:
        ((r) (obj)).initialize();
        context = iterator;
        if (d().a(3))
        {
            context = (new StringBuilder("Initializing io.fabric.sdk.android:fabric")).append(" [Version: 1.3.6.79").append("], with the following kits:\n");
        }
        iterator = ((List) (obj1)).iterator();
_L8:
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_351;
            }
            obj1 = (c.a.a.a.n)iterator.next();
            ((c.a.a.a.n) (obj1)).initializationTask.a(((r) (obj)).initializationTask);
            a(((e) (an)).d, ((c.a.a.a.n) (obj1)));
            ((c.a.a.a.n) (obj1)).initialize();
        } while (context == null);
        context.append(((c.a.a.a.n) (obj1)).getIdentifier()).append(" [Version: ").append(((c.a.a.a.n) (obj1)).getVersion()).append("]\n");
        if (true) goto _L8; else goto _L7
_L7:
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_367;
        }
        d().a("Fabric", context.toString());
        c/a/a/a/e;
        JVM INSTR monitorexit ;
_L2:
        return a;
    }

    public static c.a.a.a.n a(Class class1)
    {
        if (a == null)
        {
            throw new IllegalStateException("Must Initialize Fabric before using singleton()");
        } else
        {
            return (c.a.a.a.n)a.d.get(class1);
        }
    }

    static Map a(Collection collection)
    {
        HashMap hashmap = new HashMap(collection.size());
        a(((Map) (hashmap)), collection);
        return hashmap;
    }

    static AtomicBoolean a(e e1)
    {
        return e1.k;
    }

    private static void a(Map map, c.a.a.a.n n1)
    {
        n n2 = (n)n1.getClass().getAnnotation(c/a/a/a/a/c/n);
        if (n2 != null)
        {
            Class aclass[] = n2.a();
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
                        c.a.a.a.n n3;
                        do
                        {
                            if (!iterator.hasNext())
                            {
                                continue label0;
                            }
                            n3 = (c.a.a.a.n)iterator.next();
                        } while (!class1.isAssignableFrom(n3.getClass()));
                        n1.initializationTask.a(n3.initializationTask);
                    } while (true);
                }
                if ((c.a.a.a.n)map.get(class1) == null)
                {
                    throw new z("Referenced Kit was null, does the kit exist?");
                }
                n1.initializationTask.a(((c.a.a.a.n)map.get(class1)).initializationTask);
            }

        }
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
            c.a.a.a.n n1 = (c.a.a.a.n)collection.next();
            map.put(n1.getClass(), n1);
            if (n1 instanceof o)
            {
                a(map, ((o)n1).getKits());
            }
        } while (true);
    }

    static k b(e e1)
    {
        return e1.f;
    }

    public static q d()
    {
        if (a == null)
        {
            return b;
        } else
        {
            return a.l;
        }
    }

    public static boolean e()
    {
        if (a == null)
        {
            return false;
        } else
        {
            return a.m;
        }
    }

    public final Activity a()
    {
        if (j != null)
        {
            return (Activity)j.get();
        } else
        {
            return null;
        }
    }

    public final e a(Activity activity)
    {
        j = new WeakReference(activity);
        return this;
    }

    public final a b()
    {
        return i;
    }

    public final ExecutorService c()
    {
        return e;
    }

}
