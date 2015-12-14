// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;


// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            DrawingPanel

private static final class  extends Enum
{

    private static final Zoom $VALUES[];
    public static final Zoom Draw;
    public static final Zoom Erase;
    public static final Zoom Zoom;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/aviary/android/feather/sdk/panels/DrawingPanel$DrawinTool, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Draw = new <init>("Draw", 0);
        Erase = new <init>("Erase", 1);
        Zoom = new <init>("Zoom", 2);
        $VALUES = (new .VALUES[] {
            Draw, Erase, Zoom
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
