// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ui;


// Referenced classes of package com.amazon.gallery.framework.kindle.ui:
//            NetworkIndicator

public static final class  extends Enum
{

    private static final UNRELIABLE $VALUES[];
    public static final UNRELIABLE OFFLINE;
    public static final UNRELIABLE UNRELIABLE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/kindle/ui/NetworkIndicator$Status, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        OFFLINE = new <init>("OFFLINE", 0);
        UNRELIABLE = new <init>("UNRELIABLE", 1);
        $VALUES = (new .VALUES[] {
            OFFLINE, UNRELIABLE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
