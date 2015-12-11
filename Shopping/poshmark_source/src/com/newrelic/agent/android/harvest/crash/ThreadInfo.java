// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest.crash;

import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreadInfo extends HarvestableObject
{

    private boolean crashed;
    private StackTraceElement stackTrace[];
    private String state;
    private long threadId;
    private String threadName;
    private int threadPriority;

    private ThreadInfo()
    {
    }

    public ThreadInfo(Thread thread, StackTraceElement astacktraceelement[])
    {
        crashed = false;
        threadId = thread.getId();
        threadName = thread.getName();
        threadPriority = thread.getPriority();
        stackTrace = astacktraceelement;
        state = thread.getState().toString();
    }

    public ThreadInfo(Throwable throwable)
    {
        crashed = true;
        threadId = Thread.currentThread().getId();
        threadName = Thread.currentThread().getName();
        threadPriority = Thread.currentThread().getPriority();
        stackTrace = throwable.getStackTrace();
        state = Thread.currentThread().getState().toString();
    }

    public static List extractThreads(Throwable throwable)
    {
        ArrayList arraylist = new ArrayList();
        throwable = new ThreadInfo(throwable);
        long l = throwable.getThreadId();
        arraylist.add(throwable);
        throwable = Thread.getAllStackTraces().entrySet().iterator();
        do
        {
            if (!throwable.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)throwable.next();
            Thread thread = (Thread)entry.getKey();
            StackTraceElement astacktraceelement[] = (StackTraceElement[])entry.getValue();
            if (thread.getId() != l)
            {
                arraylist.add(new ThreadInfo(thread, astacktraceelement));
            }
        } while (true);
        return arraylist;
    }

    private JsonArray getStackAsJson()
    {
        JsonArray jsonarray = new JsonArray();
        StackTraceElement astacktraceelement[] = stackTrace;
        int j = astacktraceelement.length;
        for (int i = 0; i < j; i++)
        {
            StackTraceElement stacktraceelement = astacktraceelement[i];
            JsonObject jsonobject = new JsonObject();
            if (stacktraceelement.getFileName() != null)
            {
                jsonobject.add("fileName", SafeJsonPrimitive.factory(stacktraceelement.getFileName()));
            }
            jsonobject.add("className", SafeJsonPrimitive.factory(stacktraceelement.getClassName()));
            jsonobject.add("methodName", SafeJsonPrimitive.factory(stacktraceelement.getMethodName()));
            jsonobject.add("lineNumber", SafeJsonPrimitive.factory(Integer.valueOf(stacktraceelement.getLineNumber())));
            jsonarray.add(jsonobject);
        }

        return jsonarray;
    }

    public static ThreadInfo newFromJson(JsonObject jsonobject)
    {
        ThreadInfo threadinfo = new ThreadInfo();
        threadinfo.crashed = jsonobject.get("crashed").getAsBoolean();
        threadinfo.state = jsonobject.get("state").getAsString();
        threadinfo.threadId = jsonobject.get("threadNumber").getAsLong();
        threadinfo.threadName = jsonobject.get("threadId").getAsString();
        threadinfo.threadPriority = jsonobject.get("priority").getAsInt();
        threadinfo.stackTrace = stackTraceFromJson(jsonobject.get("stack").getAsJsonArray());
        return threadinfo;
    }

    public static List newListFromJson(JsonArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        for (jsonarray = jsonarray.iterator(); jsonarray.hasNext(); arraylist.add(newFromJson(((JsonElement)jsonarray.next()).getAsJsonObject()))) { }
        return arraylist;
    }

    public static StackTraceElement[] stackTraceFromJson(JsonArray jsonarray)
    {
        StackTraceElement astacktraceelement[] = new StackTraceElement[jsonarray.size()];
        int i = 0;
        for (Iterator iterator = jsonarray.iterator(); iterator.hasNext();)
        {
            JsonElement jsonelement = (JsonElement)iterator.next();
            jsonarray = "unknown";
            if (jsonelement.getAsJsonObject().get("fileName") != null)
            {
                jsonarray = jsonelement.getAsJsonObject().get("fileName").getAsString();
            }
            astacktraceelement[i] = new StackTraceElement(jsonelement.getAsJsonObject().get("className").getAsString(), jsonelement.getAsJsonObject().get("methodName").getAsString(), jsonarray, jsonelement.getAsJsonObject().get("lineNumber").getAsInt());
            i++;
        }

        return astacktraceelement;
    }

    public JsonObject asJsonObject()
    {
        JsonObject jsonobject = new JsonObject();
        jsonobject.add("crashed", SafeJsonPrimitive.factory(Boolean.valueOf(crashed)));
        jsonobject.add("state", SafeJsonPrimitive.factory(state));
        jsonobject.add("threadNumber", SafeJsonPrimitive.factory(Long.valueOf(threadId)));
        jsonobject.add("threadId", SafeJsonPrimitive.factory(threadName));
        jsonobject.add("priority", SafeJsonPrimitive.factory(Integer.valueOf(threadPriority)));
        jsonobject.add("stack", getStackAsJson());
        return jsonobject;
    }

    public long getThreadId()
    {
        return threadId;
    }
}
