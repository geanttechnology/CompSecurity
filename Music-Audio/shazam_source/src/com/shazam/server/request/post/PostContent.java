// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.request.post;


public class PostContent
{

    public final String caption;
    public final String trackKey;

    private PostContent(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        trackKey = Builder.access._mth000(builder);
        caption = Builder.access._mth100(builder);
    }

    PostContent(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
