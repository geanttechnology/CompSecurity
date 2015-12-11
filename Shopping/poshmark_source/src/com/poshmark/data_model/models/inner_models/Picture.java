// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;

import android.net.Uri;

public class Picture
{

    String content_type;
    String created_at;
    Uri file;
    String id;
    Uri originalFile;
    String url;
    String url_small;

    public Picture()
    {
        file = (new android.net.Uri.Builder()).build();
        originalFile = (new android.net.Uri.Builder()).build();
    }

    public Picture(Picture picture)
    {
        file = (new android.net.Uri.Builder()).build();
        originalFile = (new android.net.Uri.Builder()).build();
        id = picture.getId();
        url = picture.url;
        file = picture.file;
        originalFile = picture.originalFile;
    }

    public String getId()
    {
        return id;
    }

    public Uri getOriginalPictureFileUri()
    {
        return originalFile;
    }

    public Uri getPictureFileUri()
    {
        return file;
    }

    public String getPictureUrl()
    {
        return url;
    }

    public boolean isRemote()
    {
        return url != null;
    }

    public void setFileUri(Uri uri)
    {
        if (uri != null)
        {
            file = uri;
            url = null;
        }
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setOriginalFileUri(Uri uri)
    {
        originalFile = uri;
    }

    public void setPictureUrl(String s)
    {
        url = s;
    }
}
