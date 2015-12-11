// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;


public class EventContext
{

    public String by_display_handle;
    public String by_full_name;
    public String by_id;
    public String by_picture_url;
    public String by_username;
    public String created_at;
    public String id;

    public EventContext()
    {
    }

    public void copy(EventContext eventcontext)
    {
        if (eventcontext != null)
        {
            id = eventcontext.id;
            by_id = eventcontext.by_id;
            by_username = eventcontext.by_username;
            by_display_handle = eventcontext.by_display_handle;
            by_full_name = eventcontext.by_full_name;
            created_at = eventcontext.created_at;
            by_picture_url = eventcontext.by_picture_url;
        }
    }
}
