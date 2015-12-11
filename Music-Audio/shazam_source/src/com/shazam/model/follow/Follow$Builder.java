// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.follow;


// Referenced classes of package com.shazam.model.follow:
//            Follow

public static class 
{

    public String defaultAvatar;
    public String followKey;
    public String id;
    public boolean isFollowing;
    public String name;
    public boolean verified;

    public static  a()
    {
        return new <init>();
    }

    public static <init> a(Follow follow)
    {
        <init> <init>1 = new <init>();
        <init>1.id = Follow.a(follow);
        <init>1.name = Follow.b(follow);
        <init>1.defaultAvatar = Follow.c(follow);
        <init>1.followKey = Follow.d(follow);
        <init>1.verified = Follow.e(follow);
        <init>1.isFollowing = Follow.f(follow);
        return <init>1;
    }

    static String a(isFollowing isfollowing)
    {
        return isfollowing.id;
    }

    static String b(id id1)
    {
        return id1.name;
    }

    static String c(name name1)
    {
        return name1.defaultAvatar;
    }

    static boolean d(defaultAvatar defaultavatar)
    {
        return defaultavatar.verified;
    }

    static boolean e(verified verified1)
    {
        return verified1.isFollowing;
    }

    static String f(isFollowing isfollowing)
    {
        return isfollowing.followKey;
    }

    public final Follow b()
    {
        return new Follow(this, null);
    }

    public ()
    {
    }
}
