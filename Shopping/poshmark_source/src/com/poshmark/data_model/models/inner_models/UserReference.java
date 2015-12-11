// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


public class UserReference
{

    boolean caller_is_following;
    String created_at;
    String display_handle;
    String fb_user_id;
    String full_name;
    String id;
    String picture_url;
    String username;

    public UserReference()
    {
    }

    public String getAvataar()
    {
        String s = null;
        if (picture_url != null)
        {
            s = picture_url;
        } else
        if (fb_user_id != null)
        {
            return String.format("https://graph.facebook.com/%s/picture?width=100&height=100", new Object[] {
                fb_user_id
            });
        }
        return s;
    }

    public String getDisplayHandle()
    {
        return display_handle;
    }

    public String getFullName()
    {
        return full_name;
    }

    public String getUserId()
    {
        return id;
    }

    public String getUserName()
    {
        return username;
    }

    public boolean isCallerFollowing()
    {
        return caller_is_following;
    }

    public void setCallerFollowing(boolean flag)
    {
        caller_is_following = flag;
    }

    public void setDisplayHandle(String s)
    {
        display_handle = s;
    }
}
