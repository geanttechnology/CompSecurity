// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;


// Referenced classes of package com.amazon.mShop.net:
//            BaseMetricsObserver

public static final class  extends Enum
{

    private static final Failed $VALUES[];
    public static final Failed Canceled;
    public static final Failed Completed;
    public static final Failed Failed;
    public static final Failed Received;
    public static final Failed Running;
    public static final Failed Unknown;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/mShop/net/BaseMetricsObserver$Status, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Unknown = new <init>("Unknown", 0);
        Running = new <init>("Running", 1);
        Received = new <init>("Received", 2);
        Completed = new <init>("Completed", 3);
        Canceled = new <init>("Canceled", 4);
        Failed = new <init>("Failed", 5);
        $VALUES = (new .VALUES[] {
            Unknown, Running, Received, Completed, Canceled, Failed
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
