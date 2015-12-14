// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action;


// Referenced classes of package com.amazon.gallery.framework.kindle.action:
//            ManualUploadAction

public static final class  extends Enum
{

    private static final ManualUploadClicked $VALUES[];
    public static final ManualUploadClicked ManualUploadClicked;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/kindle/action/ManualUploadAction$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ManualUploadClicked = new <init>("ManualUploadClicked", 0);
        $VALUES = (new .VALUES[] {
            ManualUploadClicked
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
