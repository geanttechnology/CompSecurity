// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPMediaPlayer

protected static final class  extends Enum
{

    private static final UPLYNK $VALUES[];
    public static final UPLYNK NATIVE;
    public static final UPLYNK UPLYNK;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NATIVE = new <init>("NATIVE", 0);
        UPLYNK = new <init>("UPLYNK", 1);
        $VALUES = (new .VALUES[] {
            NATIVE, UPLYNK
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
