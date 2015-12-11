// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.events;

import java.util.HashMap;
import java.util.Map;

public final class VPAIDEvent
{

    public static final String AdClickThru = "AdClickThru";
    public static final String AdDurationChange = "AdDurationChange";
    public static final String AdError = "AdError";
    public static final String AdExpandedChange = "AdExpandedChange";
    public static final String AdImpression = "AdImpression";
    public static final String AdInteraction = "AdInteraction";
    public static final String AdLinearChange = "AdLinearChange";
    public static final String AdLoaded = "AdLoaded";
    public static final String AdLog = "AdLog";
    public static final String AdPaused = "AdPaused";
    public static final String AdPlaying = "AdPlaying";
    public static final String AdRemainingTimeChange = "AdRemainingTimeChange";
    public static final String AdSizeChange = "AdSizeChange";
    public static final String AdSkippableStateChange = "AdSkippableStateChange";
    public static final String AdSkipped = "AdSkipped";
    public static final String AdStarted = "AdStarted";
    public static final String AdStopped = "AdStopped";
    public static final String AdUserAcceptInvitation = "AdUserAcceptInvitation";
    public static final String AdUserClose = "AdUserClose";
    public static final String AdUserMinimize = "AdUserMinimize";
    public static final String AdVideoComplete = "AdVideoComplete";
    public static final String AdVideoFirstQuartile = "AdVideoFirstQuartile";
    public static final String AdVideoMidpoint = "AdVideoMidpoint";
    public static final String AdVideoStart = "AdVideoStart";
    public static final String AdVideoThirdQuartile = "AdVideoThirdQuartile";
    public static final String AdVolumeChange = "AdVolumeChange";
    private String a;
    private Object b;
    private Map c;

    public VPAIDEvent(String s)
    {
        a = s;
    }

    public VPAIDEvent(String s, Map map)
    {
        this(s);
        c = map;
    }

    public Object getParameter(String s)
    {
        if (c == null)
        {
            return null;
        } else
        {
            return c.get(s);
        }
    }

    public Object getTarget()
    {
        return b;
    }

    public String getType()
    {
        return a;
    }

    public void setParameter(String s, Object obj)
    {
        if (c == null)
        {
            c = new HashMap();
        }
        c.put(s, obj);
    }

    public void setTarget(Object obj)
    {
        b = obj;
    }
}
