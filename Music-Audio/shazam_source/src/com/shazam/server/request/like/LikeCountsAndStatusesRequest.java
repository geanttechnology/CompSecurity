// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.request.like;

import java.util.List;

public class LikeCountsAndStatusesRequest
{

    public final List likeKeys;

    private LikeCountsAndStatusesRequest(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        likeKeys = Builder.access._mth000(builder);
    }

    LikeCountsAndStatusesRequest(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
