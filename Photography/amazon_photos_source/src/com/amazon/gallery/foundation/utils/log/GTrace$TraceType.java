// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.log;


// Referenced classes of package com.amazon.gallery.foundation.utils.log:
//            GTrace

public static final class enabled extends Enum
{

    private static final Touch $VALUES[];
    public static final Touch Controller;
    public static final Touch Drawable;
    public static final Touch Renderer;
    public static final Touch Touch;
    private boolean enabled;

    public static enabled valueOf(String s)
    {
        return (enabled)Enum.valueOf(com/amazon/gallery/foundation/utils/log/GTrace$TraceType, s);
    }

    public static enabled[] values()
    {
        return (enabled[])$VALUES.clone();
    }

    boolean isEnabled()
    {
        return enabled;
    }

    static 
    {
        Renderer = new <init>("Renderer", 0, true);
        Drawable = new <init>("Drawable", 1, true);
        Controller = new <init>("Controller", 2, true);
        Touch = new <init>("Touch", 3, true);
        $VALUES = (new .VALUES[] {
            Renderer, Drawable, Controller, Touch
        });
    }

    private (String s, int i, boolean flag)
    {
        super(s, i);
        enabled = flag;
    }
}
