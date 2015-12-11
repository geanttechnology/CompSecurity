// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.common.a.b;
import com.target.mothership.model.cart.interfaces.GiftProduct;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.ac;
import com.target.mothership.services.apigee.c.b.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTRewardOptions, ab, TGTGiftProduct

class al
    implements aa
{

    private static final int EMAIL_DELIVERY_PRIORITY = 1;
    private static final int MOBILE_DELIVERY_PRIORITY = 2;
    private static final int STANDARD_DELIVERY_PRIORITY = 3;

    al()
    {
    }

    static int a(al al1, GiftProduct giftproduct)
    {
        return al1.a(giftproduct);
    }

    private int a(GiftProduct giftproduct)
    {
        static class _cls2
        {

            static final int $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[];

            static 
            {
                $SwitchMap$com$target$mothership$common$cart$DeliveryMethod = new int[b.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Email.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Mobile.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Standard.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.target.mothership.common.cart.DeliveryMethod[giftproduct.c().ordinal()])
        {
        default:
            return 3;

        case 1: // '\001'
            return 1;

        case 2: // '\002'
            return 2;
        }
    }

    private List a(List list)
    {
        Collections.sort(list, new Comparator() {

            final al this$0;

            public int a(GiftProduct giftproduct, GiftProduct giftproduct1)
            {
                return al.a(al.this, giftproduct) - al.a(al.this, giftproduct1);
            }

            public int compare(Object obj, Object obj1)
            {
                return a((GiftProduct)obj, (GiftProduct)obj1);
            }

            
            {
                this$0 = al.this;
                super();
            }
        });
        return list;
    }

    public TGTRewardOptions a(ac ac1)
    {
        TGTRewardOptions tgtrewardoptions = new TGTRewardOptions();
        tgtrewardoptions.a(ac1.b());
        ArrayList arraylist = new ArrayList();
        if (ac1.a() != null)
        {
            ab ab1 = new ab();
            TGTGiftProduct tgtgiftproduct;
            for (Iterator iterator = ac1.a().iterator(); iterator.hasNext(); arraylist.add(tgtgiftproduct))
            {
                tgtgiftproduct = ab1.a((s)iterator.next());
                tgtgiftproduct.e(ac1.b());
            }

        }
        tgtrewardoptions.a(a(((List) (arraylist))));
        return tgtrewardoptions;
    }

    public volatile Object a(Object obj)
    {
        return a((ac)obj);
    }
}
