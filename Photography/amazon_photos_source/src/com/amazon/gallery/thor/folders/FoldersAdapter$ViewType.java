// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.folders;


// Referenced classes of package com.amazon.gallery.thor.folders:
//            FoldersAdapter

private static final class  extends Enum
{

    private static final ITEM $VALUES[];
    public static final ITEM BANNER;
    public static final ITEM ITEM;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/folders/FoldersAdapter$ViewType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        BANNER = new <init>("BANNER", 0);
        ITEM = new <init>("ITEM", 1);
        $VALUES = (new .VALUES[] {
            BANNER, ITEM
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
