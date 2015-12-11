// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


public class Host
{

    public String display_handle;
    public String fb_user_id;
    public String full_name;
    public String id;
    private String picture_url;
    public String username;

    public Host()
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

    public String getUsername()
    {
        return username;
    }
}
