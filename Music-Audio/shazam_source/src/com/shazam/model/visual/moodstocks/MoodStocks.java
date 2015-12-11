// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.visual.moodstocks;

import java.util.List;

public class MoodStocks
{

    List scanResult;

    public MoodStocks()
    {
    }

    private MoodStocks(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        scanResult = Builder.a(builder);
    }

    public MoodStocks(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
