// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.objects;

import java.io.Serializable;

public class EPChannels
    implements Serializable
{

    private static final long serialVersionUID = 0x367e1386e6ffb764L;
    String imageSmall;
    String name;
    String networkCode;
    String networkId;
    String resourceId;
    String slateImageLarge;
    String slateImageMed;
    String slateImageSmall;
    String type;

    public EPChannels(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8)
    {
        name = s;
        type = s1;
        networkId = s2;
        networkCode = s3;
        imageSmall = s4;
        slateImageSmall = s5;
        slateImageMed = s6;
        slateImageLarge = s7;
        resourceId = s8;
    }

    public String getImageSmall()
    {
        return imageSmall;
    }

    public String getName()
    {
        return name;
    }

    public String getNetworkCode()
    {
        return networkCode;
    }

    public String getNetworkId()
    {
        return networkId;
    }

    public String getResourceId()
    {
        return resourceId;
    }

    public String getSlateImageLarge()
    {
        return slateImageLarge;
    }

    public String getSlateImageMed()
    {
        return slateImageMed;
    }

    public String getSlateImageSmall()
    {
        return slateImageSmall;
    }

    public String getType()
    {
        return type;
    }
}
