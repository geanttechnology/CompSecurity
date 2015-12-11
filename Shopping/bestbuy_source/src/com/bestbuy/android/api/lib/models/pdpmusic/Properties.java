// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpmusic;

import gu;
import java.io.Serializable;
import java.util.List;

public class Properties
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String chatType;
    private String contractCondition;
    private String fileSize;
    private String format;
    private String freeShippingCode;
    private String mediaType;
    private List primaryArtist;
    private String topHat;

    public Properties()
    {
    }

    public String getChatType()
    {
        return chatType;
    }

    public String getContractCondition()
    {
        return contractCondition;
    }

    public String getFileSize()
    {
        return fileSize;
    }

    public String getFormat()
    {
        return format;
    }

    public String getFreeShippingCode()
    {
        return freeShippingCode;
    }

    public String getMediaType()
    {
        return mediaType;
    }

    public List getPrimaryArtist()
    {
        return primaryArtist;
    }

    public String getTopHat()
    {
        return topHat;
    }

    public void setChatType(String s)
    {
        chatType = s;
    }

    public void setContractCondition(String s)
    {
        contractCondition = s;
    }

    public void setFileSize(String s)
    {
        fileSize = s;
    }

    public void setFormat(String s)
    {
        format = s;
    }

    public void setFreeShippingCode(String s)
    {
        freeShippingCode = s;
    }

    public void setMediaType(String s)
    {
        mediaType = s;
    }

    public void setPrimaryArtist(List list)
    {
        primaryArtist = list;
    }

    public void setTopHat(String s)
    {
        topHat = s;
    }
}
