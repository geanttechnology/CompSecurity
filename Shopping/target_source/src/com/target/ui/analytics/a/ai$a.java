// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;


// Referenced classes of package com.target.ui.analytics.a:
//            ai

public static final class  extends Enum
{

    private static final Account $VALUES[];
    public static final Account Account;
    public static final Account List;
    public static final Account Main;
    public static final Account Shop;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/analytics/a/ai$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Main = new <init>("Main", 0);
        Shop = new <init>("Shop", 1);
        List = new <init>("List", 2);
        Account = new <init>("Account", 3);
        $VALUES = (new .VALUES[] {
            Main, Shop, List, Account
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
