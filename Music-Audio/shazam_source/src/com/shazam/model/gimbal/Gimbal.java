// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.gimbal;

import java.util.List;

public class Gimbal
{

    public List beacons;

    private Gimbal()
    {
    }

    private Gimbal(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        beacons = Builder.a(builder);
    }

    public Gimbal(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
