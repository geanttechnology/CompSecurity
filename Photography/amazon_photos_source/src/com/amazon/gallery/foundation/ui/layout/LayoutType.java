// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.ui.layout;


public final class LayoutType extends Enum
{

    private static final LayoutType $VALUES[];
    public static final LayoutType GRID;
    public static final LayoutType MOSAIC;
    public static final LayoutType SINGLE;
    public static final LayoutType ZOOM;

    private LayoutType(String s, int i)
    {
        super(s, i);
    }

    public static LayoutType valueOf(String s)
    {
        return (LayoutType)Enum.valueOf(com/amazon/gallery/foundation/ui/layout/LayoutType, s);
    }

    public static LayoutType[] values()
    {
        return (LayoutType[])$VALUES.clone();
    }

    static 
    {
        GRID = new LayoutType("GRID", 0);
        MOSAIC = new LayoutType("MOSAIC", 1);
        SINGLE = new LayoutType("SINGLE", 2);
        ZOOM = new LayoutType("ZOOM", 3);
        $VALUES = (new LayoutType[] {
            GRID, MOSAIC, SINGLE, ZOOM
        });
    }
}
