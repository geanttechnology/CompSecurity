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
        if (log.getLevel() == 4)
        {
            log.verbose("SharedPrefsAnalyticAttributeStore.clear - flushing stored attributes");
        }
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
        if (log.getLevel() == 4)
        {
            log.verbose((new StringBuilder()).append("SharedPrefsAnalyticAttributeStore.count - returning ").append(i).toString());
        }
        return i;
    }

    public void delete(AnalyticAttribute analyticattribute)
    {
        this;
        JVM INSTR monitorenter ;
        if (log.getLevel() == 4)
        {
            log.verbose((new StringBuilder()).append("SharedPrefsAnalyticAttributeStore.delete - deleting attribute ").append(analyticattribute.getName()).toString());
        }
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
        if (log.getLevel() == 4)
        {
            log.verbose("SharedPrefsAnalyticAttributeStore.fetchAll invoked.");
        }
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
            if (entry.getValue() instanceof Float)
            {
                ((ArrayList) (obj)).add(new AnalyticAttribute(entry.getKey().toString(), Float.valueOf(entry.getValue().toString()).floatValue(), true));
            } else
            if (entry.getValue() instanceof Boolean)
            {
                ((ArrayList) (obj)).add(new AnalyticAttribute(entry.getKey().toString(), Boolean.valueOf(entry.getValue().toString()).booleanValue(), true));
            } else
            {
                log.error((new StringBuilder()).append("SharedPrefsAnalyticAttributeStore.fetchAll - unsupported analytic attribute ").append(entry.getKey()).append("=").append(entry.getValue()).toString());
            }
        }

        break MISSING_BLOCK_LABEL_333;
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
            break MISSING_BLOCK_LABEL_290;
        }
        editor = context.getSharedPreferences("NRAnalyticAttributeStore", 0).edit();
        static class _cls1
        {

            static final int $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[];

            static 
            {
                $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType = new int[com.newrelic.agent.android.analytics.AnalyticAttribute.AttributeDataType.values().length];
                try
                {
                    $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[com.newrelic.agent.android.analytics.AnalyticAttribute.AttributeDataType.STRING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[com.newrelic.agent.android.analytics.AnalyticAttribute.AttributeDataType.FLOAT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[com.newrelic.agent.android.analytics.AnalyticAttribute.AttributeDataType.BOOLEAN.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.newrelic.agent.android.analytics.AnalyticAttribute.AttributeDataType[analyticattribute.getAttributeDataType().ordinal()];
        JVM INSTR tableswitch 1 3: default 294
    //                   1 105
    //                   2 170
    //                   3 230;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_230;
_L1:
        log.error((new StringBuilder()).append("SharedPrefsAnalyticAttributeStore.store - unsupported analytic attribute data type").append(analyticattribute.getName()).toString());
_L5:
        boolean flag = editor.commit();
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        log.verbose((new StringBuilder()).append("SharedPrefsAnalyticAttributeStore.store - storing analytic attribute ").append(analyticattribute.getName()).append("=").append(analyticattribute.getStringValue()).toString());
        editor.putString(analyticattribute.getName(), analyticattribute.getStringValue());
          goto _L5
        analyticattribute;
        this;
        JVM INSTR monitorexit ;
        throw analyticattribute;
_L3:
        log.verbose((new StringBuilder()).append("SharedPrefsAnalyticAttributeStore.store - storing analytic attribute ").append(analyticattribute.getName()).append("=").append(analyticattribute.getFloatValue()).toString());
        editor.putFloat(analyticattribute.getName(), analyticattribute.getFloatValue());
          goto _L5
        log.verbose((new StringBuilder()).append("SharedPrefsAnalyticAttributeStore.store - storing analytic attribute ").append(analyticattribute.getName()).append("=").append(analyticattribute.getBooleanValue()).toString());
        editor.putBoolean(analyticattribute.getName(), analyticattribute.getBooleanValue());
          goto _L5
        this;
        JVM INSTR monitorexit ;
        return false;
    }

}
