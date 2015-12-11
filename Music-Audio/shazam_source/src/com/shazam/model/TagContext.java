// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model;

import com.shazam.model.audio.Watermark;
import com.shazam.model.gimbal.Gimbal;
import com.shazam.model.ibeacon.IBeacons;
import com.shazam.model.time.Ntp;
import com.shazam.model.visual.Image;

public class TagContext
{
    public static class Builder
    {

        public Gimbal gimbal;
        IBeacons iBeacons;
        public Image image;
        public Ntp ntp;
        public Watermark watermark;

        public static Builder a()
        {
            return new Builder();
        }

        public static Builder a(Builder builder)
        {
            Builder builder1 = new Builder();
            builder1.watermark = builder.watermark;
            builder1.ntp = builder.ntp;
            builder1.gimbal = builder.gimbal;
            builder1.iBeacons = builder.iBeacons;
            builder1.image = builder.image;
            return builder1;
        }

        static Watermark b(Builder builder)
        {
            return builder.watermark;
        }

        static Ntp c(Builder builder)
        {
            return builder.ntp;
        }

        static Gimbal d(Builder builder)
        {
            return builder.gimbal;
        }

        static IBeacons e(Builder builder)
        {
            return builder.iBeacons;
        }

        static Image f(Builder builder)
        {
            return builder.image;
        }

        public final TagContext b()
        {
            return new TagContext(this, null);
        }

        public Builder()
        {
        }
    }


    public Gimbal gimbal;
    private IBeacons iBeacons;
    private Image image;
    private Ntp ntp;
    public Watermark watermark;

    private TagContext()
    {
    }

    private TagContext(Builder builder)
    {
        watermark = Builder.b(builder);
        ntp = Builder.c(builder);
        gimbal = Builder.d(builder);
        iBeacons = Builder.e(builder);
        image = Builder.f(builder);
    }

    TagContext(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public static Builder a(TagContext tagcontext)
    {
        Builder builder = Builder.a();
        builder.image = tagcontext.image;
        builder.watermark = tagcontext.watermark;
        builder.iBeacons = tagcontext.iBeacons;
        builder.ntp = tagcontext.ntp;
        return builder;
    }
}
