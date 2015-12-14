// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.ui.layout;


public final class ScrollDirection extends Enum
{

    private static final ScrollDirection $VALUES[];
    public static final ScrollDirection HORIZONTAL;
    public static final ScrollDirection VERTICAL;

    private ScrollDirection(String s, int i)
    {
        super(s, i);
    }

    public static ScrollDirection valueOf(String s)
    {
        return (ScrollDirection)Enum.valueOf(com/amazon/gallery/foundation/ui/layout/ScrollDirection, s);
    }

    public static ScrollDirection[] values()
    {
        return (ScrollDirection[])$VALUES.clone();
    }

    static 
    {
        VERTICAL = new ScrollDirection("VERTICAL", 0);
        HORIZONTAL = new ScrollDirection("HORIZONTAL", 1);
        $VALUES = (new ScrollDirection[] {
            VERTICAL, HORIZONTAL
        });
    }
}
