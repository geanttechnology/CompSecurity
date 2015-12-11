// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.pager;


// Referenced classes of package com.aio.downloader.pager:
//            JazzyViewPager

public static final class  extends Enum
{

    public static final Accordion Accordion;
    public static final Accordion CubeIn;
    public static final Accordion CubeOut;
    private static final Accordion ENUM$VALUES[];
    public static final Accordion FlipHorizontal;
    public static final Accordion FlipVertical;
    public static final Accordion RotateDown;
    public static final Accordion RotateUp;
    public static final Accordion Stack;
    public static final Accordion Standard;
    public static final Accordion Tablet;
    public static final Accordion ZoomIn;
    public static final Accordion ZoomOut;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/aio/downloader/pager/JazzyViewPager$TransitionEffect, s);
    }

    public static [] values()
    {
         a[] = ENUM$VALUES;
        int i = a.length;
         a1[] = new ENUM.VALUES[i];
        System.arraycopy(a, 0, a1, 0, i);
        return a1;
    }

    static 
    {
        Standard = new <init>("Standard", 0);
        Tablet = new <init>("Tablet", 1);
        CubeIn = new <init>("CubeIn", 2);
        CubeOut = new <init>("CubeOut", 3);
        FlipVertical = new <init>("FlipVertical", 4);
        FlipHorizontal = new <init>("FlipHorizontal", 5);
        Stack = new <init>("Stack", 6);
        ZoomIn = new <init>("ZoomIn", 7);
        ZoomOut = new <init>("ZoomOut", 8);
        RotateUp = new <init>("RotateUp", 9);
        RotateDown = new <init>("RotateDown", 10);
        Accordion = new <init>("Accordion", 11);
        ENUM$VALUES = (new ENUM.VALUES[] {
            Standard, Tablet, CubeIn, CubeOut, FlipVertical, FlipHorizontal, Stack, ZoomIn, ZoomOut, RotateUp, 
            RotateDown, Accordion
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
