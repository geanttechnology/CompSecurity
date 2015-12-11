// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;


public class PoshmarkPost
{
    public class PostImage
    {

        final PoshmarkPost this$0;
        public String url;

        public PostImage()
        {
            this$0 = PoshmarkPost.this;
            super();
        }
    }

    public class PostTarget
    {

        final PoshmarkPost this$0;
        public String type;
        public String url;

        public PostTarget()
        {
            this$0 = PoshmarkPost.this;
            super();
        }
    }

    public class PostTitle
    {

        final PoshmarkPost this$0;
        public String title;

        public PostTitle()
        {
            this$0 = PoshmarkPost.this;
            super();
        }
    }


    public PostImage image;
    public PostTarget target;
    public PostTitle text;

    public PoshmarkPost()
    {
    }
}
