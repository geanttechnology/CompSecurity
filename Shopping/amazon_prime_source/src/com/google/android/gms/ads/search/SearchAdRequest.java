// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.search;

import com.google.android.gms.internal.as;

public final class SearchAdRequest
{

    public static final String DEVICE_ID_EMULATOR;
    private final int rR;
    private final int rS;
    private final int rT;
    private final int rU;
    private final int rV;
    private final int rW;
    private final int rX;
    private final int rY;
    private final String rZ;
    private final int sa;
    private final String sb;
    private final int sc;
    private final int sd;
    private final String se;

    public int getAnchorTextColor()
    {
        return rR;
    }

    public int getBackgroundColor()
    {
        return rS;
    }

    public int getBackgroundGradientBottom()
    {
        return rT;
    }

    public int getBackgroundGradientTop()
    {
        return rU;
    }

    public int getBorderColor()
    {
        return rV;
    }

    public int getBorderThickness()
    {
        return rW;
    }

    public int getBorderType()
    {
        return rX;
    }

    public int getCallButtonColor()
    {
        return rY;
    }

    public String getCustomChannels()
    {
        return rZ;
    }

    public int getDescriptionTextColor()
    {
        return sa;
    }

    public String getFontFace()
    {
        return sb;
    }

    public int getHeaderTextColor()
    {
        return sc;
    }

    public int getHeaderTextSize()
    {
        return sd;
    }

    public String getQuery()
    {
        return se;
    }

    static 
    {
        DEVICE_ID_EMULATOR = as.DEVICE_ID_EMULATOR;
    }
}
