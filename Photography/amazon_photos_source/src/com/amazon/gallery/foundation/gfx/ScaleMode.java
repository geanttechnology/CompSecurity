// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.gfx;


public final class ScaleMode extends Enum
{

    private static final ScaleMode $VALUES[];
    public static final ScaleMode NO_RESIZE;
    public static final ScaleMode SCALE_TO_FILL;
    public static final ScaleMode SCALE_TO_FIT;

    private ScaleMode(String s, int i)
    {
        super(s, i);
    }

    public static ScaleMode valueOf(String s)
    {
        return (ScaleMode)Enum.valueOf(com/amazon/gallery/foundation/gfx/ScaleMode, s);
    }

    public static ScaleMode[] values()
    {
        return (ScaleMode[])$VALUES.clone();
    }

    static 
    {
        SCALE_TO_FIT = new ScaleMode("SCALE_TO_FIT", 0);
        SCALE_TO_FILL = new ScaleMode("SCALE_TO_FILL", 1);
        NO_RESIZE = new ScaleMode("NO_RESIZE", 2);
        $VALUES = (new ScaleMode[] {
            SCALE_TO_FIT, SCALE_TO_FILL, NO_RESIZE
        });
    }
}
