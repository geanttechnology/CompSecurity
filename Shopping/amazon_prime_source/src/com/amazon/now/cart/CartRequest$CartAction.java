// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.cart;


// Referenced classes of package com.amazon.now.cart:
//            CartRequest

protected static final class  extends Enum
{

    private static final GET $VALUES[];
    public static final GET ADD;
    public static final GET GET;
    public static final GET REMOVE;
    public static final GET UPDATE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/now/cart/CartRequest$CartAction, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ADD = new <init>("ADD", 0);
        REMOVE = new <init>("REMOVE", 1);
        UPDATE = new <init>("UPDATE", 2);
        GET = new <init>("GET", 3);
        $VALUES = (new .VALUES[] {
            ADD, REMOVE, UPDATE, GET
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
