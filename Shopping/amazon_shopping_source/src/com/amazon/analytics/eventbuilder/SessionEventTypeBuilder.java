// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics.eventbuilder;

import com.amazon.analytics.session.PriorityQueue;
import com.amazon.analytics.util.Message;
import com.amazon.analytics.util.Preconditions;
import com.amazon.device.analytics.events.Event;
import com.amazon.device.analytics.log.Logger;
import com.amazon.device.analytics.log.Logging;
import java.util.Map;

// Referenced classes of package com.amazon.analytics.eventbuilder:
//            AnalyticsEventBuilder

public abstract class SessionEventTypeBuilder extends AnalyticsEventBuilder
    implements AnalyticsBuilderInterfaces.ActivityNameView, AnalyticsBuilderInterfaces.SessionTypeBuilder
{
    public static class OnPauseBuilder extends SessionEventTypeBuilder
    {

        String getType()
        {
            return "onPause";
        }

        public OnPauseBuilder()
        {
        }
    }

    public static class OnResumeBuilder extends SessionEventTypeBuilder
    {

        String getType()
        {
            return "onResume";
        }

        public OnResumeBuilder()
        {
        }
    }


    private static final Logger logger = Logging.getLogger(com/amazon/analytics/eventbuilder/SessionEventTypeBuilder);
    String activityName;

    private SessionEventTypeBuilder()
    {
    }


    void processEvent(Event event)
    {
        Message message = new Message();
        message.getExtras().put("TimeStamp", Long.valueOf(timestamp));
        message.getExtras().put("PackageName", packageName);
        Map map = message.getExtras();
        int i;
        if (getType().equals("onResume"))
        {
            i = 0;
        } else
        {
            i = 1;
        }
        map.put("SessionFlag", Integer.valueOf(i));
        message.getExtras().put("TailwindEvent", event);
        message.getExtras().put("topic", getType());
        queue.enqueue(message);
        logger.d((new StringBuilder()).append("Published an ").append(getType()).append(" Session event at ").append(message.getExtras().get("TimeStamp")).append(" for package ").append(packageName).toString());
    }

    void setupEventAttributesAndMetrics(Event event)
    {
        super.setupEventAttributesAndMetrics(event);
        event.addAttribute("an", activityName);
        event.addAttribute("os", android.os.Build.VERSION.CODENAME);
        event.addAttribute("ov", android.os.Build.VERSION.RELEASE);
    }

    public AnalyticsBuilderInterfaces.BaseAnalyticsBuilder withActivityName(String s)
    {
        activityName = (String)Preconditions.checkNotNull(s);
        return this;
    }

}
