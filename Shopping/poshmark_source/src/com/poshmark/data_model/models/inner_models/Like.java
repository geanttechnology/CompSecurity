// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


public class Like
{

    public String created_at;
    public String creator_display_handle;
    public String creator_id;
    public String id;

    public Like()
    {
    }

    public void copy(Like like)
    {
        if (like != null)
        {
            id = like.id;
            created_at = like.created_at;
            creator_display_handle = like.creator_display_handle;
            creator_id = like.creator_id;
        }
    }

    public String getDisplayHandle()
    {
        return creator_display_handle;
    }
}
