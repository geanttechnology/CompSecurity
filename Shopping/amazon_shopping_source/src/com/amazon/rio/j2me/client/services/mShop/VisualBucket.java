// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

public class VisualBucket
{

    private List attributes;
    private byte bestImage[];
    private String bestImageUrl;
    private List sameAsBucket;

    public VisualBucket()
    {
    }

    public List getAttributes()
    {
        return attributes;
    }

    public byte[] getBestImage()
    {
        return bestImage;
    }

    public String getBestImageUrl()
    {
        return bestImageUrl;
    }

    public List getSameAsBucket()
    {
        return sameAsBucket;
    }

    public void setAttributes(List list)
    {
        attributes = list;
    }

    public void setBestImage(byte abyte0[])
    {
        bestImage = abyte0;
    }

    public void setBestImageUrl(String s)
    {
        bestImageUrl = s;
    }

    public void setSameAsBucket(List list)
    {
        sameAsBucket = list;
    }
}
