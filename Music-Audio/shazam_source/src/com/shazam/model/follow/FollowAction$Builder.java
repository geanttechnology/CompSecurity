// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.follow;


// Referenced classes of package com.shazam.model.follow:
//            FollowAction, FollowData

public static class 
{

    public FollowData followData;
    public boolean following;

    public static  a()
    {
        return new <init>();
    }

    static boolean a(<init> <init>1)
    {
        return <init>1.following;
    }

    static FollowData b(following following1)
    {
        return following1.followData;
    }

    public final FollowAction b()
    {
        return new FollowAction(this, null);
    }

    public ()
    {
    }
}
