// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.model.tags;


// Referenced classes of package com.amazon.gallery.framework.model.tags:
//            TagProperty, CommonTagProperty

public static final class  extends Enum
    implements TagProperty
{

    private static final FREETIME $VALUES[];
    public static final FREETIME CAMERA;
    public static final FREETIME FREETIME;
    public static final FREETIME NOT_SET;
    public static final FREETIME YOUR_CLOUD_DRIVE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/model/tags/CommonTagProperty$Misc, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NOT_SET = new <init>("NOT_SET", 0);
        CAMERA = new <init>("CAMERA", 1);
        YOUR_CLOUD_DRIVE = new <init>("YOUR_CLOUD_DRIVE", 2);
        FREETIME = new <init>("FREETIME", 3);
        $VALUES = (new .VALUES[] {
            NOT_SET, CAMERA, YOUR_CLOUD_DRIVE, FREETIME
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
