// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream;

import com.google.a.a.b;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.cardstream:
//            e

public class h
{

    private static com.google.a.b.h sDefaultContextCards;
    private static com.google.a.b.h sInStoreCardNames;

    public h()
    {
    }

    public b a()
    {
        return new b() {

            final h this$0;

            public volatile Object a(Object obj)
            {
                return a((g.a)obj);
            }

            public List a(g.a a1)
            {
                return h.this.a(a1);
            }

            
            {
                this$0 = h.this;
                super();
            }
        };
    }

    public List a(g.a a1)
    {
        if (a1.isInStore)
        {
            return sInStoreCardNames;
        } else
        {
            return sDefaultContextCards;
        }
    }

    static 
    {
        sInStoreCardNames = com.google.a.b.h.a(e.DEV_TEST_CARD, e.WELCOME, e.SHOW_STORE_MAP_VIEW, e.REQUEST_A_TEAM_MEMBER, e.SHOPPING_LIST_ENGAGEMENT, e.SHOPPING_LIST, e.MOBILE_COUPONS, e.WEEKLY_AD);
        sDefaultContextCards = com.google.a.b.h.a(e.DEV_TEST_CARD);
    }
}
