// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;


// Referenced classes of package com.aviary.android.feather.cds:
//            AviaryCds

public static final class  extends Enum
{

    private static final FEATURED_IMAGE $VALUES[];
    public static final FEATURED_IMAGE CONTENT;
    public static final FEATURED_IMAGE DETAIL_IMAGE;
    public static final FEATURED_IMAGE FEATURED_IMAGE;
    public static final FEATURED_IMAGE MESSAGE;
    public static final FEATURED_IMAGE PREVIEW;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/aviary/android/feather/cds/AviaryCds$ContentType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PREVIEW = new <init>("PREVIEW", 0);
        CONTENT = new <init>("CONTENT", 1);
        MESSAGE = new <init>("MESSAGE", 2);
        DETAIL_IMAGE = new <init>("DETAIL_IMAGE", 3);
        FEATURED_IMAGE = new <init>("FEATURED_IMAGE", 4);
        $VALUES = (new .VALUES[] {
            PREVIEW, CONTENT, MESSAGE, DETAIL_IMAGE, FEATURED_IMAGE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
