// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.metrics.customer;


public interface FTUEMetricsHelper
{
    public static final class ClickSource extends Enum
    {

        private static final ClickSource $VALUES[];
        public static final ClickSource DESKTOP_CLICK;
        public static final ClickSource FACEBOOK_CLICK;
        public static final ClickSource MOBILE_CLICK;

        public static ClickSource valueOf(String s)
        {
            return (ClickSource)Enum.valueOf(com/amazon/gallery/framework/kindle/metrics/customer/FTUEMetricsHelper$ClickSource, s);
        }

        public static ClickSource[] values()
        {
            return (ClickSource[])$VALUES.clone();
        }

        static 
        {
            FACEBOOK_CLICK = new ClickSource("FACEBOOK_CLICK", 0);
            DESKTOP_CLICK = new ClickSource("DESKTOP_CLICK", 1);
            MOBILE_CLICK = new ClickSource("MOBILE_CLICK", 2);
            $VALUES = (new ClickSource[] {
                FACEBOOK_CLICK, DESKTOP_CLICK, MOBILE_CLICK
            });
        }

        private ClickSource(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract void logClickEvent(ClickSource clicksource, long l);
}
