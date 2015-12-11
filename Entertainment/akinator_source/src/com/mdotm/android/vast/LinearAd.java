// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mdotm.android.vast;

import java.util.ArrayList;

// Referenced classes of package com.mdotm.android.vast:
//            BaseVastAd, AdResource, LinearAdTrackingEvents

public class LinearAd extends BaseVastAd
{

    private static final long serialVersionUID = 1L;
    protected AdResource adResource;
    protected String closeBtnLocation;
    protected String closeBtnSize;
    protected String duration;
    protected String skipOffset;
    protected LinearAdTrackingEvents trackingEvents;
    protected ArrayList videoClickTracking;
    protected ArrayList videoClicks;

    public LinearAd()
    {
        videoClicks = new ArrayList();
        videoClickTracking = new ArrayList();
    }

    public AdResource getAdResource()
    {
        return adResource;
    }

    public String getDuration()
    {
        return duration;
    }

    public LinearAdTrackingEvents getTrackingEvents()
    {
        return trackingEvents;
    }

    public ArrayList getVideoClickTrack()
    {
        return videoClickTracking;
    }

    public ArrayList getVideoClicks()
    {
        return videoClicks;
    }

    public void setAdResource(AdResource adresource)
    {
        adResource = adresource;
    }

    public void setDuration(String s)
    {
        duration = s;
    }

    public void setTrackingEvents(LinearAdTrackingEvents linearadtrackingevents)
    {
        trackingEvents = linearadtrackingevents;
    }

    public void setVideoClicks(ArrayList arraylist)
    {
        videoClicks = arraylist;
    }
}
