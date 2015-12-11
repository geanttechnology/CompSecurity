// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;


// Referenced classes of package com.poshmark.ui.customviews:
//            CollectionSortWidget

static final class  extends Enum
{

    private static final three_button $VALUES[];
    public static final three_button three_button;
    public static final three_button two_button;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/ui/customviews/CollectionSortWidget$WIDGET_TYPE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        two_button = new <init>("two_button", 0);
        three_button = new <init>("three_button", 1);
        $VALUES = (new .VALUES[] {
            two_button, three_button
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
