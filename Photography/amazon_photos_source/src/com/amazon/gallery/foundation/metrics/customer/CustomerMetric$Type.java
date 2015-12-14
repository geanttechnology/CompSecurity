// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.metrics.customer;


// Referenced classes of package com.amazon.gallery.foundation.metrics.customer:
//            CustomerMetric

public static final class  extends Enum
{

    private static final FIRST_START $VALUES[];
    public static final FIRST_START EVENT;
    public static final FIRST_START FIRST_START;
    public static final FIRST_START SESSION;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/foundation/metrics/customer/CustomerMetric$Type, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        EVENT = new <init>("EVENT", 0);
        SESSION = new <init>("SESSION", 1);
        FIRST_START = new <init>("FIRST_START", 2);
        $VALUES = (new .VALUES[] {
            EVENT, SESSION, FIRST_START
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
