// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

// Referenced classes of package com.flurry.android:
//            v, fm, FlurryAds

final class gv
{

    private static String p = "FlurryAgent";
    private final ScheduledExecutorService ai = Executors.newSingleThreadScheduledExecutor();
    private Map jh;
    private Map ji;

    gv()
    {
        jh = new HashMap();
        ji = new HashMap();
    }

    final void C(String s)
    {
        this;
        JVM INSTR monitorenter ;
        jh.remove(s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    final v O(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (!ji.containsKey(s)) goto _L2; else goto _L1
_L1:
        s = (Stack)ji.get(s);
        if (s.size() <= 0) goto _L4; else goto _L3
_L3:
        s = (v)((WeakReference)s.peek()).get();
_L6:
        this;
        JVM INSTR monitorexit ;
        return s;
_L4:
        s = null;
        continue; /* Loop/switch isn't completed */
_L2:
        s = null;
        if (true) goto _L6; else goto _L5
_L5:
        s;
        throw s;
    }

    final fm P(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = (fm)jh.remove(s);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    final boolean Q(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = jh.containsKey(s);
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }

    final v a(FlurryAds flurryads, Context context, ViewGroup viewgroup, String s)
    {
        this;
        JVM INSTR monitorenter ;
        v v1 = O(s);
        if (v1 == null) goto _L2; else goto _L1
_L1:
        boolean flag = v1.getContext().equals(context);
        if (!flag) goto _L2; else goto _L3
_L3:
        flurryads = v1;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flurryads;
_L2:
        context = new v(flurryads, context, s, viewgroup, ai);
        viewgroup = (Stack)ji.get(s);
        flurryads = viewgroup;
        if (viewgroup != null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        flurryads = new Stack();
        ji.put(s, flurryads);
        flurryads.push(new WeakReference(context));
        flurryads = context;
        if (true) goto _L5; else goto _L4
_L4:
        flurryads;
        throw flurryads;
    }

    final void a(String s, fm fm1)
    {
        this;
        JVM INSTR monitorenter ;
        jh.put(s, fm1);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    final void d(v v1)
    {
        this;
        JVM INSTR monitorenter ;
        if (v1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        String s;
        Stack stack;
        s = v1.i();
        stack = (Stack)ji.get(s);
        if (stack == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        Iterator iterator = stack.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            WeakReference weakreference = (WeakReference)iterator.next();
            if (v1 != weakreference.get())
            {
                continue;
            }
            if (stack.remove(weakreference))
            {
                (new StringBuilder()).append("removed banner holder for adSpaceName: ").append(v1.i()).toString();
            }
            break;
        } while (true);
        if (stack.size() == 0)
        {
            ji.remove(s);
        }
        if (true) goto _L1; else goto _L3
_L3:
        v1;
        throw v1;
    }

    final List w(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        Iterator iterator;
        arraylist = new ArrayList();
        iterator = ji.values().iterator();
_L5:
        Iterator iterator1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        iterator1 = ((Stack)iterator.next()).iterator();
_L2:
        v v1;
        do
        {
            if (!iterator1.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            v1 = (v)((WeakReference)iterator1.next()).get();
        } while (v1 == null);
        if (context == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (context != v1.getContext()) goto _L2; else goto _L1
_L1:
        arraylist.add(v1);
        if (true) goto _L2; else goto _L3
_L3:
        if (true) goto _L5; else goto _L4
_L4:
        break MISSING_BLOCK_LABEL_112;
        context;
        throw context;
        return arraylist;
    }

}
