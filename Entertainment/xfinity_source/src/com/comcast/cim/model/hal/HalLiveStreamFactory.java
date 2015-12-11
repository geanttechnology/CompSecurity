// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model.hal;

import com.comcast.cim.cmasl.hal.model.HalObjectFactory;
import com.comcast.cim.cmasl.hal.model.HalParseable;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;

public class HalLiveStreamFactory extends HalObjectFactory
{

    public HalLiveStreamFactory()
    {
    }

    protected volatile HalParseable get()
    {
        return get();
    }

    protected HalLiveStream get()
    {
        return new HalLiveStream();
    }
}
