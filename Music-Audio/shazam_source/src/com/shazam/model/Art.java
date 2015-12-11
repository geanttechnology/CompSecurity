// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model;


public class Art
{

    public byte data[];
    public String expireDateTime;
    public String type;
    public String url;

    public Art()
    {
    }

    private Art(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        url = Builder.a(builder);
    }

    Art(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
