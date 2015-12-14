// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;


// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            ImageViewVignette

static final class  extends Enum
{

    private static final Scale $VALUES[];
    public static final Scale Center;
    public static final Scale None;
    public static final Scale Scale;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/aviary/android/feather/sdk/widget/ImageViewVignette$TouchState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        None = new <init>("None", 0);
        Center = new <init>("Center", 1);
        Scale = new <init>("Scale", 2);
        $VALUES = (new .VALUES[] {
            None, Center, Scale
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
