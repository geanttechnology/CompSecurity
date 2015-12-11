// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.mbe.mediation;


public final class SPTPNVideoEvent extends Enum
{

    private static final SPTPNVideoEvent ENUM$VALUES[];
    public static final SPTPNVideoEvent SPTPNVideoEventAborted;
    public static final SPTPNVideoEvent SPTPNVideoEventAdapterNotIntegrated;
    public static final SPTPNVideoEvent SPTPNVideoEventClosed;
    public static final SPTPNVideoEvent SPTPNVideoEventError;
    public static final SPTPNVideoEvent SPTPNVideoEventFinished;
    public static final SPTPNVideoEvent SPTPNVideoEventNoVideo;
    public static final SPTPNVideoEvent SPTPNVideoEventStarted;
    public static final SPTPNVideoEvent SPTPNVideoEventTimeout;
    private final String text;

    private SPTPNVideoEvent(String s, int i, String s1)
    {
        super(s, i);
        text = s1;
    }

    public static SPTPNVideoEvent valueOf(String s)
    {
        return (SPTPNVideoEvent)Enum.valueOf(com/sponsorpay/publisher/mbe/mediation/SPTPNVideoEvent, s);
    }

    public static SPTPNVideoEvent[] values()
    {
        SPTPNVideoEvent asptpnvideoevent[] = ENUM$VALUES;
        int i = asptpnvideoevent.length;
        SPTPNVideoEvent asptpnvideoevent1[] = new SPTPNVideoEvent[i];
        System.arraycopy(asptpnvideoevent, 0, asptpnvideoevent1, 0, i);
        return asptpnvideoevent1;
    }

    public String toString()
    {
        return text;
    }

    static 
    {
        SPTPNVideoEventStarted = new SPTPNVideoEvent("SPTPNVideoEventStarted", 0, "started");
        SPTPNVideoEventAborted = new SPTPNVideoEvent("SPTPNVideoEventAborted", 1, "aborted");
        SPTPNVideoEventFinished = new SPTPNVideoEvent("SPTPNVideoEventFinished", 2, "finished");
        SPTPNVideoEventClosed = new SPTPNVideoEvent("SPTPNVideoEventClosed", 3, "closed");
        SPTPNVideoEventNoVideo = new SPTPNVideoEvent("SPTPNVideoEventNoVideo", 4, "no_video");
        SPTPNVideoEventTimeout = new SPTPNVideoEvent("SPTPNVideoEventTimeout", 5, "timeout");
        SPTPNVideoEventError = new SPTPNVideoEvent("SPTPNVideoEventError", 6, "error");
        SPTPNVideoEventAdapterNotIntegrated = new SPTPNVideoEvent("SPTPNVideoEventAdapterNotIntegrated", 7, "no_sdk");
        ENUM$VALUES = (new SPTPNVideoEvent[] {
            SPTPNVideoEventStarted, SPTPNVideoEventAborted, SPTPNVideoEventFinished, SPTPNVideoEventClosed, SPTPNVideoEventNoVideo, SPTPNVideoEventTimeout, SPTPNVideoEventError, SPTPNVideoEventAdapterNotIntegrated
        });
    }
}
