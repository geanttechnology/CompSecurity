// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.models.api;

import java.io.Serializable;
import java.util.ArrayList;

public class Ads
    implements Serializable
{

    private ArrayList ad;
    private String label;
    private String type;

    public Ads()
    {
        ad = null;
        type = null;
        label = null;
    }

    public ArrayList getAd()
    {
        return ad;
    }

    public String getType()
    {
        return type;
    }
}
