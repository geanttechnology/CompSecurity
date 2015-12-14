// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;


// Referenced classes of package com.millennialmedia.internal.video:
//            VASTParser

public static final class  extends Enum
{

    private static final progress $VALUES[];
    public static final progress closeLinear;
    public static final progress complete;
    public static final progress creativeView;
    public static final progress firstQuartile;
    public static final progress midpoint;
    public static final progress progress;
    public static final progress skip;
    public static final progress start;
    public static final progress thirdQuartile;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/millennialmedia/internal/video/VASTParser$TrackableEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        creativeView = new <init>("creativeView", 0);
        start = new <init>("start", 1);
        firstQuartile = new <init>("firstQuartile", 2);
        midpoint = new <init>("midpoint", 3);
        thirdQuartile = new <init>("thirdQuartile", 4);
        complete = new <init>("complete", 5);
        closeLinear = new <init>("closeLinear", 6);
        skip = new <init>("skip", 7);
        progress = new <init>("progress", 8);
        $VALUES = (new .VALUES[] {
            creativeView, start, firstQuartile, midpoint, thirdQuartile, complete, closeLinear, skip, progress
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
