// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.follow;


// Referenced classes of package com.shazam.model.follow:
//            FollowData

public static class 
{

    public String artistId;
    public String followKey;

    public static  a()
    {
        return new <init>();
    }

    public static <init> a(FollowData followdata)
    {
        <init> <init>1 = new <init>();
        <init>1.followKey = FollowData.a(followdata);
        <init>1.artistId = FollowData.b(followdata);
        return <init>1;
    }

    static String a(artistId artistid)
    {
        return artistid.followKey;
    }

    static String b(followKey followkey)
    {
        return followkey.artistId;
    }

    public final FollowData b()
    {
        return new FollowData(this, null);
    }

    public ()
    {
    }
}
