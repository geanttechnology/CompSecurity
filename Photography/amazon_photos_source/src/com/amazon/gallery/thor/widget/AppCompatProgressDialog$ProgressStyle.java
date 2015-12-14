// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;


// Referenced classes of package com.amazon.gallery.thor.widget:
//            AppCompatProgressDialog

public static final class  extends Enum
{

    private static final SPINNER $VALUES[];
    public static final SPINNER HORIZONTAL;
    public static final SPINNER SPINNER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/widget/AppCompatProgressDialog$ProgressStyle, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        HORIZONTAL = new <init>("HORIZONTAL", 0);
        SPINNER = new <init>("SPINNER", 1);
        $VALUES = (new .VALUES[] {
            HORIZONTAL, SPINNER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
