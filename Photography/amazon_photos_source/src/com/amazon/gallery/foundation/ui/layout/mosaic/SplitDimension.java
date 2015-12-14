// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.ui.layout.mosaic;


public final class SplitDimension extends Enum
{

    private static final SplitDimension $VALUES[];
    public static final SplitDimension HORIZONTAL;
    public static final SplitDimension NONE;
    public static final SplitDimension VERTICAL;

    private SplitDimension(String s, int i)
    {
        super(s, i);
    }

    public static SplitDimension valueOf(String s)
    {
        return (SplitDimension)Enum.valueOf(com/amazon/gallery/foundation/ui/layout/mosaic/SplitDimension, s);
    }

    public static SplitDimension[] values()
    {
        return (SplitDimension[])$VALUES.clone();
    }

    static 
    {
        HORIZONTAL = new SplitDimension("HORIZONTAL", 0);
        VERTICAL = new SplitDimension("VERTICAL", 1);
        NONE = new SplitDimension("NONE", 2);
        $VALUES = (new SplitDimension[] {
            HORIZONTAL, VERTICAL, NONE
        });
    }
}
