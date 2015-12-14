// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;


// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            GalleryBaseAdapter

public static final class Q extends Enum
{

    private static final BANNER $VALUES[];
    public static final BANNER BANNER;
    public static final BANNER DIVIDER;
    public static final BANNER MEDIA_ITEM;

    public static Q valueOf(String s)
    {
        return (Q)Enum.valueOf(com/amazon/gallery/framework/gallery/widget/GalleryBaseAdapter$ItemViewType, s);
    }

    public static Q[] values()
    {
        return (Q[])$VALUES.clone();
    }

    static 
    {
        DIVIDER = new <init>("DIVIDER", 0);
        MEDIA_ITEM = new <init>("MEDIA_ITEM", 1);
        BANNER = new <init>("BANNER", 2);
        $VALUES = (new .VALUES[] {
            DIVIDER, MEDIA_ITEM, BANNER
        });
    }

    private Q(String s, int i)
    {
        super(s, i);
    }
}
