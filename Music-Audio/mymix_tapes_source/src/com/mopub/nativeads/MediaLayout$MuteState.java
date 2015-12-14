// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;


// Referenced classes of package com.mopub.nativeads:
//            MediaLayout

public static final class  extends Enum
{

    private static final UNMUTED $VALUES[];
    public static final UNMUTED MUTED;
    public static final UNMUTED UNMUTED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/mopub/nativeads/MediaLayout$MuteState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        MUTED = new <init>("MUTED", 0);
        UNMUTED = new <init>("UNMUTED", 1);
        $VALUES = (new .VALUES[] {
            MUTED, UNMUTED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
