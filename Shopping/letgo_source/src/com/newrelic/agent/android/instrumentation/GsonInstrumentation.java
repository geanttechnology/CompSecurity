// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation;

import android.support.v7.aeu;
import android.support.v7.afa;
import android.support.v7.afb;
import android.support.v7.afi;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
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

    public static Object fromJson(aeu aeu1, afa afa, Class class1)
        throws afi
    {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        aeu1 = ((aeu) (aeu1.a(afa, class1)));
        TraceMachine.exitMethod();
        return aeu1;
    }

    public static Object fromJson(aeu aeu1, afa afa, Type type)
        throws afi
    {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        aeu1 = ((aeu) (aeu1.a(afa, type)));
        TraceMachine.exitMethod();
        return aeu1;
    }

    public static Object fromJson(aeu aeu1, JsonReader jsonreader, Type type)
        throws afb, afi
    {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        aeu1 = ((aeu) (aeu1.a(jsonreader, type)));
        TraceMachine.exitMethod();
        return aeu1;
    }

    public static Object fromJson(aeu aeu1, Reader reader, Class class1)
        throws afi, afb
    {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        aeu1 = ((aeu) (aeu1.a(reader, class1)));
        TraceMachine.exitMethod();
        return aeu1;
    }

    public static Object fromJson(aeu aeu1, Reader reader, Type type)
        throws afb, afi
    {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        aeu1 = ((aeu) (aeu1.a(reader, type)));
        TraceMachine.exitMethod();
        return aeu1;
    }

    public static Object fromJson(aeu aeu1, String s, Class class1)
        throws afi
    {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        aeu1 = ((aeu) (aeu1.a(s, class1)));
        TraceMachine.exitMethod();
        return aeu1;
    }

    public static Object fromJson(aeu aeu1, String s, Type type)
        throws afi
    {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        aeu1 = ((aeu) (aeu1.a(s, type)));
        TraceMachine.exitMethod();
        return aeu1;
    }

    public static String toJson(aeu aeu1, afa afa)
    {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        aeu1 = aeu1.a(afa);
        TraceMachine.exitMethod();
        return aeu1;
    }

    public static String toJson(aeu aeu1, Object obj)
    {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        aeu1 = aeu1.a(obj);
        TraceMachine.exitMethod();
        return aeu1;
    }

    public static String toJson(aeu aeu1, Object obj, Type type)
    {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        aeu1 = aeu1.a(obj, type);
        TraceMachine.exitMethod();
        return aeu1;
    }

    public static void toJson(aeu aeu1, afa afa, JsonWriter jsonwriter)
        throws afb
    {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        aeu1.a(afa, jsonwriter);
        TraceMachine.exitMethod();
    }

    public static void toJson(aeu aeu1, afa afa, Appendable appendable)
        throws afb
    {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        aeu1.a(afa, appendable);
        TraceMachine.exitMethod();
    }

    public static void toJson(aeu aeu1, Object obj, Appendable appendable)
        throws afb
    {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        aeu1.a(obj, appendable);
        TraceMachine.exitMethod();
    }

    public static void toJson(aeu aeu1, Object obj, Type type, JsonWriter jsonwriter)
        throws afb
    {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        aeu1.a(obj, type, jsonwriter);
        TraceMachine.exitMethod();
    }

    public static void toJson(aeu aeu1, Object obj, Type type, Appendable appendable)
        throws afb
    {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        aeu1.a(obj, type, appendable);
        TraceMachine.exitMethod();
    }

}
