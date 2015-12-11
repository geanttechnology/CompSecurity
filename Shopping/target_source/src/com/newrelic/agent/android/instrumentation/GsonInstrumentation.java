// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation;

import com.google.b.d.a;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.l;
import com.google.b.m;
import com.google.b.u;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

// Referenced classes of package com.newrelic.agent.android.instrumentation:
//            MetricCategory

public class GsonInstrumentation
{

    private static final ArrayList categoryParams = new ArrayList(Arrays.asList(new String[] {
        "category", com/newrelic/agent/android/instrumentation/MetricCategory.getName(), "JSON"
    }));

    public GsonInstrumentation()
    {
    }

    public static Object fromJson(f f1, a a, Type type)
        throws m, u
    {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        f1 = ((f) (f1.a(a, type)));
        TraceMachine.exitMethod();
        return f1;
    }

    public static Object fromJson(f f1, l l, Class class1)
        throws u
    {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        f1 = ((f) (f1.a(l, class1)));
        TraceMachine.exitMethod();
        return f1;
    }

    public static Object fromJson(f f1, l l, Type type)
        throws u
    {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        f1 = ((f) (f1.a(l, type)));
        TraceMachine.exitMethod();
        return f1;
    }

    public static Object fromJson(f f1, Reader reader, Class class1)
        throws u, m
    {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        f1 = ((f) (f1.a(reader, class1)));
        TraceMachine.exitMethod();
        return f1;
    }

    public static Object fromJson(f f1, Reader reader, Type type)
        throws m, u
    {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        f1 = ((f) (f1.a(reader, type)));
        TraceMachine.exitMethod();
        return f1;
    }

    public static Object fromJson(f f1, String s, Class class1)
        throws u
    {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        f1 = ((f) (f1.a(s, class1)));
        TraceMachine.exitMethod();
        return f1;
    }

    public static Object fromJson(f f1, String s, Type type)
        throws u
    {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        f1 = ((f) (f1.a(s, type)));
        TraceMachine.exitMethod();
        return f1;
    }

    public static String toJson(f f1, l l)
    {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        f1 = f1.a(l);
        TraceMachine.exitMethod();
        return f1;
    }

    public static String toJson(f f1, Object obj)
    {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        f1 = f1.b(obj);
        TraceMachine.exitMethod();
        return f1;
    }

    public static String toJson(f f1, Object obj, Type type)
    {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        f1 = f1.b(obj, type);
        TraceMachine.exitMethod();
        return f1;
    }

    public static void toJson(f f1, l l, c c)
        throws m
    {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        f1.a(l, c);
        TraceMachine.exitMethod();
    }

    public static void toJson(f f1, l l, Appendable appendable)
        throws m
    {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        f1.a(l, appendable);
        TraceMachine.exitMethod();
    }

    public static void toJson(f f1, Object obj, Appendable appendable)
        throws m
    {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        f1.a(obj, appendable);
        TraceMachine.exitMethod();
    }

    public static void toJson(f f1, Object obj, Type type, c c)
        throws m
    {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        f1.a(obj, type, c);
        TraceMachine.exitMethod();
    }

    public static void toJson(f f1, Object obj, Type type, Appendable appendable)
        throws m
    {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        f1.a(obj, type, appendable);
        TraceMachine.exitMethod();
    }

}
