// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


public class Comment
{

    public String comment;
    public String created_at;
    public String creator_display_handle;
    public String creator_fb_id;
    public String creator_full_name;
    public String creator_id;
    public String creator_picture_url;
    public String creator_username;
    public String id;

    public Comment()
    {
    }

    public void copy(Comment comment1)
    {
        creator_picture_url = comment1.creator_picture_url;
        id = comment1.id;
        creator_username = comment1.creator_username;
        creator_full_name = comment1.creator_full_name;
        created_at = comment1.created_at;
        creator_fb_id = comment1.creator_fb_id;
        creator_display_handle = comment1.creator_display_handle;
        comment = comment1.comment;
        creator_id = comment1.creator_id;
    }

    public CharSequence getComment()
    {
        return comment;
    }

    public String getCommenterDisplayHandle()
    {
        return creator_display_handle;
    }

    public String getCommenterFbId()
    {
        return creator_fb_id;
    }

    public String getCommenterId()
    {
        return creator_id;
    }

    public String getCommenterName()
    {
        return creator_username;
    }

    public String getCommenterPicture()
    {
        String s = null;
        if (creator_picture_url != null)
        {
            s = creator_picture_url;
        } else
        if (creator_fb_id != null)
        {
            return String.format("https://graph.facebook.com/%s/picture?width=100&height=100", new Object[] {
                creator_fb_id
            });
        }
        return s;
    }

    public String getCreatedAt()
    {
        return created_at;
    }
}
