// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.post;

import com.shazam.model.share.ShareData;

// Referenced classes of package com.shazam.model.post:
//            Post

public static class 
{

    public String caption;
    public String likeKey;
    public ShareData shareData;
    public String tagId;
    public String trackKey;
    public String uuid;

    public static  a()
    {
        return new <init>();
    }

    static String a(<init> <init>1)
    {
        return <init>1.trackKey;
    }

    static String b(trackKey trackkey)
    {
        return trackkey.uuid;
    }

    static String c(uuid uuid1)
    {
        return uuid1.caption;
    }

    static String d(caption caption1)
    {
        return caption1.tagId;
    }

    static String e(tagId tagid)
    {
        return tagid.likeKey;
    }

    static ShareData f(likeKey likekey)
    {
        return likekey.shareData;
    }

    public final Post b()
    {
        return new Post(this, null);
    }

    public ()
    {
    }
}
