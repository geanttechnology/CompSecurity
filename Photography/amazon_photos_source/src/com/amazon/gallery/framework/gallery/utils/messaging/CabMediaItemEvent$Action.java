// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.utils.messaging;


// Referenced classes of package com.amazon.gallery.framework.gallery.utils.messaging:
//            CabMediaItemEvent

public static final class  extends Enum
{

    private static final REMOVE $VALUES[];
    public static final REMOVE ADD;
    public static final REMOVE REMOVE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/gallery/utils/messaging/CabMediaItemEvent$Action, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ADD = new <init>("ADD", 0);
        REMOVE = new <init>("REMOVE", 1);
        $VALUES = (new .VALUES[] {
            ADD, REMOVE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
