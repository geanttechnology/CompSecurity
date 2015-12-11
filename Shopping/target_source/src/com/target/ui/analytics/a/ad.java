// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import com.target.ui.analytics.b.f;
import com.target.ui.fragment.cardstream.e;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            e, i, s, y

class ad extends com.target.ui.analytics.a.e
{

    private static final String KEY_LINK_POSITION = "linkPosition";
    private static final String KEY_TAP_ACTION_NAME = "tapActionName";
    private final f mEvent;

    ad(f f1)
    {
        mEvent = f1;
    }

    private String a(int j, int k)
    {
        return String.format("r%dc%d", new Object[] {
            Integer.valueOf(j), Integer.valueOf(k)
        });
    }

    private String a(e e1)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$fragment$cardstream$CardName[];

            static 
            {
                $SwitchMap$com$target$ui$fragment$cardstream$CardName = new int[e.values().length];
                try
                {
                    $SwitchMap$com$target$ui$fragment$cardstream$CardName[e.SHOW_STORE_MAP_VIEW.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$ui$fragment$cardstream$CardName[e.SHOPPING_LIST_ENGAGEMENT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$ui$fragment$cardstream$CardName[e.SHOPPING_LIST.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$ui$fragment$cardstream$CardName[e.REQUEST_A_TEAM_MEMBER.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$ui$fragment$cardstream$CardName[e.MOBILE_COUPONS.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$ui$fragment$cardstream$CardName[e.WEEKLY_AD.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$fragment$cardstream$CardName[e.DEV_TEST_CARD.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$fragment$cardstream$CardName[e.WELCOME.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.fragment.cardstream.CardName[e1.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return "store map";

        case 2: // '\002'
            return "shopping list engagement";

        case 3: // '\003'
            return "shopping list";

        case 4: // '\004'
            return "request team member";

        case 5: // '\005'
            return "mobile coupons";

        case 6: // '\006'
            return "weekly ad";
        }
    }

    protected Map b()
    {
        Map map = super.b();
        com.target.ui.analytics.a.i.a(map, "linkPosition", a(mEvent.cardRow, mEvent.cardColumn));
        com.target.ui.analytics.a.i.a(map, "tapActionName", a(mEvent.tappedCard));
        return map;
    }

    protected s c()
    {
        return s.InStoreCards;
    }

    protected List d()
    {
        return Collections.emptyList();
    }

    protected y i()
    {
        return y.InStoreCard;
    }
}
