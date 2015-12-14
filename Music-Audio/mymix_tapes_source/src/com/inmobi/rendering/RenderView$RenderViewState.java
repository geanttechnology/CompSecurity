// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering;


// Referenced classes of package com.inmobi.rendering:
//            RenderView

public static final class  extends Enum
{

    private static final RESIZING $VALUES[];
    public static final RESIZING DEFAULT;
    public static final RESIZING EXPANDED;
    public static final RESIZING EXPANDING;
    public static final RESIZING HIDDEN;
    public static final RESIZING LOADING;
    public static final RESIZING RESIZED;
    public static final RESIZING RESIZING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/rendering/RenderView$RenderViewState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LOADING = new <init>("LOADING", 0);
        DEFAULT = new <init>("DEFAULT", 1);
        RESIZED = new <init>("RESIZED", 2);
        EXPANDED = new <init>("EXPANDED", 3);
        EXPANDING = new <init>("EXPANDING", 4);
        HIDDEN = new <init>("HIDDEN", 5);
        RESIZING = new <init>("RESIZING", 6);
        $VALUES = (new .VALUES[] {
            LOADING, DEFAULT, RESIZED, EXPANDED, EXPANDING, HIDDEN, RESIZING
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
