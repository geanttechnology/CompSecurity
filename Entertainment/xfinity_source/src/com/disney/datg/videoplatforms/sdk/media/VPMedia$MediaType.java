// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPMedia

public static final class types extends Enum
{

    private static final LIVE $VALUES[];
    public static final LIVE LIVE;
    public static final LIVE VOD;
    private String label;
    private String types;

    public static types valueOf(String s)
    {
        return (types)Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType, s);
    }

    public static types[] values()
    {
        return (types[])$VALUES.clone();
    }

    public String getTypes()
    {
        return types;
    }

    static 
    {
        VOD = new <init>("VOD", 0, "VOD", "lf,es,mp");
        LIVE = new <init>("LIVE", 1, "LIVE", "lv");
        $VALUES = (new .VALUES[] {
            VOD, LIVE
        });
    }

    private (String s, int i, String s1, String s2)
    {
        super(s, i);
        label = s1;
        types = s2;
    }
}
