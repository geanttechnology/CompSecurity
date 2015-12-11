// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;


public class FeedItemContentType
{
    public static final class ContentType extends Enum
    {

        private static final ContentType $VALUES[];
        public static final ContentType Brand;
        public static final ContentType Collection;
        public static final ContentType Event;
        public static final ContentType Invalid;
        public static final ContentType PoshmarkPost;
        public static final ContentType Post;
        public static final ContentType User;

        public static ContentType valueOf(String s)
        {
            return (ContentType)Enum.valueOf(com/poshmark/data_model/models/FeedItemContentType$ContentType, s);
        }

        public static ContentType[] values()
        {
            return (ContentType[])$VALUES.clone();
        }

        static 
        {
            Post = new ContentType("Post", 0);
            Brand = new ContentType("Brand", 1);
            User = new ContentType("User", 2);
            Event = new ContentType("Event", 3);
            Collection = new ContentType("Collection", 4);
            PoshmarkPost = new ContentType("PoshmarkPost", 5);
            Invalid = new ContentType("Invalid", 6);
            $VALUES = (new ContentType[] {
                Post, Brand, User, Event, Collection, PoshmarkPost, Invalid
            });
        }

        private ContentType(String s, int i)
        {
            super(s, i);
        }
    }


    public ContentType type;

    public FeedItemContentType()
    {
        type = ContentType.Invalid;
    }

    public FeedItemContentType(String s)
    {
        type = ContentType.Invalid;
        setContentType(s);
    }

    private void setContentType(String s)
    {
label0:
        {
            if (s != null)
            {
                if (!s.equalsIgnoreCase("post"))
                {
                    break label0;
                }
                type = ContentType.Post;
            }
            return;
        }
        if (s.equalsIgnoreCase("brand"))
        {
            type = ContentType.Brand;
            return;
        }
        if (s.equalsIgnoreCase("user"))
        {
            type = ContentType.User;
            return;
        }
        if (s.equalsIgnoreCase("event"))
        {
            type = ContentType.Event;
            return;
        }
        if (s.equalsIgnoreCase("collection"))
        {
            type = ContentType.Collection;
            return;
        }
        if (s.equalsIgnoreCase("cpu_message"))
        {
            type = ContentType.PoshmarkPost;
            return;
        } else
        {
            type = ContentType.Invalid;
            return;
        }
    }
}
