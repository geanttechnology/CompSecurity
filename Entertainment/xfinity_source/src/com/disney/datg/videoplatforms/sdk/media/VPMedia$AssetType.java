// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPMedia

public static final class  extends Enum
{

    private static final UNDEFINED $VALUES[];
    public static final UNDEFINED MOV;
    public static final UNDEFINED ULNK;
    public static final UNDEFINED UNDEFINED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ULNK = new <init>("ULNK", 0);
        MOV = new <init>("MOV", 1);
        UNDEFINED = new <init>("UNDEFINED", 2);
        $VALUES = (new .VALUES[] {
            ULNK, MOV, UNDEFINED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
