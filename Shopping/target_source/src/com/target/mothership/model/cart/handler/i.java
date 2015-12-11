// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.model.b;
import com.target.mothership.model.cart.a.f;
import com.target.mothership.model.cart.interfaces.AppliedPromoCodes;
import com.target.mothership.model.d;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.e;
import com.target.mothership.services.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTAppliedPromoCodes, TGTPromoCode

public class i extends b
{

    private final aa mTransformer = new aa() {

        final i this$0;

        public AppliedPromoCodes a(e e1)
        {
            TGTAppliedPromoCodes tgtappliedpromocodes = new TGTAppliedPromoCodes();
            tgtappliedpromocodes.a(e1.a());
            ArrayList arraylist = new ArrayList();
            TGTPromoCode tgtpromocode;
            for (e1 = e1.b().iterator(); e1.hasNext(); arraylist.add(tgtpromocode))
            {
                com.target.mothership.services.apigee.c.b.aa aa1 = (com.target.mothership.services.apigee.c.b.aa)e1.next();
                tgtpromocode = new TGTPromoCode();
                tgtpromocode.b(aa1.b());
                tgtpromocode.a(aa1.a());
            }

            tgtappliedpromocodes.a(arraylist);
            return tgtappliedpromocodes;
        }

        public volatile Object a(Object obj)
        {
            return a((e)obj);
        }

            
            {
                this$0 = i.this;
                super();
            }
    };

    public i(d d)
    {
        super(d);
    }

    protected AppliedPromoCodes a(e e1)
    {
        return (AppliedPromoCodes)mTransformer.a(e1);
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((e)obj);
    }

    protected com.target.mothership.model.cart.interfaces.a.e b(x x)
    {
        return (new f()).a(x);
    }
}
