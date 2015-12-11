// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mdotm.android.vast;

import java.io.Serializable;
import java.util.ArrayList;

// Referenced classes of package com.mdotm.android.vast:
//            Companion

public class VastAd
    implements Serializable
{

    protected static boolean isNonLinear = false;
    private static final long serialVersionUID = 0xaa336ba13604f21eL;
    protected String adSystem;
    protected String adTitle;
    protected Companion companion;
    protected String description;
    protected ArrayList error;
    protected ArrayList impression;
    protected boolean liniearAndCompanion;
    protected ArrayList servey;
    protected ArrayList staticOverlayUrls;
    private int status;
    protected ArrayList vastAds;

    public VastAd()
    {
        servey = new ArrayList();
        error = new ArrayList();
        impression = new ArrayList();
        vastAds = new ArrayList();
        staticOverlayUrls = new ArrayList();
        companion = new Companion();
        liniearAndCompanion = false;
    }

    public String getAdSystem()
    {
        return adSystem;
    }

    public String getAdTitle()
    {
        return adTitle;
    }

    public String getDescription()
    {
        return description;
    }

    public ArrayList getError()
    {
        return error;
    }

    public ArrayList getImpression()
    {
        return impression;
    }

    public ArrayList getServey()
    {
        return servey;
    }

    public ArrayList getStaticOverlay()
    {
        return staticOverlayUrls;
    }

    public int getStatus()
    {
        return status;
    }

    public ArrayList getVastAds()
    {
        return vastAds;
    }

    public void setAdSystem(String s)
    {
        adSystem = s;
    }

    public void setAdTitle(String s)
    {
        adTitle = s;
    }

    public void setDescription(String s)
    {
        description = s;
    }

    public void setError(ArrayList arraylist)
    {
        error = arraylist;
    }

    public void setImpression(ArrayList arraylist)
    {
        impression = arraylist;
    }

    public void setServey(ArrayList arraylist)
    {
        servey = arraylist;
    }

    public void setStatus(int i)
    {
        status = i;
    }

    public void setVastAds(ArrayList arraylist)
    {
        vastAds = arraylist;
    }

    static 
    {
        isNonLinear = false;
    }
}
