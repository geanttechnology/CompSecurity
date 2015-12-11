// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPMedia

public static final class  extends Enum
{

    private static final EPISODE $VALUES[];
    public static final EPISODE EPISODE;
    public static final EPISODE SHOW;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SHOW = new <init>("SHOW", 0);
        EPISODE = new <init>("EPISODE", 1);
        $VALUES = (new .VALUES[] {
            SHOW, EPISODE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
