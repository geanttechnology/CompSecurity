// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.request.post;


// Referenced classes of package com.shazam.server.request.post:
//            PostContent

public class PublishPostRequest
{

    public final PostContent postContent;
    public final String type;

    private PublishPostRequest(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        type = Builder.access._mth000(builder);
        postContent = Builder.access._mth100(builder);
    }

    PublishPostRequest(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
