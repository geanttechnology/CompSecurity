// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.ibeacon;

import java.util.List;

public class IBeacons
{

    private List iBeacons;

    private IBeacons()
    {
    }

    private IBeacons(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        iBeacons = Builder.a(builder);
    }

    IBeacons(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
