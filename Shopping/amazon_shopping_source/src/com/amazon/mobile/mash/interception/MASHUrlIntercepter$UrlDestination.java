// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.interception;


// Referenced classes of package com.amazon.mobile.mash.interception:
//            MASHUrlIntercepter

protected static final class  extends Enum
{

    private static final appstore $VALUES[];
    public static final appstore appstore;
    public static final appstore browse;
    public static final appstore cart;
    public static final appstore checkout;
    public static final appstore detail;
    public static final appstore home;
    public static final appstore search;

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
        $VALUES = (new .VALUES[] {
            home, search, browse, cart, detail, checkout, appstore
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
