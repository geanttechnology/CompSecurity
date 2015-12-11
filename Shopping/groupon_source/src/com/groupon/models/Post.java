// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;

import java.util.Date;
import java.util.List;

public class Post
{
    public static class ListWrapper
    {

        public List posts;

        public ListWrapper()
        {
        }
    }


    public String body;
    public Date createdAt;
    public String posterAvatar;
    public String posterName;

    public Post()
    {
    }
}
