// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp;

import gu;
import java.io.Serializable;

public class Track
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String displayName;
    private String playURL;

    public Track()
    {
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getPlayURL()
    {
        return playURL;
    }

    public void setDisplayName(String s)
    {
        displayName = s;
    }

    public void setPlayURL(String s)
    {
        playURL = s;
    }
}
