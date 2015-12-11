// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.models.api;

import java.io.Serializable;

public class Asset
    implements Serializable
{

    private String accesslevel;
    private String format;
    private String lang;
    private String storageid;
    private String value;

    public Asset()
    {
        lang = "en-us";
    }

    public String getAccesslevel()
    {
        return accesslevel;
    }

    public String getFormat()
    {
        return format;
    }

    public String getStorageid()
    {
        return storageid;
    }

    public String getValue()
    {
        return value;
    }
}
