// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


// Referenced classes of package com.mopub.mobileads:
//            VastXmlManagerAggregator

static final class  extends Enum
{

    private static final PORTRAIT $VALUES[];
    public static final PORTRAIT LANDSCAPE;
    public static final PORTRAIT PORTRAIT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/mopub/mobileads/VastXmlManagerAggregator$CompanionOrientation, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LANDSCAPE = new <init>("LANDSCAPE", 0);
        PORTRAIT = new <init>("PORTRAIT", 1);
        $VALUES = (new .VALUES[] {
            LANDSCAPE, PORTRAIT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
