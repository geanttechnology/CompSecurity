// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation;

import java.util.HashMap;
import java.util.Map;

public final class MetricCategory extends Enum
{

    private static final MetricCategory $VALUES[];
    public static final MetricCategory DATABASE;
    public static final MetricCategory IMAGE;
    public static final MetricCategory JSON;
    public static final MetricCategory NETWORK;
    public static final MetricCategory NONE;
    public static final MetricCategory VIEW_LAYOUT;
    public static final MetricCategory VIEW_LOADING;
    private static final Map methodMap = new HashMap() {

            
            {
                put("onCreate", MetricCategory.VIEW_LOADING);
            }
    };
    private String categoryName;

    private MetricCategory(String s, int i, String s1)
    {
        super(s, i);
        categoryName = s1;
    }

    public static MetricCategory categoryForMethod(String s)
    {
        if (s == null)
        {
            s = NONE;
        } else
        {
            Object obj = null;
            int i = s.indexOf("#");
            if (i >= 0)
            {
                obj = s.substring(i + 1);
            }
            obj = (MetricCategory)methodMap.get(obj);
            s = ((String) (obj));
            if (obj == null)
            {
                return NONE;
            }
        }
        return s;
    }

    public static MetricCategory valueOf(String s)
    {
        return (MetricCategory)Enum.valueOf(com/newrelic/agent/android/instrumentation/MetricCategory, s);
    }

    public static MetricCategory[] values()
    {
        return (MetricCategory[])$VALUES.clone();
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    static 
    {
        NONE = new MetricCategory("NONE", 0, "None");
        VIEW_LOADING = new MetricCategory("VIEW_LOADING", 1, "View Loading");
        VIEW_LAYOUT = new MetricCategory("VIEW_LAYOUT", 2, "Layout");
        DATABASE = new MetricCategory("DATABASE", 3, "Database");
        IMAGE = new MetricCategory("IMAGE", 4, "Images");
        JSON = new MetricCategory("JSON", 5, "JSON");
        NETWORK = new MetricCategory("NETWORK", 6, "Network");
        $VALUES = (new MetricCategory[] {
            NONE, VIEW_LOADING, VIEW_LAYOUT, DATABASE, IMAGE, JSON, NETWORK
        });
    }
}
