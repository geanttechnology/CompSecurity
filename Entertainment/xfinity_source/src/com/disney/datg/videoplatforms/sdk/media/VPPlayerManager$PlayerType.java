// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPPlayerManager

public static final class I extends Enum
{

    private static final NATIVE $VALUES[];
    public static final NATIVE LIVE;
    public static final NATIVE NATIVE;
    public static final NATIVE VOD;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/VPPlayerManager$PlayerType, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        LIVE = new <init>("LIVE", 0);
        VOD = new <init>("VOD", 1);
        NATIVE = new <init>("NATIVE", 2);
        $VALUES = (new .VALUES[] {
            LIVE, VOD, NATIVE
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
