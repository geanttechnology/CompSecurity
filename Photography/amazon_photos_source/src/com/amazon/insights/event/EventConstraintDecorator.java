// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.event;

import com.amazon.insights.Event;
import com.amazon.insights.core.log.Logger;
import com.amazon.insights.core.util.StringUtil;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class EventConstraintDecorator
    implements Event
{
    private static class Pair
    {

        private Object key;
        private Object value;

        private Object getKey()
        {
            return key;
        }

        private Object getValue()
        {
            return value;
        }



        public Pair(Object obj, Object obj1)
        {
            key = obj;
            value = obj1;
        }
    }


    private static Logger logger = Logger.getLogger(com/amazon/insights/event/EventConstraintDecorator);
    private final AtomicInteger currentNumOfAttributesAndMetrics = new AtomicInteger(0);
    private final Event decoratedEvent;
    private final int maxAttributesAndMetrics;

    public EventConstraintDecorator(Event event, int i)
    {
        decoratedEvent = event;
        maxAttributesAndMetrics = i;
    }

    public static EventConstraintDecorator newInstance(Event event)
    {
        return new EventConstraintDecorator(event, 20);
    }

    private static Pair processAttribute(String s, String s1)
    {
        String s2 = StringUtil.clipString(s, 50, false);
        if (s2.length() < s.length())
        {
            logger.devw("The attribute key has been trimmed to a length of 50 characters");
        }
        s = StringUtil.clipString(s1, 1000, false);
        if (s.length() < s1.length())
        {
            logger.devw("The attribute value has been trimmed to a length of 1000 characters");
        }
        return new Pair(s2, s);
    }

    private static Pair processMetric(String s, Number number)
    {
        String s1 = StringUtil.clipString(s, 50, false);
        if (s1.length() < s.length())
        {
            logger.devw("The metric key has been trimmed to a length of 50 characters");
        }
        return new Pair(s1, number);
    }

    public void addAttribute(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (s == null || s1 == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        if (!decoratedEvent.hasAttribute(s) && currentNumOfAttributesAndMetrics.get() < maxAttributesAndMetrics)
        {
            s = processAttribute(s, s1);
            decoratedEvent.addAttribute((String)s.getKey(), (String)s.getValue());
            currentNumOfAttributesAndMetrics.incrementAndGet();
        }
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        logger.e("addAttribute", s);
        if (true) goto _L2; else goto _L1
_L1:
        s;
        throw s;
    }

    public void addMetric(String s, Number number)
    {
        this;
        JVM INSTR monitorenter ;
        if (s == null || number == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        if (!decoratedEvent.hasMetric(s) && currentNumOfAttributesAndMetrics.get() < maxAttributesAndMetrics)
        {
            s = processMetric(s, number);
            decoratedEvent.addMetric((String)s.getKey(), (Number)s.getValue());
            currentNumOfAttributesAndMetrics.incrementAndGet();
        }
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        logger.e("addMetric", s);
        if (true) goto _L2; else goto _L1
_L1:
        s;
        throw s;
    }

    public Map getAllAttributes()
    {
        return decoratedEvent.getAllAttributes();
    }

    public Map getAllMetrics()
    {
        return decoratedEvent.getAllMetrics();
    }

    public String getAttribute(String s)
    {
        return decoratedEvent.getAttribute(s);
    }

    public String getEventType()
    {
        return decoratedEvent.getEventType();
    }

    public boolean hasAttribute(String s)
    {
        boolean flag;
        try
        {
            flag = decoratedEvent.hasAttribute(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logger.e("hasAttribute", s);
            return false;
        }
        return flag;
    }

    public boolean hasMetric(String s)
    {
        boolean flag;
        try
        {
            flag = decoratedEvent.hasMetric(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logger.e("hasMetric", s);
            return false;
        }
        return flag;
    }

    public Event withAttribute(String s, String s1)
    {
        try
        {
            addAttribute(s, s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logger.e("withAttribute", s);
        }
        return decoratedEvent;
    }

    public Event withMetric(String s, Number number)
    {
        try
        {
            addMetric(s, number);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logger.e("withMetric", s);
        }
        return decoratedEvent;
    }

}
