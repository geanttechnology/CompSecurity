// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics.session;

import com.amazon.analytics.util.Message;
import com.amazon.device.analytics.events.EventRecorder;
import com.amazon.device.analytics.log.Logger;
import com.amazon.device.analytics.log.Logging;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.analytics.session:
//            PackageSessionBuilder, PackageSession

public class SessionObserver
{

    private static final Logger logger = Logging.getLogger(com/amazon/analytics/session/SessionObserver);
    private final EventRecorder recorder;
    private final PackageSessionBuilder sessionBuilder;

    public SessionObserver(EventRecorder eventrecorder, PackageSessionBuilder packagesessionbuilder)
    {
        recorder = eventrecorder;
        sessionBuilder = packagesessionbuilder;
    }

    private Set getPackageSessionsThatCareAbout(Message message)
    {
        HashSet hashset = new HashSet();
        message = message.getExtras().get("PackageName").toString();
        hashset.add(sessionBuilder.getInstance(message));
        return hashset;
    }

    public void onUpdate(Message message)
    {
        logger.v("Enter onUpdate");
        logger.d((new StringBuilder()).append("Received an ").append(message.getExtras().get("topic")).append(" Session event at ").append(message.getExtras().get("TimeStamp")).append(" for package ").append(message.getExtras().get("PackageName").toString()).toString());
        Iterator iterator = getPackageSessionsThatCareAbout(message).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.amazon.device.analytics.events.Event event = ((PackageSession)iterator.next()).tryChangeSessionState(message);
            if (event != null)
            {
                recorder.recordEvent(event);
            }
        } while (true);
        logger.v("Exit onUpdate");
    }

}
