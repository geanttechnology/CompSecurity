// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.search;


// Referenced classes of package com.target.ui.fragment.product.search:
//            a

private static final class  extends Enum
{

    private static final NONE $VALUES[];
    public static final NONE NONE;
    public static final NONE SEARCH_BY_TEXT;
    public static final NONE SEARCH_BY_VOICE;
    public static final NONE SEARCH_CLEARED;
    public static final NONE SEARCH_EDIT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/fragment/product/search/a$c, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SEARCH_BY_VOICE = new <init>("SEARCH_BY_VOICE", 0);
        SEARCH_BY_TEXT = new <init>("SEARCH_BY_TEXT", 1);
        SEARCH_EDIT = new <init>("SEARCH_EDIT", 2);
        SEARCH_CLEARED = new <init>("SEARCH_CLEARED", 3);
        NONE = new <init>("NONE", 4);
        $VALUES = (new .VALUES[] {
            SEARCH_BY_VOICE, SEARCH_BY_TEXT, SEARCH_EDIT, SEARCH_CLEARED, NONE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
