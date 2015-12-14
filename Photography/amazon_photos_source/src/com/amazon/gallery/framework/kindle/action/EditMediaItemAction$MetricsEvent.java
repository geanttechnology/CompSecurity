// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action;


// Referenced classes of package com.amazon.gallery.framework.kindle.action:
//            EditMediaItemAction

public static final class Q extends Enum
{

    private static final SingleViewEditSelected $VALUES[];
    public static final SingleViewEditSelected ContextMenuEditSelected;
    public static final SingleViewEditSelected SingleViewEditSelected;

    public static Q valueOf(String s)
    {
        return (Q)Enum.valueOf(com/amazon/gallery/framework/kindle/action/EditMediaItemAction$MetricsEvent, s);
    }

    public static Q[] values()
    {
        return (Q[])$VALUES.clone();
    }

    static 
    {
        ContextMenuEditSelected = new <init>("ContextMenuEditSelected", 0);
        SingleViewEditSelected = new <init>("SingleViewEditSelected", 1);
        $VALUES = (new .VALUES[] {
            ContextMenuEditSelected, SingleViewEditSelected
        });
    }

    private Q(String s, int i)
    {
        super(s, i);
    }
}
