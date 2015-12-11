// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class ProductWarning
{

    private String header;
    private Integer headerColor;
    private byte icon[];
    private String imageUrl;
    private String message;
    private boolean prominent;
    private String url;

    public ProductWarning()
    {
    }

    public void setHeader(String s)
    {
        header = s;
    }

    public void setHeaderColor(Integer integer)
    {
        headerColor = integer;
    }

    public void setIcon(byte abyte0[])
    {
        icon = abyte0;
    }

    public void setImageUrl(String s)
    {
        imageUrl = s;
    }

    public void setMessage(String s)
    {
        message = s;
    }

    public void setProminent(boolean flag)
    {
        prominent = flag;
    }

    public void setUrl(String s)
    {
        url = s;
    }
}
