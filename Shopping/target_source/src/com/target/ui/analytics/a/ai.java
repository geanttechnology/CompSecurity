// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            e, y, i, s

public class ai extends e
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a Account;
        public static final a List;
        public static final a Main;
        public static final a Shop;

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/target/ui/analytics/a/ai$a, s1);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            Main = new a("Main", 0);
            Shop = new a("Shop", 1);
            List = new a("List", 2);
            Account = new a("Account", 3);
            $VALUES = (new a[] {
                Main, Shop, List, Account
            });
        }

        private a(String s1, int j)
        {
            super(s1, j);
        }
    }


    private a mNavigation;

    private ai()
    {
    }

    private ai(a a1)
    {
        mNavigation = a1;
    }

    public static ai a(a a1)
    {
        if (a1 == null)
        {
            throw new IllegalArgumentException("Navigation cannot be null");
        } else
        {
            return new ai(a1);
        }
    }

    private y b(a a1)
    {
        if (a1 == null)
        {
            return y.Unknown;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$analytics$brighttag$TapNavigationEvent$Navigation[];

            static 
            {
                $SwitchMap$com$target$ui$analytics$brighttag$TapNavigationEvent$Navigation = new int[a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapNavigationEvent$Navigation[a.Main.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapNavigationEvent$Navigation[a.Shop.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapNavigationEvent$Navigation[com.target.ui.analytics.a.a.List.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapNavigationEvent$Navigation[a.Account.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.analytics.brighttag.TapNavigationEvent.Navigation[a1.ordinal()])
        {
        default:
            return y.Unknown;

        case 1: // '\001'
            return y.LeftNavMain;

        case 2: // '\002'
            return y.LeftNavShop;

        case 3: // '\003'
            return y.LeftNavList;

        case 4: // '\004'
            return y.LeftNavAccount;
        }
    }

    private String c(a a1)
    {
        if (a1 == null)
        {
            return "";
        }
        switch (_cls1..SwitchMap.com.target.ui.analytics.brighttag.TapNavigationEvent.Navigation[a1.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return "r0c0";

        case 2: // '\002'
            return "r1c0";

        case 3: // '\003'
            return "r2c0";

        case 4: // '\004'
            return "r3c0";
        }
    }

    protected Map b()
    {
        Map map = super.b();
        com.target.ui.analytics.a.i.a(map, "linkPosition", c(mNavigation));
        return map;
    }

    protected s c()
    {
        return s.AccountLogin;
    }

    protected List d()
    {
        return Collections.emptyList();
    }

    protected y i()
    {
        return b(mNavigation);
    }
}
