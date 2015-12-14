// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.util;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

// Referenced classes of package com.socialin.android.picsart.profile.util:
//            CardVisibilityTracker, c, f, ac, 
//            Timer, b

public final class a
{

    public final CardVisibilityTracker a;
    public final Map b;
    public Map c;
    public final Map d;
    public b e;
    public boolean f;
    private final Handler g;
    private final c h;
    private f i;
    private boolean j;

    public a(Context context)
    {
        this(((Map) (new WeakHashMap())), ((Map) (new WeakHashMap())), new CardVisibilityTracker(context), new Handler());
    }

    private a(Map map, Map map1, CardVisibilityTracker cardvisibilitytracker, Handler handler)
    {
        j = false;
        f = false;
        b = map;
        d = map1;
        a = cardvisibilitytracker;
        c = new WeakHashMap();
        g = handler;
        h = new c(this);
    }

    static void a(a a1)
    {
        a1.d();
    }

    private void d()
    {
        (new StringBuilder("all clear ")).append(toString());
        b.clear();
        d.clear();
        g.removeMessages(0);
        CardVisibilityTracker cardvisibilitytracker = a;
        cardvisibilitytracker.c.clear();
        cardvisibilitytracker.e.removeMessages(0);
        cardvisibilitytracker.f = false;
        b.putAll(c);
        View view;
        for (Iterator iterator = c.keySet().iterator(); iterator.hasNext(); a.a(view))
        {
            view = (View)iterator.next();
        }

        c.clear();
        f = false;
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
        (new StringBuilder("Destroy timers ")).append(toString());
        f = true;
        b();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(View view)
    {
        b.remove(view);
        b(view);
        a.c.remove(view);
    }

    public final void a(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        (new StringBuilder("Start Tracking ")).append(toString());
        if (!j && !flag)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        CardVisibilityTracker cardvisibilitytracker;
        f f1;
        Object obj;
        i = new f(this);
        cardvisibilitytracker = a;
        f1 = i;
        obj = (View)cardvisibilitytracker.b.get();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        obj = ((View) (obj)).getViewTreeObserver();
        if (((ViewTreeObserver) (obj)).isAlive())
        {
            cardvisibilitytracker.a = new CardVisibilityTracker._cls1(cardvisibilitytracker);
            ((ViewTreeObserver) (obj)).addOnPreDrawListener(cardvisibilitytracker.a);
        }
        cardvisibilitytracker.d = f1;
        a.a();
        j = false;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    final void b()
    {
        if (j && g.hasMessages(0))
        {
            return;
        }
        if (f)
        {
            d();
        }
        g.post(h);
    }

    final void b(View view)
    {
        d.remove(view);
    }

    public final void c()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        (new StringBuilder("Stop timers ")).append(toString()).append("   ").append(d.toString());
        obj = d.values().iterator();
_L2:
        Object obj1;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_94;
            }
            obj1 = (ac)((Iterator) (obj)).next();
        } while (obj1 == null);
        if (((ac) (obj1)).b.c()) goto _L2; else goto _L1
_L1:
        ((ac) (obj1)).a();
          goto _L2
        Exception exception;
        exception;
        throw exception;
        b();
        exception = a;
        obj1 = (View)((CardVisibilityTracker) (exception)).b.get();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        if (((CardVisibilityTracker) (exception)).a != null)
        {
            obj1 = ((View) (obj1)).getViewTreeObserver();
            if (((ViewTreeObserver) (obj1)).isAlive())
            {
                ((ViewTreeObserver) (obj1)).removeOnPreDrawListener(((CardVisibilityTracker) (exception)).a);
            }
            exception.a = null;
        }
        exception.d = null;
        i = null;
        j = true;
        this;
        JVM INSTR monitorexit ;
    }

    public final String toString()
    {
        return (new StringBuilder()).append(hashCode()).append(" tDestroy = ").append(f).append(" , tStopped = ").append(j).toString();
    }
}
