// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.a.a;

import android.content.Context;
import android.os.AsyncTask;
import com.j.a.d.e;
import com.j.a.g.w;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import dalvik.system.DexFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

// Referenced classes of package com.j.a.a.a:
//            l, i, b

class d extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    final l a;

    private d(l l1)
    {
        a = l1;
        super();
    }

    d(l l1, b b)
    {
        this(l1);
    }

    public void _nr_setTrace(Trace trace)
    {
        try
        {
            _nr_trace = trace;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Trace trace)
        {
            return;
        }
    }

    protected final transient Void a(Void avoid[])
    {
        boolean flag = false;
        if (l.a(a) != null && l.b(a) != null && l.c(a) != null && l.d(a) != null && a.d != null) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        obj = new DexFile(e.e().o().getPackageCodePath());
        obj1 = ((DexFile) (obj)).entries();
_L4:
        boolean flag1 = ((Enumeration) (obj1)).hasMoreElements();
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        Object obj2 = Class.forName((String)((Enumeration) (obj1)).nextElement());
        i j;
        int k;
        int i1;
        try
        {
            avoid = ((Class) (obj2)).getDeclaredFields();
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid = null;
        }
        if (avoid == null) goto _L4; else goto _L3
_L3:
        if (!((Class) (obj2)).getCanonicalName().contains("com.flurry.sdk") || avoid.length <= 30) goto _L4; else goto _L5
_L5:
        w.a((new StringBuilder()).append("Found flurry gy: ").append(((Class) (obj2)).getCanonicalName()).toString());
        l.a(a, ((Class) (obj2)));
        a.d = avoid;
        obj = ((DexFile) (obj)).entries();
_L11:
        flag1 = ((Enumeration) (obj)).hasMoreElements();
        if (!flag1) goto _L7; else goto _L6
_L6:
        obj1 = Class.forName((String)((Enumeration) (obj)).nextElement());
        try
        {
            avoid = ((Class) (obj1)).getDeclaredMethods();
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid = null;
        }
        if (avoid == null) goto _L9; else goto _L8
_L8:
        i1 = avoid.length;
        k = 0;
_L27:
        if (k >= i1) goto _L9; else goto _L10
_L10:
        if (avoid[k].getReturnType() != l.d(a))
        {
            break MISSING_BLOCK_LABEL_678;
        }
        w.a((new StringBuilder()).append("found flurry fu: ").append(((Class) (obj1)).getCanonicalName()).toString());
        l.b(a, ((Class) (obj1)));
_L9:
        avoid = l.c(a);
        if (avoid == null) goto _L11; else goto _L7
_L7:
        if (l.c(a) == null) goto _L2; else goto _L12
_L12:
        avoid = l.c(a).getDeclaredMethods();
        i1 = avoid.length;
        k = 0;
_L25:
        if (k >= i1) goto _L2; else goto _L13
_L13:
        obj = avoid[k];
        if (((Method) (obj)).getReturnType() != l.c(a)) goto _L15; else goto _L14
_L14:
        l.a(a, ((Method) (obj)));
_L24:
        if (l.a(a) == null || l.b(a) == null) goto _L16; else goto _L2
_L2:
        if (l.b(a) == null || l.a(a) == null || a.d == null || l.c(a) == null || l.d(a) == null) goto _L18; else goto _L17
_L17:
        l.b(a).setAccessible(true);
        l.a(a).setAccessible(true);
        avoid = ((Void []) (l.a(a).invoke(l.b(a).invoke(l.d(a), new Object[0]), new Object[0])));
        if (avoid == null) goto _L18; else goto _L19
_L19:
        obj = a.d;
        i1 = obj.length;
        k = ((flag) ? 1 : 0);
_L26:
        if (k >= i1) goto _L18; else goto _L20
_L20:
        obj1 = obj[k];
        if (((Field) (obj1)).getType() != java/util/Map || ((Field) (obj1)).getType() == com/j/a/a/a/i) goto _L22; else goto _L21
_L21:
        ((Field) (obj1)).setAccessible(true);
        obj2 = (Map)((Field) (obj1)).get(avoid);
        j = new i();
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_570;
        }
        j.putAll(((Map) (obj2)));
        ((Field) (obj1)).set(avoid, j);
          goto _L22
_L15:
        if (((Method) (obj)).getReturnType() != l.d(a) || ((Method) (obj)).getParameterTypes().length != 0) goto _L24; else goto _L23
_L23:
        l.b(a, ((Method) (obj)));
          goto _L24
        avoid;
        if (avoid instanceof Exception)
        {
            avoid = (Exception)avoid;
        } else
        {
            avoid = null;
        }
        w.b("Flry problems", avoid);
_L18:
        return null;
_L16:
        k++;
          goto _L25
        avoid;
          goto _L11
        avoid;
          goto _L4
_L22:
        k++;
          goto _L26
        k++;
          goto _L27
    }

    protected Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "d#doInBackground", null);
_L1:
        aobj = a((Void[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "d#doInBackground", null);
          goto _L1
    }
}
