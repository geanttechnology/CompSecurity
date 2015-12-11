// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;


// Referenced classes of package com.groupon.view:
//            UrlImageView

public static final class  extends Enum
{

    private static final CENTER_INSIDE $VALUES[];
    public static final CENTER_INSIDE CENTER_CROP;
    public static final CENTER_INSIDE CENTER_INSIDE;
    public static final CENTER_INSIDE NONE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/groupon/view/UrlImageView$ScaleImageType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        CENTER_CROP = new <init>("CENTER_CROP", 1);
        CENTER_INSIDE = new <init>("CENTER_INSIDE", 2);
        $VALUES = (new .VALUES[] {
            NONE, CENTER_CROP, CENTER_INSIDE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
