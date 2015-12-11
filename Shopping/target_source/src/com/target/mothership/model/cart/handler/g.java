// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.model.b;
import com.target.mothership.model.cart.interfaces.AppliedGiftCard;
import com.target.mothership.model.cart.interfaces.a.c;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.d;
import com.target.mothership.services.x;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTAppliedGiftCard

public class g extends b
{

    private final aa mTransformer = new aa() {

        final g this$0;

        public AppliedGiftCard a(d d2)
        {
            TGTAppliedGiftCard tgtappliedgiftcard = new TGTAppliedGiftCard();
            Object obj = d2.a();
            if (obj != null && ((List) (obj)).size() != 0)
            {
                obj = (com.target.mothership.services.apigee.c.b.d.a)((List) (obj)).get(0);
                tgtappliedgiftcard.a(((com.target.mothership.services.apigee.c.b.d.a) (obj)).a());
                tgtappliedgiftcard.b(((com.target.mothership.services.apigee.c.b.d.a) (obj)).b());
            }
            tgtappliedgiftcard.c(d2.b());
            return tgtappliedgiftcard;
        }

        public volatile Object a(Object obj)
        {
            return a((d)obj);
        }

            
            {
                this$0 = g.this;
                super();
            }
    };

    public g(com.target.mothership.model.d d1)
    {
        super(d1);
    }

    protected AppliedGiftCard a(d d1)
    {
        return (AppliedGiftCard)mTransformer.a(d1);
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((d)obj);
    }

    protected c b(x x)
    {
        return (new com.target.mothership.model.cart.a.d()).a(x);
    }
}
