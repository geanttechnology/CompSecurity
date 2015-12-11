// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.search;

import java.io.Serializable;

public class Track
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String release;
    private String relevancyVersion;

    public Track()
    {
    }

    public String getRelease()
    {
        return release;
    }

    public String getRelevancyVersion()
    {
        return relevancyVersion;
    }

    public void setRelease(String s)
    {
        release = s;
    }

    public void setRelevancyVersion(String s)
    {
        relevancyVersion = s;
    }
}
