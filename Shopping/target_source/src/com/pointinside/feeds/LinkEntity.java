// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.feeds;


class LinkEntity
{

    public final String eTag;
    public final String type;
    public final String uri;

    public LinkEntity(LinkEntity linkentity)
    {
        type = linkentity.type;
        uri = linkentity.uri;
        eTag = linkentity.eTag;
    }
}
