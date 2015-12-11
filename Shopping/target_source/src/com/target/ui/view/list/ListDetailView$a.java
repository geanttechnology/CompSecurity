// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;


// Referenced classes of package com.target.ui.view.list:
//            ListDetailView

private static final class  extends Enum
{

    private static final FADE_OUT $VALUES[];
    public static final FADE_OUT FADE_IN;
    public static final FADE_OUT FADE_OUT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/view/list/ListDetailView$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FADE_IN = new <init>("FADE_IN", 0);
        FADE_OUT = new <init>("FADE_OUT", 1);
        $VALUES = (new .VALUES[] {
            FADE_IN, FADE_OUT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
