// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.g;

import com.shazam.server.response.like.Like;

public final class a
    implements com.shazam.b.a.a
{

    public a()
    {
    }

    public final Object a(Object obj)
    {
        obj = (Like)obj;
        com.shazam.model.like.Like.Builder builder = com.shazam.model.like.Like.Builder.a();
        builder.key = ((Like) (obj)).key;
        builder.isLiked = ((Like) (obj)).isLiked;
        builder.count = ((Like) (obj)).count;
        return builder.b();
    }
}
