// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.interception;


// Referenced classes of package com.amazon.mobile.mash.interception:
//            MASHUrlIntercepter

protected static final class  extends Enum
{

    private static final prime_sign_up $VALUES[];
    public static final prime_sign_up appstore;
    public static final prime_sign_up browse;
    public static final prime_sign_up cart;
    public static final prime_sign_up checkout;
    public static final prime_sign_up detail;
    public static final prime_sign_up home;
    public static final prime_sign_up order_status;
    public static final prime_sign_up prime_sign_up;
    public static final prime_sign_up search;
    public static final prime_sign_up your_account;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        home = new <init>("home", 0);
        search = new <init>("search", 1);
        browse = new <init>("browse", 2);
        cart = new <init>("cart", 3);
        detail = new <init>("detail", 4);
        checkout = new <init>("checkout", 5);
        appstore = new <init>("appstore", 6);
        order_status = new <init>("order_status", 7);
        your_account = new <init>("your_account", 8);
        prime_sign_up = new <init>("prime_sign_up", 9);
        $VALUES = (new .VALUES[] {
            home, search, browse, cart, detail, checkout, appstore, order_status, your_account, prime_sign_up
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
