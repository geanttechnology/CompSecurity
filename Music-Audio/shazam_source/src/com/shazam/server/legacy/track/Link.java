// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy.track;


public class Link
{

    private String href;

    private Link()
    {
    }

    private Link(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        href = Builder.access._mth000(builder);
    }

    Link(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public Link(String s)
    {
        href = s;
    }

    public String getHref()
    {
        return href;
    }
}
