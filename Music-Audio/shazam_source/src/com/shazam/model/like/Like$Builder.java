// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.like;


// Referenced classes of package com.shazam.model.like:
//            Like

public static class 
{

    public int count;
    public boolean isLiked;
    public String key;

    public static  a()
    {
        return new <init>();
    }

    public static <init> a(Like like)
    {
        <init> <init>1 = new <init>();
        <init>1.key = Like.a(like);
        <init>1.isLiked = Like.b(like);
        <init>1.count = Like.c(like);
        return <init>1;
    }

    static String a(count count1)
    {
        return count1.key;
    }

    static boolean b(key key1)
    {
        return key1.isLiked;
    }

    static int c(isLiked isliked)
    {
        return isliked.count;
    }

    public final Like b()
    {
        return new Like(this, null);
    }

    public ()
    {
    }
}
