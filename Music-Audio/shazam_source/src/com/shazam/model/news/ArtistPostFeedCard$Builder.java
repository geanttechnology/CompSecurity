// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;

import com.shazam.model.like.Like;

// Referenced classes of package com.shazam.model.news:
//            ArtistPostFeedCard

public static class 
{

    public String captionText;
    public Like like;
    public captionText tagNewsCardBuilder;

    public static  a()
    {
        return new <init>();
    }

    static <init> a(<init> <init>1)
    {
        return <init>1.tagNewsCardBuilder;
    }

    static Like b(tagNewsCardBuilder tagnewscardbuilder)
    {
        return tagnewscardbuilder.like;
    }

    static String c(like like1)
    {
        return like1.captionText;
    }

    public final ArtistPostFeedCard b()
    {
        return new ArtistPostFeedCard(this);
    }

    public ()
    {
    }
}
