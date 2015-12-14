// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;


// Referenced classes of package com.millennialmedia:
//            NativeAd

public static final class  extends Enum
{

    private static final DISCLAIMER $VALUES[];
    public static final DISCLAIMER BODY;
    public static final DISCLAIMER CALL_TO_ACTION;
    public static final DISCLAIMER DISCLAIMER;
    public static final DISCLAIMER ICON_IMAGE;
    public static final DISCLAIMER MAIN_IMAGE;
    public static final DISCLAIMER RATING;
    public static final DISCLAIMER TITLE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/millennialmedia/NativeAd$ComponentName, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TITLE = new <init>("TITLE", 0);
        BODY = new <init>("BODY", 1);
        ICON_IMAGE = new <init>("ICON_IMAGE", 2);
        MAIN_IMAGE = new <init>("MAIN_IMAGE", 3);
        CALL_TO_ACTION = new <init>("CALL_TO_ACTION", 4);
        RATING = new <init>("RATING", 5);
        DISCLAIMER = new <init>("DISCLAIMER", 6);
        $VALUES = (new .VALUES[] {
            TITLE, BODY, ICON_IMAGE, MAIN_IMAGE, CALL_TO_ACTION, RATING, DISCLAIMER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
