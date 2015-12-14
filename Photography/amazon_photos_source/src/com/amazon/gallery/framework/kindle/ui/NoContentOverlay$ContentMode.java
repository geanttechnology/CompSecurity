// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ui;


// Referenced classes of package com.amazon.gallery.framework.kindle.ui:
//            NoContentOverlay

public static final class I extends Enum
{

    private static final HIDDEN $VALUES[];
    public static final HIDDEN ALBUM;
    public static final HIDDEN ALL;
    public static final HIDDEN CAMERA;
    public static final HIDDEN CLOUD;
    public static final HIDDEN DEVICE;
    public static final HIDDEN HIDDEN;
    public static final HIDDEN VIDEOS;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/amazon/gallery/framework/kindle/ui/NoContentOverlay$ContentMode, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        CLOUD = new <init>("CLOUD", 0);
        DEVICE = new <init>("DEVICE", 1);
        ALL = new <init>("ALL", 2);
        CAMERA = new <init>("CAMERA", 3);
        VIDEOS = new <init>("VIDEOS", 4);
        ALBUM = new <init>("ALBUM", 5);
        HIDDEN = new <init>("HIDDEN", 6);
        $VALUES = (new .VALUES[] {
            CLOUD, DEVICE, ALL, CAMERA, VIDEOS, ALBUM, HIDDEN
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
