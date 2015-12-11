// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.wearable;


public class AudioSignature
{

    public byte sig[];
    public long timestamp;

    private AudioSignature()
    {
    }

    private AudioSignature(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        sig = Builder.a(builder);
        timestamp = Builder.b(builder);
    }

    AudioSignature(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
