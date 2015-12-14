// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;


// Referenced classes of package com.mopub.nativeads:
//            MoPubRecyclerAdapter

public static final class  extends Enum
{

    private static final KEEP_ADS_FIXED $VALUES[];
    public static final KEEP_ADS_FIXED INSERT_AT_END;
    public static final KEEP_ADS_FIXED KEEP_ADS_FIXED;
    public static final KEEP_ADS_FIXED MOVE_ALL_ADS_WITH_CONTENT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/mopub/nativeads/MoPubRecyclerAdapter$ContentChangeStrategy, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        INSERT_AT_END = new <init>("INSERT_AT_END", 0);
        MOVE_ALL_ADS_WITH_CONTENT = new <init>("MOVE_ALL_ADS_WITH_CONTENT", 1);
        KEEP_ADS_FIXED = new <init>("KEEP_ADS_FIXED", 2);
        $VALUES = (new .VALUES[] {
            INSERT_AT_END, MOVE_ALL_ADS_WITH_CONTENT, KEEP_ADS_FIXED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
