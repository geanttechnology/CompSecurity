// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model.hal;

import com.comcast.cim.cmasl.hal.model.HalObjectFactory;
import com.comcast.cim.cmasl.hal.model.HalParseable;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStreamResource;

public class HalLiveStreamResourceFactory extends HalObjectFactory
{

    public HalLiveStreamResourceFactory()
    {
    }

    protected volatile HalParseable get()
    {
        return get();
    }

    protected HalLiveStreamResource get()
    {
        return new HalLiveStreamResource();
    }
}
