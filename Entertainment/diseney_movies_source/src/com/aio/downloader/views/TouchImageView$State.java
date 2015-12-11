// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;


// Referenced classes of package com.aio.downloader.views:
//            TouchImageView

private static final class  extends Enum
{

    public static final ANIMATE_ZOOM ANIMATE_ZOOM;
    public static final ANIMATE_ZOOM DRAG;
    private static final ANIMATE_ZOOM ENUM$VALUES[];
    public static final ANIMATE_ZOOM FLING;
    public static final ANIMATE_ZOOM NONE;
    public static final ANIMATE_ZOOM ZOOM;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/aio/downloader/views/TouchImageView$State, s);
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
        NONE = new <init>("NONE", 0);
        DRAG = new <init>("DRAG", 1);
        ZOOM = new <init>("ZOOM", 2);
        FLING = new <init>("FLING", 3);
        ANIMATE_ZOOM = new <init>("ANIMATE_ZOOM", 4);
        ENUM$VALUES = (new ENUM.VALUES[] {
            NONE, DRAG, ZOOM, FLING, ANIMATE_ZOOM
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
