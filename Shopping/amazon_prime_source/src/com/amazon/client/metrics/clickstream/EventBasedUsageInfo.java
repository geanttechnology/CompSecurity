// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.clickstream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.client.metrics.clickstream:
//            ClickStreamInfo, ClickStreamHelper

public class EventBasedUsageInfo
    implements ClickStreamInfo
{
    public static final class ACTION extends Enum
    {

        private static final ACTION $VALUES[];
        public static final ACTION CONSUMPTION;
        public static final ACTION DISCOVERY;
        public static final ACTION INTENTION;
        public static final ACTION TRANSACTION;

        public static ACTION valueOf(String s)
        {
            return (ACTION)Enum.valueOf(com/amazon/client/metrics/clickstream/EventBasedUsageInfo$ACTION, s);
        }

        public static ACTION[] values()
        {
            return (ACTION[])$VALUES.clone();
        }

        static 
        {
            INTENTION = new ACTION("INTENTION", 0);
            DISCOVERY = new ACTION("DISCOVERY", 1);
            TRANSACTION = new ACTION("TRANSACTION", 2);
            CONSUMPTION = new ACTION("CONSUMPTION", 3);
            $VALUES = (new ACTION[] {
                INTENTION, DISCOVERY, TRANSACTION, CONSUMPTION
            });
        }

        private ACTION(String s, int i)
        {
            super(s, i);
        }
    }

    public static class EventBasedUsageInfoBuilder
    {

        private ACTION _action;
        private Map _keys;
        private String _prefix;
        private String _suffix;
        private String _type;

        public EventBasedUsageInfo build()
        {
            if (_prefix == null || _prefix.length() == 0)
            {
                throw new IllegalArgumentException("prefix can not be null or empty");
            }
            if (_suffix == null || _suffix.length() == 0)
            {
                throw new IllegalArgumentException("suffix can not be null or empty");
            }
            if (_action == null)
            {
                throw new IllegalArgumentException("action can not be null");
            }
            if (_keys != null && (_keys.containsKey(EventBasedUsageInfo.ACTION) || _keys.containsKey(EventBasedUsageInfo.TYPE)))
            {
                throw new IllegalArgumentException("Not null keys can not contain action or type as key");
            } else
            {
                return new EventBasedUsageInfo(_prefix, _suffix, _action, _type, _keys);
            }
        }

        public EventBasedUsageInfoBuilder withAction(ACTION action1)
        {
            _action = action1;
            return this;
        }

        public EventBasedUsageInfoBuilder withKeys(Map map)
        {
            _keys = map;
            return this;
        }

        public EventBasedUsageInfoBuilder withPrefix(String s)
        {
            _prefix = s;
            return this;
        }

        public EventBasedUsageInfoBuilder withSuffix(String s)
        {
            _suffix = s;
            return this;
        }

        public EventBasedUsageInfoBuilder withType(String s)
        {
            _type = s;
            return this;
        }

        public EventBasedUsageInfoBuilder()
        {
        }
    }


    private static String ACTION = "action";
    private static String DOT = ".";
    private static String HYPHEN = "-";
    private static String TYPE = "type";
    private ACTION action;
    private Map keys;
    private String prefix;
    private String suffix;
    private String type;

    private EventBasedUsageInfo(String s, String s1, ACTION action1, String s2, Map map)
    {
        prefix = s;
        suffix = s1;
        action = action1;
        type = s2;
        keys = map;
    }


    public List getDataPoints()
    {
        ArrayList arraylist = new ArrayList();
        ClickStreamHelper.addDatapoint(arraylist, (new StringBuilder()).append(prefix).append(HYPHEN).append(ACTION).append(DOT).append(suffix).toString(), action.toString());
        ClickStreamHelper.addDatapoint(arraylist, (new StringBuilder()).append(prefix).append(HYPHEN).append(TYPE).append(DOT).append(suffix).toString(), type);
        java.util.Map.Entry entry;
        for (Iterator iterator = keys.entrySet().iterator(); iterator.hasNext(); ClickStreamHelper.addDatapoint(arraylist, (new StringBuilder()).append(prefix).append(HYPHEN).append((String)entry.getKey()).append(DOT).append(suffix).toString(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return arraylist;
    }



}
