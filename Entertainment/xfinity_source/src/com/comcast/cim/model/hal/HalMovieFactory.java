// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model.hal;

import com.comcast.cim.cmasl.hal.model.HalObjectFactory;
import com.comcast.cim.cmasl.hal.model.HalParseable;
import com.xfinity.playerlib.model.consumable.hal.HalMovieConsumable;

public class HalMovieFactory extends HalObjectFactory
{

    public HalMovieFactory()
    {
    }

    protected volatile HalParseable get()
    {
        return get();
    }

    protected HalMovieConsumable get()
    {
        return new HalMovieConsumable();
    }
}
