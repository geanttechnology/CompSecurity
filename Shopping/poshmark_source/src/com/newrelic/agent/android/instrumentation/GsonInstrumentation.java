// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
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

    public static Object fromJson(Gson gson, JsonElement jsonelement, Class class1)
        throws JsonSyntaxException
    {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        gson = ((Gson) (gson.fromJson(jsonelement, class1)));
        TraceMachine.exitMethod();
        return gson;
    }

    public static Object fromJson(Gson gson, JsonElement jsonelement, Type type)
        throws JsonSyntaxException
    {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        gson = ((Gson) (gson.fromJson(jsonelement, type)));
        TraceMachine.exitMethod();
        return gson;
    }

    public static Object fromJson(Gson gson, JsonReader jsonreader, Type type)
        throws JsonIOException, JsonSyntaxException
    {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        gson = ((Gson) (gson.fromJson(jsonreader, type)));
        TraceMachine.exitMethod();
        return gson;
    }

    public static Object fromJson(Gson gson, Reader reader, Class class1)
        throws JsonSyntaxException, JsonIOException
    {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        gson = ((Gson) (gson.fromJson(reader, class1)));
        TraceMachine.exitMethod();
        return gson;
    }

    public static Object fromJson(Gson gson, Reader reader, Type type)
        throws JsonIOException, JsonSyntaxException
    {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        gson = ((Gson) (gson.fromJson(reader, type)));
        TraceMachine.exitMethod();
        return gson;
    }

    public static Object fromJson(Gson gson, String s, Class class1)
        throws JsonSyntaxException
    {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        gson = ((Gson) (gson.fromJson(s, class1)));
        TraceMachine.exitMethod();
        return gson;
    }

    public static Object fromJson(Gson gson, String s, Type type)
        throws JsonSyntaxException
    {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        gson = ((Gson) (gson.fromJson(s, type)));
        TraceMachine.exitMethod();
        return gson;
    }

    public static String toJson(Gson gson, JsonElement jsonelement)
    {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        gson = gson.toJson(jsonelement);
        TraceMachine.exitMethod();
        return gson;
    }

    public static String toJson(Gson gson, Object obj)
    {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        gson = gson.toJson(obj);
        TraceMachine.exitMethod();
        return gson;
    }

    public static String toJson(Gson gson, Object obj, Type type)
    {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        gson = gson.toJson(obj, type);
        TraceMachine.exitMethod();
        return gson;
    }

    public static void toJson(Gson gson, JsonElement jsonelement, JsonWriter jsonwriter)
        throws JsonIOException
    {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        gson.toJson(jsonelement, jsonwriter);
        TraceMachine.exitMethod();
    }

    public static void toJson(Gson gson, JsonElement jsonelement, Appendable appendable)
        throws JsonIOException
    {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        gson.toJson(jsonelement, appendable);
        TraceMachine.exitMethod();
    }

    public static void toJson(Gson gson, Object obj, Appendable appendable)
        throws JsonIOException
    {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        gson.toJson(obj, appendable);
        TraceMachine.exitMethod();
    }

    public static void toJson(Gson gson, Object obj, Type type, JsonWriter jsonwriter)
        throws JsonIOException
    {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        gson.toJson(obj, type, jsonwriter);
        TraceMachine.exitMethod();
    }

    public static void toJson(Gson gson, Object obj, Type type, Appendable appendable)
        throws JsonIOException
    {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        gson.toJson(obj, type, appendable);
        TraceMachine.exitMethod();
    }

}
