// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.request.recognition;

import java.util.List;

public class Mood
{

    public final List messages;
    public final String sdkVersion;

    private Mood(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        messages = Builder.access._mth000(builder);
        sdkVersion = Builder.access._mth100(builder);
    }

    Mood(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
