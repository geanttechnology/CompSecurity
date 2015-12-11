// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.newrelic.agent.android.crashes.CrashStore;
import com.newrelic.agent.android.harvest.crash.Crash;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class JsonCrashStore
    implements CrashStore
{

    private static final String STORE_FILE = "NRCrashStore";
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final Context context;

    public JsonCrashStore(Context context1)
    {
        context = context1;
    }

    public void clear()
    {
        this;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences("NRCrashStore", 0).edit();
        editor.clear();
        editor.commit();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int count()
    {
        return context.getSharedPreferences("NRCrashStore", 0).getAll().size();
    }

    public void delete(Crash crash)
    {
        this;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences("NRCrashStore", 0).edit();
        editor.remove(crash.getUuid().toString());
        editor.commit();
        this;
        JVM INSTR monitorexit ;
        return;
        crash;
        this;
        JVM INSTR monitorexit ;
        throw crash;
    }

    public List fetchAll()
    {
        Object obj1 = context.getSharedPreferences("NRCrashStore", 0);
        Object obj = new ArrayList();
        this;
        JVM INSTR monitorenter ;
        obj1 = ((SharedPreferences) (obj1)).getAll();
        this;
        JVM INSTR monitorexit ;
        obj1 = ((Map) (obj1)).values().iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            Object obj2 = ((Iterator) (obj1)).next();
            if (obj2 instanceof String)
            {
                try
                {
                    ((List) (obj)).add(Crash.crashFromJsonString((String)obj2));
                }
                catch (Exception exception)
                {
                    log.error("Exception encountered while deserializing crash", exception);
                }
            }
        } while (true);
        break MISSING_BLOCK_LABEL_102;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        return ((List) (obj));
    }

    public void store(Crash crash)
    {
        this;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences("NRCrashStore", 0).edit();
        editor.putString(crash.getUuid().toString(), crash.toJsonString());
        editor.commit();
        this;
        JVM INSTR monitorexit ;
        return;
        crash;
        this;
        JVM INSTR monitorexit ;
        throw crash;
    }

}
