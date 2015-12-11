// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPCaptionStyle

public static final class  extends Enum
{

    private static final EDGE_TYPE_DROP_SHADOW $VALUES[];
    public static final EDGE_TYPE_DROP_SHADOW EDGE_TYPE_DROP_SHADOW;
    public static final EDGE_TYPE_DROP_SHADOW EDGE_TYPE_NONE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        EDGE_TYPE_NONE = new <init>("EDGE_TYPE_NONE", 0);
        EDGE_TYPE_DROP_SHADOW = new <init>("EDGE_TYPE_DROP_SHADOW", 1);
        $VALUES = (new .VALUES[] {
            EDGE_TYPE_NONE, EDGE_TYPE_DROP_SHADOW
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
