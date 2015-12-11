// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.visual;

import com.shazam.model.visual.digimarc.Digimarc;
import com.shazam.model.visual.moodstocks.MoodStocks;

public class Image
{

    private Digimarc digimarc;
    private MoodStocks moodStocks;

    private Image()
    {
    }

    private Image(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        moodStocks = Builder.a(builder);
        digimarc = Builder.b(builder);
    }

    public Image(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
