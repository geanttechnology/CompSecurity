// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.currency;


// Referenced classes of package com.ebay.common.net.api.currency:
//            CurrencyConversionDataManager

protected static final class  extends Enum
{

    private static final DONE $VALUES[];
    public static final DONE DONE;
    public static final DONE NEVER;
    public static final DONE PENDING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/common/net/api/currency/CurrencyConversionDataManager$CurrencyCacheLock$LoadState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NEVER = new <init>("NEVER", 0);
        PENDING = new <init>("PENDING", 1);
        DONE = new <init>("DONE", 2);
        $VALUES = (new .VALUES[] {
            NEVER, PENDING, DONE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
