// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;


// Referenced classes of package com.poshmark.data_model.models:
//            FeedItemContentType

public static final class  extends Enum
{

    private static final Invalid $VALUES[];
    public static final Invalid Brand;
    public static final Invalid Collection;
    public static final Invalid Event;
    public static final Invalid Invalid;
    public static final Invalid PoshmarkPost;
    public static final Invalid Post;
    public static final Invalid User;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/data_model/models/FeedItemContentType$ContentType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Post = new <init>("Post", 0);
        Brand = new <init>("Brand", 1);
        User = new <init>("User", 2);
        Event = new <init>("Event", 3);
        Collection = new <init>("Collection", 4);
        PoshmarkPost = new <init>("PoshmarkPost", 5);
        Invalid = new <init>("Invalid", 6);
        $VALUES = (new .VALUES[] {
            Post, Brand, User, Event, Collection, PoshmarkPost, Invalid
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
