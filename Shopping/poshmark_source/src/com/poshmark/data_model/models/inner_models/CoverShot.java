// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


public class CoverShot
{

    String content_type;
    String created_at;
    public String id;
    public String url;
    public String url_small;
    public String url_thumb;

    public CoverShot()
    {
    }

    public void copy(CoverShot covershot)
    {
        id = covershot.id;
        created_at = covershot.created_at;
        url_small = covershot.url_small;
        content_type = covershot.content_type;
        url = covershot.url;
        url_thumb = covershot.url_thumb;
    }
}
