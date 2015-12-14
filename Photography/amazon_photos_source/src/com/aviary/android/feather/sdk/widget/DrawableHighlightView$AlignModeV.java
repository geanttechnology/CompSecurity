// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;


// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            DrawableHighlightView

public static final class  extends Enum
{

    private static final Center $VALUES[];
    public static final Center Bottom;
    public static final Center Center;
    public static final Center Top;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/aviary/android/feather/sdk/widget/DrawableHighlightView$AlignModeV, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Top = new <init>("Top", 0);
        Bottom = new <init>("Bottom", 1);
        Center = new <init>("Center", 2);
        $VALUES = (new .VALUES[] {
            Top, Bottom, Center
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
