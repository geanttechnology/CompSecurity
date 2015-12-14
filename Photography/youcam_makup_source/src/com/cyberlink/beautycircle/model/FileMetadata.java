// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import android.net.Uri;
import com.perfectcorp.model.Model;

public class FileMetadata extends Model
{

    public String dominantedColor;
    public long fileSize;
    public Integer height;
    public String imageDescription;
    public Uri lookStoreUrl;
    public String md5;
    public Integer orientation;
    public Uri originalUrl;
    public Uri redirectUrl;
    public Integer width;

    public FileMetadata()
    {
        fileSize = -1L;
        md5 = null;
        width = null;
        height = null;
        originalUrl = null;
        redirectUrl = null;
        orientation = null;
        imageDescription = null;
        dominantedColor = null;
        lookStoreUrl = null;
    }
}
