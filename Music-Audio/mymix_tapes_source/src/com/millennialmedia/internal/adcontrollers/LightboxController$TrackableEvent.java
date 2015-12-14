// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adcontrollers;


// Referenced classes of package com.millennialmedia.internal.adcontrollers:
//            LightboxController

public static final class  extends Enum
{

    private static final videoClose $VALUES[];
    public static final videoClose complete;
    public static final videoClose firstQuartile;
    public static final videoClose loaded;
    public static final videoClose midpoint;
    public static final videoClose start;
    public static final videoClose thirdQuartile;
    public static final videoClose videoClose;
    public static final videoClose videoCollapse;
    public static final videoClose videoExpand;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/millennialmedia/internal/adcontrollers/LightboxController$TrackableEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        loaded = new <init>("loaded", 0);
        start = new <init>("start", 1);
        firstQuartile = new <init>("firstQuartile", 2);
        midpoint = new <init>("midpoint", 3);
        thirdQuartile = new <init>("thirdQuartile", 4);
        complete = new <init>("complete", 5);
        videoExpand = new <init>("videoExpand", 6);
        videoCollapse = new <init>("videoCollapse", 7);
        videoClose = new <init>("videoClose", 8);
        $VALUES = (new .VALUES[] {
            loaded, start, firstQuartile, midpoint, thirdQuartile, complete, videoExpand, videoCollapse, videoClose
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
