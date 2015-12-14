// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.model.media;

import org.json.JSONObject;

public class UploadPart
{

    private final JSONObject headers;
    private final int partNumber;
    private final JSONObject uploadParameters;
    private final String uploadUrl;

    public UploadPart(int i, String s, JSONObject jsonobject, JSONObject jsonobject1)
    {
        partNumber = i;
        uploadUrl = s;
        headers = jsonobject;
        uploadParameters = jsonobject1;
    }

    public JSONObject getHeaders()
    {
        return headers;
    }

    public int getPartNumber()
    {
        return partNumber;
    }

    public JSONObject getUploadParameters()
    {
        return uploadParameters;
    }

    public String getUploadUrl()
    {
        return uploadUrl;
    }
}
