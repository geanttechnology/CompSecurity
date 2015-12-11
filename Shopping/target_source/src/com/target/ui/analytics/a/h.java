// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import com.target.a.a.b;
import com.target.ui.analytics.b.c;
import com.target.ui.analytics.b.e;
import com.target.ui.analytics.b.f;
import com.target.ui.analytics.b.g;
import com.target.ui.analytics.b.i;
import com.target.ui.analytics.b.k;
import com.target.ui.util.j;

// Referenced classes of package com.target.ui.analytics.a:
//            b, g, k, z, 
//            ad, ae, ay, bc, 
//            bd, be

public class h
{

    private static final String LOG_TAG = com/target/ui/analytics/a/h.getSimpleName();

    public h()
    {
    }

    private void a(com.target.ui.analytics.a.b b1)
    {
        try
        {
            java.util.Map map = b1.h();
            g.a().a(b1.g(), map);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.target.ui.analytics.a.b b1)
        {
            b.a(LOG_TAG, "Critical error while trying to publish analytics event: ", b1);
        }
    }

    public void onEvent(c c)
    {
        a(new com.target.ui.analytics.a.k(c, j.b(g.a().b())));
    }

    public void onEvent(e e1)
    {
        byte byte0;
        byte byte1;
        byte1 = 3;
        byte0 = byte1;
        e1.origin;
        JVM INSTR tableswitch 1 3: default 36
    //                   1 54
    //                   2 69
    //                   3 38;
           goto _L1 _L2 _L3 _L4
_L4:
        break; /* Loop/switch isn't completed */
_L1:
        byte0 = byte1;
_L6:
        z.a(e1.product, e1.pageItemHierarchy, byte0).f();
        return;
_L2:
        z.a(e1.cartProduct, e1.quantity).f();
        return;
_L3:
        byte0 = 2;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onEvent(f f)
    {
        a(new ad(f));
    }

    public void onEvent(g g1)
    {
        ae.a(ae.a.valueOf(g1.listEventType.name()), g1.itemName, g1.numItems).f();
    }

    public void onEvent(com.target.ui.analytics.b.h h1)
    {
        ay.a(h1.report).f();
    }

    public void onEvent(i l)
    {
        bc.a(l.orderCompletionDetails, l.orderReview, l.checkoutContext, l.loadTimeMS).f();
    }

    public void onEvent(com.target.ui.analytics.b.j j1)
    {
        bd.a(j1.productDetails, j1.pageItemHierarchy, j1.loadTimeMS).f();
    }

    public void onEvent(k k1)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$analytics$events$ViewPLPEvent$SearchMethod[];

            static 
            {
                $SwitchMap$com$target$ui$analytics$events$ViewPLPEvent$SearchMethod = new int[com.target.ui.analytics.b.k.a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$analytics$events$ViewPLPEvent$SearchMethod[com.target.ui.analytics.b.k.a.Browse.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$events$ViewPLPEvent$SearchMethod[com.target.ui.analytics.b.k.a.DeepLink.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$events$ViewPLPEvent$SearchMethod[com.target.ui.analytics.b.k.a.Query.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.analytics.events.ViewPLPEvent.SearchMethod[k1.searchMethod.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            be.a(k1.productSummary, k1.productSummaryParam, k1.pageItemHierarchy, k1.loadTimeMS).f();
            return;

        case 2: // '\002'
            be.a(k1.productSummary, k1.loadTimeMS).f();
            return;

        case 3: // '\003'
            be.a(k1.productSummary, k1.productSummaryParam, k1.loadTimeMS).f();
            break;
        }
    }

}
