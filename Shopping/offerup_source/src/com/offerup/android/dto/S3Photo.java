// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.net.Uri;

public class S3Photo
{

    private String uploadUrl;
    private String uuid;

    public S3Photo()
    {
        uploadUrl = null;
        uuid = null;
    }

    public Uri getUploadUrl()
    {
        if (uploadUrl != null)
        {
            return Uri.parse(uploadUrl.replace("%", "%25"));
        } else
        {
            return null;
        }
    }

    public String getUuid()
    {
        return uuid;
    }
}
