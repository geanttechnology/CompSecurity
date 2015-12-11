// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


public class FeedContext
{

    public boolean shared;
    public String shared_at;
    String shared_by_fb_user_id;
    String shared_by_id;
    String shared_by_picture_url;
    public String shared_by_username;

    public FeedContext()
    {
    }

    public void copy(FeedContext feedcontext)
    {
        if (feedcontext != null)
        {
            shared = feedcontext.shared;
            shared_by_username = feedcontext.shared_by_username;
            shared_by_picture_url = feedcontext.shared_by_picture_url;
            shared_at = feedcontext.shared_at;
            shared_by_id = feedcontext.shared_by_id;
            shared_by_fb_user_id = feedcontext.shared_by_fb_user_id;
        }
    }
}
