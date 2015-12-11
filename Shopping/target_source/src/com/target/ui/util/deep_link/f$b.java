// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.deep_link;


// Referenced classes of package com.target.ui.util.deep_link:
//            f

public static final class  extends Enum
{

    private static final NONE $VALUES[];
    public static final NONE CUSTOM_ACTION;
    public static final NONE DIALOG_FRAGMENT;
    public static final NONE FRAGMENT;
    public static final NONE NONE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/util/deep_link/f$b, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CUSTOM_ACTION = new <init>("CUSTOM_ACTION", 0);
        DIALOG_FRAGMENT = new <init>("DIALOG_FRAGMENT", 1);
        FRAGMENT = new <init>("FRAGMENT", 2);
        NONE = new <init>("NONE", 3);
        $VALUES = (new .VALUES[] {
            CUSTOM_ACTION, DIALOG_FRAGMENT, FRAGMENT, NONE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
