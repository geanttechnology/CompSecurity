// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.newrelic.agent.android.analytics.AnalyticAttribute;
import com.newrelic.agent.android.analytics.AnalyticAttributeStore;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SharedPrefsAnalyticAttributeStore
    implements AnalyticAttributeStore
{

    private static final String STORE_FILE = "NRAnalyticAttributeStore";
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final Context context;

    public SharedPrefsAnalyticAttributeStore(Context context1)
    {
        context = context1;
    }

    public void clear()
    {
        log.debug("SharedPrefsAnalyticAttributeStore.clear - flushing stored attributes");
        this;
        JVM INSTR monitorenter ;
        context.getSharedPreferences("NRAnalyticAttributeStore", 0).edit().clear().commit();
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
        int i = context.getSharedPreferences("NRAnalyticAttributeStore", 0).getAll().size();
        log.debug((new StringBuilder()).append("SharedPrefsAnalyticAttributeStore.count - returning ").append(i).toString());
        return i;
    }

    public void delete(AnalyticAttribute analyticattribute)
    {
        this;
        JVM INSTR monitorenter ;
        log.debug((new StringBuilder()).append("SharedPrefsAnalyticAttributeStore.delete - deleting attribute ").append(analyticattribute.getName()).toString());
        context.getSharedPreferences("NRAnalyticAttributeStore", 0).edit().remove(analyticattribute.getName()).commit();
        this;
        JVM INSTR monitorexit ;
        return;
        analyticattribute;
        this;
        JVM INSTR monitorexit ;
        throw analyticattribute;
    }

    public List fetchAll()
    {
        Object obj1;
        log.debug("SharedPrefsAnalyticAttributeStore.fetchAll invoked.");
        obj1 = context.getSharedPreferences("NRAnalyticAttributeStore", 0);
        Object obj = new ArrayList();
        this;
        JVM INSTR monitorenter ;
        obj1 = ((SharedPreferences) (obj1)).getAll();
        this;
        JVM INSTR monitorexit ;
        for (obj1 = ((Map) (obj1)).entrySet().iterator(); ((Iterator) (obj1)).hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj1)).next();
            log.debug((new StringBuilder()).append("SharedPrefsAnalyticAttributeStore.fetchAll - found analytic attribute ").append(entry.getKey()).append("=").append(entry.getValue()).toString());
            if (entry.getValue() instanceof String)
            {
                ((ArrayList) (obj)).add(new AnalyticAttribute(entry.getKey().toString(), entry.getValue().toString(), true));
            } else
            {
                ((ArrayList) (obj)).add(new AnalyticAttribute(entry.getKey().toString(), Float.valueOf(entry.getValue().toString()).floatValue(), true));
            }
        }

        break MISSING_BLOCK_LABEL_208;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        return ((List) (obj));
    }

    public boolean store(AnalyticAttribute analyticattribute)
    {
        this;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor;
        if (!analyticattribute.isPersistent())
        {
            break MISSING_BLOCK_LABEL_165;
        }
        editor = context.getSharedPreferences("NRAnalyticAttributeStore", 0).edit();
        if (!analyticattribute.isStringAttribute())
        {
            break MISSING_BLOCK_LABEL_100;
        }
        log.debug((new StringBuilder()).append("SharedPrefsAnalyticAttributeStore.store - storing analytic attribute ").append(analyticattribute.getName()).append("=").append(analyticattribute.getStringValue()).toString());
        editor.putString(analyticattribute.getName(), analyticattribute.getStringValue());
_L1:
        boolean flag = editor.commit();
        this;
        JVM INSTR monitorexit ;
        return flag;
        log.debug((new StringBuilder()).append("SharedPrefsAnalyticAttributeStore.store - storing analytic attribute ").append(analyticattribute.getName()).append("=").append(analyticattribute.getFloatValue()).toString());
        editor.putFloat(analyticattribute.getName(), analyticattribute.getFloatValue());
          goto _L1
        analyticattribute;
        this;
        JVM INSTR monitorexit ;
        throw analyticattribute;
        this;
        JVM INSTR monitorexit ;
        return false;
    }

}
