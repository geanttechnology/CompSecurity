// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;


// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            PointCloud

static final class  extends Enum
{

    private static final Ellipse $VALUES[];
    public static final Ellipse Circle;
    public static final Ellipse Ellipse;
    public static final Ellipse Line;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/aviary/android/feather/sdk/widget/PointCloud$WaveType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Circle = new <init>("Circle", 0);
        Line = new <init>("Line", 1);
        Ellipse = new <init>("Ellipse", 2);
        $VALUES = (new .VALUES[] {
            Circle, Line, Ellipse
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
