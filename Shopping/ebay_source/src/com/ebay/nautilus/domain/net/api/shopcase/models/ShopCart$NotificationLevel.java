// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopcase.models;


// Referenced classes of package com.ebay.nautilus.domain.net.api.shopcase.models:
//            ShopCart

public static final class Q extends Enum
{

    private static final ERROR $VALUES[];
    public static final ERROR ERROR;
    public static final ERROR INFO;
    public static final ERROR SUCCESS;
    public static final ERROR WARNING;

    public static Q valueOf(String s)
    {
        return (Q)Enum.valueOf(com/ebay/nautilus/domain/net/api/shopcase/models/ShopCart$NotificationLevel, s);
    }

    public static Q[] values()
    {
        return (Q[])$VALUES.clone();
    }

    static 
    {
        SUCCESS = new <init>("SUCCESS", 0);
        INFO = new <init>("INFO", 1);
        WARNING = new <init>("WARNING", 2);
        ERROR = new <init>("ERROR", 3);
        $VALUES = (new .VALUES[] {
            SUCCESS, INFO, WARNING, ERROR
        });
    }

    private Q(String s, int i)
    {
        super(s, i);
    }
}
