// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.like;


public class Like
{

    public static final Like EMPTY = new Like(null, false, 0);
    public final int count;
    public final boolean isLiked;
    public final String key;

    private Like(String s, boolean flag, int i)
    {
        key = s;
        isLiked = flag;
        count = i;
    }

}
