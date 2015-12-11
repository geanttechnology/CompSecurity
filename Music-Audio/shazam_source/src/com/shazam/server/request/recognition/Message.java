// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.request.recognition;


public class Message
{

    public final String id;
    public final String type;

    private Message(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        id = Builder.access._mth000(builder);
        type = Builder.access._mth100(builder);
    }

    Message(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
