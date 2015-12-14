// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.log;


// Referenced classes of package com.amazon.gallery.foundation.utils.log:
//            GTracer

public class GTrace
{
    public static final class TraceType extends Enum
    {

        private static final TraceType $VALUES[];
        public static final TraceType Controller;
        public static final TraceType Drawable;
        public static final TraceType Renderer;
        public static final TraceType Touch;
        private boolean enabled;

        public static TraceType valueOf(String s)
        {
            return (TraceType)Enum.valueOf(com/amazon/gallery/foundation/utils/log/GTrace$TraceType, s);
        }

        public static TraceType[] values()
        {
            return (TraceType[])$VALUES.clone();
        }

        boolean isEnabled()
        {
            return enabled;
        }

        static 
        {
            Renderer = new TraceType("Renderer", 0, true);
            Drawable = new TraceType("Drawable", 1, true);
            Controller = new TraceType("Controller", 2, true);
            Touch = new TraceType("Touch", 3, true);
            $VALUES = (new TraceType[] {
                Renderer, Drawable, Controller, Touch
            });
        }

        private TraceType(String s, int i, boolean flag)
        {
            super(s, i);
            enabled = flag;
        }
    }


    private static GTracer gTracer = null;

    public static void beginSection(TraceType tracetype, String s)
    {
        if (tracetype.isEnabled())
        {
            beginSectionRelease(s);
        }
    }

    public static void beginSectionRelease(String s)
    {
        if (gTracer != null)
        {
            gTracer.beginSection(s);
        }
    }

    public static void endSection(TraceType tracetype)
    {
        if (tracetype.isEnabled())
        {
            endSectionRelease();
        }
    }

    public static void endSectionRelease()
    {
        if (gTracer != null)
        {
            gTracer.endSection();
        }
    }

    public static void setGTracer(GTracer gtracer)
    {
        gTracer = gtracer;
    }

}
