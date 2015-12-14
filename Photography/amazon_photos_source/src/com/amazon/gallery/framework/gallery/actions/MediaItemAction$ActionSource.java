// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;


// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            MediaItemAction

public static final class  extends Enum
{

    private static final SINGLE_VIEW_HAB $VALUES[];
    public static final SINGLE_VIEW_HAB MULTISELECT;
    public static final SINGLE_VIEW_HAB SINGLE_VIEW_HAB;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/gallery/actions/MediaItemAction$ActionSource, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        MULTISELECT = new <init>("MULTISELECT", 0);
        SINGLE_VIEW_HAB = new <init>("SINGLE_VIEW_HAB", 1);
        $VALUES = (new .VALUES[] {
            MULTISELECT, SINGLE_VIEW_HAB
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
