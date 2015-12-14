// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.messaging;


// Referenced classes of package com.amazon.gallery.foundation.utils.messaging:
//            ActionCompleteEvent

public static final class  extends Enum
{

    private static final DELETE $VALUES[];
    public static final DELETE DELETE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/foundation/utils/messaging/ActionCompleteEvent$ActionSource, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DELETE = new <init>("DELETE", 0);
        $VALUES = (new .VALUES[] {
            DELETE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
