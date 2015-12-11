// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class PhotoSearchRequest
{

    private byte image[];
    private Boolean includeAddOnItems;

    public PhotoSearchRequest()
    {
    }

    public byte[] getImage()
    {
        return image;
    }

    public Boolean getIncludeAddOnItems()
    {
        return includeAddOnItems;
    }

    public void setImage(byte abyte0[])
    {
        image = abyte0;
    }

    public void setIncludeAddOnItems(Boolean boolean1)
    {
        includeAddOnItems = boolean1;
    }
}
